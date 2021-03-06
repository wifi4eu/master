
package eu.europa.ec.budg.abac.legal_entity.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ExStaffMemberGetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ExStaffMemberGetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}PrivatePersonGetType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NupNumber" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}NupNumberType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExStaffMemberGetType", propOrder = {
    "nupNumber"
})
public class ExStaffMemberGetType
    extends PrivatePersonGetType
{

    @XmlElement(name = "NupNumber")
    protected String nupNumber;

    /**
     * Obtiene el valor de la propiedad nupNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNupNumber() {
        return nupNumber;
    }

    /**
     * Define el valor de la propiedad nupNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNupNumber(String value) {
        this.nupNumber = value;
    }

}
