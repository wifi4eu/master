
package generated.jagate.ws.domain.bankaccount.v5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.bankaccount.V2.BankAccountType;
import generated.jagate.ws.domain.reference.v1.EObjectStatusType;
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
 * <p>Java class for BankAccountHolderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BankAccountHolderType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/research/fp/model/bankaccount/V2}BankAccountType">
 *       &lt;sequence>
 *         &lt;element name="bankAccountStatus" type="{http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1}EObjectStatusType" minOccurs="0"/>
 *         &lt;element name="locObjForeignId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confidentialFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="legalEntityLink" type="{http://ec.europa.eu/rdg/jagate/ws/domain/bankaccount/v5}BankAccountLegalEntityLink" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="refBankAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankAccountHolderType", propOrder = {
    "bankAccountStatus",
    "locObjForeignId",
    "confidentialFlag",
    "legalEntityLink",
    "refBankAccount"
})
public class BankAccountHolderType
    extends BankAccountType
    implements Equals, HashCode, ToString
{

    protected EObjectStatusType bankAccountStatus;
    protected String locObjForeignId;
    protected Boolean confidentialFlag;
    protected List<BankAccountLegalEntityLink> legalEntityLink;
    protected String refBankAccount;

    /**
     * Gets the value of the bankAccountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EObjectStatusType }
     *     
     */
    public EObjectStatusType getBankAccountStatus() {
        return bankAccountStatus;
    }

    /**
     * Sets the value of the bankAccountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EObjectStatusType }
     *     
     */
    public void setBankAccountStatus(EObjectStatusType value) {
        this.bankAccountStatus = value;
    }

    /**
     * Gets the value of the locObjForeignId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocObjForeignId() {
        return locObjForeignId;
    }

    /**
     * Sets the value of the locObjForeignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocObjForeignId(String value) {
        this.locObjForeignId = value;
    }

    /**
     * Gets the value of the confidentialFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConfidentialFlag() {
        return confidentialFlag;
    }

    /**
     * Sets the value of the confidentialFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConfidentialFlag(Boolean value) {
        this.confidentialFlag = value;
    }

    /**
     * Gets the value of the legalEntityLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legalEntityLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegalEntityLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BankAccountLegalEntityLink }
     * 
     * 
     */
    public List<BankAccountLegalEntityLink> getLegalEntityLink() {
        if (legalEntityLink == null) {
            legalEntityLink = new ArrayList<BankAccountLegalEntityLink>();
        }
        return this.legalEntityLink;
    }

    /**
     * Gets the value of the refBankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefBankAccount() {
        return refBankAccount;
    }

    /**
     * Sets the value of the refBankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefBankAccount(String value) {
        this.refBankAccount = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BankAccountHolderType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final BankAccountHolderType that = ((BankAccountHolderType) object);
        {
            EObjectStatusType lhsBankAccountStatus;
            lhsBankAccountStatus = this.getBankAccountStatus();
            EObjectStatusType rhsBankAccountStatus;
            rhsBankAccountStatus = that.getBankAccountStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountStatus", lhsBankAccountStatus), LocatorUtils.property(thatLocator, "bankAccountStatus", rhsBankAccountStatus), lhsBankAccountStatus, rhsBankAccountStatus)) {
                return false;
            }
        }
        {
            String lhsLocObjForeignId;
            lhsLocObjForeignId = this.getLocObjForeignId();
            String rhsLocObjForeignId;
            rhsLocObjForeignId = that.getLocObjForeignId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "locObjForeignId", lhsLocObjForeignId), LocatorUtils.property(thatLocator, "locObjForeignId", rhsLocObjForeignId), lhsLocObjForeignId, rhsLocObjForeignId)) {
                return false;
            }
        }
        {
            Boolean lhsConfidentialFlag;
            lhsConfidentialFlag = this.isConfidentialFlag();
            Boolean rhsConfidentialFlag;
            rhsConfidentialFlag = that.isConfidentialFlag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "confidentialFlag", lhsConfidentialFlag), LocatorUtils.property(thatLocator, "confidentialFlag", rhsConfidentialFlag), lhsConfidentialFlag, rhsConfidentialFlag)) {
                return false;
            }
        }
        {
            List<BankAccountLegalEntityLink> lhsLegalEntityLink;
            lhsLegalEntityLink = (((this.legalEntityLink!= null)&&(!this.legalEntityLink.isEmpty()))?this.getLegalEntityLink():null);
            List<BankAccountLegalEntityLink> rhsLegalEntityLink;
            rhsLegalEntityLink = (((that.legalEntityLink!= null)&&(!that.legalEntityLink.isEmpty()))?that.getLegalEntityLink():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalEntityLink", lhsLegalEntityLink), LocatorUtils.property(thatLocator, "legalEntityLink", rhsLegalEntityLink), lhsLegalEntityLink, rhsLegalEntityLink)) {
                return false;
            }
        }
        {
            String lhsRefBankAccount;
            lhsRefBankAccount = this.getRefBankAccount();
            String rhsRefBankAccount;
            rhsRefBankAccount = that.getRefBankAccount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "refBankAccount", lhsRefBankAccount), LocatorUtils.property(thatLocator, "refBankAccount", rhsRefBankAccount), lhsRefBankAccount, rhsRefBankAccount)) {
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
        super.appendFields(locator, buffer, strategy);
        {
            EObjectStatusType theBankAccountStatus;
            theBankAccountStatus = this.getBankAccountStatus();
            strategy.appendField(locator, this, "bankAccountStatus", buffer, theBankAccountStatus);
        }
        {
            String theLocObjForeignId;
            theLocObjForeignId = this.getLocObjForeignId();
            strategy.appendField(locator, this, "locObjForeignId", buffer, theLocObjForeignId);
        }
        {
            Boolean theConfidentialFlag;
            theConfidentialFlag = this.isConfidentialFlag();
            strategy.appendField(locator, this, "confidentialFlag", buffer, theConfidentialFlag);
        }
        {
            List<BankAccountLegalEntityLink> theLegalEntityLink;
            theLegalEntityLink = (((this.legalEntityLink!= null)&&(!this.legalEntityLink.isEmpty()))?this.getLegalEntityLink():null);
            strategy.appendField(locator, this, "legalEntityLink", buffer, theLegalEntityLink);
        }
        {
            String theRefBankAccount;
            theRefBankAccount = this.getRefBankAccount();
            strategy.appendField(locator, this, "refBankAccount", buffer, theRefBankAccount);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            EObjectStatusType theBankAccountStatus;
            theBankAccountStatus = this.getBankAccountStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountStatus", theBankAccountStatus), currentHashCode, theBankAccountStatus);
        }
        {
            String theLocObjForeignId;
            theLocObjForeignId = this.getLocObjForeignId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "locObjForeignId", theLocObjForeignId), currentHashCode, theLocObjForeignId);
        }
        {
            Boolean theConfidentialFlag;
            theConfidentialFlag = this.isConfidentialFlag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "confidentialFlag", theConfidentialFlag), currentHashCode, theConfidentialFlag);
        }
        {
            List<BankAccountLegalEntityLink> theLegalEntityLink;
            theLegalEntityLink = (((this.legalEntityLink!= null)&&(!this.legalEntityLink.isEmpty()))?this.getLegalEntityLink():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalEntityLink", theLegalEntityLink), currentHashCode, theLegalEntityLink);
        }
        {
            String theRefBankAccount;
            theRefBankAccount = this.getRefBankAccount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "refBankAccount", theRefBankAccount), currentHashCode, theRefBankAccount);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
