
package abac.budgetary_commitment_level2.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para PaymentSchemeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaymentSchemeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PeriodTypeCode" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PeriodTypeCodeType" minOccurs="0"/&gt;
 *         &lt;element name="PeriodDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateType" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyAmount" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}RemarksType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentSchemeType", propOrder = {
    "periodTypeCode",
    "periodDate",
    "currencyAmount",
    "remarks"
})
public class PaymentSchemeType {

    @XmlElement(name = "PeriodTypeCode")
    protected String periodTypeCode;
    @XmlElement(name = "PeriodDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar periodDate;
    @XmlElement(name = "CurrencyAmount")
    protected BigDecimal currencyAmount;
    @XmlElement(name = "Remarks")
    protected String remarks;

    /**
     * Obtiene el valor de la propiedad periodTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodTypeCode() {
        return periodTypeCode;
    }

    /**
     * Define el valor de la propiedad periodTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodTypeCode(String value) {
        this.periodTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad periodDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodDate() {
        return periodDate;
    }

    /**
     * Define el valor de la propiedad periodDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodDate(XMLGregorianCalendar value) {
        this.periodDate = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrencyAmount() {
        return currencyAmount;
    }

    /**
     * Define el valor de la propiedad currencyAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrencyAmount(BigDecimal value) {
        this.currencyAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define el valor de la propiedad remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

}
