
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CommitmentL1ConsumptionsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CommitmentL1ConsumptionsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PositionsL1" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}PositionsL1Type" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "CommitmentL1ConsumptionsType", propOrder = {
    "positionsL1",
    "paymentRequests"
})
public class CommitmentL1ConsumptionsType {

    @XmlElement(name = "PositionsL1")
    protected List<PositionsL1Type> positionsL1;
    @XmlElement(name = "PaymentRequests")
    protected CommitmentL1ConsumptionsType.PaymentRequests paymentRequests;

    /**
     * Gets the value of the positionsL1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the positionsL1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPositionsL1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PositionsL1Type }
     * 
     * 
     */
    public List<PositionsL1Type> getPositionsL1() {
        if (positionsL1 == null) {
            positionsL1 = new ArrayList<PositionsL1Type>();
        }
        return this.positionsL1;
    }

    /**
     * Obtiene el valor de la propiedad paymentRequests.
     * 
     * @return
     *     possible object is
     *     {@link CommitmentL1ConsumptionsType.PaymentRequests }
     *     
     */
    public CommitmentL1ConsumptionsType.PaymentRequests getPaymentRequests() {
        return paymentRequests;
    }

    /**
     * Define el valor de la propiedad paymentRequests.
     * 
     * @param value
     *     allowed object is
     *     {@link CommitmentL1ConsumptionsType.PaymentRequests }
     *     
     */
    public void setPaymentRequests(CommitmentL1ConsumptionsType.PaymentRequests value) {
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
