
package generated.jagate.model;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for GetEwsByFelIdRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetEwsByFelIdRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="felId" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEwsByFelIdRequestType", propOrder = {
    "felId"
})
public class GetEwsByFelIdRequestType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<String> felId;

    /**
     * Gets the value of the felId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the felId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFelId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFelId() {
        if (felId == null) {
            felId = new ArrayList<String>();
        }
        return this.felId;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetEwsByFelIdRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetEwsByFelIdRequestType that = ((GetEwsByFelIdRequestType) object);
        {
            List<String> lhsFelId;
            lhsFelId = (((this.felId!= null)&&(!this.felId.isEmpty()))?this.getFelId():null);
            List<String> rhsFelId;
            rhsFelId = (((that.felId!= null)&&(!that.felId.isEmpty()))?that.getFelId():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "felId", lhsFelId), LocatorUtils.property(thatLocator, "felId", rhsFelId), lhsFelId, rhsFelId)) {
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
            List<String> theFelId;
            theFelId = (((this.felId!= null)&&(!this.felId.isEmpty()))?this.getFelId():null);
            strategy.appendField(locator, this, "felId", buffer, theFelId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<String> theFelId;
            theFelId = (((this.felId!= null)&&(!this.felId.isEmpty()))?this.getFelId():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "felId", theFelId), currentHashCode, theFelId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
