package wifi4eu.wifi4eu.util;

import java.io.Closeable;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.sync.RedisPubSubCommands;

@Service
public class RedisPublisher implements Closeable {
	
	private final Logger LOGGER = LogManager.getLogger(RedisPublisher.class);
	
    @Value("${redis.pubsub.uri}")
	private String redisUri;
    
    @Value("${redis.pubsub.refreshgo.channel}")
	private String redisPubsubChannel;
	
	private StatefulRedisPubSubConnection<String, String> connection;
	private RedisPubSubCommands<String, String> sync;
	
	public RedisPublisher() {
	}
	
	public void connect() {
		this.LOGGER.info("Connecting to redis server [{}]", this.redisUri);
		
		RedisClient redisClient = RedisClient.create(redisUri);
		
		this.LOGGER.info("redisClient [{}]", redisClient == null ? "NULL" : redisClient.toString());
		
		this.connection = redisClient.connectPubSub();
		this.sync = this.connection.sync();
		
		this.LOGGER.info("this.sync [{}]", this.sync == null ? "NULL" : this.sync.toString());
	}
	
	public boolean publish(RedisPublisherMessage message) {
		this.LOGGER.info("publishing on channel[{}], token[{}], userId [{}], municipalityId [{}]", this.redisPubsubChannel, message.getCsrfToken(), message.getUserId(), message.getMunicipalityId());
		boolean result = false;
		
		String stringMessage;
		try {
			stringMessage = new ObjectMapper().writeValueAsString(message);
			this.LOGGER.info("message size[{}]", stringMessage == null, "NULL" ,String.valueOf(stringMessage.length()));

			this.sync.publish(this.redisPubsubChannel, stringMessage);
			result = true;
			
		} catch (Exception e) {
			this.LOGGER.error("ERROR PUBLISHING A MESSAGE", e);
			
		}
		
		this.LOGGER.info("publishing result [{}]", result);

		return result;
	}

	@Override
	public void close() throws IOException {
		this.connection.close();
	}
}
