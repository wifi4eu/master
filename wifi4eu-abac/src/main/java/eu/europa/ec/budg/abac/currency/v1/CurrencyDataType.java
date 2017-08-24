
package eu.europa.ec.budg.abac.currency.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para CurrencyDataType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CurrencyDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Iso3Code" type="{http://www.ec.europa.eu/budg/abac/currency/v1}Iso3CodeType"/&gt;
 *         &lt;element name="ExchangeRate" type="{http://www.ec.europa.eu/budg/abac/currency/v1}ExchangeRateType" minOccurs="0"/&gt;
 *         &lt;element name="RateDate" type="{http://www.ec.europa.eu/budg/abac/currency/v1}RateDateType" minOccurs="0"/&gt;
 *         &lt;element name="SpecialExchangeRateFlag" type="{http://www.ec.europa.eu/budg/abac/currency/v1}SpecialExchangeRateFlagType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyDataType", propOrder = {
    "iso3Code",
    "exchangeRate",
    "rateDate",
    "specialExchangeRateFlag"
})
public class CurrencyDataType {

    @XmlElement(name = "Iso3Code", required = true)
    protected String iso3Code;
    @XmlElement(name = "ExchangeRate")
    protected BigDecimal exchangeRate;
    @XmlElement(name = "RateDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar rateDate;
    @XmlElement(name = "SpecialExchangeRateFlag")
    protected Boolean specialExchangeRateFlag;

    /**
     * Obtiene el valor de la propiedad iso3Code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIso3Code() {
        return iso3Code;
    }

    /**
     * Define el valor de la propiedad iso3Code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIso3Code(String value) {
        this.iso3Code = value;
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
     * Obtiene el valor de la propiedad rateDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRateDate() {
        return rateDate;
    }

    /**
     * Define el valor de la propiedad rateDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRateDate(XMLGregorianCalendar value) {
        this.rateDate = value;
    }

    /**
     * Obtiene el valor de la propiedad specialExchangeRateFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSpecialExchangeRateFlag() {
        return specialExchangeRateFlag;
    }

    /**
     * Define el valor de la propiedad specialExchangeRateFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSpecialExchangeRateFlag(Boolean value) {
        this.specialExchangeRateFlag = value;
    }

}
