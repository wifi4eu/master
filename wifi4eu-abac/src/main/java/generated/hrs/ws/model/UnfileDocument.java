
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ec.europa.eu/sg/hrs/types}header"/>
 *         &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;group ref="{http://ec.europa.eu/sg/hrs/types}FilingRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "documentId",
    "fileId",
    "fileSearchExpression",
    "specialFile"
})
@XmlRootElement(name = "unfileDocument")
public class UnfileDocument
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected String documentId;
    protected String fileId;
    protected String fileSearchExpression;
    protected Boolean specialFile;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentId(String value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the fileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * Sets the value of the fileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileId(String value) {
        this.fileId = value;
    }

    /**
     * Gets the value of the fileSearchExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileSearchExpression() {
        return fileSearchExpression;
    }

    /**
     * Sets the value of the fileSearchExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileSearchExpression(String value) {
        this.fileSearchExpression = value;
    }

    /**
     * Gets the value of the specialFile property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSpecialFile() {
        return specialFile;
    }

    /**
     * Sets the value of the specialFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSpecialFile(Boolean value) {
        this.specialFile = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UnfileDocument)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UnfileDocument that = ((UnfileDocument) object);
        {
            Header lhsHeader;
            lhsHeader = this.getHeader();
            Header rhsHeader;
            rhsHeader = that.getHeader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "header", lhsHeader), LocatorUtils.property(thatLocator, "header", rhsHeader), lhsHeader, rhsHeader)) {
                return false;
            }
        }
        {
            String lhsDocumentId;
            lhsDocumentId = this.getDocumentId();
            String rhsDocumentId;
            rhsDocumentId = that.getDocumentId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "documentId", lhsDocumentId), LocatorUtils.property(thatLocator, "documentId", rhsDocumentId), lhsDocumentId, rhsDocumentId)) {
                return false;
            }
        }
        {
            String lhsFileId;
            lhsFileId = this.getFileId();
            String rhsFileId;
            rhsFileId = that.getFileId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileId", lhsFileId), LocatorUtils.property(thatLocator, "fileId", rhsFileId), lhsFileId, rhsFileId)) {
                return false;
            }
        }
        {
            String lhsFileSearchExpression;
            lhsFileSearchExpression = this.getFileSearchExpression();
            String rhsFileSearchExpression;
            rhsFileSearchExpression = that.getFileSearchExpression();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileSearchExpression", lhsFileSearchExpression), LocatorUtils.property(thatLocator, "fileSearchExpression", rhsFileSearchExpression), lhsFileSearchExpression, rhsFileSearchExpression)) {
                return false;
            }
        }
        {
            Boolean lhsSpecialFile;
            lhsSpecialFile = this.isSpecialFile();
            Boolean rhsSpecialFile;
            rhsSpecialFile = that.isSpecialFile();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "specialFile", lhsSpecialFile), LocatorUtils.property(thatLocator, "specialFile", rhsSpecialFile), lhsSpecialFile, rhsSpecialFile)) {
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
            Header theHeader;
            theHeader = this.getHeader();
            strategy.appendField(locator, this, "header", buffer, theHeader);
        }
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            strategy.appendField(locator, this, "documentId", buffer, theDocumentId);
        }
        {
            String theFileId;
            theFileId = this.getFileId();
            strategy.appendField(locator, this, "fileId", buffer, theFileId);
        }
        {
            String theFileSearchExpression;
            theFileSearchExpression = this.getFileSearchExpression();
            strategy.appendField(locator, this, "fileSearchExpression", buffer, theFileSearchExpression);
        }
        {
            Boolean theSpecialFile;
            theSpecialFile = this.isSpecialFile();
            strategy.appendField(locator, this, "specialFile", buffer, theSpecialFile);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Header theHeader;
            theHeader = this.getHeader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "header", theHeader), currentHashCode, theHeader);
        }
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentId", theDocumentId), currentHashCode, theDocumentId);
        }
        {
            String theFileId;
            theFileId = this.getFileId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileId", theFileId), currentHashCode, theFileId);
        }
        {
            String theFileSearchExpression;
            theFileSearchExpression = this.getFileSearchExpression();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileSearchExpression", theFileSearchExpression), currentHashCode, theFileSearchExpression);
        }
        {
            Boolean theSpecialFile;
            theSpecialFile = this.isSpecialFile();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specialFile", theSpecialFile), currentHashCode, theSpecialFile);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
