
package eu.europa.ec.budg.abac.soatube.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.europa.ec.budg.abac.soatube.v1 package. 
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

    private final static QName _SoatubeRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/soatube/v1", "SoatubeRequest");
    private final static QName _SoatubeResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/soatube/v1", "SoatubeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.europa.ec.budg.abac.soatube.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SoatubeResponseType }
     * 
     */
    public SoatubeResponseType createSoatubeResponseType() {
        return new SoatubeResponseType();
    }

    /**
     * Create an instance of {@link SoatubeResponseType.ServicesList }
     * 
     */
    public SoatubeResponseType.ServicesList createSoatubeResponseTypeServicesList() {
        return new SoatubeResponseType.ServicesList();
    }

    /**
     * Create an instance of {@link SoatubeRequestType }
     * 
     */
    public SoatubeRequestType createSoatubeRequestType() {
        return new SoatubeRequestType();
    }

    /**
     * Create an instance of {@link SoatubeResponseType.ServicesList.Service }
     * 
     */
    public SoatubeResponseType.ServicesList.Service createSoatubeResponseTypeServicesListService() {
        return new SoatubeResponseType.ServicesList.Service();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoatubeRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/soatube/v1", name = "SoatubeRequest")
    public JAXBElement<SoatubeRequestType> createSoatubeRequest(SoatubeRequestType value) {
        return new JAXBElement<SoatubeRequestType>(_SoatubeRequest_QNAME, SoatubeRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoatubeResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/soatube/v1", name = "SoatubeResponse")
    public JAXBElement<SoatubeResponseType> createSoatubeResponse(SoatubeResponseType value) {
        return new JAXBElement<SoatubeResponseType>(_SoatubeResponse_QNAME, SoatubeResponseType.class, null, value);
    }

}
