
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
 * An element for supporting-Item details
 * 
 * <p>Java class for SupportingItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupportingItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://ec.europa.eu/sg/hrs/types}SupportingItemGroupCommon"/>
 *         &lt;element name="id" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="fileSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="hyperlink" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="retentionRequested" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportingItemRetained" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contentId" type="{http://ec.europa.eu/sg/hrs/types}ContentIdType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupportingItem", propOrder = {
    "type",
    "contentCategory",
    "title",
    "comment",
    "id",
    "documentId",
    "fileSize",
    "hyperlink",
    "retentionRequested",
    "supportingItemRetained",
    "fileName",
    "contentId"
})
public class SupportingItem
    implements Equals, HashCode, ToString
{

    protected String type;
    @XmlElement(required = true)
    protected String contentCategory;
    protected String title;
    protected String comment;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String documentId;
    protected Long fileSize;
    protected String hyperlink;
    @XmlElement(defaultValue = "false")
    protected Boolean retentionRequested;
    @XmlElement(defaultValue = "false")
    protected Boolean supportingItemRetained;
    protected String fileName;
    protected String contentId;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the contentCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentCategory() {
        return contentCategory;
    }

    /**
     * Sets the value of the contentCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentCategory(String value) {
        this.contentCategory = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

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
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentId(String value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the fileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileSize(Long value) {
        this.fileSize = value;
    }

    /**
     * Gets the value of the hyperlink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHyperlink() {
        return hyperlink;
    }

    /**
     * Sets the value of the hyperlink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHyperlink(String value) {
        this.hyperlink = value;
    }

    /**
     * Gets the value of the retentionRequested property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRetentionRequested() {
        return retentionRequested;
    }

    /**
     * Sets the value of the retentionRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRetentionRequested(Boolean value) {
        this.retentionRequested = value;
    }

    /**
     * Gets the value of the supportingItemRetained property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportingItemRetained() {
        return supportingItemRetained;
    }

    /**
     * Sets the value of the supportingItemRetained property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportingItemRetained(Boolean value) {
        this.supportingItemRetained = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SupportingItem)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SupportingItem that = ((SupportingItem) object);
        {
            String lhsType;
            lhsType = this.getType();
            String rhsType;
            rhsType = that.getType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType)) {
                return false;
            }
        }
        {
            String lhsContentCategory;
            lhsContentCategory = this.getContentCategory();
            String rhsContentCategory;
            rhsContentCategory = that.getContentCategory();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentCategory", lhsContentCategory), LocatorUtils.property(thatLocator, "contentCategory", rhsContentCategory), lhsContentCategory, rhsContentCategory)) {
                return false;
            }
        }
        {
            String lhsTitle;
            lhsTitle = this.getTitle();
            String rhsTitle;
            rhsTitle = that.getTitle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "title", lhsTitle), LocatorUtils.property(thatLocator, "title", rhsTitle), lhsTitle, rhsTitle)) {
                return false;
            }
        }
        {
            String lhsComment;
            lhsComment = this.getComment();
            String rhsComment;
            rhsComment = that.getComment();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "comment", lhsComment), LocatorUtils.property(thatLocator, "comment", rhsComment), lhsComment, rhsComment)) {
                return false;
            }
        }
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
            String lhsDocumentId;
            lhsDocumentId = this.getDocumentId();
            String rhsDocumentId;
            rhsDocumentId = that.getDocumentId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "documentId", lhsDocumentId), LocatorUtils.property(thatLocator, "documentId", rhsDocumentId), lhsDocumentId, rhsDocumentId)) {
                return false;
            }
        }
        {
            Long lhsFileSize;
            lhsFileSize = this.getFileSize();
            Long rhsFileSize;
            rhsFileSize = that.getFileSize();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileSize", lhsFileSize), LocatorUtils.property(thatLocator, "fileSize", rhsFileSize), lhsFileSize, rhsFileSize)) {
                return false;
            }
        }
        {
            String lhsHyperlink;
            lhsHyperlink = this.getHyperlink();
            String rhsHyperlink;
            rhsHyperlink = that.getHyperlink();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "hyperlink", lhsHyperlink), LocatorUtils.property(thatLocator, "hyperlink", rhsHyperlink), lhsHyperlink, rhsHyperlink)) {
                return false;
            }
        }
        {
            Boolean lhsRetentionRequested;
            lhsRetentionRequested = this.isRetentionRequested();
            Boolean rhsRetentionRequested;
            rhsRetentionRequested = that.isRetentionRequested();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "retentionRequested", lhsRetentionRequested), LocatorUtils.property(thatLocator, "retentionRequested", rhsRetentionRequested), lhsRetentionRequested, rhsRetentionRequested)) {
                return false;
            }
        }
        {
            Boolean lhsSupportingItemRetained;
            lhsSupportingItemRetained = this.isSupportingItemRetained();
            Boolean rhsSupportingItemRetained;
            rhsSupportingItemRetained = that.isSupportingItemRetained();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "supportingItemRetained", lhsSupportingItemRetained), LocatorUtils.property(thatLocator, "supportingItemRetained", rhsSupportingItemRetained), lhsSupportingItemRetained, rhsSupportingItemRetained)) {
                return false;
            }
        }
        {
            String lhsFileName;
            lhsFileName = this.getFileName();
            String rhsFileName;
            rhsFileName = that.getFileName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileName", lhsFileName), LocatorUtils.property(thatLocator, "fileName", rhsFileName), lhsFileName, rhsFileName)) {
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
            String theType;
            theType = this.getType();
            strategy.appendField(locator, this, "type", buffer, theType);
        }
        {
            String theContentCategory;
            theContentCategory = this.getContentCategory();
            strategy.appendField(locator, this, "contentCategory", buffer, theContentCategory);
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle);
        }
        {
            String theComment;
            theComment = this.getComment();
            strategy.appendField(locator, this, "comment", buffer, theComment);
        }
        {
            String theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            strategy.appendField(locator, this, "documentId", buffer, theDocumentId);
        }
        {
            Long theFileSize;
            theFileSize = this.getFileSize();
            strategy.appendField(locator, this, "fileSize", buffer, theFileSize);
        }
        {
            String theHyperlink;
            theHyperlink = this.getHyperlink();
            strategy.appendField(locator, this, "hyperlink", buffer, theHyperlink);
        }
        {
            Boolean theRetentionRequested;
            theRetentionRequested = this.isRetentionRequested();
            strategy.appendField(locator, this, "retentionRequested", buffer, theRetentionRequested);
        }
        {
            Boolean theSupportingItemRetained;
            theSupportingItemRetained = this.isSupportingItemRetained();
            strategy.appendField(locator, this, "supportingItemRetained", buffer, theSupportingItemRetained);
        }
        {
            String theFileName;
            theFileName = this.getFileName();
            strategy.appendField(locator, this, "fileName", buffer, theFileName);
        }
        {
            String theContentId;
            theContentId = this.getContentId();
            strategy.appendField(locator, this, "contentId", buffer, theContentId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theType;
            theType = this.getType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType);
        }
        {
            String theContentCategory;
            theContentCategory = this.getContentCategory();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentCategory", theContentCategory), currentHashCode, theContentCategory);
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle), currentHashCode, theTitle);
        }
        {
            String theComment;
            theComment = this.getComment();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comment", theComment), currentHashCode, theComment);
        }
        {
            String theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentId", theDocumentId), currentHashCode, theDocumentId);
        }
        {
            Long theFileSize;
            theFileSize = this.getFileSize();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileSize", theFileSize), currentHashCode, theFileSize);
        }
        {
            String theHyperlink;
            theHyperlink = this.getHyperlink();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hyperlink", theHyperlink), currentHashCode, theHyperlink);
        }
        {
            Boolean theRetentionRequested;
            theRetentionRequested = this.isRetentionRequested();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "retentionRequested", theRetentionRequested), currentHashCode, theRetentionRequested);
        }
        {
            Boolean theSupportingItemRetained;
            theSupportingItemRetained = this.isSupportingItemRetained();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "supportingItemRetained", theSupportingItemRetained), currentHashCode, theSupportingItemRetained);
        }
        {
            String theFileName;
            theFileName = this.getFileName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileName", theFileName), currentHashCode, theFileName);
        }
        {
            String theContentId;
            theContentId = this.getContentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentId", theContentId), currentHashCode, theContentId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
