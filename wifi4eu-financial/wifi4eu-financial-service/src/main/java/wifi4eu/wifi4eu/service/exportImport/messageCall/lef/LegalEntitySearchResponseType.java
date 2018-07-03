
package wifi4eu.wifi4eu.service.exportImport.messageCall.lef;

import eu.europa.ec.budg.abac.message.v1.SearchMessageResponseType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Clase Java para LegalEntitySearchResponseType complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="LegalEntitySearchResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}SearchMessageResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.ec.europa.eu/budg/abac/legal_entity/v2}LegalEntitySearchChoiceGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalEntitySearchResponseType", propOrder = {
        "legalEntitySearchChoiceGroup"
})
public class LegalEntitySearchResponseType
        extends SearchMessageResponseType {

    @XmlElements({
            @XmlElement(name = "PrivatePersonSearch", type = PrivatePersonSearchType.class),
            @XmlElement(name = "StaffMemberSearch", type = StaffMemberSearchType.class),
            @XmlElement(name = "ExStaffMemberSearch", type = ExStaffMemberSearchType.class),
            @XmlElement(name = "EuropeanParliamentMemberSearch", type = EuropeanParliamentMemberSearchType.class),
            @XmlElement(name = "PublicLawBodySearch", type = PublicLawBodySearchType.class),
            @XmlElement(name = "PrivateLawBodySearch", type = PrivateLawBodySearchType.class),
            @XmlElement(name = "TechnicalLegalEntitySearch", type = TechnicalLegalEntitySearchType.class)
    })
    protected List<LegalEntitySearchType> legalEntitySearchChoiceGroup;

    /**
     * Gets the value of the legalEntitySearchChoiceGroup property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legalEntitySearchChoiceGroup property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegalEntitySearchChoiceGroup().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrivatePersonSearchType }
     * {@link StaffMemberSearchType }
     * {@link ExStaffMemberSearchType }
     * {@link EuropeanParliamentMemberSearchType }
     * {@link PublicLawBodySearchType }
     * {@link PrivateLawBodySearchType }
     * {@link TechnicalLegalEntitySearchType }
     */
    public List<LegalEntitySearchType> getLegalEntitySearchChoiceGroup() {
        if (legalEntitySearchChoiceGroup == null) {
            legalEntitySearchChoiceGroup = new ArrayList<LegalEntitySearchType>();
        }
        return this.legalEntitySearchChoiceGroup;
    }

}
