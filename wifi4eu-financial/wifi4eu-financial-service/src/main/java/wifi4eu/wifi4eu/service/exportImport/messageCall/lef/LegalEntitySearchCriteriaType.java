
package wifi4eu.wifi4eu.service.exportImport.messageCall.lef;

import eu.europa.ec.budg.abac.search_criterion.v1.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegalEntitySearchCriteriaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntitySearchCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AbacKey" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="AccountGroupCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="Acronym" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="BirthCountryCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="BirthDate" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}DateCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="BlockedFlag" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}IndicatorCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="BlockingCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetCompanyCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CentralStatus" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CorrectedLegalEntityLocalKey" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CreationDate" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}DateCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CreationUser" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowLevel" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}NumberCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowOrganisation" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowStatus" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CustomerOnly" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}IndicatorCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="FirstName" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}OracleTextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="IdentificationNum" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="LegalEntityFpoType" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="LegalForm" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="LegalFormFpoType" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="LegalType" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="Lot" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="MatriculeNum" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ModificationDate" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}DateCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ModificationUser" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="Name" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="NgoFlag" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}IndicatorCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="OfficialName" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}OracleTextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="OfficialAddressCity" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="OfficialAddressCountryCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="OfficialAddressPostCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="OfficialAddressStreetNr" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationAuth" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationCountryCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationDate" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}DateCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationNumber" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleUsers" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="Vat" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="LinkStatusCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="NationalIdNumber" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="NationalIdIssuingCountryCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="PassportNumber" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="PassportIssuingCountryCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="DriverLicenseNumber" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="DriverLicenseIssuingCountryCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="IdentityCardNumber" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="IdentityCardIssuingCountryCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="OtherDocumentNumber" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="OtherDocumentIssuingCountryCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="AnyDocumentNumber" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="AnyDocumentIssuingCountryCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="WholeName" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}OracleTextCriterionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntitySearchCriteriaType", propOrder = {
    "abacKey",
    "accountGroupCode",
    "acronym",
    "birthCountryCode",
    "birthDate",
    "blockedFlag",
    "blockingCode",
    "budgetCompanyCode",
    "centralStatus",
    "correctedLegalEntityLocalKey",
    "creationDate",
    "creationUser",
    "currentWorkflowLevel",
    "currentWorkflowOrganisation",
    "currentWorkflowStatus",
    "customerOnly",
    "firstName",
    "identificationNum",
    "legalEntityFpoType",
    "legalForm",
    "legalFormFpoType",
    "legalType",
    "lot",
    "matriculeNum",
    "modificationDate",
    "modificationUser",
    "name",
    "ngoFlag",
    "officialName",
    "officialAddressCity",
    "officialAddressCountryCode",
    "officialAddressPostCode",
    "officialAddressStreetNr",
    "registrationAuth",
    "registrationCountryCode",
    "registrationDate",
    "registrationNumber",
    "responsibleUsers",
    "vat",
    "linkStatusCode",
    "nationalIdNumber",
    "nationalIdIssuingCountryCode",
    "passportNumber",
    "passportIssuingCountryCode",
    "driverLicenseNumber",
    "driverLicenseIssuingCountryCode",
    "identityCardNumber",
    "identityCardIssuingCountryCode",
    "otherDocumentNumber",
    "otherDocumentIssuingCountryCode",
    "anyDocumentNumber",
    "anyDocumentIssuingCountryCode",
    "wholeName"
})
public class LegalEntitySearchCriteriaType {

    @XmlElement(name = "AbacKey")
    protected TextCriterionType abacKey;
    @XmlElement(name = "AccountGroupCode")
    protected TextCriterionType accountGroupCode;
    @XmlElement(name = "Acronym")
    protected TextCriterionType acronym;
    @XmlElement(name = "BirthCountryCode")
    protected TextCriterionType birthCountryCode;
    @XmlElement(name = "BirthDate")
    protected DateCriterionType birthDate;
    @XmlElement(name = "BlockedFlag")
    protected IndicatorCriterionType blockedFlag;
    @XmlElement(name = "BlockingCode")
    protected TextCriterionType blockingCode;
    @XmlElement(name = "BudgetCompanyCode")
    protected TextCriterionType budgetCompanyCode;
    @XmlElement(name = "CentralStatus")
    protected TextCriterionType centralStatus;
    @XmlElement(name = "CorrectedLegalEntityLocalKey")
    protected TextCriterionType correctedLegalEntityLocalKey;
    @XmlElement(name = "CreationDate")
    protected DateCriterionType creationDate;
    @XmlElement(name = "CreationUser")
    protected TextCriterionType creationUser;
    @XmlElement(name = "CurrentWorkflowLevel")
    protected NumberCriterionType currentWorkflowLevel;
    @XmlElement(name = "CurrentWorkflowOrganisation")
    protected TextCriterionType currentWorkflowOrganisation;
    @XmlElement(name = "CurrentWorkflowStatus")
    protected TextCriterionType currentWorkflowStatus;
    @XmlElement(name = "CustomerOnly")
    protected IndicatorCriterionType customerOnly;
    @XmlElement(name = "FirstName")
    protected OracleTextCriterionType firstName;
    @XmlElement(name = "IdentificationNum")
    protected TextCriterionType identificationNum;
    @XmlElement(name = "LegalEntityFpoType")
    protected TextCriterionType legalEntityFpoType;
    @XmlElement(name = "LegalForm")
    protected TextCriterionType legalForm;
    @XmlElement(name = "LegalFormFpoType")
    protected TextCriterionType legalFormFpoType;
    @XmlElement(name = "LegalType")
    protected TextCriterionType legalType;
    @XmlElement(name = "Lot")
    protected TextCriterionType lot;
    @XmlElement(name = "MatriculeNum")
    protected TextCriterionType matriculeNum;
    @XmlElement(name = "ModificationDate")
    protected DateCriterionType modificationDate;
    @XmlElement(name = "ModificationUser")
    protected TextCriterionType modificationUser;
    @XmlElement(name = "Name")
    protected TextCriterionType name;
    @XmlElement(name = "NgoFlag")
    protected IndicatorCriterionType ngoFlag;
    @XmlElement(name = "OfficialName")
    protected OracleTextCriterionType officialName;
    @XmlElement(name = "OfficialAddressCity")
    protected TextCriterionType officialAddressCity;
    @XmlElement(name = "OfficialAddressCountryCode")
    protected TextCriterionType officialAddressCountryCode;
    @XmlElement(name = "OfficialAddressPostCode")
    protected TextCriterionType officialAddressPostCode;
    @XmlElement(name = "OfficialAddressStreetNr")
    protected TextCriterionType officialAddressStreetNr;
    @XmlElement(name = "RegistrationAuth")
    protected TextCriterionType registrationAuth;
    @XmlElement(name = "RegistrationCountryCode")
    protected TextCriterionType registrationCountryCode;
    @XmlElement(name = "RegistrationDate")
    protected DateCriterionType registrationDate;
    @XmlElement(name = "RegistrationNumber")
    protected TextCriterionType registrationNumber;
    @XmlElement(name = "ResponsibleUsers")
    protected TextCriterionType responsibleUsers;
    @XmlElement(name = "Vat")
    protected TextCriterionType vat;
    @XmlElement(name = "LinkStatusCode")
    protected TextCriterionType linkStatusCode;
    @XmlElement(name = "NationalIdNumber")
    protected TextCriterionType nationalIdNumber;
    @XmlElement(name = "NationalIdIssuingCountryCode")
    protected TextCriterionType nationalIdIssuingCountryCode;
    @XmlElement(name = "PassportNumber")
    protected TextCriterionType passportNumber;
    @XmlElement(name = "PassportIssuingCountryCode")
    protected TextCriterionType passportIssuingCountryCode;
    @XmlElement(name = "DriverLicenseNumber")
    protected TextCriterionType driverLicenseNumber;
    @XmlElement(name = "DriverLicenseIssuingCountryCode")
    protected TextCriterionType driverLicenseIssuingCountryCode;
    @XmlElement(name = "IdentityCardNumber")
    protected TextCriterionType identityCardNumber;
    @XmlElement(name = "IdentityCardIssuingCountryCode")
    protected TextCriterionType identityCardIssuingCountryCode;
    @XmlElement(name = "OtherDocumentNumber")
    protected TextCriterionType otherDocumentNumber;
    @XmlElement(name = "OtherDocumentIssuingCountryCode")
    protected TextCriterionType otherDocumentIssuingCountryCode;
    @XmlElement(name = "AnyDocumentNumber")
    protected TextCriterionType anyDocumentNumber;
    @XmlElement(name = "AnyDocumentIssuingCountryCode")
    protected TextCriterionType anyDocumentIssuingCountryCode;
    @XmlElement(name = "WholeName")
    protected OracleTextCriterionType wholeName;

    /**
     * Obtiene el valor de la propiedad abacKey.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getAbacKey() {
        return abacKey;
    }

    /**
     * Define el valor de la propiedad abacKey.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setAbacKey(TextCriterionType value) {
        this.abacKey = value;
    }

    /**
     * Obtiene el valor de la propiedad accountGroupCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getAccountGroupCode() {
        return accountGroupCode;
    }

    /**
     * Define el valor de la propiedad accountGroupCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setAccountGroupCode(TextCriterionType value) {
        this.accountGroupCode = value;
    }

    /**
     * Obtiene el valor de la propiedad acronym.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getAcronym() {
        return acronym;
    }

    /**
     * Define el valor de la propiedad acronym.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setAcronym(TextCriterionType value) {
        this.acronym = value;
    }

    /**
     * Obtiene el valor de la propiedad birthCountryCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getBirthCountryCode() {
        return birthCountryCode;
    }

    /**
     * Define el valor de la propiedad birthCountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setBirthCountryCode(TextCriterionType value) {
        this.birthCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad birthDate.
     * 
     * @return
     *     possible object is
     *     {@link DateCriterionType }
     *     
     */
    public DateCriterionType getBirthDate() {
        return birthDate;
    }

    /**
     * Define el valor de la propiedad birthDate.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCriterionType }
     *     
     */
    public void setBirthDate(DateCriterionType value) {
        this.birthDate = value;
    }

    /**
     * Obtiene el valor de la propiedad blockedFlag.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorCriterionType }
     *     
     */
    public IndicatorCriterionType getBlockedFlag() {
        return blockedFlag;
    }

    /**
     * Define el valor de la propiedad blockedFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorCriterionType }
     *     
     */
    public void setBlockedFlag(IndicatorCriterionType value) {
        this.blockedFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad blockingCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getBlockingCode() {
        return blockingCode;
    }

    /**
     * Define el valor de la propiedad blockingCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setBlockingCode(TextCriterionType value) {
        this.blockingCode = value;
    }

    /**
     * Obtiene el valor de la propiedad budgetCompanyCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getBudgetCompanyCode() {
        return budgetCompanyCode;
    }

    /**
     * Define el valor de la propiedad budgetCompanyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setBudgetCompanyCode(TextCriterionType value) {
        this.budgetCompanyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad centralStatus.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCentralStatus() {
        return centralStatus;
    }

    /**
     * Define el valor de la propiedad centralStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCentralStatus(TextCriterionType value) {
        this.centralStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad correctedLegalEntityLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCorrectedLegalEntityLocalKey() {
        return correctedLegalEntityLocalKey;
    }

    /**
     * Define el valor de la propiedad correctedLegalEntityLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCorrectedLegalEntityLocalKey(TextCriterionType value) {
        this.correctedLegalEntityLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad creationDate.
     * 
     * @return
     *     possible object is
     *     {@link DateCriterionType }
     *     
     */
    public DateCriterionType getCreationDate() {
        return creationDate;
    }

    /**
     * Define el valor de la propiedad creationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCriterionType }
     *     
     */
    public void setCreationDate(DateCriterionType value) {
        this.creationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad creationUser.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCreationUser() {
        return creationUser;
    }

    /**
     * Define el valor de la propiedad creationUser.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCreationUser(TextCriterionType value) {
        this.creationUser = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowLevel.
     * 
     * @return
     *     possible object is
     *     {@link NumberCriterionType }
     *     
     */
    public NumberCriterionType getCurrentWorkflowLevel() {
        return currentWorkflowLevel;
    }

    /**
     * Define el valor de la propiedad currentWorkflowLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link NumberCriterionType }
     *     
     */
    public void setCurrentWorkflowLevel(NumberCriterionType value) {
        this.currentWorkflowLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowOrganisation.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCurrentWorkflowOrganisation() {
        return currentWorkflowOrganisation;
    }

    /**
     * Define el valor de la propiedad currentWorkflowOrganisation.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCurrentWorkflowOrganisation(TextCriterionType value) {
        this.currentWorkflowOrganisation = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowStatus.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCurrentWorkflowStatus() {
        return currentWorkflowStatus;
    }

    /**
     * Define el valor de la propiedad currentWorkflowStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCurrentWorkflowStatus(TextCriterionType value) {
        this.currentWorkflowStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad customerOnly.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorCriterionType }
     *     
     */
    public IndicatorCriterionType getCustomerOnly() {
        return customerOnly;
    }

    /**
     * Define el valor de la propiedad customerOnly.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorCriterionType }
     *     
     */
    public void setCustomerOnly(IndicatorCriterionType value) {
        this.customerOnly = value;
    }

    /**
     * Obtiene el valor de la propiedad firstName.
     * 
     * @return
     *     possible object is
     *     {@link OracleTextCriterionType }
     *     
     */
    public OracleTextCriterionType getFirstName() {
        return firstName;
    }

    /**
     * Define el valor de la propiedad firstName.
     * 
     * @param value
     *     allowed object is
     *     {@link OracleTextCriterionType }
     *     
     */
    public void setFirstName(OracleTextCriterionType value) {
        this.firstName = value;
    }

    /**
     * Obtiene el valor de la propiedad identificationNum.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getIdentificationNum() {
        return identificationNum;
    }

    /**
     * Define el valor de la propiedad identificationNum.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setIdentificationNum(TextCriterionType value) {
        this.identificationNum = value;
    }

    /**
     * Obtiene el valor de la propiedad legalEntityFpoType.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getLegalEntityFpoType() {
        return legalEntityFpoType;
    }

    /**
     * Define el valor de la propiedad legalEntityFpoType.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setLegalEntityFpoType(TextCriterionType value) {
        this.legalEntityFpoType = value;
    }

    /**
     * Obtiene el valor de la propiedad legalForm.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getLegalForm() {
        return legalForm;
    }

    /**
     * Define el valor de la propiedad legalForm.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setLegalForm(TextCriterionType value) {
        this.legalForm = value;
    }

    /**
     * Obtiene el valor de la propiedad legalFormFpoType.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getLegalFormFpoType() {
        return legalFormFpoType;
    }

    /**
     * Define el valor de la propiedad legalFormFpoType.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setLegalFormFpoType(TextCriterionType value) {
        this.legalFormFpoType = value;
    }

    /**
     * Obtiene el valor de la propiedad legalType.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getLegalType() {
        return legalType;
    }

    /**
     * Define el valor de la propiedad legalType.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setLegalType(TextCriterionType value) {
        this.legalType = value;
    }

    /**
     * Obtiene el valor de la propiedad lot.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getLot() {
        return lot;
    }

    /**
     * Define el valor de la propiedad lot.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setLot(TextCriterionType value) {
        this.lot = value;
    }

    /**
     * Obtiene el valor de la propiedad matriculeNum.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getMatriculeNum() {
        return matriculeNum;
    }

    /**
     * Define el valor de la propiedad matriculeNum.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setMatriculeNum(TextCriterionType value) {
        this.matriculeNum = value;
    }

    /**
     * Obtiene el valor de la propiedad modificationDate.
     * 
     * @return
     *     possible object is
     *     {@link DateCriterionType }
     *     
     */
    public DateCriterionType getModificationDate() {
        return modificationDate;
    }

    /**
     * Define el valor de la propiedad modificationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCriterionType }
     *     
     */
    public void setModificationDate(DateCriterionType value) {
        this.modificationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad modificationUser.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getModificationUser() {
        return modificationUser;
    }

    /**
     * Define el valor de la propiedad modificationUser.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setModificationUser(TextCriterionType value) {
        this.modificationUser = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setName(TextCriterionType value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad ngoFlag.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorCriterionType }
     *     
     */
    public IndicatorCriterionType getNgoFlag() {
        return ngoFlag;
    }

    /**
     * Define el valor de la propiedad ngoFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorCriterionType }
     *     
     */
    public void setNgoFlag(IndicatorCriterionType value) {
        this.ngoFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad officialName.
     * 
     * @return
     *     possible object is
     *     {@link OracleTextCriterionType }
     *     
     */
    public OracleTextCriterionType getOfficialName() {
        return officialName;
    }

    /**
     * Define el valor de la propiedad officialName.
     * 
     * @param value
     *     allowed object is
     *     {@link OracleTextCriterionType }
     *     
     */
    public void setOfficialName(OracleTextCriterionType value) {
        this.officialName = value;
    }

    /**
     * Obtiene el valor de la propiedad officialAddressCity.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getOfficialAddressCity() {
        return officialAddressCity;
    }

    /**
     * Define el valor de la propiedad officialAddressCity.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setOfficialAddressCity(TextCriterionType value) {
        this.officialAddressCity = value;
    }

    /**
     * Obtiene el valor de la propiedad officialAddressCountryCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getOfficialAddressCountryCode() {
        return officialAddressCountryCode;
    }

    /**
     * Define el valor de la propiedad officialAddressCountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setOfficialAddressCountryCode(TextCriterionType value) {
        this.officialAddressCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad officialAddressPostCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getOfficialAddressPostCode() {
        return officialAddressPostCode;
    }

    /**
     * Define el valor de la propiedad officialAddressPostCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setOfficialAddressPostCode(TextCriterionType value) {
        this.officialAddressPostCode = value;
    }

    /**
     * Obtiene el valor de la propiedad officialAddressStreetNr.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getOfficialAddressStreetNr() {
        return officialAddressStreetNr;
    }

    /**
     * Define el valor de la propiedad officialAddressStreetNr.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setOfficialAddressStreetNr(TextCriterionType value) {
        this.officialAddressStreetNr = value;
    }

    /**
     * Obtiene el valor de la propiedad registrationAuth.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getRegistrationAuth() {
        return registrationAuth;
    }

    /**
     * Define el valor de la propiedad registrationAuth.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setRegistrationAuth(TextCriterionType value) {
        this.registrationAuth = value;
    }

    /**
     * Obtiene el valor de la propiedad registrationCountryCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getRegistrationCountryCode() {
        return registrationCountryCode;
    }

    /**
     * Define el valor de la propiedad registrationCountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setRegistrationCountryCode(TextCriterionType value) {
        this.registrationCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad registrationDate.
     * 
     * @return
     *     possible object is
     *     {@link DateCriterionType }
     *     
     */
    public DateCriterionType getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Define el valor de la propiedad registrationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCriterionType }
     *     
     */
    public void setRegistrationDate(DateCriterionType value) {
        this.registrationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad registrationNumber.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Define el valor de la propiedad registrationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setRegistrationNumber(TextCriterionType value) {
        this.registrationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleUsers.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getResponsibleUsers() {
        return responsibleUsers;
    }

    /**
     * Define el valor de la propiedad responsibleUsers.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setResponsibleUsers(TextCriterionType value) {
        this.responsibleUsers = value;
    }

    /**
     * Obtiene el valor de la propiedad vat.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getVat() {
        return vat;
    }

    /**
     * Define el valor de la propiedad vat.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setVat(TextCriterionType value) {
        this.vat = value;
    }

    /**
     * Obtiene el valor de la propiedad linkStatusCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getLinkStatusCode() {
        return linkStatusCode;
    }

    /**
     * Define el valor de la propiedad linkStatusCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setLinkStatusCode(TextCriterionType value) {
        this.linkStatusCode = value;
    }

    /**
     * Obtiene el valor de la propiedad nationalIdNumber.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getNationalIdNumber() {
        return nationalIdNumber;
    }

    /**
     * Define el valor de la propiedad nationalIdNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setNationalIdNumber(TextCriterionType value) {
        this.nationalIdNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad nationalIdIssuingCountryCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getNationalIdIssuingCountryCode() {
        return nationalIdIssuingCountryCode;
    }

    /**
     * Define el valor de la propiedad nationalIdIssuingCountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setNationalIdIssuingCountryCode(TextCriterionType value) {
        this.nationalIdIssuingCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad passportNumber.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getPassportNumber() {
        return passportNumber;
    }

    /**
     * Define el valor de la propiedad passportNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setPassportNumber(TextCriterionType value) {
        this.passportNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad passportIssuingCountryCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getPassportIssuingCountryCode() {
        return passportIssuingCountryCode;
    }

    /**
     * Define el valor de la propiedad passportIssuingCountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setPassportIssuingCountryCode(TextCriterionType value) {
        this.passportIssuingCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad driverLicenseNumber.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    /**
     * Define el valor de la propiedad driverLicenseNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setDriverLicenseNumber(TextCriterionType value) {
        this.driverLicenseNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad driverLicenseIssuingCountryCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getDriverLicenseIssuingCountryCode() {
        return driverLicenseIssuingCountryCode;
    }

    /**
     * Define el valor de la propiedad driverLicenseIssuingCountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setDriverLicenseIssuingCountryCode(TextCriterionType value) {
        this.driverLicenseIssuingCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad identityCardNumber.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getIdentityCardNumber() {
        return identityCardNumber;
    }

    /**
     * Define el valor de la propiedad identityCardNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setIdentityCardNumber(TextCriterionType value) {
        this.identityCardNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad identityCardIssuingCountryCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getIdentityCardIssuingCountryCode() {
        return identityCardIssuingCountryCode;
    }

    /**
     * Define el valor de la propiedad identityCardIssuingCountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setIdentityCardIssuingCountryCode(TextCriterionType value) {
        this.identityCardIssuingCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad otherDocumentNumber.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getOtherDocumentNumber() {
        return otherDocumentNumber;
    }

    /**
     * Define el valor de la propiedad otherDocumentNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setOtherDocumentNumber(TextCriterionType value) {
        this.otherDocumentNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad otherDocumentIssuingCountryCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getOtherDocumentIssuingCountryCode() {
        return otherDocumentIssuingCountryCode;
    }

    /**
     * Define el valor de la propiedad otherDocumentIssuingCountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setOtherDocumentIssuingCountryCode(TextCriterionType value) {
        this.otherDocumentIssuingCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad anyDocumentNumber.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getAnyDocumentNumber() {
        return anyDocumentNumber;
    }

    /**
     * Define el valor de la propiedad anyDocumentNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setAnyDocumentNumber(TextCriterionType value) {
        this.anyDocumentNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad anyDocumentIssuingCountryCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getAnyDocumentIssuingCountryCode() {
        return anyDocumentIssuingCountryCode;
    }

    /**
     * Define el valor de la propiedad anyDocumentIssuingCountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setAnyDocumentIssuingCountryCode(TextCriterionType value) {
        this.anyDocumentIssuingCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad wholeName.
     * 
     * @return
     *     possible object is
     *     {@link OracleTextCriterionType }
     *     
     */
    public OracleTextCriterionType getWholeName() {
        return wholeName;
    }

    /**
     * Define el valor de la propiedad wholeName.
     * 
     * @param value
     *     allowed object is
     *     {@link OracleTextCriterionType }
     *     
     */
    public void setWholeName(OracleTextCriterionType value) {
        this.wholeName = value;
    }

}
