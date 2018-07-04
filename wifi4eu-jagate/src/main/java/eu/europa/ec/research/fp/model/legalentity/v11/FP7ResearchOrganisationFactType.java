
package eu.europa.ec.research.fp.model.legalentity.v11;

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
 * <p>Java class for FP7ResearchOrganisationFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FP7ResearchOrganisationFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResearchOrganisation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FP7ResearchOrganisationFactType", propOrder = {
    "researchOrganisation"
})
public class FP7ResearchOrganisationFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ResearchOrganisation")
    protected boolean researchOrganisation;

    /**
     * Gets the value of the researchOrganisation property.
     * 
     */
    public boolean isResearchOrganisation() {
        return researchOrganisation;
    }

    /**
     * Sets the value of the researchOrganisation property.
     * 
     */
    public void setResearchOrganisation(boolean value) {
        this.researchOrganisation = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FP7ResearchOrganisationFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FP7ResearchOrganisationFactType that = ((FP7ResearchOrganisationFactType) object);
        {
            boolean lhsResearchOrganisation;
            lhsResearchOrganisation = (true?this.isResearchOrganisation():false);
            boolean rhsResearchOrganisation;
            rhsResearchOrganisation = (true?that.isResearchOrganisation():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "researchOrganisation", lhsResearchOrganisation), LocatorUtils.property(thatLocator, "researchOrganisation", rhsResearchOrganisation), lhsResearchOrganisation, rhsResearchOrganisation)) {
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
            boolean theResearchOrganisation;
            theResearchOrganisation = (true?this.isResearchOrganisation():false);
            strategy.appendField(locator, this, "researchOrganisation", buffer, theResearchOrganisation);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theResearchOrganisation;
            theResearchOrganisation = (true?this.isResearchOrganisation():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "researchOrganisation", theResearchOrganisation), currentHashCode, theResearchOrganisation);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
