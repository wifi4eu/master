
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
 * <p>Java class for ExtendedErasmusECHEAccreditationFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedErasmusECHEAccreditationFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErasmusECHEAccreditationFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedErasmusECHEAccreditationFactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedErasmusECHEAccreditationFactListType", propOrder = {
    "erasmusECHEAccreditationFact"
})
public class ExtendedErasmusECHEAccreditationFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ErasmusECHEAccreditationFact", required = true)
    protected List<ExtendedErasmusECHEAccreditationFactType> erasmusECHEAccreditationFact;

    /**
     * Gets the value of the erasmusECHEAccreditationFact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the erasmusECHEAccreditationFact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErasmusECHEAccreditationFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedErasmusECHEAccreditationFactType }
     * 
     * 
     */
    public List<ExtendedErasmusECHEAccreditationFactType> getErasmusECHEAccreditationFact() {
        if (erasmusECHEAccreditationFact == null) {
            erasmusECHEAccreditationFact = new ArrayList<ExtendedErasmusECHEAccreditationFactType>();
        }
        return this.erasmusECHEAccreditationFact;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedErasmusECHEAccreditationFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedErasmusECHEAccreditationFactListType that = ((ExtendedErasmusECHEAccreditationFactListType) object);
        {
            List<ExtendedErasmusECHEAccreditationFactType> lhsErasmusECHEAccreditationFact;
            lhsErasmusECHEAccreditationFact = (((this.erasmusECHEAccreditationFact!= null)&&(!this.erasmusECHEAccreditationFact.isEmpty()))?this.getErasmusECHEAccreditationFact():null);
            List<ExtendedErasmusECHEAccreditationFactType> rhsErasmusECHEAccreditationFact;
            rhsErasmusECHEAccreditationFact = (((that.erasmusECHEAccreditationFact!= null)&&(!that.erasmusECHEAccreditationFact.isEmpty()))?that.getErasmusECHEAccreditationFact():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "erasmusECHEAccreditationFact", lhsErasmusECHEAccreditationFact), LocatorUtils.property(thatLocator, "erasmusECHEAccreditationFact", rhsErasmusECHEAccreditationFact), lhsErasmusECHEAccreditationFact, rhsErasmusECHEAccreditationFact)) {
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
            List<ExtendedErasmusECHEAccreditationFactType> theErasmusECHEAccreditationFact;
            theErasmusECHEAccreditationFact = (((this.erasmusECHEAccreditationFact!= null)&&(!this.erasmusECHEAccreditationFact.isEmpty()))?this.getErasmusECHEAccreditationFact():null);
            strategy.appendField(locator, this, "erasmusECHEAccreditationFact", buffer, theErasmusECHEAccreditationFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExtendedErasmusECHEAccreditationFactType> theErasmusECHEAccreditationFact;
            theErasmusECHEAccreditationFact = (((this.erasmusECHEAccreditationFact!= null)&&(!this.erasmusECHEAccreditationFact.isEmpty()))?this.getErasmusECHEAccreditationFact():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "erasmusECHEAccreditationFact", theErasmusECHEAccreditationFact), currentHashCode, theErasmusECHEAccreditationFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
