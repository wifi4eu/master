
package eu.europa.ec.budg.abac.early_warning.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import eu.europa.ec.budg.abac.complex_type.v1.PeriodType;


/**
 * <p>Clase Java para EarlyWarningType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EarlyWarningType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ContactName" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}ContactNameType"/&gt;
 *         &lt;element name="CreationDate" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}CreationDateType"/&gt;
 *         &lt;element name="ModificationDate" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}ModificationDateType"/&gt;
 *         &lt;element name="PhoneNumber" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}PhoneNumberType"/&gt;
 *         &lt;element name="Reference" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}ReferenceType"/&gt;
 *         &lt;element name="ResponsibleOrganisation" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}ResponsibleOrganisationType"/&gt;
 *         &lt;element name="SubCode" type="{http://www.ec.europa.eu/budg/abac/early_warning/v1}EarlyWarningSubCodeType"/&gt;
 *         &lt;element name="ValidityPeriod" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}PeriodType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EarlyWarningType", propOrder = {
    "contactName",
    "creationDate",
    "modificationDate",
    "phoneNumber",
    "reference",
    "responsibleOrganisation",
    "subCode",
    "validityPeriod"
})
public class EarlyWarningType {

    @XmlElement(name = "ContactName", required = true)
    protected String contactName;
    @XmlElement(name = "CreationDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "ModificationDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar modificationDate;
    @XmlElement(name = "PhoneNumber", required = true)
    protected String phoneNumber;
    @XmlElement(name = "Reference", required = true)
    protected String reference;
    @XmlElement(name = "ResponsibleOrganisation", required = true)
    protected String responsibleOrganisation;
    @XmlElement(name = "SubCode", required = true)
    protected EarlyWarningSubCodeType subCode;
    @XmlElement(name = "ValidityPeriod", required = true)
    protected PeriodType validityPeriod;

    /**
     * Obtiene el valor de la propiedad contactName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Define el valor de la propiedad contactName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Obtiene el valor de la propiedad creationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Define el valor de la propiedad creationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad modificationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModificationDate() {
        return modificationDate;
    }

    /**
     * Define el valor de la propiedad modificationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModificationDate(XMLGregorianCalendar value) {
        this.modificationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad phoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Define el valor de la propiedad phoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad reference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Define el valor de la propiedad reference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleOrganisation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleOrganisation() {
        return responsibleOrganisation;
    }

    /**
     * Define el valor de la propiedad responsibleOrganisation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleOrganisation(String value) {
        this.responsibleOrganisation = value;
    }

    /**
     * Obtiene el valor de la propiedad subCode.
     * 
     * @return
     *     possible object is
     *     {@link EarlyWarningSubCodeType }
     *     
     */
    public EarlyWarningSubCodeType getSubCode() {
        return subCode;
    }

    /**
     * Define el valor de la propiedad subCode.
     * 
     * @param value
     *     allowed object is
     *     {@link EarlyWarningSubCodeType }
     *     
     */
    public void setSubCode(EarlyWarningSubCodeType value) {
        this.subCode = value;
    }

    /**
     * Obtiene el valor de la propiedad validityPeriod.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Define el valor de la propiedad validityPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setValidityPeriod(PeriodType value) {
        this.validityPeriod = value;
    }

}
