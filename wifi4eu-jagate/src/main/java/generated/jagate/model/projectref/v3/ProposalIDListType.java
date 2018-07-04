
package generated.jagate.model.projectref.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for ProposalIDListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProposalIDListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProposalID" type="{http://ec.europa.eu/research/fp/model/project-ref/V3}ProjectIdType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProposalIDListType", propOrder = {
    "proposalID"
})
public class ProposalIDListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ProposalID")
    protected List<ProjectIdType> proposalID;

    /**
     * Gets the value of the proposalID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proposalID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProposalID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProjectIdType }
     * 
     * 
     */
    public List<ProjectIdType> getProposalID() {
        if (proposalID == null) {
            proposalID = new ArrayList<ProjectIdType>();
        }
        return this.proposalID;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProposalIDListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ProposalIDListType that = ((ProposalIDListType) object);
        {
            List<ProjectIdType> lhsProposalID;
            lhsProposalID = (((this.proposalID!= null)&&(!this.proposalID.isEmpty()))?this.getProposalID():null);
            List<ProjectIdType> rhsProposalID;
            rhsProposalID = (((that.proposalID!= null)&&(!that.proposalID.isEmpty()))?that.getProposalID():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "proposalID", lhsProposalID), LocatorUtils.property(thatLocator, "proposalID", rhsProposalID), lhsProposalID, rhsProposalID)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            List<ProjectIdType> theProposalID;
            theProposalID = (((this.proposalID!= null)&&(!this.proposalID.isEmpty()))?this.getProposalID():null);
            strategy.appendField(locator, this, "proposalID", buffer, theProposalID);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ProjectIdType> theProposalID;
            theProposalID = (((this.proposalID!= null)&&(!this.proposalID.isEmpty()))?this.getProposalID():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "proposalID", theProposalID), currentHashCode, theProposalID);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
