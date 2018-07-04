
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.base.V1.DateIntervalType;
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
 * <p>Java class for ErasmusECHEAccreditationFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ErasmusECHEAccreditationFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ECHEReferenceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InstitutionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ECHEStartEndDate" type="{http://ec.europa.eu/research/fp/model/base/V1}DateIntervalType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErasmusECHEAccreditationFactType", propOrder = {
    "echeReferenceCode",
    "institutionCode",
    "echeStartEndDate"
})
public class ErasmusECHEAccreditationFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ECHEReferenceCode", required = true)
    protected String echeReferenceCode;
    @XmlElement(name = "InstitutionCode", required = true)
    protected String institutionCode;
    @XmlElement(name = "ECHEStartEndDate", required = true)
    protected DateIntervalType echeStartEndDate;

    /**
     * Gets the value of the echeReferenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECHEReferenceCode() {
        return echeReferenceCode;
    }

    /**
     * Sets the value of the echeReferenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECHEReferenceCode(String value) {
        this.echeReferenceCode = value;
    }

    /**
     * Gets the value of the institutionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitutionCode() {
        return institutionCode;
    }

    /**
     * Sets the value of the institutionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitutionCode(String value) {
        this.institutionCode = value;
    }

    /**
     * Gets the value of the echeStartEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateIntervalType }
     *     
     */
    public DateIntervalType getECHEStartEndDate() {
        return echeStartEndDate;
    }

    /**
     * Sets the value of the echeStartEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateIntervalType }
     *     
     */
    public void setECHEStartEndDate(DateIntervalType value) {
        this.echeStartEndDate = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ErasmusECHEAccreditationFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ErasmusECHEAccreditationFactType that = ((ErasmusECHEAccreditationFactType) object);
        {
            String lhsECHEReferenceCode;
            lhsECHEReferenceCode = this.getECHEReferenceCode();
            String rhsECHEReferenceCode;
            rhsECHEReferenceCode = that.getECHEReferenceCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "echeReferenceCode", lhsECHEReferenceCode), LocatorUtils.property(thatLocator, "echeReferenceCode", rhsECHEReferenceCode), lhsECHEReferenceCode, rhsECHEReferenceCode)) {
                return false;
            }
        }
        {
            String lhsInstitutionCode;
            lhsInstitutionCode = this.getInstitutionCode();
            String rhsInstitutionCode;
            rhsInstitutionCode = that.getInstitutionCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "institutionCode", lhsInstitutionCode), LocatorUtils.property(thatLocator, "institutionCode", rhsInstitutionCode), lhsInstitutionCode, rhsInstitutionCode)) {
                return false;
            }
        }
        {
            DateIntervalType lhsECHEStartEndDate;
            lhsECHEStartEndDate = this.getECHEStartEndDate();
            DateIntervalType rhsECHEStartEndDate;
            rhsECHEStartEndDate = that.getECHEStartEndDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "echeStartEndDate", lhsECHEStartEndDate), LocatorUtils.property(thatLocator, "echeStartEndDate", rhsECHEStartEndDate), lhsECHEStartEndDate, rhsECHEStartEndDate)) {
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
            String theECHEReferenceCode;
            theECHEReferenceCode = this.getECHEReferenceCode();
            strategy.appendField(locator, this, "echeReferenceCode", buffer, theECHEReferenceCode);
        }
        {
            String theInstitutionCode;
            theInstitutionCode = this.getInstitutionCode();
            strategy.appendField(locator, this, "institutionCode", buffer, theInstitutionCode);
        }
        {
            DateIntervalType theECHEStartEndDate;
            theECHEStartEndDate = this.getECHEStartEndDate();
            strategy.appendField(locator, this, "echeStartEndDate", buffer, theECHEStartEndDate);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theECHEReferenceCode;
            theECHEReferenceCode = this.getECHEReferenceCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "echeReferenceCode", theECHEReferenceCode), currentHashCode, theECHEReferenceCode);
        }
        {
            String theInstitutionCode;
            theInstitutionCode = this.getInstitutionCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "institutionCode", theInstitutionCode), currentHashCode, theInstitutionCode);
        }
        {
            DateIntervalType theECHEStartEndDate;
            theECHEStartEndDate = this.getECHEStartEndDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "echeStartEndDate", theECHEStartEndDate), currentHashCode, theECHEStartEndDate);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
