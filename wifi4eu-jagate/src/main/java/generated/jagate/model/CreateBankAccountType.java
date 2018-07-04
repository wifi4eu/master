
package generated.jagate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.header.V1.HeaderType;
import generated.jagate.ws.domain.bankaccount.v5.JagateBankAccountType;
import generated.jagate.ws.domain.base.v2.AresDocumentList;
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
 *         &lt;element name="header" type="{http://ec.europa.eu/research/fp/model/header/V1}HeaderType"/>
 *         &lt;element name="bankAccount" type="{http://ec.europa.eu/rdg/jagate/ws/domain/bankaccount/v5}JagateBankAccountType"/>
 *         &lt;element name="aresDocumentList" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}AresDocumentList"/>
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
    "header",
    "bankAccount",
    "aresDocumentList",
    "visa"
})
public class CreateBankAccountType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected HeaderType header;
    @XmlElement(required = true)
    protected JagateBankAccountType bankAccount;
    @XmlElement(required = true)
    protected AresDocumentList aresDocumentList;
    @XmlElement(required = true)
    protected SingleTransactionVisaEmbeddedType visa;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderType }
     *     
     */
    public HeaderType getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderType }
     *     
     */
    public void setHeader(HeaderType value) {
        this.header = value;
    }

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
            HeaderType lhsHeader;
            lhsHeader = this.getHeader();
            HeaderType rhsHeader;
            rhsHeader = that.getHeader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "header", lhsHeader), LocatorUtils.property(thatLocator, "header", rhsHeader), lhsHeader, rhsHeader)) {
                return false;
            }
        }
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
            HeaderType theHeader;
            theHeader = this.getHeader();
            strategy.appendField(locator, this, "header", buffer, theHeader);
        }
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
            SingleTransactionVisaEmbeddedType theVisa;
            theVisa = this.getVisa();
            strategy.appendField(locator, this, "visa", buffer, theVisa);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            HeaderType theHeader;
            theHeader = this.getHeader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "header", theHeader), currentHashCode, theHeader);
        }
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
