
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PaymentDetailsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaymentDetailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentDetailLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="LegalEntityLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="Amount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="WorkflowAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentDetailsType", propOrder = {
    "paymentDetailLocalKey",
    "legalEntityLocalKey",
    "amount",
    "workflowAmount"
})
public class PaymentDetailsType {

    @XmlElement(name = "PaymentDetailLocalKey")
    protected String paymentDetailLocalKey;
    @XmlElement(name = "LegalEntityLocalKey")
    protected String legalEntityLocalKey;
    @XmlElement(name = "Amount")
    protected BigDecimal amount;
    @XmlElement(name = "WorkflowAmount")
    protected BigDecimal workflowAmount;

    /**
     * Obtiene el valor de la propiedad paymentDetailLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDetailLocalKey() {
        return paymentDetailLocalKey;
    }

    /**
     * Define el valor de la propiedad paymentDetailLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDetailLocalKey(String value) {
        this.paymentDetailLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad legalEntityLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityLocalKey() {
        return legalEntityLocalKey;
    }

    /**
     * Define el valor de la propiedad legalEntityLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityLocalKey(String value) {
        this.legalEntityLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad amount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Obtiene el valor de la propiedad workflowAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWorkflowAmount() {
        return workflowAmount;
    }

    /**
     * Define el valor de la propiedad workflowAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWorkflowAmount(BigDecimal value) {
        this.workflowAmount = value;
    }

}
