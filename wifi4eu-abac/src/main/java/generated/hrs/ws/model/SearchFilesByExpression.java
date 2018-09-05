
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
 *         &lt;element name="fileRetrievalOptions" type="{http://ec.europa.eu/sg/hrs/types}FileRetrievalOptions" minOccurs="0"/>
 *         &lt;element name="sortOptions" type="{http://ec.europa.eu/sg/hrs/types}SortOptions" minOccurs="0"/>
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
    "fileRetrievalOptions",
    "sortOptions"
})
@XmlRootElement(name = "searchFilesByExpression")
public class SearchFilesByExpression
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected FilingPlanSearchByExpressionRequest request;
    protected FileRetrievalOptions fileRetrievalOptions;
    protected SortOptions sortOptions;

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
     * Gets the value of the fileRetrievalOptions property.
     * 
     * @return
     *     possible object is
     *     {@link FileRetrievalOptions }
     *     
     */
    public FileRetrievalOptions getFileRetrievalOptions() {
        return fileRetrievalOptions;
    }

    /**
     * Sets the value of the fileRetrievalOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileRetrievalOptions }
     *     
     */
    public void setFileRetrievalOptions(FileRetrievalOptions value) {
        this.fileRetrievalOptions = value;
    }

    /**
     * Gets the value of the sortOptions property.
     * 
     * @return
     *     possible object is
     *     {@link SortOptions }
     *     
     */
    public SortOptions getSortOptions() {
        return sortOptions;
    }

    /**
     * Sets the value of the sortOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortOptions }
     *     
     */
    public void setSortOptions(SortOptions value) {
        this.sortOptions = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SearchFilesByExpression)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SearchFilesByExpression that = ((SearchFilesByExpression) object);
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
            FileRetrievalOptions lhsFileRetrievalOptions;
            lhsFileRetrievalOptions = this.getFileRetrievalOptions();
            FileRetrievalOptions rhsFileRetrievalOptions;
            rhsFileRetrievalOptions = that.getFileRetrievalOptions();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fileRetrievalOptions", lhsFileRetrievalOptions), LocatorUtils.property(thatLocator, "fileRetrievalOptions", rhsFileRetrievalOptions), lhsFileRetrievalOptions, rhsFileRetrievalOptions)) {
                return false;
            }
        }
        {
            SortOptions lhsSortOptions;
            lhsSortOptions = this.getSortOptions();
            SortOptions rhsSortOptions;
            rhsSortOptions = that.getSortOptions();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sortOptions", lhsSortOptions), LocatorUtils.property(thatLocator, "sortOptions", rhsSortOptions), lhsSortOptions, rhsSortOptions)) {
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
            FileRetrievalOptions theFileRetrievalOptions;
            theFileRetrievalOptions = this.getFileRetrievalOptions();
            strategy.appendField(locator, this, "fileRetrievalOptions", buffer, theFileRetrievalOptions);
        }
        {
            SortOptions theSortOptions;
            theSortOptions = this.getSortOptions();
            strategy.appendField(locator, this, "sortOptions", buffer, theSortOptions);
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
            FileRetrievalOptions theFileRetrievalOptions;
            theFileRetrievalOptions = this.getFileRetrievalOptions();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fileRetrievalOptions", theFileRetrievalOptions), currentHashCode, theFileRetrievalOptions);
        }
        {
            SortOptions theSortOptions;
            theSortOptions = this.getSortOptions();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sortOptions", theSortOptions), currentHashCode, theSortOptions);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
