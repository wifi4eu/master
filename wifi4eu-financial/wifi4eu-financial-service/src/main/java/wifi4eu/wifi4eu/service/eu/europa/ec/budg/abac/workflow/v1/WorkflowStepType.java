
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.workflow.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para WorkflowStepType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WorkflowStepType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Description" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}StepDescriptionType"/&gt;
 *         &lt;element name="NormalActionCode" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}ActionCodeType"/&gt;
 *         &lt;element name="RoleName" type="{http://www.ec.europa.eu/budg/abac/security/v1}RoleNameType"/&gt;
 *         &lt;element name="StepId" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}StepIdType"/&gt;
 *         &lt;element name="WorkflowCenterCode" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowCenterCodeType"/&gt;
 *         &lt;element name="WorkflowModelDescription" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}WorkflowModelDescriptionType"/&gt;
 *         &lt;element name="WorkflowOrganisationName" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowOrganisationNameType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowStepType", propOrder = {
    "description",
    "normalActionCode",
    "roleName",
    "stepId",
    "workflowCenterCode",
    "workflowModelDescription",
    "workflowOrganisationName"
})
public class WorkflowStepType {

    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "NormalActionCode", required = true)
    protected String normalActionCode;
    @XmlElement(name = "RoleName", required = true)
    protected String roleName;
    @XmlElement(name = "StepId", required = true)
    protected BigInteger stepId;
    @XmlElement(name = "WorkflowCenterCode", required = true)
    protected String workflowCenterCode;
    @XmlElement(name = "WorkflowModelDescription", required = true)
    protected String workflowModelDescription;
    @XmlElement(name = "WorkflowOrganisationName", required = true)
    protected String workflowOrganisationName;

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
     * Obtiene el valor de la propiedad normalActionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNormalActionCode() {
        return normalActionCode;
    }

    /**
     * Define el valor de la propiedad normalActionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNormalActionCode(String value) {
        this.normalActionCode = value;
    }

    /**
     * Obtiene el valor de la propiedad roleName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Define el valor de la propiedad roleName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

    /**
     * Obtiene el valor de la propiedad stepId.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStepId() {
        return stepId;
    }

    /**
     * Define el valor de la propiedad stepId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStepId(BigInteger value) {
        this.stepId = value;
    }

    /**
     * Obtiene el valor de la propiedad workflowCenterCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowCenterCode() {
        return workflowCenterCode;
    }

    /**
     * Define el valor de la propiedad workflowCenterCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowCenterCode(String value) {
        this.workflowCenterCode = value;
    }

    /**
     * Obtiene el valor de la propiedad workflowModelDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowModelDescription() {
        return workflowModelDescription;
    }

    /**
     * Define el valor de la propiedad workflowModelDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowModelDescription(String value) {
        this.workflowModelDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad workflowOrganisationName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowOrganisationName() {
        return workflowOrganisationName;
    }

    /**
     * Define el valor de la propiedad workflowOrganisationName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowOrganisationName(String value) {
        this.workflowOrganisationName = value;
    }

}
