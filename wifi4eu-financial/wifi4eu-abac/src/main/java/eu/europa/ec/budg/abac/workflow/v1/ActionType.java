
package eu.europa.ec.budg.abac.workflow.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ActionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ActionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}ActionCodeType"/&gt;
 *         &lt;element name="Decscription" type="{http://www.ec.europa.eu/budg/abac/workflow/v1}ActionDescriptionType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionType", propOrder = {
    "code",
    "decscription"
})
public class ActionType {

    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Decscription", required = true)
    protected String decscription;

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
     * Obtiene el valor de la propiedad decscription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecscription() {
        return decscription;
    }

    /**
     * Define el valor de la propiedad decscription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecscription(String value) {
        this.decscription = value;
    }

}
