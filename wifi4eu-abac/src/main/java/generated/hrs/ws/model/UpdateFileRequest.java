
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
 * Request for updating an existing file
 * 
 * <p>Java class for UpdateFileRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFileRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="englishName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="germanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="germanComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="chefDeFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updateAssociatedLeadDepartments" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="remove" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="add" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="deskOfficer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updateReaders" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="remove" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="add" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="updateUsers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="remove" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="add" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="updateEditors" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="remove" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="add" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="categoryKey" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" minOccurs="0"/>
 *         &lt;element name="sensitivePersonalData" type="{http://ec.europa.eu/sg/hrs/types}FileSensitivePersonalData" minOccurs="0"/>
 *         &lt;element name="updateExceptionForOpeningToThePublic" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="remove" type="{http://ec.europa.eu/sg/hrs/types}FileExceptionForOpeningToThePublic" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}FileExceptionForOpeningToThePublic" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlType(name = "UpdateFileRequest", propOrder = {
    "fileId",
    "englishName",
    "frenchName",
    "germanName",
    "englishComments",
    "frenchComments",
    "germanComments",
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
    "updateAssociatedLeadDepartments",
    "deskOfficer",
    "updateReaders",
    "updateUsers",
    "updateEditors",
    "categoryKey",
    "sensitivePersonalData",
    "updateExceptionForOpeningToThePublic",
    "commentsRelatedToOpeningToThePublic"
})
public class UpdateFileRequest
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String fileId;
    protected String englishName;
    protected String frenchName;
    protected String germanName;
    protected String englishComments;
    protected String frenchComments;
    protected String germanComments;
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
    protected String chefDeFile;
    protected UpdateFileRequest.UpdateAssociatedLeadDepartments updateAssociatedLeadDepartments;
    protected String deskOfficer;
    protected UpdateFileRequest.UpdateReaders updateReaders;
    protected UpdateFileRequest.UpdateUsers updateUsers;
    protected UpdateFileRequest.UpdateEditors updateEditors;
    protected String categoryKey;
    protected FileSensitivePersonalData sensitivePersonalData;
    protected UpdateFileRequest.UpdateExceptionForOpeningToThePublic updateExceptionForOpeningToThePublic;
    protected String commentsRelatedToOpeningToThePublic;

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
     * Gets the value of the updateAssociatedLeadDepartments property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFileRequest.UpdateAssociatedLeadDepartments }
     *     
     */
    public UpdateFileRequest.UpdateAssociatedLeadDepartments getUpdateAssociatedLeadDepartments() {
        return updateAssociatedLeadDepartments;
    }

    /**
     * Sets the value of the updateAssociatedLeadDepartments property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFileRequest.UpdateAssociatedLeadDepartments }
     *     
     */
    public void setUpdateAssociatedLeadDepartments(UpdateFileRequest.UpdateAssociatedLeadDepartments value) {
        this.updateAssociatedLeadDepartments = value;
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
     * Gets the value of the updateReaders property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFileRequest.UpdateReaders }
     *     
     */
    public UpdateFileRequest.UpdateReaders getUpdateReaders() {
        return updateReaders;
    }

    /**
     * Sets the value of the updateReaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFileRequest.UpdateReaders }
     *     
     */
    public void setUpdateReaders(UpdateFileRequest.UpdateReaders value) {
        this.updateReaders = value;
    }

    /**
     * Gets the value of the updateUsers property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFileRequest.UpdateUsers }
     *     
     */
    public UpdateFileRequest.UpdateUsers getUpdateUsers() {
        return updateUsers;
    }

    /**
     * Sets the value of the updateUsers property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFileRequest.UpdateUsers }
     *     
     */
    public void setUpdateUsers(UpdateFileRequest.UpdateUsers value) {
        this.updateUsers = value;
    }

    /**
     * Gets the value of the updateEditors property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFileRequest.UpdateEditors }
     *     
     */
    public UpdateFileRequest.UpdateEditors getUpdateEditors() {
        return updateEditors;
    }

    /**
     * Sets the value of the updateEditors property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFileRequest.UpdateEditors }
     *     
     */
    public void setUpdateEditors(UpdateFileRequest.UpdateEditors value) {
        this.updateEditors = value;
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
     * Gets the value of the updateExceptionForOpeningToThePublic property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFileRequest.UpdateExceptionForOpeningToThePublic }
     *     
     */
    public UpdateFileRequest.UpdateExceptionForOpeningToThePublic getUpdateExceptionForOpeningToThePublic() {
        return updateExceptionForOpeningToThePublic;
    }

    /**
     * Sets the value of the updateExceptionForOpeningToThePublic property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFileRequest.UpdateExceptionForOpeningToThePublic }
     *     
     */
    public void setUpdateExceptionForOpeningToThePublic(UpdateFileRequest.UpdateExceptionForOpeningToThePublic value) {
        this.updateExceptionForOpeningToThePublic = value;
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
        if (!(object instanceof UpdateFileRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UpdateFileRequest that = ((UpdateFileRequest) object);
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
            UpdateFileRequest.UpdateAssociatedLeadDepartments lhsUpdateAssociatedLeadDepartments;
            lhsUpdateAssociatedLeadDepartments = this.getUpdateAssociatedLeadDepartments();
            UpdateFileRequest.UpdateAssociatedLeadDepartments rhsUpdateAssociatedLeadDepartments;
            rhsUpdateAssociatedLeadDepartments = that.getUpdateAssociatedLeadDepartments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateAssociatedLeadDepartments", lhsUpdateAssociatedLeadDepartments), LocatorUtils.property(thatLocator, "updateAssociatedLeadDepartments", rhsUpdateAssociatedLeadDepartments), lhsUpdateAssociatedLeadDepartments, rhsUpdateAssociatedLeadDepartments)) {
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
            UpdateFileRequest.UpdateReaders lhsUpdateReaders;
            lhsUpdateReaders = this.getUpdateReaders();
            UpdateFileRequest.UpdateReaders rhsUpdateReaders;
            rhsUpdateReaders = that.getUpdateReaders();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateReaders", lhsUpdateReaders), LocatorUtils.property(thatLocator, "updateReaders", rhsUpdateReaders), lhsUpdateReaders, rhsUpdateReaders)) {
                return false;
            }
        }
        {
            UpdateFileRequest.UpdateUsers lhsUpdateUsers;
            lhsUpdateUsers = this.getUpdateUsers();
            UpdateFileRequest.UpdateUsers rhsUpdateUsers;
            rhsUpdateUsers = that.getUpdateUsers();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateUsers", lhsUpdateUsers), LocatorUtils.property(thatLocator, "updateUsers", rhsUpdateUsers), lhsUpdateUsers, rhsUpdateUsers)) {
                return false;
            }
        }
        {
            UpdateFileRequest.UpdateEditors lhsUpdateEditors;
            lhsUpdateEditors = this.getUpdateEditors();
            UpdateFileRequest.UpdateEditors rhsUpdateEditors;
            rhsUpdateEditors = that.getUpdateEditors();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateEditors", lhsUpdateEditors), LocatorUtils.property(thatLocator, "updateEditors", rhsUpdateEditors), lhsUpdateEditors, rhsUpdateEditors)) {
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
            UpdateFileRequest.UpdateExceptionForOpeningToThePublic lhsUpdateExceptionForOpeningToThePublic;
            lhsUpdateExceptionForOpeningToThePublic = this.getUpdateExceptionForOpeningToThePublic();
            UpdateFileRequest.UpdateExceptionForOpeningToThePublic rhsUpdateExceptionForOpeningToThePublic;
            rhsUpdateExceptionForOpeningToThePublic = that.getUpdateExceptionForOpeningToThePublic();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "updateExceptionForOpeningToThePublic", lhsUpdateExceptionForOpeningToThePublic), LocatorUtils.property(thatLocator, "updateExceptionForOpeningToThePublic", rhsUpdateExceptionForOpeningToThePublic), lhsUpdateExceptionForOpeningToThePublic, rhsUpdateExceptionForOpeningToThePublic)) {
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
            String theFileId;
            theFileId = this.getFileId();
            strategy.appendField(locator, this, "fileId", buffer, theFileId);
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
            UpdateFileRequest.UpdateAssociatedLeadDepartments theUpdateAssociatedLeadDepartments;
            theUpdateAssociatedLeadDepartments = this.getUpdateAssociatedLeadDepartments();
            strategy.appendField(locator, this, "updateAssociatedLeadDepartments", buffer, theUpdateAssociatedLeadDepartments);
        }
        {
            String theDeskOfficer;
            theDeskOfficer = this.getDeskOfficer();
            strategy.appendField(locator, this, "deskOfficer", buffer, theDeskOfficer);
        }
        {
            UpdateFileRequest.UpdateReaders theUpdateReaders;
            theUpdateReaders = this.getUpdateReaders();
            strategy.appendField(locator, this, "updateReaders", buffer, theUpdateReaders);
        }
        {
            UpdateFileRequest.UpdateUsers theUpdateUsers;
            theUpdateUsers = this.getUpdateUsers();
            strategy.appendField(locator, this, "updateUsers", buffer, theUpdateUsers);
        }
        {
            UpdateFileRequest.UpdateEditors theUpdateEditors;
            theUpdateEditors = this.getUpdateEditors();
            strategy.appendField(locator, this, "updateEditors", buffer, theUpdateEditors);
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
            UpdateFileRequest.UpdateExceptionForOpeningToThePublic theUpdateExceptionForOpeningToThePublic;
            theUpdateExceptionForOpeningToThePublic = this.getUpdateExceptionForOpeningToThePublic();
            strategy.appendField(locator, this, "updateExceptionForOpeningToThePublic", buffer, theUpdateExceptionForOpeningToThePublic);
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
            String theFileId;
            theFileId = this.getFileId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileId", theFileId), currentHashCode, theFileId);
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
            UpdateFileRequest.UpdateAssociatedLeadDepartments theUpdateAssociatedLeadDepartments;
            theUpdateAssociatedLeadDepartments = this.getUpdateAssociatedLeadDepartments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateAssociatedLeadDepartments", theUpdateAssociatedLeadDepartments), currentHashCode, theUpdateAssociatedLeadDepartments);
        }
        {
            String theDeskOfficer;
            theDeskOfficer = this.getDeskOfficer();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deskOfficer", theDeskOfficer), currentHashCode, theDeskOfficer);
        }
        {
            UpdateFileRequest.UpdateReaders theUpdateReaders;
            theUpdateReaders = this.getUpdateReaders();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateReaders", theUpdateReaders), currentHashCode, theUpdateReaders);
        }
        {
            UpdateFileRequest.UpdateUsers theUpdateUsers;
            theUpdateUsers = this.getUpdateUsers();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateUsers", theUpdateUsers), currentHashCode, theUpdateUsers);
        }
        {
            UpdateFileRequest.UpdateEditors theUpdateEditors;
            theUpdateEditors = this.getUpdateEditors();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateEditors", theUpdateEditors), currentHashCode, theUpdateEditors);
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
            UpdateFileRequest.UpdateExceptionForOpeningToThePublic theUpdateExceptionForOpeningToThePublic;
            theUpdateExceptionForOpeningToThePublic = this.getUpdateExceptionForOpeningToThePublic();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "updateExceptionForOpeningToThePublic", theUpdateExceptionForOpeningToThePublic), currentHashCode, theUpdateExceptionForOpeningToThePublic);
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
     *         &lt;element name="remove" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="add" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    public static class UpdateAssociatedLeadDepartments
        implements Equals, HashCode, ToString
    {

        protected List<String> remove;
        protected List<String> add;

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
         * {@link String }
         * 
         * 
         */
        public List<String> getAdd() {
            if (add == null) {
                add = new ArrayList<String>();
            }
            return this.add;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof UpdateFileRequest.UpdateAssociatedLeadDepartments)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final UpdateFileRequest.UpdateAssociatedLeadDepartments that = ((UpdateFileRequest.UpdateAssociatedLeadDepartments) object);
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
                List<String> lhsAdd;
                lhsAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                List<String> rhsAdd;
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
                List<String> theAdd;
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
                List<String> theAdd;
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
     *         &lt;element name="remove" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="add" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    public static class UpdateEditors
        implements Equals, HashCode, ToString
    {

        protected List<String> remove;
        protected List<String> add;

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
         * {@link String }
         * 
         * 
         */
        public List<String> getAdd() {
            if (add == null) {
                add = new ArrayList<String>();
            }
            return this.add;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof UpdateFileRequest.UpdateEditors)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final UpdateFileRequest.UpdateEditors that = ((UpdateFileRequest.UpdateEditors) object);
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
                List<String> lhsAdd;
                lhsAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                List<String> rhsAdd;
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
                List<String> theAdd;
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
                List<String> theAdd;
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
     *         &lt;element name="remove" type="{http://ec.europa.eu/sg/hrs/types}FileExceptionForOpeningToThePublic" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="add" type="{http://ec.europa.eu/sg/hrs/types}FileExceptionForOpeningToThePublic" maxOccurs="unbounded" minOccurs="0"/>
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
    public static class UpdateExceptionForOpeningToThePublic
        implements Equals, HashCode, ToString
    {

        protected List<FileExceptionForOpeningToThePublic> remove;
        protected List<FileExceptionForOpeningToThePublic> add;

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
         * {@link FileExceptionForOpeningToThePublic }
         * 
         * 
         */
        public List<FileExceptionForOpeningToThePublic> getRemove() {
            if (remove == null) {
                remove = new ArrayList<FileExceptionForOpeningToThePublic>();
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
         * {@link FileExceptionForOpeningToThePublic }
         * 
         * 
         */
        public List<FileExceptionForOpeningToThePublic> getAdd() {
            if (add == null) {
                add = new ArrayList<FileExceptionForOpeningToThePublic>();
            }
            return this.add;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof UpdateFileRequest.UpdateExceptionForOpeningToThePublic)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final UpdateFileRequest.UpdateExceptionForOpeningToThePublic that = ((UpdateFileRequest.UpdateExceptionForOpeningToThePublic) object);
            {
                List<FileExceptionForOpeningToThePublic> lhsRemove;
                lhsRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                List<FileExceptionForOpeningToThePublic> rhsRemove;
                rhsRemove = (((that.remove!= null)&&(!that.remove.isEmpty()))?that.getRemove():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "remove", lhsRemove), LocatorUtils.property(thatLocator, "remove", rhsRemove), lhsRemove, rhsRemove)) {
                    return false;
                }
            }
            {
                List<FileExceptionForOpeningToThePublic> lhsAdd;
                lhsAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                List<FileExceptionForOpeningToThePublic> rhsAdd;
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
                List<FileExceptionForOpeningToThePublic> theRemove;
                theRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                strategy.appendField(locator, this, "remove", buffer, theRemove);
            }
            {
                List<FileExceptionForOpeningToThePublic> theAdd;
                theAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                strategy.appendField(locator, this, "add", buffer, theAdd);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<FileExceptionForOpeningToThePublic> theRemove;
                theRemove = (((this.remove!= null)&&(!this.remove.isEmpty()))?this.getRemove():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "remove", theRemove), currentHashCode, theRemove);
            }
            {
                List<FileExceptionForOpeningToThePublic> theAdd;
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
     *         &lt;element name="remove" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="add" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    public static class UpdateReaders
        implements Equals, HashCode, ToString
    {

        protected List<String> remove;
        protected List<String> add;

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
         * {@link String }
         * 
         * 
         */
        public List<String> getAdd() {
            if (add == null) {
                add = new ArrayList<String>();
            }
            return this.add;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof UpdateFileRequest.UpdateReaders)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final UpdateFileRequest.UpdateReaders that = ((UpdateFileRequest.UpdateReaders) object);
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
                List<String> lhsAdd;
                lhsAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                List<String> rhsAdd;
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
                List<String> theAdd;
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
                List<String> theAdd;
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
     *         &lt;element name="remove" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="add" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    public static class UpdateUsers
        implements Equals, HashCode, ToString
    {

        protected List<String> remove;
        protected List<String> add;

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
         * {@link String }
         * 
         * 
         */
        public List<String> getAdd() {
            if (add == null) {
                add = new ArrayList<String>();
            }
            return this.add;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof UpdateFileRequest.UpdateUsers)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final UpdateFileRequest.UpdateUsers that = ((UpdateFileRequest.UpdateUsers) object);
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
                List<String> lhsAdd;
                lhsAdd = (((this.add!= null)&&(!this.add.isEmpty()))?this.getAdd():null);
                List<String> rhsAdd;
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
                List<String> theAdd;
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
                List<String> theAdd;
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
