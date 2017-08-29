
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.budgetary_commitment_level2.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.associated_country.v1.AssociatedCountriesType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.external_criteria.v1.ExternalCriteriasType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.posting_criteria_link.v1.PostingCriteriaLinksType;
import wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.wbs.v1.WbsType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2PositionCreateType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2PositionCreateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2PositionWritableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AssociatedCountries" type="{http://www.ec.europa.eu/budg/abac/associated_country/v1}AssociatedCountriesType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriterias" type="{http://www.ec.europa.eu/budg/abac/external_criteria/v1}ExternalCriteriasType" minOccurs="0"/&gt;
 *         &lt;element name="PostingCriteriaLinks" type="{http://www.ec.europa.eu/budg/abac/posting_criteria_link/v1}PostingCriteriaLinksType" minOccurs="0"/&gt;
 *         &lt;element name="Wbs" type="{http://www.ec.europa.eu/budg/abac/wbs/v1}WbsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2PositionCreateType", propOrder = {
    "associatedCountries",
    "externalCriterias",
    "postingCriteriaLinks",
    "wbs"
})
@XmlSeeAlso({
    BudgetaryCommitmentLevel2PositionGetType.class
})
public class BudgetaryCommitmentLevel2PositionCreateType
    extends BudgetaryCommitmentLevel2PositionWritableType
{

    @XmlElement(name = "AssociatedCountries")
    protected AssociatedCountriesType associatedCountries;
    @XmlElement(name = "ExternalCriterias")
    protected ExternalCriteriasType externalCriterias;
    @XmlElement(name = "PostingCriteriaLinks")
    protected PostingCriteriaLinksType postingCriteriaLinks;
    @XmlElement(name = "Wbs")
    protected WbsType wbs;

    /**
     * Obtiene el valor de la propiedad associatedCountries.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedCountriesType }
     *     
     */
    public AssociatedCountriesType getAssociatedCountries() {
        return associatedCountries;
    }

    /**
     * Define el valor de la propiedad associatedCountries.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedCountriesType }
     *     
     */
    public void setAssociatedCountries(AssociatedCountriesType value) {
        this.associatedCountries = value;
    }

    /**
     * Obtiene el valor de la propiedad externalCriterias.
     * 
     * @return
     *     possible object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public ExternalCriteriasType getExternalCriterias() {
        return externalCriterias;
    }

    /**
     * Define el valor de la propiedad externalCriterias.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalCriteriasType }
     *     
     */
    public void setExternalCriterias(ExternalCriteriasType value) {
        this.externalCriterias = value;
    }

    /**
     * Obtiene el valor de la propiedad postingCriteriaLinks.
     * 
     * @return
     *     possible object is
     *     {@link PostingCriteriaLinksType }
     *     
     */
    public PostingCriteriaLinksType getPostingCriteriaLinks() {
        return postingCriteriaLinks;
    }

    /**
     * Define el valor de la propiedad postingCriteriaLinks.
     * 
     * @param value
     *     allowed object is
     *     {@link PostingCriteriaLinksType }
     *     
     */
    public void setPostingCriteriaLinks(PostingCriteriaLinksType value) {
        this.postingCriteriaLinks = value;
    }

    /**
     * Obtiene el valor de la propiedad wbs.
     * 
     * @return
     *     possible object is
     *     {@link WbsType }
     *     
     */
    public WbsType getWbs() {
        return wbs;
    }

    /**
     * Define el valor de la propiedad wbs.
     * 
     * @param value
     *     allowed object is
     *     {@link WbsType }
     *     
     */
    public void setWbs(WbsType value) {
        this.wbs = value;
    }

}
