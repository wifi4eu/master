
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for ExternaLEntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternaLEntityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Person" type="{http://ec.europa.eu/research/fp/model/document/V5}ExternalPersonType"/>
 *           &lt;element name="OrganisationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ExternaLEntityType", propOrder = {
    "person",
    "organisationName"
})
public class ExternaLEntityType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Person")
    protected ExternalPersonType person;
    @XmlElement(name = "OrganisationName")
    protected String organisationName;

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalPersonType }
     *     
     */
    public ExternalPersonType getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalPersonType }
     *     
     */
    public void setPerson(ExternalPersonType value) {
        this.person = value;
    }

    /**
     * Gets the value of the organisationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganisationName() {
        return organisationName;
    }

    /**
     * Sets the value of the organisationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganisationName(String value) {
        this.organisationName = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExternaLEntityType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExternaLEntityType that = ((ExternaLEntityType) object);
        {
            ExternalPersonType lhsPerson;
            lhsPerson = this.getPerson();
            ExternalPersonType rhsPerson;
            rhsPerson = that.getPerson();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "person", lhsPerson), LocatorUtils.property(thatLocator, "person", rhsPerson), lhsPerson, rhsPerson)) {
                return false;
            }
        }
        {
            String lhsOrganisationName;
            lhsOrganisationName = this.getOrganisationName();
            String rhsOrganisationName;
            rhsOrganisationName = that.getOrganisationName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "organisationName", lhsOrganisationName), LocatorUtils.property(thatLocator, "organisationName", rhsOrganisationName), lhsOrganisationName, rhsOrganisationName)) {
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
            ExternalPersonType thePerson;
            thePerson = this.getPerson();
            strategy.appendField(locator, this, "person", buffer, thePerson);
        }
        {
            String theOrganisationName;
            theOrganisationName = this.getOrganisationName();
            strategy.appendField(locator, this, "organisationName", buffer, theOrganisationName);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            ExternalPersonType thePerson;
            thePerson = this.getPerson();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "person", thePerson), currentHashCode, thePerson);
        }
        {
            String theOrganisationName;
            theOrganisationName = this.getOrganisationName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "organisationName", theOrganisationName), currentHashCode, theOrganisationName);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
