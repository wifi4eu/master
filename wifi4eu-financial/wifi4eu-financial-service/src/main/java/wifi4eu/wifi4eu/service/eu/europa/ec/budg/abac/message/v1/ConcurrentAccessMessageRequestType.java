
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para ConcurrentAccessMessageRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConcurrentAccessMessageRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LastModificationDateTime" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateTimeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConcurrentAccessMessageRequestType", propOrder = {
    "lastModificationDateTime"
})
public abstract class ConcurrentAccessMessageRequestType
    extends BusinessRuleMessageRequestType
{

    @XmlElement(name = "LastModificationDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModificationDateTime;

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
