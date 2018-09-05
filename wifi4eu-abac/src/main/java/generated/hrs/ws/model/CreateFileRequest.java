
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
 * Request for creating a file
 * 
 * <p>Java class for CreateFileRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateFileRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="headingId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *           &lt;element name="parentFileId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;/choice>
 *         &lt;element name="englishName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="germanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="germanComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specialFile" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="custodian" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userFirstUseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="userClosureDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="financialDocuments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="otherDigitalRepositories" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="otherStorageTypes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="shelf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cupboard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="office" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locationComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specificCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chefDeFile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="associatedLeadDepartments" type="{http://ec.europa.eu/sg/hrs/types}AssociatedLeadDepartments" minOccurs="0"/>
 *         &lt;element name="deskOfficer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="editors">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="editor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="activate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="categoryKey" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" minOccurs="0"/>
 *         &lt;element name="sensitivePersonalData" type="{http://ec.europa.eu/sg/hrs/types}FileSensitivePersonalData" minOccurs="0"/>
 *         &lt;element name="exceptionForOpeningToThePublic" type="{http://ec.europa.eu/sg/hrs/types}FileExceptionForOpeningToThePublic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="commentsRelatedToOpeningToThePublic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateFileRequest", propOrder = {
    "headingId",
    "parentFileId",
    "englishName",
    "frenchName",
    "germanName",
    "englishComments",
    "frenchComments",
    "germanComments",
    "specialFile",
    "custodian",
    "userFirstUseDate",
    "userClosureDate",
    "financialDocuments",
    "otherDigitalRepositories",
    "otherStorageTypes",
    "shelf",
    "cupboard",
    "office",
    "locationComments",
    "specificCode",
    "chefDeFile",
    "associatedLeadDepartments",
    "deskOfficer",
    "readers",
    "users",
    "editors",
    "activate",
    "categoryKey",
    "sensitivePersonalData",
    "exceptionForOpeningToThePublic",
    "commentsRelatedToOpeningToThePublic"
})
public class CreateFileRequest
    implements Equals, HashCode, ToString
{

    protected String headingId;
    protected String parentFileId;
    protected String englishName;
    protected String frenchName;
    protected String germanName;
    protected String englishComments;
    protected String frenchComments;
    protected String germanComments;
    protected Boolean specialFile;
    protected String custodian;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar userFirstUseDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar userClosureDate;
    protected Boolean financialDocuments;
    protected String otherDigitalRepositories;
    protected Boolean otherStorageTypes;
    protected String shelf;
    protected String cupboard;
    protected String office;
    protected String locationComments;
    protected String specificCode;
    @XmlElement(required = true)
    protected String chefDeFile;
    protected AssociatedLeadDepartments associatedLeadDepartments;
    protected String deskOfficer;
    protected CreateFileRequest.Readers readers;
    protected CreateFileRequest.Users users;
    @XmlElement(required = true)
    protected CreateFileRequest.Editors editors;
    @XmlElement(defaultValue = "false")
    protected boolean activate;
    protected String categoryKey;
    protected FileSensitivePersonalData sensitivePersonalData;
    protected List<FileExceptionForOpeningToThePublic> exceptionForOpeningToThePublic;
    protected String commentsRelatedToOpeningToThePublic;

    /**
     * Gets the value of the headingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadingId() {
        return headingId;
    }

    /**
     * Sets the value of the headingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadingId(String value) {
        this.headingId = value;
    }

    /**
     * Gets the value of the parentFileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentFileId() {
        return parentFileId;
    }

    /**
     * Sets the value of the parentFileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentFileId(String value) {
        this.parentFileId = value;
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

    /**
     * Gets the value of the custodian property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustodian() {
        return custodian;
    }

    /**
     * Sets the value of the custodian property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustodian(String value) {
        this.custodian = value;
    }

    /**
     * Gets the value of the userFirstUseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUserFirstUseDate() {
        return userFirstUseDate;
    }

    /**
     * Sets the value of the userFirstUseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUserFirstUseDate(XMLGregorianCalendar value) {
        this.userFirstUseDate = value;
    }

    /**
     * Gets the value of the userClosureDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUserClosureDate() {
        return userClosureDate;
    }

    /**
     * Sets the value of the userClosureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUserClosureDate(XMLGregorianCalendar value) {
        this.userClosureDate = value;
    }

    /**
     * Gets the value of the financialDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFinancialDocuments() {
        return financialDocuments;
    }

    /**
     * Sets the value of the financialDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFinancialDocuments(Boolean value) {
        this.financialDocuments = value;
    }

    /**
     * Gets the value of the otherDigitalRepositories property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherDigitalRepositories() {
        return otherDigitalRepositories;
    }

    /**
     * Sets the value of the otherDigitalRepositories property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherDigitalRepositories(String value) {
        this.otherDigitalRepositories = value;
    }

    /**
     * Gets the value of the otherStorageTypes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOtherStorageTypes() {
        return otherStorageTypes;
    }

    /**
     * Sets the value of the otherStorageTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOtherStorageTypes(Boolean value) {
        this.otherStorageTypes = value;
    }

    /**
     * Gets the value of the shelf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShelf() {
        return shelf;
    }

    /**
     * Sets the value of the shelf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShelf(String value) {
        this.shelf = value;
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
     * Gets the value of the locationComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationComments() {
        return locationComments;
    }

    /**
     * Sets the value of the locationComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationComments(String value) {
        this.locationComments = value;
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
     * Gets the value of the readers property.
     * 
     * @return
     *     possible object is
     *     {@link CreateFileRequest.Readers }
     *     
     */
    public CreateFileRequest.Readers getReaders() {
        return readers;
    }

    /**
     * Sets the value of the readers property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateFileRequest.Readers }
     *     
     */
    public void setReaders(CreateFileRequest.Readers value) {
        this.readers = value;
    }

    /**
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link CreateFileRequest.Users }
     *     
     */
    public CreateFileRequest.Users getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateFileRequest.Users }
     *     
     */
    public void setUsers(CreateFileRequest.Users value) {
        this.users = value;
    }

    /**
     * Gets the value of the editors property.
     * 
     * @return
     *     possible object is
     *     {@link CreateFileRequest.Editors }
     *     
     */
    public CreateFileRequest.Editors getEditors() {
        return editors;
    }

    /**
     * Sets the value of the editors property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateFileRequest.Editors }
     *     
     */
    public void setEditors(CreateFileRequest.Editors value) {
        this.editors = value;
    }

    /**
     * Gets the value of the activate property.
     * 
     */
    public boolean isActivate() {
        return activate;
    }

    /**
     * Sets the value of the activate property.
     * 
     */
    public void setActivate(boolean value) {
        this.activate = value;
    }

    /**
     * Gets the value of the categoryKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryKey() {
        return categoryKey;
    }

    /**
     * Sets the value of the categoryKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryKey(String value) {
        this.categoryKey = value;
    }

    /**
     * Gets the value of the sensitivePersonalData property.
     * 
     * @return
     *     possible object is
     *     {@link FileSensitivePersonalData }
     *     
     */
    public FileSensitivePersonalData getSensitivePersonalData() {
        return sensitivePersonalData;
    }

    /**
     * Sets the value of the sensitivePersonalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileSensitivePersonalData }
     *     
     */
    public void setSensitivePersonalData(FileSensitivePersonalData value) {
        this.sensitivePersonalData = value;
    }

    /**
     * Gets the value of the exceptionForOpeningToThePublic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exceptionForOpeningToThePublic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExceptionForOpeningToThePublic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileExceptionForOpeningToThePublic }
     * 
     * 
     */
    public List<FileExceptionForOpeningToThePublic> getExceptionForOpeningToThePublic() {
        if (exceptionForOpeningToThePublic == null) {
            exceptionForOpeningToThePublic = new ArrayList<FileExceptionForOpeningToThePublic>();
        }
        return this.exceptionForOpeningToThePublic;
    }

    /**
     * Gets the value of the commentsRelatedToOpeningToThePublic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentsRelatedToOpeningToThePublic() {
        return commentsRelatedToOpeningToThePublic;
    }

    /**
     * Sets the value of the commentsRelatedToOpeningToThePublic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentsRelatedToOpeningToThePublic(String value) {
        this.commentsRelatedToOpeningToThePublic = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CreateFileRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CreateFileRequest that = ((CreateFileRequest) object);
        {
            String lhsHeadingId;
            lhsHeadingId = this.getHeadingId();
            String rhsHeadingId;
            rhsHeadingId = that.getHeadingId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "headingId", lhsHeadingId), LocatorUtils.property(thatLocator, "headingId", rhsHeadingId), lhsHeadingId, rhsHeadingId)) {
                return false;
            }
        }
        {
            String lhsParentFileId;
            lhsParentFileId = this.getParentFileId();
            String rhsParentFileId;
            rhsParentFileId = that.getParentFileId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "parentFileId", lhsParentFileId), LocatorUtils.property(thatLocator, "parentFileId", rhsParentFileId), lhsParentFileId, rhsParentFileId)) {
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
            Boolean lhsSpecialFile;
            lhsSpecialFile = this.isSpecialFile();
            Boolean rhsSpecialFile;
            rhsSpecialFile = that.isSpecialFile();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "specialFile", lhsSpecialFile), LocatorUtils.property(thatLocator, "specialFile", rhsSpecialFile), lhsSpecialFile, rhsSpecialFile)) {
                return false;
            }
        }
        {
            String lhsCustodian;
            lhsCustodian = this.getCustodian();
            String rhsCustodian;
            rhsCustodian = that.getCustodian();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "custodian", lhsCustodian), LocatorUtils.property(thatLocator, "custodian", rhsCustodian), lhsCustodian, rhsCustodian)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsUserFirstUseDate;
            lhsUserFirstUseDate = this.getUserFirstUseDate();
            XMLGregorianCalendar rhsUserFirstUseDate;
            rhsUserFirstUseDate = that.getUserFirstUseDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userFirstUseDate", lhsUserFirstUseDate), LocatorUtils.property(thatLocator, "userFirstUseDate", rhsUserFirstUseDate), lhsUserFirstUseDate, rhsUserFirstUseDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsUserClosureDate;
            lhsUserClosureDate = this.getUserClosureDate();
            XMLGregorianCalendar rhsUserClosureDate;
            rhsUserClosureDate = that.getUserClosureDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userClosureDate", lhsUserClosureDate), LocatorUtils.property(thatLocator, "userClosureDate", rhsUserClosureDate), lhsUserClosureDate, rhsUserClosureDate)) {
                return false;
            }
        }
        {
            Boolean lhsFinancialDocuments;
            lhsFinancialDocuments = this.isFinancialDocuments();
            Boolean rhsFinancialDocuments;
            rhsFinancialDocuments = that.isFinancialDocuments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "financialDocuments", lhsFinancialDocuments), LocatorUtils.property(thatLocator, "financialDocuments", rhsFinancialDocuments), lhsFinancialDocuments, rhsFinancialDocuments)) {
                return false;
            }
        }
        {
            String lhsOtherDigitalRepositories;
            lhsOtherDigitalRepositories = this.getOtherDigitalRepositories();
            String rhsOtherDigitalRepositories;
            rhsOtherDigitalRepositories = that.getOtherDigitalRepositories();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "otherDigitalRepositories", lhsOtherDigitalRepositories), LocatorUtils.property(thatLocator, "otherDigitalRepositories", rhsOtherDigitalRepositories), lhsOtherDigitalRepositories, rhsOtherDigitalRepositories)) {
                return false;
            }
        }
        {
            Boolean lhsOtherStorageTypes;
            lhsOtherStorageTypes = this.isOtherStorageTypes();
            Boolean rhsOtherStorageTypes;
            rhsOtherStorageTypes = that.isOtherStorageTypes();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "otherStorageTypes", lhsOtherStorageTypes), LocatorUtils.property(thatLocator, "otherStorageTypes", rhsOtherStorageTypes), lhsOtherStorageTypes, rhsOtherStorageTypes)) {
                return false;
            }
        }
        {
            String lhsShelf;
            lhsShelf = this.getShelf();
            String rhsShelf;
            rhsShelf = that.getShelf();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "shelf", lhsShelf), LocatorUtils.property(thatLocator, "shelf", rhsShelf), lhsShelf, rhsShelf)) {
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
            String lhsLocationComments;
            lhsLocationComments = this.getLocationComments();
            String rhsLocationComments;
            rhsLocationComments = that.getLocationComments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "locationComments", lhsLocationComments), LocatorUtils.property(thatLocator, "locationComments", rhsLocationComments), lhsLocationComments, rhsLocationComments)) {
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
            String lhsDeskOfficer;
            lhsDeskOfficer = this.getDeskOfficer();
            String rhsDeskOfficer;
            rhsDeskOfficer = that.getDeskOfficer();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deskOfficer", lhsDeskOfficer), LocatorUtils.property(thatLocator, "deskOfficer", rhsDeskOfficer), lhsDeskOfficer, rhsDeskOfficer)) {
                return false;
            }
        }
        {
            CreateFileRequest.Readers lhsReaders;
            lhsReaders = this.getReaders();
            CreateFileRequest.Readers rhsReaders;
            rhsReaders = that.getReaders();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "readers", lhsReaders), LocatorUtils.property(thatLocator, "readers", rhsReaders), lhsReaders, rhsReaders)) {
                return false;
            }
        }
        {
            CreateFileRequest.Users lhsUsers;
            lhsUsers = this.getUsers();
            CreateFileRequest.Users rhsUsers;
            rhsUsers = that.getUsers();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "users", lhsUsers), LocatorUtils.property(thatLocator, "users", rhsUsers), lhsUsers, rhsUsers)) {
                return false;
            }
        }
        {
            CreateFileRequest.Editors lhsEditors;
            lhsEditors = this.getEditors();
            CreateFileRequest.Editors rhsEditors;
            rhsEditors = that.getEditors();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "editors", lhsEditors), LocatorUtils.property(thatLocator, "editors", rhsEditors), lhsEditors, rhsEditors)) {
                return false;
            }
        }
        {
            boolean lhsActivate;
            lhsActivate = (true?this.isActivate():false);
            boolean rhsActivate;
            rhsActivate = (true?that.isActivate():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "activate", lhsActivate), LocatorUtils.property(thatLocator, "activate", rhsActivate), lhsActivate, rhsActivate)) {
                return false;
            }
        }
        {
            String lhsCategoryKey;
            lhsCategoryKey = this.getCategoryKey();
            String rhsCategoryKey;
            rhsCategoryKey = that.getCategoryKey();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "categoryKey", lhsCategoryKey), LocatorUtils.property(thatLocator, "categoryKey", rhsCategoryKey), lhsCategoryKey, rhsCategoryKey)) {
                return false;
            }
        }
        {
            FileSensitivePersonalData lhsSensitivePersonalData;
            lhsSensitivePersonalData = this.getSensitivePersonalData();
            FileSensitivePersonalData rhsSensitivePersonalData;
            rhsSensitivePersonalData = that.getSensitivePersonalData();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sensitivePersonalData", lhsSensitivePersonalData), LocatorUtils.property(thatLocator, "sensitivePersonalData", rhsSensitivePersonalData), lhsSensitivePersonalData, rhsSensitivePersonalData)) {
                return false;
            }
        }
        {
            List<FileExceptionForOpeningToThePublic> lhsExceptionForOpeningToThePublic;
            lhsExceptionForOpeningToThePublic = (((this.exceptionForOpeningToThePublic!= null)&&(!this.exceptionForOpeningToThePublic.isEmpty()))?this.getExceptionForOpeningToThePublic():null);
            List<FileExceptionForOpeningToThePublic> rhsExceptionForOpeningToThePublic;
            rhsExceptionForOpeningToThePublic = (((that.exceptionForOpeningToThePublic!= null)&&(!that.exceptionForOpeningToThePublic.isEmpty()))?that.getExceptionForOpeningToThePublic():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "exceptionForOpeningToThePublic", lhsExceptionForOpeningToThePublic), LocatorUtils.property(thatLocator, "exceptionForOpeningToThePublic", rhsExceptionForOpeningToThePublic), lhsExceptionForOpeningToThePublic, rhsExceptionForOpeningToThePublic)) {
                return false;
            }
        }
        {
            String lhsCommentsRelatedToOpeningToThePublic;
            lhsCommentsRelatedToOpeningToThePublic = this.getCommentsRelatedToOpeningToThePublic();
            String rhsCommentsRelatedToOpeningToThePublic;
            rhsCommentsRelatedToOpeningToThePublic = that.getCommentsRelatedToOpeningToThePublic();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "commentsRelatedToOpeningToThePublic", lhsCommentsRelatedToOpeningToThePublic), LocatorUtils.property(thatLocator, "commentsRelatedToOpeningToThePublic", rhsCommentsRelatedToOpeningToThePublic), lhsCommentsRelatedToOpeningToThePublic, rhsCommentsRelatedToOpeningToThePublic)) {
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
            String theHeadingId;
            theHeadingId = this.getHeadingId();
            strategy.appendField(locator, this, "headingId", buffer, theHeadingId);
        }
        {
            String theParentFileId;
            theParentFileId = this.getParentFileId();
            strategy.appendField(locator, this, "parentFileId", buffer, theParentFileId);
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
            Boolean theSpecialFile;
            theSpecialFile = this.isSpecialFile();
            strategy.appendField(locator, this, "specialFile", buffer, theSpecialFile);
        }
        {
            String theCustodian;
            theCustodian = this.getCustodian();
            strategy.appendField(locator, this, "custodian", buffer, theCustodian);
        }
        {
            XMLGregorianCalendar theUserFirstUseDate;
            theUserFirstUseDate = this.getUserFirstUseDate();
            strategy.appendField(locator, this, "userFirstUseDate", buffer, theUserFirstUseDate);
        }
        {
            XMLGregorianCalendar theUserClosureDate;
            theUserClosureDate = this.getUserClosureDate();
            strategy.appendField(locator, this, "userClosureDate", buffer, theUserClosureDate);
        }
        {
            Boolean theFinancialDocuments;
            theFinancialDocuments = this.isFinancialDocuments();
            strategy.appendField(locator, this, "financialDocuments", buffer, theFinancialDocuments);
        }
        {
            String theOtherDigitalRepositories;
            theOtherDigitalRepositories = this.getOtherDigitalRepositories();
            strategy.appendField(locator, this, "otherDigitalRepositories", buffer, theOtherDigitalRepositories);
        }
        {
            Boolean theOtherStorageTypes;
            theOtherStorageTypes = this.isOtherStorageTypes();
            strategy.appendField(locator, this, "otherStorageTypes", buffer, theOtherStorageTypes);
        }
        {
            String theShelf;
            theShelf = this.getShelf();
            strategy.appendField(locator, this, "shelf", buffer, theShelf);
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
            String theLocationComments;
            theLocationComments = this.getLocationComments();
            strategy.appendField(locator, this, "locationComments", buffer, theLocationComments);
        }
        {
            String theSpecificCode;
            theSpecificCode = this.getSpecificCode();
            strategy.appendField(locator, this, "specificCode", buffer, theSpecificCode);
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
            String theDeskOfficer;
            theDeskOfficer = this.getDeskOfficer();
            strategy.appendField(locator, this, "deskOfficer", buffer, theDeskOfficer);
        }
        {
            CreateFileRequest.Readers theReaders;
            theReaders = this.getReaders();
            strategy.appendField(locator, this, "readers", buffer, theReaders);
        }
        {
            CreateFileRequest.Users theUsers;
            theUsers = this.getUsers();
            strategy.appendField(locator, this, "users", buffer, theUsers);
        }
        {
            CreateFileRequest.Editors theEditors;
            theEditors = this.getEditors();
            strategy.appendField(locator, this, "editors", buffer, theEditors);
        }
        {
            boolean theActivate;
            theActivate = (true?this.isActivate():false);
            strategy.appendField(locator, this, "activate", buffer, theActivate);
        }
        {
            String theCategoryKey;
            theCategoryKey = this.getCategoryKey();
            strategy.appendField(locator, this, "categoryKey", buffer, theCategoryKey);
        }
        {
            FileSensitivePersonalData theSensitivePersonalData;
            theSensitivePersonalData = this.getSensitivePersonalData();
            strategy.appendField(locator, this, "sensitivePersonalData", buffer, theSensitivePersonalData);
        }
        {
            List<FileExceptionForOpeningToThePublic> theExceptionForOpeningToThePublic;
            theExceptionForOpeningToThePublic = (((this.exceptionForOpeningToThePublic!= null)&&(!this.exceptionForOpeningToThePublic.isEmpty()))?this.getExceptionForOpeningToThePublic():null);
            strategy.appendField(locator, this, "exceptionForOpeningToThePublic", buffer, theExceptionForOpeningToThePublic);
        }
        {
            String theCommentsRelatedToOpeningToThePublic;
            theCommentsRelatedToOpeningToThePublic = this.getCommentsRelatedToOpeningToThePublic();
            strategy.appendField(locator, this, "commentsRelatedToOpeningToThePublic", buffer, theCommentsRelatedToOpeningToThePublic);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theHeadingId;
            theHeadingId = this.getHeadingId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "headingId", theHeadingId), currentHashCode, theHeadingId);
        }
        {
            String theParentFileId;
            theParentFileId = this.getParentFileId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "parentFileId", theParentFileId), currentHashCode, theParentFileId);
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
            Boolean theSpecialFile;
            theSpecialFile = this.isSpecialFile();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specialFile", theSpecialFile), currentHashCode, theSpecialFile);
        }
        {
            String theCustodian;
            theCustodian = this.getCustodian();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "custodian", theCustodian), currentHashCode, theCustodian);
        }
        {
            XMLGregorianCalendar theUserFirstUseDate;
            theUserFirstUseDate = this.getUserFirstUseDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userFirstUseDate", theUserFirstUseDate), currentHashCode, theUserFirstUseDate);
        }
        {
            XMLGregorianCalendar theUserClosureDate;
            theUserClosureDate = this.getUserClosureDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userClosureDate", theUserClosureDate), currentHashCode, theUserClosureDate);
        }
        {
            Boolean theFinancialDocuments;
            theFinancialDocuments = this.isFinancialDocuments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "financialDocuments", theFinancialDocuments), currentHashCode, theFinancialDocuments);
        }
        {
            String theOtherDigitalRepositories;
            theOtherDigitalRepositories = this.getOtherDigitalRepositories();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otherDigitalRepositories", theOtherDigitalRepositories), currentHashCode, theOtherDigitalRepositories);
        }
        {
            Boolean theOtherStorageTypes;
            theOtherStorageTypes = this.isOtherStorageTypes();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otherStorageTypes", theOtherStorageTypes), currentHashCode, theOtherStorageTypes);
        }
        {
            String theShelf;
            theShelf = this.getShelf();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "shelf", theShelf), currentHashCode, theShelf);
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
            String theLocationComments;
            theLocationComments = this.getLocationComments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "locationComments", theLocationComments), currentHashCode, theLocationComments);
        }
        {
            String theSpecificCode;
            theSpecificCode = this.getSpecificCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specificCode", theSpecificCode), currentHashCode, theSpecificCode);
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
            String theDeskOfficer;
            theDeskOfficer = this.getDeskOfficer();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deskOfficer", theDeskOfficer), currentHashCode, theDeskOfficer);
        }
        {
            CreateFileRequest.Readers theReaders;
            theReaders = this.getReaders();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "readers", theReaders), currentHashCode, theReaders);
        }
        {
            CreateFileRequest.Users theUsers;
            theUsers = this.getUsers();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "users", theUsers), currentHashCode, theUsers);
        }
        {
            CreateFileRequest.Editors theEditors;
            theEditors = this.getEditors();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "editors", theEditors), currentHashCode, theEditors);
        }
        {
            boolean theActivate;
            theActivate = (true?this.isActivate():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "activate", theActivate), currentHashCode, theActivate);
        }
        {
            String theCategoryKey;
            theCategoryKey = this.getCategoryKey();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "categoryKey", theCategoryKey), currentHashCode, theCategoryKey);
        }
        {
            FileSensitivePersonalData theSensitivePersonalData;
            theSensitivePersonalData = this.getSensitivePersonalData();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sensitivePersonalData", theSensitivePersonalData), currentHashCode, theSensitivePersonalData);
        }
        {
            List<FileExceptionForOpeningToThePublic> theExceptionForOpeningToThePublic;
            theExceptionForOpeningToThePublic = (((this.exceptionForOpeningToThePublic!= null)&&(!this.exceptionForOpeningToThePublic.isEmpty()))?this.getExceptionForOpeningToThePublic():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exceptionForOpeningToThePublic", theExceptionForOpeningToThePublic), currentHashCode, theExceptionForOpeningToThePublic);
        }
        {
            String theCommentsRelatedToOpeningToThePublic;
            theCommentsRelatedToOpeningToThePublic = this.getCommentsRelatedToOpeningToThePublic();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "commentsRelatedToOpeningToThePublic", theCommentsRelatedToOpeningToThePublic), currentHashCode, theCommentsRelatedToOpeningToThePublic);
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
     *         &lt;element name="editor" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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

        @XmlElement(required = true)
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
            if (!(object instanceof CreateFileRequest.Editors)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final CreateFileRequest.Editors that = ((CreateFileRequest.Editors) object);
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
            if (!(object instanceof CreateFileRequest.Readers)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final CreateFileRequest.Readers that = ((CreateFileRequest.Readers) object);
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
            if (!(object instanceof CreateFileRequest.Users)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final CreateFileRequest.Users that = ((CreateFileRequest.Users) object);
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
