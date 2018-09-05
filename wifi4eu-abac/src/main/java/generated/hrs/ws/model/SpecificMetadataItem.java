
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * An item/attachment
 * 
 * <p>Java class for SpecificMetadataItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpecificMetadataItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="namespace" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contentSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="externalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="modificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="creatorUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecificMetadataItem", propOrder = {
    "itemId",
    "namespace",
    "name",
    "contentSize",
    "externalReference",
    "creationDate",
    "modificationDate",
    "creatorUserName"
})
public class SpecificMetadataItem
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String itemId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String namespace;
    @XmlElement(required = true)
    protected String name;
    protected int contentSize;
    protected String externalReference;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modificationDate;
    @XmlElement(required = true)
    protected String creatorUserName;

    /**
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemId(String value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the namespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Sets the value of the namespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespace(String value) {
        this.namespace = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the contentSize property.
     * 
     */
    public int getContentSize() {
        return contentSize;
    }

    /**
     * Sets the value of the contentSize property.
     * 
     */
    public void setContentSize(int value) {
        this.contentSize = value;
    }

    /**
     * Gets the value of the externalReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalReference() {
        return externalReference;
    }

    /**
     * Sets the value of the externalReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalReference(String value) {
        this.externalReference = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the modificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the value of the modificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModificationDate(XMLGregorianCalendar value) {
        this.modificationDate = value;
    }

    /**
     * Gets the value of the creatorUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorUserName() {
        return creatorUserName;
    }

    /**
     * Sets the value of the creatorUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorUserName(String value) {
        this.creatorUserName = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SpecificMetadataItem)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SpecificMetadataItem that = ((SpecificMetadataItem) object);
        {
            String lhsItemId;
            lhsItemId = this.getItemId();
            String rhsItemId;
            rhsItemId = that.getItemId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemId", lhsItemId), LocatorUtils.property(thatLocator, "itemId", rhsItemId), lhsItemId, rhsItemId)) {
                return false;
            }
        }
        {
            String lhsNamespace;
            lhsNamespace = this.getNamespace();
            String rhsNamespace;
            rhsNamespace = that.getNamespace();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "namespace", lhsNamespace), LocatorUtils.property(thatLocator, "namespace", rhsNamespace), lhsNamespace, rhsNamespace)) {
                return false;
            }
        }
        {
            String lhsName;
            lhsName = this.getName();
            String rhsName;
            rhsName = that.getName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                return false;
            }
        }
        {
            int lhsContentSize;
            lhsContentSize = (true?this.getContentSize(): 0);
            int rhsContentSize;
            rhsContentSize = (true?that.getContentSize(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contentSize", lhsContentSize), LocatorUtils.property(thatLocator, "contentSize", rhsContentSize), lhsContentSize, rhsContentSize)) {
                return false;
            }
        }
        {
            String lhsExternalReference;
            lhsExternalReference = this.getExternalReference();
            String rhsExternalReference;
            rhsExternalReference = that.getExternalReference();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalReference", lhsExternalReference), LocatorUtils.property(thatLocator, "externalReference", rhsExternalReference), lhsExternalReference, rhsExternalReference)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsCreationDate;
            lhsCreationDate = this.getCreationDate();
            XMLGregorianCalendar rhsCreationDate;
            rhsCreationDate = that.getCreationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creationDate", lhsCreationDate), LocatorUtils.property(thatLocator, "creationDate", rhsCreationDate), lhsCreationDate, rhsCreationDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsModificationDate;
            lhsModificationDate = this.getModificationDate();
            XMLGregorianCalendar rhsModificationDate;
            rhsModificationDate = that.getModificationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "modificationDate", lhsModificationDate), LocatorUtils.property(thatLocator, "modificationDate", rhsModificationDate), lhsModificationDate, rhsModificationDate)) {
                return false;
            }
        }
        {
            String lhsCreatorUserName;
            lhsCreatorUserName = this.getCreatorUserName();
            String rhsCreatorUserName;
            rhsCreatorUserName = that.getCreatorUserName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creatorUserName", lhsCreatorUserName), LocatorUtils.property(thatLocator, "creatorUserName", rhsCreatorUserName), lhsCreatorUserName, rhsCreatorUserName)) {
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
            String theItemId;
            theItemId = this.getItemId();
            strategy.appendField(locator, this, "itemId", buffer, theItemId);
        }
        {
            String theNamespace;
            theNamespace = this.getNamespace();
            strategy.appendField(locator, this, "namespace", buffer, theNamespace);
        }
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            int theContentSize;
            theContentSize = (true?this.getContentSize(): 0);
            strategy.appendField(locator, this, "contentSize", buffer, theContentSize);
        }
        {
            String theExternalReference;
            theExternalReference = this.getExternalReference();
            strategy.appendField(locator, this, "externalReference", buffer, theExternalReference);
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            strategy.appendField(locator, this, "creationDate", buffer, theCreationDate);
        }
        {
            XMLGregorianCalendar theModificationDate;
            theModificationDate = this.getModificationDate();
            strategy.appendField(locator, this, "modificationDate", buffer, theModificationDate);
        }
        {
            String theCreatorUserName;
            theCreatorUserName = this.getCreatorUserName();
            strategy.appendField(locator, this, "creatorUserName", buffer, theCreatorUserName);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theItemId;
            theItemId = this.getItemId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemId", theItemId), currentHashCode, theItemId);
        }
        {
            String theNamespace;
            theNamespace = this.getNamespace();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "namespace", theNamespace), currentHashCode, theNamespace);
        }
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            int theContentSize;
            theContentSize = (true?this.getContentSize(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contentSize", theContentSize), currentHashCode, theContentSize);
        }
        {
            String theExternalReference;
            theExternalReference = this.getExternalReference();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalReference", theExternalReference), currentHashCode, theExternalReference);
        }
        {
            XMLGregorianCalendar theCreationDate;
            theCreationDate = this.getCreationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creationDate", theCreationDate), currentHashCode, theCreationDate);
        }
        {
            XMLGregorianCalendar theModificationDate;
            theModificationDate = this.getModificationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "modificationDate", theModificationDate), currentHashCode, theModificationDate);
        }
        {
            String theCreatorUserName;
            theCreatorUserName = this.getCreatorUserName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creatorUserName", theCreatorUserName), currentHashCode, theCreatorUserName);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
