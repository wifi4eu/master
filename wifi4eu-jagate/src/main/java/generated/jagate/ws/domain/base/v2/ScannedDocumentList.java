
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
 * <p>Java class for ScannedDocumentList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScannedDocumentList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ScannedDocument" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}ScannedDocument" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScannedDocumentList", propOrder = {
    "scannedDocument"
})
public class ScannedDocumentList
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ScannedDocument", required = true)
    protected List<ScannedDocument> scannedDocument;

    /**
     * Gets the value of the scannedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scannedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScannedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScannedDocument }
     * 
     * 
     */
    public List<ScannedDocument> getScannedDocument() {
        if (scannedDocument == null) {
            scannedDocument = new ArrayList<ScannedDocument>();
        }
        return this.scannedDocument;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ScannedDocumentList)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ScannedDocumentList that = ((ScannedDocumentList) object);
        {
            List<ScannedDocument> lhsScannedDocument;
            lhsScannedDocument = (((this.scannedDocument!= null)&&(!this.scannedDocument.isEmpty()))?this.getScannedDocument():null);
            List<ScannedDocument> rhsScannedDocument;
            rhsScannedDocument = (((that.scannedDocument!= null)&&(!that.scannedDocument.isEmpty()))?that.getScannedDocument():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "scannedDocument", lhsScannedDocument), LocatorUtils.property(thatLocator, "scannedDocument", rhsScannedDocument), lhsScannedDocument, rhsScannedDocument)) {
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
            List<ScannedDocument> theScannedDocument;
            theScannedDocument = (((this.scannedDocument!= null)&&(!this.scannedDocument.isEmpty()))?this.getScannedDocument():null);
            strategy.appendField(locator, this, "scannedDocument", buffer, theScannedDocument);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<ScannedDocument> theScannedDocument;
            theScannedDocument = (((this.scannedDocument!= null)&&(!this.scannedDocument.isEmpty()))?this.getScannedDocument():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "scannedDocument", theScannedDocument), currentHashCode, theScannedDocument);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
