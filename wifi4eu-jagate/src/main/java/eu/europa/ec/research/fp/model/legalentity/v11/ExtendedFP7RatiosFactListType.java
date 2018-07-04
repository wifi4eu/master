
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
 * <p>Java class for ExtendedFP7RatiosFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedFP7RatiosFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FP7RatiosFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedRatiosFactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedFP7RatiosFactListType", propOrder = {
    "fp7RatiosFact"
})
public class ExtendedFP7RatiosFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "FP7RatiosFact", required = true)
    protected List<ExtendedRatiosFactType> fp7RatiosFact;

    /**
     * Gets the value of the fp7RatiosFact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fp7RatiosFact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFP7RatiosFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedRatiosFactType }
     * 
     * 
     */
    public List<ExtendedRatiosFactType> getFP7RatiosFact() {
        if (fp7RatiosFact == null) {
            fp7RatiosFact = new ArrayList<ExtendedRatiosFactType>();
        }
        return this.fp7RatiosFact;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedFP7RatiosFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedFP7RatiosFactListType that = ((ExtendedFP7RatiosFactListType) object);
        {
            List<ExtendedRatiosFactType> lhsFP7RatiosFact;
            lhsFP7RatiosFact = (((this.fp7RatiosFact!= null)&&(!this.fp7RatiosFact.isEmpty()))?this.getFP7RatiosFact():null);
            List<ExtendedRatiosFactType> rhsFP7RatiosFact;
            rhsFP7RatiosFact = (((that.fp7RatiosFact!= null)&&(!that.fp7RatiosFact.isEmpty()))?that.getFP7RatiosFact():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fp7RatiosFact", lhsFP7RatiosFact), LocatorUtils.property(thatLocator, "fp7RatiosFact", rhsFP7RatiosFact), lhsFP7RatiosFact, rhsFP7RatiosFact)) {
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
            List<ExtendedRatiosFactType> theFP7RatiosFact;
            theFP7RatiosFact = (((this.fp7RatiosFact!= null)&&(!this.fp7RatiosFact.isEmpty()))?this.getFP7RatiosFact():null);
            strategy.appendField(locator, this, "fp7RatiosFact", buffer, theFP7RatiosFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExtendedRatiosFactType> theFP7RatiosFact;
            theFP7RatiosFact = (((this.fp7RatiosFact!= null)&&(!this.fp7RatiosFact.isEmpty()))?this.getFP7RatiosFact():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fp7RatiosFact", theFP7RatiosFact), currentHashCode, theFP7RatiosFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
