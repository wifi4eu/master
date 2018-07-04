
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for EntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Internal" type="{http://ec.europa.eu/research/fp/model/document/V5}InternalEntityType"/>
 *         &lt;element name="External" type="{http://ec.europa.eu/research/fp/model/document/V5}ExternaLEntityType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntityType", propOrder = {
    "internal",
    "external"
})
public class EntityType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Internal")
    protected InternalEntityType internal;
    @XmlElement(name = "External")
    protected ExternaLEntityType external;

    /**
     * Gets the value of the internal property.
     * 
     * @return
     *     possible object is
     *     {@link InternalEntityType }
     *     
     */
    public InternalEntityType getInternal() {
        return internal;
    }

    /**
     * Sets the value of the internal property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalEntityType }
     *     
     */
    public void setInternal(InternalEntityType value) {
        this.internal = value;
    }

    /**
     * Gets the value of the external property.
     * 
     * @return
     *     possible object is
     *     {@link ExternaLEntityType }
     *     
     */
    public ExternaLEntityType getExternal() {
        return external;
    }

    /**
     * Sets the value of the external property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternaLEntityType }
     *     
     */
    public void setExternal(ExternaLEntityType value) {
        this.external = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof EntityType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EntityType that = ((EntityType) object);
        {
            InternalEntityType lhsInternal;
            lhsInternal = this.getInternal();
            InternalEntityType rhsInternal;
            rhsInternal = that.getInternal();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "internal", lhsInternal), LocatorUtils.property(thatLocator, "internal", rhsInternal), lhsInternal, rhsInternal)) {
                return false;
            }
        }
        {
            ExternaLEntityType lhsExternal;
            lhsExternal = this.getExternal();
            ExternaLEntityType rhsExternal;
            rhsExternal = that.getExternal();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "external", lhsExternal), LocatorUtils.property(thatLocator, "external", rhsExternal), lhsExternal, rhsExternal)) {
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
            InternalEntityType theInternal;
            theInternal = this.getInternal();
            strategy.appendField(locator, this, "internal", buffer, theInternal);
        }
        {
            ExternaLEntityType theExternal;
            theExternal = this.getExternal();
            strategy.appendField(locator, this, "external", buffer, theExternal);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            InternalEntityType theInternal;
            theInternal = this.getInternal();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "internal", theInternal), currentHashCode, theInternal);
        }
        {
            ExternaLEntityType theExternal;
            theExternal = this.getExternal();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "external", theExternal), currentHashCode, theExternal);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
