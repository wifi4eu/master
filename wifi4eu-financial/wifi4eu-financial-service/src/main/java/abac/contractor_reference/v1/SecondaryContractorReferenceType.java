
package abac.contractor_reference.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SecondaryContractorReferenceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SecondaryContractorReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/contractor_reference/v1}ContractorReferenceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LegalEntityLocalKey" type="{http://www.ec.europa.eu/budg/abac/simple_type/v1}LocalKeyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecondaryContractorReferenceType", propOrder = {
    "legalEntityLocalKey"
})
public class SecondaryContractorReferenceType
    extends ContractorReferenceType
{

    @XmlElement(name = "LegalEntityLocalKey")
    protected String legalEntityLocalKey;

    /**
     * Obtiene el valor de la propiedad legalEntityLocalKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalEntityLocalKey() {
        return legalEntityLocalKey;
    }

    /**
     * Define el valor de la propiedad legalEntityLocalKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalEntityLocalKey(String value) {
        this.legalEntityLocalKey = value;
    }

}
