
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
 * Business specific metadata items/attachments to be added
 * 
 * <p>Java class for SpecificMetadataItemsToAdd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpecificMetadataItemsToAdd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="specificMetadataItem" type="{http://ec.europa.eu/sg/hrs/types}SpecificMetadataItemToAdd" maxOccurs="10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecificMetadataItemsToAdd", propOrder = {
    "specificMetadataItem"
})
public class SpecificMetadataItemsToAdd
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<SpecificMetadataItemToAdd> specificMetadataItem;

    /**
     * Gets the value of the specificMetadataItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specificMetadataItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecificMetadataItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecificMetadataItemToAdd }
     * 
     * 
     */
    public List<SpecificMetadataItemToAdd> getSpecificMetadataItem() {
        if (specificMetadataItem == null) {
            specificMetadataItem = new ArrayList<SpecificMetadataItemToAdd>();
        }
        return this.specificMetadataItem;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SpecificMetadataItemsToAdd)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SpecificMetadataItemsToAdd that = ((SpecificMetadataItemsToAdd) object);
        {
            List<SpecificMetadataItemToAdd> lhsSpecificMetadataItem;
            lhsSpecificMetadataItem = (((this.specificMetadataItem!= null)&&(!this.specificMetadataItem.isEmpty()))?this.getSpecificMetadataItem():null);
            List<SpecificMetadataItemToAdd> rhsSpecificMetadataItem;
            rhsSpecificMetadataItem = (((that.specificMetadataItem!= null)&&(!that.specificMetadataItem.isEmpty()))?that.getSpecificMetadataItem():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "specificMetadataItem", lhsSpecificMetadataItem), LocatorUtils.property(thatLocator, "specificMetadataItem", rhsSpecificMetadataItem), lhsSpecificMetadataItem, rhsSpecificMetadataItem)) {
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
            List<SpecificMetadataItemToAdd> theSpecificMetadataItem;
            theSpecificMetadataItem = (((this.specificMetadataItem!= null)&&(!this.specificMetadataItem.isEmpty()))?this.getSpecificMetadataItem():null);
            strategy.appendField(locator, this, "specificMetadataItem", buffer, theSpecificMetadataItem);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<SpecificMetadataItemToAdd> theSpecificMetadataItem;
            theSpecificMetadataItem = (((this.specificMetadataItem!= null)&&(!this.specificMetadataItem.isEmpty()))?this.getSpecificMetadataItem():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specificMetadataItem", theSpecificMetadataItem), currentHashCode, theSpecificMetadataItem);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
