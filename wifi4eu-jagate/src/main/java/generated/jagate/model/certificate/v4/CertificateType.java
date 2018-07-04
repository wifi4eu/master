
package generated.jagate.model.certificate.v4;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import eu.europa.ec.research.fp.model.document.v5.DocumentType;
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
 * <p>Java class for CertificateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CertificateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuditorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Cost" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType"/>
 *         &lt;element name="Document" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificateType", propOrder = {
    "auditorName",
    "cost",
    "document"
})
public class CertificateType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "AuditorName", required = true)
    protected String auditorName;
    @XmlElement(name = "Cost", required = true)
    protected BigDecimal cost;
    @XmlElement(name = "Document", required = true)
    protected DocumentType document;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the auditorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditorName() {
        return auditorName;
    }

    /**
     * Sets the value of the auditorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditorName(String value) {
        this.auditorName = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCost(BigDecimal value) {
        this.cost = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType }
     *     
     */
    public DocumentType getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType }
     *     
     */
    public void setDocument(DocumentType value) {
        this.document = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CertificateType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CertificateType that = ((CertificateType) object);
        {
            String lhsAuditorName;
            lhsAuditorName = this.getAuditorName();
            String rhsAuditorName;
            rhsAuditorName = that.getAuditorName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "auditorName", lhsAuditorName), LocatorUtils.property(thatLocator, "auditorName", rhsAuditorName), lhsAuditorName, rhsAuditorName)) {
                return false;
            }
        }
        {
            BigDecimal lhsCost;
            lhsCost = this.getCost();
            BigDecimal rhsCost;
            rhsCost = that.getCost();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cost", lhsCost), LocatorUtils.property(thatLocator, "cost", rhsCost), lhsCost, rhsCost)) {
                return false;
            }
        }
        {
            DocumentType lhsDocument;
            lhsDocument = this.getDocument();
            DocumentType rhsDocument;
            rhsDocument = that.getDocument();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "document", lhsDocument), LocatorUtils.property(thatLocator, "document", rhsDocument), lhsDocument, rhsDocument)) {
                return false;
            }
        }
        {
            String lhsId;
            lhsId = this.getId();
            String rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
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
            String theAuditorName;
            theAuditorName = this.getAuditorName();
            strategy.appendField(locator, this, "auditorName", buffer, theAuditorName);
        }
        {
            BigDecimal theCost;
            theCost = this.getCost();
            strategy.appendField(locator, this, "cost", buffer, theCost);
        }
        {
            DocumentType theDocument;
            theDocument = this.getDocument();
            strategy.appendField(locator, this, "document", buffer, theDocument);
        }
        {
            String theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theAuditorName;
            theAuditorName = this.getAuditorName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "auditorName", theAuditorName), currentHashCode, theAuditorName);
        }
        {
            BigDecimal theCost;
            theCost = this.getCost();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cost", theCost), currentHashCode, theCost);
        }
        {
            DocumentType theDocument;
            theDocument = this.getDocument();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "document", theDocument), currentHashCode, theDocument);
        }
        {
            String theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
