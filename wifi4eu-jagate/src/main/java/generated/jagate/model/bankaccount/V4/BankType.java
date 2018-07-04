
package generated.jagate.model.bankaccount.V4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.address.v4.AddressType;
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
 * <p>Java class for BankType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BankType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BranchAddress" type="{http://ec.europa.eu/research/fp/model/address/V4}AddressType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankType", propOrder = {
    "name",
    "bic",
    "branchAddress"
})
public class BankType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "BIC")
    protected String bic;
    @XmlElement(name = "BranchAddress", required = true)
    protected AddressType branchAddress;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the bic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIC() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIC(String value) {
        this.bic = value;
    }

    /**
     * Gets the value of the branchAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getBranchAddress() {
        return branchAddress;
    }

    /**
     * Sets the value of the branchAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setBranchAddress(AddressType value) {
        this.branchAddress = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BankType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final BankType that = ((BankType) object);
        {
            String lhsName;
            lhsName = this.getName();
            String rhsName;
            rhsName = that.getName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                return false;
            }
        }
        {
            String lhsBIC;
            lhsBIC = this.getBIC();
            String rhsBIC;
            rhsBIC = that.getBIC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bic", lhsBIC), LocatorUtils.property(thatLocator, "bic", rhsBIC), lhsBIC, rhsBIC)) {
                return false;
            }
        }
        {
            AddressType lhsBranchAddress;
            lhsBranchAddress = this.getBranchAddress();
            AddressType rhsBranchAddress;
            rhsBranchAddress = that.getBranchAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "branchAddress", lhsBranchAddress), LocatorUtils.property(thatLocator, "branchAddress", rhsBranchAddress), lhsBranchAddress, rhsBranchAddress)) {
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
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            String theBIC;
            theBIC = this.getBIC();
            strategy.appendField(locator, this, "bic", buffer, theBIC);
        }
        {
            AddressType theBranchAddress;
            theBranchAddress = this.getBranchAddress();
            strategy.appendField(locator, this, "branchAddress", buffer, theBranchAddress);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            String theBIC;
            theBIC = this.getBIC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bic", theBIC), currentHashCode, theBIC);
        }
        {
            AddressType theBranchAddress;
            theBranchAddress = this.getBranchAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "branchAddress", theBranchAddress), currentHashCode, theBranchAddress);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
