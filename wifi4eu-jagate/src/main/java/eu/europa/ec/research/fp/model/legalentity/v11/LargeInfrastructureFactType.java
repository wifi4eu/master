
package eu.europa.ec.research.fp.model.legalentity.v11;

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
 * <p>Java class for LargeInfrastructureFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LargeInfrastructureFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LargeInfrastructure" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LargeInfrastructureFactType", propOrder = {
    "largeInfrastructure"
})
public class LargeInfrastructureFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LargeInfrastructure")
    protected boolean largeInfrastructure;

    /**
     * Gets the value of the largeInfrastructure property.
     * 
     */
    public boolean isLargeInfrastructure() {
        return largeInfrastructure;
    }

    /**
     * Sets the value of the largeInfrastructure property.
     * 
     */
    public void setLargeInfrastructure(boolean value) {
        this.largeInfrastructure = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LargeInfrastructureFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LargeInfrastructureFactType that = ((LargeInfrastructureFactType) object);
        {
            boolean lhsLargeInfrastructure;
            lhsLargeInfrastructure = (true?this.isLargeInfrastructure():false);
            boolean rhsLargeInfrastructure;
            rhsLargeInfrastructure = (true?that.isLargeInfrastructure():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "largeInfrastructure", lhsLargeInfrastructure), LocatorUtils.property(thatLocator, "largeInfrastructure", rhsLargeInfrastructure), lhsLargeInfrastructure, rhsLargeInfrastructure)) {
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
            boolean theLargeInfrastructure;
            theLargeInfrastructure = (true?this.isLargeInfrastructure():false);
            strategy.appendField(locator, this, "largeInfrastructure", buffer, theLargeInfrastructure);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theLargeInfrastructure;
            theLargeInfrastructure = (true?this.isLargeInfrastructure():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "largeInfrastructure", theLargeInfrastructure), currentHashCode, theLargeInfrastructure);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
