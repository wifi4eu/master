
package generated.hrs.ws.model;

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
 * An external signature of a document. This represents a sign action done
 *                 outside of Hermes and, thus, not via Hermes e-Signatory workflow.
 *                 From Hermes point of view this is just stored as information and does not have any
 *                 (legal) value.
 * 
 * <p>Java class for ExternalSignature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalSignature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="signedBy" type="{http://ec.europa.eu/sg/hrs/types}WorkflowUser"/>
 *         &lt;element name="dateSigned" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ecasSignature" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalSignature", propOrder = {
    "id",
    "signedBy",
    "dateSigned",
    "application",
    "ecasSignature"
})
public class ExternalSignature
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected WorkflowUser signedBy;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateSigned;
    @XmlElement(required = true)
    protected String application;
    protected boolean ecasSignature;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the signedBy property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowUser }
     *     
     */
    public WorkflowUser getSignedBy() {
        return signedBy;
    }

    /**
     * Sets the value of the signedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowUser }
     *     
     */
    public void setSignedBy(WorkflowUser value) {
        this.signedBy = value;
    }

    /**
     * Gets the value of the dateSigned property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateSigned() {
        return dateSigned;
    }

    /**
     * Sets the value of the dateSigned property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateSigned(XMLGregorianCalendar value) {
        this.dateSigned = value;
    }

    /**
     * Gets the value of the application property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplication(String value) {
        this.application = value;
    }

    /**
     * Gets the value of the ecasSignature property.
     * 
     */
    public boolean isEcasSignature() {
        return ecasSignature;
    }

    /**
     * Sets the value of the ecasSignature property.
     * 
     */
    public void setEcasSignature(boolean value) {
        this.ecasSignature = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExternalSignature)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExternalSignature that = ((ExternalSignature) object);
        {
            int lhsId;
            lhsId = (true?this.getId(): 0);
            int rhsId;
            rhsId = (true?that.getId(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            WorkflowUser lhsSignedBy;
            lhsSignedBy = this.getSignedBy();
            WorkflowUser rhsSignedBy;
            rhsSignedBy = that.getSignedBy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "signedBy", lhsSignedBy), LocatorUtils.property(thatLocator, "signedBy", rhsSignedBy), lhsSignedBy, rhsSignedBy)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDateSigned;
            lhsDateSigned = this.getDateSigned();
            XMLGregorianCalendar rhsDateSigned;
            rhsDateSigned = that.getDateSigned();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateSigned", lhsDateSigned), LocatorUtils.property(thatLocator, "dateSigned", rhsDateSigned), lhsDateSigned, rhsDateSigned)) {
                return false;
            }
        }
        {
            String lhsApplication;
            lhsApplication = this.getApplication();
            String rhsApplication;
            rhsApplication = that.getApplication();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "application", lhsApplication), LocatorUtils.property(thatLocator, "application", rhsApplication), lhsApplication, rhsApplication)) {
                return false;
            }
        }
        {
            boolean lhsEcasSignature;
            lhsEcasSignature = (true?this.isEcasSignature():false);
            boolean rhsEcasSignature;
            rhsEcasSignature = (true?that.isEcasSignature():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ecasSignature", lhsEcasSignature), LocatorUtils.property(thatLocator, "ecasSignature", rhsEcasSignature), lhsEcasSignature, rhsEcasSignature)) {
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
            int theId;
            theId = (true?this.getId(): 0);
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            WorkflowUser theSignedBy;
            theSignedBy = this.getSignedBy();
            strategy.appendField(locator, this, "signedBy", buffer, theSignedBy);
        }
        {
            XMLGregorianCalendar theDateSigned;
            theDateSigned = this.getDateSigned();
            strategy.appendField(locator, this, "dateSigned", buffer, theDateSigned);
        }
        {
            String theApplication;
            theApplication = this.getApplication();
            strategy.appendField(locator, this, "application", buffer, theApplication);
        }
        {
            boolean theEcasSignature;
            theEcasSignature = (true?this.isEcasSignature():false);
            strategy.appendField(locator, this, "ecasSignature", buffer, theEcasSignature);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theId;
            theId = (true?this.getId(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            WorkflowUser theSignedBy;
            theSignedBy = this.getSignedBy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "signedBy", theSignedBy), currentHashCode, theSignedBy);
        }
        {
            XMLGregorianCalendar theDateSigned;
            theDateSigned = this.getDateSigned();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateSigned", theDateSigned), currentHashCode, theDateSigned);
        }
        {
            String theApplication;
            theApplication = this.getApplication();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "application", theApplication), currentHashCode, theApplication);
        }
        {
            boolean theEcasSignature;
            theEcasSignature = (true?this.isEcasSignature():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ecasSignature", theEcasSignature), currentHashCode, theEcasSignature);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
