
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para SAPMessageRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SAPMessageRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="JMSCorrelationId" type="{http://www.ec.europa.eu/budg/abac/message/v1}JMSCorrelationIdType" minOccurs="0"/&gt;
 *         &lt;element name="LastModificationDateTime" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateTimeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SAPMessageRequestType", propOrder = {
    "jmsCorrelationId",
    "lastModificationDateTime"
})
public abstract class SAPMessageRequestType
    extends BusinessRuleMessageRequestType
{

    @XmlElement(name = "JMSCorrelationId")
    protected String jmsCorrelationId;
    @XmlElement(name = "LastModificationDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModificationDateTime;

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

    /**
     * Obtiene el valor de la propiedad lastModificationDateTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModificationDateTime() {
        return lastModificationDateTime;
    }

    /**
     * Define el valor de la propiedad lastModificationDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModificationDateTime(XMLGregorianCalendar value) {
        this.lastModificationDateTime = value;
    }

}
