
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchRequestType;


/**
 * <p>Clase Java para SearchMessageRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SearchMessageRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="blockingSize"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="startIndex" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchMessageRequestType", propOrder = {
    "blockingSize",
    "startIndex"
})
@XmlSeeAlso({
    LegalEntitySearchRequestType.class
})
public abstract class SearchMessageRequestType
    extends MessageRequestType
{

    protected int blockingSize;
    protected int startIndex;

    /**
     * Obtiene el valor de la propiedad blockingSize.
     * 
     */
    public int getBlockingSize() {
        return blockingSize;
    }

    /**
     * Define el valor de la propiedad blockingSize.
     * 
     */
    public void setBlockingSize(int value) {
        this.blockingSize = value;
    }

    /**
     * Obtiene el valor de la propiedad startIndex.
     * 
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Define el valor de la propiedad startIndex.
     * 
     */
    public void setStartIndex(int value) {
        this.startIndex = value;
    }

}
