
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
 * Options allowing to sort the result of a search
 * 
 * <p>Java class for SortOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SortOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sortBy" maxOccurs="2">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fieldName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="order">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="ASC"/>
 *                         &lt;enumeration value="DESC"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
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
@XmlType(name = "SortOptions", propOrder = {
    "sortBy"
})
public class SortOptions
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected List<SortOptions.SortBy> sortBy;

    /**
     * Gets the value of the sortBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSortBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SortOptions.SortBy }
     * 
     * 
     */
    public List<SortOptions.SortBy> getSortBy() {
        if (sortBy == null) {
            sortBy = new ArrayList<SortOptions.SortBy>();
        }
        return this.sortBy;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SortOptions)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SortOptions that = ((SortOptions) object);
        {
            List<SortOptions.SortBy> lhsSortBy;
            lhsSortBy = (((this.sortBy!= null)&&(!this.sortBy.isEmpty()))?this.getSortBy():null);
            List<SortOptions.SortBy> rhsSortBy;
            rhsSortBy = (((that.sortBy!= null)&&(!that.sortBy.isEmpty()))?that.getSortBy():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sortBy", lhsSortBy), LocatorUtils.property(thatLocator, "sortBy", rhsSortBy), lhsSortBy, rhsSortBy)) {
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
            List<SortOptions.SortBy> theSortBy;
            theSortBy = (((this.sortBy!= null)&&(!this.sortBy.isEmpty()))?this.getSortBy():null);
            strategy.appendField(locator, this, "sortBy", buffer, theSortBy);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<SortOptions.SortBy> theSortBy;
            theSortBy = (((this.sortBy!= null)&&(!this.sortBy.isEmpty()))?this.getSortBy():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sortBy", theSortBy), currentHashCode, theSortBy);
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
     *         &lt;element name="fieldName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="order">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="ASC"/>
     *               &lt;enumeration value="DESC"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
    @XmlType(name = "", propOrder = {
        "fieldName",
        "order"
    })
    public static class SortBy
        implements Equals, HashCode, ToString
    {

        @XmlElement(required = true)
        protected String fieldName;
        @XmlElement(required = true)
        protected String order;

        /**
         * Gets the value of the fieldName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFieldName() {
            return fieldName;
        }

        /**
         * Sets the value of the fieldName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFieldName(String value) {
            this.fieldName = value;
        }

        /**
         * Gets the value of the order property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrder() {
            return order;
        }

        /**
         * Sets the value of the order property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrder(String value) {
            this.order = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof SortOptions.SortBy)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final SortOptions.SortBy that = ((SortOptions.SortBy) object);
            {
                String lhsFieldName;
                lhsFieldName = this.getFieldName();
                String rhsFieldName;
                rhsFieldName = that.getFieldName();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "fieldName", lhsFieldName), LocatorUtils.property(thatLocator, "fieldName", rhsFieldName), lhsFieldName, rhsFieldName)) {
                    return false;
                }
            }
            {
                String lhsOrder;
                lhsOrder = this.getOrder();
                String rhsOrder;
                rhsOrder = that.getOrder();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "order", lhsOrder), LocatorUtils.property(thatLocator, "order", rhsOrder), lhsOrder, rhsOrder)) {
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
                String theFieldName;
                theFieldName = this.getFieldName();
                strategy.appendField(locator, this, "fieldName", buffer, theFieldName);
            }
            {
                String theOrder;
                theOrder = this.getOrder();
                strategy.appendField(locator, this, "order", buffer, theOrder);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theFieldName;
                theFieldName = this.getFieldName();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fieldName", theFieldName), currentHashCode, theFieldName);
            }
            {
                String theOrder;
                theOrder = this.getOrder();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "order", theOrder), currentHashCode, theOrder);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
