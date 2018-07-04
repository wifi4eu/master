
package eu.europa.ec.research.fp.model.legalentity.v11;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for PartnersListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartnersListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Partner" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Type" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}SMEPartnerType"/>
 *                   &lt;element name="AnnualBalanceSheet" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="AnnualTurnover" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="ParticipationPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="FinancialYearEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="NumberOfEmployees" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="ExchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="CurrencyCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
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
@XmlType(name = "PartnersListType", propOrder = {
    "partner"
})
public class PartnersListType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Partner", required = true)
    protected List<PartnersListType.Partner> partner;

    /**
     * Gets the value of the partner property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partner property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartner().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartnersListType.Partner }
     * 
     * 
     */
    public List<PartnersListType.Partner> getPartner() {
        if (partner == null) {
            partner = new ArrayList<PartnersListType.Partner>();
        }
        return this.partner;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PartnersListType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PartnersListType that = ((PartnersListType) object);
        {
            List<PartnersListType.Partner> lhsPartner;
            lhsPartner = (((this.partner!= null)&&(!this.partner.isEmpty()))?this.getPartner():null);
            List<PartnersListType.Partner> rhsPartner;
            rhsPartner = (((that.partner!= null)&&(!that.partner.isEmpty()))?that.getPartner():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "partner", lhsPartner), LocatorUtils.property(thatLocator, "partner", rhsPartner), lhsPartner, rhsPartner)) {
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
            List<PartnersListType.Partner> thePartner;
            thePartner = (((this.partner!= null)&&(!this.partner.isEmpty()))?this.getPartner():null);
            strategy.appendField(locator, this, "partner", buffer, thePartner);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<PartnersListType.Partner> thePartner;
            thePartner = (((this.partner!= null)&&(!this.partner.isEmpty()))?this.getPartner():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "partner", thePartner), currentHashCode, thePartner);
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
     *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Type" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}SMEPartnerType"/>
     *         &lt;element name="AnnualBalanceSheet" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="AnnualTurnover" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="ParticipationPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="FinancialYearEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="NumberOfEmployees" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="ExchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="CurrencyCode" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
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
        "name",
        "type",
        "annualBalanceSheet",
        "annualTurnover",
        "participationPercentage",
        "financialYearEndDate",
        "numberOfEmployees",
        "exchangeRate",
        "currencyCode"
    })
    public static class Partner
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "Name")
        protected String name;
        @XmlElement(name = "Type", required = true)
        protected String type;
        @XmlElement(name = "AnnualBalanceSheet")
        protected BigDecimal annualBalanceSheet;
        @XmlElement(name = "AnnualTurnover")
        protected BigDecimal annualTurnover;
        @XmlElement(name = "ParticipationPercentage", required = true)
        protected BigDecimal participationPercentage;
        @XmlElement(name = "FinancialYearEndDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar financialYearEndDate;
        @XmlElement(name = "NumberOfEmployees")
        protected BigInteger numberOfEmployees;
        @XmlElement(name = "ExchangeRate")
        protected BigDecimal exchangeRate;
        @XmlElement(name = "CurrencyCode")
        protected CodeRefType currencyCode;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
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
         * Gets the value of the participationPercentage property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getParticipationPercentage() {
            return participationPercentage;
        }

        /**
         * Sets the value of the participationPercentage property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setParticipationPercentage(BigDecimal value) {
            this.participationPercentage = value;
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

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof PartnersListType.Partner)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final PartnersListType.Partner that = ((PartnersListType.Partner) object);
            {
                String lhsName;
                lhsName = this.getName();
                String rhsName;
                rhsName = that.getName();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                    return false;
                }
            }
            {
                String lhsType;
                lhsType = this.getType();
                String rhsType;
                rhsType = that.getType();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType)) {
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
                BigDecimal lhsParticipationPercentage;
                lhsParticipationPercentage = this.getParticipationPercentage();
                BigDecimal rhsParticipationPercentage;
                rhsParticipationPercentage = that.getParticipationPercentage();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "participationPercentage", lhsParticipationPercentage), LocatorUtils.property(thatLocator, "participationPercentage", rhsParticipationPercentage), lhsParticipationPercentage, rhsParticipationPercentage)) {
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
                String theName;
                theName = this.getName();
                strategy.appendField(locator, this, "name", buffer, theName);
            }
            {
                String theType;
                theType = this.getType();
                strategy.appendField(locator, this, "type", buffer, theType);
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
                BigDecimal theParticipationPercentage;
                theParticipationPercentage = this.getParticipationPercentage();
                strategy.appendField(locator, this, "participationPercentage", buffer, theParticipationPercentage);
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
                BigDecimal theExchangeRate;
                theExchangeRate = this.getExchangeRate();
                strategy.appendField(locator, this, "exchangeRate", buffer, theExchangeRate);
            }
            {
                CodeRefType theCurrencyCode;
                theCurrencyCode = this.getCurrencyCode();
                strategy.appendField(locator, this, "currencyCode", buffer, theCurrencyCode);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theName;
                theName = this.getName();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
            }
            {
                String theType;
                theType = this.getType();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType);
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
                BigDecimal theParticipationPercentage;
                theParticipationPercentage = this.getParticipationPercentage();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "participationPercentage", theParticipationPercentage), currentHashCode, theParticipationPercentage);
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
                BigDecimal theExchangeRate;
                theExchangeRate = this.getExchangeRate();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exchangeRate", theExchangeRate), currentHashCode, theExchangeRate);
            }
            {
                CodeRefType theCurrencyCode;
                theCurrencyCode = this.getCurrencyCode();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currencyCode", theCurrencyCode), currentHashCode, theCurrencyCode);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
