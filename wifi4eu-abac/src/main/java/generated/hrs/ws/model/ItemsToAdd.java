
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 * <p>Java class for ItemsToAdd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemsToAdd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="scannedItem" type="{http://ec.europa.eu/sg/hrs/types}ScannedItemToAdd"/>
 *           &lt;element name="uploadedItem" type="{http://ec.europa.eu/sg/hrs/types}UploadedItemToAdd"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemsToAdd", propOrder = {
    "scannedItemOrUploadedItem"
})
public class ItemsToAdd
    implements Equals, HashCode, ToString
{

    @XmlElements({
        @XmlElement(name = "scannedItem", type = ScannedItemToAdd.class),
        @XmlElement(name = "uploadedItem", type = UploadedItemToAdd.class)
    })
    protected List<Object> scannedItemOrUploadedItem;

    /**
     * Gets the value of the scannedItemOrUploadedItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scannedItemOrUploadedItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScannedItemOrUploadedItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScannedItemToAdd }
     * {@link UploadedItemToAdd }
     * 
     * 
     */
    public List<Object> getScannedItemOrUploadedItem() {
        if (scannedItemOrUploadedItem == null) {
            scannedItemOrUploadedItem = new ArrayList<Object>();
        }
        return this.scannedItemOrUploadedItem;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ItemsToAdd)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ItemsToAdd that = ((ItemsToAdd) object);
        {
            List<Object> lhsScannedItemOrUploadedItem;
            lhsScannedItemOrUploadedItem = (((this.scannedItemOrUploadedItem!= null)&&(!this.scannedItemOrUploadedItem.isEmpty()))?this.getScannedItemOrUploadedItem():null);
            List<Object> rhsScannedItemOrUploadedItem;
            rhsScannedItemOrUploadedItem = (((that.scannedItemOrUploadedItem!= null)&&(!that.scannedItemOrUploadedItem.isEmpty()))?that.getScannedItemOrUploadedItem():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "scannedItemOrUploadedItem", lhsScannedItemOrUploadedItem), LocatorUtils.property(thatLocator, "scannedItemOrUploadedItem", rhsScannedItemOrUploadedItem), lhsScannedItemOrUploadedItem, rhsScannedItemOrUploadedItem)) {
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
            List<Object> theScannedItemOrUploadedItem;
            theScannedItemOrUploadedItem = (((this.scannedItemOrUploadedItem!= null)&&(!this.scannedItemOrUploadedItem.isEmpty()))?this.getScannedItemOrUploadedItem():null);
            strategy.appendField(locator, this, "scannedItemOrUploadedItem", buffer, theScannedItemOrUploadedItem);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<Object> theScannedItemOrUploadedItem;
            theScannedItemOrUploadedItem = (((this.scannedItemOrUploadedItem!= null)&&(!this.scannedItemOrUploadedItem.isEmpty()))?this.getScannedItemOrUploadedItem():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "scannedItemOrUploadedItem", theScannedItemOrUploadedItem), currentHashCode, theScannedItemOrUploadedItem);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
