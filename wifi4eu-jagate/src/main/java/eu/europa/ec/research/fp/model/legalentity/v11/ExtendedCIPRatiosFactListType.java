
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
 * <p>Java class for ExtendedCIPRatiosFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedCIPRatiosFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CIPRatiosFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedRatiosFactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedCIPRatiosFactListType", propOrder = {
    "cipRatiosFact"
})
public class ExtendedCIPRatiosFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CIPRatiosFact", required = true)
    protected List<ExtendedRatiosFactType> cipRatiosFact;

    /**
     * Gets the value of the cipRatiosFact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cipRatiosFact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCIPRatiosFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedRatiosFactType }
     * 
     * 
     */
    public List<ExtendedRatiosFactType> getCIPRatiosFact() {
        if (cipRatiosFact == null) {
            cipRatiosFact = new ArrayList<ExtendedRatiosFactType>();
        }
        return this.cipRatiosFact;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedCIPRatiosFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedCIPRatiosFactListType that = ((ExtendedCIPRatiosFactListType) object);
        {
            List<ExtendedRatiosFactType> lhsCIPRatiosFact;
            lhsCIPRatiosFact = (((this.cipRatiosFact!= null)&&(!this.cipRatiosFact.isEmpty()))?this.getCIPRatiosFact():null);
            List<ExtendedRatiosFactType> rhsCIPRatiosFact;
            rhsCIPRatiosFact = (((that.cipRatiosFact!= null)&&(!that.cipRatiosFact.isEmpty()))?that.getCIPRatiosFact():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cipRatiosFact", lhsCIPRatiosFact), LocatorUtils.property(thatLocator, "cipRatiosFact", rhsCIPRatiosFact), lhsCIPRatiosFact, rhsCIPRatiosFact)) {
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
            List<ExtendedRatiosFactType> theCIPRatiosFact;
            theCIPRatiosFact = (((this.cipRatiosFact!= null)&&(!this.cipRatiosFact.isEmpty()))?this.getCIPRatiosFact():null);
            strategy.appendField(locator, this, "cipRatiosFact", buffer, theCIPRatiosFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExtendedRatiosFactType> theCIPRatiosFact;
            theCIPRatiosFact = (((this.cipRatiosFact!= null)&&(!this.cipRatiosFact.isEmpty()))?this.getCIPRatiosFact():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cipRatiosFact", theCIPRatiosFact), currentHashCode, theCIPRatiosFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
