
package generated.jagate.model.base.V1;

import java.math.BigInteger;
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
 * any period during the project
 * 
 * <p>Java class for ProjectPeriodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProjectPeriodType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FromMonth" type="{http://ec.europa.eu/research/fp/model/base/V1}MonthNumberType"/>
 *         &lt;element name="ToMonth" type="{http://ec.europa.eu/research/fp/model/base/V1}MonthNumberType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProjectPeriodType", propOrder = {
    "fromMonth",
    "toMonth"
})
public class ProjectPeriodType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "FromMonth", required = true)
    protected BigInteger fromMonth;
    @XmlElement(name = "ToMonth", required = true)
    protected BigInteger toMonth;

    /**
     * Gets the value of the fromMonth property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFromMonth() {
        return fromMonth;
    }

    /**
     * Sets the value of the fromMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFromMonth(BigInteger value) {
        this.fromMonth = value;
    }

    /**
     * Gets the value of the toMonth property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getToMonth() {
        return toMonth;
    }

    /**
     * Sets the value of the toMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setToMonth(BigInteger value) {
        this.toMonth = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProjectPeriodType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ProjectPeriodType that = ((ProjectPeriodType) object);
        {
            BigInteger lhsFromMonth;
            lhsFromMonth = this.getFromMonth();
            BigInteger rhsFromMonth;
            rhsFromMonth = that.getFromMonth();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fromMonth", lhsFromMonth), LocatorUtils.property(thatLocator, "fromMonth", rhsFromMonth), lhsFromMonth, rhsFromMonth)) {
                return false;
            }
        }
        {
            BigInteger lhsToMonth;
            lhsToMonth = this.getToMonth();
            BigInteger rhsToMonth;
            rhsToMonth = that.getToMonth();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "toMonth", lhsToMonth), LocatorUtils.property(thatLocator, "toMonth", rhsToMonth), lhsToMonth, rhsToMonth)) {
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
            BigInteger theFromMonth;
            theFromMonth = this.getFromMonth();
            strategy.appendField(locator, this, "fromMonth", buffer, theFromMonth);
        }
        {
            BigInteger theToMonth;
            theToMonth = this.getToMonth();
            strategy.appendField(locator, this, "toMonth", buffer, theToMonth);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            BigInteger theFromMonth;
            theFromMonth = this.getFromMonth();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fromMonth", theFromMonth), currentHashCode, theFromMonth);
        }
        {
            BigInteger theToMonth;
            theToMonth = this.getToMonth();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "toMonth", theToMonth), currentHashCode, theToMonth);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
