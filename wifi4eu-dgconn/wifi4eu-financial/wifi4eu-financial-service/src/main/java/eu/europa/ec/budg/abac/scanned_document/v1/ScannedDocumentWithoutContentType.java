
package eu.europa.ec.budg.abac.scanned_document.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ScannedDocumentWithoutContentType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ScannedDocumentWithoutContentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LineNumber" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}LineNumberType" minOccurs="0"/&gt;
 *         &lt;element name="ListType" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ListTypeType" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}DescriptionType" minOccurs="0"/&gt;
 *         &lt;element name="FormatType" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}FormatTypeType" minOccurs="0"/&gt;
 *         &lt;element name="OfficialDocument" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}OfficialDocumentType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScannedDocumentWithoutContentType", propOrder = {
    "lineNumber",
    "listType",
    "description",
    "formatType",
    "officialDocument"
})
@XmlSeeAlso({
    ScannedDocumentType.class
})
public class ScannedDocumentWithoutContentType {

    @XmlElement(name = "LineNumber")
    protected BigInteger lineNumber;
    @XmlElement(name = "ListType")
    protected String listType;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "FormatType")
    protected String formatType;
    @XmlElement(name = "OfficialDocument")
    protected boolean officialDocument;

    /**
     * Obtiene el valor de la propiedad lineNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLineNumber() {
        return lineNumber;
    }

    /**
     * Define el valor de la propiedad lineNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLineNumber(BigInteger value) {
        this.lineNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad listType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListType() {
        return listType;
    }

    /**
     * Define el valor de la propiedad listType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListType(String value) {
        this.listType = value;
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
     * Obtiene el valor de la propiedad formatType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatType() {
        return formatType;
    }

    /**
     * Define el valor de la propiedad formatType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatType(String value) {
        this.formatType = value;
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

}
