
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for LocalFileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocalFileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsSubFile" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsDocumentFilingAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ChefDeFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HeadingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecificCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MultiLingualNames" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MultiLingualName" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="UserFileRoles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="UserFileRole" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="HasSubFiles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Readers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Reader" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Users" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="User" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Editors" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Editor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EnglishComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FrenchComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GermanComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeskOfficer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Limited" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Cupboard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Office" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Binder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ActivationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ClosingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="TransferDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DestroyDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="RestoreDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Category" type="{http://ec.europa.eu/research/fp/model/document/V5}CategoryType" minOccurs="0"/>
 *         &lt;element name="SystemHasSubFiles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SystemContainsDocuments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalFileType", propOrder = {
    "fileId",
    "isSubFile",
    "isDocumentFilingAllowed",
    "path",
    "chefDeFile",
    "headingCode",
    "fileCode",
    "specificCode",
    "status",
    "parentId",
    "multiLingualNames",
    "userFileRoles",
    "hasSubFiles",
    "readers",
    "users",
    "editors",
    "englishComments",
    "frenchComments",
    "germanComments",
    "deskOfficer",
    "limited",
    "cupboard",
    "office",
    "binder",
    "creationDate",
    "activationDate",
    "closingDate",
    "transferDate",
    "destroyDate",
    "restoreDate",
    "category",
    "systemHasSubFiles",
    "systemContainsDocuments"
})
public class LocalFileType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "FileId", required = true)
    protected String fileId;
    @XmlElement(name = "IsSubFile")
    protected boolean isSubFile;
    @XmlElement(name = "IsDocumentFilingAllowed")
    protected Boolean isDocumentFilingAllowed;
    @XmlElement(name = "Path", required = true)
    protected String path;
    @XmlElement(name = "ChefDeFile")
    protected String chefDeFile;
    @XmlElement(name = "HeadingCode")
    protected String headingCode;
    @XmlElement(name = "FileCode")
    protected String fileCode;
    @XmlElement(name = "SpecificCode")
    protected String specificCode;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "ParentId")
    protected String parentId;
    @XmlElement(name = "MultiLingualNames")
    protected LocalFileType.MultiLingualNames multiLingualNames;
    @XmlElement(name = "UserFileRoles")
    protected LocalFileType.UserFileRoles userFileRoles;
    @XmlElement(name = "HasSubFiles")
    protected Boolean hasSubFiles;
    @XmlElement(name = "Readers")
    protected LocalFileType.Readers readers;
    @XmlElement(name = "Users")
    protected LocalFileType.Users users;
    @XmlElement(name = "Editors")
    protected LocalFileType.Editors editors;
    @XmlElement(name = "EnglishComments")
    protected String englishComments;
    @XmlElement(name = "FrenchComments")
    protected String frenchComments;
    @XmlElement(name = "GermanComments")
    protected String germanComments;
    @XmlElement(name = "DeskOfficer")
    protected String deskOfficer;
    @XmlElement(name = "Limited")
    protected Boolean limited;
    @XmlElement(name = "Cupboard")
    protected String cupboard;
    @XmlElement(name = "Office")
    protected String office;
    @XmlElement(name = "Binder")
    protected String binder;
    @XmlElement(name = "CreationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "ActivationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activationDate;
    @XmlElement(name = "ClosingDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar closingDate;
    @XmlElement(name = "TransferDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transferDate;
    @XmlElement(name = "DestroyDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar destroyDate;
    @XmlElement(name = "RestoreDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar restoreDate;
    @XmlElement(name = "Category")
    protected CategoryType category;
    @XmlElement(name = "SystemHasSubFiles")
    protected Boolean systemHasSubFiles;
    @XmlElement(name = "SystemContainsDocuments")
    protected Boolean systemContainsDocuments;

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
     * Gets the value of the isSubFile property.
     * 
     */
    public boolean isIsSubFile() {
        return isSubFile;
    }

    /**
     * Sets the value of the isSubFile property.
     * 
     */
    public void setIsSubFile(boolean value) {
        this.isSubFile = value;
    }

    /**
     * Gets the value of the isDocumentFilingAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDocumentFilingAllowed() {
        return isDocumentFilingAllowed;
    }

    /**
     * Sets the value of the isDocumentFilingAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDocumentFilingAllowed(Boolean value) {
        this.isDocumentFilingAllowed = value;
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
     * Gets the value of the headingCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadingCode() {
        return headingCode;
    }

    /**
     * Sets the value of the headingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadingCode(String value) {
        this.headingCode = value;
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
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the parentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the value of the parentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentId(String value) {
        this.parentId = value;
    }

    /**
     * Gets the value of the multiLingualNames property.
     * 
     * @return
     *     possible object is
     *     {@link LocalFileType.MultiLingualNames }
     *     
     */
    public LocalFileType.MultiLingualNames getMultiLingualNames() {
        return multiLingualNames;
    }

    /**
     * Sets the value of the multiLingualNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalFileType.MultiLingualNames }
     *     
     */
    public void setMultiLingualNames(LocalFileType.MultiLingualNames value) {
        this.multiLingualNames = value;
    }

    /**
     * Gets the value of the userFileRoles property.
     * 
     * @return
     *     possible object is
     *     {@link LocalFileType.UserFileRoles }
     *     
     */
    public LocalFileType.UserFileRoles getUserFileRoles() {
        return userFileRoles;
    }

    /**
     * Sets the value of the userFileRoles property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalFileType.UserFileRoles }
     *     
     */
    public void setUserFileRoles(LocalFileType.UserFileRoles value) {
        this.userFileRoles = value;
    }

    /**
     * Gets the value of the hasSubFiles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasSubFiles() {
        return hasSubFiles;
    }

    /**
     * Sets the value of the hasSubFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasSubFiles(Boolean value) {
        this.hasSubFiles = value;
    }

    /**
     * Gets the value of the readers property.
     * 
     * @return
     *     possible object is
     *     {@link LocalFileType.Readers }
     *     
     */
    public LocalFileType.Readers getReaders() {
        return readers;
    }

    /**
     * Sets the value of the readers property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalFileType.Readers }
     *     
     */
    public void setReaders(LocalFileType.Readers value) {
        this.readers = value;
    }

    /**
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link LocalFileType.Users }
     *     
     */
    public LocalFileType.Users getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalFileType.Users }
     *     
     */
    public void setUsers(LocalFileType.Users value) {
        this.users = value;
    }

    /**
     * Gets the value of the editors property.
     * 
     * @return
     *     possible object is
     *     {@link LocalFileType.Editors }
     *     
     */
    public LocalFileType.Editors getEditors() {
        return editors;
    }

    /**
     * Sets the value of the editors property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalFileType.Editors }
     *     
     */
    public void setEditors(LocalFileType.Editors value) {
        this.editors = value;
    }

    /**
     * Gets the value of the englishComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishComments() {
        return englishComments;
    }

    /**
     * Sets the value of the englishComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishComments(String value) {
        this.englishComments = value;
    }

    /**
     * Gets the value of the frenchComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrenchComments() {
        return frenchComments;
    }

    /**
     * Sets the value of the frenchComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrenchComments(String value) {
        this.frenchComments = value;
    }

    /**
     * Gets the value of the germanComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGermanComments() {
        return germanComments;
    }

    /**
     * Sets the value of the germanComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGermanComments(String value) {
        this.germanComments = value;
    }

    /**
     * Gets the value of the deskOfficer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeskOfficer() {
        return deskOfficer;
    }

    /**
     * Sets the value of the deskOfficer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeskOfficer(String value) {
        this.deskOfficer = value;
    }

    /**
     * Gets the value of the limited property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLimited() {
        return limited;
    }

    /**
     * Sets the value of the limited property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLimited(Boolean value) {
        this.limited = value;
    }

    /**
     * Gets the value of the cupboard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCupboard() {
        return cupboard;
    }

    /**
     * Sets the value of the cupboard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCupboard(String value) {
        this.cupboard = value;
    }

    /**
     * Gets the value of the office property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffice() {
        return office;
    }

    /**
     * Sets the value of the office property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffice(String value) {
        this.office = value;
    }

    /**
     * Gets the value of the binder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBinder() {
        return binder;
    }

    /**
     * Sets the value of the binder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBinder(String value) {
        this.binder = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the activationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActivationDate() {
        return activationDate;
    }

    /**
     * Sets the value of the activationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActivationDate(XMLGregorianCalendar value) {
        this.activationDate = value;
    }

    /**
     * Gets the value of the closingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClosingDate() {
        return closingDate;
    }

    /**
     * Sets the value of the closingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClosingDate(XMLGregorianCalendar value) {
        this.closingDate = value;
    }

    /**
     * Gets the value of the transferDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransferDate() {
        return transferDate;
    }

    /**
     * Sets the value of the transferDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransferDate(XMLGregorianCalendar value) {
        this.transferDate = value;
    }

    /**
     * Gets the value of the destroyDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDestroyDate() {
        return destroyDate;
    }

    /**
     * Sets the value of the destroyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDestroyDate(XMLGregorianCalendar value) {
        this.destroyDate = value;
    }

    /**
     * Gets the value of the restoreDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRestoreDate() {
        return restoreDate;
    }

    /**
     * Sets the value of the restoreDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRestoreDate(XMLGregorianCalendar value) {
        this.restoreDate = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryType }
     *     
     */
    public CategoryType getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryType }
     *     
     */
    public void setCategory(CategoryType value) {
        this.category = value;
    }

    /**
     * Gets the value of the systemHasSubFiles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSystemHasSubFiles() {
        return systemHasSubFiles;
    }

    /**
     * Sets the value of the systemHasSubFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSystemHasSubFiles(Boolean value) {
        this.systemHasSubFiles = value;
    }

    /**
     * Gets the value of the systemContainsDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSystemContainsDocuments() {
        return systemContainsDocuments;
    }

    /**
     * Sets the value of the systemContainsDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSystemContainsDocuments(Boolean value) {
        this.systemContainsDocuments = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LocalFileType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LocalFileType that = ((LocalFileType) object);
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
            boolean lhsIsSubFile;
            lhsIsSubFile = (true?this.isIsSubFile():false);
            boolean rhsIsSubFile;
            rhsIsSubFile = (true?that.isIsSubFile():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "isSubFile", lhsIsSubFile), LocatorUtils.property(thatLocator, "isSubFile", rhsIsSubFile), lhsIsSubFile, rhsIsSubFile)) {
                return false;
            }
        }
        {
            Boolean lhsIsDocumentFilingAllowed;
            lhsIsDocumentFilingAllowed = this.isIsDocumentFilingAllowed();
            Boolean rhsIsDocumentFilingAllowed;
            rhsIsDocumentFilingAllowed = that.isIsDocumentFilingAllowed();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "isDocumentFilingAllowed", lhsIsDocumentFilingAllowed), LocatorUtils.property(thatLocator, "isDocumentFilingAllowed", rhsIsDocumentFilingAllowed), lhsIsDocumentFilingAllowed, rhsIsDocumentFilingAllowed)) {
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
            String lhsHeadingCode;
            lhsHeadingCode = this.getHeadingCode();
            String rhsHeadingCode;
            rhsHeadingCode = that.getHeadingCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "headingCode", lhsHeadingCode), LocatorUtils.property(thatLocator, "headingCode", rhsHeadingCode), lhsHeadingCode, rhsHeadingCode)) {
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
            String lhsStatus;
            lhsStatus = this.getStatus();
            String rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            String lhsParentId;
            lhsParentId = this.getParentId();
            String rhsParentId;
            rhsParentId = that.getParentId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "parentId", lhsParentId), LocatorUtils.property(thatLocator, "parentId", rhsParentId), lhsParentId, rhsParentId)) {
                return false;
            }
        }
        {
            LocalFileType.MultiLingualNames lhsMultiLingualNames;
            lhsMultiLingualNames = this.getMultiLingualNames();
            LocalFileType.MultiLingualNames rhsMultiLingualNames;
            rhsMultiLingualNames = that.getMultiLingualNames();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "multiLingualNames", lhsMultiLingualNames), LocatorUtils.property(thatLocator, "multiLingualNames", rhsMultiLingualNames), lhsMultiLingualNames, rhsMultiLingualNames)) {
                return false;
            }
        }
        {
            LocalFileType.UserFileRoles lhsUserFileRoles;
            lhsUserFileRoles = this.getUserFileRoles();
            LocalFileType.UserFileRoles rhsUserFileRoles;
            rhsUserFileRoles = that.getUserFileRoles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userFileRoles", lhsUserFileRoles), LocatorUtils.property(thatLocator, "userFileRoles", rhsUserFileRoles), lhsUserFileRoles, rhsUserFileRoles)) {
                return false;
            }
        }
        {
            Boolean lhsHasSubFiles;
            lhsHasSubFiles = this.isHasSubFiles();
            Boolean rhsHasSubFiles;
            rhsHasSubFiles = that.isHasSubFiles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "hasSubFiles", lhsHasSubFiles), LocatorUtils.property(thatLocator, "hasSubFiles", rhsHasSubFiles), lhsHasSubFiles, rhsHasSubFiles)) {
                return false;
            }
        }
        {
            LocalFileType.Readers lhsReaders;
            lhsReaders = this.getReaders();
            LocalFileType.Readers rhsReaders;
            rhsReaders = that.getReaders();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "readers", lhsReaders), LocatorUtils.property(thatLocator, "readers", rhsReaders), lhsReaders, rhsReaders)) {
                return false;
            }
        }
        {
            LocalFileType.Users lhsUsers;
            lhsUsers = this.getUsers();
            LocalFileType.Users rhsUsers;
            rhsUsers = that.getUsers();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "users", lhsUsers), LocatorUtils.property(thatLocator, "users", rhsUsers), lhsUsers, rhsUsers)) {
                return false;
            }
        }
        {
            LocalFileType.Editors lhsEditors;
            lhsEditors = this.getEditors();
            LocalFileType.Editors rhsEditors;
            rhsEditors = that.getEditors();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "editors", lhsEditors), LocatorUtils.property(thatLocator, "editors", rhsEditors), lhsEditors, rhsEditors)) {
                return false;
            }
        }
        {
            String lhsEnglishComments;
            lhsEnglishComments = this.getEnglishComments();
            String rhsEnglishComments;
            rhsEnglishComments = that.getEnglishComments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "englishComments", lhsEnglishComments), LocatorUtils.property(thatLocator, "englishComments", rhsEnglishComments), lhsEnglishComments, rhsEnglishComments)) {
                return false;
            }
        }
        {
            String lhsFrenchComments;
            lhsFrenchComments = this.getFrenchComments();
            String rhsFrenchComments;
            rhsFrenchComments = that.getFrenchComments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "frenchComments", lhsFrenchComments), LocatorUtils.property(thatLocator, "frenchComments", rhsFrenchComments), lhsFrenchComments, rhsFrenchComments)) {
                return false;
            }
        }
        {
            String lhsGermanComments;
            lhsGermanComments = this.getGermanComments();
            String rhsGermanComments;
            rhsGermanComments = that.getGermanComments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "germanComments", lhsGermanComments), LocatorUtils.property(thatLocator, "germanComments", rhsGermanComments), lhsGermanComments, rhsGermanComments)) {
                return false;
            }
        }
        {
            String lhsDeskOfficer;
            lhsDeskOfficer = this.getDeskOfficer();
            String rhsDeskOfficer;
            rhsDeskOfficer = that.getDeskOfficer();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deskOfficer", lhsDeskOfficer), LocatorUtils.property(thatLocator, "deskOfficer", rhsDeskOfficer), lhsDeskOfficer, rhsDeskOfficer)) {
                return false;
            }
        }
        {
            Boolean lhsLimited;
            lhsLimited = this.isLimited();
            Boolean rhsLimited;
            rhsLimited = that.isLimited();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "limited", lhsLimited), LocatorUtils.property(thatLocator, "limited", rhsLimited), lhsLimited, rhsLimited)) {
                return false;
            }
        }
        {
            String lhsCupboard;
            lhsCupboard = this.getCupboard();
            String rhsCupboard;
            rhsCupboard = that.getCupboard();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cupboard", lhsCupboard), LocatorUtils.property(thatLocator, "cupboard", rhsCupboard), lhsCupboard, rhsCupboard)) {
                return false;
            }
        }
        {
            String lhsOffice;
            lhsOffice = this.getOffice();
            String rhsOffice;
            rhsOffice = that.getOffice();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "office", lhsOffice), LocatorUtils.property(thatLocator, "office", rhsOffice), lhsOffice, rhsOffice)) {
                return false;
            }
        }
        {
            String lhsBinder;
            lhsBinder = this.getBinder();
            String rhsBinder;
            rhsBinder = that.getBinder();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "binder", lhsBinder), LocatorUtils.property(thatLocator, "binder", rhsBinder), lhsBinder, rhsBinder)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsCreationDate;
            lhsCreationDate = this.getCreationDate();
            XMLGregorianCalendar rhsCreationDate;
            rhsCreationDate = that.getCreationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creationDate", lhsCreationDate), LocatorUtils.property(thatLocator, "creationDate", rhsCreationDate), lhsCreationDate, rhsCreationDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsActivationDate;
            lhsActivationDate = this.getActivationDate();
            XMLGregorianCalendar rhsActivationDate;
            rhsActivationDate = that.getActivationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activationDate", lhsActivationDate), LocatorUtils.property(thatLocator, "activationDate", rhsActivationDate), lhsActivationDate, rhsActivationDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsClosingDate;
            lhsClosingDate = this.getClosingDate();
            XMLGregorianCalendar rhsClosingDate;
            rhsClosingDate = that.getClosingDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "closingDate", lhsClosingDate), LocatorUtils.property(thatLocator, "closingDate", rhsClosingDate), lhsClosingDate, rhsClosingDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsTransferDate;
            lhsTransferDate = this.getTransferDate();
            XMLGregorianCalendar rhsTransferDate;
            rhsTransferDate = that.getTransferDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transferDate", lhsTransferDate), LocatorUtils.property(thatLocator, "transferDate", rhsTransferDate), lhsTransferDate, rhsTransferDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDestroyDate;
            lhsDestroyDate = this.getDestroyDate();
            XMLGregorianCalendar rhsDestroyDate;
            rhsDestroyDate = that.getDestroyDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "destroyDate", lhsDestroyDate), LocatorUtils.property(thatLocator, "destroyDate", rhsDestroyDate), lhsDestroyDate, rhsDestroyDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsRestoreDate;
            lhsRestoreDate = this.getRestoreDate();
            XMLGregorianCalendar rhsRestoreDate;
            rhsRestoreDate = that.getRestoreDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "restoreDate", lhsRestoreDate), LocatorUtils.property(thatLocator, "restoreDate", rhsRestoreDate), lhsRestoreDate, rhsRestoreDate)) {
                return false;
            }
        }
        {
            CategoryType lhsCategory;
            lhsCategory = this.getCategory();
            CategoryType rhsCategory;
            rhsCategory = that.getCategory();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "category", lhsCategory), LocatorUtils.property(thatLocator, "category", rhsCategory), lhsCategory, rhsCategory)) {
                return false;
            }
        }
        {
            Boolean lhsSystemHasSubFiles;
            lhsSystemHasSubFiles = this.isSystemHasSubFiles();
            Boolean rhsSystemHasSubFiles;
            rhsSystemHasSubFiles = that.isSystemHasSubFiles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "systemHasSubFiles", lhsSystemHasSubFiles), LocatorUtils.property(thatLocator, "systemHasSubFiles", rhsSystemHasSubFiles), lhsSystemHasSubFiles, rhsSystemHasSubFiles)) {
                return false;
            }
        }
        {
            Boolean lhsSystemContainsDocuments;
            lhsSystemContainsDocuments = this.isSystemContainsDocuments();
            Boolean rhsSystemContainsDocuments;
            rhsSystemContainsDocuments = that.isSystemContainsDocuments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "systemContainsDocuments", lhsSystemContainsDocuments), LocatorUtils.property(thatLocator, "systemContainsDocuments", rhsSystemContainsDocuments), lhsSystemContainsDocuments, rhsSystemContainsDocuments)) {
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
            boolean theIsSubFile;
            theIsSubFile = (true?this.isIsSubFile():false);
            strategy.appendField(locator, this, "isSubFile", buffer, theIsSubFile);
        }
        {
            Boolean theIsDocumentFilingAllowed;
            theIsDocumentFilingAllowed = this.isIsDocumentFilingAllowed();
            strategy.appendField(locator, this, "isDocumentFilingAllowed", buffer, theIsDocumentFilingAllowed);
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
            String theHeadingCode;
            theHeadingCode = this.getHeadingCode();
            strategy.appendField(locator, this, "headingCode", buffer, theHeadingCode);
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
            String theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            String theParentId;
            theParentId = this.getParentId();
            strategy.appendField(locator, this, "parentId", buffer, theParentId);
        }
        {
            LocalFileType.MultiLingualNames theMultiLingualNames;
            theMultiLingualNames = this.getMultiLingualNames();
            strategy.appendField(locator, this, "multiLingualNames", buffer, theMultiLingualNames);
        }
        {
            LocalFileType.UserFileRoles theUserFileRoles;
            theUserFileRoles = this.getUserFileRoles();
            strategy.appendField(locator, this, "userFileRoles", buffer, theUserFileRoles);
        }
        {
            Boolean theHasSubFiles;
            theHasSubFiles = this.isHasSubFiles();
            strategy.appendField(locator, this, "hasSubFiles", buffer, theHasSubFiles);
        }
        {
            LocalFileType.Readers theReaders;
            theReaders = this.getReaders();
            strategy.appendField(locator, this, "readers", buffer, theReaders);
        }
        {
            LocalFileType.Users theUsers;
            theUsers = this.getUsers();
            strategy.appendField(locator, this, "users", buffer, theUsers);
        }
        {
            LocalFileType.Editors theEditors;
            theEditors = this.getEditors();
            strategy.appendField(locator, this, "editors", buffer, theEditors);
        }
        {
            String theEnglishComments;
            theEnglishComments = this.getEnglishComments();
            strategy.appendField(locator, this, "englishComments", buffer, theEnglishComments);
        }
        {
            String theFrenchComments;
            theFrenchComments = this.getFrenchComments();
            strategy.appendField(locator, this, "frenchComments", buffer, theFrenchComments);
        }
        {
            String theGermanComments;
            theGermanComments = this.getGermanComments();
            strategy.appendField(locator, this, "germanComments", buffer, theGermanComments);
        }
        {
            String theDeskOfficer;
            theDeskOfficer = this.getDeskOfficer();
            strategy.appendField(locator, this, "deskOfficer", buffer, theDeskOfficer);
        }
        {
            Boolean theLimited;
            theLimited = this.isLimited();
            strategy.appendField(locator, this, "limited", buffer, theLimited);
        }
        {
            String theCupboard;
            theCupboard = this.getCupboard();
            strategy.appendField(locator, this, "cupboard", buffer, theCupboard);
        }
        {
            String theOffice;
            theOffice = this.getOffice();
            strategy.appendField(locator, this, "office", buffer, theOffice);
        }
        {
            String theBinder;
            theBinder = this.getBinder();
            strategy.appendField(locator, this, "binder", buffer, theBinder);
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            strategy.appendField(locator, this, "creationDate", buffer, theCreationDate);
        }
        {
            XMLGregorianCalendar theActivationDate;
            theActivationDate = this.getActivationDate();
            strategy.appendField(locator, this, "activationDate", buffer, theActivationDate);
        }
        {
            XMLGregorianCalendar theClosingDate;
            theClosingDate = this.getClosingDate();
            strategy.appendField(locator, this, "closingDate", buffer, theClosingDate);
        }
        {
            XMLGregorianCalendar theTransferDate;
            theTransferDate = this.getTransferDate();
            strategy.appendField(locator, this, "transferDate", buffer, theTransferDate);
        }
        {
            XMLGregorianCalendar theDestroyDate;
            theDestroyDate = this.getDestroyDate();
            strategy.appendField(locator, this, "destroyDate", buffer, theDestroyDate);
        }
        {
            XMLGregorianCalendar theRestoreDate;
            theRestoreDate = this.getRestoreDate();
            strategy.appendField(locator, this, "restoreDate", buffer, theRestoreDate);
        }
        {
            CategoryType theCategory;
            theCategory = this.getCategory();
            strategy.appendField(locator, this, "category", buffer, theCategory);
        }
        {
            Boolean theSystemHasSubFiles;
            theSystemHasSubFiles = this.isSystemHasSubFiles();
            strategy.appendField(locator, this, "systemHasSubFiles", buffer, theSystemHasSubFiles);
        }
        {
            Boolean theSystemContainsDocuments;
            theSystemContainsDocuments = this.isSystemContainsDocuments();
            strategy.appendField(locator, this, "systemContainsDocuments", buffer, theSystemContainsDocuments);
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
            boolean theIsSubFile;
            theIsSubFile = (true?this.isIsSubFile():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "isSubFile", theIsSubFile), currentHashCode, theIsSubFile);
        }
        {
            Boolean theIsDocumentFilingAllowed;
            theIsDocumentFilingAllowed = this.isIsDocumentFilingAllowed();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "isDocumentFilingAllowed", theIsDocumentFilingAllowed), currentHashCode, theIsDocumentFilingAllowed);
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
            String theHeadingCode;
            theHeadingCode = this.getHeadingCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "headingCode", theHeadingCode), currentHashCode, theHeadingCode);
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
            String theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            String theParentId;
            theParentId = this.getParentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "parentId", theParentId), currentHashCode, theParentId);
        }
        {
            LocalFileType.MultiLingualNames theMultiLingualNames;
            theMultiLingualNames = this.getMultiLingualNames();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "multiLingualNames", theMultiLingualNames), currentHashCode, theMultiLingualNames);
        }
        {
            LocalFileType.UserFileRoles theUserFileRoles;
            theUserFileRoles = this.getUserFileRoles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userFileRoles", theUserFileRoles), currentHashCode, theUserFileRoles);
        }
        {
            Boolean theHasSubFiles;
            theHasSubFiles = this.isHasSubFiles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hasSubFiles", theHasSubFiles), currentHashCode, theHasSubFiles);
        }
        {
            LocalFileType.Readers theReaders;
            theReaders = this.getReaders();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "readers", theReaders), currentHashCode, theReaders);
        }
        {
            LocalFileType.Users theUsers;
            theUsers = this.getUsers();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "users", theUsers), currentHashCode, theUsers);
        }
        {
            LocalFileType.Editors theEditors;
            theEditors = this.getEditors();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "editors", theEditors), currentHashCode, theEditors);
        }
        {
            String theEnglishComments;
            theEnglishComments = this.getEnglishComments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "englishComments", theEnglishComments), currentHashCode, theEnglishComments);
        }
        {
            String theFrenchComments;
            theFrenchComments = this.getFrenchComments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "frenchComments", theFrenchComments), currentHashCode, theFrenchComments);
        }
        {
            String theGermanComments;
            theGermanComments = this.getGermanComments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "germanComments", theGermanComments), currentHashCode, theGermanComments);
        }
        {
            String theDeskOfficer;
            theDeskOfficer = this.getDeskOfficer();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deskOfficer", theDeskOfficer), currentHashCode, theDeskOfficer);
        }
        {
            Boolean theLimited;
            theLimited = this.isLimited();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "limited", theLimited), currentHashCode, theLimited);
        }
        {
            String theCupboard;
            theCupboard = this.getCupboard();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cupboard", theCupboard), currentHashCode, theCupboard);
        }
        {
            String theOffice;
            theOffice = this.getOffice();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "office", theOffice), currentHashCode, theOffice);
        }
        {
            String theBinder;
            theBinder = this.getBinder();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "binder", theBinder), currentHashCode, theBinder);
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creationDate", theCreationDate), currentHashCode, theCreationDate);
        }
        {
            XMLGregorianCalendar theActivationDate;
            theActivationDate = this.getActivationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activationDate", theActivationDate), currentHashCode, theActivationDate);
        }
        {
            XMLGregorianCalendar theClosingDate;
            theClosingDate = this.getClosingDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "closingDate", theClosingDate), currentHashCode, theClosingDate);
        }
        {
            XMLGregorianCalendar theTransferDate;
            theTransferDate = this.getTransferDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transferDate", theTransferDate), currentHashCode, theTransferDate);
        }
        {
            XMLGregorianCalendar theDestroyDate;
            theDestroyDate = this.getDestroyDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "destroyDate", theDestroyDate), currentHashCode, theDestroyDate);
        }
        {
            XMLGregorianCalendar theRestoreDate;
            theRestoreDate = this.getRestoreDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "restoreDate", theRestoreDate), currentHashCode, theRestoreDate);
        }
        {
            CategoryType theCategory;
            theCategory = this.getCategory();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "category", theCategory), currentHashCode, theCategory);
        }
        {
            Boolean theSystemHasSubFiles;
            theSystemHasSubFiles = this.isSystemHasSubFiles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "systemHasSubFiles", theSystemHasSubFiles), currentHashCode, theSystemHasSubFiles);
        }
        {
            Boolean theSystemContainsDocuments;
            theSystemContainsDocuments = this.isSystemContainsDocuments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "systemContainsDocuments", theSystemContainsDocuments), currentHashCode, theSystemContainsDocuments);
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
     *         &lt;element name="Editor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "editor"
    })
    public static class Editors
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "Editor")
        protected List<String> editor;

        /**
         * Gets the value of the editor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the editor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEditor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getEditor() {
            if (editor == null) {
                editor = new ArrayList<String>();
            }
            return this.editor;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof LocalFileType.Editors)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final LocalFileType.Editors that = ((LocalFileType.Editors) object);
            {
                List<String> lhsEditor;
                lhsEditor = (((this.editor!= null)&&(!this.editor.isEmpty()))?this.getEditor():null);
                List<String> rhsEditor;
                rhsEditor = (((that.editor!= null)&&(!that.editor.isEmpty()))?that.getEditor():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "editor", lhsEditor), LocatorUtils.property(thatLocator, "editor", rhsEditor), lhsEditor, rhsEditor)) {
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
                List<String> theEditor;
                theEditor = (((this.editor!= null)&&(!this.editor.isEmpty()))?this.getEditor():null);
                strategy.appendField(locator, this, "editor", buffer, theEditor);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theEditor;
                theEditor = (((this.editor!= null)&&(!this.editor.isEmpty()))?this.getEditor():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "editor", theEditor), currentHashCode, theEditor);
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
     *         &lt;element name="MultiLingualName" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "multiLingualName"
    })
    public static class MultiLingualNames
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "MultiLingualName")
        protected List<LocalFileType.MultiLingualNames.MultiLingualName> multiLingualName;

        /**
         * Gets the value of the multiLingualName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the multiLingualName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMultiLingualName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LocalFileType.MultiLingualNames.MultiLingualName }
         * 
         * 
         */
        public List<LocalFileType.MultiLingualNames.MultiLingualName> getMultiLingualName() {
            if (multiLingualName == null) {
                multiLingualName = new ArrayList<LocalFileType.MultiLingualNames.MultiLingualName>();
            }
            return this.multiLingualName;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof LocalFileType.MultiLingualNames)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final LocalFileType.MultiLingualNames that = ((LocalFileType.MultiLingualNames) object);
            {
                List<LocalFileType.MultiLingualNames.MultiLingualName> lhsMultiLingualName;
                lhsMultiLingualName = (((this.multiLingualName!= null)&&(!this.multiLingualName.isEmpty()))?this.getMultiLingualName():null);
                List<LocalFileType.MultiLingualNames.MultiLingualName> rhsMultiLingualName;
                rhsMultiLingualName = (((that.multiLingualName!= null)&&(!that.multiLingualName.isEmpty()))?that.getMultiLingualName():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "multiLingualName", lhsMultiLingualName), LocatorUtils.property(thatLocator, "multiLingualName", rhsMultiLingualName), lhsMultiLingualName, rhsMultiLingualName)) {
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
                List<LocalFileType.MultiLingualNames.MultiLingualName> theMultiLingualName;
                theMultiLingualName = (((this.multiLingualName!= null)&&(!this.multiLingualName.isEmpty()))?this.getMultiLingualName():null);
                strategy.appendField(locator, this, "multiLingualName", buffer, theMultiLingualName);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<LocalFileType.MultiLingualNames.MultiLingualName> theMultiLingualName;
                theMultiLingualName = (((this.multiLingualName!= null)&&(!this.multiLingualName.isEmpty()))?this.getMultiLingualName():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "multiLingualName", theMultiLingualName), currentHashCode, theMultiLingualName);
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
         *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "language",
            "value"
        })
        public static class MultiLingualName
            implements Equals, HashCode, ToString
        {

            @XmlElement(name = "Language", required = true)
            protected String language;
            @XmlElement(name = "Value", required = true)
            protected String value;

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
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof LocalFileType.MultiLingualNames.MultiLingualName)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final LocalFileType.MultiLingualNames.MultiLingualName that = ((LocalFileType.MultiLingualNames.MultiLingualName) object);
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
                    String lhsValue;
                    lhsValue = this.getValue();
                    String rhsValue;
                    rhsValue = that.getValue();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "value", lhsValue), LocatorUtils.property(thatLocator, "value", rhsValue), lhsValue, rhsValue)) {
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
                    String theLanguage;
                    theLanguage = this.getLanguage();
                    strategy.appendField(locator, this, "language", buffer, theLanguage);
                }
                {
                    String theValue;
                    theValue = this.getValue();
                    strategy.appendField(locator, this, "value", buffer, theValue);
                }
                return buffer;
            }

            public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
                int currentHashCode = 1;
                {
                    String theLanguage;
                    theLanguage = this.getLanguage();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "language", theLanguage), currentHashCode, theLanguage);
                }
                {
                    String theValue;
                    theValue = this.getValue();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "value", theValue), currentHashCode, theValue);
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
     *         &lt;element name="Reader" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "reader"
    })
    public static class Readers
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "Reader")
        protected List<String> reader;

        /**
         * Gets the value of the reader property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the reader property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReader().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getReader() {
            if (reader == null) {
                reader = new ArrayList<String>();
            }
            return this.reader;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof LocalFileType.Readers)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final LocalFileType.Readers that = ((LocalFileType.Readers) object);
            {
                List<String> lhsReader;
                lhsReader = (((this.reader!= null)&&(!this.reader.isEmpty()))?this.getReader():null);
                List<String> rhsReader;
                rhsReader = (((that.reader!= null)&&(!that.reader.isEmpty()))?that.getReader():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "reader", lhsReader), LocatorUtils.property(thatLocator, "reader", rhsReader), lhsReader, rhsReader)) {
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
                List<String> theReader;
                theReader = (((this.reader!= null)&&(!this.reader.isEmpty()))?this.getReader():null);
                strategy.appendField(locator, this, "reader", buffer, theReader);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theReader;
                theReader = (((this.reader!= null)&&(!this.reader.isEmpty()))?this.getReader():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reader", theReader), currentHashCode, theReader);
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
     *         &lt;element name="UserFileRole" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "userFileRole"
    })
    public static class UserFileRoles
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "UserFileRole")
        protected List<String> userFileRole;

        /**
         * Gets the value of the userFileRole property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the userFileRole property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUserFileRole().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getUserFileRole() {
            if (userFileRole == null) {
                userFileRole = new ArrayList<String>();
            }
            return this.userFileRole;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof LocalFileType.UserFileRoles)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final LocalFileType.UserFileRoles that = ((LocalFileType.UserFileRoles) object);
            {
                List<String> lhsUserFileRole;
                lhsUserFileRole = (((this.userFileRole!= null)&&(!this.userFileRole.isEmpty()))?this.getUserFileRole():null);
                List<String> rhsUserFileRole;
                rhsUserFileRole = (((that.userFileRole!= null)&&(!that.userFileRole.isEmpty()))?that.getUserFileRole():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "userFileRole", lhsUserFileRole), LocatorUtils.property(thatLocator, "userFileRole", rhsUserFileRole), lhsUserFileRole, rhsUserFileRole)) {
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
                List<String> theUserFileRole;
                theUserFileRole = (((this.userFileRole!= null)&&(!this.userFileRole.isEmpty()))?this.getUserFileRole():null);
                strategy.appendField(locator, this, "userFileRole", buffer, theUserFileRole);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theUserFileRole;
                theUserFileRole = (((this.userFileRole!= null)&&(!this.userFileRole.isEmpty()))?this.getUserFileRole():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userFileRole", theUserFileRole), currentHashCode, theUserFileRole);
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
     *         &lt;element name="User" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "user"
    })
    public static class Users
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "User")
        protected List<String> user;

        /**
         * Gets the value of the user property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the user property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUser().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getUser() {
            if (user == null) {
                user = new ArrayList<String>();
            }
            return this.user;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof LocalFileType.Users)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final LocalFileType.Users that = ((LocalFileType.Users) object);
            {
                List<String> lhsUser;
                lhsUser = (((this.user!= null)&&(!this.user.isEmpty()))?this.getUser():null);
                List<String> rhsUser;
                rhsUser = (((that.user!= null)&&(!that.user.isEmpty()))?that.getUser():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "user", lhsUser), LocatorUtils.property(thatLocator, "user", rhsUser), lhsUser, rhsUser)) {
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
                List<String> theUser;
                theUser = (((this.user!= null)&&(!this.user.isEmpty()))?this.getUser():null);
                strategy.appendField(locator, this, "user", buffer, theUser);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theUser;
                theUser = (((this.user!= null)&&(!this.user.isEmpty()))?this.getUser():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "user", theUser), currentHashCode, theUser);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
