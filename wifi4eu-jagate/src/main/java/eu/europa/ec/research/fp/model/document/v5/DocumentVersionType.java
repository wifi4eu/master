
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for DocumentVersionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentVersionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;group ref="{http://ec.europa.eu/research/fp/model/document/V5}DocumentInfoGroup"/>
 *         &lt;element name="MetaData" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentMetaDataType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Classification" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentClassificationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StorageList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Storage" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentStorageType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sendersRecipients" type="{http://ec.europa.eu/research/fp/model/document/V5}SendersRecipients"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentVersionType", propOrder = {
    "versionNumber",
    "name",
    "description",
    "author",
    "securityClass",
    "metaData",
    "classification",
    "storageList",
    "sendersRecipients"
})
public class DocumentVersionType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "VersionNumber", required = true)
    protected String versionNumber;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Author")
    protected String author;
    @XmlElement(name = "SecurityClass")
    protected String securityClass;
    @XmlElement(name = "MetaData")
    protected List<DocumentMetaDataType> metaData;
    @XmlElement(name = "Classification")
    protected List<DocumentClassificationType> classification;
    @XmlElement(name = "StorageList", required = true)
    protected DocumentVersionType.StorageList storageList;
    @XmlElement(required = true)
    protected SendersRecipients sendersRecipients;

    /**
     * Gets the value of the versionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionNumber(String value) {
        this.versionNumber = value;
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
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the securityClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityClass() {
        return securityClass;
    }

    /**
     * Sets the value of the securityClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityClass(String value) {
        this.securityClass = value;
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
     * Gets the value of the classification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentClassificationType }
     * 
     * 
     */
    public List<DocumentClassificationType> getClassification() {
        if (classification == null) {
            classification = new ArrayList<DocumentClassificationType>();
        }
        return this.classification;
    }

    /**
     * Gets the value of the storageList property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentVersionType.StorageList }
     *     
     */
    public DocumentVersionType.StorageList getStorageList() {
        return storageList;
    }

    /**
     * Sets the value of the storageList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentVersionType.StorageList }
     *     
     */
    public void setStorageList(DocumentVersionType.StorageList value) {
        this.storageList = value;
    }

    /**
     * Gets the value of the sendersRecipients property.
     * 
     * @return
     *     possible object is
     *     {@link SendersRecipients }
     *     
     */
    public SendersRecipients getSendersRecipients() {
        return sendersRecipients;
    }

    /**
     * Sets the value of the sendersRecipients property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendersRecipients }
     *     
     */
    public void setSendersRecipients(SendersRecipients value) {
        this.sendersRecipients = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentVersionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentVersionType that = ((DocumentVersionType) object);
        {
            String lhsVersionNumber;
            lhsVersionNumber = this.getVersionNumber();
            String rhsVersionNumber;
            rhsVersionNumber = that.getVersionNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "versionNumber", lhsVersionNumber), LocatorUtils.property(thatLocator, "versionNumber", rhsVersionNumber), lhsVersionNumber, rhsVersionNumber)) {
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
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            String lhsAuthor;
            lhsAuthor = this.getAuthor();
            String rhsAuthor;
            rhsAuthor = that.getAuthor();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "author", lhsAuthor), LocatorUtils.property(thatLocator, "author", rhsAuthor), lhsAuthor, rhsAuthor)) {
                return false;
            }
        }
        {
            String lhsSecurityClass;
            lhsSecurityClass = this.getSecurityClass();
            String rhsSecurityClass;
            rhsSecurityClass = that.getSecurityClass();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityClass", lhsSecurityClass), LocatorUtils.property(thatLocator, "securityClass", rhsSecurityClass), lhsSecurityClass, rhsSecurityClass)) {
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
            List<DocumentClassificationType> lhsClassification;
            lhsClassification = (((this.classification!= null)&&(!this.classification.isEmpty()))?this.getClassification():null);
            List<DocumentClassificationType> rhsClassification;
            rhsClassification = (((that.classification!= null)&&(!that.classification.isEmpty()))?that.getClassification():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "classification", lhsClassification), LocatorUtils.property(thatLocator, "classification", rhsClassification), lhsClassification, rhsClassification)) {
                return false;
            }
        }
        {
            DocumentVersionType.StorageList lhsStorageList;
            lhsStorageList = this.getStorageList();
            DocumentVersionType.StorageList rhsStorageList;
            rhsStorageList = that.getStorageList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "storageList", lhsStorageList), LocatorUtils.property(thatLocator, "storageList", rhsStorageList), lhsStorageList, rhsStorageList)) {
                return false;
            }
        }
        {
            SendersRecipients lhsSendersRecipients;
            lhsSendersRecipients = this.getSendersRecipients();
            SendersRecipients rhsSendersRecipients;
            rhsSendersRecipients = that.getSendersRecipients();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sendersRecipients", lhsSendersRecipients), LocatorUtils.property(thatLocator, "sendersRecipients", rhsSendersRecipients), lhsSendersRecipients, rhsSendersRecipients)) {
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
            String theVersionNumber;
            theVersionNumber = this.getVersionNumber();
            strategy.appendField(locator, this, "versionNumber", buffer, theVersionNumber);
        }
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            String theAuthor;
            theAuthor = this.getAuthor();
            strategy.appendField(locator, this, "author", buffer, theAuthor);
        }
        {
            String theSecurityClass;
            theSecurityClass = this.getSecurityClass();
            strategy.appendField(locator, this, "securityClass", buffer, theSecurityClass);
        }
        {
            List<DocumentMetaDataType> theMetaData;
            theMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            strategy.appendField(locator, this, "metaData", buffer, theMetaData);
        }
        {
            List<DocumentClassificationType> theClassification;
            theClassification = (((this.classification!= null)&&(!this.classification.isEmpty()))?this.getClassification():null);
            strategy.appendField(locator, this, "classification", buffer, theClassification);
        }
        {
            DocumentVersionType.StorageList theStorageList;
            theStorageList = this.getStorageList();
            strategy.appendField(locator, this, "storageList", buffer, theStorageList);
        }
        {
            SendersRecipients theSendersRecipients;
            theSendersRecipients = this.getSendersRecipients();
            strategy.appendField(locator, this, "sendersRecipients", buffer, theSendersRecipients);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theVersionNumber;
            theVersionNumber = this.getVersionNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "versionNumber", theVersionNumber), currentHashCode, theVersionNumber);
        }
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            String theAuthor;
            theAuthor = this.getAuthor();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "author", theAuthor), currentHashCode, theAuthor);
        }
        {
            String theSecurityClass;
            theSecurityClass = this.getSecurityClass();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityClass", theSecurityClass), currentHashCode, theSecurityClass);
        }
        {
            List<DocumentMetaDataType> theMetaData;
            theMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "metaData", theMetaData), currentHashCode, theMetaData);
        }
        {
            List<DocumentClassificationType> theClassification;
            theClassification = (((this.classification!= null)&&(!this.classification.isEmpty()))?this.getClassification():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "classification", theClassification), currentHashCode, theClassification);
        }
        {
            DocumentVersionType.StorageList theStorageList;
            theStorageList = this.getStorageList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "storageList", theStorageList), currentHashCode, theStorageList);
        }
        {
            SendersRecipients theSendersRecipients;
            theSendersRecipients = this.getSendersRecipients();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sendersRecipients", theSendersRecipients), currentHashCode, theSendersRecipients);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }


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
     *         &lt;element name="Storage" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentStorageType" maxOccurs="unbounded"/>
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
        "storage"
    })
    public static class StorageList
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "Storage", required = true)
        protected List<DocumentStorageType> storage;

        /**
         * Gets the value of the storage property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the storage property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStorage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentStorageType }
         * 
         * 
         */
        public List<DocumentStorageType> getStorage() {
            if (storage == null) {
                storage = new ArrayList<DocumentStorageType>();
            }
            return this.storage;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof DocumentVersionType.StorageList)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final DocumentVersionType.StorageList that = ((DocumentVersionType.StorageList) object);
            {
                List<DocumentStorageType> lhsStorage;
                lhsStorage = (((this.storage!= null)&&(!this.storage.isEmpty()))?this.getStorage():null);
                List<DocumentStorageType> rhsStorage;
                rhsStorage = (((that.storage!= null)&&(!that.storage.isEmpty()))?that.getStorage():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "storage", lhsStorage), LocatorUtils.property(thatLocator, "storage", rhsStorage), lhsStorage, rhsStorage)) {
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
                List<DocumentStorageType> theStorage;
                theStorage = (((this.storage!= null)&&(!this.storage.isEmpty()))?this.getStorage():null);
                strategy.appendField(locator, this, "storage", buffer, theStorage);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<DocumentStorageType> theStorage;
                theStorage = (((this.storage!= null)&&(!this.storage.isEmpty()))?this.getStorage():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "storage", theStorage), currentHashCode, theStorage);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
