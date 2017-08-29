
package abac.scanned_document.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ScannedDocumentType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ScannedDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ScannedDocumentWithoutContentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BinaryData" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}BinaryDataType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScannedDocumentType", propOrder = {
    "binaryData"
})
public class ScannedDocumentType
    extends ScannedDocumentWithoutContentType
{

    @XmlElement(name = "BinaryData")
    protected BinaryDataType binaryData;

    /**
     * Obtiene el valor de la propiedad binaryData.
     * 
     * @return
     *     possible object is
     *     {@link BinaryDataType }
     *     
     */
    public BinaryDataType getBinaryData() {
        return binaryData;
    }

    /**
     * Define el valor de la propiedad binaryData.
     * 
     * @param value
     *     allowed object is
     *     {@link BinaryDataType }
     *     
     */
    public void setBinaryData(BinaryDataType value) {
        this.binaryData = value;
    }

}
