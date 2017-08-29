
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.suspension.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PaymentSuspensionPeriodType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaymentSuspensionPeriodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/suspension/v1}SuspensionPeriodType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentSuspensionReasonCode" type="{http://www.ec.europa.eu/budg/abac/suspension_reason/v1}CodeType"/&gt;
 *         &lt;element name="SuspensionType" type="{http://www.ec.europa.eu/budg/abac/suspension/v1}SuspensionTypeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentSuspensionPeriodType", propOrder = {
    "paymentSuspensionReasonCode",
    "suspensionType"
})
public class PaymentSuspensionPeriodType
    extends SuspensionPeriodType
{

    @XmlElement(name = "PaymentSuspensionReasonCode", required = true)
    protected String paymentSuspensionReasonCode;
    @XmlElement(name = "SuspensionType", required = true)
    @XmlSchemaType(name = "string")
    protected SuspensionTypeType suspensionType;

    /**
     * Obtiene el valor de la propiedad paymentSuspensionReasonCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentSuspensionReasonCode() {
        return paymentSuspensionReasonCode;
    }

    /**
     * Define el valor de la propiedad paymentSuspensionReasonCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentSuspensionReasonCode(String value) {
        this.paymentSuspensionReasonCode = value;
    }

    /**
     * Obtiene el valor de la propiedad suspensionType.
     * 
     * @return
     *     possible object is
     *     {@link SuspensionTypeType }
     *     
     */
    public SuspensionTypeType getSuspensionType() {
        return suspensionType;
    }

    /**
     * Define el valor de la propiedad suspensionType.
     * 
     * @param value
     *     allowed object is
     *     {@link SuspensionTypeType }
     *     
     */
    public void setSuspensionType(SuspensionTypeType value) {
        this.suspensionType = value;
    }

}
