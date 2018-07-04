
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
 * <p>Java class for SoaResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoaResponseMessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contextField" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="severity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="businessRuleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detailMessage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoaResponseMessageType", propOrder = {
    "contextField",
    "severity",
    "businessRuleCode",
    "message",
    "detailMessage"
})
public class SoaResponseMessageType
    implements Equals, HashCode, ToString
{

    protected String contextField;
    protected String severity;
    protected String businessRuleCode;
    @XmlElement(required = true)
    protected String message;
    protected List<String> detailMessage;

    /**
     * Gets the value of the contextField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextField() {
        return contextField;
    }

    /**
     * Sets the value of the contextField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextField(String value) {
        this.contextField = value;
    }

    /**
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeverity(String value) {
        this.severity = value;
    }

    /**
     * Gets the value of the businessRuleCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessRuleCode() {
        return businessRuleCode;
    }

    /**
     * Sets the value of the businessRuleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessRuleCode(String value) {
        this.businessRuleCode = value;
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
     * Gets the value of the detailMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detailMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetailMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDetailMessage() {
        if (detailMessage == null) {
            detailMessage = new ArrayList<String>();
        }
        return this.detailMessage;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SoaResponseMessageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SoaResponseMessageType that = ((SoaResponseMessageType) object);
        {
            String lhsContextField;
            lhsContextField = this.getContextField();
            String rhsContextField;
            rhsContextField = that.getContextField();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contextField", lhsContextField), LocatorUtils.property(thatLocator, "contextField", rhsContextField), lhsContextField, rhsContextField)) {
                return false;
            }
        }
        {
            String lhsSeverity;
            lhsSeverity = this.getSeverity();
            String rhsSeverity;
            rhsSeverity = that.getSeverity();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "severity", lhsSeverity), LocatorUtils.property(thatLocator, "severity", rhsSeverity), lhsSeverity, rhsSeverity)) {
                return false;
            }
        }
        {
            String lhsBusinessRuleCode;
            lhsBusinessRuleCode = this.getBusinessRuleCode();
            String rhsBusinessRuleCode;
            rhsBusinessRuleCode = that.getBusinessRuleCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "businessRuleCode", lhsBusinessRuleCode), LocatorUtils.property(thatLocator, "businessRuleCode", rhsBusinessRuleCode), lhsBusinessRuleCode, rhsBusinessRuleCode)) {
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
            List<String> lhsDetailMessage;
            lhsDetailMessage = (((this.detailMessage!= null)&&(!this.detailMessage.isEmpty()))?this.getDetailMessage():null);
            List<String> rhsDetailMessage;
            rhsDetailMessage = (((that.detailMessage!= null)&&(!that.detailMessage.isEmpty()))?that.getDetailMessage():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "detailMessage", lhsDetailMessage), LocatorUtils.property(thatLocator, "detailMessage", rhsDetailMessage), lhsDetailMessage, rhsDetailMessage)) {
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
            String theContextField;
            theContextField = this.getContextField();
            strategy.appendField(locator, this, "contextField", buffer, theContextField);
        }
        {
            String theSeverity;
            theSeverity = this.getSeverity();
            strategy.appendField(locator, this, "severity", buffer, theSeverity);
        }
        {
            String theBusinessRuleCode;
            theBusinessRuleCode = this.getBusinessRuleCode();
            strategy.appendField(locator, this, "businessRuleCode", buffer, theBusinessRuleCode);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            strategy.appendField(locator, this, "message", buffer, theMessage);
        }
        {
            List<String> theDetailMessage;
            theDetailMessage = (((this.detailMessage!= null)&&(!this.detailMessage.isEmpty()))?this.getDetailMessage():null);
            strategy.appendField(locator, this, "detailMessage", buffer, theDetailMessage);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theContextField;
            theContextField = this.getContextField();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contextField", theContextField), currentHashCode, theContextField);
        }
        {
            String theSeverity;
            theSeverity = this.getSeverity();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "severity", theSeverity), currentHashCode, theSeverity);
        }
        {
            String theBusinessRuleCode;
            theBusinessRuleCode = this.getBusinessRuleCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "businessRuleCode", theBusinessRuleCode), currentHashCode, theBusinessRuleCode);
        }
        {
            String theMessage;
            theMessage = this.getMessage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "message", theMessage), currentHashCode, theMessage);
        }
        {
            List<String> theDetailMessage;
            theDetailMessage = (((this.detailMessage!= null)&&(!this.detailMessage.isEmpty()))?this.getDetailMessage():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "detailMessage", theDetailMessage), currentHashCode, theDetailMessage);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
