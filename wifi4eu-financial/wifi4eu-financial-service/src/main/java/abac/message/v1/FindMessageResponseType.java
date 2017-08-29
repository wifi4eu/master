
package abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FindMessageResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FindMessageResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rowCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindMessageResponseType", propOrder = {
    "rowCount"
})
public class FindMessageResponseType
    extends MessageResponseType
{

    protected int rowCount;

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

}
