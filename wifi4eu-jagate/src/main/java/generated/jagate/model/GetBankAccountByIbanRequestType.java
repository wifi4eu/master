
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
 * <p>Java class for GetBankAccountByIbanRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBankAccountByIbanRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iban" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBankAccountByIbanRequestType", propOrder = {
    "iban"
})
public class GetBankAccountByIbanRequestType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<String> iban;

    /**
     * Gets the value of the iban property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iban property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIban().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIban() {
        if (iban == null) {
            iban = new ArrayList<String>();
        }
        return this.iban;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetBankAccountByIbanRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetBankAccountByIbanRequestType that = ((GetBankAccountByIbanRequestType) object);
        {
            List<String> lhsIban;
            lhsIban = (((this.iban!= null)&&(!this.iban.isEmpty()))?this.getIban():null);
            List<String> rhsIban;
            rhsIban = (((that.iban!= null)&&(!that.iban.isEmpty()))?that.getIban():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "iban", lhsIban), LocatorUtils.property(thatLocator, "iban", rhsIban), lhsIban, rhsIban)) {
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
            List<String> theIban;
            theIban = (((this.iban!= null)&&(!this.iban.isEmpty()))?this.getIban():null);
            strategy.appendField(locator, this, "iban", buffer, theIban);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<String> theIban;
            theIban = (((this.iban!= null)&&(!this.iban.isEmpty()))?this.getIban():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "iban", theIban), currentHashCode, theIban);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
