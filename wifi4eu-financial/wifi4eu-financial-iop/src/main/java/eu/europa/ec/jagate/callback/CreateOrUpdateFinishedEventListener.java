package eu.europa.ec.jagate.callback;

import eu.europa.ec.rdg.jagate.ws.domain.event.legalentity.finish.v2.CreateOrUpdateFinishedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import static com.google.common.base.Throwables.propagate;

@MessageDriven(mappedName = "jms/topic/rdg/event", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "jagate/jms/factory"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue = "jagate/jms/topic"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue ="JMSType='eu.europa.ec.rdg.jagate.ws.domain.event.legalentity.finish.v2.CreateOrUpdateFinishedEvent' OR JMSType='eu.europa.ec.rdg.jagate.ws.domain.event.legalentity.interrupted.v1.CreateOrUpdateInterruptedEvent'"),
        @ActivationConfigProperty(propertyName = "subscriptionSharingPolicy", propertyValue = "Sharable"),
        @ActivationConfigProperty(propertyName = "clientIdPolicy", propertyValue = "UNRESTRICTED")})
public class CreateOrUpdateFinishedEventListener implements MessageListener {

    private Logger LOGGER= LoggerFactory.getLogger(CreateOrUpdateFinishedEventListener.class);

    public void onMessage(Message message)
    {
        try{
            if(message instanceof TextMessage){
                onMessage((TextMessage)message);
            }
            else{
                LOGGER.warn("Ignored unsupported Message type received: (expected: " + TextMessage.class.getName() + " , actual: " + message.getJMSType());
            }
        }
        catch(Exception e){
            LOGGER.error("Error while receiving an event.", e);
            propagate(e);
        }
    }

    private void onMessage(TextMessage message) throws Exception
    {
        LOGGER.debug("Received event Message:" + message);
        if (message == null) {
            LOGGER.warn("Ignored null message received");
            return;
        }

        String textMessage = message.getText();
        Object eventBody = getEventBody(textMessage);
        LOGGER.debug("eventBody {}", eventBody);

        if (eventBody instanceof eu.europa.ec.rdg.efp.domain.event.v1_0.EventBodyType) {
            LOGGER.warn("EventBody " + eventBody.getClass() + " not supported");
        } else if (eventBody instanceof eu.europa.ec.research.fp.model.eventbase.v1.EventType) {
            eu.europa.ec.research.fp.model.eventbase.v1.EventBodyType eventBodyType=((eu.europa.ec.research.fp.model.eventbase.v1.EventType) eventBody).getEventBody();
            onEvent(eventBodyType);
        }

    }

    protected Object getEventBody(String textMessage) {
        Object eventBody = null;
        try {
            eventBody = SOAPEnvelopExtractor.extractFromNotifyTemplateV1(textMessage);
        } catch (Exception e1) {
            //
            try {
                eventBody = SOAPEnvelopExtractor.extractFromNotifyTemplateV2(textMessage);
            } catch (Exception e2) {
                //
            }
        }

        return eventBody;
    }

    protected void onEvent(eu.europa.ec.research.fp.model.eventbase.v1.EventBodyType eventBody)
            throws Exception
    {
        if (eventBody instanceof CreateOrUpdateFinishedEvent) {
            LOGGER.warn("CreateOrUpdateFinishedEvent " + ((CreateOrUpdateFinishedEvent)eventBody).getFelId());
        }
        else {
            LOGGER.warn("EventBody " + eventBody.getClass() + " not supported");
        }
    }


}
