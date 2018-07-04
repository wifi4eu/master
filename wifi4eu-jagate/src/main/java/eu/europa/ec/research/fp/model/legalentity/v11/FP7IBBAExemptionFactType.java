
package eu.europa.ec.research.fp.model.legalentity.v11;

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
 * <p>Java class for FP7IBBAExemptionFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FP7IBBAExemptionFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterestYieldingBankAccount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FP7IBBAExemptionFactType", propOrder = {
    "interestYieldingBankAccount"
})
public class FP7IBBAExemptionFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "InterestYieldingBankAccount")
    protected Boolean interestYieldingBankAccount;

    /**
     * Gets the value of the interestYieldingBankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInterestYieldingBankAccount() {
        return interestYieldingBankAccount;
    }

    /**
     * Sets the value of the interestYieldingBankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInterestYieldingBankAccount(Boolean value) {
        this.interestYieldingBankAccount = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FP7IBBAExemptionFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FP7IBBAExemptionFactType that = ((FP7IBBAExemptionFactType) object);
        {
            Boolean lhsInterestYieldingBankAccount;
            lhsInterestYieldingBankAccount = this.isInterestYieldingBankAccount();
            Boolean rhsInterestYieldingBankAccount;
            rhsInterestYieldingBankAccount = that.isInterestYieldingBankAccount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "interestYieldingBankAccount", lhsInterestYieldingBankAccount), LocatorUtils.property(thatLocator, "interestYieldingBankAccount", rhsInterestYieldingBankAccount), lhsInterestYieldingBankAccount, rhsInterestYieldingBankAccount)) {
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
            Boolean theInterestYieldingBankAccount;
            theInterestYieldingBankAccount = this.isInterestYieldingBankAccount();
            strategy.appendField(locator, this, "interestYieldingBankAccount", buffer, theInterestYieldingBankAccount);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Boolean theInterestYieldingBankAccount;
            theInterestYieldingBankAccount = this.isInterestYieldingBankAccount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "interestYieldingBankAccount", theInterestYieldingBankAccount), currentHashCode, theInterestYieldingBankAccount);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
