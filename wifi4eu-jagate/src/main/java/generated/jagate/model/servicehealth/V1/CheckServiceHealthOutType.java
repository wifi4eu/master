
package generated.jagate.model.servicehealth.V1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.servicecontext.V2.ResultContextType;
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
 * <p>Java class for CheckServiceHealthOutType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckServiceHealthOutType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultContext" type="{http://ec.europa.eu/research/fp/model/service-context/V2}ResultContextType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckServiceHealthOutType", propOrder = {
    "resultContext"
})
public class CheckServiceHealthOutType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ResultContext", required = true)
    protected ResultContextType resultContext;

    /**
     * Gets the value of the resultContext property.
     * 
     * @return
     *     possible object is
     *     {@link ResultContextType }
     *     
     */
    public ResultContextType getResultContext() {
        return resultContext;
    }

    /**
     * Sets the value of the resultContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultContextType }
     *     
     */
    public void setResultContext(ResultContextType value) {
        this.resultContext = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CheckServiceHealthOutType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CheckServiceHealthOutType that = ((CheckServiceHealthOutType) object);
        {
            ResultContextType lhsResultContext;
            lhsResultContext = this.getResultContext();
            ResultContextType rhsResultContext;
            rhsResultContext = that.getResultContext();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resultContext", lhsResultContext), LocatorUtils.property(thatLocator, "resultContext", rhsResultContext), lhsResultContext, rhsResultContext)) {
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
            ResultContextType theResultContext;
            theResultContext = this.getResultContext();
            strategy.appendField(locator, this, "resultContext", buffer, theResultContext);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            ResultContextType theResultContext;
            theResultContext = this.getResultContext();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultContext", theResultContext), currentHashCode, theResultContext);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
