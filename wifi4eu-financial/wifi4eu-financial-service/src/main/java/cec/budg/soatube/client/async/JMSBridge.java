package cec.budg.soatube.client.async;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

/**
 * Message-Driven Bean implementation class for: JMSBridge
 *
 */
@MessageDriven(name="JMSBridge")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@RunAs ("SOATubeRole")
public class JMSBridge implements MessageListener {
	
	private static Logger LOGGER = Logger.getLogger("budg.soa.logging");

	@Resource(name="jms/localQCF")
	QueueConnectionFactory queueConnectionFactory;
	@Resource(name="jms/BudgSoaLocalQueue")
	javax.jms.Queue        queue;

	QueueConnection    queueConnection = null;

    @PostConstruct
    private void initJMS() {
        try {
        	queueConnection = queueConnectionFactory.createQueueConnection();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    private void closeJMS() {
        try {
        	queueConnection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
	
    public void onMessage(Message message) {
    	QueueSender       queueSender = null;
    	QueueSession queueSession = null;
    	try {
    		queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    		queueSender = queueSession.createSender(queue);
    		queueSender.setTimeToLive(60000);
    		queueSender.send(message);

    	} catch (JMSException e) {
    		LOGGER.error("Error while dequeing message",e);
    	}
    	finally {
    	try {
    		if (queueSession != null) queueSession.close();
		} catch (Exception e2) {}	
    	}
    }

}
