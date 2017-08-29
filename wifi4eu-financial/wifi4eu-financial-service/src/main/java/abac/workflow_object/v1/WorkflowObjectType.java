
package abac.workflow_object.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import abac.abac_object.v1.AbacObjectType;
import abac.local_abac_document.v1.LocalAbacDocumentType;


/**
 * <p>Clase Java para WorkflowObjectType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WorkflowObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/abac_object/v1}AbacObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="WorkflowInfo" type="{http://www.ec.europa.eu/budg/abac/workflow_object/v1}WorkflowInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowObjectType", propOrder = {
    "workflowInfo"
})
@XmlSeeAlso({
    LocalAbacDocumentType.class
})
public abstract class WorkflowObjectType
    extends AbacObjectType
{

    @XmlElement(name = "WorkflowInfo")
    protected WorkflowInfoType workflowInfo;

    /**
     * Obtiene el valor de la propiedad workflowInfo.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowInfoType }
     *     
     */
    public WorkflowInfoType getWorkflowInfo() {
        return workflowInfo;
    }

    /**
     * Define el valor de la propiedad workflowInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowInfoType }
     *     
     */
    public void setWorkflowInfo(WorkflowInfoType value) {
        this.workflowInfo = value;
    }

}
