
package abac.budgetary_commitment_level2.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2EnvelopeLinkWritableType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2EnvelopeLinkWritableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DgName" type="{http://www.ec.europa.eu/budg/abac/dg/v1}NameType" minOccurs="0"/&gt;
 *         &lt;element name="EntryInCurrencyAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="EnvelopeLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="ExpenseTypeCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}ExpenseTypeCodeType" minOccurs="0"/&gt;
 *         &lt;element name="PolicyAreaCode" type="{http://www.ec.europa.eu/budg/abac/policy_area/v1}CodeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2EnvelopeLinkWritableType", propOrder = {
    "dgName",
    "entryInCurrencyAmount",
    "envelopeLocalKey",
    "expenseTypeCode",
    "policyAreaCode"
})
@XmlSeeAlso({
    BudgetaryCommitmentLevel2EnvelopeLinkCreateType.class
})
public class BudgetaryCommitmentLevel2EnvelopeLinkWritableType {

    @XmlElement(name = "DgName")
    protected String dgName;
    @XmlElement(name = "EntryInCurrencyAmount")
    protected BigDecimal entryInCurrencyAmount;
    @XmlElement(name = "EnvelopeLocalKey")
    protected String envelopeLocalKey;
    @XmlElement(name = "ExpenseTypeCode")
    protected String expenseTypeCode;
    @XmlElement(name = "PolicyAreaCode")
    protected String policyAreaCode;

    /**
     * Obtiene el valor de la propiedad dgName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDgName() {
        return dgName;
    }

    /**
     * Define el valor de la propiedad dgName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDgName(String value) {
        this.dgName = value;
    }

    /**
     * Obtiene el valor de la propiedad entryInCurrencyAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEntryInCurrencyAmount() {
        return entryInCurrencyAmount;
    }

    /**
     * Define el valor de la propiedad entryInCurrencyAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEntryInCurrencyAmount(BigDecimal value) {
        this.entryInCurrencyAmount = value;
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
     * Obtiene el valor de la propiedad expenseTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpenseTypeCode() {
        return expenseTypeCode;
    }

    /**
     * Define el valor de la propiedad expenseTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpenseTypeCode(String value) {
        this.expenseTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad policyAreaCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyAreaCode() {
        return policyAreaCode;
    }

    /**
     * Define el valor de la propiedad policyAreaCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyAreaCode(String value) {
        this.policyAreaCode = value;
    }

}
