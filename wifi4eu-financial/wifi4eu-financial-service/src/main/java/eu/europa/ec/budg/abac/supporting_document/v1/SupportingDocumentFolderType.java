
package eu.europa.ec.budg.abac.supporting_document.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para SupportingDocumentFolderType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SupportingDocumentFolderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Date" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}DescriptionType" minOccurs="0"/&gt;
 *         &lt;element name="Location" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}LocationType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleName" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}ResponsibleNameType" minOccurs="0"/&gt;
 *         &lt;element name="SupportingDocuments" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SupportingDocument" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}SupportingDocumentType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "SupportingDocumentFolderType", propOrder = {
    "date",
    "description",
    "location",
    "responsibleName",
    "supportingDocuments",
    "version"
})
public class SupportingDocumentFolderType {

    @XmlElement(name = "Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "ResponsibleName")
    protected String responsibleName;
    @XmlElement(name = "SupportingDocuments")
    protected SupportingDocuments supportingDocuments;
    @XmlElement(name = "Version")
    protected String version;

    /**
     * Obtiene el valor de la propiedad date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
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
     * Obtiene el valor de la propiedad responsibleName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleName() {
        return responsibleName;
    }

    /**
     * Define el valor de la propiedad responsibleName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleName(String value) {
        this.responsibleName = value;
    }

    /**
     * Obtiene el valor de la propiedad supportingDocuments.
     * 
     * @return
     *     possible object is
     *     {@link SupportingDocuments }
     *     
     */
    public SupportingDocuments getSupportingDocuments() {
        return supportingDocuments;
    }

    /**
     * Define el valor de la propiedad supportingDocuments.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportingDocuments }
     *     
     */
    public void setSupportingDocuments(SupportingDocuments value) {
        this.supportingDocuments = value;
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
     *         &lt;element name="SupportingDocument" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}SupportingDocumentType" maxOccurs="unbounded"/&gt;
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
        "supportingDocument"
    })
    public static class SupportingDocuments {

        @XmlElement(name = "SupportingDocument", required = true)
        protected List<SupportingDocumentType> supportingDocument;

        /**
         * Gets the value of the supportingDocument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the supportingDocument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSupportingDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SupportingDocumentType }
         * 
         * 
         */
        public List<SupportingDocumentType> getSupportingDocument() {
            if (supportingDocument == null) {
                supportingDocument = new ArrayList<SupportingDocumentType>();
            }
            return this.supportingDocument;
        }

    }

}
