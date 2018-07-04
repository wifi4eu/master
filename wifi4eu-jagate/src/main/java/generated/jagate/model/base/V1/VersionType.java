
package generated.jagate.model.base.V1;

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
 * <p>Java class for VersionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Major" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Minor" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionType", propOrder = {
    "major",
    "minor"
})
public class VersionType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Major", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger major;
    @XmlElement(name = "Minor")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger minor;

    /**
     * Gets the value of the major property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMajor() {
        return major;
    }

    /**
     * Sets the value of the major property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMajor(BigInteger value) {
        this.major = value;
    }

    /**
     * Gets the value of the minor property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinor() {
        return minor;
    }

    /**
     * Sets the value of the minor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinor(BigInteger value) {
        this.minor = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof VersionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final VersionType that = ((VersionType) object);
        {
            BigInteger lhsMajor;
            lhsMajor = this.getMajor();
            BigInteger rhsMajor;
            rhsMajor = that.getMajor();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "major", lhsMajor), LocatorUtils.property(thatLocator, "major", rhsMajor), lhsMajor, rhsMajor)) {
                return false;
            }
        }
        {
            BigInteger lhsMinor;
            lhsMinor = this.getMinor();
            BigInteger rhsMinor;
            rhsMinor = that.getMinor();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "minor", lhsMinor), LocatorUtils.property(thatLocator, "minor", rhsMinor), lhsMinor, rhsMinor)) {
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
            BigInteger theMajor;
            theMajor = this.getMajor();
            strategy.appendField(locator, this, "major", buffer, theMajor);
        }
        {
            BigInteger theMinor;
            theMinor = this.getMinor();
            strategy.appendField(locator, this, "minor", buffer, theMinor);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            BigInteger theMajor;
            theMajor = this.getMajor();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "major", theMajor), currentHashCode, theMajor);
        }
        {
            BigInteger theMinor;
            theMinor = this.getMinor();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "minor", theMinor), currentHashCode, theMinor);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
