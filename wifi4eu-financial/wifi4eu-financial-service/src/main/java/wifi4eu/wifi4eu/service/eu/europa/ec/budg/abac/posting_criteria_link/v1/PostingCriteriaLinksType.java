
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.posting_criteria_link.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PostingCriteriaLinksType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PostingCriteriaLinksType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PostingCriteriaLink" type="{http://www.ec.europa.eu/budg/abac/posting_criteria_link/v1}PostingCriteriaLinkType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostingCriteriaLinksType", propOrder = {
    "postingCriteriaLink"
})
public class PostingCriteriaLinksType {

    @XmlElement(name = "PostingCriteriaLink", required = true)
    protected List<PostingCriteriaLinkType> postingCriteriaLink;

    /**
     * Gets the value of the postingCriteriaLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postingCriteriaLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostingCriteriaLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostingCriteriaLinkType }
     * 
     * 
     */
    public List<PostingCriteriaLinkType> getPostingCriteriaLink() {
        if (postingCriteriaLink == null) {
            postingCriteriaLink = new ArrayList<PostingCriteriaLinkType>();
        }
        return this.postingCriteriaLink;
    }

}
