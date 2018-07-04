
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
 * <p>Java class for ExtendedSMESelfAssessmentFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedSMESelfAssessmentFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SMESelfAssessmentFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedSMESelfAssessmentFactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedSMESelfAssessmentFactListType", propOrder = {
    "smeSelfAssessmentFact"
})
public class ExtendedSMESelfAssessmentFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "SMESelfAssessmentFact", required = true)
    protected List<ExtendedSMESelfAssessmentFactType> smeSelfAssessmentFact;

    /**
     * Gets the value of the smeSelfAssessmentFact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smeSelfAssessmentFact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSMESelfAssessmentFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedSMESelfAssessmentFactType }
     * 
     * 
     */
    public List<ExtendedSMESelfAssessmentFactType> getSMESelfAssessmentFact() {
        if (smeSelfAssessmentFact == null) {
            smeSelfAssessmentFact = new ArrayList<ExtendedSMESelfAssessmentFactType>();
        }
        return this.smeSelfAssessmentFact;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedSMESelfAssessmentFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedSMESelfAssessmentFactListType that = ((ExtendedSMESelfAssessmentFactListType) object);
        {
            List<ExtendedSMESelfAssessmentFactType> lhsSMESelfAssessmentFact;
            lhsSMESelfAssessmentFact = (((this.smeSelfAssessmentFact!= null)&&(!this.smeSelfAssessmentFact.isEmpty()))?this.getSMESelfAssessmentFact():null);
            List<ExtendedSMESelfAssessmentFactType> rhsSMESelfAssessmentFact;
            rhsSMESelfAssessmentFact = (((that.smeSelfAssessmentFact!= null)&&(!that.smeSelfAssessmentFact.isEmpty()))?that.getSMESelfAssessmentFact():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "smeSelfAssessmentFact", lhsSMESelfAssessmentFact), LocatorUtils.property(thatLocator, "smeSelfAssessmentFact", rhsSMESelfAssessmentFact), lhsSMESelfAssessmentFact, rhsSMESelfAssessmentFact)) {
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
            List<ExtendedSMESelfAssessmentFactType> theSMESelfAssessmentFact;
            theSMESelfAssessmentFact = (((this.smeSelfAssessmentFact!= null)&&(!this.smeSelfAssessmentFact.isEmpty()))?this.getSMESelfAssessmentFact():null);
            strategy.appendField(locator, this, "smeSelfAssessmentFact", buffer, theSMESelfAssessmentFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExtendedSMESelfAssessmentFactType> theSMESelfAssessmentFact;
            theSMESelfAssessmentFact = (((this.smeSelfAssessmentFact!= null)&&(!this.smeSelfAssessmentFact.isEmpty()))?this.getSMESelfAssessmentFact():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "smeSelfAssessmentFact", theSMESelfAssessmentFact), currentHashCode, theSMESelfAssessmentFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
