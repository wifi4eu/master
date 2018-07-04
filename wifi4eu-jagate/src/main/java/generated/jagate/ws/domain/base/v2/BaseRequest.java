
package generated.jagate.ws.domain.base.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.ws.domain.constants.v1.ERequestClient;
import generated.jagate.ws.domain.constants.v1.ERequestType;
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
 * <p>Java class for BaseRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientRef" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LocalObjectForeignId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RequestType" type="{http://ec.europa.eu/rdg/jagate/ws/domain/constants/v1}ERequestType"/>
 *         &lt;element name="Client" type="{http://ec.europa.eu/rdg/jagate/ws/domain/constants/v1}ERequestClient"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequest", propOrder = {
    "requestId",
    "clientRef",
    "localObjectForeignId",
    "status",
    "requestType",
    "client"
})
public class BaseRequest
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "RequestId")
    protected String requestId;
    @XmlElement(name = "ClientRef", required = true)
    protected String clientRef;
    @XmlElement(name = "LocalObjectForeignId")
    protected String localObjectForeignId;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "RequestType", required = true)
    protected ERequestType requestType;
    @XmlElement(name = "Client", required = true)
    protected ERequestClient client;

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link ERequestType }
     *     
     */
    public ERequestType getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERequestType }
     *     
     */
    public void setRequestType(ERequestType value) {
        this.requestType = value;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link ERequestClient }
     *     
     */
    public ERequestClient getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERequestClient }
     *     
     */
    public void setClient(ERequestClient value) {
        this.client = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BaseRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final BaseRequest that = ((BaseRequest) object);
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
            String lhsStatus;
            lhsStatus = this.getStatus();
            String rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            ERequestType lhsRequestType;
            lhsRequestType = this.getRequestType();
            ERequestType rhsRequestType;
            rhsRequestType = that.getRequestType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "requestType", lhsRequestType), LocatorUtils.property(thatLocator, "requestType", rhsRequestType), lhsRequestType, rhsRequestType)) {
                return false;
            }
        }
        {
            ERequestClient lhsClient;
            lhsClient = this.getClient();
            ERequestClient rhsClient;
            rhsClient = that.getClient();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "client", lhsClient), LocatorUtils.property(thatLocator, "client", rhsClient), lhsClient, rhsClient)) {
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
            String theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            ERequestType theRequestType;
            theRequestType = this.getRequestType();
            strategy.appendField(locator, this, "requestType", buffer, theRequestType);
        }
        {
            ERequestClient theClient;
            theClient = this.getClient();
            strategy.appendField(locator, this, "client", buffer, theClient);
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
            String theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            ERequestType theRequestType;
            theRequestType = this.getRequestType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requestType", theRequestType), currentHashCode, theRequestType);
        }
        {
            ERequestClient theClient;
            theClient = this.getClient();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "client", theClient), currentHashCode, theClient);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
