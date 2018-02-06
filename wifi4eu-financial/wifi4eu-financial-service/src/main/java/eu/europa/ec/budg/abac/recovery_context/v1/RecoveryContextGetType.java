
package eu.europa.ec.budg.abac.recovery_context.v1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para RecoveryContextGetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RecoveryContextGetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CountryIso2Code" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}Iso2CodeType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowLevel" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowLevelType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowStatus" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowStatusType" minOccurs="0"/&gt;
 *         &lt;element name="DetectedByCode" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}DetectedByCodeType" minOccurs="0"/&gt;
 *         &lt;element name="DetectedByText" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}DetectedByTextType" minOccurs="0"/&gt;
 *         &lt;element name="Documents" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Document" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}DocumentType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="OlafCaseID" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}OlafCaseIDType" minOccurs="0"/&gt;
 *         &lt;element name="OlafNotificationDate" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}OlafNotificationDateType" minOccurs="0"/&gt;
 *         &lt;element name="QualificationCode" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}QualificationCodeType"/&gt;
 *         &lt;element name="YearOfCommitting" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}YearOfCommittingType" minOccurs="0"/&gt;
 *         &lt;element name="YearOfDetection" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}YearOfDetectionType" minOccurs="0"/&gt;
 *         &lt;element name="ErrorIrregularityTypes" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ErrorIrregularityType" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}ErrorIrregularityTypeType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecoveryContextGetType", propOrder = {
    "countryIso2Code",
    "currentWorkflowLevel",
    "currentWorkflowStatus",
    "detectedByCode",
    "detectedByText",
    "documents",
    "localKey",
    "olafCaseID",
    "olafNotificationDate",
    "qualificationCode",
    "yearOfCommitting",
    "yearOfDetection",
    "errorIrregularityTypes"
})
public class RecoveryContextGetType {

    @XmlElement(name = "CountryIso2Code")
    protected String countryIso2Code;
    @XmlElement(name = "CurrentWorkflowLevel")
    protected BigInteger currentWorkflowLevel;
    @XmlElement(name = "CurrentWorkflowStatus")
    protected String currentWorkflowStatus;
    @XmlElement(name = "DetectedByCode")
    protected String detectedByCode;
    @XmlElement(name = "DetectedByText")
    protected String detectedByText;
    @XmlElement(name = "Documents")
    protected Documents documents;
    @XmlElement(name = "LocalKey", required = true)
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
    @XmlElement(name = "ErrorIrregularityTypes")
    protected ErrorIrregularityTypes errorIrregularityTypes;

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
     * Obtiene el valor de la propiedad currentWorkflowLevel.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCurrentWorkflowLevel() {
        return currentWorkflowLevel;
    }

    /**
     * Define el valor de la propiedad currentWorkflowLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCurrentWorkflowLevel(BigInteger value) {
        this.currentWorkflowLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentWorkflowStatus() {
        return currentWorkflowStatus;
    }

    /**
     * Define el valor de la propiedad currentWorkflowStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentWorkflowStatus(String value) {
        this.currentWorkflowStatus = value;
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
     * Obtiene el valor de la propiedad documents.
     * 
     * @return
     *     possible object is
     *     {@link Documents }
     *     
     */
    public Documents getDocuments() {
        return documents;
    }

    /**
     * Define el valor de la propiedad documents.
     * 
     * @param value
     *     allowed object is
     *     {@link Documents }
     *     
     */
    public void setDocuments(Documents value) {
        this.documents = value;
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

    /**
     * Obtiene el valor de la propiedad errorIrregularityTypes.
     * 
     * @return
     *     possible object is
     *     {@link ErrorIrregularityTypes }
     *     
     */
    public ErrorIrregularityTypes getErrorIrregularityTypes() {
        return errorIrregularityTypes;
    }

    /**
     * Define el valor de la propiedad errorIrregularityTypes.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorIrregularityTypes }
     *     
     */
    public void setErrorIrregularityTypes(ErrorIrregularityTypes value) {
        this.errorIrregularityTypes = value;
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
     *         &lt;element name="Document" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}DocumentType" maxOccurs="unbounded"/&gt;
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
        "document"
    })
    public static class Documents {

        @XmlElement(name = "Document", required = true)
        protected List<DocumentType> document;

        /**
         * Gets the value of the document property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the document property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentType }
         * 
         * 
         */
        public List<DocumentType> getDocument() {
            if (document == null) {
                document = new ArrayList<DocumentType>();
            }
            return this.document;
        }

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
     *         &lt;element name="ErrorIrregularityType" type="{http://www.ec.europa.eu/budg/abac/recovery_context/v1}ErrorIrregularityTypeType" maxOccurs="unbounded"/&gt;
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
        "errorIrregularityType"
    })
    public static class ErrorIrregularityTypes {

        @XmlElement(name = "ErrorIrregularityType", required = true)
        protected List<ErrorIrregularityTypeType> errorIrregularityType;

        /**
         * Gets the value of the errorIrregularityType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the errorIrregularityType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getErrorIrregularityType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ErrorIrregularityTypeType }
         * 
         * 
         */
        public List<ErrorIrregularityTypeType> getErrorIrregularityType() {
            if (errorIrregularityType == null) {
                errorIrregularityType = new ArrayList<ErrorIrregularityTypeType>();
            }
            return this.errorIrregularityType;
        }

    }

}
