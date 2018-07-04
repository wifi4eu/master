
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
 * <p>Java class for ExtendedMandateFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedMandateFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtendedMandate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedMandateFactType", propOrder = {
    "extendedMandate"
})
public class ExtendedMandateFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ExtendedMandate")
    protected boolean extendedMandate;

    /**
     * Gets the value of the extendedMandate property.
     * 
     */
    public boolean isExtendedMandate() {
        return extendedMandate;
    }

    /**
     * Sets the value of the extendedMandate property.
     * 
     */
    public void setExtendedMandate(boolean value) {
        this.extendedMandate = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedMandateFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedMandateFactType that = ((ExtendedMandateFactType) object);
        {
            boolean lhsExtendedMandate;
            lhsExtendedMandate = (true?this.isExtendedMandate():false);
            boolean rhsExtendedMandate;
            rhsExtendedMandate = (true?that.isExtendedMandate():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extendedMandate", lhsExtendedMandate), LocatorUtils.property(thatLocator, "extendedMandate", rhsExtendedMandate), lhsExtendedMandate, rhsExtendedMandate)) {
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
            boolean theExtendedMandate;
            theExtendedMandate = (true?this.isExtendedMandate():false);
            strategy.appendField(locator, this, "extendedMandate", buffer, theExtendedMandate);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theExtendedMandate;
            theExtendedMandate = (true?this.isExtendedMandate():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extendedMandate", theExtendedMandate), currentHashCode, theExtendedMandate);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
