
package eu.europa.ec.rdg.jagate.ws.domain.transaction.v1;

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
 * <p>Java class for CheckROByPicResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckROByPicResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecoveryOrders" type="{http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1}CheckROByPicResponseType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckROByPicResponse", propOrder = {
    "recoveryOrders"
})
public class CheckROByPicResponse
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "RecoveryOrders", required = true)
    protected List<CheckROByPicResponseType> recoveryOrders;

    /**
     * Gets the value of the recoveryOrders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recoveryOrders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecoveryOrders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckROByPicResponseType }
     * 
     * 
     */
    public List<CheckROByPicResponseType> getRecoveryOrders() {
        if (recoveryOrders == null) {
            recoveryOrders = new ArrayList<CheckROByPicResponseType>();
        }
        return this.recoveryOrders;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CheckROByPicResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CheckROByPicResponse that = ((CheckROByPicResponse) object);
        {
            List<CheckROByPicResponseType> lhsRecoveryOrders;
            lhsRecoveryOrders = (((this.recoveryOrders!= null)&&(!this.recoveryOrders.isEmpty()))?this.getRecoveryOrders():null);
            List<CheckROByPicResponseType> rhsRecoveryOrders;
            rhsRecoveryOrders = (((that.recoveryOrders!= null)&&(!that.recoveryOrders.isEmpty()))?that.getRecoveryOrders():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recoveryOrders", lhsRecoveryOrders), LocatorUtils.property(thatLocator, "recoveryOrders", rhsRecoveryOrders), lhsRecoveryOrders, rhsRecoveryOrders)) {
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
            List<CheckROByPicResponseType> theRecoveryOrders;
            theRecoveryOrders = (((this.recoveryOrders!= null)&&(!this.recoveryOrders.isEmpty()))?this.getRecoveryOrders():null);
            strategy.appendField(locator, this, "recoveryOrders", buffer, theRecoveryOrders);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<CheckROByPicResponseType> theRecoveryOrders;
            theRecoveryOrders = (((this.recoveryOrders!= null)&&(!this.recoveryOrders.isEmpty()))?this.getRecoveryOrders():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recoveryOrders", theRecoveryOrders), currentHashCode, theRecoveryOrders);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
