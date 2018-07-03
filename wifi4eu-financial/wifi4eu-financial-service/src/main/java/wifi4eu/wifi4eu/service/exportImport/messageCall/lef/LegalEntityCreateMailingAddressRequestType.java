
package wifi4eu.wifi4eu.service.exportImport.messageCall.lef;

import eu.europa.ec.budg.abac.message.v1.MessageRequestType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegalEntityCreateMailingAddressRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityCreateMailingAddressRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="MailingAddress" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}MailingAddressType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityCreateMailingAddressRequestType", propOrder = {
    "localKey",
    "mailingAddress"
})
public class LegalEntityCreateMailingAddressRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "MailingAddress", required = true)
    protected MailingAddressType mailingAddress;

    /**
     * Obtiene el valor de la propiedad localKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalKey() {
        return localKey;
    }

    /**
     * Define el valor de la propiedad localKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalKey(String value) {
        this.localKey = value;
    }

    /**
     * Obtiene el valor de la propiedad mailingAddress.
     * 
     * @return
     *     possible object is
     *     {@link MailingAddressType }
     *     
     */
    public MailingAddressType getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Define el valor de la propiedad mailingAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link MailingAddressType }
     *     
     */
    public void setMailingAddress(MailingAddressType value) {
        this.mailingAddress = value;
    }

}
