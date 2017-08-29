
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.bank_account.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.address.v1.BankAccountAddressType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.address.v1.BankAddressType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.organisation.v1.ResponsibleOrganisationType;


/**
 * <p>Clase Java para BankAccountWritableType complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="BankAccountWritableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountHolderAddress" type="{http://www.ec.europa.eu/budg/abac/address/v1}BankAccountAddressType"/&gt;
 *         &lt;element name="AccountHolderLanguageCode" type="{http://www.ec.europa.eu/budg/abac/language/v1}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="AccountHolderName" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}NameType"/&gt;
 *         &lt;element name="AccountNrMask" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}AccountNrMaskCodeType" minOccurs="0"/&gt;
 *         &lt;element name="BankAccountNumber" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}BankAccountNumberType" minOccurs="0"/&gt;
 *         &lt;element name="BankAddress" type="{http://www.ec.europa.eu/budg/abac/address/v1}BankAddressType" minOccurs="0"/&gt;
 *         &lt;element name="BankName" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}BankNameType" minOccurs="0"/&gt;
 *         &lt;element name="BicCode" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}BicCodeType" minOccurs="0"/&gt;
 *         &lt;element name="ChequeExecutionCountryCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}Iso2CodeType" minOccurs="0"/&gt;
 *         &lt;element name="ConfidentialInfo" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}ConfidentialInfoType"/&gt;
 *         &lt;element name="CurrencyCode" type="{http://www.ec.europa.eu/budg/abac/currency/v1}Iso3CodeType" minOccurs="0"/&gt;
 *         &lt;element name="Iban" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}IbanType" minOccurs="0"/&gt;
 *         &lt;element name="IsLocalPaymentOnly" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}IndicatorType" minOccurs="0"/&gt;
 *         &lt;element name="LocalKey" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}LocalKeyType"/&gt;
 *         &lt;element name="OriginalLocalKey" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}LocalKeyType" minOccurs="0"/&gt;
 *         &lt;element name="PaymentMethodCode" type="{http://www.ec.europa.eu/budg/abac/payment_method/v1}CodeType"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}RemarksType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}ResponsibleOrganisationType" minOccurs="0"/&gt;
 *         &lt;element name="RoutingNumberOrBSBCode" type="{http://www.ec.europa.eu/budg/abac/bank_account/v1}RoutingNumberOrBSBCodeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankAccountWritableType", propOrder = {
        "accountHolderAddress",
        "accountHolderLanguageCode",
        "accountHolderName",
        "accountNrMask",
        "bankAccountNumber",
        "bankAddress",
        "bankName",
        "bicCode",
        "chequeExecutionCountryCode",
        "confidentialInfo",
        "currencyCode",
        "iban",
        "isLocalPaymentOnly",
        "localKey",
        "originalLocalKey",
        "paymentMethodCode",
        "remarks",
        "responsibleOrganisation",
        "routingNumberOrBSBCode"
})
@XmlSeeAlso({
        BankAccountCreateType.class
})
public class BankAccountWritableType {

    @XmlElement(name = "AccountHolderAddress", required = true)
    protected BankAccountAddressType accountHolderAddress;
    @XmlElement(name = "AccountHolderLanguageCode")
    protected String accountHolderLanguageCode;
    @XmlElement(name = "AccountHolderName", required = true)
    protected String accountHolderName;
    @XmlElement(name = "AccountNrMask")
    protected String accountNrMask;
    @XmlElement(name = "BankAccountNumber")
    protected String bankAccountNumber;
    @XmlElement(name = "BankAddress")
    protected BankAddressType bankAddress;
    @XmlElement(name = "BankName")
    protected String bankName;
    @XmlElement(name = "BicCode")
    protected String bicCode;
    @XmlElement(name = "ChequeExecutionCountryCode")
    protected String chequeExecutionCountryCode;
    @XmlElement(name = "ConfidentialInfo")
    protected boolean confidentialInfo;
    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElement(name = "Iban")
    protected String iban;
    @XmlElement(name = "IsLocalPaymentOnly")
    protected Boolean isLocalPaymentOnly;
    @XmlElement(name = "LocalKey", required = true)
    protected String localKey;
    @XmlElement(name = "OriginalLocalKey")
    protected String originalLocalKey;
    @XmlElement(name = "PaymentMethodCode", required = true)
    protected String paymentMethodCode;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "ResponsibleOrganisation")
    protected ResponsibleOrganisationType responsibleOrganisation;
    @XmlElement(name = "RoutingNumberOrBSBCode")
    protected String routingNumberOrBSBCode;

    /**
     * Obtiene el valor de la propiedad accountHolderAddress.
     *
     * @return possible object is
     * {@link BankAccountAddressType }
     */
    public BankAccountAddressType getAccountHolderAddress() {
        return accountHolderAddress;
    }

    /**
     * Define el valor de la propiedad accountHolderAddress.
     *
     * @param value allowed object is
     *              {@link BankAccountAddressType }
     */
    public void setAccountHolderAddress(BankAccountAddressType value) {
        this.accountHolderAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad accountHolderLanguageCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountHolderLanguageCode() {
        return accountHolderLanguageCode;
    }

    /**
     * Define el valor de la propiedad accountHolderLanguageCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountHolderLanguageCode(String value) {
        this.accountHolderLanguageCode = value;
    }

    /**
     * Obtiene el valor de la propiedad accountHolderName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Define el valor de la propiedad accountHolderName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountHolderName(String value) {
        this.accountHolderName = value;
    }

    /**
     * Obtiene el valor de la propiedad accountNrMask.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountNrMask() {
        return accountNrMask;
    }

    /**
     * Define el valor de la propiedad accountNrMask.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountNrMask(String value) {
        this.accountNrMask = value;
    }

    /**
     * Obtiene el valor de la propiedad bankAccountNumber.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * Define el valor de la propiedad bankAccountNumber.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBankAccountNumber(String value) {
        this.bankAccountNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad bankAddress.
     *
     * @return possible object is
     * {@link BankAddressType }
     */
    public BankAddressType getBankAddress() {
        return bankAddress;
    }

    /**
     * Define el valor de la propiedad bankAddress.
     *
     * @param value allowed object is
     *              {@link BankAddressType }
     */
    public void setBankAddress(BankAddressType value) {
        this.bankAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad bankName.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Define el valor de la propiedad bankName.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Obtiene el valor de la propiedad bicCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBicCode() {
        return bicCode;
    }

    /**
     * Define el valor de la propiedad bicCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBicCode(String value) {
        this.bicCode = value;
    }

    /**
     * Obtiene el valor de la propiedad chequeExecutionCountryCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChequeExecutionCountryCode() {
        return chequeExecutionCountryCode;
    }

    /**
     * Define el valor de la propiedad chequeExecutionCountryCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChequeExecutionCountryCode(String value) {
        this.chequeExecutionCountryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad confidentialInfo.
     */
    public boolean isConfidentialInfo() {
        return confidentialInfo;
    }

    /**
     * Define el valor de la propiedad confidentialInfo.
     */
    public void setConfidentialInfo(boolean value) {
        this.confidentialInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Define el valor de la propiedad currencyCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad iban.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIban() {
        return iban;
    }

    /**
     * Define el valor de la propiedad iban.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIban(String value) {
        this.iban = value;
    }

    /**
     * Obtiene el valor de la propiedad isLocalPaymentOnly.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isIsLocalPaymentOnly() {
        return isLocalPaymentOnly;
    }

    /**
     * Define el valor de la propiedad isLocalPaymentOnly.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsLocalPaymentOnly(Boolean value) {
        this.isLocalPaymentOnly = value;
    }

    /**
     * Obtiene el valor de la propiedad localKey.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLocalKey() {
        return localKey;
    }

    /**
     * Define el valor de la propiedad localKey.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLocalKey(String value) {
        this.localKey = value;
    }

    /**
     * Obtiene el valor de la propiedad originalLocalKey.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOriginalLocalKey() {
        return originalLocalKey;
    }

    /**
     * Define el valor de la propiedad originalLocalKey.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOriginalLocalKey(String value) {
        this.originalLocalKey = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentMethodCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    /**
     * Define el valor de la propiedad paymentMethodCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPaymentMethodCode(String value) {
        this.paymentMethodCode = value;
    }

    /**
     * Obtiene el valor de la propiedad remarks.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define el valor de la propiedad remarks.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleOrganisation.
     *
     * @return possible object is
     * {@link ResponsibleOrganisationType }
     */
    public ResponsibleOrganisationType getResponsibleOrganisation() {
        return responsibleOrganisation;
    }

    /**
     * Define el valor de la propiedad responsibleOrganisation.
     *
     * @param value allowed object is
     *              {@link ResponsibleOrganisationType }
     */
    public void setResponsibleOrganisation(ResponsibleOrganisationType value) {
        this.responsibleOrganisation = value;
    }

    /**
     * Obtiene el valor de la propiedad routingNumberOrBSBCode.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRoutingNumberOrBSBCode() {
        return routingNumberOrBSBCode;
    }

    /**
     * Define el valor de la propiedad routingNumberOrBSBCode.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRoutingNumberOrBSBCode(String value) {
        this.routingNumberOrBSBCode = value;
    }

}
