
package generated.jagate.model.servicehealth.V1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model.servicehealth.V1 package. 
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

    private final static QName _CheckServiceHealthOut_QNAME = new QName("http://ec.europa.eu/research/fp/model/service-health/V1", "CheckServiceHealthOut");
    private final static QName _CheckServiceHealthIn_QNAME = new QName("http://ec.europa.eu/research/fp/model/service-health/V1", "CheckServiceHealthIn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model.servicehealth.V1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckServiceHealthOutType }
     * 
     */
    public CheckServiceHealthOutType createCheckServiceHealthOutType() {
        return new CheckServiceHealthOutType();
    }

    /**
     * Create an instance of {@link CheckServiceHealthInType }
     * 
     */
    public CheckServiceHealthInType createCheckServiceHealthInType() {
        return new CheckServiceHealthInType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckServiceHealthOutType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/service-health/V1", name = "CheckServiceHealthOut")
    public JAXBElement<CheckServiceHealthOutType> createCheckServiceHealthOut(CheckServiceHealthOutType value) {
        return new JAXBElement<CheckServiceHealthOutType>(_CheckServiceHealthOut_QNAME, CheckServiceHealthOutType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckServiceHealthInType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/service-health/V1", name = "CheckServiceHealthIn")
    public JAXBElement<CheckServiceHealthInType> createCheckServiceHealthIn(CheckServiceHealthInType value) {
        return new JAXBElement<CheckServiceHealthInType>(_CheckServiceHealthIn_QNAME, CheckServiceHealthInType.class, null, value);
    }

}
