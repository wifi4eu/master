
package generated.jagate.model.legalentityref.v3;

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
 * <p>Java class for SuspendedPICType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SuspendedPICType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SuspendedPIC" type="{http://ec.europa.eu/research/fp/model/legalentity-ref/V3}LegalEntityIdType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuspendedPICType", propOrder = {
    "suspendedPIC"
})
public class SuspendedPICType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "SuspendedPIC", required = true)
    protected List<String> suspendedPIC;

    /**
     * Gets the value of the suspendedPIC property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the suspendedPIC property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuspendedPIC().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSuspendedPIC() {
        if (suspendedPIC == null) {
            suspendedPIC = new ArrayList<String>();
        }
        return this.suspendedPIC;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SuspendedPICType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SuspendedPICType that = ((SuspendedPICType) object);
        {
            List<String> lhsSuspendedPIC;
            lhsSuspendedPIC = (((this.suspendedPIC!= null)&&(!this.suspendedPIC.isEmpty()))?this.getSuspendedPIC():null);
            List<String> rhsSuspendedPIC;
            rhsSuspendedPIC = (((that.suspendedPIC!= null)&&(!that.suspendedPIC.isEmpty()))?that.getSuspendedPIC():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "suspendedPIC", lhsSuspendedPIC), LocatorUtils.property(thatLocator, "suspendedPIC", rhsSuspendedPIC), lhsSuspendedPIC, rhsSuspendedPIC)) {
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
            List<String> theSuspendedPIC;
            theSuspendedPIC = (((this.suspendedPIC!= null)&&(!this.suspendedPIC.isEmpty()))?this.getSuspendedPIC():null);
            strategy.appendField(locator, this, "suspendedPIC", buffer, theSuspendedPIC);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<String> theSuspendedPIC;
            theSuspendedPIC = (((this.suspendedPIC!= null)&&(!this.suspendedPIC.isEmpty()))?this.getSuspendedPIC():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "suspendedPIC", theSuspendedPIC), currentHashCode, theSuspendedPIC);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
