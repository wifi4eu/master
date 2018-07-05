
package wifi4eu.wifi4eu.service.exportImport.messageCall.bc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Clase Java para CommitmentL2ConsumptionsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CommitmentL2ConsumptionsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PositionsL2" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PositionsL2Type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PaymentRequests" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PaymentRequestLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommitmentL2ConsumptionsType", propOrder = {
    "positionsL2",
    "paymentRequests"
})
public class CommitmentL2ConsumptionsType {

    @XmlElement(name = "PositionsL2")
    protected List<PositionsL2Type> positionsL2;
    @XmlElement(name = "PaymentRequests")
    protected PaymentRequests paymentRequests;

    /**
     * Gets the value of the positionsL2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the positionsL2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPositionsL2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PositionsL2Type }
     * 
     * 
     */
    public List<PositionsL2Type> getPositionsL2() {
        if (positionsL2 == null) {
            positionsL2 = new ArrayList<PositionsL2Type>();
        }
        return this.positionsL2;
    }

    /**
     * Obtiene el valor de la propiedad paymentRequests.
     * 
     * @return
     *     possible object is
     *     {@link PaymentRequests }
     *     
     */
    public PaymentRequests getPaymentRequests() {
        return paymentRequests;
    }

    /**
     * Define el valor de la propiedad paymentRequests.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentRequests }
     *     
     */
    public void setPaymentRequests(PaymentRequests value) {
        this.paymentRequests = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PaymentRequestLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "paymentRequestLocalKey"
    })
    public static class PaymentRequests {

        @XmlElement(name = "PaymentRequestLocalKey", required = true)
        protected List<String> paymentRequestLocalKey;

        /**
         * Gets the value of the paymentRequestLocalKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paymentRequestLocalKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPaymentRequestLocalKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getPaymentRequestLocalKey() {
            if (paymentRequestLocalKey == null) {
                paymentRequestLocalKey = new ArrayList<String>();
            }
            return this.paymentRequestLocalKey;
        }

    }

}
