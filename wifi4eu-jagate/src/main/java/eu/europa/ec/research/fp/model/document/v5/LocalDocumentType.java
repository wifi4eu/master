
package eu.europa.ec.research.fp.model.document.v5;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for LocalDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocalDocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://ec.europa.eu/research/fp/model/document-ref/V3}DocumentRefGroup"/>
 *         &lt;element name="Type" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="Externalized" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ExternalizationType" type="{http://ec.europa.eu/research/fp/model/document/V5}ExternalizationType" minOccurs="0"/>
 *         &lt;element name="MetaData" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentMetaDataType" maxOccurs="unbounded"/>
 *         &lt;element name="SendersRecipients" type="{http://ec.europa.eu/research/fp/model/document/V5}SendersRecipients" minOccurs="0"/>
 *         &lt;element name="Attachments" type="{http://ec.europa.eu/research/fp/model/document/V5}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LinkedDocuments" type="{http://ec.europa.eu/research/fp/model/document/V5}LinkedDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MailType" type="{http://ec.europa.eu/research/fp/model/document/V5}MailTypeType" minOccurs="0"/>
 *         &lt;element name="ExternalizationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="TagInfo" type="{http://ec.europa.eu/research/fp/model/document/V5}TagInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalDocumentType", propOrder = {
    "master",
    "masterID",
    "tag",
    "type",
    "externalized",
    "externalizationType",
    "metaData",
    "sendersRecipients",
    "attachments",
    "linkedDocuments",
    "mailType",
    "externalizationDate",
    "tagInfo"
})
public class LocalDocumentType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Master", namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3", required = true)
    protected String master;
    @XmlElement(name = "MasterID", namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3", required = true)
    protected String masterID;
    @XmlElement(name = "Tag", namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3")
    protected String tag;
    @XmlElement(name = "Type", required = true)
    protected CodeRefType type;
    @XmlElement(name = "Externalized")
    protected boolean externalized;
    @XmlElement(name = "ExternalizationType")
    protected ExternalizationType externalizationType;
    @XmlElement(name = "MetaData", required = true)
    protected List<DocumentMetaDataType> metaData;
    @XmlElement(name = "SendersRecipients")
    protected SendersRecipients sendersRecipients;
    @XmlElement(name = "Attachments")
    protected List<AttachmentType> attachments;
    @XmlElement(name = "LinkedDocuments")
    protected List<LinkedDocumentType> linkedDocuments;
    @XmlElement(name = "MailType")
    protected MailTypeType mailType;
    @XmlElement(name = "ExternalizationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar externalizationDate;
    @XmlElement(name = "TagInfo")
    protected TagInfoType tagInfo;

    /**
     * Gets the value of the master property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaster() {
        return master;
    }

    /**
     * Sets the value of the master property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaster(String value) {
        this.master = value;
    }

    /**
     * Gets the value of the masterID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterID() {
        return masterID;
    }

    /**
     * Sets the value of the masterID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterID(String value) {
        this.masterID = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setType(CodeRefType value) {
        this.type = value;
    }

    /**
     * Gets the value of the externalized property.
     * 
     */
    public boolean isExternalized() {
        return externalized;
    }

    /**
     * Sets the value of the externalized property.
     * 
     */
    public void setExternalized(boolean value) {
        this.externalized = value;
    }

    /**
     * Gets the value of the externalizationType property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalizationType }
     *     
     */
    public ExternalizationType getExternalizationType() {
        return externalizationType;
    }

    /**
     * Sets the value of the externalizationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalizationType }
     *     
     */
    public void setExternalizationType(ExternalizationType value) {
        this.externalizationType = value;
    }

    /**
     * Gets the value of the metaData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metaData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetaData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentMetaDataType }
     * 
     * 
     */
    public List<DocumentMetaDataType> getMetaData() {
        if (metaData == null) {
            metaData = new ArrayList<DocumentMetaDataType>();
        }
        return this.metaData;
    }

    /**
     * Gets the value of the sendersRecipients property.
     * 
     * @return
     *     possible object is
     *     {@link SendersRecipients }
     *     
     */
    public SendersRecipients getSendersRecipients() {
        return sendersRecipients;
    }

    /**
     * Sets the value of the sendersRecipients property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendersRecipients }
     *     
     */
    public void setSendersRecipients(SendersRecipients value) {
        this.sendersRecipients = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<AttachmentType>();
        }
        return this.attachments;
    }

    /**
     * Gets the value of the linkedDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkedDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkedDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkedDocumentType }
     * 
     * 
     */
    public List<LinkedDocumentType> getLinkedDocuments() {
        if (linkedDocuments == null) {
            linkedDocuments = new ArrayList<LinkedDocumentType>();
        }
        return this.linkedDocuments;
    }

    /**
     * Gets the value of the mailType property.
     * 
     * @return
     *     possible object is
     *     {@link MailTypeType }
     *     
     */
    public MailTypeType getMailType() {
        return mailType;
    }

    /**
     * Sets the value of the mailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MailTypeType }
     *     
     */
    public void setMailType(MailTypeType value) {
        this.mailType = value;
    }

    /**
     * Gets the value of the externalizationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExternalizationDate() {
        return externalizationDate;
    }

    /**
     * Sets the value of the externalizationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExternalizationDate(XMLGregorianCalendar value) {
        this.externalizationDate = value;
    }

    /**
     * Gets the value of the tagInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TagInfoType }
     *     
     */
    public TagInfoType getTagInfo() {
        return tagInfo;
    }

    /**
     * Sets the value of the tagInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TagInfoType }
     *     
     */
    public void setTagInfo(TagInfoType value) {
        this.tagInfo = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LocalDocumentType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LocalDocumentType that = ((LocalDocumentType) object);
        {
            String lhsMaster;
            lhsMaster = this.getMaster();
            String rhsMaster;
            rhsMaster = that.getMaster();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "master", lhsMaster), LocatorUtils.property(thatLocator, "master", rhsMaster), lhsMaster, rhsMaster)) {
                return false;
            }
        }
        {
            String lhsMasterID;
            lhsMasterID = this.getMasterID();
            String rhsMasterID;
            rhsMasterID = that.getMasterID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "masterID", lhsMasterID), LocatorUtils.property(thatLocator, "masterID", rhsMasterID), lhsMasterID, rhsMasterID)) {
                return false;
            }
        }
        {
            String lhsTag;
            lhsTag = this.getTag();
            String rhsTag;
            rhsTag = that.getTag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tag", lhsTag), LocatorUtils.property(thatLocator, "tag", rhsTag), lhsTag, rhsTag)) {
                return false;
            }
        }
        {
            CodeRefType lhsType;
            lhsType = this.getType();
            CodeRefType rhsType;
            rhsType = that.getType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType)) {
                return false;
            }
        }
        {
            boolean lhsExternalized;
            lhsExternalized = (true?this.isExternalized():false);
            boolean rhsExternalized;
            rhsExternalized = (true?that.isExternalized():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalized", lhsExternalized), LocatorUtils.property(thatLocator, "externalized", rhsExternalized), lhsExternalized, rhsExternalized)) {
                return false;
            }
        }
        {
            ExternalizationType lhsExternalizationType;
            lhsExternalizationType = this.getExternalizationType();
            ExternalizationType rhsExternalizationType;
            rhsExternalizationType = that.getExternalizationType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalizationType", lhsExternalizationType), LocatorUtils.property(thatLocator, "externalizationType", rhsExternalizationType), lhsExternalizationType, rhsExternalizationType)) {
                return false;
            }
        }
        {
            List<DocumentMetaDataType> lhsMetaData;
            lhsMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            List<DocumentMetaDataType> rhsMetaData;
            rhsMetaData = (((that.metaData!= null)&&(!that.metaData.isEmpty()))?that.getMetaData():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "metaData", lhsMetaData), LocatorUtils.property(thatLocator, "metaData", rhsMetaData), lhsMetaData, rhsMetaData)) {
                return false;
            }
        }
        {
            SendersRecipients lhsSendersRecipients;
            lhsSendersRecipients = this.getSendersRecipients();
            SendersRecipients rhsSendersRecipients;
            rhsSendersRecipients = that.getSendersRecipients();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sendersRecipients", lhsSendersRecipients), LocatorUtils.property(thatLocator, "sendersRecipients", rhsSendersRecipients), lhsSendersRecipients, rhsSendersRecipients)) {
                return false;
            }
        }
        {
            List<AttachmentType> lhsAttachments;
            lhsAttachments = (((this.attachments!= null)&&(!this.attachments.isEmpty()))?this.getAttachments():null);
            List<AttachmentType> rhsAttachments;
            rhsAttachments = (((that.attachments!= null)&&(!that.attachments.isEmpty()))?that.getAttachments():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attachments", lhsAttachments), LocatorUtils.property(thatLocator, "attachments", rhsAttachments), lhsAttachments, rhsAttachments)) {
                return false;
            }
        }
        {
            List<LinkedDocumentType> lhsLinkedDocuments;
            lhsLinkedDocuments = (((this.linkedDocuments!= null)&&(!this.linkedDocuments.isEmpty()))?this.getLinkedDocuments():null);
            List<LinkedDocumentType> rhsLinkedDocuments;
            rhsLinkedDocuments = (((that.linkedDocuments!= null)&&(!that.linkedDocuments.isEmpty()))?that.getLinkedDocuments():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "linkedDocuments", lhsLinkedDocuments), LocatorUtils.property(thatLocator, "linkedDocuments", rhsLinkedDocuments), lhsLinkedDocuments, rhsLinkedDocuments)) {
                return false;
            }
        }
        {
            MailTypeType lhsMailType;
            lhsMailType = this.getMailType();
            MailTypeType rhsMailType;
            rhsMailType = that.getMailType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mailType", lhsMailType), LocatorUtils.property(thatLocator, "mailType", rhsMailType), lhsMailType, rhsMailType)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsExternalizationDate;
            lhsExternalizationDate = this.getExternalizationDate();
            XMLGregorianCalendar rhsExternalizationDate;
            rhsExternalizationDate = that.getExternalizationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalizationDate", lhsExternalizationDate), LocatorUtils.property(thatLocator, "externalizationDate", rhsExternalizationDate), lhsExternalizationDate, rhsExternalizationDate)) {
                return false;
            }
        }
        {
            TagInfoType lhsTagInfo;
            lhsTagInfo = this.getTagInfo();
            TagInfoType rhsTagInfo;
            rhsTagInfo = that.getTagInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tagInfo", lhsTagInfo), LocatorUtils.property(thatLocator, "tagInfo", rhsTagInfo), lhsTagInfo, rhsTagInfo)) {
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
            String theMaster;
            theMaster = this.getMaster();
            strategy.appendField(locator, this, "master", buffer, theMaster);
        }
        {
            String theMasterID;
            theMasterID = this.getMasterID();
            strategy.appendField(locator, this, "masterID", buffer, theMasterID);
        }
        {
            String theTag;
            theTag = this.getTag();
            strategy.appendField(locator, this, "tag", buffer, theTag);
        }
        {
            CodeRefType theType;
            theType = this.getType();
            strategy.appendField(locator, this, "type", buffer, theType);
        }
        {
            boolean theExternalized;
            theExternalized = (true?this.isExternalized():false);
            strategy.appendField(locator, this, "externalized", buffer, theExternalized);
        }
        {
            ExternalizationType theExternalizationType;
            theExternalizationType = this.getExternalizationType();
            strategy.appendField(locator, this, "externalizationType", buffer, theExternalizationType);
        }
        {
            List<DocumentMetaDataType> theMetaData;
            theMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            strategy.appendField(locator, this, "metaData", buffer, theMetaData);
        }
        {
            SendersRecipients theSendersRecipients;
            theSendersRecipients = this.getSendersRecipients();
            strategy.appendField(locator, this, "sendersRecipients", buffer, theSendersRecipients);
        }
        {
            List<AttachmentType> theAttachments;
            theAttachments = (((this.attachments!= null)&&(!this.attachments.isEmpty()))?this.getAttachments():null);
            strategy.appendField(locator, this, "attachments", buffer, theAttachments);
        }
        {
            List<LinkedDocumentType> theLinkedDocuments;
            theLinkedDocuments = (((this.linkedDocuments!= null)&&(!this.linkedDocuments.isEmpty()))?this.getLinkedDocuments():null);
            strategy.appendField(locator, this, "linkedDocuments", buffer, theLinkedDocuments);
        }
        {
            MailTypeType theMailType;
            theMailType = this.getMailType();
            strategy.appendField(locator, this, "mailType", buffer, theMailType);
        }
        {
            XMLGregorianCalendar theExternalizationDate;
            theExternalizationDate = this.getExternalizationDate();
            strategy.appendField(locator, this, "externalizationDate", buffer, theExternalizationDate);
        }
        {
            TagInfoType theTagInfo;
            theTagInfo = this.getTagInfo();
            strategy.appendField(locator, this, "tagInfo", buffer, theTagInfo);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theMaster;
            theMaster = this.getMaster();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "master", theMaster), currentHashCode, theMaster);
        }
        {
            String theMasterID;
            theMasterID = this.getMasterID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "masterID", theMasterID), currentHashCode, theMasterID);
        }
        {
            String theTag;
            theTag = this.getTag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tag", theTag), currentHashCode, theTag);
        }
        {
            CodeRefType theType;
            theType = this.getType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType);
        }
        {
            boolean theExternalized;
            theExternalized = (true?this.isExternalized():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalized", theExternalized), currentHashCode, theExternalized);
        }
        {
            ExternalizationType theExternalizationType;
            theExternalizationType = this.getExternalizationType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalizationType", theExternalizationType), currentHashCode, theExternalizationType);
        }
        {
            List<DocumentMetaDataType> theMetaData;
            theMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "metaData", theMetaData), currentHashCode, theMetaData);
        }
        {
            SendersRecipients theSendersRecipients;
            theSendersRecipients = this.getSendersRecipients();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sendersRecipients", theSendersRecipients), currentHashCode, theSendersRecipients);
        }
        {
            List<AttachmentType> theAttachments;
            theAttachments = (((this.attachments!= null)&&(!this.attachments.isEmpty()))?this.getAttachments():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachments", theAttachments), currentHashCode, theAttachments);
        }
        {
            List<LinkedDocumentType> theLinkedDocuments;
            theLinkedDocuments = (((this.linkedDocuments!= null)&&(!this.linkedDocuments.isEmpty()))?this.getLinkedDocuments():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "linkedDocuments", theLinkedDocuments), currentHashCode, theLinkedDocuments);
        }
        {
            MailTypeType theMailType;
            theMailType = this.getMailType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mailType", theMailType), currentHashCode, theMailType);
        }
        {
            XMLGregorianCalendar theExternalizationDate;
            theExternalizationDate = this.getExternalizationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalizationDate", theExternalizationDate), currentHashCode, theExternalizationDate);
        }
        {
            TagInfoType theTagInfo;
            theTagInfo = this.getTagInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tagInfo", theTagInfo), currentHashCode, theTagInfo);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
