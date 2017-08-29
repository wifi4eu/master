
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.supporting_document.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para SupportingDocumentType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SupportingDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CreationDate" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}CreationDateType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}DescriptionType" minOccurs="0"/&gt;
 *         &lt;element name="DocumentNumber" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}DocumentNumberType"/&gt;
 *         &lt;element name="DocumentType" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}DocumentTypeType"/&gt;
 *         &lt;element name="Location" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}LocationType" minOccurs="0"/&gt;
 *         &lt;element name="Remark" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}RemarkType" minOccurs="0"/&gt;
 *         &lt;element name="Version" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}VersionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupportingDocumentType", propOrder = {
    "creationDate",
    "description",
    "documentNumber",
    "documentType",
    "location",
    "remark",
    "version"
})
public class SupportingDocumentType {

    @XmlElement(name = "CreationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "DocumentNumber", required = true)
    protected BigInteger documentNumber;
    @XmlElement(name = "DocumentType", required = true)
    protected String documentType;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "Remark")
    protected String remark;
    @XmlElement(name = "Version")
    protected String version;

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
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad documentNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDocumentNumber() {
        return documentNumber;
    }

    /**
     * Define el valor de la propiedad documentNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDocumentNumber(BigInteger value) {
        this.documentNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad documentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Define el valor de la propiedad documentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentType(String value) {
        this.documentType = value;
    }

    /**
     * Obtiene el valor de la propiedad location.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Define el valor de la propiedad location.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Obtiene el valor de la propiedad remark.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Define el valor de la propiedad remark.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
