
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
 * <p>Java class for ExtendedNonBankruptcyDeclarationFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedNonBankruptcyDeclarationFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NonBankruptcyDeclarationFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedNonBankruptcyDeclarationFactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedNonBankruptcyDeclarationFactListType", propOrder = {
    "nonBankruptcyDeclarationFact"
})
public class ExtendedNonBankruptcyDeclarationFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "NonBankruptcyDeclarationFact", required = true)
    protected List<ExtendedNonBankruptcyDeclarationFactType> nonBankruptcyDeclarationFact;

    /**
     * Gets the value of the nonBankruptcyDeclarationFact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonBankruptcyDeclarationFact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNonBankruptcyDeclarationFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedNonBankruptcyDeclarationFactType }
     * 
     * 
     */
    public List<ExtendedNonBankruptcyDeclarationFactType> getNonBankruptcyDeclarationFact() {
        if (nonBankruptcyDeclarationFact == null) {
            nonBankruptcyDeclarationFact = new ArrayList<ExtendedNonBankruptcyDeclarationFactType>();
        }
        return this.nonBankruptcyDeclarationFact;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedNonBankruptcyDeclarationFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedNonBankruptcyDeclarationFactListType that = ((ExtendedNonBankruptcyDeclarationFactListType) object);
        {
            List<ExtendedNonBankruptcyDeclarationFactType> lhsNonBankruptcyDeclarationFact;
            lhsNonBankruptcyDeclarationFact = (((this.nonBankruptcyDeclarationFact!= null)&&(!this.nonBankruptcyDeclarationFact.isEmpty()))?this.getNonBankruptcyDeclarationFact():null);
            List<ExtendedNonBankruptcyDeclarationFactType> rhsNonBankruptcyDeclarationFact;
            rhsNonBankruptcyDeclarationFact = (((that.nonBankruptcyDeclarationFact!= null)&&(!that.nonBankruptcyDeclarationFact.isEmpty()))?that.getNonBankruptcyDeclarationFact():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nonBankruptcyDeclarationFact", lhsNonBankruptcyDeclarationFact), LocatorUtils.property(thatLocator, "nonBankruptcyDeclarationFact", rhsNonBankruptcyDeclarationFact), lhsNonBankruptcyDeclarationFact, rhsNonBankruptcyDeclarationFact)) {
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
            List<ExtendedNonBankruptcyDeclarationFactType> theNonBankruptcyDeclarationFact;
            theNonBankruptcyDeclarationFact = (((this.nonBankruptcyDeclarationFact!= null)&&(!this.nonBankruptcyDeclarationFact.isEmpty()))?this.getNonBankruptcyDeclarationFact():null);
            strategy.appendField(locator, this, "nonBankruptcyDeclarationFact", buffer, theNonBankruptcyDeclarationFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExtendedNonBankruptcyDeclarationFactType> theNonBankruptcyDeclarationFact;
            theNonBankruptcyDeclarationFact = (((this.nonBankruptcyDeclarationFact!= null)&&(!this.nonBankruptcyDeclarationFact.isEmpty()))?this.getNonBankruptcyDeclarationFact():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nonBankruptcyDeclarationFact", theNonBankruptcyDeclarationFact), currentHashCode, theNonBankruptcyDeclarationFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
