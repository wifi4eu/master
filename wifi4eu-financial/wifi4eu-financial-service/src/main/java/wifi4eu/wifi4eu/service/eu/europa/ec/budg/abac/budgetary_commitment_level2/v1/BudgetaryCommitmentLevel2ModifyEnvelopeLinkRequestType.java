
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.message.v1.MessageRequestType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2ModifyEnvelopeLinkRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2ModifyEnvelopeLinkRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="EnvelopeLink" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2EnvelopeLinkWritableType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2ModifyEnvelopeLinkRequestType", propOrder = {
    "localKey",
    "envelopeLink"
})
public class BudgetaryCommitmentLevel2ModifyEnvelopeLinkRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "EnvelopeLink", required = true)
    protected BudgetaryCommitmentLevel2EnvelopeLinkWritableType envelopeLink;

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
     * Obtiene el valor de la propiedad envelopeLink.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel2EnvelopeLinkWritableType }
     *     
     */
    public BudgetaryCommitmentLevel2EnvelopeLinkWritableType getEnvelopeLink() {
        return envelopeLink;
    }

    /**
     * Define el valor de la propiedad envelopeLink.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel2EnvelopeLinkWritableType }
     *     
     */
    public void setEnvelopeLink(BudgetaryCommitmentLevel2EnvelopeLinkWritableType value) {
        this.envelopeLink = value;
    }

}
