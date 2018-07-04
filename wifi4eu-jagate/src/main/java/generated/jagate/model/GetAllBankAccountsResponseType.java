
package generated.jagate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.LegalEntityBankAccountType;
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
 * <p>Java class for GetAllBankAccountsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAllBankAccountsResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankAccounts" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}LegalEntityBankAccountType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllBankAccountsResponseType", propOrder = {
    "bankAccounts"
})
public class GetAllBankAccountsResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected LegalEntityBankAccountType bankAccounts;

    /**
     * Gets the value of the bankAccounts property.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityBankAccountType }
     *     
     */
    public LegalEntityBankAccountType getBankAccounts() {
        return bankAccounts;
    }

    /**
     * Sets the value of the bankAccounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityBankAccountType }
     *     
     */
    public void setBankAccounts(LegalEntityBankAccountType value) {
        this.bankAccounts = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetAllBankAccountsResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetAllBankAccountsResponseType that = ((GetAllBankAccountsResponseType) object);
        {
            LegalEntityBankAccountType lhsBankAccounts;
            lhsBankAccounts = this.getBankAccounts();
            LegalEntityBankAccountType rhsBankAccounts;
            rhsBankAccounts = that.getBankAccounts();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccounts", lhsBankAccounts), LocatorUtils.property(thatLocator, "bankAccounts", rhsBankAccounts), lhsBankAccounts, rhsBankAccounts)) {
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
            LegalEntityBankAccountType theBankAccounts;
            theBankAccounts = this.getBankAccounts();
            strategy.appendField(locator, this, "bankAccounts", buffer, theBankAccounts);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            LegalEntityBankAccountType theBankAccounts;
            theBankAccounts = this.getBankAccounts();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccounts", theBankAccounts), currentHashCode, theBankAccounts);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
