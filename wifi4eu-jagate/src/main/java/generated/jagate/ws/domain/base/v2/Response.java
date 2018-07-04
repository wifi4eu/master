
package generated.jagate.ws.domain.base.v2;

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
 * <p>Java class for Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString" minOccurs="0"/>
 *         &lt;element name="ClientRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocalObjectForeignId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Element" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", propOrder = {
    "requestId",
    "clientRef",
    "localObjectForeignId",
    "returnCode",
    "message",
    "element"
})
public class Response
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "RequestId")
    protected String requestId;
    @XmlElement(name = "ClientRef")
    protected String clientRef;
    @XmlElement(name = "LocalObjectForeignId", required = true)
    protected String localObjectForeignId;
    @XmlElement(name = "ReturnCode")
    protected long returnCode;
    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlElement(name = "Element", nillable = true)
    protected List<Object> element;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the clientRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientRef() {
        return clientRef;
    }

    /**
     * Sets the value of the clientRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientRef(String value) {
        this.clientRef = value;
    }

    /**
     * Gets the value of the localObjectForeignId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalObjectForeignId() {
        return localObjectForeignId;
    }

    /**
     * Sets the value of the localObjectForeignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalObjectForeignId(String value) {
        this.localObjectForeignId = value;
    }

    /**
     * Gets the value of the returnCode property.
     * 
     */
    public long getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     * 
     */
    public void setReturnCode(long value) {
        this.returnCode = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the element property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the element property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getElement() {
        if (element == null) {
            element = new ArrayList<Object>();
        }
        return this.element;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Response)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Response that = ((Response) object);
        {
            String lhsRequestId;
            lhsRequestId = this.getRequestId();
            String rhsRequestId;
            rhsRequestId = that.getRequestId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "requestId", lhsRequestId), LocatorUtils.property(thatLocator, "requestId", rhsRequestId), lhsRequestId, rhsRequestId)) {
                return false;
            }
        }
        {
            String lhsClientRef;
            lhsClientRef = this.getClientRef();
            String rhsClientRef;
            rhsClientRef = that.getClientRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "clientRef", lhsClientRef), LocatorUtils.property(thatLocator, "clientRef", rhsClientRef), lhsClientRef, rhsClientRef)) {
                return false;
            }
        }
        {
            String lhsLocalObjectForeignId;
            lhsLocalObjectForeignId = this.getLocalObjectForeignId();
            String rhsLocalObjectForeignId;
            rhsLocalObjectForeignId = that.getLocalObjectForeignId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "localObjectForeignId", lhsLocalObjectForeignId), LocatorUtils.property(thatLocator, "localObjectForeignId", rhsLocalObjectForeignId), lhsLocalObjectForeignId, rhsLocalObjectForeignId)) {
                return false;
            }
        }
        {
            long lhsReturnCode;
            lhsReturnCode = (true?this.getReturnCode(): 0L);
            long rhsReturnCode;
            rhsReturnCode = (true?that.getReturnCode(): 0L);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "returnCode", lhsReturnCode), LocatorUtils.property(thatLocator, "returnCode", rhsReturnCode), lhsReturnCode, rhsReturnCode)) {
                return false;
            }
        }
        {
            String lhsMessage;
            lhsMessage = this.getMessage();
            String rhsMessage;
            rhsMessage = that.getMessage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "message", lhsMessage), LocatorUtils.property(thatLocator, "message", rhsMessage), lhsMessage, rhsMessage)) {
                return false;
            }
        }
        {
            List<Object> lhsElement;
            lhsElement = (((this.element!= null)&&(!this.element.isEmpty()))?this.getElement():null);
            List<Object> rhsElement;
            rhsElement = (((that.element!= null)&&(!that.element.isEmpty()))?that.getElement():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "element", lhsElement), LocatorUtils.property(thatLocator, "element", rhsElement), lhsElement, rhsElement)) {
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
            String theRequestId;
            theRequestId = this.getRequestId();
            strategy.appendField(locator, this, "requestId", buffer, theRequestId);
        }
        {
            String theClientRef;
            theClientRef = this.getClientRef();
            strategy.appendField(locator, this, "clientRef", buffer, theClientRef);
        }
        {
            String theLocalObjectForeignId;
            theLocalObjectForeignId = this.getLocalObjectForeignId();
            strategy.appendField(locator, this, "localObjectForeignId", buffer, theLocalObjectForeignId);
        }
        {
            long theReturnCode;
            theReturnCode = (true?this.getReturnCode(): 0L);
            strategy.appendField(locator, this, "returnCode", buffer, theReturnCode);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            strategy.appendField(locator, this, "message", buffer, theMessage);
        }
        {
            List<Object> theElement;
            theElement = (((this.element!= null)&&(!this.element.isEmpty()))?this.getElement():null);
            strategy.appendField(locator, this, "element", buffer, theElement);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theRequestId;
            theRequestId = this.getRequestId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requestId", theRequestId), currentHashCode, theRequestId);
        }
        {
            String theClientRef;
            theClientRef = this.getClientRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "clientRef", theClientRef), currentHashCode, theClientRef);
        }
        {
            String theLocalObjectForeignId;
            theLocalObjectForeignId = this.getLocalObjectForeignId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localObjectForeignId", theLocalObjectForeignId), currentHashCode, theLocalObjectForeignId);
        }
        {
            long theReturnCode;
            theReturnCode = (true?this.getReturnCode(): 0L);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "returnCode", theReturnCode), currentHashCode, theReturnCode);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            List<Object> theElement;
            theElement = (((this.element!= null)&&(!this.element.isEmpty()))?this.getElement():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "element", theElement), currentHashCode, theElement);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
