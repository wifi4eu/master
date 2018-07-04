
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
 * <p>Java class for ProjectRefListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProjectRefListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResearchProjectRef" type="{http://ec.europa.eu/research/fp/model/project-ref/V3}ProjectRefType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProjectRefListType", propOrder = {
    "researchProjectRef"
})
public class ProjectRefListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ResearchProjectRef")
    protected List<ProjectRefType> researchProjectRef;

    /**
     * Gets the value of the researchProjectRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the researchProjectRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResearchProjectRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProjectRefType }
     * 
     * 
     */
    public List<ProjectRefType> getResearchProjectRef() {
        if (researchProjectRef == null) {
            researchProjectRef = new ArrayList<ProjectRefType>();
        }
        return this.researchProjectRef;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProjectRefListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ProjectRefListType that = ((ProjectRefListType) object);
        {
            List<ProjectRefType> lhsResearchProjectRef;
            lhsResearchProjectRef = (((this.researchProjectRef!= null)&&(!this.researchProjectRef.isEmpty()))?this.getResearchProjectRef():null);
            List<ProjectRefType> rhsResearchProjectRef;
            rhsResearchProjectRef = (((that.researchProjectRef!= null)&&(!that.researchProjectRef.isEmpty()))?that.getResearchProjectRef():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "researchProjectRef", lhsResearchProjectRef), LocatorUtils.property(thatLocator, "researchProjectRef", rhsResearchProjectRef), lhsResearchProjectRef, rhsResearchProjectRef)) {
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
            List<ProjectRefType> theResearchProjectRef;
            theResearchProjectRef = (((this.researchProjectRef!= null)&&(!this.researchProjectRef.isEmpty()))?this.getResearchProjectRef():null);
            strategy.appendField(locator, this, "researchProjectRef", buffer, theResearchProjectRef);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ProjectRefType> theResearchProjectRef;
            theResearchProjectRef = (((this.researchProjectRef!= null)&&(!this.researchProjectRef.isEmpty()))?this.getResearchProjectRef():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "researchProjectRef", theResearchProjectRef), currentHashCode, theResearchProjectRef);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
