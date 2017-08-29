
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PrivatePersonSearchType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PrivatePersonSearchType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}NaturalPersonSearchType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BirthCity" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}BirthCityType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivatePersonSearchType", propOrder = {
    "birthCity"
})
@XmlSeeAlso({
    ExStaffMemberSearchType.class
})
public class PrivatePersonSearchType
    extends NaturalPersonSearchType
{

    @XmlElement(name = "BirthCity")
    protected String birthCity;

    /**
     * Obtiene el valor de la propiedad birthCity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthCity() {
        return birthCity;
    }

    /**
     * Define el valor de la propiedad birthCity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthCity(String value) {
        this.birthCity = value;
    }

}
