
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
 * <p>Java class for GetLegalEntityBankAccountLinkResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetLegalEntityBankAccountLinkResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankAccount" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}LegalEntityBankAccountType" minOccurs="0"/>
 *         &lt;element name="bankAccountStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="legalentityStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountLegalEntityLinkStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="blockingReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetLegalEntityBankAccountLinkResponseType", propOrder = {
    "bankAccount",
    "bankAccountStatus",
    "legalentityStatus",
    "bankAccountLegalEntityLinkStatus",
    "blockingReason"
})
public class GetLegalEntityBankAccountLinkResponseType
    implements Equals, HashCode, ToString
{

    protected LegalEntityBankAccountType bankAccount;
    protected String bankAccountStatus;
    protected String legalentityStatus;
    @XmlElement(name = "BankAccountLegalEntityLinkStatus")
    protected String bankAccountLegalEntityLinkStatus;
    protected String blockingReason;

    /**
     * Gets the value of the bankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityBankAccountType }
     *     
     */
    public LegalEntityBankAccountType getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the value of the bankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityBankAccountType }
     *     
     */
    public void setBankAccount(LegalEntityBankAccountType value) {
        this.bankAccount = value;
    }

    /**
     * Gets the value of the bankAccountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountStatus() {
        return bankAccountStatus;
    }

    /**
     * Sets the value of the bankAccountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountStatus(String value) {
        this.bankAccountStatus = value;
    }

    /**
     * Gets the value of the legalentityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalentityStatus() {
        return legalentityStatus;
    }

    /**
     * Sets the value of the legalentityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalentityStatus(String value) {
        this.legalentityStatus = value;
    }

    /**
     * Gets the value of the bankAccountLegalEntityLinkStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountLegalEntityLinkStatus() {
        return bankAccountLegalEntityLinkStatus;
    }

    /**
     * Sets the value of the bankAccountLegalEntityLinkStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountLegalEntityLinkStatus(String value) {
        this.bankAccountLegalEntityLinkStatus = value;
    }

    /**
     * Gets the value of the blockingReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockingReason() {
        return blockingReason;
    }

    /**
     * Sets the value of the blockingReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockingReason(String value) {
        this.blockingReason = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetLegalEntityBankAccountLinkResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetLegalEntityBankAccountLinkResponseType that = ((GetLegalEntityBankAccountLinkResponseType) object);
        {
            LegalEntityBankAccountType lhsBankAccount;
            lhsBankAccount = this.getBankAccount();
            LegalEntityBankAccountType rhsBankAccount;
            rhsBankAccount = that.getBankAccount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccount", lhsBankAccount), LocatorUtils.property(thatLocator, "bankAccount", rhsBankAccount), lhsBankAccount, rhsBankAccount)) {
                return false;
            }
        }
        {
            String lhsBankAccountStatus;
            lhsBankAccountStatus = this.getBankAccountStatus();
            String rhsBankAccountStatus;
            rhsBankAccountStatus = that.getBankAccountStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountStatus", lhsBankAccountStatus), LocatorUtils.property(thatLocator, "bankAccountStatus", rhsBankAccountStatus), lhsBankAccountStatus, rhsBankAccountStatus)) {
                return false;
            }
        }
        {
            String lhsLegalentityStatus;
            lhsLegalentityStatus = this.getLegalentityStatus();
            String rhsLegalentityStatus;
            rhsLegalentityStatus = that.getLegalentityStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalentityStatus", lhsLegalentityStatus), LocatorUtils.property(thatLocator, "legalentityStatus", rhsLegalentityStatus), lhsLegalentityStatus, rhsLegalentityStatus)) {
                return false;
            }
        }
        {
            String lhsBankAccountLegalEntityLinkStatus;
            lhsBankAccountLegalEntityLinkStatus = this.getBankAccountLegalEntityLinkStatus();
            String rhsBankAccountLegalEntityLinkStatus;
            rhsBankAccountLegalEntityLinkStatus = that.getBankAccountLegalEntityLinkStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountLegalEntityLinkStatus", lhsBankAccountLegalEntityLinkStatus), LocatorUtils.property(thatLocator, "bankAccountLegalEntityLinkStatus", rhsBankAccountLegalEntityLinkStatus), lhsBankAccountLegalEntityLinkStatus, rhsBankAccountLegalEntityLinkStatus)) {
                return false;
            }
        }
        {
            String lhsBlockingReason;
            lhsBlockingReason = this.getBlockingReason();
            String rhsBlockingReason;
            rhsBlockingReason = that.getBlockingReason();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "blockingReason", lhsBlockingReason), LocatorUtils.property(thatLocator, "blockingReason", rhsBlockingReason), lhsBlockingReason, rhsBlockingReason)) {
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
            LegalEntityBankAccountType theBankAccount;
            theBankAccount = this.getBankAccount();
            strategy.appendField(locator, this, "bankAccount", buffer, theBankAccount);
        }
        {
            String theBankAccountStatus;
            theBankAccountStatus = this.getBankAccountStatus();
            strategy.appendField(locator, this, "bankAccountStatus", buffer, theBankAccountStatus);
        }
        {
            String theLegalentityStatus;
            theLegalentityStatus = this.getLegalentityStatus();
            strategy.appendField(locator, this, "legalentityStatus", buffer, theLegalentityStatus);
        }
        {
            String theBankAccountLegalEntityLinkStatus;
            theBankAccountLegalEntityLinkStatus = this.getBankAccountLegalEntityLinkStatus();
            strategy.appendField(locator, this, "bankAccountLegalEntityLinkStatus", buffer, theBankAccountLegalEntityLinkStatus);
        }
        {
            String theBlockingReason;
            theBlockingReason = this.getBlockingReason();
            strategy.appendField(locator, this, "blockingReason", buffer, theBlockingReason);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            LegalEntityBankAccountType theBankAccount;
            theBankAccount = this.getBankAccount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccount", theBankAccount), currentHashCode, theBankAccount);
        }
        {
            String theBankAccountStatus;
            theBankAccountStatus = this.getBankAccountStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountStatus", theBankAccountStatus), currentHashCode, theBankAccountStatus);
        }
        {
            String theLegalentityStatus;
            theLegalentityStatus = this.getLegalentityStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalentityStatus", theLegalentityStatus), currentHashCode, theLegalentityStatus);
        }
        {
            String theBankAccountLegalEntityLinkStatus;
            theBankAccountLegalEntityLinkStatus = this.getBankAccountLegalEntityLinkStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountLegalEntityLinkStatus", theBankAccountLegalEntityLinkStatus), currentHashCode, theBankAccountLegalEntityLinkStatus);
        }
        {
            String theBlockingReason;
            theBlockingReason = this.getBlockingReason();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "blockingReason", theBlockingReason), currentHashCode, theBlockingReason);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
