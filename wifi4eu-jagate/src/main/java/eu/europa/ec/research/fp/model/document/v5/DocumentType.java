
package eu.europa.ec.research.fp.model.document.v5;

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
 * <p>Java class for DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://ec.europa.eu/research/fp/model/document-ref/V3}DocumentRefGroup"/>
 *         &lt;element name="Type" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="MetaData" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentMetaDataType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VersionList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Version" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentVersionType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
    "master",
    "masterID",
    "tag",
    "type",
    "metaData",
    "versionList"
})
public class DocumentType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Master", namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3", required = true)
    protected String master;
    @XmlElement(name = "MasterID", namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3", required = true)
    protected String masterID;
    @XmlElement(name = "Tag", namespace = "http://ec.europa.eu/research/fp/model/document-ref/V3")
    protected String tag;
    @XmlElement(name = "Type", required = true)
    protected CodeRefType type;
    @XmlElement(name = "MetaData")
    protected List<DocumentMetaDataType> metaData;
    @XmlElement(name = "VersionList")
    protected DocumentType.VersionList versionList;

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setType(CodeRefType value) {
        this.type = value;
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
     * Gets the value of the versionList property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType.VersionList }
     *     
     */
    public DocumentType.VersionList getVersionList() {
        return versionList;
    }

    /**
     * Sets the value of the versionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType.VersionList }
     *     
     */
    public void setVersionList(DocumentType.VersionList value) {
        this.versionList = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentType that = ((DocumentType) object);
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
            CodeRefType lhsType;
            lhsType = this.getType();
            CodeRefType rhsType;
            rhsType = that.getType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType)) {
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
            DocumentType.VersionList lhsVersionList;
            lhsVersionList = this.getVersionList();
            DocumentType.VersionList rhsVersionList;
            rhsVersionList = that.getVersionList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "versionList", lhsVersionList), LocatorUtils.property(thatLocator, "versionList", rhsVersionList), lhsVersionList, rhsVersionList)) {
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
            CodeRefType theType;
            theType = this.getType();
            strategy.appendField(locator, this, "type", buffer, theType);
        }
        {
            List<DocumentMetaDataType> theMetaData;
            theMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            strategy.appendField(locator, this, "metaData", buffer, theMetaData);
        }
        {
            DocumentType.VersionList theVersionList;
            theVersionList = this.getVersionList();
            strategy.appendField(locator, this, "versionList", buffer, theVersionList);
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
            CodeRefType theType;
            theType = this.getType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType);
        }
        {
            List<DocumentMetaDataType> theMetaData;
            theMetaData = (((this.metaData!= null)&&(!this.metaData.isEmpty()))?this.getMetaData():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "metaData", theMetaData), currentHashCode, theMetaData);
        }
        {
            DocumentType.VersionList theVersionList;
            theVersionList = this.getVersionList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "versionList", theVersionList), currentHashCode, theVersionList);
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
     *         &lt;element name="Version" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentVersionType" maxOccurs="unbounded"/>
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
        "version"
    })
    public static class VersionList
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "Version", required = true)
        protected List<DocumentVersionType> version;

        /**
         * Gets the value of the version property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the version property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVersion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocumentVersionType }
         * 
         * 
         */
        public List<DocumentVersionType> getVersion() {
            if (version == null) {
                version = new ArrayList<DocumentVersionType>();
            }
            return this.version;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof DocumentType.VersionList)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final DocumentType.VersionList that = ((DocumentType.VersionList) object);
            {
                List<DocumentVersionType> lhsVersion;
                lhsVersion = (((this.version!= null)&&(!this.version.isEmpty()))?this.getVersion():null);
                List<DocumentVersionType> rhsVersion;
                rhsVersion = (((that.version!= null)&&(!that.version.isEmpty()))?that.getVersion():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "version", lhsVersion), LocatorUtils.property(thatLocator, "version", rhsVersion), lhsVersion, rhsVersion)) {
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
                List<DocumentVersionType> theVersion;
                theVersion = (((this.version!= null)&&(!this.version.isEmpty()))?this.getVersion():null);
                strategy.appendField(locator, this, "version", buffer, theVersion);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<DocumentVersionType> theVersion;
                theVersion = (((this.version!= null)&&(!this.version.isEmpty()))?this.getVersion():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "version", theVersion), currentHashCode, theVersion);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
