
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

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
 * <p>Clase Java para BudgetaryCommitmentLevel1WritableType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel1WritableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AnnualInstallmentFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="AnnualInstallmentJustification" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}AnnualInstallmentJustificationType" minOccurs="0"/&gt;
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
 *         &lt;element name="CurrentBudgetYear" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}CurrentBudgetYearType"/&gt;
 *         &lt;element name="ExternalActionFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
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
@XmlType(name = "BudgetaryCommitmentLevel1WritableType", propOrder = {
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
    "classCode",
    "currencyIso3Code",
    "currentBudgetYear",
    "externalActionFlag",
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
    "userReference"
})
@XmlSeeAlso({
    BudgetaryCommitmentLevel1CreateType.class
})
public class BudgetaryCommitmentLevel1WritableType {

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
    @XmlElement(name = "ClassCode", required = true)
    protected String classCode;
    @XmlElement(name = "CurrencyIso3Code")
    protected String currencyIso3Code;
    @XmlElement(name = "CurrentBudgetYear", required = true)
    protected String currentBudgetYear;
    @XmlElement(name = "ExternalActionFlag")
    protected Boolean externalActionFlag;
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

}
