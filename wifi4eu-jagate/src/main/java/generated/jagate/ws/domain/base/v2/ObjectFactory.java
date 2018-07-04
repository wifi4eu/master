
package generated.jagate.ws.domain.base.v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.ws.domain.base.v2 package. 
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

    private final static QName _LocObjForeignId_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", "LocObjForeignId");
    private final static QName _Exception_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", "Exception");
    private final static QName _Response_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", "Response");
    private final static QName _Callback_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", "Callback");
    private final static QName _Message_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", "Message");
    private final static QName _RequestId_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", "RequestId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.ws.domain.base.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestHeader }
     * 
     */
    public RequestHeader createRequestHeader() {
        return new RequestHeader();
    }

    /**
     * Create an instance of {@link RequestHeader.ResultSetContext }
     * 
     */
    public RequestHeader.ResultSetContext createRequestHeaderResultSetContext() {
        return new RequestHeader.ResultSetContext();
    }

    /**
     * Create an instance of {@link JAgateException }
     * 
     */
    public JAgateException createJAgateException() {
        return new JAgateException();
    }

    /**
     * Create an instance of {@link BaseResponseMessageType }
     * 
     */
    public BaseResponseMessageType createBaseResponseMessageType() {
        return new BaseResponseMessageType();
    }

    /**
     * Create an instance of {@link CallbackType }
     * 
     */
    public CallbackType createCallbackType() {
        return new CallbackType();
    }

    /**
     * Create an instance of {@link SecurityContext }
     * 
     */
    public SecurityContext createSecurityContext() {
        return new SecurityContext();
    }

    /**
     * Create an instance of {@link Visa }
     * 
     */
    public Visa createVisa() {
        return new Visa();
    }

    /**
     * Create an instance of {@link EjbCallbackSpecType }
     * 
     */
    public EjbCallbackSpecType createEjbCallbackSpecType() {
        return new EjbCallbackSpecType();
    }

    /**
     * Create an instance of {@link EmbebedBaseVisaType }
     * 
     */
    public EmbebedBaseVisaType createEmbebedBaseVisaType() {
        return new EmbebedBaseVisaType();
    }

    /**
     * Create an instance of {@link WebServiceCallbackSpecType }
     * 
     */
    public WebServiceCallbackSpecType createWebServiceCallbackSpecType() {
        return new WebServiceCallbackSpecType();
    }

    /**
     * Create an instance of {@link ScannedDocument }
     * 
     */
    public ScannedDocument createScannedDocument() {
        return new ScannedDocument();
    }

    /**
     * Create an instance of {@link AresDocument }
     * 
     */
    public AresDocument createAresDocument() {
        return new AresDocument();
    }

    /**
     * Create an instance of {@link BaseRequestMessageType }
     * 
     */
    public BaseRequestMessageType createBaseRequestMessageType() {
        return new BaseRequestMessageType();
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link JmsCallbackSpecType }
     * 
     */
    public JmsCallbackSpecType createJmsCallbackSpecType() {
        return new JmsCallbackSpecType();
    }

    /**
     * Create an instance of {@link IdentifiedResponseMessageType }
     * 
     */
    public IdentifiedResponseMessageType createIdentifiedResponseMessageType() {
        return new IdentifiedResponseMessageType();
    }

    /**
     * Create an instance of {@link SoaResponseType }
     * 
     */
    public SoaResponseType createSoaResponseType() {
        return new SoaResponseType();
    }

    /**
     * Create an instance of {@link ScannedDocumentList }
     * 
     */
    public ScannedDocumentList createScannedDocumentList() {
        return new ScannedDocumentList();
    }

    /**
     * Create an instance of {@link AresDocumentList }
     * 
     */
    public AresDocumentList createAresDocumentList() {
        return new AresDocumentList();
    }

    /**
     * Create an instance of {@link BaseVisaType }
     * 
     */
    public BaseVisaType createBaseVisaType() {
        return new BaseVisaType();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link BaseRequest }
     * 
     */
    public BaseRequest createBaseRequest() {
        return new BaseRequest();
    }

    /**
     * Create an instance of {@link SoaResponseMessageType }
     * 
     */
    public SoaResponseMessageType createSoaResponseMessageType() {
        return new SoaResponseMessageType();
    }

    /**
     * Create an instance of {@link TransactionResponseMessageType }
     * 
     */
    public TransactionResponseMessageType createTransactionResponseMessageType() {
        return new TransactionResponseMessageType();
    }

    /**
     * Create an instance of {@link RequestHeader.ResultSetContext.StatelessPagination }
     * 
     */
    public RequestHeader.ResultSetContext.StatelessPagination createRequestHeaderResultSetContextStatelessPagination() {
        return new RequestHeader.ResultSetContext.StatelessPagination();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", name = "LocObjForeignId")
    public JAXBElement<String> createLocObjForeignId(String value) {
        return new JAXBElement<String>(_LocObjForeignId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JAgateException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", name = "Exception")
    public JAXBElement<JAgateException> createException(JAgateException value) {
        return new JAXBElement<JAgateException>(_Exception_QNAME, JAgateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseResponseMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", name = "Response")
    public JAXBElement<BaseResponseMessageType> createResponse(BaseResponseMessageType value) {
        return new JAXBElement<BaseResponseMessageType>(_Response_QNAME, BaseResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CallbackType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", name = "Callback")
    public JAXBElement<CallbackType> createCallback(CallbackType value) {
        return new JAXBElement<CallbackType>(_Callback_QNAME, CallbackType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", name = "Message")
    public JAXBElement<String> createMessage(String value) {
        return new JAXBElement<String>(_Message_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/base/v2", name = "RequestId")
    public JAXBElement<String> createRequestId(String value) {
        return new JAXBElement<String>(_RequestId_QNAME, String.class, null, value);
    }

}
