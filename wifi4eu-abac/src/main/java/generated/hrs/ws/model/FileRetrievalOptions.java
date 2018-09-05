
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
 * Options allowing to precise the information of a file we need to retrieve. If less information is required, the operation can result in better response times.
 * 
 * <p>Java class for FileRetrievalOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileRetrievalOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="includeDocumentFilingAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeUserFileRole" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeHasSubfiles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeRoles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeCategory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeAssociatedLeadDepartments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeSystemContainsDocuments" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeSystemHasSubfiles" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeFullPreservationMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeTransparencyMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeSystemDocumentCount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeAccessibleDocumentCount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileRetrievalOptions", propOrder = {
    "includeDocumentFilingAllowed",
    "includeUserFileRole",
    "includeHasSubfiles",
    "includeRoles",
    "includeCategory",
    "includeAssociatedLeadDepartments",
    "includeSystemContainsDocuments",
    "includeSystemHasSubfiles",
    "includeFullPreservationMetadata",
    "includeTransparencyMetadata",
    "includeSystemDocumentCount",
    "includeAccessibleDocumentCount"
})
public class FileRetrievalOptions
    implements Equals, HashCode, ToString
{

    @XmlElement(defaultValue = "false")
    protected Boolean includeDocumentFilingAllowed;
    @XmlElement(defaultValue = "false")
    protected Boolean includeUserFileRole;
    @XmlElement(defaultValue = "false")
    protected Boolean includeHasSubfiles;
    @XmlElement(defaultValue = "false")
    protected Boolean includeRoles;
    @XmlElement(defaultValue = "false")
    protected Boolean includeCategory;
    @XmlElement(defaultValue = "false")
    protected Boolean includeAssociatedLeadDepartments;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSystemContainsDocuments;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSystemHasSubfiles;
    @XmlElement(defaultValue = "false")
    protected Boolean includeFullPreservationMetadata;
    @XmlElement(defaultValue = "false")
    protected Boolean includeTransparencyMetadata;
    @XmlElement(defaultValue = "false")
    protected Boolean includeSystemDocumentCount;
    @XmlElement(defaultValue = "false")
    protected Boolean includeAccessibleDocumentCount;

    /**
     * Gets the value of the includeDocumentFilingAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeDocumentFilingAllowed() {
        return includeDocumentFilingAllowed;
    }

    /**
     * Sets the value of the includeDocumentFilingAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeDocumentFilingAllowed(Boolean value) {
        this.includeDocumentFilingAllowed = value;
    }

    /**
     * Gets the value of the includeUserFileRole property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeUserFileRole() {
        return includeUserFileRole;
    }

    /**
     * Sets the value of the includeUserFileRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeUserFileRole(Boolean value) {
        this.includeUserFileRole = value;
    }

    /**
     * Gets the value of the includeHasSubfiles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeHasSubfiles() {
        return includeHasSubfiles;
    }

    /**
     * Sets the value of the includeHasSubfiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeHasSubfiles(Boolean value) {
        this.includeHasSubfiles = value;
    }

    /**
     * Gets the value of the includeRoles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeRoles() {
        return includeRoles;
    }

    /**
     * Sets the value of the includeRoles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeRoles(Boolean value) {
        this.includeRoles = value;
    }

    /**
     * Gets the value of the includeCategory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeCategory() {
        return includeCategory;
    }

    /**
     * Sets the value of the includeCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeCategory(Boolean value) {
        this.includeCategory = value;
    }

    /**
     * Gets the value of the includeAssociatedLeadDepartments property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAssociatedLeadDepartments() {
        return includeAssociatedLeadDepartments;
    }

    /**
     * Sets the value of the includeAssociatedLeadDepartments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAssociatedLeadDepartments(Boolean value) {
        this.includeAssociatedLeadDepartments = value;
    }

    /**
     * Gets the value of the includeSystemContainsDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSystemContainsDocuments() {
        return includeSystemContainsDocuments;
    }

    /**
     * Sets the value of the includeSystemContainsDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSystemContainsDocuments(Boolean value) {
        this.includeSystemContainsDocuments = value;
    }

    /**
     * Gets the value of the includeSystemHasSubfiles property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSystemHasSubfiles() {
        return includeSystemHasSubfiles;
    }

    /**
     * Sets the value of the includeSystemHasSubfiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSystemHasSubfiles(Boolean value) {
        this.includeSystemHasSubfiles = value;
    }

    /**
     * Gets the value of the includeFullPreservationMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeFullPreservationMetadata() {
        return includeFullPreservationMetadata;
    }

    /**
     * Sets the value of the includeFullPreservationMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeFullPreservationMetadata(Boolean value) {
        this.includeFullPreservationMetadata = value;
    }

    /**
     * Gets the value of the includeTransparencyMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeTransparencyMetadata() {
        return includeTransparencyMetadata;
    }

    /**
     * Sets the value of the includeTransparencyMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeTransparencyMetadata(Boolean value) {
        this.includeTransparencyMetadata = value;
    }

    /**
     * Gets the value of the includeSystemDocumentCount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSystemDocumentCount() {
        return includeSystemDocumentCount;
    }

    /**
     * Sets the value of the includeSystemDocumentCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSystemDocumentCount(Boolean value) {
        this.includeSystemDocumentCount = value;
    }

    /**
     * Gets the value of the includeAccessibleDocumentCount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAccessibleDocumentCount() {
        return includeAccessibleDocumentCount;
    }

    /**
     * Sets the value of the includeAccessibleDocumentCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAccessibleDocumentCount(Boolean value) {
        this.includeAccessibleDocumentCount = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FileRetrievalOptions)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FileRetrievalOptions that = ((FileRetrievalOptions) object);
        {
            Boolean lhsIncludeDocumentFilingAllowed;
            lhsIncludeDocumentFilingAllowed = this.isIncludeDocumentFilingAllowed();
            Boolean rhsIncludeDocumentFilingAllowed;
            rhsIncludeDocumentFilingAllowed = that.isIncludeDocumentFilingAllowed();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeDocumentFilingAllowed", lhsIncludeDocumentFilingAllowed), LocatorUtils.property(thatLocator, "includeDocumentFilingAllowed", rhsIncludeDocumentFilingAllowed), lhsIncludeDocumentFilingAllowed, rhsIncludeDocumentFilingAllowed)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeUserFileRole;
            lhsIncludeUserFileRole = this.isIncludeUserFileRole();
            Boolean rhsIncludeUserFileRole;
            rhsIncludeUserFileRole = that.isIncludeUserFileRole();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeUserFileRole", lhsIncludeUserFileRole), LocatorUtils.property(thatLocator, "includeUserFileRole", rhsIncludeUserFileRole), lhsIncludeUserFileRole, rhsIncludeUserFileRole)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeHasSubfiles;
            lhsIncludeHasSubfiles = this.isIncludeHasSubfiles();
            Boolean rhsIncludeHasSubfiles;
            rhsIncludeHasSubfiles = that.isIncludeHasSubfiles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeHasSubfiles", lhsIncludeHasSubfiles), LocatorUtils.property(thatLocator, "includeHasSubfiles", rhsIncludeHasSubfiles), lhsIncludeHasSubfiles, rhsIncludeHasSubfiles)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeRoles;
            lhsIncludeRoles = this.isIncludeRoles();
            Boolean rhsIncludeRoles;
            rhsIncludeRoles = that.isIncludeRoles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeRoles", lhsIncludeRoles), LocatorUtils.property(thatLocator, "includeRoles", rhsIncludeRoles), lhsIncludeRoles, rhsIncludeRoles)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeCategory;
            lhsIncludeCategory = this.isIncludeCategory();
            Boolean rhsIncludeCategory;
            rhsIncludeCategory = that.isIncludeCategory();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeCategory", lhsIncludeCategory), LocatorUtils.property(thatLocator, "includeCategory", rhsIncludeCategory), lhsIncludeCategory, rhsIncludeCategory)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeAssociatedLeadDepartments;
            lhsIncludeAssociatedLeadDepartments = this.isIncludeAssociatedLeadDepartments();
            Boolean rhsIncludeAssociatedLeadDepartments;
            rhsIncludeAssociatedLeadDepartments = that.isIncludeAssociatedLeadDepartments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeAssociatedLeadDepartments", lhsIncludeAssociatedLeadDepartments), LocatorUtils.property(thatLocator, "includeAssociatedLeadDepartments", rhsIncludeAssociatedLeadDepartments), lhsIncludeAssociatedLeadDepartments, rhsIncludeAssociatedLeadDepartments)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSystemContainsDocuments;
            lhsIncludeSystemContainsDocuments = this.isIncludeSystemContainsDocuments();
            Boolean rhsIncludeSystemContainsDocuments;
            rhsIncludeSystemContainsDocuments = that.isIncludeSystemContainsDocuments();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSystemContainsDocuments", lhsIncludeSystemContainsDocuments), LocatorUtils.property(thatLocator, "includeSystemContainsDocuments", rhsIncludeSystemContainsDocuments), lhsIncludeSystemContainsDocuments, rhsIncludeSystemContainsDocuments)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSystemHasSubfiles;
            lhsIncludeSystemHasSubfiles = this.isIncludeSystemHasSubfiles();
            Boolean rhsIncludeSystemHasSubfiles;
            rhsIncludeSystemHasSubfiles = that.isIncludeSystemHasSubfiles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSystemHasSubfiles", lhsIncludeSystemHasSubfiles), LocatorUtils.property(thatLocator, "includeSystemHasSubfiles", rhsIncludeSystemHasSubfiles), lhsIncludeSystemHasSubfiles, rhsIncludeSystemHasSubfiles)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeFullPreservationMetadata;
            lhsIncludeFullPreservationMetadata = this.isIncludeFullPreservationMetadata();
            Boolean rhsIncludeFullPreservationMetadata;
            rhsIncludeFullPreservationMetadata = that.isIncludeFullPreservationMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeFullPreservationMetadata", lhsIncludeFullPreservationMetadata), LocatorUtils.property(thatLocator, "includeFullPreservationMetadata", rhsIncludeFullPreservationMetadata), lhsIncludeFullPreservationMetadata, rhsIncludeFullPreservationMetadata)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeTransparencyMetadata;
            lhsIncludeTransparencyMetadata = this.isIncludeTransparencyMetadata();
            Boolean rhsIncludeTransparencyMetadata;
            rhsIncludeTransparencyMetadata = that.isIncludeTransparencyMetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeTransparencyMetadata", lhsIncludeTransparencyMetadata), LocatorUtils.property(thatLocator, "includeTransparencyMetadata", rhsIncludeTransparencyMetadata), lhsIncludeTransparencyMetadata, rhsIncludeTransparencyMetadata)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeSystemDocumentCount;
            lhsIncludeSystemDocumentCount = this.isIncludeSystemDocumentCount();
            Boolean rhsIncludeSystemDocumentCount;
            rhsIncludeSystemDocumentCount = that.isIncludeSystemDocumentCount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeSystemDocumentCount", lhsIncludeSystemDocumentCount), LocatorUtils.property(thatLocator, "includeSystemDocumentCount", rhsIncludeSystemDocumentCount), lhsIncludeSystemDocumentCount, rhsIncludeSystemDocumentCount)) {
                return false;
            }
        }
        {
            Boolean lhsIncludeAccessibleDocumentCount;
            lhsIncludeAccessibleDocumentCount = this.isIncludeAccessibleDocumentCount();
            Boolean rhsIncludeAccessibleDocumentCount;
            rhsIncludeAccessibleDocumentCount = that.isIncludeAccessibleDocumentCount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "includeAccessibleDocumentCount", lhsIncludeAccessibleDocumentCount), LocatorUtils.property(thatLocator, "includeAccessibleDocumentCount", rhsIncludeAccessibleDocumentCount), lhsIncludeAccessibleDocumentCount, rhsIncludeAccessibleDocumentCount)) {
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
            Boolean theIncludeDocumentFilingAllowed;
            theIncludeDocumentFilingAllowed = this.isIncludeDocumentFilingAllowed();
            strategy.appendField(locator, this, "includeDocumentFilingAllowed", buffer, theIncludeDocumentFilingAllowed);
        }
        {
            Boolean theIncludeUserFileRole;
            theIncludeUserFileRole = this.isIncludeUserFileRole();
            strategy.appendField(locator, this, "includeUserFileRole", buffer, theIncludeUserFileRole);
        }
        {
            Boolean theIncludeHasSubfiles;
            theIncludeHasSubfiles = this.isIncludeHasSubfiles();
            strategy.appendField(locator, this, "includeHasSubfiles", buffer, theIncludeHasSubfiles);
        }
        {
            Boolean theIncludeRoles;
            theIncludeRoles = this.isIncludeRoles();
            strategy.appendField(locator, this, "includeRoles", buffer, theIncludeRoles);
        }
        {
            Boolean theIncludeCategory;
            theIncludeCategory = this.isIncludeCategory();
            strategy.appendField(locator, this, "includeCategory", buffer, theIncludeCategory);
        }
        {
            Boolean theIncludeAssociatedLeadDepartments;
            theIncludeAssociatedLeadDepartments = this.isIncludeAssociatedLeadDepartments();
            strategy.appendField(locator, this, "includeAssociatedLeadDepartments", buffer, theIncludeAssociatedLeadDepartments);
        }
        {
            Boolean theIncludeSystemContainsDocuments;
            theIncludeSystemContainsDocuments = this.isIncludeSystemContainsDocuments();
            strategy.appendField(locator, this, "includeSystemContainsDocuments", buffer, theIncludeSystemContainsDocuments);
        }
        {
            Boolean theIncludeSystemHasSubfiles;
            theIncludeSystemHasSubfiles = this.isIncludeSystemHasSubfiles();
            strategy.appendField(locator, this, "includeSystemHasSubfiles", buffer, theIncludeSystemHasSubfiles);
        }
        {
            Boolean theIncludeFullPreservationMetadata;
            theIncludeFullPreservationMetadata = this.isIncludeFullPreservationMetadata();
            strategy.appendField(locator, this, "includeFullPreservationMetadata", buffer, theIncludeFullPreservationMetadata);
        }
        {
            Boolean theIncludeTransparencyMetadata;
            theIncludeTransparencyMetadata = this.isIncludeTransparencyMetadata();
            strategy.appendField(locator, this, "includeTransparencyMetadata", buffer, theIncludeTransparencyMetadata);
        }
        {
            Boolean theIncludeSystemDocumentCount;
            theIncludeSystemDocumentCount = this.isIncludeSystemDocumentCount();
            strategy.appendField(locator, this, "includeSystemDocumentCount", buffer, theIncludeSystemDocumentCount);
        }
        {
            Boolean theIncludeAccessibleDocumentCount;
            theIncludeAccessibleDocumentCount = this.isIncludeAccessibleDocumentCount();
            strategy.appendField(locator, this, "includeAccessibleDocumentCount", buffer, theIncludeAccessibleDocumentCount);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Boolean theIncludeDocumentFilingAllowed;
            theIncludeDocumentFilingAllowed = this.isIncludeDocumentFilingAllowed();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeDocumentFilingAllowed", theIncludeDocumentFilingAllowed), currentHashCode, theIncludeDocumentFilingAllowed);
        }
        {
            Boolean theIncludeUserFileRole;
            theIncludeUserFileRole = this.isIncludeUserFileRole();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeUserFileRole", theIncludeUserFileRole), currentHashCode, theIncludeUserFileRole);
        }
        {
            Boolean theIncludeHasSubfiles;
            theIncludeHasSubfiles = this.isIncludeHasSubfiles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeHasSubfiles", theIncludeHasSubfiles), currentHashCode, theIncludeHasSubfiles);
        }
        {
            Boolean theIncludeRoles;
            theIncludeRoles = this.isIncludeRoles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeRoles", theIncludeRoles), currentHashCode, theIncludeRoles);
        }
        {
            Boolean theIncludeCategory;
            theIncludeCategory = this.isIncludeCategory();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeCategory", theIncludeCategory), currentHashCode, theIncludeCategory);
        }
        {
            Boolean theIncludeAssociatedLeadDepartments;
            theIncludeAssociatedLeadDepartments = this.isIncludeAssociatedLeadDepartments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeAssociatedLeadDepartments", theIncludeAssociatedLeadDepartments), currentHashCode, theIncludeAssociatedLeadDepartments);
        }
        {
            Boolean theIncludeSystemContainsDocuments;
            theIncludeSystemContainsDocuments = this.isIncludeSystemContainsDocuments();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSystemContainsDocuments", theIncludeSystemContainsDocuments), currentHashCode, theIncludeSystemContainsDocuments);
        }
        {
            Boolean theIncludeSystemHasSubfiles;
            theIncludeSystemHasSubfiles = this.isIncludeSystemHasSubfiles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSystemHasSubfiles", theIncludeSystemHasSubfiles), currentHashCode, theIncludeSystemHasSubfiles);
        }
        {
            Boolean theIncludeFullPreservationMetadata;
            theIncludeFullPreservationMetadata = this.isIncludeFullPreservationMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeFullPreservationMetadata", theIncludeFullPreservationMetadata), currentHashCode, theIncludeFullPreservationMetadata);
        }
        {
            Boolean theIncludeTransparencyMetadata;
            theIncludeTransparencyMetadata = this.isIncludeTransparencyMetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeTransparencyMetadata", theIncludeTransparencyMetadata), currentHashCode, theIncludeTransparencyMetadata);
        }
        {
            Boolean theIncludeSystemDocumentCount;
            theIncludeSystemDocumentCount = this.isIncludeSystemDocumentCount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeSystemDocumentCount", theIncludeSystemDocumentCount), currentHashCode, theIncludeSystemDocumentCount);
        }
        {
            Boolean theIncludeAccessibleDocumentCount;
            theIncludeAccessibleDocumentCount = this.isIncludeAccessibleDocumentCount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "includeAccessibleDocumentCount", theIncludeAccessibleDocumentCount), currentHashCode, theIncludeAccessibleDocumentCount);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
