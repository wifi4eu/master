
package generated.jagate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
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
 * <p>Java class for SearchLegalEntityRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchLegalEntityRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LegalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *         &lt;element name="FELId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="normaliseSearch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="resultsLimit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchLegalEntityRequestType", propOrder = {
    "firstName",
    "lastName",
    "identificationNumber",
    "legalName",
    "registrationNumber",
    "vat",
    "city",
    "country",
    "felId",
    "normaliseSearch",
    "resultsLimit"
})
public class SearchLegalEntityRequestType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "IdentificationNumber")
    protected String identificationNumber;
    @XmlElement(name = "LegalName")
    protected String legalName;
    @XmlElement(name = "RegistrationNumber")
    protected String registrationNumber;
    @XmlElement(name = "VAT")
    protected String vat;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "Country")
    protected CodeRefType country;
    @XmlElement(name = "FELId")
    protected String felId;
    @XmlElement(defaultValue = "true")
    protected Boolean normaliseSearch;
    protected Integer resultsLimit;

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
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the identificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Sets the value of the identificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationNumber(String value) {
        this.identificationNumber = value;
    }

    /**
     * Gets the value of the legalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * Sets the value of the legalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalName(String value) {
        this.legalName = value;
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
     * Gets the value of the vat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVAT() {
        return vat;
    }

    /**
     * Sets the value of the vat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVAT(String value) {
        this.vat = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCountry(CodeRefType value) {
        this.country = value;
    }

    /**
     * Gets the value of the felId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFELId() {
        return felId;
    }

    /**
     * Sets the value of the felId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFELId(String value) {
        this.felId = value;
    }

    /**
     * Gets the value of the normaliseSearch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNormaliseSearch() {
        return normaliseSearch;
    }

    /**
     * Sets the value of the normaliseSearch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNormaliseSearch(Boolean value) {
        this.normaliseSearch = value;
    }

    /**
     * Gets the value of the resultsLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResultsLimit() {
        return resultsLimit;
    }

    /**
     * Sets the value of the resultsLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResultsLimit(Integer value) {
        this.resultsLimit = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SearchLegalEntityRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SearchLegalEntityRequestType that = ((SearchLegalEntityRequestType) object);
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
            String lhsLastName;
            lhsLastName = this.getLastName();
            String rhsLastName;
            rhsLastName = that.getLastName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastName", lhsLastName), LocatorUtils.property(thatLocator, "lastName", rhsLastName), lhsLastName, rhsLastName)) {
                return false;
            }
        }
        {
            String lhsIdentificationNumber;
            lhsIdentificationNumber = this.getIdentificationNumber();
            String rhsIdentificationNumber;
            rhsIdentificationNumber = that.getIdentificationNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "identificationNumber", lhsIdentificationNumber), LocatorUtils.property(thatLocator, "identificationNumber", rhsIdentificationNumber), lhsIdentificationNumber, rhsIdentificationNumber)) {
                return false;
            }
        }
        {
            String lhsLegalName;
            lhsLegalName = this.getLegalName();
            String rhsLegalName;
            rhsLegalName = that.getLegalName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalName", lhsLegalName), LocatorUtils.property(thatLocator, "legalName", rhsLegalName), lhsLegalName, rhsLegalName)) {
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
            String lhsVAT;
            lhsVAT = this.getVAT();
            String rhsVAT;
            rhsVAT = that.getVAT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vat", lhsVAT), LocatorUtils.property(thatLocator, "vat", rhsVAT), lhsVAT, rhsVAT)) {
                return false;
            }
        }
        {
            String lhsCity;
            lhsCity = this.getCity();
            String rhsCity;
            rhsCity = that.getCity();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "city", lhsCity), LocatorUtils.property(thatLocator, "city", rhsCity), lhsCity, rhsCity)) {
                return false;
            }
        }
        {
            CodeRefType lhsCountry;
            lhsCountry = this.getCountry();
            CodeRefType rhsCountry;
            rhsCountry = that.getCountry();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "country", lhsCountry), LocatorUtils.property(thatLocator, "country", rhsCountry), lhsCountry, rhsCountry)) {
                return false;
            }
        }
        {
            String lhsFELId;
            lhsFELId = this.getFELId();
            String rhsFELId;
            rhsFELId = that.getFELId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "felId", lhsFELId), LocatorUtils.property(thatLocator, "felId", rhsFELId), lhsFELId, rhsFELId)) {
                return false;
            }
        }
        {
            Boolean lhsNormaliseSearch;
            lhsNormaliseSearch = this.isNormaliseSearch();
            Boolean rhsNormaliseSearch;
            rhsNormaliseSearch = that.isNormaliseSearch();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "normaliseSearch", lhsNormaliseSearch), LocatorUtils.property(thatLocator, "normaliseSearch", rhsNormaliseSearch), lhsNormaliseSearch, rhsNormaliseSearch)) {
                return false;
            }
        }
        {
            Integer lhsResultsLimit;
            lhsResultsLimit = this.getResultsLimit();
            Integer rhsResultsLimit;
            rhsResultsLimit = that.getResultsLimit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resultsLimit", lhsResultsLimit), LocatorUtils.property(thatLocator, "resultsLimit", rhsResultsLimit), lhsResultsLimit, rhsResultsLimit)) {
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
            String theFirstName;
            theFirstName = this.getFirstName();
            strategy.appendField(locator, this, "firstName", buffer, theFirstName);
        }
        {
            String theLastName;
            theLastName = this.getLastName();
            strategy.appendField(locator, this, "lastName", buffer, theLastName);
        }
        {
            String theIdentificationNumber;
            theIdentificationNumber = this.getIdentificationNumber();
            strategy.appendField(locator, this, "identificationNumber", buffer, theIdentificationNumber);
        }
        {
            String theLegalName;
            theLegalName = this.getLegalName();
            strategy.appendField(locator, this, "legalName", buffer, theLegalName);
        }
        {
            String theRegistrationNumber;
            theRegistrationNumber = this.getRegistrationNumber();
            strategy.appendField(locator, this, "registrationNumber", buffer, theRegistrationNumber);
        }
        {
            String theVAT;
            theVAT = this.getVAT();
            strategy.appendField(locator, this, "vat", buffer, theVAT);
        }
        {
            String theCity;
            theCity = this.getCity();
            strategy.appendField(locator, this, "city", buffer, theCity);
        }
        {
            CodeRefType theCountry;
            theCountry = this.getCountry();
            strategy.appendField(locator, this, "country", buffer, theCountry);
        }
        {
            String theFELId;
            theFELId = this.getFELId();
            strategy.appendField(locator, this, "felId", buffer, theFELId);
        }
        {
            Boolean theNormaliseSearch;
            theNormaliseSearch = this.isNormaliseSearch();
            strategy.appendField(locator, this, "normaliseSearch", buffer, theNormaliseSearch);
        }
        {
            Integer theResultsLimit;
            theResultsLimit = this.getResultsLimit();
            strategy.appendField(locator, this, "resultsLimit", buffer, theResultsLimit);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "firstName", theFirstName), currentHashCode, theFirstName);
        }
        {
            String theLastName;
            theLastName = this.getLastName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastName", theLastName), currentHashCode, theLastName);
        }
        {
            String theIdentificationNumber;
            theIdentificationNumber = this.getIdentificationNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "identificationNumber", theIdentificationNumber), currentHashCode, theIdentificationNumber);
        }
        {
            String theLegalName;
            theLegalName = this.getLegalName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalName", theLegalName), currentHashCode, theLegalName);
        }
        {
            String theRegistrationNumber;
            theRegistrationNumber = this.getRegistrationNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationNumber", theRegistrationNumber), currentHashCode, theRegistrationNumber);
        }
        {
            String theVAT;
            theVAT = this.getVAT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vat", theVAT), currentHashCode, theVAT);
        }
        {
            String theCity;
            theCity = this.getCity();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "city", theCity), currentHashCode, theCity);
        }
        {
            CodeRefType theCountry;
            theCountry = this.getCountry();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "country", theCountry), currentHashCode, theCountry);
        }
        {
            String theFELId;
            theFELId = this.getFELId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "felId", theFELId), currentHashCode, theFELId);
        }
        {
            Boolean theNormaliseSearch;
            theNormaliseSearch = this.isNormaliseSearch();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "normaliseSearch", theNormaliseSearch), currentHashCode, theNormaliseSearch);
        }
        {
            Integer theResultsLimit;
            theResultsLimit = this.getResultsLimit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultsLimit", theResultsLimit), currentHashCode, theResultsLimit);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
