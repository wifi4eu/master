
package generated.jagate.ws.domain.bankaccount.v5;

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
 * <p>Java class for FollowUpInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FollowUpInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="freeTextReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FollowUpInfoType", propOrder = {
    "freeTextReason"
})
public class FollowUpInfoType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String freeTextReason;

    /**
     * Gets the value of the freeTextReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeTextReason() {
        return freeTextReason;
    }

    /**
     * Sets the value of the freeTextReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeTextReason(String value) {
        this.freeTextReason = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FollowUpInfoType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FollowUpInfoType that = ((FollowUpInfoType) object);
        {
            String lhsFreeTextReason;
            lhsFreeTextReason = this.getFreeTextReason();
            String rhsFreeTextReason;
            rhsFreeTextReason = that.getFreeTextReason();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "freeTextReason", lhsFreeTextReason), LocatorUtils.property(thatLocator, "freeTextReason", rhsFreeTextReason), lhsFreeTextReason, rhsFreeTextReason)) {
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
            String theFreeTextReason;
            theFreeTextReason = this.getFreeTextReason();
            strategy.appendField(locator, this, "freeTextReason", buffer, theFreeTextReason);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theFreeTextReason;
            theFreeTextReason = this.getFreeTextReason();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "freeTextReason", theFreeTextReason), currentHashCode, theFreeTextReason);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
