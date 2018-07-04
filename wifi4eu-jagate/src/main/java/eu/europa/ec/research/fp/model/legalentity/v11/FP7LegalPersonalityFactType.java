
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
 * <p>Java class for FP7LegalPersonalityFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FP7LegalPersonalityFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LegalPersonality" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FP7LegalPersonalityFactType", propOrder = {
    "legalPersonality"
})
public class FP7LegalPersonalityFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LegalPersonality")
    protected boolean legalPersonality;

    /**
     * Gets the value of the legalPersonality property.
     * 
     */
    public boolean isLegalPersonality() {
        return legalPersonality;
    }

    /**
     * Sets the value of the legalPersonality property.
     * 
     */
    public void setLegalPersonality(boolean value) {
        this.legalPersonality = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FP7LegalPersonalityFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FP7LegalPersonalityFactType that = ((FP7LegalPersonalityFactType) object);
        {
            boolean lhsLegalPersonality;
            lhsLegalPersonality = (true?this.isLegalPersonality():false);
            boolean rhsLegalPersonality;
            rhsLegalPersonality = (true?that.isLegalPersonality():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalPersonality", lhsLegalPersonality), LocatorUtils.property(thatLocator, "legalPersonality", rhsLegalPersonality), lhsLegalPersonality, rhsLegalPersonality)) {
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
            boolean theLegalPersonality;
            theLegalPersonality = (true?this.isLegalPersonality():false);
            strategy.appendField(locator, this, "legalPersonality", buffer, theLegalPersonality);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theLegalPersonality;
            theLegalPersonality = (true?this.isLegalPersonality():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalPersonality", theLegalPersonality), currentHashCode, theLegalPersonality);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
