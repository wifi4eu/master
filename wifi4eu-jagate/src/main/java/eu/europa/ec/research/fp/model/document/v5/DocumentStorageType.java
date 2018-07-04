
package eu.europa.ec.research.fp.model.document.v5;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for DocumentStorageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentStorageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Repository" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RepositoryId" type="{http://ec.europa.eu/research/fp/model/document-ref/V3}DocumentRepositoryIdType" minOccurs="0"/>
 *         &lt;element name="Attachment" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentAttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentStorageType", propOrder = {
    "repository",
    "repositoryId",
    "attachment",
    "creationTime"
})
public class DocumentStorageType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Repository", required = true)
    protected String repository;
    @XmlElement(name = "RepositoryId")
    protected String repositoryId;
    @XmlElement(name = "Attachment")
    protected List<DocumentAttachmentType> attachment;
    @XmlElement(name = "CreationTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTime;

    /**
     * Gets the value of the repository property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepository() {
        return repository;
    }

    /**
     * Sets the value of the repository property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepository(String value) {
        this.repository = value;
    }

    /**
     * Gets the value of the repositoryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepositoryId() {
        return repositoryId;
    }

    /**
     * Sets the value of the repositoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepositoryId(String value) {
        this.repositoryId = value;
    }

    /**
     * Gets the value of the attachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentAttachmentType }
     * 
     * 
     */
    public List<DocumentAttachmentType> getAttachment() {
        if (attachment == null) {
            attachment = new ArrayList<DocumentAttachmentType>();
        }
        return this.attachment;
    }

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationTime(XMLGregorianCalendar value) {
        this.creationTime = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentStorageType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentStorageType that = ((DocumentStorageType) object);
        {
            String lhsRepository;
            lhsRepository = this.getRepository();
            String rhsRepository;
            rhsRepository = that.getRepository();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "repository", lhsRepository), LocatorUtils.property(thatLocator, "repository", rhsRepository), lhsRepository, rhsRepository)) {
                return false;
            }
        }
        {
            String lhsRepositoryId;
            lhsRepositoryId = this.getRepositoryId();
            String rhsRepositoryId;
            rhsRepositoryId = that.getRepositoryId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "repositoryId", lhsRepositoryId), LocatorUtils.property(thatLocator, "repositoryId", rhsRepositoryId), lhsRepositoryId, rhsRepositoryId)) {
                return false;
            }
        }
        {
            List<DocumentAttachmentType> lhsAttachment;
            lhsAttachment = (((this.attachment!= null)&&(!this.attachment.isEmpty()))?this.getAttachment():null);
            List<DocumentAttachmentType> rhsAttachment;
            rhsAttachment = (((that.attachment!= null)&&(!that.attachment.isEmpty()))?that.getAttachment():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "attachment", lhsAttachment), LocatorUtils.property(thatLocator, "attachment", rhsAttachment), lhsAttachment, rhsAttachment)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsCreationTime;
            lhsCreationTime = this.getCreationTime();
            XMLGregorianCalendar rhsCreationTime;
            rhsCreationTime = that.getCreationTime();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creationTime", lhsCreationTime), LocatorUtils.property(thatLocator, "creationTime", rhsCreationTime), lhsCreationTime, rhsCreationTime)) {
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
            String theRepository;
            theRepository = this.getRepository();
            strategy.appendField(locator, this, "repository", buffer, theRepository);
        }
        {
            String theRepositoryId;
            theRepositoryId = this.getRepositoryId();
            strategy.appendField(locator, this, "repositoryId", buffer, theRepositoryId);
        }
        {
            List<DocumentAttachmentType> theAttachment;
            theAttachment = (((this.attachment!= null)&&(!this.attachment.isEmpty()))?this.getAttachment():null);
            strategy.appendField(locator, this, "attachment", buffer, theAttachment);
        }
        {
            XMLGregorianCalendar theCreationTime;
            theCreationTime = this.getCreationTime();
            strategy.appendField(locator, this, "creationTime", buffer, theCreationTime);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theRepository;
            theRepository = this.getRepository();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "repository", theRepository), currentHashCode, theRepository);
        }
        {
            String theRepositoryId;
            theRepositoryId = this.getRepositoryId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "repositoryId", theRepositoryId), currentHashCode, theRepositoryId);
        }
        {
            List<DocumentAttachmentType> theAttachment;
            theAttachment = (((this.attachment!= null)&&(!this.attachment.isEmpty()))?this.getAttachment():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "attachment", theAttachment), currentHashCode, theAttachment);
        }
        {
            XMLGregorianCalendar theCreationTime;
            theCreationTime = this.getCreationTime();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creationTime", theCreationTime), currentHashCode, theCreationTime);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
