
package generated.jagate.model.base.V1;

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
 * Type used to hold the legal version and legal name of a template (as published by the legal unit), e.g. .
 * 
 * <p>Java class for TemplateLegalInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemplateLegalInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TemplateLegalName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TemplateLegalVersion" type="{http://ec.europa.eu/research/fp/model/base/V1}VersionType"/>
 *         &lt;element name="TemplateImplementationTag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemplateLegalInfoType", propOrder = {
    "templateLegalName",
    "templateLegalVersion",
    "templateImplementationTag"
})
public class TemplateLegalInfoType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "TemplateLegalName", required = true)
    protected String templateLegalName;
    @XmlElement(name = "TemplateLegalVersion", required = true)
    protected VersionType templateLegalVersion;
    @XmlElement(name = "TemplateImplementationTag", required = true)
    protected String templateImplementationTag;

    /**
     * Gets the value of the templateLegalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateLegalName() {
        return templateLegalName;
    }

    /**
     * Sets the value of the templateLegalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateLegalName(String value) {
        this.templateLegalName = value;
    }

    /**
     * Gets the value of the templateLegalVersion property.
     * 
     * @return
     *     possible object is
     *     {@link VersionType }
     *     
     */
    public VersionType getTemplateLegalVersion() {
        return templateLegalVersion;
    }

    /**
     * Sets the value of the templateLegalVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionType }
     *     
     */
    public void setTemplateLegalVersion(VersionType value) {
        this.templateLegalVersion = value;
    }

    /**
     * Gets the value of the templateImplementationTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateImplementationTag() {
        return templateImplementationTag;
    }

    /**
     * Sets the value of the templateImplementationTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateImplementationTag(String value) {
        this.templateImplementationTag = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TemplateLegalInfoType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TemplateLegalInfoType that = ((TemplateLegalInfoType) object);
        {
            String lhsTemplateLegalName;
            lhsTemplateLegalName = this.getTemplateLegalName();
            String rhsTemplateLegalName;
            rhsTemplateLegalName = that.getTemplateLegalName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "templateLegalName", lhsTemplateLegalName), LocatorUtils.property(thatLocator, "templateLegalName", rhsTemplateLegalName), lhsTemplateLegalName, rhsTemplateLegalName)) {
                return false;
            }
        }
        {
            VersionType lhsTemplateLegalVersion;
            lhsTemplateLegalVersion = this.getTemplateLegalVersion();
            VersionType rhsTemplateLegalVersion;
            rhsTemplateLegalVersion = that.getTemplateLegalVersion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "templateLegalVersion", lhsTemplateLegalVersion), LocatorUtils.property(thatLocator, "templateLegalVersion", rhsTemplateLegalVersion), lhsTemplateLegalVersion, rhsTemplateLegalVersion)) {
                return false;
            }
        }
        {
            String lhsTemplateImplementationTag;
            lhsTemplateImplementationTag = this.getTemplateImplementationTag();
            String rhsTemplateImplementationTag;
            rhsTemplateImplementationTag = that.getTemplateImplementationTag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "templateImplementationTag", lhsTemplateImplementationTag), LocatorUtils.property(thatLocator, "templateImplementationTag", rhsTemplateImplementationTag), lhsTemplateImplementationTag, rhsTemplateImplementationTag)) {
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
            String theTemplateLegalName;
            theTemplateLegalName = this.getTemplateLegalName();
            strategy.appendField(locator, this, "templateLegalName", buffer, theTemplateLegalName);
        }
        {
            VersionType theTemplateLegalVersion;
            theTemplateLegalVersion = this.getTemplateLegalVersion();
            strategy.appendField(locator, this, "templateLegalVersion", buffer, theTemplateLegalVersion);
        }
        {
            String theTemplateImplementationTag;
            theTemplateImplementationTag = this.getTemplateImplementationTag();
            strategy.appendField(locator, this, "templateImplementationTag", buffer, theTemplateImplementationTag);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theTemplateLegalName;
            theTemplateLegalName = this.getTemplateLegalName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "templateLegalName", theTemplateLegalName), currentHashCode, theTemplateLegalName);
        }
        {
            VersionType theTemplateLegalVersion;
            theTemplateLegalVersion = this.getTemplateLegalVersion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "templateLegalVersion", theTemplateLegalVersion), currentHashCode, theTemplateLegalVersion);
        }
        {
            String theTemplateImplementationTag;
            theTemplateImplementationTag = this.getTemplateImplementationTag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "templateImplementationTag", theTemplateImplementationTag), currentHashCode, theTemplateImplementationTag);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
