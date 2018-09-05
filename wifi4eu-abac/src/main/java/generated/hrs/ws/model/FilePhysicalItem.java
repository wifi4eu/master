
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
 * A physical item (binder, folder…) for a file that has a non-electronic part (ex: paper documents, information on DVD…).
 *                 This is not compulsory and the functionality is only available for files (not for subfiles).
 * 
 * <p>Java class for FilePhysicalItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilePhysicalItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://ec.europa.eu/sg/hrs/types}FilePhysicalItemType"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paper" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="digital" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="analogue" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="other" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilePhysicalItem", propOrder = {
    "type",
    "code",
    "paper",
    "digital",
    "analogue",
    "other",
    "comments"
})
public class FilePhysicalItem
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected FilePhysicalItemType type;
    @XmlElement(required = true)
    protected String code;
    protected Boolean paper;
    protected Boolean digital;
    protected Boolean analogue;
    protected String other;
    protected String comments;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link FilePhysicalItemType }
     *     
     */
    public FilePhysicalItemType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilePhysicalItemType }
     *     
     */
    public void setType(FilePhysicalItemType value) {
        this.type = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the paper property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPaper() {
        return paper;
    }

    /**
     * Sets the value of the paper property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPaper(Boolean value) {
        this.paper = value;
    }

    /**
     * Gets the value of the digital property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDigital() {
        return digital;
    }

    /**
     * Sets the value of the digital property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDigital(Boolean value) {
        this.digital = value;
    }

    /**
     * Gets the value of the analogue property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnalogue() {
        return analogue;
    }

    /**
     * Sets the value of the analogue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnalogue(Boolean value) {
        this.analogue = value;
    }

    /**
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOther(String value) {
        this.other = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FilePhysicalItem)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FilePhysicalItem that = ((FilePhysicalItem) object);
        {
            FilePhysicalItemType lhsType;
            lhsType = this.getType();
            FilePhysicalItemType rhsType;
            rhsType = that.getType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType)) {
                return false;
            }
        }
        {
            String lhsCode;
            lhsCode = this.getCode();
            String rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
                return false;
            }
        }
        {
            Boolean lhsPaper;
            lhsPaper = this.isPaper();
            Boolean rhsPaper;
            rhsPaper = that.isPaper();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "paper", lhsPaper), LocatorUtils.property(thatLocator, "paper", rhsPaper), lhsPaper, rhsPaper)) {
                return false;
            }
        }
        {
            Boolean lhsDigital;
            lhsDigital = this.isDigital();
            Boolean rhsDigital;
            rhsDigital = that.isDigital();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "digital", lhsDigital), LocatorUtils.property(thatLocator, "digital", rhsDigital), lhsDigital, rhsDigital)) {
                return false;
            }
        }
        {
            Boolean lhsAnalogue;
            lhsAnalogue = this.isAnalogue();
            Boolean rhsAnalogue;
            rhsAnalogue = that.isAnalogue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "analogue", lhsAnalogue), LocatorUtils.property(thatLocator, "analogue", rhsAnalogue), lhsAnalogue, rhsAnalogue)) {
                return false;
            }
        }
        {
            String lhsOther;
            lhsOther = this.getOther();
            String rhsOther;
            rhsOther = that.getOther();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "other", lhsOther), LocatorUtils.property(thatLocator, "other", rhsOther), lhsOther, rhsOther)) {
                return false;
            }
        }
        {
            String lhsComments;
            lhsComments = this.getComments();
            String rhsComments;
            rhsComments = that.getComments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "comments", lhsComments), LocatorUtils.property(thatLocator, "comments", rhsComments), lhsComments, rhsComments)) {
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
            FilePhysicalItemType theType;
            theType = this.getType();
            strategy.appendField(locator, this, "type", buffer, theType);
        }
        {
            String theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        {
            Boolean thePaper;
            thePaper = this.isPaper();
            strategy.appendField(locator, this, "paper", buffer, thePaper);
        }
        {
            Boolean theDigital;
            theDigital = this.isDigital();
            strategy.appendField(locator, this, "digital", buffer, theDigital);
        }
        {
            Boolean theAnalogue;
            theAnalogue = this.isAnalogue();
            strategy.appendField(locator, this, "analogue", buffer, theAnalogue);
        }
        {
            String theOther;
            theOther = this.getOther();
            strategy.appendField(locator, this, "other", buffer, theOther);
        }
        {
            String theComments;
            theComments = this.getComments();
            strategy.appendField(locator, this, "comments", buffer, theComments);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            FilePhysicalItemType theType;
            theType = this.getType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType);
        }
        {
            String theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        {
            Boolean thePaper;
            thePaper = this.isPaper();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "paper", thePaper), currentHashCode, thePaper);
        }
        {
            Boolean theDigital;
            theDigital = this.isDigital();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "digital", theDigital), currentHashCode, theDigital);
        }
        {
            Boolean theAnalogue;
            theAnalogue = this.isAnalogue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "analogue", theAnalogue), currentHashCode, theAnalogue);
        }
        {
            String theOther;
            theOther = this.getOther();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "other", theOther), currentHashCode, theOther);
        }
        {
            String theComments;
            theComments = this.getComments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "comments", theComments), currentHashCode, theComments);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
