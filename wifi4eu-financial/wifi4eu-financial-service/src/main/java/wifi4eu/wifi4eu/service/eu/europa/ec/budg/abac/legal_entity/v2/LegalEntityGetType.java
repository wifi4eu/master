
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.address.v1.LegalEntityAddressType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.ares_document.v1.AresDocumentsType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.complex_type.v1.AuditInfoType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.early_warning.v1.EarlyWarningType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.organisation.v1.ResponsibleOrganisationType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.responsible_user.v1.ResponsibleUsersType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.scanned_document.v1.ScannedDocumentsWithoutContentType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.supporting_document.v1.SupportingDocumentFolderType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.workflow_object.v1.WorkflowInfoType;


/**
 * <p>Clase Java para LegalEntityGetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityGetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountGroupCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}AccountGroupCodeType" minOccurs="0"/&gt;
 *         &lt;element name="AuditInfo" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}AuditInfoType"/&gt;
 *         &lt;element name="BlockingCode" type="{http://www.ec.europa.eu/budg/abac/third_party/v1}BlockingCodeType" minOccurs="0"/&gt;
 *         &lt;element name="DeleteFlag" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}DeleteFlagType"/&gt;
 *         &lt;element name="DuplicateCheckBypassFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="DuplicateCheckReliabilityPct" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}DuplicateCheckReliabilityPctType" minOccurs="0"/&gt;
 *         &lt;element name="DuplicateCheckSimilarityPct" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}DuplicateCheckSimilarityPctType" minOccurs="0"/&gt;
 *         &lt;element name="DuplicateCheckLastExecution" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}DuplicateCheckLastExecutionType" minOccurs="0"/&gt;
 *         &lt;element name="ExpiryDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="IsACustomerOnly" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}IsACustomerOnlyType"/&gt;
 *         &lt;element name="LanguageCode" type="{http://www.ec.europa.eu/budg/abac/language/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="LastValidationType" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LastValidationTypeType" minOccurs="0"/&gt;
 *         &lt;element name="LightValidationFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="LightValidationContext" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LightValidationContextType" minOccurs="0"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}RemarksType" minOccurs="0"/&gt;
 *         &lt;element name="MailingAddressOption" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}MailingAddressOptionType"/&gt;
 *         &lt;element name="OfficialName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}OfficialNameType"/&gt;
 *         &lt;element name="OfficialName2" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}OfficialName2Type" minOccurs="0"/&gt;
 *         &lt;element name="OfficialName3" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}OfficialName3Type" minOccurs="0"/&gt;
 *         &lt;element name="OfficialAddress" type="{http://www.ec.europa.eu/budg/abac/address/v1}LegalEntityAddressType"/&gt;
 *         &lt;element name="OriginalLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}ResponsibleOrganisationType" minOccurs="0"/&gt;
 *         &lt;element name="WorkflowInfo" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowInfoType" minOccurs="0"/&gt;
 *         &lt;element name="AresDocuments" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentsType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetCompanyCode" type="{http://www.ec.europa.eu/budg/abac/abac_object/v1}BudgetCompanyCodeType"/&gt;
 *         &lt;element name="EarlyWarning" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}EarlyWarningType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="LegalEntityBankAccountLinks" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="LegalEntityBankAccountLink" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="BankAccountLocalKey" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}LocalKeyType"/&gt;
 *                             &lt;element name="StatusCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity_bank_account_link/v1}StatusCodeType"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;element name="MailingAddresses" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MailingAddress" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}MailingAddressType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ResponsibleUsers" type="{http://www.ec.europa.eu/budg/abac/responsible_user/v1}ResponsibleUsersType" minOccurs="0"/&gt;
 *         &lt;element name="ScannedDocuments" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ScannedDocumentsWithoutContentType" minOccurs="0"/&gt;
 *         &lt;element name="SupportingDocumentFolder" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}SupportingDocumentFolderType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityGetType", propOrder = {
    "accountGroupCode",
    "auditInfo",
    "blockingCode",
    "deleteFlag",
    "duplicateCheckBypassFlag",
    "duplicateCheckReliabilityPct",
    "duplicateCheckSimilarityPct",
    "duplicateCheckLastExecution",
    "expiryDate",
    "isACustomerOnly",
    "languageCode",
    "lastValidationType",
    "lightValidationFlag",
    "lightValidationContext",
    "localKey",
    "remarks",
    "mailingAddressOption",
    "officialName",
    "officialName2",
    "officialName3",
    "officialAddress",
    "originalLocalKey",
    "responsibleOrganisation",
    "workflowInfo",
    "aresDocuments",
    "budgetCompanyCode",
    "earlyWarning",
    "legalEntityBankAccountLinks",
    "localSystemCode",
    "mailingAddresses",
    "responsibleUsers",
    "scannedDocuments",
    "supportingDocumentFolder"
})
@XmlSeeAlso({
    TechnicalLegalEntityGetType.class,
    NaturalPersonGetType.class,
    PublicPrivateLawBodyGetType.class
})
public abstract class LegalEntityGetType {

    @XmlElement(name = "AccountGroupCode")
    protected String accountGroupCode;
    @XmlElement(name = "AuditInfo", required = true)
    protected AuditInfoType auditInfo;
    @XmlElement(name = "BlockingCode")
    protected String blockingCode;
    @XmlElement(name = "DeleteFlag")
    protected boolean deleteFlag;
    @XmlElement(name = "DuplicateCheckBypassFlag")
    protected Boolean duplicateCheckBypassFlag;
    @XmlElement(name = "DuplicateCheckReliabilityPct")
    protected BigDecimal duplicateCheckReliabilityPct;
    @XmlElement(name = "DuplicateCheckSimilarityPct")
    protected BigDecimal duplicateCheckSimilarityPct;
    @XmlElement(name = "DuplicateCheckLastExecution")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar duplicateCheckLastExecution;
    @XmlElement(name = "ExpiryDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expiryDate;
    @XmlElement(name = "IsACustomerOnly")
    protected boolean isACustomerOnly;
    @XmlElement(name = "LanguageCode")
    protected String languageCode;
    @XmlElement(name = "LastValidationType")
    protected String lastValidationType;
    @XmlElement(name = "LightValidationFlag")
    protected Boolean lightValidationFlag;
    @XmlElement(name = "LightValidationContext")
    protected String lightValidationContext;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "MailingAddressOption", required = true)
    protected String mailingAddressOption;
    @XmlElement(name = "OfficialName", required = true)
    protected String officialName;
    @XmlElement(name = "OfficialName2")
    protected String officialName2;
    @XmlElement(name = "OfficialName3")
    protected String officialName3;
    @XmlElement(name = "OfficialAddress", required = true)
    protected LegalEntityAddressType officialAddress;
    @XmlElement(name = "OriginalLocalKey")
    protected String originalLocalKey;
    @XmlElement(name = "ResponsibleOrganisation")
    protected ResponsibleOrganisationType responsibleOrganisation;
    @XmlElement(name = "WorkflowInfo")
    protected WorkflowInfoType workflowInfo;
    @XmlElement(name = "AresDocuments")
    protected AresDocumentsType aresDocuments;
    @XmlElement(name = "BudgetCompanyCode", required = true)
    protected String budgetCompanyCode;
    @XmlElement(name = "EarlyWarning")
    protected List<EarlyWarningType> earlyWarning;
    @XmlElement(name = "LegalEntityBankAccountLinks")
    protected LegalEntityBankAccountLinks legalEntityBankAccountLinks;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "MailingAddresses")
    protected MailingAddresses mailingAddresses;
    @XmlElement(name = "ResponsibleUsers")
    protected ResponsibleUsersType responsibleUsers;
    @XmlElement(name = "ScannedDocuments")
    protected ScannedDocumentsWithoutContentType scannedDocuments;
    @XmlElement(name = "SupportingDocumentFolder")
    protected SupportingDocumentFolderType supportingDocumentFolder;

    /**
     * Obtiene el valor de la propiedad accountGroupCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountGroupCode() {
        return accountGroupCode;
    }

    /**
     * Define el valor de la propiedad accountGroupCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountGroupCode(String value) {
        this.accountGroupCode = value;
    }

    /**
     * Obtiene el valor de la propiedad auditInfo.
     * 
     * @return
     *     possible object is
     *     {@link AuditInfoType }
     *     
     */
    public AuditInfoType getAuditInfo() {
        return auditInfo;
    }

    /**
     * Define el valor de la propiedad auditInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditInfoType }
     *     
     */
    public void setAuditInfo(AuditInfoType value) {
        this.auditInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad blockingCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockingCode() {
        return blockingCode;
    }

    /**
     * Define el valor de la propiedad blockingCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockingCode(String value) {
        this.blockingCode = value;
    }

    /**
     * Obtiene el valor de la propiedad deleteFlag.
     * 
     */
    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    /**
     * Define el valor de la propiedad deleteFlag.
     * 
     */
    public void setDeleteFlag(boolean value) {
        this.deleteFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad duplicateCheckBypassFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDuplicateCheckBypassFlag() {
        return duplicateCheckBypassFlag;
    }

    /**
     * Define el valor de la propiedad duplicateCheckBypassFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDuplicateCheckBypassFlag(Boolean value) {
        this.duplicateCheckBypassFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad duplicateCheckReliabilityPct.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDuplicateCheckReliabilityPct() {
        return duplicateCheckReliabilityPct;
    }

    /**
     * Define el valor de la propiedad duplicateCheckReliabilityPct.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDuplicateCheckReliabilityPct(BigDecimal value) {
        this.duplicateCheckReliabilityPct = value;
    }

    /**
     * Obtiene el valor de la propiedad duplicateCheckSimilarityPct.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDuplicateCheckSimilarityPct() {
        return duplicateCheckSimilarityPct;
    }

    /**
     * Define el valor de la propiedad duplicateCheckSimilarityPct.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDuplicateCheckSimilarityPct(BigDecimal value) {
        this.duplicateCheckSimilarityPct = value;
    }

    /**
     * Obtiene el valor de la propiedad duplicateCheckLastExecution.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDuplicateCheckLastExecution() {
        return duplicateCheckLastExecution;
    }

    /**
     * Define el valor de la propiedad duplicateCheckLastExecution.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDuplicateCheckLastExecution(XMLGregorianCalendar value) {
        this.duplicateCheckLastExecution = value;
    }

    /**
     * Obtiene el valor de la propiedad expiryDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Define el valor de la propiedad expiryDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * Obtiene el valor de la propiedad isACustomerOnly.
     * 
     */
    public boolean isIsACustomerOnly() {
        return isACustomerOnly;
    }

    /**
     * Define el valor de la propiedad isACustomerOnly.
     * 
     */
    public void setIsACustomerOnly(boolean value) {
        this.isACustomerOnly = value;
    }

    /**
     * Obtiene el valor de la propiedad languageCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Define el valor de la propiedad languageCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageCode(String value) {
        this.languageCode = value;
    }

    /**
     * Obtiene el valor de la propiedad lastValidationType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastValidationType() {
        return lastValidationType;
    }

    /**
     * Define el valor de la propiedad lastValidationType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastValidationType(String value) {
        this.lastValidationType = value;
    }

    /**
     * Obtiene el valor de la propiedad lightValidationFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLightValidationFlag() {
        return lightValidationFlag;
    }

    /**
     * Define el valor de la propiedad lightValidationFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLightValidationFlag(Boolean value) {
        this.lightValidationFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad lightValidationContext.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLightValidationContext() {
        return lightValidationContext;
    }

    /**
     * Define el valor de la propiedad lightValidationContext.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLightValidationContext(String value) {
        this.lightValidationContext = value;
    }

    /**
     * Obtiene el valor de la propiedad localKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalKey() {
        return localKey;
    }

    /**
     * Define el valor de la propiedad localKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalKey(String value) {
        this.localKey = value;
    }

    /**
     * Obtiene el valor de la propiedad remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define el valor de la propiedad remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Obtiene el valor de la propiedad mailingAddressOption.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailingAddressOption() {
        return mailingAddressOption;
    }

    /**
     * Define el valor de la propiedad mailingAddressOption.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailingAddressOption(String value) {
        this.mailingAddressOption = value;
    }

    /**
     * Obtiene el valor de la propiedad officialName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficialName() {
        return officialName;
    }

    /**
     * Define el valor de la propiedad officialName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficialName(String value) {
        this.officialName = value;
    }

    /**
     * Obtiene el valor de la propiedad officialName2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficialName2() {
        return officialName2;
    }

    /**
     * Define el valor de la propiedad officialName2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficialName2(String value) {
        this.officialName2 = value;
    }

    /**
     * Obtiene el valor de la propiedad officialName3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficialName3() {
        return officialName3;
    }

    /**
     * Define el valor de la propiedad officialName3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficialName3(String value) {
        this.officialName3 = value;
    }

    /**
     * Obtiene el valor de la propiedad officialAddress.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityAddressType }
     *     
     */
    public LegalEntityAddressType getOfficialAddress() {
        return officialAddress;
    }

    /**
     * Define el valor de la propiedad officialAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityAddressType }
     *     
     */
    public void setOfficialAddress(LegalEntityAddressType value) {
        this.officialAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad originalLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalLocalKey() {
        return originalLocalKey;
    }

    /**
     * Define el valor de la propiedad originalLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalLocalKey(String value) {
        this.originalLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleOrganisation.
     * 
     * @return
     *     possible object is
     *     {@link ResponsibleOrganisationType }
     *     
     */
    public ResponsibleOrganisationType getResponsibleOrganisation() {
        return responsibleOrganisation;
    }

    /**
     * Define el valor de la propiedad responsibleOrganisation.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsibleOrganisationType }
     *     
     */
    public void setResponsibleOrganisation(ResponsibleOrganisationType value) {
        this.responsibleOrganisation = value;
    }

    /**
     * Obtiene el valor de la propiedad workflowInfo.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowInfoType }
     *     
     */
    public WorkflowInfoType getWorkflowInfo() {
        return workflowInfo;
    }

    /**
     * Define el valor de la propiedad workflowInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowInfoType }
     *     
     */
    public void setWorkflowInfo(WorkflowInfoType value) {
        this.workflowInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad aresDocuments.
     * 
     * @return
     *     possible object is
     *     {@link AresDocumentsType }
     *     
     */
    public AresDocumentsType getAresDocuments() {
        return aresDocuments;
    }

    /**
     * Define el valor de la propiedad aresDocuments.
     * 
     * @param value
     *     allowed object is
     *     {@link AresDocumentsType }
     *     
     */
    public void setAresDocuments(AresDocumentsType value) {
        this.aresDocuments = value;
    }

    /**
     * Obtiene el valor de la propiedad budgetCompanyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetCompanyCode() {
        return budgetCompanyCode;
    }

    /**
     * Define el valor de la propiedad budgetCompanyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetCompanyCode(String value) {
        this.budgetCompanyCode = value;
    }

    /**
     * Gets the value of the earlyWarning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the earlyWarning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEarlyWarning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EarlyWarningType }
     * 
     * 
     */
    public List<EarlyWarningType> getEarlyWarning() {
        if (earlyWarning == null) {
            earlyWarning = new ArrayList<EarlyWarningType>();
        }
        return this.earlyWarning;
    }

    /**
     * Obtiene el valor de la propiedad legalEntityBankAccountLinks.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityBankAccountLinks }
     *     
     */
    public LegalEntityBankAccountLinks getLegalEntityBankAccountLinks() {
        return legalEntityBankAccountLinks;
    }

    /**
     * Define el valor de la propiedad legalEntityBankAccountLinks.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityBankAccountLinks }
     *     
     */
    public void setLegalEntityBankAccountLinks(LegalEntityBankAccountLinks value) {
        this.legalEntityBankAccountLinks = value;
    }

    /**
     * Obtiene el valor de la propiedad localSystemCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalSystemCode() {
        return localSystemCode;
    }

    /**
     * Define el valor de la propiedad localSystemCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalSystemCode(String value) {
        this.localSystemCode = value;
    }

    /**
     * Obtiene el valor de la propiedad mailingAddresses.
     * 
     * @return
     *     possible object is
     *     {@link MailingAddresses }
     *     
     */
    public MailingAddresses getMailingAddresses() {
        return mailingAddresses;
    }

    /**
     * Define el valor de la propiedad mailingAddresses.
     * 
     * @param value
     *     allowed object is
     *     {@link MailingAddresses }
     *     
     */
    public void setMailingAddresses(MailingAddresses value) {
        this.mailingAddresses = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleUsers.
     * 
     * @return
     *     possible object is
     *     {@link ResponsibleUsersType }
     *     
     */
    public ResponsibleUsersType getResponsibleUsers() {
        return responsibleUsers;
    }

    /**
     * Define el valor de la propiedad responsibleUsers.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsibleUsersType }
     *     
     */
    public void setResponsibleUsers(ResponsibleUsersType value) {
        this.responsibleUsers = value;
    }

    /**
     * Obtiene el valor de la propiedad scannedDocuments.
     * 
     * @return
     *     possible object is
     *     {@link ScannedDocumentsWithoutContentType }
     *     
     */
    public ScannedDocumentsWithoutContentType getScannedDocuments() {
        return scannedDocuments;
    }

    /**
     * Define el valor de la propiedad scannedDocuments.
     * 
     * @param value
     *     allowed object is
     *     {@link ScannedDocumentsWithoutContentType }
     *     
     */
    public void setScannedDocuments(ScannedDocumentsWithoutContentType value) {
        this.scannedDocuments = value;
    }

    /**
     * Obtiene el valor de la propiedad supportingDocumentFolder.
     * 
     * @return
     *     possible object is
     *     {@link SupportingDocumentFolderType }
     *     
     */
    public SupportingDocumentFolderType getSupportingDocumentFolder() {
        return supportingDocumentFolder;
    }

    /**
     * Define el valor de la propiedad supportingDocumentFolder.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportingDocumentFolderType }
     *     
     */
    public void setSupportingDocumentFolder(SupportingDocumentFolderType value) {
        this.supportingDocumentFolder = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="LegalEntityBankAccountLink" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="BankAccountLocalKey" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}LocalKeyType"/&gt;
     *                   &lt;element name="StatusCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity_bank_account_link/v1}StatusCodeType"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "legalEntityBankAccountLink"
    })
    public static class LegalEntityBankAccountLinks {

        @XmlElement(name = "LegalEntityBankAccountLink")
        protected List<LegalEntityBankAccountLink> legalEntityBankAccountLink;

        /**
         * Gets the value of the legalEntityBankAccountLink property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the legalEntityBankAccountLink property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLegalEntityBankAccountLink().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LegalEntityBankAccountLink }
         * 
         * 
         */
        public List<LegalEntityBankAccountLink> getLegalEntityBankAccountLink() {
            if (legalEntityBankAccountLink == null) {
                legalEntityBankAccountLink = new ArrayList<LegalEntityBankAccountLink>();
            }
            return this.legalEntityBankAccountLink;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="BankAccountLocalKey" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}LocalKeyType"/&gt;
         *         &lt;element name="StatusCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity_bank_account_link/v1}StatusCodeType"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "bankAccountLocalKey",
            "statusCode"
        })
        public static class LegalEntityBankAccountLink {

            @XmlElement(name = "BankAccountLocalKey", required = true)
            protected String bankAccountLocalKey;
            @XmlElement(name = "StatusCode", required = true)
            protected String statusCode;

            /**
             * Obtiene el valor de la propiedad bankAccountLocalKey.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBankAccountLocalKey() {
                return bankAccountLocalKey;
            }

            /**
             * Define el valor de la propiedad bankAccountLocalKey.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBankAccountLocalKey(String value) {
                this.bankAccountLocalKey = value;
            }

            /**
             * Obtiene el valor de la propiedad statusCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStatusCode() {
                return statusCode;
            }

            /**
             * Define el valor de la propiedad statusCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStatusCode(String value) {
                this.statusCode = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="MailingAddress" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}MailingAddressType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mailingAddress"
    })
    public static class MailingAddresses {

        @XmlElement(name = "MailingAddress")
        protected List<MailingAddressType> mailingAddress;

        /**
         * Gets the value of the mailingAddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mailingAddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMailingAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MailingAddressType }
         * 
         * 
         */
        public List<MailingAddressType> getMailingAddress() {
            if (mailingAddress == null) {
                mailingAddress = new ArrayList<MailingAddressType>();
            }
            return this.mailingAddress;
        }

    }

}
