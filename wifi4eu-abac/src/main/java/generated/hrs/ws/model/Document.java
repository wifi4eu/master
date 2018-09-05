
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
 * A document
 * 
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mailType" type="{http://ec.europa.eu/sg/hrs/types}MailType" minOccurs="0"/>
 *         &lt;element name="documentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="sentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="encodingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="modificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="registrationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="saveNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="registrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saverEcasId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="registererEcasId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createdOnBehalfOf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="securityClassification" type="{http://ec.europa.eu/sg/hrs/types}SecurityClassification" minOccurs="0"/>
 *         &lt;element name="markerType" type="{http://ec.europa.eu/sg/hrs/types}MarkerType" minOccurs="0"/>
 *         &lt;element name="markerDeadline" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="markerExpiryEvent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="classificationDeadline" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="classificationExpiryEvent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personConcerned" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="internalEntity" type="{http://ec.europa.eu/sg/hrs/types}InternalEntity"/>
 *                     &lt;element name="externalEntity" type="{http://ec.europa.eu/sg/hrs/types}ExternalEntity"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="markerService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="encryptItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="encryptItemsDeadline" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="frozen" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="noteToTheFile" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="senders" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="sender" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;choice>
 *                               &lt;element name="internalEntity" type="{http://ec.europa.eu/sg/hrs/types}InternalEntity"/>
 *                               &lt;element name="externalEntity" type="{http://ec.europa.eu/sg/hrs/types}ExternalEntity"/>
 *                             &lt;/choice>
 *                             &lt;element name="validForRegistration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
 *         &lt;element name="recipients" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="recipient" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;choice>
 *                               &lt;element name="internalEntity" type="{http://ec.europa.eu/sg/hrs/types}InternalEntity"/>
 *                               &lt;element name="externalEntity" type="{http://ec.europa.eu/sg/hrs/types}ExternalEntity"/>
 *                             &lt;/choice>
 *                             &lt;element name="code" type="{http://ec.europa.eu/sg/hrs/types}RecipientCode"/>
 *                             &lt;element name="validForRegistration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
 *         &lt;element name="items" minOccurs="0">
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
 *         &lt;element name="filedIn" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="file" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="fileId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *                             &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="chefDeFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="fileCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="specificCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="status" type="{http://ec.europa.eu/sg/hrs/types}FileStatus" minOccurs="0"/>
 *                             &lt;element name="englishName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="frenchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="germanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="filingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
 *         &lt;element name="links" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="link" type="{http://ec.europa.eu/sg/hrs/types}Link" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="assignmentWorkflow" type="{http://ec.europa.eu/sg/hrs/types}AssignmentWorkflow" minOccurs="0"/>
 *         &lt;element name="signatoryWorkflow" type="{http://ec.europa.eu/sg/hrs/types}SignatoryWorkflow" minOccurs="0"/>
 *         &lt;element name="supportingItems" type="{http://ec.europa.eu/sg/hrs/types}SupportingItems" minOccurs="0"/>
 *         &lt;element name="procedure" type="{http://ec.europa.eu/sg/hrs/types}Procedure" minOccurs="0"/>
 *         &lt;element name="signedBy" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="user" type="{http://ec.europa.eu/sg/hrs/types}WorkflowUser"/>
 *                   &lt;element name="on" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="externalizationDetails" type="{http://ec.europa.eu/sg/hrs/types}ExternalizationDetails" minOccurs="0"/>
 *         &lt;element name="specificMetadata" type="{http://ec.europa.eu/sg/hrs/types}SpecificMetadata" minOccurs="0"/>
 *         &lt;element name="signAndLock" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="partitionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="specificMetadataItems" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="specificMetadataItem" type="{http://ec.europa.eu/sg/hrs/types}SpecificMetadataItem" maxOccurs="10"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="externalSignatures" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="externalSignature" type="{http://ec.europa.eu/sg/hrs/types}ExternalSignature" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="accessibilityInfo" type="{http://ec.europa.eu/sg/hrs/types}AccessibilityInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "documentId",
    "title",
    "mailType",
    "documentDate",
    "sentDate",
    "encodingDate",
    "modificationDate",
    "registrationDate",
    "saveNumber",
    "registrationNumber",
    "saverEcasId",
    "registererEcasId",
    "createdOnBehalfOf",
    "comments",
    "securityClassification",
    "markerType",
    "markerDeadline",
    "markerExpiryEvent",
    "classificationDeadline",
    "classificationExpiryEvent",
    "personConcerned",
    "markerService",
    "encryptItems",
    "encryptItemsDeadline",
    "frozen",
    "noteToTheFile",
    "senders",
    "recipients",
    "items",
    "filedIn",
    "links",
    "assignmentWorkflow",
    "signatoryWorkflow",
    "supportingItems",
    "procedure",
    "signedBy",
    "externalizationDetails",
    "specificMetadata",
    "signAndLock",
    "partitionId",
    "specificMetadataItems",
    "externalSignatures",
    "accessibilityInfo"
})
public class Document
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String documentId;
    protected String title;
    protected MailType mailType;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar documentDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar sentDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar encodingDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modificationDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar registrationDate;
    protected String saveNumber;
    protected String registrationNumber;
    protected String saverEcasId;
    protected String registererEcasId;
    protected String createdOnBehalfOf;
    protected String comments;
    protected SecurityClassification securityClassification;
    protected MarkerType markerType;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar markerDeadline;
    protected String markerExpiryEvent;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar classificationDeadline;
    protected String classificationExpiryEvent;
    protected Document.PersonConcerned personConcerned;
    protected String markerService;
    protected Boolean encryptItems;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar encryptItemsDeadline;
    protected Boolean frozen;
    protected Boolean noteToTheFile;
    protected Document.Senders senders;
    protected Document.Recipients recipients;
    protected Document.Items items;
    protected Document.FiledIn filedIn;
    protected Document.Links links;
    protected AssignmentWorkflow assignmentWorkflow;
    protected SignatoryWorkflow signatoryWorkflow;
    protected SupportingItems supportingItems;
    protected Procedure procedure;
    protected List<Document.SignedBy> signedBy;
    protected ExternalizationDetails externalizationDetails;
    protected SpecificMetadata specificMetadata;
    protected Boolean signAndLock;
    protected Integer partitionId;
    protected Document.SpecificMetadataItems specificMetadataItems;
    protected Document.ExternalSignatures externalSignatures;
    protected AccessibilityInfo accessibilityInfo;

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
     * Gets the value of the mailType property.
     * 
     * @return
     *     possible object is
     *     {@link MailType }
     *     
     */
    public MailType getMailType() {
        return mailType;
    }

    /**
     * Sets the value of the mailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MailType }
     *     
     */
    public void setMailType(MailType value) {
        this.mailType = value;
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
     * Gets the value of the encodingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEncodingDate() {
        return encodingDate;
    }

    /**
     * Sets the value of the encodingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEncodingDate(XMLGregorianCalendar value) {
        this.encodingDate = value;
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
     * Gets the value of the registrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the value of the registrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegistrationDate(XMLGregorianCalendar value) {
        this.registrationDate = value;
    }

    /**
     * Gets the value of the saveNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaveNumber() {
        return saveNumber;
    }

    /**
     * Sets the value of the saveNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaveNumber(String value) {
        this.saveNumber = value;
    }

    /**
     * Gets the value of the registrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Sets the value of the registrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationNumber(String value) {
        this.registrationNumber = value;
    }

    /**
     * Gets the value of the saverEcasId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaverEcasId() {
        return saverEcasId;
    }

    /**
     * Sets the value of the saverEcasId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaverEcasId(String value) {
        this.saverEcasId = value;
    }

    /**
     * Gets the value of the registererEcasId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistererEcasId() {
        return registererEcasId;
    }

    /**
     * Sets the value of the registererEcasId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistererEcasId(String value) {
        this.registererEcasId = value;
    }

    /**
     * Gets the value of the createdOnBehalfOf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedOnBehalfOf() {
        return createdOnBehalfOf;
    }

    /**
     * Sets the value of the createdOnBehalfOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedOnBehalfOf(String value) {
        this.createdOnBehalfOf = value;
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
     * Gets the value of the markerType property.
     * 
     * @return
     *     possible object is
     *     {@link MarkerType }
     *     
     */
    public MarkerType getMarkerType() {
        return markerType;
    }

    /**
     * Sets the value of the markerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkerType }
     *     
     */
    public void setMarkerType(MarkerType value) {
        this.markerType = value;
    }

    /**
     * Gets the value of the markerDeadline property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMarkerDeadline() {
        return markerDeadline;
    }

    /**
     * Sets the value of the markerDeadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMarkerDeadline(XMLGregorianCalendar value) {
        this.markerDeadline = value;
    }

    /**
     * Gets the value of the markerExpiryEvent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkerExpiryEvent() {
        return markerExpiryEvent;
    }

    /**
     * Sets the value of the markerExpiryEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkerExpiryEvent(String value) {
        this.markerExpiryEvent = value;
    }

    /**
     * Gets the value of the classificationDeadline property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClassificationDeadline() {
        return classificationDeadline;
    }

    /**
     * Sets the value of the classificationDeadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClassificationDeadline(XMLGregorianCalendar value) {
        this.classificationDeadline = value;
    }

    /**
     * Gets the value of the classificationExpiryEvent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassificationExpiryEvent() {
        return classificationExpiryEvent;
    }

    /**
     * Sets the value of the classificationExpiryEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassificationExpiryEvent(String value) {
        this.classificationExpiryEvent = value;
    }

    /**
     * Gets the value of the personConcerned property.
     * 
     * @return
     *     possible object is
     *     {@link Document.PersonConcerned }
     *     
     */
    public Document.PersonConcerned getPersonConcerned() {
        return personConcerned;
    }

    /**
     * Sets the value of the personConcerned property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document.PersonConcerned }
     *     
     */
    public void setPersonConcerned(Document.PersonConcerned value) {
        this.personConcerned = value;
    }

    /**
     * Gets the value of the markerService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkerService() {
        return markerService;
    }

    /**
     * Sets the value of the markerService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkerService(String value) {
        this.markerService = value;
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
     * Gets the value of the frozen property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFrozen() {
        return frozen;
    }

    /**
     * Sets the value of the frozen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFrozen(Boolean value) {
        this.frozen = value;
    }

    /**
     * Gets the value of the noteToTheFile property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoteToTheFile() {
        return noteToTheFile;
    }

    /**
     * Sets the value of the noteToTheFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoteToTheFile(Boolean value) {
        this.noteToTheFile = value;
    }

    /**
     * Gets the value of the senders property.
     * 
     * @return
     *     possible object is
     *     {@link Document.Senders }
     *     
     */
    public Document.Senders getSenders() {
        return senders;
    }

    /**
     * Sets the value of the senders property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document.Senders }
     *     
     */
    public void setSenders(Document.Senders value) {
        this.senders = value;
    }

    /**
     * Gets the value of the recipients property.
     * 
     * @return
     *     possible object is
     *     {@link Document.Recipients }
     *     
     */
    public Document.Recipients getRecipients() {
        return recipients;
    }

    /**
     * Sets the value of the recipients property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document.Recipients }
     *     
     */
    public void setRecipients(Document.Recipients value) {
        this.recipients = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link Document.Items }
     *     
     */
    public Document.Items getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document.Items }
     *     
     */
    public void setItems(Document.Items value) {
        this.items = value;
    }

    /**
     * Gets the value of the filedIn property.
     * 
     * @return
     *     possible object is
     *     {@link Document.FiledIn }
     *     
     */
    public Document.FiledIn getFiledIn() {
        return filedIn;
    }

    /**
     * Sets the value of the filedIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document.FiledIn }
     *     
     */
    public void setFiledIn(Document.FiledIn value) {
        this.filedIn = value;
    }

    /**
     * Gets the value of the links property.
     * 
     * @return
     *     possible object is
     *     {@link Document.Links }
     *     
     */
    public Document.Links getLinks() {
        return links;
    }

    /**
     * Sets the value of the links property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document.Links }
     *     
     */
    public void setLinks(Document.Links value) {
        this.links = value;
    }

    /**
     * Gets the value of the assignmentWorkflow property.
     * 
     * @return
     *     possible object is
     *     {@link AssignmentWorkflow }
     *     
     */
    public AssignmentWorkflow getAssignmentWorkflow() {
        return assignmentWorkflow;
    }

    /**
     * Sets the value of the assignmentWorkflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignmentWorkflow }
     *     
     */
    public void setAssignmentWorkflow(AssignmentWorkflow value) {
        this.assignmentWorkflow = value;
    }

    /**
     * Gets the value of the signatoryWorkflow property.
     * 
     * @return
     *     possible object is
     *     {@link SignatoryWorkflow }
     *     
     */
    public SignatoryWorkflow getSignatoryWorkflow() {
        return signatoryWorkflow;
    }

    /**
     * Sets the value of the signatoryWorkflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatoryWorkflow }
     *     
     */
    public void setSignatoryWorkflow(SignatoryWorkflow value) {
        this.signatoryWorkflow = value;
    }

    /**
     * Gets the value of the supportingItems property.
     * 
     * @return
     *     possible object is
     *     {@link SupportingItems }
     *     
     */
    public SupportingItems getSupportingItems() {
        return supportingItems;
    }

    /**
     * Sets the value of the supportingItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportingItems }
     *     
     */
    public void setSupportingItems(SupportingItems value) {
        this.supportingItems = value;
    }

    /**
     * Gets the value of the procedure property.
     * 
     * @return
     *     possible object is
     *     {@link Procedure }
     *     
     */
    public Procedure getProcedure() {
        return procedure;
    }

    /**
     * Sets the value of the procedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Procedure }
     *     
     */
    public void setProcedure(Procedure value) {
        this.procedure = value;
    }

    /**
     * Gets the value of the signedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Document.SignedBy }
     * 
     * 
     */
    public List<Document.SignedBy> getSignedBy() {
        if (signedBy == null) {
            signedBy = new ArrayList<Document.SignedBy>();
        }
        return this.signedBy;
    }

    /**
     * Gets the value of the externalizationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalizationDetails }
     *     
     */
    public ExternalizationDetails getExternalizationDetails() {
        return externalizationDetails;
    }

    /**
     * Sets the value of the externalizationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalizationDetails }
     *     
     */
    public void setExternalizationDetails(ExternalizationDetails value) {
        this.externalizationDetails = value;
    }

    /**
     * Gets the value of the specificMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link SpecificMetadata }
     *     
     */
    public SpecificMetadata getSpecificMetadata() {
        return specificMetadata;
    }

    /**
     * Sets the value of the specificMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecificMetadata }
     *     
     */
    public void setSpecificMetadata(SpecificMetadata value) {
        this.specificMetadata = value;
    }

    /**
     * Gets the value of the signAndLock property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSignAndLock() {
        return signAndLock;
    }

    /**
     * Sets the value of the signAndLock property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSignAndLock(Boolean value) {
        this.signAndLock = value;
    }

    /**
     * Gets the value of the partitionId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPartitionId() {
        return partitionId;
    }

    /**
     * Sets the value of the partitionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPartitionId(Integer value) {
        this.partitionId = value;
    }

    /**
     * Gets the value of the specificMetadataItems property.
     * 
     * @return
     *     possible object is
     *     {@link Document.SpecificMetadataItems }
     *     
     */
    public Document.SpecificMetadataItems getSpecificMetadataItems() {
        return specificMetadataItems;
    }

    /**
     * Sets the value of the specificMetadataItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document.SpecificMetadataItems }
     *     
     */
    public void setSpecificMetadataItems(Document.SpecificMetadataItems value) {
        this.specificMetadataItems = value;
    }

    /**
     * Gets the value of the externalSignatures property.
     * 
     * @return
     *     possible object is
     *     {@link Document.ExternalSignatures }
     *     
     */
    public Document.ExternalSignatures getExternalSignatures() {
        return externalSignatures;
    }

    /**
     * Sets the value of the externalSignatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document.ExternalSignatures }
     *     
     */
    public void setExternalSignatures(Document.ExternalSignatures value) {
        this.externalSignatures = value;
    }

    /**
     * Gets the value of the accessibilityInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AccessibilityInfo }
     *     
     */
    public AccessibilityInfo getAccessibilityInfo() {
        return accessibilityInfo;
    }

    /**
     * Sets the value of the accessibilityInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessibilityInfo }
     *     
     */
    public void setAccessibilityInfo(AccessibilityInfo value) {
        this.accessibilityInfo = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Document)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Document that = ((Document) object);
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
            String lhsTitle;
            lhsTitle = this.getTitle();
            String rhsTitle;
            rhsTitle = that.getTitle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "title", lhsTitle), LocatorUtils.property(thatLocator, "title", rhsTitle), lhsTitle, rhsTitle)) {
                return false;
            }
        }
        {
            MailType lhsMailType;
            lhsMailType = this.getMailType();
            MailType rhsMailType;
            rhsMailType = that.getMailType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mailType", lhsMailType), LocatorUtils.property(thatLocator, "mailType", rhsMailType), lhsMailType, rhsMailType)) {
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
            XMLGregorianCalendar lhsEncodingDate;
            lhsEncodingDate = this.getEncodingDate();
            XMLGregorianCalendar rhsEncodingDate;
            rhsEncodingDate = that.getEncodingDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "encodingDate", lhsEncodingDate), LocatorUtils.property(thatLocator, "encodingDate", rhsEncodingDate), lhsEncodingDate, rhsEncodingDate)) {
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
            XMLGregorianCalendar lhsRegistrationDate;
            lhsRegistrationDate = this.getRegistrationDate();
            XMLGregorianCalendar rhsRegistrationDate;
            rhsRegistrationDate = that.getRegistrationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationDate", lhsRegistrationDate), LocatorUtils.property(thatLocator, "registrationDate", rhsRegistrationDate), lhsRegistrationDate, rhsRegistrationDate)) {
                return false;
            }
        }
        {
            String lhsSaveNumber;
            lhsSaveNumber = this.getSaveNumber();
            String rhsSaveNumber;
            rhsSaveNumber = that.getSaveNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "saveNumber", lhsSaveNumber), LocatorUtils.property(thatLocator, "saveNumber", rhsSaveNumber), lhsSaveNumber, rhsSaveNumber)) {
                return false;
            }
        }
        {
            String lhsRegistrationNumber;
            lhsRegistrationNumber = this.getRegistrationNumber();
            String rhsRegistrationNumber;
            rhsRegistrationNumber = that.getRegistrationNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationNumber", lhsRegistrationNumber), LocatorUtils.property(thatLocator, "registrationNumber", rhsRegistrationNumber), lhsRegistrationNumber, rhsRegistrationNumber)) {
                return false;
            }
        }
        {
            String lhsSaverEcasId;
            lhsSaverEcasId = this.getSaverEcasId();
            String rhsSaverEcasId;
            rhsSaverEcasId = that.getSaverEcasId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "saverEcasId", lhsSaverEcasId), LocatorUtils.property(thatLocator, "saverEcasId", rhsSaverEcasId), lhsSaverEcasId, rhsSaverEcasId)) {
                return false;
            }
        }
        {
            String lhsRegistererEcasId;
            lhsRegistererEcasId = this.getRegistererEcasId();
            String rhsRegistererEcasId;
            rhsRegistererEcasId = that.getRegistererEcasId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "registererEcasId", lhsRegistererEcasId), LocatorUtils.property(thatLocator, "registererEcasId", rhsRegistererEcasId), lhsRegistererEcasId, rhsRegistererEcasId)) {
                return false;
            }
        }
        {
            String lhsCreatedOnBehalfOf;
            lhsCreatedOnBehalfOf = this.getCreatedOnBehalfOf();
            String rhsCreatedOnBehalfOf;
            rhsCreatedOnBehalfOf = that.getCreatedOnBehalfOf();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "createdOnBehalfOf", lhsCreatedOnBehalfOf), LocatorUtils.property(thatLocator, "createdOnBehalfOf", rhsCreatedOnBehalfOf), lhsCreatedOnBehalfOf, rhsCreatedOnBehalfOf)) {
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
            SecurityClassification lhsSecurityClassification;
            lhsSecurityClassification = this.getSecurityClassification();
            SecurityClassification rhsSecurityClassification;
            rhsSecurityClassification = that.getSecurityClassification();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityClassification", lhsSecurityClassification), LocatorUtils.property(thatLocator, "securityClassification", rhsSecurityClassification), lhsSecurityClassification, rhsSecurityClassification)) {
                return false;
            }
        }
        {
            MarkerType lhsMarkerType;
            lhsMarkerType = this.getMarkerType();
            MarkerType rhsMarkerType;
            rhsMarkerType = that.getMarkerType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "markerType", lhsMarkerType), LocatorUtils.property(thatLocator, "markerType", rhsMarkerType), lhsMarkerType, rhsMarkerType)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsMarkerDeadline;
            lhsMarkerDeadline = this.getMarkerDeadline();
            XMLGregorianCalendar rhsMarkerDeadline;
            rhsMarkerDeadline = that.getMarkerDeadline();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "markerDeadline", lhsMarkerDeadline), LocatorUtils.property(thatLocator, "markerDeadline", rhsMarkerDeadline), lhsMarkerDeadline, rhsMarkerDeadline)) {
                return false;
            }
        }
        {
            String lhsMarkerExpiryEvent;
            lhsMarkerExpiryEvent = this.getMarkerExpiryEvent();
            String rhsMarkerExpiryEvent;
            rhsMarkerExpiryEvent = that.getMarkerExpiryEvent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "markerExpiryEvent", lhsMarkerExpiryEvent), LocatorUtils.property(thatLocator, "markerExpiryEvent", rhsMarkerExpiryEvent), lhsMarkerExpiryEvent, rhsMarkerExpiryEvent)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsClassificationDeadline;
            lhsClassificationDeadline = this.getClassificationDeadline();
            XMLGregorianCalendar rhsClassificationDeadline;
            rhsClassificationDeadline = that.getClassificationDeadline();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "classificationDeadline", lhsClassificationDeadline), LocatorUtils.property(thatLocator, "classificationDeadline", rhsClassificationDeadline), lhsClassificationDeadline, rhsClassificationDeadline)) {
                return false;
            }
        }
        {
            String lhsClassificationExpiryEvent;
            lhsClassificationExpiryEvent = this.getClassificationExpiryEvent();
            String rhsClassificationExpiryEvent;
            rhsClassificationExpiryEvent = that.getClassificationExpiryEvent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "classificationExpiryEvent", lhsClassificationExpiryEvent), LocatorUtils.property(thatLocator, "classificationExpiryEvent", rhsClassificationExpiryEvent), lhsClassificationExpiryEvent, rhsClassificationExpiryEvent)) {
                return false;
            }
        }
        {
            Document.PersonConcerned lhsPersonConcerned;
            lhsPersonConcerned = this.getPersonConcerned();
            Document.PersonConcerned rhsPersonConcerned;
            rhsPersonConcerned = that.getPersonConcerned();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "personConcerned", lhsPersonConcerned), LocatorUtils.property(thatLocator, "personConcerned", rhsPersonConcerned), lhsPersonConcerned, rhsPersonConcerned)) {
                return false;
            }
        }
        {
            String lhsMarkerService;
            lhsMarkerService = this.getMarkerService();
            String rhsMarkerService;
            rhsMarkerService = that.getMarkerService();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "markerService", lhsMarkerService), LocatorUtils.property(thatLocator, "markerService", rhsMarkerService), lhsMarkerService, rhsMarkerService)) {
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
            Boolean lhsFrozen;
            lhsFrozen = this.isFrozen();
            Boolean rhsFrozen;
            rhsFrozen = that.isFrozen();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "frozen", lhsFrozen), LocatorUtils.property(thatLocator, "frozen", rhsFrozen), lhsFrozen, rhsFrozen)) {
                return false;
            }
        }
        {
            Boolean lhsNoteToTheFile;
            lhsNoteToTheFile = this.isNoteToTheFile();
            Boolean rhsNoteToTheFile;
            rhsNoteToTheFile = that.isNoteToTheFile();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "noteToTheFile", lhsNoteToTheFile), LocatorUtils.property(thatLocator, "noteToTheFile", rhsNoteToTheFile), lhsNoteToTheFile, rhsNoteToTheFile)) {
                return false;
            }
        }
        {
            Document.Senders lhsSenders;
            lhsSenders = this.getSenders();
            Document.Senders rhsSenders;
            rhsSenders = that.getSenders();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "senders", lhsSenders), LocatorUtils.property(thatLocator, "senders", rhsSenders), lhsSenders, rhsSenders)) {
                return false;
            }
        }
        {
            Document.Recipients lhsRecipients;
            lhsRecipients = this.getRecipients();
            Document.Recipients rhsRecipients;
            rhsRecipients = that.getRecipients();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recipients", lhsRecipients), LocatorUtils.property(thatLocator, "recipients", rhsRecipients), lhsRecipients, rhsRecipients)) {
                return false;
            }
        }
        {
            Document.Items lhsItems;
            lhsItems = this.getItems();
            Document.Items rhsItems;
            rhsItems = that.getItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "items", lhsItems), LocatorUtils.property(thatLocator, "items", rhsItems), lhsItems, rhsItems)) {
                return false;
            }
        }
        {
            Document.FiledIn lhsFiledIn;
            lhsFiledIn = this.getFiledIn();
            Document.FiledIn rhsFiledIn;
            rhsFiledIn = that.getFiledIn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "filedIn", lhsFiledIn), LocatorUtils.property(thatLocator, "filedIn", rhsFiledIn), lhsFiledIn, rhsFiledIn)) {
                return false;
            }
        }
        {
            Document.Links lhsLinks;
            lhsLinks = this.getLinks();
            Document.Links rhsLinks;
            rhsLinks = that.getLinks();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "links", lhsLinks), LocatorUtils.property(thatLocator, "links", rhsLinks), lhsLinks, rhsLinks)) {
                return false;
            }
        }
        {
            AssignmentWorkflow lhsAssignmentWorkflow;
            lhsAssignmentWorkflow = this.getAssignmentWorkflow();
            AssignmentWorkflow rhsAssignmentWorkflow;
            rhsAssignmentWorkflow = that.getAssignmentWorkflow();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assignmentWorkflow", lhsAssignmentWorkflow), LocatorUtils.property(thatLocator, "assignmentWorkflow", rhsAssignmentWorkflow), lhsAssignmentWorkflow, rhsAssignmentWorkflow)) {
                return false;
            }
        }
        {
            SignatoryWorkflow lhsSignatoryWorkflow;
            lhsSignatoryWorkflow = this.getSignatoryWorkflow();
            SignatoryWorkflow rhsSignatoryWorkflow;
            rhsSignatoryWorkflow = that.getSignatoryWorkflow();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signatoryWorkflow", lhsSignatoryWorkflow), LocatorUtils.property(thatLocator, "signatoryWorkflow", rhsSignatoryWorkflow), lhsSignatoryWorkflow, rhsSignatoryWorkflow)) {
                return false;
            }
        }
        {
            SupportingItems lhsSupportingItems;
            lhsSupportingItems = this.getSupportingItems();
            SupportingItems rhsSupportingItems;
            rhsSupportingItems = that.getSupportingItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "supportingItems", lhsSupportingItems), LocatorUtils.property(thatLocator, "supportingItems", rhsSupportingItems), lhsSupportingItems, rhsSupportingItems)) {
                return false;
            }
        }
        {
            Procedure lhsProcedure;
            lhsProcedure = this.getProcedure();
            Procedure rhsProcedure;
            rhsProcedure = that.getProcedure();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "procedure", lhsProcedure), LocatorUtils.property(thatLocator, "procedure", rhsProcedure), lhsProcedure, rhsProcedure)) {
                return false;
            }
        }
        {
            List<Document.SignedBy> lhsSignedBy;
            lhsSignedBy = (((this.signedBy!= null)&&(!this.signedBy.isEmpty()))?this.getSignedBy():null);
            List<Document.SignedBy> rhsSignedBy;
            rhsSignedBy = (((that.signedBy!= null)&&(!that.signedBy.isEmpty()))?that.getSignedBy():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signedBy", lhsSignedBy), LocatorUtils.property(thatLocator, "signedBy", rhsSignedBy), lhsSignedBy, rhsSignedBy)) {
                return false;
            }
        }
        {
            ExternalizationDetails lhsExternalizationDetails;
            lhsExternalizationDetails = this.getExternalizationDetails();
            ExternalizationDetails rhsExternalizationDetails;
            rhsExternalizationDetails = that.getExternalizationDetails();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalizationDetails", lhsExternalizationDetails), LocatorUtils.property(thatLocator, "externalizationDetails", rhsExternalizationDetails), lhsExternalizationDetails, rhsExternalizationDetails)) {
                return false;
            }
        }
        {
            SpecificMetadata lhsSpecificMetadata;
            lhsSpecificMetadata = this.getSpecificMetadata();
            SpecificMetadata rhsSpecificMetadata;
            rhsSpecificMetadata = that.getSpecificMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "specificMetadata", lhsSpecificMetadata), LocatorUtils.property(thatLocator, "specificMetadata", rhsSpecificMetadata), lhsSpecificMetadata, rhsSpecificMetadata)) {
                return false;
            }
        }
        {
            Boolean lhsSignAndLock;
            lhsSignAndLock = this.isSignAndLock();
            Boolean rhsSignAndLock;
            rhsSignAndLock = that.isSignAndLock();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signAndLock", lhsSignAndLock), LocatorUtils.property(thatLocator, "signAndLock", rhsSignAndLock), lhsSignAndLock, rhsSignAndLock)) {
                return false;
            }
        }
        {
            Integer lhsPartitionId;
            lhsPartitionId = this.getPartitionId();
            Integer rhsPartitionId;
            rhsPartitionId = that.getPartitionId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "partitionId", lhsPartitionId), LocatorUtils.property(thatLocator, "partitionId", rhsPartitionId), lhsPartitionId, rhsPartitionId)) {
                return false;
            }
        }
        {
            Document.SpecificMetadataItems lhsSpecificMetadataItems;
            lhsSpecificMetadataItems = this.getSpecificMetadataItems();
            Document.SpecificMetadataItems rhsSpecificMetadataItems;
            rhsSpecificMetadataItems = that.getSpecificMetadataItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "specificMetadataItems", lhsSpecificMetadataItems), LocatorUtils.property(thatLocator, "specificMetadataItems", rhsSpecificMetadataItems), lhsSpecificMetadataItems, rhsSpecificMetadataItems)) {
                return false;
            }
        }
        {
            Document.ExternalSignatures lhsExternalSignatures;
            lhsExternalSignatures = this.getExternalSignatures();
            Document.ExternalSignatures rhsExternalSignatures;
            rhsExternalSignatures = that.getExternalSignatures();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalSignatures", lhsExternalSignatures), LocatorUtils.property(thatLocator, "externalSignatures", rhsExternalSignatures), lhsExternalSignatures, rhsExternalSignatures)) {
                return false;
            }
        }
        {
            AccessibilityInfo lhsAccessibilityInfo;
            lhsAccessibilityInfo = this.getAccessibilityInfo();
            AccessibilityInfo rhsAccessibilityInfo;
            rhsAccessibilityInfo = that.getAccessibilityInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accessibilityInfo", lhsAccessibilityInfo), LocatorUtils.property(thatLocator, "accessibilityInfo", rhsAccessibilityInfo), lhsAccessibilityInfo, rhsAccessibilityInfo)) {
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
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle);
        }
        {
            MailType theMailType;
            theMailType = this.getMailType();
            strategy.appendField(locator, this, "mailType", buffer, theMailType);
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
            XMLGregorianCalendar theEncodingDate;
            theEncodingDate = this.getEncodingDate();
            strategy.appendField(locator, this, "encodingDate", buffer, theEncodingDate);
        }
        {
            XMLGregorianCalendar theModificationDate;
            theModificationDate = this.getModificationDate();
            strategy.appendField(locator, this, "modificationDate", buffer, theModificationDate);
        }
        {
            XMLGregorianCalendar theRegistrationDate;
            theRegistrationDate = this.getRegistrationDate();
            strategy.appendField(locator, this, "registrationDate", buffer, theRegistrationDate);
        }
        {
            String theSaveNumber;
            theSaveNumber = this.getSaveNumber();
            strategy.appendField(locator, this, "saveNumber", buffer, theSaveNumber);
        }
        {
            String theRegistrationNumber;
            theRegistrationNumber = this.getRegistrationNumber();
            strategy.appendField(locator, this, "registrationNumber", buffer, theRegistrationNumber);
        }
        {
            String theSaverEcasId;
            theSaverEcasId = this.getSaverEcasId();
            strategy.appendField(locator, this, "saverEcasId", buffer, theSaverEcasId);
        }
        {
            String theRegistererEcasId;
            theRegistererEcasId = this.getRegistererEcasId();
            strategy.appendField(locator, this, "registererEcasId", buffer, theRegistererEcasId);
        }
        {
            String theCreatedOnBehalfOf;
            theCreatedOnBehalfOf = this.getCreatedOnBehalfOf();
            strategy.appendField(locator, this, "createdOnBehalfOf", buffer, theCreatedOnBehalfOf);
        }
        {
            String theComments;
            theComments = this.getComments();
            strategy.appendField(locator, this, "comments", buffer, theComments);
        }
        {
            SecurityClassification theSecurityClassification;
            theSecurityClassification = this.getSecurityClassification();
            strategy.appendField(locator, this, "securityClassification", buffer, theSecurityClassification);
        }
        {
            MarkerType theMarkerType;
            theMarkerType = this.getMarkerType();
            strategy.appendField(locator, this, "markerType", buffer, theMarkerType);
        }
        {
            XMLGregorianCalendar theMarkerDeadline;
            theMarkerDeadline = this.getMarkerDeadline();
            strategy.appendField(locator, this, "markerDeadline", buffer, theMarkerDeadline);
        }
        {
            String theMarkerExpiryEvent;
            theMarkerExpiryEvent = this.getMarkerExpiryEvent();
            strategy.appendField(locator, this, "markerExpiryEvent", buffer, theMarkerExpiryEvent);
        }
        {
            XMLGregorianCalendar theClassificationDeadline;
            theClassificationDeadline = this.getClassificationDeadline();
            strategy.appendField(locator, this, "classificationDeadline", buffer, theClassificationDeadline);
        }
        {
            String theClassificationExpiryEvent;
            theClassificationExpiryEvent = this.getClassificationExpiryEvent();
            strategy.appendField(locator, this, "classificationExpiryEvent", buffer, theClassificationExpiryEvent);
        }
        {
            Document.PersonConcerned thePersonConcerned;
            thePersonConcerned = this.getPersonConcerned();
            strategy.appendField(locator, this, "personConcerned", buffer, thePersonConcerned);
        }
        {
            String theMarkerService;
            theMarkerService = this.getMarkerService();
            strategy.appendField(locator, this, "markerService", buffer, theMarkerService);
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
            Boolean theFrozen;
            theFrozen = this.isFrozen();
            strategy.appendField(locator, this, "frozen", buffer, theFrozen);
        }
        {
            Boolean theNoteToTheFile;
            theNoteToTheFile = this.isNoteToTheFile();
            strategy.appendField(locator, this, "noteToTheFile", buffer, theNoteToTheFile);
        }
        {
            Document.Senders theSenders;
            theSenders = this.getSenders();
            strategy.appendField(locator, this, "senders", buffer, theSenders);
        }
        {
            Document.Recipients theRecipients;
            theRecipients = this.getRecipients();
            strategy.appendField(locator, this, "recipients", buffer, theRecipients);
        }
        {
            Document.Items theItems;
            theItems = this.getItems();
            strategy.appendField(locator, this, "items", buffer, theItems);
        }
        {
            Document.FiledIn theFiledIn;
            theFiledIn = this.getFiledIn();
            strategy.appendField(locator, this, "filedIn", buffer, theFiledIn);
        }
        {
            Document.Links theLinks;
            theLinks = this.getLinks();
            strategy.appendField(locator, this, "links", buffer, theLinks);
        }
        {
            AssignmentWorkflow theAssignmentWorkflow;
            theAssignmentWorkflow = this.getAssignmentWorkflow();
            strategy.appendField(locator, this, "assignmentWorkflow", buffer, theAssignmentWorkflow);
        }
        {
            SignatoryWorkflow theSignatoryWorkflow;
            theSignatoryWorkflow = this.getSignatoryWorkflow();
            strategy.appendField(locator, this, "signatoryWorkflow", buffer, theSignatoryWorkflow);
        }
        {
            SupportingItems theSupportingItems;
            theSupportingItems = this.getSupportingItems();
            strategy.appendField(locator, this, "supportingItems", buffer, theSupportingItems);
        }
        {
            Procedure theProcedure;
            theProcedure = this.getProcedure();
            strategy.appendField(locator, this, "procedure", buffer, theProcedure);
        }
        {
            List<Document.SignedBy> theSignedBy;
            theSignedBy = (((this.signedBy!= null)&&(!this.signedBy.isEmpty()))?this.getSignedBy():null);
            strategy.appendField(locator, this, "signedBy", buffer, theSignedBy);
        }
        {
            ExternalizationDetails theExternalizationDetails;
            theExternalizationDetails = this.getExternalizationDetails();
            strategy.appendField(locator, this, "externalizationDetails", buffer, theExternalizationDetails);
        }
        {
            SpecificMetadata theSpecificMetadata;
            theSpecificMetadata = this.getSpecificMetadata();
            strategy.appendField(locator, this, "specificMetadata", buffer, theSpecificMetadata);
        }
        {
            Boolean theSignAndLock;
            theSignAndLock = this.isSignAndLock();
            strategy.appendField(locator, this, "signAndLock", buffer, theSignAndLock);
        }
        {
            Integer thePartitionId;
            thePartitionId = this.getPartitionId();
            strategy.appendField(locator, this, "partitionId", buffer, thePartitionId);
        }
        {
            Document.SpecificMetadataItems theSpecificMetadataItems;
            theSpecificMetadataItems = this.getSpecificMetadataItems();
            strategy.appendField(locator, this, "specificMetadataItems", buffer, theSpecificMetadataItems);
        }
        {
            Document.ExternalSignatures theExternalSignatures;
            theExternalSignatures = this.getExternalSignatures();
            strategy.appendField(locator, this, "externalSignatures", buffer, theExternalSignatures);
        }
        {
            AccessibilityInfo theAccessibilityInfo;
            theAccessibilityInfo = this.getAccessibilityInfo();
            strategy.appendField(locator, this, "accessibilityInfo", buffer, theAccessibilityInfo);
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
            String theTitle;
            theTitle = this.getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle), currentHashCode, theTitle);
        }
        {
            MailType theMailType;
            theMailType = this.getMailType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mailType", theMailType), currentHashCode, theMailType);
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
            XMLGregorianCalendar theEncodingDate;
            theEncodingDate = this.getEncodingDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "encodingDate", theEncodingDate), currentHashCode, theEncodingDate);
        }
        {
            XMLGregorianCalendar theModificationDate;
            theModificationDate = this.getModificationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "modificationDate", theModificationDate), currentHashCode, theModificationDate);
        }
        {
            XMLGregorianCalendar theRegistrationDate;
            theRegistrationDate = this.getRegistrationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationDate", theRegistrationDate), currentHashCode, theRegistrationDate);
        }
        {
            String theSaveNumber;
            theSaveNumber = this.getSaveNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saveNumber", theSaveNumber), currentHashCode, theSaveNumber);
        }
        {
            String theRegistrationNumber;
            theRegistrationNumber = this.getRegistrationNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationNumber", theRegistrationNumber), currentHashCode, theRegistrationNumber);
        }
        {
            String theSaverEcasId;
            theSaverEcasId = this.getSaverEcasId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saverEcasId", theSaverEcasId), currentHashCode, theSaverEcasId);
        }
        {
            String theRegistererEcasId;
            theRegistererEcasId = this.getRegistererEcasId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registererEcasId", theRegistererEcasId), currentHashCode, theRegistererEcasId);
        }
        {
            String theCreatedOnBehalfOf;
            theCreatedOnBehalfOf = this.getCreatedOnBehalfOf();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "createdOnBehalfOf", theCreatedOnBehalfOf), currentHashCode, theCreatedOnBehalfOf);
        }
        {
            String theComments;
            theComments = this.getComments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comments", theComments), currentHashCode, theComments);
        }
        {
            SecurityClassification theSecurityClassification;
            theSecurityClassification = this.getSecurityClassification();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityClassification", theSecurityClassification), currentHashCode, theSecurityClassification);
        }
        {
            MarkerType theMarkerType;
            theMarkerType = this.getMarkerType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "markerType", theMarkerType), currentHashCode, theMarkerType);
        }
        {
            XMLGregorianCalendar theMarkerDeadline;
            theMarkerDeadline = this.getMarkerDeadline();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "markerDeadline", theMarkerDeadline), currentHashCode, theMarkerDeadline);
        }
        {
            String theMarkerExpiryEvent;
            theMarkerExpiryEvent = this.getMarkerExpiryEvent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "markerExpiryEvent", theMarkerExpiryEvent), currentHashCode, theMarkerExpiryEvent);
        }
        {
            XMLGregorianCalendar theClassificationDeadline;
            theClassificationDeadline = this.getClassificationDeadline();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "classificationDeadline", theClassificationDeadline), currentHashCode, theClassificationDeadline);
        }
        {
            String theClassificationExpiryEvent;
            theClassificationExpiryEvent = this.getClassificationExpiryEvent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "classificationExpiryEvent", theClassificationExpiryEvent), currentHashCode, theClassificationExpiryEvent);
        }
        {
            Document.PersonConcerned thePersonConcerned;
            thePersonConcerned = this.getPersonConcerned();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "personConcerned", thePersonConcerned), currentHashCode, thePersonConcerned);
        }
        {
            String theMarkerService;
            theMarkerService = this.getMarkerService();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "markerService", theMarkerService), currentHashCode, theMarkerService);
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
            Boolean theFrozen;
            theFrozen = this.isFrozen();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "frozen", theFrozen), currentHashCode, theFrozen);
        }
        {
            Boolean theNoteToTheFile;
            theNoteToTheFile = this.isNoteToTheFile();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "noteToTheFile", theNoteToTheFile), currentHashCode, theNoteToTheFile);
        }
        {
            Document.Senders theSenders;
            theSenders = this.getSenders();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "senders", theSenders), currentHashCode, theSenders);
        }
        {
            Document.Recipients theRecipients;
            theRecipients = this.getRecipients();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recipients", theRecipients), currentHashCode, theRecipients);
        }
        {
            Document.Items theItems;
            theItems = this.getItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "items", theItems), currentHashCode, theItems);
        }
        {
            Document.FiledIn theFiledIn;
            theFiledIn = this.getFiledIn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "filedIn", theFiledIn), currentHashCode, theFiledIn);
        }
        {
            Document.Links theLinks;
            theLinks = this.getLinks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "links", theLinks), currentHashCode, theLinks);
        }
        {
            AssignmentWorkflow theAssignmentWorkflow;
            theAssignmentWorkflow = this.getAssignmentWorkflow();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assignmentWorkflow", theAssignmentWorkflow), currentHashCode, theAssignmentWorkflow);
        }
        {
            SignatoryWorkflow theSignatoryWorkflow;
            theSignatoryWorkflow = this.getSignatoryWorkflow();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signatoryWorkflow", theSignatoryWorkflow), currentHashCode, theSignatoryWorkflow);
        }
        {
            SupportingItems theSupportingItems;
            theSupportingItems = this.getSupportingItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "supportingItems", theSupportingItems), currentHashCode, theSupportingItems);
        }
        {
            Procedure theProcedure;
            theProcedure = this.getProcedure();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "procedure", theProcedure), currentHashCode, theProcedure);
        }
        {
            List<Document.SignedBy> theSignedBy;
            theSignedBy = (((this.signedBy!= null)&&(!this.signedBy.isEmpty()))?this.getSignedBy():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signedBy", theSignedBy), currentHashCode, theSignedBy);
        }
        {
            ExternalizationDetails theExternalizationDetails;
            theExternalizationDetails = this.getExternalizationDetails();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalizationDetails", theExternalizationDetails), currentHashCode, theExternalizationDetails);
        }
        {
            SpecificMetadata theSpecificMetadata;
            theSpecificMetadata = this.getSpecificMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specificMetadata", theSpecificMetadata), currentHashCode, theSpecificMetadata);
        }
        {
            Boolean theSignAndLock;
            theSignAndLock = this.isSignAndLock();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signAndLock", theSignAndLock), currentHashCode, theSignAndLock);
        }
        {
            Integer thePartitionId;
            thePartitionId = this.getPartitionId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "partitionId", thePartitionId), currentHashCode, thePartitionId);
        }
        {
            Document.SpecificMetadataItems theSpecificMetadataItems;
            theSpecificMetadataItems = this.getSpecificMetadataItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specificMetadataItems", theSpecificMetadataItems), currentHashCode, theSpecificMetadataItems);
        }
        {
            Document.ExternalSignatures theExternalSignatures;
            theExternalSignatures = this.getExternalSignatures();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalSignatures", theExternalSignatures), currentHashCode, theExternalSignatures);
        }
        {
            AccessibilityInfo theAccessibilityInfo;
            theAccessibilityInfo = this.getAccessibilityInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accessibilityInfo", theAccessibilityInfo), currentHashCode, theAccessibilityInfo);
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
     *         &lt;element name="externalSignature" type="{http://ec.europa.eu/sg/hrs/types}ExternalSignature" maxOccurs="unbounded"/>
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
        "externalSignature"
    })
    public static class ExternalSignatures
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected List<ExternalSignature> externalSignature;

        /**
         * Gets the value of the externalSignature property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the externalSignature property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExternalSignature().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExternalSignature }
         * 
         * 
         */
        public List<ExternalSignature> getExternalSignature() {
            if (externalSignature == null) {
                externalSignature = new ArrayList<ExternalSignature>();
            }
            return this.externalSignature;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Document.ExternalSignatures)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Document.ExternalSignatures that = ((Document.ExternalSignatures) object);
            {
                List<ExternalSignature> lhsExternalSignature;
                lhsExternalSignature = (((this.externalSignature!= null)&&(!this.externalSignature.isEmpty()))?this.getExternalSignature():null);
                List<ExternalSignature> rhsExternalSignature;
                rhsExternalSignature = (((that.externalSignature!= null)&&(!that.externalSignature.isEmpty()))?that.getExternalSignature():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "externalSignature", lhsExternalSignature), LocatorUtils.property(thatLocator, "externalSignature", rhsExternalSignature), lhsExternalSignature, rhsExternalSignature)) {
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
                List<ExternalSignature> theExternalSignature;
                theExternalSignature = (((this.externalSignature!= null)&&(!this.externalSignature.isEmpty()))?this.getExternalSignature():null);
                strategy.appendField(locator, this, "externalSignature", buffer, theExternalSignature);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<ExternalSignature> theExternalSignature;
                theExternalSignature = (((this.externalSignature!= null)&&(!this.externalSignature.isEmpty()))?this.getExternalSignature():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalSignature", theExternalSignature), currentHashCode, theExternalSignature);
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
     *         &lt;element name="file" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="fileId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
     *                   &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="chefDeFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="fileCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="specificCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="status" type="{http://ec.europa.eu/sg/hrs/types}FileStatus" minOccurs="0"/>
     *                   &lt;element name="englishName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="frenchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="germanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="filingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
        "file"
    })
    public static class FiledIn
        implements Equals, HashCode, ToString
    {

        protected List<Document.FiledIn.File> file;

        /**
         * Gets the value of the file property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the file property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFile().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Document.FiledIn.File }
         * 
         * 
         */
        public List<Document.FiledIn.File> getFile() {
            if (file == null) {
                file = new ArrayList<Document.FiledIn.File>();
            }
            return this.file;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Document.FiledIn)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Document.FiledIn that = ((Document.FiledIn) object);
            {
                List<Document.FiledIn.File> lhsFile;
                lhsFile = (((this.file!= null)&&(!this.file.isEmpty()))?this.getFile():null);
                List<Document.FiledIn.File> rhsFile;
                rhsFile = (((that.file!= null)&&(!that.file.isEmpty()))?that.getFile():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "file", lhsFile), LocatorUtils.property(thatLocator, "file", rhsFile), lhsFile, rhsFile)) {
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
                List<Document.FiledIn.File> theFile;
                theFile = (((this.file!= null)&&(!this.file.isEmpty()))?this.getFile():null);
                strategy.appendField(locator, this, "file", buffer, theFile);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<Document.FiledIn.File> theFile;
                theFile = (((this.file!= null)&&(!this.file.isEmpty()))?this.getFile():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "file", theFile), currentHashCode, theFile);
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
         *         &lt;element name="fileId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
         *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="chefDeFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="fileCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="specificCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="status" type="{http://ec.europa.eu/sg/hrs/types}FileStatus" minOccurs="0"/>
         *         &lt;element name="englishName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="frenchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="germanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="filingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
            "fileId",
            "path",
            "chefDeFile",
            "fileCode",
            "specificCode",
            "status",
            "englishName",
            "frenchName",
            "germanName",
            "filingDate"
        })
        public static class File
            implements Equals, HashCode, ToString
        {

            @XmlElement(required = true)
            protected String fileId;
            @XmlElement(required = true)
            protected String path;
            protected String chefDeFile;
            protected String fileCode;
            protected String specificCode;
            protected FileStatus status;
            protected String englishName;
            protected String frenchName;
            protected String germanName;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar filingDate;

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
             * Gets the value of the path property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPath() {
                return path;
            }

            /**
             * Sets the value of the path property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPath(String value) {
                this.path = value;
            }

            /**
             * Gets the value of the chefDeFile property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getChefDeFile() {
                return chefDeFile;
            }

            /**
             * Sets the value of the chefDeFile property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setChefDeFile(String value) {
                this.chefDeFile = value;
            }

            /**
             * Gets the value of the fileCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFileCode() {
                return fileCode;
            }

            /**
             * Sets the value of the fileCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFileCode(String value) {
                this.fileCode = value;
            }

            /**
             * Gets the value of the specificCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSpecificCode() {
                return specificCode;
            }

            /**
             * Sets the value of the specificCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSpecificCode(String value) {
                this.specificCode = value;
            }

            /**
             * Gets the value of the status property.
             * 
             * @return
             *     possible object is
             *     {@link FileStatus }
             *     
             */
            public FileStatus getStatus() {
                return status;
            }

            /**
             * Sets the value of the status property.
             * 
             * @param value
             *     allowed object is
             *     {@link FileStatus }
             *     
             */
            public void setStatus(FileStatus value) {
                this.status = value;
            }

            /**
             * Gets the value of the englishName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEnglishName() {
                return englishName;
            }

            /**
             * Sets the value of the englishName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEnglishName(String value) {
                this.englishName = value;
            }

            /**
             * Gets the value of the frenchName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFrenchName() {
                return frenchName;
            }

            /**
             * Sets the value of the frenchName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFrenchName(String value) {
                this.frenchName = value;
            }

            /**
             * Gets the value of the germanName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGermanName() {
                return germanName;
            }

            /**
             * Sets the value of the germanName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGermanName(String value) {
                this.germanName = value;
            }

            /**
             * Gets the value of the filingDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getFilingDate() {
                return filingDate;
            }

            /**
             * Sets the value of the filingDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setFilingDate(XMLGregorianCalendar value) {
                this.filingDate = value;
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof Document.FiledIn.File)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final Document.FiledIn.File that = ((Document.FiledIn.File) object);
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
                    String lhsPath;
                    lhsPath = this.getPath();
                    String rhsPath;
                    rhsPath = that.getPath();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "path", lhsPath), LocatorUtils.property(thatLocator, "path", rhsPath), lhsPath, rhsPath)) {
                        return false;
                    }
                }
                {
                    String lhsChefDeFile;
                    lhsChefDeFile = this.getChefDeFile();
                    String rhsChefDeFile;
                    rhsChefDeFile = that.getChefDeFile();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "chefDeFile", lhsChefDeFile), LocatorUtils.property(thatLocator, "chefDeFile", rhsChefDeFile), lhsChefDeFile, rhsChefDeFile)) {
                        return false;
                    }
                }
                {
                    String lhsFileCode;
                    lhsFileCode = this.getFileCode();
                    String rhsFileCode;
                    rhsFileCode = that.getFileCode();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "fileCode", lhsFileCode), LocatorUtils.property(thatLocator, "fileCode", rhsFileCode), lhsFileCode, rhsFileCode)) {
                        return false;
                    }
                }
                {
                    String lhsSpecificCode;
                    lhsSpecificCode = this.getSpecificCode();
                    String rhsSpecificCode;
                    rhsSpecificCode = that.getSpecificCode();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "specificCode", lhsSpecificCode), LocatorUtils.property(thatLocator, "specificCode", rhsSpecificCode), lhsSpecificCode, rhsSpecificCode)) {
                        return false;
                    }
                }
                {
                    FileStatus lhsStatus;
                    lhsStatus = this.getStatus();
                    FileStatus rhsStatus;
                    rhsStatus = that.getStatus();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                        return false;
                    }
                }
                {
                    String lhsEnglishName;
                    lhsEnglishName = this.getEnglishName();
                    String rhsEnglishName;
                    rhsEnglishName = that.getEnglishName();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "englishName", lhsEnglishName), LocatorUtils.property(thatLocator, "englishName", rhsEnglishName), lhsEnglishName, rhsEnglishName)) {
                        return false;
                    }
                }
                {
                    String lhsFrenchName;
                    lhsFrenchName = this.getFrenchName();
                    String rhsFrenchName;
                    rhsFrenchName = that.getFrenchName();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "frenchName", lhsFrenchName), LocatorUtils.property(thatLocator, "frenchName", rhsFrenchName), lhsFrenchName, rhsFrenchName)) {
                        return false;
                    }
                }
                {
                    String lhsGermanName;
                    lhsGermanName = this.getGermanName();
                    String rhsGermanName;
                    rhsGermanName = that.getGermanName();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "germanName", lhsGermanName), LocatorUtils.property(thatLocator, "germanName", rhsGermanName), lhsGermanName, rhsGermanName)) {
                        return false;
                    }
                }
                {
                    XMLGregorianCalendar lhsFilingDate;
                    lhsFilingDate = this.getFilingDate();
                    XMLGregorianCalendar rhsFilingDate;
                    rhsFilingDate = that.getFilingDate();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "filingDate", lhsFilingDate), LocatorUtils.property(thatLocator, "filingDate", rhsFilingDate), lhsFilingDate, rhsFilingDate)) {
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
                    String theFileId;
                    theFileId = this.getFileId();
                    strategy.appendField(locator, this, "fileId", buffer, theFileId);
                }
                {
                    String thePath;
                    thePath = this.getPath();
                    strategy.appendField(locator, this, "path", buffer, thePath);
                }
                {
                    String theChefDeFile;
                    theChefDeFile = this.getChefDeFile();
                    strategy.appendField(locator, this, "chefDeFile", buffer, theChefDeFile);
                }
                {
                    String theFileCode;
                    theFileCode = this.getFileCode();
                    strategy.appendField(locator, this, "fileCode", buffer, theFileCode);
                }
                {
                    String theSpecificCode;
                    theSpecificCode = this.getSpecificCode();
                    strategy.appendField(locator, this, "specificCode", buffer, theSpecificCode);
                }
                {
                    FileStatus theStatus;
                    theStatus = this.getStatus();
                    strategy.appendField(locator, this, "status", buffer, theStatus);
                }
                {
                    String theEnglishName;
                    theEnglishName = this.getEnglishName();
                    strategy.appendField(locator, this, "englishName", buffer, theEnglishName);
                }
                {
                    String theFrenchName;
                    theFrenchName = this.getFrenchName();
                    strategy.appendField(locator, this, "frenchName", buffer, theFrenchName);
                }
                {
                    String theGermanName;
                    theGermanName = this.getGermanName();
                    strategy.appendField(locator, this, "germanName", buffer, theGermanName);
                }
                {
                    XMLGregorianCalendar theFilingDate;
                    theFilingDate = this.getFilingDate();
                    strategy.appendField(locator, this, "filingDate", buffer, theFilingDate);
                }
                return buffer;
            }

            public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
                int currentHashCode = 1;
                {
                    String theFileId;
                    theFileId = this.getFileId();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileId", theFileId), currentHashCode, theFileId);
                }
                {
                    String thePath;
                    thePath = this.getPath();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "path", thePath), currentHashCode, thePath);
                }
                {
                    String theChefDeFile;
                    theChefDeFile = this.getChefDeFile();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "chefDeFile", theChefDeFile), currentHashCode, theChefDeFile);
                }
                {
                    String theFileCode;
                    theFileCode = this.getFileCode();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileCode", theFileCode), currentHashCode, theFileCode);
                }
                {
                    String theSpecificCode;
                    theSpecificCode = this.getSpecificCode();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specificCode", theSpecificCode), currentHashCode, theSpecificCode);
                }
                {
                    FileStatus theStatus;
                    theStatus = this.getStatus();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
                }
                {
                    String theEnglishName;
                    theEnglishName = this.getEnglishName();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "englishName", theEnglishName), currentHashCode, theEnglishName);
                }
                {
                    String theFrenchName;
                    theFrenchName = this.getFrenchName();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "frenchName", theFrenchName), currentHashCode, theFrenchName);
                }
                {
                    String theGermanName;
                    theGermanName = this.getGermanName();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "germanName", theGermanName), currentHashCode, theGermanName);
                }
                {
                    XMLGregorianCalendar theFilingDate;
                    theFilingDate = this.getFilingDate();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "filingDate", theFilingDate), currentHashCode, theFilingDate);
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
    public static class Items
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
            if (!(object instanceof Document.Items)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Document.Items that = ((Document.Items) object);
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
     *         &lt;element name="link" type="{http://ec.europa.eu/sg/hrs/types}Link" maxOccurs="unbounded" minOccurs="0"/>
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
        "link"
    })
    public static class Links
        implements Equals, HashCode, ToString
    {

        protected List<Link> link;

        /**
         * Gets the value of the link property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the link property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLink().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Link }
         * 
         * 
         */
        public List<Link> getLink() {
            if (link == null) {
                link = new ArrayList<Link>();
            }
            return this.link;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Document.Links)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Document.Links that = ((Document.Links) object);
            {
                List<Link> lhsLink;
                lhsLink = (((this.link!= null)&&(!this.link.isEmpty()))?this.getLink():null);
                List<Link> rhsLink;
                rhsLink = (((that.link!= null)&&(!that.link.isEmpty()))?that.getLink():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "link", lhsLink), LocatorUtils.property(thatLocator, "link", rhsLink), lhsLink, rhsLink)) {
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
                List<Link> theLink;
                theLink = (((this.link!= null)&&(!this.link.isEmpty()))?this.getLink():null);
                strategy.appendField(locator, this, "link", buffer, theLink);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<Link> theLink;
                theLink = (((this.link!= null)&&(!this.link.isEmpty()))?this.getLink():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "link", theLink), currentHashCode, theLink);
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
     *         &lt;choice>
     *           &lt;element name="internalEntity" type="{http://ec.europa.eu/sg/hrs/types}InternalEntity"/>
     *           &lt;element name="externalEntity" type="{http://ec.europa.eu/sg/hrs/types}ExternalEntity"/>
     *         &lt;/choice>
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
        "internalEntity",
        "externalEntity"
    })
    public static class PersonConcerned
        implements Equals, HashCode, ToString
    {

        protected InternalEntity internalEntity;
        protected ExternalEntity externalEntity;

        /**
         * Gets the value of the internalEntity property.
         * 
         * @return
         *     possible object is
         *     {@link InternalEntity }
         *     
         */
        public InternalEntity getInternalEntity() {
            return internalEntity;
        }

        /**
         * Sets the value of the internalEntity property.
         * 
         * @param value
         *     allowed object is
         *     {@link InternalEntity }
         *     
         */
        public void setInternalEntity(InternalEntity value) {
            this.internalEntity = value;
        }

        /**
         * Gets the value of the externalEntity property.
         * 
         * @return
         *     possible object is
         *     {@link ExternalEntity }
         *     
         */
        public ExternalEntity getExternalEntity() {
            return externalEntity;
        }

        /**
         * Sets the value of the externalEntity property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExternalEntity }
         *     
         */
        public void setExternalEntity(ExternalEntity value) {
            this.externalEntity = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Document.PersonConcerned)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Document.PersonConcerned that = ((Document.PersonConcerned) object);
            {
                InternalEntity lhsInternalEntity;
                lhsInternalEntity = this.getInternalEntity();
                InternalEntity rhsInternalEntity;
                rhsInternalEntity = that.getInternalEntity();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "internalEntity", lhsInternalEntity), LocatorUtils.property(thatLocator, "internalEntity", rhsInternalEntity), lhsInternalEntity, rhsInternalEntity)) {
                    return false;
                }
            }
            {
                ExternalEntity lhsExternalEntity;
                lhsExternalEntity = this.getExternalEntity();
                ExternalEntity rhsExternalEntity;
                rhsExternalEntity = that.getExternalEntity();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "externalEntity", lhsExternalEntity), LocatorUtils.property(thatLocator, "externalEntity", rhsExternalEntity), lhsExternalEntity, rhsExternalEntity)) {
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
                InternalEntity theInternalEntity;
                theInternalEntity = this.getInternalEntity();
                strategy.appendField(locator, this, "internalEntity", buffer, theInternalEntity);
            }
            {
                ExternalEntity theExternalEntity;
                theExternalEntity = this.getExternalEntity();
                strategy.appendField(locator, this, "externalEntity", buffer, theExternalEntity);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                InternalEntity theInternalEntity;
                theInternalEntity = this.getInternalEntity();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "internalEntity", theInternalEntity), currentHashCode, theInternalEntity);
            }
            {
                ExternalEntity theExternalEntity;
                theExternalEntity = this.getExternalEntity();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalEntity", theExternalEntity), currentHashCode, theExternalEntity);
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
     *         &lt;element name="recipient" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;choice>
     *                     &lt;element name="internalEntity" type="{http://ec.europa.eu/sg/hrs/types}InternalEntity"/>
     *                     &lt;element name="externalEntity" type="{http://ec.europa.eu/sg/hrs/types}ExternalEntity"/>
     *                   &lt;/choice>
     *                   &lt;element name="code" type="{http://ec.europa.eu/sg/hrs/types}RecipientCode"/>
     *                   &lt;element name="validForRegistration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
        "recipient"
    })
    public static class Recipients
        implements Equals, HashCode, ToString
    {

        protected List<Document.Recipients.Recipient> recipient;

        /**
         * Gets the value of the recipient property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the recipient property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRecipient().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Document.Recipients.Recipient }
         * 
         * 
         */
        public List<Document.Recipients.Recipient> getRecipient() {
            if (recipient == null) {
                recipient = new ArrayList<Document.Recipients.Recipient>();
            }
            return this.recipient;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Document.Recipients)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Document.Recipients that = ((Document.Recipients) object);
            {
                List<Document.Recipients.Recipient> lhsRecipient;
                lhsRecipient = (((this.recipient!= null)&&(!this.recipient.isEmpty()))?this.getRecipient():null);
                List<Document.Recipients.Recipient> rhsRecipient;
                rhsRecipient = (((that.recipient!= null)&&(!that.recipient.isEmpty()))?that.getRecipient():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "recipient", lhsRecipient), LocatorUtils.property(thatLocator, "recipient", rhsRecipient), lhsRecipient, rhsRecipient)) {
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
                List<Document.Recipients.Recipient> theRecipient;
                theRecipient = (((this.recipient!= null)&&(!this.recipient.isEmpty()))?this.getRecipient():null);
                strategy.appendField(locator, this, "recipient", buffer, theRecipient);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<Document.Recipients.Recipient> theRecipient;
                theRecipient = (((this.recipient!= null)&&(!this.recipient.isEmpty()))?this.getRecipient():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recipient", theRecipient), currentHashCode, theRecipient);
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
         *         &lt;choice>
         *           &lt;element name="internalEntity" type="{http://ec.europa.eu/sg/hrs/types}InternalEntity"/>
         *           &lt;element name="externalEntity" type="{http://ec.europa.eu/sg/hrs/types}ExternalEntity"/>
         *         &lt;/choice>
         *         &lt;element name="code" type="{http://ec.europa.eu/sg/hrs/types}RecipientCode"/>
         *         &lt;element name="validForRegistration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
            "internalEntity",
            "externalEntity",
            "code",
            "validForRegistration"
        })
        public static class Recipient
            implements Equals, HashCode, ToString
        {

            protected InternalEntity internalEntity;
            protected ExternalEntity externalEntity;
            @XmlElement(required = true)
            protected RecipientCode code;
            protected Boolean validForRegistration;

            /**
             * Gets the value of the internalEntity property.
             * 
             * @return
             *     possible object is
             *     {@link InternalEntity }
             *     
             */
            public InternalEntity getInternalEntity() {
                return internalEntity;
            }

            /**
             * Sets the value of the internalEntity property.
             * 
             * @param value
             *     allowed object is
             *     {@link InternalEntity }
             *     
             */
            public void setInternalEntity(InternalEntity value) {
                this.internalEntity = value;
            }

            /**
             * Gets the value of the externalEntity property.
             * 
             * @return
             *     possible object is
             *     {@link ExternalEntity }
             *     
             */
            public ExternalEntity getExternalEntity() {
                return externalEntity;
            }

            /**
             * Sets the value of the externalEntity property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExternalEntity }
             *     
             */
            public void setExternalEntity(ExternalEntity value) {
                this.externalEntity = value;
            }

            /**
             * Gets the value of the code property.
             * 
             * @return
             *     possible object is
             *     {@link RecipientCode }
             *     
             */
            public RecipientCode getCode() {
                return code;
            }

            /**
             * Sets the value of the code property.
             * 
             * @param value
             *     allowed object is
             *     {@link RecipientCode }
             *     
             */
            public void setCode(RecipientCode value) {
                this.code = value;
            }

            /**
             * Gets the value of the validForRegistration property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isValidForRegistration() {
                return validForRegistration;
            }

            /**
             * Sets the value of the validForRegistration property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setValidForRegistration(Boolean value) {
                this.validForRegistration = value;
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof Document.Recipients.Recipient)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final Document.Recipients.Recipient that = ((Document.Recipients.Recipient) object);
                {
                    InternalEntity lhsInternalEntity;
                    lhsInternalEntity = this.getInternalEntity();
                    InternalEntity rhsInternalEntity;
                    rhsInternalEntity = that.getInternalEntity();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "internalEntity", lhsInternalEntity), LocatorUtils.property(thatLocator, "internalEntity", rhsInternalEntity), lhsInternalEntity, rhsInternalEntity)) {
                        return false;
                    }
                }
                {
                    ExternalEntity lhsExternalEntity;
                    lhsExternalEntity = this.getExternalEntity();
                    ExternalEntity rhsExternalEntity;
                    rhsExternalEntity = that.getExternalEntity();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "externalEntity", lhsExternalEntity), LocatorUtils.property(thatLocator, "externalEntity", rhsExternalEntity), lhsExternalEntity, rhsExternalEntity)) {
                        return false;
                    }
                }
                {
                    RecipientCode lhsCode;
                    lhsCode = this.getCode();
                    RecipientCode rhsCode;
                    rhsCode = that.getCode();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
                        return false;
                    }
                }
                {
                    Boolean lhsValidForRegistration;
                    lhsValidForRegistration = this.isValidForRegistration();
                    Boolean rhsValidForRegistration;
                    rhsValidForRegistration = that.isValidForRegistration();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "validForRegistration", lhsValidForRegistration), LocatorUtils.property(thatLocator, "validForRegistration", rhsValidForRegistration), lhsValidForRegistration, rhsValidForRegistration)) {
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
                    InternalEntity theInternalEntity;
                    theInternalEntity = this.getInternalEntity();
                    strategy.appendField(locator, this, "internalEntity", buffer, theInternalEntity);
                }
                {
                    ExternalEntity theExternalEntity;
                    theExternalEntity = this.getExternalEntity();
                    strategy.appendField(locator, this, "externalEntity", buffer, theExternalEntity);
                }
                {
                    RecipientCode theCode;
                    theCode = this.getCode();
                    strategy.appendField(locator, this, "code", buffer, theCode);
                }
                {
                    Boolean theValidForRegistration;
                    theValidForRegistration = this.isValidForRegistration();
                    strategy.appendField(locator, this, "validForRegistration", buffer, theValidForRegistration);
                }
                return buffer;
            }

            public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
                int currentHashCode = 1;
                {
                    InternalEntity theInternalEntity;
                    theInternalEntity = this.getInternalEntity();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "internalEntity", theInternalEntity), currentHashCode, theInternalEntity);
                }
                {
                    ExternalEntity theExternalEntity;
                    theExternalEntity = this.getExternalEntity();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalEntity", theExternalEntity), currentHashCode, theExternalEntity);
                }
                {
                    RecipientCode theCode;
                    theCode = this.getCode();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
                }
                {
                    Boolean theValidForRegistration;
                    theValidForRegistration = this.isValidForRegistration();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validForRegistration", theValidForRegistration), currentHashCode, theValidForRegistration);
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
     *         &lt;element name="sender" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;choice>
     *                     &lt;element name="internalEntity" type="{http://ec.europa.eu/sg/hrs/types}InternalEntity"/>
     *                     &lt;element name="externalEntity" type="{http://ec.europa.eu/sg/hrs/types}ExternalEntity"/>
     *                   &lt;/choice>
     *                   &lt;element name="validForRegistration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
        "sender"
    })
    public static class Senders
        implements Equals, HashCode, ToString
    {

        protected List<Document.Senders.Sender> sender;

        /**
         * Gets the value of the sender property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sender property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSender().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Document.Senders.Sender }
         * 
         * 
         */
        public List<Document.Senders.Sender> getSender() {
            if (sender == null) {
                sender = new ArrayList<Document.Senders.Sender>();
            }
            return this.sender;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Document.Senders)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Document.Senders that = ((Document.Senders) object);
            {
                List<Document.Senders.Sender> lhsSender;
                lhsSender = (((this.sender!= null)&&(!this.sender.isEmpty()))?this.getSender():null);
                List<Document.Senders.Sender> rhsSender;
                rhsSender = (((that.sender!= null)&&(!that.sender.isEmpty()))?that.getSender():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "sender", lhsSender), LocatorUtils.property(thatLocator, "sender", rhsSender), lhsSender, rhsSender)) {
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
                List<Document.Senders.Sender> theSender;
                theSender = (((this.sender!= null)&&(!this.sender.isEmpty()))?this.getSender():null);
                strategy.appendField(locator, this, "sender", buffer, theSender);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<Document.Senders.Sender> theSender;
                theSender = (((this.sender!= null)&&(!this.sender.isEmpty()))?this.getSender():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sender", theSender), currentHashCode, theSender);
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
         *         &lt;choice>
         *           &lt;element name="internalEntity" type="{http://ec.europa.eu/sg/hrs/types}InternalEntity"/>
         *           &lt;element name="externalEntity" type="{http://ec.europa.eu/sg/hrs/types}ExternalEntity"/>
         *         &lt;/choice>
         *         &lt;element name="validForRegistration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
            "internalEntity",
            "externalEntity",
            "validForRegistration"
        })
        public static class Sender
            implements Equals, HashCode, ToString
        {

            protected InternalEntity internalEntity;
            protected ExternalEntity externalEntity;
            protected Boolean validForRegistration;

            /**
             * Gets the value of the internalEntity property.
             * 
             * @return
             *     possible object is
             *     {@link InternalEntity }
             *     
             */
            public InternalEntity getInternalEntity() {
                return internalEntity;
            }

            /**
             * Sets the value of the internalEntity property.
             * 
             * @param value
             *     allowed object is
             *     {@link InternalEntity }
             *     
             */
            public void setInternalEntity(InternalEntity value) {
                this.internalEntity = value;
            }

            /**
             * Gets the value of the externalEntity property.
             * 
             * @return
             *     possible object is
             *     {@link ExternalEntity }
             *     
             */
            public ExternalEntity getExternalEntity() {
                return externalEntity;
            }

            /**
             * Sets the value of the externalEntity property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExternalEntity }
             *     
             */
            public void setExternalEntity(ExternalEntity value) {
                this.externalEntity = value;
            }

            /**
             * Gets the value of the validForRegistration property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isValidForRegistration() {
                return validForRegistration;
            }

            /**
             * Sets the value of the validForRegistration property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setValidForRegistration(Boolean value) {
                this.validForRegistration = value;
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof Document.Senders.Sender)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final Document.Senders.Sender that = ((Document.Senders.Sender) object);
                {
                    InternalEntity lhsInternalEntity;
                    lhsInternalEntity = this.getInternalEntity();
                    InternalEntity rhsInternalEntity;
                    rhsInternalEntity = that.getInternalEntity();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "internalEntity", lhsInternalEntity), LocatorUtils.property(thatLocator, "internalEntity", rhsInternalEntity), lhsInternalEntity, rhsInternalEntity)) {
                        return false;
                    }
                }
                {
                    ExternalEntity lhsExternalEntity;
                    lhsExternalEntity = this.getExternalEntity();
                    ExternalEntity rhsExternalEntity;
                    rhsExternalEntity = that.getExternalEntity();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "externalEntity", lhsExternalEntity), LocatorUtils.property(thatLocator, "externalEntity", rhsExternalEntity), lhsExternalEntity, rhsExternalEntity)) {
                        return false;
                    }
                }
                {
                    Boolean lhsValidForRegistration;
                    lhsValidForRegistration = this.isValidForRegistration();
                    Boolean rhsValidForRegistration;
                    rhsValidForRegistration = that.isValidForRegistration();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "validForRegistration", lhsValidForRegistration), LocatorUtils.property(thatLocator, "validForRegistration", rhsValidForRegistration), lhsValidForRegistration, rhsValidForRegistration)) {
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
                    InternalEntity theInternalEntity;
                    theInternalEntity = this.getInternalEntity();
                    strategy.appendField(locator, this, "internalEntity", buffer, theInternalEntity);
                }
                {
                    ExternalEntity theExternalEntity;
                    theExternalEntity = this.getExternalEntity();
                    strategy.appendField(locator, this, "externalEntity", buffer, theExternalEntity);
                }
                {
                    Boolean theValidForRegistration;
                    theValidForRegistration = this.isValidForRegistration();
                    strategy.appendField(locator, this, "validForRegistration", buffer, theValidForRegistration);
                }
                return buffer;
            }

            public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
                int currentHashCode = 1;
                {
                    InternalEntity theInternalEntity;
                    theInternalEntity = this.getInternalEntity();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "internalEntity", theInternalEntity), currentHashCode, theInternalEntity);
                }
                {
                    ExternalEntity theExternalEntity;
                    theExternalEntity = this.getExternalEntity();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalEntity", theExternalEntity), currentHashCode, theExternalEntity);
                }
                {
                    Boolean theValidForRegistration;
                    theValidForRegistration = this.isValidForRegistration();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validForRegistration", theValidForRegistration), currentHashCode, theValidForRegistration);
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
     *         &lt;element name="user" type="{http://ec.europa.eu/sg/hrs/types}WorkflowUser"/>
     *         &lt;element name="on" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "user",
        "on"
    })
    public static class SignedBy
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected WorkflowUser user;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar on;

        /**
         * Gets the value of the user property.
         * 
         * @return
         *     possible object is
         *     {@link WorkflowUser }
         *     
         */
        public WorkflowUser getUser() {
            return user;
        }

        /**
         * Sets the value of the user property.
         * 
         * @param value
         *     allowed object is
         *     {@link WorkflowUser }
         *     
         */
        public void setUser(WorkflowUser value) {
            this.user = value;
        }

        /**
         * Gets the value of the on property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getOn() {
            return on;
        }

        /**
         * Sets the value of the on property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setOn(XMLGregorianCalendar value) {
            this.on = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Document.SignedBy)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Document.SignedBy that = ((Document.SignedBy) object);
            {
                WorkflowUser lhsUser;
                lhsUser = this.getUser();
                WorkflowUser rhsUser;
                rhsUser = that.getUser();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "user", lhsUser), LocatorUtils.property(thatLocator, "user", rhsUser), lhsUser, rhsUser)) {
                    return false;
                }
            }
            {
                XMLGregorianCalendar lhsOn;
                lhsOn = this.getOn();
                XMLGregorianCalendar rhsOn;
                rhsOn = that.getOn();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "on", lhsOn), LocatorUtils.property(thatLocator, "on", rhsOn), lhsOn, rhsOn)) {
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
                WorkflowUser theUser;
                theUser = this.getUser();
                strategy.appendField(locator, this, "user", buffer, theUser);
            }
            {
                XMLGregorianCalendar theOn;
                theOn = this.getOn();
                strategy.appendField(locator, this, "on", buffer, theOn);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                WorkflowUser theUser;
                theUser = this.getUser();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "user", theUser), currentHashCode, theUser);
            }
            {
                XMLGregorianCalendar theOn;
                theOn = this.getOn();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "on", theOn), currentHashCode, theOn);
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
     *         &lt;element name="specificMetadataItem" type="{http://ec.europa.eu/sg/hrs/types}SpecificMetadataItem" maxOccurs="10"/>
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
        "specificMetadataItem"
    })
    public static class SpecificMetadataItems
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected List<SpecificMetadataItem> specificMetadataItem;

        /**
         * Gets the value of the specificMetadataItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the specificMetadataItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSpecificMetadataItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SpecificMetadataItem }
         * 
         * 
         */
        public List<SpecificMetadataItem> getSpecificMetadataItem() {
            if (specificMetadataItem == null) {
                specificMetadataItem = new ArrayList<SpecificMetadataItem>();
            }
            return this.specificMetadataItem;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Document.SpecificMetadataItems)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Document.SpecificMetadataItems that = ((Document.SpecificMetadataItems) object);
            {
                List<SpecificMetadataItem> lhsSpecificMetadataItem;
                lhsSpecificMetadataItem = (((this.specificMetadataItem!= null)&&(!this.specificMetadataItem.isEmpty()))?this.getSpecificMetadataItem():null);
                List<SpecificMetadataItem> rhsSpecificMetadataItem;
                rhsSpecificMetadataItem = (((that.specificMetadataItem!= null)&&(!that.specificMetadataItem.isEmpty()))?that.getSpecificMetadataItem():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "specificMetadataItem", lhsSpecificMetadataItem), LocatorUtils.property(thatLocator, "specificMetadataItem", rhsSpecificMetadataItem), lhsSpecificMetadataItem, rhsSpecificMetadataItem)) {
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
                List<SpecificMetadataItem> theSpecificMetadataItem;
                theSpecificMetadataItem = (((this.specificMetadataItem!= null)&&(!this.specificMetadataItem.isEmpty()))?this.getSpecificMetadataItem():null);
                strategy.appendField(locator, this, "specificMetadataItem", buffer, theSpecificMetadataItem);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<SpecificMetadataItem> theSpecificMetadataItem;
                theSpecificMetadataItem = (((this.specificMetadataItem!= null)&&(!this.specificMetadataItem.isEmpty()))?this.getSpecificMetadataItem():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specificMetadataItem", theSpecificMetadataItem), currentHashCode, theSpecificMetadataItem);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
