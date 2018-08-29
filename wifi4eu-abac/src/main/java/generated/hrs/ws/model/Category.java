
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
 * A category
 * 
 * <p>Java class for Category complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Category">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categoryId" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="categoryKey" type="{http://ec.europa.eu/sg/hrs/types}ObjectId"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="englishName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="frenchName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://ec.europa.eu/sg/hrs/types}CategoryType" minOccurs="0"/>
 *         &lt;element name="status" type="{http://ec.europa.eu/sg/hrs/types}CategoryStatus"/>
 *         &lt;element name="englishDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishObservations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frenchObservations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Category", propOrder = {
    "categoryId",
    "categoryKey",
    "code",
    "englishName",
    "frenchName",
    "version",
    "type",
    "status",
    "englishDescription",
    "frenchDescription",
    "englishObservations",
    "frenchObservations"
})
public class Category
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String categoryId;
    @XmlElement(required = true)
    protected String categoryKey;
    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String englishName;
    @XmlElement(required = true)
    protected String frenchName;
    protected int version;
    protected CategoryType type;
    @XmlElement(required = true)
    protected CategoryStatus status;
    protected String englishDescription;
    protected String frenchDescription;
    protected String englishObservations;
    protected String frenchObservations;

    /**
     * Gets the value of the categoryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the value of the categoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryId(String value) {
        this.categoryId = value;
    }

    /**
     * Gets the value of the categoryKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryKey() {
        return categoryKey;
    }

    /**
     * Sets the value of the categoryKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryKey(String value) {
        this.categoryKey = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the englishName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * Sets the value of the englishName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishName(String value) {
        this.englishName = value;
    }

    /**
     * Gets the value of the frenchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrenchName() {
        return frenchName;
    }

    /**
     * Sets the value of the frenchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrenchName(String value) {
        this.frenchName = value;
    }

    /**
     * Gets the value of the version property.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryType }
     *     
     */
    public CategoryType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryType }
     *     
     */
    public void setType(CategoryType value) {
        this.type = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryStatus }
     *     
     */
    public CategoryStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryStatus }
     *     
     */
    public void setStatus(CategoryStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the englishDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishDescription() {
        return englishDescription;
    }

    /**
     * Sets the value of the englishDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishDescription(String value) {
        this.englishDescription = value;
    }

    /**
     * Gets the value of the frenchDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrenchDescription() {
        return frenchDescription;
    }

    /**
     * Sets the value of the frenchDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrenchDescription(String value) {
        this.frenchDescription = value;
    }

    /**
     * Gets the value of the englishObservations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishObservations() {
        return englishObservations;
    }

    /**
     * Sets the value of the englishObservations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishObservations(String value) {
        this.englishObservations = value;
    }

    /**
     * Gets the value of the frenchObservations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrenchObservations() {
        return frenchObservations;
    }

    /**
     * Sets the value of the frenchObservations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrenchObservations(String value) {
        this.frenchObservations = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Category)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Category that = ((Category) object);
        {
            String lhsCategoryId;
            lhsCategoryId = this.getCategoryId();
            String rhsCategoryId;
            rhsCategoryId = that.getCategoryId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "categoryId", lhsCategoryId), LocatorUtils.property(thatLocator, "categoryId", rhsCategoryId), lhsCategoryId, rhsCategoryId)) {
                return false;
            }
        }
        {
            String lhsCategoryKey;
            lhsCategoryKey = this.getCategoryKey();
            String rhsCategoryKey;
            rhsCategoryKey = that.getCategoryKey();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "categoryKey", lhsCategoryKey), LocatorUtils.property(thatLocator, "categoryKey", rhsCategoryKey), lhsCategoryKey, rhsCategoryKey)) {
                return false;
            }
        }
        {
            String lhsCode;
            lhsCode = this.getCode();
            String rhsCode;
            rhsCode = that.getCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "code", lhsCode), LocatorUtils.property(thatLocator, "code", rhsCode), lhsCode, rhsCode)) {
                return false;
            }
        }
        {
            String lhsEnglishName;
            lhsEnglishName = this.getEnglishName();
            String rhsEnglishName;
            rhsEnglishName = that.getEnglishName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "englishName", lhsEnglishName), LocatorUtils.property(thatLocator, "englishName", rhsEnglishName), lhsEnglishName, rhsEnglishName)) {
                return false;
            }
        }
        {
            String lhsFrenchName;
            lhsFrenchName = this.getFrenchName();
            String rhsFrenchName;
            rhsFrenchName = that.getFrenchName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "frenchName", lhsFrenchName), LocatorUtils.property(thatLocator, "frenchName", rhsFrenchName), lhsFrenchName, rhsFrenchName)) {
                return false;
            }
        }
        {
            int lhsVersion;
            lhsVersion = (true?this.getVersion(): 0);
            int rhsVersion;
            rhsVersion = (true?that.getVersion(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "version", lhsVersion), LocatorUtils.property(thatLocator, "version", rhsVersion), lhsVersion, rhsVersion)) {
                return false;
            }
        }
        {
            CategoryType lhsType;
            lhsType = this.getType();
            CategoryType rhsType;
            rhsType = that.getType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType)) {
                return false;
            }
        }
        {
            CategoryStatus lhsStatus;
            lhsStatus = this.getStatus();
            CategoryStatus rhsStatus;
            rhsStatus = that.getStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "status", lhsStatus), LocatorUtils.property(thatLocator, "status", rhsStatus), lhsStatus, rhsStatus)) {
                return false;
            }
        }
        {
            String lhsEnglishDescription;
            lhsEnglishDescription = this.getEnglishDescription();
            String rhsEnglishDescription;
            rhsEnglishDescription = that.getEnglishDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "englishDescription", lhsEnglishDescription), LocatorUtils.property(thatLocator, "englishDescription", rhsEnglishDescription), lhsEnglishDescription, rhsEnglishDescription)) {
                return false;
            }
        }
        {
            String lhsFrenchDescription;
            lhsFrenchDescription = this.getFrenchDescription();
            String rhsFrenchDescription;
            rhsFrenchDescription = that.getFrenchDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "frenchDescription", lhsFrenchDescription), LocatorUtils.property(thatLocator, "frenchDescription", rhsFrenchDescription), lhsFrenchDescription, rhsFrenchDescription)) {
                return false;
            }
        }
        {
            String lhsEnglishObservations;
            lhsEnglishObservations = this.getEnglishObservations();
            String rhsEnglishObservations;
            rhsEnglishObservations = that.getEnglishObservations();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "englishObservations", lhsEnglishObservations), LocatorUtils.property(thatLocator, "englishObservations", rhsEnglishObservations), lhsEnglishObservations, rhsEnglishObservations)) {
                return false;
            }
        }
        {
            String lhsFrenchObservations;
            lhsFrenchObservations = this.getFrenchObservations();
            String rhsFrenchObservations;
            rhsFrenchObservations = that.getFrenchObservations();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "frenchObservations", lhsFrenchObservations), LocatorUtils.property(thatLocator, "frenchObservations", rhsFrenchObservations), lhsFrenchObservations, rhsFrenchObservations)) {
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
            String theCategoryId;
            theCategoryId = this.getCategoryId();
            strategy.appendField(locator, this, "categoryId", buffer, theCategoryId);
        }
        {
            String theCategoryKey;
            theCategoryKey = this.getCategoryKey();
            strategy.appendField(locator, this, "categoryKey", buffer, theCategoryKey);
        }
        {
            String theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        {
            String theEnglishName;
            theEnglishName = this.getEnglishName();
            strategy.appendField(locator, this, "englishName", buffer, theEnglishName);
        }
        {
            String theFrenchName;
            theFrenchName = this.getFrenchName();
            strategy.appendField(locator, this, "frenchName", buffer, theFrenchName);
        }
        {
            int theVersion;
            theVersion = (true?this.getVersion(): 0);
            strategy.appendField(locator, this, "version", buffer, theVersion);
        }
        {
            CategoryType theType;
            theType = this.getType();
            strategy.appendField(locator, this, "type", buffer, theType);
        }
        {
            CategoryStatus theStatus;
            theStatus = this.getStatus();
            strategy.appendField(locator, this, "status", buffer, theStatus);
        }
        {
            String theEnglishDescription;
            theEnglishDescription = this.getEnglishDescription();
            strategy.appendField(locator, this, "englishDescription", buffer, theEnglishDescription);
        }
        {
            String theFrenchDescription;
            theFrenchDescription = this.getFrenchDescription();
            strategy.appendField(locator, this, "frenchDescription", buffer, theFrenchDescription);
        }
        {
            String theEnglishObservations;
            theEnglishObservations = this.getEnglishObservations();
            strategy.appendField(locator, this, "englishObservations", buffer, theEnglishObservations);
        }
        {
            String theFrenchObservations;
            theFrenchObservations = this.getFrenchObservations();
            strategy.appendField(locator, this, "frenchObservations", buffer, theFrenchObservations);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theCategoryId;
            theCategoryId = this.getCategoryId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "categoryId", theCategoryId), currentHashCode, theCategoryId);
        }
        {
            String theCategoryKey;
            theCategoryKey = this.getCategoryKey();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "categoryKey", theCategoryKey), currentHashCode, theCategoryKey);
        }
        {
            String theCode;
            theCode = this.getCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "code", theCode), currentHashCode, theCode);
        }
        {
            String theEnglishName;
            theEnglishName = this.getEnglishName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "englishName", theEnglishName), currentHashCode, theEnglishName);
        }
        {
            String theFrenchName;
            theFrenchName = this.getFrenchName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "frenchName", theFrenchName), currentHashCode, theFrenchName);
        }
        {
            int theVersion;
            theVersion = (true?this.getVersion(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "version", theVersion), currentHashCode, theVersion);
        }
        {
            CategoryType theType;
            theType = this.getType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType);
        }
        {
            CategoryStatus theStatus;
            theStatus = this.getStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "status", theStatus), currentHashCode, theStatus);
        }
        {
            String theEnglishDescription;
            theEnglishDescription = this.getEnglishDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "englishDescription", theEnglishDescription), currentHashCode, theEnglishDescription);
        }
        {
            String theFrenchDescription;
            theFrenchDescription = this.getFrenchDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "frenchDescription", theFrenchDescription), currentHashCode, theFrenchDescription);
        }
        {
            String theEnglishObservations;
            theEnglishObservations = this.getEnglishObservations();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "englishObservations", theEnglishObservations), currentHashCode, theEnglishObservations);
        }
        {
            String theFrenchObservations;
            theFrenchObservations = this.getFrenchObservations();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "frenchObservations", theFrenchObservations), currentHashCode, theFrenchObservations);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
