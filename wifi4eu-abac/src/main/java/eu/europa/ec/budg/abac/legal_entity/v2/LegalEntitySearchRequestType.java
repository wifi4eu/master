
package eu.europa.ec.budg.abac.legal_entity.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.europa.ec.budg.abac.message.v1.SearchMessageRequestType;


/**
 * <p>Clase Java para LegalEntitySearchRequestType complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="LegalEntitySearchRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}SearchMessageRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SearchCriteria" type="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntitySearchCriteriaType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntitySearchRequestType", propOrder = {
        "searchCriteria"
})
public class LegalEntitySearchRequestType
        extends SearchMessageRequestType {

    @XmlElement(name = "SearchCriteria", required = true)
    protected LegalEntitySearchCriteriaType searchCriteria;

    /**
     * Obtiene el valor de la propiedad searchCriteria.
     *
     * @return possible object is
     * {@link LegalEntitySearchCriteriaType }
     */
    public LegalEntitySearchCriteriaType getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * Define el valor de la propiedad searchCriteria.
     *
     * @param value allowed object is
     *              {@link LegalEntitySearchCriteriaType }
     */
    public void setSearchCriteria(LegalEntitySearchCriteriaType value) {
        this.searchCriteria = value;
    }

}
