
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.search_criterion.v1.DateCriterionType;
import eu.europa.ec.budg.abac.search_criterion.v1.IndicatorCriterionType;
import eu.europa.ec.budg.abac.search_criterion.v1.NumberCriterionType;
import eu.europa.ec.budg.abac.search_criterion.v1.TextCriterionType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel1SearchCriteriaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel1SearchCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AcceptedAmountInCurrency" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="AppropriationLocalKey" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="BlockedFlag" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}IndicatorCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetCompanyCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CentralKey" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CentralStatus" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ClassCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ContractorReferenceLocalKey" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CreationDate" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}DateCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CreationUser" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentBudgetYear" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowLevel" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}NumberCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowOrganisation" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowStatus" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriteriaCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriteriaTypeCode" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="FileReference" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="LegalEntityLocalKey" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="Lot" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ModificationDate" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}DateCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ModificationUser" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="PostingCriterionLocalKey" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="Project" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisationName" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleUsers" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *         &lt;element name="UserReference" type="{http://www.ec.europa.eu/budg/abac/search_criterion/v1}TextCriterionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel1SearchCriteriaType", propOrder = {
    "acceptedAmountInCurrency",
    "appropriationLocalKey",
    "blockedFlag",
    "budgetCompanyCode",
    "centralKey",
    "centralStatus",
    "classCode",
    "contractorReferenceLocalKey",
    "creationDate",
    "creationUser",
    "currentBudgetYear",
    "currentWorkflowLevel",
    "currentWorkflowOrganisation",
    "currentWorkflowStatus",
    "externalCriteriaCode",
    "externalCriteriaTypeCode",
    "fileReference",
    "legalEntityLocalKey",
    "localKey",
    "lot",
    "modificationDate",
    "modificationUser",
    "postingCriterionLocalKey",
    "project",
    "responsibleOrganisationName",
    "responsibleUsers",
    "userReference"
})
public class BudgetaryCommitmentLevel1SearchCriteriaType {

    @XmlElement(name = "AcceptedAmountInCurrency")
    protected TextCriterionType acceptedAmountInCurrency;
    @XmlElement(name = "AppropriationLocalKey")
    protected TextCriterionType appropriationLocalKey;
    @XmlElement(name = "BlockedFlag")
    protected IndicatorCriterionType blockedFlag;
    @XmlElement(name = "BudgetCompanyCode")
    protected TextCriterionType budgetCompanyCode;
    @XmlElement(name = "CentralKey")
    protected TextCriterionType centralKey;
    @XmlElement(name = "CentralStatus")
    protected TextCriterionType centralStatus;
    @XmlElement(name = "ClassCode")
    protected TextCriterionType classCode;
    @XmlElement(name = "ContractorReferenceLocalKey")
    protected TextCriterionType contractorReferenceLocalKey;
    @XmlElement(name = "CreationDate")
    protected DateCriterionType creationDate;
    @XmlElement(name = "CreationUser")
    protected TextCriterionType creationUser;
    @XmlElement(name = "CurrentBudgetYear")
    protected TextCriterionType currentBudgetYear;
    @XmlElement(name = "CurrentWorkflowLevel")
    protected NumberCriterionType currentWorkflowLevel;
    @XmlElement(name = "CurrentWorkflowOrganisation")
    protected TextCriterionType currentWorkflowOrganisation;
    @XmlElement(name = "CurrentWorkflowStatus")
    protected TextCriterionType currentWorkflowStatus;
    @XmlElement(name = "ExternalCriteriaCode")
    protected TextCriterionType externalCriteriaCode;
    @XmlElement(name = "ExternalCriteriaTypeCode")
    protected TextCriterionType externalCriteriaTypeCode;
    @XmlElement(name = "FileReference")
    protected TextCriterionType fileReference;
    @XmlElement(name = "LegalEntityLocalKey")
    protected TextCriterionType legalEntityLocalKey;
    @XmlElement(name = "LocalKey")
    protected TextCriterionType localKey;
    @XmlElement(name = "Lot")
    protected TextCriterionType lot;
    @XmlElement(name = "ModificationDate")
    protected DateCriterionType modificationDate;
    @XmlElement(name = "ModificationUser")
    protected TextCriterionType modificationUser;
    @XmlElement(name = "PostingCriterionLocalKey")
    protected TextCriterionType postingCriterionLocalKey;
    @XmlElement(name = "Project")
    protected TextCriterionType project;
    @XmlElement(name = "ResponsibleOrganisationName")
    protected TextCriterionType responsibleOrganisationName;
    @XmlElement(name = "ResponsibleUsers")
    protected TextCriterionType responsibleUsers;
    @XmlElement(name = "UserReference")
    protected TextCriterionType userReference;

    /**
     * Obtiene el valor de la propiedad acceptedAmountInCurrency.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getAcceptedAmountInCurrency() {
        return acceptedAmountInCurrency;
    }

    /**
     * Define el valor de la propiedad acceptedAmountInCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setAcceptedAmountInCurrency(TextCriterionType value) {
        this.acceptedAmountInCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad appropriationLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getAppropriationLocalKey() {
        return appropriationLocalKey;
    }

    /**
     * Define el valor de la propiedad appropriationLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setAppropriationLocalKey(TextCriterionType value) {
        this.appropriationLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad blockedFlag.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorCriterionType }
     *     
     */
    public IndicatorCriterionType getBlockedFlag() {
        return blockedFlag;
    }

    /**
     * Define el valor de la propiedad blockedFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorCriterionType }
     *     
     */
    public void setBlockedFlag(IndicatorCriterionType value) {
        this.blockedFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad budgetCompanyCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getBudgetCompanyCode() {
        return budgetCompanyCode;
    }

    /**
     * Define el valor de la propiedad budgetCompanyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setBudgetCompanyCode(TextCriterionType value) {
        this.budgetCompanyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad centralKey.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCentralKey() {
        return centralKey;
    }

    /**
     * Define el valor de la propiedad centralKey.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCentralKey(TextCriterionType value) {
        this.centralKey = value;
    }

    /**
     * Obtiene el valor de la propiedad centralStatus.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCentralStatus() {
        return centralStatus;
    }

    /**
     * Define el valor de la propiedad centralStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCentralStatus(TextCriterionType value) {
        this.centralStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad classCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getClassCode() {
        return classCode;
    }

    /**
     * Define el valor de la propiedad classCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setClassCode(TextCriterionType value) {
        this.classCode = value;
    }

    /**
     * Obtiene el valor de la propiedad contractorReferenceLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getContractorReferenceLocalKey() {
        return contractorReferenceLocalKey;
    }

    /**
     * Define el valor de la propiedad contractorReferenceLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setContractorReferenceLocalKey(TextCriterionType value) {
        this.contractorReferenceLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad creationDate.
     * 
     * @return
     *     possible object is
     *     {@link DateCriterionType }
     *     
     */
    public DateCriterionType getCreationDate() {
        return creationDate;
    }

    /**
     * Define el valor de la propiedad creationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCriterionType }
     *     
     */
    public void setCreationDate(DateCriterionType value) {
        this.creationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad creationUser.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCreationUser() {
        return creationUser;
    }

    /**
     * Define el valor de la propiedad creationUser.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCreationUser(TextCriterionType value) {
        this.creationUser = value;
    }

    /**
     * Obtiene el valor de la propiedad currentBudgetYear.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCurrentBudgetYear() {
        return currentBudgetYear;
    }

    /**
     * Define el valor de la propiedad currentBudgetYear.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCurrentBudgetYear(TextCriterionType value) {
        this.currentBudgetYear = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowLevel.
     * 
     * @return
     *     possible object is
     *     {@link NumberCriterionType }
     *     
     */
    public NumberCriterionType getCurrentWorkflowLevel() {
        return currentWorkflowLevel;
    }

    /**
     * Define el valor de la propiedad currentWorkflowLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link NumberCriterionType }
     *     
     */
    public void setCurrentWorkflowLevel(NumberCriterionType value) {
        this.currentWorkflowLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowOrganisation.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCurrentWorkflowOrganisation() {
        return currentWorkflowOrganisation;
    }

    /**
     * Define el valor de la propiedad currentWorkflowOrganisation.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCurrentWorkflowOrganisation(TextCriterionType value) {
        this.currentWorkflowOrganisation = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowStatus.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getCurrentWorkflowStatus() {
        return currentWorkflowStatus;
    }

    /**
     * Define el valor de la propiedad currentWorkflowStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setCurrentWorkflowStatus(TextCriterionType value) {
        this.currentWorkflowStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad externalCriteriaCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getExternalCriteriaCode() {
        return externalCriteriaCode;
    }

    /**
     * Define el valor de la propiedad externalCriteriaCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setExternalCriteriaCode(TextCriterionType value) {
        this.externalCriteriaCode = value;
    }

    /**
     * Obtiene el valor de la propiedad externalCriteriaTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getExternalCriteriaTypeCode() {
        return externalCriteriaTypeCode;
    }

    /**
     * Define el valor de la propiedad externalCriteriaTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setExternalCriteriaTypeCode(TextCriterionType value) {
        this.externalCriteriaTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad fileReference.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getFileReference() {
        return fileReference;
    }

    /**
     * Define el valor de la propiedad fileReference.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setFileReference(TextCriterionType value) {
        this.fileReference = value;
    }

    /**
     * Obtiene el valor de la propiedad legalEntityLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getLegalEntityLocalKey() {
        return legalEntityLocalKey;
    }

    /**
     * Define el valor de la propiedad legalEntityLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setLegalEntityLocalKey(TextCriterionType value) {
        this.legalEntityLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad localKey.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getLocalKey() {
        return localKey;
    }

    /**
     * Define el valor de la propiedad localKey.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setLocalKey(TextCriterionType value) {
        this.localKey = value;
    }

    /**
     * Obtiene el valor de la propiedad lot.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getLot() {
        return lot;
    }

    /**
     * Define el valor de la propiedad lot.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setLot(TextCriterionType value) {
        this.lot = value;
    }

    /**
     * Obtiene el valor de la propiedad modificationDate.
     * 
     * @return
     *     possible object is
     *     {@link DateCriterionType }
     *     
     */
    public DateCriterionType getModificationDate() {
        return modificationDate;
    }

    /**
     * Define el valor de la propiedad modificationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link DateCriterionType }
     *     
     */
    public void setModificationDate(DateCriterionType value) {
        this.modificationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad modificationUser.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getModificationUser() {
        return modificationUser;
    }

    /**
     * Define el valor de la propiedad modificationUser.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setModificationUser(TextCriterionType value) {
        this.modificationUser = value;
    }

    /**
     * Obtiene el valor de la propiedad postingCriterionLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getPostingCriterionLocalKey() {
        return postingCriterionLocalKey;
    }

    /**
     * Define el valor de la propiedad postingCriterionLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setPostingCriterionLocalKey(TextCriterionType value) {
        this.postingCriterionLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad project.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getProject() {
        return project;
    }

    /**
     * Define el valor de la propiedad project.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setProject(TextCriterionType value) {
        this.project = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleOrganisationName.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getResponsibleOrganisationName() {
        return responsibleOrganisationName;
    }

    /**
     * Define el valor de la propiedad responsibleOrganisationName.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setResponsibleOrganisationName(TextCriterionType value) {
        this.responsibleOrganisationName = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleUsers.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getResponsibleUsers() {
        return responsibleUsers;
    }

    /**
     * Define el valor de la propiedad responsibleUsers.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setResponsibleUsers(TextCriterionType value) {
        this.responsibleUsers = value;
    }

    /**
     * Obtiene el valor de la propiedad userReference.
     * 
     * @return
     *     possible object is
     *     {@link TextCriterionType }
     *     
     */
    public TextCriterionType getUserReference() {
        return userReference;
    }

    /**
     * Define el valor de la propiedad userReference.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCriterionType }
     *     
     */
    public void setUserReference(TextCriterionType value) {
        this.userReference = value;
    }

}
