
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.complex_type.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para AuditInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AuditInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CreationDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}CreationDateType"/&gt;
 *         &lt;element name="CreationUser" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}CreationUserType"/&gt;
 *         &lt;element name="ModificationDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}ModificationDateType"/&gt;
 *         &lt;element name="ModificationUser" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}ModificationUserType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditInfoType", propOrder = {
    "creationDate",
    "creationUser",
    "modificationDate",
    "modificationUser"
})
public class AuditInfoType {

    @XmlElement(name = "CreationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "CreationUser", required = true)
    protected String creationUser;
    @XmlElement(name = "ModificationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modificationDate;
    @XmlElement(name = "ModificationUser", required = true)
    protected String modificationUser;

    /**
     * Obtiene el valor de la propiedad creationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Define el valor de la propiedad creationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad creationUser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationUser() {
        return creationUser;
    }

    /**
     * Define el valor de la propiedad creationUser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationUser(String value) {
        this.creationUser = value;
    }

    /**
     * Obtiene el valor de la propiedad modificationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModificationDate() {
        return modificationDate;
    }

    /**
     * Define el valor de la propiedad modificationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModificationDate(XMLGregorianCalendar value) {
        this.modificationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad modificationUser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModificationUser() {
        return modificationUser;
    }

    /**
     * Define el valor de la propiedad modificationUser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModificationUser(String value) {
        this.modificationUser = value;
    }

}
