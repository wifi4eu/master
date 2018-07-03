
package eu.europa.ec.budg.abac.budgetary_commitment_level1.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import eu.europa.ec.budg.abac.associated_country.v1.AssociatedCountriesType;
import eu.europa.ec.budg.abac.external_criteria.v1.ExternalCriteriasType;
import eu.europa.ec.budg.abac.posting_criteria_link.v1.PostingCriteriaLinksType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel1PositionCreateType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel1PositionCreateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level1/v1}BudgetaryCommitmentLevel1PositionWritableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AssociatedCountries" type="{http://www.ec.europa.eu/budg/abac/associated_country/v1}AssociatedCountriesType" minOccurs="0"/&gt;
 *         &lt;element name="ExternalCriterias" type="{http://www.ec.europa.eu/budg/abac/external_criteria/v1}ExternalCriteriasType" minOccurs="0"/&gt;
 *         &lt;element name="PostingCriteriaLinks" type="{http://www.ec.europa.eu/budg/abac/posting_criteria_link/v1}PostingCriteriaLinksType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel1PositionCreateType", propOrder = {
    "associatedCountries",
    "externalCriterias",
    "postingCriteriaLinks"
})
@XmlSeeAlso({
    BudgetaryCommitmentLevel1PositionGetType.class
})
public class BudgetaryCommitmentLevel1PositionCreateType
    extends BudgetaryCommitmentLevel1PositionWritableType
{

    @XmlElement(name = "AssociatedCountries")
    protected AssociatedCountriesType associatedCountries;
    @XmlElement(name = "ExternalCriterias")
    protected ExternalCriteriasType externalCriterias;
    @XmlElement(name = "PostingCriteriaLinks")
    protected PostingCriteriaLinksType postingCriteriaLinks;

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

}
