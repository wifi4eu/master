
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ec.europa.eu/sg/hrs/types}header"/>
 *         &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="specificMetadataItems" type="{http://ec.europa.eu/sg/hrs/types}SpecificMetadataItemsToUpdate"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "documentId",
    "specificMetadataItems"
})
@XmlRootElement(name = "updateSpecificMetadataItems")
public class UpdateSpecificMetadataItems
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected String documentId;
    @XmlElement(required = true)
    protected SpecificMetadataItemsToUpdate specificMetadataItems;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
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
     * Gets the value of the specificMetadataItems property.
     * 
     * @return
     *     possible object is
     *     {@link SpecificMetadataItemsToUpdate }
     *     
     */
    public SpecificMetadataItemsToUpdate getSpecificMetadataItems() {
        return specificMetadataItems;
    }

    /**
     * Sets the value of the specificMetadataItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecificMetadataItemsToUpdate }
     *     
     */
    public void setSpecificMetadataItems(SpecificMetadataItemsToUpdate value) {
        this.specificMetadataItems = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UpdateSpecificMetadataItems)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UpdateSpecificMetadataItems that = ((UpdateSpecificMetadataItems) object);
        {
            Header lhsHeader;
            lhsHeader = this.getHeader();
            Header rhsHeader;
            rhsHeader = that.getHeader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "header", lhsHeader), LocatorUtils.property(thatLocator, "header", rhsHeader), lhsHeader, rhsHeader)) {
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
            SpecificMetadataItemsToUpdate lhsSpecificMetadataItems;
            lhsSpecificMetadataItems = this.getSpecificMetadataItems();
            SpecificMetadataItemsToUpdate rhsSpecificMetadataItems;
            rhsSpecificMetadataItems = that.getSpecificMetadataItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "specificMetadataItems", lhsSpecificMetadataItems), LocatorUtils.property(thatLocator, "specificMetadataItems", rhsSpecificMetadataItems), lhsSpecificMetadataItems, rhsSpecificMetadataItems)) {
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
            Header theHeader;
            theHeader = this.getHeader();
            strategy.appendField(locator, this, "header", buffer, theHeader);
        }
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            strategy.appendField(locator, this, "documentId", buffer, theDocumentId);
        }
        {
            SpecificMetadataItemsToUpdate theSpecificMetadataItems;
            theSpecificMetadataItems = this.getSpecificMetadataItems();
            strategy.appendField(locator, this, "specificMetadataItems", buffer, theSpecificMetadataItems);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Header theHeader;
            theHeader = this.getHeader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "header", theHeader), currentHashCode, theHeader);
        }
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentId", theDocumentId), currentHashCode, theDocumentId);
        }
        {
            SpecificMetadataItemsToUpdate theSpecificMetadataItems;
            theSpecificMetadataItems = this.getSpecificMetadataItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specificMetadataItems", theSpecificMetadataItems), currentHashCode, theSpecificMetadataItems);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
