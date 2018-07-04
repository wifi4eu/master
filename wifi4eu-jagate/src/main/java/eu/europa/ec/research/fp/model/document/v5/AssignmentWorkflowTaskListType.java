
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
 * <p>Java class for AssignmentWorkflowTaskListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignmentWorkflowTaskListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssignmentWorkflowTask" type="{http://ec.europa.eu/research/fp/model/document/V5}AssignmentWorkflowTaskType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignmentWorkflowTaskListType", propOrder = {
    "assignmentWorkflowTask"
})
public class AssignmentWorkflowTaskListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AssignmentWorkflowTask", required = true)
    protected List<AssignmentWorkflowTaskType> assignmentWorkflowTask;

    /**
     * Gets the value of the assignmentWorkflowTask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assignmentWorkflowTask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssignmentWorkflowTask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssignmentWorkflowTaskType }
     * 
     * 
     */
    public List<AssignmentWorkflowTaskType> getAssignmentWorkflowTask() {
        if (assignmentWorkflowTask == null) {
            assignmentWorkflowTask = new ArrayList<AssignmentWorkflowTaskType>();
        }
        return this.assignmentWorkflowTask;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AssignmentWorkflowTaskListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AssignmentWorkflowTaskListType that = ((AssignmentWorkflowTaskListType) object);
        {
            List<AssignmentWorkflowTaskType> lhsAssignmentWorkflowTask;
            lhsAssignmentWorkflowTask = (((this.assignmentWorkflowTask!= null)&&(!this.assignmentWorkflowTask.isEmpty()))?this.getAssignmentWorkflowTask():null);
            List<AssignmentWorkflowTaskType> rhsAssignmentWorkflowTask;
            rhsAssignmentWorkflowTask = (((that.assignmentWorkflowTask!= null)&&(!that.assignmentWorkflowTask.isEmpty()))?that.getAssignmentWorkflowTask():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assignmentWorkflowTask", lhsAssignmentWorkflowTask), LocatorUtils.property(thatLocator, "assignmentWorkflowTask", rhsAssignmentWorkflowTask), lhsAssignmentWorkflowTask, rhsAssignmentWorkflowTask)) {
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
            List<AssignmentWorkflowTaskType> theAssignmentWorkflowTask;
            theAssignmentWorkflowTask = (((this.assignmentWorkflowTask!= null)&&(!this.assignmentWorkflowTask.isEmpty()))?this.getAssignmentWorkflowTask():null);
            strategy.appendField(locator, this, "assignmentWorkflowTask", buffer, theAssignmentWorkflowTask);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<AssignmentWorkflowTaskType> theAssignmentWorkflowTask;
            theAssignmentWorkflowTask = (((this.assignmentWorkflowTask!= null)&&(!this.assignmentWorkflowTask.isEmpty()))?this.getAssignmentWorkflowTask():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assignmentWorkflowTask", theAssignmentWorkflowTask), currentHashCode, theAssignmentWorkflowTask);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
