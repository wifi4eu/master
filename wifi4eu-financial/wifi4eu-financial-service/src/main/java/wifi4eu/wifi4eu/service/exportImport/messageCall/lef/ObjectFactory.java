
package wifi4eu.wifi4eu.service.exportImport.messageCall.lef;

import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageResponseType;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.europa.ec.budg.abac.legal_entity.v2 package.
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

    private final static QName _LegalEntityGetRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityGetRequest");
    private final static QName _LegalEntityGetResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityGetResponse");
    private final static QName _EuropeanParliamentMember_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "EuropeanParliamentMember");
    private final static QName _ExStaffMember_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "ExStaffMember");
    private final static QName _PrivatePerson_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "PrivatePerson");
    private final static QName _PublicLawBody_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "PublicLawBody");
    private final static QName _PrivateLawBody_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "PrivateLawBody");
    private final static QName _StaffMember_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "StaffMember");
    private final static QName _TechnicalLegalEntity_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "TechnicalLegalEntity");
    private final static QName _LegalEntityCreateRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateRequest");
    private final static QName _LegalEntityCreateResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateResponse");
    private final static QName _LegalEntityCreateAresDocumentRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateAresDocumentRequest");
    private final static QName _LegalEntityCreateAresDocumentResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateAresDocumentResponse");
    private final static QName _LegalEntityCreateBankAccountRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateBankAccountRequest");
    private final static QName _LegalEntityCreateBankAccountResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateBankAccountResponse");
    private final static QName _LegalEntityCreateMailingAddressRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateMailingAddressRequest");
    private final static QName _LegalEntityCreateMailingAddressResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateMailingAddressResponse");
    private final static QName _LegalEntityCreateResponsibleUserRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateResponsibleUserRequest");
    private final static QName _LegalEntityCreateResponsibleUserResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateResponsibleUserResponse");
    private final static QName _LegalEntityCreateScannedDocumentRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateScannedDocumentRequest");
    private final static QName _LegalEntityCreateScannedDocumentResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCreateScannedDocumentResponse");
    private final static QName _LegalEntityCheckCreateRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCheckCreateRequest");
    private final static QName _LegalEntityCheckCreateResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCheckCreateResponse");
    private final static QName _LegalEntitySearchRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntitySearchRequest");
    private final static QName _LegalEntitySearchResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntitySearchResponse");
    private final static QName _PrivatePersonSearch_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "PrivatePersonSearch");
    private final static QName _StaffMemberSearch_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "StaffMemberSearch");
    private final static QName _ExStaffMemberSearch_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "ExStaffMemberSearch");
    private final static QName _EuropeanParliamentMemberSearch_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "EuropeanParliamentMemberSearch");
    private final static QName _PublicLawBodySearch_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "PublicLawBodySearch");
    private final static QName _PrivateLawBodySearch_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "PrivateLawBodySearch");
    private final static QName _TechnicalLegalEntitySearch_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "TechnicalLegalEntitySearch");
    private final static QName _LegalEntityCheckDuplicateRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCheckDuplicateRequest");
    private final static QName _LegalEntityCheckDuplicateResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCheckDuplicateResponse");
    private final static QName _LegalEntityCheckModifyRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCheckModifyRequest");
    private final static QName _LegalEntityCheckModifyResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityCheckModifyResponse");
    private final static QName _LegalEntityModifyBankAccountRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityModifyBankAccountRequest");
    private final static QName _LegalEntityModifyBankAccountResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityModifyBankAccountResponse");
    private final static QName _LegalEntityModifyMailingAddressRequest_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityModifyMailingAddressRequest");
    private final static QName _LegalEntityModifyMailingAddressResponse_QNAME = new QName("http://www.ec.europa.eu/budg/abac/legal_entity/v2", "LegalEntityModifyMailingAddressResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.europa.ec.budg.abac.legal_entity.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LegalEntityGetType.LegalEntityBankAccountLinks }
     * 
     */
    public LegalEntityGetType.LegalEntityBankAccountLinks createLegalEntityGetTypeLegalEntityBankAccountLinks() {
        return new LegalEntityGetType.LegalEntityBankAccountLinks();
    }

    /**
     * Create an instance of {@link LegalEntityCreateType.LegalEntityBankAccountLinks }
     *
     */
    public LegalEntityCreateType.LegalEntityBankAccountLinks createLegalEntityCreateTypeLegalEntityBankAccountLinks() {
        return new LegalEntityCreateType.LegalEntityBankAccountLinks();
    }

    /**
     * Create an instance of {@link LegalEntityModifyBankAccountRequestType }
     *
     */
    public LegalEntityModifyBankAccountRequestType createLegalEntityModifyBankAccountRequestType() {
        return new LegalEntityModifyBankAccountRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityCheckDuplicateResponseType }
     *
     */
    public LegalEntityCheckDuplicateResponseType createLegalEntityCheckDuplicateResponseType() {
        return new LegalEntityCheckDuplicateResponseType();
    }

    /**
     * Create an instance of {@link LegalEntityCreateBankAccountRequestType }
     *
     */
    public LegalEntityCreateBankAccountRequestType createLegalEntityCreateBankAccountRequestType() {
        return new LegalEntityCreateBankAccountRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityGetRequestType }
     *
     */
    public LegalEntityGetRequestType createLegalEntityGetRequestType() {
        return new LegalEntityGetRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityGetResponseType }
     *
     */
    public LegalEntityGetResponseType createLegalEntityGetResponseType() {
        return new LegalEntityGetResponseType();
    }

    /**
     * Create an instance of {@link EuropeanParliamentMemberGetType }
     *
     */
    public EuropeanParliamentMemberGetType createEuropeanParliamentMemberGetType() {
        return new EuropeanParliamentMemberGetType();
    }

    /**
     * Create an instance of {@link ExStaffMemberGetType }
     *
     */
    public ExStaffMemberGetType createExStaffMemberGetType() {
        return new ExStaffMemberGetType();
    }

    /**
     * Create an instance of {@link PrivatePersonGetType }
     *
     */
    public PrivatePersonGetType createPrivatePersonGetType() {
        return new PrivatePersonGetType();
    }

    /**
     * Create an instance of {@link PublicLawBodyGetType }
     *
     */
    public PublicLawBodyGetType createPublicLawBodyGetType() {
        return new PublicLawBodyGetType();
    }

    /**
     * Create an instance of {@link PrivateLawBodyGetType }
     *
     */
    public PrivateLawBodyGetType createPrivateLawBodyGetType() {
        return new PrivateLawBodyGetType();
    }

    /**
     * Create an instance of {@link StaffMemberGetType }
     *
     */
    public StaffMemberGetType createStaffMemberGetType() {
        return new StaffMemberGetType();
    }

    /**
     * Create an instance of {@link TechnicalLegalEntityGetType }
     *
     */
    public TechnicalLegalEntityGetType createTechnicalLegalEntityGetType() {
        return new TechnicalLegalEntityGetType();
    }

    /**
     * Create an instance of {@link LegalEntityCreateRequestType }
     *
     */
    public LegalEntityCreateRequestType createLegalEntityCreateRequestType() {
        return new LegalEntityCreateRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityCreateAresDocumentRequestType }
     *
     */
    public LegalEntityCreateAresDocumentRequestType createLegalEntityCreateAresDocumentRequestType() {
        return new LegalEntityCreateAresDocumentRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityCreateMailingAddressRequestType }
     *
     */
    public LegalEntityCreateMailingAddressRequestType createLegalEntityCreateMailingAddressRequestType() {
        return new LegalEntityCreateMailingAddressRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityCreateResponsibleUserRequestType }
     *
     */
    public LegalEntityCreateResponsibleUserRequestType createLegalEntityCreateResponsibleUserRequestType() {
        return new LegalEntityCreateResponsibleUserRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityCreateScannedDocumentRequestType }
     *
     */
    public LegalEntityCreateScannedDocumentRequestType createLegalEntityCreateScannedDocumentRequestType() {
        return new LegalEntityCreateScannedDocumentRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityCheckCreateRequestType }
     *
     */
    public LegalEntityCheckCreateRequestType createLegalEntityCheckCreateRequestType() {
        return new LegalEntityCheckCreateRequestType();
    }

    /**
     * Create an instance of {@link LegalEntitySearchRequestType }
     *
     */
    public LegalEntitySearchRequestType createLegalEntitySearchRequestType() {
        return new LegalEntitySearchRequestType();
    }

    /**
     * Create an instance of {@link LegalEntitySearchResponseType }
     *
     */
    public LegalEntitySearchResponseType createLegalEntitySearchResponseType() {
        return new LegalEntitySearchResponseType();
    }

    /**
     * Create an instance of {@link PrivatePersonSearchType }
     *
     */
    public PrivatePersonSearchType createPrivatePersonSearchType() {
        return new PrivatePersonSearchType();
    }

    /**
     * Create an instance of {@link StaffMemberSearchType }
     *
     */
    public StaffMemberSearchType createStaffMemberSearchType() {
        return new StaffMemberSearchType();
    }

    /**
     * Create an instance of {@link ExStaffMemberSearchType }
     *
     */
    public ExStaffMemberSearchType createExStaffMemberSearchType() {
        return new ExStaffMemberSearchType();
    }

    /**
     * Create an instance of {@link EuropeanParliamentMemberSearchType }
     *
     */
    public EuropeanParliamentMemberSearchType createEuropeanParliamentMemberSearchType() {
        return new EuropeanParliamentMemberSearchType();
    }

    /**
     * Create an instance of {@link PublicLawBodySearchType }
     *
     */
    public PublicLawBodySearchType createPublicLawBodySearchType() {
        return new PublicLawBodySearchType();
    }

    /**
     * Create an instance of {@link PrivateLawBodySearchType }
     *
     */
    public PrivateLawBodySearchType createPrivateLawBodySearchType() {
        return new PrivateLawBodySearchType();
    }

    /**
     * Create an instance of {@link TechnicalLegalEntitySearchType }
     *
     */
    public TechnicalLegalEntitySearchType createTechnicalLegalEntitySearchType() {
        return new TechnicalLegalEntitySearchType();
    }

    /**
     * Create an instance of {@link LegalEntityCheckDuplicateRequestType }
     *
     */
    public LegalEntityCheckDuplicateRequestType createLegalEntityCheckDuplicateRequestType() {
        return new LegalEntityCheckDuplicateRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityCheckModifyRequestType }
     *
     */
    public LegalEntityCheckModifyRequestType createLegalEntityCheckModifyRequestType() {
        return new LegalEntityCheckModifyRequestType();
    }

    /**
     * Create an instance of {@link LegalEntityModifyMailingAddressRequestType }
     *
     */
    public LegalEntityModifyMailingAddressRequestType createLegalEntityModifyMailingAddressRequestType() {
        return new LegalEntityModifyMailingAddressRequestType();
    }

    /**
     * Create an instance of {@link PrivatePersonWritableType }
     *
     */
    public PrivatePersonWritableType createPrivatePersonWritableType() {
        return new PrivatePersonWritableType();
    }

    /**
     * Create an instance of {@link PrivatePersonCreateType }
     *
     */
    public PrivatePersonCreateType createPrivatePersonCreateType() {
        return new PrivatePersonCreateType();
    }

    /**
     * Create an instance of {@link PublicLawBodyWritableType }
     *
     */
    public PublicLawBodyWritableType createPublicLawBodyWritableType() {
        return new PublicLawBodyWritableType();
    }

    /**
     * Create an instance of {@link PublicLawBodyCreateType }
     *
     */
    public PublicLawBodyCreateType createPublicLawBodyCreateType() {
        return new PublicLawBodyCreateType();
    }

    /**
     * Create an instance of {@link PrivateLawBodyWritableType }
     *
     */
    public PrivateLawBodyWritableType createPrivateLawBodyWritableType() {
        return new PrivateLawBodyWritableType();
    }

    /**
     * Create an instance of {@link PrivateLawBodyCreateType }
     *
     */
    public PrivateLawBodyCreateType createPrivateLawBodyCreateType() {
        return new PrivateLawBodyCreateType();
    }

    /**
     * Create an instance of {@link StaffMemberWritableType }
     *
     */
    public StaffMemberWritableType createStaffMemberWritableType() {
        return new StaffMemberWritableType();
    }

    /**
     * Create an instance of {@link StaffMemberCreateType }
     *
     */
    public StaffMemberCreateType createStaffMemberCreateType() {
        return new StaffMemberCreateType();
    }

    /**
     * Create an instance of {@link EuropeanParliamentMemberWritableType }
     *
     */
    public EuropeanParliamentMemberWritableType createEuropeanParliamentMemberWritableType() {
        return new EuropeanParliamentMemberWritableType();
    }

    /**
     * Create an instance of {@link EuropeanParliamentMemberCreateType }
     *
     */
    public EuropeanParliamentMemberCreateType createEuropeanParliamentMemberCreateType() {
        return new EuropeanParliamentMemberCreateType();
    }

    /**
     * Create an instance of {@link ExStaffMemberWritableType }
     *
     */
    public ExStaffMemberWritableType createExStaffMemberWritableType() {
        return new ExStaffMemberWritableType();
    }

    /**
     * Create an instance of {@link ExStaffMemberCreateType }
     *
     */
    public ExStaffMemberCreateType createExStaffMemberCreateType() {
        return new ExStaffMemberCreateType();
    }

    /**
     * Create an instance of {@link IdentificationDocumentType }
     *
     */
    public IdentificationDocumentType createIdentificationDocumentType() {
        return new IdentificationDocumentType();
    }

    /**
     * Create an instance of {@link RegistrationInfoType }
     *
     */
    public RegistrationInfoType createRegistrationInfoType() {
        return new RegistrationInfoType();
    }

    /**
     * Create an instance of {@link MailingAddressType }
     *
     */
    public MailingAddressType createMailingAddressType() {
        return new MailingAddressType();
    }

    /**
     * Create an instance of {@link LegalEntitySearchCriteriaType }
     *
     */
    public LegalEntitySearchCriteriaType createLegalEntitySearchCriteriaType() {
        return new LegalEntitySearchCriteriaType();
    }

    /**
     * Create an instance of {@link NaturalPersonSearchType.Title }
     *
     */
    public NaturalPersonSearchType.Title createNaturalPersonSearchTypeTitle() {
        return new NaturalPersonSearchType.Title();
    }

    /**
     * Create an instance of {@link LegalEntityGetType.MailingAddresses }
     *
     */
    public LegalEntityGetType.MailingAddresses createLegalEntityGetTypeMailingAddresses() {
        return new LegalEntityGetType.MailingAddresses();
    }

    /**
     * Create an instance of {@link LegalEntityGetType.LegalEntityBankAccountLinks.LegalEntityBankAccountLink }
     *
     */
    public LegalEntityGetType.LegalEntityBankAccountLinks.LegalEntityBankAccountLink createLegalEntityGetTypeLegalEntityBankAccountLinksLegalEntityBankAccountLink() {
        return new LegalEntityGetType.LegalEntityBankAccountLinks.LegalEntityBankAccountLink();
    }

    /**
     * Create an instance of {@link NaturalPersonGetType.Title }
     *
     */
    public NaturalPersonGetType.Title createNaturalPersonGetTypeTitle() {
        return new NaturalPersonGetType.Title();
    }

    /**
     * Create an instance of {@link LegalEntityCreateType.MailingAddresses }
     *
     */
    public LegalEntityCreateType.MailingAddresses createLegalEntityCreateTypeMailingAddresses() {
        return new LegalEntityCreateType.MailingAddresses();
    }

    /**
     * Create an instance of {@link NaturalPersonCreateType.Title }
     *
     */
    public NaturalPersonCreateType.Title createNaturalPersonCreateTypeTitle() {
        return new NaturalPersonCreateType.Title();
    }

    /**
     * Create an instance of {@link LegalEntityCreateType.LegalEntityBankAccountLinks.LegalEntityBankAccountLink }
     *
     */
    public LegalEntityCreateType.LegalEntityBankAccountLinks.LegalEntityBankAccountLink createLegalEntityCreateTypeLegalEntityBankAccountLinksLegalEntityBankAccountLink() {
        return new LegalEntityCreateType.LegalEntityBankAccountLinks.LegalEntityBankAccountLink();
    }

    /**
     * Create an instance of {@link NaturalPersonWritableType.Title }
     *
     */
    public NaturalPersonWritableType.Title createNaturalPersonWritableTypeTitle() {
        return new NaturalPersonWritableType.Title();
    }

    /**
     * Create an instance of {@link LegalEntityModifyBankAccountRequestType.LegalEntityBankAccountLink }
     *
     */
    public LegalEntityModifyBankAccountRequestType.LegalEntityBankAccountLink createLegalEntityModifyBankAccountRequestTypeLegalEntityBankAccountLink() {
        return new LegalEntityModifyBankAccountRequestType.LegalEntityBankAccountLink();
    }

    /**
     * Create an instance of {@link LegalEntityCheckDuplicateResponseType.Result }
     *
     */
    public LegalEntityCheckDuplicateResponseType.Result createLegalEntityCheckDuplicateResponseTypeResult() {
        return new LegalEntityCheckDuplicateResponseType.Result();
    }

    /**
     * Create an instance of {@link LegalEntityCreateBankAccountRequestType.LegalEntityBankAccountLink }
     *
     */
    public LegalEntityCreateBankAccountRequestType.LegalEntityBankAccountLink createLegalEntityCreateBankAccountRequestTypeLegalEntityBankAccountLink() {
        return new LegalEntityCreateBankAccountRequestType.LegalEntityBankAccountLink();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityGetRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityGetRequest")
    public JAXBElement<LegalEntityGetRequestType> createLegalEntityGetRequest(LegalEntityGetRequestType value) {
        return new JAXBElement<LegalEntityGetRequestType>(_LegalEntityGetRequest_QNAME, LegalEntityGetRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityGetResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityGetResponse")
    public JAXBElement<LegalEntityGetResponseType> createLegalEntityGetResponse(LegalEntityGetResponseType value) {
        return new JAXBElement<LegalEntityGetResponseType>(_LegalEntityGetResponse_QNAME, LegalEntityGetResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EuropeanParliamentMemberGetType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "EuropeanParliamentMember")
    public JAXBElement<EuropeanParliamentMemberGetType> createEuropeanParliamentMember(EuropeanParliamentMemberGetType value) {
        return new JAXBElement<EuropeanParliamentMemberGetType>(_EuropeanParliamentMember_QNAME, EuropeanParliamentMemberGetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExStaffMemberGetType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "ExStaffMember")
    public JAXBElement<ExStaffMemberGetType> createExStaffMember(ExStaffMemberGetType value) {
        return new JAXBElement<ExStaffMemberGetType>(_ExStaffMember_QNAME, ExStaffMemberGetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrivatePersonGetType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "PrivatePerson")
    public JAXBElement<PrivatePersonGetType> createPrivatePerson(PrivatePersonGetType value) {
        return new JAXBElement<PrivatePersonGetType>(_PrivatePerson_QNAME, PrivatePersonGetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicLawBodyGetType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "PublicLawBody")
    public JAXBElement<PublicLawBodyGetType> createPublicLawBody(PublicLawBodyGetType value) {
        return new JAXBElement<PublicLawBodyGetType>(_PublicLawBody_QNAME, PublicLawBodyGetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrivateLawBodyGetType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "PrivateLawBody")
    public JAXBElement<PrivateLawBodyGetType> createPrivateLawBody(PrivateLawBodyGetType value) {
        return new JAXBElement<PrivateLawBodyGetType>(_PrivateLawBody_QNAME, PrivateLawBodyGetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StaffMemberGetType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "StaffMember")
    public JAXBElement<StaffMemberGetType> createStaffMember(StaffMemberGetType value) {
        return new JAXBElement<StaffMemberGetType>(_StaffMember_QNAME, StaffMemberGetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TechnicalLegalEntityGetType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "TechnicalLegalEntity")
    public JAXBElement<TechnicalLegalEntityGetType> createTechnicalLegalEntity(TechnicalLegalEntityGetType value) {
        return new JAXBElement<TechnicalLegalEntityGetType>(_TechnicalLegalEntity_QNAME, TechnicalLegalEntityGetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCreateRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateRequest")
    public JAXBElement<LegalEntityCreateRequestType> createLegalEntityCreateRequest(LegalEntityCreateRequestType value) {
        return new JAXBElement<LegalEntityCreateRequestType>(_LegalEntityCreateRequest_QNAME, LegalEntityCreateRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityCreateResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityCreateResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCreateAresDocumentRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateAresDocumentRequest")
    public JAXBElement<LegalEntityCreateAresDocumentRequestType> createLegalEntityCreateAresDocumentRequest(LegalEntityCreateAresDocumentRequestType value) {
        return new JAXBElement<LegalEntityCreateAresDocumentRequestType>(_LegalEntityCreateAresDocumentRequest_QNAME, LegalEntityCreateAresDocumentRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateAresDocumentResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityCreateAresDocumentResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityCreateAresDocumentResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCreateBankAccountRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateBankAccountRequest")
    public JAXBElement<LegalEntityCreateBankAccountRequestType> createLegalEntityCreateBankAccountRequest(LegalEntityCreateBankAccountRequestType value) {
        return new JAXBElement<LegalEntityCreateBankAccountRequestType>(_LegalEntityCreateBankAccountRequest_QNAME, LegalEntityCreateBankAccountRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateBankAccountResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityCreateBankAccountResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityCreateBankAccountResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCreateMailingAddressRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateMailingAddressRequest")
    public JAXBElement<LegalEntityCreateMailingAddressRequestType> createLegalEntityCreateMailingAddressRequest(LegalEntityCreateMailingAddressRequestType value) {
        return new JAXBElement<LegalEntityCreateMailingAddressRequestType>(_LegalEntityCreateMailingAddressRequest_QNAME, LegalEntityCreateMailingAddressRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateMailingAddressResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityCreateMailingAddressResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityCreateMailingAddressResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCreateResponsibleUserRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateResponsibleUserRequest")
    public JAXBElement<LegalEntityCreateResponsibleUserRequestType> createLegalEntityCreateResponsibleUserRequest(LegalEntityCreateResponsibleUserRequestType value) {
        return new JAXBElement<LegalEntityCreateResponsibleUserRequestType>(_LegalEntityCreateResponsibleUserRequest_QNAME, LegalEntityCreateResponsibleUserRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateResponsibleUserResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityCreateResponsibleUserResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityCreateResponsibleUserResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCreateScannedDocumentRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateScannedDocumentRequest")
    public JAXBElement<LegalEntityCreateScannedDocumentRequestType> createLegalEntityCreateScannedDocumentRequest(LegalEntityCreateScannedDocumentRequestType value) {
        return new JAXBElement<LegalEntityCreateScannedDocumentRequestType>(_LegalEntityCreateScannedDocumentRequest_QNAME, LegalEntityCreateScannedDocumentRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCreateScannedDocumentResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityCreateScannedDocumentResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityCreateScannedDocumentResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCheckCreateRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCheckCreateRequest")
    public JAXBElement<LegalEntityCheckCreateRequestType> createLegalEntityCheckCreateRequest(LegalEntityCheckCreateRequestType value) {
        return new JAXBElement<LegalEntityCheckCreateRequestType>(_LegalEntityCheckCreateRequest_QNAME, LegalEntityCheckCreateRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCheckCreateResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityCheckCreateResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityCheckCreateResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntitySearchRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntitySearchRequest")
    public JAXBElement<LegalEntitySearchRequestType> createLegalEntitySearchRequest(LegalEntitySearchRequestType value) {
        return new JAXBElement<LegalEntitySearchRequestType>(_LegalEntitySearchRequest_QNAME, LegalEntitySearchRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntitySearchResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntitySearchResponse")
    public JAXBElement<LegalEntitySearchResponseType> createLegalEntitySearchResponse(LegalEntitySearchResponseType value) {
        return new JAXBElement<LegalEntitySearchResponseType>(_LegalEntitySearchResponse_QNAME, LegalEntitySearchResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrivatePersonSearchType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "PrivatePersonSearch")
    public JAXBElement<PrivatePersonSearchType> createPrivatePersonSearch(PrivatePersonSearchType value) {
        return new JAXBElement<PrivatePersonSearchType>(_PrivatePersonSearch_QNAME, PrivatePersonSearchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StaffMemberSearchType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "StaffMemberSearch")
    public JAXBElement<StaffMemberSearchType> createStaffMemberSearch(StaffMemberSearchType value) {
        return new JAXBElement<StaffMemberSearchType>(_StaffMemberSearch_QNAME, StaffMemberSearchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExStaffMemberSearchType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "ExStaffMemberSearch")
    public JAXBElement<ExStaffMemberSearchType> createExStaffMemberSearch(ExStaffMemberSearchType value) {
        return new JAXBElement<ExStaffMemberSearchType>(_ExStaffMemberSearch_QNAME, ExStaffMemberSearchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EuropeanParliamentMemberSearchType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "EuropeanParliamentMemberSearch")
    public JAXBElement<EuropeanParliamentMemberSearchType> createEuropeanParliamentMemberSearch(EuropeanParliamentMemberSearchType value) {
        return new JAXBElement<EuropeanParliamentMemberSearchType>(_EuropeanParliamentMemberSearch_QNAME, EuropeanParliamentMemberSearchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicLawBodySearchType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "PublicLawBodySearch")
    public JAXBElement<PublicLawBodySearchType> createPublicLawBodySearch(PublicLawBodySearchType value) {
        return new JAXBElement<PublicLawBodySearchType>(_PublicLawBodySearch_QNAME, PublicLawBodySearchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrivateLawBodySearchType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "PrivateLawBodySearch")
    public JAXBElement<PrivateLawBodySearchType> createPrivateLawBodySearch(PrivateLawBodySearchType value) {
        return new JAXBElement<PrivateLawBodySearchType>(_PrivateLawBodySearch_QNAME, PrivateLawBodySearchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TechnicalLegalEntitySearchType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "TechnicalLegalEntitySearch")
    public JAXBElement<TechnicalLegalEntitySearchType> createTechnicalLegalEntitySearch(TechnicalLegalEntitySearchType value) {
        return new JAXBElement<TechnicalLegalEntitySearchType>(_TechnicalLegalEntitySearch_QNAME, TechnicalLegalEntitySearchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCheckDuplicateRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCheckDuplicateRequest")
    public JAXBElement<LegalEntityCheckDuplicateRequestType> createLegalEntityCheckDuplicateRequest(LegalEntityCheckDuplicateRequestType value) {
        return new JAXBElement<LegalEntityCheckDuplicateRequestType>(_LegalEntityCheckDuplicateRequest_QNAME, LegalEntityCheckDuplicateRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCheckDuplicateResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCheckDuplicateResponse")
    public JAXBElement<LegalEntityCheckDuplicateResponseType> createLegalEntityCheckDuplicateResponse(LegalEntityCheckDuplicateResponseType value) {
        return new JAXBElement<LegalEntityCheckDuplicateResponseType>(_LegalEntityCheckDuplicateResponse_QNAME, LegalEntityCheckDuplicateResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityCheckModifyRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCheckModifyRequest")
    public JAXBElement<LegalEntityCheckModifyRequestType> createLegalEntityCheckModifyRequest(LegalEntityCheckModifyRequestType value) {
        return new JAXBElement<LegalEntityCheckModifyRequestType>(_LegalEntityCheckModifyRequest_QNAME, LegalEntityCheckModifyRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityCheckModifyResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityCheckModifyResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityCheckModifyResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityModifyBankAccountRequestType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityModifyBankAccountRequest")
    public JAXBElement<LegalEntityModifyBankAccountRequestType> createLegalEntityModifyBankAccountRequest(LegalEntityModifyBankAccountRequestType value) {
        return new JAXBElement<LegalEntityModifyBankAccountRequestType>(_LegalEntityModifyBankAccountRequest_QNAME, LegalEntityModifyBankAccountRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityModifyBankAccountResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityModifyBankAccountResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityModifyBankAccountResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LegalEntityModifyMailingAddressRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityModifyMailingAddressRequest")
    public JAXBElement<LegalEntityModifyMailingAddressRequestType> createLegalEntityModifyMailingAddressRequest(LegalEntityModifyMailingAddressRequestType value) {
        return new JAXBElement<LegalEntityModifyMailingAddressRequestType>(_LegalEntityModifyMailingAddressRequest_QNAME, LegalEntityModifyMailingAddressRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessRuleMessageResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ec.europa.eu/budg/abac/legal_entity/v2", name = "LegalEntityModifyMailingAddressResponse")
    public JAXBElement<BusinessRuleMessageResponseType> createLegalEntityModifyMailingAddressResponse(BusinessRuleMessageResponseType value) {
        return new JAXBElement<BusinessRuleMessageResponseType>(_LegalEntityModifyMailingAddressResponse_QNAME, BusinessRuleMessageResponseType.class, null, value);
    }

}
