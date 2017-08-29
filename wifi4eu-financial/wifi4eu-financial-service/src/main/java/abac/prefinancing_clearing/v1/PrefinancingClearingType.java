
package abac.prefinancing_clearing.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PrefinancingClearingType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PrefinancingClearingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ClearingAmountInCurrency" type="{http://www.ec.europa.eu/budg/abac/prefinancing_clearing/v1}ClearingAmountInCurrencyType"/&gt;
 *         &lt;element name="EwsJustification" type="{http://www.ec.europa.eu/budg/abac/prefinancing_clearing/v1}EwsJustificationType" minOccurs="0"/&gt;
 *         &lt;element name="JustificationCode" type="{http://www.ec.europa.eu/budg/abac/prefinancing_clearing_justification/v1}CodeType"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="PaymentDetailLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrefinancingClearingType", propOrder = {
    "clearingAmountInCurrency",
    "ewsJustification",
    "justificationCode",
    "localKey",
    "paymentDetailLocalKey"
})
@XmlSeeAlso({
    PrefinancingClearingWithEuroType.class
})
public class PrefinancingClearingType {

    @XmlElement(name = "ClearingAmountInCurrency", required = true)
    protected BigDecimal clearingAmountInCurrency;
    @XmlElement(name = "EwsJustification")
    protected String ewsJustification;
    @XmlElement(name = "JustificationCode", required = true)
    protected String justificationCode;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "PaymentDetailLocalKey", required = true)
    protected String paymentDetailLocalKey;

    /**
     * Obtiene el valor de la propiedad clearingAmountInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getClearingAmountInCurrency() {
        return clearingAmountInCurrency;
    }

    /**
     * Define el valor de la propiedad clearingAmountInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setClearingAmountInCurrency(BigDecimal value) {
        this.clearingAmountInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad ewsJustification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEwsJustification() {
        return ewsJustification;
    }

    /**
     * Define el valor de la propiedad ewsJustification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEwsJustification(String value) {
        this.ewsJustification = value;
    }

    /**
     * Obtiene el valor de la propiedad justificationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustificationCode() {
        return justificationCode;
    }

    /**
     * Define el valor de la propiedad justificationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustificationCode(String value) {
        this.justificationCode = value;
    }

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

}
