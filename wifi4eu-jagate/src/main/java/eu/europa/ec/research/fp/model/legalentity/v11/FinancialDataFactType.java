
package eu.europa.ec.research.fp.model.legalentity.v11;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import generated.jagate.model.coderef.V3.CodeRefType;
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
 * An annual balance sheet of a Legal Entity.
 * 
 * <p>Java class for FinancialDataFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FinancialDataFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClosingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="DurationInMonths" type="{http://ec.europa.eu/research/fp/model/base/V1}CountType"/>
 *         &lt;element name="Year" type="{http://ec.europa.eu/research/fp/model/base/V1}YearType"/>
 *         &lt;element name="ValidityDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ExchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CurrencyCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType"/>
 *         &lt;element name="AuditFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ConsolidatedDataFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="BusinessPlanDataFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FinancialDataAmounts" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}FinancialDataAmountsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialDataFactType", propOrder = {
    "closingDate",
    "durationInMonths",
    "year",
    "validityDate",
    "exchangeRate",
    "currencyCode",
    "auditFlag",
    "consolidatedDataFlag",
    "businessPlanDataFlag",
    "financialDataAmounts"
})
public class FinancialDataFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ClosingDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar closingDate;
    @XmlElement(name = "DurationInMonths", required = true)
    protected BigInteger durationInMonths;
    @XmlElement(name = "Year")
    protected int year;
    @XmlElement(name = "ValidityDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validityDate;
    @XmlElement(name = "ExchangeRate")
    protected BigDecimal exchangeRate;
    @XmlElement(name = "CurrencyCode", required = true)
    protected CodeRefType currencyCode;
    @XmlElement(name = "AuditFlag")
    protected boolean auditFlag;
    @XmlElement(name = "ConsolidatedDataFlag")
    protected boolean consolidatedDataFlag;
    @XmlElement(name = "BusinessPlanDataFlag")
    protected boolean businessPlanDataFlag;
    @XmlElement(name = "FinancialDataAmounts")
    protected FinancialDataAmountsType financialDataAmounts;

    /**
     * Gets the value of the closingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClosingDate() {
        return closingDate;
    }

    /**
     * Sets the value of the closingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClosingDate(XMLGregorianCalendar value) {
        this.closingDate = value;
    }

    /**
     * Gets the value of the durationInMonths property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDurationInMonths() {
        return durationInMonths;
    }

    /**
     * Sets the value of the durationInMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDurationInMonths(BigInteger value) {
        this.durationInMonths = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

    /**
     * Gets the value of the validityDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityDate() {
        return validityDate;
    }

    /**
     * Sets the value of the validityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityDate(XMLGregorianCalendar value) {
        this.validityDate = value;
    }

    /**
     * Gets the value of the exchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the value of the exchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExchangeRate(BigDecimal value) {
        this.exchangeRate = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodeRefType }
     *     
     */
    public CodeRefType getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeRefType }
     *     
     */
    public void setCurrencyCode(CodeRefType value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the auditFlag property.
     * 
     */
    public boolean isAuditFlag() {
        return auditFlag;
    }

    /**
     * Sets the value of the auditFlag property.
     * 
     */
    public void setAuditFlag(boolean value) {
        this.auditFlag = value;
    }

    /**
     * Gets the value of the consolidatedDataFlag property.
     * 
     */
    public boolean isConsolidatedDataFlag() {
        return consolidatedDataFlag;
    }

    /**
     * Sets the value of the consolidatedDataFlag property.
     * 
     */
    public void setConsolidatedDataFlag(boolean value) {
        this.consolidatedDataFlag = value;
    }

    /**
     * Gets the value of the businessPlanDataFlag property.
     * 
     */
    public boolean isBusinessPlanDataFlag() {
        return businessPlanDataFlag;
    }

    /**
     * Sets the value of the businessPlanDataFlag property.
     * 
     */
    public void setBusinessPlanDataFlag(boolean value) {
        this.businessPlanDataFlag = value;
    }

    /**
     * Gets the value of the financialDataAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialDataAmountsType }
     *     
     */
    public FinancialDataAmountsType getFinancialDataAmounts() {
        return financialDataAmounts;
    }

    /**
     * Sets the value of the financialDataAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialDataAmountsType }
     *     
     */
    public void setFinancialDataAmounts(FinancialDataAmountsType value) {
        this.financialDataAmounts = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FinancialDataFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FinancialDataFactType that = ((FinancialDataFactType) object);
        {
            XMLGregorianCalendar lhsClosingDate;
            lhsClosingDate = this.getClosingDate();
            XMLGregorianCalendar rhsClosingDate;
            rhsClosingDate = that.getClosingDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "closingDate", lhsClosingDate), LocatorUtils.property(thatLocator, "closingDate", rhsClosingDate), lhsClosingDate, rhsClosingDate)) {
                return false;
            }
        }
        {
            BigInteger lhsDurationInMonths;
            lhsDurationInMonths = this.getDurationInMonths();
            BigInteger rhsDurationInMonths;
            rhsDurationInMonths = that.getDurationInMonths();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "durationInMonths", lhsDurationInMonths), LocatorUtils.property(thatLocator, "durationInMonths", rhsDurationInMonths), lhsDurationInMonths, rhsDurationInMonths)) {
                return false;
            }
        }
        {
            int lhsYear;
            lhsYear = (true?this.getYear(): 0);
            int rhsYear;
            rhsYear = (true?that.getYear(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "year", lhsYear), LocatorUtils.property(thatLocator, "year", rhsYear), lhsYear, rhsYear)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidityDate;
            lhsValidityDate = this.getValidityDate();
            XMLGregorianCalendar rhsValidityDate;
            rhsValidityDate = that.getValidityDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validityDate", lhsValidityDate), LocatorUtils.property(thatLocator, "validityDate", rhsValidityDate), lhsValidityDate, rhsValidityDate)) {
                return false;
            }
        }
        {
            BigDecimal lhsExchangeRate;
            lhsExchangeRate = this.getExchangeRate();
            BigDecimal rhsExchangeRate;
            rhsExchangeRate = that.getExchangeRate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "exchangeRate", lhsExchangeRate), LocatorUtils.property(thatLocator, "exchangeRate", rhsExchangeRate), lhsExchangeRate, rhsExchangeRate)) {
                return false;
            }
        }
        {
            CodeRefType lhsCurrencyCode;
            lhsCurrencyCode = this.getCurrencyCode();
            CodeRefType rhsCurrencyCode;
            rhsCurrencyCode = that.getCurrencyCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "currencyCode", lhsCurrencyCode), LocatorUtils.property(thatLocator, "currencyCode", rhsCurrencyCode), lhsCurrencyCode, rhsCurrencyCode)) {
                return false;
            }
        }
        {
            boolean lhsAuditFlag;
            lhsAuditFlag = (true?this.isAuditFlag():false);
            boolean rhsAuditFlag;
            rhsAuditFlag = (true?that.isAuditFlag():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "auditFlag", lhsAuditFlag), LocatorUtils.property(thatLocator, "auditFlag", rhsAuditFlag), lhsAuditFlag, rhsAuditFlag)) {
                return false;
            }
        }
        {
            boolean lhsConsolidatedDataFlag;
            lhsConsolidatedDataFlag = (true?this.isConsolidatedDataFlag():false);
            boolean rhsConsolidatedDataFlag;
            rhsConsolidatedDataFlag = (true?that.isConsolidatedDataFlag():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "consolidatedDataFlag", lhsConsolidatedDataFlag), LocatorUtils.property(thatLocator, "consolidatedDataFlag", rhsConsolidatedDataFlag), lhsConsolidatedDataFlag, rhsConsolidatedDataFlag)) {
                return false;
            }
        }
        {
            boolean lhsBusinessPlanDataFlag;
            lhsBusinessPlanDataFlag = (true?this.isBusinessPlanDataFlag():false);
            boolean rhsBusinessPlanDataFlag;
            rhsBusinessPlanDataFlag = (true?that.isBusinessPlanDataFlag():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "businessPlanDataFlag", lhsBusinessPlanDataFlag), LocatorUtils.property(thatLocator, "businessPlanDataFlag", rhsBusinessPlanDataFlag), lhsBusinessPlanDataFlag, rhsBusinessPlanDataFlag)) {
                return false;
            }
        }
        {
            FinancialDataAmountsType lhsFinancialDataAmounts;
            lhsFinancialDataAmounts = this.getFinancialDataAmounts();
            FinancialDataAmountsType rhsFinancialDataAmounts;
            rhsFinancialDataAmounts = that.getFinancialDataAmounts();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "financialDataAmounts", lhsFinancialDataAmounts), LocatorUtils.property(thatLocator, "financialDataAmounts", rhsFinancialDataAmounts), lhsFinancialDataAmounts, rhsFinancialDataAmounts)) {
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
            XMLGregorianCalendar theClosingDate;
            theClosingDate = this.getClosingDate();
            strategy.appendField(locator, this, "closingDate", buffer, theClosingDate);
        }
        {
            BigInteger theDurationInMonths;
            theDurationInMonths = this.getDurationInMonths();
            strategy.appendField(locator, this, "durationInMonths", buffer, theDurationInMonths);
        }
        {
            int theYear;
            theYear = (true?this.getYear(): 0);
            strategy.appendField(locator, this, "year", buffer, theYear);
        }
        {
            XMLGregorianCalendar theValidityDate;
            theValidityDate = this.getValidityDate();
            strategy.appendField(locator, this, "validityDate", buffer, theValidityDate);
        }
        {
            BigDecimal theExchangeRate;
            theExchangeRate = this.getExchangeRate();
            strategy.appendField(locator, this, "exchangeRate", buffer, theExchangeRate);
        }
        {
            CodeRefType theCurrencyCode;
            theCurrencyCode = this.getCurrencyCode();
            strategy.appendField(locator, this, "currencyCode", buffer, theCurrencyCode);
        }
        {
            boolean theAuditFlag;
            theAuditFlag = (true?this.isAuditFlag():false);
            strategy.appendField(locator, this, "auditFlag", buffer, theAuditFlag);
        }
        {
            boolean theConsolidatedDataFlag;
            theConsolidatedDataFlag = (true?this.isConsolidatedDataFlag():false);
            strategy.appendField(locator, this, "consolidatedDataFlag", buffer, theConsolidatedDataFlag);
        }
        {
            boolean theBusinessPlanDataFlag;
            theBusinessPlanDataFlag = (true?this.isBusinessPlanDataFlag():false);
            strategy.appendField(locator, this, "businessPlanDataFlag", buffer, theBusinessPlanDataFlag);
        }
        {
            FinancialDataAmountsType theFinancialDataAmounts;
            theFinancialDataAmounts = this.getFinancialDataAmounts();
            strategy.appendField(locator, this, "financialDataAmounts", buffer, theFinancialDataAmounts);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            XMLGregorianCalendar theClosingDate;
            theClosingDate = this.getClosingDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "closingDate", theClosingDate), currentHashCode, theClosingDate);
        }
        {
            BigInteger theDurationInMonths;
            theDurationInMonths = this.getDurationInMonths();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "durationInMonths", theDurationInMonths), currentHashCode, theDurationInMonths);
        }
        {
            int theYear;
            theYear = (true?this.getYear(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "year", theYear), currentHashCode, theYear);
        }
        {
            XMLGregorianCalendar theValidityDate;
            theValidityDate = this.getValidityDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validityDate", theValidityDate), currentHashCode, theValidityDate);
        }
        {
            BigDecimal theExchangeRate;
            theExchangeRate = this.getExchangeRate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exchangeRate", theExchangeRate), currentHashCode, theExchangeRate);
        }
        {
            CodeRefType theCurrencyCode;
            theCurrencyCode = this.getCurrencyCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currencyCode", theCurrencyCode), currentHashCode, theCurrencyCode);
        }
        {
            boolean theAuditFlag;
            theAuditFlag = (true?this.isAuditFlag():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "auditFlag", theAuditFlag), currentHashCode, theAuditFlag);
        }
        {
            boolean theConsolidatedDataFlag;
            theConsolidatedDataFlag = (true?this.isConsolidatedDataFlag():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "consolidatedDataFlag", theConsolidatedDataFlag), currentHashCode, theConsolidatedDataFlag);
        }
        {
            boolean theBusinessPlanDataFlag;
            theBusinessPlanDataFlag = (true?this.isBusinessPlanDataFlag():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "businessPlanDataFlag", theBusinessPlanDataFlag), currentHashCode, theBusinessPlanDataFlag);
        }
        {
            FinancialDataAmountsType theFinancialDataAmounts;
            theFinancialDataAmounts = this.getFinancialDataAmounts();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "financialDataAmounts", theFinancialDataAmounts), currentHashCode, theFinancialDataAmounts);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
