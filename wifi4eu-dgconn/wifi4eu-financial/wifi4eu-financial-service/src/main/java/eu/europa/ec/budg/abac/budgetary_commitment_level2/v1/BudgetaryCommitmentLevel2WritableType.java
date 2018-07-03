
package eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import eu.europa.ec.budg.abac.organisation.v1.ResponsibleOrganisationType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2WritableType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2WritableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AnnualInstallmentFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="AnnualInstallmentJustification" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}AnnualInstallmentJustificationType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryName" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryNameType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryContact" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryContactType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryStreet" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryStreetType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryPostCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryPostCodeType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryPostBox" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryPostBoxType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryCity" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryCityType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryCountryIso2Code" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryCountryIso2CodeType" minOccurs="0"/&gt;
 *         &lt;element name="BeneficiaryCounty" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BeneficiaryCountyType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetManagementTypeCode" type="{http://www.ec.europa.eu/budg/abac/budget_management_type/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ClassCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}ClassCodeType"/&gt;
 *         &lt;element name="CompletionFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="CompletionModReason" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}CompletionModReasonType" minOccurs="0"/&gt;
 *         &lt;element name="ConsumingL1ReasonJustCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyIso3Code" type="{http://www.ec.europa.eu/budg/abac/currency/v1}Iso3CodeType"/&gt;
 *         &lt;element name="CurrentBudgetYear" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}CurrentBudgetYearType" minOccurs="0"/&gt;
 *         &lt;element name="ExpenditureCategoryCode" type="{http://www.ec.europa.eu/budg/abac/expenditure_category/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalActionFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="FdiDelimiterCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}FdiDelimiterCodeType" minOccurs="0"/&gt;
 *         &lt;element name="FinancialRegulationGroupCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationGroupCodeType" minOccurs="0"/&gt;
 *         &lt;element name="ImplementedByCode" type="{http://www.ec.europa.eu/budg/abac/implemented_by/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationCodeForNoFdcIlc" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationForMultiplePaymentClassCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationForMultipleThirdpartyCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationForNoThirdpartyCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="LegalJustificationCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="PaymentClassCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PaymentClassCodeType" minOccurs="0"/&gt;
 *         &lt;element name="PerformanceGuaranteeIndicatorCode" type="{http://www.ec.europa.eu/budg/abac/performance_guarantee_indicator/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="PrefinGuaranteeAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="PrefinGuaranteeJustificationCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}JustificationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="PrefinGuaranteeJustificationFinRegulCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Project" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}ProjectType" minOccurs="0"/&gt;
 *         &lt;element name="ProposedFdiDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="ReferenceTreatyCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}ReferenceTreatyCodeType" minOccurs="0"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}RemarksType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}ResponsibleOrganisationType"/&gt;
 *         &lt;element name="UpdateFdiReason" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}UpdateFdiReasonType" minOccurs="0"/&gt;
 *         &lt;element name="UserReference" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}UserReferenceType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2WritableType", propOrder = {
    "annualInstallmentFlag",
    "annualInstallmentJustification",
    "beneficiaryName",
    "beneficiaryContact",
    "beneficiaryStreet",
    "beneficiaryPostCode",
    "beneficiaryPostBox",
    "beneficiaryCity",
    "beneficiaryCountryIso2Code",
    "beneficiaryCounty",
    "budgetManagementTypeCode",
    "classCode",
    "completionFlag",
    "completionModReason",
    "consumingL1ReasonJustCode",
    "currencyIso3Code",
    "currentBudgetYear",
    "expenditureCategoryCode",
    "externalActionFlag",
    "fdiDelimiterCode",
    "financialRegulationGroupCode",
    "implementedByCode",
    "justificationCodeForNoFdcIlc",
    "justificationForMultiplePaymentClassCode",
    "justificationForMultipleThirdpartyCode",
    "justificationForNoThirdpartyCode",
    "legalJustificationCode",
    "localKey",
    "paymentClassCode",
    "performanceGuaranteeIndicatorCode",
    "prefinGuaranteeAmount",
    "prefinGuaranteeJustificationCode",
    "prefinGuaranteeJustificationFinRegulCode",
    "project",
    "proposedFdiDate",
    "referenceTreatyCode",
    "remarks",
    "responsibleOrganisation",
    "updateFdiReason",
    "userReference"
})
@XmlSeeAlso({
    BudgetaryCommitmentLevel2CreateType.class
})
public class BudgetaryCommitmentLevel2WritableType {

    @XmlElement(name = "AnnualInstallmentFlag")
    protected Boolean annualInstallmentFlag;
    @XmlElement(name = "AnnualInstallmentJustification")
    protected String annualInstallmentJustification;
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
    @XmlElement(name = "BudgetManagementTypeCode")
    protected String budgetManagementTypeCode;
    @XmlElement(name = "ClassCode", required = true)
    protected String classCode;
    @XmlElement(name = "CompletionFlag")
    protected Boolean completionFlag;
    @XmlElement(name = "CompletionModReason")
    protected String completionModReason;
    @XmlElement(name = "ConsumingL1ReasonJustCode")
    protected String consumingL1ReasonJustCode;
    @XmlElement(name = "CurrencyIso3Code", required = true)
    protected String currencyIso3Code;
    @XmlElement(name = "CurrentBudgetYear")
    protected String currentBudgetYear;
    @XmlElement(name = "ExpenditureCategoryCode")
    protected String expenditureCategoryCode;
    @XmlElement(name = "ExternalActionFlag")
    protected Boolean externalActionFlag;
    @XmlElement(name = "FdiDelimiterCode")
    protected String fdiDelimiterCode;
    @XmlElement(name = "FinancialRegulationGroupCode")
    protected String financialRegulationGroupCode;
    @XmlElement(name = "ImplementedByCode")
    protected String implementedByCode;
    @XmlElement(name = "JustificationCodeForNoFdcIlc")
    protected String justificationCodeForNoFdcIlc;
    @XmlElement(name = "JustificationForMultiplePaymentClassCode")
    protected String justificationForMultiplePaymentClassCode;
    @XmlElement(name = "JustificationForMultipleThirdpartyCode")
    protected String justificationForMultipleThirdpartyCode;
    @XmlElement(name = "JustificationForNoThirdpartyCode")
    protected String justificationForNoThirdpartyCode;
    @XmlElement(name = "LegalJustificationCode")
    protected String legalJustificationCode;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "PaymentClassCode")
    protected String paymentClassCode;
    @XmlElement(name = "PerformanceGuaranteeIndicatorCode")
    protected String performanceGuaranteeIndicatorCode;
    @XmlElement(name = "PrefinGuaranteeAmount")
    protected BigDecimal prefinGuaranteeAmount;
    @XmlElement(name = "PrefinGuaranteeJustificationCode")
    protected String prefinGuaranteeJustificationCode;
    @XmlElement(name = "PrefinGuaranteeJustificationFinRegulCode")
    protected String prefinGuaranteeJustificationFinRegulCode;
    @XmlElement(name = "Project")
    protected String project;
    @XmlElement(name = "ProposedFdiDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar proposedFdiDate;
    @XmlElement(name = "ReferenceTreatyCode")
    protected String referenceTreatyCode;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "ResponsibleOrganisation", required = true)
    protected ResponsibleOrganisationType responsibleOrganisation;
    @XmlElement(name = "UpdateFdiReason")
    protected String updateFdiReason;
    @XmlElement(name = "UserReference", required = true)
    protected String userReference;

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
     * Obtiene el valor de la propiedad budgetManagementTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetManagementTypeCode() {
        return budgetManagementTypeCode;
    }

    /**
     * Define el valor de la propiedad budgetManagementTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetManagementTypeCode(String value) {
        this.budgetManagementTypeCode = value;
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
     * Obtiene el valor de la propiedad completionFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCompletionFlag() {
        return completionFlag;
    }

    /**
     * Define el valor de la propiedad completionFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCompletionFlag(Boolean value) {
        this.completionFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad completionModReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompletionModReason() {
        return completionModReason;
    }

    /**
     * Define el valor de la propiedad completionModReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompletionModReason(String value) {
        this.completionModReason = value;
    }

    /**
     * Obtiene el valor de la propiedad consumingL1ReasonJustCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsumingL1ReasonJustCode() {
        return consumingL1ReasonJustCode;
    }

    /**
     * Define el valor de la propiedad consumingL1ReasonJustCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsumingL1ReasonJustCode(String value) {
        this.consumingL1ReasonJustCode = value;
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
     * Obtiene el valor de la propiedad currentBudgetYear.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentBudgetYear() {
        return currentBudgetYear;
    }

    /**
     * Define el valor de la propiedad currentBudgetYear.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentBudgetYear(String value) {
        this.currentBudgetYear = value;
    }

    /**
     * Obtiene el valor de la propiedad expenditureCategoryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpenditureCategoryCode() {
        return expenditureCategoryCode;
    }

    /**
     * Define el valor de la propiedad expenditureCategoryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpenditureCategoryCode(String value) {
        this.expenditureCategoryCode = value;
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
     * Obtiene el valor de la propiedad fdiDelimiterCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFdiDelimiterCode() {
        return fdiDelimiterCode;
    }

    /**
     * Define el valor de la propiedad fdiDelimiterCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFdiDelimiterCode(String value) {
        this.fdiDelimiterCode = value;
    }

    /**
     * Obtiene el valor de la propiedad financialRegulationGroupCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinancialRegulationGroupCode() {
        return financialRegulationGroupCode;
    }

    /**
     * Define el valor de la propiedad financialRegulationGroupCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinancialRegulationGroupCode(String value) {
        this.financialRegulationGroupCode = value;
    }

    /**
     * Obtiene el valor de la propiedad implementedByCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImplementedByCode() {
        return implementedByCode;
    }

    /**
     * Define el valor de la propiedad implementedByCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImplementedByCode(String value) {
        this.implementedByCode = value;
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
     * Obtiene el valor de la propiedad justificationForMultiplePaymentClassCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationForMultiplePaymentClassCode() {
        return justificationForMultiplePaymentClassCode;
    }

    /**
     * Define el valor de la propiedad justificationForMultiplePaymentClassCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationForMultiplePaymentClassCode(String value) {
        this.justificationForMultiplePaymentClassCode = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationForMultipleThirdpartyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationForMultipleThirdpartyCode() {
        return justificationForMultipleThirdpartyCode;
    }

    /**
     * Define el valor de la propiedad justificationForMultipleThirdpartyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationForMultipleThirdpartyCode(String value) {
        this.justificationForMultipleThirdpartyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationForNoThirdpartyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationForNoThirdpartyCode() {
        return justificationForNoThirdpartyCode;
    }

    /**
     * Define el valor de la propiedad justificationForNoThirdpartyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationForNoThirdpartyCode(String value) {
        this.justificationForNoThirdpartyCode = value;
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
     * Obtiene el valor de la propiedad paymentClassCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentClassCode() {
        return paymentClassCode;
    }

    /**
     * Define el valor de la propiedad paymentClassCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentClassCode(String value) {
        this.paymentClassCode = value;
    }

    /**
     * Obtiene el valor de la propiedad performanceGuaranteeIndicatorCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerformanceGuaranteeIndicatorCode() {
        return performanceGuaranteeIndicatorCode;
    }

    /**
     * Define el valor de la propiedad performanceGuaranteeIndicatorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerformanceGuaranteeIndicatorCode(String value) {
        this.performanceGuaranteeIndicatorCode = value;
    }

    /**
     * Obtiene el valor de la propiedad prefinGuaranteeAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrefinGuaranteeAmount() {
        return prefinGuaranteeAmount;
    }

    /**
     * Define el valor de la propiedad prefinGuaranteeAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrefinGuaranteeAmount(BigDecimal value) {
        this.prefinGuaranteeAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad prefinGuaranteeJustificationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefinGuaranteeJustificationCode() {
        return prefinGuaranteeJustificationCode;
    }

    /**
     * Define el valor de la propiedad prefinGuaranteeJustificationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefinGuaranteeJustificationCode(String value) {
        this.prefinGuaranteeJustificationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad prefinGuaranteeJustificationFinRegulCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefinGuaranteeJustificationFinRegulCode() {
        return prefinGuaranteeJustificationFinRegulCode;
    }

    /**
     * Define el valor de la propiedad prefinGuaranteeJustificationFinRegulCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefinGuaranteeJustificationFinRegulCode(String value) {
        this.prefinGuaranteeJustificationFinRegulCode = value;
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
     * Obtiene el valor de la propiedad proposedFdiDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProposedFdiDate() {
        return proposedFdiDate;
    }

    /**
     * Define el valor de la propiedad proposedFdiDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProposedFdiDate(XMLGregorianCalendar value) {
        this.proposedFdiDate = value;
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
     * Obtiene el valor de la propiedad updateFdiReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateFdiReason() {
        return updateFdiReason;
    }

    /**
     * Define el valor de la propiedad updateFdiReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateFdiReason(String value) {
        this.updateFdiReason = value;
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

}
