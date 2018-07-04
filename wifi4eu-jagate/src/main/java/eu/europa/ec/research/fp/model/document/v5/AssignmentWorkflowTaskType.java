
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for AssignmentWorkflowTaskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignmentWorkflowTaskType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://ec.europa.eu/research/fp/model/document/V5}AssignmentTaskCodeType"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Assignee" type="{http://ec.europa.eu/research/fp/model/document/V5}WorkflowUserType"/>
 *         &lt;element name="CloseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Closer" type="{http://ec.europa.eu/research/fp/model/document/V5}WorkflowUserType" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Critical" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Deleted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeadlineDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Instructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReadDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Reader" type="{http://ec.europa.eu/research/fp/model/document/V5}WorkflowUserType" minOccurs="0"/>
 *         &lt;element name="Sender" type="{http://ec.europa.eu/research/fp/model/document/V5}WorkflowUserType"/>
 *         &lt;element name="SentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://ec.europa.eu/research/fp/model/document/V5}WorkflowStatusType"/>
 *         &lt;element name="TaskId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="WorkflowId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignmentWorkflowTaskType", propOrder = {
    "code",
    "active",
    "assignee",
    "closeDate",
    "closer",
    "comments",
    "critical",
    "deleted",
    "deadlineDate",
    "instructions",
    "readDate",
    "reader",
    "sender",
    "sentDate",
    "status",
    "taskId",
    "workflowId"
})
public class AssignmentWorkflowTaskType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Code", required = true)
    protected AssignmentTaskCodeType code;
    @XmlElement(name = "Active")
    protected Boolean active;
    @XmlElement(name = "Assignee", required = true)
    protected WorkflowUserType assignee;
    @XmlElement(name = "CloseDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar closeDate;
    @XmlElement(name = "Closer")
    protected WorkflowUserType closer;
    @XmlElement(name = "Comments")
    protected String comments;
    @XmlElement(name = "Critical")
    protected boolean critical;
    @XmlElement(name = "Deleted")
    protected Boolean deleted;
    @XmlElement(name = "DeadlineDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deadlineDate;
    @XmlElement(name = "Instructions")
    protected String instructions;
    @XmlElement(name = "ReadDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar readDate;
    @XmlElement(name = "Reader")
    protected WorkflowUserType reader;
    @XmlElement(name = "Sender", required = true)
    protected WorkflowUserType sender;
    @XmlElement(name = "SentDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sentDate;
    @XmlElement(name = "Status", required = true)
    protected WorkflowStatusType status;
    @XmlElement(name = "TaskId")
    protected int taskId;
    @XmlElement(name = "WorkflowId")
    protected int workflowId;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link AssignmentTaskCodeType }
     *     
     */
    public AssignmentTaskCodeType getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignmentTaskCodeType }
     *     
     */
    public void setCode(AssignmentTaskCodeType value) {
        this.code = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the assignee property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUserType }
     *     
     */
    public WorkflowUserType getAssignee() {
        return assignee;
    }

    /**
     * Sets the value of the assignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUserType }
     *     
     */
    public void setAssignee(WorkflowUserType value) {
        this.assignee = value;
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
     * Gets the value of the closer property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUserType }
     *     
     */
    public WorkflowUserType getCloser() {
        return closer;
    }

    /**
     * Sets the value of the closer property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUserType }
     *     
     */
    public void setCloser(WorkflowUserType value) {
        this.closer = value;
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
     * Gets the value of the reader property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUserType }
     *     
     */
    public WorkflowUserType getReader() {
        return reader;
    }

    /**
     * Sets the value of the reader property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUserType }
     *     
     */
    public void setReader(WorkflowUserType value) {
        this.reader = value;
    }

    /**
     * Gets the value of the sender property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUserType }
     *     
     */
    public WorkflowUserType getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUserType }
     *     
     */
    public void setSender(WorkflowUserType value) {
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowStatusType }
     *     
     */
    public WorkflowStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowStatusType }
     *     
     */
    public void setStatus(WorkflowStatusType value) {
        this.status = value;
    }

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AssignmentWorkflowTaskType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AssignmentWorkflowTaskType that = ((AssignmentWorkflowTaskType) object);
        {
            AssignmentTaskCodeType lhsCode;
            lhsCode = this.getCode();
            AssignmentTaskCodeType rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
                return false;
            }
        }
        {
            Boolean lhsActive;
            lhsActive = this.isActive();
            Boolean rhsActive;
            rhsActive = that.isActive();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "active", lhsActive), LocatorUtils.property(thatLocator, "active", rhsActive), lhsActive, rhsActive)) {
                return false;
            }
        }
        {
            WorkflowUserType lhsAssignee;
            lhsAssignee = this.getAssignee();
            WorkflowUserType rhsAssignee;
            rhsAssignee = that.getAssignee();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assignee", lhsAssignee), LocatorUtils.property(thatLocator, "assignee", rhsAssignee), lhsAssignee, rhsAssignee)) {
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
            WorkflowUserType lhsCloser;
            lhsCloser = this.getCloser();
            WorkflowUserType rhsCloser;
            rhsCloser = that.getCloser();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "closer", lhsCloser), LocatorUtils.property(thatLocator, "closer", rhsCloser), lhsCloser, rhsCloser)) {
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
            XMLGregorianCalendar lhsReadDate;
            lhsReadDate = this.getReadDate();
            XMLGregorianCalendar rhsReadDate;
            rhsReadDate = that.getReadDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "readDate", lhsReadDate), LocatorUtils.property(thatLocator, "readDate", rhsReadDate), lhsReadDate, rhsReadDate)) {
                return false;
            }
        }
        {
            WorkflowUserType lhsReader;
            lhsReader = this.getReader();
            WorkflowUserType rhsReader;
            rhsReader = that.getReader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reader", lhsReader), LocatorUtils.property(thatLocator, "reader", rhsReader), lhsReader, rhsReader)) {
                return false;
            }
        }
        {
            WorkflowUserType lhsSender;
            lhsSender = this.getSender();
            WorkflowUserType rhsSender;
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
            WorkflowStatusType lhsStatus;
            lhsStatus = this.getStatus();
            WorkflowStatusType rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
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
            AssignmentTaskCodeType theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        {
            Boolean theActive;
            theActive = this.isActive();
            strategy.appendField(locator, this, "active", buffer, theActive);
        }
        {
            WorkflowUserType theAssignee;
            theAssignee = this.getAssignee();
            strategy.appendField(locator, this, "assignee", buffer, theAssignee);
        }
        {
            XMLGregorianCalendar theCloseDate;
            theCloseDate = this.getCloseDate();
            strategy.appendField(locator, this, "closeDate", buffer, theCloseDate);
        }
        {
            WorkflowUserType theCloser;
            theCloser = this.getCloser();
            strategy.appendField(locator, this, "closer", buffer, theCloser);
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
            XMLGregorianCalendar theReadDate;
            theReadDate = this.getReadDate();
            strategy.appendField(locator, this, "readDate", buffer, theReadDate);
        }
        {
            WorkflowUserType theReader;
            theReader = this.getReader();
            strategy.appendField(locator, this, "reader", buffer, theReader);
        }
        {
            WorkflowUserType theSender;
            theSender = this.getSender();
            strategy.appendField(locator, this, "sender", buffer, theSender);
        }
        {
            XMLGregorianCalendar theSentDate;
            theSentDate = this.getSentDate();
            strategy.appendField(locator, this, "sentDate", buffer, theSentDate);
        }
        {
            WorkflowStatusType theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
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
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            AssignmentTaskCodeType theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        {
            Boolean theActive;
            theActive = this.isActive();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "active", theActive), currentHashCode, theActive);
        }
        {
            WorkflowUserType theAssignee;
            theAssignee = this.getAssignee();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assignee", theAssignee), currentHashCode, theAssignee);
        }
        {
            XMLGregorianCalendar theCloseDate;
            theCloseDate = this.getCloseDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "closeDate", theCloseDate), currentHashCode, theCloseDate);
        }
        {
            WorkflowUserType theCloser;
            theCloser = this.getCloser();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "closer", theCloser), currentHashCode, theCloser);
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
            XMLGregorianCalendar theReadDate;
            theReadDate = this.getReadDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "readDate", theReadDate), currentHashCode, theReadDate);
        }
        {
            WorkflowUserType theReader;
            theReader = this.getReader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reader", theReader), currentHashCode, theReader);
        }
        {
            WorkflowUserType theSender;
            theSender = this.getSender();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sender", theSender), currentHashCode, theSender);
        }
        {
            XMLGregorianCalendar theSentDate;
            theSentDate = this.getSentDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sentDate", theSentDate), currentHashCode, theSentDate);
        }
        {
            WorkflowStatusType theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
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
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
