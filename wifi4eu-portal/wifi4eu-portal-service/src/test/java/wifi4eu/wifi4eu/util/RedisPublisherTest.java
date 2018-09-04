package wifi4eu.wifi4eu.util;

import org.junit.Test;
import org.junit.runner.RunWith;

//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class RedisPublisherTest {
	
	public RedisPublisherTest() {
		System.out.println("CONTRUCTOR");
	}
	
	public static void main(String[] args) {
		System.out.println("PRUEBA");
		RedisPublisher redisPublisher = new RedisPublisher();
		RedisPublisherMessage message = new RedisPublisherMessage();
		message.setCsrfToken("TOKEN_FRANKLIN");
		redisPublisher.publish(message);
		
		try {
			redisPublisher.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Autowired
	//RedisPublisher redisPublisher;

//    @Before
    public void setUp() {
    	
        //Mockito.when(this.localEntityRepository.findAll()).thenReturn(localEntities);
    }
    
    /**
     * This is the simplest case. There must not be any errors.
     * 
     */
	@Test
    public void testCase1() throws Exception {
    	RedisPublisherMessage message = new RedisPublisherMessage();
    	message.setCsrfToken("TEST-TOKEN");
    	//this.redisPublisher.publish(message);
        
        
    }
	
}
