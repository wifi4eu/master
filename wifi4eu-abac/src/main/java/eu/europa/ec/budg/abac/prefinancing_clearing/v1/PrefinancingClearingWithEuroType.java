
package eu.europa.ec.budg.abac.prefinancing_clearing.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PrefinancingClearingWithEuroType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PrefinancingClearingWithEuroType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/prefinancing_clearing/v1}PrefinancingClearingType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ClearingAmountInEuro" type="{http://www.ec.europa.eu/budg/abac/prefinancing_clearing/v1}ClearingAmountInEuroType"/&gt;
 *         &lt;element name="ClearingCurrencyIso3Code" type="{http://www.ec.europa.eu/budg/abac/currency/v1}Iso3CodeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrefinancingClearingWithEuroType", propOrder = {
    "clearingAmountInEuro",
    "clearingCurrencyIso3Code"
})
@XmlSeeAlso({
    StandAlonePrefinancingClearingType.class
})
public class PrefinancingClearingWithEuroType
    extends PrefinancingClearingType
{

    @XmlElement(name = "ClearingAmountInEuro", required = true)
    protected BigDecimal clearingAmountInEuro;
    @XmlElement(name = "ClearingCurrencyIso3Code", required = true)
    protected String clearingCurrencyIso3Code;

    /**
     * Obtiene el valor de la propiedad clearingAmountInEuro.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getClearingAmountInEuro() {
        return clearingAmountInEuro;
    }

    /**
     * Define el valor de la propiedad clearingAmountInEuro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setClearingAmountInEuro(BigDecimal value) {
        this.clearingAmountInEuro = value;
    }

    /**
     * Obtiene el valor de la propiedad clearingCurrencyIso3Code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClearingCurrencyIso3Code() {
        return clearingCurrencyIso3Code;
    }

    /**
     * Define el valor de la propiedad clearingCurrencyIso3Code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClearingCurrencyIso3Code(String value) {
        this.clearingCurrencyIso3Code = value;
    }

}
