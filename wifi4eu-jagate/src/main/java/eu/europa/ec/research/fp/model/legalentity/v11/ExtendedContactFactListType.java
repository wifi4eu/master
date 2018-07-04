
package eu.europa.ec.research.fp.model.legalentity.v11;

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
 * <p>Java class for ExtendedContactFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedContactFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContactFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedContactFactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedContactFactListType", propOrder = {
    "contactFact"
})
public class ExtendedContactFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ContactFact", required = true)
    protected List<ExtendedContactFactType> contactFact;

    /**
     * Gets the value of the contactFact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactFact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedContactFactType }
     * 
     * 
     */
    public List<ExtendedContactFactType> getContactFact() {
        if (contactFact == null) {
            contactFact = new ArrayList<ExtendedContactFactType>();
        }
        return this.contactFact;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedContactFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedContactFactListType that = ((ExtendedContactFactListType) object);
        {
            List<ExtendedContactFactType> lhsContactFact;
            lhsContactFact = (((this.contactFact!= null)&&(!this.contactFact.isEmpty()))?this.getContactFact():null);
            List<ExtendedContactFactType> rhsContactFact;
            rhsContactFact = (((that.contactFact!= null)&&(!that.contactFact.isEmpty()))?that.getContactFact():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contactFact", lhsContactFact), LocatorUtils.property(thatLocator, "contactFact", rhsContactFact), lhsContactFact, rhsContactFact)) {
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
            List<ExtendedContactFactType> theContactFact;
            theContactFact = (((this.contactFact!= null)&&(!this.contactFact.isEmpty()))?this.getContactFact():null);
            strategy.appendField(locator, this, "contactFact", buffer, theContactFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExtendedContactFactType> theContactFact;
            theContactFact = (((this.contactFact!= null)&&(!this.contactFact.isEmpty()))?this.getContactFact():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contactFact", theContactFact), currentHashCode, theContactFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
