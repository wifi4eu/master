
package generated.jagate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.ws.domain.base.v2.AresDocumentList;
import generated.jagate.ws.domain.base.v2.SecurityContext;
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
 * <p>Java class for FollowUpBankAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FollowUpBankAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}SecurityContext" minOccurs="0"/>
 *         &lt;element name="AbacKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "FollowUpBankAccountType", propOrder = {
    "securityContext",
    "abacKey",
    "aresDocumentList",
    "visa"
})
public class FollowUpBankAccountType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "SecurityContext", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/base/v2")
    protected SecurityContext securityContext;
    @XmlElement(name = "AbacKey", required = true)
    protected String abacKey;
    @XmlElement(required = true)
    protected AresDocumentList aresDocumentList;
    @XmlElement(required = true)
    protected SingleTransactionVisaEmbeddedType visa;

    /**
     * Gets the value of the securityContext property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityContext }
     *     
     */
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * Sets the value of the securityContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityContext }
     *     
     */
    public void setSecurityContext(SecurityContext value) {
        this.securityContext = value;
    }

    /**
     * Gets the value of the abacKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbacKey() {
        return abacKey;
    }

    /**
     * Sets the value of the abacKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbacKey(String value) {
        this.abacKey = value;
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
        if (!(object instanceof FollowUpBankAccountType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FollowUpBankAccountType that = ((FollowUpBankAccountType) object);
        {
            SecurityContext lhsSecurityContext;
            lhsSecurityContext = this.getSecurityContext();
            SecurityContext rhsSecurityContext;
            rhsSecurityContext = that.getSecurityContext();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityContext", lhsSecurityContext), LocatorUtils.property(thatLocator, "securityContext", rhsSecurityContext), lhsSecurityContext, rhsSecurityContext)) {
                return false;
            }
        }
        {
            String lhsAbacKey;
            lhsAbacKey = this.getAbacKey();
            String rhsAbacKey;
            rhsAbacKey = that.getAbacKey();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "abacKey", lhsAbacKey), LocatorUtils.property(thatLocator, "abacKey", rhsAbacKey), lhsAbacKey, rhsAbacKey)) {
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
            SecurityContext theSecurityContext;
            theSecurityContext = this.getSecurityContext();
            strategy.appendField(locator, this, "securityContext", buffer, theSecurityContext);
        }
        {
            String theAbacKey;
            theAbacKey = this.getAbacKey();
            strategy.appendField(locator, this, "abacKey", buffer, theAbacKey);
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
            SecurityContext theSecurityContext;
            theSecurityContext = this.getSecurityContext();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityContext", theSecurityContext), currentHashCode, theSecurityContext);
        }
        {
            String theAbacKey;
            theAbacKey = this.getAbacKey();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "abacKey", theAbacKey), currentHashCode, theAbacKey);
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
