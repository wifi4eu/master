
package wifi4eu.wifi4eu.service.exportImport.messageCall.lef;

import eu.europa.ec.budg.abac.ares_document.v1.AresDocumentsType;
import eu.europa.ec.budg.abac.responsible_user.v1.ResponsibleUsersType;
import eu.europa.ec.budg.abac.supporting_document.v1.SupportingDocumentFolderType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Clase Java para LegalEntityCreateType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityCreateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntityWritableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AresDocuments" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentsType" minOccurs="0"/&gt;
 *         &lt;element name="BudgetCompanyCode" type="{http://www.ec.europa.eu/budg/abac/abac_object/v1}BudgetCompanyCodeType" minOccurs="0"/&gt;
 *         &lt;element name="LegalEntityBankAccountLinks" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="LegalEntityBankAccountLink" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="BankAccountLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
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
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;element name="MailingAddresses" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MailingAddress" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}MailingAddressType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "LegalEntityCreateType", propOrder = {
    "aresDocuments",
    "budgetCompanyCode",
    "legalEntityBankAccountLinks",
    "localSystemCode",
    "mailingAddresses",
    "responsibleUsers",
    "supportingDocumentFolder"
})
@XmlSeeAlso({
    PublicPrivateLawBodyCreateType.class,
    NaturalPersonCreateType.class
})
public abstract class LegalEntityCreateType
    extends LegalEntityWritableType
{

    @XmlElement(name = "AresDocuments")
    protected AresDocumentsType aresDocuments;
    @XmlElement(name = "BudgetCompanyCode")
    protected String budgetCompanyCode;
    @XmlElement(name = "LegalEntityBankAccountLinks")
    protected LegalEntityBankAccountLinks legalEntityBankAccountLinks;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "MailingAddresses")
    protected MailingAddresses mailingAddresses;
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
     * Obtiene el valor de la propiedad legalEntityBankAccountLinks.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityBankAccountLinks }
     *     
     */
    public LegalEntityBankAccountLinks getLegalEntityBankAccountLinks() {
        return legalEntityBankAccountLinks;
    }

    /**
     * Define el valor de la propiedad legalEntityBankAccountLinks.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityBankAccountLinks }
     *     
     */
    public void setLegalEntityBankAccountLinks(LegalEntityBankAccountLinks value) {
        this.legalEntityBankAccountLinks = value;
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
     * Obtiene el valor de la propiedad mailingAddresses.
     * 
     * @return
     *     possible object is
     *     {@link MailingAddresses }
     *     
     */
    public MailingAddresses getMailingAddresses() {
        return mailingAddresses;
    }

    /**
     * Define el valor de la propiedad mailingAddresses.
     * 
     * @param value
     *     allowed object is
     *     {@link MailingAddresses }
     *     
     */
    public void setMailingAddresses(MailingAddresses value) {
        this.mailingAddresses = value;
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
     *         &lt;element name="LegalEntityBankAccountLink" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="BankAccountLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
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
        "legalEntityBankAccountLink"
    })
    public static class LegalEntityBankAccountLinks {

        @XmlElement(name = "LegalEntityBankAccountLink", required = true)
        protected List<LegalEntityBankAccountLink> legalEntityBankAccountLink;

        /**
         * Gets the value of the legalEntityBankAccountLink property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the legalEntityBankAccountLink property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLegalEntityBankAccountLink().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LegalEntityBankAccountLink }
         * 
         * 
         */
        public List<LegalEntityBankAccountLink> getLegalEntityBankAccountLink() {
            if (legalEntityBankAccountLink == null) {
                legalEntityBankAccountLink = new ArrayList<LegalEntityBankAccountLink>();
            }
            return this.legalEntityBankAccountLink;
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
         *         &lt;element name="BankAccountLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
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
            "bankAccountLocalKey",
            "statusCode"
        })
        public static class LegalEntityBankAccountLink {

            @XmlElement(name = "BankAccountLocalKey", required = true)
            protected String bankAccountLocalKey;
            @XmlElement(name = "StatusCode", required = true)
            protected String statusCode;

            /**
             * Obtiene el valor de la propiedad bankAccountLocalKey.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBankAccountLocalKey() {
                return bankAccountLocalKey;
            }

            /**
             * Define el valor de la propiedad bankAccountLocalKey.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBankAccountLocalKey(String value) {
                this.bankAccountLocalKey = value;
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
     *         &lt;element name="MailingAddress" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}MailingAddressType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "mailingAddress"
    })
    public static class MailingAddresses {

        @XmlElement(name = "MailingAddress")
        protected List<MailingAddressType> mailingAddress;

        /**
         * Gets the value of the mailingAddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mailingAddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMailingAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MailingAddressType }
         * 
         * 
         */
        public List<MailingAddressType> getMailingAddress() {
            if (mailingAddress == null) {
                mailingAddress = new ArrayList<MailingAddressType>();
            }
            return this.mailingAddress;
        }

    }

}
