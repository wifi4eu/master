
package eu.europa.ec.budg.abac.local_abac_document.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.europa.ec.budg.abac.ares_document.v1.AresDocumentType;
import eu.europa.ec.budg.abac.scanned_document.v1.ScannedDocumentWithoutContentType;
import eu.europa.ec.budg.abac.supporting_document.v1.SupportingDocumentFolderType;
import eu.europa.ec.budg.abac.external_criteria.v1.ExternalCriteriasType;
import eu.europa.ec.budg.abac.workflow_object.v1.WorkflowObjectType;


/**
 * <p>Clase Java para LocalAbacDocumentType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LocalAbacDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AresDocuments" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AresDocument" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ExternalCriterias" type="{http://www.ec.europa.eu/budg/abac/external_criteria/v1}ExternalCriteriasType" minOccurs="0"/&gt;
 *         &lt;element name="FileReference" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}FileReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="Project" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}ProjectType" minOccurs="0"/&gt;
 *         &lt;element name="Remarks" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}RemarksType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisation" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Name" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}NameType"/&gt;
 *                   &lt;element name="TypeCode" type="{http://www.ec.europa.eu/budg/abac/organisation_type/v1}TypeCodeType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ResponsibleUsers" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}ResponsibleUsersType" minOccurs="0"/&gt;
 *         &lt;element name="ScannedDocuments" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ScannedDocument" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ScannedDocumentWithoutContentType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SupportingDocumentFolder" type="{http://www.ec.europa.eu/budg/abac/supporting_document/v1}SupportingDocumentFolderType" minOccurs="0"/&gt;
 *         &lt;element name="UserReference" type="{http://www.ec.europa.eu/budg/abac/local_abac_document/v1}UserReferenceType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalAbacDocumentType", propOrder = {
    "aresDocuments",
    "externalCriterias",
    "fileReference",
    "project",
    "remarks",
    "responsibleOrganisation",
    "responsibleUsers",
    "scannedDocuments",
    "supportingDocumentFolder",
    "userReference"
})
public abstract class LocalAbacDocumentType
    extends WorkflowObjectType
{

    @XmlElement(name = "AresDocuments")
    protected AresDocuments aresDocuments;
    @XmlElement(name = "ExternalCriterias")
    protected ExternalCriteriasType externalCriterias;
    @XmlElement(name = "FileReference")
    protected String fileReference;
    @XmlElement(name = "Project")
    protected String project;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "ResponsibleOrganisation")
    protected ResponsibleOrganisation responsibleOrganisation;
    @XmlElement(name = "ResponsibleUsers")
    protected ResponsibleUsersType responsibleUsers;
    @XmlElement(name = "ScannedDocuments")
    protected ScannedDocuments scannedDocuments;
    @XmlElement(name = "SupportingDocumentFolder")
    protected SupportingDocumentFolderType supportingDocumentFolder;
    @XmlElement(name = "UserReference", required = true)
    protected String userReference;

    /**
     * Obtiene el valor de la propiedad aresDocuments.
     * 
     * @return
     *     possible object is
     *     {@link AresDocuments }
     *     
     */
    public AresDocuments getAresDocuments() {
        return aresDocuments;
    }

    /**
     * Define el valor de la propiedad aresDocuments.
     * 
     * @param value
     *     allowed object is
     *     {@link AresDocuments }
     *     
     */
    public void setAresDocuments(AresDocuments value) {
        this.aresDocuments = value;
    }

    /**
     * Obtiene el valor de la propiedad externalCriterias.
     * 
     * @return
     *     possible object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public ExternalCriteriasType getExternalCriterias() {
        return externalCriterias;
    }

    /**
     * Define el valor de la propiedad externalCriterias.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public void setExternalCriterias(ExternalCriteriasType value) {
        this.externalCriterias = value;
    }

    /**
     * Obtiene el valor de la propiedad fileReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileReference() {
        return fileReference;
    }

    /**
     * Define el valor de la propiedad fileReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileReference(String value) {
        this.fileReference = value;
    }

    /**
     * Obtiene el valor de la propiedad project.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProject() {
        return project;
    }

    /**
     * Define el valor de la propiedad project.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProject(String value) {
        this.project = value;
    }

    /**
     * Obtiene el valor de la propiedad remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define el valor de la propiedad remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleOrganisation.
     * 
     * @return
     *     possible object is
     *     {@link ResponsibleOrganisation }
     *     
     */
    public ResponsibleOrganisation getResponsibleOrganisation() {
        return responsibleOrganisation;
    }

    /**
     * Define el valor de la propiedad responsibleOrganisation.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsibleOrganisation }
     *     
     */
    public void setResponsibleOrganisation(ResponsibleOrganisation value) {
        this.responsibleOrganisation = value;
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
     *     {@link ScannedDocuments }
     *     
     */
    public ScannedDocuments getScannedDocuments() {
        return scannedDocuments;
    }

    /**
     * Define el valor de la propiedad scannedDocuments.
     * 
     * @param value
     *     allowed object is
     *     {@link ScannedDocuments }
     *     
     */
    public void setScannedDocuments(ScannedDocuments value) {
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
     * Obtiene el valor de la propiedad userReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserReference() {
        return userReference;
    }

    /**
     * Define el valor de la propiedad userReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserReference(String value) {
        this.userReference = value;
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
     *         &lt;element name="AresDocument" type="{http://www.ec.europa.eu/budg/abac/ares_document/v1}AresDocumentType" maxOccurs="unbounded"/&gt;
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
        "aresDocument"
    })
    public static class AresDocuments {

        @XmlElement(name = "AresDocument", required = true)
        protected List<AresDocumentType> aresDocument;

        /**
         * Gets the value of the aresDocument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the aresDocument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAresDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AresDocumentType }
         * 
         * 
         */
        public List<AresDocumentType> getAresDocument() {
            if (aresDocument == null) {
                aresDocument = new ArrayList<AresDocumentType>();
            }
            return this.aresDocument;
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
     *         &lt;element name="Name" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}NameType"/&gt;
     *         &lt;element name="TypeCode" type="{http://www.ec.europa.eu/budg/abac/organisation_type/v1}TypeCodeType"/&gt;
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
        "name",
        "typeCode"
    })
    public static class ResponsibleOrganisation {

        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "TypeCode", required = true)
        protected String typeCode;

        /**
         * Obtiene el valor de la propiedad name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Define el valor de la propiedad name.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Obtiene el valor de la propiedad typeCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeCode() {
            return typeCode;
        }

        /**
         * Define el valor de la propiedad typeCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeCode(String value) {
            this.typeCode = value;
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
     *         &lt;element name="ScannedDocument" type="{http://www.ec.europa.eu/budg/abac/scanned_document/v1}ScannedDocumentWithoutContentType" maxOccurs="unbounded"/&gt;
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
        "scannedDocument"
    })
    public static class ScannedDocuments {

        @XmlElement(name = "ScannedDocument", required = true)
        protected List<ScannedDocumentWithoutContentType> scannedDocument;

        /**
         * Gets the value of the scannedDocument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the scannedDocument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getScannedDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ScannedDocumentWithoutContentType }
         * 
         * 
         */
        public List<ScannedDocumentWithoutContentType> getScannedDocument() {
            if (scannedDocument == null) {
                scannedDocument = new ArrayList<ScannedDocumentWithoutContentType>();
            }
            return this.scannedDocument;
        }

    }

}
