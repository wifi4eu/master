
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * <p>Java class for AttachmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttachmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attachmentType" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="kind" type="{http://ec.europa.eu/research/fp/model/document/V5}KindType"/>
 *         &lt;element name="contentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attachmentName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userReadableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rendition" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="externalized" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="createUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Attributes" type="{http://ec.europa.eu/research/fp/model/document/V5}AttachmentAttributeListType" minOccurs="0"/>
 *         &lt;element name="lastUploadDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentType", propOrder = {
    "id",
    "attachmentType",
    "language",
    "kind",
    "contentType",
    "attachmentName",
    "userReadableName",
    "rendition",
    "extension",
    "externalized",
    "createUser",
    "createDate",
    "attributes",
    "lastUploadDate"
})
public class AttachmentType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(required = true)
    protected CodeRefType attachmentType;
    @XmlElement(required = true)
    protected String language;
    @XmlElement(required = true)
    protected KindType kind;
    @XmlElement(required = true)
    protected String contentType;
    @XmlElement(required = true)
    protected String attachmentName;
    protected String userReadableName;
    protected boolean rendition;
    protected String extension;
    protected Boolean externalized;
    protected String createUser;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    @XmlElement(name = "Attributes")
    protected AttachmentAttributeListType attributes;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUploadDate;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the attachmentType property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getAttachmentType() {
        return attachmentType;
    }

    /**
     * Sets the value of the attachmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setAttachmentType(CodeRefType value) {
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
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link KindType }
     *     
     */
    public KindType getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link KindType }
     *     
     */
    public void setKind(KindType value) {
        this.kind = value;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    /**
     * Gets the value of the attachmentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     * Sets the value of the attachmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentName(String value) {
        this.attachmentName = value;
    }

    /**
     * Gets the value of the userReadableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserReadableName() {
        return userReadableName;
    }

    /**
     * Sets the value of the userReadableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserReadableName(String value) {
        this.userReadableName = value;
    }

    /**
     * Gets the value of the rendition property.
     * 
     */
    public boolean isRendition() {
        return rendition;
    }

    /**
     * Sets the value of the rendition property.
     * 
     */
    public void setRendition(boolean value) {
        this.rendition = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtension(String value) {
        this.extension = value;
    }

    /**
     * Gets the value of the externalized property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExternalized() {
        return externalized;
    }

    /**
     * Sets the value of the externalized property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExternalized(Boolean value) {
        this.externalized = value;
    }

    /**
     * Gets the value of the createUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * Sets the value of the createUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateUser(String value) {
        this.createUser = value;
    }

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentAttributeListType }
     *     
     */
    public AttachmentAttributeListType getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentAttributeListType }
     *     
     */
    public void setAttributes(AttachmentAttributeListType value) {
        this.attributes = value;
    }

    /**
     * Gets the value of the lastUploadDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUploadDate() {
        return lastUploadDate;
    }

    /**
     * Sets the value of the lastUploadDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUploadDate(XMLGregorianCalendar value) {
        this.lastUploadDate = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AttachmentType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AttachmentType that = ((AttachmentType) object);
        {
            String lhsId;
            lhsId = this.getId();
            String rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            CodeRefType lhsAttachmentType;
            lhsAttachmentType = this.getAttachmentType();
            CodeRefType rhsAttachmentType;
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
            KindType lhsKind;
            lhsKind = this.getKind();
            KindType rhsKind;
            rhsKind = that.getKind();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "kind", lhsKind), LocatorUtils.property(thatLocator, "kind", rhsKind), lhsKind, rhsKind)) {
                return false;
            }
        }
        {
            String lhsContentType;
            lhsContentType = this.getContentType();
            String rhsContentType;
            rhsContentType = that.getContentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentType", lhsContentType), LocatorUtils.property(thatLocator, "contentType", rhsContentType), lhsContentType, rhsContentType)) {
                return false;
            }
        }
        {
            String lhsAttachmentName;
            lhsAttachmentName = this.getAttachmentName();
            String rhsAttachmentName;
            rhsAttachmentName = that.getAttachmentName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attachmentName", lhsAttachmentName), LocatorUtils.property(thatLocator, "attachmentName", rhsAttachmentName), lhsAttachmentName, rhsAttachmentName)) {
                return false;
            }
        }
        {
            String lhsUserReadableName;
            lhsUserReadableName = this.getUserReadableName();
            String rhsUserReadableName;
            rhsUserReadableName = that.getUserReadableName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userReadableName", lhsUserReadableName), LocatorUtils.property(thatLocator, "userReadableName", rhsUserReadableName), lhsUserReadableName, rhsUserReadableName)) {
                return false;
            }
        }
        {
            boolean lhsRendition;
            lhsRendition = (true?this.isRendition():false);
            boolean rhsRendition;
            rhsRendition = (true?that.isRendition():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "rendition", lhsRendition), LocatorUtils.property(thatLocator, "rendition", rhsRendition), lhsRendition, rhsRendition)) {
                return false;
            }
        }
        {
            String lhsExtension;
            lhsExtension = this.getExtension();
            String rhsExtension;
            rhsExtension = that.getExtension();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extension", lhsExtension), LocatorUtils.property(thatLocator, "extension", rhsExtension), lhsExtension, rhsExtension)) {
                return false;
            }
        }
        {
            Boolean lhsExternalized;
            lhsExternalized = this.isExternalized();
            Boolean rhsExternalized;
            rhsExternalized = that.isExternalized();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalized", lhsExternalized), LocatorUtils.property(thatLocator, "externalized", rhsExternalized), lhsExternalized, rhsExternalized)) {
                return false;
            }
        }
        {
            String lhsCreateUser;
            lhsCreateUser = this.getCreateUser();
            String rhsCreateUser;
            rhsCreateUser = that.getCreateUser();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "createUser", lhsCreateUser), LocatorUtils.property(thatLocator, "createUser", rhsCreateUser), lhsCreateUser, rhsCreateUser)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsCreateDate;
            lhsCreateDate = this.getCreateDate();
            XMLGregorianCalendar rhsCreateDate;
            rhsCreateDate = that.getCreateDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "createDate", lhsCreateDate), LocatorUtils.property(thatLocator, "createDate", rhsCreateDate), lhsCreateDate, rhsCreateDate)) {
                return false;
            }
        }
        {
            AttachmentAttributeListType lhsAttributes;
            lhsAttributes = this.getAttributes();
            AttachmentAttributeListType rhsAttributes;
            rhsAttributes = that.getAttributes();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attributes", lhsAttributes), LocatorUtils.property(thatLocator, "attributes", rhsAttributes), lhsAttributes, rhsAttributes)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsLastUploadDate;
            lhsLastUploadDate = this.getLastUploadDate();
            XMLGregorianCalendar rhsLastUploadDate;
            rhsLastUploadDate = that.getLastUploadDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastUploadDate", lhsLastUploadDate), LocatorUtils.property(thatLocator, "lastUploadDate", rhsLastUploadDate), lhsLastUploadDate, rhsLastUploadDate)) {
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
            String theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            CodeRefType theAttachmentType;
            theAttachmentType = this.getAttachmentType();
            strategy.appendField(locator, this, "attachmentType", buffer, theAttachmentType);
        }
        {
            String theLanguage;
            theLanguage = this.getLanguage();
            strategy.appendField(locator, this, "language", buffer, theLanguage);
        }
        {
            KindType theKind;
            theKind = this.getKind();
            strategy.appendField(locator, this, "kind", buffer, theKind);
        }
        {
            String theContentType;
            theContentType = this.getContentType();
            strategy.appendField(locator, this, "contentType", buffer, theContentType);
        }
        {
            String theAttachmentName;
            theAttachmentName = this.getAttachmentName();
            strategy.appendField(locator, this, "attachmentName", buffer, theAttachmentName);
        }
        {
            String theUserReadableName;
            theUserReadableName = this.getUserReadableName();
            strategy.appendField(locator, this, "userReadableName", buffer, theUserReadableName);
        }
        {
            boolean theRendition;
            theRendition = (true?this.isRendition():false);
            strategy.appendField(locator, this, "rendition", buffer, theRendition);
        }
        {
            String theExtension;
            theExtension = this.getExtension();
            strategy.appendField(locator, this, "extension", buffer, theExtension);
        }
        {
            Boolean theExternalized;
            theExternalized = this.isExternalized();
            strategy.appendField(locator, this, "externalized", buffer, theExternalized);
        }
        {
            String theCreateUser;
            theCreateUser = this.getCreateUser();
            strategy.appendField(locator, this, "createUser", buffer, theCreateUser);
        }
        {
            XMLGregorianCalendar theCreateDate;
            theCreateDate = this.getCreateDate();
            strategy.appendField(locator, this, "createDate", buffer, theCreateDate);
        }
        {
            AttachmentAttributeListType theAttributes;
            theAttributes = this.getAttributes();
            strategy.appendField(locator, this, "attributes", buffer, theAttributes);
        }
        {
            XMLGregorianCalendar theLastUploadDate;
            theLastUploadDate = this.getLastUploadDate();
            strategy.appendField(locator, this, "lastUploadDate", buffer, theLastUploadDate);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            CodeRefType theAttachmentType;
            theAttachmentType = this.getAttachmentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentType", theAttachmentType), currentHashCode, theAttachmentType);
        }
        {
            String theLanguage;
            theLanguage = this.getLanguage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "language", theLanguage), currentHashCode, theLanguage);
        }
        {
            KindType theKind;
            theKind = this.getKind();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "kind", theKind), currentHashCode, theKind);
        }
        {
            String theContentType;
            theContentType = this.getContentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentType", theContentType), currentHashCode, theContentType);
        }
        {
            String theAttachmentName;
            theAttachmentName = this.getAttachmentName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentName", theAttachmentName), currentHashCode, theAttachmentName);
        }
        {
            String theUserReadableName;
            theUserReadableName = this.getUserReadableName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userReadableName", theUserReadableName), currentHashCode, theUserReadableName);
        }
        {
            boolean theRendition;
            theRendition = (true?this.isRendition():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "rendition", theRendition), currentHashCode, theRendition);
        }
        {
            String theExtension;
            theExtension = this.getExtension();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extension", theExtension), currentHashCode, theExtension);
        }
        {
            Boolean theExternalized;
            theExternalized = this.isExternalized();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalized", theExternalized), currentHashCode, theExternalized);
        }
        {
            String theCreateUser;
            theCreateUser = this.getCreateUser();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "createUser", theCreateUser), currentHashCode, theCreateUser);
        }
        {
            XMLGregorianCalendar theCreateDate;
            theCreateDate = this.getCreateDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "createDate", theCreateDate), currentHashCode, theCreateDate);
        }
        {
            AttachmentAttributeListType theAttributes;
            theAttributes = this.getAttributes();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attributes", theAttributes), currentHashCode, theAttributes);
        }
        {
            XMLGregorianCalendar theLastUploadDate;
            theLastUploadDate = this.getLastUploadDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastUploadDate", theLastUploadDate), currentHashCode, theLastUploadDate);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
