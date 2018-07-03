
package wifi4eu.wifi4eu.service.exportImport.messageCall.bc;

import eu.europa.ec.budg.abac.associated_country.v1.AssociatedCountriesType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BudgetaryCommitmentLevel2EnvelopeLinkCreateType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BudgetaryCommitmentLevel2EnvelopeLinkCreateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1}BudgetaryCommitmentLevel2EnvelopeLinkWritableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AssociatedCountries" type="{http://www.ec.europa.eu/budg/abac/associated_country/v1}AssociatedCountriesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BudgetaryCommitmentLevel2EnvelopeLinkCreateType", propOrder = {
    "associatedCountries"
})
public class BudgetaryCommitmentLevel2EnvelopeLinkCreateType
    extends BudgetaryCommitmentLevel2EnvelopeLinkWritableType
{

    @XmlElement(name = "AssociatedCountries")
    protected AssociatedCountriesType associatedCountries;

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

}
