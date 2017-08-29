
package abac.legal_entity.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para RegistrationInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RegistrationInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RegistrationAuthority" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}RegistrationAuthorityType" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationDate" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}RegistrationDateType" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationIso2CountryCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}Iso2CodeType" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationNumber" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}RegistrationNumberType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistrationInfoType", propOrder = {
    "registrationAuthority",
    "registrationDate",
    "registrationIso2CountryCode",
    "registrationNumber"
})
public class RegistrationInfoType {

    @XmlElement(name = "RegistrationAuthority")
    protected String registrationAuthority;
    @XmlElement(name = "RegistrationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar registrationDate;
    @XmlElement(name = "RegistrationIso2CountryCode")
    protected String registrationIso2CountryCode;
    @XmlElement(name = "RegistrationNumber")
    protected String registrationNumber;

    /**
     * Obtiene el valor de la propiedad registrationAuthority.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    /**
     * Define el valor de la propiedad registrationAuthority.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationAuthority(String value) {
        this.registrationAuthority = value;
    }

    /**
     * Obtiene el valor de la propiedad registrationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Define el valor de la propiedad registrationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegistrationDate(XMLGregorianCalendar value) {
        this.registrationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad registrationIso2CountryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationIso2CountryCode() {
        return registrationIso2CountryCode;
    }

    /**
     * Define el valor de la propiedad registrationIso2CountryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationIso2CountryCode(String value) {
        this.registrationIso2CountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad registrationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Define el valor de la propiedad registrationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationNumber(String value) {
        this.registrationNumber = value;
    }

}
