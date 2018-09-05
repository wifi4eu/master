
package generated.hrs.ws.model;

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
 * Request for adding an external EU Login / ECAS signature to multiple documents
 * 
 * <p>Java class for AddExternalSignatureRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddExternalSignatureRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="10"/>
 *         &lt;element name="ecasSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddExternalSignatureRequest", propOrder = {
    "documentId",
    "ecasSignature",
    "application"
})
public class AddExternalSignatureRequest
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<String> documentId;
    @XmlElement(required = true)
    protected byte[] ecasSignature;
    @XmlElement(required = true)
    protected String application;

    /**
     * Gets the value of the documentId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDocumentId() {
        if (documentId == null) {
            documentId = new ArrayList<String>();
        }
        return this.documentId;
    }

    /**
     * Gets the value of the ecasSignature property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getEcasSignature() {
        return ecasSignature;
    }

    /**
     * Sets the value of the ecasSignature property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setEcasSignature(byte[] value) {
        this.ecasSignature = value;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AddExternalSignatureRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AddExternalSignatureRequest that = ((AddExternalSignatureRequest) object);
        {
            List<String> lhsDocumentId;
            lhsDocumentId = (((this.documentId!= null)&&(!this.documentId.isEmpty()))?this.getDocumentId():null);
            List<String> rhsDocumentId;
            rhsDocumentId = (((that.documentId!= null)&&(!that.documentId.isEmpty()))?that.getDocumentId():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "documentId", lhsDocumentId), LocatorUtils.property(thatLocator, "documentId", rhsDocumentId), lhsDocumentId, rhsDocumentId)) {
                return false;
            }
        }
        {
            byte[] lhsEcasSignature;
            lhsEcasSignature = this.getEcasSignature();
            byte[] rhsEcasSignature;
            rhsEcasSignature = that.getEcasSignature();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ecasSignature", lhsEcasSignature), LocatorUtils.property(thatLocator, "ecasSignature", rhsEcasSignature), lhsEcasSignature, rhsEcasSignature)) {
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
            List<String> theDocumentId;
            theDocumentId = (((this.documentId!= null)&&(!this.documentId.isEmpty()))?this.getDocumentId():null);
            strategy.appendField(locator, this, "documentId", buffer, theDocumentId);
        }
        {
            byte[] theEcasSignature;
            theEcasSignature = this.getEcasSignature();
            strategy.appendField(locator, this, "ecasSignature", buffer, theEcasSignature);
        }
        {
            String theApplication;
            theApplication = this.getApplication();
            strategy.appendField(locator, this, "application", buffer, theApplication);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<String> theDocumentId;
            theDocumentId = (((this.documentId!= null)&&(!this.documentId.isEmpty()))?this.getDocumentId():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentId", theDocumentId), currentHashCode, theDocumentId);
        }
        {
            byte[] theEcasSignature;
            theEcasSignature = this.getEcasSignature();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ecasSignature", theEcasSignature), currentHashCode, theEcasSignature);
        }
        {
            String theApplication;
            theApplication = this.getApplication();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "application", theApplication), currentHashCode, theApplication);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
