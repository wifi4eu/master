
package eu.europa.ec.research.fp.model.legalentity.v11;

import java.math.BigInteger;
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
 * <p>Java class for AnalyticalMetricType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnalyticalMetricType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Quote" type="{http://ec.europa.eu/research/fp/model/base/V1}CountType" minOccurs="0"/>
 *         &lt;element name="Qualification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalyticalMetricType", propOrder = {
    "quote",
    "qualification"
})
public class AnalyticalMetricType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Quote")
    protected BigInteger quote;
    @XmlElement(name = "Qualification")
    protected String qualification;

    /**
     * Gets the value of the quote property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuote() {
        return quote;
    }

    /**
     * Sets the value of the quote property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuote(BigInteger value) {
        this.quote = value;
    }

    /**
     * Gets the value of the qualification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * Sets the value of the qualification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualification(String value) {
        this.qualification = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AnalyticalMetricType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AnalyticalMetricType that = ((AnalyticalMetricType) object);
        {
            BigInteger lhsQuote;
            lhsQuote = this.getQuote();
            BigInteger rhsQuote;
            rhsQuote = that.getQuote();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "quote", lhsQuote), LocatorUtils.property(thatLocator, "quote", rhsQuote), lhsQuote, rhsQuote)) {
                return false;
            }
        }
        {
            String lhsQualification;
            lhsQualification = this.getQualification();
            String rhsQualification;
            rhsQualification = that.getQualification();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "qualification", lhsQualification), LocatorUtils.property(thatLocator, "qualification", rhsQualification), lhsQualification, rhsQualification)) {
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
            BigInteger theQuote;
            theQuote = this.getQuote();
            strategy.appendField(locator, this, "quote", buffer, theQuote);
        }
        {
            String theQualification;
            theQualification = this.getQualification();
            strategy.appendField(locator, this, "qualification", buffer, theQualification);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            BigInteger theQuote;
            theQuote = this.getQuote();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "quote", theQuote), currentHashCode, theQuote);
        }
        {
            String theQualification;
            theQualification = this.getQualification();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "qualification", theQualification), currentHashCode, theQualification);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
