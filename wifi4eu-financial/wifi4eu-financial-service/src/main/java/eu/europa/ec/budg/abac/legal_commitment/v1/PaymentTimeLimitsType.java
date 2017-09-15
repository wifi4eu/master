
package eu.europa.ec.budg.abac.legal_commitment.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PaymentTimeLimitsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaymentTimeLimitsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentTimeLimit" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}PaymentTimeLimitType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTimeLimitsType", propOrder = {
    "paymentTimeLimit"
})
public class PaymentTimeLimitsType {

    @XmlElement(name = "PaymentTimeLimit", required = true)
    protected List<PaymentTimeLimitType> paymentTimeLimit;

    /**
     * Gets the value of the paymentTimeLimit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentTimeLimit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentTimeLimit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTimeLimitType }
     * 
     * 
     */
    public List<PaymentTimeLimitType> getPaymentTimeLimit() {
        if (paymentTimeLimit == null) {
            paymentTimeLimit = new ArrayList<PaymentTimeLimitType>();
        }
        return this.paymentTimeLimit;
    }

}
