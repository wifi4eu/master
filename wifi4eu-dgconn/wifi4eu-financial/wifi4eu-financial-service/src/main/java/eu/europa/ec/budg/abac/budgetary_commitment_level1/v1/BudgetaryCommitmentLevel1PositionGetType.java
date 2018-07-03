
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import eu.europa.ec.budg.abac.wbs.v1.WbsType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel1PositionGetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel1PositionGetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BudgetaryCommitmentLevel1PositionCreateType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AmountTotalAcceptedInEuro" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountTotalAcceptedInCurrency" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountTotalConsumedInEuro" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountTotalConsumedInCurrency" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountAcceptedInWorkflowInEuro" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountAcceptedInWorkflowInCurrency" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountConsumedInWorkflowInEuro" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountConsumedInWorkflowInCurrency" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountInEntryInEuro" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountInEntryInCurrency" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountOpenInEuro" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountOpenInCurrency" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="ExchangeRate" type="{http://www.ec.europa.eu/budg/abac/currency/v1}ExchangeRateType" minOccurs="0"/&gt;
 *         &lt;element name="ExchangeRateDate" type="{http://www.ec.europa.eu/budg/abac/currency/v1}RateDateType" minOccurs="0"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="Wbs" type="{http://www.ec.europa.eu/budg/abac/wbs/v1}WbsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel1PositionGetType", propOrder = {
    "amountTotalAcceptedInEuro",
    "amountTotalAcceptedInCurrency",
    "amountTotalConsumedInEuro",
    "amountTotalConsumedInCurrency",
    "amountAcceptedInWorkflowInEuro",
    "amountAcceptedInWorkflowInCurrency",
    "amountConsumedInWorkflowInEuro",
    "amountConsumedInWorkflowInCurrency",
    "amountInEntryInEuro",
    "amountInEntryInCurrency",
    "amountOpenInEuro",
    "amountOpenInCurrency",
    "exchangeRate",
    "exchangeRateDate",
    "localKey",
    "wbs"
})
public class BudgetaryCommitmentLevel1PositionGetType
    extends BudgetaryCommitmentLevel1PositionCreateType
{

    @XmlElement(name = "AmountTotalAcceptedInEuro")
    protected BigDecimal amountTotalAcceptedInEuro;
    @XmlElement(name = "AmountTotalAcceptedInCurrency")
    protected BigDecimal amountTotalAcceptedInCurrency;
    @XmlElement(name = "AmountTotalConsumedInEuro")
    protected BigDecimal amountTotalConsumedInEuro;
    @XmlElement(name = "AmountTotalConsumedInCurrency")
    protected BigDecimal amountTotalConsumedInCurrency;
    @XmlElement(name = "AmountAcceptedInWorkflowInEuro")
    protected BigDecimal amountAcceptedInWorkflowInEuro;
    @XmlElement(name = "AmountAcceptedInWorkflowInCurrency")
    protected BigDecimal amountAcceptedInWorkflowInCurrency;
    @XmlElement(name = "AmountConsumedInWorkflowInEuro")
    protected BigDecimal amountConsumedInWorkflowInEuro;
    @XmlElement(name = "AmountConsumedInWorkflowInCurrency")
    protected BigDecimal amountConsumedInWorkflowInCurrency;
    @XmlElement(name = "AmountInEntryInEuro")
    protected BigDecimal amountInEntryInEuro;
    @XmlElement(name = "AmountInEntryInCurrency")
    protected BigDecimal amountInEntryInCurrency;
    @XmlElement(name = "AmountOpenInEuro")
    protected BigDecimal amountOpenInEuro;
    @XmlElement(name = "AmountOpenInCurrency")
    protected BigDecimal amountOpenInCurrency;
    @XmlElement(name = "ExchangeRate")
    protected BigDecimal exchangeRate;
    @XmlElement(name = "ExchangeRateDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar exchangeRateDate;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "Wbs")
    protected WbsType wbs;

    /**
     * Obtiene el valor de la propiedad amountTotalAcceptedInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountTotalAcceptedInEuro() {
        return amountTotalAcceptedInEuro;
    }

    /**
     * Define el valor de la propiedad amountTotalAcceptedInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountTotalAcceptedInEuro(BigDecimal value) {
        this.amountTotalAcceptedInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountTotalAcceptedInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountTotalAcceptedInCurrency() {
        return amountTotalAcceptedInCurrency;
    }

    /**
     * Define el valor de la propiedad amountTotalAcceptedInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountTotalAcceptedInCurrency(BigDecimal value) {
        this.amountTotalAcceptedInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountTotalConsumedInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountTotalConsumedInEuro() {
        return amountTotalConsumedInEuro;
    }

    /**
     * Define el valor de la propiedad amountTotalConsumedInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountTotalConsumedInEuro(BigDecimal value) {
        this.amountTotalConsumedInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountTotalConsumedInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountTotalConsumedInCurrency() {
        return amountTotalConsumedInCurrency;
    }

    /**
     * Define el valor de la propiedad amountTotalConsumedInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountTotalConsumedInCurrency(BigDecimal value) {
        this.amountTotalConsumedInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountAcceptedInWorkflowInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountAcceptedInWorkflowInEuro() {
        return amountAcceptedInWorkflowInEuro;
    }

    /**
     * Define el valor de la propiedad amountAcceptedInWorkflowInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountAcceptedInWorkflowInEuro(BigDecimal value) {
        this.amountAcceptedInWorkflowInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountAcceptedInWorkflowInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountAcceptedInWorkflowInCurrency() {
        return amountAcceptedInWorkflowInCurrency;
    }

    /**
     * Define el valor de la propiedad amountAcceptedInWorkflowInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountAcceptedInWorkflowInCurrency(BigDecimal value) {
        this.amountAcceptedInWorkflowInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountConsumedInWorkflowInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountConsumedInWorkflowInEuro() {
        return amountConsumedInWorkflowInEuro;
    }

    /**
     * Define el valor de la propiedad amountConsumedInWorkflowInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountConsumedInWorkflowInEuro(BigDecimal value) {
        this.amountConsumedInWorkflowInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountConsumedInWorkflowInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountConsumedInWorkflowInCurrency() {
        return amountConsumedInWorkflowInCurrency;
    }

    /**
     * Define el valor de la propiedad amountConsumedInWorkflowInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountConsumedInWorkflowInCurrency(BigDecimal value) {
        this.amountConsumedInWorkflowInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountInEntryInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountInEntryInEuro() {
        return amountInEntryInEuro;
    }

    /**
     * Define el valor de la propiedad amountInEntryInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountInEntryInEuro(BigDecimal value) {
        this.amountInEntryInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountInEntryInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountInEntryInCurrency() {
        return amountInEntryInCurrency;
    }

    /**
     * Define el valor de la propiedad amountInEntryInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountInEntryInCurrency(BigDecimal value) {
        this.amountInEntryInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad amountOpenInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountOpenInEuro() {
        return amountOpenInEuro;
    }

    /**
     * Define el valor de la propiedad amountOpenInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountOpenInEuro(BigDecimal value) {
        this.amountOpenInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad amountOpenInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountOpenInCurrency() {
        return amountOpenInCurrency;
    }

    /**
     * Define el valor de la propiedad amountOpenInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountOpenInCurrency(BigDecimal value) {
        this.amountOpenInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad exchangeRate.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Define el valor de la propiedad exchangeRate.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExchangeRate(BigDecimal value) {
        this.exchangeRate = value;
    }

    /**
     * Obtiene el valor de la propiedad exchangeRateDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExchangeRateDate() {
        return exchangeRateDate;
    }

    /**
     * Define el valor de la propiedad exchangeRateDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExchangeRateDate(XMLGregorianCalendar value) {
        this.exchangeRateDate = value;
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
     * Obtiene el valor de la propiedad wbs.
     * 
     * @return
     *     possible object is
     *     {@link WbsType }
     *     
     */
    public WbsType getWbs() {
        return wbs;
    }

    /**
     * Define el valor de la propiedad wbs.
     * 
     * @param value
     *     allowed object is
     *     {@link WbsType }
     *     
     */
    public void setWbs(WbsType value) {
        this.wbs = value;
    }

}
