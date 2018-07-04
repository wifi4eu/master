
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for LegalEntityEwsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityEwsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identifier" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="legalEntityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="earlyWarning" type="{http://ec.europa.eu/rdg/jagate/ws/domain/legalentity/v6}EarlyWarningType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityEwsType", propOrder = {
    "identifier",
    "legalEntityName",
    "earlyWarning"
})
public class LegalEntityEwsType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String identifier;
    protected String legalEntityName;
    protected List<EarlyWarningType> earlyWarning;

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the legalEntityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityName() {
        return legalEntityName;
    }

    /**
     * Sets the value of the legalEntityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityName(String value) {
        this.legalEntityName = value;
    }

    /**
     * Gets the value of the earlyWarning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the earlyWarning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEarlyWarning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EarlyWarningType }
     * 
     * 
     */
    public List<EarlyWarningType> getEarlyWarning() {
        if (earlyWarning == null) {
            earlyWarning = new ArrayList<EarlyWarningType>();
        }
        return this.earlyWarning;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LegalEntityEwsType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LegalEntityEwsType that = ((LegalEntityEwsType) object);
        {
            String lhsIdentifier;
            lhsIdentifier = this.getIdentifier();
            String rhsIdentifier;
            rhsIdentifier = that.getIdentifier();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "identifier", lhsIdentifier), LocatorUtils.property(thatLocator, "identifier", rhsIdentifier), lhsIdentifier, rhsIdentifier)) {
                return false;
            }
        }
        {
            String lhsLegalEntityName;
            lhsLegalEntityName = this.getLegalEntityName();
            String rhsLegalEntityName;
            rhsLegalEntityName = that.getLegalEntityName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalEntityName", lhsLegalEntityName), LocatorUtils.property(thatLocator, "legalEntityName", rhsLegalEntityName), lhsLegalEntityName, rhsLegalEntityName)) {
                return false;
            }
        }
        {
            List<EarlyWarningType> lhsEarlyWarning;
            lhsEarlyWarning = (((this.earlyWarning!= null)&&(!this.earlyWarning.isEmpty()))?this.getEarlyWarning():null);
            List<EarlyWarningType> rhsEarlyWarning;
            rhsEarlyWarning = (((that.earlyWarning!= null)&&(!that.earlyWarning.isEmpty()))?that.getEarlyWarning():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "earlyWarning", lhsEarlyWarning), LocatorUtils.property(thatLocator, "earlyWarning", rhsEarlyWarning), lhsEarlyWarning, rhsEarlyWarning)) {
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
            String theIdentifier;
            theIdentifier = this.getIdentifier();
            strategy.appendField(locator, this, "identifier", buffer, theIdentifier);
        }
        {
            String theLegalEntityName;
            theLegalEntityName = this.getLegalEntityName();
            strategy.appendField(locator, this, "legalEntityName", buffer, theLegalEntityName);
        }
        {
            List<EarlyWarningType> theEarlyWarning;
            theEarlyWarning = (((this.earlyWarning!= null)&&(!this.earlyWarning.isEmpty()))?this.getEarlyWarning():null);
            strategy.appendField(locator, this, "earlyWarning", buffer, theEarlyWarning);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theIdentifier;
            theIdentifier = this.getIdentifier();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identifier", theIdentifier), currentHashCode, theIdentifier);
        }
        {
            String theLegalEntityName;
            theLegalEntityName = this.getLegalEntityName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalEntityName", theLegalEntityName), currentHashCode, theLegalEntityName);
        }
        {
            List<EarlyWarningType> theEarlyWarning;
            theEarlyWarning = (((this.earlyWarning!= null)&&(!this.earlyWarning.isEmpty()))?this.getEarlyWarning():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "earlyWarning", theEarlyWarning), currentHashCode, theEarlyWarning);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
