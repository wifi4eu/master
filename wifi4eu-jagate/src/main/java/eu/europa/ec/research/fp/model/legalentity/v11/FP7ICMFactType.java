
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
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
 * <p>Java class for FP7ICMFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FP7ICMFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IndirectCostMethod" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FP7ICMFactType", propOrder = {
    "indirectCostMethod"
})
public class FP7ICMFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "IndirectCostMethod", required = true)
    protected CodeRefType indirectCostMethod;

    /**
     * Gets the value of the indirectCostMethod property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getIndirectCostMethod() {
        return indirectCostMethod;
    }

    /**
     * Sets the value of the indirectCostMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setIndirectCostMethod(CodeRefType value) {
        this.indirectCostMethod = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FP7ICMFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FP7ICMFactType that = ((FP7ICMFactType) object);
        {
            CodeRefType lhsIndirectCostMethod;
            lhsIndirectCostMethod = this.getIndirectCostMethod();
            CodeRefType rhsIndirectCostMethod;
            rhsIndirectCostMethod = that.getIndirectCostMethod();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "indirectCostMethod", lhsIndirectCostMethod), LocatorUtils.property(thatLocator, "indirectCostMethod", rhsIndirectCostMethod), lhsIndirectCostMethod, rhsIndirectCostMethod)) {
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
            CodeRefType theIndirectCostMethod;
            theIndirectCostMethod = this.getIndirectCostMethod();
            strategy.appendField(locator, this, "indirectCostMethod", buffer, theIndirectCostMethod);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            CodeRefType theIndirectCostMethod;
            theIndirectCostMethod = this.getIndirectCostMethod();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indirectCostMethod", theIndirectCostMethod), currentHashCode, theIndirectCostMethod);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
