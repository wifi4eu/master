
package generated.jagate.ws.domain.visa.v3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * 
 * 				Visa dataset for a message that generates more than 1 transaction in ABAC (Prefinancing). For each transaction the visa 'header' 
 * 				(dgcode and workflow cost center) can be different. 
 * 			
 * 
 * <p>Java class for VisaMultiTransactionHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VisaMultiTransactionHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkflowCostCenterCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DGCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Order" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Visas" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v3}VisaBodyEmbeddedType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisaMultiTransactionHeaderType", propOrder = {
    "workflowCostCenterCode",
    "dgCode",
    "order",
    "visas"
})
public class VisaMultiTransactionHeaderType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "WorkflowCostCenterCode", required = true)
    protected String workflowCostCenterCode;
    @XmlElement(name = "DGCode")
    protected int dgCode;
    @XmlElement(name = "Order", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger order;
    @XmlElement(name = "Visas", required = true)
    protected List<VisaBodyEmbeddedType> visas;

    /**
     * Gets the value of the workflowCostCenterCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowCostCenterCode() {
        return workflowCostCenterCode;
    }

    /**
     * Sets the value of the workflowCostCenterCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowCostCenterCode(String value) {
        this.workflowCostCenterCode = value;
    }

    /**
     * Gets the value of the dgCode property.
     * 
     */
    public int getDGCode() {
        return dgCode;
    }

    /**
     * Sets the value of the dgCode property.
     * 
     */
    public void setDGCode(int value) {
        this.dgCode = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrder(BigInteger value) {
        this.order = value;
    }

    /**
     * Gets the value of the visas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the visas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVisas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VisaBodyEmbeddedType }
     * 
     * 
     */
    public List<VisaBodyEmbeddedType> getVisas() {
        if (visas == null) {
            visas = new ArrayList<VisaBodyEmbeddedType>();
        }
        return this.visas;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof VisaMultiTransactionHeaderType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final VisaMultiTransactionHeaderType that = ((VisaMultiTransactionHeaderType) object);
        {
            String lhsWorkflowCostCenterCode;
            lhsWorkflowCostCenterCode = this.getWorkflowCostCenterCode();
            String rhsWorkflowCostCenterCode;
            rhsWorkflowCostCenterCode = that.getWorkflowCostCenterCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "workflowCostCenterCode", lhsWorkflowCostCenterCode), LocatorUtils.property(thatLocator, "workflowCostCenterCode", rhsWorkflowCostCenterCode), lhsWorkflowCostCenterCode, rhsWorkflowCostCenterCode)) {
                return false;
            }
        }
        {
            int lhsDGCode;
            lhsDGCode = (true?this.getDGCode(): 0);
            int rhsDGCode;
            rhsDGCode = (true?that.getDGCode(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dgCode", lhsDGCode), LocatorUtils.property(thatLocator, "dgCode", rhsDGCode), lhsDGCode, rhsDGCode)) {
                return false;
            }
        }
        {
            BigInteger lhsOrder;
            lhsOrder = this.getOrder();
            BigInteger rhsOrder;
            rhsOrder = that.getOrder();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "order", lhsOrder), LocatorUtils.property(thatLocator, "order", rhsOrder), lhsOrder, rhsOrder)) {
                return false;
            }
        }
        {
            List<VisaBodyEmbeddedType> lhsVisas;
            lhsVisas = (((this.visas!= null)&&(!this.visas.isEmpty()))?this.getVisas():null);
            List<VisaBodyEmbeddedType> rhsVisas;
            rhsVisas = (((that.visas!= null)&&(!that.visas.isEmpty()))?that.getVisas():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "visas", lhsVisas), LocatorUtils.property(thatLocator, "visas", rhsVisas), lhsVisas, rhsVisas)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            String theWorkflowCostCenterCode;
            theWorkflowCostCenterCode = this.getWorkflowCostCenterCode();
            strategy.appendField(locator, this, "workflowCostCenterCode", buffer, theWorkflowCostCenterCode);
        }
        {
            int theDGCode;
            theDGCode = (true?this.getDGCode(): 0);
            strategy.appendField(locator, this, "dgCode", buffer, theDGCode);
        }
        {
            BigInteger theOrder;
            theOrder = this.getOrder();
            strategy.appendField(locator, this, "order", buffer, theOrder);
        }
        {
            List<VisaBodyEmbeddedType> theVisas;
            theVisas = (((this.visas!= null)&&(!this.visas.isEmpty()))?this.getVisas():null);
            strategy.appendField(locator, this, "visas", buffer, theVisas);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theWorkflowCostCenterCode;
            theWorkflowCostCenterCode = this.getWorkflowCostCenterCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "workflowCostCenterCode", theWorkflowCostCenterCode), currentHashCode, theWorkflowCostCenterCode);
        }
        {
            int theDGCode;
            theDGCode = (true?this.getDGCode(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dgCode", theDGCode), currentHashCode, theDGCode);
        }
        {
            BigInteger theOrder;
            theOrder = this.getOrder();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "order", theOrder), currentHashCode, theOrder);
        }
        {
            List<VisaBodyEmbeddedType> theVisas;
            theVisas = (((this.visas!= null)&&(!this.visas.isEmpty()))?this.getVisas():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "visas", theVisas), currentHashCode, theVisas);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
