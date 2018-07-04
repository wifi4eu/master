
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

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
 * <p>Java class for PrivateLawBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrivateLawBody">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}AbstractLawBody">
 *       &lt;sequence>
 *         &lt;element name="RegistrationInfo" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}LawBodyRegistration"/>
 *         &lt;element name="AccountGroup" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}PrivateBodyAccountGroupType"/>
 *         &lt;element name="AbacLegalForm" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="NonProfit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivateLawBody", propOrder = {
    "registrationInfo",
    "accountGroup",
    "abacLegalForm",
    "nonProfit"
})
public class PrivateLawBody
    extends AbstractLawBody
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "RegistrationInfo", required = true)
    protected LawBodyRegistration registrationInfo;
    @XmlElement(name = "AccountGroup", required = true)
    protected PrivateBodyAccountGroupType accountGroup;
    @XmlElement(name = "AbacLegalForm", required = true)
    protected CodeRefType abacLegalForm;
    @XmlElement(name = "NonProfit")
    protected boolean nonProfit;

    /**
     * Gets the value of the registrationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LawBodyRegistration }
     *     
     */
    public LawBodyRegistration getRegistrationInfo() {
        return registrationInfo;
    }

    /**
     * Sets the value of the registrationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LawBodyRegistration }
     *     
     */
    public void setRegistrationInfo(LawBodyRegistration value) {
        this.registrationInfo = value;
    }

    /**
     * Gets the value of the accountGroup property.
     * 
     * @return
     *     possible object is
     *     {@link PrivateBodyAccountGroupType }
     *     
     */
    public PrivateBodyAccountGroupType getAccountGroup() {
        return accountGroup;
    }

    /**
     * Sets the value of the accountGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivateBodyAccountGroupType }
     *     
     */
    public void setAccountGroup(PrivateBodyAccountGroupType value) {
        this.accountGroup = value;
    }

    /**
     * Gets the value of the abacLegalForm property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getAbacLegalForm() {
        return abacLegalForm;
    }

    /**
     * Sets the value of the abacLegalForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setAbacLegalForm(CodeRefType value) {
        this.abacLegalForm = value;
    }

    /**
     * Gets the value of the nonProfit property.
     * 
     */
    public boolean isNonProfit() {
        return nonProfit;
    }

    /**
     * Sets the value of the nonProfit property.
     * 
     */
    public void setNonProfit(boolean value) {
        this.nonProfit = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PrivateLawBody)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final PrivateLawBody that = ((PrivateLawBody) object);
        {
            LawBodyRegistration lhsRegistrationInfo;
            lhsRegistrationInfo = this.getRegistrationInfo();
            LawBodyRegistration rhsRegistrationInfo;
            rhsRegistrationInfo = that.getRegistrationInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationInfo", lhsRegistrationInfo), LocatorUtils.property(thatLocator, "registrationInfo", rhsRegistrationInfo), lhsRegistrationInfo, rhsRegistrationInfo)) {
                return false;
            }
        }
        {
            PrivateBodyAccountGroupType lhsAccountGroup;
            lhsAccountGroup = this.getAccountGroup();
            PrivateBodyAccountGroupType rhsAccountGroup;
            rhsAccountGroup = that.getAccountGroup();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accountGroup", lhsAccountGroup), LocatorUtils.property(thatLocator, "accountGroup", rhsAccountGroup), lhsAccountGroup, rhsAccountGroup)) {
                return false;
            }
        }
        {
            CodeRefType lhsAbacLegalForm;
            lhsAbacLegalForm = this.getAbacLegalForm();
            CodeRefType rhsAbacLegalForm;
            rhsAbacLegalForm = that.getAbacLegalForm();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "abacLegalForm", lhsAbacLegalForm), LocatorUtils.property(thatLocator, "abacLegalForm", rhsAbacLegalForm), lhsAbacLegalForm, rhsAbacLegalForm)) {
                return false;
            }
        }
        {
            boolean lhsNonProfit;
            lhsNonProfit = (true?this.isNonProfit():false);
            boolean rhsNonProfit;
            rhsNonProfit = (true?that.isNonProfit():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nonProfit", lhsNonProfit), LocatorUtils.property(thatLocator, "nonProfit", rhsNonProfit), lhsNonProfit, rhsNonProfit)) {
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
            LawBodyRegistration theRegistrationInfo;
            theRegistrationInfo = this.getRegistrationInfo();
            strategy.appendField(locator, this, "registrationInfo", buffer, theRegistrationInfo);
        }
        {
            PrivateBodyAccountGroupType theAccountGroup;
            theAccountGroup = this.getAccountGroup();
            strategy.appendField(locator, this, "accountGroup", buffer, theAccountGroup);
        }
        {
            CodeRefType theAbacLegalForm;
            theAbacLegalForm = this.getAbacLegalForm();
            strategy.appendField(locator, this, "abacLegalForm", buffer, theAbacLegalForm);
        }
        {
            boolean theNonProfit;
            theNonProfit = (true?this.isNonProfit():false);
            strategy.appendField(locator, this, "nonProfit", buffer, theNonProfit);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            LawBodyRegistration theRegistrationInfo;
            theRegistrationInfo = this.getRegistrationInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationInfo", theRegistrationInfo), currentHashCode, theRegistrationInfo);
        }
        {
            PrivateBodyAccountGroupType theAccountGroup;
            theAccountGroup = this.getAccountGroup();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accountGroup", theAccountGroup), currentHashCode, theAccountGroup);
        }
        {
            CodeRefType theAbacLegalForm;
            theAbacLegalForm = this.getAbacLegalForm();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "abacLegalForm", theAbacLegalForm), currentHashCode, theAbacLegalForm);
        }
        {
            boolean theNonProfit;
            theNonProfit = (true?this.isNonProfit():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nonProfit", theNonProfit), currentHashCode, theNonProfit);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
