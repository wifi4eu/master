
package generated.hrs.ws.model;

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
 * Options allowing to precise the parts of a document we need to retrieve. It allows client applications to define which metadata to retrieve for a document.
 * 
 * <p>Java class for DocumentRetrievalOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentRetrievalOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="includeItemsMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *           &lt;element name="includeItemsAndVersionsMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="includeSendersAndRecipientsMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *           &lt;sequence>
 *             &lt;element name="includeSenders" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *             &lt;element name="includeRecipients" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="includeSendersRecipientsValidationForRegistration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeFilingInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeLinks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeAssignmentWorkflow" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeSignatoryWorkflow" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="limitTasksToCurrentUser" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="limitTasksToActiveTasks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeProcedure" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeSignedBy" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeExternalizationDetails" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeSpecificMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeSpecificMetadataItemsMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeExternalSignatures" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeAccessibilityInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeSignatoryWorkflowSupportingItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentRetrievalOptions", propOrder = {
    "includeItemsMetadata",
    "includeItemsAndVersionsMetadata",
    "includeSendersAndRecipientsMetadata",
    "includeSenders",
    "includeRecipients",
    "includeSendersRecipientsValidationForRegistration",
    "includeFilingInfo",
    "includeLinks",
    "includeAssignmentWorkflow",
    "includeSignatoryWorkflow",
    "limitTasksToCurrentUser",
    "limitTasksToActiveTasks",
    "includeProcedure",
    "includeSignedBy",
    "includeExternalizationDetails",
    "includeSpecificMetadata",
    "includeSpecificMetadataItemsMetadata",
    "includeExternalSignatures",
    "includeAccessibilityInfo",
    "includeSignatoryWorkflowSupportingItems"
})
public class DocumentRetrievalOptions
    implements Equals, HashCode, ToString
{

    @XmlElement(defaultValue = "false")
    protected Boolean includeItemsMetadata;
    @XmlElement(defaultValue = "false")
    protected Boolean includeItemsAndVersionsMetadata;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSendersAndRecipientsMetadata;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSenders;
    @XmlElement(defaultValue = "false")
    protected Boolean includeRecipients;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSendersRecipientsValidationForRegistration;
    @XmlElement(defaultValue = "false")
    protected Boolean includeFilingInfo;
    @XmlElement(defaultValue = "false")
    protected Boolean includeLinks;
    @XmlElement(defaultValue = "false")
    protected Boolean includeAssignmentWorkflow;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSignatoryWorkflow;
    @XmlElement(defaultValue = "false")
    protected Boolean limitTasksToCurrentUser;
    @XmlElement(defaultValue = "false")
    protected Boolean limitTasksToActiveTasks;
    @XmlElement(defaultValue = "false")
    protected Boolean includeProcedure;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSignedBy;
    @XmlElement(defaultValue = "false")
    protected Boolean includeExternalizationDetails;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSpecificMetadata;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSpecificMetadataItemsMetadata;
    @XmlElement(defaultValue = "false")
    protected Boolean includeExternalSignatures;
    @XmlElement(defaultValue = "false")
    protected Boolean includeAccessibilityInfo;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSignatoryWorkflowSupportingItems;

    /**
     * Gets the value of the includeItemsMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeItemsMetadata() {
        return includeItemsMetadata;
    }

    /**
     * Sets the value of the includeItemsMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeItemsMetadata(Boolean value) {
        this.includeItemsMetadata = value;
    }

    /**
     * Gets the value of the includeItemsAndVersionsMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeItemsAndVersionsMetadata() {
        return includeItemsAndVersionsMetadata;
    }

    /**
     * Sets the value of the includeItemsAndVersionsMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeItemsAndVersionsMetadata(Boolean value) {
        this.includeItemsAndVersionsMetadata = value;
    }

    /**
     * Gets the value of the includeSendersAndRecipientsMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSendersAndRecipientsMetadata() {
        return includeSendersAndRecipientsMetadata;
    }

    /**
     * Sets the value of the includeSendersAndRecipientsMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSendersAndRecipientsMetadata(Boolean value) {
        this.includeSendersAndRecipientsMetadata = value;
    }

    /**
     * Gets the value of the includeSenders property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSenders() {
        return includeSenders;
    }

    /**
     * Sets the value of the includeSenders property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSenders(Boolean value) {
        this.includeSenders = value;
    }

    /**
     * Gets the value of the includeRecipients property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeRecipients() {
        return includeRecipients;
    }

    /**
     * Sets the value of the includeRecipients property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeRecipients(Boolean value) {
        this.includeRecipients = value;
    }

    /**
     * Gets the value of the includeSendersRecipientsValidationForRegistration property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSendersRecipientsValidationForRegistration() {
        return includeSendersRecipientsValidationForRegistration;
    }

    /**
     * Sets the value of the includeSendersRecipientsValidationForRegistration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSendersRecipientsValidationForRegistration(Boolean value) {
        this.includeSendersRecipientsValidationForRegistration = value;
    }

    /**
     * Gets the value of the includeFilingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeFilingInfo() {
        return includeFilingInfo;
    }

    /**
     * Sets the value of the includeFilingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeFilingInfo(Boolean value) {
        this.includeFilingInfo = value;
    }

    /**
     * Gets the value of the includeLinks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeLinks() {
        return includeLinks;
    }

    /**
     * Sets the value of the includeLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeLinks(Boolean value) {
        this.includeLinks = value;
    }

    /**
     * Gets the value of the includeAssignmentWorkflow property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAssignmentWorkflow() {
        return includeAssignmentWorkflow;
    }

    /**
     * Sets the value of the includeAssignmentWorkflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAssignmentWorkflow(Boolean value) {
        this.includeAssignmentWorkflow = value;
    }

    /**
     * Gets the value of the includeSignatoryWorkflow property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSignatoryWorkflow() {
        return includeSignatoryWorkflow;
    }

    /**
     * Sets the value of the includeSignatoryWorkflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSignatoryWorkflow(Boolean value) {
        this.includeSignatoryWorkflow = value;
    }

    /**
     * Gets the value of the limitTasksToCurrentUser property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLimitTasksToCurrentUser() {
        return limitTasksToCurrentUser;
    }

    /**
     * Sets the value of the limitTasksToCurrentUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLimitTasksToCurrentUser(Boolean value) {
        this.limitTasksToCurrentUser = value;
    }

    /**
     * Gets the value of the limitTasksToActiveTasks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLimitTasksToActiveTasks() {
        return limitTasksToActiveTasks;
    }

    /**
     * Sets the value of the limitTasksToActiveTasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLimitTasksToActiveTasks(Boolean value) {
        this.limitTasksToActiveTasks = value;
    }

    /**
     * Gets the value of the includeProcedure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeProcedure() {
        return includeProcedure;
    }

    /**
     * Sets the value of the includeProcedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeProcedure(Boolean value) {
        this.includeProcedure = value;
    }

    /**
     * Gets the value of the includeSignedBy property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSignedBy() {
        return includeSignedBy;
    }

    /**
     * Sets the value of the includeSignedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSignedBy(Boolean value) {
        this.includeSignedBy = value;
    }

    /**
     * Gets the value of the includeExternalizationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeExternalizationDetails() {
        return includeExternalizationDetails;
    }

    /**
     * Sets the value of the includeExternalizationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeExternalizationDetails(Boolean value) {
        this.includeExternalizationDetails = value;
    }

    /**
     * Gets the value of the includeSpecificMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSpecificMetadata() {
        return includeSpecificMetadata;
    }

    /**
     * Sets the value of the includeSpecificMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSpecificMetadata(Boolean value) {
        this.includeSpecificMetadata = value;
    }

    /**
     * Gets the value of the includeSpecificMetadataItemsMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSpecificMetadataItemsMetadata() {
        return includeSpecificMetadataItemsMetadata;
    }

    /**
     * Sets the value of the includeSpecificMetadataItemsMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSpecificMetadataItemsMetadata(Boolean value) {
        this.includeSpecificMetadataItemsMetadata = value;
    }

    /**
     * Gets the value of the includeExternalSignatures property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeExternalSignatures() {
        return includeExternalSignatures;
    }

    /**
     * Sets the value of the includeExternalSignatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeExternalSignatures(Boolean value) {
        this.includeExternalSignatures = value;
    }

    /**
     * Gets the value of the includeAccessibilityInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAccessibilityInfo() {
        return includeAccessibilityInfo;
    }

    /**
     * Sets the value of the includeAccessibilityInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAccessibilityInfo(Boolean value) {
        this.includeAccessibilityInfo = value;
    }

    /**
     * Gets the value of the includeSignatoryWorkflowSupportingItems property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSignatoryWorkflowSupportingItems() {
        return includeSignatoryWorkflowSupportingItems;
    }

    /**
     * Sets the value of the includeSignatoryWorkflowSupportingItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSignatoryWorkflowSupportingItems(Boolean value) {
        this.includeSignatoryWorkflowSupportingItems = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DocumentRetrievalOptions)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DocumentRetrievalOptions that = ((DocumentRetrievalOptions) object);
        {
            Boolean lhsIncludeItemsMetadata;
            lhsIncludeItemsMetadata = this.isIncludeItemsMetadata();
            Boolean rhsIncludeItemsMetadata;
            rhsIncludeItemsMetadata = that.isIncludeItemsMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeItemsMetadata", lhsIncludeItemsMetadata), LocatorUtils.property(thatLocator, "includeItemsMetadata", rhsIncludeItemsMetadata), lhsIncludeItemsMetadata, rhsIncludeItemsMetadata)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeItemsAndVersionsMetadata;
            lhsIncludeItemsAndVersionsMetadata = this.isIncludeItemsAndVersionsMetadata();
            Boolean rhsIncludeItemsAndVersionsMetadata;
            rhsIncludeItemsAndVersionsMetadata = that.isIncludeItemsAndVersionsMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeItemsAndVersionsMetadata", lhsIncludeItemsAndVersionsMetadata), LocatorUtils.property(thatLocator, "includeItemsAndVersionsMetadata", rhsIncludeItemsAndVersionsMetadata), lhsIncludeItemsAndVersionsMetadata, rhsIncludeItemsAndVersionsMetadata)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSendersAndRecipientsMetadata;
            lhsIncludeSendersAndRecipientsMetadata = this.isIncludeSendersAndRecipientsMetadata();
            Boolean rhsIncludeSendersAndRecipientsMetadata;
            rhsIncludeSendersAndRecipientsMetadata = that.isIncludeSendersAndRecipientsMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSendersAndRecipientsMetadata", lhsIncludeSendersAndRecipientsMetadata), LocatorUtils.property(thatLocator, "includeSendersAndRecipientsMetadata", rhsIncludeSendersAndRecipientsMetadata), lhsIncludeSendersAndRecipientsMetadata, rhsIncludeSendersAndRecipientsMetadata)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSenders;
            lhsIncludeSenders = this.isIncludeSenders();
            Boolean rhsIncludeSenders;
            rhsIncludeSenders = that.isIncludeSenders();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSenders", lhsIncludeSenders), LocatorUtils.property(thatLocator, "includeSenders", rhsIncludeSenders), lhsIncludeSenders, rhsIncludeSenders)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeRecipients;
            lhsIncludeRecipients = this.isIncludeRecipients();
            Boolean rhsIncludeRecipients;
            rhsIncludeRecipients = that.isIncludeRecipients();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeRecipients", lhsIncludeRecipients), LocatorUtils.property(thatLocator, "includeRecipients", rhsIncludeRecipients), lhsIncludeRecipients, rhsIncludeRecipients)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSendersRecipientsValidationForRegistration;
            lhsIncludeSendersRecipientsValidationForRegistration = this.isIncludeSendersRecipientsValidationForRegistration();
            Boolean rhsIncludeSendersRecipientsValidationForRegistration;
            rhsIncludeSendersRecipientsValidationForRegistration = that.isIncludeSendersRecipientsValidationForRegistration();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSendersRecipientsValidationForRegistration", lhsIncludeSendersRecipientsValidationForRegistration), LocatorUtils.property(thatLocator, "includeSendersRecipientsValidationForRegistration", rhsIncludeSendersRecipientsValidationForRegistration), lhsIncludeSendersRecipientsValidationForRegistration, rhsIncludeSendersRecipientsValidationForRegistration)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeFilingInfo;
            lhsIncludeFilingInfo = this.isIncludeFilingInfo();
            Boolean rhsIncludeFilingInfo;
            rhsIncludeFilingInfo = that.isIncludeFilingInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeFilingInfo", lhsIncludeFilingInfo), LocatorUtils.property(thatLocator, "includeFilingInfo", rhsIncludeFilingInfo), lhsIncludeFilingInfo, rhsIncludeFilingInfo)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeLinks;
            lhsIncludeLinks = this.isIncludeLinks();
            Boolean rhsIncludeLinks;
            rhsIncludeLinks = that.isIncludeLinks();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeLinks", lhsIncludeLinks), LocatorUtils.property(thatLocator, "includeLinks", rhsIncludeLinks), lhsIncludeLinks, rhsIncludeLinks)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeAssignmentWorkflow;
            lhsIncludeAssignmentWorkflow = this.isIncludeAssignmentWorkflow();
            Boolean rhsIncludeAssignmentWorkflow;
            rhsIncludeAssignmentWorkflow = that.isIncludeAssignmentWorkflow();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeAssignmentWorkflow", lhsIncludeAssignmentWorkflow), LocatorUtils.property(thatLocator, "includeAssignmentWorkflow", rhsIncludeAssignmentWorkflow), lhsIncludeAssignmentWorkflow, rhsIncludeAssignmentWorkflow)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSignatoryWorkflow;
            lhsIncludeSignatoryWorkflow = this.isIncludeSignatoryWorkflow();
            Boolean rhsIncludeSignatoryWorkflow;
            rhsIncludeSignatoryWorkflow = that.isIncludeSignatoryWorkflow();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSignatoryWorkflow", lhsIncludeSignatoryWorkflow), LocatorUtils.property(thatLocator, "includeSignatoryWorkflow", rhsIncludeSignatoryWorkflow), lhsIncludeSignatoryWorkflow, rhsIncludeSignatoryWorkflow)) {
                return false;
            }
        }
        {
            Boolean lhsLimitTasksToCurrentUser;
            lhsLimitTasksToCurrentUser = this.isLimitTasksToCurrentUser();
            Boolean rhsLimitTasksToCurrentUser;
            rhsLimitTasksToCurrentUser = that.isLimitTasksToCurrentUser();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "limitTasksToCurrentUser", lhsLimitTasksToCurrentUser), LocatorUtils.property(thatLocator, "limitTasksToCurrentUser", rhsLimitTasksToCurrentUser), lhsLimitTasksToCurrentUser, rhsLimitTasksToCurrentUser)) {
                return false;
            }
        }
        {
            Boolean lhsLimitTasksToActiveTasks;
            lhsLimitTasksToActiveTasks = this.isLimitTasksToActiveTasks();
            Boolean rhsLimitTasksToActiveTasks;
            rhsLimitTasksToActiveTasks = that.isLimitTasksToActiveTasks();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "limitTasksToActiveTasks", lhsLimitTasksToActiveTasks), LocatorUtils.property(thatLocator, "limitTasksToActiveTasks", rhsLimitTasksToActiveTasks), lhsLimitTasksToActiveTasks, rhsLimitTasksToActiveTasks)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeProcedure;
            lhsIncludeProcedure = this.isIncludeProcedure();
            Boolean rhsIncludeProcedure;
            rhsIncludeProcedure = that.isIncludeProcedure();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeProcedure", lhsIncludeProcedure), LocatorUtils.property(thatLocator, "includeProcedure", rhsIncludeProcedure), lhsIncludeProcedure, rhsIncludeProcedure)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSignedBy;
            lhsIncludeSignedBy = this.isIncludeSignedBy();
            Boolean rhsIncludeSignedBy;
            rhsIncludeSignedBy = that.isIncludeSignedBy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSignedBy", lhsIncludeSignedBy), LocatorUtils.property(thatLocator, "includeSignedBy", rhsIncludeSignedBy), lhsIncludeSignedBy, rhsIncludeSignedBy)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeExternalizationDetails;
            lhsIncludeExternalizationDetails = this.isIncludeExternalizationDetails();
            Boolean rhsIncludeExternalizationDetails;
            rhsIncludeExternalizationDetails = that.isIncludeExternalizationDetails();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeExternalizationDetails", lhsIncludeExternalizationDetails), LocatorUtils.property(thatLocator, "includeExternalizationDetails", rhsIncludeExternalizationDetails), lhsIncludeExternalizationDetails, rhsIncludeExternalizationDetails)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSpecificMetadata;
            lhsIncludeSpecificMetadata = this.isIncludeSpecificMetadata();
            Boolean rhsIncludeSpecificMetadata;
            rhsIncludeSpecificMetadata = that.isIncludeSpecificMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSpecificMetadata", lhsIncludeSpecificMetadata), LocatorUtils.property(thatLocator, "includeSpecificMetadata", rhsIncludeSpecificMetadata), lhsIncludeSpecificMetadata, rhsIncludeSpecificMetadata)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSpecificMetadataItemsMetadata;
            lhsIncludeSpecificMetadataItemsMetadata = this.isIncludeSpecificMetadataItemsMetadata();
            Boolean rhsIncludeSpecificMetadataItemsMetadata;
            rhsIncludeSpecificMetadataItemsMetadata = that.isIncludeSpecificMetadataItemsMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSpecificMetadataItemsMetadata", lhsIncludeSpecificMetadataItemsMetadata), LocatorUtils.property(thatLocator, "includeSpecificMetadataItemsMetadata", rhsIncludeSpecificMetadataItemsMetadata), lhsIncludeSpecificMetadataItemsMetadata, rhsIncludeSpecificMetadataItemsMetadata)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeExternalSignatures;
            lhsIncludeExternalSignatures = this.isIncludeExternalSignatures();
            Boolean rhsIncludeExternalSignatures;
            rhsIncludeExternalSignatures = that.isIncludeExternalSignatures();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeExternalSignatures", lhsIncludeExternalSignatures), LocatorUtils.property(thatLocator, "includeExternalSignatures", rhsIncludeExternalSignatures), lhsIncludeExternalSignatures, rhsIncludeExternalSignatures)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeAccessibilityInfo;
            lhsIncludeAccessibilityInfo = this.isIncludeAccessibilityInfo();
            Boolean rhsIncludeAccessibilityInfo;
            rhsIncludeAccessibilityInfo = that.isIncludeAccessibilityInfo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeAccessibilityInfo", lhsIncludeAccessibilityInfo), LocatorUtils.property(thatLocator, "includeAccessibilityInfo", rhsIncludeAccessibilityInfo), lhsIncludeAccessibilityInfo, rhsIncludeAccessibilityInfo)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSignatoryWorkflowSupportingItems;
            lhsIncludeSignatoryWorkflowSupportingItems = this.isIncludeSignatoryWorkflowSupportingItems();
            Boolean rhsIncludeSignatoryWorkflowSupportingItems;
            rhsIncludeSignatoryWorkflowSupportingItems = that.isIncludeSignatoryWorkflowSupportingItems();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSignatoryWorkflowSupportingItems", lhsIncludeSignatoryWorkflowSupportingItems), LocatorUtils.property(thatLocator, "includeSignatoryWorkflowSupportingItems", rhsIncludeSignatoryWorkflowSupportingItems), lhsIncludeSignatoryWorkflowSupportingItems, rhsIncludeSignatoryWorkflowSupportingItems)) {
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
            Boolean theIncludeItemsMetadata;
            theIncludeItemsMetadata = this.isIncludeItemsMetadata();
            strategy.appendField(locator, this, "includeItemsMetadata", buffer, theIncludeItemsMetadata);
        }
        {
            Boolean theIncludeItemsAndVersionsMetadata;
            theIncludeItemsAndVersionsMetadata = this.isIncludeItemsAndVersionsMetadata();
            strategy.appendField(locator, this, "includeItemsAndVersionsMetadata", buffer, theIncludeItemsAndVersionsMetadata);
        }
        {
            Boolean theIncludeSendersAndRecipientsMetadata;
            theIncludeSendersAndRecipientsMetadata = this.isIncludeSendersAndRecipientsMetadata();
            strategy.appendField(locator, this, "includeSendersAndRecipientsMetadata", buffer, theIncludeSendersAndRecipientsMetadata);
        }
        {
            Boolean theIncludeSenders;
            theIncludeSenders = this.isIncludeSenders();
            strategy.appendField(locator, this, "includeSenders", buffer, theIncludeSenders);
        }
        {
            Boolean theIncludeRecipients;
            theIncludeRecipients = this.isIncludeRecipients();
            strategy.appendField(locator, this, "includeRecipients", buffer, theIncludeRecipients);
        }
        {
            Boolean theIncludeSendersRecipientsValidationForRegistration;
            theIncludeSendersRecipientsValidationForRegistration = this.isIncludeSendersRecipientsValidationForRegistration();
            strategy.appendField(locator, this, "includeSendersRecipientsValidationForRegistration", buffer, theIncludeSendersRecipientsValidationForRegistration);
        }
        {
            Boolean theIncludeFilingInfo;
            theIncludeFilingInfo = this.isIncludeFilingInfo();
            strategy.appendField(locator, this, "includeFilingInfo", buffer, theIncludeFilingInfo);
        }
        {
            Boolean theIncludeLinks;
            theIncludeLinks = this.isIncludeLinks();
            strategy.appendField(locator, this, "includeLinks", buffer, theIncludeLinks);
        }
        {
            Boolean theIncludeAssignmentWorkflow;
            theIncludeAssignmentWorkflow = this.isIncludeAssignmentWorkflow();
            strategy.appendField(locator, this, "includeAssignmentWorkflow", buffer, theIncludeAssignmentWorkflow);
        }
        {
            Boolean theIncludeSignatoryWorkflow;
            theIncludeSignatoryWorkflow = this.isIncludeSignatoryWorkflow();
            strategy.appendField(locator, this, "includeSignatoryWorkflow", buffer, theIncludeSignatoryWorkflow);
        }
        {
            Boolean theLimitTasksToCurrentUser;
            theLimitTasksToCurrentUser = this.isLimitTasksToCurrentUser();
            strategy.appendField(locator, this, "limitTasksToCurrentUser", buffer, theLimitTasksToCurrentUser);
        }
        {
            Boolean theLimitTasksToActiveTasks;
            theLimitTasksToActiveTasks = this.isLimitTasksToActiveTasks();
            strategy.appendField(locator, this, "limitTasksToActiveTasks", buffer, theLimitTasksToActiveTasks);
        }
        {
            Boolean theIncludeProcedure;
            theIncludeProcedure = this.isIncludeProcedure();
            strategy.appendField(locator, this, "includeProcedure", buffer, theIncludeProcedure);
        }
        {
            Boolean theIncludeSignedBy;
            theIncludeSignedBy = this.isIncludeSignedBy();
            strategy.appendField(locator, this, "includeSignedBy", buffer, theIncludeSignedBy);
        }
        {
            Boolean theIncludeExternalizationDetails;
            theIncludeExternalizationDetails = this.isIncludeExternalizationDetails();
            strategy.appendField(locator, this, "includeExternalizationDetails", buffer, theIncludeExternalizationDetails);
        }
        {
            Boolean theIncludeSpecificMetadata;
            theIncludeSpecificMetadata = this.isIncludeSpecificMetadata();
            strategy.appendField(locator, this, "includeSpecificMetadata", buffer, theIncludeSpecificMetadata);
        }
        {
            Boolean theIncludeSpecificMetadataItemsMetadata;
            theIncludeSpecificMetadataItemsMetadata = this.isIncludeSpecificMetadataItemsMetadata();
            strategy.appendField(locator, this, "includeSpecificMetadataItemsMetadata", buffer, theIncludeSpecificMetadataItemsMetadata);
        }
        {
            Boolean theIncludeExternalSignatures;
            theIncludeExternalSignatures = this.isIncludeExternalSignatures();
            strategy.appendField(locator, this, "includeExternalSignatures", buffer, theIncludeExternalSignatures);
        }
        {
            Boolean theIncludeAccessibilityInfo;
            theIncludeAccessibilityInfo = this.isIncludeAccessibilityInfo();
            strategy.appendField(locator, this, "includeAccessibilityInfo", buffer, theIncludeAccessibilityInfo);
        }
        {
            Boolean theIncludeSignatoryWorkflowSupportingItems;
            theIncludeSignatoryWorkflowSupportingItems = this.isIncludeSignatoryWorkflowSupportingItems();
            strategy.appendField(locator, this, "includeSignatoryWorkflowSupportingItems", buffer, theIncludeSignatoryWorkflowSupportingItems);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Boolean theIncludeItemsMetadata;
            theIncludeItemsMetadata = this.isIncludeItemsMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeItemsMetadata", theIncludeItemsMetadata), currentHashCode, theIncludeItemsMetadata);
        }
        {
            Boolean theIncludeItemsAndVersionsMetadata;
            theIncludeItemsAndVersionsMetadata = this.isIncludeItemsAndVersionsMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeItemsAndVersionsMetadata", theIncludeItemsAndVersionsMetadata), currentHashCode, theIncludeItemsAndVersionsMetadata);
        }
        {
            Boolean theIncludeSendersAndRecipientsMetadata;
            theIncludeSendersAndRecipientsMetadata = this.isIncludeSendersAndRecipientsMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSendersAndRecipientsMetadata", theIncludeSendersAndRecipientsMetadata), currentHashCode, theIncludeSendersAndRecipientsMetadata);
        }
        {
            Boolean theIncludeSenders;
            theIncludeSenders = this.isIncludeSenders();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSenders", theIncludeSenders), currentHashCode, theIncludeSenders);
        }
        {
            Boolean theIncludeRecipients;
            theIncludeRecipients = this.isIncludeRecipients();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeRecipients", theIncludeRecipients), currentHashCode, theIncludeRecipients);
        }
        {
            Boolean theIncludeSendersRecipientsValidationForRegistration;
            theIncludeSendersRecipientsValidationForRegistration = this.isIncludeSendersRecipientsValidationForRegistration();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSendersRecipientsValidationForRegistration", theIncludeSendersRecipientsValidationForRegistration), currentHashCode, theIncludeSendersRecipientsValidationForRegistration);
        }
        {
            Boolean theIncludeFilingInfo;
            theIncludeFilingInfo = this.isIncludeFilingInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeFilingInfo", theIncludeFilingInfo), currentHashCode, theIncludeFilingInfo);
        }
        {
            Boolean theIncludeLinks;
            theIncludeLinks = this.isIncludeLinks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeLinks", theIncludeLinks), currentHashCode, theIncludeLinks);
        }
        {
            Boolean theIncludeAssignmentWorkflow;
            theIncludeAssignmentWorkflow = this.isIncludeAssignmentWorkflow();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeAssignmentWorkflow", theIncludeAssignmentWorkflow), currentHashCode, theIncludeAssignmentWorkflow);
        }
        {
            Boolean theIncludeSignatoryWorkflow;
            theIncludeSignatoryWorkflow = this.isIncludeSignatoryWorkflow();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSignatoryWorkflow", theIncludeSignatoryWorkflow), currentHashCode, theIncludeSignatoryWorkflow);
        }
        {
            Boolean theLimitTasksToCurrentUser;
            theLimitTasksToCurrentUser = this.isLimitTasksToCurrentUser();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "limitTasksToCurrentUser", theLimitTasksToCurrentUser), currentHashCode, theLimitTasksToCurrentUser);
        }
        {
            Boolean theLimitTasksToActiveTasks;
            theLimitTasksToActiveTasks = this.isLimitTasksToActiveTasks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "limitTasksToActiveTasks", theLimitTasksToActiveTasks), currentHashCode, theLimitTasksToActiveTasks);
        }
        {
            Boolean theIncludeProcedure;
            theIncludeProcedure = this.isIncludeProcedure();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeProcedure", theIncludeProcedure), currentHashCode, theIncludeProcedure);
        }
        {
            Boolean theIncludeSignedBy;
            theIncludeSignedBy = this.isIncludeSignedBy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSignedBy", theIncludeSignedBy), currentHashCode, theIncludeSignedBy);
        }
        {
            Boolean theIncludeExternalizationDetails;
            theIncludeExternalizationDetails = this.isIncludeExternalizationDetails();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeExternalizationDetails", theIncludeExternalizationDetails), currentHashCode, theIncludeExternalizationDetails);
        }
        {
            Boolean theIncludeSpecificMetadata;
            theIncludeSpecificMetadata = this.isIncludeSpecificMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSpecificMetadata", theIncludeSpecificMetadata), currentHashCode, theIncludeSpecificMetadata);
        }
        {
            Boolean theIncludeSpecificMetadataItemsMetadata;
            theIncludeSpecificMetadataItemsMetadata = this.isIncludeSpecificMetadataItemsMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSpecificMetadataItemsMetadata", theIncludeSpecificMetadataItemsMetadata), currentHashCode, theIncludeSpecificMetadataItemsMetadata);
        }
        {
            Boolean theIncludeExternalSignatures;
            theIncludeExternalSignatures = this.isIncludeExternalSignatures();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeExternalSignatures", theIncludeExternalSignatures), currentHashCode, theIncludeExternalSignatures);
        }
        {
            Boolean theIncludeAccessibilityInfo;
            theIncludeAccessibilityInfo = this.isIncludeAccessibilityInfo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeAccessibilityInfo", theIncludeAccessibilityInfo), currentHashCode, theIncludeAccessibilityInfo);
        }
        {
            Boolean theIncludeSignatoryWorkflowSupportingItems;
            theIncludeSignatoryWorkflowSupportingItems = this.isIncludeSignatoryWorkflowSupportingItems();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSignatoryWorkflowSupportingItems", theIncludeSignatoryWorkflowSupportingItems), currentHashCode, theIncludeSignatoryWorkflowSupportingItems);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
