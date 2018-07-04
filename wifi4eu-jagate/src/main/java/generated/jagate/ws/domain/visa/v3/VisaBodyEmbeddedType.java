
package generated.jagate.ws.domain.visa.v3;

import java.math.BigInteger;
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
 * <p>Java class for VisaBodyEmbeddedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VisaBodyEmbeddedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AgentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AgentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SuppliedAgentName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ActionCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Order" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisaBodyEmbeddedType", propOrder = {
    "agentId",
    "agentType",
    "suppliedAgentName",
    "actionCd",
    "order"
})
public class VisaBodyEmbeddedType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AgentId", required = true)
    protected String agentId;
    @XmlElement(name = "AgentType", required = true)
    protected String agentType;
    @XmlElement(name = "SuppliedAgentName", required = true)
    protected String suppliedAgentName;
    @XmlElement(name = "ActionCd", required = true)
    protected String actionCd;
    @XmlElement(name = "Order")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger order;

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof VisaBodyEmbeddedType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final VisaBodyEmbeddedType that = ((VisaBodyEmbeddedType) object);
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
            String lhsSuppliedAgentName;
            lhsSuppliedAgentName = this.getSuppliedAgentName();
            String rhsSuppliedAgentName;
            rhsSuppliedAgentName = that.getSuppliedAgentName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "suppliedAgentName", lhsSuppliedAgentName), LocatorUtils.property(thatLocator, "suppliedAgentName", rhsSuppliedAgentName), lhsSuppliedAgentName, rhsSuppliedAgentName)) {
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
        {
            BigInteger lhsOrder;
            lhsOrder = this.getOrder();
            BigInteger rhsOrder;
            rhsOrder = that.getOrder();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "order", lhsOrder), LocatorUtils.property(thatLocator, "order", rhsOrder), lhsOrder, rhsOrder)) {
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
            String theSuppliedAgentName;
            theSuppliedAgentName = this.getSuppliedAgentName();
            strategy.appendField(locator, this, "suppliedAgentName", buffer, theSuppliedAgentName);
        }
        {
            String theActionCd;
            theActionCd = this.getActionCd();
            strategy.appendField(locator, this, "actionCd", buffer, theActionCd);
        }
        {
            BigInteger theOrder;
            theOrder = this.getOrder();
            strategy.appendField(locator, this, "order", buffer, theOrder);
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
            String theSuppliedAgentName;
            theSuppliedAgentName = this.getSuppliedAgentName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "suppliedAgentName", theSuppliedAgentName), currentHashCode, theSuppliedAgentName);
        }
        {
            String theActionCd;
            theActionCd = this.getActionCd();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "actionCd", theActionCd), currentHashCode, theActionCd);
        }
        {
            BigInteger theOrder;
            theOrder = this.getOrder();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "order", theOrder), currentHashCode, theOrder);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
