
package generated.hrs.ws.model;

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
 * An internal entity
 * 
 * <p>Java class for InternalEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InternalEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/sg/hrs/types}Entity">
 *       &lt;sequence>
 *         &lt;element name="internalOrganization" type="{http://ec.europa.eu/sg/hrs/types}InternalOrganization"/>
 *         &lt;element name="internalPerson" type="{http://ec.europa.eu/sg/hrs/types}InternalPerson" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternalEntity", propOrder = {
    "internalOrganization",
    "internalPerson"
})
public class InternalEntity
    extends Entity
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected InternalOrganization internalOrganization;
    protected InternalPerson internalPerson;

    /**
     * Gets the value of the internalOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link InternalOrganization }
     *     
     */
    public InternalOrganization getInternalOrganization() {
        return internalOrganization;
    }

    /**
     * Sets the value of the internalOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalOrganization }
     *     
     */
    public void setInternalOrganization(InternalOrganization value) {
        this.internalOrganization = value;
    }

    /**
     * Gets the value of the internalPerson property.
     * 
     * @return
     *     possible object is
     *     {@link InternalPerson }
     *     
     */
    public InternalPerson getInternalPerson() {
        return internalPerson;
    }

    /**
     * Sets the value of the internalPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalPerson }
     *     
     */
    public void setInternalPerson(InternalPerson value) {
        this.internalPerson = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof InternalEntity)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final InternalEntity that = ((InternalEntity) object);
        {
            InternalOrganization lhsInternalOrganization;
            lhsInternalOrganization = this.getInternalOrganization();
            InternalOrganization rhsInternalOrganization;
            rhsInternalOrganization = that.getInternalOrganization();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "internalOrganization", lhsInternalOrganization), LocatorUtils.property(thatLocator, "internalOrganization", rhsInternalOrganization), lhsInternalOrganization, rhsInternalOrganization)) {
                return false;
            }
        }
        {
            InternalPerson lhsInternalPerson;
            lhsInternalPerson = this.getInternalPerson();
            InternalPerson rhsInternalPerson;
            rhsInternalPerson = that.getInternalPerson();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "internalPerson", lhsInternalPerson), LocatorUtils.property(thatLocator, "internalPerson", rhsInternalPerson), lhsInternalPerson, rhsInternalPerson)) {
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
            InternalOrganization theInternalOrganization;
            theInternalOrganization = this.getInternalOrganization();
            strategy.appendField(locator, this, "internalOrganization", buffer, theInternalOrganization);
        }
        {
            InternalPerson theInternalPerson;
            theInternalPerson = this.getInternalPerson();
            strategy.appendField(locator, this, "internalPerson", buffer, theInternalPerson);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            InternalOrganization theInternalOrganization;
            theInternalOrganization = this.getInternalOrganization();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "internalOrganization", theInternalOrganization), currentHashCode, theInternalOrganization);
        }
        {
            InternalPerson theInternalPerson;
            theInternalPerson = this.getInternalPerson();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "internalPerson", theInternalPerson), currentHashCode, theInternalPerson);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
