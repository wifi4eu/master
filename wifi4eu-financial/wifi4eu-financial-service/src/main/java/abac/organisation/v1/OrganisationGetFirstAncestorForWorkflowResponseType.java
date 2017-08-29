
package abac.organisation.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import abac.message.v1.MessageResponseType;


/**
 * <p>Clase Java para OrganisationGetFirstAncestorForWorkflowResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OrganisationGetFirstAncestorForWorkflowResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Organisation" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}OrganisationType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganisationGetFirstAncestorForWorkflowResponseType", propOrder = {
    "organisation"
})
public class OrganisationGetFirstAncestorForWorkflowResponseType
    extends MessageResponseType
{

    @XmlElement(name = "Organisation", required = true)
    protected OrganisationType organisation;

    /**
     * Obtiene el valor de la propiedad organisation.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationType }
     *     
     */
    public OrganisationType getOrganisation() {
        return organisation;
    }

    /**
     * Define el valor de la propiedad organisation.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationType }
     *     
     */
    public void setOrganisation(OrganisationType value) {
        this.organisation = value;
    }

}
