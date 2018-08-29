
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
 * An element to wrap various fields, providing details about supporting-item.
 * 
 * <p>Java class for SupportingItems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupportingItems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="supportingItem" type="{http://ec.europa.eu/sg/hrs/types}SupportingItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupportingItems", propOrder = {
    "supportingItem"
})
public class SupportingItems
    implements Equals, HashCode, ToString
{

    protected List<SupportingItem> supportingItem;

    /**
     * Gets the value of the supportingItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportingItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportingItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupportingItem }
     * 
     * 
     */
    public List<SupportingItem> getSupportingItem() {
        if (supportingItem == null) {
            supportingItem = new ArrayList<SupportingItem>();
        }
        return this.supportingItem;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SupportingItems)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SupportingItems that = ((SupportingItems) object);
        {
            List<SupportingItem> lhsSupportingItem;
            lhsSupportingItem = (((this.supportingItem!= null)&&(!this.supportingItem.isEmpty()))?this.getSupportingItem():null);
            List<SupportingItem> rhsSupportingItem;
            rhsSupportingItem = (((that.supportingItem!= null)&&(!that.supportingItem.isEmpty()))?that.getSupportingItem():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "supportingItem", lhsSupportingItem), LocatorUtils.property(thatLocator, "supportingItem", rhsSupportingItem), lhsSupportingItem, rhsSupportingItem)) {
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
            List<SupportingItem> theSupportingItem;
            theSupportingItem = (((this.supportingItem!= null)&&(!this.supportingItem.isEmpty()))?this.getSupportingItem():null);
            strategy.appendField(locator, this, "supportingItem", buffer, theSupportingItem);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<SupportingItem> theSupportingItem;
            theSupportingItem = (((this.supportingItem!= null)&&(!this.supportingItem.isEmpty()))?this.getSupportingItem():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "supportingItem", theSupportingItem), currentHashCode, theSupportingItem);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
