
package abac.contractor_reference.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ContractorReferencesType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ContractorReferencesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.ec.europa.eu/budg/abac/contractor_reference/v1}ContractorReferenceChoiceGroup" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractorReferencesType", propOrder = {
    "contractorReferenceChoiceGroup"
})
public class ContractorReferencesType {

    @XmlElements({
        @XmlElement(name = "PrimaryContractorReference", type = PrimaryContractorReferenceType.class),
        @XmlElement(name = "SecondaryContractorReference", type = SecondaryContractorReferenceType.class),
        @XmlElement(name = "HistoricalContractorReference", type = HistoricalContractorReferenceType.class)
    })
    protected List<ContractorReferenceType> contractorReferenceChoiceGroup;

    /**
     * Gets the value of the contractorReferenceChoiceGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractorReferenceChoiceGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractorReferenceChoiceGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrimaryContractorReferenceType }
     * {@link SecondaryContractorReferenceType }
     * {@link HistoricalContractorReferenceType }
     * 
     * 
     */
    public List<ContractorReferenceType> getContractorReferenceChoiceGroup() {
        if (contractorReferenceChoiceGroup == null) {
            contractorReferenceChoiceGroup = new ArrayList<ContractorReferenceType>();
        }
        return this.contractorReferenceChoiceGroup;
    }

}
