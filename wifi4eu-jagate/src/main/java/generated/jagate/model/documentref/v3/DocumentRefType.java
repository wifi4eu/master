
package generated.jagate.model.documentref.v3;

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
 * <p>Java class for DocumentRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://ec.europa.eu/research/fp/model/document-ref/V3}DocumentRefGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentRefType", propOrder = {
    "master",
    "masterID",
    "tag"
})
public class DocumentRefType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Master", required = true)
    protected String master;
    @XmlElement(name = "MasterID", required = true)
    protected String masterID;
    @XmlElement(name = "Tag")
    protected String tag;

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentRefType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentRefType that = ((DocumentRefType) object);
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
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
