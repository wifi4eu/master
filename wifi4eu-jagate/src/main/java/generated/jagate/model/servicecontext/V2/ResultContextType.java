
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
 * This element contains the operation's execution result information. ResultContext typically describes a degradated response (e.g. deprecated operation, capped response, partial response due to missing dependencies).
 * 
 * <p>Java class for ResultContextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultContextType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GlobalStatus" type="{http://ec.europa.eu/research/fp/model/service-context/V2}StatusType"/>
 *         &lt;element name="ResultNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Complete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ServiceInformationList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ServiceInformation" type="{http://ec.europa.eu/research/fp/model/service-context/V2}ServiceInformationType" maxOccurs="unbounded"/>
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
@XmlType(name = "ResultContextType", propOrder = {
    "globalStatus",
    "resultNumber",
    "complete",
    "serviceInformationList"
})
public class ResultContextType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "GlobalStatus", required = true)
    protected StatusType globalStatus;
    @XmlElement(name = "ResultNumber")
    protected Integer resultNumber;
    @XmlElement(name = "Complete")
    protected Boolean complete;
    @XmlElement(name = "ServiceInformationList", required = true)
    protected ResultContextType.ServiceInformationList serviceInformationList;

    /**
     * Gets the value of the globalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getGlobalStatus() {
        return globalStatus;
    }

    /**
     * Sets the value of the globalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setGlobalStatus(StatusType value) {
        this.globalStatus = value;
    }

    /**
     * Gets the value of the resultNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResultNumber() {
        return resultNumber;
    }

    /**
     * Sets the value of the resultNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResultNumber(Integer value) {
        this.resultNumber = value;
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
     * Gets the value of the serviceInformationList property.
     * 
     * @return
     *     possible object is
     *     {@link ResultContextType.ServiceInformationList }
     *     
     */
    public ResultContextType.ServiceInformationList getServiceInformationList() {
        return serviceInformationList;
    }

    /**
     * Sets the value of the serviceInformationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultContextType.ServiceInformationList }
     *     
     */
    public void setServiceInformationList(ResultContextType.ServiceInformationList value) {
        this.serviceInformationList = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResultContextType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ResultContextType that = ((ResultContextType) object);
        {
            StatusType lhsGlobalStatus;
            lhsGlobalStatus = this.getGlobalStatus();
            StatusType rhsGlobalStatus;
            rhsGlobalStatus = that.getGlobalStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "globalStatus", lhsGlobalStatus), LocatorUtils.property(thatLocator, "globalStatus", rhsGlobalStatus), lhsGlobalStatus, rhsGlobalStatus)) {
                return false;
            }
        }
        {
            Integer lhsResultNumber;
            lhsResultNumber = this.getResultNumber();
            Integer rhsResultNumber;
            rhsResultNumber = that.getResultNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resultNumber", lhsResultNumber), LocatorUtils.property(thatLocator, "resultNumber", rhsResultNumber), lhsResultNumber, rhsResultNumber)) {
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
            ResultContextType.ServiceInformationList lhsServiceInformationList;
            lhsServiceInformationList = this.getServiceInformationList();
            ResultContextType.ServiceInformationList rhsServiceInformationList;
            rhsServiceInformationList = that.getServiceInformationList();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceInformationList", lhsServiceInformationList), LocatorUtils.property(thatLocator, "serviceInformationList", rhsServiceInformationList), lhsServiceInformationList, rhsServiceInformationList)) {
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
            StatusType theGlobalStatus;
            theGlobalStatus = this.getGlobalStatus();
            strategy.appendField(locator, this, "globalStatus", buffer, theGlobalStatus);
        }
        {
            Integer theResultNumber;
            theResultNumber = this.getResultNumber();
            strategy.appendField(locator, this, "resultNumber", buffer, theResultNumber);
        }
        {
            Boolean theComplete;
            theComplete = this.isComplete();
            strategy.appendField(locator, this, "complete", buffer, theComplete);
        }
        {
            ResultContextType.ServiceInformationList theServiceInformationList;
            theServiceInformationList = this.getServiceInformationList();
            strategy.appendField(locator, this, "serviceInformationList", buffer, theServiceInformationList);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            StatusType theGlobalStatus;
            theGlobalStatus = this.getGlobalStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "globalStatus", theGlobalStatus), currentHashCode, theGlobalStatus);
        }
        {
            Integer theResultNumber;
            theResultNumber = this.getResultNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultNumber", theResultNumber), currentHashCode, theResultNumber);
        }
        {
            Boolean theComplete;
            theComplete = this.isComplete();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "complete", theComplete), currentHashCode, theComplete);
        }
        {
            ResultContextType.ServiceInformationList theServiceInformationList;
            theServiceInformationList = this.getServiceInformationList();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceInformationList", theServiceInformationList), currentHashCode, theServiceInformationList);
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
     *         &lt;element name="ServiceInformation" type="{http://ec.europa.eu/research/fp/model/service-context/V2}ServiceInformationType" maxOccurs="unbounded"/>
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
        "serviceInformation"
    })
    public static class ServiceInformationList
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "ServiceInformation", required = true)
        protected List<ServiceInformationType> serviceInformation;

        /**
         * Gets the value of the serviceInformation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the serviceInformation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getServiceInformation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ServiceInformationType }
         * 
         * 
         */
        public List<ServiceInformationType> getServiceInformation() {
            if (serviceInformation == null) {
                serviceInformation = new ArrayList<ServiceInformationType>();
            }
            return this.serviceInformation;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof ResultContextType.ServiceInformationList)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final ResultContextType.ServiceInformationList that = ((ResultContextType.ServiceInformationList) object);
            {
                List<ServiceInformationType> lhsServiceInformation;
                lhsServiceInformation = (((this.serviceInformation!= null)&&(!this.serviceInformation.isEmpty()))?this.getServiceInformation():null);
                List<ServiceInformationType> rhsServiceInformation;
                rhsServiceInformation = (((that.serviceInformation!= null)&&(!that.serviceInformation.isEmpty()))?that.getServiceInformation():null);
                if (!strategy.equals(LocatorUtils.property(thisLocator, "serviceInformation", lhsServiceInformation), LocatorUtils.property(thatLocator, "serviceInformation", rhsServiceInformation), lhsServiceInformation, rhsServiceInformation)) {
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
                List<ServiceInformationType> theServiceInformation;
                theServiceInformation = (((this.serviceInformation!= null)&&(!this.serviceInformation.isEmpty()))?this.getServiceInformation():null);
                strategy.appendField(locator, this, "serviceInformation", buffer, theServiceInformation);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                List<ServiceInformationType> theServiceInformation;
                theServiceInformation = (((this.serviceInformation!= null)&&(!this.serviceInformation.isEmpty()))?this.getServiceInformation():null);
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "serviceInformation", theServiceInformation), currentHashCode, theServiceInformation);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
