
package generated.jagate.ws.domain.visa.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * <p>Java class for Visa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Visa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agentId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="action" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v1}ActionType"/>
 *         &lt;element name="agentType" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v1}AgentType"/>
 *         &lt;element name="agentRole" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v1}AgentRole"/>
 *         &lt;element name="otherAgentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WorkflowCenterCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Visa", propOrder = {
    "agentId",
    "action",
    "agentType",
    "agentRole",
    "otherAgentId",
    "workflowCenterCode",
    "dg"
})
public class Visa
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String agentId;
    @XmlElement(required = true)
    protected ActionType action;
    @XmlElement(required = true)
    protected AgentType agentType;
    @XmlElement(required = true)
    protected AgentRole agentRole;
    @XmlElement(required = true)
    protected String otherAgentId;
    @XmlElement(name = "WorkflowCenterCode", required = true)
    protected String workflowCenterCode;
    @XmlElement(name = "DG", required = true)
    protected String dg;

    /**
     * Gets the value of the agentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * Sets the value of the agentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentId(String value) {
        this.agentId = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link ActionType }
     *     
     */
    public ActionType getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionType }
     *     
     */
    public void setAction(ActionType value) {
        this.action = value;
    }

    /**
     * Gets the value of the agentType property.
     * 
     * @return
     *     possible object is
     *     {@link AgentType }
     *     
     */
    public AgentType getAgentType() {
        return agentType;
    }

    /**
     * Sets the value of the agentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgentType }
     *     
     */
    public void setAgentType(AgentType value) {
        this.agentType = value;
    }

    /**
     * Gets the value of the agentRole property.
     * 
     * @return
     *     possible object is
     *     {@link AgentRole }
     *     
     */
    public AgentRole getAgentRole() {
        return agentRole;
    }

    /**
     * Sets the value of the agentRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgentRole }
     *     
     */
    public void setAgentRole(AgentRole value) {
        this.agentRole = value;
    }

    /**
     * Gets the value of the otherAgentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherAgentId() {
        return otherAgentId;
    }

    /**
     * Sets the value of the otherAgentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherAgentId(String value) {
        this.otherAgentId = value;
    }

    /**
     * Gets the value of the workflowCenterCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowCenterCode() {
        return workflowCenterCode;
    }

    /**
     * Sets the value of the workflowCenterCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowCenterCode(String value) {
        this.workflowCenterCode = value;
    }

    /**
     * Gets the value of the dg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDG() {
        return dg;
    }

    /**
     * Sets the value of the dg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDG(String value) {
        this.dg = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Visa)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Visa that = ((Visa) object);
        {
            String lhsAgentId;
            lhsAgentId = this.getAgentId();
            String rhsAgentId;
            rhsAgentId = that.getAgentId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agentId", lhsAgentId), LocatorUtils.property(thatLocator, "agentId", rhsAgentId), lhsAgentId, rhsAgentId)) {
                return false;
            }
        }
        {
            ActionType lhsAction;
            lhsAction = this.getAction();
            ActionType rhsAction;
            rhsAction = that.getAction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "action", lhsAction), LocatorUtils.property(thatLocator, "action", rhsAction), lhsAction, rhsAction)) {
                return false;
            }
        }
        {
            AgentType lhsAgentType;
            lhsAgentType = this.getAgentType();
            AgentType rhsAgentType;
            rhsAgentType = that.getAgentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agentType", lhsAgentType), LocatorUtils.property(thatLocator, "agentType", rhsAgentType), lhsAgentType, rhsAgentType)) {
                return false;
            }
        }
        {
            AgentRole lhsAgentRole;
            lhsAgentRole = this.getAgentRole();
            AgentRole rhsAgentRole;
            rhsAgentRole = that.getAgentRole();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agentRole", lhsAgentRole), LocatorUtils.property(thatLocator, "agentRole", rhsAgentRole), lhsAgentRole, rhsAgentRole)) {
                return false;
            }
        }
        {
            String lhsOtherAgentId;
            lhsOtherAgentId = this.getOtherAgentId();
            String rhsOtherAgentId;
            rhsOtherAgentId = that.getOtherAgentId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "otherAgentId", lhsOtherAgentId), LocatorUtils.property(thatLocator, "otherAgentId", rhsOtherAgentId), lhsOtherAgentId, rhsOtherAgentId)) {
                return false;
            }
        }
        {
            String lhsWorkflowCenterCode;
            lhsWorkflowCenterCode = this.getWorkflowCenterCode();
            String rhsWorkflowCenterCode;
            rhsWorkflowCenterCode = that.getWorkflowCenterCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "workflowCenterCode", lhsWorkflowCenterCode), LocatorUtils.property(thatLocator, "workflowCenterCode", rhsWorkflowCenterCode), lhsWorkflowCenterCode, rhsWorkflowCenterCode)) {
                return false;
            }
        }
        {
            String lhsDG;
            lhsDG = this.getDG();
            String rhsDG;
            rhsDG = that.getDG();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dg", lhsDG), LocatorUtils.property(thatLocator, "dg", rhsDG), lhsDG, rhsDG)) {
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
            String theAgentId;
            theAgentId = this.getAgentId();
            strategy.appendField(locator, this, "agentId", buffer, theAgentId);
        }
        {
            ActionType theAction;
            theAction = this.getAction();
            strategy.appendField(locator, this, "action", buffer, theAction);
        }
        {
            AgentType theAgentType;
            theAgentType = this.getAgentType();
            strategy.appendField(locator, this, "agentType", buffer, theAgentType);
        }
        {
            AgentRole theAgentRole;
            theAgentRole = this.getAgentRole();
            strategy.appendField(locator, this, "agentRole", buffer, theAgentRole);
        }
        {
            String theOtherAgentId;
            theOtherAgentId = this.getOtherAgentId();
            strategy.appendField(locator, this, "otherAgentId", buffer, theOtherAgentId);
        }
        {
            String theWorkflowCenterCode;
            theWorkflowCenterCode = this.getWorkflowCenterCode();
            strategy.appendField(locator, this, "workflowCenterCode", buffer, theWorkflowCenterCode);
        }
        {
            String theDG;
            theDG = this.getDG();
            strategy.appendField(locator, this, "dg", buffer, theDG);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theAgentId;
            theAgentId = this.getAgentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agentId", theAgentId), currentHashCode, theAgentId);
        }
        {
            ActionType theAction;
            theAction = this.getAction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "action", theAction), currentHashCode, theAction);
        }
        {
            AgentType theAgentType;
            theAgentType = this.getAgentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agentType", theAgentType), currentHashCode, theAgentType);
        }
        {
            AgentRole theAgentRole;
            theAgentRole = this.getAgentRole();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agentRole", theAgentRole), currentHashCode, theAgentRole);
        }
        {
            String theOtherAgentId;
            theOtherAgentId = this.getOtherAgentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otherAgentId", theOtherAgentId), currentHashCode, theOtherAgentId);
        }
        {
            String theWorkflowCenterCode;
            theWorkflowCenterCode = this.getWorkflowCenterCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "workflowCenterCode", theWorkflowCenterCode), currentHashCode, theWorkflowCenterCode);
        }
        {
            String theDG;
            theDG = this.getDG();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dg", theDG), currentHashCode, theDG);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
