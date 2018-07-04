
package generated.jagate.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.ws.domain.bankaccount.v5.BankAccountHolderType;
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
 * <p>Java class for GetBankAccountResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBankAccountResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankAccountHolder" type="{http://ec.europa.eu/rdg/jagate/ws/domain/bankaccount/v5}BankAccountHolderType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBankAccountResponseType", propOrder = {
    "bankAccountHolder"
})
public class GetBankAccountResponseType
    implements Equals, HashCode, ToString
{

    protected List<BankAccountHolderType> bankAccountHolder;

    /**
     * Gets the value of the bankAccountHolder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bankAccountHolder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBankAccountHolder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BankAccountHolderType }
     * 
     * 
     */
    public List<BankAccountHolderType> getBankAccountHolder() {
        if (bankAccountHolder == null) {
            bankAccountHolder = new ArrayList<BankAccountHolderType>();
        }
        return this.bankAccountHolder;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetBankAccountResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetBankAccountResponseType that = ((GetBankAccountResponseType) object);
        {
            List<BankAccountHolderType> lhsBankAccountHolder;
            lhsBankAccountHolder = (((this.bankAccountHolder!= null)&&(!this.bankAccountHolder.isEmpty()))?this.getBankAccountHolder():null);
            List<BankAccountHolderType> rhsBankAccountHolder;
            rhsBankAccountHolder = (((that.bankAccountHolder!= null)&&(!that.bankAccountHolder.isEmpty()))?that.getBankAccountHolder():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountHolder", lhsBankAccountHolder), LocatorUtils.property(thatLocator, "bankAccountHolder", rhsBankAccountHolder), lhsBankAccountHolder, rhsBankAccountHolder)) {
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
            List<BankAccountHolderType> theBankAccountHolder;
            theBankAccountHolder = (((this.bankAccountHolder!= null)&&(!this.bankAccountHolder.isEmpty()))?this.getBankAccountHolder():null);
            strategy.appendField(locator, this, "bankAccountHolder", buffer, theBankAccountHolder);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<BankAccountHolderType> theBankAccountHolder;
            theBankAccountHolder = (((this.bankAccountHolder!= null)&&(!this.bankAccountHolder.isEmpty()))?this.getBankAccountHolder():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountHolder", theBankAccountHolder), currentHashCode, theBankAccountHolder);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
