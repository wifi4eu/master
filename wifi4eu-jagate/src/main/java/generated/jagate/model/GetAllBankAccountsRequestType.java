
package generated.jagate.model;

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
 * <p>Java class for GetAllBankAccountsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAllBankAccountsRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="pic" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *           &lt;element name="fel" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
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
@XmlType(name = "GetAllBankAccountsRequestType", propOrder = {
    "pic",
    "fel"
})
public class GetAllBankAccountsRequestType
    implements Equals, HashCode, ToString
{

    protected String pic;
    protected String fel;

    /**
     * Gets the value of the pic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPic() {
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
    public void setPic(String value) {
        this.pic = value;
    }

    /**
     * Gets the value of the fel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFel() {
        return fel;
    }

    /**
     * Sets the value of the fel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFel(String value) {
        this.fel = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetAllBankAccountsRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetAllBankAccountsRequestType that = ((GetAllBankAccountsRequestType) object);
        {
            String lhsPic;
            lhsPic = this.getPic();
            String rhsPic;
            rhsPic = that.getPic();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pic", lhsPic), LocatorUtils.property(thatLocator, "pic", rhsPic), lhsPic, rhsPic)) {
                return false;
            }
        }
        {
            String lhsFel;
            lhsFel = this.getFel();
            String rhsFel;
            rhsFel = that.getFel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fel", lhsFel), LocatorUtils.property(thatLocator, "fel", rhsFel), lhsFel, rhsFel)) {
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
            String thePic;
            thePic = this.getPic();
            strategy.appendField(locator, this, "pic", buffer, thePic);
        }
        {
            String theFel;
            theFel = this.getFel();
            strategy.appendField(locator, this, "fel", buffer, theFel);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String thePic;
            thePic = this.getPic();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pic", thePic), currentHashCode, thePic);
        }
        {
            String theFel;
            theFel = this.getFel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fel", theFel), currentHashCode, theFel);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
