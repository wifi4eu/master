
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
 * <p>Java class for CheckROByPicResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckROByPicResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recoveryOrder" type="{http://ec.europa.eu/rdg/jagate/ws/domain/transaction/v1}RecoveriesByPartnerType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckROByPicResponseType", propOrder = {
    "pic",
    "recoveryOrder"
})
public class CheckROByPicResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String pic;
    @XmlElement(nillable = true)
    protected List<RecoveriesByPartnerType> recoveryOrder;

    /**
     * Gets the value of the pic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPic() {
        return pic;
    }

    /**
     * Sets the value of the pic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPic(String value) {
        this.pic = value;
    }

    /**
     * Gets the value of the recoveryOrder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recoveryOrder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecoveryOrder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecoveriesByPartnerType }
     * 
     * 
     */
    public List<RecoveriesByPartnerType> getRecoveryOrder() {
        if (recoveryOrder == null) {
            recoveryOrder = new ArrayList<RecoveriesByPartnerType>();
        }
        return this.recoveryOrder;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CheckROByPicResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CheckROByPicResponseType that = ((CheckROByPicResponseType) object);
        {
            String lhsPic;
            lhsPic = this.getPic();
            String rhsPic;
            rhsPic = that.getPic();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pic", lhsPic), LocatorUtils.property(thatLocator, "pic", rhsPic), lhsPic, rhsPic)) {
                return false;
            }
        }
        {
            List<RecoveriesByPartnerType> lhsRecoveryOrder;
            lhsRecoveryOrder = (((this.recoveryOrder!= null)&&(!this.recoveryOrder.isEmpty()))?this.getRecoveryOrder():null);
            List<RecoveriesByPartnerType> rhsRecoveryOrder;
            rhsRecoveryOrder = (((that.recoveryOrder!= null)&&(!that.recoveryOrder.isEmpty()))?that.getRecoveryOrder():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recoveryOrder", lhsRecoveryOrder), LocatorUtils.property(thatLocator, "recoveryOrder", rhsRecoveryOrder), lhsRecoveryOrder, rhsRecoveryOrder)) {
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
            String thePic;
            thePic = this.getPic();
            strategy.appendField(locator, this, "pic", buffer, thePic);
        }
        {
            List<RecoveriesByPartnerType> theRecoveryOrder;
            theRecoveryOrder = (((this.recoveryOrder!= null)&&(!this.recoveryOrder.isEmpty()))?this.getRecoveryOrder():null);
            strategy.appendField(locator, this, "recoveryOrder", buffer, theRecoveryOrder);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String thePic;
            thePic = this.getPic();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pic", thePic), currentHashCode, thePic);
        }
        {
            List<RecoveriesByPartnerType> theRecoveryOrder;
            theRecoveryOrder = (((this.recoveryOrder!= null)&&(!this.recoveryOrder.isEmpty()))?this.getRecoveryOrder():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recoveryOrder", theRecoveryOrder), currentHashCode, theRecoveryOrder);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
