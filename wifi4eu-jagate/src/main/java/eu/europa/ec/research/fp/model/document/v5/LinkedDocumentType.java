
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.documentref.v3.DocumentRefType;
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
 * <p>Java class for LinkedDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinkedDocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LinkedDocument" type="{http://ec.europa.eu/research/fp/model/document-ref/V3}DocumentRefType"/>
 *         &lt;element name="LinkType" type="{http://ec.europa.eu/research/fp/model/document/V5}LinkTypeType"/>
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkedDocumentType", propOrder = {
    "linkedDocument",
    "linkType",
    "reason"
})
public class LinkedDocumentType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "LinkedDocument", required = true)
    protected DocumentRefType linkedDocument;
    @XmlElement(name = "LinkType", required = true)
    protected LinkTypeType linkType;
    @XmlElement(name = "Reason", required = true)
    protected String reason;

    /**
     * Gets the value of the linkedDocument property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentRefType }
     *     
     */
    public DocumentRefType getLinkedDocument() {
        return linkedDocument;
    }

    /**
     * Sets the value of the linkedDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentRefType }
     *     
     */
    public void setLinkedDocument(DocumentRefType value) {
        this.linkedDocument = value;
    }

    /**
     * Gets the value of the linkType property.
     * 
     * @return
     *     possible object is
     *     {@link LinkTypeType }
     *     
     */
    public LinkTypeType getLinkType() {
        return linkType;
    }

    /**
     * Sets the value of the linkType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkTypeType }
     *     
     */
    public void setLinkType(LinkTypeType value) {
        this.linkType = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LinkedDocumentType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LinkedDocumentType that = ((LinkedDocumentType) object);
        {
            DocumentRefType lhsLinkedDocument;
            lhsLinkedDocument = this.getLinkedDocument();
            DocumentRefType rhsLinkedDocument;
            rhsLinkedDocument = that.getLinkedDocument();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "linkedDocument", lhsLinkedDocument), LocatorUtils.property(thatLocator, "linkedDocument", rhsLinkedDocument), lhsLinkedDocument, rhsLinkedDocument)) {
                return false;
            }
        }
        {
            LinkTypeType lhsLinkType;
            lhsLinkType = this.getLinkType();
            LinkTypeType rhsLinkType;
            rhsLinkType = that.getLinkType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "linkType", lhsLinkType), LocatorUtils.property(thatLocator, "linkType", rhsLinkType), lhsLinkType, rhsLinkType)) {
                return false;
            }
        }
        {
            String lhsReason;
            lhsReason = this.getReason();
            String rhsReason;
            rhsReason = that.getReason();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reason", lhsReason), LocatorUtils.property(thatLocator, "reason", rhsReason), lhsReason, rhsReason)) {
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
            DocumentRefType theLinkedDocument;
            theLinkedDocument = this.getLinkedDocument();
            strategy.appendField(locator, this, "linkedDocument", buffer, theLinkedDocument);
        }
        {
            LinkTypeType theLinkType;
            theLinkType = this.getLinkType();
            strategy.appendField(locator, this, "linkType", buffer, theLinkType);
        }
        {
            String theReason;
            theReason = this.getReason();
            strategy.appendField(locator, this, "reason", buffer, theReason);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            DocumentRefType theLinkedDocument;
            theLinkedDocument = this.getLinkedDocument();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "linkedDocument", theLinkedDocument), currentHashCode, theLinkedDocument);
        }
        {
            LinkTypeType theLinkType;
            theLinkType = this.getLinkType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "linkType", theLinkType), currentHashCode, theLinkType);
        }
        {
            String theReason;
            theReason = this.getReason();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reason", theReason), currentHashCode, theReason);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
