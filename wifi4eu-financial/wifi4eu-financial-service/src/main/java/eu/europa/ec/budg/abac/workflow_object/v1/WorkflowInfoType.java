
package eu.europa.ec.budg.abac.workflow_object.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.central_reference.v1.CentralReferencesType;


/**
 * <p>Clase Java para WorkflowInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WorkflowInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CentralReferences" type="{http://www.ec.europa.eu/budg/abac/central_reference/v1}CentralReferencesType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowCenter" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowCenterCodeType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowLevel" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowLevelType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowOrganisation" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowOrganisationNameType" minOccurs="0"/&gt;
 *         &lt;element name="CurrentWorkflowStatus" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowStatusType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowInfoType", propOrder = {
    "centralReferences",
    "currentWorkflowCenter",
    "currentWorkflowLevel",
    "currentWorkflowOrganisation",
    "currentWorkflowStatus"
})
public class WorkflowInfoType {

    @XmlElement(name = "CentralReferences")
    protected CentralReferencesType centralReferences;
    @XmlElement(name = "CurrentWorkflowCenter")
    protected String currentWorkflowCenter;
    @XmlElement(name = "CurrentWorkflowLevel")
    protected BigInteger currentWorkflowLevel;
    @XmlElement(name = "CurrentWorkflowOrganisation")
    protected String currentWorkflowOrganisation;
    @XmlElement(name = "CurrentWorkflowStatus")
    protected String currentWorkflowStatus;

    /**
     * Obtiene el valor de la propiedad centralReferences.
     * 
     * @return
     *     possible object is
     *     {@link CentralReferencesType }
     *     
     */
    public CentralReferencesType getCentralReferences() {
        return centralReferences;
    }

    /**
     * Define el valor de la propiedad centralReferences.
     * 
     * @param value
     *     allowed object is
     *     {@link CentralReferencesType }
     *     
     */
    public void setCentralReferences(CentralReferencesType value) {
        this.centralReferences = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowCenter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentWorkflowCenter() {
        return currentWorkflowCenter;
    }

    /**
     * Define el valor de la propiedad currentWorkflowCenter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentWorkflowCenter(String value) {
        this.currentWorkflowCenter = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowLevel.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCurrentWorkflowLevel() {
        return currentWorkflowLevel;
    }

    /**
     * Define el valor de la propiedad currentWorkflowLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCurrentWorkflowLevel(BigInteger value) {
        this.currentWorkflowLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowOrganisation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentWorkflowOrganisation() {
        return currentWorkflowOrganisation;
    }

    /**
     * Define el valor de la propiedad currentWorkflowOrganisation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentWorkflowOrganisation(String value) {
        this.currentWorkflowOrganisation = value;
    }

    /**
     * Obtiene el valor de la propiedad currentWorkflowStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentWorkflowStatus() {
        return currentWorkflowStatus;
    }

    /**
     * Define el valor de la propiedad currentWorkflowStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentWorkflowStatus(String value) {
        this.currentWorkflowStatus = value;
    }

}
