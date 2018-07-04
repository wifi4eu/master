
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
 * <p>Java class for ExtendedFinancialDataFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedFinancialDataFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FinancialDataFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedFinancialDataFactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedFinancialDataFactListType", propOrder = {
    "financialDataFact"
})
public class ExtendedFinancialDataFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "FinancialDataFact", required = true)
    protected List<ExtendedFinancialDataFactType> financialDataFact;

    /**
     * Gets the value of the financialDataFact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the financialDataFact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinancialDataFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedFinancialDataFactType }
     * 
     * 
     */
    public List<ExtendedFinancialDataFactType> getFinancialDataFact() {
        if (financialDataFact == null) {
            financialDataFact = new ArrayList<ExtendedFinancialDataFactType>();
        }
        return this.financialDataFact;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedFinancialDataFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedFinancialDataFactListType that = ((ExtendedFinancialDataFactListType) object);
        {
            List<ExtendedFinancialDataFactType> lhsFinancialDataFact;
            lhsFinancialDataFact = (((this.financialDataFact!= null)&&(!this.financialDataFact.isEmpty()))?this.getFinancialDataFact():null);
            List<ExtendedFinancialDataFactType> rhsFinancialDataFact;
            rhsFinancialDataFact = (((that.financialDataFact!= null)&&(!that.financialDataFact.isEmpty()))?that.getFinancialDataFact():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "financialDataFact", lhsFinancialDataFact), LocatorUtils.property(thatLocator, "financialDataFact", rhsFinancialDataFact), lhsFinancialDataFact, rhsFinancialDataFact)) {
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
            List<ExtendedFinancialDataFactType> theFinancialDataFact;
            theFinancialDataFact = (((this.financialDataFact!= null)&&(!this.financialDataFact.isEmpty()))?this.getFinancialDataFact():null);
            strategy.appendField(locator, this, "financialDataFact", buffer, theFinancialDataFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExtendedFinancialDataFactType> theFinancialDataFact;
            theFinancialDataFact = (((this.financialDataFact!= null)&&(!this.financialDataFact.isEmpty()))?this.getFinancialDataFact():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "financialDataFact", theFinancialDataFact), currentHashCode, theFinancialDataFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
