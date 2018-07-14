package wifi4eu.wifi4eu.apply;

import io.lettuce.core.Consumer;
import io.lettuce.core.RedisClient;
import io.lettuce.core.StreamMessage;
import io.lettuce.core.XReadArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStreamCommands;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LoggingSystem;


/* REDIS CONFIGURATION

    https://redis.io/topics/streams-intro


    XADD ${wifi4eu.queue.name} * r 1000 u 500 m 299 ip 10.0.0.1

    XGROUP CREATE ${wifi4eu.queue.name} ${wifi4eu.queue.cgroup} 0 --> Create consumer group (from beginning)
                                                                $ -> latest unread



    XREADGROUP GROUP ${wifi4eu.queue.cgroup} {consumerId} STREAMS ${wifi4eu.queue.name} 0 --> Get EVERYTHING
    XREADGROUP GROUP ${wifi4eu.queue.cgroup} {consumerId} STREAMS ${wifi4eu.queue.name} > --> Get UNPROCESSED

    Messages need to be ACK'd and then they are no longer read

 */

public class QueueConnection {


    private String cfgQueueName;
    private String cfgGroupName;
    private String cfgConsumerId;

    private static RedisClient redis = null;
    private static StatefulRedisConnection<String, String> connection = null;
    private static RedisStreamCommands<String, String> streamCommands = null;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public QueueConnection()  throws IOException {

        cfgQueueName = Config.getEnvironment("wifi4eu.queue.name");
        cfgGroupName = Config.getEnvironment("wifi4eu.queue.cgroup");
        cfgConsumerId = Config.getEnvironment("wifi4eu.queue.consumerid");

        if (redis == null) {
            connect();
        }
    }

    private synchronized void connect() throws IOException {

        String cfgRedisUri = Config.getEnvironment("wifi4eu.queue.uri");

        logger.info("Connecting to redis at " + cfgRedisUri);

        redis = RedisClient.create(cfgRedisUri);
        connection = redis.connect();
        streamCommands = connection.sync();
    }

    public static RedisStreamCommands<String,String> getStreamCommands() {
        return streamCommands;
    }


    // ADD ITEM TO QUEUE
    public void add(Map<String,String> values) {


        streamCommands.xadd(cfgQueueName, values);
    }


    public void consume() throws Exception {

       LocalDB db = new LocalDB();

        //streamCommands.xgroupCreate(cfgQueueName, cfgGroupName, "$");
        //System.out.println("LAST CONSUMED: " + XReadArgs.StreamOffset.lastConsumed(cfgQueueName));

       // List<StreamMessage<String, String>> messages = streamCommands.xreadgroup(
       //         Consumer.from(cfgGroupName, cfgConsumerId), XReadArgs.StreamOffset.from(cfgQueueName, "0")/*XReadArgs.StreamOffset.lastConsumed(cfgQueueName)*/);

        logger.info("Attempting queue read (stream={}, group={}, consumer={}", cfgQueueName, cfgGroupName, cfgConsumerId);

        List<StreamMessage<String, String>> messages = streamCommands.xreadgroup(
                    Consumer.from(cfgGroupName, cfgConsumerId),
                    XReadArgs.Builder.noack(),
                    //XReadArgs.StreamOffset.from(cfgQueueName, "0"));
                    XReadArgs.StreamOffset.lastConsumed(cfgQueueName));


        logger.info("READ " + messages.size() + " items from " + cfgQueueName);

        for (StreamMessage<String,String> msg : messages) {

            boolean ok = false;


                try {
                    Application app = new Application(msg.getId(), msg.getBody().get("r"),
                            msg.getBody().get("u"), msg.getBody().get("m"), msg.getBody().get("ip"), msg.getBody().get("ecas"), null);

                    logger.info("QUEUE ENTRY: <{}> r={} u={} m={} ip={}", app.id, app.r, app.u, app.m, app.ip, app.ecas);

                    // TODO: validate entry and store in DB

                    db.saveMessage(app);

                    ok = true;

                } catch (Exception ex) {

                    logger.warn("Error processing entry {}: {}", msg.getId(), ex.getMessage());

                    ok = false;

                } finally {

                    if (ok == true && msg != null) {

                        streamCommands.xack(cfgQueueName, cfgGroupName, msg.getId());
                        logger.info("Entry {} saved and acknowledged", msg.getId());
                    }
                }

        }
    }

}
