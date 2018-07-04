
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
 * <p>Java class for OrganisationClassificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganisationClassificationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/research/fp/model/document/V5}DocumentClassificationType">
 *       &lt;sequence>
 *         &lt;element name="PIC" type="{http://ec.europa.eu/research/fp/model/legalentity-ref/V3}LegalEntityIdType"/>
 *         &lt;element name="LocalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganisationClassificationType", propOrder = {
    "pic",
    "localReference"
})
public class OrganisationClassificationType
    extends DocumentClassificationType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "PIC", required = true)
    protected String pic;
    @XmlElement(name = "LocalReference")
    protected String localReference;

    /**
     * Gets the value of the pic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPIC() {
        return pic;
    }

    /**
     * Sets the value of the pic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPIC(String value) {
        this.pic = value;
    }

    /**
     * Gets the value of the localReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalReference() {
        return localReference;
    }

    /**
     * Sets the value of the localReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalReference(String value) {
        this.localReference = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof OrganisationClassificationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final OrganisationClassificationType that = ((OrganisationClassificationType) object);
        {
            String lhsPIC;
            lhsPIC = this.getPIC();
            String rhsPIC;
            rhsPIC = that.getPIC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pic", lhsPIC), LocatorUtils.property(thatLocator, "pic", rhsPIC), lhsPIC, rhsPIC)) {
                return false;
            }
        }
        {
            String lhsLocalReference;
            lhsLocalReference = this.getLocalReference();
            String rhsLocalReference;
            rhsLocalReference = that.getLocalReference();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "localReference", lhsLocalReference), LocatorUtils.property(thatLocator, "localReference", rhsLocalReference), lhsLocalReference, rhsLocalReference)) {
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
            String thePIC;
            thePIC = this.getPIC();
            strategy.appendField(locator, this, "pic", buffer, thePIC);
        }
        {
            String theLocalReference;
            theLocalReference = this.getLocalReference();
            strategy.appendField(locator, this, "localReference", buffer, theLocalReference);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String thePIC;
            thePIC = this.getPIC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pic", thePIC), currentHashCode, thePIC);
        }
        {
            String theLocalReference;
            theLocalReference = this.getLocalReference();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localReference", theLocalReference), currentHashCode, theLocalReference);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
