
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.recovery_context.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.recovery_context.v1 package.
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

    private final static QName _RecoveryContextGetRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/recovery_context/v1", "RecoveryContextGetRequest");
    private final static QName _RecoveryContextGetResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/recovery_context/v1", "RecoveryContextGetResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.recovery_context.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecoveryContextGetType }
     * 
     */
    public RecoveryContextGetType createRecoveryContextGetType() {
        return new RecoveryContextGetType();
    }

    /**
     * Create an instance of {@link RecoveryContextType }
     * 
     */
    public RecoveryContextType createRecoveryContextType() {
        return new RecoveryContextType();
    }

    /**
     * Create an instance of {@link RecoveryContextGetRequestType }
     * 
     */
    public RecoveryContextGetRequestType createRecoveryContextGetRequestType() {
        return new RecoveryContextGetRequestType();
    }

    /**
     * Create an instance of {@link RecoveryContextGetResponseType }
     * 
     */
    public RecoveryContextGetResponseType createRecoveryContextGetResponseType() {
        return new RecoveryContextGetResponseType();
    }

    /**
     * Create an instance of {@link RecoveryContextWithoutErrorsType }
     * 
     */
    public RecoveryContextWithoutErrorsType createRecoveryContextWithoutErrorsType() {
        return new RecoveryContextWithoutErrorsType();
    }

    /**
     * Create an instance of {@link ErrorIrregularityTypeNoDescType }
     * 
     */
    public ErrorIrregularityTypeNoDescType createErrorIrregularityTypeNoDescType() {
        return new ErrorIrregularityTypeNoDescType();
    }

    /**
     * Create an instance of {@link ErrorIrregularityTypeType }
     * 
     */
    public ErrorIrregularityTypeType createErrorIrregularityTypeType() {
        return new ErrorIrregularityTypeType();
    }

    /**
     * Create an instance of {@link DocumentType }
     * 
     */
    public DocumentType createDocumentType() {
        return new DocumentType();
    }

    /**
     * Create an instance of {@link RecoveryContextGetType.Documents }
     * 
     */
    public RecoveryContextGetType.Documents createRecoveryContextGetTypeDocuments() {
        return new RecoveryContextGetType.Documents();
    }

    /**
     * Create an instance of {@link RecoveryContextGetType.ErrorIrregularityTypes }
     * 
     */
    public RecoveryContextGetType.ErrorIrregularityTypes createRecoveryContextGetTypeErrorIrregularityTypes() {
        return new RecoveryContextGetType.ErrorIrregularityTypes();
    }

    /**
     * Create an instance of {@link RecoveryContextType.ErrorIrregularityTypes }
     * 
     */
    public RecoveryContextType.ErrorIrregularityTypes createRecoveryContextTypeErrorIrregularityTypes() {
        return new RecoveryContextType.ErrorIrregularityTypes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecoveryContextGetRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/recovery_context/v1", name = "RecoveryContextGetRequest")
    public JAXBElement<RecoveryContextGetRequestType> createRecoveryContextGetRequest(RecoveryContextGetRequestType value) {
        return new JAXBElement<RecoveryContextGetRequestType>(_RecoveryContextGetRequest_QNAME, RecoveryContextGetRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecoveryContextGetResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/recovery_context/v1", name = "RecoveryContextGetResponse")
    public JAXBElement<RecoveryContextGetResponseType> createRecoveryContextGetResponse(RecoveryContextGetResponseType value) {
        return new JAXBElement<RecoveryContextGetResponseType>(_RecoveryContextGetResponse_QNAME, RecoveryContextGetResponseType.class, null, value);
    }

}
