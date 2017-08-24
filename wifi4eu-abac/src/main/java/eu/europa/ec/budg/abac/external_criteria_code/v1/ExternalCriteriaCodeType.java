
package eu.europa.ec.budg.abac.external_criteria_code.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import eu.europa.ec.budg.abac.complex_type.v1.AuditInfoType;
import eu.europa.ec.budg.abac.organisational_group.v1.OrganisationalGroupType;


/**
 * <p>Clase Java para ExternalCriteriaCodeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ExternalCriteriaCodeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Abbreviation" type="{http://www.ec.europa.eu/budg/abac/external_criteria_code/v1}AbbreviationType"/&gt;
 *         &lt;element name="AuditInfo" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}AuditInfoType"/&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/external_criteria_code/v1}CodeType"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/external_criteria_code/v1}DescriptionType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriteriaTypeCode" type="{http://www.ec.europa.eu/budg/abac/external_criteria_type/v1}CodeType"/&gt;
 *         &lt;element name="OrganisationalGroup" type="{http://www.ec.europa.eu/budg/abac/organisational_group/v1}OrganisationalGroupType"/&gt;
 *         &lt;element name="ValidFromDate" type="{http://www.ec.europa.eu/budg/abac/external_criteria_code/v1}ValidFromDateType"/&gt;
 *         &lt;element name="ValidToDate" type="{http://www.ec.europa.eu/budg/abac/external_criteria_code/v1}ValidToDateType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalCriteriaCodeType", propOrder = {
    "abbreviation",
    "auditInfo",
    "code",
    "description",
    "externalCriteriaTypeCode",
    "organisationalGroup",
    "validFromDate",
    "validToDate"
})
public class ExternalCriteriaCodeType {

    @XmlElement(name = "Abbreviation", required = true)
    protected String abbreviation;
    @XmlElement(name = "AuditInfo", required = true)
    protected AuditInfoType auditInfo;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "ExternalCriteriaTypeCode", required = true)
    protected String externalCriteriaTypeCode;
    @XmlElement(name = "OrganisationalGroup", required = true)
    protected OrganisationalGroupType organisationalGroup;
    @XmlElement(name = "ValidFromDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validFromDate;
    @XmlElement(name = "ValidToDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validToDate;

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
     * Obtiene el valor de la propiedad externalCriteriaTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCriteriaTypeCode() {
        return externalCriteriaTypeCode;
    }

    /**
     * Define el valor de la propiedad externalCriteriaTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCriteriaTypeCode(String value) {
        this.externalCriteriaTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad organisationalGroup.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationalGroupType }
     *     
     */
    public OrganisationalGroupType getOrganisationalGroup() {
        return organisationalGroup;
    }

    /**
     * Define el valor de la propiedad organisationalGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationalGroupType }
     *     
     */
    public void setOrganisationalGroup(OrganisationalGroupType value) {
        this.organisationalGroup = value;
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
