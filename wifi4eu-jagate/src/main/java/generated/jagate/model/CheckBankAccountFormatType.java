
package generated.jagate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
import generated.jagate.model.header.V1.HeaderType;
import generated.jagate.ws.domain.bankaccount.v5.BankAccountFormatType;
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
 * <p>Java class for CheckBankAccountFormatType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckBankAccountFormatType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header" type="{http://ec.europa.eu/research/fp/model/header/V1}HeaderType"/>
 *         &lt;element name="bankAccountFormat" type="{http://ec.europa.eu/rdg/jagate/ws/domain/bankaccount/v5}BankAccountFormatType"/>
 *         &lt;element name="country" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckBankAccountFormatType", propOrder = {
    "header",
    "bankAccountFormat",
    "country"
})
public class CheckBankAccountFormatType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected HeaderType header;
    @XmlElement(required = true)
    protected BankAccountFormatType bankAccountFormat;
    @XmlElement(required = true)
    protected CodeRefType country;

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
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCountry(CodeRefType value) {
        this.country = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CheckBankAccountFormatType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CheckBankAccountFormatType that = ((CheckBankAccountFormatType) object);
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
            BankAccountFormatType lhsBankAccountFormat;
            lhsBankAccountFormat = this.getBankAccountFormat();
            BankAccountFormatType rhsBankAccountFormat;
            rhsBankAccountFormat = that.getBankAccountFormat();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountFormat", lhsBankAccountFormat), LocatorUtils.property(thatLocator, "bankAccountFormat", rhsBankAccountFormat), lhsBankAccountFormat, rhsBankAccountFormat)) {
                return false;
            }
        }
        {
            CodeRefType lhsCountry;
            lhsCountry = this.getCountry();
            CodeRefType rhsCountry;
            rhsCountry = that.getCountry();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "country", lhsCountry), LocatorUtils.property(thatLocator, "country", rhsCountry), lhsCountry, rhsCountry)) {
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
            BankAccountFormatType theBankAccountFormat;
            theBankAccountFormat = this.getBankAccountFormat();
            strategy.appendField(locator, this, "bankAccountFormat", buffer, theBankAccountFormat);
        }
        {
            CodeRefType theCountry;
            theCountry = this.getCountry();
            strategy.appendField(locator, this, "country", buffer, theCountry);
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
            BankAccountFormatType theBankAccountFormat;
            theBankAccountFormat = this.getBankAccountFormat();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountFormat", theBankAccountFormat), currentHashCode, theBankAccountFormat);
        }
        {
            CodeRefType theCountry;
            theCountry = this.getCountry();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "country", theCountry), currentHashCode, theCountry);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
