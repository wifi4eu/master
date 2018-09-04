package wifi4eu.wifi4eu.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.reactive.RedisPubSubReactiveCommands;

public class RedisSubscriber {
	
	private static final Logger LOGGER = LogManager.getLogger(RedisSubscriber.class);
	
	private static String redisUri;
    
	private static String redisPubsubChannel;
	
	private static StatefulRedisPubSubConnection<String, String> connection;
//	private static RedisPubSubCommands<String, String> sync;
	
	public static void register() {
		
		LOGGER.info("REGISTERING SUBSCRIBER redisUri[{}], redisPubsubChannel[{}]", redisUri, redisPubsubChannel);

		RedisClient redisClient = RedisClient.create(redisUri);
		
		connection = redisClient.connectPubSub();
		//sync = connection.sync();
		
		RedisPubSubReactiveCommands<String, String> reactive = connection.reactive();
		reactive.subscribe(redisPubsubChannel).subscribe();

		reactive.observeChannels().doOnNext(patternMessage -> {
			String message = patternMessage.getMessage();
			
			LOGGER.info("message length[{}]", message == null ? "NULL" : String.valueOf(message.length()));
			
		}).subscribe();

	}

    @Value("${redis.pubsub.uri}")
	public void setRedisUri(String redisUri) {
		RedisSubscriber.redisUri = redisUri;
	}

    @Value("${redis.pubsub.refreshgo.channel}")
	private void setredisPubsubChannel(String redisPubsubChannel) {
		RedisSubscriber.redisPubsubChannel = redisPubsubChannel;
	}

}