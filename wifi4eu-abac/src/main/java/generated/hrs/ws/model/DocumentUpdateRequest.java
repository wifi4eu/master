
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
 * Request for updating a saved (but unregistered) document
 * 
 * <p>Java class for DocumentUpdateRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentUpdateRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="updateDocumentDetails" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="documentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="sentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="securityClassification" type="{http://ec.europa.eu/sg/hrs/types}SecurityClassification" minOccurs="0"/>
 *                   &lt;element name="marking" type="{http://ec.europa.eu/sg/hrs/types}Marking" minOccurs="0"/>
 *                   &lt;element name="removeMarking" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="classification" type="{http://ec.europa.eu/sg/hrs/types}Classification" minOccurs="0"/>
 *                   &lt;element name="encryptItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="encryptItemsDeadline" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="updateSenders" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="remove" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}CurrentEntityToAdd" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="updateRecipients" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="remove" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}RecipientToAdd" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="updateItems" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="remove" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}ItemsToAdd" minOccurs="0"/>
 *                   &lt;element name="updateDetails" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="language" type="{http://ec.europa.eu/sg/hrs/types}LanguageCode" minOccurs="0"/>
 *                             &lt;element name="kind" type="{http://ec.europa.eu/sg/hrs/types}ItemKind" minOccurs="0"/>
 *                             &lt;element name="attachmentType" type="{http://ec.europa.eu/sg/hrs/types}AttachmentType" minOccurs="0"/>
 *                             &lt;element name="externalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="toStamp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="updateExternalSignatures" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}ExternalSignaturesToAdd" minOccurs="0"/>
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
@XmlType(name = "DocumentUpdateRequest", propOrder = {
    "documentId",
    "updateDocumentDetails",
    "updateSenders",
    "updateRecipients",
    "updateItems",
    "updateExternalSignatures"
})
public class DocumentUpdateRequest
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String documentId;
    protected DocumentUpdateRequest.UpdateDocumentDetails updateDocumentDetails;
    protected DocumentUpdateRequest.UpdateSenders updateSenders;
    protected DocumentUpdateRequest.UpdateRecipients updateRecipients;
    protected DocumentUpdateRequest.UpdateItems updateItems;
    protected DocumentUpdateRequest.UpdateExternalSignatures updateExternalSignatures;

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
     * Gets the value of the updateDocumentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentUpdateRequest.UpdateDocumentDetails }
     *     
     */
    public DocumentUpdateRequest.UpdateDocumentDetails getUpdateDocumentDetails() {
        return updateDocumentDetails;
    }

    /**
     * Sets the value of the updateDocumentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentUpdateRequest.UpdateDocumentDetails }
     *     
     */
    public void setUpdateDocumentDetails(DocumentUpdateRequest.UpdateDocumentDetails value) {
        this.updateDocumentDetails = value;
    }

    /**
     * Gets the value of the updateSenders property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentUpdateRequest.UpdateSenders }
     *     
     */
    public DocumentUpdateRequest.UpdateSenders getUpdateSenders() {
        return updateSenders;
    }

    /**
     * Sets the value of the updateSenders property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentUpdateRequest.UpdateSenders }
     *     
     */
    public void setUpdateSenders(DocumentUpdateRequest.UpdateSenders value) {
        this.updateSenders = value;
    }

    /**
     * Gets the value of the updateRecipients property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentUpdateRequest.UpdateRecipients }
     *     
     */
    public DocumentUpdateRequest.UpdateRecipients getUpdateRecipients() {
        return updateRecipients;
    }

    /**
     * Sets the value of the updateRecipients property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentUpdateRequest.UpdateRecipients }
     *     
     */
    public void setUpdateRecipients(DocumentUpdateRequest.UpdateRecipients value) {
        this.updateRecipients = value;
    }

    /**
     * Gets the value of the updateItems property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentUpdateRequest.UpdateItems }
     *     
     */
    public DocumentUpdateRequest.UpdateItems getUpdateItems() {
        return updateItems;
    }

    /**
     * Sets the value of the updateItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentUpdateRequest.UpdateItems }
     *     
     */
    public void setUpdateItems(DocumentUpdateRequest.UpdateItems value) {
        this.updateItems = value;
    }

    /**
     * Gets the value of the updateExternalSignatures property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentUpdateRequest.UpdateExternalSignatures }
     *     
     */
    public DocumentUpdateRequest.UpdateExternalSignatures getUpdateExternalSignatures() {
        return updateExternalSignatures;
    }

    /**
     * Sets the value of the updateExternalSignatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentUpdateRequest.UpdateExternalSignatures }
     *     
     */
    public void setUpdateExternalSignatures(DocumentUpdateRequest.UpdateExternalSignatures value) {
        this.updateExternalSignatures = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentUpdateRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentUpdateRequest that = ((DocumentUpdateRequest) object);
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
            DocumentUpdateRequest.UpdateDocumentDetails lhsUpdateDocumentDetails;
            lhsUpdateDocumentDetails = this.getUpdateDocumentDetails();
            DocumentUpdateRequest.UpdateDocumentDetails rhsUpdateDocumentDetails;
            rhsUpdateDocumentDetails = that.getUpdateDocumentDetails();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateDocumentDetails", lhsUpdateDocumentDetails), LocatorUtils.property(thatLocator, "updateDocumentDetails", rhsUpdateDocumentDetails), lhsUpdateDocumentDetails, rhsUpdateDocumentDetails)) {
                return false;
            }
        }
        {
            DocumentUpdateRequest.UpdateSenders lhsUpdateSenders;
            lhsUpdateSenders = this.getUpdateSenders();
            DocumentUpdateRequest.UpdateSenders rhsUpdateSenders;
            rhsUpdateSenders = that.getUpdateSenders();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateSenders", lhsUpdateSenders), LocatorUtils.property(thatLocator, "updateSenders", rhsUpdateSenders), lhsUpdateSenders, rhsUpdateSenders)) {
                return false;
            }
        }
        {
            DocumentUpdateRequest.UpdateRecipients lhsUpdateRecipients;
            lhsUpdateRecipients = this.getUpdateRecipients();
            DocumentUpdateRequest.UpdateRecipients rhsUpdateRecipients;
            rhsUpdateRecipients = that.getUpdateRecipients();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateRecipients", lhsUpdateRecipients), LocatorUtils.property(thatLocator, "updateRecipients", rhsUpdateRecipients), lhsUpdateRecipients, rhsUpdateRecipients)) {
                return false;
            }
        }
        {
            DocumentUpdateRequest.UpdateItems lhsUpdateItems;
            lhsUpdateItems = this.getUpdateItems();
            DocumentUpdateRequest.UpdateItems rhsUpdateItems;
            rhsUpdateItems = that.getUpdateItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateItems", lhsUpdateItems), LocatorUtils.property(thatLocator, "updateItems", rhsUpdateItems), lhsUpdateItems, rhsUpdateItems)) {
                return false;
            }
        }
        {
            DocumentUpdateRequest.UpdateExternalSignatures lhsUpdateExternalSignatures;
            lhsUpdateExternalSignatures = this.getUpdateExternalSignatures();
            DocumentUpdateRequest.UpdateExternalSignatures rhsUpdateExternalSignatures;
            rhsUpdateExternalSignatures = that.getUpdateExternalSignatures();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateExternalSignatures", lhsUpdateExternalSignatures), LocatorUtils.property(thatLocator, "updateExternalSignatures", rhsUpdateExternalSignatures), lhsUpdateExternalSignatures, rhsUpdateExternalSignatures)) {
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
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            strategy.appendField(locator, this, "documentId", buffer, theDocumentId);
        }
        {
            DocumentUpdateRequest.UpdateDocumentDetails theUpdateDocumentDetails;
            theUpdateDocumentDetails = this.getUpdateDocumentDetails();
            strategy.appendField(locator, this, "updateDocumentDetails", buffer, theUpdateDocumentDetails);
        }
        {
            DocumentUpdateRequest.UpdateSenders theUpdateSenders;
            theUpdateSenders = this.getUpdateSenders();
            strategy.appendField(locator, this, "updateSenders", buffer, theUpdateSenders);
        }
        {
            DocumentUpdateRequest.UpdateRecipients theUpdateRecipients;
            theUpdateRecipients = this.getUpdateRecipients();
            strategy.appendField(locator, this, "updateRecipients", buffer, theUpdateRecipients);
        }
        {
            DocumentUpdateRequest.UpdateItems theUpdateItems;
            theUpdateItems = this.getUpdateItems();
            strategy.appendField(locator, this, "updateItems", buffer, theUpdateItems);
        }
        {
            DocumentUpdateRequest.UpdateExternalSignatures theUpdateExternalSignatures;
            theUpdateExternalSignatures = this.getUpdateExternalSignatures();
            strategy.appendField(locator, this, "updateExternalSignatures", buffer, theUpdateExternalSignatures);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentId", theDocumentId), currentHashCode, theDocumentId);
        }
        {
            DocumentUpdateRequest.UpdateDocumentDetails theUpdateDocumentDetails;
            theUpdateDocumentDetails = this.getUpdateDocumentDetails();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateDocumentDetails", theUpdateDocumentDetails), currentHashCode, theUpdateDocumentDetails);
        }
        {
            DocumentUpdateRequest.UpdateSenders theUpdateSenders;
            theUpdateSenders = this.getUpdateSenders();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateSenders", theUpdateSenders), currentHashCode, theUpdateSenders);
        }
        {
            DocumentUpdateRequest.UpdateRecipients theUpdateRecipients;
            theUpdateRecipients = this.getUpdateRecipients();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateRecipients", theUpdateRecipients), currentHashCode, theUpdateRecipients);
        }
        {
            DocumentUpdateRequest.UpdateItems theUpdateItems;
            theUpdateItems = this.getUpdateItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateItems", theUpdateItems), currentHashCode, theUpdateItems);
        }
        {
            DocumentUpdateRequest.UpdateExternalSignatures theUpdateExternalSignatures;
            theUpdateExternalSignatures = this.getUpdateExternalSignatures();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateExternalSignatures", theUpdateExternalSignatures), currentHashCode, theUpdateExternalSignatures);
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
     *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="documentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="sentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="securityClassification" type="{http://ec.europa.eu/sg/hrs/types}SecurityClassification" minOccurs="0"/>
     *         &lt;element name="marking" type="{http://ec.europa.eu/sg/hrs/types}Marking" minOccurs="0"/>
     *         &lt;element name="removeMarking" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="classification" type="{http://ec.europa.eu/sg/hrs/types}Classification" minOccurs="0"/>
     *         &lt;element name="encryptItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="encryptItemsDeadline" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "title",
        "documentDate",
        "sentDate",
        "securityClassification",
        "marking",
        "removeMarking",
        "classification",
        "encryptItems",
        "encryptItemsDeadline",
        "comments"
    })
    public static class UpdateDocumentDetails
        implements Equals, HashCode, ToString
    {

        protected String title;
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar documentDate;
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar sentDate;
        protected SecurityClassification securityClassification;
        protected Marking marking;
        protected Boolean removeMarking;
        protected Classification classification;
        protected Boolean encryptItems;
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar encryptItemsDeadline;
        protected String comments;

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
         * Gets the value of the removeMarking property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isRemoveMarking() {
            return removeMarking;
        }

        /**
         * Sets the value of the removeMarking property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setRemoveMarking(Boolean value) {
            this.removeMarking = value;
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

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof DocumentUpdateRequest.UpdateDocumentDetails)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final DocumentUpdateRequest.UpdateDocumentDetails that = ((DocumentUpdateRequest.UpdateDocumentDetails) object);
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
                Boolean lhsRemoveMarking;
                lhsRemoveMarking = this.isRemoveMarking();
                Boolean rhsRemoveMarking;
                rhsRemoveMarking = that.isRemoveMarking();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "removeMarking", lhsRemoveMarking), LocatorUtils.property(thatLocator, "removeMarking", rhsRemoveMarking), lhsRemoveMarking, rhsRemoveMarking)) {
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
                Boolean theRemoveMarking;
                theRemoveMarking = this.isRemoveMarking();
                strategy.appendField(locator, this, "removeMarking", buffer, theRemoveMarking);
            }
            {
                Classification theClassification;
                theClassification = this.getClassification();
                strategy.appendField(locator, this, "classification", buffer, theClassification);
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
                Boolean theRemoveMarking;
                theRemoveMarking = this.isRemoveMarking();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "removeMarking", theRemoveMarking), currentHashCode, theRemoveMarking);
            }
            {
                Classification theClassification;
                theClassification = this.getClassification();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "classification", theClassification), currentHashCode, theClassification);
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
     *         &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}ExternalSignaturesToAdd" minOccurs="0"/>
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
        "add"
    })
    public static class UpdateExternalSignatures
        implements Equals, HashCode, ToString
    {

        protected ExternalSignaturesToAdd add;

        /**
         * Gets the value of the add property.
         * 
         * @return
         *     possible object is
         *     {@link ExternalSignaturesToAdd }
         *     
         */
        public ExternalSignaturesToAdd getAdd() {
            return add;
        }

        /**
         * Sets the value of the add property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExternalSignaturesToAdd }
         *     
         */
        public void setAdd(ExternalSignaturesToAdd value) {
            this.add = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof DocumentUpdateRequest.UpdateExternalSignatures)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final DocumentUpdateRequest.UpdateExternalSignatures that = ((DocumentUpdateRequest.UpdateExternalSignatures) object);
            {
                ExternalSignaturesToAdd lhsAdd;
                lhsAdd = this.getAdd();
                ExternalSignaturesToAdd rhsAdd;
                rhsAdd = that.getAdd();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "add", lhsAdd), LocatorUtils.property(thatLocator, "add", rhsAdd), lhsAdd, rhsAdd)) {
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
                ExternalSignaturesToAdd theAdd;
                theAdd = this.getAdd();
                strategy.appendField(locator, this, "add", buffer, theAdd);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                ExternalSignaturesToAdd theAdd;
                theAdd = this.getAdd();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "add", theAdd), currentHashCode, theAdd);
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
     *         &lt;element name="remove" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}ItemsToAdd" minOccurs="0"/>
     *         &lt;element name="updateDetails" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="language" type="{http://ec.europa.eu/sg/hrs/types}LanguageCode" minOccurs="0"/>
     *                   &lt;element name="kind" type="{http://ec.europa.eu/sg/hrs/types}ItemKind" minOccurs="0"/>
     *                   &lt;element name="attachmentType" type="{http://ec.europa.eu/sg/hrs/types}AttachmentType" minOccurs="0"/>
     *                   &lt;element name="externalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="toStamp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    @XmlType(name = "", propOrder = {
        "remove",
        "add",
        "updateDetails"
    })
    public static class UpdateItems
        implements Equals, HashCode, ToString
    {

        protected List<String> remove;
        protected ItemsToAdd add;
        protected List<DocumentUpdateRequest.UpdateItems.UpdateDetails> updateDetails;

        /**
         * Gets the value of the remove property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the remove property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRemove().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRemove() {
            if (remove == null) {
                remove = new ArrayList<String>();
            }
            return this.remove;
        }

        /**
         * Gets the value of the add property.
         * 
         * @return
         *     possible object is
         *     {@link ItemsToAdd }
         *     
         */
        public ItemsToAdd getAdd() {
            return add;
        }

        /**
         * Sets the value of the add property.
         * 
         * @param value
         *     allowed object is
         *     {@link ItemsToAdd }
         *     
         */
        public void setAdd(ItemsToAdd value) {
            this.add = value;
        }

        /**
         * Gets the value of the updateDetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the updateDetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUpdateDetails().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentUpdateRequest.UpdateItems.UpdateDetails }
         * 
         * 
         */
        public List<DocumentUpdateRequest.UpdateItems.UpdateDetails> getUpdateDetails() {
            if (updateDetails == null) {
                updateDetails = new ArrayList<DocumentUpdateRequest.UpdateItems.UpdateDetails>();
            }
            return this.updateDetails;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof DocumentUpdateRequest.UpdateItems)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final DocumentUpdateRequest.UpdateItems that = ((DocumentUpdateRequest.UpdateItems) object);
            {
                List<String> lhsRemove;
                lhsRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                List<String> rhsRemove;
                rhsRemove = (((that.remove!= null)&&(!that.remove.isEmpty()))?that.getRemove():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "remove", lhsRemove), LocatorUtils.property(thatLocator, "remove", rhsRemove), lhsRemove, rhsRemove)) {
                    return false;
                }
            }
            {
                ItemsToAdd lhsAdd;
                lhsAdd = this.getAdd();
                ItemsToAdd rhsAdd;
                rhsAdd = that.getAdd();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "add", lhsAdd), LocatorUtils.property(thatLocator, "add", rhsAdd), lhsAdd, rhsAdd)) {
                    return false;
                }
            }
            {
                List<DocumentUpdateRequest.UpdateItems.UpdateDetails> lhsUpdateDetails;
                lhsUpdateDetails = (((this.updateDetails!= null)&&(!this.updateDetails.isEmpty()))?this.getUpdateDetails():null);
                List<DocumentUpdateRequest.UpdateItems.UpdateDetails> rhsUpdateDetails;
                rhsUpdateDetails = (((that.updateDetails!= null)&&(!that.updateDetails.isEmpty()))?that.getUpdateDetails():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "updateDetails", lhsUpdateDetails), LocatorUtils.property(thatLocator, "updateDetails", rhsUpdateDetails), lhsUpdateDetails, rhsUpdateDetails)) {
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
                List<String> theRemove;
                theRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                strategy.appendField(locator, this, "remove", buffer, theRemove);
            }
            {
                ItemsToAdd theAdd;
                theAdd = this.getAdd();
                strategy.appendField(locator, this, "add", buffer, theAdd);
            }
            {
                List<DocumentUpdateRequest.UpdateItems.UpdateDetails> theUpdateDetails;
                theUpdateDetails = (((this.updateDetails!= null)&&(!this.updateDetails.isEmpty()))?this.getUpdateDetails():null);
                strategy.appendField(locator, this, "updateDetails", buffer, theUpdateDetails);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theRemove;
                theRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "remove", theRemove), currentHashCode, theRemove);
            }
            {
                ItemsToAdd theAdd;
                theAdd = this.getAdd();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "add", theAdd), currentHashCode, theAdd);
            }
            {
                List<DocumentUpdateRequest.UpdateItems.UpdateDetails> theUpdateDetails;
                theUpdateDetails = (((this.updateDetails!= null)&&(!this.updateDetails.isEmpty()))?this.getUpdateDetails():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateDetails", theUpdateDetails), currentHashCode, theUpdateDetails);
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
         *         &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="language" type="{http://ec.europa.eu/sg/hrs/types}LanguageCode" minOccurs="0"/>
         *         &lt;element name="kind" type="{http://ec.europa.eu/sg/hrs/types}ItemKind" minOccurs="0"/>
         *         &lt;element name="attachmentType" type="{http://ec.europa.eu/sg/hrs/types}AttachmentType" minOccurs="0"/>
         *         &lt;element name="externalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        @XmlType(name = "", propOrder = {
            "itemId",
            "name",
            "language",
            "kind",
            "attachmentType",
            "externalReference",
            "toStamp"
        })
        public static class UpdateDetails
            implements Equals, HashCode, ToString
        {

            @XmlElement(required = true)
            protected String itemId;
            protected String name;
            protected String language;
            protected ItemKind kind;
            protected AttachmentType attachmentType;
            protected String externalReference;
            @XmlElement(defaultValue = "true")
            protected Boolean toStamp;

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
                if (!(object instanceof DocumentUpdateRequest.UpdateItems.UpdateDetails)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final DocumentUpdateRequest.UpdateItems.UpdateDetails that = ((DocumentUpdateRequest.UpdateItems.UpdateDetails) object);
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
                    ItemKind lhsKind;
                    lhsKind = this.getKind();
                    ItemKind rhsKind;
                    rhsKind = that.getKind();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "kind", lhsKind), LocatorUtils.property(thatLocator, "kind", rhsKind), lhsKind, rhsKind)) {
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
                    String lhsExternalReference;
                    lhsExternalReference = this.getExternalReference();
                    String rhsExternalReference;
                    rhsExternalReference = that.getExternalReference();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "externalReference", lhsExternalReference), LocatorUtils.property(thatLocator, "externalReference", rhsExternalReference), lhsExternalReference, rhsExternalReference)) {
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
                    ItemKind theKind;
                    theKind = this.getKind();
                    strategy.appendField(locator, this, "kind", buffer, theKind);
                }
                {
                    AttachmentType theAttachmentType;
                    theAttachmentType = this.getAttachmentType();
                    strategy.appendField(locator, this, "attachmentType", buffer, theAttachmentType);
                }
                {
                    String theExternalReference;
                    theExternalReference = this.getExternalReference();
                    strategy.appendField(locator, this, "externalReference", buffer, theExternalReference);
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
                    ItemKind theKind;
                    theKind = this.getKind();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "kind", theKind), currentHashCode, theKind);
                }
                {
                    AttachmentType theAttachmentType;
                    theAttachmentType = this.getAttachmentType();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentType", theAttachmentType), currentHashCode, theAttachmentType);
                }
                {
                    String theExternalReference;
                    theExternalReference = this.getExternalReference();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalReference", theExternalReference), currentHashCode, theExternalReference);
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
     *         &lt;element name="remove" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}RecipientToAdd" maxOccurs="unbounded" minOccurs="0"/>
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
        "remove",
        "add"
    })
    public static class UpdateRecipients
        implements Equals, HashCode, ToString
    {

        protected List<String> remove;
        protected List<RecipientToAdd> add;

        /**
         * Gets the value of the remove property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the remove property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRemove().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRemove() {
            if (remove == null) {
                remove = new ArrayList<String>();
            }
            return this.remove;
        }

        /**
         * Gets the value of the add property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the add property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdd().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RecipientToAdd }
         * 
         * 
         */
        public List<RecipientToAdd> getAdd() {
            if (add == null) {
                add = new ArrayList<RecipientToAdd>();
            }
            return this.add;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof DocumentUpdateRequest.UpdateRecipients)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final DocumentUpdateRequest.UpdateRecipients that = ((DocumentUpdateRequest.UpdateRecipients) object);
            {
                List<String> lhsRemove;
                lhsRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                List<String> rhsRemove;
                rhsRemove = (((that.remove!= null)&&(!that.remove.isEmpty()))?that.getRemove():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "remove", lhsRemove), LocatorUtils.property(thatLocator, "remove", rhsRemove), lhsRemove, rhsRemove)) {
                    return false;
                }
            }
            {
                List<RecipientToAdd> lhsAdd;
                lhsAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                List<RecipientToAdd> rhsAdd;
                rhsAdd = (((that.add!= null)&&(!that.add.isEmpty()))?that.getAdd():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "add", lhsAdd), LocatorUtils.property(thatLocator, "add", rhsAdd), lhsAdd, rhsAdd)) {
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
                List<String> theRemove;
                theRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                strategy.appendField(locator, this, "remove", buffer, theRemove);
            }
            {
                List<RecipientToAdd> theAdd;
                theAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                strategy.appendField(locator, this, "add", buffer, theAdd);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theRemove;
                theRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "remove", theRemove), currentHashCode, theRemove);
            }
            {
                List<RecipientToAdd> theAdd;
                theAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "add", theAdd), currentHashCode, theAdd);
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
     *         &lt;element name="remove" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}CurrentEntityToAdd" maxOccurs="unbounded" minOccurs="0"/>
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
        "remove",
        "add"
    })
    public static class UpdateSenders
        implements Equals, HashCode, ToString
    {

        protected List<String> remove;
        protected List<CurrentEntityToAdd> add;

        /**
         * Gets the value of the remove property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the remove property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRemove().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRemove() {
            if (remove == null) {
                remove = new ArrayList<String>();
            }
            return this.remove;
        }

        /**
         * Gets the value of the add property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the add property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdd().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CurrentEntityToAdd }
         * 
         * 
         */
        public List<CurrentEntityToAdd> getAdd() {
            if (add == null) {
                add = new ArrayList<CurrentEntityToAdd>();
            }
            return this.add;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof DocumentUpdateRequest.UpdateSenders)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final DocumentUpdateRequest.UpdateSenders that = ((DocumentUpdateRequest.UpdateSenders) object);
            {
                List<String> lhsRemove;
                lhsRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                List<String> rhsRemove;
                rhsRemove = (((that.remove!= null)&&(!that.remove.isEmpty()))?that.getRemove():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "remove", lhsRemove), LocatorUtils.property(thatLocator, "remove", rhsRemove), lhsRemove, rhsRemove)) {
                    return false;
                }
            }
            {
                List<CurrentEntityToAdd> lhsAdd;
                lhsAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                List<CurrentEntityToAdd> rhsAdd;
                rhsAdd = (((that.add!= null)&&(!that.add.isEmpty()))?that.getAdd():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "add", lhsAdd), LocatorUtils.property(thatLocator, "add", rhsAdd), lhsAdd, rhsAdd)) {
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
                List<String> theRemove;
                theRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                strategy.appendField(locator, this, "remove", buffer, theRemove);
            }
            {
                List<CurrentEntityToAdd> theAdd;
                theAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                strategy.appendField(locator, this, "add", buffer, theAdd);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theRemove;
                theRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "remove", theRemove), currentHashCode, theRemove);
            }
            {
                List<CurrentEntityToAdd> theAdd;
                theAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "add", theAdd), currentHashCode, theAdd);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
