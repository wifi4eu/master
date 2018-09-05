
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
 * Common response for the operations searching for documents
 * 
 * <p>Java class for DocumentSearchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentSearchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="totalRetrievable" type="{http://ec.europa.eu/sg/hrs/types}int0To2000"/>
 *         &lt;element name="document" type="{http://ec.europa.eu/sg/hrs/types}Document" maxOccurs="2000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentSearchResponse", propOrder = {
    "totalRetrievable",
    "document"
})
public class DocumentSearchResponse
    implements Equals, HashCode, ToString
{

    protected int totalRetrievable;
    protected List<Document> document;

    /**
     * Gets the value of the totalRetrievable property.
     * 
     */
    public int getTotalRetrievable() {
        return totalRetrievable;
    }

    /**
     * Sets the value of the totalRetrievable property.
     * 
     */
    public void setTotalRetrievable(int value) {
        this.totalRetrievable = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Document }
     * 
     * 
     */
    public List<Document> getDocument() {
        if (document == null) {
            document = new ArrayList<Document>();
        }
        return this.document;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentSearchResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentSearchResponse that = ((DocumentSearchResponse) object);
        {
            int lhsTotalRetrievable;
            lhsTotalRetrievable = (true?this.getTotalRetrievable(): 0);
            int rhsTotalRetrievable;
            rhsTotalRetrievable = (true?that.getTotalRetrievable(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "totalRetrievable", lhsTotalRetrievable), LocatorUtils.property(thatLocator, "totalRetrievable", rhsTotalRetrievable), lhsTotalRetrievable, rhsTotalRetrievable)) {
                return false;
            }
        }
        {
            List<Document> lhsDocument;
            lhsDocument = (((this.document!= null)&&(!this.document.isEmpty()))?this.getDocument():null);
            List<Document> rhsDocument;
            rhsDocument = (((that.document!= null)&&(!that.document.isEmpty()))?that.getDocument():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "document", lhsDocument), LocatorUtils.property(thatLocator, "document", rhsDocument), lhsDocument, rhsDocument)) {
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
            int theTotalRetrievable;
            theTotalRetrievable = (true?this.getTotalRetrievable(): 0);
            strategy.appendField(locator, this, "totalRetrievable", buffer, theTotalRetrievable);
        }
        {
            List<Document> theDocument;
            theDocument = (((this.document!= null)&&(!this.document.isEmpty()))?this.getDocument():null);
            strategy.appendField(locator, this, "document", buffer, theDocument);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theTotalRetrievable;
            theTotalRetrievable = (true?this.getTotalRetrievable(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalRetrievable", theTotalRetrievable), currentHashCode, theTotalRetrievable);
        }
        {
            List<Document> theDocument;
            theDocument = (((this.document!= null)&&(!this.document.isEmpty()))?this.getDocument():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "document", theDocument), currentHashCode, theDocument);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
