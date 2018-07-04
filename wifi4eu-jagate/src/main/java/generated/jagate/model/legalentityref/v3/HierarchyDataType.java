
package generated.jagate.model.legalentityref.v3;

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
 * <p>Java class for HierarchyDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HierarchyDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UTROPIC" type="{http://ec.europa.eu/research/fp/model/legalentity-ref/V3}LegalEntityIdType" minOccurs="0"/>
 *         &lt;element name="UTROPICList" type="{http://ec.europa.eu/research/fp/model/legalentity-ref/V3}SuspendedPICType" minOccurs="0"/>
 *         &lt;element name="DeprecatedPICList" type="{http://ec.europa.eu/research/fp/model/legalentity-ref/V3}DeprecatedPICType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HierarchyDataType", propOrder = {
    "utropic",
    "utropicList",
    "deprecatedPICList"
})
public class HierarchyDataType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "UTROPIC")
    protected String utropic;
    @XmlElement(name = "UTROPICList")
    protected SuspendedPICType utropicList;
    @XmlElement(name = "DeprecatedPICList")
    protected DeprecatedPICType deprecatedPICList;

    /**
     * Gets the value of the utropic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUTROPIC() {
        return utropic;
    }

    /**
     * Sets the value of the utropic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUTROPIC(String value) {
        this.utropic = value;
    }

    /**
     * Gets the value of the utropicList property.
     * 
     * @return
     *     possible object is
     *     {@link SuspendedPICType }
     *     
     */
    public SuspendedPICType getUTROPICList() {
        return utropicList;
    }

    /**
     * Sets the value of the utropicList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuspendedPICType }
     *     
     */
    public void setUTROPICList(SuspendedPICType value) {
        this.utropicList = value;
    }

    /**
     * Gets the value of the deprecatedPICList property.
     * 
     * @return
     *     possible object is
     *     {@link DeprecatedPICType }
     *     
     */
    public DeprecatedPICType getDeprecatedPICList() {
        return deprecatedPICList;
    }

    /**
     * Sets the value of the deprecatedPICList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeprecatedPICType }
     *     
     */
    public void setDeprecatedPICList(DeprecatedPICType value) {
        this.deprecatedPICList = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof HierarchyDataType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final HierarchyDataType that = ((HierarchyDataType) object);
        {
            String lhsUTROPIC;
            lhsUTROPIC = this.getUTROPIC();
            String rhsUTROPIC;
            rhsUTROPIC = that.getUTROPIC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "utropic", lhsUTROPIC), LocatorUtils.property(thatLocator, "utropic", rhsUTROPIC), lhsUTROPIC, rhsUTROPIC)) {
                return false;
            }
        }
        {
            SuspendedPICType lhsUTROPICList;
            lhsUTROPICList = this.getUTROPICList();
            SuspendedPICType rhsUTROPICList;
            rhsUTROPICList = that.getUTROPICList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "utropicList", lhsUTROPICList), LocatorUtils.property(thatLocator, "utropicList", rhsUTROPICList), lhsUTROPICList, rhsUTROPICList)) {
                return false;
            }
        }
        {
            DeprecatedPICType lhsDeprecatedPICList;
            lhsDeprecatedPICList = this.getDeprecatedPICList();
            DeprecatedPICType rhsDeprecatedPICList;
            rhsDeprecatedPICList = that.getDeprecatedPICList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deprecatedPICList", lhsDeprecatedPICList), LocatorUtils.property(thatLocator, "deprecatedPICList", rhsDeprecatedPICList), lhsDeprecatedPICList, rhsDeprecatedPICList)) {
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
            String theUTROPIC;
            theUTROPIC = this.getUTROPIC();
            strategy.appendField(locator, this, "utropic", buffer, theUTROPIC);
        }
        {
            SuspendedPICType theUTROPICList;
            theUTROPICList = this.getUTROPICList();
            strategy.appendField(locator, this, "utropicList", buffer, theUTROPICList);
        }
        {
            DeprecatedPICType theDeprecatedPICList;
            theDeprecatedPICList = this.getDeprecatedPICList();
            strategy.appendField(locator, this, "deprecatedPICList", buffer, theDeprecatedPICList);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theUTROPIC;
            theUTROPIC = this.getUTROPIC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "utropic", theUTROPIC), currentHashCode, theUTROPIC);
        }
        {
            SuspendedPICType theUTROPICList;
            theUTROPICList = this.getUTROPICList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "utropicList", theUTROPICList), currentHashCode, theUTROPICList);
        }
        {
            DeprecatedPICType theDeprecatedPICList;
            theDeprecatedPICList = this.getDeprecatedPICList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deprecatedPICList", theDeprecatedPICList), currentHashCode, theDeprecatedPICList);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
