
package generated.hrs.ws.model;

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
 * A notification about a document
 * 
 * <p>Java class for DocumentNotification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentNotification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="notificationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="read" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="followUp" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="document" type="{http://ec.europa.eu/sg/hrs/types}Document"/>
 *         &lt;element name="readOn" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentNotification", propOrder = {
    "notificationId",
    "read",
    "followUp",
    "document",
    "readOn"
})
public class DocumentNotification
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String notificationId;
    protected boolean read;
    protected boolean followUp;
    @XmlElement(required = true)
    protected Document document;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar readOn;

    /**
     * Gets the value of the notificationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationId() {
        return notificationId;
    }

    /**
     * Sets the value of the notificationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationId(String value) {
        this.notificationId = value;
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

    /**
     * Gets the value of the followUp property.
     * 
     */
    public boolean isFollowUp() {
        return followUp;
    }

    /**
     * Sets the value of the followUp property.
     * 
     */
    public void setFollowUp(boolean value) {
        this.followUp = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link Document }
     *     
     */
    public Document getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document }
     *     
     */
    public void setDocument(Document value) {
        this.document = value;
    }

    /**
     * Gets the value of the readOn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReadOn() {
        return readOn;
    }

    /**
     * Sets the value of the readOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReadOn(XMLGregorianCalendar value) {
        this.readOn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentNotification)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentNotification that = ((DocumentNotification) object);
        {
            String lhsNotificationId;
            lhsNotificationId = this.getNotificationId();
            String rhsNotificationId;
            rhsNotificationId = that.getNotificationId();
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
        {
            boolean lhsFollowUp;
            lhsFollowUp = (true?this.isFollowUp():false);
            boolean rhsFollowUp;
            rhsFollowUp = (true?that.isFollowUp():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "followUp", lhsFollowUp), LocatorUtils.property(thatLocator, "followUp", rhsFollowUp), lhsFollowUp, rhsFollowUp)) {
                return false;
            }
        }
        {
            Document lhsDocument;
            lhsDocument = this.getDocument();
            Document rhsDocument;
            rhsDocument = that.getDocument();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "document", lhsDocument), LocatorUtils.property(thatLocator, "document", rhsDocument), lhsDocument, rhsDocument)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsReadOn;
            lhsReadOn = this.getReadOn();
            XMLGregorianCalendar rhsReadOn;
            rhsReadOn = that.getReadOn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "readOn", lhsReadOn), LocatorUtils.property(thatLocator, "readOn", rhsReadOn), lhsReadOn, rhsReadOn)) {
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
            String theNotificationId;
            theNotificationId = this.getNotificationId();
            strategy.appendField(locator, this, "notificationId", buffer, theNotificationId);
        }
        {
            boolean theRead;
            theRead = (true?this.isRead():false);
            strategy.appendField(locator, this, "read", buffer, theRead);
        }
        {
            boolean theFollowUp;
            theFollowUp = (true?this.isFollowUp():false);
            strategy.appendField(locator, this, "followUp", buffer, theFollowUp);
        }
        {
            Document theDocument;
            theDocument = this.getDocument();
            strategy.appendField(locator, this, "document", buffer, theDocument);
        }
        {
            XMLGregorianCalendar theReadOn;
            theReadOn = this.getReadOn();
            strategy.appendField(locator, this, "readOn", buffer, theReadOn);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theNotificationId;
            theNotificationId = this.getNotificationId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "notificationId", theNotificationId), currentHashCode, theNotificationId);
        }
        {
            boolean theRead;
            theRead = (true?this.isRead():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "read", theRead), currentHashCode, theRead);
        }
        {
            boolean theFollowUp;
            theFollowUp = (true?this.isFollowUp():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "followUp", theFollowUp), currentHashCode, theFollowUp);
        }
        {
            Document theDocument;
            theDocument = this.getDocument();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "document", theDocument), currentHashCode, theDocument);
        }
        {
            XMLGregorianCalendar theReadOn;
            theReadOn = this.getReadOn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "readOn", theReadOn), currentHashCode, theReadOn);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
