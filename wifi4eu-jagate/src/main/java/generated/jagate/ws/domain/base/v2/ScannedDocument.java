
package generated.jagate.ws.domain.base.v2;

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
 * <p>Java class for ScannedDocument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScannedDocument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Filetype" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="Description" type="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}NonEmptyString"/>
 *         &lt;element name="BinaryContent" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScannedDocument", propOrder = {
    "filetype",
    "description",
    "binaryContent"
})
public class ScannedDocument
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Filetype", required = true)
    protected String filetype;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "BinaryContent", required = true)
    protected byte[] binaryContent;

    /**
     * Gets the value of the filetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiletype() {
        return filetype;
    }

    /**
     * Sets the value of the filetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiletype(String value) {
        this.filetype = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the binaryContent property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBinaryContent() {
        return binaryContent;
    }

    /**
     * Sets the value of the binaryContent property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBinaryContent(byte[] value) {
        this.binaryContent = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ScannedDocument)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ScannedDocument that = ((ScannedDocument) object);
        {
            String lhsFiletype;
            lhsFiletype = this.getFiletype();
            String rhsFiletype;
            rhsFiletype = that.getFiletype();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "filetype", lhsFiletype), LocatorUtils.property(thatLocator, "filetype", rhsFiletype), lhsFiletype, rhsFiletype)) {
                return false;
            }
        }
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            byte[] lhsBinaryContent;
            lhsBinaryContent = this.getBinaryContent();
            byte[] rhsBinaryContent;
            rhsBinaryContent = that.getBinaryContent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "binaryContent", lhsBinaryContent), LocatorUtils.property(thatLocator, "binaryContent", rhsBinaryContent), lhsBinaryContent, rhsBinaryContent)) {
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
            String theFiletype;
            theFiletype = this.getFiletype();
            strategy.appendField(locator, this, "filetype", buffer, theFiletype);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            byte[] theBinaryContent;
            theBinaryContent = this.getBinaryContent();
            strategy.appendField(locator, this, "binaryContent", buffer, theBinaryContent);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theFiletype;
            theFiletype = this.getFiletype();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "filetype", theFiletype), currentHashCode, theFiletype);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            byte[] theBinaryContent;
            theBinaryContent = this.getBinaryContent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "binaryContent", theBinaryContent), currentHashCode, theBinaryContent);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
