
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * A workflow of type Assignment
 * 
 * <p>Java class for AssignmentWorkflow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignmentWorkflow">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/sg/hrs/types}Workflow">
 *       &lt;sequence>
 *         &lt;element name="tasks" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="task" type="{http://ec.europa.eu/sg/hrs/types}AssignmentTask" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignmentWorkflow", propOrder = {
    "tasks"
})
public class AssignmentWorkflow
    extends Workflow
    implements Equals, HashCode, ToString
{

    protected AssignmentWorkflow.Tasks tasks;

    /**
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link AssignmentWorkflow.Tasks }
     *     
     */
    public AssignmentWorkflow.Tasks getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignmentWorkflow.Tasks }
     *     
     */
    public void setTasks(AssignmentWorkflow.Tasks value) {
        this.tasks = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AssignmentWorkflow)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final AssignmentWorkflow that = ((AssignmentWorkflow) object);
        {
            AssignmentWorkflow.Tasks lhsTasks;
            lhsTasks = this.getTasks();
            AssignmentWorkflow.Tasks rhsTasks;
            rhsTasks = that.getTasks();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tasks", lhsTasks), LocatorUtils.property(thatLocator, "tasks", rhsTasks), lhsTasks, rhsTasks)) {
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
        super.appendFields(locator, buffer, strategy);
        {
            AssignmentWorkflow.Tasks theTasks;
            theTasks = this.getTasks();
            strategy.appendField(locator, this, "tasks", buffer, theTasks);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            AssignmentWorkflow.Tasks theTasks;
            theTasks = this.getTasks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tasks", theTasks), currentHashCode, theTasks);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="task" type="{http://ec.europa.eu/sg/hrs/types}AssignmentTask" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "task"
    })
    public static class Tasks
        implements Equals, HashCode, ToString
    {

        protected List<AssignmentTask> task;

        /**
         * Gets the value of the task property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the task property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTask().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AssignmentTask }
         * 
         * 
         */
        public List<AssignmentTask> getTask() {
            if (task == null) {
                task = new ArrayList<AssignmentTask>();
            }
            return this.task;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof AssignmentWorkflow.Tasks)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final AssignmentWorkflow.Tasks that = ((AssignmentWorkflow.Tasks) object);
            {
                List<AssignmentTask> lhsTask;
                lhsTask = (((this.task!= null)&&(!this.task.isEmpty()))?this.getTask():null);
                List<AssignmentTask> rhsTask;
                rhsTask = (((that.task!= null)&&(!that.task.isEmpty()))?that.getTask():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "task", lhsTask), LocatorUtils.property(thatLocator, "task", rhsTask), lhsTask, rhsTask)) {
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
                List<AssignmentTask> theTask;
                theTask = (((this.task!= null)&&(!this.task.isEmpty()))?this.getTask():null);
                strategy.appendField(locator, this, "task", buffer, theTask);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<AssignmentTask> theTask;
                theTask = (((this.task!= null)&&(!this.task.isEmpty()))?this.getTask():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "task", theTask), currentHashCode, theTask);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
