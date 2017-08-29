
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.legal_entity.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para StaffMemberSearchType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="StaffMemberSearchType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}NaturalPersonSearchType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NupNumber" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}NupNumberType" minOccurs="0"/&gt;
 *         &lt;element name="PersonalId" type="{http://www.ec.europa.eu/budg/abac/legal_entity/simple_type/v1}PersonalIdType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StaffMemberSearchType", propOrder = {
    "nupNumber",
    "personalId"
})
@XmlSeeAlso({
    EuropeanParliamentMemberSearchType.class
})
public class StaffMemberSearchType
    extends NaturalPersonSearchType
{

    @XmlElement(name = "NupNumber")
    protected String nupNumber;
    @XmlElement(name = "PersonalId")
    protected BigInteger personalId;

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

    /**
     * Obtiene el valor de la propiedad personalId.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPersonalId() {
        return personalId;
    }

    /**
     * Define el valor de la propiedad personalId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPersonalId(BigInteger value) {
        this.personalId = value;
    }

}
