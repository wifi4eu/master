
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * The preervation metadata of a file
 * 
 * <p>Java class for FilePreservationMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilePreservationMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="custodian" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userDateOfFirstUse" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="dateOfFirstUse" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="userClosureDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="closureDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="endDateARP" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="postARPAction" type="{http://ec.europa.eu/sg/hrs/types}FilePostARPAction" minOccurs="0"/>
 *         &lt;element name="financialDocuments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="crlCategoryWithManualFollowUp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="crlCategoryWithAdminElimination" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="deadlineForAPED" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="hermesDigitalRepository" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="otherDigitalRepositories" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="otherStorageTypes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="physicalItems" type="{http://ec.europa.eu/sg/hrs/types}FilePhysicalItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shelf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cupboard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="office" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locationComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilePreservationMetadata", propOrder = {
    "custodian",
    "userDateOfFirstUse",
    "dateOfFirstUse",
    "userClosureDate",
    "closureDate",
    "endDateARP",
    "postARPAction",
    "financialDocuments",
    "crlCategoryWithManualFollowUp",
    "crlCategoryWithAdminElimination",
    "deadlineForAPED",
    "hermesDigitalRepository",
    "otherDigitalRepositories",
    "otherStorageTypes",
    "physicalItems",
    "shelf",
    "cupboard",
    "office",
    "locationComments"
})
public class FilePreservationMetadata
    implements Equals, HashCode, ToString
{

    protected String custodian;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar userDateOfFirstUse;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfFirstUse;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar userClosureDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar closureDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDateARP;
    protected FilePostARPAction postARPAction;
    protected Boolean financialDocuments;
    protected Boolean crlCategoryWithManualFollowUp;
    protected Boolean crlCategoryWithAdminElimination;
    protected Integer deadlineForAPED;
    protected Boolean hermesDigitalRepository;
    protected String otherDigitalRepositories;
    protected Boolean otherStorageTypes;
    protected List<FilePhysicalItem> physicalItems;
    protected String shelf;
    protected String cupboard;
    protected String office;
    protected String locationComments;

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
     * Gets the value of the userDateOfFirstUse property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUserDateOfFirstUse() {
        return userDateOfFirstUse;
    }

    /**
     * Sets the value of the userDateOfFirstUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUserDateOfFirstUse(XMLGregorianCalendar value) {
        this.userDateOfFirstUse = value;
    }

    /**
     * Gets the value of the dateOfFirstUse property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfFirstUse() {
        return dateOfFirstUse;
    }

    /**
     * Sets the value of the dateOfFirstUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfFirstUse(XMLGregorianCalendar value) {
        this.dateOfFirstUse = value;
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
     * Gets the value of the closureDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClosureDate() {
        return closureDate;
    }

    /**
     * Sets the value of the closureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClosureDate(XMLGregorianCalendar value) {
        this.closureDate = value;
    }

    /**
     * Gets the value of the endDateARP property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDateARP() {
        return endDateARP;
    }

    /**
     * Sets the value of the endDateARP property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDateARP(XMLGregorianCalendar value) {
        this.endDateARP = value;
    }

    /**
     * Gets the value of the postARPAction property.
     * 
     * @return
     *     possible object is
     *     {@link FilePostARPAction }
     *     
     */
    public FilePostARPAction getPostARPAction() {
        return postARPAction;
    }

    /**
     * Sets the value of the postARPAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilePostARPAction }
     *     
     */
    public void setPostARPAction(FilePostARPAction value) {
        this.postARPAction = value;
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
     * Gets the value of the crlCategoryWithManualFollowUp property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrlCategoryWithManualFollowUp() {
        return crlCategoryWithManualFollowUp;
    }

    /**
     * Sets the value of the crlCategoryWithManualFollowUp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrlCategoryWithManualFollowUp(Boolean value) {
        this.crlCategoryWithManualFollowUp = value;
    }

    /**
     * Gets the value of the crlCategoryWithAdminElimination property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrlCategoryWithAdminElimination() {
        return crlCategoryWithAdminElimination;
    }

    /**
     * Sets the value of the crlCategoryWithAdminElimination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrlCategoryWithAdminElimination(Boolean value) {
        this.crlCategoryWithAdminElimination = value;
    }

    /**
     * Gets the value of the deadlineForAPED property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeadlineForAPED() {
        return deadlineForAPED;
    }

    /**
     * Sets the value of the deadlineForAPED property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeadlineForAPED(Integer value) {
        this.deadlineForAPED = value;
    }

    /**
     * Gets the value of the hermesDigitalRepository property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHermesDigitalRepository() {
        return hermesDigitalRepository;
    }

    /**
     * Sets the value of the hermesDigitalRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHermesDigitalRepository(Boolean value) {
        this.hermesDigitalRepository = value;
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
     * Gets the value of the physicalItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physicalItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysicalItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilePhysicalItem }
     * 
     * 
     */
    public List<FilePhysicalItem> getPhysicalItems() {
        if (physicalItems == null) {
            physicalItems = new ArrayList<FilePhysicalItem>();
        }
        return this.physicalItems;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FilePreservationMetadata)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FilePreservationMetadata that = ((FilePreservationMetadata) object);
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
            XMLGregorianCalendar lhsUserDateOfFirstUse;
            lhsUserDateOfFirstUse = this.getUserDateOfFirstUse();
            XMLGregorianCalendar rhsUserDateOfFirstUse;
            rhsUserDateOfFirstUse = that.getUserDateOfFirstUse();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userDateOfFirstUse", lhsUserDateOfFirstUse), LocatorUtils.property(thatLocator, "userDateOfFirstUse", rhsUserDateOfFirstUse), lhsUserDateOfFirstUse, rhsUserDateOfFirstUse)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDateOfFirstUse;
            lhsDateOfFirstUse = this.getDateOfFirstUse();
            XMLGregorianCalendar rhsDateOfFirstUse;
            rhsDateOfFirstUse = that.getDateOfFirstUse();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateOfFirstUse", lhsDateOfFirstUse), LocatorUtils.property(thatLocator, "dateOfFirstUse", rhsDateOfFirstUse), lhsDateOfFirstUse, rhsDateOfFirstUse)) {
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
            XMLGregorianCalendar lhsClosureDate;
            lhsClosureDate = this.getClosureDate();
            XMLGregorianCalendar rhsClosureDate;
            rhsClosureDate = that.getClosureDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "closureDate", lhsClosureDate), LocatorUtils.property(thatLocator, "closureDate", rhsClosureDate), lhsClosureDate, rhsClosureDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsEndDateARP;
            lhsEndDateARP = this.getEndDateARP();
            XMLGregorianCalendar rhsEndDateARP;
            rhsEndDateARP = that.getEndDateARP();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "endDateARP", lhsEndDateARP), LocatorUtils.property(thatLocator, "endDateARP", rhsEndDateARP), lhsEndDateARP, rhsEndDateARP)) {
                return false;
            }
        }
        {
            FilePostARPAction lhsPostARPAction;
            lhsPostARPAction = this.getPostARPAction();
            FilePostARPAction rhsPostARPAction;
            rhsPostARPAction = that.getPostARPAction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "postARPAction", lhsPostARPAction), LocatorUtils.property(thatLocator, "postARPAction", rhsPostARPAction), lhsPostARPAction, rhsPostARPAction)) {
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
            Boolean lhsCrlCategoryWithManualFollowUp;
            lhsCrlCategoryWithManualFollowUp = this.isCrlCategoryWithManualFollowUp();
            Boolean rhsCrlCategoryWithManualFollowUp;
            rhsCrlCategoryWithManualFollowUp = that.isCrlCategoryWithManualFollowUp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "crlCategoryWithManualFollowUp", lhsCrlCategoryWithManualFollowUp), LocatorUtils.property(thatLocator, "crlCategoryWithManualFollowUp", rhsCrlCategoryWithManualFollowUp), lhsCrlCategoryWithManualFollowUp, rhsCrlCategoryWithManualFollowUp)) {
                return false;
            }
        }
        {
            Boolean lhsCrlCategoryWithAdminElimination;
            lhsCrlCategoryWithAdminElimination = this.isCrlCategoryWithAdminElimination();
            Boolean rhsCrlCategoryWithAdminElimination;
            rhsCrlCategoryWithAdminElimination = that.isCrlCategoryWithAdminElimination();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "crlCategoryWithAdminElimination", lhsCrlCategoryWithAdminElimination), LocatorUtils.property(thatLocator, "crlCategoryWithAdminElimination", rhsCrlCategoryWithAdminElimination), lhsCrlCategoryWithAdminElimination, rhsCrlCategoryWithAdminElimination)) {
                return false;
            }
        }
        {
            Integer lhsDeadlineForAPED;
            lhsDeadlineForAPED = this.getDeadlineForAPED();
            Integer rhsDeadlineForAPED;
            rhsDeadlineForAPED = that.getDeadlineForAPED();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deadlineForAPED", lhsDeadlineForAPED), LocatorUtils.property(thatLocator, "deadlineForAPED", rhsDeadlineForAPED), lhsDeadlineForAPED, rhsDeadlineForAPED)) {
                return false;
            }
        }
        {
            Boolean lhsHermesDigitalRepository;
            lhsHermesDigitalRepository = this.isHermesDigitalRepository();
            Boolean rhsHermesDigitalRepository;
            rhsHermesDigitalRepository = that.isHermesDigitalRepository();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "hermesDigitalRepository", lhsHermesDigitalRepository), LocatorUtils.property(thatLocator, "hermesDigitalRepository", rhsHermesDigitalRepository), lhsHermesDigitalRepository, rhsHermesDigitalRepository)) {
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
            List<FilePhysicalItem> lhsPhysicalItems;
            lhsPhysicalItems = (((this.physicalItems!= null)&&(!this.physicalItems.isEmpty()))?this.getPhysicalItems():null);
            List<FilePhysicalItem> rhsPhysicalItems;
            rhsPhysicalItems = (((that.physicalItems!= null)&&(!that.physicalItems.isEmpty()))?that.getPhysicalItems():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "physicalItems", lhsPhysicalItems), LocatorUtils.property(thatLocator, "physicalItems", rhsPhysicalItems), lhsPhysicalItems, rhsPhysicalItems)) {
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
            String theCustodian;
            theCustodian = this.getCustodian();
            strategy.appendField(locator, this, "custodian", buffer, theCustodian);
        }
        {
            XMLGregorianCalendar theUserDateOfFirstUse;
            theUserDateOfFirstUse = this.getUserDateOfFirstUse();
            strategy.appendField(locator, this, "userDateOfFirstUse", buffer, theUserDateOfFirstUse);
        }
        {
            XMLGregorianCalendar theDateOfFirstUse;
            theDateOfFirstUse = this.getDateOfFirstUse();
            strategy.appendField(locator, this, "dateOfFirstUse", buffer, theDateOfFirstUse);
        }
        {
            XMLGregorianCalendar theUserClosureDate;
            theUserClosureDate = this.getUserClosureDate();
            strategy.appendField(locator, this, "userClosureDate", buffer, theUserClosureDate);
        }
        {
            XMLGregorianCalendar theClosureDate;
            theClosureDate = this.getClosureDate();
            strategy.appendField(locator, this, "closureDate", buffer, theClosureDate);
        }
        {
            XMLGregorianCalendar theEndDateARP;
            theEndDateARP = this.getEndDateARP();
            strategy.appendField(locator, this, "endDateARP", buffer, theEndDateARP);
        }
        {
            FilePostARPAction thePostARPAction;
            thePostARPAction = this.getPostARPAction();
            strategy.appendField(locator, this, "postARPAction", buffer, thePostARPAction);
        }
        {
            Boolean theFinancialDocuments;
            theFinancialDocuments = this.isFinancialDocuments();
            strategy.appendField(locator, this, "financialDocuments", buffer, theFinancialDocuments);
        }
        {
            Boolean theCrlCategoryWithManualFollowUp;
            theCrlCategoryWithManualFollowUp = this.isCrlCategoryWithManualFollowUp();
            strategy.appendField(locator, this, "crlCategoryWithManualFollowUp", buffer, theCrlCategoryWithManualFollowUp);
        }
        {
            Boolean theCrlCategoryWithAdminElimination;
            theCrlCategoryWithAdminElimination = this.isCrlCategoryWithAdminElimination();
            strategy.appendField(locator, this, "crlCategoryWithAdminElimination", buffer, theCrlCategoryWithAdminElimination);
        }
        {
            Integer theDeadlineForAPED;
            theDeadlineForAPED = this.getDeadlineForAPED();
            strategy.appendField(locator, this, "deadlineForAPED", buffer, theDeadlineForAPED);
        }
        {
            Boolean theHermesDigitalRepository;
            theHermesDigitalRepository = this.isHermesDigitalRepository();
            strategy.appendField(locator, this, "hermesDigitalRepository", buffer, theHermesDigitalRepository);
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
            List<FilePhysicalItem> thePhysicalItems;
            thePhysicalItems = (((this.physicalItems!= null)&&(!this.physicalItems.isEmpty()))?this.getPhysicalItems():null);
            strategy.appendField(locator, this, "physicalItems", buffer, thePhysicalItems);
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
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theCustodian;
            theCustodian = this.getCustodian();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "custodian", theCustodian), currentHashCode, theCustodian);
        }
        {
            XMLGregorianCalendar theUserDateOfFirstUse;
            theUserDateOfFirstUse = this.getUserDateOfFirstUse();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userDateOfFirstUse", theUserDateOfFirstUse), currentHashCode, theUserDateOfFirstUse);
        }
        {
            XMLGregorianCalendar theDateOfFirstUse;
            theDateOfFirstUse = this.getDateOfFirstUse();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateOfFirstUse", theDateOfFirstUse), currentHashCode, theDateOfFirstUse);
        }
        {
            XMLGregorianCalendar theUserClosureDate;
            theUserClosureDate = this.getUserClosureDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userClosureDate", theUserClosureDate), currentHashCode, theUserClosureDate);
        }
        {
            XMLGregorianCalendar theClosureDate;
            theClosureDate = this.getClosureDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "closureDate", theClosureDate), currentHashCode, theClosureDate);
        }
        {
            XMLGregorianCalendar theEndDateARP;
            theEndDateARP = this.getEndDateARP();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "endDateARP", theEndDateARP), currentHashCode, theEndDateARP);
        }
        {
            FilePostARPAction thePostARPAction;
            thePostARPAction = this.getPostARPAction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "postARPAction", thePostARPAction), currentHashCode, thePostARPAction);
        }
        {
            Boolean theFinancialDocuments;
            theFinancialDocuments = this.isFinancialDocuments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "financialDocuments", theFinancialDocuments), currentHashCode, theFinancialDocuments);
        }
        {
            Boolean theCrlCategoryWithManualFollowUp;
            theCrlCategoryWithManualFollowUp = this.isCrlCategoryWithManualFollowUp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "crlCategoryWithManualFollowUp", theCrlCategoryWithManualFollowUp), currentHashCode, theCrlCategoryWithManualFollowUp);
        }
        {
            Boolean theCrlCategoryWithAdminElimination;
            theCrlCategoryWithAdminElimination = this.isCrlCategoryWithAdminElimination();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "crlCategoryWithAdminElimination", theCrlCategoryWithAdminElimination), currentHashCode, theCrlCategoryWithAdminElimination);
        }
        {
            Integer theDeadlineForAPED;
            theDeadlineForAPED = this.getDeadlineForAPED();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deadlineForAPED", theDeadlineForAPED), currentHashCode, theDeadlineForAPED);
        }
        {
            Boolean theHermesDigitalRepository;
            theHermesDigitalRepository = this.isHermesDigitalRepository();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hermesDigitalRepository", theHermesDigitalRepository), currentHashCode, theHermesDigitalRepository);
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
            List<FilePhysicalItem> thePhysicalItems;
            thePhysicalItems = (((this.physicalItems!= null)&&(!this.physicalItems.isEmpty()))?this.getPhysicalItems():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "physicalItems", thePhysicalItems), currentHashCode, thePhysicalItems);
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
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
