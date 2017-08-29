
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.prefinancing_clearing.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para StandAlonePrefinancingClearingType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="StandAlonePrefinancingClearingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/prefinancing_clearing/v1}PrefinancingClearingWithEuroType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResponsibleOrganisationName" type="{http://www.ec.europa.eu/budg/abac/organisation/v1}NameType" minOccurs="0"/&gt;
 *         &lt;element name="ResponsibleOrganisationTypeCode" type="{http://www.ec.europa.eu/budg/abac/organisation_type/v1}TypeCodeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandAlonePrefinancingClearingType", propOrder = {
    "responsibleOrganisationName",
    "responsibleOrganisationTypeCode"
})
public class StandAlonePrefinancingClearingType
    extends PrefinancingClearingWithEuroType
{

    @XmlElement(name = "ResponsibleOrganisationName")
    protected String responsibleOrganisationName;
    @XmlElement(name = "ResponsibleOrganisationTypeCode")
    protected String responsibleOrganisationTypeCode;

    /**
     * Obtiene el valor de la propiedad responsibleOrganisationName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleOrganisationName() {
        return responsibleOrganisationName;
    }

    /**
     * Define el valor de la propiedad responsibleOrganisationName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleOrganisationName(String value) {
        this.responsibleOrganisationName = value;
    }

    /**
     * Obtiene el valor de la propiedad responsibleOrganisationTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleOrganisationTypeCode() {
        return responsibleOrganisationTypeCode;
    }

    /**
     * Define el valor de la propiedad responsibleOrganisationTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleOrganisationTypeCode(String value) {
        this.responsibleOrganisationTypeCode = value;
    }

}
