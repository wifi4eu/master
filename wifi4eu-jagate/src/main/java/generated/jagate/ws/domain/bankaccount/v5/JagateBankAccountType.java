
package generated.jagate.ws.domain.bankaccount.v5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
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
 * <p>Java class for JagateBankAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JagateBankAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankAccountFormat" type="{http://ec.europa.eu/rdg/jagate/ws/domain/bankaccount/v5}BankAccountFormatType"/>
 *         &lt;element name="bankName" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="legalEntityId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="currency" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *         &lt;element name="responsibleUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responsibleOrganization" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="confidential" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankAddress" type="{http://ec.europa.eu/rdg/jagate/ws/domain/bankaccount/v5}JagateBankAccountAddressType"/>
 *         &lt;element name="bankAccountHolder" type="{http://ec.europa.eu/rdg/jagate/ws/domain/bankaccount/v5}JagateBankAccountHolderType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JagateBankAccountType", propOrder = {
    "bankAccountFormat",
    "bankName",
    "legalEntityId",
    "currency",
    "responsibleUser",
    "responsibleOrganization",
    "confidential",
    "remarks",
    "bankAddress",
    "bankAccountHolder"
})
public class JagateBankAccountType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected BankAccountFormatType bankAccountFormat;
    @XmlElement(required = true)
    protected String bankName;
    @XmlElement(required = true)
    protected String legalEntityId;
    protected CodeRefType currency;
    protected String responsibleUser;
    @XmlElement(required = true)
    protected CodeRefType responsibleOrganization;
    protected boolean confidential;
    protected String remarks;
    @XmlElement(required = true)
    protected JagateBankAccountAddressType bankAddress;
    @XmlElement(required = true)
    protected JagateBankAccountHolderType bankAccountHolder;

    /**
     * Gets the value of the bankAccountFormat property.
     * 
     * @return
     *     possible object is
     *     {@link BankAccountFormatType }
     *     
     */
    public BankAccountFormatType getBankAccountFormat() {
        return bankAccountFormat;
    }

    /**
     * Sets the value of the bankAccountFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccountFormatType }
     *     
     */
    public void setBankAccountFormat(BankAccountFormatType value) {
        this.bankAccountFormat = value;
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Gets the value of the legalEntityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityId() {
        return legalEntityId;
    }

    /**
     * Sets the value of the legalEntityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityId(String value) {
        this.legalEntityId = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCurrency(CodeRefType value) {
        this.currency = value;
    }

    /**
     * Gets the value of the responsibleUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleUser() {
        return responsibleUser;
    }

    /**
     * Sets the value of the responsibleUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleUser(String value) {
        this.responsibleUser = value;
    }

    /**
     * Gets the value of the responsibleOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getResponsibleOrganization() {
        return responsibleOrganization;
    }

    /**
     * Sets the value of the responsibleOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setResponsibleOrganization(CodeRefType value) {
        this.responsibleOrganization = value;
    }

    /**
     * Gets the value of the confidential property.
     * 
     */
    public boolean isConfidential() {
        return confidential;
    }

    /**
     * Sets the value of the confidential property.
     * 
     */
    public void setConfidential(boolean value) {
        this.confidential = value;
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
     * Gets the value of the bankAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JagateBankAccountAddressType }
     *     
     */
    public JagateBankAccountAddressType getBankAddress() {
        return bankAddress;
    }

    /**
     * Sets the value of the bankAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JagateBankAccountAddressType }
     *     
     */
    public void setBankAddress(JagateBankAccountAddressType value) {
        this.bankAddress = value;
    }

    /**
     * Gets the value of the bankAccountHolder property.
     * 
     * @return
     *     possible object is
     *     {@link JagateBankAccountHolderType }
     *     
     */
    public JagateBankAccountHolderType getBankAccountHolder() {
        return bankAccountHolder;
    }

    /**
     * Sets the value of the bankAccountHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JagateBankAccountHolderType }
     *     
     */
    public void setBankAccountHolder(JagateBankAccountHolderType value) {
        this.bankAccountHolder = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof JagateBankAccountType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final JagateBankAccountType that = ((JagateBankAccountType) object);
        {
            BankAccountFormatType lhsBankAccountFormat;
            lhsBankAccountFormat = this.getBankAccountFormat();
            BankAccountFormatType rhsBankAccountFormat;
            rhsBankAccountFormat = that.getBankAccountFormat();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountFormat", lhsBankAccountFormat), LocatorUtils.property(thatLocator, "bankAccountFormat", rhsBankAccountFormat), lhsBankAccountFormat, rhsBankAccountFormat)) {
                return false;
            }
        }
        {
            String lhsBankName;
            lhsBankName = this.getBankName();
            String rhsBankName;
            rhsBankName = that.getBankName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankName", lhsBankName), LocatorUtils.property(thatLocator, "bankName", rhsBankName), lhsBankName, rhsBankName)) {
                return false;
            }
        }
        {
            String lhsLegalEntityId;
            lhsLegalEntityId = this.getLegalEntityId();
            String rhsLegalEntityId;
            rhsLegalEntityId = that.getLegalEntityId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalEntityId", lhsLegalEntityId), LocatorUtils.property(thatLocator, "legalEntityId", rhsLegalEntityId), lhsLegalEntityId, rhsLegalEntityId)) {
                return false;
            }
        }
        {
            CodeRefType lhsCurrency;
            lhsCurrency = this.getCurrency();
            CodeRefType rhsCurrency;
            rhsCurrency = that.getCurrency();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "currency", lhsCurrency), LocatorUtils.property(thatLocator, "currency", rhsCurrency), lhsCurrency, rhsCurrency)) {
                return false;
            }
        }
        {
            String lhsResponsibleUser;
            lhsResponsibleUser = this.getResponsibleUser();
            String rhsResponsibleUser;
            rhsResponsibleUser = that.getResponsibleUser();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "responsibleUser", lhsResponsibleUser), LocatorUtils.property(thatLocator, "responsibleUser", rhsResponsibleUser), lhsResponsibleUser, rhsResponsibleUser)) {
                return false;
            }
        }
        {
            CodeRefType lhsResponsibleOrganization;
            lhsResponsibleOrganization = this.getResponsibleOrganization();
            CodeRefType rhsResponsibleOrganization;
            rhsResponsibleOrganization = that.getResponsibleOrganization();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "responsibleOrganization", lhsResponsibleOrganization), LocatorUtils.property(thatLocator, "responsibleOrganization", rhsResponsibleOrganization), lhsResponsibleOrganization, rhsResponsibleOrganization)) {
                return false;
            }
        }
        {
            boolean lhsConfidential;
            lhsConfidential = (true?this.isConfidential():false);
            boolean rhsConfidential;
            rhsConfidential = (true?that.isConfidential():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "confidential", lhsConfidential), LocatorUtils.property(thatLocator, "confidential", rhsConfidential), lhsConfidential, rhsConfidential)) {
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
            JagateBankAccountAddressType lhsBankAddress;
            lhsBankAddress = this.getBankAddress();
            JagateBankAccountAddressType rhsBankAddress;
            rhsBankAddress = that.getBankAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAddress", lhsBankAddress), LocatorUtils.property(thatLocator, "bankAddress", rhsBankAddress), lhsBankAddress, rhsBankAddress)) {
                return false;
            }
        }
        {
            JagateBankAccountHolderType lhsBankAccountHolder;
            lhsBankAccountHolder = this.getBankAccountHolder();
            JagateBankAccountHolderType rhsBankAccountHolder;
            rhsBankAccountHolder = that.getBankAccountHolder();
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
            BankAccountFormatType theBankAccountFormat;
            theBankAccountFormat = this.getBankAccountFormat();
            strategy.appendField(locator, this, "bankAccountFormat", buffer, theBankAccountFormat);
        }
        {
            String theBankName;
            theBankName = this.getBankName();
            strategy.appendField(locator, this, "bankName", buffer, theBankName);
        }
        {
            String theLegalEntityId;
            theLegalEntityId = this.getLegalEntityId();
            strategy.appendField(locator, this, "legalEntityId", buffer, theLegalEntityId);
        }
        {
            CodeRefType theCurrency;
            theCurrency = this.getCurrency();
            strategy.appendField(locator, this, "currency", buffer, theCurrency);
        }
        {
            String theResponsibleUser;
            theResponsibleUser = this.getResponsibleUser();
            strategy.appendField(locator, this, "responsibleUser", buffer, theResponsibleUser);
        }
        {
            CodeRefType theResponsibleOrganization;
            theResponsibleOrganization = this.getResponsibleOrganization();
            strategy.appendField(locator, this, "responsibleOrganization", buffer, theResponsibleOrganization);
        }
        {
            boolean theConfidential;
            theConfidential = (true?this.isConfidential():false);
            strategy.appendField(locator, this, "confidential", buffer, theConfidential);
        }
        {
            String theRemarks;
            theRemarks = this.getRemarks();
            strategy.appendField(locator, this, "remarks", buffer, theRemarks);
        }
        {
            JagateBankAccountAddressType theBankAddress;
            theBankAddress = this.getBankAddress();
            strategy.appendField(locator, this, "bankAddress", buffer, theBankAddress);
        }
        {
            JagateBankAccountHolderType theBankAccountHolder;
            theBankAccountHolder = this.getBankAccountHolder();
            strategy.appendField(locator, this, "bankAccountHolder", buffer, theBankAccountHolder);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            BankAccountFormatType theBankAccountFormat;
            theBankAccountFormat = this.getBankAccountFormat();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountFormat", theBankAccountFormat), currentHashCode, theBankAccountFormat);
        }
        {
            String theBankName;
            theBankName = this.getBankName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankName", theBankName), currentHashCode, theBankName);
        }
        {
            String theLegalEntityId;
            theLegalEntityId = this.getLegalEntityId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalEntityId", theLegalEntityId), currentHashCode, theLegalEntityId);
        }
        {
            CodeRefType theCurrency;
            theCurrency = this.getCurrency();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currency", theCurrency), currentHashCode, theCurrency);
        }
        {
            String theResponsibleUser;
            theResponsibleUser = this.getResponsibleUser();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "responsibleUser", theResponsibleUser), currentHashCode, theResponsibleUser);
        }
        {
            CodeRefType theResponsibleOrganization;
            theResponsibleOrganization = this.getResponsibleOrganization();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "responsibleOrganization", theResponsibleOrganization), currentHashCode, theResponsibleOrganization);
        }
        {
            boolean theConfidential;
            theConfidential = (true?this.isConfidential():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "confidential", theConfidential), currentHashCode, theConfidential);
        }
        {
            String theRemarks;
            theRemarks = this.getRemarks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "remarks", theRemarks), currentHashCode, theRemarks);
        }
        {
            JagateBankAccountAddressType theBankAddress;
            theBankAddress = this.getBankAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAddress", theBankAddress), currentHashCode, theBankAddress);
        }
        {
            JagateBankAccountHolderType theBankAccountHolder;
            theBankAccountHolder = this.getBankAccountHolder();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountHolder", theBankAccountHolder), currentHashCode, theBankAccountHolder);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
