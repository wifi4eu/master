
package generated.jagate.ws.domain.visa.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
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
 * Visa dataset for a message that generates 1 single transaction in ABAC (Commitment).
 * 
 * <p>Java class for VisaSingleTransactionHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VisaSingleTransactionHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkflowCostCenterCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WorkflowOrg" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="Visa" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v3}VisaBodyEmbeddedType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisaSingleTransactionHeaderType", propOrder = {
    "workflowCostCenterCode",
    "workflowOrg",
    "visa"
})
public class VisaSingleTransactionHeaderType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "WorkflowCostCenterCode", required = true)
    protected String workflowCostCenterCode;
    @XmlElement(name = "WorkflowOrg", required = true)
    protected CodeRefType workflowOrg;
    @XmlElement(name = "Visa", required = true)
    protected List<VisaBodyEmbeddedType> visa;

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
     * Gets the value of the workflowOrg property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getWorkflowOrg() {
        return workflowOrg;
    }

    /**
     * Sets the value of the workflowOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setWorkflowOrg(CodeRefType value) {
        this.workflowOrg = value;
    }

    /**
     * Gets the value of the visa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the visa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVisa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VisaBodyEmbeddedType }
     * 
     * 
     */
    public List<VisaBodyEmbeddedType> getVisa() {
        if (visa == null) {
            visa = new ArrayList<VisaBodyEmbeddedType>();
        }
        return this.visa;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof VisaSingleTransactionHeaderType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final VisaSingleTransactionHeaderType that = ((VisaSingleTransactionHeaderType) object);
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
            CodeRefType lhsWorkflowOrg;
            lhsWorkflowOrg = this.getWorkflowOrg();
            CodeRefType rhsWorkflowOrg;
            rhsWorkflowOrg = that.getWorkflowOrg();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "workflowOrg", lhsWorkflowOrg), LocatorUtils.property(thatLocator, "workflowOrg", rhsWorkflowOrg), lhsWorkflowOrg, rhsWorkflowOrg)) {
                return false;
            }
        }
        {
            List<VisaBodyEmbeddedType> lhsVisa;
            lhsVisa = (((this.visa!= null)&&(!this.visa.isEmpty()))?this.getVisa():null);
            List<VisaBodyEmbeddedType> rhsVisa;
            rhsVisa = (((that.visa!= null)&&(!that.visa.isEmpty()))?that.getVisa():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "visa", lhsVisa), LocatorUtils.property(thatLocator, "visa", rhsVisa), lhsVisa, rhsVisa)) {
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
            CodeRefType theWorkflowOrg;
            theWorkflowOrg = this.getWorkflowOrg();
            strategy.appendField(locator, this, "workflowOrg", buffer, theWorkflowOrg);
        }
        {
            List<VisaBodyEmbeddedType> theVisa;
            theVisa = (((this.visa!= null)&&(!this.visa.isEmpty()))?this.getVisa():null);
            strategy.appendField(locator, this, "visa", buffer, theVisa);
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
            CodeRefType theWorkflowOrg;
            theWorkflowOrg = this.getWorkflowOrg();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "workflowOrg", theWorkflowOrg), currentHashCode, theWorkflowOrg);
        }
        {
            List<VisaBodyEmbeddedType> theVisa;
            theVisa = (((this.visa!= null)&&(!this.visa.isEmpty()))?this.getVisa():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "visa", theVisa), currentHashCode, theVisa);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
