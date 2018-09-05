
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * An item/attachment
 * 
 * <p>Java class for Item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="language" type="{http://ec.europa.eu/sg/hrs/types}LanguageCode"/>
 *         &lt;element name="attachmentType" type="{http://ec.europa.eu/sg/hrs/types}AttachmentType"/>
 *         &lt;element name="kind" type="{http://ec.europa.eu/sg/hrs/types}ItemKind"/>
 *         &lt;element name="isScanWithoutContent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="modificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="externalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pageNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="renditionStatus" type="{http://ec.europa.eu/sg/hrs/types}RenditionStatus" minOccurs="0"/>
 *         &lt;element name="checkedOut" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="translations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="translation" type="{http://ec.europa.eu/sg/hrs/types}Item" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="contentSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="versioned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="versionLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contentId" type="{http://ec.europa.eu/sg/hrs/types}ContentIdType" minOccurs="0"/>
 *         &lt;element name="sha256" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="searchSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="versions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{http://ec.europa.eu/sg/hrs/types}Item" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "Item", propOrder = {
    "itemId",
    "name",
    "language",
    "attachmentType",
    "kind",
    "isScanWithoutContent",
    "modificationDate",
    "externalReference",
    "contentType",
    "pageNo",
    "renditionStatus",
    "checkedOut",
    "translations",
    "contentSize",
    "versioned",
    "versionLabel",
    "mimeType",
    "contentId",
    "sha256",
    "searchSummary",
    "versions"
})
public class Item
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String itemId;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String language;
    @XmlElement(required = true)
    protected AttachmentType attachmentType;
    @XmlElement(required = true)
    protected ItemKind kind;
    protected boolean isScanWithoutContent;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modificationDate;
    protected String externalReference;
    protected String contentType;
    protected Integer pageNo;
    protected RenditionStatus renditionStatus;
    protected Item.CheckedOut checkedOut;
    protected Item.Translations translations;
    protected Integer contentSize;
    protected Boolean versioned;
    protected String versionLabel;
    protected String mimeType;
    protected String contentId;
    protected String sha256;
    protected String searchSummary;
    protected Item.Versions versions;

    /**
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemId(String value) {
        this.itemId = value;
    }

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
     * Gets the value of the attachmentType property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentType }
     *     
     */
    public AttachmentType getAttachmentType() {
        return attachmentType;
    }

    /**
     * Sets the value of the attachmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentType }
     *     
     */
    public void setAttachmentType(AttachmentType value) {
        this.attachmentType = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link ItemKind }
     *     
     */
    public ItemKind getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemKind }
     *     
     */
    public void setKind(ItemKind value) {
        this.kind = value;
    }

    /**
     * Gets the value of the isScanWithoutContent property.
     * 
     */
    public boolean isIsScanWithoutContent() {
        return isScanWithoutContent;
    }

    /**
     * Sets the value of the isScanWithoutContent property.
     * 
     */
    public void setIsScanWithoutContent(boolean value) {
        this.isScanWithoutContent = value;
    }

    /**
     * Gets the value of the modificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the value of the modificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModificationDate(XMLGregorianCalendar value) {
        this.modificationDate = value;
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
     * Gets the value of the pageNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * Sets the value of the pageNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPageNo(Integer value) {
        this.pageNo = value;
    }

    /**
     * Gets the value of the renditionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RenditionStatus }
     *     
     */
    public RenditionStatus getRenditionStatus() {
        return renditionStatus;
    }

    /**
     * Sets the value of the renditionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenditionStatus }
     *     
     */
    public void setRenditionStatus(RenditionStatus value) {
        this.renditionStatus = value;
    }

    /**
     * Gets the value of the checkedOut property.
     * 
     * @return
     *     possible object is
     *     {@link Item.CheckedOut }
     *     
     */
    public Item.CheckedOut getCheckedOut() {
        return checkedOut;
    }

    /**
     * Sets the value of the checkedOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item.CheckedOut }
     *     
     */
    public void setCheckedOut(Item.CheckedOut value) {
        this.checkedOut = value;
    }

    /**
     * Gets the value of the translations property.
     * 
     * @return
     *     possible object is
     *     {@link Item.Translations }
     *     
     */
    public Item.Translations getTranslations() {
        return translations;
    }

    /**
     * Sets the value of the translations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item.Translations }
     *     
     */
    public void setTranslations(Item.Translations value) {
        this.translations = value;
    }

    /**
     * Gets the value of the contentSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getContentSize() {
        return contentSize;
    }

    /**
     * Sets the value of the contentSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setContentSize(Integer value) {
        this.contentSize = value;
    }

    /**
     * Gets the value of the versioned property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVersioned() {
        return versioned;
    }

    /**
     * Sets the value of the versioned property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVersioned(Boolean value) {
        this.versioned = value;
    }

    /**
     * Gets the value of the versionLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionLabel() {
        return versionLabel;
    }

    /**
     * Sets the value of the versionLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionLabel(String value) {
        this.versionLabel = value;
    }

    /**
     * Gets the value of the mimeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the value of the mimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMimeType(String value) {
        this.mimeType = value;
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
     * Gets the value of the sha256 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSha256() {
        return sha256;
    }

    /**
     * Sets the value of the sha256 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSha256(String value) {
        this.sha256 = value;
    }

    /**
     * Gets the value of the searchSummary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchSummary() {
        return searchSummary;
    }

    /**
     * Sets the value of the searchSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchSummary(String value) {
        this.searchSummary = value;
    }

    /**
     * Gets the value of the versions property.
     * 
     * @return
     *     possible object is
     *     {@link Item.Versions }
     *     
     */
    public Item.Versions getVersions() {
        return versions;
    }

    /**
     * Sets the value of the versions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item.Versions }
     *     
     */
    public void setVersions(Item.Versions value) {
        this.versions = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Item)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Item that = ((Item) object);
        {
            String lhsItemId;
            lhsItemId = this.getItemId();
            String rhsItemId;
            rhsItemId = that.getItemId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemId", lhsItemId), LocatorUtils.property(thatLocator, "itemId", rhsItemId), lhsItemId, rhsItemId)) {
                return false;
            }
        }
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
            AttachmentType lhsAttachmentType;
            lhsAttachmentType = this.getAttachmentType();
            AttachmentType rhsAttachmentType;
            rhsAttachmentType = that.getAttachmentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attachmentType", lhsAttachmentType), LocatorUtils.property(thatLocator, "attachmentType", rhsAttachmentType), lhsAttachmentType, rhsAttachmentType)) {
                return false;
            }
        }
        {
            ItemKind lhsKind;
            lhsKind = this.getKind();
            ItemKind rhsKind;
            rhsKind = that.getKind();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "kind", lhsKind), LocatorUtils.property(thatLocator, "kind", rhsKind), lhsKind, rhsKind)) {
                return false;
            }
        }
        {
            boolean lhsIsScanWithoutContent;
            lhsIsScanWithoutContent = (true?this.isIsScanWithoutContent():false);
            boolean rhsIsScanWithoutContent;
            rhsIsScanWithoutContent = (true?that.isIsScanWithoutContent():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "isScanWithoutContent", lhsIsScanWithoutContent), LocatorUtils.property(thatLocator, "isScanWithoutContent", rhsIsScanWithoutContent), lhsIsScanWithoutContent, rhsIsScanWithoutContent)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsModificationDate;
            lhsModificationDate = this.getModificationDate();
            XMLGregorianCalendar rhsModificationDate;
            rhsModificationDate = that.getModificationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "modificationDate", lhsModificationDate), LocatorUtils.property(thatLocator, "modificationDate", rhsModificationDate), lhsModificationDate, rhsModificationDate)) {
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
            String lhsContentType;
            lhsContentType = this.getContentType();
            String rhsContentType;
            rhsContentType = that.getContentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentType", lhsContentType), LocatorUtils.property(thatLocator, "contentType", rhsContentType), lhsContentType, rhsContentType)) {
                return false;
            }
        }
        {
            Integer lhsPageNo;
            lhsPageNo = this.getPageNo();
            Integer rhsPageNo;
            rhsPageNo = that.getPageNo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pageNo", lhsPageNo), LocatorUtils.property(thatLocator, "pageNo", rhsPageNo), lhsPageNo, rhsPageNo)) {
                return false;
            }
        }
        {
            RenditionStatus lhsRenditionStatus;
            lhsRenditionStatus = this.getRenditionStatus();
            RenditionStatus rhsRenditionStatus;
            rhsRenditionStatus = that.getRenditionStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "renditionStatus", lhsRenditionStatus), LocatorUtils.property(thatLocator, "renditionStatus", rhsRenditionStatus), lhsRenditionStatus, rhsRenditionStatus)) {
                return false;
            }
        }
        {
            Item.CheckedOut lhsCheckedOut;
            lhsCheckedOut = this.getCheckedOut();
            Item.CheckedOut rhsCheckedOut;
            rhsCheckedOut = that.getCheckedOut();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "checkedOut", lhsCheckedOut), LocatorUtils.property(thatLocator, "checkedOut", rhsCheckedOut), lhsCheckedOut, rhsCheckedOut)) {
                return false;
            }
        }
        {
            Item.Translations lhsTranslations;
            lhsTranslations = this.getTranslations();
            Item.Translations rhsTranslations;
            rhsTranslations = that.getTranslations();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "translations", lhsTranslations), LocatorUtils.property(thatLocator, "translations", rhsTranslations), lhsTranslations, rhsTranslations)) {
                return false;
            }
        }
        {
            Integer lhsContentSize;
            lhsContentSize = this.getContentSize();
            Integer rhsContentSize;
            rhsContentSize = that.getContentSize();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentSize", lhsContentSize), LocatorUtils.property(thatLocator, "contentSize", rhsContentSize), lhsContentSize, rhsContentSize)) {
                return false;
            }
        }
        {
            Boolean lhsVersioned;
            lhsVersioned = this.isVersioned();
            Boolean rhsVersioned;
            rhsVersioned = that.isVersioned();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "versioned", lhsVersioned), LocatorUtils.property(thatLocator, "versioned", rhsVersioned), lhsVersioned, rhsVersioned)) {
                return false;
            }
        }
        {
            String lhsVersionLabel;
            lhsVersionLabel = this.getVersionLabel();
            String rhsVersionLabel;
            rhsVersionLabel = that.getVersionLabel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "versionLabel", lhsVersionLabel), LocatorUtils.property(thatLocator, "versionLabel", rhsVersionLabel), lhsVersionLabel, rhsVersionLabel)) {
                return false;
            }
        }
        {
            String lhsMimeType;
            lhsMimeType = this.getMimeType();
            String rhsMimeType;
            rhsMimeType = that.getMimeType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mimeType", lhsMimeType), LocatorUtils.property(thatLocator, "mimeType", rhsMimeType), lhsMimeType, rhsMimeType)) {
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
            String lhsSha256;
            lhsSha256 = this.getSha256();
            String rhsSha256;
            rhsSha256 = that.getSha256();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sha256", lhsSha256), LocatorUtils.property(thatLocator, "sha256", rhsSha256), lhsSha256, rhsSha256)) {
                return false;
            }
        }
        {
            String lhsSearchSummary;
            lhsSearchSummary = this.getSearchSummary();
            String rhsSearchSummary;
            rhsSearchSummary = that.getSearchSummary();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "searchSummary", lhsSearchSummary), LocatorUtils.property(thatLocator, "searchSummary", rhsSearchSummary), lhsSearchSummary, rhsSearchSummary)) {
                return false;
            }
        }
        {
            Item.Versions lhsVersions;
            lhsVersions = this.getVersions();
            Item.Versions rhsVersions;
            rhsVersions = that.getVersions();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "versions", lhsVersions), LocatorUtils.property(thatLocator, "versions", rhsVersions), lhsVersions, rhsVersions)) {
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
            String theItemId;
            theItemId = this.getItemId();
            strategy.appendField(locator, this, "itemId", buffer, theItemId);
        }
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
            AttachmentType theAttachmentType;
            theAttachmentType = this.getAttachmentType();
            strategy.appendField(locator, this, "attachmentType", buffer, theAttachmentType);
        }
        {
            ItemKind theKind;
            theKind = this.getKind();
            strategy.appendField(locator, this, "kind", buffer, theKind);
        }
        {
            boolean theIsScanWithoutContent;
            theIsScanWithoutContent = (true?this.isIsScanWithoutContent():false);
            strategy.appendField(locator, this, "isScanWithoutContent", buffer, theIsScanWithoutContent);
        }
        {
            XMLGregorianCalendar theModificationDate;
            theModificationDate = this.getModificationDate();
            strategy.appendField(locator, this, "modificationDate", buffer, theModificationDate);
        }
        {
            String theExternalReference;
            theExternalReference = this.getExternalReference();
            strategy.appendField(locator, this, "externalReference", buffer, theExternalReference);
        }
        {
            String theContentType;
            theContentType = this.getContentType();
            strategy.appendField(locator, this, "contentType", buffer, theContentType);
        }
        {
            Integer thePageNo;
            thePageNo = this.getPageNo();
            strategy.appendField(locator, this, "pageNo", buffer, thePageNo);
        }
        {
            RenditionStatus theRenditionStatus;
            theRenditionStatus = this.getRenditionStatus();
            strategy.appendField(locator, this, "renditionStatus", buffer, theRenditionStatus);
        }
        {
            Item.CheckedOut theCheckedOut;
            theCheckedOut = this.getCheckedOut();
            strategy.appendField(locator, this, "checkedOut", buffer, theCheckedOut);
        }
        {
            Item.Translations theTranslations;
            theTranslations = this.getTranslations();
            strategy.appendField(locator, this, "translations", buffer, theTranslations);
        }
        {
            Integer theContentSize;
            theContentSize = this.getContentSize();
            strategy.appendField(locator, this, "contentSize", buffer, theContentSize);
        }
        {
            Boolean theVersioned;
            theVersioned = this.isVersioned();
            strategy.appendField(locator, this, "versioned", buffer, theVersioned);
        }
        {
            String theVersionLabel;
            theVersionLabel = this.getVersionLabel();
            strategy.appendField(locator, this, "versionLabel", buffer, theVersionLabel);
        }
        {
            String theMimeType;
            theMimeType = this.getMimeType();
            strategy.appendField(locator, this, "mimeType", buffer, theMimeType);
        }
        {
            String theContentId;
            theContentId = this.getContentId();
            strategy.appendField(locator, this, "contentId", buffer, theContentId);
        }
        {
            String theSha256;
            theSha256 = this.getSha256();
            strategy.appendField(locator, this, "sha256", buffer, theSha256);
        }
        {
            String theSearchSummary;
            theSearchSummary = this.getSearchSummary();
            strategy.appendField(locator, this, "searchSummary", buffer, theSearchSummary);
        }
        {
            Item.Versions theVersions;
            theVersions = this.getVersions();
            strategy.appendField(locator, this, "versions", buffer, theVersions);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theItemId;
            theItemId = this.getItemId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemId", theItemId), currentHashCode, theItemId);
        }
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
            AttachmentType theAttachmentType;
            theAttachmentType = this.getAttachmentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentType", theAttachmentType), currentHashCode, theAttachmentType);
        }
        {
            ItemKind theKind;
            theKind = this.getKind();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "kind", theKind), currentHashCode, theKind);
        }
        {
            boolean theIsScanWithoutContent;
            theIsScanWithoutContent = (true?this.isIsScanWithoutContent():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "isScanWithoutContent", theIsScanWithoutContent), currentHashCode, theIsScanWithoutContent);
        }
        {
            XMLGregorianCalendar theModificationDate;
            theModificationDate = this.getModificationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "modificationDate", theModificationDate), currentHashCode, theModificationDate);
        }
        {
            String theExternalReference;
            theExternalReference = this.getExternalReference();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalReference", theExternalReference), currentHashCode, theExternalReference);
        }
        {
            String theContentType;
            theContentType = this.getContentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentType", theContentType), currentHashCode, theContentType);
        }
        {
            Integer thePageNo;
            thePageNo = this.getPageNo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pageNo", thePageNo), currentHashCode, thePageNo);
        }
        {
            RenditionStatus theRenditionStatus;
            theRenditionStatus = this.getRenditionStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "renditionStatus", theRenditionStatus), currentHashCode, theRenditionStatus);
        }
        {
            Item.CheckedOut theCheckedOut;
            theCheckedOut = this.getCheckedOut();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "checkedOut", theCheckedOut), currentHashCode, theCheckedOut);
        }
        {
            Item.Translations theTranslations;
            theTranslations = this.getTranslations();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "translations", theTranslations), currentHashCode, theTranslations);
        }
        {
            Integer theContentSize;
            theContentSize = this.getContentSize();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentSize", theContentSize), currentHashCode, theContentSize);
        }
        {
            Boolean theVersioned;
            theVersioned = this.isVersioned();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "versioned", theVersioned), currentHashCode, theVersioned);
        }
        {
            String theVersionLabel;
            theVersionLabel = this.getVersionLabel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "versionLabel", theVersionLabel), currentHashCode, theVersionLabel);
        }
        {
            String theMimeType;
            theMimeType = this.getMimeType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mimeType", theMimeType), currentHashCode, theMimeType);
        }
        {
            String theContentId;
            theContentId = this.getContentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentId", theContentId), currentHashCode, theContentId);
        }
        {
            String theSha256;
            theSha256 = this.getSha256();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sha256", theSha256), currentHashCode, theSha256);
        }
        {
            String theSearchSummary;
            theSearchSummary = this.getSearchSummary();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchSummary", theSearchSummary), currentHashCode, theSearchSummary);
        }
        {
            Item.Versions theVersions;
            theVersions = this.getVersions();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "versions", theVersions), currentHashCode, theVersions);
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
     *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
        "userName",
        "date"
    })
    public static class CheckedOut
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected String userName;
        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar date;

        /**
         * Gets the value of the userName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUserName() {
            return userName;
        }

        /**
         * Sets the value of the userName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUserName(String value) {
            this.userName = value;
        }

        /**
         * Gets the value of the date property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDate(XMLGregorianCalendar value) {
            this.date = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Item.CheckedOut)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Item.CheckedOut that = ((Item.CheckedOut) object);
            {
                String lhsUserName;
                lhsUserName = this.getUserName();
                String rhsUserName;
                rhsUserName = that.getUserName();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "userName", lhsUserName), LocatorUtils.property(thatLocator, "userName", rhsUserName), lhsUserName, rhsUserName)) {
                    return false;
                }
            }
            {
                XMLGregorianCalendar lhsDate;
                lhsDate = this.getDate();
                XMLGregorianCalendar rhsDate;
                rhsDate = that.getDate();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "date", lhsDate), LocatorUtils.property(thatLocator, "date", rhsDate), lhsDate, rhsDate)) {
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
                String theUserName;
                theUserName = this.getUserName();
                strategy.appendField(locator, this, "userName", buffer, theUserName);
            }
            {
                XMLGregorianCalendar theDate;
                theDate = this.getDate();
                strategy.appendField(locator, this, "date", buffer, theDate);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theUserName;
                theUserName = this.getUserName();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userName", theUserName), currentHashCode, theUserName);
            }
            {
                XMLGregorianCalendar theDate;
                theDate = this.getDate();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "date", theDate), currentHashCode, theDate);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

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
     *         &lt;element name="translation" type="{http://ec.europa.eu/sg/hrs/types}Item" maxOccurs="unbounded"/>
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
        "translation"
    })
    public static class Translations
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected List<Item> translation;

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
         * {@link Item }
         * 
         * 
         */
        public List<Item> getTranslation() {
            if (translation == null) {
                translation = new ArrayList<Item>();
            }
            return this.translation;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Item.Translations)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Item.Translations that = ((Item.Translations) object);
            {
                List<Item> lhsTranslation;
                lhsTranslation = (((this.translation!= null)&&(!this.translation.isEmpty()))?this.getTranslation():null);
                List<Item> rhsTranslation;
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
                List<Item> theTranslation;
                theTranslation = (((this.translation!= null)&&(!this.translation.isEmpty()))?this.getTranslation():null);
                strategy.appendField(locator, this, "translation", buffer, theTranslation);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<Item> theTranslation;
                theTranslation = (((this.translation!= null)&&(!this.translation.isEmpty()))?this.getTranslation():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "translation", theTranslation), currentHashCode, theTranslation);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

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
     *         &lt;element name="item" type="{http://ec.europa.eu/sg/hrs/types}Item" maxOccurs="unbounded" minOccurs="0"/>
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
        "item"
    })
    public static class Versions
        implements Equals, HashCode, ToString
    {

        protected List<Item> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Item }
         * 
         * 
         */
        public List<Item> getItem() {
            if (item == null) {
                item = new ArrayList<Item>();
            }
            return this.item;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Item.Versions)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Item.Versions that = ((Item.Versions) object);
            {
                List<Item> lhsItem;
                lhsItem = (((this.item!= null)&&(!this.item.isEmpty()))?this.getItem():null);
                List<Item> rhsItem;
                rhsItem = (((that.item!= null)&&(!that.item.isEmpty()))?that.getItem():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "item", lhsItem), LocatorUtils.property(thatLocator, "item", rhsItem), lhsItem, rhsItem)) {
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
                List<Item> theItem;
                theItem = (((this.item!= null)&&(!this.item.isEmpty()))?this.getItem():null);
                strategy.appendField(locator, this, "item", buffer, theItem);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<Item> theItem;
                theItem = (((this.item!= null)&&(!this.item.isEmpty()))?this.getItem():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "item", theItem), currentHashCode, theItem);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
