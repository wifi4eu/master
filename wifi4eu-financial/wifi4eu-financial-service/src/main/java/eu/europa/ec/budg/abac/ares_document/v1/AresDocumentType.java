
package eu.europa.ec.budg.abac.ares_document.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AresDocumentType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AresDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}DescriptionType" minOccurs="0"/&gt;
 *         &lt;element name="OfficialDocument" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}OfficialDocumentType"/&gt;
 *         &lt;element name="Reference" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}ReferenceType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AresDocumentType", propOrder = {
    "description",
    "officialDocument",
    "reference"
})
public class AresDocumentType {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "OfficialDocument")
    protected boolean officialDocument;
    @XmlElement(name = "Reference", required = true)
    protected String reference;

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
     * Obtiene el valor de la propiedad officialDocument.
     * 
     */
    public boolean isOfficialDocument() {
        return officialDocument;
    }

    /**
     * Define el valor de la propiedad officialDocument.
     * 
     */
    public void setOfficialDocument(boolean value) {
        this.officialDocument = value;
    }

    /**
     * Obtiene el valor de la propiedad reference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Define el valor de la propiedad reference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

}
