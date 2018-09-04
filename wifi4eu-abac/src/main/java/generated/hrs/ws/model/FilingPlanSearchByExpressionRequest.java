
package generated.hrs.ws.model;

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
 * Request for searching files or headings.
 * 
 * <p>Java class for FilingPlanSearchByExpressionRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingPlanSearchByExpressionRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchExpression" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="skip" type="{http://ec.europa.eu/sg/hrs/types}int0To300" minOccurs="0"/>
 *         &lt;element name="max" type="{http://ec.europa.eu/sg/hrs/types}int0To300" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilingPlanSearchByExpressionRequest", propOrder = {
    "searchExpression",
    "skip",
    "max"
})
public class FilingPlanSearchByExpressionRequest
    implements Equals, HashCode, ToString
{

    protected String searchExpression;
    @XmlElement(defaultValue = "0")
    protected Integer skip;
    @XmlElement(defaultValue = "10")
    protected Integer max;

    /**
     * Gets the value of the searchExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchExpression() {
        return searchExpression;
    }

    /**
     * Sets the value of the searchExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchExpression(String value) {
        this.searchExpression = value;
    }

    /**
     * Gets the value of the skip property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSkip() {
        return skip;
    }

    /**
     * Sets the value of the skip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSkip(Integer value) {
        this.skip = value;
    }

    /**
     * Gets the value of the max property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMax(Integer value) {
        this.max = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FilingPlanSearchByExpressionRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FilingPlanSearchByExpressionRequest that = ((FilingPlanSearchByExpressionRequest) object);
        {
            String lhsSearchExpression;
            lhsSearchExpression = this.getSearchExpression();
            String rhsSearchExpression;
            rhsSearchExpression = that.getSearchExpression();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "searchExpression", lhsSearchExpression), LocatorUtils.property(thatLocator, "searchExpression", rhsSearchExpression), lhsSearchExpression, rhsSearchExpression)) {
                return false;
            }
        }
        {
            Integer lhsSkip;
            lhsSkip = this.getSkip();
            Integer rhsSkip;
            rhsSkip = that.getSkip();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "skip", lhsSkip), LocatorUtils.property(thatLocator, "skip", rhsSkip), lhsSkip, rhsSkip)) {
                return false;
            }
        }
        {
            Integer lhsMax;
            lhsMax = this.getMax();
            Integer rhsMax;
            rhsMax = that.getMax();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "max", lhsMax), LocatorUtils.property(thatLocator, "max", rhsMax), lhsMax, rhsMax)) {
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
            String theSearchExpression;
            theSearchExpression = this.getSearchExpression();
            strategy.appendField(locator, this, "searchExpression", buffer, theSearchExpression);
        }
        {
            Integer theSkip;
            theSkip = this.getSkip();
            strategy.appendField(locator, this, "skip", buffer, theSkip);
        }
        {
            Integer theMax;
            theMax = this.getMax();
            strategy.appendField(locator, this, "max", buffer, theMax);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theSearchExpression;
            theSearchExpression = this.getSearchExpression();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchExpression", theSearchExpression), currentHashCode, theSearchExpression);
        }
        {
            Integer theSkip;
            theSkip = this.getSkip();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "skip", theSkip), currentHashCode, theSkip);
        }
        {
            Integer theMax;
            theMax = this.getMax();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "max", theMax), currentHashCode, theMax);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
