
package eu.europa.ec.rdg.jagate.ws.domain.transaction.v1;

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
 * <p>Java class for GetROStatusRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetROStatusRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="localObjectForeigId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetROStatusRequestType", propOrder = {
    "localObjectForeigId"
})
public class GetROStatusRequestType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String localObjectForeigId;

    /**
     * Gets the value of the localObjectForeigId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalObjectForeigId() {
        return localObjectForeigId;
    }

    /**
     * Sets the value of the localObjectForeigId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalObjectForeigId(String value) {
        this.localObjectForeigId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetROStatusRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetROStatusRequestType that = ((GetROStatusRequestType) object);
        {
            String lhsLocalObjectForeigId;
            lhsLocalObjectForeigId = this.getLocalObjectForeigId();
            String rhsLocalObjectForeigId;
            rhsLocalObjectForeigId = that.getLocalObjectForeigId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "localObjectForeigId", lhsLocalObjectForeigId), LocatorUtils.property(thatLocator, "localObjectForeigId", rhsLocalObjectForeigId), lhsLocalObjectForeigId, rhsLocalObjectForeigId)) {
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
            String theLocalObjectForeigId;
            theLocalObjectForeigId = this.getLocalObjectForeigId();
            strategy.appendField(locator, this, "localObjectForeigId", buffer, theLocalObjectForeigId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theLocalObjectForeigId;
            theLocalObjectForeigId = this.getLocalObjectForeigId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localObjectForeigId", theLocalObjectForeigId), currentHashCode, theLocalObjectForeigId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
