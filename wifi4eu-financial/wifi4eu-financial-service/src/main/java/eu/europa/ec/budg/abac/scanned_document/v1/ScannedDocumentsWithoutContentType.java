
package eu.europa.ec.budg.abac.scanned_document.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ScannedDocumentsWithoutContentType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ScannedDocumentsWithoutContentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ScannedDocument" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ScannedDocumentWithoutContentType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScannedDocumentsWithoutContentType", propOrder = {
    "scannedDocument"
})
public class ScannedDocumentsWithoutContentType {

    @XmlElement(name = "ScannedDocument", required = true)
    protected List<ScannedDocumentWithoutContentType> scannedDocument;

    /**
     * Gets the value of the scannedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scannedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScannedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScannedDocumentWithoutContentType }
     * 
     * 
     */
    public List<ScannedDocumentWithoutContentType> getScannedDocument() {
        if (scannedDocument == null) {
            scannedDocument = new ArrayList<ScannedDocumentWithoutContentType>();
        }
        return this.scannedDocument;
    }

}
