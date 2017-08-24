
package eu.europa.ec.budg.abac.external_criteria_type.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import eu.europa.ec.budg.abac.complex_type.v1.AuditInfoType;


/**
 * <p>Clase Java para ExternalCriteriaTypeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ExternalCriteriaTypeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuditInfo" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}AuditInfoType"/&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/external_criteria_type/v1}CodeType"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/external_criteria_type/v1}DescriptionType" minOccurs="0"/&gt;
 *         &lt;element name="DocumentAttribute" type="{http://www.ec.europa.eu/budg/abac/external_criteria_type/v1}DocumentAttributeType"/&gt;
 *         &lt;element name="FreeTextFlag" type="{http://www.ec.europa.eu/budg/abac/external_criteria_type/v1}FreeTextFlagType"/&gt;
 *         &lt;element name="LocalSystemCode" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalSystemCodeType"/&gt;
 *         &lt;element name="OwnerOrganisationalGroup" type="{http://www.ec.europa.eu/budg/abac/organisational_group/v1}CodeType"/&gt;
 *         &lt;element name="ValidFromDate" type="{http://www.ec.europa.eu/budg/abac/external_criteria_type/v1}ValidFromDateType"/&gt;
 *         &lt;element name="ValidToDate" type="{http://www.ec.europa.eu/budg/abac/external_criteria_type/v1}ValidToDateType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalCriteriaTypeType", propOrder = {
    "auditInfo",
    "code",
    "description",
    "documentAttribute",
    "freeTextFlag",
    "localSystemCode",
    "ownerOrganisationalGroup",
    "validFromDate",
    "validToDate"
})
public class ExternalCriteriaTypeType {

    @XmlElement(name = "AuditInfo", required = true)
    protected AuditInfoType auditInfo;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "DocumentAttribute")
    protected boolean documentAttribute;
    @XmlElement(name = "FreeTextFlag")
    protected boolean freeTextFlag;
    @XmlElement(name = "LocalSystemCode", required = true)
    protected String localSystemCode;
    @XmlElement(name = "OwnerOrganisationalGroup", required = true)
    protected String ownerOrganisationalGroup;
    @XmlElement(name = "ValidFromDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validFromDate;
    @XmlElement(name = "ValidToDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validToDate;

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
     * Obtiene el valor de la propiedad documentAttribute.
     * 
     */
    public boolean isDocumentAttribute() {
        return documentAttribute;
    }

    /**
     * Define el valor de la propiedad documentAttribute.
     * 
     */
    public void setDocumentAttribute(boolean value) {
        this.documentAttribute = value;
    }

    /**
     * Obtiene el valor de la propiedad freeTextFlag.
     * 
     */
    public boolean isFreeTextFlag() {
        return freeTextFlag;
    }

    /**
     * Define el valor de la propiedad freeTextFlag.
     * 
     */
    public void setFreeTextFlag(boolean value) {
        this.freeTextFlag = value;
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
     * Obtiene el valor de la propiedad ownerOrganisationalGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerOrganisationalGroup() {
        return ownerOrganisationalGroup;
    }

    /**
     * Define el valor de la propiedad ownerOrganisationalGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerOrganisationalGroup(String value) {
        this.ownerOrganisationalGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad validFromDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFromDate() {
        return validFromDate;
    }

    /**
     * Define el valor de la propiedad validFromDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFromDate(XMLGregorianCalendar value) {
        this.validFromDate = value;
    }

    /**
     * Obtiene el valor de la propiedad validToDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidToDate() {
        return validToDate;
    }

    /**
     * Define el valor de la propiedad validToDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidToDate(XMLGregorianCalendar value) {
        this.validToDate = value;
    }

}
