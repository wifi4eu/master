
package generated.jagate.ws.domain.base.v2;

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
 *         &lt;element name="AgentId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="AgentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransAreaCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CostCenterCd" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="OrgName" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="SuppliedAgentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SignAsAgentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "agentType",
    "transTypeCd",
    "transAreaCd",
    "costCenterCd",
    "orgName",
    "suppliedAgentName",
    "signAsAgentType",
    "actionCd"
})
public class Visa
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AgentId", required = true)
    protected String agentId;
    @XmlElement(name = "AgentType")
    protected String agentType;
    @XmlElement(name = "TransTypeCd")
    protected String transTypeCd;
    @XmlElement(name = "TransAreaCd")
    protected String transAreaCd;
    @XmlElement(name = "CostCenterCd", required = true)
    protected String costCenterCd;
    @XmlElement(name = "OrgName", required = true)
    protected String orgName;
    @XmlElement(name = "SuppliedAgentName")
    protected String suppliedAgentName;
    @XmlElement(name = "SignAsAgentType")
    protected String signAsAgentType;
    @XmlElement(name = "ActionCd")
    protected String actionCd;

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
     * Gets the value of the agentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentType() {
        return agentType;
    }

    /**
     * Sets the value of the agentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentType(String value) {
        this.agentType = value;
    }

    /**
     * Gets the value of the transTypeCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransTypeCd() {
        return transTypeCd;
    }

    /**
     * Sets the value of the transTypeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransTypeCd(String value) {
        this.transTypeCd = value;
    }

    /**
     * Gets the value of the transAreaCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransAreaCd() {
        return transAreaCd;
    }

    /**
     * Sets the value of the transAreaCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransAreaCd(String value) {
        this.transAreaCd = value;
    }

    /**
     * Gets the value of the costCenterCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostCenterCd() {
        return costCenterCd;
    }

    /**
     * Sets the value of the costCenterCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostCenterCd(String value) {
        this.costCenterCd = value;
    }

    /**
     * Gets the value of the orgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * Sets the value of the orgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    /**
     * Gets the value of the suppliedAgentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuppliedAgentName() {
        return suppliedAgentName;
    }

    /**
     * Sets the value of the suppliedAgentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuppliedAgentName(String value) {
        this.suppliedAgentName = value;
    }

    /**
     * Gets the value of the signAsAgentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignAsAgentType() {
        return signAsAgentType;
    }

    /**
     * Sets the value of the signAsAgentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignAsAgentType(String value) {
        this.signAsAgentType = value;
    }

    /**
     * Gets the value of the actionCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCd() {
        return actionCd;
    }

    /**
     * Sets the value of the actionCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCd(String value) {
        this.actionCd = value;
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
            String lhsAgentType;
            lhsAgentType = this.getAgentType();
            String rhsAgentType;
            rhsAgentType = that.getAgentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agentType", lhsAgentType), LocatorUtils.property(thatLocator, "agentType", rhsAgentType), lhsAgentType, rhsAgentType)) {
                return false;
            }
        }
        {
            String lhsTransTypeCd;
            lhsTransTypeCd = this.getTransTypeCd();
            String rhsTransTypeCd;
            rhsTransTypeCd = that.getTransTypeCd();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transTypeCd", lhsTransTypeCd), LocatorUtils.property(thatLocator, "transTypeCd", rhsTransTypeCd), lhsTransTypeCd, rhsTransTypeCd)) {
                return false;
            }
        }
        {
            String lhsTransAreaCd;
            lhsTransAreaCd = this.getTransAreaCd();
            String rhsTransAreaCd;
            rhsTransAreaCd = that.getTransAreaCd();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transAreaCd", lhsTransAreaCd), LocatorUtils.property(thatLocator, "transAreaCd", rhsTransAreaCd), lhsTransAreaCd, rhsTransAreaCd)) {
                return false;
            }
        }
        {
            String lhsCostCenterCd;
            lhsCostCenterCd = this.getCostCenterCd();
            String rhsCostCenterCd;
            rhsCostCenterCd = that.getCostCenterCd();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "costCenterCd", lhsCostCenterCd), LocatorUtils.property(thatLocator, "costCenterCd", rhsCostCenterCd), lhsCostCenterCd, rhsCostCenterCd)) {
                return false;
            }
        }
        {
            String lhsOrgName;
            lhsOrgName = this.getOrgName();
            String rhsOrgName;
            rhsOrgName = that.getOrgName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "orgName", lhsOrgName), LocatorUtils.property(thatLocator, "orgName", rhsOrgName), lhsOrgName, rhsOrgName)) {
                return false;
            }
        }
        {
            String lhsSuppliedAgentName;
            lhsSuppliedAgentName = this.getSuppliedAgentName();
            String rhsSuppliedAgentName;
            rhsSuppliedAgentName = that.getSuppliedAgentName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "suppliedAgentName", lhsSuppliedAgentName), LocatorUtils.property(thatLocator, "suppliedAgentName", rhsSuppliedAgentName), lhsSuppliedAgentName, rhsSuppliedAgentName)) {
                return false;
            }
        }
        {
            String lhsSignAsAgentType;
            lhsSignAsAgentType = this.getSignAsAgentType();
            String rhsSignAsAgentType;
            rhsSignAsAgentType = that.getSignAsAgentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signAsAgentType", lhsSignAsAgentType), LocatorUtils.property(thatLocator, "signAsAgentType", rhsSignAsAgentType), lhsSignAsAgentType, rhsSignAsAgentType)) {
                return false;
            }
        }
        {
            String lhsActionCd;
            lhsActionCd = this.getActionCd();
            String rhsActionCd;
            rhsActionCd = that.getActionCd();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "actionCd", lhsActionCd), LocatorUtils.property(thatLocator, "actionCd", rhsActionCd), lhsActionCd, rhsActionCd)) {
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
            String theAgentType;
            theAgentType = this.getAgentType();
            strategy.appendField(locator, this, "agentType", buffer, theAgentType);
        }
        {
            String theTransTypeCd;
            theTransTypeCd = this.getTransTypeCd();
            strategy.appendField(locator, this, "transTypeCd", buffer, theTransTypeCd);
        }
        {
            String theTransAreaCd;
            theTransAreaCd = this.getTransAreaCd();
            strategy.appendField(locator, this, "transAreaCd", buffer, theTransAreaCd);
        }
        {
            String theCostCenterCd;
            theCostCenterCd = this.getCostCenterCd();
            strategy.appendField(locator, this, "costCenterCd", buffer, theCostCenterCd);
        }
        {
            String theOrgName;
            theOrgName = this.getOrgName();
            strategy.appendField(locator, this, "orgName", buffer, theOrgName);
        }
        {
            String theSuppliedAgentName;
            theSuppliedAgentName = this.getSuppliedAgentName();
            strategy.appendField(locator, this, "suppliedAgentName", buffer, theSuppliedAgentName);
        }
        {
            String theSignAsAgentType;
            theSignAsAgentType = this.getSignAsAgentType();
            strategy.appendField(locator, this, "signAsAgentType", buffer, theSignAsAgentType);
        }
        {
            String theActionCd;
            theActionCd = this.getActionCd();
            strategy.appendField(locator, this, "actionCd", buffer, theActionCd);
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
            String theAgentType;
            theAgentType = this.getAgentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agentType", theAgentType), currentHashCode, theAgentType);
        }
        {
            String theTransTypeCd;
            theTransTypeCd = this.getTransTypeCd();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transTypeCd", theTransTypeCd), currentHashCode, theTransTypeCd);
        }
        {
            String theTransAreaCd;
            theTransAreaCd = this.getTransAreaCd();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transAreaCd", theTransAreaCd), currentHashCode, theTransAreaCd);
        }
        {
            String theCostCenterCd;
            theCostCenterCd = this.getCostCenterCd();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "costCenterCd", theCostCenterCd), currentHashCode, theCostCenterCd);
        }
        {
            String theOrgName;
            theOrgName = this.getOrgName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "orgName", theOrgName), currentHashCode, theOrgName);
        }
        {
            String theSuppliedAgentName;
            theSuppliedAgentName = this.getSuppliedAgentName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "suppliedAgentName", theSuppliedAgentName), currentHashCode, theSuppliedAgentName);
        }
        {
            String theSignAsAgentType;
            theSignAsAgentType = this.getSignAsAgentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signAsAgentType", theSignAsAgentType), currentHashCode, theSignAsAgentType);
        }
        {
            String theActionCd;
            theActionCd = this.getActionCd();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "actionCd", theActionCd), currentHashCode, theActionCd);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
