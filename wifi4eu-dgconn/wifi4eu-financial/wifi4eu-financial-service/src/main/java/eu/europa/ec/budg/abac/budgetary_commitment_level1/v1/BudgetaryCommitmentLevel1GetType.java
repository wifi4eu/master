
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import eu.europa.ec.budg.abac.ares_document.v1.AresDocumentsType;
import eu.europa.ec.budg.abac.complex_type.v1.AuditInfoType;
import eu.europa.ec.budg.abac.contractor_reference.v1.ContractorReferencesType;
import eu.europa.ec.budg.abac.external_criteria.v1.ExternalCriteriasType;
import eu.europa.ec.budg.abac.organisation.v1.ResponsibleOrganisationType;
import eu.europa.ec.budg.abac.responsible_user.v1.ResponsibleUsersType;
import eu.europa.ec.budg.abac.scanned_document.v1.ScannedDocumentsWithoutContentType;
import eu.europa.ec.budg.abac.supporting_document.v1.SupportingDocumentFolderType;
import eu.europa.ec.budg.abac.workflow_object.v1.WorkflowInfoType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel1GetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel1GetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AmountTotalAcceptedInEuro" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountTotalAcceptedInEuroType" minOccurs="0"/&gt;
 *         &lt;element name="AmountTotalAcceptedInCurrency" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountTotalAcceptedInCurrencyType" minOccurs="0"/&gt;
 *         &lt;element name="AmountTotalConsumedInEuro" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountTotalConsumedInEuroType" minOccurs="0"/&gt;
 *         &lt;element name="AmountTotalConsumedInCurrency" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountTotalConsumedInCurrencyType" minOccurs="0"/&gt;
 *         &lt;element name="AmountAcceptedInWorkflowInEuro" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountAcceptedInWorkflowInEuroType" minOccurs="0"/&gt;
 *         &lt;element name="AmountAcceptedInWorkflowInCurrency" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountAcceptedInWorkflowInCurrencyType" minOccurs="0"/&gt;
 *         &lt;element name="AmountConsumedInWorkflowInEuro" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountConsumedInWorkflowInEuroType" minOccurs="0"/&gt;
 *         &lt;element name="AmountConsumedInWorkflowInCurrency" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountConsumedInWorkflowInCurrencyType" minOccurs="0"/&gt;
 *         &lt;element name="AmountInEntryInEuro" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountInEntryInEuroType" minOccurs="0"/&gt;
 *         &lt;element name="AmountInEntryInCurrency" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountInEntryInCurrencyType" minOccurs="0"/&gt;
 *         &lt;element name="AmountOpenInEuro" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountOpenInEuroType" minOccurs="0"/&gt;
 *         &lt;element name="AmountOpenInCurrency" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AmountOpenInCurrencyType" minOccurs="0"/&gt;
 *         &lt;element name="AnnualInstallmentFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="AnnualInstallmentJustification" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AnnualInstallmentJustificationType" minOccurs="0"/&gt;
 *         &lt;element name="AuditInfo" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}AuditInfoType"/&gt;
 *         &lt;element name="BeneficiaryName" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BeneficiaryNameType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryContact" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BeneficiaryContactType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryStreet" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BeneficiaryStreetType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryPostCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BeneficiaryPostCodeType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryPostBox" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BeneficiaryPostBoxType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryCity" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BeneficiaryCityType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryCountryIso2Code" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BeneficiaryCountryIso2CodeType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryCounty" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BeneficiaryCountyType" minOccurs="0"/&gt;
 *         &lt;element name="ClassCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}ClassCodeType"/&gt;
 *         &lt;element name="CurrencyIso3Code" type="{http://www.ec.europa.eu/budg/abac/currency/v1}Iso3CodeType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentBudgetaryYear" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}CurrentBudgetYearType"/&gt;
 *         &lt;element name="ExternalActionFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="FileReference" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}FileReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="FinancialAgreement" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}FinancialAgreementType" minOccurs="0"/&gt;
 *         &lt;element name="FinancialAgreementConcludingFinalDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="FinancialAgreementImplementingFinalDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="FinancialAgreementSignedDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationCodeForNoFdcIlc" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationCodeForNoFdiFa" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="LegalJustificationCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}JustificationCodeType"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="Project" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}ProjectType" minOccurs="0"/&gt;
 *         &lt;element name="ProposedFdcDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="ProposedDcpFa" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}ProposedDcpFaType" minOccurs="0"/&gt;
 *         &lt;element name="ReferenceTreatyCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}ReferenceTreatyCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}RemarksType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}ResponsibleOrganisationType"/&gt;
 *         &lt;element name="StillToCoverInEuroAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="UserReference" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}UserReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="WorkflowInfo" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowInfoType" minOccurs="0"/&gt;
 *         &lt;element name="AresDocuments" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentsType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetCompanyCode" type="{http://www.ec.europa.eu/budg/abac/abac_object/v1}BudgetCompanyCodeType"/&gt;
 *         &lt;element name="CommitmentPositions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BudgetaryCommitmentLevel1Position" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BudgetaryCommitmentLevel1PositionGetType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ContractorReferences" type="{http://www.ec.europa.eu/budg/abac/contractor_reference/v1}ContractorReferencesType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriterias" type="{http://www.ec.europa.eu/budg/abac/external_criteria/v1}ExternalCriteriasType" minOccurs="0"/&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;element name="ResponsibleUsers" type="{http://www.ec.europa.eu/budg/abac/responsible_user/v1}ResponsibleUsersType" minOccurs="0"/&gt;
 *         &lt;element name="ScannedDocuments" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ScannedDocumentsWithoutContentType" minOccurs="0"/&gt;
 *         &lt;element name="SupportingDocumentFolder" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}SupportingDocumentFolderType" minOccurs="0"/&gt;
 *         &lt;element name="CommitmentL1Consumptions" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}CommitmentL1ConsumptionsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel1GetType", propOrder = {
    "amountTotalAcceptedInEuro",
    "amountTotalAcceptedInCurrency",
    "amountTotalConsumedInEuro",
    "amountTotalConsumedInCurrency",
    "amountAcceptedInWorkflowInEuro",
    "amountAcceptedInWorkflowInCurrency",
    "amountConsumedInWorkflowInEuro",
    "amountConsumedInWorkflowInCurrency",
    "amountInEntryInEuro",
    "amountInEntryInCurrency",
    "amountOpenInEuro",
    "amountOpenInCurrency",
    "annualInstallmentFlag",
    "annualInstallmentJustification",
    "auditInfo",
    "beneficiaryName",
    "beneficiaryContact",
    "beneficiaryStreet",
    "beneficiaryPostCode",
    "beneficiaryPostBox",
    "beneficiaryCity",
    "beneficiaryCountryIso2Code",
    "beneficiaryCounty",
    "classCode",
    "currencyIso3Code",
    "currentBudgetaryYear",
    "externalActionFlag",
    "fileReference",
    "financialAgreement",
    "financialAgreementConcludingFinalDate",
    "financialAgreementImplementingFinalDate",
    "financialAgreementSignedDate",
    "justificationCodeForNoFdcIlc",
    "justificationCodeForNoFdiFa",
    "legalJustificationCode",
    "localKey",
    "project",
    "proposedFdcDate",
    "proposedDcpFa",
    "referenceTreatyCode",
    "remarks",
    "responsibleOrganisation",
    "stillToCoverInEuroAmount",
    "userReference",
    "workflowInfo",
    "aresDocuments",
    "budgetCompanyCode",
    "commitmentPositions",
    "contractorReferences",
    "externalCriterias",
    "localSystemCode",
    "responsibleUsers",
    "scannedDocuments",
    "supportingDocumentFolder",
    "commitmentL1Consumptions"
})
public class BudgetaryCommitmentLevel1GetType {

    @XmlElement(name = "AmountTotalAcceptedInEuro")
    protected BigDecimal amountTotalAcceptedInEuro;
    @XmlElement(name = "AmountTotalAcceptedInCurrency")
    protected BigDecimal amountTotalAcceptedInCurrency;
    @XmlElement(name = "AmountTotalConsumedInEuro")
    protected BigDecimal amountTotalConsumedInEuro;
    @XmlElement(name = "AmountTotalConsumedInCurrency")
    protected BigDecimal amountTotalConsumedInCurrency;
    @XmlElement(name = "AmountAcceptedInWorkflowInEuro")
    protected BigDecimal amountAcceptedInWorkflowInEuro;
    @XmlElement(name = "AmountAcceptedInWorkflowInCurrency")
    protected BigDecimal amountAcceptedInWorkflowInCurrency;
    @XmlElement(name = "AmountConsumedInWorkflowInEuro")
    protected BigDecimal amountConsumedInWorkflowInEuro;
    @XmlElement(name = "AmountConsumedInWorkflowInCurrency")
    protected BigDecimal amountConsumedInWorkflowInCurrency;
    @XmlElement(name = "AmountInEntryInEuro")
    protected BigDecimal amountInEntryInEuro;
    @XmlElement(name = "AmountInEntryInCurrency")
    protected BigDecimal amountInEntryInCurrency;
    @XmlElement(name = "AmountOpenInEuro")
    protected BigDecimal amountOpenInEuro;
    @XmlElement(name = "AmountOpenInCurrency")
    protected BigDecimal amountOpenInCurrency;
    @XmlElement(name = "AnnualInstallmentFlag")
    protected Boolean annualInstallmentFlag;
    @XmlElement(name = "AnnualInstallmentJustification")
    protected String annualInstallmentJustification;
    @XmlElement(name = "AuditInfo", required = true)
    protected AuditInfoType auditInfo;
    @XmlElement(name = "BeneficiaryName")
    protected String beneficiaryName;
    @XmlElement(name = "BeneficiaryContact")
    protected String beneficiaryContact;
    @XmlElement(name = "BeneficiaryStreet")
    protected String beneficiaryStreet;
    @XmlElement(name = "BeneficiaryPostCode")
    protected String beneficiaryPostCode;
    @XmlElement(name = "BeneficiaryPostBox")
    protected String beneficiaryPostBox;
    @XmlElement(name = "BeneficiaryCity")
    protected String beneficiaryCity;
    @XmlElement(name = "BeneficiaryCountryIso2Code")
    protected String beneficiaryCountryIso2Code;
    @XmlElement(name = "BeneficiaryCounty")
    protected String beneficiaryCounty;
    @XmlElement(name = "ClassCode", required = true)
    protected String classCode;
    @XmlElement(name = "CurrencyIso3Code")
    protected String currencyIso3Code;
    @XmlElement(name = "CurrentBudgetaryYear", required = true)
    protected String currentBudgetaryYear;
    @XmlElement(name = "ExternalActionFlag")
    protected Boolean externalActionFlag;
    @XmlElement(name = "FileReference")
    protected String fileReference;
    @XmlElement(name = "FinancialAgreement")
    protected String financialAgreement;
    @XmlElement(name = "FinancialAgreementConcludingFinalDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar financialAgreementConcludingFinalDate;
    @XmlElement(name = "FinancialAgreementImplementingFinalDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar financialAgreementImplementingFinalDate;
    @XmlElement(name = "FinancialAgreementSignedDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar financialAgreementSignedDate;
    @XmlElement(name = "JustificationCodeForNoFdcIlc")
    protected String justificationCodeForNoFdcIlc;
    @XmlElement(name = "JustificationCodeForNoFdiFa")
    protected String justificationCodeForNoFdiFa;
    @XmlElement(name = "LegalJustificationCode", required = true)
    protected String legalJustificationCode;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "Project")
    protected String project;
    @XmlElement(name = "ProposedFdcDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar proposedFdcDate;
    @XmlElement(name = "ProposedDcpFa")
    protected Long proposedDcpFa;
    @XmlElement(name = "ReferenceTreatyCode")
    protected String referenceTreatyCode;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "ResponsibleOrganisation", required = true)
    protected ResponsibleOrganisationType responsibleOrganisation;
    @XmlElement(name = "StillToCoverInEuroAmount")
    protected BigDecimal stillToCoverInEuroAmount;
    @XmlElement(name = "UserReference")
    protected String userReference;
    @XmlElement(name = "WorkflowInfo")
    protected WorkflowInfoType workflowInfo;
    @XmlElement(name = "AresDocuments")
    protected AresDocumentsType aresDocuments;
    @XmlElement(name = "BudgetCompanyCode", required = true)
    protected String budgetCompanyCode;
    @XmlElement(name = "CommitmentPositions")
    protected BudgetaryCommitmentLevel1GetType.CommitmentPositions commitmentPositions;
    @XmlElement(name = "ContractorReferences")
    protected ContractorReferencesType contractorReferences;
    @XmlElement(name = "ExternalCriterias")
    protected ExternalCriteriasType externalCriterias;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "ResponsibleUsers")
    protected ResponsibleUsersType responsibleUsers;
    @XmlElement(name = "ScannedDocuments")
    protected ScannedDocumentsWithoutContentType scannedDocuments;
    @XmlElement(name = "SupportingDocumentFolder")
    protected SupportingDocumentFolderType supportingDocumentFolder;
    @XmlElement(name = "CommitmentL1Consumptions")
    protected CommitmentL1ConsumptionsType commitmentL1Consumptions;

    /**
     * Obtiene el valor de la propiedad amountTotalAcceptedInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountTotalAcceptedInEuro() {
        return amountTotalAcceptedInEuro;
    }

    /**
     * Define el valor de la propiedad amountTotalAcceptedInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountTotalAcceptedInEuro(BigDecimal value) {
        this.amountTotalAcceptedInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountTotalAcceptedInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountTotalAcceptedInCurrency() {
        return amountTotalAcceptedInCurrency;
    }

    /**
     * Define el valor de la propiedad amountTotalAcceptedInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountTotalAcceptedInCurrency(BigDecimal value) {
        this.amountTotalAcceptedInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountTotalConsumedInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountTotalConsumedInEuro() {
        return amountTotalConsumedInEuro;
    }

    /**
     * Define el valor de la propiedad amountTotalConsumedInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountTotalConsumedInEuro(BigDecimal value) {
        this.amountTotalConsumedInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountTotalConsumedInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountTotalConsumedInCurrency() {
        return amountTotalConsumedInCurrency;
    }

    /**
     * Define el valor de la propiedad amountTotalConsumedInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountTotalConsumedInCurrency(BigDecimal value) {
        this.amountTotalConsumedInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountAcceptedInWorkflowInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountAcceptedInWorkflowInEuro() {
        return amountAcceptedInWorkflowInEuro;
    }

    /**
     * Define el valor de la propiedad amountAcceptedInWorkflowInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountAcceptedInWorkflowInEuro(BigDecimal value) {
        this.amountAcceptedInWorkflowInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountAcceptedInWorkflowInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountAcceptedInWorkflowInCurrency() {
        return amountAcceptedInWorkflowInCurrency;
    }

    /**
     * Define el valor de la propiedad amountAcceptedInWorkflowInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountAcceptedInWorkflowInCurrency(BigDecimal value) {
        this.amountAcceptedInWorkflowInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountConsumedInWorkflowInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountConsumedInWorkflowInEuro() {
        return amountConsumedInWorkflowInEuro;
    }

    /**
     * Define el valor de la propiedad amountConsumedInWorkflowInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountConsumedInWorkflowInEuro(BigDecimal value) {
        this.amountConsumedInWorkflowInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountConsumedInWorkflowInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountConsumedInWorkflowInCurrency() {
        return amountConsumedInWorkflowInCurrency;
    }

    /**
     * Define el valor de la propiedad amountConsumedInWorkflowInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountConsumedInWorkflowInCurrency(BigDecimal value) {
        this.amountConsumedInWorkflowInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountInEntryInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountInEntryInEuro() {
        return amountInEntryInEuro;
    }

    /**
     * Define el valor de la propiedad amountInEntryInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountInEntryInEuro(BigDecimal value) {
        this.amountInEntryInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountInEntryInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountInEntryInCurrency() {
        return amountInEntryInCurrency;
    }

    /**
     * Define el valor de la propiedad amountInEntryInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountInEntryInCurrency(BigDecimal value) {
        this.amountInEntryInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountOpenInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountOpenInEuro() {
        return amountOpenInEuro;
    }

    /**
     * Define el valor de la propiedad amountOpenInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountOpenInEuro(BigDecimal value) {
        this.amountOpenInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountOpenInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountOpenInCurrency() {
        return amountOpenInCurrency;
    }

    /**
     * Define el valor de la propiedad amountOpenInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountOpenInCurrency(BigDecimal value) {
        this.amountOpenInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad annualInstallmentFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnnualInstallmentFlag() {
        return annualInstallmentFlag;
    }

    /**
     * Define el valor de la propiedad annualInstallmentFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnnualInstallmentFlag(Boolean value) {
        this.annualInstallmentFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad annualInstallmentJustification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnualInstallmentJustification() {
        return annualInstallmentJustification;
    }

    /**
     * Define el valor de la propiedad annualInstallmentJustification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnualInstallmentJustification(String value) {
        this.annualInstallmentJustification = value;
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
     * Obtiene el valor de la propiedad beneficiaryName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * Define el valor de la propiedad beneficiaryName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryName(String value) {
        this.beneficiaryName = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryContact.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryContact() {
        return beneficiaryContact;
    }

    /**
     * Define el valor de la propiedad beneficiaryContact.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryContact(String value) {
        this.beneficiaryContact = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryStreet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryStreet() {
        return beneficiaryStreet;
    }

    /**
     * Define el valor de la propiedad beneficiaryStreet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryStreet(String value) {
        this.beneficiaryStreet = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryPostCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryPostCode() {
        return beneficiaryPostCode;
    }

    /**
     * Define el valor de la propiedad beneficiaryPostCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryPostCode(String value) {
        this.beneficiaryPostCode = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryPostBox.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryPostBox() {
        return beneficiaryPostBox;
    }

    /**
     * Define el valor de la propiedad beneficiaryPostBox.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryPostBox(String value) {
        this.beneficiaryPostBox = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryCity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryCity() {
        return beneficiaryCity;
    }

    /**
     * Define el valor de la propiedad beneficiaryCity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryCity(String value) {
        this.beneficiaryCity = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryCountryIso2Code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryCountryIso2Code() {
        return beneficiaryCountryIso2Code;
    }

    /**
     * Define el valor de la propiedad beneficiaryCountryIso2Code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryCountryIso2Code(String value) {
        this.beneficiaryCountryIso2Code = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiaryCounty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryCounty() {
        return beneficiaryCounty;
    }

    /**
     * Define el valor de la propiedad beneficiaryCounty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryCounty(String value) {
        this.beneficiaryCounty = value;
    }

    /**
     * Obtiene el valor de la propiedad classCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * Define el valor de la propiedad classCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassCode(String value) {
        this.classCode = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyIso3Code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyIso3Code() {
        return currencyIso3Code;
    }

    /**
     * Define el valor de la propiedad currencyIso3Code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyIso3Code(String value) {
        this.currencyIso3Code = value;
    }

    /**
     * Obtiene el valor de la propiedad currentBudgetaryYear.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentBudgetaryYear() {
        return currentBudgetaryYear;
    }

    /**
     * Define el valor de la propiedad currentBudgetaryYear.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentBudgetaryYear(String value) {
        this.currentBudgetaryYear = value;
    }

    /**
     * Obtiene el valor de la propiedad externalActionFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExternalActionFlag() {
        return externalActionFlag;
    }

    /**
     * Define el valor de la propiedad externalActionFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExternalActionFlag(Boolean value) {
        this.externalActionFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad fileReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileReference() {
        return fileReference;
    }

    /**
     * Define el valor de la propiedad fileReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileReference(String value) {
        this.fileReference = value;
    }

    /**
     * Obtiene el valor de la propiedad financialAgreement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinancialAgreement() {
        return financialAgreement;
    }

    /**
     * Define el valor de la propiedad financialAgreement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinancialAgreement(String value) {
        this.financialAgreement = value;
    }

    /**
     * Obtiene el valor de la propiedad financialAgreementConcludingFinalDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinancialAgreementConcludingFinalDate() {
        return financialAgreementConcludingFinalDate;
    }

    /**
     * Define el valor de la propiedad financialAgreementConcludingFinalDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinancialAgreementConcludingFinalDate(XMLGregorianCalendar value) {
        this.financialAgreementConcludingFinalDate = value;
    }

    /**
     * Obtiene el valor de la propiedad financialAgreementImplementingFinalDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinancialAgreementImplementingFinalDate() {
        return financialAgreementImplementingFinalDate;
    }

    /**
     * Define el valor de la propiedad financialAgreementImplementingFinalDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinancialAgreementImplementingFinalDate(XMLGregorianCalendar value) {
        this.financialAgreementImplementingFinalDate = value;
    }

    /**
     * Obtiene el valor de la propiedad financialAgreementSignedDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinancialAgreementSignedDate() {
        return financialAgreementSignedDate;
    }

    /**
     * Define el valor de la propiedad financialAgreementSignedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinancialAgreementSignedDate(XMLGregorianCalendar value) {
        this.financialAgreementSignedDate = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationCodeForNoFdcIlc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationCodeForNoFdcIlc() {
        return justificationCodeForNoFdcIlc;
    }

    /**
     * Define el valor de la propiedad justificationCodeForNoFdcIlc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationCodeForNoFdcIlc(String value) {
        this.justificationCodeForNoFdcIlc = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationCodeForNoFdiFa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationCodeForNoFdiFa() {
        return justificationCodeForNoFdiFa;
    }

    /**
     * Define el valor de la propiedad justificationCodeForNoFdiFa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationCodeForNoFdiFa(String value) {
        this.justificationCodeForNoFdiFa = value;
    }

    /**
     * Obtiene el valor de la propiedad legalJustificationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalJustificationCode() {
        return legalJustificationCode;
    }

    /**
     * Define el valor de la propiedad legalJustificationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalJustificationCode(String value) {
        this.legalJustificationCode = value;
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
     * Obtiene el valor de la propiedad project.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProject() {
        return project;
    }

    /**
     * Define el valor de la propiedad project.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProject(String value) {
        this.project = value;
    }

    /**
     * Obtiene el valor de la propiedad proposedFdcDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProposedFdcDate() {
        return proposedFdcDate;
    }

    /**
     * Define el valor de la propiedad proposedFdcDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProposedFdcDate(XMLGregorianCalendar value) {
        this.proposedFdcDate = value;
    }

    /**
     * Obtiene el valor de la propiedad proposedDcpFa.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProposedDcpFa() {
        return proposedDcpFa;
    }

    /**
     * Define el valor de la propiedad proposedDcpFa.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProposedDcpFa(Long value) {
        this.proposedDcpFa = value;
    }

    /**
     * Obtiene el valor de la propiedad referenceTreatyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceTreatyCode() {
        return referenceTreatyCode;
    }

    /**
     * Define el valor de la propiedad referenceTreatyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceTreatyCode(String value) {
        this.referenceTreatyCode = value;
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
     * Obtiene el valor de la propiedad stillToCoverInEuroAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStillToCoverInEuroAmount() {
        return stillToCoverInEuroAmount;
    }

    /**
     * Define el valor de la propiedad stillToCoverInEuroAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStillToCoverInEuroAmount(BigDecimal value) {
        this.stillToCoverInEuroAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad userReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserReference() {
        return userReference;
    }

    /**
     * Define el valor de la propiedad userReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserReference(String value) {
        this.userReference = value;
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
     * Obtiene el valor de la propiedad commitmentPositions.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel1GetType.CommitmentPositions }
     *     
     */
    public BudgetaryCommitmentLevel1GetType.CommitmentPositions getCommitmentPositions() {
        return commitmentPositions;
    }

    /**
     * Define el valor de la propiedad commitmentPositions.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel1GetType.CommitmentPositions }
     *     
     */
    public void setCommitmentPositions(BudgetaryCommitmentLevel1GetType.CommitmentPositions value) {
        this.commitmentPositions = value;
    }

    /**
     * Obtiene el valor de la propiedad contractorReferences.
     * 
     * @return
     *     possible object is
     *     {@link ContractorReferencesType }
     *     
     */
    public ContractorReferencesType getContractorReferences() {
        return contractorReferences;
    }

    /**
     * Define el valor de la propiedad contractorReferences.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractorReferencesType }
     *     
     */
    public void setContractorReferences(ContractorReferencesType value) {
        this.contractorReferences = value;
    }

    /**
     * Obtiene el valor de la propiedad externalCriterias.
     * 
     * @return
     *     possible object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public ExternalCriteriasType getExternalCriterias() {
        return externalCriterias;
    }

    /**
     * Define el valor de la propiedad externalCriterias.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public void setExternalCriterias(ExternalCriteriasType value) {
        this.externalCriterias = value;
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
     * Obtiene el valor de la propiedad commitmentL1Consumptions.
     * 
     * @return
     *     possible object is
     *     {@link CommitmentL1ConsumptionsType }
     *     
     */
    public CommitmentL1ConsumptionsType getCommitmentL1Consumptions() {
        return commitmentL1Consumptions;
    }

    /**
     * Define el valor de la propiedad commitmentL1Consumptions.
     * 
     * @param value
     *     allowed object is
     *     {@link CommitmentL1ConsumptionsType }
     *     
     */
    public void setCommitmentL1Consumptions(CommitmentL1ConsumptionsType value) {
        this.commitmentL1Consumptions = value;
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
     *         &lt;element name="BudgetaryCommitmentLevel1Position" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BudgetaryCommitmentLevel1PositionGetType" maxOccurs="unbounded"/&gt;
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
        "budgetaryCommitmentLevel1Position"
    })
    public static class CommitmentPositions {

        @XmlElement(name = "BudgetaryCommitmentLevel1Position", required = true)
        protected List<BudgetaryCommitmentLevel1PositionGetType> budgetaryCommitmentLevel1Position;

        /**
         * Gets the value of the budgetaryCommitmentLevel1Position property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the budgetaryCommitmentLevel1Position property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBudgetaryCommitmentLevel1Position().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BudgetaryCommitmentLevel1PositionGetType }
         * 
         * 
         */
        public List<BudgetaryCommitmentLevel1PositionGetType> getBudgetaryCommitmentLevel1Position() {
            if (budgetaryCommitmentLevel1Position == null) {
                budgetaryCommitmentLevel1Position = new ArrayList<BudgetaryCommitmentLevel1PositionGetType>();
            }
            return this.budgetaryCommitmentLevel1Position;
        }

    }

}
