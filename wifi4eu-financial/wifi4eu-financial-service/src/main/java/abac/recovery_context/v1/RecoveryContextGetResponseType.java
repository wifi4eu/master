
package abac.recovery_context.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import abac.message.v1.MessageResponseType;


/**
 * <p>Clase Java para RecoveryContextGetResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RecoveryContextGetResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RecoveryContext" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}RecoveryContextGetType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecoveryContextGetResponseType", propOrder = {
    "recoveryContext"
})
public class RecoveryContextGetResponseType
    extends MessageResponseType
{

    @XmlElement(name = "RecoveryContext", required = true)
    protected RecoveryContextGetType recoveryContext;

    /**
     * Obtiene el valor de la propiedad recoveryContext.
     * 
     * @return
     *     possible object is
     *     {@link RecoveryContextGetType }
     *     
     */
    public RecoveryContextGetType getRecoveryContext() {
        return recoveryContext;
    }

    /**
     * Define el valor de la propiedad recoveryContext.
     * 
     * @param value
     *     allowed object is
     *     {@link RecoveryContextGetType }
     *     
     */
    public void setRecoveryContext(RecoveryContextGetType value) {
        this.recoveryContext = value;
    }

}
