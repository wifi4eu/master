
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
 * Specifies what has to be externalized.
 * 
 * <p>Java class for ExternalizationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalizationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="ersPartitionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="externalizationTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partial" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="eraseRenditionMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *                   &lt;element name="eraseRenditionMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="specificMetadataItems" minOccurs="0">
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
@XmlType(name = "ExternalizationRequest", propOrder = {
    "documentId",
    "ersPartitionId",
    "externalizationTitle",
    "partial",
    "eraseRenditionMetadata",
    "item",
    "specificMetadataItems"
})
public class ExternalizationRequest
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String documentId;
    protected int ersPartitionId;
    protected String externalizationTitle;
    protected boolean partial;
    protected Boolean eraseRenditionMetadata;
    protected List<ExternalizationRequest.Item> item;
    protected ExternalizationRequest.SpecificMetadataItems specificMetadataItems;

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
     * Gets the value of the ersPartitionId property.
     * 
     */
    public int getErsPartitionId() {
        return ersPartitionId;
    }

    /**
     * Sets the value of the ersPartitionId property.
     * 
     */
    public void setErsPartitionId(int value) {
        this.ersPartitionId = value;
    }

    /**
     * Gets the value of the externalizationTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalizationTitle() {
        return externalizationTitle;
    }

    /**
     * Sets the value of the externalizationTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalizationTitle(String value) {
        this.externalizationTitle = value;
    }

    /**
     * Gets the value of the partial property.
     * 
     */
    public boolean isPartial() {
        return partial;
    }

    /**
     * Sets the value of the partial property.
     * 
     */
    public void setPartial(boolean value) {
        this.partial = value;
    }

    /**
     * Gets the value of the eraseRenditionMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEraseRenditionMetadata() {
        return eraseRenditionMetadata;
    }

    /**
     * Sets the value of the eraseRenditionMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEraseRenditionMetadata(Boolean value) {
        this.eraseRenditionMetadata = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalizationRequest.Item }
     * 
     * 
     */
    public List<ExternalizationRequest.Item> getItem() {
        if (item == null) {
            item = new ArrayList<ExternalizationRequest.Item>();
        }
        return this.item;
    }

    /**
     * Gets the value of the specificMetadataItems property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalizationRequest.SpecificMetadataItems }
     *     
     */
    public ExternalizationRequest.SpecificMetadataItems getSpecificMetadataItems() {
        return specificMetadataItems;
    }

    /**
     * Sets the value of the specificMetadataItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalizationRequest.SpecificMetadataItems }
     *     
     */
    public void setSpecificMetadataItems(ExternalizationRequest.SpecificMetadataItems value) {
        this.specificMetadataItems = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ExternalizationRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ExternalizationRequest that = ((ExternalizationRequest) object);
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
            int lhsErsPartitionId;
            lhsErsPartitionId = (true?this.getErsPartitionId(): 0);
            int rhsErsPartitionId;
            rhsErsPartitionId = (true?that.getErsPartitionId(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ersPartitionId", lhsErsPartitionId), LocatorUtils.property(thatLocator, "ersPartitionId", rhsErsPartitionId), lhsErsPartitionId, rhsErsPartitionId)) {
                return false;
            }
        }
        {
            String lhsExternalizationTitle;
            lhsExternalizationTitle = this.getExternalizationTitle();
            String rhsExternalizationTitle;
            rhsExternalizationTitle = that.getExternalizationTitle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "externalizationTitle", lhsExternalizationTitle), LocatorUtils.property(thatLocator, "externalizationTitle", rhsExternalizationTitle), lhsExternalizationTitle, rhsExternalizationTitle)) {
                return false;
            }
        }
        {
            boolean lhsPartial;
            lhsPartial = (true?this.isPartial():false);
            boolean rhsPartial;
            rhsPartial = (true?that.isPartial():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "partial", lhsPartial), LocatorUtils.property(thatLocator, "partial", rhsPartial), lhsPartial, rhsPartial)) {
                return false;
            }
        }
        {
            Boolean lhsEraseRenditionMetadata;
            lhsEraseRenditionMetadata = this.isEraseRenditionMetadata();
            Boolean rhsEraseRenditionMetadata;
            rhsEraseRenditionMetadata = that.isEraseRenditionMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "eraseRenditionMetadata", lhsEraseRenditionMetadata), LocatorUtils.property(thatLocator, "eraseRenditionMetadata", rhsEraseRenditionMetadata), lhsEraseRenditionMetadata, rhsEraseRenditionMetadata)) {
                return false;
            }
        }
        {
            List<ExternalizationRequest.Item> lhsItem;
            lhsItem = (((this.item!= null)&&(!this.item.isEmpty()))?this.getItem():null);
            List<ExternalizationRequest.Item> rhsItem;
            rhsItem = (((that.item!= null)&&(!that.item.isEmpty()))?that.getItem():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "item", lhsItem), LocatorUtils.property(thatLocator, "item", rhsItem), lhsItem, rhsItem)) {
                return false;
            }
        }
        {
            ExternalizationRequest.SpecificMetadataItems lhsSpecificMetadataItems;
            lhsSpecificMetadataItems = this.getSpecificMetadataItems();
            ExternalizationRequest.SpecificMetadataItems rhsSpecificMetadataItems;
            rhsSpecificMetadataItems = that.getSpecificMetadataItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "specificMetadataItems", lhsSpecificMetadataItems), LocatorUtils.property(thatLocator, "specificMetadataItems", rhsSpecificMetadataItems), lhsSpecificMetadataItems, rhsSpecificMetadataItems)) {
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
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            strategy.appendField(locator, this, "documentId", buffer, theDocumentId);
        }
        {
            int theErsPartitionId;
            theErsPartitionId = (true?this.getErsPartitionId(): 0);
            strategy.appendField(locator, this, "ersPartitionId", buffer, theErsPartitionId);
        }
        {
            String theExternalizationTitle;
            theExternalizationTitle = this.getExternalizationTitle();
            strategy.appendField(locator, this, "externalizationTitle", buffer, theExternalizationTitle);
        }
        {
            boolean thePartial;
            thePartial = (true?this.isPartial():false);
            strategy.appendField(locator, this, "partial", buffer, thePartial);
        }
        {
            Boolean theEraseRenditionMetadata;
            theEraseRenditionMetadata = this.isEraseRenditionMetadata();
            strategy.appendField(locator, this, "eraseRenditionMetadata", buffer, theEraseRenditionMetadata);
        }
        {
            List<ExternalizationRequest.Item> theItem;
            theItem = (((this.item!= null)&&(!this.item.isEmpty()))?this.getItem():null);
            strategy.appendField(locator, this, "item", buffer, theItem);
        }
        {
            ExternalizationRequest.SpecificMetadataItems theSpecificMetadataItems;
            theSpecificMetadataItems = this.getSpecificMetadataItems();
            strategy.appendField(locator, this, "specificMetadataItems", buffer, theSpecificMetadataItems);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theDocumentId;
            theDocumentId = this.getDocumentId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "documentId", theDocumentId), currentHashCode, theDocumentId);
        }
        {
            int theErsPartitionId;
            theErsPartitionId = (true?this.getErsPartitionId(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ersPartitionId", theErsPartitionId), currentHashCode, theErsPartitionId);
        }
        {
            String theExternalizationTitle;
            theExternalizationTitle = this.getExternalizationTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalizationTitle", theExternalizationTitle), currentHashCode, theExternalizationTitle);
        }
        {
            boolean thePartial;
            thePartial = (true?this.isPartial():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "partial", thePartial), currentHashCode, thePartial);
        }
        {
            Boolean theEraseRenditionMetadata;
            theEraseRenditionMetadata = this.isEraseRenditionMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "eraseRenditionMetadata", theEraseRenditionMetadata), currentHashCode, theEraseRenditionMetadata);
        }
        {
            List<ExternalizationRequest.Item> theItem;
            theItem = (((this.item!= null)&&(!this.item.isEmpty()))?this.getItem():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "item", theItem), currentHashCode, theItem);
        }
        {
            ExternalizationRequest.SpecificMetadataItems theSpecificMetadataItems;
            theSpecificMetadataItems = this.getSpecificMetadataItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "specificMetadataItems", theSpecificMetadataItems), currentHashCode, theSpecificMetadataItems);
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
     *         &lt;element name="itemId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
     *         &lt;element name="eraseRenditionMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
        "itemId",
        "eraseRenditionMetadata"
    })
    public static class Item
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected String itemId;
        protected Boolean eraseRenditionMetadata;

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
         * Gets the value of the eraseRenditionMetadata property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isEraseRenditionMetadata() {
            return eraseRenditionMetadata;
        }

        /**
         * Sets the value of the eraseRenditionMetadata property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setEraseRenditionMetadata(Boolean value) {
            this.eraseRenditionMetadata = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof ExternalizationRequest.Item)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final ExternalizationRequest.Item that = ((ExternalizationRequest.Item) object);
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
                Boolean lhsEraseRenditionMetadata;
                lhsEraseRenditionMetadata = this.isEraseRenditionMetadata();
                Boolean rhsEraseRenditionMetadata;
                rhsEraseRenditionMetadata = that.isEraseRenditionMetadata();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "eraseRenditionMetadata", lhsEraseRenditionMetadata), LocatorUtils.property(thatLocator, "eraseRenditionMetadata", rhsEraseRenditionMetadata), lhsEraseRenditionMetadata, rhsEraseRenditionMetadata)) {
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
                Boolean theEraseRenditionMetadata;
                theEraseRenditionMetadata = this.isEraseRenditionMetadata();
                strategy.appendField(locator, this, "eraseRenditionMetadata", buffer, theEraseRenditionMetadata);
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
                Boolean theEraseRenditionMetadata;
                theEraseRenditionMetadata = this.isEraseRenditionMetadata();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "eraseRenditionMetadata", theEraseRenditionMetadata), currentHashCode, theEraseRenditionMetadata);
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
    public static class SpecificMetadataItems
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
            if (!(object instanceof ExternalizationRequest.SpecificMetadataItems)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final ExternalizationRequest.SpecificMetadataItems that = ((ExternalizationRequest.SpecificMetadataItems) object);
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
