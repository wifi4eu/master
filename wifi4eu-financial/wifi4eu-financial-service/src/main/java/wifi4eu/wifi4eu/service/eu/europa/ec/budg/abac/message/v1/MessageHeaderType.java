
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MessageHeaderType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MessageHeaderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageCorrelationId" type="{http://www.ec.europa.eu/budg/abac/message/v1}MessageCorrelationIdType" minOccurs="0"/&gt;
 *         &lt;element name="AgentId" type="{http://www.ec.europa.eu/budg/abac/message/v1}UserIdType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageHeaderType", propOrder = {
    "messageCorrelationId",
    "agentId"
})
public class MessageHeaderType {

    @XmlElement(name = "MessageCorrelationId")
    protected String messageCorrelationId;
    @XmlElement(name = "AgentId")
    protected String agentId;

    /**
     * Obtiene el valor de la propiedad messageCorrelationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageCorrelationId() {
        return messageCorrelationId;
    }

    /**
     * Define el valor de la propiedad messageCorrelationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageCorrelationId(String value) {
        this.messageCorrelationId = value;
    }

    /**
     * Obtiene el valor de la propiedad agentId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * Define el valor de la propiedad agentId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentId(String value) {
        this.agentId = value;
    }

}
