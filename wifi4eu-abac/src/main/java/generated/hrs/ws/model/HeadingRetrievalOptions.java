
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
 * Options allowing to precise the information headings. If
 *                 less information is required, the operation can result in better response times.
 * 
 * <p>Java class for HeadingRetrievalOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeadingRetrievalOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="includeRoles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeServiceOwners" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeCategories" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeadingRetrievalOptions", propOrder = {
    "includeRoles",
    "includeServiceOwners",
    "includeCategories"
})
public class HeadingRetrievalOptions
    implements Equals, HashCode, ToString
{

    @XmlElement(defaultValue = "false")
    protected Boolean includeRoles;
    @XmlElement(defaultValue = "false")
    protected Boolean includeServiceOwners;
    @XmlElement(defaultValue = "false")
    protected Boolean includeCategories;

    /**
     * Gets the value of the includeRoles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeRoles() {
        return includeRoles;
    }

    /**
     * Sets the value of the includeRoles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeRoles(Boolean value) {
        this.includeRoles = value;
    }

    /**
     * Gets the value of the includeServiceOwners property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeServiceOwners() {
        return includeServiceOwners;
    }

    /**
     * Sets the value of the includeServiceOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeServiceOwners(Boolean value) {
        this.includeServiceOwners = value;
    }

    /**
     * Gets the value of the includeCategories property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeCategories() {
        return includeCategories;
    }

    /**
     * Sets the value of the includeCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeCategories(Boolean value) {
        this.includeCategories = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof HeadingRetrievalOptions)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final HeadingRetrievalOptions that = ((HeadingRetrievalOptions) object);
        {
            Boolean lhsIncludeRoles;
            lhsIncludeRoles = this.isIncludeRoles();
            Boolean rhsIncludeRoles;
            rhsIncludeRoles = that.isIncludeRoles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeRoles", lhsIncludeRoles), LocatorUtils.property(thatLocator, "includeRoles", rhsIncludeRoles), lhsIncludeRoles, rhsIncludeRoles)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeServiceOwners;
            lhsIncludeServiceOwners = this.isIncludeServiceOwners();
            Boolean rhsIncludeServiceOwners;
            rhsIncludeServiceOwners = that.isIncludeServiceOwners();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeServiceOwners", lhsIncludeServiceOwners), LocatorUtils.property(thatLocator, "includeServiceOwners", rhsIncludeServiceOwners), lhsIncludeServiceOwners, rhsIncludeServiceOwners)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeCategories;
            lhsIncludeCategories = this.isIncludeCategories();
            Boolean rhsIncludeCategories;
            rhsIncludeCategories = that.isIncludeCategories();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeCategories", lhsIncludeCategories), LocatorUtils.property(thatLocator, "includeCategories", rhsIncludeCategories), lhsIncludeCategories, rhsIncludeCategories)) {
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
            Boolean theIncludeRoles;
            theIncludeRoles = this.isIncludeRoles();
            strategy.appendField(locator, this, "includeRoles", buffer, theIncludeRoles);
        }
        {
            Boolean theIncludeServiceOwners;
            theIncludeServiceOwners = this.isIncludeServiceOwners();
            strategy.appendField(locator, this, "includeServiceOwners", buffer, theIncludeServiceOwners);
        }
        {
            Boolean theIncludeCategories;
            theIncludeCategories = this.isIncludeCategories();
            strategy.appendField(locator, this, "includeCategories", buffer, theIncludeCategories);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Boolean theIncludeRoles;
            theIncludeRoles = this.isIncludeRoles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeRoles", theIncludeRoles), currentHashCode, theIncludeRoles);
        }
        {
            Boolean theIncludeServiceOwners;
            theIncludeServiceOwners = this.isIncludeServiceOwners();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeServiceOwners", theIncludeServiceOwners), currentHashCode, theIncludeServiceOwners);
        }
        {
            Boolean theIncludeCategories;
            theIncludeCategories = this.isIncludeCategories();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeCategories", theIncludeCategories), currentHashCode, theIncludeCategories);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
