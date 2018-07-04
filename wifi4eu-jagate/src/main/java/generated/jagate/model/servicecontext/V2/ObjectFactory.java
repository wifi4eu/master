
package generated.jagate.model.servicecontext.V2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model.servicecontext.V2 package. 
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

    private final static QName _ResultContext_QNAME = new QName("http://ec.europa.eu/research/fp/model/service-context/V2", "ResultContext");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model.servicecontext.V2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceInformationType }
     * 
     */
    public ServiceInformationType createServiceInformationType() {
        return new ServiceInformationType();
    }

    /**
     * Create an instance of {@link ResultContextType }
     * 
     */
    public ResultContextType createResultContextType() {
        return new ResultContextType();
    }

    /**
     * Create an instance of {@link StatusDetailType }
     * 
     */
    public StatusDetailType createStatusDetailType() {
        return new StatusDetailType();
    }

    /**
     * Create an instance of {@link ServiceInformationType.StatusDetailList }
     * 
     */
    public ServiceInformationType.StatusDetailList createServiceInformationTypeStatusDetailList() {
        return new ServiceInformationType.StatusDetailList();
    }

    /**
     * Create an instance of {@link ResultContextType.ServiceInformationList }
     * 
     */
    public ResultContextType.ServiceInformationList createResultContextTypeServiceInformationList() {
        return new ResultContextType.ServiceInformationList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultContextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/service-context/V2", name = "ResultContext")
    public JAXBElement<ResultContextType> createResultContext(ResultContextType value) {
        return new JAXBElement<ResultContextType>(_ResultContext_QNAME, ResultContextType.class, null, value);
    }

}
