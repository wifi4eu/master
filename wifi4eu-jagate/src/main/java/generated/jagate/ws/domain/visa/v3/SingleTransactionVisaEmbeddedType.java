
package generated.jagate.ws.domain.visa.v3;

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
 * <p>Java class for SingleTransactionVisaEmbeddedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SingleTransactionVisaEmbeddedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ABACVisas" type="{http://ec.europa.eu/rdg/jagate/ws/domain/visa/v3}VisaSingleTransactionHeaderType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SingleTransactionVisaEmbeddedType", propOrder = {
    "abacVisas"
})
public class SingleTransactionVisaEmbeddedType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ABACVisas", required = true)
    protected VisaSingleTransactionHeaderType abacVisas;

    /**
     * Gets the value of the abacVisas property.
     * 
     * @return
     *     possible object is
     *     {@link VisaSingleTransactionHeaderType }
     *     
     */
    public VisaSingleTransactionHeaderType getABACVisas() {
        return abacVisas;
    }

    /**
     * Sets the value of the abacVisas property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisaSingleTransactionHeaderType }
     *     
     */
    public void setABACVisas(VisaSingleTransactionHeaderType value) {
        this.abacVisas = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SingleTransactionVisaEmbeddedType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SingleTransactionVisaEmbeddedType that = ((SingleTransactionVisaEmbeddedType) object);
        {
            VisaSingleTransactionHeaderType lhsABACVisas;
            lhsABACVisas = this.getABACVisas();
            VisaSingleTransactionHeaderType rhsABACVisas;
            rhsABACVisas = that.getABACVisas();
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
            VisaSingleTransactionHeaderType theABACVisas;
            theABACVisas = this.getABACVisas();
            strategy.appendField(locator, this, "abacVisas", buffer, theABACVisas);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            VisaSingleTransactionHeaderType theABACVisas;
            theABACVisas = this.getABACVisas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "abacVisas", theABACVisas), currentHashCode, theABACVisas);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
