
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
 * <p>Java class for ExtraCommunicationFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtraCommunicationFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Phone1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Internet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtraCommunicationFactType", propOrder = {
    "phone1",
    "phone2",
    "fax",
    "email",
    "internet"
})
public class ExtraCommunicationFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Phone1")
    protected String phone1;
    @XmlElement(name = "Phone2")
    protected String phone2;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Internet")
    protected String internet;

    /**
     * Gets the value of the phone1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * Sets the value of the phone1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone1(String value) {
        this.phone1 = value;
    }

    /**
     * Gets the value of the phone2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * Sets the value of the phone2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone2(String value) {
        this.phone2 = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the internet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternet() {
        return internet;
    }

    /**
     * Sets the value of the internet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternet(String value) {
        this.internet = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtraCommunicationFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtraCommunicationFactType that = ((ExtraCommunicationFactType) object);
        {
            String lhsPhone1;
            lhsPhone1 = this.getPhone1();
            String rhsPhone1;
            rhsPhone1 = that.getPhone1();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "phone1", lhsPhone1), LocatorUtils.property(thatLocator, "phone1", rhsPhone1), lhsPhone1, rhsPhone1)) {
                return false;
            }
        }
        {
            String lhsPhone2;
            lhsPhone2 = this.getPhone2();
            String rhsPhone2;
            rhsPhone2 = that.getPhone2();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "phone2", lhsPhone2), LocatorUtils.property(thatLocator, "phone2", rhsPhone2), lhsPhone2, rhsPhone2)) {
                return false;
            }
        }
        {
            String lhsFax;
            lhsFax = this.getFax();
            String rhsFax;
            rhsFax = that.getFax();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fax", lhsFax), LocatorUtils.property(thatLocator, "fax", rhsFax), lhsFax, rhsFax)) {
                return false;
            }
        }
        {
            String lhsEmail;
            lhsEmail = this.getEmail();
            String rhsEmail;
            rhsEmail = that.getEmail();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "email", lhsEmail), LocatorUtils.property(thatLocator, "email", rhsEmail), lhsEmail, rhsEmail)) {
                return false;
            }
        }
        {
            String lhsInternet;
            lhsInternet = this.getInternet();
            String rhsInternet;
            rhsInternet = that.getInternet();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "internet", lhsInternet), LocatorUtils.property(thatLocator, "internet", rhsInternet), lhsInternet, rhsInternet)) {
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
            String thePhone1;
            thePhone1 = this.getPhone1();
            strategy.appendField(locator, this, "phone1", buffer, thePhone1);
        }
        {
            String thePhone2;
            thePhone2 = this.getPhone2();
            strategy.appendField(locator, this, "phone2", buffer, thePhone2);
        }
        {
            String theFax;
            theFax = this.getFax();
            strategy.appendField(locator, this, "fax", buffer, theFax);
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            strategy.appendField(locator, this, "email", buffer, theEmail);
        }
        {
            String theInternet;
            theInternet = this.getInternet();
            strategy.appendField(locator, this, "internet", buffer, theInternet);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String thePhone1;
            thePhone1 = this.getPhone1();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "phone1", thePhone1), currentHashCode, thePhone1);
        }
        {
            String thePhone2;
            thePhone2 = this.getPhone2();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "phone2", thePhone2), currentHashCode, thePhone2);
        }
        {
            String theFax;
            theFax = this.getFax();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fax", theFax), currentHashCode, theFax);
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "email", theEmail), currentHashCode, theEmail);
        }
        {
            String theInternet;
            theInternet = this.getInternet();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "internet", theInternet), currentHashCode, theInternet);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
