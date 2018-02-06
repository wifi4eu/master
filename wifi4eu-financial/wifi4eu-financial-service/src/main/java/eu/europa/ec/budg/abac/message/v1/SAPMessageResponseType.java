
package eu.europa.ec.budg.abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SAPMessageResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SAPMessageResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="JMSCorrelationId" type="{http://www.ec.europa.eu/budg/abac/message/v1}JMSCorrelationIdType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SAPMessageResponseType", propOrder = {
    "jmsCorrelationId"
})
public abstract class SAPMessageResponseType
    extends BusinessRuleMessageResponseType
{

    @XmlElement(name = "JMSCorrelationId")
    protected String jmsCorrelationId;

    /**
     * Obtiene el valor de la propiedad jmsCorrelationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJMSCorrelationId() {
        return jmsCorrelationId;
    }

    /**
     * Define el valor de la propiedad jmsCorrelationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJMSCorrelationId(String value) {
        this.jmsCorrelationId = value;
    }

}
