
package eu.europa.ec.budg.abac.legal_entity.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.europa.ec.budg.abac.message.v1.MessageRequestType;


/**
 * <p>Clase Java para LegalEntityModifyBankAccountRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityModifyBankAccountRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}LocalKeyType"/&gt;
 *         &lt;element name="LegalEntityBankAccountLink"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BankAccountLocalKey" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}LocalKeyType"/&gt;
 *                   &lt;element name="StatusCode" type="{http://www.ec.europa.eu/budg/abac/legal_entity_bank_account_link/v1}StatusCodeType"/&gt;
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
@XmlType(name = "LegalEntityModifyBankAccountRequestType", propOrder = {
    "localKey",
    "legalEntityBankAccountLink"
})
public class LegalEntityModifyBankAccountRequestType
    extends MessageRequestType
{

    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "LegalEntityBankAccountLink", required = true)
    protected LegalEntityBankAccountLink legalEntityBankAccountLink;

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
     * Obtiene el valor de la propiedad legalEntityBankAccountLink.
     * 
     * @return
     *     possible object is
     *     {@link LegalEntityBankAccountLink }
     *     
     */
    public LegalEntityBankAccountLink getLegalEntityBankAccountLink() {
        return legalEntityBankAccountLink;
    }

    /**
     * Define el valor de la propiedad legalEntityBankAccountLink.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalEntityBankAccountLink }
     *     
     */
    public void setLegalEntityBankAccountLink(LegalEntityBankAccountLink value) {
        this.legalEntityBankAccountLink = value;
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
     *         &lt;element name="BankAccountLocalKey" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}LocalKeyType"/&gt;
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
