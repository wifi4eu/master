
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.address.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BankAccountAddressType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BankAccountAddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/address/v1}AddressType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="County" type="{http://www.ec.europa.eu/budg/abac/address/v1}CountyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankAccountAddressType", propOrder = {
    "county"
})
@XmlSeeAlso({
    LegalEntityAddressType.class
})
public class BankAccountAddressType
    extends AddressType
{

    @XmlElement(name = "County")
    protected String county;

    /**
     * Obtiene el valor de la propiedad county.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Define el valor de la propiedad county.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
    }

}
