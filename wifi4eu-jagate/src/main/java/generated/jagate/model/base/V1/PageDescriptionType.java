
package generated.jagate.model.base.V1;

import java.math.BigInteger;
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
 * Boundaries of requested data
 * 
 * <p>Java class for PageDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pageNumber" type="{http://ec.europa.eu/research/fp/model/base/V1}CountType"/>
 *         &lt;element name="pageSize" type="{http://ec.europa.eu/research/fp/model/base/V1}CountType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageDescriptionType", propOrder = {
    "pageNumber",
    "pageSize"
})
public class PageDescriptionType
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected BigInteger pageNumber;
    @XmlElement(required = true)
    protected BigInteger pageSize;

    /**
     * Gets the value of the pageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the value of the pageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPageNumber(BigInteger value) {
        this.pageNumber = value;
    }

    /**
     * Gets the value of the pageSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPageSize(BigInteger value) {
        this.pageSize = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PageDescriptionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PageDescriptionType that = ((PageDescriptionType) object);
        {
            BigInteger lhsPageNumber;
            lhsPageNumber = this.getPageNumber();
            BigInteger rhsPageNumber;
            rhsPageNumber = that.getPageNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pageNumber", lhsPageNumber), LocatorUtils.property(thatLocator, "pageNumber", rhsPageNumber), lhsPageNumber, rhsPageNumber)) {
                return false;
            }
        }
        {
            BigInteger lhsPageSize;
            lhsPageSize = this.getPageSize();
            BigInteger rhsPageSize;
            rhsPageSize = that.getPageSize();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pageSize", lhsPageSize), LocatorUtils.property(thatLocator, "pageSize", rhsPageSize), lhsPageSize, rhsPageSize)) {
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
            BigInteger thePageNumber;
            thePageNumber = this.getPageNumber();
            strategy.appendField(locator, this, "pageNumber", buffer, thePageNumber);
        }
        {
            BigInteger thePageSize;
            thePageSize = this.getPageSize();
            strategy.appendField(locator, this, "pageSize", buffer, thePageSize);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            BigInteger thePageNumber;
            thePageNumber = this.getPageNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pageNumber", thePageNumber), currentHashCode, thePageNumber);
        }
        {
            BigInteger thePageSize;
            thePageSize = this.getPageSize();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pageSize", thePageSize), currentHashCode, thePageSize);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
