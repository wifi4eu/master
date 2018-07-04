
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
 * <p>Java class for OrgWithOperatingGrantsFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrgWithOperatingGrantsFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperatingGrants" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrgWithOperatingGrantsFactType", propOrder = {
    "operatingGrants"
})
public class OrgWithOperatingGrantsFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "OperatingGrants")
    protected boolean operatingGrants;

    /**
     * Gets the value of the operatingGrants property.
     * 
     */
    public boolean isOperatingGrants() {
        return operatingGrants;
    }

    /**
     * Sets the value of the operatingGrants property.
     * 
     */
    public void setOperatingGrants(boolean value) {
        this.operatingGrants = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof OrgWithOperatingGrantsFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final OrgWithOperatingGrantsFactType that = ((OrgWithOperatingGrantsFactType) object);
        {
            boolean lhsOperatingGrants;
            lhsOperatingGrants = (true?this.isOperatingGrants():false);
            boolean rhsOperatingGrants;
            rhsOperatingGrants = (true?that.isOperatingGrants():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "operatingGrants", lhsOperatingGrants), LocatorUtils.property(thatLocator, "operatingGrants", rhsOperatingGrants), lhsOperatingGrants, rhsOperatingGrants)) {
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
            boolean theOperatingGrants;
            theOperatingGrants = (true?this.isOperatingGrants():false);
            strategy.appendField(locator, this, "operatingGrants", buffer, theOperatingGrants);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theOperatingGrants;
            theOperatingGrants = (true?this.isOperatingGrants():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "operatingGrants", theOperatingGrants), currentHashCode, theOperatingGrants);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
