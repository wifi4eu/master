
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
 * <p>Java class for ExtendedBankAccountFactListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedBankAccountFactListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BankAccountFact" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ExtendedBankAccountFactType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedBankAccountFactListType", propOrder = {
    "bankAccountFact"
})
public class ExtendedBankAccountFactListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "BankAccountFact", required = true)
    protected List<ExtendedBankAccountFactType> bankAccountFact;

    /**
     * Gets the value of the bankAccountFact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bankAccountFact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBankAccountFact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedBankAccountFactType }
     * 
     * 
     */
    public List<ExtendedBankAccountFactType> getBankAccountFact() {
        if (bankAccountFact == null) {
            bankAccountFact = new ArrayList<ExtendedBankAccountFactType>();
        }
        return this.bankAccountFact;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExtendedBankAccountFactListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExtendedBankAccountFactListType that = ((ExtendedBankAccountFactListType) object);
        {
            List<ExtendedBankAccountFactType> lhsBankAccountFact;
            lhsBankAccountFact = (((this.bankAccountFact!= null)&&(!this.bankAccountFact.isEmpty()))?this.getBankAccountFact():null);
            List<ExtendedBankAccountFactType> rhsBankAccountFact;
            rhsBankAccountFact = (((that.bankAccountFact!= null)&&(!that.bankAccountFact.isEmpty()))?that.getBankAccountFact():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountFact", lhsBankAccountFact), LocatorUtils.property(thatLocator, "bankAccountFact", rhsBankAccountFact), lhsBankAccountFact, rhsBankAccountFact)) {
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
            List<ExtendedBankAccountFactType> theBankAccountFact;
            theBankAccountFact = (((this.bankAccountFact!= null)&&(!this.bankAccountFact.isEmpty()))?this.getBankAccountFact():null);
            strategy.appendField(locator, this, "bankAccountFact", buffer, theBankAccountFact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ExtendedBankAccountFactType> theBankAccountFact;
            theBankAccountFact = (((this.bankAccountFact!= null)&&(!this.bankAccountFact.isEmpty()))?this.getBankAccountFact():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountFact", theBankAccountFact), currentHashCode, theBankAccountFact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
