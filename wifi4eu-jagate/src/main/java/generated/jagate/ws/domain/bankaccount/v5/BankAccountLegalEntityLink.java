
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
 * <p>Java class for BankAccountLegalEntityLink complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BankAccountLegalEntityLink">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="legalEntityId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legalEntityLinkStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankAccountLegalEntityLink", propOrder = {
    "legalEntityId",
    "legalEntityLinkStatus"
})
public class BankAccountLegalEntityLink
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String legalEntityId;
    @XmlElement(required = true)
    protected String legalEntityLinkStatus;

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
     * Gets the value of the legalEntityLinkStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityLinkStatus() {
        return legalEntityLinkStatus;
    }

    /**
     * Sets the value of the legalEntityLinkStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityLinkStatus(String value) {
        this.legalEntityLinkStatus = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BankAccountLegalEntityLink)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final BankAccountLegalEntityLink that = ((BankAccountLegalEntityLink) object);
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
            String lhsLegalEntityLinkStatus;
            lhsLegalEntityLinkStatus = this.getLegalEntityLinkStatus();
            String rhsLegalEntityLinkStatus;
            rhsLegalEntityLinkStatus = that.getLegalEntityLinkStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalEntityLinkStatus", lhsLegalEntityLinkStatus), LocatorUtils.property(thatLocator, "legalEntityLinkStatus", rhsLegalEntityLinkStatus), lhsLegalEntityLinkStatus, rhsLegalEntityLinkStatus)) {
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
            String theLegalEntityLinkStatus;
            theLegalEntityLinkStatus = this.getLegalEntityLinkStatus();
            strategy.appendField(locator, this, "legalEntityLinkStatus", buffer, theLegalEntityLinkStatus);
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
            String theLegalEntityLinkStatus;
            theLegalEntityLinkStatus = this.getLegalEntityLinkStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalEntityLinkStatus", theLegalEntityLinkStatus), currentHashCode, theLegalEntityLinkStatus);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
