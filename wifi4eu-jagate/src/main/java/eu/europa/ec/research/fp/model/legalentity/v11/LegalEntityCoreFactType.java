
package eu.europa.ec.research.fp.model.legalentity.v11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import generated.jagate.model.address.v4.AddressType;
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
 * <p>Java class for LegalEntityCoreFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityCoreFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LegalStatus" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}LegalEntityStatusType"/>
 *         &lt;element name="LegalEntityType" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}LegalEntityTypeType"/>
 *         &lt;element name="LegalNonProfit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NGO" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ABACLegalForm" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="DepartmentWithDelegatedAuthority" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LegalName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BusinessName">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="NotAvailable" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" default="false" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="VAT">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="NotApplicable" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" default="false" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RegistrationData">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="LegalRegistration" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}LegalRegistrationType" minOccurs="0"/>
 *                   &lt;element name="IndividualRegistration" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}IndividualRegistrationType" minOccurs="0"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FELId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LegalAddress" type="{http://ec.europa.eu/research/fp/model/address/V4}AddressType"/>
 *         &lt;element name="OfficialLanguage" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityCoreFactType", propOrder = {
    "legalStatus",
    "legalEntityType",
    "legalNonProfit",
    "ngo",
    "abacLegalForm",
    "departmentWithDelegatedAuthority",
    "legalName",
    "businessName",
    "vat",
    "registrationData",
    "felId",
    "legalAddress",
    "officialLanguage"
})
public class LegalEntityCoreFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LegalStatus", required = true)
    protected String legalStatus;
    @XmlElement(name = "LegalEntityType", required = true)
    protected String legalEntityType;
    @XmlElement(name = "LegalNonProfit")
    protected boolean legalNonProfit;
    @XmlElement(name = "NGO")
    protected boolean ngo;
    @XmlElement(name = "ABACLegalForm", required = true)
    protected CodeRefType abacLegalForm;
    @XmlElement(name = "DepartmentWithDelegatedAuthority")
    protected boolean departmentWithDelegatedAuthority;
    @XmlElement(name = "LegalName", required = true)
    protected String legalName;
    @XmlElement(name = "BusinessName", required = true)
    protected LegalEntityCoreFactType.BusinessName businessName;
    @XmlElement(name = "VAT", required = true)
    protected LegalEntityCoreFactType.VAT vat;
    @XmlElement(name = "RegistrationData", required = true)
    protected LegalEntityCoreFactType.RegistrationData registrationData;
    @XmlElement(name = "FELId")
    protected String felId;
    @XmlElement(name = "LegalAddress", required = true)
    protected AddressType legalAddress;
    @XmlElement(name = "OfficialLanguage")
    protected CodeRefType officialLanguage;

    /**
     * Gets the value of the legalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalStatus() {
        return legalStatus;
    }

    /**
     * Sets the value of the legalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalStatus(String value) {
        this.legalStatus = value;
    }

    /**
     * Gets the value of the legalEntityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityType() {
        return legalEntityType;
    }

    /**
     * Sets the value of the legalEntityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityType(String value) {
        this.legalEntityType = value;
    }

    /**
     * Gets the value of the legalNonProfit property.
     * 
     */
    public boolean isLegalNonProfit() {
        return legalNonProfit;
    }

    /**
     * Sets the value of the legalNonProfit property.
     * 
     */
    public void setLegalNonProfit(boolean value) {
        this.legalNonProfit = value;
    }

    /**
     * Gets the value of the ngo property.
     * 
     */
    public boolean isNGO() {
        return ngo;
    }

    /**
     * Sets the value of the ngo property.
     * 
     */
    public void setNGO(boolean value) {
        this.ngo = value;
    }

    /**
     * Gets the value of the abacLegalForm property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getABACLegalForm() {
        return abacLegalForm;
    }

    /**
     * Sets the value of the abacLegalForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setABACLegalForm(CodeRefType value) {
        this.abacLegalForm = value;
    }

    /**
     * Gets the value of the departmentWithDelegatedAuthority property.
     * 
     */
    public boolean isDepartmentWithDelegatedAuthority() {
        return departmentWithDelegatedAuthority;
    }

    /**
     * Sets the value of the departmentWithDelegatedAuthority property.
     * 
     */
    public void setDepartmentWithDelegatedAuthority(boolean value) {
        this.departmentWithDelegatedAuthority = value;
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
     * Gets the value of the businessName property.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityCoreFactType.BusinessName }
     *     
     */
    public LegalEntityCoreFactType.BusinessName getBusinessName() {
        return businessName;
    }

    /**
     * Sets the value of the businessName property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityCoreFactType.BusinessName }
     *     
     */
    public void setBusinessName(LegalEntityCoreFactType.BusinessName value) {
        this.businessName = value;
    }

    /**
     * Gets the value of the vat property.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityCoreFactType.VAT }
     *     
     */
    public LegalEntityCoreFactType.VAT getVAT() {
        return vat;
    }

    /**
     * Sets the value of the vat property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityCoreFactType.VAT }
     *     
     */
    public void setVAT(LegalEntityCoreFactType.VAT value) {
        this.vat = value;
    }

    /**
     * Gets the value of the registrationData property.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityCoreFactType.RegistrationData }
     *     
     */
    public LegalEntityCoreFactType.RegistrationData getRegistrationData() {
        return registrationData;
    }

    /**
     * Sets the value of the registrationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityCoreFactType.RegistrationData }
     *     
     */
    public void setRegistrationData(LegalEntityCoreFactType.RegistrationData value) {
        this.registrationData = value;
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
     * Gets the value of the legalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getLegalAddress() {
        return legalAddress;
    }

    /**
     * Sets the value of the legalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setLegalAddress(AddressType value) {
        this.legalAddress = value;
    }

    /**
     * Gets the value of the officialLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getOfficialLanguage() {
        return officialLanguage;
    }

    /**
     * Sets the value of the officialLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setOfficialLanguage(CodeRefType value) {
        this.officialLanguage = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LegalEntityCoreFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LegalEntityCoreFactType that = ((LegalEntityCoreFactType) object);
        {
            String lhsLegalStatus;
            lhsLegalStatus = this.getLegalStatus();
            String rhsLegalStatus;
            rhsLegalStatus = that.getLegalStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalStatus", lhsLegalStatus), LocatorUtils.property(thatLocator, "legalStatus", rhsLegalStatus), lhsLegalStatus, rhsLegalStatus)) {
                return false;
            }
        }
        {
            String lhsLegalEntityType;
            lhsLegalEntityType = this.getLegalEntityType();
            String rhsLegalEntityType;
            rhsLegalEntityType = that.getLegalEntityType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalEntityType", lhsLegalEntityType), LocatorUtils.property(thatLocator, "legalEntityType", rhsLegalEntityType), lhsLegalEntityType, rhsLegalEntityType)) {
                return false;
            }
        }
        {
            boolean lhsLegalNonProfit;
            lhsLegalNonProfit = (true?this.isLegalNonProfit():false);
            boolean rhsLegalNonProfit;
            rhsLegalNonProfit = (true?that.isLegalNonProfit():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalNonProfit", lhsLegalNonProfit), LocatorUtils.property(thatLocator, "legalNonProfit", rhsLegalNonProfit), lhsLegalNonProfit, rhsLegalNonProfit)) {
                return false;
            }
        }
        {
            boolean lhsNGO;
            lhsNGO = (true?this.isNGO():false);
            boolean rhsNGO;
            rhsNGO = (true?that.isNGO():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ngo", lhsNGO), LocatorUtils.property(thatLocator, "ngo", rhsNGO), lhsNGO, rhsNGO)) {
                return false;
            }
        }
        {
            CodeRefType lhsABACLegalForm;
            lhsABACLegalForm = this.getABACLegalForm();
            CodeRefType rhsABACLegalForm;
            rhsABACLegalForm = that.getABACLegalForm();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "abacLegalForm", lhsABACLegalForm), LocatorUtils.property(thatLocator, "abacLegalForm", rhsABACLegalForm), lhsABACLegalForm, rhsABACLegalForm)) {
                return false;
            }
        }
        {
            boolean lhsDepartmentWithDelegatedAuthority;
            lhsDepartmentWithDelegatedAuthority = (true?this.isDepartmentWithDelegatedAuthority():false);
            boolean rhsDepartmentWithDelegatedAuthority;
            rhsDepartmentWithDelegatedAuthority = (true?that.isDepartmentWithDelegatedAuthority():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "departmentWithDelegatedAuthority", lhsDepartmentWithDelegatedAuthority), LocatorUtils.property(thatLocator, "departmentWithDelegatedAuthority", rhsDepartmentWithDelegatedAuthority), lhsDepartmentWithDelegatedAuthority, rhsDepartmentWithDelegatedAuthority)) {
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
            LegalEntityCoreFactType.BusinessName lhsBusinessName;
            lhsBusinessName = this.getBusinessName();
            LegalEntityCoreFactType.BusinessName rhsBusinessName;
            rhsBusinessName = that.getBusinessName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "businessName", lhsBusinessName), LocatorUtils.property(thatLocator, "businessName", rhsBusinessName), lhsBusinessName, rhsBusinessName)) {
                return false;
            }
        }
        {
            LegalEntityCoreFactType.VAT lhsVAT;
            lhsVAT = this.getVAT();
            LegalEntityCoreFactType.VAT rhsVAT;
            rhsVAT = that.getVAT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vat", lhsVAT), LocatorUtils.property(thatLocator, "vat", rhsVAT), lhsVAT, rhsVAT)) {
                return false;
            }
        }
        {
            LegalEntityCoreFactType.RegistrationData lhsRegistrationData;
            lhsRegistrationData = this.getRegistrationData();
            LegalEntityCoreFactType.RegistrationData rhsRegistrationData;
            rhsRegistrationData = that.getRegistrationData();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "registrationData", lhsRegistrationData), LocatorUtils.property(thatLocator, "registrationData", rhsRegistrationData), lhsRegistrationData, rhsRegistrationData)) {
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
            AddressType lhsLegalAddress;
            lhsLegalAddress = this.getLegalAddress();
            AddressType rhsLegalAddress;
            rhsLegalAddress = that.getLegalAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "legalAddress", lhsLegalAddress), LocatorUtils.property(thatLocator, "legalAddress", rhsLegalAddress), lhsLegalAddress, rhsLegalAddress)) {
                return false;
            }
        }
        {
            CodeRefType lhsOfficialLanguage;
            lhsOfficialLanguage = this.getOfficialLanguage();
            CodeRefType rhsOfficialLanguage;
            rhsOfficialLanguage = that.getOfficialLanguage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "officialLanguage", lhsOfficialLanguage), LocatorUtils.property(thatLocator, "officialLanguage", rhsOfficialLanguage), lhsOfficialLanguage, rhsOfficialLanguage)) {
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
            String theLegalStatus;
            theLegalStatus = this.getLegalStatus();
            strategy.appendField(locator, this, "legalStatus", buffer, theLegalStatus);
        }
        {
            String theLegalEntityType;
            theLegalEntityType = this.getLegalEntityType();
            strategy.appendField(locator, this, "legalEntityType", buffer, theLegalEntityType);
        }
        {
            boolean theLegalNonProfit;
            theLegalNonProfit = (true?this.isLegalNonProfit():false);
            strategy.appendField(locator, this, "legalNonProfit", buffer, theLegalNonProfit);
        }
        {
            boolean theNGO;
            theNGO = (true?this.isNGO():false);
            strategy.appendField(locator, this, "ngo", buffer, theNGO);
        }
        {
            CodeRefType theABACLegalForm;
            theABACLegalForm = this.getABACLegalForm();
            strategy.appendField(locator, this, "abacLegalForm", buffer, theABACLegalForm);
        }
        {
            boolean theDepartmentWithDelegatedAuthority;
            theDepartmentWithDelegatedAuthority = (true?this.isDepartmentWithDelegatedAuthority():false);
            strategy.appendField(locator, this, "departmentWithDelegatedAuthority", buffer, theDepartmentWithDelegatedAuthority);
        }
        {
            String theLegalName;
            theLegalName = this.getLegalName();
            strategy.appendField(locator, this, "legalName", buffer, theLegalName);
        }
        {
            LegalEntityCoreFactType.BusinessName theBusinessName;
            theBusinessName = this.getBusinessName();
            strategy.appendField(locator, this, "businessName", buffer, theBusinessName);
        }
        {
            LegalEntityCoreFactType.VAT theVAT;
            theVAT = this.getVAT();
            strategy.appendField(locator, this, "vat", buffer, theVAT);
        }
        {
            LegalEntityCoreFactType.RegistrationData theRegistrationData;
            theRegistrationData = this.getRegistrationData();
            strategy.appendField(locator, this, "registrationData", buffer, theRegistrationData);
        }
        {
            String theFELId;
            theFELId = this.getFELId();
            strategy.appendField(locator, this, "felId", buffer, theFELId);
        }
        {
            AddressType theLegalAddress;
            theLegalAddress = this.getLegalAddress();
            strategy.appendField(locator, this, "legalAddress", buffer, theLegalAddress);
        }
        {
            CodeRefType theOfficialLanguage;
            theOfficialLanguage = this.getOfficialLanguage();
            strategy.appendField(locator, this, "officialLanguage", buffer, theOfficialLanguage);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theLegalStatus;
            theLegalStatus = this.getLegalStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalStatus", theLegalStatus), currentHashCode, theLegalStatus);
        }
        {
            String theLegalEntityType;
            theLegalEntityType = this.getLegalEntityType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalEntityType", theLegalEntityType), currentHashCode, theLegalEntityType);
        }
        {
            boolean theLegalNonProfit;
            theLegalNonProfit = (true?this.isLegalNonProfit():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalNonProfit", theLegalNonProfit), currentHashCode, theLegalNonProfit);
        }
        {
            boolean theNGO;
            theNGO = (true?this.isNGO():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ngo", theNGO), currentHashCode, theNGO);
        }
        {
            CodeRefType theABACLegalForm;
            theABACLegalForm = this.getABACLegalForm();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "abacLegalForm", theABACLegalForm), currentHashCode, theABACLegalForm);
        }
        {
            boolean theDepartmentWithDelegatedAuthority;
            theDepartmentWithDelegatedAuthority = (true?this.isDepartmentWithDelegatedAuthority():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "departmentWithDelegatedAuthority", theDepartmentWithDelegatedAuthority), currentHashCode, theDepartmentWithDelegatedAuthority);
        }
        {
            String theLegalName;
            theLegalName = this.getLegalName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalName", theLegalName), currentHashCode, theLegalName);
        }
        {
            LegalEntityCoreFactType.BusinessName theBusinessName;
            theBusinessName = this.getBusinessName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "businessName", theBusinessName), currentHashCode, theBusinessName);
        }
        {
            LegalEntityCoreFactType.VAT theVAT;
            theVAT = this.getVAT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vat", theVAT), currentHashCode, theVAT);
        }
        {
            LegalEntityCoreFactType.RegistrationData theRegistrationData;
            theRegistrationData = this.getRegistrationData();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registrationData", theRegistrationData), currentHashCode, theRegistrationData);
        }
        {
            String theFELId;
            theFELId = this.getFELId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "felId", theFELId), currentHashCode, theFELId);
        }
        {
            AddressType theLegalAddress;
            theLegalAddress = this.getLegalAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalAddress", theLegalAddress), currentHashCode, theLegalAddress);
        }
        {
            CodeRefType theOfficialLanguage;
            theOfficialLanguage = this.getOfficialLanguage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "officialLanguage", theOfficialLanguage), currentHashCode, theOfficialLanguage);
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
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="NotAvailable" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" default="false" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class BusinessName
        implements Equals, HashCode, ToString
    {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "NotAvailable")
        @XmlSchemaType(name = "anySimpleType")
        protected String notAvailable;

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

        /**
         * Gets the value of the notAvailable property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotAvailable() {
            if (notAvailable == null) {
                return "false";
            } else {
                return notAvailable;
            }
        }

        /**
         * Sets the value of the notAvailable property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotAvailable(String value) {
            this.notAvailable = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof LegalEntityCoreFactType.BusinessName)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final LegalEntityCoreFactType.BusinessName that = ((LegalEntityCoreFactType.BusinessName) object);
            {
                String lhsValue;
                lhsValue = this.getValue();
                String rhsValue;
                rhsValue = that.getValue();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "value", lhsValue), LocatorUtils.property(thatLocator, "value", rhsValue), lhsValue, rhsValue)) {
                    return false;
                }
            }
            {
                String lhsNotAvailable;
                lhsNotAvailable = this.getNotAvailable();
                String rhsNotAvailable;
                rhsNotAvailable = that.getNotAvailable();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "notAvailable", lhsNotAvailable), LocatorUtils.property(thatLocator, "notAvailable", rhsNotAvailable), lhsNotAvailable, rhsNotAvailable)) {
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
                String theValue;
                theValue = this.getValue();
                strategy.appendField(locator, this, "value", buffer, theValue);
            }
            {
                String theNotAvailable;
                theNotAvailable = this.getNotAvailable();
                strategy.appendField(locator, this, "notAvailable", buffer, theNotAvailable);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theValue;
                theValue = this.getValue();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "value", theValue), currentHashCode, theValue);
            }
            {
                String theNotAvailable;
                theNotAvailable = this.getNotAvailable();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "notAvailable", theNotAvailable), currentHashCode, theNotAvailable);
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
     *       &lt;choice>
     *         &lt;element name="LegalRegistration" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}LegalRegistrationType" minOccurs="0"/>
     *         &lt;element name="IndividualRegistration" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}IndividualRegistrationType" minOccurs="0"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "legalRegistration",
        "individualRegistration"
    })
    public static class RegistrationData
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "LegalRegistration")
        protected LegalRegistrationType legalRegistration;
        @XmlElement(name = "IndividualRegistration")
        protected IndividualRegistrationType individualRegistration;

        /**
         * Gets the value of the legalRegistration property.
         * 
         * @return
         *     possible object is
         *     {@link LegalRegistrationType }
         *     
         */
        public LegalRegistrationType getLegalRegistration() {
            return legalRegistration;
        }

        /**
         * Sets the value of the legalRegistration property.
         * 
         * @param value
         *     allowed object is
         *     {@link LegalRegistrationType }
         *     
         */
        public void setLegalRegistration(LegalRegistrationType value) {
            this.legalRegistration = value;
        }

        /**
         * Gets the value of the individualRegistration property.
         * 
         * @return
         *     possible object is
         *     {@link IndividualRegistrationType }
         *     
         */
        public IndividualRegistrationType getIndividualRegistration() {
            return individualRegistration;
        }

        /**
         * Sets the value of the individualRegistration property.
         * 
         * @param value
         *     allowed object is
         *     {@link IndividualRegistrationType }
         *     
         */
        public void setIndividualRegistration(IndividualRegistrationType value) {
            this.individualRegistration = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof LegalEntityCoreFactType.RegistrationData)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final LegalEntityCoreFactType.RegistrationData that = ((LegalEntityCoreFactType.RegistrationData) object);
            {
                LegalRegistrationType lhsLegalRegistration;
                lhsLegalRegistration = this.getLegalRegistration();
                LegalRegistrationType rhsLegalRegistration;
                rhsLegalRegistration = that.getLegalRegistration();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "legalRegistration", lhsLegalRegistration), LocatorUtils.property(thatLocator, "legalRegistration", rhsLegalRegistration), lhsLegalRegistration, rhsLegalRegistration)) {
                    return false;
                }
            }
            {
                IndividualRegistrationType lhsIndividualRegistration;
                lhsIndividualRegistration = this.getIndividualRegistration();
                IndividualRegistrationType rhsIndividualRegistration;
                rhsIndividualRegistration = that.getIndividualRegistration();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "individualRegistration", lhsIndividualRegistration), LocatorUtils.property(thatLocator, "individualRegistration", rhsIndividualRegistration), lhsIndividualRegistration, rhsIndividualRegistration)) {
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
                LegalRegistrationType theLegalRegistration;
                theLegalRegistration = this.getLegalRegistration();
                strategy.appendField(locator, this, "legalRegistration", buffer, theLegalRegistration);
            }
            {
                IndividualRegistrationType theIndividualRegistration;
                theIndividualRegistration = this.getIndividualRegistration();
                strategy.appendField(locator, this, "individualRegistration", buffer, theIndividualRegistration);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                LegalRegistrationType theLegalRegistration;
                theLegalRegistration = this.getLegalRegistration();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "legalRegistration", theLegalRegistration), currentHashCode, theLegalRegistration);
            }
            {
                IndividualRegistrationType theIndividualRegistration;
                theIndividualRegistration = this.getIndividualRegistration();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "individualRegistration", theIndividualRegistration), currentHashCode, theIndividualRegistration);
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
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="NotApplicable" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" default="false" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class VAT
        implements Equals, HashCode, ToString
    {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "NotApplicable")
        @XmlSchemaType(name = "anySimpleType")
        protected String notApplicable;

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

        /**
         * Gets the value of the notApplicable property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotApplicable() {
            if (notApplicable == null) {
                return "false";
            } else {
                return notApplicable;
            }
        }

        /**
         * Sets the value of the notApplicable property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotApplicable(String value) {
            this.notApplicable = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof LegalEntityCoreFactType.VAT)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final LegalEntityCoreFactType.VAT that = ((LegalEntityCoreFactType.VAT) object);
            {
                String lhsValue;
                lhsValue = this.getValue();
                String rhsValue;
                rhsValue = that.getValue();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "value", lhsValue), LocatorUtils.property(thatLocator, "value", rhsValue), lhsValue, rhsValue)) {
                    return false;
                }
            }
            {
                String lhsNotApplicable;
                lhsNotApplicable = this.getNotApplicable();
                String rhsNotApplicable;
                rhsNotApplicable = that.getNotApplicable();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "notApplicable", lhsNotApplicable), LocatorUtils.property(thatLocator, "notApplicable", rhsNotApplicable), lhsNotApplicable, rhsNotApplicable)) {
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
                String theValue;
                theValue = this.getValue();
                strategy.appendField(locator, this, "value", buffer, theValue);
            }
            {
                String theNotApplicable;
                theNotApplicable = this.getNotApplicable();
                strategy.appendField(locator, this, "notApplicable", buffer, theNotApplicable);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theValue;
                theValue = this.getValue();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "value", theValue), currentHashCode, theValue);
            }
            {
                String theNotApplicable;
                theNotApplicable = this.getNotApplicable();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "notApplicable", theNotApplicable), currentHashCode, theNotApplicable);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
