package cec.budg.soatube.client.async;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import cec.budg.soatube.client.util.BudgSOAException;
import eu.europa.ec.budg.abac.message.v1.MessageFaultType.MessageFaultDetail.Program;
import eu.europa.ec.budg.abac.message.v1.MessageHeaderType;
import eu.europa.ec.budg.abac.soatube.v1.ObjectFactory;
import eu.europa.ec.budg.abac.soatube.v1.SoatubeRequestType;
import eu.europa.ec.budg.abac.soatube.v1.SoatubeResponseType;
import org.slf4j.LoggerFactory;
import wifi4eu.wifi4eu.service.exportImport.ExportImportFinancialAbacService;

@Stateless(name="JmsProducer")
public class JmsProducer implements JmsProducerLocal {

	private static Logger LOGGER = Logger.getLogger("budg.soa.logging");

	@Resource(name="jms/localQCF")
	private QueueConnectionFactory queueConnectionFactory;
	@Resource(name="jms/SendingQueue")
	private Queue sendingQueue;
	@Resource(name="jms/ReceivingQueue")
	private Queue receivingQueue;
	private JAXBContext soaTubeRequestContext;
	private JAXBContext soaTubeResponseContext;
	private final org.slf4j.Logger _log = LoggerFactory.getLogger(ExportImportFinancialAbacService.class);

	@PostConstruct
	private void init () throws RuntimeException {
		try {
			soaTubeRequestContext = JAXBContext.newInstance(SoatubeRequestType.class);
			soaTubeResponseContext = JAXBContext.newInstance(SoatubeResponseType.class.getPackage().getName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public HashMap<String, String> sendMessage(String messageCorID) throws BudgSOAException {
		LOGGER.trace("Preparing to send message with message correlation="+messageCorID);

		_log.info("sendMessage");

		HashMap<String, String> retHashMap = new HashMap<String, String>();
		QueueSender queueSender = null;
		QueueConnection     queueConnection = null;
		QueueSession      queueSession = null;
		QueueReceiver queueReceiver = null;

		TextMessage message = null;
		String jmsMessageCorrelation=null;
		String receivedText=null;
		String soaTubeRequestXmlString=null;
		String jmsMessageIdentifier=null;

		//create the request
		SoatubeRequestType soaTubeRequestType = createRequest(messageCorID);
		retHashMap.put("MSG_COR_ID", messageCorID);

		try {
			soaTubeRequestXmlString = convertRequestToXmlString(soaTubeRequestType);
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			queueSender = queueSession.createSender(sendingQueue);
			message = queueSession.createTextMessage();
			message.setText(soaTubeRequestXmlString);
			queueSender.send(message);
			jmsMessageIdentifier = message.getJMSMessageID();
			retHashMap.put("JMSMessageID", jmsMessageIdentifier);
			queueReceiver = queueSession.createReceiver(receivingQueue, "JMSCorrelationID='"+jmsMessageIdentifier+"'");
			queueConnection.start();
			Message receive = queueReceiver.receive(50000);
			if (receive == null) throw new BudgSOAException("Synchronous JMS receive timeout");
			receivedText = ((TextMessage)receive).getText();
			jmsMessageCorrelation=receive.getJMSCorrelationID();
			retHashMap.put("JMSCorID", jmsMessageCorrelation);

			JAXBElement<SoatubeResponseType> soaTubeResponse;
			soaTubeResponse = createResponse(receivedText);
			if(soaTubeResponse==null){
				throw new BudgSOAException("Response message was empty");
			}

			if(soaTubeResponse!=null && soaTubeResponse.getValue()!=null){
				if(soaTubeResponse.getValue().getMessageFault() ==null ){
					retHashMap.put("DB_NAME", soaTubeResponse.getValue().getDatabaseName());
					retHashMap.put("APP_VERSION", soaTubeResponse.getValue().getApplicationVersion());
				}
				else{
					String faultMessage =
							"Fault Code:" +  soaTubeResponse.getValue().getMessageFault().getMessageFaultCode()  +
							"\nFault Reason:" + soaTubeResponse.getValue().getMessageFault().getMessageFaultReason() +
							"\nFault source:" + soaTubeResponse.getValue().getMessageFault().getMessageFaultSource() ;
					String programFaultDetails ="";
					String serverName="";
					if(soaTubeResponse.getValue().getMessageFault().getMessageFaultDetail()!=null){
						if(soaTubeResponse.getValue().getMessageFault().getMessageFaultDetail().getProgram() != null){
							programFaultDetails += "Program >> ";

							for ( Program pr : soaTubeResponse.getValue().getMessageFault().getMessageFaultDetail().getProgram() ){
								programFaultDetails += " Line: "+ pr.getProgramLine() +" " + " Unit: " + pr.getProgramUnit();
							}
						}
						serverName = soaTubeResponse.getValue().getMessageFault().getMessageFaultDetail().getServerName();
					}
					String faultDetail = faultMessage + "Fault Detail : "+ "Server name: " + serverName + programFaultDetails ;
					LOGGER.error(faultDetail);
					throw new BudgSOAException(faultMessage);
				}
			}

			LOGGER.debug("DB_NAME="+soaTubeResponse.getValue().getDatabaseName());
			LOGGER.debug("APP_VERSION="+soaTubeResponse.getValue().getApplicationVersion());

		} catch (JMSException e) {
			e.printStackTrace();
			throw new BudgSOAException("Error while sending/receiving message", e );
		}
		catch (JAXBException e) {
			e.printStackTrace();
			throw new BudgSOAException("JAXBException", e );
		}

		finally {
			try {
				if(queueSession!=null){	queueSession.close();}
				if(queueConnection!=null){queueConnection.close();}
			}
			catch (JMSException e) {
				LOGGER.error("Error while cleaning up JMS resources");
				e.printStackTrace();
			}
		}
		return retHashMap;
	}

	public SoatubeRequestType createRequest(String messageCorID){
		SoatubeRequestType request= new SoatubeRequestType();
		request.setDebug(true);
		MessageHeaderType msgHeaderType=new MessageHeaderType();
		msgHeaderType.setMessageCorrelationId(messageCorID);
		request.setMessageHeader(msgHeaderType);
		return request;
	}

	public JAXBElement<SoatubeResponseType> createResponse(String responseXmlString) throws JAXBException{
		if( responseXmlString ==null ) return null;
		Unmarshaller unmarshaller = soaTubeResponseContext.createUnmarshaller();
		return (JAXBElement<SoatubeResponseType>) unmarshaller.unmarshal(new StringReader(responseXmlString));
	}

	public String convertRequestToXmlString(SoatubeRequestType soaTubeRequestType) throws JAXBException{
		Marshaller soaMarshaller = soaTubeRequestContext.createMarshaller();
		StringWriter sw = new StringWriter();
		ObjectFactory of=new ObjectFactory();
		soaMarshaller.marshal(of.createSoatubeRequest(soaTubeRequestType),  sw);
		return sw.toString();
	}
}
