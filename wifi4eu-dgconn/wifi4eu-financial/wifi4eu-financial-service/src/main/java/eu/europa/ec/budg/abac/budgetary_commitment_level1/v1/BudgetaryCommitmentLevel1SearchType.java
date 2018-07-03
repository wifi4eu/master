
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel1SearchType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel1SearchType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="CentralStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowLevel" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowLevelType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowStatus" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowStatusType" minOccurs="0"/&gt;
 *         &lt;element name="ClassCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserReference" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}UserReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyIso3Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrentBudgetYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WorkflowOrganisation" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowOrganisationNameType" minOccurs="0"/&gt;
 *         &lt;element name="WorkflowCentre" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowCenterCodeType" minOccurs="0"/&gt;
 *         &lt;element name="FileReference" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}FileReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="Project" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}ProjectType" minOccurs="0"/&gt;
 *         &lt;element name="CreationDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}CreationDateType"/&gt;
 *         &lt;element name="CreationUser" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}CreationUserType"/&gt;
 *         &lt;element name="ModificationDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}ModificationDateType"/&gt;
 *         &lt;element name="ModificationUser" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}ModificationUserType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel1SearchType", propOrder = {
    "localKey",
    "centralStatus",
    "currentWorkflowLevel",
    "currentWorkflowStatus",
    "classCode",
    "userReference",
    "currencyIso3Code",
    "currentBudgetYear",
    "workflowOrganisation",
    "workflowCentre",
    "fileReference",
    "project",
    "creationDate",
    "creationUser",
    "modificationDate",
    "modificationUser"
})
public class BudgetaryCommitmentLevel1SearchType {

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "CentralStatus")
    protected String centralStatus;
    @XmlElement(name = "CurrentWorkflowLevel")
    protected BigInteger currentWorkflowLevel;
    @XmlElement(name = "CurrentWorkflowStatus")
    protected String currentWorkflowStatus;
    @XmlElement(name = "ClassCode")
    protected String classCode;
    @XmlElement(name = "UserReference")
    protected String userReference;
    @XmlElement(name = "CurrencyIso3Code")
    protected String currencyIso3Code;
    @XmlElement(name = "CurrentBudgetYear")
    protected String currentBudgetYear;
    @XmlElement(name = "WorkflowOrganisation")
    protected String workflowOrganisation;
    @XmlElement(name = "WorkflowCentre")
    protected String workflowCentre;
    @XmlElement(name = "FileReference")
    protected String fileReference;
    @XmlElement(name = "Project")
    protected String project;
    @XmlElement(name = "CreationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "CreationUser", required = true)
    protected String creationUser;
    @XmlElement(name = "ModificationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modificationDate;
    @XmlElement(name = "ModificationUser", required = true)
    protected String modificationUser;

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
     * Obtiene el valor de la propiedad centralStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentralStatus() {
        return centralStatus;
    }

    /**
     * Define el valor de la propiedad centralStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentralStatus(String value) {
        this.centralStatus = value;
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
     * Obtiene el valor de la propiedad classCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * Define el valor de la propiedad classCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassCode(String value) {
        this.classCode = value;
    }

    /**
     * Obtiene el valor de la propiedad userReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserReference() {
        return userReference;
    }

    /**
     * Define el valor de la propiedad userReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserReference(String value) {
        this.userReference = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyIso3Code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyIso3Code() {
        return currencyIso3Code;
    }

    /**
     * Define el valor de la propiedad currencyIso3Code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyIso3Code(String value) {
        this.currencyIso3Code = value;
    }

    /**
     * Obtiene el valor de la propiedad currentBudgetYear.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentBudgetYear() {
        return currentBudgetYear;
    }

    /**
     * Define el valor de la propiedad currentBudgetYear.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentBudgetYear(String value) {
        this.currentBudgetYear = value;
    }

    /**
     * Obtiene el valor de la propiedad workflowOrganisation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowOrganisation() {
        return workflowOrganisation;
    }

    /**
     * Define el valor de la propiedad workflowOrganisation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowOrganisation(String value) {
        this.workflowOrganisation = value;
    }

    /**
     * Obtiene el valor de la propiedad workflowCentre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowCentre() {
        return workflowCentre;
    }

    /**
     * Define el valor de la propiedad workflowCentre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowCentre(String value) {
        this.workflowCentre = value;
    }

    /**
     * Obtiene el valor de la propiedad fileReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileReference() {
        return fileReference;
    }

    /**
     * Define el valor de la propiedad fileReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileReference(String value) {
        this.fileReference = value;
    }

    /**
     * Obtiene el valor de la propiedad project.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProject() {
        return project;
    }

    /**
     * Define el valor de la propiedad project.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProject(String value) {
        this.project = value;
    }

    /**
     * Obtiene el valor de la propiedad creationDate.
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
     * Define el valor de la propiedad creationDate.
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
     * Obtiene el valor de la propiedad creationUser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationUser() {
        return creationUser;
    }

    /**
     * Define el valor de la propiedad creationUser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationUser(String value) {
        this.creationUser = value;
    }

    /**
     * Obtiene el valor de la propiedad modificationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModificationDate() {
        return modificationDate;
    }

    /**
     * Define el valor de la propiedad modificationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModificationDate(XMLGregorianCalendar value) {
        this.modificationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad modificationUser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModificationUser() {
        return modificationUser;
    }

    /**
     * Define el valor de la propiedad modificationUser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModificationUser(String value) {
        this.modificationUser = value;
    }

}
