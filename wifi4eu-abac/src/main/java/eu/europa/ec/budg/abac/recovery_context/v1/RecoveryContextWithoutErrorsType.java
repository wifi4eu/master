
package eu.europa.ec.budg.abac.recovery_context.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para RecoveryContextWithoutErrorsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RecoveryContextWithoutErrorsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CountryIso2Code" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}Iso2CodeType" minOccurs="0"/&gt;
 *         &lt;element name="DetectedByCode" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}DetectedByCodeType" minOccurs="0"/&gt;
 *         &lt;element name="DetectedByText" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}DetectedByTextType" minOccurs="0"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="OlafCaseID" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}OlafCaseIDType" minOccurs="0"/&gt;
 *         &lt;element name="OlafNotificationDate" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}OlafNotificationDateType" minOccurs="0"/&gt;
 *         &lt;element name="QualificationCode" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}QualificationCodeType"/&gt;
 *         &lt;element name="YearOfCommitting" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}YearOfCommittingType" minOccurs="0"/&gt;
 *         &lt;element name="YearOfDetection" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}YearOfDetectionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecoveryContextWithoutErrorsType", propOrder = {
    "countryIso2Code",
    "detectedByCode",
    "detectedByText",
    "localKey",
    "olafCaseID",
    "olafNotificationDate",
    "qualificationCode",
    "yearOfCommitting",
    "yearOfDetection"
})
@XmlSeeAlso({
    RecoveryContextType.class
})
public class RecoveryContextWithoutErrorsType {

    @XmlElement(name = "CountryIso2Code")
    protected String countryIso2Code;
    @XmlElement(name = "DetectedByCode")
    protected String detectedByCode;
    @XmlElement(name = "DetectedByText")
    protected String detectedByText;
    @XmlElement(name = "LocalKey")
    protected String localKey;
    @XmlElement(name = "OlafCaseID")
    protected String olafCaseID;
    @XmlElement(name = "OlafNotificationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar olafNotificationDate;
    @XmlElement(name = "QualificationCode", required = true)
    protected String qualificationCode;
    @XmlElement(name = "YearOfCommitting")
    protected BigInteger yearOfCommitting;
    @XmlElement(name = "YearOfDetection")
    protected BigInteger yearOfDetection;

    /**
     * Obtiene el valor de la propiedad countryIso2Code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryIso2Code() {
        return countryIso2Code;
    }

    /**
     * Define el valor de la propiedad countryIso2Code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryIso2Code(String value) {
        this.countryIso2Code = value;
    }

    /**
     * Obtiene el valor de la propiedad detectedByCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetectedByCode() {
        return detectedByCode;
    }

    /**
     * Define el valor de la propiedad detectedByCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetectedByCode(String value) {
        this.detectedByCode = value;
    }

    /**
     * Obtiene el valor de la propiedad detectedByText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetectedByText() {
        return detectedByText;
    }

    /**
     * Define el valor de la propiedad detectedByText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetectedByText(String value) {
        this.detectedByText = value;
    }

    /**
     * Obtiene el valor de la propiedad localKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalKey() {
        return localKey;
    }

    /**
     * Define el valor de la propiedad localKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalKey(String value) {
        this.localKey = value;
    }

    /**
     * Obtiene el valor de la propiedad olafCaseID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOlafCaseID() {
        return olafCaseID;
    }

    /**
     * Define el valor de la propiedad olafCaseID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOlafCaseID(String value) {
        this.olafCaseID = value;
    }

    /**
     * Obtiene el valor de la propiedad olafNotificationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOlafNotificationDate() {
        return olafNotificationDate;
    }

    /**
     * Define el valor de la propiedad olafNotificationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOlafNotificationDate(XMLGregorianCalendar value) {
        this.olafNotificationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad qualificationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualificationCode() {
        return qualificationCode;
    }

    /**
     * Define el valor de la propiedad qualificationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualificationCode(String value) {
        this.qualificationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad yearOfCommitting.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYearOfCommitting() {
        return yearOfCommitting;
    }

    /**
     * Define el valor de la propiedad yearOfCommitting.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYearOfCommitting(BigInteger value) {
        this.yearOfCommitting = value;
    }

    /**
     * Obtiene el valor de la propiedad yearOfDetection.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYearOfDetection() {
        return yearOfDetection;
    }

    /**
     * Define el valor de la propiedad yearOfDetection.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYearOfDetection(BigInteger value) {
        this.yearOfDetection = value;
    }

}
