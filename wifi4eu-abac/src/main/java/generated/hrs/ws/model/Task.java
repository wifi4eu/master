
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 * A workflow task
 * 
 * <p>Java class for Task complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Task">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="workflowId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="DRAFT"/>
 *               &lt;enumeration value="LAUNCHED"/>
 *               &lt;enumeration value="ACTIVE"/>
 *               &lt;enumeration value="CLOSED"/>
 *               &lt;enumeration value="BYPASSED"/>
 *               &lt;enumeration value="MANUAL"/>
 *               &lt;enumeration value="DECLINED"/>
 *               &lt;enumeration value="DELEGATED"/>
 *               &lt;enumeration value="RETURNED_TO_SENDER"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="assignee" type="{http://ec.europa.eu/sg/hrs/types}WorkflowUser"/>
 *         &lt;element name="sender" type="{http://ec.europa.eu/sg/hrs/types}WorkflowUser"/>
 *         &lt;element name="sentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="closer" type="{http://ec.europa.eu/sg/hrs/types}WorkflowUser" minOccurs="0"/>
 *         &lt;element name="closeDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="reader" type="{http://ec.europa.eu/sg/hrs/types}WorkflowUser" minOccurs="0"/>
 *         &lt;element name="readDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="deadlineDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="instructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="critical" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Task", propOrder = {
    "taskId",
    "workflowId",
    "status",
    "assignee",
    "sender",
    "sentDate",
    "closer",
    "closeDate",
    "reader",
    "readDate",
    "deadlineDate",
    "instructions",
    "comments",
    "critical",
    "deleted"
})
@XmlSeeAlso({
    AssignmentTask.class,
    SignatoryTask.class
})
public abstract class Task
    implements Equals, HashCode, ToString
{

    protected int taskId;
    protected int workflowId;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected WorkflowUser assignee;
    @XmlElement(required = true)
    protected WorkflowUser sender;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar sentDate;
    protected WorkflowUser closer;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar closeDate;
    protected WorkflowUser reader;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar readDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deadlineDate;
    protected String instructions;
    protected String comments;
    protected boolean critical;
    protected Boolean deleted;

    /**
     * Gets the value of the taskId property.
     * 
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * Sets the value of the taskId property.
     * 
     */
    public void setTaskId(int value) {
        this.taskId = value;
    }

    /**
     * Gets the value of the workflowId property.
     * 
     */
    public int getWorkflowId() {
        return workflowId;
    }

    /**
     * Sets the value of the workflowId property.
     * 
     */
    public void setWorkflowId(int value) {
        this.workflowId = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the assignee property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUser }
     *     
     */
    public WorkflowUser getAssignee() {
        return assignee;
    }

    /**
     * Sets the value of the assignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUser }
     *     
     */
    public void setAssignee(WorkflowUser value) {
        this.assignee = value;
    }

    /**
     * Gets the value of the sender property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUser }
     *     
     */
    public WorkflowUser getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUser }
     *     
     */
    public void setSender(WorkflowUser value) {
        this.sender = value;
    }

    /**
     * Gets the value of the sentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSentDate() {
        return sentDate;
    }

    /**
     * Sets the value of the sentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSentDate(XMLGregorianCalendar value) {
        this.sentDate = value;
    }

    /**
     * Gets the value of the closer property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUser }
     *     
     */
    public WorkflowUser getCloser() {
        return closer;
    }

    /**
     * Sets the value of the closer property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUser }
     *     
     */
    public void setCloser(WorkflowUser value) {
        this.closer = value;
    }

    /**
     * Gets the value of the closeDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCloseDate() {
        return closeDate;
    }

    /**
     * Sets the value of the closeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCloseDate(XMLGregorianCalendar value) {
        this.closeDate = value;
    }

    /**
     * Gets the value of the reader property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUser }
     *     
     */
    public WorkflowUser getReader() {
        return reader;
    }

    /**
     * Sets the value of the reader property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUser }
     *     
     */
    public void setReader(WorkflowUser value) {
        this.reader = value;
    }

    /**
     * Gets the value of the readDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReadDate() {
        return readDate;
    }

    /**
     * Sets the value of the readDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReadDate(XMLGregorianCalendar value) {
        this.readDate = value;
    }

    /**
     * Gets the value of the deadlineDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeadlineDate() {
        return deadlineDate;
    }

    /**
     * Sets the value of the deadlineDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeadlineDate(XMLGregorianCalendar value) {
        this.deadlineDate = value;
    }

    /**
     * Gets the value of the instructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Sets the value of the instructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstructions(String value) {
        this.instructions = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the critical property.
     * 
     */
    public boolean isCritical() {
        return critical;
    }

    /**
     * Sets the value of the critical property.
     * 
     */
    public void setCritical(boolean value) {
        this.critical = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleted(Boolean value) {
        this.deleted = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Task)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Task that = ((Task) object);
        {
            int lhsTaskId;
            lhsTaskId = (true?this.getTaskId(): 0);
            int rhsTaskId;
            rhsTaskId = (true?that.getTaskId(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "taskId", lhsTaskId), LocatorUtils.property(thatLocator, "taskId", rhsTaskId), lhsTaskId, rhsTaskId)) {
                return false;
            }
        }
        {
            int lhsWorkflowId;
            lhsWorkflowId = (true?this.getWorkflowId(): 0);
            int rhsWorkflowId;
            rhsWorkflowId = (true?that.getWorkflowId(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "workflowId", lhsWorkflowId), LocatorUtils.property(thatLocator, "workflowId", rhsWorkflowId), lhsWorkflowId, rhsWorkflowId)) {
                return false;
            }
        }
        {
            String lhsStatus;
            lhsStatus = this.getStatus();
            String rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            WorkflowUser lhsAssignee;
            lhsAssignee = this.getAssignee();
            WorkflowUser rhsAssignee;
            rhsAssignee = that.getAssignee();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assignee", lhsAssignee), LocatorUtils.property(thatLocator, "assignee", rhsAssignee), lhsAssignee, rhsAssignee)) {
                return false;
            }
        }
        {
            WorkflowUser lhsSender;
            lhsSender = this.getSender();
            WorkflowUser rhsSender;
            rhsSender = that.getSender();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sender", lhsSender), LocatorUtils.property(thatLocator, "sender", rhsSender), lhsSender, rhsSender)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsSentDate;
            lhsSentDate = this.getSentDate();
            XMLGregorianCalendar rhsSentDate;
            rhsSentDate = that.getSentDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sentDate", lhsSentDate), LocatorUtils.property(thatLocator, "sentDate", rhsSentDate), lhsSentDate, rhsSentDate)) {
                return false;
            }
        }
        {
            WorkflowUser lhsCloser;
            lhsCloser = this.getCloser();
            WorkflowUser rhsCloser;
            rhsCloser = that.getCloser();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "closer", lhsCloser), LocatorUtils.property(thatLocator, "closer", rhsCloser), lhsCloser, rhsCloser)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsCloseDate;
            lhsCloseDate = this.getCloseDate();
            XMLGregorianCalendar rhsCloseDate;
            rhsCloseDate = that.getCloseDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "closeDate", lhsCloseDate), LocatorUtils.property(thatLocator, "closeDate", rhsCloseDate), lhsCloseDate, rhsCloseDate)) {
                return false;
            }
        }
        {
            WorkflowUser lhsReader;
            lhsReader = this.getReader();
            WorkflowUser rhsReader;
            rhsReader = that.getReader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reader", lhsReader), LocatorUtils.property(thatLocator, "reader", rhsReader), lhsReader, rhsReader)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsReadDate;
            lhsReadDate = this.getReadDate();
            XMLGregorianCalendar rhsReadDate;
            rhsReadDate = that.getReadDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "readDate", lhsReadDate), LocatorUtils.property(thatLocator, "readDate", rhsReadDate), lhsReadDate, rhsReadDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDeadlineDate;
            lhsDeadlineDate = this.getDeadlineDate();
            XMLGregorianCalendar rhsDeadlineDate;
            rhsDeadlineDate = that.getDeadlineDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deadlineDate", lhsDeadlineDate), LocatorUtils.property(thatLocator, "deadlineDate", rhsDeadlineDate), lhsDeadlineDate, rhsDeadlineDate)) {
                return false;
            }
        }
        {
            String lhsInstructions;
            lhsInstructions = this.getInstructions();
            String rhsInstructions;
            rhsInstructions = that.getInstructions();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "instructions", lhsInstructions), LocatorUtils.property(thatLocator, "instructions", rhsInstructions), lhsInstructions, rhsInstructions)) {
                return false;
            }
        }
        {
            String lhsComments;
            lhsComments = this.getComments();
            String rhsComments;
            rhsComments = that.getComments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "comments", lhsComments), LocatorUtils.property(thatLocator, "comments", rhsComments), lhsComments, rhsComments)) {
                return false;
            }
        }
        {
            boolean lhsCritical;
            lhsCritical = (true?this.isCritical():false);
            boolean rhsCritical;
            rhsCritical = (true?that.isCritical():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "critical", lhsCritical), LocatorUtils.property(thatLocator, "critical", rhsCritical), lhsCritical, rhsCritical)) {
                return false;
            }
        }
        {
            Boolean lhsDeleted;
            lhsDeleted = this.isDeleted();
            Boolean rhsDeleted;
            rhsDeleted = that.isDeleted();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deleted", lhsDeleted), LocatorUtils.property(thatLocator, "deleted", rhsDeleted), lhsDeleted, rhsDeleted)) {
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
            int theTaskId;
            theTaskId = (true?this.getTaskId(): 0);
            strategy.appendField(locator, this, "taskId", buffer, theTaskId);
        }
        {
            int theWorkflowId;
            theWorkflowId = (true?this.getWorkflowId(): 0);
            strategy.appendField(locator, this, "workflowId", buffer, theWorkflowId);
        }
        {
            String theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            WorkflowUser theAssignee;
            theAssignee = this.getAssignee();
            strategy.appendField(locator, this, "assignee", buffer, theAssignee);
        }
        {
            WorkflowUser theSender;
            theSender = this.getSender();
            strategy.appendField(locator, this, "sender", buffer, theSender);
        }
        {
            XMLGregorianCalendar theSentDate;
            theSentDate = this.getSentDate();
            strategy.appendField(locator, this, "sentDate", buffer, theSentDate);
        }
        {
            WorkflowUser theCloser;
            theCloser = this.getCloser();
            strategy.appendField(locator, this, "closer", buffer, theCloser);
        }
        {
            XMLGregorianCalendar theCloseDate;
            theCloseDate = this.getCloseDate();
            strategy.appendField(locator, this, "closeDate", buffer, theCloseDate);
        }
        {
            WorkflowUser theReader;
            theReader = this.getReader();
            strategy.appendField(locator, this, "reader", buffer, theReader);
        }
        {
            XMLGregorianCalendar theReadDate;
            theReadDate = this.getReadDate();
            strategy.appendField(locator, this, "readDate", buffer, theReadDate);
        }
        {
            XMLGregorianCalendar theDeadlineDate;
            theDeadlineDate = this.getDeadlineDate();
            strategy.appendField(locator, this, "deadlineDate", buffer, theDeadlineDate);
        }
        {
            String theInstructions;
            theInstructions = this.getInstructions();
            strategy.appendField(locator, this, "instructions", buffer, theInstructions);
        }
        {
            String theComments;
            theComments = this.getComments();
            strategy.appendField(locator, this, "comments", buffer, theComments);
        }
        {
            boolean theCritical;
            theCritical = (true?this.isCritical():false);
            strategy.appendField(locator, this, "critical", buffer, theCritical);
        }
        {
            Boolean theDeleted;
            theDeleted = this.isDeleted();
            strategy.appendField(locator, this, "deleted", buffer, theDeleted);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theTaskId;
            theTaskId = (true?this.getTaskId(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "taskId", theTaskId), currentHashCode, theTaskId);
        }
        {
            int theWorkflowId;
            theWorkflowId = (true?this.getWorkflowId(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "workflowId", theWorkflowId), currentHashCode, theWorkflowId);
        }
        {
            String theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            WorkflowUser theAssignee;
            theAssignee = this.getAssignee();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assignee", theAssignee), currentHashCode, theAssignee);
        }
        {
            WorkflowUser theSender;
            theSender = this.getSender();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sender", theSender), currentHashCode, theSender);
        }
        {
            XMLGregorianCalendar theSentDate;
            theSentDate = this.getSentDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sentDate", theSentDate), currentHashCode, theSentDate);
        }
        {
            WorkflowUser theCloser;
            theCloser = this.getCloser();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "closer", theCloser), currentHashCode, theCloser);
        }
        {
            XMLGregorianCalendar theCloseDate;
            theCloseDate = this.getCloseDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "closeDate", theCloseDate), currentHashCode, theCloseDate);
        }
        {
            WorkflowUser theReader;
            theReader = this.getReader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reader", theReader), currentHashCode, theReader);
        }
        {
            XMLGregorianCalendar theReadDate;
            theReadDate = this.getReadDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "readDate", theReadDate), currentHashCode, theReadDate);
        }
        {
            XMLGregorianCalendar theDeadlineDate;
            theDeadlineDate = this.getDeadlineDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deadlineDate", theDeadlineDate), currentHashCode, theDeadlineDate);
        }
        {
            String theInstructions;
            theInstructions = this.getInstructions();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instructions", theInstructions), currentHashCode, theInstructions);
        }
        {
            String theComments;
            theComments = this.getComments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comments", theComments), currentHashCode, theComments);
        }
        {
            boolean theCritical;
            theCritical = (true?this.isCritical():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "critical", theCritical), currentHashCode, theCritical);
        }
        {
            Boolean theDeleted;
            theDeleted = this.isDeleted();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deleted", theDeleted), currentHashCode, theDeleted);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
