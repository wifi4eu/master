
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
 * <p>Java class for InternalEntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InternalEntityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Person" type="{http://ec.europa.eu/research/fp/model/document/V5}PersonType"/>
 *           &lt;element name="Organisation" type="{http://ec.europa.eu/research/fp/model/document/V5}InternalOrganisationType"/>
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
@XmlType(name = "InternalEntityType", propOrder = {
    "person",
    "organisation"
})
public class InternalEntityType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Person")
    protected PersonType person;
    @XmlElement(name = "Organisation")
    protected InternalOrganisationType organisation;

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setPerson(PersonType value) {
        this.person = value;
    }

    /**
     * Gets the value of the organisation property.
     * 
     * @return
     *     possible object is
     *     {@link InternalOrganisationType }
     *     
     */
    public InternalOrganisationType getOrganisation() {
        return organisation;
    }

    /**
     * Sets the value of the organisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalOrganisationType }
     *     
     */
    public void setOrganisation(InternalOrganisationType value) {
        this.organisation = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof InternalEntityType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final InternalEntityType that = ((InternalEntityType) object);
        {
            PersonType lhsPerson;
            lhsPerson = this.getPerson();
            PersonType rhsPerson;
            rhsPerson = that.getPerson();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "person", lhsPerson), LocatorUtils.property(thatLocator, "person", rhsPerson), lhsPerson, rhsPerson)) {
                return false;
            }
        }
        {
            InternalOrganisationType lhsOrganisation;
            lhsOrganisation = this.getOrganisation();
            InternalOrganisationType rhsOrganisation;
            rhsOrganisation = that.getOrganisation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "organisation", lhsOrganisation), LocatorUtils.property(thatLocator, "organisation", rhsOrganisation), lhsOrganisation, rhsOrganisation)) {
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
            PersonType thePerson;
            thePerson = this.getPerson();
            strategy.appendField(locator, this, "person", buffer, thePerson);
        }
        {
            InternalOrganisationType theOrganisation;
            theOrganisation = this.getOrganisation();
            strategy.appendField(locator, this, "organisation", buffer, theOrganisation);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            PersonType thePerson;
            thePerson = this.getPerson();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "person", thePerson), currentHashCode, thePerson);
        }
        {
            InternalOrganisationType theOrganisation;
            theOrganisation = this.getOrganisation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "organisation", theOrganisation), currentHashCode, theOrganisation);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
