
package generated.jagate.ws.domain.visa.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.ws.domain.visa.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GiveVisaResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/visa/v1", "GiveVisaResponse");
    private final static QName _GiveVisaRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/visa/v1", "GiveVisaRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.ws.domain.visa.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GiveVisaResponseType }
     * 
     */
    public GiveVisaResponseType createGiveVisaResponseType() {
        return new GiveVisaResponseType();
    }

    /**
     * Create an instance of {@link GiveVisaRequestType }
     * 
     */
    public GiveVisaRequestType createGiveVisaRequestType() {
        return new GiveVisaRequestType();
    }

    /**
     * Create an instance of {@link BasicVisa }
     * 
     */
    public BasicVisa createBasicVisa() {
        return new BasicVisa();
    }

    /**
     * Create an instance of {@link Visa }
     * 
     */
    public Visa createVisa() {
        return new Visa();
    }

    /**
     * Create an instance of {@link VisaEmbeddedType }
     * 
     */
    public VisaEmbeddedType createVisaEmbeddedType() {
        return new VisaEmbeddedType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GiveVisaResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/visa/v1", name = "GiveVisaResponse")
    public JAXBElement<GiveVisaResponseType> createGiveVisaResponse(GiveVisaResponseType value) {
        return new JAXBElement<GiveVisaResponseType>(_GiveVisaResponse_QNAME, GiveVisaResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GiveVisaRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/visa/v1", name = "GiveVisaRequest")
    public JAXBElement<GiveVisaRequestType> createGiveVisaRequest(GiveVisaRequestType value) {
        return new JAXBElement<GiveVisaRequestType>(_GiveVisaRequest_QNAME, GiveVisaRequestType.class, null, value);
    }

}
