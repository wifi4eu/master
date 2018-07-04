
package eu.europa.ec.research.fp.model.document.v5;

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
 * A rerefence to an attachment, there is two ways to identify an attachment, the first is the document id plus attachment id
 * 				and the second is document id plus attachment name
 * 
 * <p>Java class for DocumentAttachmentRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentAttachmentRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://ec.europa.eu/research/fp/model/document-ref/V3}DocumentRefGroup"/>
 *         &lt;choice>
 *           &lt;element name="AttachmentId" type="{http://ec.europa.eu/research/fp/model/document/V5}AttachmentIdType"/>
 *           &lt;element name="AttachmentName" type="{http://ec.europa.eu/research/fp/model/document/V5}AttachmentNameType"/>
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
@XmlType(name = "DocumentAttachmentRefType", propOrder = {
    "master",
    "masterID",
    "tag",
    "attachmentId",
    "attachmentName"
})
public class DocumentAttachmentRefType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Master", namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3", required = true)
    protected String master;
    @XmlElement(name = "MasterID", namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3", required = true)
    protected String masterID;
    @XmlElement(name = "Tag", namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3")
    protected String tag;
    @XmlElement(name = "AttachmentId")
    protected AttachmentIdType attachmentId;
    @XmlElement(name = "AttachmentName")
    protected AttachmentNameType attachmentName;

    /**
     * Gets the value of the master property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaster() {
        return master;
    }

    /**
     * Sets the value of the master property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaster(String value) {
        this.master = value;
    }

    /**
     * Gets the value of the masterID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterID() {
        return masterID;
    }

    /**
     * Sets the value of the masterID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterID(String value) {
        this.masterID = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Gets the value of the attachmentId property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentIdType }
     *     
     */
    public AttachmentIdType getAttachmentId() {
        return attachmentId;
    }

    /**
     * Sets the value of the attachmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentIdType }
     *     
     */
    public void setAttachmentId(AttachmentIdType value) {
        this.attachmentId = value;
    }

    /**
     * Gets the value of the attachmentName property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentNameType }
     *     
     */
    public AttachmentNameType getAttachmentName() {
        return attachmentName;
    }

    /**
     * Sets the value of the attachmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentNameType }
     *     
     */
    public void setAttachmentName(AttachmentNameType value) {
        this.attachmentName = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentAttachmentRefType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentAttachmentRefType that = ((DocumentAttachmentRefType) object);
        {
            String lhsMaster;
            lhsMaster = this.getMaster();
            String rhsMaster;
            rhsMaster = that.getMaster();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "master", lhsMaster), LocatorUtils.property(thatLocator, "master", rhsMaster), lhsMaster, rhsMaster)) {
                return false;
            }
        }
        {
            String lhsMasterID;
            lhsMasterID = this.getMasterID();
            String rhsMasterID;
            rhsMasterID = that.getMasterID();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "masterID", lhsMasterID), LocatorUtils.property(thatLocator, "masterID", rhsMasterID), lhsMasterID, rhsMasterID)) {
                return false;
            }
        }
        {
            String lhsTag;
            lhsTag = this.getTag();
            String rhsTag;
            rhsTag = that.getTag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tag", lhsTag), LocatorUtils.property(thatLocator, "tag", rhsTag), lhsTag, rhsTag)) {
                return false;
            }
        }
        {
            AttachmentIdType lhsAttachmentId;
            lhsAttachmentId = this.getAttachmentId();
            AttachmentIdType rhsAttachmentId;
            rhsAttachmentId = that.getAttachmentId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attachmentId", lhsAttachmentId), LocatorUtils.property(thatLocator, "attachmentId", rhsAttachmentId), lhsAttachmentId, rhsAttachmentId)) {
                return false;
            }
        }
        {
            AttachmentNameType lhsAttachmentName;
            lhsAttachmentName = this.getAttachmentName();
            AttachmentNameType rhsAttachmentName;
            rhsAttachmentName = that.getAttachmentName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attachmentName", lhsAttachmentName), LocatorUtils.property(thatLocator, "attachmentName", rhsAttachmentName), lhsAttachmentName, rhsAttachmentName)) {
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
            String theMaster;
            theMaster = this.getMaster();
            strategy.appendField(locator, this, "master", buffer, theMaster);
        }
        {
            String theMasterID;
            theMasterID = this.getMasterID();
            strategy.appendField(locator, this, "masterID", buffer, theMasterID);
        }
        {
            String theTag;
            theTag = this.getTag();
            strategy.appendField(locator, this, "tag", buffer, theTag);
        }
        {
            AttachmentIdType theAttachmentId;
            theAttachmentId = this.getAttachmentId();
            strategy.appendField(locator, this, "attachmentId", buffer, theAttachmentId);
        }
        {
            AttachmentNameType theAttachmentName;
            theAttachmentName = this.getAttachmentName();
            strategy.appendField(locator, this, "attachmentName", buffer, theAttachmentName);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theMaster;
            theMaster = this.getMaster();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "master", theMaster), currentHashCode, theMaster);
        }
        {
            String theMasterID;
            theMasterID = this.getMasterID();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "masterID", theMasterID), currentHashCode, theMasterID);
        }
        {
            String theTag;
            theTag = this.getTag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tag", theTag), currentHashCode, theTag);
        }
        {
            AttachmentIdType theAttachmentId;
            theAttachmentId = this.getAttachmentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentId", theAttachmentId), currentHashCode, theAttachmentId);
        }
        {
            AttachmentNameType theAttachmentName;
            theAttachmentName = this.getAttachmentName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentName", theAttachmentName), currentHashCode, theAttachmentName);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
