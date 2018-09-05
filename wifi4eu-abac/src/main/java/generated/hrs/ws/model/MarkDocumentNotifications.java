
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ec.europa.eu/sg/hrs/types}header"/>
 *         &lt;element name="notificationId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="read" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "notificationId",
    "read"
})
@XmlRootElement(name = "markDocumentNotifications")
public class MarkDocumentNotifications
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected List<String> notificationId;
    protected boolean read;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the notificationId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notificationId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotificationId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNotificationId() {
        if (notificationId == null) {
            notificationId = new ArrayList<String>();
        }
        return this.notificationId;
    }

    /**
     * Gets the value of the read property.
     * 
     */
    public boolean isRead() {
        return read;
    }

    /**
     * Sets the value of the read property.
     * 
     */
    public void setRead(boolean value) {
        this.read = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof MarkDocumentNotifications)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final MarkDocumentNotifications that = ((MarkDocumentNotifications) object);
        {
            Header lhsHeader;
            lhsHeader = this.getHeader();
            Header rhsHeader;
            rhsHeader = that.getHeader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "header", lhsHeader), LocatorUtils.property(thatLocator, "header", rhsHeader), lhsHeader, rhsHeader)) {
                return false;
            }
        }
        {
            List<String> lhsNotificationId;
            lhsNotificationId = (((this.notificationId!= null)&&(!this.notificationId.isEmpty()))?this.getNotificationId():null);
            List<String> rhsNotificationId;
            rhsNotificationId = (((that.notificationId!= null)&&(!that.notificationId.isEmpty()))?that.getNotificationId():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "notificationId", lhsNotificationId), LocatorUtils.property(thatLocator, "notificationId", rhsNotificationId), lhsNotificationId, rhsNotificationId)) {
                return false;
            }
        }
        {
            boolean lhsRead;
            lhsRead = (true?this.isRead():false);
            boolean rhsRead;
            rhsRead = (true?that.isRead():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "read", lhsRead), LocatorUtils.property(thatLocator, "read", rhsRead), lhsRead, rhsRead)) {
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
            Header theHeader;
            theHeader = this.getHeader();
            strategy.appendField(locator, this, "header", buffer, theHeader);
        }
        {
            List<String> theNotificationId;
            theNotificationId = (((this.notificationId!= null)&&(!this.notificationId.isEmpty()))?this.getNotificationId():null);
            strategy.appendField(locator, this, "notificationId", buffer, theNotificationId);
        }
        {
            boolean theRead;
            theRead = (true?this.isRead():false);
            strategy.appendField(locator, this, "read", buffer, theRead);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Header theHeader;
            theHeader = this.getHeader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "header", theHeader), currentHashCode, theHeader);
        }
        {
            List<String> theNotificationId;
            theNotificationId = (((this.notificationId!= null)&&(!this.notificationId.isEmpty()))?this.getNotificationId():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "notificationId", theNotificationId), currentHashCode, theNotificationId);
        }
        {
            boolean theRead;
            theRead = (true?this.isRead():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "read", theRead), currentHashCode, theRead);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
