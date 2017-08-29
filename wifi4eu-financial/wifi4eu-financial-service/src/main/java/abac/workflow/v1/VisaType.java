
package abac.workflow.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para VisaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VisaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ActionCode" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}ActionCodeType"/&gt;
 *         &lt;element name="ActionDate" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="AgentId" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}AgentIdType" minOccurs="0"/&gt;
 *         &lt;element name="CommentText" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}CommentTextType" minOccurs="0"/&gt;
 *         &lt;element name="PersonId" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}PersonIdType" minOccurs="0"/&gt;
 *         &lt;element name="SignAsAgentType" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}SignAsAgentTypeType" minOccurs="0"/&gt;
 *         &lt;element name="Signature" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}SignatureType" minOccurs="0"/&gt;
 *         &lt;element name="SuppliedAgentName" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}SuppliedAgentNameType" minOccurs="0"/&gt;
 *         &lt;element name="WorkflowCenterCode" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowCenterCodeType"/&gt;
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
@XmlType(name = "VisaType", propOrder = {
    "actionCode",
    "actionDate",
    "agentId",
    "commentText",
    "personId",
    "signAsAgentType",
    "signature",
    "suppliedAgentName",
    "workflowCenterCode",
    "workflowOrganisationName"
})
public class VisaType {

    @XmlElement(name = "ActionCode", required = true)
    protected String actionCode;
    @XmlElement(name = "ActionDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actionDate;
    @XmlElement(name = "AgentId")
    protected String agentId;
    @XmlElement(name = "CommentText")
    protected String commentText;
    @XmlElement(name = "PersonId")
    protected String personId;
    @XmlElement(name = "SignAsAgentType")
    protected String signAsAgentType;
    @XmlElement(name = "Signature")
    protected String signature;
    @XmlElement(name = "SuppliedAgentName")
    protected String suppliedAgentName;
    @XmlElement(name = "WorkflowCenterCode", required = true)
    protected String workflowCenterCode;
    @XmlElement(name = "WorkflowOrganisationName", required = true)
    protected String workflowOrganisationName;

    /**
     * Obtiene el valor de la propiedad actionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Define el valor de la propiedad actionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

    /**
     * Obtiene el valor de la propiedad actionDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActionDate() {
        return actionDate;
    }

    /**
     * Define el valor de la propiedad actionDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActionDate(XMLGregorianCalendar value) {
        this.actionDate = value;
    }

    /**
     * Obtiene el valor de la propiedad agentId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * Define el valor de la propiedad agentId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentId(String value) {
        this.agentId = value;
    }

    /**
     * Obtiene el valor de la propiedad commentText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * Define el valor de la propiedad commentText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentText(String value) {
        this.commentText = value;
    }

    /**
     * Obtiene el valor de la propiedad personId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * Define el valor de la propiedad personId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonId(String value) {
        this.personId = value;
    }

    /**
     * Obtiene el valor de la propiedad signAsAgentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignAsAgentType() {
        return signAsAgentType;
    }

    /**
     * Define el valor de la propiedad signAsAgentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignAsAgentType(String value) {
        this.signAsAgentType = value;
    }

    /**
     * Obtiene el valor de la propiedad signature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Define el valor de la propiedad signature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Obtiene el valor de la propiedad suppliedAgentName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuppliedAgentName() {
        return suppliedAgentName;
    }

    /**
     * Define el valor de la propiedad suppliedAgentName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuppliedAgentName(String value) {
        this.suppliedAgentName = value;
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
