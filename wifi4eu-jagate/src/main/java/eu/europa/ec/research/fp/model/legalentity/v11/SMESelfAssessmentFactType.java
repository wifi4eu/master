
package eu.europa.ec.research.fp.model.legalentity.v11;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * <p>Java class for SMESelfAssessmentFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SMESelfAssessmentFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="FinancialYearEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SelfDeclared" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AssessmentResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AssessmentReport" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SMESelfAssessmentFactType", propOrder = {
    "year",
    "financialYearEndDate",
    "selfDeclared",
    "assessmentResult",
    "assessmentReport"
})
public class SMESelfAssessmentFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Year", required = true)
    protected BigInteger year;
    @XmlElement(name = "FinancialYearEndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar financialYearEndDate;
    @XmlElement(name = "SelfDeclared")
    protected boolean selfDeclared;
    @XmlElement(name = "AssessmentResult")
    protected Boolean assessmentResult;
    @XmlElement(name = "AssessmentReport")
    protected Long assessmentReport;

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYear(BigInteger value) {
        this.year = value;
    }

    /**
     * Gets the value of the financialYearEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinancialYearEndDate() {
        return financialYearEndDate;
    }

    /**
     * Sets the value of the financialYearEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinancialYearEndDate(XMLGregorianCalendar value) {
        this.financialYearEndDate = value;
    }

    /**
     * Gets the value of the selfDeclared property.
     * 
     */
    public boolean isSelfDeclared() {
        return selfDeclared;
    }

    /**
     * Sets the value of the selfDeclared property.
     * 
     */
    public void setSelfDeclared(boolean value) {
        this.selfDeclared = value;
    }

    /**
     * Gets the value of the assessmentResult property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAssessmentResult() {
        return assessmentResult;
    }

    /**
     * Sets the value of the assessmentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAssessmentResult(Boolean value) {
        this.assessmentResult = value;
    }

    /**
     * Gets the value of the assessmentReport property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAssessmentReport() {
        return assessmentReport;
    }

    /**
     * Sets the value of the assessmentReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAssessmentReport(Long value) {
        this.assessmentReport = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SMESelfAssessmentFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SMESelfAssessmentFactType that = ((SMESelfAssessmentFactType) object);
        {
            BigInteger lhsYear;
            lhsYear = this.getYear();
            BigInteger rhsYear;
            rhsYear = that.getYear();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "year", lhsYear), LocatorUtils.property(thatLocator, "year", rhsYear), lhsYear, rhsYear)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsFinancialYearEndDate;
            lhsFinancialYearEndDate = this.getFinancialYearEndDate();
            XMLGregorianCalendar rhsFinancialYearEndDate;
            rhsFinancialYearEndDate = that.getFinancialYearEndDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "financialYearEndDate", lhsFinancialYearEndDate), LocatorUtils.property(thatLocator, "financialYearEndDate", rhsFinancialYearEndDate), lhsFinancialYearEndDate, rhsFinancialYearEndDate)) {
                return false;
            }
        }
        {
            boolean lhsSelfDeclared;
            lhsSelfDeclared = (true?this.isSelfDeclared():false);
            boolean rhsSelfDeclared;
            rhsSelfDeclared = (true?that.isSelfDeclared():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "selfDeclared", lhsSelfDeclared), LocatorUtils.property(thatLocator, "selfDeclared", rhsSelfDeclared), lhsSelfDeclared, rhsSelfDeclared)) {
                return false;
            }
        }
        {
            Boolean lhsAssessmentResult;
            lhsAssessmentResult = this.isAssessmentResult();
            Boolean rhsAssessmentResult;
            rhsAssessmentResult = that.isAssessmentResult();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assessmentResult", lhsAssessmentResult), LocatorUtils.property(thatLocator, "assessmentResult", rhsAssessmentResult), lhsAssessmentResult, rhsAssessmentResult)) {
                return false;
            }
        }
        {
            Long lhsAssessmentReport;
            lhsAssessmentReport = this.getAssessmentReport();
            Long rhsAssessmentReport;
            rhsAssessmentReport = that.getAssessmentReport();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "assessmentReport", lhsAssessmentReport), LocatorUtils.property(thatLocator, "assessmentReport", rhsAssessmentReport), lhsAssessmentReport, rhsAssessmentReport)) {
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
            BigInteger theYear;
            theYear = this.getYear();
            strategy.appendField(locator, this, "year", buffer, theYear);
        }
        {
            XMLGregorianCalendar theFinancialYearEndDate;
            theFinancialYearEndDate = this.getFinancialYearEndDate();
            strategy.appendField(locator, this, "financialYearEndDate", buffer, theFinancialYearEndDate);
        }
        {
            boolean theSelfDeclared;
            theSelfDeclared = (true?this.isSelfDeclared():false);
            strategy.appendField(locator, this, "selfDeclared", buffer, theSelfDeclared);
        }
        {
            Boolean theAssessmentResult;
            theAssessmentResult = this.isAssessmentResult();
            strategy.appendField(locator, this, "assessmentResult", buffer, theAssessmentResult);
        }
        {
            Long theAssessmentReport;
            theAssessmentReport = this.getAssessmentReport();
            strategy.appendField(locator, this, "assessmentReport", buffer, theAssessmentReport);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            BigInteger theYear;
            theYear = this.getYear();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "year", theYear), currentHashCode, theYear);
        }
        {
            XMLGregorianCalendar theFinancialYearEndDate;
            theFinancialYearEndDate = this.getFinancialYearEndDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "financialYearEndDate", theFinancialYearEndDate), currentHashCode, theFinancialYearEndDate);
        }
        {
            boolean theSelfDeclared;
            theSelfDeclared = (true?this.isSelfDeclared():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "selfDeclared", theSelfDeclared), currentHashCode, theSelfDeclared);
        }
        {
            Boolean theAssessmentResult;
            theAssessmentResult = this.isAssessmentResult();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assessmentResult", theAssessmentResult), currentHashCode, theAssessmentResult);
        }
        {
            Long theAssessmentReport;
            theAssessmentReport = this.getAssessmentReport();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "assessmentReport", theAssessmentReport), currentHashCode, theAssessmentReport);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
