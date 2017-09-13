
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

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
 *         &lt;element name="Amount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="BankAccountKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="BankAccountName" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BankAccountNameType" minOccurs="0"/&gt;
 *         &lt;element name="Invoice" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}InvoiceType" minOccurs="0"/&gt;
 *         &lt;element name="LegalEntityKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="LegalEntityName" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}LegalEntityNameType" minOccurs="0"/&gt;
 *         &lt;element name="PaymentDetailKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
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
    "amount",
    "bankAccountKey",
    "bankAccountName",
    "invoice",
    "legalEntityKey",
    "legalEntityName",
    "paymentDetailKey"
})
public class PaymentDetailsType {

    @XmlElement(name = "Amount")
    protected BigDecimal amount;
    @XmlElement(name = "BankAccountKey")
    protected String bankAccountKey;
    @XmlElement(name = "BankAccountName")
    protected String bankAccountName;
    @XmlElement(name = "Invoice")
    protected InvoiceType invoice;
    @XmlElement(name = "LegalEntityKey")
    protected String legalEntityKey;
    @XmlElement(name = "LegalEntityName")
    protected String legalEntityName;
    @XmlElement(name = "PaymentDetailKey")
    protected String paymentDetailKey;

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
     * Obtiene el valor de la propiedad bankAccountKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountKey() {
        return bankAccountKey;
    }

    /**
     * Define el valor de la propiedad bankAccountKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountKey(String value) {
        this.bankAccountKey = value;
    }

    /**
     * Obtiene el valor de la propiedad bankAccountName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountName() {
        return bankAccountName;
    }

    /**
     * Define el valor de la propiedad bankAccountName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountName(String value) {
        this.bankAccountName = value;
    }

    /**
     * Obtiene el valor de la propiedad invoice.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceType }
     *     
     */
    public InvoiceType getInvoice() {
        return invoice;
    }

    /**
     * Define el valor de la propiedad invoice.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceType }
     *     
     */
    public void setInvoice(InvoiceType value) {
        this.invoice = value;
    }

    /**
     * Obtiene el valor de la propiedad legalEntityKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityKey() {
        return legalEntityKey;
    }

    /**
     * Define el valor de la propiedad legalEntityKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityKey(String value) {
        this.legalEntityKey = value;
    }

    /**
     * Obtiene el valor de la propiedad legalEntityName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityName() {
        return legalEntityName;
    }

    /**
     * Define el valor de la propiedad legalEntityName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityName(String value) {
        this.legalEntityName = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentDetailKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDetailKey() {
        return paymentDetailKey;
    }

    /**
     * Define el valor de la propiedad paymentDetailKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDetailKey(String value) {
        this.paymentDetailKey = value;
    }

}
