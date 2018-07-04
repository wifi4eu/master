
package generated.jagate.ws.domain.base.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.ws.domain.reference.v1.EActionCodeType;
import generated.jagate.ws.domain.reference.v1.EAgentType;
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
 * <p>Java class for EmbebedBaseVisaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EmbebedBaseVisaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AgentId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="AgentType" type="{http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1}EAgentType"/>
 *         &lt;element name="ActionCd" type="{http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1}EActionCodeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmbebedBaseVisaType", propOrder = {
    "agentId",
    "agentType",
    "actionCd"
})
@XmlSeeAlso({
    BaseVisaType.class
})
public class EmbebedBaseVisaType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AgentId", required = true)
    protected String agentId;
    @XmlElement(name = "AgentType", required = true)
    protected EAgentType agentType;
    @XmlElement(name = "ActionCd", required = true)
    protected EActionCodeType actionCd;

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
     *     {@link EAgentType }
     *     
     */
    public EAgentType getAgentType() {
        return agentType;
    }

    /**
     * Sets the value of the agentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EAgentType }
     *     
     */
    public void setAgentType(EAgentType value) {
        this.agentType = value;
    }

    /**
     * Gets the value of the actionCd property.
     * 
     * @return
     *     possible object is
     *     {@link EActionCodeType }
     *     
     */
    public EActionCodeType getActionCd() {
        return actionCd;
    }

    /**
     * Sets the value of the actionCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link EActionCodeType }
     *     
     */
    public void setActionCd(EActionCodeType value) {
        this.actionCd = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof EmbebedBaseVisaType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EmbebedBaseVisaType that = ((EmbebedBaseVisaType) object);
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
            EAgentType lhsAgentType;
            lhsAgentType = this.getAgentType();
            EAgentType rhsAgentType;
            rhsAgentType = that.getAgentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agentType", lhsAgentType), LocatorUtils.property(thatLocator, "agentType", rhsAgentType), lhsAgentType, rhsAgentType)) {
                return false;
            }
        }
        {
            EActionCodeType lhsActionCd;
            lhsActionCd = this.getActionCd();
            EActionCodeType rhsActionCd;
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
            EAgentType theAgentType;
            theAgentType = this.getAgentType();
            strategy.appendField(locator, this, "agentType", buffer, theAgentType);
        }
        {
            EActionCodeType theActionCd;
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
            EAgentType theAgentType;
            theAgentType = this.getAgentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agentType", theAgentType), currentHashCode, theAgentType);
        }
        {
            EActionCodeType theActionCd;
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
