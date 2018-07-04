
package generated.jagate.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import generated.jagate.ws.domain.base.v2.JAgateException;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.jagate.model package. 
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

    private final static QName _CheckServiceHealthResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "CheckServiceHealthResponse");
    private final static QName _GetStatusByFelIdRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetStatusByFelIdRequest");
    private final static QName _GetMailingAddressesByPicRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetMailingAddressesByPicRequest");
    private final static QName _GetAllBankAccountsRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetAllBankAccountsRequest");
    private final static QName _CreateLegalEntityResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "CreateLegalEntityResponse");
    private final static QName _UpdateLegalEntityRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "UpdateLegalEntityRequest");
    private final static QName _GetLegalEntityBankAccountLinkResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetLegalEntityBankAccountLinkResponse");
    private final static QName _GetEwsByFelIdResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetEwsByFelIdResponse");
    private final static QName _GetLegalEntityBankAccountLinkRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetLegalEntityBankAccountLinkRequest");
    private final static QName _GetStatusByFelIdResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetStatusByFelIdResponse");
    private final static QName _GetBankAccountByFelIdRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetBankAccountByFelIdRequest");
    private final static QName _SearchLegalEntityResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "SearchLegalEntityResponse");
    private final static QName _GetBankAccountByPicResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetBankAccountByPicResponse");
    private final static QName _GetEwsByFelIdRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetEwsByFelIdRequest");
    private final static QName _GetStatusByPicRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetStatusByPicRequest");
    private final static QName _GetBankAccountByFelIdResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetBankAccountByFelIdResponse");
    private final static QName _SearchLegalEntityRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "SearchLegalEntityRequest");
    private final static QName _UpdateLegalEntityResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "UpdateLegalEntityResponse");
    private final static QName _GetEwsByPicResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetEwsByPicResponse");
    private final static QName _LegalEntityException_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "LegalEntityException");
    private final static QName _CreateLegalEntityRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "CreateLegalEntityRequest");
    private final static QName _GetStatusByPicResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetStatusByPicResponse");
    private final static QName _GetMailingAddressesByPicResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetMailingAddressesByPicResponse");
    private final static QName _GetAllBankAccountsResponse_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetAllBankAccountsResponse");
    private final static QName _GetBankAccountByPicRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetBankAccountByPicRequest");
    private final static QName _CheckServiceHealthRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "CheckServiceHealthRequest");
    private final static QName _GetEwsByPicRequest_QNAME = new QName("http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", "GetEwsByPicRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.jagate.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllBankAccountsResponseType }
     * 
     */
    public GetAllBankAccountsResponseType createGetAllBankAccountsResponseType() {
        return new GetAllBankAccountsResponseType();
    }

    /**
     * Create an instance of {@link GetBankAccountByPicRequestType }
     * 
     */
    public GetBankAccountByPicRequestType createGetBankAccountByPicRequestType() {
        return new GetBankAccountByPicRequestType();
    }

    /**
     * Create an instance of {@link GetStatusByFelIdResponseType }
     * 
     */
    public GetStatusByFelIdResponseType createGetStatusByFelIdResponseType() {
        return new GetStatusByFelIdResponseType();
    }

    /**
     * Create an instance of {@link CheckServiceHealthRequestType }
     * 
     */
    public CheckServiceHealthRequestType createCheckServiceHealthRequestType() {
        return new CheckServiceHealthRequestType();
    }

    /**
     * Create an instance of {@link SearchLegalEntityResponseType }
     * 
     */
    public SearchLegalEntityResponseType createSearchLegalEntityResponseType() {
        return new SearchLegalEntityResponseType();
    }

    /**
     * Create an instance of {@link GetEwsByPicRequestType }
     * 
     */
    public GetEwsByPicRequestType createGetEwsByPicRequestType() {
        return new GetEwsByPicRequestType();
    }

    /**
     * Create an instance of {@link GetBankAccountByPicResponseType }
     * 
     */
    public GetBankAccountByPicResponseType createGetBankAccountByPicResponseType() {
        return new GetBankAccountByPicResponseType();
    }

    /**
     * Create an instance of {@link GetBankAccountByFelIdRequestType }
     * 
     */
    public GetBankAccountByFelIdRequestType createGetBankAccountByFelIdRequestType() {
        return new GetBankAccountByFelIdRequestType();
    }

    /**
     * Create an instance of {@link CheckServiceHealthResponseType }
     * 
     */
    public CheckServiceHealthResponseType createCheckServiceHealthResponseType() {
        return new CheckServiceHealthResponseType();
    }

    /**
     * Create an instance of {@link GetBankAccountByFelIdResponseType }
     * 
     */
    public GetBankAccountByFelIdResponseType createGetBankAccountByFelIdResponseType() {
        return new GetBankAccountByFelIdResponseType();
    }

    /**
     * Create an instance of {@link SearchLegalEntityRequestType }
     * 
     */
    public SearchLegalEntityRequestType createSearchLegalEntityRequestType() {
        return new SearchLegalEntityRequestType();
    }

    /**
     * Create an instance of {@link GetStatusByFelIdRequestType }
     * 
     */
    public GetStatusByFelIdRequestType createGetStatusByFelIdRequestType() {
        return new GetStatusByFelIdRequestType();
    }

    /**
     * Create an instance of {@link GetMailingAddressesByPicRequestType }
     * 
     */
    public GetMailingAddressesByPicRequestType createGetMailingAddressesByPicRequestType() {
        return new GetMailingAddressesByPicRequestType();
    }

    /**
     * Create an instance of {@link GetEwsByFelIdRequestType }
     * 
     */
    public GetEwsByFelIdRequestType createGetEwsByFelIdRequestType() {
        return new GetEwsByFelIdRequestType();
    }

    /**
     * Create an instance of {@link GetStatusByPicRequestType }
     * 
     */
    public GetStatusByPicRequestType createGetStatusByPicRequestType() {
        return new GetStatusByPicRequestType();
    }

    /**
     * Create an instance of {@link UpdateLegalEntityRequestType }
     * 
     */
    public UpdateLegalEntityRequestType createUpdateLegalEntityRequestType() {
        return new UpdateLegalEntityRequestType();
    }

    /**
     * Create an instance of {@link GetLegalEntityBankAccountLinkResponseType }
     * 
     */
    public GetLegalEntityBankAccountLinkResponseType createGetLegalEntityBankAccountLinkResponseType() {
        return new GetLegalEntityBankAccountLinkResponseType();
    }

    /**
     * Create an instance of {@link CreateLegalEntityRequestType }
     * 
     */
    public CreateLegalEntityRequestType createCreateLegalEntityRequestType() {
        return new CreateLegalEntityRequestType();
    }

    /**
     * Create an instance of {@link GetEwsByFelIdResponseType }
     * 
     */
    public GetEwsByFelIdResponseType createGetEwsByFelIdResponseType() {
        return new GetEwsByFelIdResponseType();
    }

    /**
     * Create an instance of {@link GetStatusByPicResponseType }
     * 
     */
    public GetStatusByPicResponseType createGetStatusByPicResponseType() {
        return new GetStatusByPicResponseType();
    }

    /**
     * Create an instance of {@link GetLegalEntityBankAccountLinkRequestType }
     * 
     */
    public GetLegalEntityBankAccountLinkRequestType createGetLegalEntityBankAccountLinkRequestType() {
        return new GetLegalEntityBankAccountLinkRequestType();
    }

    /**
     * Create an instance of {@link GetMailingAddressesByPicResponseType }
     * 
     */
    public GetMailingAddressesByPicResponseType createGetMailingAddressesByPicResponseType() {
        return new GetMailingAddressesByPicResponseType();
    }

    /**
     * Create an instance of {@link GetAllBankAccountsRequestType }
     * 
     */
    public GetAllBankAccountsRequestType createGetAllBankAccountsRequestType() {
        return new GetAllBankAccountsRequestType();
    }

    /**
     * Create an instance of {@link UpdateLegalEntityResponseType }
     * 
     */
    public UpdateLegalEntityResponseType createUpdateLegalEntityResponseType() {
        return new UpdateLegalEntityResponseType();
    }

    /**
     * Create an instance of {@link GetEwsByPicResponseType }
     * 
     */
    public GetEwsByPicResponseType createGetEwsByPicResponseType() {
        return new GetEwsByPicResponseType();
    }

    /**
     * Create an instance of {@link CreateLegalEntityResponseType }
     * 
     */
    public CreateLegalEntityResponseType createCreateLegalEntityResponseType() {
        return new CreateLegalEntityResponseType();
    }

    /**
     * Create an instance of {@link SearchLegalEntityResultType }
     * 
     */
    public SearchLegalEntityResultType createSearchLegalEntityResultType() {
        return new SearchLegalEntityResultType();
    }

    /**
     * Create an instance of {@link LegalEntityExceptionType }
     * 
     */
    public LegalEntityExceptionType createLegalEntityExceptionType() {
        return new LegalEntityExceptionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckServiceHealthResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "CheckServiceHealthResponse")
    public JAXBElement<CheckServiceHealthResponseType> createCheckServiceHealthResponse(CheckServiceHealthResponseType value) {
        return new JAXBElement<CheckServiceHealthResponseType>(_CheckServiceHealthResponse_QNAME, CheckServiceHealthResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusByFelIdRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetStatusByFelIdRequest")
    public JAXBElement<GetStatusByFelIdRequestType> createGetStatusByFelIdRequest(GetStatusByFelIdRequestType value) {
        return new JAXBElement<GetStatusByFelIdRequestType>(_GetStatusByFelIdRequest_QNAME, GetStatusByFelIdRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMailingAddressesByPicRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetMailingAddressesByPicRequest")
    public JAXBElement<GetMailingAddressesByPicRequestType> createGetMailingAddressesByPicRequest(GetMailingAddressesByPicRequestType value) {
        return new JAXBElement<GetMailingAddressesByPicRequestType>(_GetMailingAddressesByPicRequest_QNAME, GetMailingAddressesByPicRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBankAccountsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetAllBankAccountsRequest")
    public JAXBElement<GetAllBankAccountsRequestType> createGetAllBankAccountsRequest(GetAllBankAccountsRequestType value) {
        return new JAXBElement<GetAllBankAccountsRequestType>(_GetAllBankAccountsRequest_QNAME, GetAllBankAccountsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateLegalEntityResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "CreateLegalEntityResponse")
    public JAXBElement<CreateLegalEntityResponseType> createCreateLegalEntityResponse(CreateLegalEntityResponseType value) {
        return new JAXBElement<CreateLegalEntityResponseType>(_CreateLegalEntityResponse_QNAME, CreateLegalEntityResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLegalEntityRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "UpdateLegalEntityRequest")
    public JAXBElement<UpdateLegalEntityRequestType> createUpdateLegalEntityRequest(UpdateLegalEntityRequestType value) {
        return new JAXBElement<UpdateLegalEntityRequestType>(_UpdateLegalEntityRequest_QNAME, UpdateLegalEntityRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLegalEntityBankAccountLinkResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetLegalEntityBankAccountLinkResponse")
    public JAXBElement<GetLegalEntityBankAccountLinkResponseType> createGetLegalEntityBankAccountLinkResponse(GetLegalEntityBankAccountLinkResponseType value) {
        return new JAXBElement<GetLegalEntityBankAccountLinkResponseType>(_GetLegalEntityBankAccountLinkResponse_QNAME, GetLegalEntityBankAccountLinkResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEwsByFelIdResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetEwsByFelIdResponse")
    public JAXBElement<GetEwsByFelIdResponseType> createGetEwsByFelIdResponse(GetEwsByFelIdResponseType value) {
        return new JAXBElement<GetEwsByFelIdResponseType>(_GetEwsByFelIdResponse_QNAME, GetEwsByFelIdResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLegalEntityBankAccountLinkRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetLegalEntityBankAccountLinkRequest")
    public JAXBElement<GetLegalEntityBankAccountLinkRequestType> createGetLegalEntityBankAccountLinkRequest(GetLegalEntityBankAccountLinkRequestType value) {
        return new JAXBElement<GetLegalEntityBankAccountLinkRequestType>(_GetLegalEntityBankAccountLinkRequest_QNAME, GetLegalEntityBankAccountLinkRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusByFelIdResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetStatusByFelIdResponse")
    public JAXBElement<GetStatusByFelIdResponseType> createGetStatusByFelIdResponse(GetStatusByFelIdResponseType value) {
        return new JAXBElement<GetStatusByFelIdResponseType>(_GetStatusByFelIdResponse_QNAME, GetStatusByFelIdResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankAccountByFelIdRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetBankAccountByFelIdRequest")
    public JAXBElement<GetBankAccountByFelIdRequestType> createGetBankAccountByFelIdRequest(GetBankAccountByFelIdRequestType value) {
        return new JAXBElement<GetBankAccountByFelIdRequestType>(_GetBankAccountByFelIdRequest_QNAME, GetBankAccountByFelIdRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchLegalEntityResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "SearchLegalEntityResponse")
    public JAXBElement<SearchLegalEntityResponseType> createSearchLegalEntityResponse(SearchLegalEntityResponseType value) {
        return new JAXBElement<SearchLegalEntityResponseType>(_SearchLegalEntityResponse_QNAME, SearchLegalEntityResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankAccountByPicResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetBankAccountByPicResponse")
    public JAXBElement<GetBankAccountByPicResponseType> createGetBankAccountByPicResponse(GetBankAccountByPicResponseType value) {
        return new JAXBElement<GetBankAccountByPicResponseType>(_GetBankAccountByPicResponse_QNAME, GetBankAccountByPicResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEwsByFelIdRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetEwsByFelIdRequest")
    public JAXBElement<GetEwsByFelIdRequestType> createGetEwsByFelIdRequest(GetEwsByFelIdRequestType value) {
        return new JAXBElement<GetEwsByFelIdRequestType>(_GetEwsByFelIdRequest_QNAME, GetEwsByFelIdRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusByPicRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetStatusByPicRequest")
    public JAXBElement<GetStatusByPicRequestType> createGetStatusByPicRequest(GetStatusByPicRequestType value) {
        return new JAXBElement<GetStatusByPicRequestType>(_GetStatusByPicRequest_QNAME, GetStatusByPicRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankAccountByFelIdResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetBankAccountByFelIdResponse")
    public JAXBElement<GetBankAccountByFelIdResponseType> createGetBankAccountByFelIdResponse(GetBankAccountByFelIdResponseType value) {
        return new JAXBElement<GetBankAccountByFelIdResponseType>(_GetBankAccountByFelIdResponse_QNAME, GetBankAccountByFelIdResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchLegalEntityRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "SearchLegalEntityRequest")
    public JAXBElement<SearchLegalEntityRequestType> createSearchLegalEntityRequest(SearchLegalEntityRequestType value) {
        return new JAXBElement<SearchLegalEntityRequestType>(_SearchLegalEntityRequest_QNAME, SearchLegalEntityRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLegalEntityResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "UpdateLegalEntityResponse")
    public JAXBElement<UpdateLegalEntityResponseType> createUpdateLegalEntityResponse(UpdateLegalEntityResponseType value) {
        return new JAXBElement<UpdateLegalEntityResponseType>(_UpdateLegalEntityResponse_QNAME, UpdateLegalEntityResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEwsByPicResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetEwsByPicResponse")
    public JAXBElement<GetEwsByPicResponseType> createGetEwsByPicResponse(GetEwsByPicResponseType value) {
        return new JAXBElement<GetEwsByPicResponseType>(_GetEwsByPicResponse_QNAME, GetEwsByPicResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JAgateException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "LegalEntityException")
    public JAXBElement<JAgateException> createLegalEntityException(JAgateException value) {
        return new JAXBElement<JAgateException>(_LegalEntityException_QNAME, JAgateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateLegalEntityRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "CreateLegalEntityRequest")
    public JAXBElement<CreateLegalEntityRequestType> createCreateLegalEntityRequest(CreateLegalEntityRequestType value) {
        return new JAXBElement<CreateLegalEntityRequestType>(_CreateLegalEntityRequest_QNAME, CreateLegalEntityRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusByPicResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetStatusByPicResponse")
    public JAXBElement<GetStatusByPicResponseType> createGetStatusByPicResponse(GetStatusByPicResponseType value) {
        return new JAXBElement<GetStatusByPicResponseType>(_GetStatusByPicResponse_QNAME, GetStatusByPicResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMailingAddressesByPicResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetMailingAddressesByPicResponse")
    public JAXBElement<GetMailingAddressesByPicResponseType> createGetMailingAddressesByPicResponse(GetMailingAddressesByPicResponseType value) {
        return new JAXBElement<GetMailingAddressesByPicResponseType>(_GetMailingAddressesByPicResponse_QNAME, GetMailingAddressesByPicResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBankAccountsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetAllBankAccountsResponse")
    public JAXBElement<GetAllBankAccountsResponseType> createGetAllBankAccountsResponse(GetAllBankAccountsResponseType value) {
        return new JAXBElement<GetAllBankAccountsResponseType>(_GetAllBankAccountsResponse_QNAME, GetAllBankAccountsResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankAccountByPicRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetBankAccountByPicRequest")
    public JAXBElement<GetBankAccountByPicRequestType> createGetBankAccountByPicRequest(GetBankAccountByPicRequestType value) {
        return new JAXBElement<GetBankAccountByPicRequestType>(_GetBankAccountByPicRequest_QNAME, GetBankAccountByPicRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckServiceHealthRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "CheckServiceHealthRequest")
    public JAXBElement<CheckServiceHealthRequestType> createCheckServiceHealthRequest(CheckServiceHealthRequestType value) {
        return new JAXBElement<CheckServiceHealthRequestType>(_CheckServiceHealthRequest_QNAME, CheckServiceHealthRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEwsByPicRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/rdg/jagate/ws/legalentity/v6/interfaces", name = "GetEwsByPicRequest")
    public JAXBElement<GetEwsByPicRequestType> createGetEwsByPicRequest(GetEwsByPicRequestType value) {
        return new JAXBElement<GetEwsByPicRequestType>(_GetEwsByPicRequest_QNAME, GetEwsByPicRequestType.class, null, value);
    }

}
