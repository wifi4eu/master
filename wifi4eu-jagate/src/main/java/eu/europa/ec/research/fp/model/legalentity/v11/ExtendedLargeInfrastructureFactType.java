
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
 * <p>Java class for ExtendedLargeInfrastructureFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedLargeInfrastructureFactType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/research/fp/model/legalentity/V11}AbstractFactType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}LargeInfrastructureFactType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedLargeInfrastructureFactType", propOrder = {
    "details"
})
public class ExtendedLargeInfrastructureFactType
    extends AbstractFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Details", required = true)
    protected LargeInfrastructureFactType details;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link LargeInfrastructureFactType }
     *     
     */
    public LargeInfrastructureFactType getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link LargeInfrastructureFactType }
     *     
     */
    public void setDetails(LargeInfrastructureFactType value) {
        this.details = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedLargeInfrastructureFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ExtendedLargeInfrastructureFactType that = ((ExtendedLargeInfrastructureFactType) object);
        {
            LargeInfrastructureFactType lhsDetails;
            lhsDetails = this.getDetails();
            LargeInfrastructureFactType rhsDetails;
            rhsDetails = that.getDetails();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "details", lhsDetails), LocatorUtils.property(thatLocator, "details", rhsDetails), lhsDetails, rhsDetails)) {
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
        super.appendFields(locator, buffer, strategy);
        {
            LargeInfrastructureFactType theDetails;
            theDetails = this.getDetails();
            strategy.appendField(locator, this, "details", buffer, theDetails);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            LargeInfrastructureFactType theDetails;
            theDetails = this.getDetails();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "details", theDetails), currentHashCode, theDetails);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
