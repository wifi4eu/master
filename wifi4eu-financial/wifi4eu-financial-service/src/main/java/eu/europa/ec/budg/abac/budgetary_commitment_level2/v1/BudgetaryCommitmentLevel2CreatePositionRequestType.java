
package eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.message.v1.MessageRequestType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2CreatePositionRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2CreatePositionRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="BudgetaryCommitmentLevel2Position" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2PositionCreateType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2CreatePositionRequestType", propOrder = {
    "localKey",
    "budgetaryCommitmentLevel2Position"
})
public class BudgetaryCommitmentLevel2CreatePositionRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "BudgetaryCommitmentLevel2Position", required = true)
    protected BudgetaryCommitmentLevel2PositionCreateType budgetaryCommitmentLevel2Position;

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
     * Obtiene el valor de la propiedad budgetaryCommitmentLevel2Position.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel2PositionCreateType }
     *     
     */
    public BudgetaryCommitmentLevel2PositionCreateType getBudgetaryCommitmentLevel2Position() {
        return budgetaryCommitmentLevel2Position;
    }

    /**
     * Define el valor de la propiedad budgetaryCommitmentLevel2Position.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel2PositionCreateType }
     *     
     */
    public void setBudgetaryCommitmentLevel2Position(BudgetaryCommitmentLevel2PositionCreateType value) {
        this.budgetaryCommitmentLevel2Position = value;
    }

}
