
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * Response for operations that return a list of document notifications.
 * 
 * <p>Java class for DocumentNotificationsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentNotificationsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="total" type="{http://ec.europa.eu/sg/hrs/types}int0To300"/>
 *         &lt;element name="documentNotification" type="{http://ec.europa.eu/sg/hrs/types}DocumentNotification" maxOccurs="300" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentNotificationsResponse", propOrder = {
    "total",
    "documentNotification"
})
public class DocumentNotificationsResponse
    implements Equals, HashCode, ToString
{

    protected int total;
    protected List<DocumentNotification> documentNotification;

    /**
     * Gets the value of the total property.
     * 
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     */
    public void setTotal(int value) {
        this.total = value;
    }

    /**
     * Gets the value of the documentNotification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentNotification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentNotification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentNotification }
     * 
     * 
     */
    public List<DocumentNotification> getDocumentNotification() {
        if (documentNotification == null) {
            documentNotification = new ArrayList<DocumentNotification>();
        }
        return this.documentNotification;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentNotificationsResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentNotificationsResponse that = ((DocumentNotificationsResponse) object);
        {
            int lhsTotal;
            lhsTotal = (true?this.getTotal(): 0);
            int rhsTotal;
            rhsTotal = (true?that.getTotal(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "total", lhsTotal), LocatorUtils.property(thatLocator, "total", rhsTotal), lhsTotal, rhsTotal)) {
                return false;
            }
        }
        {
            List<DocumentNotification> lhsDocumentNotification;
            lhsDocumentNotification = (((this.documentNotification!= null)&&(!this.documentNotification.isEmpty()))?this.getDocumentNotification():null);
            List<DocumentNotification> rhsDocumentNotification;
            rhsDocumentNotification = (((that.documentNotification!= null)&&(!that.documentNotification.isEmpty()))?that.getDocumentNotification():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "documentNotification", lhsDocumentNotification), LocatorUtils.property(thatLocator, "documentNotification", rhsDocumentNotification), lhsDocumentNotification, rhsDocumentNotification)) {
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
            int theTotal;
            theTotal = (true?this.getTotal(): 0);
            strategy.appendField(locator, this, "total", buffer, theTotal);
        }
        {
            List<DocumentNotification> theDocumentNotification;
            theDocumentNotification = (((this.documentNotification!= null)&&(!this.documentNotification.isEmpty()))?this.getDocumentNotification():null);
            strategy.appendField(locator, this, "documentNotification", buffer, theDocumentNotification);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theTotal;
            theTotal = (true?this.getTotal(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "total", theTotal), currentHashCode, theTotal);
        }
        {
            List<DocumentNotification> theDocumentNotification;
            theDocumentNotification = (((this.documentNotification!= null)&&(!this.documentNotification.isEmpty()))?this.getDocumentNotification():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentNotification", theDocumentNotification), currentHashCode, theDocumentNotification);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
