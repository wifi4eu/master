
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
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
 * Structure representing the response for the operation getUpdateFileStatusAsyncResult
 * 
 * <p>Java class for UpdateFileStatusAsyncResultResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFileStatusAsyncResultResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://ec.europa.eu/sg/hrs/types}AsyncOperationStatus"/>
 *         &lt;element name="creationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="lastUpdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="statusMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorDetailMessage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFileStatusAsyncResultResponse", propOrder = {
    "status",
    "creationTime",
    "lastUpdate",
    "statusMessage",
    "errorDetailMessage"
})
public class UpdateFileStatusAsyncResultResponse
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected AsyncOperationStatus status;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdate;
    protected String statusMessage;
    protected List<String> errorDetailMessage;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link AsyncOperationStatus }
     *     
     */
    public AsyncOperationStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link AsyncOperationStatus }
     *     
     */
    public void setStatus(AsyncOperationStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationTime(XMLGregorianCalendar value) {
        this.creationTime = value;
    }

    /**
     * Gets the value of the lastUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Sets the value of the lastUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdate(XMLGregorianCalendar value) {
        this.lastUpdate = value;
    }

    /**
     * Gets the value of the statusMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Sets the value of the statusMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusMessage(String value) {
        this.statusMessage = value;
    }

    /**
     * Gets the value of the errorDetailMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorDetailMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorDetailMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getErrorDetailMessage() {
        if (errorDetailMessage == null) {
            errorDetailMessage = new ArrayList<String>();
        }
        return this.errorDetailMessage;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UpdateFileStatusAsyncResultResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UpdateFileStatusAsyncResultResponse that = ((UpdateFileStatusAsyncResultResponse) object);
        {
            AsyncOperationStatus lhsStatus;
            lhsStatus = this.getStatus();
            AsyncOperationStatus rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsCreationTime;
            lhsCreationTime = this.getCreationTime();
            XMLGregorianCalendar rhsCreationTime;
            rhsCreationTime = that.getCreationTime();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creationTime", lhsCreationTime), LocatorUtils.property(thatLocator, "creationTime", rhsCreationTime), lhsCreationTime, rhsCreationTime)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsLastUpdate;
            lhsLastUpdate = this.getLastUpdate();
            XMLGregorianCalendar rhsLastUpdate;
            rhsLastUpdate = that.getLastUpdate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastUpdate", lhsLastUpdate), LocatorUtils.property(thatLocator, "lastUpdate", rhsLastUpdate), lhsLastUpdate, rhsLastUpdate)) {
                return false;
            }
        }
        {
            String lhsStatusMessage;
            lhsStatusMessage = this.getStatusMessage();
            String rhsStatusMessage;
            rhsStatusMessage = that.getStatusMessage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "statusMessage", lhsStatusMessage), LocatorUtils.property(thatLocator, "statusMessage", rhsStatusMessage), lhsStatusMessage, rhsStatusMessage)) {
                return false;
            }
        }
        {
            List<String> lhsErrorDetailMessage;
            lhsErrorDetailMessage = (((this.errorDetailMessage!= null)&&(!this.errorDetailMessage.isEmpty()))?this.getErrorDetailMessage():null);
            List<String> rhsErrorDetailMessage;
            rhsErrorDetailMessage = (((that.errorDetailMessage!= null)&&(!that.errorDetailMessage.isEmpty()))?that.getErrorDetailMessage():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "errorDetailMessage", lhsErrorDetailMessage), LocatorUtils.property(thatLocator, "errorDetailMessage", rhsErrorDetailMessage), lhsErrorDetailMessage, rhsErrorDetailMessage)) {
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
            AsyncOperationStatus theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            XMLGregorianCalendar theCreationTime;
            theCreationTime = this.getCreationTime();
            strategy.appendField(locator, this, "creationTime", buffer, theCreationTime);
        }
        {
            XMLGregorianCalendar theLastUpdate;
            theLastUpdate = this.getLastUpdate();
            strategy.appendField(locator, this, "lastUpdate", buffer, theLastUpdate);
        }
        {
            String theStatusMessage;
            theStatusMessage = this.getStatusMessage();
            strategy.appendField(locator, this, "statusMessage", buffer, theStatusMessage);
        }
        {
            List<String> theErrorDetailMessage;
            theErrorDetailMessage = (((this.errorDetailMessage!= null)&&(!this.errorDetailMessage.isEmpty()))?this.getErrorDetailMessage():null);
            strategy.appendField(locator, this, "errorDetailMessage", buffer, theErrorDetailMessage);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            AsyncOperationStatus theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            XMLGregorianCalendar theCreationTime;
            theCreationTime = this.getCreationTime();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creationTime", theCreationTime), currentHashCode, theCreationTime);
        }
        {
            XMLGregorianCalendar theLastUpdate;
            theLastUpdate = this.getLastUpdate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastUpdate", theLastUpdate), currentHashCode, theLastUpdate);
        }
        {
            String theStatusMessage;
            theStatusMessage = this.getStatusMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "statusMessage", theStatusMessage), currentHashCode, theStatusMessage);
        }
        {
            List<String> theErrorDetailMessage;
            theErrorDetailMessage = (((this.errorDetailMessage!= null)&&(!this.errorDetailMessage.isEmpty()))?this.getErrorDetailMessage():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "errorDetailMessage", theErrorDetailMessage), currentHashCode, theErrorDetailMessage);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
