
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
 * <p>Java class for GetAllBankAccountsByAbacIdRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAllBankAccountsByAbacIdRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="abacId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllBankAccountsByAbacIdRequestType", propOrder = {
    "abacId"
})
public class GetAllBankAccountsByAbacIdRequestType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String abacId;

    /**
     * Gets the value of the abacId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbacId() {
        return abacId;
    }

    /**
     * Sets the value of the abacId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbacId(String value) {
        this.abacId = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetAllBankAccountsByAbacIdRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetAllBankAccountsByAbacIdRequestType that = ((GetAllBankAccountsByAbacIdRequestType) object);
        {
            String lhsAbacId;
            lhsAbacId = this.getAbacId();
            String rhsAbacId;
            rhsAbacId = that.getAbacId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "abacId", lhsAbacId), LocatorUtils.property(thatLocator, "abacId", rhsAbacId), lhsAbacId, rhsAbacId)) {
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
            String theAbacId;
            theAbacId = this.getAbacId();
            strategy.appendField(locator, this, "abacId", buffer, theAbacId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theAbacId;
            theAbacId = this.getAbacId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "abacId", theAbacId), currentHashCode, theAbacId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
