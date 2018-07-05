package wifi4eu.jagate.jms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;


@Component
public class JagateMessageListener {

	private static final Logger logger = LoggerFactory.getLogger(JagateMessageListener.class);

	//@JmsListener(containerFactory = "esContainerFactory", destination = "jagate/jms/topic")
	@JmsListener(containerFactory = "esContainerFactory", destination = "pdmv5/ES/ReceptionQueue")
	public void onMessage(final Message<String> message) throws JMSException {
		logger.info("PDM JMS message received!");

		System.out.println(message);
	}

}
