
package generated.hrs.ws.model;

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
 * Request for the operation createDocument
 * 
 * <p>Java class for DocumentCreationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentCreationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="documentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="sentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="securityClassification" type="{http://ec.europa.eu/sg/hrs/types}SecurityClassification"/>
 *         &lt;element name="marking" type="{http://ec.europa.eu/sg/hrs/types}Marking" minOccurs="0"/>
 *         &lt;element name="classification" type="{http://ec.europa.eu/sg/hrs/types}Classification" minOccurs="0"/>
 *         &lt;element name="replyTo" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" minOccurs="0"/>
 *         &lt;element name="fileReply" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="encryptItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="encryptItemsDeadline" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="procedureId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="senders" type="{http://ec.europa.eu/sg/hrs/types}SendersToAdd" minOccurs="0"/>
 *         &lt;element name="recipients" type="{http://ec.europa.eu/sg/hrs/types}RecipientsToAdd" minOccurs="0"/>
 *         &lt;element name="items" type="{http://ec.europa.eu/sg/hrs/types}ItemsToAdd" minOccurs="0"/>
 *         &lt;element name="externalSignatures" type="{http://ec.europa.eu/sg/hrs/types}ExternalSignaturesToAdd" minOccurs="0"/>
 *         &lt;element name="saveNumberPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;group ref="{http://ec.europa.eu/sg/hrs/types}FilingRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentCreationRequest", propOrder = {
    "title",
    "documentDate",
    "sentDate",
    "securityClassification",
    "marking",
    "classification",
    "replyTo",
    "fileReply",
    "encryptItems",
    "encryptItemsDeadline",
    "comments",
    "procedureId",
    "senders",
    "recipients",
    "items",
    "externalSignatures",
    "saveNumberPrefix",
    "fileId",
    "fileSearchExpression",
    "specialFile"
})
public class DocumentCreationRequest
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String title;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar documentDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar sentDate;
    @XmlElement(required = true, defaultValue = "NORMAL")
    protected SecurityClassification securityClassification;
    protected Marking marking;
    protected Classification classification;
    protected String replyTo;
    protected Boolean fileReply;
    protected Boolean encryptItems;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar encryptItemsDeadline;
    protected String comments;
    protected Integer procedureId;
    protected SendersToAdd senders;
    protected RecipientsToAdd recipients;
    protected ItemsToAdd items;
    protected ExternalSignaturesToAdd externalSignatures;
    protected String saveNumberPrefix;
    protected String fileId;
    protected String fileSearchExpression;
    protected Boolean specialFile;

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
     * Gets the value of the documentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocumentDate() {
        return documentDate;
    }

    /**
     * Sets the value of the documentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocumentDate(XMLGregorianCalendar value) {
        this.documentDate = value;
    }

    /**
     * Gets the value of the sentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSentDate() {
        return sentDate;
    }

    /**
     * Sets the value of the sentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSentDate(XMLGregorianCalendar value) {
        this.sentDate = value;
    }

    /**
     * Gets the value of the securityClassification property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityClassification }
     *     
     */
    public SecurityClassification getSecurityClassification() {
        return securityClassification;
    }

    /**
     * Sets the value of the securityClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityClassification }
     *     
     */
    public void setSecurityClassification(SecurityClassification value) {
        this.securityClassification = value;
    }

    /**
     * Gets the value of the marking property.
     * 
     * @return
     *     possible object is
     *     {@link Marking }
     *     
     */
    public Marking getMarking() {
        return marking;
    }

    /**
     * Sets the value of the marking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Marking }
     *     
     */
    public void setMarking(Marking value) {
        this.marking = value;
    }

    /**
     * Gets the value of the classification property.
     * 
     * @return
     *     possible object is
     *     {@link Classification }
     *     
     */
    public Classification getClassification() {
        return classification;
    }

    /**
     * Sets the value of the classification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Classification }
     *     
     */
    public void setClassification(Classification value) {
        this.classification = value;
    }

    /**
     * Gets the value of the replyTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplyTo() {
        return replyTo;
    }

    /**
     * Sets the value of the replyTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplyTo(String value) {
        this.replyTo = value;
    }

    /**
     * Gets the value of the fileReply property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFileReply() {
        return fileReply;
    }

    /**
     * Sets the value of the fileReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFileReply(Boolean value) {
        this.fileReply = value;
    }

    /**
     * Gets the value of the encryptItems property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEncryptItems() {
        return encryptItems;
    }

    /**
     * Sets the value of the encryptItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEncryptItems(Boolean value) {
        this.encryptItems = value;
    }

    /**
     * Gets the value of the encryptItemsDeadline property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEncryptItemsDeadline() {
        return encryptItemsDeadline;
    }

    /**
     * Sets the value of the encryptItemsDeadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEncryptItemsDeadline(XMLGregorianCalendar value) {
        this.encryptItemsDeadline = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the procedureId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProcedureId() {
        return procedureId;
    }

    /**
     * Sets the value of the procedureId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProcedureId(Integer value) {
        this.procedureId = value;
    }

    /**
     * Gets the value of the senders property.
     * 
     * @return
     *     possible object is
     *     {@link SendersToAdd }
     *     
     */
    public SendersToAdd getSenders() {
        return senders;
    }

    /**
     * Sets the value of the senders property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendersToAdd }
     *     
     */
    public void setSenders(SendersToAdd value) {
        this.senders = value;
    }

    /**
     * Gets the value of the recipients property.
     * 
     * @return
     *     possible object is
     *     {@link RecipientsToAdd }
     *     
     */
    public RecipientsToAdd getRecipients() {
        return recipients;
    }

    /**
     * Sets the value of the recipients property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecipientsToAdd }
     *     
     */
    public void setRecipients(RecipientsToAdd value) {
        this.recipients = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link ItemsToAdd }
     *     
     */
    public ItemsToAdd getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemsToAdd }
     *     
     */
    public void setItems(ItemsToAdd value) {
        this.items = value;
    }

    /**
     * Gets the value of the externalSignatures property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalSignaturesToAdd }
     *     
     */
    public ExternalSignaturesToAdd getExternalSignatures() {
        return externalSignatures;
    }

    /**
     * Sets the value of the externalSignatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalSignaturesToAdd }
     *     
     */
    public void setExternalSignatures(ExternalSignaturesToAdd value) {
        this.externalSignatures = value;
    }

    /**
     * Gets the value of the saveNumberPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaveNumberPrefix() {
        return saveNumberPrefix;
    }

    /**
     * Sets the value of the saveNumberPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaveNumberPrefix(String value) {
        this.saveNumberPrefix = value;
    }

    /**
     * Gets the value of the fileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * Sets the value of the fileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileId(String value) {
        this.fileId = value;
    }

    /**
     * Gets the value of the fileSearchExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileSearchExpression() {
        return fileSearchExpression;
    }

    /**
     * Sets the value of the fileSearchExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileSearchExpression(String value) {
        this.fileSearchExpression = value;
    }

    /**
     * Gets the value of the specialFile property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSpecialFile() {
        return specialFile;
    }

    /**
     * Sets the value of the specialFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSpecialFile(Boolean value) {
        this.specialFile = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentCreationRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentCreationRequest that = ((DocumentCreationRequest) object);
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
            XMLGregorianCalendar lhsDocumentDate;
            lhsDocumentDate = this.getDocumentDate();
            XMLGregorianCalendar rhsDocumentDate;
            rhsDocumentDate = that.getDocumentDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "documentDate", lhsDocumentDate), LocatorUtils.property(thatLocator, "documentDate", rhsDocumentDate), lhsDocumentDate, rhsDocumentDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsSentDate;
            lhsSentDate = this.getSentDate();
            XMLGregorianCalendar rhsSentDate;
            rhsSentDate = that.getSentDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sentDate", lhsSentDate), LocatorUtils.property(thatLocator, "sentDate", rhsSentDate), lhsSentDate, rhsSentDate)) {
                return false;
            }
        }
        {
            SecurityClassification lhsSecurityClassification;
            lhsSecurityClassification = this.getSecurityClassification();
            SecurityClassification rhsSecurityClassification;
            rhsSecurityClassification = that.getSecurityClassification();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityClassification", lhsSecurityClassification), LocatorUtils.property(thatLocator, "securityClassification", rhsSecurityClassification), lhsSecurityClassification, rhsSecurityClassification)) {
                return false;
            }
        }
        {
            Marking lhsMarking;
            lhsMarking = this.getMarking();
            Marking rhsMarking;
            rhsMarking = that.getMarking();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "marking", lhsMarking), LocatorUtils.property(thatLocator, "marking", rhsMarking), lhsMarking, rhsMarking)) {
                return false;
            }
        }
        {
            Classification lhsClassification;
            lhsClassification = this.getClassification();
            Classification rhsClassification;
            rhsClassification = that.getClassification();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "classification", lhsClassification), LocatorUtils.property(thatLocator, "classification", rhsClassification), lhsClassification, rhsClassification)) {
                return false;
            }
        }
        {
            String lhsReplyTo;
            lhsReplyTo = this.getReplyTo();
            String rhsReplyTo;
            rhsReplyTo = that.getReplyTo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "replyTo", lhsReplyTo), LocatorUtils.property(thatLocator, "replyTo", rhsReplyTo), lhsReplyTo, rhsReplyTo)) {
                return false;
            }
        }
        {
            Boolean lhsFileReply;
            lhsFileReply = this.isFileReply();
            Boolean rhsFileReply;
            rhsFileReply = that.isFileReply();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileReply", lhsFileReply), LocatorUtils.property(thatLocator, "fileReply", rhsFileReply), lhsFileReply, rhsFileReply)) {
                return false;
            }
        }
        {
            Boolean lhsEncryptItems;
            lhsEncryptItems = this.isEncryptItems();
            Boolean rhsEncryptItems;
            rhsEncryptItems = that.isEncryptItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "encryptItems", lhsEncryptItems), LocatorUtils.property(thatLocator, "encryptItems", rhsEncryptItems), lhsEncryptItems, rhsEncryptItems)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsEncryptItemsDeadline;
            lhsEncryptItemsDeadline = this.getEncryptItemsDeadline();
            XMLGregorianCalendar rhsEncryptItemsDeadline;
            rhsEncryptItemsDeadline = that.getEncryptItemsDeadline();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "encryptItemsDeadline", lhsEncryptItemsDeadline), LocatorUtils.property(thatLocator, "encryptItemsDeadline", rhsEncryptItemsDeadline), lhsEncryptItemsDeadline, rhsEncryptItemsDeadline)) {
                return false;
            }
        }
        {
            String lhsComments;
            lhsComments = this.getComments();
            String rhsComments;
            rhsComments = that.getComments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "comments", lhsComments), LocatorUtils.property(thatLocator, "comments", rhsComments), lhsComments, rhsComments)) {
                return false;
            }
        }
        {
            Integer lhsProcedureId;
            lhsProcedureId = this.getProcedureId();
            Integer rhsProcedureId;
            rhsProcedureId = that.getProcedureId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "procedureId", lhsProcedureId), LocatorUtils.property(thatLocator, "procedureId", rhsProcedureId), lhsProcedureId, rhsProcedureId)) {
                return false;
            }
        }
        {
            SendersToAdd lhsSenders;
            lhsSenders = this.getSenders();
            SendersToAdd rhsSenders;
            rhsSenders = that.getSenders();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "senders", lhsSenders), LocatorUtils.property(thatLocator, "senders", rhsSenders), lhsSenders, rhsSenders)) {
                return false;
            }
        }
        {
            RecipientsToAdd lhsRecipients;
            lhsRecipients = this.getRecipients();
            RecipientsToAdd rhsRecipients;
            rhsRecipients = that.getRecipients();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recipients", lhsRecipients), LocatorUtils.property(thatLocator, "recipients", rhsRecipients), lhsRecipients, rhsRecipients)) {
                return false;
            }
        }
        {
            ItemsToAdd lhsItems;
            lhsItems = this.getItems();
            ItemsToAdd rhsItems;
            rhsItems = that.getItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "items", lhsItems), LocatorUtils.property(thatLocator, "items", rhsItems), lhsItems, rhsItems)) {
                return false;
            }
        }
        {
            ExternalSignaturesToAdd lhsExternalSignatures;
            lhsExternalSignatures = this.getExternalSignatures();
            ExternalSignaturesToAdd rhsExternalSignatures;
            rhsExternalSignatures = that.getExternalSignatures();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalSignatures", lhsExternalSignatures), LocatorUtils.property(thatLocator, "externalSignatures", rhsExternalSignatures), lhsExternalSignatures, rhsExternalSignatures)) {
                return false;
            }
        }
        {
            String lhsSaveNumberPrefix;
            lhsSaveNumberPrefix = this.getSaveNumberPrefix();
            String rhsSaveNumberPrefix;
            rhsSaveNumberPrefix = that.getSaveNumberPrefix();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "saveNumberPrefix", lhsSaveNumberPrefix), LocatorUtils.property(thatLocator, "saveNumberPrefix", rhsSaveNumberPrefix), lhsSaveNumberPrefix, rhsSaveNumberPrefix)) {
                return false;
            }
        }
        {
            String lhsFileId;
            lhsFileId = this.getFileId();
            String rhsFileId;
            rhsFileId = that.getFileId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileId", lhsFileId), LocatorUtils.property(thatLocator, "fileId", rhsFileId), lhsFileId, rhsFileId)) {
                return false;
            }
        }
        {
            String lhsFileSearchExpression;
            lhsFileSearchExpression = this.getFileSearchExpression();
            String rhsFileSearchExpression;
            rhsFileSearchExpression = that.getFileSearchExpression();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileSearchExpression", lhsFileSearchExpression), LocatorUtils.property(thatLocator, "fileSearchExpression", rhsFileSearchExpression), lhsFileSearchExpression, rhsFileSearchExpression)) {
                return false;
            }
        }
        {
            Boolean lhsSpecialFile;
            lhsSpecialFile = this.isSpecialFile();
            Boolean rhsSpecialFile;
            rhsSpecialFile = that.isSpecialFile();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "specialFile", lhsSpecialFile), LocatorUtils.property(thatLocator, "specialFile", rhsSpecialFile), lhsSpecialFile, rhsSpecialFile)) {
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
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle);
        }
        {
            XMLGregorianCalendar theDocumentDate;
            theDocumentDate = this.getDocumentDate();
            strategy.appendField(locator, this, "documentDate", buffer, theDocumentDate);
        }
        {
            XMLGregorianCalendar theSentDate;
            theSentDate = this.getSentDate();
            strategy.appendField(locator, this, "sentDate", buffer, theSentDate);
        }
        {
            SecurityClassification theSecurityClassification;
            theSecurityClassification = this.getSecurityClassification();
            strategy.appendField(locator, this, "securityClassification", buffer, theSecurityClassification);
        }
        {
            Marking theMarking;
            theMarking = this.getMarking();
            strategy.appendField(locator, this, "marking", buffer, theMarking);
        }
        {
            Classification theClassification;
            theClassification = this.getClassification();
            strategy.appendField(locator, this, "classification", buffer, theClassification);
        }
        {
            String theReplyTo;
            theReplyTo = this.getReplyTo();
            strategy.appendField(locator, this, "replyTo", buffer, theReplyTo);
        }
        {
            Boolean theFileReply;
            theFileReply = this.isFileReply();
            strategy.appendField(locator, this, "fileReply", buffer, theFileReply);
        }
        {
            Boolean theEncryptItems;
            theEncryptItems = this.isEncryptItems();
            strategy.appendField(locator, this, "encryptItems", buffer, theEncryptItems);
        }
        {
            XMLGregorianCalendar theEncryptItemsDeadline;
            theEncryptItemsDeadline = this.getEncryptItemsDeadline();
            strategy.appendField(locator, this, "encryptItemsDeadline", buffer, theEncryptItemsDeadline);
        }
        {
            String theComments;
            theComments = this.getComments();
            strategy.appendField(locator, this, "comments", buffer, theComments);
        }
        {
            Integer theProcedureId;
            theProcedureId = this.getProcedureId();
            strategy.appendField(locator, this, "procedureId", buffer, theProcedureId);
        }
        {
            SendersToAdd theSenders;
            theSenders = this.getSenders();
            strategy.appendField(locator, this, "senders", buffer, theSenders);
        }
        {
            RecipientsToAdd theRecipients;
            theRecipients = this.getRecipients();
            strategy.appendField(locator, this, "recipients", buffer, theRecipients);
        }
        {
            ItemsToAdd theItems;
            theItems = this.getItems();
            strategy.appendField(locator, this, "items", buffer, theItems);
        }
        {
            ExternalSignaturesToAdd theExternalSignatures;
            theExternalSignatures = this.getExternalSignatures();
            strategy.appendField(locator, this, "externalSignatures", buffer, theExternalSignatures);
        }
        {
            String theSaveNumberPrefix;
            theSaveNumberPrefix = this.getSaveNumberPrefix();
            strategy.appendField(locator, this, "saveNumberPrefix", buffer, theSaveNumberPrefix);
        }
        {
            String theFileId;
            theFileId = this.getFileId();
            strategy.appendField(locator, this, "fileId", buffer, theFileId);
        }
        {
            String theFileSearchExpression;
            theFileSearchExpression = this.getFileSearchExpression();
            strategy.appendField(locator, this, "fileSearchExpression", buffer, theFileSearchExpression);
        }
        {
            Boolean theSpecialFile;
            theSpecialFile = this.isSpecialFile();
            strategy.appendField(locator, this, "specialFile", buffer, theSpecialFile);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theTitle;
            theTitle = this.getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle), currentHashCode, theTitle);
        }
        {
            XMLGregorianCalendar theDocumentDate;
            theDocumentDate = this.getDocumentDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentDate", theDocumentDate), currentHashCode, theDocumentDate);
        }
        {
            XMLGregorianCalendar theSentDate;
            theSentDate = this.getSentDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sentDate", theSentDate), currentHashCode, theSentDate);
        }
        {
            SecurityClassification theSecurityClassification;
            theSecurityClassification = this.getSecurityClassification();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityClassification", theSecurityClassification), currentHashCode, theSecurityClassification);
        }
        {
            Marking theMarking;
            theMarking = this.getMarking();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "marking", theMarking), currentHashCode, theMarking);
        }
        {
            Classification theClassification;
            theClassification = this.getClassification();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "classification", theClassification), currentHashCode, theClassification);
        }
        {
            String theReplyTo;
            theReplyTo = this.getReplyTo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "replyTo", theReplyTo), currentHashCode, theReplyTo);
        }
        {
            Boolean theFileReply;
            theFileReply = this.isFileReply();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileReply", theFileReply), currentHashCode, theFileReply);
        }
        {
            Boolean theEncryptItems;
            theEncryptItems = this.isEncryptItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "encryptItems", theEncryptItems), currentHashCode, theEncryptItems);
        }
        {
            XMLGregorianCalendar theEncryptItemsDeadline;
            theEncryptItemsDeadline = this.getEncryptItemsDeadline();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "encryptItemsDeadline", theEncryptItemsDeadline), currentHashCode, theEncryptItemsDeadline);
        }
        {
            String theComments;
            theComments = this.getComments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comments", theComments), currentHashCode, theComments);
        }
        {
            Integer theProcedureId;
            theProcedureId = this.getProcedureId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "procedureId", theProcedureId), currentHashCode, theProcedureId);
        }
        {
            SendersToAdd theSenders;
            theSenders = this.getSenders();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "senders", theSenders), currentHashCode, theSenders);
        }
        {
            RecipientsToAdd theRecipients;
            theRecipients = this.getRecipients();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recipients", theRecipients), currentHashCode, theRecipients);
        }
        {
            ItemsToAdd theItems;
            theItems = this.getItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "items", theItems), currentHashCode, theItems);
        }
        {
            ExternalSignaturesToAdd theExternalSignatures;
            theExternalSignatures = this.getExternalSignatures();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalSignatures", theExternalSignatures), currentHashCode, theExternalSignatures);
        }
        {
            String theSaveNumberPrefix;
            theSaveNumberPrefix = this.getSaveNumberPrefix();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saveNumberPrefix", theSaveNumberPrefix), currentHashCode, theSaveNumberPrefix);
        }
        {
            String theFileId;
            theFileId = this.getFileId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileId", theFileId), currentHashCode, theFileId);
        }
        {
            String theFileSearchExpression;
            theFileSearchExpression = this.getFileSearchExpression();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileSearchExpression", theFileSearchExpression), currentHashCode, theFileSearchExpression);
        }
        {
            Boolean theSpecialFile;
            theSpecialFile = this.isSpecialFile();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specialFile", theSpecialFile), currentHashCode, theSpecialFile);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
