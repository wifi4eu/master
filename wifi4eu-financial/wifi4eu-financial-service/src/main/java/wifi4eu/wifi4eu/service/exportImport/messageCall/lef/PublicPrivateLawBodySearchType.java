
package wifi4eu.wifi4eu.service.exportImport.messageCall.lef;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para PublicPrivateLawBodySearchType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PublicPrivateLawBodySearchType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntitySearchType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Acronym" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}AcronymType" minOccurs="0"/&gt;
 *         &lt;element name="BusinessName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}BusinessNameType" minOccurs="0"/&gt;
 *         &lt;element name="LegalFormCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MainRegistrationInfo" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}RegistrationInfoType" minOccurs="0"/&gt;
 *         &lt;element name="MainVatNumber" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}VatNumberType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicPrivateLawBodySearchType", propOrder = {
    "acronym",
    "businessName",
    "legalFormCode",
    "mainRegistrationInfo",
    "mainVatNumber"
})
@XmlSeeAlso({
    PublicLawBodySearchType.class,
    PrivateLawBodySearchType.class
})
public abstract class PublicPrivateLawBodySearchType
    extends LegalEntitySearchType
{

    @XmlElement(name = "Acronym")
    protected String acronym;
    @XmlElement(name = "BusinessName")
    protected String businessName;
    @XmlElement(name = "LegalFormCode")
    protected String legalFormCode;
    @XmlElement(name = "MainRegistrationInfo")
    protected RegistrationInfoType mainRegistrationInfo;
    @XmlElement(name = "MainVatNumber")
    protected String mainVatNumber;

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

}
