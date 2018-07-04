
package generated.jagate.model.certificate.v4;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import eu.europa.ec.research.fp.model.document.v5.DocumentType;
import generated.jagate.model.coderef.V3.CodeRefType;
import generated.jagate.model.projectref.v3.ProjectIdType;
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
 * <p>Java class for CertificateOnMethodologyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CertificateOnMethodologyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypeCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RequestDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Cost" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="ChargedInProject" type="{http://ec.europa.eu/research/fp/model/project-ref/V3}ProjectIdType" minOccurs="0"/>
 *         &lt;element name="AuditorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Document" type="{http://ec.europa.eu/research/fp/model/document/V5}DocumentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificateOnMethodologyType", propOrder = {
    "typeCode",
    "startDate",
    "endDate",
    "requestDate",
    "cost",
    "chargedInProject",
    "auditorName",
    "document"
})
public class CertificateOnMethodologyType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "TypeCode", required = true)
    protected CodeRefType typeCode;
    @XmlElement(name = "StartDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "RequestDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar requestDate;
    @XmlElement(name = "Cost")
    protected BigDecimal cost;
    @XmlElement(name = "ChargedInProject")
    protected ProjectIdType chargedInProject;
    @XmlElement(name = "AuditorName")
    protected String auditorName;
    @XmlElement(name = "Document")
    protected DocumentType document;

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setTypeCode(CodeRefType value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the requestDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the value of the requestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestDate(XMLGregorianCalendar value) {
        this.requestDate = value;
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
     * Gets the value of the chargedInProject property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectIdType }
     *     
     */
    public ProjectIdType getChargedInProject() {
        return chargedInProject;
    }

    /**
     * Sets the value of the chargedInProject property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectIdType }
     *     
     */
    public void setChargedInProject(ProjectIdType value) {
        this.chargedInProject = value;
    }

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CertificateOnMethodologyType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CertificateOnMethodologyType that = ((CertificateOnMethodologyType) object);
        {
            CodeRefType lhsTypeCode;
            lhsTypeCode = this.getTypeCode();
            CodeRefType rhsTypeCode;
            rhsTypeCode = that.getTypeCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "typeCode", lhsTypeCode), LocatorUtils.property(thatLocator, "typeCode", rhsTypeCode), lhsTypeCode, rhsTypeCode)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsStartDate;
            lhsStartDate = this.getStartDate();
            XMLGregorianCalendar rhsStartDate;
            rhsStartDate = that.getStartDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "startDate", lhsStartDate), LocatorUtils.property(thatLocator, "startDate", rhsStartDate), lhsStartDate, rhsStartDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsEndDate;
            lhsEndDate = this.getEndDate();
            XMLGregorianCalendar rhsEndDate;
            rhsEndDate = that.getEndDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "endDate", lhsEndDate), LocatorUtils.property(thatLocator, "endDate", rhsEndDate), lhsEndDate, rhsEndDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsRequestDate;
            lhsRequestDate = this.getRequestDate();
            XMLGregorianCalendar rhsRequestDate;
            rhsRequestDate = that.getRequestDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "requestDate", lhsRequestDate), LocatorUtils.property(thatLocator, "requestDate", rhsRequestDate), lhsRequestDate, rhsRequestDate)) {
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
            ProjectIdType lhsChargedInProject;
            lhsChargedInProject = this.getChargedInProject();
            ProjectIdType rhsChargedInProject;
            rhsChargedInProject = that.getChargedInProject();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "chargedInProject", lhsChargedInProject), LocatorUtils.property(thatLocator, "chargedInProject", rhsChargedInProject), lhsChargedInProject, rhsChargedInProject)) {
                return false;
            }
        }
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
            DocumentType lhsDocument;
            lhsDocument = this.getDocument();
            DocumentType rhsDocument;
            rhsDocument = that.getDocument();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "document", lhsDocument), LocatorUtils.property(thatLocator, "document", rhsDocument), lhsDocument, rhsDocument)) {
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
            CodeRefType theTypeCode;
            theTypeCode = this.getTypeCode();
            strategy.appendField(locator, this, "typeCode", buffer, theTypeCode);
        }
        {
            XMLGregorianCalendar theStartDate;
            theStartDate = this.getStartDate();
            strategy.appendField(locator, this, "startDate", buffer, theStartDate);
        }
        {
            XMLGregorianCalendar theEndDate;
            theEndDate = this.getEndDate();
            strategy.appendField(locator, this, "endDate", buffer, theEndDate);
        }
        {
            XMLGregorianCalendar theRequestDate;
            theRequestDate = this.getRequestDate();
            strategy.appendField(locator, this, "requestDate", buffer, theRequestDate);
        }
        {
            BigDecimal theCost;
            theCost = this.getCost();
            strategy.appendField(locator, this, "cost", buffer, theCost);
        }
        {
            ProjectIdType theChargedInProject;
            theChargedInProject = this.getChargedInProject();
            strategy.appendField(locator, this, "chargedInProject", buffer, theChargedInProject);
        }
        {
            String theAuditorName;
            theAuditorName = this.getAuditorName();
            strategy.appendField(locator, this, "auditorName", buffer, theAuditorName);
        }
        {
            DocumentType theDocument;
            theDocument = this.getDocument();
            strategy.appendField(locator, this, "document", buffer, theDocument);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            CodeRefType theTypeCode;
            theTypeCode = this.getTypeCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "typeCode", theTypeCode), currentHashCode, theTypeCode);
        }
        {
            XMLGregorianCalendar theStartDate;
            theStartDate = this.getStartDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "startDate", theStartDate), currentHashCode, theStartDate);
        }
        {
            XMLGregorianCalendar theEndDate;
            theEndDate = this.getEndDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "endDate", theEndDate), currentHashCode, theEndDate);
        }
        {
            XMLGregorianCalendar theRequestDate;
            theRequestDate = this.getRequestDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requestDate", theRequestDate), currentHashCode, theRequestDate);
        }
        {
            BigDecimal theCost;
            theCost = this.getCost();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cost", theCost), currentHashCode, theCost);
        }
        {
            ProjectIdType theChargedInProject;
            theChargedInProject = this.getChargedInProject();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "chargedInProject", theChargedInProject), currentHashCode, theChargedInProject);
        }
        {
            String theAuditorName;
            theAuditorName = this.getAuditorName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "auditorName", theAuditorName), currentHashCode, theAuditorName);
        }
        {
            DocumentType theDocument;
            theDocument = this.getDocument();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "document", theDocument), currentHashCode, theDocument);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
