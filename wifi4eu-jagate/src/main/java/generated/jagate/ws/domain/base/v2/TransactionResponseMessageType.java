
package generated.jagate.ws.domain.base.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.ws.domain.reference.v1.EClientTransactionType;
import generated.jagate.ws.domain.reference.v1.EObjectStatusType;
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
 * <p>Java class for TransactionResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionResponseMessageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}IdentifiedResponseMessageType">
 *       &lt;sequence>
 *         &lt;element name="Transaction" type="{http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1}EClientTransactionType"/>
 *         &lt;element name="WorkflowStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ObjectStatus" type="{http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1}EObjectStatusType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionResponseMessageType", propOrder = {
    "transaction",
    "workflowStatus",
    "objectStatus"
})
public class TransactionResponseMessageType
    extends IdentifiedResponseMessageType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Transaction", required = true)
    protected EClientTransactionType transaction;
    @XmlElement(name = "WorkflowStatus", required = true)
    protected String workflowStatus;
    @XmlElement(name = "ObjectStatus", required = true)
    protected EObjectStatusType objectStatus;

    /**
     * Gets the value of the transaction property.
     * 
     * @return
     *     possible object is
     *     {@link EClientTransactionType }
     *     
     */
    public EClientTransactionType getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link EClientTransactionType }
     *     
     */
    public void setTransaction(EClientTransactionType value) {
        this.transaction = value;
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
     * Gets the value of the objectStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EObjectStatusType }
     *     
     */
    public EObjectStatusType getObjectStatus() {
        return objectStatus;
    }

    /**
     * Sets the value of the objectStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EObjectStatusType }
     *     
     */
    public void setObjectStatus(EObjectStatusType value) {
        this.objectStatus = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TransactionResponseMessageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final TransactionResponseMessageType that = ((TransactionResponseMessageType) object);
        {
            EClientTransactionType lhsTransaction;
            lhsTransaction = this.getTransaction();
            EClientTransactionType rhsTransaction;
            rhsTransaction = that.getTransaction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transaction", lhsTransaction), LocatorUtils.property(thatLocator, "transaction", rhsTransaction), lhsTransaction, rhsTransaction)) {
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
            EObjectStatusType lhsObjectStatus;
            lhsObjectStatus = this.getObjectStatus();
            EObjectStatusType rhsObjectStatus;
            rhsObjectStatus = that.getObjectStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "objectStatus", lhsObjectStatus), LocatorUtils.property(thatLocator, "objectStatus", rhsObjectStatus), lhsObjectStatus, rhsObjectStatus)) {
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
        super.appendFields(locator, buffer, strategy);
        {
            EClientTransactionType theTransaction;
            theTransaction = this.getTransaction();
            strategy.appendField(locator, this, "transaction", buffer, theTransaction);
        }
        {
            String theWorkflowStatus;
            theWorkflowStatus = this.getWorkflowStatus();
            strategy.appendField(locator, this, "workflowStatus", buffer, theWorkflowStatus);
        }
        {
            EObjectStatusType theObjectStatus;
            theObjectStatus = this.getObjectStatus();
            strategy.appendField(locator, this, "objectStatus", buffer, theObjectStatus);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            EClientTransactionType theTransaction;
            theTransaction = this.getTransaction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transaction", theTransaction), currentHashCode, theTransaction);
        }
        {
            String theWorkflowStatus;
            theWorkflowStatus = this.getWorkflowStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "workflowStatus", theWorkflowStatus), currentHashCode, theWorkflowStatus);
        }
        {
            EObjectStatusType theObjectStatus;
            theObjectStatus = this.getObjectStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectStatus", theObjectStatus), currentHashCode, theObjectStatus);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
