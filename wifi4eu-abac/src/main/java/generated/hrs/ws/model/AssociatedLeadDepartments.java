
package generated.hrs.ws.model;

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
 * A list of associated lead departments of a File
 * 
 * <p>Java class for AssociatedLeadDepartments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssociatedLeadDepartments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="associatedLeadDepartment" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociatedLeadDepartments", propOrder = {
    "associatedLeadDepartment"
})
public class AssociatedLeadDepartments
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<String> associatedLeadDepartment;

    /**
     * Gets the value of the associatedLeadDepartment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedLeadDepartment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedLeadDepartment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAssociatedLeadDepartment() {
        if (associatedLeadDepartment == null) {
            associatedLeadDepartment = new ArrayList<String>();
        }
        return this.associatedLeadDepartment;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AssociatedLeadDepartments)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AssociatedLeadDepartments that = ((AssociatedLeadDepartments) object);
        {
            List<String> lhsAssociatedLeadDepartment;
            lhsAssociatedLeadDepartment = (((this.associatedLeadDepartment!= null)&&(!this.associatedLeadDepartment.isEmpty()))?this.getAssociatedLeadDepartment():null);
            List<String> rhsAssociatedLeadDepartment;
            rhsAssociatedLeadDepartment = (((that.associatedLeadDepartment!= null)&&(!that.associatedLeadDepartment.isEmpty()))?that.getAssociatedLeadDepartment():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "associatedLeadDepartment", lhsAssociatedLeadDepartment), LocatorUtils.property(thatLocator, "associatedLeadDepartment", rhsAssociatedLeadDepartment), lhsAssociatedLeadDepartment, rhsAssociatedLeadDepartment)) {
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
            List<String> theAssociatedLeadDepartment;
            theAssociatedLeadDepartment = (((this.associatedLeadDepartment!= null)&&(!this.associatedLeadDepartment.isEmpty()))?this.getAssociatedLeadDepartment():null);
            strategy.appendField(locator, this, "associatedLeadDepartment", buffer, theAssociatedLeadDepartment);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<String> theAssociatedLeadDepartment;
            theAssociatedLeadDepartment = (((this.associatedLeadDepartment!= null)&&(!this.associatedLeadDepartment.isEmpty()))?this.getAssociatedLeadDepartment():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "associatedLeadDepartment", theAssociatedLeadDepartment), currentHashCode, theAssociatedLeadDepartment);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
