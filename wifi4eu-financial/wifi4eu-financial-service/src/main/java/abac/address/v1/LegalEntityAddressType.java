
package abac.address.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegalEntityAddressType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegalEntityAddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/address/v1}BankAccountAddressType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StreetNr2" type="{http://www.ec.europa.eu/budg/abac/address/v1}StreetNr2Type" minOccurs="0"/&gt;
 *         &lt;element name="StreetNr3" type="{http://www.ec.europa.eu/budg/abac/address/v1}StreetNr3Type" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntityAddressType", propOrder = {
    "streetNr2",
    "streetNr3"
})
public class LegalEntityAddressType
    extends BankAccountAddressType
{

    @XmlElement(name = "StreetNr2")
    protected String streetNr2;
    @XmlElement(name = "StreetNr3")
    protected String streetNr3;

    /**
     * Obtiene el valor de la propiedad streetNr2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNr2() {
        return streetNr2;
    }

    /**
     * Define el valor de la propiedad streetNr2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNr2(String value) {
        this.streetNr2 = value;
    }

    /**
     * Obtiene el valor de la propiedad streetNr3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNr3() {
        return streetNr3;
    }

    /**
     * Define el valor de la propiedad streetNr3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNr3(String value) {
        this.streetNr3 = value;
    }

}
