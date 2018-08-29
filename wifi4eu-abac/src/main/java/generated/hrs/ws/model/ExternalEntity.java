
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * An entity which is external to the Commission
 * 
 * <p>Java class for ExternalEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/sg/hrs/types}Entity">
 *       &lt;sequence>
 *         &lt;element name="externalOrganization" type="{http://ec.europa.eu/sg/hrs/types}ExternalOrganization" minOccurs="0"/>
 *         &lt;element name="externalPerson" type="{http://ec.europa.eu/sg/hrs/types}ExternalPerson" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalEntity", propOrder = {
    "externalOrganization",
    "externalPerson"
})
public class ExternalEntity
    extends Entity
    implements Equals, HashCode, ToString
{

    protected ExternalOrganization externalOrganization;
    protected ExternalPerson externalPerson;

    /**
     * Gets the value of the externalOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalOrganization }
     *     
     */
    public ExternalOrganization getExternalOrganization() {
        return externalOrganization;
    }

    /**
     * Sets the value of the externalOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalOrganization }
     *     
     */
    public void setExternalOrganization(ExternalOrganization value) {
        this.externalOrganization = value;
    }

    /**
     * Gets the value of the externalPerson property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalPerson }
     *     
     */
    public ExternalPerson getExternalPerson() {
        return externalPerson;
    }

    /**
     * Sets the value of the externalPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalPerson }
     *     
     */
    public void setExternalPerson(ExternalPerson value) {
        this.externalPerson = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExternalEntity)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ExternalEntity that = ((ExternalEntity) object);
        {
            ExternalOrganization lhsExternalOrganization;
            lhsExternalOrganization = this.getExternalOrganization();
            ExternalOrganization rhsExternalOrganization;
            rhsExternalOrganization = that.getExternalOrganization();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalOrganization", lhsExternalOrganization), LocatorUtils.property(thatLocator, "externalOrganization", rhsExternalOrganization), lhsExternalOrganization, rhsExternalOrganization)) {
                return false;
            }
        }
        {
            ExternalPerson lhsExternalPerson;
            lhsExternalPerson = this.getExternalPerson();
            ExternalPerson rhsExternalPerson;
            rhsExternalPerson = that.getExternalPerson();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalPerson", lhsExternalPerson), LocatorUtils.property(thatLocator, "externalPerson", rhsExternalPerson), lhsExternalPerson, rhsExternalPerson)) {
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
            ExternalOrganization theExternalOrganization;
            theExternalOrganization = this.getExternalOrganization();
            strategy.appendField(locator, this, "externalOrganization", buffer, theExternalOrganization);
        }
        {
            ExternalPerson theExternalPerson;
            theExternalPerson = this.getExternalPerson();
            strategy.appendField(locator, this, "externalPerson", buffer, theExternalPerson);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            ExternalOrganization theExternalOrganization;
            theExternalOrganization = this.getExternalOrganization();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalOrganization", theExternalOrganization), currentHashCode, theExternalOrganization);
        }
        {
            ExternalPerson theExternalPerson;
            theExternalPerson = this.getExternalPerson();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalPerson", theExternalPerson), currentHashCode, theExternalPerson);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
