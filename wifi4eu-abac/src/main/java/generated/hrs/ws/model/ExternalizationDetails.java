
package generated.hrs.ws.model;

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
 * <p>Java class for ExternalizationDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalizationDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://ec.europa.eu/sg/hrs/types}ExternalizationStatus"/>
 *         &lt;element name="externalizationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="revocationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="externalizedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="revokedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ersPartitionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="partial" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="externalizedItems" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="externalizedSpecificMetadataItems" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="10"/>
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
@XmlType(name = "ExternalizationDetails", propOrder = {
    "status",
    "externalizationDate",
    "revocationDate",
    "externalizedBy",
    "revokedBy",
    "ersPartitionId",
    "partial",
    "externalizedItems",
    "externalizedSpecificMetadataItems"
})
public class ExternalizationDetails
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected ExternalizationStatus status;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar externalizationDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar revocationDate;
    protected String externalizedBy;
    protected String revokedBy;
    protected Integer ersPartitionId;
    protected Boolean partial;
    protected ExternalizationDetails.ExternalizedItems externalizedItems;
    protected ExternalizationDetails.ExternalizedSpecificMetadataItems externalizedSpecificMetadataItems;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalizationStatus }
     *     
     */
    public ExternalizationStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalizationStatus }
     *     
     */
    public void setStatus(ExternalizationStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the externalizationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExternalizationDate() {
        return externalizationDate;
    }

    /**
     * Sets the value of the externalizationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExternalizationDate(XMLGregorianCalendar value) {
        this.externalizationDate = value;
    }

    /**
     * Gets the value of the revocationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRevocationDate() {
        return revocationDate;
    }

    /**
     * Sets the value of the revocationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRevocationDate(XMLGregorianCalendar value) {
        this.revocationDate = value;
    }

    /**
     * Gets the value of the externalizedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalizedBy() {
        return externalizedBy;
    }

    /**
     * Sets the value of the externalizedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalizedBy(String value) {
        this.externalizedBy = value;
    }

    /**
     * Gets the value of the revokedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevokedBy() {
        return revokedBy;
    }

    /**
     * Sets the value of the revokedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevokedBy(String value) {
        this.revokedBy = value;
    }

    /**
     * Gets the value of the ersPartitionId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErsPartitionId() {
        return ersPartitionId;
    }

    /**
     * Sets the value of the ersPartitionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErsPartitionId(Integer value) {
        this.ersPartitionId = value;
    }

    /**
     * Gets the value of the partial property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPartial() {
        return partial;
    }

    /**
     * Sets the value of the partial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPartial(Boolean value) {
        this.partial = value;
    }

    /**
     * Gets the value of the externalizedItems property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalizationDetails.ExternalizedItems }
     *     
     */
    public ExternalizationDetails.ExternalizedItems getExternalizedItems() {
        return externalizedItems;
    }

    /**
     * Sets the value of the externalizedItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalizationDetails.ExternalizedItems }
     *     
     */
    public void setExternalizedItems(ExternalizationDetails.ExternalizedItems value) {
        this.externalizedItems = value;
    }

    /**
     * Gets the value of the externalizedSpecificMetadataItems property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalizationDetails.ExternalizedSpecificMetadataItems }
     *     
     */
    public ExternalizationDetails.ExternalizedSpecificMetadataItems getExternalizedSpecificMetadataItems() {
        return externalizedSpecificMetadataItems;
    }

    /**
     * Sets the value of the externalizedSpecificMetadataItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalizationDetails.ExternalizedSpecificMetadataItems }
     *     
     */
    public void setExternalizedSpecificMetadataItems(ExternalizationDetails.ExternalizedSpecificMetadataItems value) {
        this.externalizedSpecificMetadataItems = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExternalizationDetails)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExternalizationDetails that = ((ExternalizationDetails) object);
        {
            ExternalizationStatus lhsStatus;
            lhsStatus = this.getStatus();
            ExternalizationStatus rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsExternalizationDate;
            lhsExternalizationDate = this.getExternalizationDate();
            XMLGregorianCalendar rhsExternalizationDate;
            rhsExternalizationDate = that.getExternalizationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalizationDate", lhsExternalizationDate), LocatorUtils.property(thatLocator, "externalizationDate", rhsExternalizationDate), lhsExternalizationDate, rhsExternalizationDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsRevocationDate;
            lhsRevocationDate = this.getRevocationDate();
            XMLGregorianCalendar rhsRevocationDate;
            rhsRevocationDate = that.getRevocationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "revocationDate", lhsRevocationDate), LocatorUtils.property(thatLocator, "revocationDate", rhsRevocationDate), lhsRevocationDate, rhsRevocationDate)) {
                return false;
            }
        }
        {
            String lhsExternalizedBy;
            lhsExternalizedBy = this.getExternalizedBy();
            String rhsExternalizedBy;
            rhsExternalizedBy = that.getExternalizedBy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalizedBy", lhsExternalizedBy), LocatorUtils.property(thatLocator, "externalizedBy", rhsExternalizedBy), lhsExternalizedBy, rhsExternalizedBy)) {
                return false;
            }
        }
        {
            String lhsRevokedBy;
            lhsRevokedBy = this.getRevokedBy();
            String rhsRevokedBy;
            rhsRevokedBy = that.getRevokedBy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "revokedBy", lhsRevokedBy), LocatorUtils.property(thatLocator, "revokedBy", rhsRevokedBy), lhsRevokedBy, rhsRevokedBy)) {
                return false;
            }
        }
        {
            Integer lhsErsPartitionId;
            lhsErsPartitionId = this.getErsPartitionId();
            Integer rhsErsPartitionId;
            rhsErsPartitionId = that.getErsPartitionId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ersPartitionId", lhsErsPartitionId), LocatorUtils.property(thatLocator, "ersPartitionId", rhsErsPartitionId), lhsErsPartitionId, rhsErsPartitionId)) {
                return false;
            }
        }
        {
            Boolean lhsPartial;
            lhsPartial = this.isPartial();
            Boolean rhsPartial;
            rhsPartial = that.isPartial();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "partial", lhsPartial), LocatorUtils.property(thatLocator, "partial", rhsPartial), lhsPartial, rhsPartial)) {
                return false;
            }
        }
        {
            ExternalizationDetails.ExternalizedItems lhsExternalizedItems;
            lhsExternalizedItems = this.getExternalizedItems();
            ExternalizationDetails.ExternalizedItems rhsExternalizedItems;
            rhsExternalizedItems = that.getExternalizedItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalizedItems", lhsExternalizedItems), LocatorUtils.property(thatLocator, "externalizedItems", rhsExternalizedItems), lhsExternalizedItems, rhsExternalizedItems)) {
                return false;
            }
        }
        {
            ExternalizationDetails.ExternalizedSpecificMetadataItems lhsExternalizedSpecificMetadataItems;
            lhsExternalizedSpecificMetadataItems = this.getExternalizedSpecificMetadataItems();
            ExternalizationDetails.ExternalizedSpecificMetadataItems rhsExternalizedSpecificMetadataItems;
            rhsExternalizedSpecificMetadataItems = that.getExternalizedSpecificMetadataItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalizedSpecificMetadataItems", lhsExternalizedSpecificMetadataItems), LocatorUtils.property(thatLocator, "externalizedSpecificMetadataItems", rhsExternalizedSpecificMetadataItems), lhsExternalizedSpecificMetadataItems, rhsExternalizedSpecificMetadataItems)) {
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
            ExternalizationStatus theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            XMLGregorianCalendar theExternalizationDate;
            theExternalizationDate = this.getExternalizationDate();
            strategy.appendField(locator, this, "externalizationDate", buffer, theExternalizationDate);
        }
        {
            XMLGregorianCalendar theRevocationDate;
            theRevocationDate = this.getRevocationDate();
            strategy.appendField(locator, this, "revocationDate", buffer, theRevocationDate);
        }
        {
            String theExternalizedBy;
            theExternalizedBy = this.getExternalizedBy();
            strategy.appendField(locator, this, "externalizedBy", buffer, theExternalizedBy);
        }
        {
            String theRevokedBy;
            theRevokedBy = this.getRevokedBy();
            strategy.appendField(locator, this, "revokedBy", buffer, theRevokedBy);
        }
        {
            Integer theErsPartitionId;
            theErsPartitionId = this.getErsPartitionId();
            strategy.appendField(locator, this, "ersPartitionId", buffer, theErsPartitionId);
        }
        {
            Boolean thePartial;
            thePartial = this.isPartial();
            strategy.appendField(locator, this, "partial", buffer, thePartial);
        }
        {
            ExternalizationDetails.ExternalizedItems theExternalizedItems;
            theExternalizedItems = this.getExternalizedItems();
            strategy.appendField(locator, this, "externalizedItems", buffer, theExternalizedItems);
        }
        {
            ExternalizationDetails.ExternalizedSpecificMetadataItems theExternalizedSpecificMetadataItems;
            theExternalizedSpecificMetadataItems = this.getExternalizedSpecificMetadataItems();
            strategy.appendField(locator, this, "externalizedSpecificMetadataItems", buffer, theExternalizedSpecificMetadataItems);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            ExternalizationStatus theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            XMLGregorianCalendar theExternalizationDate;
            theExternalizationDate = this.getExternalizationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalizationDate", theExternalizationDate), currentHashCode, theExternalizationDate);
        }
        {
            XMLGregorianCalendar theRevocationDate;
            theRevocationDate = this.getRevocationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "revocationDate", theRevocationDate), currentHashCode, theRevocationDate);
        }
        {
            String theExternalizedBy;
            theExternalizedBy = this.getExternalizedBy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalizedBy", theExternalizedBy), currentHashCode, theExternalizedBy);
        }
        {
            String theRevokedBy;
            theRevokedBy = this.getRevokedBy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "revokedBy", theRevokedBy), currentHashCode, theRevokedBy);
        }
        {
            Integer theErsPartitionId;
            theErsPartitionId = this.getErsPartitionId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ersPartitionId", theErsPartitionId), currentHashCode, theErsPartitionId);
        }
        {
            Boolean thePartial;
            thePartial = this.isPartial();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "partial", thePartial), currentHashCode, thePartial);
        }
        {
            ExternalizationDetails.ExternalizedItems theExternalizedItems;
            theExternalizedItems = this.getExternalizedItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalizedItems", theExternalizedItems), currentHashCode, theExternalizedItems);
        }
        {
            ExternalizationDetails.ExternalizedSpecificMetadataItems theExternalizedSpecificMetadataItems;
            theExternalizedSpecificMetadataItems = this.getExternalizedSpecificMetadataItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalizedSpecificMetadataItems", theExternalizedSpecificMetadataItems), currentHashCode, theExternalizedSpecificMetadataItems);
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
     *         &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="unbounded" minOccurs="0"/>
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
        "itemId"
    })
    public static class ExternalizedItems
        implements Equals, HashCode, ToString
    {

        protected List<String> itemId;

        /**
         * Gets the value of the itemId property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the itemId property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItemId().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getItemId() {
            if (itemId == null) {
                itemId = new ArrayList<String>();
            }
            return this.itemId;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof ExternalizationDetails.ExternalizedItems)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final ExternalizationDetails.ExternalizedItems that = ((ExternalizationDetails.ExternalizedItems) object);
            {
                List<String> lhsItemId;
                lhsItemId = (((this.itemId!= null)&&(!this.itemId.isEmpty()))?this.getItemId():null);
                List<String> rhsItemId;
                rhsItemId = (((that.itemId!= null)&&(!that.itemId.isEmpty()))?that.getItemId():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "itemId", lhsItemId), LocatorUtils.property(thatLocator, "itemId", rhsItemId), lhsItemId, rhsItemId)) {
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
                List<String> theItemId;
                theItemId = (((this.itemId!= null)&&(!this.itemId.isEmpty()))?this.getItemId():null);
                strategy.appendField(locator, this, "itemId", buffer, theItemId);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theItemId;
                theItemId = (((this.itemId!= null)&&(!this.itemId.isEmpty()))?this.getItemId():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemId", theItemId), currentHashCode, theItemId);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

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
     *         &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId" maxOccurs="10"/>
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
        "itemId"
    })
    public static class ExternalizedSpecificMetadataItems
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected List<String> itemId;

        /**
         * Gets the value of the itemId property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the itemId property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItemId().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getItemId() {
            if (itemId == null) {
                itemId = new ArrayList<String>();
            }
            return this.itemId;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof ExternalizationDetails.ExternalizedSpecificMetadataItems)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final ExternalizationDetails.ExternalizedSpecificMetadataItems that = ((ExternalizationDetails.ExternalizedSpecificMetadataItems) object);
            {
                List<String> lhsItemId;
                lhsItemId = (((this.itemId!= null)&&(!this.itemId.isEmpty()))?this.getItemId():null);
                List<String> rhsItemId;
                rhsItemId = (((that.itemId!= null)&&(!that.itemId.isEmpty()))?that.getItemId():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "itemId", lhsItemId), LocatorUtils.property(thatLocator, "itemId", rhsItemId), lhsItemId, rhsItemId)) {
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
                List<String> theItemId;
                theItemId = (((this.itemId!= null)&&(!this.itemId.isEmpty()))?this.getItemId():null);
                strategy.appendField(locator, this, "itemId", buffer, theItemId);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<String> theItemId;
                theItemId = (((this.itemId!= null)&&(!this.itemId.isEmpty()))?this.getItemId():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemId", theItemId), currentHashCode, theItemId);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
