
package generated.jagate.ws.domain.base.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SystemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EcasDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EcasUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OnBehalfOfSystemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "systemId",
    "ecasDomain",
    "ecasUserId",
    "onBehalfOfSystemId"
})
@XmlRootElement(name = "SecurityContext")
public class SecurityContext
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "SystemId", required = true)
    protected String systemId;
    @XmlElement(name = "EcasDomain")
    protected String ecasDomain;
    @XmlElement(name = "EcasUserId")
    protected String ecasUserId;
    @XmlElement(name = "OnBehalfOfSystemId")
    protected String onBehalfOfSystemId;

    /**
     * Gets the value of the systemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * Sets the value of the systemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemId(String value) {
        this.systemId = value;
    }

    /**
     * Gets the value of the ecasDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcasDomain() {
        return ecasDomain;
    }

    /**
     * Sets the value of the ecasDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcasDomain(String value) {
        this.ecasDomain = value;
    }

    /**
     * Gets the value of the ecasUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcasUserId() {
        return ecasUserId;
    }

    /**
     * Sets the value of the ecasUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcasUserId(String value) {
        this.ecasUserId = value;
    }

    /**
     * Gets the value of the onBehalfOfSystemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnBehalfOfSystemId() {
        return onBehalfOfSystemId;
    }

    /**
     * Sets the value of the onBehalfOfSystemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnBehalfOfSystemId(String value) {
        this.onBehalfOfSystemId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SecurityContext)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SecurityContext that = ((SecurityContext) object);
        {
            String lhsSystemId;
            lhsSystemId = this.getSystemId();
            String rhsSystemId;
            rhsSystemId = that.getSystemId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "systemId", lhsSystemId), LocatorUtils.property(thatLocator, "systemId", rhsSystemId), lhsSystemId, rhsSystemId)) {
                return false;
            }
        }
        {
            String lhsEcasDomain;
            lhsEcasDomain = this.getEcasDomain();
            String rhsEcasDomain;
            rhsEcasDomain = that.getEcasDomain();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ecasDomain", lhsEcasDomain), LocatorUtils.property(thatLocator, "ecasDomain", rhsEcasDomain), lhsEcasDomain, rhsEcasDomain)) {
                return false;
            }
        }
        {
            String lhsEcasUserId;
            lhsEcasUserId = this.getEcasUserId();
            String rhsEcasUserId;
            rhsEcasUserId = that.getEcasUserId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ecasUserId", lhsEcasUserId), LocatorUtils.property(thatLocator, "ecasUserId", rhsEcasUserId), lhsEcasUserId, rhsEcasUserId)) {
                return false;
            }
        }
        {
            String lhsOnBehalfOfSystemId;
            lhsOnBehalfOfSystemId = this.getOnBehalfOfSystemId();
            String rhsOnBehalfOfSystemId;
            rhsOnBehalfOfSystemId = that.getOnBehalfOfSystemId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onBehalfOfSystemId", lhsOnBehalfOfSystemId), LocatorUtils.property(thatLocator, "onBehalfOfSystemId", rhsOnBehalfOfSystemId), lhsOnBehalfOfSystemId, rhsOnBehalfOfSystemId)) {
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
            String theSystemId;
            theSystemId = this.getSystemId();
            strategy.appendField(locator, this, "systemId", buffer, theSystemId);
        }
        {
            String theEcasDomain;
            theEcasDomain = this.getEcasDomain();
            strategy.appendField(locator, this, "ecasDomain", buffer, theEcasDomain);
        }
        {
            String theEcasUserId;
            theEcasUserId = this.getEcasUserId();
            strategy.appendField(locator, this, "ecasUserId", buffer, theEcasUserId);
        }
        {
            String theOnBehalfOfSystemId;
            theOnBehalfOfSystemId = this.getOnBehalfOfSystemId();
            strategy.appendField(locator, this, "onBehalfOfSystemId", buffer, theOnBehalfOfSystemId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theSystemId;
            theSystemId = this.getSystemId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "systemId", theSystemId), currentHashCode, theSystemId);
        }
        {
            String theEcasDomain;
            theEcasDomain = this.getEcasDomain();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ecasDomain", theEcasDomain), currentHashCode, theEcasDomain);
        }
        {
            String theEcasUserId;
            theEcasUserId = this.getEcasUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ecasUserId", theEcasUserId), currentHashCode, theEcasUserId);
        }
        {
            String theOnBehalfOfSystemId;
            theOnBehalfOfSystemId = this.getOnBehalfOfSystemId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onBehalfOfSystemId", theOnBehalfOfSystemId), currentHashCode, theOnBehalfOfSystemId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
