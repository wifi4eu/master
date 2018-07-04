
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
 * <p>Java class for AssignmentTaskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignmentTaskType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssigneeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Deadline" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Instructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Critical" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Code" type="{http://ec.europa.eu/research/fp/model/document/V5}AssignmentTaskCodeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignmentTaskType", propOrder = {
    "assigneeId",
    "deadline",
    "instructions",
    "critical",
    "code"
})
public class AssignmentTaskType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AssigneeId", required = true)
    protected String assigneeId;
    @XmlElement(name = "Deadline")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deadline;
    @XmlElement(name = "Instructions")
    protected String instructions;
    @XmlElement(name = "Critical")
    protected Boolean critical;
    @XmlElement(name = "Code", required = true)
    protected AssignmentTaskCodeType code;

    /**
     * Gets the value of the assigneeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssigneeId() {
        return assigneeId;
    }

    /**
     * Sets the value of the assigneeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssigneeId(String value) {
        this.assigneeId = value;
    }

    /**
     * Gets the value of the deadline property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeadline() {
        return deadline;
    }

    /**
     * Sets the value of the deadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeadline(XMLGregorianCalendar value) {
        this.deadline = value;
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
     * Gets the value of the critical property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCritical() {
        return critical;
    }

    /**
     * Sets the value of the critical property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCritical(Boolean value) {
        this.critical = value;
    }

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AssignmentTaskType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AssignmentTaskType that = ((AssignmentTaskType) object);
        {
            String lhsAssigneeId;
            lhsAssigneeId = this.getAssigneeId();
            String rhsAssigneeId;
            rhsAssigneeId = that.getAssigneeId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assigneeId", lhsAssigneeId), LocatorUtils.property(thatLocator, "assigneeId", rhsAssigneeId), lhsAssigneeId, rhsAssigneeId)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDeadline;
            lhsDeadline = this.getDeadline();
            XMLGregorianCalendar rhsDeadline;
            rhsDeadline = that.getDeadline();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deadline", lhsDeadline), LocatorUtils.property(thatLocator, "deadline", rhsDeadline), lhsDeadline, rhsDeadline)) {
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
            Boolean lhsCritical;
            lhsCritical = this.isCritical();
            Boolean rhsCritical;
            rhsCritical = that.isCritical();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "critical", lhsCritical), LocatorUtils.property(thatLocator, "critical", rhsCritical), lhsCritical, rhsCritical)) {
                return false;
            }
        }
        {
            AssignmentTaskCodeType lhsCode;
            lhsCode = this.getCode();
            AssignmentTaskCodeType rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
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
            String theAssigneeId;
            theAssigneeId = this.getAssigneeId();
            strategy.appendField(locator, this, "assigneeId", buffer, theAssigneeId);
        }
        {
            XMLGregorianCalendar theDeadline;
            theDeadline = this.getDeadline();
            strategy.appendField(locator, this, "deadline", buffer, theDeadline);
        }
        {
            String theInstructions;
            theInstructions = this.getInstructions();
            strategy.appendField(locator, this, "instructions", buffer, theInstructions);
        }
        {
            Boolean theCritical;
            theCritical = this.isCritical();
            strategy.appendField(locator, this, "critical", buffer, theCritical);
        }
        {
            AssignmentTaskCodeType theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theAssigneeId;
            theAssigneeId = this.getAssigneeId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assigneeId", theAssigneeId), currentHashCode, theAssigneeId);
        }
        {
            XMLGregorianCalendar theDeadline;
            theDeadline = this.getDeadline();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deadline", theDeadline), currentHashCode, theDeadline);
        }
        {
            String theInstructions;
            theInstructions = this.getInstructions();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "instructions", theInstructions), currentHashCode, theInstructions);
        }
        {
            Boolean theCritical;
            theCritical = this.isCritical();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "critical", theCritical), currentHashCode, theCritical);
        }
        {
            AssignmentTaskCodeType theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
