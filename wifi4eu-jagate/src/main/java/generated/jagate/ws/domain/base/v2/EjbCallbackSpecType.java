
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
 * <p>Java class for EjbCallbackSpecType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EjbCallbackSpecType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JndiName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BusinessInterfaceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EjbCallbackSpecType", propOrder = {
    "jndiName",
    "businessInterfaceType"
})
public class EjbCallbackSpecType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "JndiName", required = true)
    protected String jndiName;
    @XmlElement(name = "BusinessInterfaceType", required = true)
    protected String businessInterfaceType;

    /**
     * Gets the value of the jndiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJndiName() {
        return jndiName;
    }

    /**
     * Sets the value of the jndiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJndiName(String value) {
        this.jndiName = value;
    }

    /**
     * Gets the value of the businessInterfaceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessInterfaceType() {
        return businessInterfaceType;
    }

    /**
     * Sets the value of the businessInterfaceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessInterfaceType(String value) {
        this.businessInterfaceType = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof EjbCallbackSpecType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EjbCallbackSpecType that = ((EjbCallbackSpecType) object);
        {
            String lhsJndiName;
            lhsJndiName = this.getJndiName();
            String rhsJndiName;
            rhsJndiName = that.getJndiName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "jndiName", lhsJndiName), LocatorUtils.property(thatLocator, "jndiName", rhsJndiName), lhsJndiName, rhsJndiName)) {
                return false;
            }
        }
        {
            String lhsBusinessInterfaceType;
            lhsBusinessInterfaceType = this.getBusinessInterfaceType();
            String rhsBusinessInterfaceType;
            rhsBusinessInterfaceType = that.getBusinessInterfaceType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "businessInterfaceType", lhsBusinessInterfaceType), LocatorUtils.property(thatLocator, "businessInterfaceType", rhsBusinessInterfaceType), lhsBusinessInterfaceType, rhsBusinessInterfaceType)) {
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
            String theJndiName;
            theJndiName = this.getJndiName();
            strategy.appendField(locator, this, "jndiName", buffer, theJndiName);
        }
        {
            String theBusinessInterfaceType;
            theBusinessInterfaceType = this.getBusinessInterfaceType();
            strategy.appendField(locator, this, "businessInterfaceType", buffer, theBusinessInterfaceType);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theJndiName;
            theJndiName = this.getJndiName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "jndiName", theJndiName), currentHashCode, theJndiName);
        }
        {
            String theBusinessInterfaceType;
            theBusinessInterfaceType = this.getBusinessInterfaceType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "businessInterfaceType", theBusinessInterfaceType), currentHashCode, theBusinessInterfaceType);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
