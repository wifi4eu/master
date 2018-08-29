
package generated.hrs.ws.model;

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
 * <p>Java class for ScannedItemToAdd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScannedItemToAdd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="language" type="{http://ec.europa.eu/sg/hrs/types}LanguageCode"/>
 *         &lt;element name="kind" type="{http://ec.europa.eu/sg/hrs/types}ItemKindToAdd" minOccurs="0"/>
 *         &lt;element name="externalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="translations" type="{http://ec.europa.eu/sg/hrs/types}TranslationsToAdd" minOccurs="0"/>
 *         &lt;element name="toStamp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScannedItemToAdd", propOrder = {
    "name",
    "language",
    "kind",
    "externalReference",
    "translations",
    "toStamp"
})
public class ScannedItemToAdd implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true, defaultValue = "NS")
    protected String language;
    @XmlElement(defaultValue = "MAIN")
    protected ItemKindToAdd kind;
    protected String externalReference;
    protected TranslationsToAdd translations;
    @XmlElement(defaultValue = "true")
    protected Boolean toStamp;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link ItemKindToAdd }
     *     
     */
    public ItemKindToAdd getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemKindToAdd }
     *     
     */
    public void setKind(ItemKindToAdd value) {
        this.kind = value;
    }

    /**
     * Gets the value of the externalReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalReference() {
        return externalReference;
    }

    /**
     * Sets the value of the externalReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalReference(String value) {
        this.externalReference = value;
    }

    /**
     * Gets the value of the translations property.
     * 
     * @return
     *     possible object is
     *     {@link TranslationsToAdd }
     *     
     */
    public TranslationsToAdd getTranslations() {
        return translations;
    }

    /**
     * Sets the value of the translations property.
     * 
     * @param value
     *     allowed object is
     *     {@link TranslationsToAdd }
     *     
     */
    public void setTranslations(TranslationsToAdd value) {
        this.translations = value;
    }

    /**
     * Gets the value of the toStamp property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isToStamp() {
        return toStamp;
    }

    /**
     * Sets the value of the toStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setToStamp(Boolean value) {
        this.toStamp = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ScannedItemToAdd)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ScannedItemToAdd that = ((ScannedItemToAdd) object);
        {
            String lhsName;
            lhsName = this.getName();
            String rhsName;
            rhsName = that.getName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                return false;
            }
        }
        {
            String lhsLanguage;
            lhsLanguage = this.getLanguage();
            String rhsLanguage;
            rhsLanguage = that.getLanguage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "language", lhsLanguage), LocatorUtils.property(thatLocator, "language", rhsLanguage), lhsLanguage, rhsLanguage)) {
                return false;
            }
        }
        {
            ItemKindToAdd lhsKind;
            lhsKind = this.getKind();
            ItemKindToAdd rhsKind;
            rhsKind = that.getKind();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "kind", lhsKind), LocatorUtils.property(thatLocator, "kind", rhsKind), lhsKind, rhsKind)) {
                return false;
            }
        }
        {
            String lhsExternalReference;
            lhsExternalReference = this.getExternalReference();
            String rhsExternalReference;
            rhsExternalReference = that.getExternalReference();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalReference", lhsExternalReference), LocatorUtils.property(thatLocator, "externalReference", rhsExternalReference), lhsExternalReference, rhsExternalReference)) {
                return false;
            }
        }
        {
            TranslationsToAdd lhsTranslations;
            lhsTranslations = this.getTranslations();
            TranslationsToAdd rhsTranslations;
            rhsTranslations = that.getTranslations();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "translations", lhsTranslations), LocatorUtils.property(thatLocator, "translations", rhsTranslations), lhsTranslations, rhsTranslations)) {
                return false;
            }
        }
        {
            Boolean lhsToStamp;
            lhsToStamp = this.isToStamp();
            Boolean rhsToStamp;
            rhsToStamp = that.isToStamp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "toStamp", lhsToStamp), LocatorUtils.property(thatLocator, "toStamp", rhsToStamp), lhsToStamp, rhsToStamp)) {
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
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            String theLanguage;
            theLanguage = this.getLanguage();
            strategy.appendField(locator, this, "language", buffer, theLanguage);
        }
        {
            ItemKindToAdd theKind;
            theKind = this.getKind();
            strategy.appendField(locator, this, "kind", buffer, theKind);
        }
        {
            String theExternalReference;
            theExternalReference = this.getExternalReference();
            strategy.appendField(locator, this, "externalReference", buffer, theExternalReference);
        }
        {
            TranslationsToAdd theTranslations;
            theTranslations = this.getTranslations();
            strategy.appendField(locator, this, "translations", buffer, theTranslations);
        }
        {
            Boolean theToStamp;
            theToStamp = this.isToStamp();
            strategy.appendField(locator, this, "toStamp", buffer, theToStamp);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            String theLanguage;
            theLanguage = this.getLanguage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "language", theLanguage), currentHashCode, theLanguage);
        }
        {
            ItemKindToAdd theKind;
            theKind = this.getKind();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "kind", theKind), currentHashCode, theKind);
        }
        {
            String theExternalReference;
            theExternalReference = this.getExternalReference();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalReference", theExternalReference), currentHashCode, theExternalReference);
        }
        {
            TranslationsToAdd theTranslations;
            theTranslations = this.getTranslations();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "translations", theTranslations), currentHashCode, theTranslations);
        }
        {
            Boolean theToStamp;
            theToStamp = this.isToStamp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "toStamp", theToStamp), currentHashCode, theToStamp);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
