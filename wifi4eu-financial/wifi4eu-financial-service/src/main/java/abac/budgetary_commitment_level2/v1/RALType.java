
package abac.budgetary_commitment_level2.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RALType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RALType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TreeCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}TreeCodeType" minOccurs="0"/&gt;
 *         &lt;element name="OldCommitment" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}OldCommitmentType" minOccurs="0"/&gt;
 *         &lt;element name="SleepingCommitment" type="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}SleepingCommitmentType" minOccurs="0"/&gt;
 *         &lt;element name="RAL" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}AmountType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RALType", propOrder = {
    "treeCode",
    "oldCommitment",
    "sleepingCommitment",
    "ral"
})
public class RALType {

    @XmlElement(name = "TreeCode")
    protected String treeCode;
    @XmlElement(name = "OldCommitment")
    protected Boolean oldCommitment;
    @XmlElement(name = "SleepingCommitment")
    protected Boolean sleepingCommitment;
    @XmlElement(name = "RAL")
    protected BigDecimal ral;

    /**
     * Obtiene el valor de la propiedad treeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreeCode() {
        return treeCode;
    }

    /**
     * Define el valor de la propiedad treeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreeCode(String value) {
        this.treeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad oldCommitment.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOldCommitment() {
        return oldCommitment;
    }

    /**
     * Define el valor de la propiedad oldCommitment.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOldCommitment(Boolean value) {
        this.oldCommitment = value;
    }

    /**
     * Obtiene el valor de la propiedad sleepingCommitment.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSleepingCommitment() {
        return sleepingCommitment;
    }

    /**
     * Define el valor de la propiedad sleepingCommitment.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSleepingCommitment(Boolean value) {
        this.sleepingCommitment = value;
    }

    /**
     * Obtiene el valor de la propiedad ral.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRAL() {
        return ral;
    }

    /**
     * Define el valor de la propiedad ral.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRAL(BigDecimal value) {
        this.ral = value;
    }

}
