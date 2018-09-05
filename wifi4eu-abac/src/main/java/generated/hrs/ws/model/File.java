
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
 * A file (dossier)
 * 
 * <p>Java class for File complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="File">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="isSubFile" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isDocumentFilingAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chefDeFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="associatedLeadDepartments" type="{http://ec.europa.eu/sg/hrs/types}AssociatedLeadDepartments" minOccurs="0"/>
 *         &lt;element name="headingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specificCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://ec.europa.eu/sg/hrs/types}FileStatus" minOccurs="0"/>
 *         &lt;element name="parentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" minOccurs="0"/>
 *         &lt;element name="englishName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="germanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userFileRoles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="userFileRole" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="NOMCOM_MANAGER"/>
 *                         &lt;enumeration value="FILE_EDITOR"/>
 *                         &lt;enumeration value="FILE_USER"/>
 *                         &lt;enumeration value="FILE_READER"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="hasSubFiles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="readers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="reader" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="users" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="editors" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="editor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="englishComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="germanComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deskOfficer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="visibility" type="{http://ec.europa.eu/sg/hrs/types}FileVisibilityType" minOccurs="0"/>
 *         &lt;element name="special" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="activationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="closingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="transferDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="destroyDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="restoreDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="category" type="{http://ec.europa.eu/sg/hrs/types}Category" minOccurs="0"/>
 *         &lt;element name="systemHasSubFiles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="systemContainsDocuments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="preservationMetadata" type="{http://ec.europa.eu/sg/hrs/types}FilePreservationMetadata" minOccurs="0"/>
 *         &lt;element name="transparencyMetadata" type="{http://ec.europa.eu/sg/hrs/types}FileTransparencyMetadata" minOccurs="0"/>
 *         &lt;element name="systemDocumentCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="accessibleDocumentCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "File", propOrder = {
    "fileId",
    "isSubFile",
    "isDocumentFilingAllowed",
    "path",
    "chefDeFile",
    "associatedLeadDepartments",
    "headingCode",
    "fileCode",
    "specificCode",
    "status",
    "parentId",
    "englishName",
    "frenchName",
    "germanName",
    "userFileRoles",
    "hasSubFiles",
    "readers",
    "users",
    "editors",
    "englishComments",
    "frenchComments",
    "germanComments",
    "deskOfficer",
    "visibility",
    "special",
    "creationDate",
    "activationDate",
    "closingDate",
    "transferDate",
    "destroyDate",
    "restoreDate",
    "category",
    "systemHasSubFiles",
    "systemContainsDocuments",
    "preservationMetadata",
    "transparencyMetadata",
    "systemDocumentCount",
    "accessibleDocumentCount"
})
public class File
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String fileId;
    protected boolean isSubFile;
    protected Boolean isDocumentFilingAllowed;
    @XmlElement(required = true)
    protected String path;
    protected String chefDeFile;
    protected AssociatedLeadDepartments associatedLeadDepartments;
    protected String headingCode;
    protected String fileCode;
    protected String specificCode;
    protected FileStatus status;
    protected String parentId;
    protected String englishName;
    protected String frenchName;
    protected String germanName;
    protected File.UserFileRoles userFileRoles;
    protected Boolean hasSubFiles;
    protected File.Readers readers;
    protected File.Users users;
    protected File.Editors editors;
    protected String englishComments;
    protected String frenchComments;
    protected String germanComments;
    protected String deskOfficer;
    protected FileVisibilityType visibility;
    protected Boolean special;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar creationDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar activationDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar closingDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar transferDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar destroyDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar restoreDate;
    protected Category category;
    protected Boolean systemHasSubFiles;
    protected Boolean systemContainsDocuments;
    protected FilePreservationMetadata preservationMetadata;
    protected FileTransparencyMetadata transparencyMetadata;
    protected Integer systemDocumentCount;
    protected Integer accessibleDocumentCount;

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
     * Gets the value of the associatedLeadDepartments property.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedLeadDepartments }
     *     
     */
    public AssociatedLeadDepartments getAssociatedLeadDepartments() {
        return associatedLeadDepartments;
    }

    /**
     * Sets the value of the associatedLeadDepartments property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedLeadDepartments }
     *     
     */
    public void setAssociatedLeadDepartments(AssociatedLeadDepartments value) {
        this.associatedLeadDepartments = value;
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
     * Gets the value of the userFileRoles property.
     * 
     * @return
     *     possible object is
     *     {@link File.UserFileRoles }
     *     
     */
    public File.UserFileRoles getUserFileRoles() {
        return userFileRoles;
    }

    /**
     * Sets the value of the userFileRoles property.
     * 
     * @param value
     *     allowed object is
     *     {@link File.UserFileRoles }
     *     
     */
    public void setUserFileRoles(File.UserFileRoles value) {
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
     *     {@link File.Readers }
     *     
     */
    public File.Readers getReaders() {
        return readers;
    }

    /**
     * Sets the value of the readers property.
     * 
     * @param value
     *     allowed object is
     *     {@link File.Readers }
     *     
     */
    public void setReaders(File.Readers value) {
        this.readers = value;
    }

    /**
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link File.Users }
     *     
     */
    public File.Users getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link File.Users }
     *     
     */
    public void setUsers(File.Users value) {
        this.users = value;
    }

    /**
     * Gets the value of the editors property.
     * 
     * @return
     *     possible object is
     *     {@link File.Editors }
     *     
     */
    public File.Editors getEditors() {
        return editors;
    }

    /**
     * Sets the value of the editors property.
     * 
     * @param value
     *     allowed object is
     *     {@link File.Editors }
     *     
     */
    public void setEditors(File.Editors value) {
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
     * Gets the value of the visibility property.
     * 
     * @return
     *     possible object is
     *     {@link FileVisibilityType }
     *     
     */
    public FileVisibilityType getVisibility() {
        return visibility;
    }

    /**
     * Sets the value of the visibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileVisibilityType }
     *     
     */
    public void setVisibility(FileVisibilityType value) {
        this.visibility = value;
    }

    /**
     * Gets the value of the special property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSpecial() {
        return special;
    }

    /**
     * Sets the value of the special property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSpecial(Boolean value) {
        this.special = value;
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
     *     {@link Category }
     *     
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setCategory(Category value) {
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

    /**
     * Gets the value of the preservationMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link FilePreservationMetadata }
     *     
     */
    public FilePreservationMetadata getPreservationMetadata() {
        return preservationMetadata;
    }

    /**
     * Sets the value of the preservationMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilePreservationMetadata }
     *     
     */
    public void setPreservationMetadata(FilePreservationMetadata value) {
        this.preservationMetadata = value;
    }

    /**
     * Gets the value of the transparencyMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link FileTransparencyMetadata }
     *     
     */
    public FileTransparencyMetadata getTransparencyMetadata() {
        return transparencyMetadata;
    }

    /**
     * Sets the value of the transparencyMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileTransparencyMetadata }
     *     
     */
    public void setTransparencyMetadata(FileTransparencyMetadata value) {
        this.transparencyMetadata = value;
    }

    /**
     * Gets the value of the systemDocumentCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSystemDocumentCount() {
        return systemDocumentCount;
    }

    /**
     * Sets the value of the systemDocumentCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSystemDocumentCount(Integer value) {
        this.systemDocumentCount = value;
    }

    /**
     * Gets the value of the accessibleDocumentCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAccessibleDocumentCount() {
        return accessibleDocumentCount;
    }

    /**
     * Sets the value of the accessibleDocumentCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAccessibleDocumentCount(Integer value) {
        this.accessibleDocumentCount = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof File)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final File that = ((File) object);
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
            AssociatedLeadDepartments lhsAssociatedLeadDepartments;
            lhsAssociatedLeadDepartments = this.getAssociatedLeadDepartments();
            AssociatedLeadDepartments rhsAssociatedLeadDepartments;
            rhsAssociatedLeadDepartments = that.getAssociatedLeadDepartments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "associatedLeadDepartments", lhsAssociatedLeadDepartments), LocatorUtils.property(thatLocator, "associatedLeadDepartments", rhsAssociatedLeadDepartments), lhsAssociatedLeadDepartments, rhsAssociatedLeadDepartments)) {
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
            FileStatus lhsStatus;
            lhsStatus = this.getStatus();
            FileStatus rhsStatus;
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
            File.UserFileRoles lhsUserFileRoles;
            lhsUserFileRoles = this.getUserFileRoles();
            File.UserFileRoles rhsUserFileRoles;
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
            File.Readers lhsReaders;
            lhsReaders = this.getReaders();
            File.Readers rhsReaders;
            rhsReaders = that.getReaders();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "readers", lhsReaders), LocatorUtils.property(thatLocator, "readers", rhsReaders), lhsReaders, rhsReaders)) {
                return false;
            }
        }
        {
            File.Users lhsUsers;
            lhsUsers = this.getUsers();
            File.Users rhsUsers;
            rhsUsers = that.getUsers();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "users", lhsUsers), LocatorUtils.property(thatLocator, "users", rhsUsers), lhsUsers, rhsUsers)) {
                return false;
            }
        }
        {
            File.Editors lhsEditors;
            lhsEditors = this.getEditors();
            File.Editors rhsEditors;
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
            FileVisibilityType lhsVisibility;
            lhsVisibility = this.getVisibility();
            FileVisibilityType rhsVisibility;
            rhsVisibility = that.getVisibility();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "visibility", lhsVisibility), LocatorUtils.property(thatLocator, "visibility", rhsVisibility), lhsVisibility, rhsVisibility)) {
                return false;
            }
        }
        {
            Boolean lhsSpecial;
            lhsSpecial = this.isSpecial();
            Boolean rhsSpecial;
            rhsSpecial = that.isSpecial();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "special", lhsSpecial), LocatorUtils.property(thatLocator, "special", rhsSpecial), lhsSpecial, rhsSpecial)) {
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
            Category lhsCategory;
            lhsCategory = this.getCategory();
            Category rhsCategory;
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
        {
            FilePreservationMetadata lhsPreservationMetadata;
            lhsPreservationMetadata = this.getPreservationMetadata();
            FilePreservationMetadata rhsPreservationMetadata;
            rhsPreservationMetadata = that.getPreservationMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "preservationMetadata", lhsPreservationMetadata), LocatorUtils.property(thatLocator, "preservationMetadata", rhsPreservationMetadata), lhsPreservationMetadata, rhsPreservationMetadata)) {
                return false;
            }
        }
        {
            FileTransparencyMetadata lhsTransparencyMetadata;
            lhsTransparencyMetadata = this.getTransparencyMetadata();
            FileTransparencyMetadata rhsTransparencyMetadata;
            rhsTransparencyMetadata = that.getTransparencyMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transparencyMetadata", lhsTransparencyMetadata), LocatorUtils.property(thatLocator, "transparencyMetadata", rhsTransparencyMetadata), lhsTransparencyMetadata, rhsTransparencyMetadata)) {
                return false;
            }
        }
        {
            Integer lhsSystemDocumentCount;
            lhsSystemDocumentCount = this.getSystemDocumentCount();
            Integer rhsSystemDocumentCount;
            rhsSystemDocumentCount = that.getSystemDocumentCount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "systemDocumentCount", lhsSystemDocumentCount), LocatorUtils.property(thatLocator, "systemDocumentCount", rhsSystemDocumentCount), lhsSystemDocumentCount, rhsSystemDocumentCount)) {
                return false;
            }
        }
        {
            Integer lhsAccessibleDocumentCount;
            lhsAccessibleDocumentCount = this.getAccessibleDocumentCount();
            Integer rhsAccessibleDocumentCount;
            rhsAccessibleDocumentCount = that.getAccessibleDocumentCount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accessibleDocumentCount", lhsAccessibleDocumentCount), LocatorUtils.property(thatLocator, "accessibleDocumentCount", rhsAccessibleDocumentCount), lhsAccessibleDocumentCount, rhsAccessibleDocumentCount)) {
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
            AssociatedLeadDepartments theAssociatedLeadDepartments;
            theAssociatedLeadDepartments = this.getAssociatedLeadDepartments();
            strategy.appendField(locator, this, "associatedLeadDepartments", buffer, theAssociatedLeadDepartments);
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
            FileStatus theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            String theParentId;
            theParentId = this.getParentId();
            strategy.appendField(locator, this, "parentId", buffer, theParentId);
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
            File.UserFileRoles theUserFileRoles;
            theUserFileRoles = this.getUserFileRoles();
            strategy.appendField(locator, this, "userFileRoles", buffer, theUserFileRoles);
        }
        {
            Boolean theHasSubFiles;
            theHasSubFiles = this.isHasSubFiles();
            strategy.appendField(locator, this, "hasSubFiles", buffer, theHasSubFiles);
        }
        {
            File.Readers theReaders;
            theReaders = this.getReaders();
            strategy.appendField(locator, this, "readers", buffer, theReaders);
        }
        {
            File.Users theUsers;
            theUsers = this.getUsers();
            strategy.appendField(locator, this, "users", buffer, theUsers);
        }
        {
            File.Editors theEditors;
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
            FileVisibilityType theVisibility;
            theVisibility = this.getVisibility();
            strategy.appendField(locator, this, "visibility", buffer, theVisibility);
        }
        {
            Boolean theSpecial;
            theSpecial = this.isSpecial();
            strategy.appendField(locator, this, "special", buffer, theSpecial);
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
            Category theCategory;
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
        {
            FilePreservationMetadata thePreservationMetadata;
            thePreservationMetadata = this.getPreservationMetadata();
            strategy.appendField(locator, this, "preservationMetadata", buffer, thePreservationMetadata);
        }
        {
            FileTransparencyMetadata theTransparencyMetadata;
            theTransparencyMetadata = this.getTransparencyMetadata();
            strategy.appendField(locator, this, "transparencyMetadata", buffer, theTransparencyMetadata);
        }
        {
            Integer theSystemDocumentCount;
            theSystemDocumentCount = this.getSystemDocumentCount();
            strategy.appendField(locator, this, "systemDocumentCount", buffer, theSystemDocumentCount);
        }
        {
            Integer theAccessibleDocumentCount;
            theAccessibleDocumentCount = this.getAccessibleDocumentCount();
            strategy.appendField(locator, this, "accessibleDocumentCount", buffer, theAccessibleDocumentCount);
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
            AssociatedLeadDepartments theAssociatedLeadDepartments;
            theAssociatedLeadDepartments = this.getAssociatedLeadDepartments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "associatedLeadDepartments", theAssociatedLeadDepartments), currentHashCode, theAssociatedLeadDepartments);
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
            FileStatus theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            String theParentId;
            theParentId = this.getParentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "parentId", theParentId), currentHashCode, theParentId);
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
            File.UserFileRoles theUserFileRoles;
            theUserFileRoles = this.getUserFileRoles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userFileRoles", theUserFileRoles), currentHashCode, theUserFileRoles);
        }
        {
            Boolean theHasSubFiles;
            theHasSubFiles = this.isHasSubFiles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hasSubFiles", theHasSubFiles), currentHashCode, theHasSubFiles);
        }
        {
            File.Readers theReaders;
            theReaders = this.getReaders();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "readers", theReaders), currentHashCode, theReaders);
        }
        {
            File.Users theUsers;
            theUsers = this.getUsers();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "users", theUsers), currentHashCode, theUsers);
        }
        {
            File.Editors theEditors;
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
            FileVisibilityType theVisibility;
            theVisibility = this.getVisibility();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "visibility", theVisibility), currentHashCode, theVisibility);
        }
        {
            Boolean theSpecial;
            theSpecial = this.isSpecial();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "special", theSpecial), currentHashCode, theSpecial);
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
            Category theCategory;
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
        {
            FilePreservationMetadata thePreservationMetadata;
            thePreservationMetadata = this.getPreservationMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "preservationMetadata", thePreservationMetadata), currentHashCode, thePreservationMetadata);
        }
        {
            FileTransparencyMetadata theTransparencyMetadata;
            theTransparencyMetadata = this.getTransparencyMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transparencyMetadata", theTransparencyMetadata), currentHashCode, theTransparencyMetadata);
        }
        {
            Integer theSystemDocumentCount;
            theSystemDocumentCount = this.getSystemDocumentCount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "systemDocumentCount", theSystemDocumentCount), currentHashCode, theSystemDocumentCount);
        }
        {
            Integer theAccessibleDocumentCount;
            theAccessibleDocumentCount = this.getAccessibleDocumentCount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accessibleDocumentCount", theAccessibleDocumentCount), currentHashCode, theAccessibleDocumentCount);
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
     *         &lt;element name="editor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
            if (!(object instanceof File.Editors)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final File.Editors that = ((File.Editors) object);
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
     *         &lt;element name="reader" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
            if (!(object instanceof File.Readers)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final File.Readers that = ((File.Readers) object);
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
     *         &lt;element name="userFileRole" maxOccurs="unbounded" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="NOMCOM_MANAGER"/>
     *               &lt;enumeration value="FILE_EDITOR"/>
     *               &lt;enumeration value="FILE_USER"/>
     *               &lt;enumeration value="FILE_READER"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "userFileRole"
    })
    public static class UserFileRoles
        implements Equals, HashCode, ToString
    {

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
            if (!(object instanceof File.UserFileRoles)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final File.UserFileRoles that = ((File.UserFileRoles) object);
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
     *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
            if (!(object instanceof File.Users)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final File.Users that = ((File.Users) object);
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
