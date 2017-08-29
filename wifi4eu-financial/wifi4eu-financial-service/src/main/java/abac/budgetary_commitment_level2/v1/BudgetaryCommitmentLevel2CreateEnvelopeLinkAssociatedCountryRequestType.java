
package abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import abac.associated_country.v1.AssociatedCountryType;
import abac.message.v1.MessageRequestType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2CreateEnvelopeLinkAssociatedCountryRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2CreateEnvelopeLinkAssociatedCountryRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="EnvelopeLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="AssociatedCountry" type="{http://www.ec.europa.eu/budg/abac/associated_country/v1}AssociatedCountryType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2CreateEnvelopeLinkAssociatedCountryRequestType", propOrder = {
    "localKey",
    "envelopeLocalKey",
    "associatedCountry"
})
public class BudgetaryCommitmentLevel2CreateEnvelopeLinkAssociatedCountryRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "EnvelopeLocalKey", required = true)
    protected String envelopeLocalKey;
    @XmlElement(name = "AssociatedCountry", required = true)
    protected AssociatedCountryType associatedCountry;

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
     * Obtiene el valor de la propiedad envelopeLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnvelopeLocalKey() {
        return envelopeLocalKey;
    }

    /**
     * Define el valor de la propiedad envelopeLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnvelopeLocalKey(String value) {
        this.envelopeLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad associatedCountry.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedCountryType }
     *     
     */
    public AssociatedCountryType getAssociatedCountry() {
        return associatedCountry;
    }

    /**
     * Define el valor de la propiedad associatedCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedCountryType }
     *     
     */
    public void setAssociatedCountry(AssociatedCountryType value) {
        this.associatedCountry = value;
    }

}
