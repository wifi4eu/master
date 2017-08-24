
package eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.ares_document.v1.AresDocumentsType;
import eu.europa.ec.budg.abac.contractor_reference.v1.ContractorReferencesType;
import eu.europa.ec.budg.abac.external_criteria.v1.ExternalCriteriasType;
import eu.europa.ec.budg.abac.responsible_user.v1.ResponsibleUsersType;
import eu.europa.ec.budg.abac.scanned_document.v1.ScannedDocumentsType;
import eu.europa.ec.budg.abac.supporting_document.v1.SupportingDocumentFolderType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2CreateType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2CreateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2WritableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AresDocuments" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentsType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetCompanyCode" type="{http://www.ec.europa.eu/budg/abac/abac_object/v1}BudgetCompanyCodeType"/&gt;
 *         &lt;element name="ContractorReferences" type="{http://www.ec.europa.eu/budg/abac/contractor_reference/v1}ContractorReferencesType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriterias" type="{http://www.ec.europa.eu/budg/abac/external_criteria/v1}ExternalCriteriasType" minOccurs="0"/&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;group ref="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}PositionsOrEnvelopeLinkChoiceGroup" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleUsers" type="{http://www.ec.europa.eu/budg/abac/responsible_user/v1}ResponsibleUsersType" minOccurs="0"/&gt;
 *         &lt;element name="ScannedDocuments" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ScannedDocumentsType" minOccurs="0"/&gt;
 *         &lt;element name="SupportingDocumentFolder" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}SupportingDocumentFolderType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2CreateType", propOrder = {
    "aresDocuments",
    "budgetCompanyCode",
    "contractorReferences",
    "externalCriterias",
    "localSystemCode",
    "commitmentPositions",
    "envelopeLink",
    "responsibleUsers",
    "scannedDocuments",
    "supportingDocumentFolder"
})
public class BudgetaryCommitmentLevel2CreateType
    extends BudgetaryCommitmentLevel2WritableType
{

    @XmlElement(name = "AresDocuments")
    protected AresDocumentsType aresDocuments;
    @XmlElement(name = "BudgetCompanyCode", required = true)
    protected String budgetCompanyCode;
    @XmlElement(name = "ContractorReferences")
    protected ContractorReferencesType contractorReferences;
    @XmlElement(name = "ExternalCriterias")
    protected ExternalCriteriasType externalCriterias;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "CommitmentPositions")
    protected CommitmentPositionsType commitmentPositions;
    @XmlElement(name = "EnvelopeLink")
    protected BudgetaryCommitmentLevel2EnvelopeLinkCreateType envelopeLink;
    @XmlElement(name = "ResponsibleUsers")
    protected ResponsibleUsersType responsibleUsers;
    @XmlElement(name = "ScannedDocuments")
    protected ScannedDocumentsType scannedDocuments;
    @XmlElement(name = "SupportingDocumentFolder")
    protected SupportingDocumentFolderType supportingDocumentFolder;

    /**
     * Obtiene el valor de la propiedad aresDocuments.
     * 
     * @return
     *     possible object is
     *     {@link AresDocumentsType }
     *     
     */
    public AresDocumentsType getAresDocuments() {
        return aresDocuments;
    }

    /**
     * Define el valor de la propiedad aresDocuments.
     * 
     * @param value
     *     allowed object is
     *     {@link AresDocumentsType }
     *     
     */
    public void setAresDocuments(AresDocumentsType value) {
        this.aresDocuments = value;
    }

    /**
     * Obtiene el valor de la propiedad budgetCompanyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetCompanyCode() {
        return budgetCompanyCode;
    }

    /**
     * Define el valor de la propiedad budgetCompanyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetCompanyCode(String value) {
        this.budgetCompanyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad contractorReferences.
     * 
     * @return
     *     possible object is
     *     {@link ContractorReferencesType }
     *     
     */
    public ContractorReferencesType getContractorReferences() {
        return contractorReferences;
    }

    /**
     * Define el valor de la propiedad contractorReferences.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractorReferencesType }
     *     
     */
    public void setContractorReferences(ContractorReferencesType value) {
        this.contractorReferences = value;
    }

    /**
     * Obtiene el valor de la propiedad externalCriterias.
     * 
     * @return
     *     possible object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public ExternalCriteriasType getExternalCriterias() {
        return externalCriterias;
    }

    /**
     * Define el valor de la propiedad externalCriterias.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public void setExternalCriterias(ExternalCriteriasType value) {
        this.externalCriterias = value;
    }

    /**
     * Obtiene el valor de la propiedad localSystemCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalSystemCode() {
        return localSystemCode;
    }

    /**
     * Define el valor de la propiedad localSystemCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalSystemCode(String value) {
        this.localSystemCode = value;
    }

    /**
     * Obtiene el valor de la propiedad commitmentPositions.
     * 
     * @return
     *     possible object is
     *     {@link CommitmentPositionsType }
     *     
     */
    public CommitmentPositionsType getCommitmentPositions() {
        return commitmentPositions;
    }

    /**
     * Define el valor de la propiedad commitmentPositions.
     * 
     * @param value
     *     allowed object is
     *     {@link CommitmentPositionsType }
     *     
     */
    public void setCommitmentPositions(CommitmentPositionsType value) {
        this.commitmentPositions = value;
    }

    /**
     * Obtiene el valor de la propiedad envelopeLink.
     * 
     * @return
     *     possible object is
     *     {@link BudgetaryCommitmentLevel2EnvelopeLinkCreateType }
     *     
     */
    public BudgetaryCommitmentLevel2EnvelopeLinkCreateType getEnvelopeLink() {
        return envelopeLink;
    }

    /**
     * Define el valor de la propiedad envelopeLink.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetaryCommitmentLevel2EnvelopeLinkCreateType }
     *     
     */
    public void setEnvelopeLink(BudgetaryCommitmentLevel2EnvelopeLinkCreateType value) {
        this.envelopeLink = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleUsers.
     * 
     * @return
     *     possible object is
     *     {@link ResponsibleUsersType }
     *     
     */
    public ResponsibleUsersType getResponsibleUsers() {
        return responsibleUsers;
    }

    /**
     * Define el valor de la propiedad responsibleUsers.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsibleUsersType }
     *     
     */
    public void setResponsibleUsers(ResponsibleUsersType value) {
        this.responsibleUsers = value;
    }

    /**
     * Obtiene el valor de la propiedad scannedDocuments.
     * 
     * @return
     *     possible object is
     *     {@link ScannedDocumentsType }
     *     
     */
    public ScannedDocumentsType getScannedDocuments() {
        return scannedDocuments;
    }

    /**
     * Define el valor de la propiedad scannedDocuments.
     * 
     * @param value
     *     allowed object is
     *     {@link ScannedDocumentsType }
     *     
     */
    public void setScannedDocuments(ScannedDocumentsType value) {
        this.scannedDocuments = value;
    }

    /**
     * Obtiene el valor de la propiedad supportingDocumentFolder.
     * 
     * @return
     *     possible object is
     *     {@link SupportingDocumentFolderType }
     *     
     */
    public SupportingDocumentFolderType getSupportingDocumentFolder() {
        return supportingDocumentFolder;
    }

    /**
     * Define el valor de la propiedad supportingDocumentFolder.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportingDocumentFolderType }
     *     
     */
    public void setSupportingDocumentFolder(SupportingDocumentFolderType value) {
        this.supportingDocumentFolder = value;
    }

}
