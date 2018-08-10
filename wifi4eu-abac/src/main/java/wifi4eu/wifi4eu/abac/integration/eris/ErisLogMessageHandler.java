package wifi4eu.wifi4eu.abac.integration.eris;

import org.apache.xml.serializer.DOMSerializer;
import org.apache.xml.serializer.Method;
import org.apache.xml.serializer.OutputPropertiesFactory;
import org.apache.xml.serializer.Serializer;
import org.apache.xml.serializer.SerializerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

public class ErisLogMessageHandler implements SOAPHandler<SOAPMessageContext> {

    private static final Logger LOG = LoggerFactory.getLogger(ErisLogMessageHandler.class);

    private static final Set<QName> EMPTY_SET = new HashSet<>();
    private static final ThreadLocal<String> xslt = new ThreadLocal<>();

    @Override
    public Set<QName> getHeaders() {
        return EMPTY_SET ;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        //Due to a possible bug in weblogic 12.1.3.0 we cannot trust how the binary contents are transformed
        //after serializing the soap body
        //TODO: Update/Remove when the solution from the Weblogic Support Team is provided
        Boolean outbound = (Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
        LOG.debug("Handling SOAPMessage: ");
        if ((outbound != null)) {
            if (outbound) {

                LOG.debug("Adding Serialized Outbound SOAPMessage Content");
                LOG.info("OUTBOUND message {}", getXML(context.getMessage(), true));

            } else {
                LOG.debug("Adding Serialized Inbound SOAPMessage Content");
                LOG.info("INBOUND message {}", getXML(context.getMessage(), true));
            }
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        LOG.debug("Adding Serialized Inbound SOAPFault Message Content");
        LOG.error("FAULT message {}", getXML(context.getMessage(), false));
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }

    private String getXML(SOAPMessage soapMsg, boolean applyTransform) {

        try{

            StringWriter writer = new StringWriter();

            if (applyTransform && (xslt.get() != null)) {
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Source xsltSource = new StreamSource(new StringReader(xslt.get()));

                Transformer transformer = tFactory.newTransformer(xsltSource);

                DOMSource source = new DOMSource(soapMsg.getSOAPPart());
                StreamResult result = new StreamResult(writer);
                transformer.transform(source, result);

            } else {// use a more efficient way...

                java.util.Properties props = OutputPropertiesFactory.getDefaultMethodProperties(Method.XML);
                Serializer ser = SerializerFactory.getSerializer(props);
                ser.setWriter(writer);
                DOMSerializer dser = ser.asDOMSerializer();
                dser.serialize(soapMsg.getSOAPPart());
            }
            return writer.toString();

        }catch(Throwable e) {
            return null;
        }
    }
}
