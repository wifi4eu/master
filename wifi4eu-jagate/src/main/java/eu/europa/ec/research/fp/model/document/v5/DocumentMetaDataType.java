
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for DocumentMetaDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentMetaDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MetaDataRef" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="Value" type="{http://ec.europa.eu/research/fp/model/document/V5}MetaDataValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentMetaDataType", propOrder = {
    "metaDataRef",
    "value"
})
public class DocumentMetaDataType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "MetaDataRef", required = true)
    protected CodeRefType metaDataRef;
    @XmlElement(name = "Value")
    protected MetaDataValueType value;

    /**
     * Gets the value of the metaDataRef property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getMetaDataRef() {
        return metaDataRef;
    }

    /**
     * Sets the value of the metaDataRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setMetaDataRef(CodeRefType value) {
        this.metaDataRef = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link MetaDataValueType }
     *     
     */
    public MetaDataValueType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaDataValueType }
     *     
     */
    public void setValue(MetaDataValueType value) {
        this.value = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentMetaDataType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentMetaDataType that = ((DocumentMetaDataType) object);
        {
            CodeRefType lhsMetaDataRef;
            lhsMetaDataRef = this.getMetaDataRef();
            CodeRefType rhsMetaDataRef;
            rhsMetaDataRef = that.getMetaDataRef();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "metaDataRef", lhsMetaDataRef), LocatorUtils.property(thatLocator, "metaDataRef", rhsMetaDataRef), lhsMetaDataRef, rhsMetaDataRef)) {
                return false;
            }
        }
        {
            MetaDataValueType lhsValue;
            lhsValue = this.getValue();
            MetaDataValueType rhsValue;
            rhsValue = that.getValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "value", lhsValue), LocatorUtils.property(thatLocator, "value", rhsValue), lhsValue, rhsValue)) {
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
            CodeRefType theMetaDataRef;
            theMetaDataRef = this.getMetaDataRef();
            strategy.appendField(locator, this, "metaDataRef", buffer, theMetaDataRef);
        }
        {
            MetaDataValueType theValue;
            theValue = this.getValue();
            strategy.appendField(locator, this, "value", buffer, theValue);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            CodeRefType theMetaDataRef;
            theMetaDataRef = this.getMetaDataRef();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "metaDataRef", theMetaDataRef), currentHashCode, theMetaDataRef);
        }
        {
            MetaDataValueType theValue;
            theValue = this.getValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "value", theValue), currentHashCode, theValue);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
