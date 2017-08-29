
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2.LegalEntitySearchResponseType;


/**
 * <p>Clase Java para SearchMessageResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SearchMessageResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fullRowCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="rowCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="currentIndex" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchMessageResponseType", propOrder = {
    "fullRowCount",
    "rowCount",
    "currentIndex"
})
@XmlSeeAlso({
    LegalEntitySearchResponseType.class
})
public class SearchMessageResponseType
    extends MessageResponseType
{

    protected int fullRowCount;
    protected int rowCount;
    protected int currentIndex;

    /**
     * Obtiene el valor de la propiedad fullRowCount.
     * 
     */
    public int getFullRowCount() {
        return fullRowCount;
    }

    /**
     * Define el valor de la propiedad fullRowCount.
     * 
     */
    public void setFullRowCount(int value) {
        this.fullRowCount = value;
    }

    /**
     * Obtiene el valor de la propiedad rowCount.
     * 
     */
    public int getRowCount() {
        return rowCount;
    }

    /**
     * Define el valor de la propiedad rowCount.
     * 
     */
    public void setRowCount(int value) {
        this.rowCount = value;
    }

    /**
     * Obtiene el valor de la propiedad currentIndex.
     * 
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
     * Define el valor de la propiedad currentIndex.
     * 
     */
    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

}
