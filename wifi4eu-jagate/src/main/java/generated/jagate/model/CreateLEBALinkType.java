
package generated.jagate.model;

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
 * <p>Java class for CreateLEBALinkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateLEBALinkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="legalEntityId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="bankAccountId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateLEBALinkType", propOrder = {
    "legalEntityId",
    "bankAccountId"
})
public class CreateLEBALinkType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String legalEntityId;
    @XmlElement(required = true)
    protected String bankAccountId;

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
     * Gets the value of the bankAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountId() {
        return bankAccountId;
    }

    /**
     * Sets the value of the bankAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountId(String value) {
        this.bankAccountId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CreateLEBALinkType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CreateLEBALinkType that = ((CreateLEBALinkType) object);
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
            String lhsBankAccountId;
            lhsBankAccountId = this.getBankAccountId();
            String rhsBankAccountId;
            rhsBankAccountId = that.getBankAccountId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bankAccountId", lhsBankAccountId), LocatorUtils.property(thatLocator, "bankAccountId", rhsBankAccountId), lhsBankAccountId, rhsBankAccountId)) {
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
            String theLegalEntityId;
            theLegalEntityId = this.getLegalEntityId();
            strategy.appendField(locator, this, "legalEntityId", buffer, theLegalEntityId);
        }
        {
            String theBankAccountId;
            theBankAccountId = this.getBankAccountId();
            strategy.appendField(locator, this, "bankAccountId", buffer, theBankAccountId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theLegalEntityId;
            theLegalEntityId = this.getLegalEntityId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalEntityId", theLegalEntityId), currentHashCode, theLegalEntityId);
        }
        {
            String theBankAccountId;
            theBankAccountId = this.getBankAccountId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bankAccountId", theBankAccountId), currentHashCode, theBankAccountId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
