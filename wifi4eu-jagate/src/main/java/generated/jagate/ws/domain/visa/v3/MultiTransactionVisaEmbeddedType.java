
package generated.jagate.ws.domain.visa.v3;

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
 * <p>Java class for MultiTransactionVisaEmbeddedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultiTransactionVisaEmbeddedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ABACVisas" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v3}VisaMultiTransactionHeaderType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiTransactionVisaEmbeddedType", propOrder = {
    "abacVisas"
})
public class MultiTransactionVisaEmbeddedType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ABACVisas", required = true)
    protected List<VisaMultiTransactionHeaderType> abacVisas;

    /**
     * Gets the value of the abacVisas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abacVisas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getABACVisas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VisaMultiTransactionHeaderType }
     * 
     * 
     */
    public List<VisaMultiTransactionHeaderType> getABACVisas() {
        if (abacVisas == null) {
            abacVisas = new ArrayList<VisaMultiTransactionHeaderType>();
        }
        return this.abacVisas;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof MultiTransactionVisaEmbeddedType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final MultiTransactionVisaEmbeddedType that = ((MultiTransactionVisaEmbeddedType) object);
        {
            List<VisaMultiTransactionHeaderType> lhsABACVisas;
            lhsABACVisas = (((this.abacVisas!= null)&&(!this.abacVisas.isEmpty()))?this.getABACVisas():null);
            List<VisaMultiTransactionHeaderType> rhsABACVisas;
            rhsABACVisas = (((that.abacVisas!= null)&&(!that.abacVisas.isEmpty()))?that.getABACVisas():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "abacVisas", lhsABACVisas), LocatorUtils.property(thatLocator, "abacVisas", rhsABACVisas), lhsABACVisas, rhsABACVisas)) {
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
            List<VisaMultiTransactionHeaderType> theABACVisas;
            theABACVisas = (((this.abacVisas!= null)&&(!this.abacVisas.isEmpty()))?this.getABACVisas():null);
            strategy.appendField(locator, this, "abacVisas", buffer, theABACVisas);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<VisaMultiTransactionHeaderType> theABACVisas;
            theABACVisas = (((this.abacVisas!= null)&&(!this.abacVisas.isEmpty()))?this.getABACVisas():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "abacVisas", theABACVisas), currentHashCode, theABACVisas);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
