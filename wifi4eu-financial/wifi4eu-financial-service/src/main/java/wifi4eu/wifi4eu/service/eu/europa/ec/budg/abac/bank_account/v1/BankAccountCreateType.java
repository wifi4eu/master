
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.bank_account.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.ares_document.v1.AresDocumentsType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.responsible_user.v1.ResponsibleUsersType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.scanned_document.v1.ScannedDocumentsType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.supporting_document.v1.SupportingDocumentFolderType;


/**
 * <p>Clase Java para BankAccountCreateType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BankAccountCreateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/bank_account/v1}BankAccountWritableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AresDocuments" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentsType" minOccurs="0"/&gt;
 *         &lt;element name="BankAccountLegalEntityLinks" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BankAccountLegalEntityLink" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="LegalEntityLocalKey" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LocalKeyType"/&gt;
 *                             &lt;element name="StatusCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity_bank_account_link/v1}StatusCodeType"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BudgetCompanyCode" type="{http://www.ec.europa.eu/budg/abac/abac_object/v1}BudgetCompanyCodeType" minOccurs="0"/&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
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
@XmlType(name = "BankAccountCreateType", propOrder = {
    "aresDocuments",
    "bankAccountLegalEntityLinks",
    "budgetCompanyCode",
    "localSystemCode",
    "responsibleUsers",
    "scannedDocuments",
    "supportingDocumentFolder"
})
public class BankAccountCreateType
    extends BankAccountWritableType
{

    @XmlElement(name = "AresDocuments")
    protected AresDocumentsType aresDocuments;
    @XmlElement(name = "BankAccountLegalEntityLinks")
    protected BankAccountLegalEntityLinks bankAccountLegalEntityLinks;
    @XmlElement(name = "BudgetCompanyCode")
    protected String budgetCompanyCode;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
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
     * Obtiene el valor de la propiedad bankAccountLegalEntityLinks.
     * 
     * @return
     *     possible object is
     *     {@link BankAccountLegalEntityLinks }
     *     
     */
    public BankAccountLegalEntityLinks getBankAccountLegalEntityLinks() {
        return bankAccountLegalEntityLinks;
    }

    /**
     * Define el valor de la propiedad bankAccountLegalEntityLinks.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccountLegalEntityLinks }
     *     
     */
    public void setBankAccountLegalEntityLinks(BankAccountLegalEntityLinks value) {
        this.bankAccountLegalEntityLinks = value;
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
     *         &lt;element name="BankAccountLegalEntityLink" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="LegalEntityLocalKey" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LocalKeyType"/&gt;
     *                   &lt;element name="StatusCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity_bank_account_link/v1}StatusCodeType"/&gt;
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
    @XmlType(name = "", propOrder = {
        "bankAccountLegalEntityLink"
    })
    public static class BankAccountLegalEntityLinks {

        @XmlElement(name = "BankAccountLegalEntityLink", required = true)
        protected List<BankAccountLegalEntityLink> bankAccountLegalEntityLink;

        /**
         * Gets the value of the bankAccountLegalEntityLink property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bankAccountLegalEntityLink property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBankAccountLegalEntityLink().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BankAccountLegalEntityLink }
         * 
         * 
         */
        public List<BankAccountLegalEntityLink> getBankAccountLegalEntityLink() {
            if (bankAccountLegalEntityLink == null) {
                bankAccountLegalEntityLink = new ArrayList<BankAccountLegalEntityLink>();
            }
            return this.bankAccountLegalEntityLink;
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
         *         &lt;element name="LegalEntityLocalKey" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LocalKeyType"/&gt;
         *         &lt;element name="StatusCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity_bank_account_link/v1}StatusCodeType"/&gt;
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
            "legalEntityLocalKey",
            "statusCode"
        })
        public static class BankAccountLegalEntityLink {

            @XmlElement(name = "LegalEntityLocalKey", required = true)
            protected String legalEntityLocalKey;
            @XmlElement(name = "StatusCode", required = true)
            protected String statusCode;

            /**
             * Obtiene el valor de la propiedad legalEntityLocalKey.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLegalEntityLocalKey() {
                return legalEntityLocalKey;
            }

            /**
             * Define el valor de la propiedad legalEntityLocalKey.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLegalEntityLocalKey(String value) {
                this.legalEntityLocalKey = value;
            }

            /**
             * Obtiene el valor de la propiedad statusCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStatusCode() {
                return statusCode;
            }

            /**
             * Define el valor de la propiedad statusCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStatusCode(String value) {
                this.statusCode = value;
            }

        }

    }

}
