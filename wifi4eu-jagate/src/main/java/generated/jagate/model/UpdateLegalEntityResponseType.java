
package generated.jagate.model;

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
 * <p>Java class for UpdateLegalEntityResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateLegalEntityResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LocalObjectForeignId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateLegalEntityResponseType", propOrder = {
    "localObjectForeignId"
})
public class UpdateLegalEntityResponseType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LocalObjectForeignId", required = true)
    protected String localObjectForeignId;

    /**
     * Gets the value of the localObjectForeignId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalObjectForeignId() {
        return localObjectForeignId;
    }

    /**
     * Sets the value of the localObjectForeignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalObjectForeignId(String value) {
        this.localObjectForeignId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UpdateLegalEntityResponseType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UpdateLegalEntityResponseType that = ((UpdateLegalEntityResponseType) object);
        {
            String lhsLocalObjectForeignId;
            lhsLocalObjectForeignId = this.getLocalObjectForeignId();
            String rhsLocalObjectForeignId;
            rhsLocalObjectForeignId = that.getLocalObjectForeignId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "localObjectForeignId", lhsLocalObjectForeignId), LocatorUtils.property(thatLocator, "localObjectForeignId", rhsLocalObjectForeignId), lhsLocalObjectForeignId, rhsLocalObjectForeignId)) {
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
            String theLocalObjectForeignId;
            theLocalObjectForeignId = this.getLocalObjectForeignId();
            strategy.appendField(locator, this, "localObjectForeignId", buffer, theLocalObjectForeignId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theLocalObjectForeignId;
            theLocalObjectForeignId = this.getLocalObjectForeignId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localObjectForeignId", theLocalObjectForeignId), currentHashCode, theLocalObjectForeignId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
