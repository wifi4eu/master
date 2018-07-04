
package generated.jagate.ws.domain.bankaccount.v5;

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
 * <p>Java class for BBANType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BBANType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankAccountNumber" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="bicCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BsbRoutingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BBANType", propOrder = {
    "bankAccountNumber",
    "bicCode",
    "bsbRoutingCode"
})
public class BBANType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String bankAccountNumber;
    protected String bicCode;
    @XmlElement(name = "BsbRoutingCode")
    protected String bsbRoutingCode;

    /**
     * Gets the value of the bankAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * Sets the value of the bankAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountNumber(String value) {
        this.bankAccountNumber = value;
    }

    /**
     * Gets the value of the bicCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBicCode() {
        return bicCode;
    }

    /**
     * Sets the value of the bicCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBicCode(String value) {
        this.bicCode = value;
    }

    /**
     * Gets the value of the bsbRoutingCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBsbRoutingCode() {
        return bsbRoutingCode;
    }

    /**
     * Sets the value of the bsbRoutingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBsbRoutingCode(String value) {
        this.bsbRoutingCode = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BBANType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final BBANType that = ((BBANType) object);
        {
            String lhsBankAccountNumber;
            lhsBankAccountNumber = this.getBankAccountNumber();
            String rhsBankAccountNumber;
            rhsBankAccountNumber = that.getBankAccountNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountNumber", lhsBankAccountNumber), LocatorUtils.property(thatLocator, "bankAccountNumber", rhsBankAccountNumber), lhsBankAccountNumber, rhsBankAccountNumber)) {
                return false;
            }
        }
        {
            String lhsBicCode;
            lhsBicCode = this.getBicCode();
            String rhsBicCode;
            rhsBicCode = that.getBicCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bicCode", lhsBicCode), LocatorUtils.property(thatLocator, "bicCode", rhsBicCode), lhsBicCode, rhsBicCode)) {
                return false;
            }
        }
        {
            String lhsBsbRoutingCode;
            lhsBsbRoutingCode = this.getBsbRoutingCode();
            String rhsBsbRoutingCode;
            rhsBsbRoutingCode = that.getBsbRoutingCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bsbRoutingCode", lhsBsbRoutingCode), LocatorUtils.property(thatLocator, "bsbRoutingCode", rhsBsbRoutingCode), lhsBsbRoutingCode, rhsBsbRoutingCode)) {
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
            String theBankAccountNumber;
            theBankAccountNumber = this.getBankAccountNumber();
            strategy.appendField(locator, this, "bankAccountNumber", buffer, theBankAccountNumber);
        }
        {
            String theBicCode;
            theBicCode = this.getBicCode();
            strategy.appendField(locator, this, "bicCode", buffer, theBicCode);
        }
        {
            String theBsbRoutingCode;
            theBsbRoutingCode = this.getBsbRoutingCode();
            strategy.appendField(locator, this, "bsbRoutingCode", buffer, theBsbRoutingCode);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theBankAccountNumber;
            theBankAccountNumber = this.getBankAccountNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountNumber", theBankAccountNumber), currentHashCode, theBankAccountNumber);
        }
        {
            String theBicCode;
            theBicCode = this.getBicCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bicCode", theBicCode), currentHashCode, theBicCode);
        }
        {
            String theBsbRoutingCode;
            theBsbRoutingCode = this.getBsbRoutingCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bsbRoutingCode", theBsbRoutingCode), currentHashCode, theBsbRoutingCode);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
