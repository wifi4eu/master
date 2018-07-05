
package wifi4eu.wifi4eu.service.exportImport.messageCall.lef;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para NaturalPersonGetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="NaturalPersonGetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntityGetType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BirthCountryCode" type="{http://www.ec.europa.eu/budg/abac/country/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="BirthDate" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}BirthDateType" minOccurs="0"/&gt;
 *         &lt;element name="DriverLicense" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}IdentificationDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="IdentityCard" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}IdentificationDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="FirstName" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}FirstNameType" minOccurs="0"/&gt;
 *         &lt;element name="NationalIdNumber" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}NationalIdentifyingNumberType" minOccurs="0"/&gt;
 *         &lt;element name="NationalIdIssuingCountryCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}Iso2CodeType" minOccurs="0"/&gt;
 *         &lt;element name="OtherIdentificationDocument" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}IdentificationDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="Passport" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}IdentificationDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="Title" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="LanguageCode" type="{http://www.ec.europa.eu/budg/abac/language/v1}CodeType"/&gt;
 *                   &lt;element name="TitleCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}TitleCodeType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaturalPersonGetType", propOrder = {
    "birthCountryCode",
    "birthDate",
    "driverLicense",
    "identityCard",
    "firstName",
    "nationalIdNumber",
    "nationalIdIssuingCountryCode",
    "otherIdentificationDocument",
    "passport",
    "title"
})
@XmlSeeAlso({
    PrivatePersonGetType.class,
    StaffMemberGetType.class
})
public abstract class NaturalPersonGetType
    extends LegalEntityGetType
{

    @XmlElement(name = "BirthCountryCode")
    protected String birthCountryCode;
    @XmlElement(name = "BirthDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(name = "DriverLicense")
    protected IdentificationDocumentType driverLicense;
    @XmlElement(name = "IdentityCard")
    protected IdentificationDocumentType identityCard;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "NationalIdNumber")
    protected String nationalIdNumber;
    @XmlElement(name = "NationalIdIssuingCountryCode")
    protected String nationalIdIssuingCountryCode;
    @XmlElement(name = "OtherIdentificationDocument")
    protected IdentificationDocumentType otherIdentificationDocument;
    @XmlElement(name = "Passport")
    protected IdentificationDocumentType passport;
    @XmlElement(name = "Title")
    protected Title title;

    /**
     * Obtiene el valor de la propiedad birthCountryCode.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBirthCountryCode() {
        return birthCountryCode;
    }

    /**
     * Define el valor de la propiedad birthCountryCode.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBirthCountryCode(String value) {
        this.birthCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad birthDate.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Define el valor de la propiedad birthDate.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Obtiene el valor de la propiedad driverLicense.
     *
     * @return
     *     possible object is
     *     {@link IdentificationDocumentType }
     *
     */
    public IdentificationDocumentType getDriverLicense() {
        return driverLicense;
    }

    /**
     * Define el valor de la propiedad driverLicense.
     *
     * @param value
     *     allowed object is
     *     {@link IdentificationDocumentType }
     *
     */
    public void setDriverLicense(IdentificationDocumentType value) {
        this.driverLicense = value;
    }

    /**
     * Obtiene el valor de la propiedad identityCard.
     *
     * @return
     *     possible object is
     *     {@link IdentificationDocumentType }
     *
     */
    public IdentificationDocumentType getIdentityCard() {
        return identityCard;
    }

    /**
     * Define el valor de la propiedad identityCard.
     *
     * @param value
     *     allowed object is
     *     {@link IdentificationDocumentType }
     *
     */
    public void setIdentityCard(IdentificationDocumentType value) {
        this.identityCard = value;
    }

    /**
     * Obtiene el valor de la propiedad firstName.
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
     * Define el valor de la propiedad firstName.
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
     * Obtiene el valor de la propiedad nationalIdNumber.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    /**
     * Define el valor de la propiedad nationalIdNumber.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNationalIdNumber(String value) {
        this.nationalIdNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad nationalIdIssuingCountryCode.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNationalIdIssuingCountryCode() {
        return nationalIdIssuingCountryCode;
    }

    /**
     * Define el valor de la propiedad nationalIdIssuingCountryCode.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNationalIdIssuingCountryCode(String value) {
        this.nationalIdIssuingCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad otherIdentificationDocument.
     *
     * @return
     *     possible object is
     *     {@link IdentificationDocumentType }
     *
     */
    public IdentificationDocumentType getOtherIdentificationDocument() {
        return otherIdentificationDocument;
    }

    /**
     * Define el valor de la propiedad otherIdentificationDocument.
     *
     * @param value
     *     allowed object is
     *     {@link IdentificationDocumentType }
     *
     */
    public void setOtherIdentificationDocument(IdentificationDocumentType value) {
        this.otherIdentificationDocument = value;
    }

    /**
     * Obtiene el valor de la propiedad passport.
     *
     * @return
     *     possible object is
     *     {@link IdentificationDocumentType }
     *
     */
    public IdentificationDocumentType getPassport() {
        return passport;
    }

    /**
     * Define el valor de la propiedad passport.
     *
     * @param value
     *     allowed object is
     *     {@link IdentificationDocumentType }
     *     
     */
    public void setPassport(IdentificationDocumentType value) {
        this.passport = value;
    }

    /**
     * Obtiene el valor de la propiedad title.
     * 
     * @return
     *     possible object is
     *     {@link Title }
     *     
     */
    public Title getTitle() {
        return title;
    }

    /**
     * Define el valor de la propiedad title.
     * 
     * @param value
     *     allowed object is
     *     {@link Title }
     *     
     */
    public void setTitle(Title value) {
        this.title = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="LanguageCode" type="{http://www.ec.europa.eu/budg/abac/language/v1}CodeType"/&gt;
     *         &lt;element name="TitleCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}TitleCodeType"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "languageCode",
        "titleCode"
    })
    public static class Title {

        @XmlElement(name = "LanguageCode", required = true)
        protected String languageCode;
        @XmlElement(name = "TitleCode", required = true)
        protected String titleCode;

        /**
         * Obtiene el valor de la propiedad languageCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLanguageCode() {
            return languageCode;
        }

        /**
         * Define el valor de la propiedad languageCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLanguageCode(String value) {
            this.languageCode = value;
        }

        /**
         * Obtiene el valor de la propiedad titleCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitleCode() {
            return titleCode;
        }

        /**
         * Define el valor de la propiedad titleCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitleCode(String value) {
            this.titleCode = value;
        }

    }

}
