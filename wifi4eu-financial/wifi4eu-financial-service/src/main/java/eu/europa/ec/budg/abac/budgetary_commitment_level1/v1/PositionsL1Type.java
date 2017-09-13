
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PositionsL1Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PositionsL1Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AcceptedAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="EntryAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="PositionsL2" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}PositionsL2Type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="WorkflowAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PositionsL1Type", propOrder = {
    "acceptedAmount",
    "entryAmount",
    "positionsL2",
    "localKey",
    "workflowAmount"
})
public class PositionsL1Type {

    @XmlElement(name = "AcceptedAmount")
    protected BigDecimal acceptedAmount;
    @XmlElement(name = "EntryAmount")
    protected BigDecimal entryAmount;
    @XmlElement(name = "PositionsL2")
    protected List<PositionsL2Type> positionsL2;
    @XmlElement(name = "LocalKey")
    protected String localKey;
    @XmlElement(name = "WorkflowAmount")
    protected BigDecimal workflowAmount;

    /**
     * Obtiene el valor de la propiedad acceptedAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAcceptedAmount() {
        return acceptedAmount;
    }

    /**
     * Define el valor de la propiedad acceptedAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAcceptedAmount(BigDecimal value) {
        this.acceptedAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad entryAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEntryAmount() {
        return entryAmount;
    }

    /**
     * Define el valor de la propiedad entryAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEntryAmount(BigDecimal value) {
        this.entryAmount = value;
    }

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
     * Obtiene el valor de la propiedad workflowAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWorkflowAmount() {
        return workflowAmount;
    }

    /**
     * Define el valor de la propiedad workflowAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWorkflowAmount(BigDecimal value) {
        this.workflowAmount = value;
    }

}
