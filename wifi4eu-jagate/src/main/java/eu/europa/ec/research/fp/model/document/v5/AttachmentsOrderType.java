
package eu.europa.ec.research.fp.model.document.v5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
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
 * <p>Java class for AttachmentsOrderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttachmentsOrderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AttachmentOrder" type="{http://ec.europa.eu/research/fp/model/document/V5}AttachmentsOrderListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentsOrderType", propOrder = {
    "attachmentOrder"
})
public class AttachmentsOrderType
    implements Equals, HashCode, ToString
{

    @XmlList
    @XmlElement(name = "AttachmentOrder", required = true)
    protected List<String> attachmentOrder;

    /**
     * Gets the value of the attachmentOrder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachmentOrder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachmentOrder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAttachmentOrder() {
        if (attachmentOrder == null) {
            attachmentOrder = new ArrayList<String>();
        }
        return this.attachmentOrder;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AttachmentsOrderType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AttachmentsOrderType that = ((AttachmentsOrderType) object);
        {
            List<String> lhsAttachmentOrder;
            lhsAttachmentOrder = (((this.attachmentOrder!= null)&&(!this.attachmentOrder.isEmpty()))?this.getAttachmentOrder():null);
            List<String> rhsAttachmentOrder;
            rhsAttachmentOrder = (((that.attachmentOrder!= null)&&(!that.attachmentOrder.isEmpty()))?that.getAttachmentOrder():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attachmentOrder", lhsAttachmentOrder), LocatorUtils.property(thatLocator, "attachmentOrder", rhsAttachmentOrder), lhsAttachmentOrder, rhsAttachmentOrder)) {
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
            List<String> theAttachmentOrder;
            theAttachmentOrder = (((this.attachmentOrder!= null)&&(!this.attachmentOrder.isEmpty()))?this.getAttachmentOrder():null);
            strategy.appendField(locator, this, "attachmentOrder", buffer, theAttachmentOrder);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<String> theAttachmentOrder;
            theAttachmentOrder = (((this.attachmentOrder!= null)&&(!this.attachmentOrder.isEmpty()))?this.getAttachmentOrder():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentOrder", theAttachmentOrder), currentHashCode, theAttachmentOrder);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
