
package eu.europa.ec.budg.abac.posting_criteria.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.complex_type.v1.AuditInfoType;


/**
 * <p>Clase Java para PostingCriteriaTypeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PostingCriteriaTypeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Abbreviation" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}AbbreviationType" minOccurs="0"/&gt;
 *         &lt;element name="AuditInfo" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}AuditInfoType" minOccurs="0"/&gt;
 *         &lt;element name="CentralFlag" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}CentralFlagType"/&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}CodeType"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}DescriptionType" minOccurs="0"/&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;element name="TransactionAreaCode" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}TransactionAreaCodeType" minOccurs="0"/&gt;
 *         &lt;element name="TextFlag" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}TextFlagType"/&gt;
 *         &lt;element name="ValidFlag" type="{http://www.ec.europa.eu/budg/abac/posting_criteria/v1}ValidFlagType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostingCriteriaTypeType", propOrder = {
    "abbreviation",
    "auditInfo",
    "centralFlag",
    "code",
    "description",
    "localSystemCode",
    "transactionAreaCode",
    "textFlag",
    "validFlag"
})
public class PostingCriteriaTypeType {

    @XmlElement(name = "Abbreviation")
    protected String abbreviation;
    @XmlElement(name = "AuditInfo")
    protected AuditInfoType auditInfo;
    @XmlElement(name = "CentralFlag")
    protected boolean centralFlag;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "TransactionAreaCode")
    protected String transactionAreaCode;
    @XmlElement(name = "TextFlag")
    protected boolean textFlag;
    @XmlElement(name = "ValidFlag")
    protected boolean validFlag;

    /**
     * Obtiene el valor de la propiedad abbreviation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Define el valor de la propiedad abbreviation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbbreviation(String value) {
        this.abbreviation = value;
    }

    /**
     * Obtiene el valor de la propiedad auditInfo.
     * 
     * @return
     *     possible object is
     *     {@link AuditInfoType }
     *     
     */
    public AuditInfoType getAuditInfo() {
        return auditInfo;
    }

    /**
     * Define el valor de la propiedad auditInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditInfoType }
     *     
     */
    public void setAuditInfo(AuditInfoType value) {
        this.auditInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad centralFlag.
     * 
     */
    public boolean isCentralFlag() {
        return centralFlag;
    }

    /**
     * Define el valor de la propiedad centralFlag.
     * 
     */
    public void setCentralFlag(boolean value) {
        this.centralFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define el valor de la propiedad code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
     * Obtiene el valor de la propiedad transactionAreaCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionAreaCode() {
        return transactionAreaCode;
    }

    /**
     * Define el valor de la propiedad transactionAreaCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionAreaCode(String value) {
        this.transactionAreaCode = value;
    }

    /**
     * Obtiene el valor de la propiedad textFlag.
     * 
     */
    public boolean isTextFlag() {
        return textFlag;
    }

    /**
     * Define el valor de la propiedad textFlag.
     * 
     */
    public void setTextFlag(boolean value) {
        this.textFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad validFlag.
     * 
     */
    public boolean isValidFlag() {
        return validFlag;
    }

    /**
     * Define el valor de la propiedad validFlag.
     * 
     */
    public void setValidFlag(boolean value) {
        this.validFlag = value;
    }

}
