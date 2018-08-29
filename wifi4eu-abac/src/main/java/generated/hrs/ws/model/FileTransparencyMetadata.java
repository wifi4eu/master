
package generated.hrs.ws.model;

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
 * The transparency metadata of a file
 * 
 * <p>Java class for FileTransparencyMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileTransparencyMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hasDocumentsWithClassifications" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hasDocumentsWithMarkings" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sensitivePersonalData" type="{http://ec.europa.eu/sg/hrs/types}FileSensitivePersonalData"/>
 *         &lt;element name="publicAccessStatus" type="{http://ec.europa.eu/sg/hrs/types}FilePublicAccessStatus" minOccurs="0"/>
 *         &lt;element name="exceptionForOpeningToThePublic" type="{http://ec.europa.eu/sg/hrs/types}FileExceptionForOpeningToThePublic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="commentsRelatedToOpeningToThePublic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileTransparencyMetadata", propOrder = {
    "hasDocumentsWithClassifications",
    "hasDocumentsWithMarkings",
    "sensitivePersonalData",
    "publicAccessStatus",
    "exceptionForOpeningToThePublic",
    "commentsRelatedToOpeningToThePublic"
})
public class FileTransparencyMetadata
    implements Equals, HashCode, ToString
{

    protected boolean hasDocumentsWithClassifications;
    protected boolean hasDocumentsWithMarkings;
    @XmlElement(required = true)
    protected FileSensitivePersonalData sensitivePersonalData;
    protected FilePublicAccessStatus publicAccessStatus;
    protected List<FileExceptionForOpeningToThePublic> exceptionForOpeningToThePublic;
    protected String commentsRelatedToOpeningToThePublic;

    /**
     * Gets the value of the hasDocumentsWithClassifications property.
     * 
     */
    public boolean isHasDocumentsWithClassifications() {
        return hasDocumentsWithClassifications;
    }

    /**
     * Sets the value of the hasDocumentsWithClassifications property.
     * 
     */
    public void setHasDocumentsWithClassifications(boolean value) {
        this.hasDocumentsWithClassifications = value;
    }

    /**
     * Gets the value of the hasDocumentsWithMarkings property.
     * 
     */
    public boolean isHasDocumentsWithMarkings() {
        return hasDocumentsWithMarkings;
    }

    /**
     * Sets the value of the hasDocumentsWithMarkings property.
     * 
     */
    public void setHasDocumentsWithMarkings(boolean value) {
        this.hasDocumentsWithMarkings = value;
    }

    /**
     * Gets the value of the sensitivePersonalData property.
     * 
     * @return
     *     possible object is
     *     {@link FileSensitivePersonalData }
     *     
     */
    public FileSensitivePersonalData getSensitivePersonalData() {
        return sensitivePersonalData;
    }

    /**
     * Sets the value of the sensitivePersonalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileSensitivePersonalData }
     *     
     */
    public void setSensitivePersonalData(FileSensitivePersonalData value) {
        this.sensitivePersonalData = value;
    }

    /**
     * Gets the value of the publicAccessStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FilePublicAccessStatus }
     *     
     */
    public FilePublicAccessStatus getPublicAccessStatus() {
        return publicAccessStatus;
    }

    /**
     * Sets the value of the publicAccessStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilePublicAccessStatus }
     *     
     */
    public void setPublicAccessStatus(FilePublicAccessStatus value) {
        this.publicAccessStatus = value;
    }

    /**
     * Gets the value of the exceptionForOpeningToThePublic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exceptionForOpeningToThePublic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExceptionForOpeningToThePublic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileExceptionForOpeningToThePublic }
     * 
     * 
     */
    public List<FileExceptionForOpeningToThePublic> getExceptionForOpeningToThePublic() {
        if (exceptionForOpeningToThePublic == null) {
            exceptionForOpeningToThePublic = new ArrayList<FileExceptionForOpeningToThePublic>();
        }
        return this.exceptionForOpeningToThePublic;
    }

    /**
     * Gets the value of the commentsRelatedToOpeningToThePublic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentsRelatedToOpeningToThePublic() {
        return commentsRelatedToOpeningToThePublic;
    }

    /**
     * Sets the value of the commentsRelatedToOpeningToThePublic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentsRelatedToOpeningToThePublic(String value) {
        this.commentsRelatedToOpeningToThePublic = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FileTransparencyMetadata)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FileTransparencyMetadata that = ((FileTransparencyMetadata) object);
        {
            boolean lhsHasDocumentsWithClassifications;
            lhsHasDocumentsWithClassifications = (true?this.isHasDocumentsWithClassifications():false);
            boolean rhsHasDocumentsWithClassifications;
            rhsHasDocumentsWithClassifications = (true?that.isHasDocumentsWithClassifications():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "hasDocumentsWithClassifications", lhsHasDocumentsWithClassifications), LocatorUtils.property(thatLocator, "hasDocumentsWithClassifications", rhsHasDocumentsWithClassifications), lhsHasDocumentsWithClassifications, rhsHasDocumentsWithClassifications)) {
                return false;
            }
        }
        {
            boolean lhsHasDocumentsWithMarkings;
            lhsHasDocumentsWithMarkings = (true?this.isHasDocumentsWithMarkings():false);
            boolean rhsHasDocumentsWithMarkings;
            rhsHasDocumentsWithMarkings = (true?that.isHasDocumentsWithMarkings():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "hasDocumentsWithMarkings", lhsHasDocumentsWithMarkings), LocatorUtils.property(thatLocator, "hasDocumentsWithMarkings", rhsHasDocumentsWithMarkings), lhsHasDocumentsWithMarkings, rhsHasDocumentsWithMarkings)) {
                return false;
            }
        }
        {
            FileSensitivePersonalData lhsSensitivePersonalData;
            lhsSensitivePersonalData = this.getSensitivePersonalData();
            FileSensitivePersonalData rhsSensitivePersonalData;
            rhsSensitivePersonalData = that.getSensitivePersonalData();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sensitivePersonalData", lhsSensitivePersonalData), LocatorUtils.property(thatLocator, "sensitivePersonalData", rhsSensitivePersonalData), lhsSensitivePersonalData, rhsSensitivePersonalData)) {
                return false;
            }
        }
        {
            FilePublicAccessStatus lhsPublicAccessStatus;
            lhsPublicAccessStatus = this.getPublicAccessStatus();
            FilePublicAccessStatus rhsPublicAccessStatus;
            rhsPublicAccessStatus = that.getPublicAccessStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "publicAccessStatus", lhsPublicAccessStatus), LocatorUtils.property(thatLocator, "publicAccessStatus", rhsPublicAccessStatus), lhsPublicAccessStatus, rhsPublicAccessStatus)) {
                return false;
            }
        }
        {
            List<FileExceptionForOpeningToThePublic> lhsExceptionForOpeningToThePublic;
            lhsExceptionForOpeningToThePublic = (((this.exceptionForOpeningToThePublic!= null)&&(!this.exceptionForOpeningToThePublic.isEmpty()))?this.getExceptionForOpeningToThePublic():null);
            List<FileExceptionForOpeningToThePublic> rhsExceptionForOpeningToThePublic;
            rhsExceptionForOpeningToThePublic = (((that.exceptionForOpeningToThePublic!= null)&&(!that.exceptionForOpeningToThePublic.isEmpty()))?that.getExceptionForOpeningToThePublic():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "exceptionForOpeningToThePublic", lhsExceptionForOpeningToThePublic), LocatorUtils.property(thatLocator, "exceptionForOpeningToThePublic", rhsExceptionForOpeningToThePublic), lhsExceptionForOpeningToThePublic, rhsExceptionForOpeningToThePublic)) {
                return false;
            }
        }
        {
            String lhsCommentsRelatedToOpeningToThePublic;
            lhsCommentsRelatedToOpeningToThePublic = this.getCommentsRelatedToOpeningToThePublic();
            String rhsCommentsRelatedToOpeningToThePublic;
            rhsCommentsRelatedToOpeningToThePublic = that.getCommentsRelatedToOpeningToThePublic();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "commentsRelatedToOpeningToThePublic", lhsCommentsRelatedToOpeningToThePublic), LocatorUtils.property(thatLocator, "commentsRelatedToOpeningToThePublic", rhsCommentsRelatedToOpeningToThePublic), lhsCommentsRelatedToOpeningToThePublic, rhsCommentsRelatedToOpeningToThePublic)) {
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
            boolean theHasDocumentsWithClassifications;
            theHasDocumentsWithClassifications = (true?this.isHasDocumentsWithClassifications():false);
            strategy.appendField(locator, this, "hasDocumentsWithClassifications", buffer, theHasDocumentsWithClassifications);
        }
        {
            boolean theHasDocumentsWithMarkings;
            theHasDocumentsWithMarkings = (true?this.isHasDocumentsWithMarkings():false);
            strategy.appendField(locator, this, "hasDocumentsWithMarkings", buffer, theHasDocumentsWithMarkings);
        }
        {
            FileSensitivePersonalData theSensitivePersonalData;
            theSensitivePersonalData = this.getSensitivePersonalData();
            strategy.appendField(locator, this, "sensitivePersonalData", buffer, theSensitivePersonalData);
        }
        {
            FilePublicAccessStatus thePublicAccessStatus;
            thePublicAccessStatus = this.getPublicAccessStatus();
            strategy.appendField(locator, this, "publicAccessStatus", buffer, thePublicAccessStatus);
        }
        {
            List<FileExceptionForOpeningToThePublic> theExceptionForOpeningToThePublic;
            theExceptionForOpeningToThePublic = (((this.exceptionForOpeningToThePublic!= null)&&(!this.exceptionForOpeningToThePublic.isEmpty()))?this.getExceptionForOpeningToThePublic():null);
            strategy.appendField(locator, this, "exceptionForOpeningToThePublic", buffer, theExceptionForOpeningToThePublic);
        }
        {
            String theCommentsRelatedToOpeningToThePublic;
            theCommentsRelatedToOpeningToThePublic = this.getCommentsRelatedToOpeningToThePublic();
            strategy.appendField(locator, this, "commentsRelatedToOpeningToThePublic", buffer, theCommentsRelatedToOpeningToThePublic);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theHasDocumentsWithClassifications;
            theHasDocumentsWithClassifications = (true?this.isHasDocumentsWithClassifications():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hasDocumentsWithClassifications", theHasDocumentsWithClassifications), currentHashCode, theHasDocumentsWithClassifications);
        }
        {
            boolean theHasDocumentsWithMarkings;
            theHasDocumentsWithMarkings = (true?this.isHasDocumentsWithMarkings():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hasDocumentsWithMarkings", theHasDocumentsWithMarkings), currentHashCode, theHasDocumentsWithMarkings);
        }
        {
            FileSensitivePersonalData theSensitivePersonalData;
            theSensitivePersonalData = this.getSensitivePersonalData();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sensitivePersonalData", theSensitivePersonalData), currentHashCode, theSensitivePersonalData);
        }
        {
            FilePublicAccessStatus thePublicAccessStatus;
            thePublicAccessStatus = this.getPublicAccessStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "publicAccessStatus", thePublicAccessStatus), currentHashCode, thePublicAccessStatus);
        }
        {
            List<FileExceptionForOpeningToThePublic> theExceptionForOpeningToThePublic;
            theExceptionForOpeningToThePublic = (((this.exceptionForOpeningToThePublic!= null)&&(!this.exceptionForOpeningToThePublic.isEmpty()))?this.getExceptionForOpeningToThePublic():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exceptionForOpeningToThePublic", theExceptionForOpeningToThePublic), currentHashCode, theExceptionForOpeningToThePublic);
        }
        {
            String theCommentsRelatedToOpeningToThePublic;
            theCommentsRelatedToOpeningToThePublic = this.getCommentsRelatedToOpeningToThePublic();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "commentsRelatedToOpeningToThePublic", theCommentsRelatedToOpeningToThePublic), currentHashCode, theCommentsRelatedToOpeningToThePublic);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
