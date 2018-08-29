
package generated.hrs.ws.model;

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
 * <p>Java class for TranslationsToAdd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TranslationsToAdd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="translation" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="contentId" type="{http://ec.europa.eu/sg/hrs/types}ContentIdType"/>
 *                   &lt;element name="attachmentType" type="{http://ec.europa.eu/sg/hrs/types}AttachmentTypeToAdd"/>
 *                   &lt;element name="language" type="{http://ec.europa.eu/sg/hrs/types}LanguageCode"/>
 *                   &lt;element name="externalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TranslationsToAdd", propOrder = {
    "translation"
})
public class TranslationsToAdd
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<TranslationsToAdd.Translation> translation;

    /**
     * Gets the value of the translation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the translation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTranslation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TranslationsToAdd.Translation }
     * 
     * 
     */
    public List<TranslationsToAdd.Translation> getTranslation() {
        if (translation == null) {
            translation = new ArrayList<TranslationsToAdd.Translation>();
        }
        return this.translation;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TranslationsToAdd)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TranslationsToAdd that = ((TranslationsToAdd) object);
        {
            List<TranslationsToAdd.Translation> lhsTranslation;
            lhsTranslation = (((this.translation!= null)&&(!this.translation.isEmpty()))?this.getTranslation():null);
            List<TranslationsToAdd.Translation> rhsTranslation;
            rhsTranslation = (((that.translation!= null)&&(!that.translation.isEmpty()))?that.getTranslation():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "translation", lhsTranslation), LocatorUtils.property(thatLocator, "translation", rhsTranslation), lhsTranslation, rhsTranslation)) {
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
            List<TranslationsToAdd.Translation> theTranslation;
            theTranslation = (((this.translation!= null)&&(!this.translation.isEmpty()))?this.getTranslation():null);
            strategy.appendField(locator, this, "translation", buffer, theTranslation);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<TranslationsToAdd.Translation> theTranslation;
            theTranslation = (((this.translation!= null)&&(!this.translation.isEmpty()))?this.getTranslation():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "translation", theTranslation), currentHashCode, theTranslation);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="contentId" type="{http://ec.europa.eu/sg/hrs/types}ContentIdType"/>
     *         &lt;element name="attachmentType" type="{http://ec.europa.eu/sg/hrs/types}AttachmentTypeToAdd"/>
     *         &lt;element name="language" type="{http://ec.europa.eu/sg/hrs/types}LanguageCode"/>
     *         &lt;element name="externalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "contentId",
        "attachmentType",
        "language",
        "externalReference"
    })
    public static class Translation
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected String contentId;
        @XmlElement(required = true)
        protected AttachmentTypeToAdd attachmentType;
        @XmlElement(required = true, defaultValue = "NS")
        protected String language;
        protected String externalReference;

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
         * Gets the value of the contentId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContentId() {
            return contentId;
        }

        /**
         * Sets the value of the contentId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContentId(String value) {
            this.contentId = value;
        }

        /**
         * Gets the value of the attachmentType property.
         * 
         * @return
         *     possible object is
         *     {@link AttachmentTypeToAdd }
         *     
         */
        public AttachmentTypeToAdd getAttachmentType() {
            return attachmentType;
        }

        /**
         * Sets the value of the attachmentType property.
         * 
         * @param value
         *     allowed object is
         *     {@link AttachmentTypeToAdd }
         *     
         */
        public void setAttachmentType(AttachmentTypeToAdd value) {
            this.attachmentType = value;
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

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof TranslationsToAdd.Translation)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final TranslationsToAdd.Translation that = ((TranslationsToAdd.Translation) object);
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
                String lhsContentId;
                lhsContentId = this.getContentId();
                String rhsContentId;
                rhsContentId = that.getContentId();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "contentId", lhsContentId), LocatorUtils.property(thatLocator, "contentId", rhsContentId), lhsContentId, rhsContentId)) {
                    return false;
                }
            }
            {
                AttachmentTypeToAdd lhsAttachmentType;
                lhsAttachmentType = this.getAttachmentType();
                AttachmentTypeToAdd rhsAttachmentType;
                rhsAttachmentType = that.getAttachmentType();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "attachmentType", lhsAttachmentType), LocatorUtils.property(thatLocator, "attachmentType", rhsAttachmentType), lhsAttachmentType, rhsAttachmentType)) {
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
                String lhsExternalReference;
                lhsExternalReference = this.getExternalReference();
                String rhsExternalReference;
                rhsExternalReference = that.getExternalReference();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "externalReference", lhsExternalReference), LocatorUtils.property(thatLocator, "externalReference", rhsExternalReference), lhsExternalReference, rhsExternalReference)) {
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
                String theContentId;
                theContentId = this.getContentId();
                strategy.appendField(locator, this, "contentId", buffer, theContentId);
            }
            {
                AttachmentTypeToAdd theAttachmentType;
                theAttachmentType = this.getAttachmentType();
                strategy.appendField(locator, this, "attachmentType", buffer, theAttachmentType);
            }
            {
                String theLanguage;
                theLanguage = this.getLanguage();
                strategy.appendField(locator, this, "language", buffer, theLanguage);
            }
            {
                String theExternalReference;
                theExternalReference = this.getExternalReference();
                strategy.appendField(locator, this, "externalReference", buffer, theExternalReference);
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
                String theContentId;
                theContentId = this.getContentId();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentId", theContentId), currentHashCode, theContentId);
            }
            {
                AttachmentTypeToAdd theAttachmentType;
                theAttachmentType = this.getAttachmentType();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentType", theAttachmentType), currentHashCode, theAttachmentType);
            }
            {
                String theLanguage;
                theLanguage = this.getLanguage();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "language", theLanguage), currentHashCode, theLanguage);
            }
            {
                String theExternalReference;
                theExternalReference = this.getExternalReference();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalReference", theExternalReference), currentHashCode, theExternalReference);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
