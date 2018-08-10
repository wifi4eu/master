package wifi4eu.wifi4eu.apply;

import io.lettuce.core.Consumer;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.StreamMessage;
import io.lettuce.core.XReadArgs;
import io.lettuce.core.XReadArgs.*;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStreamCommands;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/* REDIS CONFIGURATION

    https://redis.io/topics/streams-intro

    1. If stream does not exist, it must be created with fields r, u, m, ip, ecas, data
    XADD ${wifi4eu.queue.name} * r 1000 u 500 m 299 ip 10.0.0.1

    2. Create group
    XGROUP CREATE ${wifi4eu.queue.name} ${wifi4eu.queue.cgroup} 0 --> Create consumer group (from beginning)
                                                                $ -> latest unread

    3. We must identify ourselves as a CONSUMER.
        XXX IMPORTANT for every node, the consumer ID must be different.
        Consumer ID is in application.properties (wifi4eu.queue.consumerid)


    4. Read from groups:
    XREADGROUP GROUP ${wifi4eu.queue.cgroup} {consumerId} STREAMS ${wifi4eu.queue.name} 0 --> Get EVERYTHING
    XREADGROUP GROUP ${wifi4eu.queue.cgroup} {consumerId} STREAMS ${wifi4eu.queue.name} > --> Get UNPROCESSED

    Messages need to be ACK'd and then they are no longer read

 */

public class QueueConsumer implements Runnable {

    private String lastReadMessageId;

    private RedisClient redis = null;
    private StatefulRedisConnection<String, String> connection = null;
    private RedisStreamCommands<String, String> streamCommands = null;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String cfgQueueName;
    private String cfgGroupName;
    private String cfgConsumerId;

    private long    cfgReadTimeout = 5000;
    private long    cfgBatchSize   = 300;


    public QueueConsumer()  throws IOException {

        lastReadMessageId = "0";

        cfgQueueName = Config.getEnvironment("wifi4eu.queue.name");
        cfgGroupName = Config.getEnvironment("wifi4eu.queue.cgroup");
        cfgConsumerId = Config.getEnvironment("wifi4eu.queue.consumerid");

        cfgReadTimeout = Long.valueOf(Config.getEnvironment("wifi4eu.queue.readinterval"), 10);
        cfgBatchSize   = Long.valueOf(Config.getEnvironment("wifi4eu.queue.batchsize"), 10);

        logger.info("cfgQueueName:" + cfgQueueName);
        logger.info("cfgGroupName:" + cfgGroupName);
        logger.info("cfgConsumerId:" + cfgConsumerId);

        logger.info("cfgReadTimeout:" + cfgReadTimeout);
        logger.info("cfgBatchSize:" + cfgBatchSize);

        if (redis == null) {
            connect();
        }
    }

    /*private synchronized void connect() throws IOException {

        String cfgRedisUri = Config.getEnvironment("wifi4eu.queue.uri");

        logger.info("Connecting to redis at :" + cfgRedisUri);

        //redis = RedisClient.create(cfgRedisUri);
        redis = RedisClient.create(RedisURI.create(cfgRedisUri, 9000));
        redis.setDefaultTimeout(Duration.ofMillis(cfgReadTimeout));

        connection = redis.connect();
        streamCommands = connection.sync();

        logger.info("Connected: " + cfgRedisUri);
    }*/

    //-- Using a pool of sentinels
    private synchronized void connect() throws IOException {
        logger.info("Connecting to redis sentinel");

        String sentinelUri1 = Config.getEnvironment("wifi4eu.queue.uri.1");
        String sentinelUri2 = Config.getEnvironment("wifi4eu.queue.uri.2");
        String sentinelUri3 = Config.getEnvironment("wifi4eu.queue.uri.3");

        Integer sentinelPort = Integer.valueOf(Config.getEnvironment("wifi4eu.queue.sentinel.port"));

        RedisURI redisUri = RedisURI.Builder.sentinel(sentinelUri1, sentinelPort, "master1")
                .withSentinel(sentinelUri2, sentinelPort)
                .withSentinel(sentinelUri3, sentinelPort)
                .build();

        redis = RedisClient.create(redisUri);
        redis.setDefaultTimeout(Duration.ofMillis(cfgReadTimeout));

        connection = redis.connect();
        streamCommands = connection.sync();

        logger.info("Connected to sentinel");
    }

    /*
    private List<StreamMessage<String, String>> readQueue() throws Exception {

        //streamCommands.xgroupCreate(cfgQueueName, cfgGroupName, "$");
        //System.out.println("LAST CONSUMED: " + XReadArgs.StreamOffset.lastConsumed(cfgQueueName));

        // List<StreamMessage<String, String>> messages = streamCommands.xreadgroup(
        //         Consumer.from(cfgGroupName, cfgConsumerId), XReadArgs.StreamOffset.from(cfgQueueName, "0")/*XReadArgs.StreamOffset.lastConsumed(cfgQueueName));*/
/*
        logger.info("Attempting queue read (stream={}, group={}, consumer={}", cfgQueueName, cfgGroupName, cfgConsumerId);

        List<StreamMessage<String, String>> messages = streamCommands.xreadgroup(
                Consumer.from(cfgGroupName, cfgConsumerId),
                XReadArgs.Builder.noack().block(cfgReadTimeout).count(cfgBatchSize),
                //XReadArgs.StreamOffset.from(cfgQueueName, "0"));
                XReadArgs.StreamOffset.lastConsumed(cfgQueueName));

        if (messages.size() > 0) {
            logger.info("READ " + messages.size() + " items from " + cfgQueueName);
        }

        return messages;
    }*/

    private List<StreamMessage<String, String>> readQueue(String fromMessageId) throws Exception {
        logger.debug("[I] readQueueSince");

        List<StreamMessage<String, String>> messages = streamCommands.<StreamMessage<String, String>>xread(StreamOffset.from(cfgQueueName, fromMessageId));

        if (messages.size() > 0) {
            logger.info("READ " + messages.size() + " items from " + cfgQueueName);
        } else {
            logger.info("No new messages found.");
        }

        logger.debug("[F] readQueueSince");
        return messages;
    }

    private Application getApplication(StreamMessage<String, String> msg) {

        Application app = new Application(msg.getId(), msg.getBody().get("r"),
                msg.getBody().get("u"), msg.getBody().get("m"), msg.getBody().get("ip"),
                msg.getBody().get("time"));

        logger.info("QUEUE ENTRY: <{}> r={} u={} m={} ip={}", app.redis_id, app.r, app.u, app.m, app.ip, app.data);

        return app;
    }


    @Override
    public void run() {

        try {

            logger.info("-- Initializing DB");
            LocalDB db = new LocalDB();
            logger.info("-- DB Initialized");

            while (true) {

                logger.info("Checking for new messagess since: " + lastReadMessageId);

                List<StreamMessage<String, String>> messages = readQueue(lastReadMessageId);

                for (StreamMessage<String, String> msg : messages) {

                    boolean ok = false;

                    try {

                        Monitor.addReceived();

                        Application app = getApplication(msg);

                        db.saveMessage(app);

                        lastReadMessageId = msg.getId(); //-- Incremental reads to redis

                        ok = true;
                    } catch (Exception ex) {

                        logger.warn("Error processing entry {}: {}", msg.getId(), ex.getMessage());

                        ok = false;

                        continue;

                    } finally {

                        if (ok == true && msg != null) {

                            //streamCommands.xack(cfgQueueName, cfgGroupName, msg.getId());
                            logger.info("Entry {} saved and acknowledged", msg.getId());

                            Monitor.addProcessed();
                        }
                    }
                }

                Thread.sleep(30000);
            }
        } catch (Exception ex) {

            logger.error("Error reading from queue", ex);
            redis.shutdown();

            // TODO UNCAUGHT EXCEPTION IN MAIN LOOP
        }
    }

}
