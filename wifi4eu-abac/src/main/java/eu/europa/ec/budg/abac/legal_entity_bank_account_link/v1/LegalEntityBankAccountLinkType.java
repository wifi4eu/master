
package eu.europa.ec.budg.abac.legal_entity_bank_account_link.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegalEntityBankAccountLinkType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityBankAccountLinkType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LegalEntityLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType"/&gt;
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
@XmlType(name = "LegalEntityBankAccountLinkType", propOrder = {
    "legalEntityLocalKey",
    "bankAccountLocalKey",
    "statusCode"
})
public class LegalEntityBankAccountLinkType {

    @XmlElement(name = "LegalEntityLocalKey", required = true)
    protected String legalEntityLocalKey;
    @XmlElement(name = "BankAccountLocalKey", required = true)
    protected String bankAccountLocalKey;
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
