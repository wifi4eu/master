
package generated.jagate.model.address.v4;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for AddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PostalAddress" type="{http://ec.europa.eu/research/fp/model/address/V4}PostalAddressType"/>
 *         &lt;element name="AdditionalContactInformation" type="{http://ec.europa.eu/research/fp/model/address/V4}AddressAdditionalContactType" minOccurs="0"/>
 *         &lt;element name="WebLink" type="{http://ec.europa.eu/research/fp/model/address/V4}WebLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AddressType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "postalAddress",
    "additionalContactInformation",
    "webLink",
    "addressType"
})
public class AddressType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "PostalAddress", required = true)
    protected PostalAddressType postalAddress;
    @XmlElement(name = "AdditionalContactInformation")
    protected AddressAdditionalContactType additionalContactInformation;
    @XmlElement(name = "WebLink")
    protected List<WebLinkType> webLink;
    @XmlElement(name = "AddressType")
    protected String addressType;

    /**
     * Gets the value of the postalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link PostalAddressType }
     *     
     */
    public PostalAddressType getPostalAddress() {
        return postalAddress;
    }

    /**
     * Sets the value of the postalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddressType }
     *     
     */
    public void setPostalAddress(PostalAddressType value) {
        this.postalAddress = value;
    }

    /**
     * Gets the value of the additionalContactInformation property.
     * 
     * @return
     *     possible object is
     *     {@link AddressAdditionalContactType }
     *     
     */
    public AddressAdditionalContactType getAdditionalContactInformation() {
        return additionalContactInformation;
    }

    /**
     * Sets the value of the additionalContactInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressAdditionalContactType }
     *     
     */
    public void setAdditionalContactInformation(AddressAdditionalContactType value) {
        this.additionalContactInformation = value;
    }

    /**
     * Gets the value of the webLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the webLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWebLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WebLinkType }
     * 
     * 
     */
    public List<WebLinkType> getWebLink() {
        if (webLink == null) {
            webLink = new ArrayList<WebLinkType>();
        }
        return this.webLink;
    }

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressType(String value) {
        this.addressType = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AddressType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AddressType that = ((AddressType) object);
        {
            PostalAddressType lhsPostalAddress;
            lhsPostalAddress = this.getPostalAddress();
            PostalAddressType rhsPostalAddress;
            rhsPostalAddress = that.getPostalAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "postalAddress", lhsPostalAddress), LocatorUtils.property(thatLocator, "postalAddress", rhsPostalAddress), lhsPostalAddress, rhsPostalAddress)) {
                return false;
            }
        }
        {
            AddressAdditionalContactType lhsAdditionalContactInformation;
            lhsAdditionalContactInformation = this.getAdditionalContactInformation();
            AddressAdditionalContactType rhsAdditionalContactInformation;
            rhsAdditionalContactInformation = that.getAdditionalContactInformation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "additionalContactInformation", lhsAdditionalContactInformation), LocatorUtils.property(thatLocator, "additionalContactInformation", rhsAdditionalContactInformation), lhsAdditionalContactInformation, rhsAdditionalContactInformation)) {
                return false;
            }
        }
        {
            List<WebLinkType> lhsWebLink;
            lhsWebLink = (((this.webLink!= null)&&(!this.webLink.isEmpty()))?this.getWebLink():null);
            List<WebLinkType> rhsWebLink;
            rhsWebLink = (((that.webLink!= null)&&(!that.webLink.isEmpty()))?that.getWebLink():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "webLink", lhsWebLink), LocatorUtils.property(thatLocator, "webLink", rhsWebLink), lhsWebLink, rhsWebLink)) {
                return false;
            }
        }
        {
            String lhsAddressType;
            lhsAddressType = this.getAddressType();
            String rhsAddressType;
            rhsAddressType = that.getAddressType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "addressType", lhsAddressType), LocatorUtils.property(thatLocator, "addressType", rhsAddressType), lhsAddressType, rhsAddressType)) {
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
            PostalAddressType thePostalAddress;
            thePostalAddress = this.getPostalAddress();
            strategy.appendField(locator, this, "postalAddress", buffer, thePostalAddress);
        }
        {
            AddressAdditionalContactType theAdditionalContactInformation;
            theAdditionalContactInformation = this.getAdditionalContactInformation();
            strategy.appendField(locator, this, "additionalContactInformation", buffer, theAdditionalContactInformation);
        }
        {
            List<WebLinkType> theWebLink;
            theWebLink = (((this.webLink!= null)&&(!this.webLink.isEmpty()))?this.getWebLink():null);
            strategy.appendField(locator, this, "webLink", buffer, theWebLink);
        }
        {
            String theAddressType;
            theAddressType = this.getAddressType();
            strategy.appendField(locator, this, "addressType", buffer, theAddressType);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            PostalAddressType thePostalAddress;
            thePostalAddress = this.getPostalAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "postalAddress", thePostalAddress), currentHashCode, thePostalAddress);
        }
        {
            AddressAdditionalContactType theAdditionalContactInformation;
            theAdditionalContactInformation = this.getAdditionalContactInformation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "additionalContactInformation", theAdditionalContactInformation), currentHashCode, theAdditionalContactInformation);
        }
        {
            List<WebLinkType> theWebLink;
            theWebLink = (((this.webLink!= null)&&(!this.webLink.isEmpty()))?this.getWebLink():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "webLink", theWebLink), currentHashCode, theWebLink);
        }
        {
            String theAddressType;
            theAddressType = this.getAddressType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "addressType", theAddressType), currentHashCode, theAddressType);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
