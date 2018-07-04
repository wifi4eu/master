
package generated.jagate.model.servicecontext.V2;

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
 * <p>Java class for ServiceInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DgName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ITSystemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ServiceVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Complete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StatusDetailList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StatusDetail" type="{http://ec.europa.eu/research/fp/model/service-context/V2}StatusDetailType" maxOccurs="unbounded"/>
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
@XmlType(name = "ServiceInformationType", propOrder = {
    "dgName",
    "itSystemName",
    "serviceVersion",
    "complete",
    "statusDetailList"
})
public class ServiceInformationType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "DgName", required = true)
    protected String dgName;
    @XmlElement(name = "ITSystemName", required = true)
    protected String itSystemName;
    @XmlElement(name = "ServiceVersion", required = true)
    protected String serviceVersion;
    @XmlElement(name = "Complete")
    protected Boolean complete;
    @XmlElement(name = "StatusDetailList", required = true)
    protected ServiceInformationType.StatusDetailList statusDetailList;

    /**
     * Gets the value of the dgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDgName() {
        return dgName;
    }

    /**
     * Sets the value of the dgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDgName(String value) {
        this.dgName = value;
    }

    /**
     * Gets the value of the itSystemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITSystemName() {
        return itSystemName;
    }

    /**
     * Sets the value of the itSystemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITSystemName(String value) {
        this.itSystemName = value;
    }

    /**
     * Gets the value of the serviceVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceVersion() {
        return serviceVersion;
    }

    /**
     * Sets the value of the serviceVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceVersion(String value) {
        this.serviceVersion = value;
    }

    /**
     * Gets the value of the complete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isComplete() {
        return complete;
    }

    /**
     * Sets the value of the complete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setComplete(Boolean value) {
        this.complete = value;
    }

    /**
     * Gets the value of the statusDetailList property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceInformationType.StatusDetailList }
     *     
     */
    public ServiceInformationType.StatusDetailList getStatusDetailList() {
        return statusDetailList;
    }

    /**
     * Sets the value of the statusDetailList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceInformationType.StatusDetailList }
     *     
     */
    public void setStatusDetailList(ServiceInformationType.StatusDetailList value) {
        this.statusDetailList = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ServiceInformationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ServiceInformationType that = ((ServiceInformationType) object);
        {
            String lhsDgName;
            lhsDgName = this.getDgName();
            String rhsDgName;
            rhsDgName = that.getDgName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dgName", lhsDgName), LocatorUtils.property(thatLocator, "dgName", rhsDgName), lhsDgName, rhsDgName)) {
                return false;
            }
        }
        {
            String lhsITSystemName;
            lhsITSystemName = this.getITSystemName();
            String rhsITSystemName;
            rhsITSystemName = that.getITSystemName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itSystemName", lhsITSystemName), LocatorUtils.property(thatLocator, "itSystemName", rhsITSystemName), lhsITSystemName, rhsITSystemName)) {
                return false;
            }
        }
        {
            String lhsServiceVersion;
            lhsServiceVersion = this.getServiceVersion();
            String rhsServiceVersion;
            rhsServiceVersion = that.getServiceVersion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceVersion", lhsServiceVersion), LocatorUtils.property(thatLocator, "serviceVersion", rhsServiceVersion), lhsServiceVersion, rhsServiceVersion)) {
                return false;
            }
        }
        {
            Boolean lhsComplete;
            lhsComplete = this.isComplete();
            Boolean rhsComplete;
            rhsComplete = that.isComplete();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "complete", lhsComplete), LocatorUtils.property(thatLocator, "complete", rhsComplete), lhsComplete, rhsComplete)) {
                return false;
            }
        }
        {
            ServiceInformationType.StatusDetailList lhsStatusDetailList;
            lhsStatusDetailList = this.getStatusDetailList();
            ServiceInformationType.StatusDetailList rhsStatusDetailList;
            rhsStatusDetailList = that.getStatusDetailList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "statusDetailList", lhsStatusDetailList), LocatorUtils.property(thatLocator, "statusDetailList", rhsStatusDetailList), lhsStatusDetailList, rhsStatusDetailList)) {
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
            String theDgName;
            theDgName = this.getDgName();
            strategy.appendField(locator, this, "dgName", buffer, theDgName);
        }
        {
            String theITSystemName;
            theITSystemName = this.getITSystemName();
            strategy.appendField(locator, this, "itSystemName", buffer, theITSystemName);
        }
        {
            String theServiceVersion;
            theServiceVersion = this.getServiceVersion();
            strategy.appendField(locator, this, "serviceVersion", buffer, theServiceVersion);
        }
        {
            Boolean theComplete;
            theComplete = this.isComplete();
            strategy.appendField(locator, this, "complete", buffer, theComplete);
        }
        {
            ServiceInformationType.StatusDetailList theStatusDetailList;
            theStatusDetailList = this.getStatusDetailList();
            strategy.appendField(locator, this, "statusDetailList", buffer, theStatusDetailList);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theDgName;
            theDgName = this.getDgName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dgName", theDgName), currentHashCode, theDgName);
        }
        {
            String theITSystemName;
            theITSystemName = this.getITSystemName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itSystemName", theITSystemName), currentHashCode, theITSystemName);
        }
        {
            String theServiceVersion;
            theServiceVersion = this.getServiceVersion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceVersion", theServiceVersion), currentHashCode, theServiceVersion);
        }
        {
            Boolean theComplete;
            theComplete = this.isComplete();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "complete", theComplete), currentHashCode, theComplete);
        }
        {
            ServiceInformationType.StatusDetailList theStatusDetailList;
            theStatusDetailList = this.getStatusDetailList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "statusDetailList", theStatusDetailList), currentHashCode, theStatusDetailList);
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
     *         &lt;element name="StatusDetail" type="{http://ec.europa.eu/research/fp/model/service-context/V2}StatusDetailType" maxOccurs="unbounded"/>
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
        "statusDetail"
    })
    public static class StatusDetailList
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "StatusDetail", required = true)
        protected List<StatusDetailType> statusDetail;

        /**
         * Gets the value of the statusDetail property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the statusDetail property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStatusDetail().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link StatusDetailType }
         * 
         * 
         */
        public List<StatusDetailType> getStatusDetail() {
            if (statusDetail == null) {
                statusDetail = new ArrayList<StatusDetailType>();
            }
            return this.statusDetail;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof ServiceInformationType.StatusDetailList)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final ServiceInformationType.StatusDetailList that = ((ServiceInformationType.StatusDetailList) object);
            {
                List<StatusDetailType> lhsStatusDetail;
                lhsStatusDetail = (((this.statusDetail!= null)&&(!this.statusDetail.isEmpty()))?this.getStatusDetail():null);
                List<StatusDetailType> rhsStatusDetail;
                rhsStatusDetail = (((that.statusDetail!= null)&&(!that.statusDetail.isEmpty()))?that.getStatusDetail():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "statusDetail", lhsStatusDetail), LocatorUtils.property(thatLocator, "statusDetail", rhsStatusDetail), lhsStatusDetail, rhsStatusDetail)) {
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
                List<StatusDetailType> theStatusDetail;
                theStatusDetail = (((this.statusDetail!= null)&&(!this.statusDetail.isEmpty()))?this.getStatusDetail():null);
                strategy.appendField(locator, this, "statusDetail", buffer, theStatusDetail);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<StatusDetailType> theStatusDetail;
                theStatusDetail = (((this.statusDetail!= null)&&(!this.statusDetail.isEmpty()))?this.getStatusDetail():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "statusDetail", theStatusDetail), currentHashCode, theStatusDetail);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
