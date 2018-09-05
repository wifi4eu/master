
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * A workflow of type Signatory, can be a Paper or e-Signatory workflow
 * 
 * <p>Java class for SignatoryWorkflow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SignatoryWorkflow">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ec.europa.eu/sg/hrs/types}Workflow">
 *       &lt;sequence>
 *         &lt;element name="managers" type="{http://ec.europa.eu/sg/hrs/types}WorkflowManagers"/>
 *         &lt;element name="launcher" type="{http://ec.europa.eu/sg/hrs/types}WorkflowUser" minOccurs="0"/>
 *         &lt;element name="launchDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="signatoryType" type="{http://ec.europa.eu/sg/hrs/types}SignatoryType"/>
 *         &lt;element name="lastESignatoryTaskId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tasks" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="task" type="{http://ec.europa.eu/sg/hrs/types}SignatoryTask" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="parallelPaperSignatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="afterRegistrationAccess" type="{http://ec.europa.eu/sg/hrs/types}AfterRegistrationAccess"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatoryWorkflow", propOrder = {
    "managers",
    "launcher",
    "launchDate",
    "signatoryType",
    "lastESignatoryTaskId",
    "tasks",
    "parallelPaperSignatory",
    "afterRegistrationAccess"
})
public class SignatoryWorkflow
    extends Workflow
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected WorkflowManagers managers;
    protected WorkflowUser launcher;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar launchDate;
    @XmlElement(required = true)
    protected SignatoryType signatoryType;
    protected Integer lastESignatoryTaskId;
    protected SignatoryWorkflow.Tasks tasks;
    protected boolean parallelPaperSignatory;
    @XmlElement(required = true)
    protected AfterRegistrationAccess afterRegistrationAccess;

    /**
     * Gets the value of the managers property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowManagers }
     *     
     */
    public WorkflowManagers getManagers() {
        return managers;
    }

    /**
     * Sets the value of the managers property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowManagers }
     *     
     */
    public void setManagers(WorkflowManagers value) {
        this.managers = value;
    }

    /**
     * Gets the value of the launcher property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUser }
     *     
     */
    public WorkflowUser getLauncher() {
        return launcher;
    }

    /**
     * Sets the value of the launcher property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUser }
     *     
     */
    public void setLauncher(WorkflowUser value) {
        this.launcher = value;
    }

    /**
     * Gets the value of the launchDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLaunchDate() {
        return launchDate;
    }

    /**
     * Sets the value of the launchDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLaunchDate(XMLGregorianCalendar value) {
        this.launchDate = value;
    }

    /**
     * Gets the value of the signatoryType property.
     * 
     * @return
     *     possible object is
     *     {@link SignatoryType }
     *     
     */
    public SignatoryType getSignatoryType() {
        return signatoryType;
    }

    /**
     * Sets the value of the signatoryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatoryType }
     *     
     */
    public void setSignatoryType(SignatoryType value) {
        this.signatoryType = value;
    }

    /**
     * Gets the value of the lastESignatoryTaskId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLastESignatoryTaskId() {
        return lastESignatoryTaskId;
    }

    /**
     * Sets the value of the lastESignatoryTaskId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLastESignatoryTaskId(Integer value) {
        this.lastESignatoryTaskId = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link SignatoryWorkflow.Tasks }
     *     
     */
    public SignatoryWorkflow.Tasks getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatoryWorkflow.Tasks }
     *     
     */
    public void setTasks(SignatoryWorkflow.Tasks value) {
        this.tasks = value;
    }

    /**
     * Gets the value of the parallelPaperSignatory property.
     * 
     */
    public boolean isParallelPaperSignatory() {
        return parallelPaperSignatory;
    }

    /**
     * Sets the value of the parallelPaperSignatory property.
     * 
     */
    public void setParallelPaperSignatory(boolean value) {
        this.parallelPaperSignatory = value;
    }

    /**
     * Gets the value of the afterRegistrationAccess property.
     * 
     * @return
     *     possible object is
     *     {@link AfterRegistrationAccess }
     *     
     */
    public AfterRegistrationAccess getAfterRegistrationAccess() {
        return afterRegistrationAccess;
    }

    /**
     * Sets the value of the afterRegistrationAccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link AfterRegistrationAccess }
     *     
     */
    public void setAfterRegistrationAccess(AfterRegistrationAccess value) {
        this.afterRegistrationAccess = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SignatoryWorkflow)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final SignatoryWorkflow that = ((SignatoryWorkflow) object);
        {
            WorkflowManagers lhsManagers;
            lhsManagers = this.getManagers();
            WorkflowManagers rhsManagers;
            rhsManagers = that.getManagers();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "managers", lhsManagers), LocatorUtils.property(thatLocator, "managers", rhsManagers), lhsManagers, rhsManagers)) {
                return false;
            }
        }
        {
            WorkflowUser lhsLauncher;
            lhsLauncher = this.getLauncher();
            WorkflowUser rhsLauncher;
            rhsLauncher = that.getLauncher();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "launcher", lhsLauncher), LocatorUtils.property(thatLocator, "launcher", rhsLauncher), lhsLauncher, rhsLauncher)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsLaunchDate;
            lhsLaunchDate = this.getLaunchDate();
            XMLGregorianCalendar rhsLaunchDate;
            rhsLaunchDate = that.getLaunchDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "launchDate", lhsLaunchDate), LocatorUtils.property(thatLocator, "launchDate", rhsLaunchDate), lhsLaunchDate, rhsLaunchDate)) {
                return false;
            }
        }
        {
            SignatoryType lhsSignatoryType;
            lhsSignatoryType = this.getSignatoryType();
            SignatoryType rhsSignatoryType;
            rhsSignatoryType = that.getSignatoryType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signatoryType", lhsSignatoryType), LocatorUtils.property(thatLocator, "signatoryType", rhsSignatoryType), lhsSignatoryType, rhsSignatoryType)) {
                return false;
            }
        }
        {
            Integer lhsLastESignatoryTaskId;
            lhsLastESignatoryTaskId = this.getLastESignatoryTaskId();
            Integer rhsLastESignatoryTaskId;
            rhsLastESignatoryTaskId = that.getLastESignatoryTaskId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastESignatoryTaskId", lhsLastESignatoryTaskId), LocatorUtils.property(thatLocator, "lastESignatoryTaskId", rhsLastESignatoryTaskId), lhsLastESignatoryTaskId, rhsLastESignatoryTaskId)) {
                return false;
            }
        }
        {
            SignatoryWorkflow.Tasks lhsTasks;
            lhsTasks = this.getTasks();
            SignatoryWorkflow.Tasks rhsTasks;
            rhsTasks = that.getTasks();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tasks", lhsTasks), LocatorUtils.property(thatLocator, "tasks", rhsTasks), lhsTasks, rhsTasks)) {
                return false;
            }
        }
        {
            boolean lhsParallelPaperSignatory;
            lhsParallelPaperSignatory = (true?this.isParallelPaperSignatory():false);
            boolean rhsParallelPaperSignatory;
            rhsParallelPaperSignatory = (true?that.isParallelPaperSignatory():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "parallelPaperSignatory", lhsParallelPaperSignatory), LocatorUtils.property(thatLocator, "parallelPaperSignatory", rhsParallelPaperSignatory), lhsParallelPaperSignatory, rhsParallelPaperSignatory)) {
                return false;
            }
        }
        {
            AfterRegistrationAccess lhsAfterRegistrationAccess;
            lhsAfterRegistrationAccess = this.getAfterRegistrationAccess();
            AfterRegistrationAccess rhsAfterRegistrationAccess;
            rhsAfterRegistrationAccess = that.getAfterRegistrationAccess();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "afterRegistrationAccess", lhsAfterRegistrationAccess), LocatorUtils.property(thatLocator, "afterRegistrationAccess", rhsAfterRegistrationAccess), lhsAfterRegistrationAccess, rhsAfterRegistrationAccess)) {
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
            WorkflowManagers theManagers;
            theManagers = this.getManagers();
            strategy.appendField(locator, this, "managers", buffer, theManagers);
        }
        {
            WorkflowUser theLauncher;
            theLauncher = this.getLauncher();
            strategy.appendField(locator, this, "launcher", buffer, theLauncher);
        }
        {
            XMLGregorianCalendar theLaunchDate;
            theLaunchDate = this.getLaunchDate();
            strategy.appendField(locator, this, "launchDate", buffer, theLaunchDate);
        }
        {
            SignatoryType theSignatoryType;
            theSignatoryType = this.getSignatoryType();
            strategy.appendField(locator, this, "signatoryType", buffer, theSignatoryType);
        }
        {
            Integer theLastESignatoryTaskId;
            theLastESignatoryTaskId = this.getLastESignatoryTaskId();
            strategy.appendField(locator, this, "lastESignatoryTaskId", buffer, theLastESignatoryTaskId);
        }
        {
            SignatoryWorkflow.Tasks theTasks;
            theTasks = this.getTasks();
            strategy.appendField(locator, this, "tasks", buffer, theTasks);
        }
        {
            boolean theParallelPaperSignatory;
            theParallelPaperSignatory = (true?this.isParallelPaperSignatory():false);
            strategy.appendField(locator, this, "parallelPaperSignatory", buffer, theParallelPaperSignatory);
        }
        {
            AfterRegistrationAccess theAfterRegistrationAccess;
            theAfterRegistrationAccess = this.getAfterRegistrationAccess();
            strategy.appendField(locator, this, "afterRegistrationAccess", buffer, theAfterRegistrationAccess);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            WorkflowManagers theManagers;
            theManagers = this.getManagers();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "managers", theManagers), currentHashCode, theManagers);
        }
        {
            WorkflowUser theLauncher;
            theLauncher = this.getLauncher();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "launcher", theLauncher), currentHashCode, theLauncher);
        }
        {
            XMLGregorianCalendar theLaunchDate;
            theLaunchDate = this.getLaunchDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "launchDate", theLaunchDate), currentHashCode, theLaunchDate);
        }
        {
            SignatoryType theSignatoryType;
            theSignatoryType = this.getSignatoryType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signatoryType", theSignatoryType), currentHashCode, theSignatoryType);
        }
        {
            Integer theLastESignatoryTaskId;
            theLastESignatoryTaskId = this.getLastESignatoryTaskId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastESignatoryTaskId", theLastESignatoryTaskId), currentHashCode, theLastESignatoryTaskId);
        }
        {
            SignatoryWorkflow.Tasks theTasks;
            theTasks = this.getTasks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tasks", theTasks), currentHashCode, theTasks);
        }
        {
            boolean theParallelPaperSignatory;
            theParallelPaperSignatory = (true?this.isParallelPaperSignatory():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "parallelPaperSignatory", theParallelPaperSignatory), currentHashCode, theParallelPaperSignatory);
        }
        {
            AfterRegistrationAccess theAfterRegistrationAccess;
            theAfterRegistrationAccess = this.getAfterRegistrationAccess();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "afterRegistrationAccess", theAfterRegistrationAccess), currentHashCode, theAfterRegistrationAccess);
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
     *         &lt;element name="task" type="{http://ec.europa.eu/sg/hrs/types}SignatoryTask" maxOccurs="unbounded" minOccurs="0"/>
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

        protected List<SignatoryTask> task;

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
         * {@link SignatoryTask }
         * 
         * 
         */
        public List<SignatoryTask> getTask() {
            if (task == null) {
                task = new ArrayList<SignatoryTask>();
            }
            return this.task;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof SignatoryWorkflow.Tasks)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final SignatoryWorkflow.Tasks that = ((SignatoryWorkflow.Tasks) object);
            {
                List<SignatoryTask> lhsTask;
                lhsTask = (((this.task!= null)&&(!this.task.isEmpty()))?this.getTask():null);
                List<SignatoryTask> rhsTask;
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
                List<SignatoryTask> theTask;
                theTask = (((this.task!= null)&&(!this.task.isEmpty()))?this.getTask():null);
                strategy.appendField(locator, this, "task", buffer, theTask);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<SignatoryTask> theTask;
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
