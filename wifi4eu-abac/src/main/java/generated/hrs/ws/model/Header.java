
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
 * <p>Java class for Header complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Header">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mappedJobUser" type="{http://ec.europa.eu/sg/hrs/types}JobUserName" minOccurs="0"/>
 *         &lt;element name="onBehalfOf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticket" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applicationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header", propOrder = {
    "userName",
    "mappedJobUser",
    "onBehalfOf",
    "ticket",
    "applicationId"
})
public class Header
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String userName;
    protected String mappedJobUser;
    protected String onBehalfOf;
    @XmlElement(required = true)
    protected String ticket;
    @XmlElement(required = true)
    protected String applicationId;

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the mappedJobUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMappedJobUser() {
        return mappedJobUser;
    }

    /**
     * Sets the value of the mappedJobUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMappedJobUser(String value) {
        this.mappedJobUser = value;
    }

    /**
     * Gets the value of the onBehalfOf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnBehalfOf() {
        return onBehalfOf;
    }

    /**
     * Sets the value of the onBehalfOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnBehalfOf(String value) {
        this.onBehalfOf = value;
    }

    /**
     * Gets the value of the ticket property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * Sets the value of the ticket property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicket(String value) {
        this.ticket = value;
    }

    /**
     * Gets the value of the applicationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the value of the applicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationId(String value) {
        this.applicationId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Header)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Header that = ((Header) object);
        {
            String lhsUserName;
            lhsUserName = this.getUserName();
            String rhsUserName;
            rhsUserName = that.getUserName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userName", lhsUserName), LocatorUtils.property(thatLocator, "userName", rhsUserName), lhsUserName, rhsUserName)) {
                return false;
            }
        }
        {
            String lhsMappedJobUser;
            lhsMappedJobUser = this.getMappedJobUser();
            String rhsMappedJobUser;
            rhsMappedJobUser = that.getMappedJobUser();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mappedJobUser", lhsMappedJobUser), LocatorUtils.property(thatLocator, "mappedJobUser", rhsMappedJobUser), lhsMappedJobUser, rhsMappedJobUser)) {
                return false;
            }
        }
        {
            String lhsOnBehalfOf;
            lhsOnBehalfOf = this.getOnBehalfOf();
            String rhsOnBehalfOf;
            rhsOnBehalfOf = that.getOnBehalfOf();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onBehalfOf", lhsOnBehalfOf), LocatorUtils.property(thatLocator, "onBehalfOf", rhsOnBehalfOf), lhsOnBehalfOf, rhsOnBehalfOf)) {
                return false;
            }
        }
        {
            String lhsTicket;
            lhsTicket = this.getTicket();
            String rhsTicket;
            rhsTicket = that.getTicket();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ticket", lhsTicket), LocatorUtils.property(thatLocator, "ticket", rhsTicket), lhsTicket, rhsTicket)) {
                return false;
            }
        }
        {
            String lhsApplicationId;
            lhsApplicationId = this.getApplicationId();
            String rhsApplicationId;
            rhsApplicationId = that.getApplicationId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "applicationId", lhsApplicationId), LocatorUtils.property(thatLocator, "applicationId", rhsApplicationId), lhsApplicationId, rhsApplicationId)) {
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
            String theUserName;
            theUserName = this.getUserName();
            strategy.appendField(locator, this, "userName", buffer, theUserName);
        }
        {
            String theMappedJobUser;
            theMappedJobUser = this.getMappedJobUser();
            strategy.appendField(locator, this, "mappedJobUser", buffer, theMappedJobUser);
        }
        {
            String theOnBehalfOf;
            theOnBehalfOf = this.getOnBehalfOf();
            strategy.appendField(locator, this, "onBehalfOf", buffer, theOnBehalfOf);
        }
        {
            String theTicket;
            theTicket = this.getTicket();
            strategy.appendField(locator, this, "ticket", buffer, theTicket);
        }
        {
            String theApplicationId;
            theApplicationId = this.getApplicationId();
            strategy.appendField(locator, this, "applicationId", buffer, theApplicationId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theUserName;
            theUserName = this.getUserName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userName", theUserName), currentHashCode, theUserName);
        }
        {
            String theMappedJobUser;
            theMappedJobUser = this.getMappedJobUser();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mappedJobUser", theMappedJobUser), currentHashCode, theMappedJobUser);
        }
        {
            String theOnBehalfOf;
            theOnBehalfOf = this.getOnBehalfOf();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onBehalfOf", theOnBehalfOf), currentHashCode, theOnBehalfOf);
        }
        {
            String theTicket;
            theTicket = this.getTicket();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ticket", theTicket), currentHashCode, theTicket);
        }
        {
            String theApplicationId;
            theApplicationId = this.getApplicationId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "applicationId", theApplicationId), currentHashCode, theApplicationId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
