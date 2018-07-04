
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * <p>Java class for DocumentAccessLogEntryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentAccessLogEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="User" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SecurityPolicy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="requestTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentAccessLogEntryType", propOrder = {
    "user",
    "securityPolicy",
    "requestTime"
})
public class DocumentAccessLogEntryType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "User", required = true)
    protected String user;
    @XmlElement(name = "SecurityPolicy", required = true)
    protected String securityPolicy;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestTime;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Gets the value of the securityPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityPolicy() {
        return securityPolicy;
    }

    /**
     * Sets the value of the securityPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityPolicy(String value) {
        this.securityPolicy = value;
    }

    /**
     * Gets the value of the requestTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestTime() {
        return requestTime;
    }

    /**
     * Sets the value of the requestTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestTime(XMLGregorianCalendar value) {
        this.requestTime = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentAccessLogEntryType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentAccessLogEntryType that = ((DocumentAccessLogEntryType) object);
        {
            String lhsUser;
            lhsUser = this.getUser();
            String rhsUser;
            rhsUser = that.getUser();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "user", lhsUser), LocatorUtils.property(thatLocator, "user", rhsUser), lhsUser, rhsUser)) {
                return false;
            }
        }
        {
            String lhsSecurityPolicy;
            lhsSecurityPolicy = this.getSecurityPolicy();
            String rhsSecurityPolicy;
            rhsSecurityPolicy = that.getSecurityPolicy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityPolicy", lhsSecurityPolicy), LocatorUtils.property(thatLocator, "securityPolicy", rhsSecurityPolicy), lhsSecurityPolicy, rhsSecurityPolicy)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsRequestTime;
            lhsRequestTime = this.getRequestTime();
            XMLGregorianCalendar rhsRequestTime;
            rhsRequestTime = that.getRequestTime();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "requestTime", lhsRequestTime), LocatorUtils.property(thatLocator, "requestTime", rhsRequestTime), lhsRequestTime, rhsRequestTime)) {
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
            String theUser;
            theUser = this.getUser();
            strategy.appendField(locator, this, "user", buffer, theUser);
        }
        {
            String theSecurityPolicy;
            theSecurityPolicy = this.getSecurityPolicy();
            strategy.appendField(locator, this, "securityPolicy", buffer, theSecurityPolicy);
        }
        {
            XMLGregorianCalendar theRequestTime;
            theRequestTime = this.getRequestTime();
            strategy.appendField(locator, this, "requestTime", buffer, theRequestTime);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theUser;
            theUser = this.getUser();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "user", theUser), currentHashCode, theUser);
        }
        {
            String theSecurityPolicy;
            theSecurityPolicy = this.getSecurityPolicy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityPolicy", theSecurityPolicy), currentHashCode, theSecurityPolicy);
        }
        {
            XMLGregorianCalendar theRequestTime;
            theRequestTime = this.getRequestTime();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requestTime", theRequestTime), currentHashCode, theRequestTime);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
