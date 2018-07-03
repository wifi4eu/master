
package eu.europa.ec.budg.abac.legal_commitment.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import eu.europa.ec.budg.abac.currency.v1.CurrencyDataType;
import eu.europa.ec.budg.abac.organisation.v1.ResponsibleOrganisationType;


/**
 * <p>Clase Java para LegalCommitmentWritableType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalCommitmentWritableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CoFinancingRate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}PercentageType" minOccurs="0"/&gt;
 *         &lt;element name="CoFinancingRateFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="ContractSignDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="ContractCurrencyAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="CoverageEuroAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType"/&gt;
 *         &lt;element name="Currency" type="{http://www.ec.europa.eu/budg/abac/currency/v1}CurrencyDataType" minOccurs="0"/&gt;
 *         &lt;element name="DateBeforeAOSValidationCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}CSDCodeType" minOccurs="0"/&gt;
 *         &lt;element name="DateInNextYearCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}CSDCodeType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalReference" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}ExternalReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="FinancialRegulationGroupCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationGroupCodeType"/&gt;
 *         &lt;element name="FirstPrefinancingFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="FtsRestrictionCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}FtsRestrictionCodeType" minOccurs="0"/&gt;
 *         &lt;element name="FtsGeoRestrictionCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}FtsGeoRestrictionCodeType" minOccurs="0"/&gt;
 *         &lt;element name="GeographicalZoneCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}GeographicalZoneCodeType" minOccurs="0"/&gt;
 *         &lt;element name="GeographicalActionLocation" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}GeographicalActionLocationType" minOccurs="0"/&gt;
 *         &lt;element name="GrantFormCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}GrantFormCodeType" minOccurs="0"/&gt;
 *         &lt;element name="HistorialRetainEuroAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="LateInterests" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="LateInterestsCalculationRule"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="RuleCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}InterestsCalculationRuleCodeType"/&gt;
 *                             &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="SpecificRate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}RateType" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="LegalCommitentType"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}LegalCommitentTypeCodeType"/&gt;
 *                   &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="PaymentDeductionModeCode" type="{http://www.ec.europa.eu/budg/abac/payment_deduction_mode/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}ResponsibleOrganisationType"/&gt;
 *         &lt;element name="Subject" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}SubjectType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalCommitmentWritableType", propOrder = {
    "coFinancingRate",
    "coFinancingRateFlag",
    "contractSignDate",
    "contractCurrencyAmount",
    "coverageEuroAmount",
    "currency",
    "dateBeforeAOSValidationCode",
    "dateInNextYearCode",
    "externalReference",
    "financialRegulationGroupCode",
    "firstPrefinancingFlag",
    "ftsRestrictionCode",
    "ftsGeoRestrictionCode",
    "geographicalZoneCode",
    "geographicalActionLocation",
    "grantFormCode",
    "historialRetainEuroAmount",
    "lateInterests",
    "legalCommitentType",
    "localKey",
    "paymentDeductionModeCode",
    "responsibleOrganisation",
    "subject"
})
@XmlSeeAlso({
    LegalCommitmentCreateType.class
})
public class LegalCommitmentWritableType {

    @XmlElement(name = "CoFinancingRate")
    protected BigDecimal coFinancingRate;
    @XmlElement(name = "CoFinancingRateFlag")
    protected Boolean coFinancingRateFlag;
    @XmlElement(name = "ContractSignDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar contractSignDate;
    @XmlElement(name = "ContractCurrencyAmount")
    protected BigDecimal contractCurrencyAmount;
    @XmlElement(name = "CoverageEuroAmount", required = true)
    protected BigDecimal coverageEuroAmount;
    @XmlElement(name = "Currency")
    protected CurrencyDataType currency;
    @XmlElement(name = "DateBeforeAOSValidationCode")
    protected String dateBeforeAOSValidationCode;
    @XmlElement(name = "DateInNextYearCode")
    protected String dateInNextYearCode;
    @XmlElement(name = "ExternalReference")
    protected String externalReference;
    @XmlElement(name = "FinancialRegulationGroupCode", required = true)
    protected String financialRegulationGroupCode;
    @XmlElement(name = "FirstPrefinancingFlag")
    protected Boolean firstPrefinancingFlag;
    @XmlElement(name = "FtsRestrictionCode")
    protected String ftsRestrictionCode;
    @XmlElement(name = "FtsGeoRestrictionCode")
    protected String ftsGeoRestrictionCode;
    @XmlElement(name = "GeographicalZoneCode")
    protected String geographicalZoneCode;
    @XmlElement(name = "GeographicalActionLocation")
    protected String geographicalActionLocation;
    @XmlElement(name = "GrantFormCode")
    protected String grantFormCode;
    @XmlElement(name = "HistorialRetainEuroAmount")
    protected BigDecimal historialRetainEuroAmount;
    @XmlElement(name = "LateInterests")
    protected LegalCommitmentWritableType.LateInterests lateInterests;
    @XmlElement(name = "LegalCommitentType", required = true)
    protected LegalCommitmentWritableType.LegalCommitentType legalCommitentType;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "PaymentDeductionModeCode")
    protected String paymentDeductionModeCode;
    @XmlElement(name = "ResponsibleOrganisation", required = true)
    protected ResponsibleOrganisationType responsibleOrganisation;
    @XmlElement(name = "Subject")
    protected String subject;

    /**
     * Obtiene el valor de la propiedad coFinancingRate.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCoFinancingRate() {
        return coFinancingRate;
    }

    /**
     * Define el valor de la propiedad coFinancingRate.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCoFinancingRate(BigDecimal value) {
        this.coFinancingRate = value;
    }

    /**
     * Obtiene el valor de la propiedad coFinancingRateFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCoFinancingRateFlag() {
        return coFinancingRateFlag;
    }

    /**
     * Define el valor de la propiedad coFinancingRateFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCoFinancingRateFlag(Boolean value) {
        this.coFinancingRateFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad contractSignDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractSignDate() {
        return contractSignDate;
    }

    /**
     * Define el valor de la propiedad contractSignDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractSignDate(XMLGregorianCalendar value) {
        this.contractSignDate = value;
    }

    /**
     * Obtiene el valor de la propiedad contractCurrencyAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getContractCurrencyAmount() {
        return contractCurrencyAmount;
    }

    /**
     * Define el valor de la propiedad contractCurrencyAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setContractCurrencyAmount(BigDecimal value) {
        this.contractCurrencyAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad coverageEuroAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCoverageEuroAmount() {
        return coverageEuroAmount;
    }

    /**
     * Define el valor de la propiedad coverageEuroAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCoverageEuroAmount(BigDecimal value) {
        this.coverageEuroAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad currency.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyDataType }
     *     
     */
    public CurrencyDataType getCurrency() {
        return currency;
    }

    /**
     * Define el valor de la propiedad currency.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyDataType }
     *     
     */
    public void setCurrency(CurrencyDataType value) {
        this.currency = value;
    }

    /**
     * Obtiene el valor de la propiedad dateBeforeAOSValidationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateBeforeAOSValidationCode() {
        return dateBeforeAOSValidationCode;
    }

    /**
     * Define el valor de la propiedad dateBeforeAOSValidationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateBeforeAOSValidationCode(String value) {
        this.dateBeforeAOSValidationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad dateInNextYearCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateInNextYearCode() {
        return dateInNextYearCode;
    }

    /**
     * Define el valor de la propiedad dateInNextYearCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateInNextYearCode(String value) {
        this.dateInNextYearCode = value;
    }

    /**
     * Obtiene el valor de la propiedad externalReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalReference() {
        return externalReference;
    }

    /**
     * Define el valor de la propiedad externalReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalReference(String value) {
        this.externalReference = value;
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
     * Obtiene el valor de la propiedad firstPrefinancingFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFirstPrefinancingFlag() {
        return firstPrefinancingFlag;
    }

    /**
     * Define el valor de la propiedad firstPrefinancingFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFirstPrefinancingFlag(Boolean value) {
        this.firstPrefinancingFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad ftsRestrictionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtsRestrictionCode() {
        return ftsRestrictionCode;
    }

    /**
     * Define el valor de la propiedad ftsRestrictionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtsRestrictionCode(String value) {
        this.ftsRestrictionCode = value;
    }

    /**
     * Obtiene el valor de la propiedad ftsGeoRestrictionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtsGeoRestrictionCode() {
        return ftsGeoRestrictionCode;
    }

    /**
     * Define el valor de la propiedad ftsGeoRestrictionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtsGeoRestrictionCode(String value) {
        this.ftsGeoRestrictionCode = value;
    }

    /**
     * Obtiene el valor de la propiedad geographicalZoneCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeographicalZoneCode() {
        return geographicalZoneCode;
    }

    /**
     * Define el valor de la propiedad geographicalZoneCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeographicalZoneCode(String value) {
        this.geographicalZoneCode = value;
    }

    /**
     * Obtiene el valor de la propiedad geographicalActionLocation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeographicalActionLocation() {
        return geographicalActionLocation;
    }

    /**
     * Define el valor de la propiedad geographicalActionLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeographicalActionLocation(String value) {
        this.geographicalActionLocation = value;
    }

    /**
     * Obtiene el valor de la propiedad grantFormCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrantFormCode() {
        return grantFormCode;
    }

    /**
     * Define el valor de la propiedad grantFormCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrantFormCode(String value) {
        this.grantFormCode = value;
    }

    /**
     * Obtiene el valor de la propiedad historialRetainEuroAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHistorialRetainEuroAmount() {
        return historialRetainEuroAmount;
    }

    /**
     * Define el valor de la propiedad historialRetainEuroAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHistorialRetainEuroAmount(BigDecimal value) {
        this.historialRetainEuroAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad lateInterests.
     * 
     * @return
     *     possible object is
     *     {@link LegalCommitmentWritableType.LateInterests }
     *     
     */
    public LegalCommitmentWritableType.LateInterests getLateInterests() {
        return lateInterests;
    }

    /**
     * Define el valor de la propiedad lateInterests.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalCommitmentWritableType.LateInterests }
     *     
     */
    public void setLateInterests(LegalCommitmentWritableType.LateInterests value) {
        this.lateInterests = value;
    }

    /**
     * Obtiene el valor de la propiedad legalCommitentType.
     * 
     * @return
     *     possible object is
     *     {@link LegalCommitmentWritableType.LegalCommitentType }
     *     
     */
    public LegalCommitmentWritableType.LegalCommitentType getLegalCommitentType() {
        return legalCommitentType;
    }

    /**
     * Define el valor de la propiedad legalCommitentType.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalCommitmentWritableType.LegalCommitentType }
     *     
     */
    public void setLegalCommitentType(LegalCommitmentWritableType.LegalCommitentType value) {
        this.legalCommitentType = value;
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
     * Obtiene el valor de la propiedad paymentDeductionModeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDeductionModeCode() {
        return paymentDeductionModeCode;
    }

    /**
     * Define el valor de la propiedad paymentDeductionModeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDeductionModeCode(String value) {
        this.paymentDeductionModeCode = value;
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
     * Obtiene el valor de la propiedad subject.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Define el valor de la propiedad subject.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
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
     *         &lt;element name="LateInterestsCalculationRule"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="RuleCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}InterestsCalculationRuleCodeType"/&gt;
     *                   &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="SpecificRate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}RateType" minOccurs="0"/&gt;
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
        "lateInterestsCalculationRule",
        "specificRate"
    })
    public static class LateInterests {

        @XmlElement(name = "LateInterestsCalculationRule", required = true)
        protected LegalCommitmentWritableType.LateInterests.LateInterestsCalculationRule lateInterestsCalculationRule;
        @XmlElement(name = "SpecificRate")
        protected BigDecimal specificRate;

        /**
         * Obtiene el valor de la propiedad lateInterestsCalculationRule.
         * 
         * @return
         *     possible object is
         *     {@link LegalCommitmentWritableType.LateInterests.LateInterestsCalculationRule }
         *     
         */
        public LegalCommitmentWritableType.LateInterests.LateInterestsCalculationRule getLateInterestsCalculationRule() {
            return lateInterestsCalculationRule;
        }

        /**
         * Define el valor de la propiedad lateInterestsCalculationRule.
         * 
         * @param value
         *     allowed object is
         *     {@link LegalCommitmentWritableType.LateInterests.LateInterestsCalculationRule }
         *     
         */
        public void setLateInterestsCalculationRule(LegalCommitmentWritableType.LateInterests.LateInterestsCalculationRule value) {
            this.lateInterestsCalculationRule = value;
        }

        /**
         * Obtiene el valor de la propiedad specificRate.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSpecificRate() {
            return specificRate;
        }

        /**
         * Define el valor de la propiedad specificRate.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSpecificRate(BigDecimal value) {
            this.specificRate = value;
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
         *         &lt;element name="RuleCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}InterestsCalculationRuleCodeType"/&gt;
         *         &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType"/&gt;
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
            "ruleCode",
            "financialRegulationCode"
        })
        public static class LateInterestsCalculationRule {

            @XmlElement(name = "RuleCode", required = true)
            protected String ruleCode;
            @XmlElement(name = "FinancialRegulationCode", required = true)
            protected String financialRegulationCode;

            /**
             * Obtiene el valor de la propiedad ruleCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRuleCode() {
                return ruleCode;
            }

            /**
             * Define el valor de la propiedad ruleCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRuleCode(String value) {
                this.ruleCode = value;
            }

            /**
             * Obtiene el valor de la propiedad financialRegulationCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFinancialRegulationCode() {
                return financialRegulationCode;
            }

            /**
             * Define el valor de la propiedad financialRegulationCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFinancialRegulationCode(String value) {
                this.financialRegulationCode = value;
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
     *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}LegalCommitentTypeCodeType"/&gt;
     *         &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType"/&gt;
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
        "code",
        "financialRegulationCode"
    })
    public static class LegalCommitentType {

        @XmlElement(name = "Code", required = true)
        protected String code;
        @XmlElement(name = "FinancialRegulationCode", required = true)
        protected String financialRegulationCode;

        /**
         * Obtiene el valor de la propiedad code.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Define el valor de la propiedad code.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Obtiene el valor de la propiedad financialRegulationCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFinancialRegulationCode() {
            return financialRegulationCode;
        }

        /**
         * Define el valor de la propiedad financialRegulationCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFinancialRegulationCode(String value) {
            this.financialRegulationCode = value;
        }

    }

}
