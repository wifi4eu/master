
package eu.europa.ec.budg.abac.legal_commitment.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.ares_document.v1.AresDocumentsType;
import eu.europa.ec.budg.abac.external_criteria.v1.ExternalCriteriasType;
import eu.europa.ec.budg.abac.responsible_user.v1.ResponsibleUsersType;
import eu.europa.ec.budg.abac.supporting_document.v1.SupportingDocumentFolderType;


/**
 * <p>Clase Java para LegalCommitmentCreateType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalCommitmentCreateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}LegalCommitmentWritableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AresDocuments" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentsType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetaryCommitmentLinks" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CommitmentLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BudgetCompanyCode" type="{http://www.ec.europa.eu/budg/abac/abac_object/v1}BudgetCompanyCodeType"/&gt;
 *         &lt;element name="ContractReferences" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ContractLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ExternalCriterias" type="{http://www.ec.europa.eu/budg/abac/external_criteria/v1}ExternalCriteriasType" minOccurs="0"/&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;element name="PaymentTimeLimits" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}PaymentTimeLimitsType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleUsers" type="{http://www.ec.europa.eu/budg/abac/responsible_user/v1}ResponsibleUsersType" minOccurs="0"/&gt;
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
@XmlType(name = "LegalCommitmentCreateType", propOrder = {
    "aresDocuments",
    "budgetaryCommitmentLinks",
    "budgetCompanyCode",
    "contractReferences",
    "externalCriterias",
    "localSystemCode",
    "paymentTimeLimits",
    "responsibleUsers",
    "supportingDocumentFolder"
})
public class LegalCommitmentCreateType
    extends LegalCommitmentWritableType
{

    @XmlElement(name = "AresDocuments")
    protected AresDocumentsType aresDocuments;
    @XmlElement(name = "BudgetaryCommitmentLinks")
    protected LegalCommitmentCreateType.BudgetaryCommitmentLinks budgetaryCommitmentLinks;
    @XmlElement(name = "BudgetCompanyCode", required = true)
    protected String budgetCompanyCode;
    @XmlElement(name = "ContractReferences")
    protected LegalCommitmentCreateType.ContractReferences contractReferences;
    @XmlElement(name = "ExternalCriterias")
    protected ExternalCriteriasType externalCriterias;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "PaymentTimeLimits")
    protected PaymentTimeLimitsType paymentTimeLimits;
    @XmlElement(name = "ResponsibleUsers")
    protected ResponsibleUsersType responsibleUsers;
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
     * Obtiene el valor de la propiedad budgetaryCommitmentLinks.
     * 
     * @return
     *     possible object is
     *     {@link LegalCommitmentCreateType.BudgetaryCommitmentLinks }
     *     
     */
    public LegalCommitmentCreateType.BudgetaryCommitmentLinks getBudgetaryCommitmentLinks() {
        return budgetaryCommitmentLinks;
    }

    /**
     * Define el valor de la propiedad budgetaryCommitmentLinks.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalCommitmentCreateType.BudgetaryCommitmentLinks }
     *     
     */
    public void setBudgetaryCommitmentLinks(LegalCommitmentCreateType.BudgetaryCommitmentLinks value) {
        this.budgetaryCommitmentLinks = value;
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
     * Obtiene el valor de la propiedad contractReferences.
     * 
     * @return
     *     possible object is
     *     {@link LegalCommitmentCreateType.ContractReferences }
     *     
     */
    public LegalCommitmentCreateType.ContractReferences getContractReferences() {
        return contractReferences;
    }

    /**
     * Define el valor de la propiedad contractReferences.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalCommitmentCreateType.ContractReferences }
     *     
     */
    public void setContractReferences(LegalCommitmentCreateType.ContractReferences value) {
        this.contractReferences = value;
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
     * Obtiene el valor de la propiedad paymentTimeLimits.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTimeLimitsType }
     *     
     */
    public PaymentTimeLimitsType getPaymentTimeLimits() {
        return paymentTimeLimits;
    }

    /**
     * Define el valor de la propiedad paymentTimeLimits.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTimeLimitsType }
     *     
     */
    public void setPaymentTimeLimits(PaymentTimeLimitsType value) {
        this.paymentTimeLimits = value;
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
     *         &lt;element name="CommitmentLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
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
        "commitmentLocalKey"
    })
    public static class BudgetaryCommitmentLinks {

        @XmlElement(name = "CommitmentLocalKey", required = true)
        protected List<String> commitmentLocalKey;

        /**
         * Gets the value of the commitmentLocalKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the commitmentLocalKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCommitmentLocalKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCommitmentLocalKey() {
            if (commitmentLocalKey == null) {
                commitmentLocalKey = new ArrayList<String>();
            }
            return this.commitmentLocalKey;
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
     *         &lt;element name="ContractLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" maxOccurs="unbounded"/&gt;
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
        "contractLocalKey"
    })
    public static class ContractReferences {

        @XmlElement(name = "ContractLocalKey", required = true)
        protected List<String> contractLocalKey;

        /**
         * Gets the value of the contractLocalKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractLocalKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractLocalKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getContractLocalKey() {
            if (contractLocalKey == null) {
                contractLocalKey = new ArrayList<String>();
            }
            return this.contractLocalKey;
        }

    }

}
