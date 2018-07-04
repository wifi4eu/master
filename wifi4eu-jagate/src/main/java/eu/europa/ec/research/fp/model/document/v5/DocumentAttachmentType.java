
package eu.europa.ec.research.fp.model.document.v5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import generated.jagate.model.coderef.V3.CodeRefType;
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
 * <p>Java class for DocumentAttachmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentAttachmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserReadableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MimeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BinaryContent" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="AttachmentType" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="LanguageCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *         &lt;element name="MetaData" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentMetaDataType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Size" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="URI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentAttachmentType", propOrder = {
    "id",
    "name",
    "userReadableName",
    "description",
    "mimeType",
    "binaryContent",
    "attachmentType",
    "languageCode",
    "metaData",
    "size",
    "uri"
})
public class DocumentAttachmentType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "UserReadableName")
    protected String userReadableName;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "MimeType")
    protected String mimeType;
    @XmlElement(name = "BinaryContent")
    protected byte[] binaryContent;
    @XmlElement(name = "AttachmentType", required = true)
    protected CodeRefType attachmentType;
    @XmlElement(name = "LanguageCode")
    protected CodeRefType languageCode;
    @XmlElement(name = "MetaData")
    protected List<DocumentMetaDataType> metaData;
    @XmlElement(name = "Size")
    protected BigInteger size;
    @XmlElement(name = "URI")
    protected String uri;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
     * Gets the value of the userReadableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserReadableName() {
        return userReadableName;
    }

    /**
     * Sets the value of the userReadableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserReadableName(String value) {
        this.userReadableName = value;
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
     * Gets the value of the mimeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the value of the mimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMimeType(String value) {
        this.mimeType = value;
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

    /**
     * Gets the value of the attachmentType property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getAttachmentType() {
        return attachmentType;
    }

    /**
     * Sets the value of the attachmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setAttachmentType(CodeRefType value) {
        this.attachmentType = value;
    }

    /**
     * Gets the value of the languageCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getLanguageCode() {
        return languageCode;
    }

    /**
     * Sets the value of the languageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setLanguageCode(CodeRefType value) {
        this.languageCode = value;
    }

    /**
     * Gets the value of the metaData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metaData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetaData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentMetaDataType }
     * 
     * 
     */
    public List<DocumentMetaDataType> getMetaData() {
        if (metaData == null) {
            metaData = new ArrayList<DocumentMetaDataType>();
        }
        return this.metaData;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSize(BigInteger value) {
        this.size = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURI() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURI(String value) {
        this.uri = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentAttachmentType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentAttachmentType that = ((DocumentAttachmentType) object);
        {
            String lhsId;
            lhsId = this.getId();
            String rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
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
            String lhsUserReadableName;
            lhsUserReadableName = this.getUserReadableName();
            String rhsUserReadableName;
            rhsUserReadableName = that.getUserReadableName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userReadableName", lhsUserReadableName), LocatorUtils.property(thatLocator, "userReadableName", rhsUserReadableName), lhsUserReadableName, rhsUserReadableName)) {
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
            String lhsMimeType;
            lhsMimeType = this.getMimeType();
            String rhsMimeType;
            rhsMimeType = that.getMimeType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mimeType", lhsMimeType), LocatorUtils.property(thatLocator, "mimeType", rhsMimeType), lhsMimeType, rhsMimeType)) {
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
        {
            CodeRefType lhsAttachmentType;
            lhsAttachmentType = this.getAttachmentType();
            CodeRefType rhsAttachmentType;
            rhsAttachmentType = that.getAttachmentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attachmentType", lhsAttachmentType), LocatorUtils.property(thatLocator, "attachmentType", rhsAttachmentType), lhsAttachmentType, rhsAttachmentType)) {
                return false;
            }
        }
        {
            CodeRefType lhsLanguageCode;
            lhsLanguageCode = this.getLanguageCode();
            CodeRefType rhsLanguageCode;
            rhsLanguageCode = that.getLanguageCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "languageCode", lhsLanguageCode), LocatorUtils.property(thatLocator, "languageCode", rhsLanguageCode), lhsLanguageCode, rhsLanguageCode)) {
                return false;
            }
        }
        {
            List<DocumentMetaDataType> lhsMetaData;
            lhsMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            List<DocumentMetaDataType> rhsMetaData;
            rhsMetaData = (((that.metaData!= null)&&(!that.metaData.isEmpty()))?that.getMetaData():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "metaData", lhsMetaData), LocatorUtils.property(thatLocator, "metaData", rhsMetaData), lhsMetaData, rhsMetaData)) {
                return false;
            }
        }
        {
            BigInteger lhsSize;
            lhsSize = this.getSize();
            BigInteger rhsSize;
            rhsSize = that.getSize();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "size", lhsSize), LocatorUtils.property(thatLocator, "size", rhsSize), lhsSize, rhsSize)) {
                return false;
            }
        }
        {
            String lhsURI;
            lhsURI = this.getURI();
            String rhsURI;
            rhsURI = that.getURI();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "uri", lhsURI), LocatorUtils.property(thatLocator, "uri", rhsURI), lhsURI, rhsURI)) {
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
            String theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            String theUserReadableName;
            theUserReadableName = this.getUserReadableName();
            strategy.appendField(locator, this, "userReadableName", buffer, theUserReadableName);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            String theMimeType;
            theMimeType = this.getMimeType();
            strategy.appendField(locator, this, "mimeType", buffer, theMimeType);
        }
        {
            byte[] theBinaryContent;
            theBinaryContent = this.getBinaryContent();
            strategy.appendField(locator, this, "binaryContent", buffer, theBinaryContent);
        }
        {
            CodeRefType theAttachmentType;
            theAttachmentType = this.getAttachmentType();
            strategy.appendField(locator, this, "attachmentType", buffer, theAttachmentType);
        }
        {
            CodeRefType theLanguageCode;
            theLanguageCode = this.getLanguageCode();
            strategy.appendField(locator, this, "languageCode", buffer, theLanguageCode);
        }
        {
            List<DocumentMetaDataType> theMetaData;
            theMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            strategy.appendField(locator, this, "metaData", buffer, theMetaData);
        }
        {
            BigInteger theSize;
            theSize = this.getSize();
            strategy.appendField(locator, this, "size", buffer, theSize);
        }
        {
            String theURI;
            theURI = this.getURI();
            strategy.appendField(locator, this, "uri", buffer, theURI);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            String theUserReadableName;
            theUserReadableName = this.getUserReadableName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userReadableName", theUserReadableName), currentHashCode, theUserReadableName);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            String theMimeType;
            theMimeType = this.getMimeType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mimeType", theMimeType), currentHashCode, theMimeType);
        }
        {
            byte[] theBinaryContent;
            theBinaryContent = this.getBinaryContent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "binaryContent", theBinaryContent), currentHashCode, theBinaryContent);
        }
        {
            CodeRefType theAttachmentType;
            theAttachmentType = this.getAttachmentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachmentType", theAttachmentType), currentHashCode, theAttachmentType);
        }
        {
            CodeRefType theLanguageCode;
            theLanguageCode = this.getLanguageCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "languageCode", theLanguageCode), currentHashCode, theLanguageCode);
        }
        {
            List<DocumentMetaDataType> theMetaData;
            theMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "metaData", theMetaData), currentHashCode, theMetaData);
        }
        {
            BigInteger theSize;
            theSize = this.getSize();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "size", theSize), currentHashCode, theSize);
        }
        {
            String theURI;
            theURI = this.getURI();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "uri", theURI), currentHashCode, theURI);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
