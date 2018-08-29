
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
 * Request for searching documents.
 * 
 * <p>Java class for DocumentSearchByExpressionRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentSearchByExpressionRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchExpression" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="skip" type="{http://ec.europa.eu/sg/hrs/types}int0To2000" minOccurs="0"/>
 *         &lt;element name="max" type="{http://ec.europa.eu/sg/hrs/types}int0To2000" minOccurs="0"/>
 *         &lt;element name="additionalPartitions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="partitionId" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="excludeDefaultPartition" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="useIndexServer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="indexServerOptions" type="{http://ec.europa.eu/sg/hrs/types}IndexServerOptions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentSearchByExpressionRequest", propOrder = {
    "searchExpression",
    "skip",
    "max",
    "additionalPartitions",
    "excludeDefaultPartition",
    "useIndexServer",
    "indexServerOptions"
})
public class DocumentSearchByExpressionRequest
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String searchExpression;
    @XmlElement(defaultValue = "0")
    protected Integer skip;
    @XmlElement(defaultValue = "10")
    protected Integer max;
    protected DocumentSearchByExpressionRequest.AdditionalPartitions additionalPartitions;
    protected Boolean excludeDefaultPartition;
    protected Boolean useIndexServer;
    protected IndexServerOptions indexServerOptions;

    /**
     * Gets the value of the searchExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchExpression() {
        return searchExpression;
    }

    /**
     * Sets the value of the searchExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchExpression(String value) {
        this.searchExpression = value;
    }

    /**
     * Gets the value of the skip property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSkip() {
        return skip;
    }

    /**
     * Sets the value of the skip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSkip(Integer value) {
        this.skip = value;
    }

    /**
     * Gets the value of the max property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMax(Integer value) {
        this.max = value;
    }

    /**
     * Gets the value of the additionalPartitions property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentSearchByExpressionRequest.AdditionalPartitions }
     *     
     */
    public DocumentSearchByExpressionRequest.AdditionalPartitions getAdditionalPartitions() {
        return additionalPartitions;
    }

    /**
     * Sets the value of the additionalPartitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentSearchByExpressionRequest.AdditionalPartitions }
     *     
     */
    public void setAdditionalPartitions(DocumentSearchByExpressionRequest.AdditionalPartitions value) {
        this.additionalPartitions = value;
    }

    /**
     * Gets the value of the excludeDefaultPartition property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExcludeDefaultPartition() {
        return excludeDefaultPartition;
    }

    /**
     * Sets the value of the excludeDefaultPartition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExcludeDefaultPartition(Boolean value) {
        this.excludeDefaultPartition = value;
    }

    /**
     * Gets the value of the useIndexServer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseIndexServer() {
        return useIndexServer;
    }

    /**
     * Sets the value of the useIndexServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseIndexServer(Boolean value) {
        this.useIndexServer = value;
    }

    /**
     * Gets the value of the indexServerOptions property.
     * 
     * @return
     *     possible object is
     *     {@link IndexServerOptions }
     *     
     */
    public IndexServerOptions getIndexServerOptions() {
        return indexServerOptions;
    }

    /**
     * Sets the value of the indexServerOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexServerOptions }
     *     
     */
    public void setIndexServerOptions(IndexServerOptions value) {
        this.indexServerOptions = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentSearchByExpressionRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentSearchByExpressionRequest that = ((DocumentSearchByExpressionRequest) object);
        {
            String lhsSearchExpression;
            lhsSearchExpression = this.getSearchExpression();
            String rhsSearchExpression;
            rhsSearchExpression = that.getSearchExpression();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "searchExpression", lhsSearchExpression), LocatorUtils.property(thatLocator, "searchExpression", rhsSearchExpression), lhsSearchExpression, rhsSearchExpression)) {
                return false;
            }
        }
        {
            Integer lhsSkip;
            lhsSkip = this.getSkip();
            Integer rhsSkip;
            rhsSkip = that.getSkip();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "skip", lhsSkip), LocatorUtils.property(thatLocator, "skip", rhsSkip), lhsSkip, rhsSkip)) {
                return false;
            }
        }
        {
            Integer lhsMax;
            lhsMax = this.getMax();
            Integer rhsMax;
            rhsMax = that.getMax();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "max", lhsMax), LocatorUtils.property(thatLocator, "max", rhsMax), lhsMax, rhsMax)) {
                return false;
            }
        }
        {
            DocumentSearchByExpressionRequest.AdditionalPartitions lhsAdditionalPartitions;
            lhsAdditionalPartitions = this.getAdditionalPartitions();
            DocumentSearchByExpressionRequest.AdditionalPartitions rhsAdditionalPartitions;
            rhsAdditionalPartitions = that.getAdditionalPartitions();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "additionalPartitions", lhsAdditionalPartitions), LocatorUtils.property(thatLocator, "additionalPartitions", rhsAdditionalPartitions), lhsAdditionalPartitions, rhsAdditionalPartitions)) {
                return false;
            }
        }
        {
            Boolean lhsExcludeDefaultPartition;
            lhsExcludeDefaultPartition = this.isExcludeDefaultPartition();
            Boolean rhsExcludeDefaultPartition;
            rhsExcludeDefaultPartition = that.isExcludeDefaultPartition();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "excludeDefaultPartition", lhsExcludeDefaultPartition), LocatorUtils.property(thatLocator, "excludeDefaultPartition", rhsExcludeDefaultPartition), lhsExcludeDefaultPartition, rhsExcludeDefaultPartition)) {
                return false;
            }
        }
        {
            Boolean lhsUseIndexServer;
            lhsUseIndexServer = this.isUseIndexServer();
            Boolean rhsUseIndexServer;
            rhsUseIndexServer = that.isUseIndexServer();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "useIndexServer", lhsUseIndexServer), LocatorUtils.property(thatLocator, "useIndexServer", rhsUseIndexServer), lhsUseIndexServer, rhsUseIndexServer)) {
                return false;
            }
        }
        {
            IndexServerOptions lhsIndexServerOptions;
            lhsIndexServerOptions = this.getIndexServerOptions();
            IndexServerOptions rhsIndexServerOptions;
            rhsIndexServerOptions = that.getIndexServerOptions();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "indexServerOptions", lhsIndexServerOptions), LocatorUtils.property(thatLocator, "indexServerOptions", rhsIndexServerOptions), lhsIndexServerOptions, rhsIndexServerOptions)) {
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
            String theSearchExpression;
            theSearchExpression = this.getSearchExpression();
            strategy.appendField(locator, this, "searchExpression", buffer, theSearchExpression);
        }
        {
            Integer theSkip;
            theSkip = this.getSkip();
            strategy.appendField(locator, this, "skip", buffer, theSkip);
        }
        {
            Integer theMax;
            theMax = this.getMax();
            strategy.appendField(locator, this, "max", buffer, theMax);
        }
        {
            DocumentSearchByExpressionRequest.AdditionalPartitions theAdditionalPartitions;
            theAdditionalPartitions = this.getAdditionalPartitions();
            strategy.appendField(locator, this, "additionalPartitions", buffer, theAdditionalPartitions);
        }
        {
            Boolean theExcludeDefaultPartition;
            theExcludeDefaultPartition = this.isExcludeDefaultPartition();
            strategy.appendField(locator, this, "excludeDefaultPartition", buffer, theExcludeDefaultPartition);
        }
        {
            Boolean theUseIndexServer;
            theUseIndexServer = this.isUseIndexServer();
            strategy.appendField(locator, this, "useIndexServer", buffer, theUseIndexServer);
        }
        {
            IndexServerOptions theIndexServerOptions;
            theIndexServerOptions = this.getIndexServerOptions();
            strategy.appendField(locator, this, "indexServerOptions", buffer, theIndexServerOptions);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theSearchExpression;
            theSearchExpression = this.getSearchExpression();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchExpression", theSearchExpression), currentHashCode, theSearchExpression);
        }
        {
            Integer theSkip;
            theSkip = this.getSkip();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "skip", theSkip), currentHashCode, theSkip);
        }
        {
            Integer theMax;
            theMax = this.getMax();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "max", theMax), currentHashCode, theMax);
        }
        {
            DocumentSearchByExpressionRequest.AdditionalPartitions theAdditionalPartitions;
            theAdditionalPartitions = this.getAdditionalPartitions();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "additionalPartitions", theAdditionalPartitions), currentHashCode, theAdditionalPartitions);
        }
        {
            Boolean theExcludeDefaultPartition;
            theExcludeDefaultPartition = this.isExcludeDefaultPartition();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "excludeDefaultPartition", theExcludeDefaultPartition), currentHashCode, theExcludeDefaultPartition);
        }
        {
            Boolean theUseIndexServer;
            theUseIndexServer = this.isUseIndexServer();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "useIndexServer", theUseIndexServer), currentHashCode, theUseIndexServer);
        }
        {
            IndexServerOptions theIndexServerOptions;
            theIndexServerOptions = this.getIndexServerOptions();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indexServerOptions", theIndexServerOptions), currentHashCode, theIndexServerOptions);
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
     *         &lt;element name="partitionId" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/>
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
        "partitionId"
    })
    public static class AdditionalPartitions
        implements Equals, HashCode, ToString
    {

        @XmlElement(type = Integer.class)
        protected List<Integer> partitionId;

        /**
         * Gets the value of the partitionId property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the partitionId property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPartitionId().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Integer }
         * 
         * 
         */
        public List<Integer> getPartitionId() {
            if (partitionId == null) {
                partitionId = new ArrayList<Integer>();
            }
            return this.partitionId;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof DocumentSearchByExpressionRequest.AdditionalPartitions)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final DocumentSearchByExpressionRequest.AdditionalPartitions that = ((DocumentSearchByExpressionRequest.AdditionalPartitions) object);
            {
                List<Integer> lhsPartitionId;
                lhsPartitionId = (((this.partitionId!= null)&&(!this.partitionId.isEmpty()))?this.getPartitionId():null);
                List<Integer> rhsPartitionId;
                rhsPartitionId = (((that.partitionId!= null)&&(!that.partitionId.isEmpty()))?that.getPartitionId():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "partitionId", lhsPartitionId), LocatorUtils.property(thatLocator, "partitionId", rhsPartitionId), lhsPartitionId, rhsPartitionId)) {
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
                List<Integer> thePartitionId;
                thePartitionId = (((this.partitionId!= null)&&(!this.partitionId.isEmpty()))?this.getPartitionId():null);
                strategy.appendField(locator, this, "partitionId", buffer, thePartitionId);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<Integer> thePartitionId;
                thePartitionId = (((this.partitionId!= null)&&(!this.partitionId.isEmpty()))?this.getPartitionId():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "partitionId", thePartitionId), currentHashCode, thePartitionId);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
