
package eu.europa.ec.rdg.jagate.ws.domain.transaction.v1;

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
 * <p>Java class for RecoveryOrderStatusResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecoveryOrderStatusResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recoveryOrderStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recoveryOrderamount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="modifDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="invoices" type="{http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1}InvoicesResponseType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecoveryOrderStatusResponseType", propOrder = {
    "recoveryOrderStatus",
    "recoveryOrderamount",
    "modifDate",
    "invoices"
})
public class RecoveryOrderStatusResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String recoveryOrderStatus;
    protected double recoveryOrderamount;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifDate;
    protected List<InvoicesResponseType> invoices;

    /**
     * Gets the value of the recoveryOrderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecoveryOrderStatus() {
        return recoveryOrderStatus;
    }

    /**
     * Sets the value of the recoveryOrderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecoveryOrderStatus(String value) {
        this.recoveryOrderStatus = value;
    }

    /**
     * Gets the value of the recoveryOrderamount property.
     * 
     */
    public double getRecoveryOrderamount() {
        return recoveryOrderamount;
    }

    /**
     * Sets the value of the recoveryOrderamount property.
     * 
     */
    public void setRecoveryOrderamount(double value) {
        this.recoveryOrderamount = value;
    }

    /**
     * Gets the value of the modifDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModifDate() {
        return modifDate;
    }

    /**
     * Sets the value of the modifDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModifDate(XMLGregorianCalendar value) {
        this.modifDate = value;
    }

    /**
     * Gets the value of the invoices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoicesResponseType }
     * 
     * 
     */
    public List<InvoicesResponseType> getInvoices() {
        if (invoices == null) {
            invoices = new ArrayList<InvoicesResponseType>();
        }
        return this.invoices;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RecoveryOrderStatusResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RecoveryOrderStatusResponseType that = ((RecoveryOrderStatusResponseType) object);
        {
            String lhsRecoveryOrderStatus;
            lhsRecoveryOrderStatus = this.getRecoveryOrderStatus();
            String rhsRecoveryOrderStatus;
            rhsRecoveryOrderStatus = that.getRecoveryOrderStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recoveryOrderStatus", lhsRecoveryOrderStatus), LocatorUtils.property(thatLocator, "recoveryOrderStatus", rhsRecoveryOrderStatus), lhsRecoveryOrderStatus, rhsRecoveryOrderStatus)) {
                return false;
            }
        }
        {
            double lhsRecoveryOrderamount;
            lhsRecoveryOrderamount = (true?this.getRecoveryOrderamount(): 0.0D);
            double rhsRecoveryOrderamount;
            rhsRecoveryOrderamount = (true?that.getRecoveryOrderamount(): 0.0D);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recoveryOrderamount", lhsRecoveryOrderamount), LocatorUtils.property(thatLocator, "recoveryOrderamount", rhsRecoveryOrderamount), lhsRecoveryOrderamount, rhsRecoveryOrderamount)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsModifDate;
            lhsModifDate = this.getModifDate();
            XMLGregorianCalendar rhsModifDate;
            rhsModifDate = that.getModifDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "modifDate", lhsModifDate), LocatorUtils.property(thatLocator, "modifDate", rhsModifDate), lhsModifDate, rhsModifDate)) {
                return false;
            }
        }
        {
            List<InvoicesResponseType> lhsInvoices;
            lhsInvoices = (((this.invoices!= null)&&(!this.invoices.isEmpty()))?this.getInvoices():null);
            List<InvoicesResponseType> rhsInvoices;
            rhsInvoices = (((that.invoices!= null)&&(!that.invoices.isEmpty()))?that.getInvoices():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "invoices", lhsInvoices), LocatorUtils.property(thatLocator, "invoices", rhsInvoices), lhsInvoices, rhsInvoices)) {
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
            String theRecoveryOrderStatus;
            theRecoveryOrderStatus = this.getRecoveryOrderStatus();
            strategy.appendField(locator, this, "recoveryOrderStatus", buffer, theRecoveryOrderStatus);
        }
        {
            double theRecoveryOrderamount;
            theRecoveryOrderamount = (true?this.getRecoveryOrderamount(): 0.0D);
            strategy.appendField(locator, this, "recoveryOrderamount", buffer, theRecoveryOrderamount);
        }
        {
            XMLGregorianCalendar theModifDate;
            theModifDate = this.getModifDate();
            strategy.appendField(locator, this, "modifDate", buffer, theModifDate);
        }
        {
            List<InvoicesResponseType> theInvoices;
            theInvoices = (((this.invoices!= null)&&(!this.invoices.isEmpty()))?this.getInvoices():null);
            strategy.appendField(locator, this, "invoices", buffer, theInvoices);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theRecoveryOrderStatus;
            theRecoveryOrderStatus = this.getRecoveryOrderStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recoveryOrderStatus", theRecoveryOrderStatus), currentHashCode, theRecoveryOrderStatus);
        }
        {
            double theRecoveryOrderamount;
            theRecoveryOrderamount = (true?this.getRecoveryOrderamount(): 0.0D);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recoveryOrderamount", theRecoveryOrderamount), currentHashCode, theRecoveryOrderamount);
        }
        {
            XMLGregorianCalendar theModifDate;
            theModifDate = this.getModifDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "modifDate", theModifDate), currentHashCode, theModifDate);
        }
        {
            List<InvoicesResponseType> theInvoices;
            theInvoices = (((this.invoices!= null)&&(!this.invoices.isEmpty()))?this.getInvoices():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "invoices", theInvoices), currentHashCode, theInvoices);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
