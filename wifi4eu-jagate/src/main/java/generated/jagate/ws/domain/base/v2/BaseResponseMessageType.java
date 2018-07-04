
package generated.jagate.ws.domain.base.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 * <p>Java class for BaseResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseResponseMessageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}AbstractResponseMessageType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}LocObjForeignId"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResponseMessageType", propOrder = {
    "locObjForeignId"
})
@XmlSeeAlso({
    IdentifiedResponseMessageType.class
})
public class BaseResponseMessageType
    extends AbstractResponseMessageType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LocObjForeignId", required = true)
    protected String locObjForeignId;

    /**
     * Gets the value of the locObjForeignId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocObjForeignId() {
        return locObjForeignId;
    }

    /**
     * Sets the value of the locObjForeignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocObjForeignId(String value) {
        this.locObjForeignId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BaseResponseMessageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final BaseResponseMessageType that = ((BaseResponseMessageType) object);
        {
            String lhsLocObjForeignId;
            lhsLocObjForeignId = this.getLocObjForeignId();
            String rhsLocObjForeignId;
            rhsLocObjForeignId = that.getLocObjForeignId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "locObjForeignId", lhsLocObjForeignId), LocatorUtils.property(thatLocator, "locObjForeignId", rhsLocObjForeignId), lhsLocObjForeignId, rhsLocObjForeignId)) {
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
            String theLocObjForeignId;
            theLocObjForeignId = this.getLocObjForeignId();
            strategy.appendField(locator, this, "locObjForeignId", buffer, theLocObjForeignId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theLocObjForeignId;
            theLocObjForeignId = this.getLocObjForeignId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "locObjForeignId", theLocObjForeignId), currentHashCode, theLocObjForeignId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
