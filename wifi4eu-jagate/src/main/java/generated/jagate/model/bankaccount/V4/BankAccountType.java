
package generated.jagate.model.bankaccount.V4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.research.fp.model.legalentity.v11.BankAccountFactType;
import generated.jagate.model.address.v4.AddressType;
import generated.jagate.modelperson.v4.PersonType;
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
 * <p>Java class for BankAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BankAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountHolderName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VATNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nordbanken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountHolderAddress" type="{http://ec.europa.eu/research/fp/model/address/V4}AddressType"/>
 *         &lt;element name="Bank" type="{http://ec.europa.eu/research/fp/model/bankaccount/V4}BankType"/>
 *         &lt;element name="AccountContact" type="{http://ec.europa.eu/research/fp/model/person/V4}PersonType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankAccountType", propOrder = {
    "accountHolderName",
    "iban",
    "accountNumber",
    "vatNumber",
    "remarks",
    "nordbanken",
    "accountHolderAddress",
    "bank",
    "accountContact"
})
@XmlSeeAlso({
    BankAccountFactType.class
})
public class BankAccountType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AccountHolderName", required = true)
    protected String accountHolderName;
    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "AccountNumber")
    protected String accountNumber;
    @XmlElement(name = "VATNumber")
    protected String vatNumber;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "Nordbanken")
    protected String nordbanken;
    @XmlElement(name = "AccountHolderAddress", required = true)
    protected AddressType accountHolderAddress;
    @XmlElement(name = "Bank", required = true)
    protected BankType bank;
    @XmlElement(name = "AccountContact", required = true)
    protected PersonType accountContact;

    /**
     * Gets the value of the accountHolderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Sets the value of the accountHolderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountHolderName(String value) {
        this.accountHolderName = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the vatNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVATNumber() {
        return vatNumber;
    }

    /**
     * Sets the value of the vatNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVATNumber(String value) {
        this.vatNumber = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the nordbanken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNordbanken() {
        return nordbanken;
    }

    /**
     * Sets the value of the nordbanken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNordbanken(String value) {
        this.nordbanken = value;
    }

    /**
     * Gets the value of the accountHolderAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAccountHolderAddress() {
        return accountHolderAddress;
    }

    /**
     * Sets the value of the accountHolderAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAccountHolderAddress(AddressType value) {
        this.accountHolderAddress = value;
    }

    /**
     * Gets the value of the bank property.
     * 
     * @return
     *     possible object is
     *     {@link BankType }
     *     
     */
    public BankType getBank() {
        return bank;
    }

    /**
     * Sets the value of the bank property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankType }
     *     
     */
    public void setBank(BankType value) {
        this.bank = value;
    }

    /**
     * Gets the value of the accountContact property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getAccountContact() {
        return accountContact;
    }

    /**
     * Sets the value of the accountContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setAccountContact(PersonType value) {
        this.accountContact = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BankAccountType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final BankAccountType that = ((BankAccountType) object);
        {
            String lhsAccountHolderName;
            lhsAccountHolderName = this.getAccountHolderName();
            String rhsAccountHolderName;
            rhsAccountHolderName = that.getAccountHolderName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accountHolderName", lhsAccountHolderName), LocatorUtils.property(thatLocator, "accountHolderName", rhsAccountHolderName), lhsAccountHolderName, rhsAccountHolderName)) {
                return false;
            }
        }
        {
            String lhsIBAN;
            lhsIBAN = this.getIBAN();
            String rhsIBAN;
            rhsIBAN = that.getIBAN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "iban", lhsIBAN), LocatorUtils.property(thatLocator, "iban", rhsIBAN), lhsIBAN, rhsIBAN)) {
                return false;
            }
        }
        {
            String lhsAccountNumber;
            lhsAccountNumber = this.getAccountNumber();
            String rhsAccountNumber;
            rhsAccountNumber = that.getAccountNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accountNumber", lhsAccountNumber), LocatorUtils.property(thatLocator, "accountNumber", rhsAccountNumber), lhsAccountNumber, rhsAccountNumber)) {
                return false;
            }
        }
        {
            String lhsVATNumber;
            lhsVATNumber = this.getVATNumber();
            String rhsVATNumber;
            rhsVATNumber = that.getVATNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vatNumber", lhsVATNumber), LocatorUtils.property(thatLocator, "vatNumber", rhsVATNumber), lhsVATNumber, rhsVATNumber)) {
                return false;
            }
        }
        {
            String lhsRemarks;
            lhsRemarks = this.getRemarks();
            String rhsRemarks;
            rhsRemarks = that.getRemarks();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "remarks", lhsRemarks), LocatorUtils.property(thatLocator, "remarks", rhsRemarks), lhsRemarks, rhsRemarks)) {
                return false;
            }
        }
        {
            String lhsNordbanken;
            lhsNordbanken = this.getNordbanken();
            String rhsNordbanken;
            rhsNordbanken = that.getNordbanken();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nordbanken", lhsNordbanken), LocatorUtils.property(thatLocator, "nordbanken", rhsNordbanken), lhsNordbanken, rhsNordbanken)) {
                return false;
            }
        }
        {
            AddressType lhsAccountHolderAddress;
            lhsAccountHolderAddress = this.getAccountHolderAddress();
            AddressType rhsAccountHolderAddress;
            rhsAccountHolderAddress = that.getAccountHolderAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accountHolderAddress", lhsAccountHolderAddress), LocatorUtils.property(thatLocator, "accountHolderAddress", rhsAccountHolderAddress), lhsAccountHolderAddress, rhsAccountHolderAddress)) {
                return false;
            }
        }
        {
            BankType lhsBank;
            lhsBank = this.getBank();
            BankType rhsBank;
            rhsBank = that.getBank();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bank", lhsBank), LocatorUtils.property(thatLocator, "bank", rhsBank), lhsBank, rhsBank)) {
                return false;
            }
        }
        {
            PersonType lhsAccountContact;
            lhsAccountContact = this.getAccountContact();
            PersonType rhsAccountContact;
            rhsAccountContact = that.getAccountContact();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accountContact", lhsAccountContact), LocatorUtils.property(thatLocator, "accountContact", rhsAccountContact), lhsAccountContact, rhsAccountContact)) {
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
            String theAccountHolderName;
            theAccountHolderName = this.getAccountHolderName();
            strategy.appendField(locator, this, "accountHolderName", buffer, theAccountHolderName);
        }
        {
            String theIBAN;
            theIBAN = this.getIBAN();
            strategy.appendField(locator, this, "iban", buffer, theIBAN);
        }
        {
            String theAccountNumber;
            theAccountNumber = this.getAccountNumber();
            strategy.appendField(locator, this, "accountNumber", buffer, theAccountNumber);
        }
        {
            String theVATNumber;
            theVATNumber = this.getVATNumber();
            strategy.appendField(locator, this, "vatNumber", buffer, theVATNumber);
        }
        {
            String theRemarks;
            theRemarks = this.getRemarks();
            strategy.appendField(locator, this, "remarks", buffer, theRemarks);
        }
        {
            String theNordbanken;
            theNordbanken = this.getNordbanken();
            strategy.appendField(locator, this, "nordbanken", buffer, theNordbanken);
        }
        {
            AddressType theAccountHolderAddress;
            theAccountHolderAddress = this.getAccountHolderAddress();
            strategy.appendField(locator, this, "accountHolderAddress", buffer, theAccountHolderAddress);
        }
        {
            BankType theBank;
            theBank = this.getBank();
            strategy.appendField(locator, this, "bank", buffer, theBank);
        }
        {
            PersonType theAccountContact;
            theAccountContact = this.getAccountContact();
            strategy.appendField(locator, this, "accountContact", buffer, theAccountContact);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theAccountHolderName;
            theAccountHolderName = this.getAccountHolderName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accountHolderName", theAccountHolderName), currentHashCode, theAccountHolderName);
        }
        {
            String theIBAN;
            theIBAN = this.getIBAN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "iban", theIBAN), currentHashCode, theIBAN);
        }
        {
            String theAccountNumber;
            theAccountNumber = this.getAccountNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accountNumber", theAccountNumber), currentHashCode, theAccountNumber);
        }
        {
            String theVATNumber;
            theVATNumber = this.getVATNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vatNumber", theVATNumber), currentHashCode, theVATNumber);
        }
        {
            String theRemarks;
            theRemarks = this.getRemarks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "remarks", theRemarks), currentHashCode, theRemarks);
        }
        {
            String theNordbanken;
            theNordbanken = this.getNordbanken();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nordbanken", theNordbanken), currentHashCode, theNordbanken);
        }
        {
            AddressType theAccountHolderAddress;
            theAccountHolderAddress = this.getAccountHolderAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accountHolderAddress", theAccountHolderAddress), currentHashCode, theAccountHolderAddress);
        }
        {
            BankType theBank;
            theBank = this.getBank();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bank", theBank), currentHashCode, theBank);
        }
        {
            PersonType theAccountContact;
            theAccountContact = this.getAccountContact();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accountContact", theAccountContact), currentHashCode, theAccountContact);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
