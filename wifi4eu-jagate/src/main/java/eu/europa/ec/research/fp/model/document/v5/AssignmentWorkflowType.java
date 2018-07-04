
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for AssignmentWorkflowType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignmentWorkflowType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DocumentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WorkflowId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Tasks" type="{http://ec.europa.eu/research/fp/model/document/V5}AssignmentWorkflowTaskListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignmentWorkflowType", propOrder = {
    "active",
    "documentId",
    "workflowId",
    "tasks"
})
public class AssignmentWorkflowType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Active")
    protected Boolean active;
    @XmlElement(name = "DocumentId", required = true)
    protected String documentId;
    @XmlElement(name = "WorkflowId")
    protected int workflowId;
    @XmlElement(name = "Tasks", required = true)
    protected AssignmentWorkflowTaskListType tasks;

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
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentId(String value) {
        this.documentId = value;
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
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link AssignmentWorkflowTaskListType }
     *     
     */
    public AssignmentWorkflowTaskListType getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignmentWorkflowTaskListType }
     *     
     */
    public void setTasks(AssignmentWorkflowTaskListType value) {
        this.tasks = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AssignmentWorkflowType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AssignmentWorkflowType that = ((AssignmentWorkflowType) object);
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
            String lhsDocumentId;
            lhsDocumentId = this.getDocumentId();
            String rhsDocumentId;
            rhsDocumentId = that.getDocumentId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "documentId", lhsDocumentId), LocatorUtils.property(thatLocator, "documentId", rhsDocumentId), lhsDocumentId, rhsDocumentId)) {
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
            AssignmentWorkflowTaskListType lhsTasks;
            lhsTasks = this.getTasks();
            AssignmentWorkflowTaskListType rhsTasks;
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
        {
            Boolean theActive;
            theActive = this.isActive();
            strategy.appendField(locator, this, "active", buffer, theActive);
        }
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            strategy.appendField(locator, this, "documentId", buffer, theDocumentId);
        }
        {
            int theWorkflowId;
            theWorkflowId = (true?this.getWorkflowId(): 0);
            strategy.appendField(locator, this, "workflowId", buffer, theWorkflowId);
        }
        {
            AssignmentWorkflowTaskListType theTasks;
            theTasks = this.getTasks();
            strategy.appendField(locator, this, "tasks", buffer, theTasks);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Boolean theActive;
            theActive = this.isActive();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "active", theActive), currentHashCode, theActive);
        }
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentId", theDocumentId), currentHashCode, theDocumentId);
        }
        {
            int theWorkflowId;
            theWorkflowId = (true?this.getWorkflowId(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "workflowId", theWorkflowId), currentHashCode, theWorkflowId);
        }
        {
            AssignmentWorkflowTaskListType theTasks;
            theTasks = this.getTasks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tasks", theTasks), currentHashCode, theTasks);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
