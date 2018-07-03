
package eu.europa.ec.budg.abac.organisational_group.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import eu.europa.ec.budg.abac.complex_type.v1.AuditInfoType;
import eu.europa.ec.budg.abac.organisation.v1.OrganisationType;


/**
 * <p>Clase Java para OrganisationalGroupType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OrganisationalGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuditInfo" type="{http://www.ec.europa.eu/budg/abac/complex_type/v1}AuditInfoType"/&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/organisational_group/v1}CodeType"/&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/organisational_group/v1}DescriptionType"/&gt;
 *         &lt;element name="ValidFromDate" type="{http://www.ec.europa.eu/budg/abac/organisational_group/v1}ValidFromDateType"/&gt;
 *         &lt;element name="ValidToDate" type="{http://www.ec.europa.eu/budg/abac/organisational_group/v1}ValidToDateType"/&gt;
 *         &lt;element name="Organisations" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Organisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}OrganisationType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "OrganisationalGroupType", propOrder = {
    "auditInfo",
    "code",
    "description",
    "validFromDate",
    "validToDate",
    "organisations"
})
public class OrganisationalGroupType {

    @XmlElement(name = "AuditInfo", required = true)
    protected AuditInfoType auditInfo;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "ValidFromDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validFromDate;
    @XmlElement(name = "ValidToDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validToDate;
    @XmlElement(name = "Organisations")
    protected Organisations organisations;

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

    /**
     * Obtiene el valor de la propiedad organisations.
     * 
     * @return
     *     possible object is
     *     {@link Organisations }
     *     
     */
    public Organisations getOrganisations() {
        return organisations;
    }

    /**
     * Define el valor de la propiedad organisations.
     * 
     * @param value
     *     allowed object is
     *     {@link Organisations }
     *     
     */
    public void setOrganisations(Organisations value) {
        this.organisations = value;
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
     *         &lt;element name="Organisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}OrganisationType" maxOccurs="unbounded"/&gt;
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
        "organisation"
    })
    public static class Organisations {

        @XmlElement(name = "Organisation", required = true)
        protected List<OrganisationType> organisation;

        /**
         * Gets the value of the organisation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the organisation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOrganisation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OrganisationType }
         * 
         * 
         */
        public List<OrganisationType> getOrganisation() {
            if (organisation == null) {
                organisation = new ArrayList<OrganisationType>();
            }
            return this.organisation;
        }

    }

}
