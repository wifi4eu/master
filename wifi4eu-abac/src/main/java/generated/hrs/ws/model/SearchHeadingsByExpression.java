
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ec.europa.eu/sg/hrs/types}header"/>
 *         &lt;element name="request" type="{http://ec.europa.eu/sg/hrs/types}FilingPlanSearchByExpressionRequest"/>
 *         &lt;element name="headingRetrievalOptions" type="{http://ec.europa.eu/sg/hrs/types}HeadingRetrievalOptions" minOccurs="0"/>
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
    "header",
    "request",
    "headingRetrievalOptions"
})
@XmlRootElement(name = "searchHeadingsByExpression")
public class SearchHeadingsByExpression
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected FilingPlanSearchByExpressionRequest request;
    protected HeadingRetrievalOptions headingRetrievalOptions;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link FilingPlanSearchByExpressionRequest }
     *     
     */
    public FilingPlanSearchByExpressionRequest getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingPlanSearchByExpressionRequest }
     *     
     */
    public void setRequest(FilingPlanSearchByExpressionRequest value) {
        this.request = value;
    }

    /**
     * Gets the value of the headingRetrievalOptions property.
     * 
     * @return
     *     possible object is
     *     {@link HeadingRetrievalOptions }
     *     
     */
    public HeadingRetrievalOptions getHeadingRetrievalOptions() {
        return headingRetrievalOptions;
    }

    /**
     * Sets the value of the headingRetrievalOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeadingRetrievalOptions }
     *     
     */
    public void setHeadingRetrievalOptions(HeadingRetrievalOptions value) {
        this.headingRetrievalOptions = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SearchHeadingsByExpression)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SearchHeadingsByExpression that = ((SearchHeadingsByExpression) object);
        {
            Header lhsHeader;
            lhsHeader = this.getHeader();
            Header rhsHeader;
            rhsHeader = that.getHeader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "header", lhsHeader), LocatorUtils.property(thatLocator, "header", rhsHeader), lhsHeader, rhsHeader)) {
                return false;
            }
        }
        {
            FilingPlanSearchByExpressionRequest lhsRequest;
            lhsRequest = this.getRequest();
            FilingPlanSearchByExpressionRequest rhsRequest;
            rhsRequest = that.getRequest();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "request", lhsRequest), LocatorUtils.property(thatLocator, "request", rhsRequest), lhsRequest, rhsRequest)) {
                return false;
            }
        }
        {
            HeadingRetrievalOptions lhsHeadingRetrievalOptions;
            lhsHeadingRetrievalOptions = this.getHeadingRetrievalOptions();
            HeadingRetrievalOptions rhsHeadingRetrievalOptions;
            rhsHeadingRetrievalOptions = that.getHeadingRetrievalOptions();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "headingRetrievalOptions", lhsHeadingRetrievalOptions), LocatorUtils.property(thatLocator, "headingRetrievalOptions", rhsHeadingRetrievalOptions), lhsHeadingRetrievalOptions, rhsHeadingRetrievalOptions)) {
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
            Header theHeader;
            theHeader = this.getHeader();
            strategy.appendField(locator, this, "header", buffer, theHeader);
        }
        {
            FilingPlanSearchByExpressionRequest theRequest;
            theRequest = this.getRequest();
            strategy.appendField(locator, this, "request", buffer, theRequest);
        }
        {
            HeadingRetrievalOptions theHeadingRetrievalOptions;
            theHeadingRetrievalOptions = this.getHeadingRetrievalOptions();
            strategy.appendField(locator, this, "headingRetrievalOptions", buffer, theHeadingRetrievalOptions);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Header theHeader;
            theHeader = this.getHeader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "header", theHeader), currentHashCode, theHeader);
        }
        {
            FilingPlanSearchByExpressionRequest theRequest;
            theRequest = this.getRequest();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "request", theRequest), currentHashCode, theRequest);
        }
        {
            HeadingRetrievalOptions theHeadingRetrievalOptions;
            theHeadingRetrievalOptions = this.getHeadingRetrievalOptions();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "headingRetrievalOptions", theHeadingRetrievalOptions), currentHashCode, theHeadingRetrievalOptions);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
