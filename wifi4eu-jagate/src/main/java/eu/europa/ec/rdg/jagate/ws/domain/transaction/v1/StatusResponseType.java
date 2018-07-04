
package eu.europa.ec.rdg.jagate.ws.domain.transaction.v1;

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
 * <p>Java class for StatusResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="localObjectForeigId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transactionStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workflowStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workflowLevel" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="modifDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="transactionType" type="{http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1}TransactionSubtype"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusResponseType", propOrder = {
    "localObjectForeigId",
    "transactionStatus",
    "workflowStatus",
    "workflowLevel",
    "modifDate",
    "transactionType"
})
public class StatusResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String localObjectForeigId;
    @XmlElement(required = true)
    protected String transactionStatus;
    @XmlElement(required = true)
    protected String workflowStatus;
    protected long workflowLevel;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifDate;
    @XmlElement(required = true)
    protected TransactionSubtype transactionType;

    /**
     * Gets the value of the localObjectForeigId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalObjectForeigId() {
        return localObjectForeigId;
    }

    /**
     * Sets the value of the localObjectForeigId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalObjectForeigId(String value) {
        this.localObjectForeigId = value;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionStatus(String value) {
        this.transactionStatus = value;
    }

    /**
     * Gets the value of the workflowStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowStatus() {
        return workflowStatus;
    }

    /**
     * Sets the value of the workflowStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowStatus(String value) {
        this.workflowStatus = value;
    }

    /**
     * Gets the value of the workflowLevel property.
     * 
     */
    public long getWorkflowLevel() {
        return workflowLevel;
    }

    /**
     * Sets the value of the workflowLevel property.
     * 
     */
    public void setWorkflowLevel(long value) {
        this.workflowLevel = value;
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
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionSubtype }
     *     
     */
    public TransactionSubtype getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionSubtype }
     *     
     */
    public void setTransactionType(TransactionSubtype value) {
        this.transactionType = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof StatusResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final StatusResponseType that = ((StatusResponseType) object);
        {
            String lhsLocalObjectForeigId;
            lhsLocalObjectForeigId = this.getLocalObjectForeigId();
            String rhsLocalObjectForeigId;
            rhsLocalObjectForeigId = that.getLocalObjectForeigId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "localObjectForeigId", lhsLocalObjectForeigId), LocatorUtils.property(thatLocator, "localObjectForeigId", rhsLocalObjectForeigId), lhsLocalObjectForeigId, rhsLocalObjectForeigId)) {
                return false;
            }
        }
        {
            String lhsTransactionStatus;
            lhsTransactionStatus = this.getTransactionStatus();
            String rhsTransactionStatus;
            rhsTransactionStatus = that.getTransactionStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transactionStatus", lhsTransactionStatus), LocatorUtils.property(thatLocator, "transactionStatus", rhsTransactionStatus), lhsTransactionStatus, rhsTransactionStatus)) {
                return false;
            }
        }
        {
            String lhsWorkflowStatus;
            lhsWorkflowStatus = this.getWorkflowStatus();
            String rhsWorkflowStatus;
            rhsWorkflowStatus = that.getWorkflowStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "workflowStatus", lhsWorkflowStatus), LocatorUtils.property(thatLocator, "workflowStatus", rhsWorkflowStatus), lhsWorkflowStatus, rhsWorkflowStatus)) {
                return false;
            }
        }
        {
            long lhsWorkflowLevel;
            lhsWorkflowLevel = (true?this.getWorkflowLevel(): 0L);
            long rhsWorkflowLevel;
            rhsWorkflowLevel = (true?that.getWorkflowLevel(): 0L);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "workflowLevel", lhsWorkflowLevel), LocatorUtils.property(thatLocator, "workflowLevel", rhsWorkflowLevel), lhsWorkflowLevel, rhsWorkflowLevel)) {
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
            TransactionSubtype lhsTransactionType;
            lhsTransactionType = this.getTransactionType();
            TransactionSubtype rhsTransactionType;
            rhsTransactionType = that.getTransactionType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transactionType", lhsTransactionType), LocatorUtils.property(thatLocator, "transactionType", rhsTransactionType), lhsTransactionType, rhsTransactionType)) {
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
            String theLocalObjectForeigId;
            theLocalObjectForeigId = this.getLocalObjectForeigId();
            strategy.appendField(locator, this, "localObjectForeigId", buffer, theLocalObjectForeigId);
        }
        {
            String theTransactionStatus;
            theTransactionStatus = this.getTransactionStatus();
            strategy.appendField(locator, this, "transactionStatus", buffer, theTransactionStatus);
        }
        {
            String theWorkflowStatus;
            theWorkflowStatus = this.getWorkflowStatus();
            strategy.appendField(locator, this, "workflowStatus", buffer, theWorkflowStatus);
        }
        {
            long theWorkflowLevel;
            theWorkflowLevel = (true?this.getWorkflowLevel(): 0L);
            strategy.appendField(locator, this, "workflowLevel", buffer, theWorkflowLevel);
        }
        {
            XMLGregorianCalendar theModifDate;
            theModifDate = this.getModifDate();
            strategy.appendField(locator, this, "modifDate", buffer, theModifDate);
        }
        {
            TransactionSubtype theTransactionType;
            theTransactionType = this.getTransactionType();
            strategy.appendField(locator, this, "transactionType", buffer, theTransactionType);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theLocalObjectForeigId;
            theLocalObjectForeigId = this.getLocalObjectForeigId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localObjectForeigId", theLocalObjectForeigId), currentHashCode, theLocalObjectForeigId);
        }
        {
            String theTransactionStatus;
            theTransactionStatus = this.getTransactionStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transactionStatus", theTransactionStatus), currentHashCode, theTransactionStatus);
        }
        {
            String theWorkflowStatus;
            theWorkflowStatus = this.getWorkflowStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "workflowStatus", theWorkflowStatus), currentHashCode, theWorkflowStatus);
        }
        {
            long theWorkflowLevel;
            theWorkflowLevel = (true?this.getWorkflowLevel(): 0L);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "workflowLevel", theWorkflowLevel), currentHashCode, theWorkflowLevel);
        }
        {
            XMLGregorianCalendar theModifDate;
            theModifDate = this.getModifDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "modifDate", theModifDate), currentHashCode, theModifDate);
        }
        {
            TransactionSubtype theTransactionType;
            theTransactionType = this.getTransactionType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transactionType", theTransactionType), currentHashCode, theTransactionType);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
