
package generated.hrs.ws.model;

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
 * Request for creating a link between 2 documents.
 * 
 * <p>Java class for LinkDocumentsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinkDocumentsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sourceDocumentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="targetDocumentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="linkType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="RESPONSE"/>
 *               &lt;enumeration value="GENERAL"/>
 *               &lt;enumeration value="DUPLICATE"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkDocumentsRequest", propOrder = {
    "sourceDocumentId",
    "targetDocumentId",
    "linkType"
})
public class LinkDocumentsRequest
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String sourceDocumentId;
    @XmlElement(required = true)
    protected String targetDocumentId;
    @XmlElement(required = true)
    protected String linkType;

    /**
     * Gets the value of the sourceDocumentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceDocumentId() {
        return sourceDocumentId;
    }

    /**
     * Sets the value of the sourceDocumentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceDocumentId(String value) {
        this.sourceDocumentId = value;
    }

    /**
     * Gets the value of the targetDocumentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetDocumentId() {
        return targetDocumentId;
    }

    /**
     * Sets the value of the targetDocumentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetDocumentId(String value) {
        this.targetDocumentId = value;
    }

    /**
     * Gets the value of the linkType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkType() {
        return linkType;
    }

    /**
     * Sets the value of the linkType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkType(String value) {
        this.linkType = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LinkDocumentsRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final LinkDocumentsRequest that = ((LinkDocumentsRequest) object);
        {
            String lhsSourceDocumentId;
            lhsSourceDocumentId = this.getSourceDocumentId();
            String rhsSourceDocumentId;
            rhsSourceDocumentId = that.getSourceDocumentId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sourceDocumentId", lhsSourceDocumentId), LocatorUtils.property(thatLocator, "sourceDocumentId", rhsSourceDocumentId), lhsSourceDocumentId, rhsSourceDocumentId)) {
                return false;
            }
        }
        {
            String lhsTargetDocumentId;
            lhsTargetDocumentId = this.getTargetDocumentId();
            String rhsTargetDocumentId;
            rhsTargetDocumentId = that.getTargetDocumentId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "targetDocumentId", lhsTargetDocumentId), LocatorUtils.property(thatLocator, "targetDocumentId", rhsTargetDocumentId), lhsTargetDocumentId, rhsTargetDocumentId)) {
                return false;
            }
        }
        {
            String lhsLinkType;
            lhsLinkType = this.getLinkType();
            String rhsLinkType;
            rhsLinkType = that.getLinkType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "linkType", lhsLinkType), LocatorUtils.property(thatLocator, "linkType", rhsLinkType), lhsLinkType, rhsLinkType)) {
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
            String theSourceDocumentId;
            theSourceDocumentId = this.getSourceDocumentId();
            strategy.appendField(locator, this, "sourceDocumentId", buffer, theSourceDocumentId);
        }
        {
            String theTargetDocumentId;
            theTargetDocumentId = this.getTargetDocumentId();
            strategy.appendField(locator, this, "targetDocumentId", buffer, theTargetDocumentId);
        }
        {
            String theLinkType;
            theLinkType = this.getLinkType();
            strategy.appendField(locator, this, "linkType", buffer, theLinkType);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theSourceDocumentId;
            theSourceDocumentId = this.getSourceDocumentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sourceDocumentId", theSourceDocumentId), currentHashCode, theSourceDocumentId);
        }
        {
            String theTargetDocumentId;
            theTargetDocumentId = this.getTargetDocumentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "targetDocumentId", theTargetDocumentId), currentHashCode, theTargetDocumentId);
        }
        {
            String theLinkType;
            theLinkType = this.getLinkType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "linkType", theLinkType), currentHashCode, theLinkType);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
