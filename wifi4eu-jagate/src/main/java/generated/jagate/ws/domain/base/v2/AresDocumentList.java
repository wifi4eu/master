
package generated.jagate.ws.domain.base.v2;

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
 * <p>Java class for AresDocumentList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AresDocumentList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AresDocument" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}AresDocument" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AresDocumentList", propOrder = {
    "aresDocument"
})
public class AresDocumentList
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AresDocument", required = true)
    protected List<AresDocument> aresDocument;

    /**
     * Gets the value of the aresDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aresDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAresDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AresDocument }
     * 
     * 
     */
    public List<AresDocument> getAresDocument() {
        if (aresDocument == null) {
            aresDocument = new ArrayList<AresDocument>();
        }
        return this.aresDocument;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AresDocumentList)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AresDocumentList that = ((AresDocumentList) object);
        {
            List<AresDocument> lhsAresDocument;
            lhsAresDocument = (((this.aresDocument!= null)&&(!this.aresDocument.isEmpty()))?this.getAresDocument():null);
            List<AresDocument> rhsAresDocument;
            rhsAresDocument = (((that.aresDocument!= null)&&(!that.aresDocument.isEmpty()))?that.getAresDocument():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "aresDocument", lhsAresDocument), LocatorUtils.property(thatLocator, "aresDocument", rhsAresDocument), lhsAresDocument, rhsAresDocument)) {
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
            List<AresDocument> theAresDocument;
            theAresDocument = (((this.aresDocument!= null)&&(!this.aresDocument.isEmpty()))?this.getAresDocument():null);
            strategy.appendField(locator, this, "aresDocument", buffer, theAresDocument);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<AresDocument> theAresDocument;
            theAresDocument = (((this.aresDocument!= null)&&(!this.aresDocument.isEmpty()))?this.getAresDocument():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aresDocument", theAresDocument), currentHashCode, theAresDocument);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
