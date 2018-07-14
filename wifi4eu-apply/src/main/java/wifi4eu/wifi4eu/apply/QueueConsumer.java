package wifi4eu.wifi4eu.apply;

import io.lettuce.core.Consumer;
import io.lettuce.core.RedisClient;
import io.lettuce.core.StreamMessage;
import io.lettuce.core.XReadArgs;
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

        cfgQueueName = Config.getEnvironment("wifi4eu.queue.name");
        cfgGroupName = Config.getEnvironment("wifi4eu.queue.cgroup");
        cfgConsumerId = Config.getEnvironment("wifi4eu.queue.consumerid");

        cfgReadTimeout = Long.valueOf(Config.getEnvironment("wifi4eu.queue.readinterval"), 10);
        cfgBatchSize   = Long.valueOf(Config.getEnvironment("wifi4eu.queue.batchsize"), 10);

        if (redis == null) {
            connect();
        }
    }

    private synchronized void connect() throws IOException {

        String cfgRedisUri = Config.getEnvironment("wifi4eu.queue.uri");

        logger.info("Connecting to redis at " + cfgRedisUri);

        redis = RedisClient.create(cfgRedisUri);

        redis.setDefaultTimeout(Duration.ofMillis(cfgReadTimeout));

        connection = redis.connect();
        streamCommands = connection.sync();
    }


    private List<StreamMessage<String, String>> readQueue() throws Exception {

        //streamCommands.xgroupCreate(cfgQueueName, cfgGroupName, "$");
        //System.out.println("LAST CONSUMED: " + XReadArgs.StreamOffset.lastConsumed(cfgQueueName));

        // List<StreamMessage<String, String>> messages = streamCommands.xreadgroup(
        //         Consumer.from(cfgGroupName, cfgConsumerId), XReadArgs.StreamOffset.from(cfgQueueName, "0")/*XReadArgs.StreamOffset.lastConsumed(cfgQueueName)*/);

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
    }

    private Application getApplication(StreamMessage<String, String> msg) {

        Application app = new Application(msg.getId(), msg.getBody().get("r"),
                msg.getBody().get("u"), msg.getBody().get("m"), msg.getBody().get("ip"),
                msg.getBody().get("ecas"), null);

        logger.info("QUEUE ENTRY: <{}> r={} u={} m={} ip={}", app.id, app.r, app.u, app.m, app.ip, app.ecas);

        return app;
    }


    @Override
    public void run() {

        try {

            LocalDB db = new LocalDB();

            while (true) {

                List<StreamMessage<String, String>> messages = readQueue();

                for (StreamMessage<String, String> msg : messages) {

                    boolean ok = false;

                    try {

                        Application app = getApplication(msg);

                        // TODO: validate entry and store in DB

                        db.saveMessage(app);

                        Monitor.addReceived();

                        ok = true;

                    } catch (Exception ex) {

                        logger.warn("Error processing entry {}: {}", msg.getId(), ex.getMessage());

                        ok = false;

                        continue;

                    } finally {

                        if (ok == true && msg != null) {

                            streamCommands.xack(cfgQueueName, cfgGroupName, msg.getId());
                            logger.info("Entry {} saved and acknowledged", msg.getId());

                            Monitor.addProcessed();
                        }
                    }
                }
            }
        } catch (Exception ex) {

            logger.error("Error reading from queue", ex);

            // TODO UNCAUGHT EXCEPTION IN MAIN LOOP
        }
    }

}
