
package eu.europa.ec.budg.abac.legal_commitment.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.BusinessRuleMessageRequestType;


/**
 * <p>Clase Java para LegalCommitmentCreateResponsibleUserRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalCommitmentCreateResponsibleUserRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}BusinessRuleMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="UserId" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}UserIdType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalCommitmentCreateResponsibleUserRequestType", propOrder = {
    "localKey",
    "userId"
})
public class LegalCommitmentCreateResponsibleUserRequestType
    extends BusinessRuleMessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "UserId", required = true)
    protected String userId;

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
     * Obtiene el valor de la propiedad userId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Define el valor de la propiedad userId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

}
