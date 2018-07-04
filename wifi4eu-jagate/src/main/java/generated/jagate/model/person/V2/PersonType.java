
package generated.jagate.model.person.V2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import eu.europa.ec.research.fp.model.code_ref.v2.CodeRefType;
import generated.jagate.model.address.V2.AddressType;
import generated.jagate.model.base.V1.GenderType;
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
 * <p>Java class for PersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://ec.europa.eu/research/fp/model/person/V2}NameGroup"/>
 *         &lt;element name="Gender" type="{http://ec.europa.eu/research/fp/model/base/V1}GenderType" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonIdentificationList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PersonIdentification" type="{http://ec.europa.eu/research/fp/model/person/V2}PersonIdentificationType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://ec.europa.eu/research/fp/model/address/V2}AddressType" minOccurs="0"/>
 *         &lt;element name="NationalityCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V2}CodeRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CountryOfResidenceCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V2}CodeRefType" minOccurs="0"/>
 *         &lt;element name="CountryOfBirthCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V2}CodeRefType" minOccurs="0"/>
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PlaceOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BirthFamilyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryOfOrigin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TownOfOrigin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonType", propOrder = {
    "familyName",
    "firstName",
    "gender",
    "title",
    "personIdentificationList",
    "position",
    "department",
    "address",
    "nationalityCode",
    "countryOfResidenceCode",
    "countryOfBirthCode",
    "dateOfBirth",
    "placeOfBirth",
    "birthFamilyName",
    "countryOfOrigin",
    "townOfOrigin"
})
public class PersonType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "FamilyName", required = true)
    protected String familyName;
    @XmlElement(name = "FirstName", required = true)
    protected String firstName;
    @XmlElement(name = "Gender")
    protected GenderType gender;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "PersonIdentificationList")
    protected PersonType.PersonIdentificationList personIdentificationList;
    @XmlElement(name = "Position")
    protected String position;
    @XmlElement(name = "Department")
    protected String department;
    @XmlElement(name = "Address")
    protected AddressType address;
    @XmlElement(name = "NationalityCode")
    protected List<CodeRefType> nationalityCode;
    @XmlElement(name = "CountryOfResidenceCode")
    protected CodeRefType countryOfResidenceCode;
    @XmlElement(name = "CountryOfBirthCode")
    protected CodeRefType countryOfBirthCode;
    @XmlElement(name = "DateOfBirth")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElement(name = "PlaceOfBirth")
    protected String placeOfBirth;
    @XmlElement(name = "BirthFamilyName")
    protected String birthFamilyName;
    @XmlElement(name = "CountryOfOrigin")
    protected String countryOfOrigin;
    @XmlElement(name = "TownOfOrigin")
    protected String townOfOrigin;

    /**
     * Gets the value of the familyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Sets the value of the familyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyName(String value) {
        this.familyName = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link GenderType }
     *     
     */
    public GenderType getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenderType }
     *     
     */
    public void setGender(GenderType value) {
        this.gender = value;
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
     * Gets the value of the personIdentificationList property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType.PersonIdentificationList }
     *     
     */
    public PersonType.PersonIdentificationList getPersonIdentificationList() {
        return personIdentificationList;
    }

    /**
     * Sets the value of the personIdentificationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType.PersonIdentificationList }
     *     
     */
    public void setPersonIdentificationList(PersonType.PersonIdentificationList value) {
        this.personIdentificationList = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the nationalityCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nationalityCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNationalityCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeRefType }
     * 
     * 
     */
    public List<CodeRefType> getNationalityCode() {
        if (nationalityCode == null) {
            nationalityCode = new ArrayList<CodeRefType>();
        }
        return this.nationalityCode;
    }

    /**
     * Gets the value of the countryOfResidenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCountryOfResidenceCode() {
        return countryOfResidenceCode;
    }

    /**
     * Sets the value of the countryOfResidenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCountryOfResidenceCode(CodeRefType value) {
        this.countryOfResidenceCode = value;
    }

    /**
     * Gets the value of the countryOfBirthCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCountryOfBirthCode() {
        return countryOfBirthCode;
    }

    /**
     * Sets the value of the countryOfBirthCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCountryOfBirthCode(CodeRefType value) {
        this.countryOfBirthCode = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the placeOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * Sets the value of the placeOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOfBirth(String value) {
        this.placeOfBirth = value;
    }

    /**
     * Gets the value of the birthFamilyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthFamilyName() {
        return birthFamilyName;
    }

    /**
     * Sets the value of the birthFamilyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthFamilyName(String value) {
        this.birthFamilyName = value;
    }

    /**
     * Gets the value of the countryOfOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /**
     * Sets the value of the countryOfOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfOrigin(String value) {
        this.countryOfOrigin = value;
    }

    /**
     * Gets the value of the townOfOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTownOfOrigin() {
        return townOfOrigin;
    }

    /**
     * Sets the value of the townOfOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTownOfOrigin(String value) {
        this.townOfOrigin = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PersonType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PersonType that = ((PersonType) object);
        {
            String lhsFamilyName;
            lhsFamilyName = this.getFamilyName();
            String rhsFamilyName;
            rhsFamilyName = that.getFamilyName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "familyName", lhsFamilyName), LocatorUtils.property(thatLocator, "familyName", rhsFamilyName), lhsFamilyName, rhsFamilyName)) {
                return false;
            }
        }
        {
            String lhsFirstName;
            lhsFirstName = this.getFirstName();
            String rhsFirstName;
            rhsFirstName = that.getFirstName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "firstName", lhsFirstName), LocatorUtils.property(thatLocator, "firstName", rhsFirstName), lhsFirstName, rhsFirstName)) {
                return false;
            }
        }
        {
            GenderType lhsGender;
            lhsGender = this.getGender();
            GenderType rhsGender;
            rhsGender = that.getGender();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "gender", lhsGender), LocatorUtils.property(thatLocator, "gender", rhsGender), lhsGender, rhsGender)) {
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
            PersonType.PersonIdentificationList lhsPersonIdentificationList;
            lhsPersonIdentificationList = this.getPersonIdentificationList();
            PersonType.PersonIdentificationList rhsPersonIdentificationList;
            rhsPersonIdentificationList = that.getPersonIdentificationList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "personIdentificationList", lhsPersonIdentificationList), LocatorUtils.property(thatLocator, "personIdentificationList", rhsPersonIdentificationList), lhsPersonIdentificationList, rhsPersonIdentificationList)) {
                return false;
            }
        }
        {
            String lhsPosition;
            lhsPosition = this.getPosition();
            String rhsPosition;
            rhsPosition = that.getPosition();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "position", lhsPosition), LocatorUtils.property(thatLocator, "position", rhsPosition), lhsPosition, rhsPosition)) {
                return false;
            }
        }
        {
            String lhsDepartment;
            lhsDepartment = this.getDepartment();
            String rhsDepartment;
            rhsDepartment = that.getDepartment();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "department", lhsDepartment), LocatorUtils.property(thatLocator, "department", rhsDepartment), lhsDepartment, rhsDepartment)) {
                return false;
            }
        }
        {
            AddressType lhsAddress;
            lhsAddress = this.getAddress();
            AddressType rhsAddress;
            rhsAddress = that.getAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "address", lhsAddress), LocatorUtils.property(thatLocator, "address", rhsAddress), lhsAddress, rhsAddress)) {
                return false;
            }
        }
        {
            List<CodeRefType> lhsNationalityCode;
            lhsNationalityCode = (((this.nationalityCode!= null)&&(!this.nationalityCode.isEmpty()))?this.getNationalityCode():null);
            List<CodeRefType> rhsNationalityCode;
            rhsNationalityCode = (((that.nationalityCode!= null)&&(!that.nationalityCode.isEmpty()))?that.getNationalityCode():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nationalityCode", lhsNationalityCode), LocatorUtils.property(thatLocator, "nationalityCode", rhsNationalityCode), lhsNationalityCode, rhsNationalityCode)) {
                return false;
            }
        }
        {
            CodeRefType lhsCountryOfResidenceCode;
            lhsCountryOfResidenceCode = this.getCountryOfResidenceCode();
            CodeRefType rhsCountryOfResidenceCode;
            rhsCountryOfResidenceCode = that.getCountryOfResidenceCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "countryOfResidenceCode", lhsCountryOfResidenceCode), LocatorUtils.property(thatLocator, "countryOfResidenceCode", rhsCountryOfResidenceCode), lhsCountryOfResidenceCode, rhsCountryOfResidenceCode)) {
                return false;
            }
        }
        {
            CodeRefType lhsCountryOfBirthCode;
            lhsCountryOfBirthCode = this.getCountryOfBirthCode();
            CodeRefType rhsCountryOfBirthCode;
            rhsCountryOfBirthCode = that.getCountryOfBirthCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "countryOfBirthCode", lhsCountryOfBirthCode), LocatorUtils.property(thatLocator, "countryOfBirthCode", rhsCountryOfBirthCode), lhsCountryOfBirthCode, rhsCountryOfBirthCode)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDateOfBirth;
            lhsDateOfBirth = this.getDateOfBirth();
            XMLGregorianCalendar rhsDateOfBirth;
            rhsDateOfBirth = that.getDateOfBirth();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateOfBirth", lhsDateOfBirth), LocatorUtils.property(thatLocator, "dateOfBirth", rhsDateOfBirth), lhsDateOfBirth, rhsDateOfBirth)) {
                return false;
            }
        }
        {
            String lhsPlaceOfBirth;
            lhsPlaceOfBirth = this.getPlaceOfBirth();
            String rhsPlaceOfBirth;
            rhsPlaceOfBirth = that.getPlaceOfBirth();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "placeOfBirth", lhsPlaceOfBirth), LocatorUtils.property(thatLocator, "placeOfBirth", rhsPlaceOfBirth), lhsPlaceOfBirth, rhsPlaceOfBirth)) {
                return false;
            }
        }
        {
            String lhsBirthFamilyName;
            lhsBirthFamilyName = this.getBirthFamilyName();
            String rhsBirthFamilyName;
            rhsBirthFamilyName = that.getBirthFamilyName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "birthFamilyName", lhsBirthFamilyName), LocatorUtils.property(thatLocator, "birthFamilyName", rhsBirthFamilyName), lhsBirthFamilyName, rhsBirthFamilyName)) {
                return false;
            }
        }
        {
            String lhsCountryOfOrigin;
            lhsCountryOfOrigin = this.getCountryOfOrigin();
            String rhsCountryOfOrigin;
            rhsCountryOfOrigin = that.getCountryOfOrigin();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "countryOfOrigin", lhsCountryOfOrigin), LocatorUtils.property(thatLocator, "countryOfOrigin", rhsCountryOfOrigin), lhsCountryOfOrigin, rhsCountryOfOrigin)) {
                return false;
            }
        }
        {
            String lhsTownOfOrigin;
            lhsTownOfOrigin = this.getTownOfOrigin();
            String rhsTownOfOrigin;
            rhsTownOfOrigin = that.getTownOfOrigin();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "townOfOrigin", lhsTownOfOrigin), LocatorUtils.property(thatLocator, "townOfOrigin", rhsTownOfOrigin), lhsTownOfOrigin, rhsTownOfOrigin)) {
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
            String theFamilyName;
            theFamilyName = this.getFamilyName();
            strategy.appendField(locator, this, "familyName", buffer, theFamilyName);
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            strategy.appendField(locator, this, "firstName", buffer, theFirstName);
        }
        {
            GenderType theGender;
            theGender = this.getGender();
            strategy.appendField(locator, this, "gender", buffer, theGender);
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle);
        }
        {
            PersonType.PersonIdentificationList thePersonIdentificationList;
            thePersonIdentificationList = this.getPersonIdentificationList();
            strategy.appendField(locator, this, "personIdentificationList", buffer, thePersonIdentificationList);
        }
        {
            String thePosition;
            thePosition = this.getPosition();
            strategy.appendField(locator, this, "position", buffer, thePosition);
        }
        {
            String theDepartment;
            theDepartment = this.getDepartment();
            strategy.appendField(locator, this, "department", buffer, theDepartment);
        }
        {
            AddressType theAddress;
            theAddress = this.getAddress();
            strategy.appendField(locator, this, "address", buffer, theAddress);
        }
        {
            List<CodeRefType> theNationalityCode;
            theNationalityCode = (((this.nationalityCode!= null)&&(!this.nationalityCode.isEmpty()))?this.getNationalityCode():null);
            strategy.appendField(locator, this, "nationalityCode", buffer, theNationalityCode);
        }
        {
            CodeRefType theCountryOfResidenceCode;
            theCountryOfResidenceCode = this.getCountryOfResidenceCode();
            strategy.appendField(locator, this, "countryOfResidenceCode", buffer, theCountryOfResidenceCode);
        }
        {
            CodeRefType theCountryOfBirthCode;
            theCountryOfBirthCode = this.getCountryOfBirthCode();
            strategy.appendField(locator, this, "countryOfBirthCode", buffer, theCountryOfBirthCode);
        }
        {
            XMLGregorianCalendar theDateOfBirth;
            theDateOfBirth = this.getDateOfBirth();
            strategy.appendField(locator, this, "dateOfBirth", buffer, theDateOfBirth);
        }
        {
            String thePlaceOfBirth;
            thePlaceOfBirth = this.getPlaceOfBirth();
            strategy.appendField(locator, this, "placeOfBirth", buffer, thePlaceOfBirth);
        }
        {
            String theBirthFamilyName;
            theBirthFamilyName = this.getBirthFamilyName();
            strategy.appendField(locator, this, "birthFamilyName", buffer, theBirthFamilyName);
        }
        {
            String theCountryOfOrigin;
            theCountryOfOrigin = this.getCountryOfOrigin();
            strategy.appendField(locator, this, "countryOfOrigin", buffer, theCountryOfOrigin);
        }
        {
            String theTownOfOrigin;
            theTownOfOrigin = this.getTownOfOrigin();
            strategy.appendField(locator, this, "townOfOrigin", buffer, theTownOfOrigin);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theFamilyName;
            theFamilyName = this.getFamilyName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "familyName", theFamilyName), currentHashCode, theFamilyName);
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "firstName", theFirstName), currentHashCode, theFirstName);
        }
        {
            GenderType theGender;
            theGender = this.getGender();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gender", theGender), currentHashCode, theGender);
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle), currentHashCode, theTitle);
        }
        {
            PersonType.PersonIdentificationList thePersonIdentificationList;
            thePersonIdentificationList = this.getPersonIdentificationList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "personIdentificationList", thePersonIdentificationList), currentHashCode, thePersonIdentificationList);
        }
        {
            String thePosition;
            thePosition = this.getPosition();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "position", thePosition), currentHashCode, thePosition);
        }
        {
            String theDepartment;
            theDepartment = this.getDepartment();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "department", theDepartment), currentHashCode, theDepartment);
        }
        {
            AddressType theAddress;
            theAddress = this.getAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "address", theAddress), currentHashCode, theAddress);
        }
        {
            List<CodeRefType> theNationalityCode;
            theNationalityCode = (((this.nationalityCode!= null)&&(!this.nationalityCode.isEmpty()))?this.getNationalityCode():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nationalityCode", theNationalityCode), currentHashCode, theNationalityCode);
        }
        {
            CodeRefType theCountryOfResidenceCode;
            theCountryOfResidenceCode = this.getCountryOfResidenceCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "countryOfResidenceCode", theCountryOfResidenceCode), currentHashCode, theCountryOfResidenceCode);
        }
        {
            CodeRefType theCountryOfBirthCode;
            theCountryOfBirthCode = this.getCountryOfBirthCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "countryOfBirthCode", theCountryOfBirthCode), currentHashCode, theCountryOfBirthCode);
        }
        {
            XMLGregorianCalendar theDateOfBirth;
            theDateOfBirth = this.getDateOfBirth();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateOfBirth", theDateOfBirth), currentHashCode, theDateOfBirth);
        }
        {
            String thePlaceOfBirth;
            thePlaceOfBirth = this.getPlaceOfBirth();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "placeOfBirth", thePlaceOfBirth), currentHashCode, thePlaceOfBirth);
        }
        {
            String theBirthFamilyName;
            theBirthFamilyName = this.getBirthFamilyName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "birthFamilyName", theBirthFamilyName), currentHashCode, theBirthFamilyName);
        }
        {
            String theCountryOfOrigin;
            theCountryOfOrigin = this.getCountryOfOrigin();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "countryOfOrigin", theCountryOfOrigin), currentHashCode, theCountryOfOrigin);
        }
        {
            String theTownOfOrigin;
            theTownOfOrigin = this.getTownOfOrigin();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "townOfOrigin", theTownOfOrigin), currentHashCode, theTownOfOrigin);
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
     *         &lt;element name="PersonIdentification" type="{http://ec.europa.eu/research/fp/model/person/V2}PersonIdentificationType" maxOccurs="unbounded"/>
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
        "personIdentification"
    })
    public static class PersonIdentificationList
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "PersonIdentification", required = true)
        protected List<PersonIdentificationType> personIdentification;

        /**
         * Gets the value of the personIdentification property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the personIdentification property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPersonIdentification().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PersonIdentificationType }
         * 
         * 
         */
        public List<PersonIdentificationType> getPersonIdentification() {
            if (personIdentification == null) {
                personIdentification = new ArrayList<PersonIdentificationType>();
            }
            return this.personIdentification;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof PersonType.PersonIdentificationList)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final PersonType.PersonIdentificationList that = ((PersonType.PersonIdentificationList) object);
            {
                List<PersonIdentificationType> lhsPersonIdentification;
                lhsPersonIdentification = (((this.personIdentification!= null)&&(!this.personIdentification.isEmpty()))?this.getPersonIdentification():null);
                List<PersonIdentificationType> rhsPersonIdentification;
                rhsPersonIdentification = (((that.personIdentification!= null)&&(!that.personIdentification.isEmpty()))?that.getPersonIdentification():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "personIdentification", lhsPersonIdentification), LocatorUtils.property(thatLocator, "personIdentification", rhsPersonIdentification), lhsPersonIdentification, rhsPersonIdentification)) {
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
                List<PersonIdentificationType> thePersonIdentification;
                thePersonIdentification = (((this.personIdentification!= null)&&(!this.personIdentification.isEmpty()))?this.getPersonIdentification():null);
                strategy.appendField(locator, this, "personIdentification", buffer, thePersonIdentification);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<PersonIdentificationType> thePersonIdentification;
                thePersonIdentification = (((this.personIdentification!= null)&&(!this.personIdentification.isEmpty()))?this.getPersonIdentification():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "personIdentification", thePersonIdentification), currentHashCode, thePersonIdentification);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
