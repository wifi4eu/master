
package eu.europa.ec.budg.abac.legal_entity.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import eu.europa.ec.budg.abac.organisation.v1.ResponsibleOrganisationType;
import eu.europa.ec.budg.abac.address.v1.LegalEntityAddressType;


/**
 * <p>Clase Java para LegalEntityWritableType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityWritableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountGroupCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}AccountGroupCodeType"/&gt;
 *         &lt;element name="DuplicateCheckBypassFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="IsACustomerOnly" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}IsACustomerOnlyType" minOccurs="0"/&gt;
 *         &lt;element name="LanguageCode" type="{http://www.ec.europa.eu/budg/abac/language/v1}CodeType"/&gt;
 *         &lt;element name="LightValidationFlag" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="LightValidationContext" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LightValidationContextType" minOccurs="0"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}RemarksType" minOccurs="0"/&gt;
 *         &lt;element name="MailingAddressOption" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}MailingAddressOptionType" minOccurs="0"/&gt;
 *         &lt;element name="OfficialName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}OfficialNameType"/&gt;
 *         &lt;element name="OfficialName2" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}OfficialName2Type" minOccurs="0"/&gt;
 *         &lt;element name="OfficialName3" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}OfficialName3Type" minOccurs="0"/&gt;
 *         &lt;element name="OfficialAddress" type="{http://www.ec.europa.eu/budg/abac/address/v1}LegalEntityAddressType"/&gt;
 *         &lt;element name="OriginalLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}ResponsibleOrganisationType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityWritableType", propOrder = {
    "accountGroupCode",
    "duplicateCheckBypassFlag",
    "isACustomerOnly",
    "languageCode",
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
    "responsibleOrganisation"
})
@XmlSeeAlso({
    PublicPrivateLawBodyWritableType.class,
    NaturalPersonWritableType.class,
    LegalEntityCreateType.class
})
public abstract class LegalEntityWritableType {

    @XmlElement(name = "AccountGroupCode", required = true)
    protected String accountGroupCode;
    @XmlElement(name = "DuplicateCheckBypassFlag")
    protected Boolean duplicateCheckBypassFlag;
    @XmlElement(name = "IsACustomerOnly")
    protected Boolean isACustomerOnly;
    @XmlElement(name = "LanguageCode", required = true)
    protected String languageCode;
    @XmlElement(name = "LightValidationFlag")
    protected Boolean lightValidationFlag;
    @XmlElement(name = "LightValidationContext")
    protected String lightValidationContext;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "MailingAddressOption")
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
     * Obtiene el valor de la propiedad isACustomerOnly.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsACustomerOnly() {
        return isACustomerOnly;
    }

    /**
     * Define el valor de la propiedad isACustomerOnly.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsACustomerOnly(Boolean value) {
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

}
