package wifi4eu.wifi4eu.apply;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.RedisURI.Builder;
import io.lettuce.core.StreamMessage;
import io.lettuce.core.XReadArgs.StreamOffset;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStreamCommands;


/* 
	REDIS CONFIGURATION

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

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueConsumer.class);

    private String lastReadMessageId;

    private RedisClient redis = null;
    private StatefulRedisConnection<String, String> connection = null;
    private RedisStreamCommands<String, String> streamCommands = null;

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

        LOGGER.info("# Initializating QueueConsumer...");
        LOGGER.info("cfgQueueName:" + cfgQueueName);
        LOGGER.info("cfgGroupName:" + cfgGroupName);
        LOGGER.info("cfgConsumerId:" + cfgConsumerId);
        LOGGER.info("cfgReadTimeout:" + cfgReadTimeout);
        LOGGER.info("cfgBatchSize:" + cfgBatchSize);

        if (redis == null) {
            connect();
        }
    }

    //-- Using a pool of sentinels
    private synchronized void connect() {
        LOGGER.info("# Connecting to redis sentinel...");

        Integer sentinelPort = Integer.valueOf(Config.getEnvironment("wifi4eu.queue.sentinel.port"));
        String cfgRedisUri = Config.getEnvironment("wifi4eu.queue.uri");
        LOGGER.info("Recovered sentinels: {} - setting connection on port {}", cfgRedisUri, sentinelPort);
        
        Builder redisUriBuilder = RedisURI.builder();
        boolean isMasterSet = false;
        String[] redisSentinels = cfgRedisUri.split(",");        
        for (String redisSentinel : redisSentinels) {
        	if (!isMasterSet) {
        		redisUriBuilder = redisUriBuilder.sentinel(redisSentinel, sentinelPort, "master1");
        		isMasterSet = true;
        		LOGGER.info("Added sentinel {} as master", redisSentinel);
        	} else {
        		redisUriBuilder = redisUriBuilder.withSentinel(redisSentinel, sentinelPort);
        		LOGGER.info("Added sentinel {}", redisSentinel);
        	}
		}
        
        RedisURI redisUri = redisUriBuilder.build();
        redis = RedisClient.create(redisUri);
        redis.setDefaultTimeout(Duration.ofMillis(cfgReadTimeout));
        connection = redis.connect();
        streamCommands = connection.sync();

        LOGGER.info("Connected to sentinel");
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

    private List<StreamMessage<String, String>> readQueue(String fromMessageId) {
        LOGGER.debug("[I] readQueueSince");

        List<StreamMessage<String, String>> messages = streamCommands.<StreamMessage<String, String>>xread(StreamOffset.from(cfgQueueName, fromMessageId));

        if (messages != null && !messages.isEmpty()) {
            LOGGER.info("READ {} items from {}", messages.size(), cfgQueueName);
        } else {
            LOGGER.info("No new messages found.");
        }

        LOGGER.debug("[F] readQueueSince");
        return messages;
    }

    private Application getApplication(StreamMessage<String, String> msg) {

        Application app = new Application(msg.getId(), msg.getBody().get("r"),
                msg.getBody().get("u"), msg.getBody().get("m"), msg.getBody().get("ip"),
                msg.getBody().get("time"));

        LOGGER.info("QUEUE ENTRY: <{}> r={} u={} m={} ip={}", app.redis_id, app.r, app.u, app.m, app.ip, app.data);

        return app;
    }


    @Override
    public void run() {

        try {
            LOGGER.info("-- Initializing DB");
            LocalDB db = new LocalDB();
            LOGGER.info("-- DB Initialized");

            while (true) {
                LOGGER.info("Checking for new messagess since: {}", lastReadMessageId);
                List<StreamMessage<String, String>> messages = readQueue(lastReadMessageId);
                for (StreamMessage<String, String> msg : messages) {
                	if (!processMessage(db, msg)) {
                		continue;
                	}
                }

                Thread.sleep(30000);
            }
        } catch (Exception ex) {
            LOGGER.error("Error reading from queue", ex);
            redis.shutdown();
            // TODO UNCAUGHT EXCEPTION IN MAIN LOOP
        }
    }
    
    private boolean processMessage(LocalDB db, StreamMessage<String, String> msg) {
        boolean ok = false;

        LOGGER.info("Processing new message...");
        
        try {
            Monitor.addReceived();
            Application app = getApplication(msg);
            db.saveMessage(app);
            lastReadMessageId = msg.getId(); //-- Incremental reads to redis
            ok = true;
        } catch (Exception ex) {
            LOGGER.warn("Error processing entry {}: {}", msg.getId(), ex.getMessage());
        } finally {
            if (ok == true && msg != null) {
                LOGGER.info("Entry {} saved and acknowledged", msg.getId());
                Monitor.addProcessed();
            }
        }
        
        return ok;
    }

}
