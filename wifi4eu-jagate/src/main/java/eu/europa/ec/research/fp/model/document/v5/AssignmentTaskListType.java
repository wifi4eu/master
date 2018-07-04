
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for AssignmentTaskListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignmentTaskListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssignmentTask" type="{http://ec.europa.eu/research/fp/model/document/V5}AssignmentTaskType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignmentTaskListType", propOrder = {
    "assignmentTask"
})
public class AssignmentTaskListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AssignmentTask", required = true)
    protected List<AssignmentTaskType> assignmentTask;

    /**
     * Gets the value of the assignmentTask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assignmentTask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssignmentTask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssignmentTaskType }
     * 
     * 
     */
    public List<AssignmentTaskType> getAssignmentTask() {
        if (assignmentTask == null) {
            assignmentTask = new ArrayList<AssignmentTaskType>();
        }
        return this.assignmentTask;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AssignmentTaskListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AssignmentTaskListType that = ((AssignmentTaskListType) object);
        {
            List<AssignmentTaskType> lhsAssignmentTask;
            lhsAssignmentTask = (((this.assignmentTask!= null)&&(!this.assignmentTask.isEmpty()))?this.getAssignmentTask():null);
            List<AssignmentTaskType> rhsAssignmentTask;
            rhsAssignmentTask = (((that.assignmentTask!= null)&&(!that.assignmentTask.isEmpty()))?that.getAssignmentTask():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assignmentTask", lhsAssignmentTask), LocatorUtils.property(thatLocator, "assignmentTask", rhsAssignmentTask), lhsAssignmentTask, rhsAssignmentTask)) {
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
            List<AssignmentTaskType> theAssignmentTask;
            theAssignmentTask = (((this.assignmentTask!= null)&&(!this.assignmentTask.isEmpty()))?this.getAssignmentTask():null);
            strategy.appendField(locator, this, "assignmentTask", buffer, theAssignmentTask);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<AssignmentTaskType> theAssignmentTask;
            theAssignmentTask = (((this.assignmentTask!= null)&&(!this.assignmentTask.isEmpty()))?this.getAssignmentTask():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assignmentTask", theAssignmentTask), currentHashCode, theAssignmentTask);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
