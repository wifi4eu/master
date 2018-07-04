
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for AttachmentAttributeListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttachmentAttributeListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ec.europa.eu/research/fp/model/document/V5}AttachmentAttribute" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentAttributeListType", propOrder = {
    "attachmentAttribute"
})
public class AttachmentAttributeListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AttachmentAttribute", required = true)
    protected List<AttachmentAttributeType> attachmentAttribute;

    /**
     * Gets the value of the attachmentAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachmentAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachmentAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentAttributeType }
     * 
     * 
     */
    public List<AttachmentAttributeType> getAttachmentAttribute() {
        if (attachmentAttribute == null) {
            attachmentAttribute = new ArrayList<AttachmentAttributeType>();
        }
        return this.attachmentAttribute;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AttachmentAttributeListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AttachmentAttributeListType that = ((AttachmentAttributeListType) object);
        {
            List<AttachmentAttributeType> lhsAttachmentAttribute;
            lhsAttachmentAttribute = (((this.attachmentAttribute!= null)&&(!this.attachmentAttribute.isEmpty()))?this.getAttachmentAttribute():null);
            List<AttachmentAttributeType> rhsAttachmentAttribute;
            rhsAttachmentAttribute = (((that.attachmentAttribute!= null)&&(!that.attachmentAttribute.isEmpty()))?that.getAttachmentAttribute():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attachmentAttribute", lhsAttachmentAttribute), LocatorUtils.property(thatLocator, "attachmentAttribute", rhsAttachmentAttribute), lhsAttachmentAttribute, rhsAttachmentAttribute)) {
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
            List<AttachmentAttributeType> theAttachmentAttribute;
            theAttachmentAttribute = (((this.attachmentAttribute!= null)&&(!this.attachmentAttribute.isEmpty()))?this.getAttachmentAttribute():null);
            strategy.appendField(locator, this, "attachmentAttribute", buffer, theAttachmentAttribute);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<AttachmentAttributeType> theAttachmentAttribute;
            theAttachmentAttribute = (((this.attachmentAttribute!= null)&&(!this.attachmentAttribute.isEmpty()))?this.getAttachmentAttribute():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentAttribute", theAttachmentAttribute), currentHashCode, theAttachmentAttribute);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
