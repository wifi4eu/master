
package eu.europa.ec.budg.abac.central_reference.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para CentralReferenceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CentralReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CentralBlockingReason" type="{http://www.ec.europa.eu/budg/abac/central_reference/v1}CentralBlockingReasonType" minOccurs="0"/&gt;
 *         &lt;element name="CentralKey" type="{http://www.ec.europa.eu/budg/abac/central_reference/v1}CentralKeyType" minOccurs="0"/&gt;
 *         &lt;element name="CentralPostingDate" type="{http://www.ec.europa.eu/budg/abac/central_reference/v1}CentralPostingDateType" minOccurs="0"/&gt;
 *         &lt;element name="CentralStatus" type="{http://www.ec.europa.eu/budg/abac/central_reference/v1}CentralStatusType" minOccurs="0"/&gt;
 *         &lt;element name="CentralStatusDate" type="{http://www.ec.europa.eu/budg/abac/central_reference/v1}CentralStatusDateType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CentralReferenceType", propOrder = {
    "centralBlockingReason",
    "centralKey",
    "centralPostingDate",
    "centralStatus",
    "centralStatusDate"
})
public class CentralReferenceType {

    @XmlElement(name = "CentralBlockingReason")
    protected String centralBlockingReason;
    @XmlElement(name = "CentralKey")
    protected String centralKey;
    @XmlElement(name = "CentralPostingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar centralPostingDate;
    @XmlElement(name = "CentralStatus")
    protected String centralStatus;
    @XmlElement(name = "CentralStatusDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar centralStatusDate;

    /**
     * Obtiene el valor de la propiedad centralBlockingReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentralBlockingReason() {
        return centralBlockingReason;
    }

    /**
     * Define el valor de la propiedad centralBlockingReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentralBlockingReason(String value) {
        this.centralBlockingReason = value;
    }

    /**
     * Obtiene el valor de la propiedad centralKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentralKey() {
        return centralKey;
    }

    /**
     * Define el valor de la propiedad centralKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentralKey(String value) {
        this.centralKey = value;
    }

    /**
     * Obtiene el valor de la propiedad centralPostingDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCentralPostingDate() {
        return centralPostingDate;
    }

    /**
     * Define el valor de la propiedad centralPostingDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCentralPostingDate(XMLGregorianCalendar value) {
        this.centralPostingDate = value;
    }

    /**
     * Obtiene el valor de la propiedad centralStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentralStatus() {
        return centralStatus;
    }

    /**
     * Define el valor de la propiedad centralStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentralStatus(String value) {
        this.centralStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad centralStatusDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCentralStatusDate() {
        return centralStatusDate;
    }

    /**
     * Define el valor de la propiedad centralStatusDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCentralStatusDate(XMLGregorianCalendar value) {
        this.centralStatusDate = value;
    }

}
