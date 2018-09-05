
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
 * A heading (rubrique)
 * 
 * <p>Java class for Heading complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Heading">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headingId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="type" type="{http://ec.europa.eu/sg/hrs/types}HeadingType"/>
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="headingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specificCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://ec.europa.eu/sg/hrs/types}HeadingStatus" minOccurs="0"/>
 *         &lt;element name="levelCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="headingCodeStep" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" minOccurs="0"/>
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="englishName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="germanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceOwners" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="serviceOwner" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="headingReaders" minOccurs="0">
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
 *         &lt;element name="headingEditors" minOccurs="0">
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
 *         &lt;element name="fileCreators" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="englishDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="germanDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="germanComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categories" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="category" type="{http://ec.europa.eu/sg/hrs/types}Category" maxOccurs="unbounded"/>
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
@XmlType(name = "Heading", propOrder = {
    "headingId",
    "type",
    "path",
    "headingCode",
    "specificCode",
    "status",
    "levelCode",
    "headingCodeStep",
    "parentId",
    "creationDate",
    "englishName",
    "frenchName",
    "germanName",
    "serviceOwners",
    "headingReaders",
    "headingEditors",
    "fileCreators",
    "englishDescription",
    "frenchDescription",
    "germanDescription",
    "englishComments",
    "frenchComments",
    "germanComments",
    "categories"
})
public class Heading
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String headingId;
    @XmlElement(required = true)
    protected HeadingType type;
    @XmlElement(required = true)
    protected String path;
    protected String headingCode;
    protected String specificCode;
    protected HeadingStatus status;
    @XmlElement(required = true)
    protected String levelCode;
    @XmlElement(required = true)
    protected String headingCodeStep;
    protected String parentId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar creationDate;
    protected String englishName;
    protected String frenchName;
    protected String germanName;
    protected Heading.ServiceOwners serviceOwners;
    protected Heading.HeadingReaders headingReaders;
    protected Heading.HeadingEditors headingEditors;
    protected Heading.FileCreators fileCreators;
    protected String englishDescription;
    protected String frenchDescription;
    protected String germanDescription;
    protected String englishComments;
    protected String frenchComments;
    protected String germanComments;
    protected Heading.Categories categories;

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link HeadingType }
     *     
     */
    public HeadingType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeadingType }
     *     
     */
    public void setType(HeadingType value) {
        this.type = value;
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
     *     {@link HeadingStatus }
     *     
     */
    public HeadingStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeadingStatus }
     *     
     */
    public void setStatus(HeadingStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the levelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevelCode() {
        return levelCode;
    }

    /**
     * Sets the value of the levelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevelCode(String value) {
        this.levelCode = value;
    }

    /**
     * Gets the value of the headingCodeStep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadingCodeStep() {
        return headingCodeStep;
    }

    /**
     * Sets the value of the headingCodeStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadingCodeStep(String value) {
        this.headingCodeStep = value;
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
     * Gets the value of the serviceOwners property.
     * 
     * @return
     *     possible object is
     *     {@link Heading.ServiceOwners }
     *     
     */
    public Heading.ServiceOwners getServiceOwners() {
        return serviceOwners;
    }

    /**
     * Sets the value of the serviceOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link Heading.ServiceOwners }
     *     
     */
    public void setServiceOwners(Heading.ServiceOwners value) {
        this.serviceOwners = value;
    }

    /**
     * Gets the value of the headingReaders property.
     * 
     * @return
     *     possible object is
     *     {@link Heading.HeadingReaders }
     *     
     */
    public Heading.HeadingReaders getHeadingReaders() {
        return headingReaders;
    }

    /**
     * Sets the value of the headingReaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link Heading.HeadingReaders }
     *     
     */
    public void setHeadingReaders(Heading.HeadingReaders value) {
        this.headingReaders = value;
    }

    /**
     * Gets the value of the headingEditors property.
     * 
     * @return
     *     possible object is
     *     {@link Heading.HeadingEditors }
     *     
     */
    public Heading.HeadingEditors getHeadingEditors() {
        return headingEditors;
    }

    /**
     * Sets the value of the headingEditors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Heading.HeadingEditors }
     *     
     */
    public void setHeadingEditors(Heading.HeadingEditors value) {
        this.headingEditors = value;
    }

    /**
     * Gets the value of the fileCreators property.
     * 
     * @return
     *     possible object is
     *     {@link Heading.FileCreators }
     *     
     */
    public Heading.FileCreators getFileCreators() {
        return fileCreators;
    }

    /**
     * Sets the value of the fileCreators property.
     * 
     * @param value
     *     allowed object is
     *     {@link Heading.FileCreators }
     *     
     */
    public void setFileCreators(Heading.FileCreators value) {
        this.fileCreators = value;
    }

    /**
     * Gets the value of the englishDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishDescription() {
        return englishDescription;
    }

    /**
     * Sets the value of the englishDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishDescription(String value) {
        this.englishDescription = value;
    }

    /**
     * Gets the value of the frenchDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrenchDescription() {
        return frenchDescription;
    }

    /**
     * Sets the value of the frenchDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrenchDescription(String value) {
        this.frenchDescription = value;
    }

    /**
     * Gets the value of the germanDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGermanDescription() {
        return germanDescription;
    }

    /**
     * Sets the value of the germanDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGermanDescription(String value) {
        this.germanDescription = value;
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
     * Gets the value of the categories property.
     * 
     * @return
     *     possible object is
     *     {@link Heading.Categories }
     *     
     */
    public Heading.Categories getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     * 
     * @param value
     *     allowed object is
     *     {@link Heading.Categories }
     *     
     */
    public void setCategories(Heading.Categories value) {
        this.categories = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Heading)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Heading that = ((Heading) object);
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
            HeadingType lhsType;
            lhsType = this.getType();
            HeadingType rhsType;
            rhsType = that.getType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType)) {
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
            String lhsHeadingCode;
            lhsHeadingCode = this.getHeadingCode();
            String rhsHeadingCode;
            rhsHeadingCode = that.getHeadingCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "headingCode", lhsHeadingCode), LocatorUtils.property(thatLocator, "headingCode", rhsHeadingCode), lhsHeadingCode, rhsHeadingCode)) {
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
            HeadingStatus lhsStatus;
            lhsStatus = this.getStatus();
            HeadingStatus rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            String lhsLevelCode;
            lhsLevelCode = this.getLevelCode();
            String rhsLevelCode;
            rhsLevelCode = that.getLevelCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "levelCode", lhsLevelCode), LocatorUtils.property(thatLocator, "levelCode", rhsLevelCode), lhsLevelCode, rhsLevelCode)) {
                return false;
            }
        }
        {
            String lhsHeadingCodeStep;
            lhsHeadingCodeStep = this.getHeadingCodeStep();
            String rhsHeadingCodeStep;
            rhsHeadingCodeStep = that.getHeadingCodeStep();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "headingCodeStep", lhsHeadingCodeStep), LocatorUtils.property(thatLocator, "headingCodeStep", rhsHeadingCodeStep), lhsHeadingCodeStep, rhsHeadingCodeStep)) {
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
            XMLGregorianCalendar lhsCreationDate;
            lhsCreationDate = this.getCreationDate();
            XMLGregorianCalendar rhsCreationDate;
            rhsCreationDate = that.getCreationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creationDate", lhsCreationDate), LocatorUtils.property(thatLocator, "creationDate", rhsCreationDate), lhsCreationDate, rhsCreationDate)) {
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
            Heading.ServiceOwners lhsServiceOwners;
            lhsServiceOwners = this.getServiceOwners();
            Heading.ServiceOwners rhsServiceOwners;
            rhsServiceOwners = that.getServiceOwners();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceOwners", lhsServiceOwners), LocatorUtils.property(thatLocator, "serviceOwners", rhsServiceOwners), lhsServiceOwners, rhsServiceOwners)) {
                return false;
            }
        }
        {
            Heading.HeadingReaders lhsHeadingReaders;
            lhsHeadingReaders = this.getHeadingReaders();
            Heading.HeadingReaders rhsHeadingReaders;
            rhsHeadingReaders = that.getHeadingReaders();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "headingReaders", lhsHeadingReaders), LocatorUtils.property(thatLocator, "headingReaders", rhsHeadingReaders), lhsHeadingReaders, rhsHeadingReaders)) {
                return false;
            }
        }
        {
            Heading.HeadingEditors lhsHeadingEditors;
            lhsHeadingEditors = this.getHeadingEditors();
            Heading.HeadingEditors rhsHeadingEditors;
            rhsHeadingEditors = that.getHeadingEditors();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "headingEditors", lhsHeadingEditors), LocatorUtils.property(thatLocator, "headingEditors", rhsHeadingEditors), lhsHeadingEditors, rhsHeadingEditors)) {
                return false;
            }
        }
        {
            Heading.FileCreators lhsFileCreators;
            lhsFileCreators = this.getFileCreators();
            Heading.FileCreators rhsFileCreators;
            rhsFileCreators = that.getFileCreators();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileCreators", lhsFileCreators), LocatorUtils.property(thatLocator, "fileCreators", rhsFileCreators), lhsFileCreators, rhsFileCreators)) {
                return false;
            }
        }
        {
            String lhsEnglishDescription;
            lhsEnglishDescription = this.getEnglishDescription();
            String rhsEnglishDescription;
            rhsEnglishDescription = that.getEnglishDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "englishDescription", lhsEnglishDescription), LocatorUtils.property(thatLocator, "englishDescription", rhsEnglishDescription), lhsEnglishDescription, rhsEnglishDescription)) {
                return false;
            }
        }
        {
            String lhsFrenchDescription;
            lhsFrenchDescription = this.getFrenchDescription();
            String rhsFrenchDescription;
            rhsFrenchDescription = that.getFrenchDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "frenchDescription", lhsFrenchDescription), LocatorUtils.property(thatLocator, "frenchDescription", rhsFrenchDescription), lhsFrenchDescription, rhsFrenchDescription)) {
                return false;
            }
        }
        {
            String lhsGermanDescription;
            lhsGermanDescription = this.getGermanDescription();
            String rhsGermanDescription;
            rhsGermanDescription = that.getGermanDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "germanDescription", lhsGermanDescription), LocatorUtils.property(thatLocator, "germanDescription", rhsGermanDescription), lhsGermanDescription, rhsGermanDescription)) {
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
            Heading.Categories lhsCategories;
            lhsCategories = this.getCategories();
            Heading.Categories rhsCategories;
            rhsCategories = that.getCategories();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "categories", lhsCategories), LocatorUtils.property(thatLocator, "categories", rhsCategories), lhsCategories, rhsCategories)) {
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
            HeadingType theType;
            theType = this.getType();
            strategy.appendField(locator, this, "type", buffer, theType);
        }
        {
            String thePath;
            thePath = this.getPath();
            strategy.appendField(locator, this, "path", buffer, thePath);
        }
        {
            String theHeadingCode;
            theHeadingCode = this.getHeadingCode();
            strategy.appendField(locator, this, "headingCode", buffer, theHeadingCode);
        }
        {
            String theSpecificCode;
            theSpecificCode = this.getSpecificCode();
            strategy.appendField(locator, this, "specificCode", buffer, theSpecificCode);
        }
        {
            HeadingStatus theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            String theLevelCode;
            theLevelCode = this.getLevelCode();
            strategy.appendField(locator, this, "levelCode", buffer, theLevelCode);
        }
        {
            String theHeadingCodeStep;
            theHeadingCodeStep = this.getHeadingCodeStep();
            strategy.appendField(locator, this, "headingCodeStep", buffer, theHeadingCodeStep);
        }
        {
            String theParentId;
            theParentId = this.getParentId();
            strategy.appendField(locator, this, "parentId", buffer, theParentId);
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            strategy.appendField(locator, this, "creationDate", buffer, theCreationDate);
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
            Heading.ServiceOwners theServiceOwners;
            theServiceOwners = this.getServiceOwners();
            strategy.appendField(locator, this, "serviceOwners", buffer, theServiceOwners);
        }
        {
            Heading.HeadingReaders theHeadingReaders;
            theHeadingReaders = this.getHeadingReaders();
            strategy.appendField(locator, this, "headingReaders", buffer, theHeadingReaders);
        }
        {
            Heading.HeadingEditors theHeadingEditors;
            theHeadingEditors = this.getHeadingEditors();
            strategy.appendField(locator, this, "headingEditors", buffer, theHeadingEditors);
        }
        {
            Heading.FileCreators theFileCreators;
            theFileCreators = this.getFileCreators();
            strategy.appendField(locator, this, "fileCreators", buffer, theFileCreators);
        }
        {
            String theEnglishDescription;
            theEnglishDescription = this.getEnglishDescription();
            strategy.appendField(locator, this, "englishDescription", buffer, theEnglishDescription);
        }
        {
            String theFrenchDescription;
            theFrenchDescription = this.getFrenchDescription();
            strategy.appendField(locator, this, "frenchDescription", buffer, theFrenchDescription);
        }
        {
            String theGermanDescription;
            theGermanDescription = this.getGermanDescription();
            strategy.appendField(locator, this, "germanDescription", buffer, theGermanDescription);
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
            Heading.Categories theCategories;
            theCategories = this.getCategories();
            strategy.appendField(locator, this, "categories", buffer, theCategories);
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
            HeadingType theType;
            theType = this.getType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType);
        }
        {
            String thePath;
            thePath = this.getPath();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "path", thePath), currentHashCode, thePath);
        }
        {
            String theHeadingCode;
            theHeadingCode = this.getHeadingCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "headingCode", theHeadingCode), currentHashCode, theHeadingCode);
        }
        {
            String theSpecificCode;
            theSpecificCode = this.getSpecificCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specificCode", theSpecificCode), currentHashCode, theSpecificCode);
        }
        {
            HeadingStatus theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            String theLevelCode;
            theLevelCode = this.getLevelCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "levelCode", theLevelCode), currentHashCode, theLevelCode);
        }
        {
            String theHeadingCodeStep;
            theHeadingCodeStep = this.getHeadingCodeStep();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "headingCodeStep", theHeadingCodeStep), currentHashCode, theHeadingCodeStep);
        }
        {
            String theParentId;
            theParentId = this.getParentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "parentId", theParentId), currentHashCode, theParentId);
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creationDate", theCreationDate), currentHashCode, theCreationDate);
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
            Heading.ServiceOwners theServiceOwners;
            theServiceOwners = this.getServiceOwners();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceOwners", theServiceOwners), currentHashCode, theServiceOwners);
        }
        {
            Heading.HeadingReaders theHeadingReaders;
            theHeadingReaders = this.getHeadingReaders();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "headingReaders", theHeadingReaders), currentHashCode, theHeadingReaders);
        }
        {
            Heading.HeadingEditors theHeadingEditors;
            theHeadingEditors = this.getHeadingEditors();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "headingEditors", theHeadingEditors), currentHashCode, theHeadingEditors);
        }
        {
            Heading.FileCreators theFileCreators;
            theFileCreators = this.getFileCreators();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileCreators", theFileCreators), currentHashCode, theFileCreators);
        }
        {
            String theEnglishDescription;
            theEnglishDescription = this.getEnglishDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "englishDescription", theEnglishDescription), currentHashCode, theEnglishDescription);
        }
        {
            String theFrenchDescription;
            theFrenchDescription = this.getFrenchDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "frenchDescription", theFrenchDescription), currentHashCode, theFrenchDescription);
        }
        {
            String theGermanDescription;
            theGermanDescription = this.getGermanDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "germanDescription", theGermanDescription), currentHashCode, theGermanDescription);
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
            Heading.Categories theCategories;
            theCategories = this.getCategories();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "categories", theCategories), currentHashCode, theCategories);
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
     *         &lt;element name="category" type="{http://ec.europa.eu/sg/hrs/types}Category" maxOccurs="unbounded"/>
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
        "category"
    })
    public static class Categories
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected List<Category> category;

        /**
         * Gets the value of the category property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the category property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCategory().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Category }
         * 
         * 
         */
        public List<Category> getCategory() {
            if (category == null) {
                category = new ArrayList<Category>();
            }
            return this.category;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Heading.Categories)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Heading.Categories that = ((Heading.Categories) object);
            {
                List<Category> lhsCategory;
                lhsCategory = (((this.category!= null)&&(!this.category.isEmpty()))?this.getCategory():null);
                List<Category> rhsCategory;
                rhsCategory = (((that.category!= null)&&(!that.category.isEmpty()))?that.getCategory():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "category", lhsCategory), LocatorUtils.property(thatLocator, "category", rhsCategory), lhsCategory, rhsCategory)) {
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
                List<Category> theCategory;
                theCategory = (((this.category!= null)&&(!this.category.isEmpty()))?this.getCategory():null);
                strategy.appendField(locator, this, "category", buffer, theCategory);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<Category> theCategory;
                theCategory = (((this.category!= null)&&(!this.category.isEmpty()))?this.getCategory():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "category", theCategory), currentHashCode, theCategory);
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
     *         &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "creator"
    })
    public static class FileCreators
        implements Equals, HashCode, ToString
    {

        protected List<String> creator;

        /**
         * Gets the value of the creator property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the creator property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCreator().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCreator() {
            if (creator == null) {
                creator = new ArrayList<String>();
            }
            return this.creator;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Heading.FileCreators)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Heading.FileCreators that = ((Heading.FileCreators) object);
            {
                List<String> lhsCreator;
                lhsCreator = (((this.creator!= null)&&(!this.creator.isEmpty()))?this.getCreator():null);
                List<String> rhsCreator;
                rhsCreator = (((that.creator!= null)&&(!that.creator.isEmpty()))?that.getCreator():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "creator", lhsCreator), LocatorUtils.property(thatLocator, "creator", rhsCreator), lhsCreator, rhsCreator)) {
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
                List<String> theCreator;
                theCreator = (((this.creator!= null)&&(!this.creator.isEmpty()))?this.getCreator():null);
                strategy.appendField(locator, this, "creator", buffer, theCreator);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theCreator;
                theCreator = (((this.creator!= null)&&(!this.creator.isEmpty()))?this.getCreator():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creator", theCreator), currentHashCode, theCreator);
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
    public static class HeadingEditors
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
            if (!(object instanceof Heading.HeadingEditors)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Heading.HeadingEditors that = ((Heading.HeadingEditors) object);
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
    public static class HeadingReaders
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
            if (!(object instanceof Heading.HeadingReaders)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Heading.HeadingReaders that = ((Heading.HeadingReaders) object);
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
     *         &lt;element name="serviceOwner" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "serviceOwner"
    })
    public static class ServiceOwners
        implements Equals, HashCode, ToString
    {

        protected List<String> serviceOwner;

        /**
         * Gets the value of the serviceOwner property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the serviceOwner property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getServiceOwner().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getServiceOwner() {
            if (serviceOwner == null) {
                serviceOwner = new ArrayList<String>();
            }
            return this.serviceOwner;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof Heading.ServiceOwners)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final Heading.ServiceOwners that = ((Heading.ServiceOwners) object);
            {
                List<String> lhsServiceOwner;
                lhsServiceOwner = (((this.serviceOwner!= null)&&(!this.serviceOwner.isEmpty()))?this.getServiceOwner():null);
                List<String> rhsServiceOwner;
                rhsServiceOwner = (((that.serviceOwner!= null)&&(!that.serviceOwner.isEmpty()))?that.getServiceOwner():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceOwner", lhsServiceOwner), LocatorUtils.property(thatLocator, "serviceOwner", rhsServiceOwner), lhsServiceOwner, rhsServiceOwner)) {
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
                List<String> theServiceOwner;
                theServiceOwner = (((this.serviceOwner!= null)&&(!this.serviceOwner.isEmpty()))?this.getServiceOwner():null);
                strategy.appendField(locator, this, "serviceOwner", buffer, theServiceOwner);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theServiceOwner;
                theServiceOwner = (((this.serviceOwner!= null)&&(!this.serviceOwner.isEmpty()))?this.getServiceOwner():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceOwner", theServiceOwner), currentHashCode, theServiceOwner);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
