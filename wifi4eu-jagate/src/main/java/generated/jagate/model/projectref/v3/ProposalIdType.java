
package generated.jagate.model.projectref.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
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
 * Contains project key identifier data elements 
 * 
 * <p>Java class for ProposalIdType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProposalIdType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{http://ec.europa.eu/research/fp/model/project-ref/V3}ProposalIdGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProposalIdType", propOrder = {
    "program",
    "number",
    "draftProposalID"
})
public class ProposalIdType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Program", required = true)
    protected CodeRefType program;
    @XmlElement(name = "Number")
    protected String number;
    @XmlElement(name = "DraftProposalID")
    protected String draftProposalID;

    /**
     * Gets the value of the program property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getProgram() {
        return program;
    }

    /**
     * Sets the value of the program property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setProgram(CodeRefType value) {
        this.program = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the draftProposalID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDraftProposalID() {
        return draftProposalID;
    }

    /**
     * Sets the value of the draftProposalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDraftProposalID(String value) {
        this.draftProposalID = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProposalIdType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ProposalIdType that = ((ProposalIdType) object);
        {
            CodeRefType lhsProgram;
            lhsProgram = this.getProgram();
            CodeRefType rhsProgram;
            rhsProgram = that.getProgram();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "program", lhsProgram), LocatorUtils.property(thatLocator, "program", rhsProgram), lhsProgram, rhsProgram)) {
                return false;
            }
        }
        {
            String lhsNumber;
            lhsNumber = this.getNumber();
            String rhsNumber;
            rhsNumber = that.getNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "number", lhsNumber), LocatorUtils.property(thatLocator, "number", rhsNumber), lhsNumber, rhsNumber)) {
                return false;
            }
        }
        {
            String lhsDraftProposalID;
            lhsDraftProposalID = this.getDraftProposalID();
            String rhsDraftProposalID;
            rhsDraftProposalID = that.getDraftProposalID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "draftProposalID", lhsDraftProposalID), LocatorUtils.property(thatLocator, "draftProposalID", rhsDraftProposalID), lhsDraftProposalID, rhsDraftProposalID)) {
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
            CodeRefType theProgram;
            theProgram = this.getProgram();
            strategy.appendField(locator, this, "program", buffer, theProgram);
        }
        {
            String theNumber;
            theNumber = this.getNumber();
            strategy.appendField(locator, this, "number", buffer, theNumber);
        }
        {
            String theDraftProposalID;
            theDraftProposalID = this.getDraftProposalID();
            strategy.appendField(locator, this, "draftProposalID", buffer, theDraftProposalID);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            CodeRefType theProgram;
            theProgram = this.getProgram();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "program", theProgram), currentHashCode, theProgram);
        }
        {
            String theNumber;
            theNumber = this.getNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "number", theNumber), currentHashCode, theNumber);
        }
        {
            String theDraftProposalID;
            theDraftProposalID = this.getDraftProposalID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "draftProposalID", theDraftProposalID), currentHashCode, theDraftProposalID);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
