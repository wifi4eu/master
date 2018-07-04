
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
 * <p>Java class for GetBankAccountByPicRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBankAccountByPicRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pic" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBankAccountByPicRequestType", propOrder = {
    "pic"
})
public class GetBankAccountByPicRequestType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<String> pic;

    /**
     * Gets the value of the pic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPic() {
        if (pic == null) {
            pic = new ArrayList<String>();
        }
        return this.pic;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetBankAccountByPicRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetBankAccountByPicRequestType that = ((GetBankAccountByPicRequestType) object);
        {
            List<String> lhsPic;
            lhsPic = (((this.pic!= null)&&(!this.pic.isEmpty()))?this.getPic():null);
            List<String> rhsPic;
            rhsPic = (((that.pic!= null)&&(!that.pic.isEmpty()))?that.getPic():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pic", lhsPic), LocatorUtils.property(thatLocator, "pic", rhsPic), lhsPic, rhsPic)) {
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
            List<String> thePic;
            thePic = (((this.pic!= null)&&(!this.pic.isEmpty()))?this.getPic():null);
            strategy.appendField(locator, this, "pic", buffer, thePic);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<String> thePic;
            thePic = (((this.pic!= null)&&(!this.pic.isEmpty()))?this.getPic():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pic", thePic), currentHashCode, thePic);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
