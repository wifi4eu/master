
package abac.legal_entity.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PrivatePersonGetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PrivatePersonGetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}NaturalPersonGetType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BirthCity" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}BirthCityType" minOccurs="0"/&gt;
 *         &lt;element name="BusinessName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}BusinessNameType" minOccurs="0"/&gt;
 *         &lt;element name="IsSelfEmployed" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationInfo" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}RegistrationInfoType" minOccurs="0"/&gt;
 *         &lt;element name="VatNumber" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}VatNumberType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivatePersonGetType", propOrder = {
    "birthCity",
    "businessName",
    "isSelfEmployed",
    "registrationInfo",
    "vatNumber"
})
@XmlSeeAlso({
    ExStaffMemberGetType.class
})
public class PrivatePersonGetType
    extends NaturalPersonGetType
{

    @XmlElement(name = "BirthCity")
    protected String birthCity;
    @XmlElement(name = "BusinessName")
    protected String businessName;
    @XmlElement(name = "IsSelfEmployed")
    protected Boolean isSelfEmployed;
    @XmlElement(name = "RegistrationInfo")
    protected RegistrationInfoType registrationInfo;
    @XmlElement(name = "VatNumber")
    protected String vatNumber;

    /**
     * Obtiene el valor de la propiedad birthCity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthCity() {
        return birthCity;
    }

    /**
     * Define el valor de la propiedad birthCity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthCity(String value) {
        this.birthCity = value;
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
     * Obtiene el valor de la propiedad isSelfEmployed.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSelfEmployed() {
        return isSelfEmployed;
    }

    /**
     * Define el valor de la propiedad isSelfEmployed.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSelfEmployed(Boolean value) {
        this.isSelfEmployed = value;
    }

    /**
     * Obtiene el valor de la propiedad registrationInfo.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationInfoType }
     *     
     */
    public RegistrationInfoType getRegistrationInfo() {
        return registrationInfo;
    }

    /**
     * Define el valor de la propiedad registrationInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationInfoType }
     *     
     */
    public void setRegistrationInfo(RegistrationInfoType value) {
        this.registrationInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad vatNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatNumber() {
        return vatNumber;
    }

    /**
     * Define el valor de la propiedad vatNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatNumber(String value) {
        this.vatNumber = value;
    }

}
