
package generated.jagate.ws.domain.bankaccount.v5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.ws.domain.base.v2.AresDocumentList;
import generated.jagate.ws.domain.base.v2.ScannedDocumentList;
import generated.jagate.ws.domain.visa.v3.SingleTransactionVisaEmbeddedType;
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
 * <p>Java class for CreateBankAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateBankAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankAccount" type="{http://ec.europa.eu/rdg/jagate/ws/domain/bankaccount/v5}JagateBankAccountType"/>
 *         &lt;choice>
 *           &lt;element name="aresDocumentList" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}AresDocumentList"/>
 *           &lt;element name="scannedDocumentList" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}ScannedDocumentList"/>
 *         &lt;/choice>
 *         &lt;element name="visa" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v3}SingleTransactionVisaEmbeddedType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateBankAccountType", propOrder = {
    "bankAccount",
    "aresDocumentList",
    "scannedDocumentList",
    "visa"
})
public class CreateBankAccountType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected JagateBankAccountType bankAccount;
    protected AresDocumentList aresDocumentList;
    protected ScannedDocumentList scannedDocumentList;
    @XmlElement(required = true)
    protected SingleTransactionVisaEmbeddedType visa;

    /**
     * Gets the value of the bankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JagateBankAccountType }
     *     
     */
    public JagateBankAccountType getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the value of the bankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JagateBankAccountType }
     *     
     */
    public void setBankAccount(JagateBankAccountType value) {
        this.bankAccount = value;
    }

    /**
     * Gets the value of the aresDocumentList property.
     * 
     * @return
     *     possible object is
     *     {@link AresDocumentList }
     *     
     */
    public AresDocumentList getAresDocumentList() {
        return aresDocumentList;
    }

    /**
     * Sets the value of the aresDocumentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AresDocumentList }
     *     
     */
    public void setAresDocumentList(AresDocumentList value) {
        this.aresDocumentList = value;
    }

    /**
     * Gets the value of the scannedDocumentList property.
     * 
     * @return
     *     possible object is
     *     {@link ScannedDocumentList }
     *     
     */
    public ScannedDocumentList getScannedDocumentList() {
        return scannedDocumentList;
    }

    /**
     * Sets the value of the scannedDocumentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScannedDocumentList }
     *     
     */
    public void setScannedDocumentList(ScannedDocumentList value) {
        this.scannedDocumentList = value;
    }

    /**
     * Gets the value of the visa property.
     * 
     * @return
     *     possible object is
     *     {@link SingleTransactionVisaEmbeddedType }
     *     
     */
    public SingleTransactionVisaEmbeddedType getVisa() {
        return visa;
    }

    /**
     * Sets the value of the visa property.
     * 
     * @param value
     *     allowed object is
     *     {@link SingleTransactionVisaEmbeddedType }
     *     
     */
    public void setVisa(SingleTransactionVisaEmbeddedType value) {
        this.visa = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CreateBankAccountType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CreateBankAccountType that = ((CreateBankAccountType) object);
        {
            JagateBankAccountType lhsBankAccount;
            lhsBankAccount = this.getBankAccount();
            JagateBankAccountType rhsBankAccount;
            rhsBankAccount = that.getBankAccount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccount", lhsBankAccount), LocatorUtils.property(thatLocator, "bankAccount", rhsBankAccount), lhsBankAccount, rhsBankAccount)) {
                return false;
            }
        }
        {
            AresDocumentList lhsAresDocumentList;
            lhsAresDocumentList = this.getAresDocumentList();
            AresDocumentList rhsAresDocumentList;
            rhsAresDocumentList = that.getAresDocumentList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "aresDocumentList", lhsAresDocumentList), LocatorUtils.property(thatLocator, "aresDocumentList", rhsAresDocumentList), lhsAresDocumentList, rhsAresDocumentList)) {
                return false;
            }
        }
        {
            ScannedDocumentList lhsScannedDocumentList;
            lhsScannedDocumentList = this.getScannedDocumentList();
            ScannedDocumentList rhsScannedDocumentList;
            rhsScannedDocumentList = that.getScannedDocumentList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "scannedDocumentList", lhsScannedDocumentList), LocatorUtils.property(thatLocator, "scannedDocumentList", rhsScannedDocumentList), lhsScannedDocumentList, rhsScannedDocumentList)) {
                return false;
            }
        }
        {
            SingleTransactionVisaEmbeddedType lhsVisa;
            lhsVisa = this.getVisa();
            SingleTransactionVisaEmbeddedType rhsVisa;
            rhsVisa = that.getVisa();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "visa", lhsVisa), LocatorUtils.property(thatLocator, "visa", rhsVisa), lhsVisa, rhsVisa)) {
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
            JagateBankAccountType theBankAccount;
            theBankAccount = this.getBankAccount();
            strategy.appendField(locator, this, "bankAccount", buffer, theBankAccount);
        }
        {
            AresDocumentList theAresDocumentList;
            theAresDocumentList = this.getAresDocumentList();
            strategy.appendField(locator, this, "aresDocumentList", buffer, theAresDocumentList);
        }
        {
            ScannedDocumentList theScannedDocumentList;
            theScannedDocumentList = this.getScannedDocumentList();
            strategy.appendField(locator, this, "scannedDocumentList", buffer, theScannedDocumentList);
        }
        {
            SingleTransactionVisaEmbeddedType theVisa;
            theVisa = this.getVisa();
            strategy.appendField(locator, this, "visa", buffer, theVisa);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            JagateBankAccountType theBankAccount;
            theBankAccount = this.getBankAccount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccount", theBankAccount), currentHashCode, theBankAccount);
        }
        {
            AresDocumentList theAresDocumentList;
            theAresDocumentList = this.getAresDocumentList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aresDocumentList", theAresDocumentList), currentHashCode, theAresDocumentList);
        }
        {
            ScannedDocumentList theScannedDocumentList;
            theScannedDocumentList = this.getScannedDocumentList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "scannedDocumentList", theScannedDocumentList), currentHashCode, theScannedDocumentList);
        }
        {
            SingleTransactionVisaEmbeddedType theVisa;
            theVisa = this.getVisa();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "visa", theVisa), currentHashCode, theVisa);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
