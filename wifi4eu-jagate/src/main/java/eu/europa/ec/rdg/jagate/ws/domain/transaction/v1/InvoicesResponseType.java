
package eu.europa.ec.rdg.jagate.ws.domain.transaction.v1;

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
 * <p>Java class for InvoicesResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoicesResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invoicelocalObjectForeigId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invoiceStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoicesResponseType", propOrder = {
    "invoicelocalObjectForeigId",
    "invoiceStatus"
})
public class InvoicesResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String invoicelocalObjectForeigId;
    @XmlElement(required = true)
    protected String invoiceStatus;

    /**
     * Gets the value of the invoicelocalObjectForeigId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoicelocalObjectForeigId() {
        return invoicelocalObjectForeigId;
    }

    /**
     * Sets the value of the invoicelocalObjectForeigId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoicelocalObjectForeigId(String value) {
        this.invoicelocalObjectForeigId = value;
    }

    /**
     * Gets the value of the invoiceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * Sets the value of the invoiceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceStatus(String value) {
        this.invoiceStatus = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof InvoicesResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final InvoicesResponseType that = ((InvoicesResponseType) object);
        {
            String lhsInvoicelocalObjectForeigId;
            lhsInvoicelocalObjectForeigId = this.getInvoicelocalObjectForeigId();
            String rhsInvoicelocalObjectForeigId;
            rhsInvoicelocalObjectForeigId = that.getInvoicelocalObjectForeigId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "invoicelocalObjectForeigId", lhsInvoicelocalObjectForeigId), LocatorUtils.property(thatLocator, "invoicelocalObjectForeigId", rhsInvoicelocalObjectForeigId), lhsInvoicelocalObjectForeigId, rhsInvoicelocalObjectForeigId)) {
                return false;
            }
        }
        {
            String lhsInvoiceStatus;
            lhsInvoiceStatus = this.getInvoiceStatus();
            String rhsInvoiceStatus;
            rhsInvoiceStatus = that.getInvoiceStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "invoiceStatus", lhsInvoiceStatus), LocatorUtils.property(thatLocator, "invoiceStatus", rhsInvoiceStatus), lhsInvoiceStatus, rhsInvoiceStatus)) {
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
            String theInvoicelocalObjectForeigId;
            theInvoicelocalObjectForeigId = this.getInvoicelocalObjectForeigId();
            strategy.appendField(locator, this, "invoicelocalObjectForeigId", buffer, theInvoicelocalObjectForeigId);
        }
        {
            String theInvoiceStatus;
            theInvoiceStatus = this.getInvoiceStatus();
            strategy.appendField(locator, this, "invoiceStatus", buffer, theInvoiceStatus);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theInvoicelocalObjectForeigId;
            theInvoicelocalObjectForeigId = this.getInvoicelocalObjectForeigId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "invoicelocalObjectForeigId", theInvoicelocalObjectForeigId), currentHashCode, theInvoicelocalObjectForeigId);
        }
        {
            String theInvoiceStatus;
            theInvoiceStatus = this.getInvoiceStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "invoiceStatus", theInvoiceStatus), currentHashCode, theInvoiceStatus);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
