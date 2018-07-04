
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
 * <p>Java class for BankAccountFormatType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BankAccountFormatType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="IBAN" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyStringMax60"/>
 *           &lt;element name="BBAN" type="{http://ec.europa.eu/rdg/jagate/ws/domain/bankaccount/v5}BBANType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankAccountFormatType", propOrder = {
    "iban",
    "bban"
})
public class BankAccountFormatType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "BBAN")
    protected BBANType bban;

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
     * Gets the value of the bban property.
     * 
     * @return
     *     possible object is
     *     {@link BBANType }
     *     
     */
    public BBANType getBBAN() {
        return bban;
    }

    /**
     * Sets the value of the bban property.
     * 
     * @param value
     *     allowed object is
     *     {@link BBANType }
     *     
     */
    public void setBBAN(BBANType value) {
        this.bban = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BankAccountFormatType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final BankAccountFormatType that = ((BankAccountFormatType) object);
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
            BBANType lhsBBAN;
            lhsBBAN = this.getBBAN();
            BBANType rhsBBAN;
            rhsBBAN = that.getBBAN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bban", lhsBBAN), LocatorUtils.property(thatLocator, "bban", rhsBBAN), lhsBBAN, rhsBBAN)) {
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
            String theIBAN;
            theIBAN = this.getIBAN();
            strategy.appendField(locator, this, "iban", buffer, theIBAN);
        }
        {
            BBANType theBBAN;
            theBBAN = this.getBBAN();
            strategy.appendField(locator, this, "bban", buffer, theBBAN);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theIBAN;
            theIBAN = this.getIBAN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "iban", theIBAN), currentHashCode, theIBAN);
        }
        {
            BBANType theBBAN;
            theBBAN = this.getBBAN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bban", theBBAN), currentHashCode, theBBAN);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
