
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
 * When searching against the index server, certain options can be specified which
 *                 are specific to the index server.
 * 
 * <p>Java class for IndexServerOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndexServerOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="collection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="year" type="{http://ec.europa.eu/sg/hrs/types}CollectionYear" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="includeItemSummary" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="limitToMatchingItemsMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="computeTotalRetrievable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndexServerOptions", propOrder = {
    "collection",
    "includeItemSummary",
    "limitToMatchingItemsMetadata",
    "computeTotalRetrievable"
})
public class IndexServerOptions
    implements Equals, HashCode, ToString
{

    protected IndexServerOptions.Collection collection;
    protected Boolean includeItemSummary;
    protected Boolean limitToMatchingItemsMetadata;
    protected Boolean computeTotalRetrievable;

    /**
     * Gets the value of the collection property.
     * 
     * @return
     *     possible object is
     *     {@link IndexServerOptions.Collection }
     *     
     */
    public IndexServerOptions.Collection getCollection() {
        return collection;
    }

    /**
     * Sets the value of the collection property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexServerOptions.Collection }
     *     
     */
    public void setCollection(IndexServerOptions.Collection value) {
        this.collection = value;
    }

    /**
     * Gets the value of the includeItemSummary property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeItemSummary() {
        return includeItemSummary;
    }

    /**
     * Sets the value of the includeItemSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeItemSummary(Boolean value) {
        this.includeItemSummary = value;
    }

    /**
     * Gets the value of the limitToMatchingItemsMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLimitToMatchingItemsMetadata() {
        return limitToMatchingItemsMetadata;
    }

    /**
     * Sets the value of the limitToMatchingItemsMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLimitToMatchingItemsMetadata(Boolean value) {
        this.limitToMatchingItemsMetadata = value;
    }

    /**
     * Gets the value of the computeTotalRetrievable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isComputeTotalRetrievable() {
        return computeTotalRetrievable;
    }

    /**
     * Sets the value of the computeTotalRetrievable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setComputeTotalRetrievable(Boolean value) {
        this.computeTotalRetrievable = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof IndexServerOptions)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IndexServerOptions that = ((IndexServerOptions) object);
        {
            IndexServerOptions.Collection lhsCollection;
            lhsCollection = this.getCollection();
            IndexServerOptions.Collection rhsCollection;
            rhsCollection = that.getCollection();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "collection", lhsCollection), LocatorUtils.property(thatLocator, "collection", rhsCollection), lhsCollection, rhsCollection)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeItemSummary;
            lhsIncludeItemSummary = this.isIncludeItemSummary();
            Boolean rhsIncludeItemSummary;
            rhsIncludeItemSummary = that.isIncludeItemSummary();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeItemSummary", lhsIncludeItemSummary), LocatorUtils.property(thatLocator, "includeItemSummary", rhsIncludeItemSummary), lhsIncludeItemSummary, rhsIncludeItemSummary)) {
                return false;
            }
        }
        {
            Boolean lhsLimitToMatchingItemsMetadata;
            lhsLimitToMatchingItemsMetadata = this.isLimitToMatchingItemsMetadata();
            Boolean rhsLimitToMatchingItemsMetadata;
            rhsLimitToMatchingItemsMetadata = that.isLimitToMatchingItemsMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "limitToMatchingItemsMetadata", lhsLimitToMatchingItemsMetadata), LocatorUtils.property(thatLocator, "limitToMatchingItemsMetadata", rhsLimitToMatchingItemsMetadata), lhsLimitToMatchingItemsMetadata, rhsLimitToMatchingItemsMetadata)) {
                return false;
            }
        }
        {
            Boolean lhsComputeTotalRetrievable;
            lhsComputeTotalRetrievable = this.isComputeTotalRetrievable();
            Boolean rhsComputeTotalRetrievable;
            rhsComputeTotalRetrievable = that.isComputeTotalRetrievable();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "computeTotalRetrievable", lhsComputeTotalRetrievable), LocatorUtils.property(thatLocator, "computeTotalRetrievable", rhsComputeTotalRetrievable), lhsComputeTotalRetrievable, rhsComputeTotalRetrievable)) {
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
            IndexServerOptions.Collection theCollection;
            theCollection = this.getCollection();
            strategy.appendField(locator, this, "collection", buffer, theCollection);
        }
        {
            Boolean theIncludeItemSummary;
            theIncludeItemSummary = this.isIncludeItemSummary();
            strategy.appendField(locator, this, "includeItemSummary", buffer, theIncludeItemSummary);
        }
        {
            Boolean theLimitToMatchingItemsMetadata;
            theLimitToMatchingItemsMetadata = this.isLimitToMatchingItemsMetadata();
            strategy.appendField(locator, this, "limitToMatchingItemsMetadata", buffer, theLimitToMatchingItemsMetadata);
        }
        {
            Boolean theComputeTotalRetrievable;
            theComputeTotalRetrievable = this.isComputeTotalRetrievable();
            strategy.appendField(locator, this, "computeTotalRetrievable", buffer, theComputeTotalRetrievable);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            IndexServerOptions.Collection theCollection;
            theCollection = this.getCollection();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "collection", theCollection), currentHashCode, theCollection);
        }
        {
            Boolean theIncludeItemSummary;
            theIncludeItemSummary = this.isIncludeItemSummary();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeItemSummary", theIncludeItemSummary), currentHashCode, theIncludeItemSummary);
        }
        {
            Boolean theLimitToMatchingItemsMetadata;
            theLimitToMatchingItemsMetadata = this.isLimitToMatchingItemsMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "limitToMatchingItemsMetadata", theLimitToMatchingItemsMetadata), currentHashCode, theLimitToMatchingItemsMetadata);
        }
        {
            Boolean theComputeTotalRetrievable;
            theComputeTotalRetrievable = this.isComputeTotalRetrievable();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "computeTotalRetrievable", theComputeTotalRetrievable), currentHashCode, theComputeTotalRetrievable);
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
     *         &lt;element name="year" type="{http://ec.europa.eu/sg/hrs/types}CollectionYear" maxOccurs="unbounded"/>
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
        "year"
    })
    public static class Collection
        implements Equals, HashCode, ToString
    {

        @XmlElement(type = Integer.class)
        protected List<Integer> year;

        /**
         * Gets the value of the year property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the year property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getYear().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Integer }
         * 
         * 
         */
        public List<Integer> getYear() {
            if (year == null) {
                year = new ArrayList<Integer>();
            }
            return this.year;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof IndexServerOptions.Collection)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final IndexServerOptions.Collection that = ((IndexServerOptions.Collection) object);
            {
                List<Integer> lhsYear;
                lhsYear = (((this.year!= null)&&(!this.year.isEmpty()))?this.getYear():null);
                List<Integer> rhsYear;
                rhsYear = (((that.year!= null)&&(!that.year.isEmpty()))?that.getYear():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "year", lhsYear), LocatorUtils.property(thatLocator, "year", rhsYear), lhsYear, rhsYear)) {
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
                List<Integer> theYear;
                theYear = (((this.year!= null)&&(!this.year.isEmpty()))?this.getYear():null);
                strategy.appendField(locator, this, "year", buffer, theYear);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<Integer> theYear;
                theYear = (((this.year!= null)&&(!this.year.isEmpty()))?this.getYear():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "year", theYear), currentHashCode, theYear);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
