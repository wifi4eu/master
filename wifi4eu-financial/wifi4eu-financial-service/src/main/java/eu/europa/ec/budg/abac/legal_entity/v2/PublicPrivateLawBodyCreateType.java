
package eu.europa.ec.budg.abac.legal_entity.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PublicPrivateLawBodyCreateType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PublicPrivateLawBodyCreateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntityCreateType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Acronym" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}AcronymType" minOccurs="0"/&gt;
 *         &lt;element name="BusinessName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}BusinessNameType" minOccurs="0"/&gt;
 *         &lt;element name="FpoTypeCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}FpoTypeCodeType" minOccurs="0"/&gt;
 *         &lt;element name="IsNgo" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}IsNgoType" minOccurs="0"/&gt;
 *         &lt;element name="LegalFormCode" type="{http://www.ec.europa.eu/budg/abac/legal_form/v1}LegalFormCodeType" minOccurs="0"/&gt;
 *         &lt;element name="MainRegistrationInfo" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}RegistrationInfoType" minOccurs="0"/&gt;
 *         &lt;element name="MainVatNumber" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}VatNumberType" minOccurs="0"/&gt;
 *         &lt;element name="OfficialName4" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}OfficialName4Type" minOccurs="0"/&gt;
 *         &lt;element name="SecondaryRegistrationNumber" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}SecondaryRegistrationNumberType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicPrivateLawBodyCreateType", propOrder = {
    "acronym",
    "businessName",
    "fpoTypeCode",
    "isNgo",
    "legalFormCode",
    "mainRegistrationInfo",
    "mainVatNumber",
    "officialName4",
    "secondaryRegistrationNumber"
})
@XmlSeeAlso({
    PublicLawBodyCreateType.class,
    PrivateLawBodyCreateType.class
})
public abstract class PublicPrivateLawBodyCreateType
    extends LegalEntityCreateType
{

    @XmlElement(name = "Acronym")
    protected String acronym;
    @XmlElement(name = "BusinessName")
    protected String businessName;
    @XmlElement(name = "FpoTypeCode")
    protected String fpoTypeCode;
    @XmlElement(name = "IsNgo")
    protected Boolean isNgo;
    @XmlElement(name = "LegalFormCode")
    protected String legalFormCode;
    @XmlElement(name = "MainRegistrationInfo")
    protected RegistrationInfoType mainRegistrationInfo;
    @XmlElement(name = "MainVatNumber")
    protected String mainVatNumber;
    @XmlElement(name = "OfficialName4")
    protected String officialName4;
    @XmlElement(name = "SecondaryRegistrationNumber")
    protected String secondaryRegistrationNumber;

    /**
     * Obtiene el valor de la propiedad acronym.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * Define el valor de la propiedad acronym.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcronym(String value) {
        this.acronym = value;
    }

    /**
     * Obtiene el valor de la propiedad businessName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * Define el valor de la propiedad businessName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessName(String value) {
        this.businessName = value;
    }

    /**
     * Obtiene el valor de la propiedad fpoTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFpoTypeCode() {
        return fpoTypeCode;
    }

    /**
     * Define el valor de la propiedad fpoTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFpoTypeCode(String value) {
        this.fpoTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad isNgo.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNgo() {
        return isNgo;
    }

    /**
     * Define el valor de la propiedad isNgo.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNgo(Boolean value) {
        this.isNgo = value;
    }

    /**
     * Obtiene el valor de la propiedad legalFormCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalFormCode() {
        return legalFormCode;
    }

    /**
     * Define el valor de la propiedad legalFormCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalFormCode(String value) {
        this.legalFormCode = value;
    }

    /**
     * Obtiene el valor de la propiedad mainRegistrationInfo.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationInfoType }
     *     
     */
    public RegistrationInfoType getMainRegistrationInfo() {
        return mainRegistrationInfo;
    }

    /**
     * Define el valor de la propiedad mainRegistrationInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationInfoType }
     *     
     */
    public void setMainRegistrationInfo(RegistrationInfoType value) {
        this.mainRegistrationInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad mainVatNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainVatNumber() {
        return mainVatNumber;
    }

    /**
     * Define el valor de la propiedad mainVatNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainVatNumber(String value) {
        this.mainVatNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad officialName4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficialName4() {
        return officialName4;
    }

    /**
     * Define el valor de la propiedad officialName4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficialName4(String value) {
        this.officialName4 = value;
    }

    /**
     * Obtiene el valor de la propiedad secondaryRegistrationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryRegistrationNumber() {
        return secondaryRegistrationNumber;
    }

    /**
     * Define el valor de la propiedad secondaryRegistrationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryRegistrationNumber(String value) {
        this.secondaryRegistrationNumber = value;
    }

}
