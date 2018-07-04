
package eu.europa.ec.research.fp.model.legalentity.v11;

import java.math.BigDecimal;
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
 * <p>Java class for SMEFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SMEFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ValidatedSME" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}ValidatedSmeType" minOccurs="0"/>
 *         &lt;element name="AnnualBalanceSheet" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AnnualTurnover" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FinancialYearEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="NumberOfEmployees" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Autonomous" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SMEFactType", propOrder = {
    "year",
    "validatedSME",
    "annualBalanceSheet",
    "annualTurnover",
    "financialYearEndDate",
    "numberOfEmployees",
    "autonomous"
})
public class SMEFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Year", required = true)
    protected BigInteger year;
    @XmlElement(name = "ValidatedSME")
    protected String validatedSME;
    @XmlElement(name = "AnnualBalanceSheet")
    protected BigDecimal annualBalanceSheet;
    @XmlElement(name = "AnnualTurnover")
    protected BigDecimal annualTurnover;
    @XmlElement(name = "FinancialYearEndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar financialYearEndDate;
    @XmlElement(name = "NumberOfEmployees")
    protected BigInteger numberOfEmployees;
    @XmlElement(name = "Autonomous")
    protected Boolean autonomous;

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
     * Gets the value of the validatedSME property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidatedSME() {
        return validatedSME;
    }

    /**
     * Sets the value of the validatedSME property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidatedSME(String value) {
        this.validatedSME = value;
    }

    /**
     * Gets the value of the annualBalanceSheet property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAnnualBalanceSheet() {
        return annualBalanceSheet;
    }

    /**
     * Sets the value of the annualBalanceSheet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAnnualBalanceSheet(BigDecimal value) {
        this.annualBalanceSheet = value;
    }

    /**
     * Gets the value of the annualTurnover property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAnnualTurnover() {
        return annualTurnover;
    }

    /**
     * Sets the value of the annualTurnover property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAnnualTurnover(BigDecimal value) {
        this.annualTurnover = value;
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
     * Gets the value of the numberOfEmployees property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Sets the value of the numberOfEmployees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfEmployees(BigInteger value) {
        this.numberOfEmployees = value;
    }

    /**
     * Gets the value of the autonomous property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutonomous() {
        return autonomous;
    }

    /**
     * Sets the value of the autonomous property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutonomous(Boolean value) {
        this.autonomous = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SMEFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SMEFactType that = ((SMEFactType) object);
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
            String lhsValidatedSME;
            lhsValidatedSME = this.getValidatedSME();
            String rhsValidatedSME;
            rhsValidatedSME = that.getValidatedSME();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validatedSME", lhsValidatedSME), LocatorUtils.property(thatLocator, "validatedSME", rhsValidatedSME), lhsValidatedSME, rhsValidatedSME)) {
                return false;
            }
        }
        {
            BigDecimal lhsAnnualBalanceSheet;
            lhsAnnualBalanceSheet = this.getAnnualBalanceSheet();
            BigDecimal rhsAnnualBalanceSheet;
            rhsAnnualBalanceSheet = that.getAnnualBalanceSheet();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "annualBalanceSheet", lhsAnnualBalanceSheet), LocatorUtils.property(thatLocator, "annualBalanceSheet", rhsAnnualBalanceSheet), lhsAnnualBalanceSheet, rhsAnnualBalanceSheet)) {
                return false;
            }
        }
        {
            BigDecimal lhsAnnualTurnover;
            lhsAnnualTurnover = this.getAnnualTurnover();
            BigDecimal rhsAnnualTurnover;
            rhsAnnualTurnover = that.getAnnualTurnover();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "annualTurnover", lhsAnnualTurnover), LocatorUtils.property(thatLocator, "annualTurnover", rhsAnnualTurnover), lhsAnnualTurnover, rhsAnnualTurnover)) {
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
            BigInteger lhsNumberOfEmployees;
            lhsNumberOfEmployees = this.getNumberOfEmployees();
            BigInteger rhsNumberOfEmployees;
            rhsNumberOfEmployees = that.getNumberOfEmployees();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "numberOfEmployees", lhsNumberOfEmployees), LocatorUtils.property(thatLocator, "numberOfEmployees", rhsNumberOfEmployees), lhsNumberOfEmployees, rhsNumberOfEmployees)) {
                return false;
            }
        }
        {
            Boolean lhsAutonomous;
            lhsAutonomous = this.isAutonomous();
            Boolean rhsAutonomous;
            rhsAutonomous = that.isAutonomous();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "autonomous", lhsAutonomous), LocatorUtils.property(thatLocator, "autonomous", rhsAutonomous), lhsAutonomous, rhsAutonomous)) {
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
            String theValidatedSME;
            theValidatedSME = this.getValidatedSME();
            strategy.appendField(locator, this, "validatedSME", buffer, theValidatedSME);
        }
        {
            BigDecimal theAnnualBalanceSheet;
            theAnnualBalanceSheet = this.getAnnualBalanceSheet();
            strategy.appendField(locator, this, "annualBalanceSheet", buffer, theAnnualBalanceSheet);
        }
        {
            BigDecimal theAnnualTurnover;
            theAnnualTurnover = this.getAnnualTurnover();
            strategy.appendField(locator, this, "annualTurnover", buffer, theAnnualTurnover);
        }
        {
            XMLGregorianCalendar theFinancialYearEndDate;
            theFinancialYearEndDate = this.getFinancialYearEndDate();
            strategy.appendField(locator, this, "financialYearEndDate", buffer, theFinancialYearEndDate);
        }
        {
            BigInteger theNumberOfEmployees;
            theNumberOfEmployees = this.getNumberOfEmployees();
            strategy.appendField(locator, this, "numberOfEmployees", buffer, theNumberOfEmployees);
        }
        {
            Boolean theAutonomous;
            theAutonomous = this.isAutonomous();
            strategy.appendField(locator, this, "autonomous", buffer, theAutonomous);
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
            String theValidatedSME;
            theValidatedSME = this.getValidatedSME();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validatedSME", theValidatedSME), currentHashCode, theValidatedSME);
        }
        {
            BigDecimal theAnnualBalanceSheet;
            theAnnualBalanceSheet = this.getAnnualBalanceSheet();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "annualBalanceSheet", theAnnualBalanceSheet), currentHashCode, theAnnualBalanceSheet);
        }
        {
            BigDecimal theAnnualTurnover;
            theAnnualTurnover = this.getAnnualTurnover();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "annualTurnover", theAnnualTurnover), currentHashCode, theAnnualTurnover);
        }
        {
            XMLGregorianCalendar theFinancialYearEndDate;
            theFinancialYearEndDate = this.getFinancialYearEndDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "financialYearEndDate", theFinancialYearEndDate), currentHashCode, theFinancialYearEndDate);
        }
        {
            BigInteger theNumberOfEmployees;
            theNumberOfEmployees = this.getNumberOfEmployees();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numberOfEmployees", theNumberOfEmployees), currentHashCode, theNumberOfEmployees);
        }
        {
            Boolean theAutonomous;
            theAutonomous = this.isAutonomous();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "autonomous", theAutonomous), currentHashCode, theAutonomous);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
