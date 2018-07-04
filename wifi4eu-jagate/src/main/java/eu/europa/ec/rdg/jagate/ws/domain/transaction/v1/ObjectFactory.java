
package eu.europa.ec.rdg.jagate.ws.domain.transaction.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.europa.ec.rdg.jagate.ws.domain.transaction.v1 package. 
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

    private final static QName _GetROStatusResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", "GetROStatusResponse");
    private final static QName _CheckROforInternalPayment_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", "CheckROforInternalPayment");
    private final static QName _CheckROforInternalPaymentResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", "CheckROforInternalPaymentResponse");
    private final static QName _CheckROByPic_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", "CheckROByPic");
    private final static QName _GetStatusResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", "GetStatusResponse");
    private final static QName _CheckROByPicResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", "CheckROByPicResponse");
    private final static QName _GetROStatus_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", "GetROStatus");
    private final static QName _GetStatus_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", "GetStatus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.europa.ec.rdg.jagate.ws.domain.transaction.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckROforInternalPaymentResponse }
     * 
     */
    public CheckROforInternalPaymentResponse createCheckROforInternalPaymentResponse() {
        return new CheckROforInternalPaymentResponse();
    }

    /**
     * Create an instance of {@link CheckROByPicRequestType }
     * 
     */
    public CheckROByPicRequestType createCheckROByPicRequestType() {
        return new CheckROByPicRequestType();
    }

    /**
     * Create an instance of {@link GetStatusResponseList }
     * 
     */
    public GetStatusResponseList createGetStatusResponseList() {
        return new GetStatusResponseList();
    }

    /**
     * Create an instance of {@link GetROStatusResponse }
     * 
     */
    public GetROStatusResponse createGetROStatusResponse() {
        return new GetROStatusResponse();
    }

    /**
     * Create an instance of {@link CheckROforInternalPaymentRequestType }
     * 
     */
    public CheckROforInternalPaymentRequestType createCheckROforInternalPaymentRequestType() {
        return new CheckROforInternalPaymentRequestType();
    }

    /**
     * Create an instance of {@link GetROStatusRequestType }
     * 
     */
    public GetROStatusRequestType createGetROStatusRequestType() {
        return new GetROStatusRequestType();
    }

    /**
     * Create an instance of {@link CheckROByPicResponse }
     * 
     */
    public CheckROByPicResponse createCheckROByPicResponse() {
        return new CheckROByPicResponse();
    }

    /**
     * Create an instance of {@link GetStatusRequestType }
     * 
     */
    public GetStatusRequestType createGetStatusRequestType() {
        return new GetStatusRequestType();
    }

    /**
     * Create an instance of {@link InvoicesResponseType }
     * 
     */
    public InvoicesResponseType createInvoicesResponseType() {
        return new InvoicesResponseType();
    }

    /**
     * Create an instance of {@link RecoveriesByPartnerType }
     * 
     */
    public RecoveriesByPartnerType createRecoveriesByPartnerType() {
        return new RecoveriesByPartnerType();
    }

    /**
     * Create an instance of {@link StatusResponseType }
     * 
     */
    public StatusResponseType createStatusResponseType() {
        return new StatusResponseType();
    }

    /**
     * Create an instance of {@link RecoveryOrderStatusResponseType }
     * 
     */
    public RecoveryOrderStatusResponseType createRecoveryOrderStatusResponseType() {
        return new RecoveryOrderStatusResponseType();
    }

    /**
     * Create an instance of {@link CheckROByPicResponseType }
     * 
     */
    public CheckROByPicResponseType createCheckROByPicResponseType() {
        return new CheckROByPicResponseType();
    }

    /**
     * Create an instance of {@link CheckROStatusResponseType }
     * 
     */
    public CheckROStatusResponseType createCheckROStatusResponseType() {
        return new CheckROStatusResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetROStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", name = "GetROStatusResponse")
    public JAXBElement<GetROStatusResponse> createGetROStatusResponse(GetROStatusResponse value) {
        return new JAXBElement<GetROStatusResponse>(_GetROStatusResponse_QNAME, GetROStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckROforInternalPaymentRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", name = "CheckROforInternalPayment")
    public JAXBElement<CheckROforInternalPaymentRequestType> createCheckROforInternalPayment(CheckROforInternalPaymentRequestType value) {
        return new JAXBElement<CheckROforInternalPaymentRequestType>(_CheckROforInternalPayment_QNAME, CheckROforInternalPaymentRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckROforInternalPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", name = "CheckROforInternalPaymentResponse")
    public JAXBElement<CheckROforInternalPaymentResponse> createCheckROforInternalPaymentResponse(CheckROforInternalPaymentResponse value) {
        return new JAXBElement<CheckROforInternalPaymentResponse>(_CheckROforInternalPaymentResponse_QNAME, CheckROforInternalPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckROByPicRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", name = "CheckROByPic")
    public JAXBElement<CheckROByPicRequestType> createCheckROByPic(CheckROByPicRequestType value) {
        return new JAXBElement<CheckROByPicRequestType>(_CheckROByPic_QNAME, CheckROByPicRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusResponseList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", name = "GetStatusResponse")
    public JAXBElement<GetStatusResponseList> createGetStatusResponse(GetStatusResponseList value) {
        return new JAXBElement<GetStatusResponseList>(_GetStatusResponse_QNAME, GetStatusResponseList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckROByPicResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", name = "CheckROByPicResponse")
    public JAXBElement<CheckROByPicResponse> createCheckROByPicResponse(CheckROByPicResponse value) {
        return new JAXBElement<CheckROByPicResponse>(_CheckROByPicResponse_QNAME, CheckROByPicResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetROStatusRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", name = "GetROStatus")
    public JAXBElement<GetROStatusRequestType> createGetROStatus(GetROStatusRequestType value) {
        return new JAXBElement<GetROStatusRequestType>(_GetROStatus_QNAME, GetROStatusRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1", name = "GetStatus")
    public JAXBElement<GetStatusRequestType> createGetStatus(GetStatusRequestType value) {
        return new JAXBElement<GetStatusRequestType>(_GetStatus_QNAME, GetStatusRequestType.class, null, value);
    }

}
