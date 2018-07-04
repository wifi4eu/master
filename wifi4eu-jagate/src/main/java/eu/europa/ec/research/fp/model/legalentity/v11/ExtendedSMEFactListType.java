
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
 * <p>Java class for ExtendedSMEFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedSMEFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SMEFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedSMEFactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedSMEFactListType", propOrder = {
    "smeFact"
})
public class ExtendedSMEFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "SMEFact", required = true)
    protected List<ExtendedSMEFactType> smeFact;

    /**
     * Gets the value of the smeFact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smeFact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSMEFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedSMEFactType }
     * 
     * 
     */
    public List<ExtendedSMEFactType> getSMEFact() {
        if (smeFact == null) {
            smeFact = new ArrayList<ExtendedSMEFactType>();
        }
        return this.smeFact;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedSMEFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedSMEFactListType that = ((ExtendedSMEFactListType) object);
        {
            List<ExtendedSMEFactType> lhsSMEFact;
            lhsSMEFact = (((this.smeFact!= null)&&(!this.smeFact.isEmpty()))?this.getSMEFact():null);
            List<ExtendedSMEFactType> rhsSMEFact;
            rhsSMEFact = (((that.smeFact!= null)&&(!that.smeFact.isEmpty()))?that.getSMEFact():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "smeFact", lhsSMEFact), LocatorUtils.property(thatLocator, "smeFact", rhsSMEFact), lhsSMEFact, rhsSMEFact)) {
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
            List<ExtendedSMEFactType> theSMEFact;
            theSMEFact = (((this.smeFact!= null)&&(!this.smeFact.isEmpty()))?this.getSMEFact():null);
            strategy.appendField(locator, this, "smeFact", buffer, theSMEFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExtendedSMEFactType> theSMEFact;
            theSMEFact = (((this.smeFact!= null)&&(!this.smeFact.isEmpty()))?this.getSMEFact():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "smeFact", theSMEFact), currentHashCode, theSMEFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
