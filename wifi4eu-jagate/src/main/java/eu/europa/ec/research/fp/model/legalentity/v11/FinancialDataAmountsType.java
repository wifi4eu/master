
package eu.europa.ec.research.fp.model.legalentity.v11;

import java.math.BigDecimal;
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
 * <p>Java class for FinancialDataAmountsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FinancialDataAmountsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalAssets" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="SubscribedCapitalUnpaid" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="FixedAssets" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="IntangibleFixedAssets" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="TangibleFixedAssets" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="FinancialAssets" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="CurrentAsset" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="Stocks" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="DebtorsDueInOneYear" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="DebtorsDueAfterOneYear" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="CashBankAndHand" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="OtherCurrentAssets" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="TotalLiabilities" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="CapitalAndReserves" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="SubscribedCapital" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="Reserves" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="ProfitLossPrevYears" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="ProfitLossFinancialYear" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="Creditors" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="LongTermNonBankDebt" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="LongTermBankDebt" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="ShortTermNonBankDebt" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="ShortTermBankDebt" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="Turnover" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="VariationInStocks" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="OtherOperatingIncome" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="OperatingIncome" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="CostMaterialsConsumables" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="OtherOperatingCharges" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="RemunerationAndCharges" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="GrossOperatingProfitOrLoss" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="AdjustNonFclAssets" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="NetOperatingProfitOrLoss" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="AdjustFclAssets" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="InterestPaid" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="SimilarCharges" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="ProfitOrLossOnOrdinaryActivities" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="ExtraordinaryIncome" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="ExtraordinaryCharges" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="TaxesOnProfit" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *         &lt;element name="ProfitOrLossForFinancialYear" type="{http://ec.europa.eu/research/fp/model/base/V1}AmountType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialDataAmountsType", propOrder = {
    "totalAssets",
    "subscribedCapitalUnpaid",
    "fixedAssets",
    "intangibleFixedAssets",
    "tangibleFixedAssets",
    "financialAssets",
    "currentAsset",
    "stocks",
    "debtorsDueInOneYear",
    "debtorsDueAfterOneYear",
    "cashBankAndHand",
    "otherCurrentAssets",
    "totalLiabilities",
    "capitalAndReserves",
    "subscribedCapital",
    "reserves",
    "profitLossPrevYears",
    "profitLossFinancialYear",
    "creditors",
    "longTermNonBankDebt",
    "longTermBankDebt",
    "shortTermNonBankDebt",
    "shortTermBankDebt",
    "turnover",
    "variationInStocks",
    "otherOperatingIncome",
    "operatingIncome",
    "costMaterialsConsumables",
    "otherOperatingCharges",
    "remunerationAndCharges",
    "grossOperatingProfitOrLoss",
    "adjustNonFclAssets",
    "netOperatingProfitOrLoss",
    "adjustFclAssets",
    "interestPaid",
    "similarCharges",
    "profitOrLossOnOrdinaryActivities",
    "extraordinaryIncome",
    "extraordinaryCharges",
    "taxesOnProfit",
    "profitOrLossForFinancialYear"
})
public class FinancialDataAmountsType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "TotalAssets")
    protected BigDecimal totalAssets;
    @XmlElement(name = "SubscribedCapitalUnpaid")
    protected BigDecimal subscribedCapitalUnpaid;
    @XmlElement(name = "FixedAssets")
    protected BigDecimal fixedAssets;
    @XmlElement(name = "IntangibleFixedAssets")
    protected BigDecimal intangibleFixedAssets;
    @XmlElement(name = "TangibleFixedAssets")
    protected BigDecimal tangibleFixedAssets;
    @XmlElement(name = "FinancialAssets")
    protected BigDecimal financialAssets;
    @XmlElement(name = "CurrentAsset")
    protected BigDecimal currentAsset;
    @XmlElement(name = "Stocks")
    protected BigDecimal stocks;
    @XmlElement(name = "DebtorsDueInOneYear")
    protected BigDecimal debtorsDueInOneYear;
    @XmlElement(name = "DebtorsDueAfterOneYear")
    protected BigDecimal debtorsDueAfterOneYear;
    @XmlElement(name = "CashBankAndHand")
    protected BigDecimal cashBankAndHand;
    @XmlElement(name = "OtherCurrentAssets")
    protected BigDecimal otherCurrentAssets;
    @XmlElement(name = "TotalLiabilities")
    protected BigDecimal totalLiabilities;
    @XmlElement(name = "CapitalAndReserves")
    protected BigDecimal capitalAndReserves;
    @XmlElement(name = "SubscribedCapital")
    protected BigDecimal subscribedCapital;
    @XmlElement(name = "Reserves")
    protected BigDecimal reserves;
    @XmlElement(name = "ProfitLossPrevYears")
    protected BigDecimal profitLossPrevYears;
    @XmlElement(name = "ProfitLossFinancialYear")
    protected BigDecimal profitLossFinancialYear;
    @XmlElement(name = "Creditors")
    protected BigDecimal creditors;
    @XmlElement(name = "LongTermNonBankDebt")
    protected BigDecimal longTermNonBankDebt;
    @XmlElement(name = "LongTermBankDebt")
    protected BigDecimal longTermBankDebt;
    @XmlElement(name = "ShortTermNonBankDebt")
    protected BigDecimal shortTermNonBankDebt;
    @XmlElement(name = "ShortTermBankDebt")
    protected BigDecimal shortTermBankDebt;
    @XmlElement(name = "Turnover")
    protected BigDecimal turnover;
    @XmlElement(name = "VariationInStocks")
    protected BigDecimal variationInStocks;
    @XmlElement(name = "OtherOperatingIncome")
    protected BigDecimal otherOperatingIncome;
    @XmlElement(name = "OperatingIncome")
    protected BigDecimal operatingIncome;
    @XmlElement(name = "CostMaterialsConsumables")
    protected BigDecimal costMaterialsConsumables;
    @XmlElement(name = "OtherOperatingCharges")
    protected BigDecimal otherOperatingCharges;
    @XmlElement(name = "RemunerationAndCharges")
    protected BigDecimal remunerationAndCharges;
    @XmlElement(name = "GrossOperatingProfitOrLoss")
    protected BigDecimal grossOperatingProfitOrLoss;
    @XmlElement(name = "AdjustNonFclAssets")
    protected BigDecimal adjustNonFclAssets;
    @XmlElement(name = "NetOperatingProfitOrLoss")
    protected BigDecimal netOperatingProfitOrLoss;
    @XmlElement(name = "AdjustFclAssets")
    protected BigDecimal adjustFclAssets;
    @XmlElement(name = "InterestPaid")
    protected BigDecimal interestPaid;
    @XmlElement(name = "SimilarCharges")
    protected BigDecimal similarCharges;
    @XmlElement(name = "ProfitOrLossOnOrdinaryActivities")
    protected BigDecimal profitOrLossOnOrdinaryActivities;
    @XmlElement(name = "ExtraordinaryIncome")
    protected BigDecimal extraordinaryIncome;
    @XmlElement(name = "ExtraordinaryCharges")
    protected BigDecimal extraordinaryCharges;
    @XmlElement(name = "TaxesOnProfit")
    protected BigDecimal taxesOnProfit;
    @XmlElement(name = "ProfitOrLossForFinancialYear")
    protected BigDecimal profitOrLossForFinancialYear;

    /**
     * Gets the value of the totalAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    /**
     * Sets the value of the totalAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAssets(BigDecimal value) {
        this.totalAssets = value;
    }

    /**
     * Gets the value of the subscribedCapitalUnpaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubscribedCapitalUnpaid() {
        return subscribedCapitalUnpaid;
    }

    /**
     * Sets the value of the subscribedCapitalUnpaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubscribedCapitalUnpaid(BigDecimal value) {
        this.subscribedCapitalUnpaid = value;
    }

    /**
     * Gets the value of the fixedAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFixedAssets() {
        return fixedAssets;
    }

    /**
     * Sets the value of the fixedAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFixedAssets(BigDecimal value) {
        this.fixedAssets = value;
    }

    /**
     * Gets the value of the intangibleFixedAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIntangibleFixedAssets() {
        return intangibleFixedAssets;
    }

    /**
     * Sets the value of the intangibleFixedAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIntangibleFixedAssets(BigDecimal value) {
        this.intangibleFixedAssets = value;
    }

    /**
     * Gets the value of the tangibleFixedAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTangibleFixedAssets() {
        return tangibleFixedAssets;
    }

    /**
     * Sets the value of the tangibleFixedAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTangibleFixedAssets(BigDecimal value) {
        this.tangibleFixedAssets = value;
    }

    /**
     * Gets the value of the financialAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFinancialAssets() {
        return financialAssets;
    }

    /**
     * Sets the value of the financialAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFinancialAssets(BigDecimal value) {
        this.financialAssets = value;
    }

    /**
     * Gets the value of the currentAsset property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentAsset() {
        return currentAsset;
    }

    /**
     * Sets the value of the currentAsset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentAsset(BigDecimal value) {
        this.currentAsset = value;
    }

    /**
     * Gets the value of the stocks property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStocks() {
        return stocks;
    }

    /**
     * Sets the value of the stocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStocks(BigDecimal value) {
        this.stocks = value;
    }

    /**
     * Gets the value of the debtorsDueInOneYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebtorsDueInOneYear() {
        return debtorsDueInOneYear;
    }

    /**
     * Sets the value of the debtorsDueInOneYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebtorsDueInOneYear(BigDecimal value) {
        this.debtorsDueInOneYear = value;
    }

    /**
     * Gets the value of the debtorsDueAfterOneYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebtorsDueAfterOneYear() {
        return debtorsDueAfterOneYear;
    }

    /**
     * Sets the value of the debtorsDueAfterOneYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebtorsDueAfterOneYear(BigDecimal value) {
        this.debtorsDueAfterOneYear = value;
    }

    /**
     * Gets the value of the cashBankAndHand property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCashBankAndHand() {
        return cashBankAndHand;
    }

    /**
     * Sets the value of the cashBankAndHand property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCashBankAndHand(BigDecimal value) {
        this.cashBankAndHand = value;
    }

    /**
     * Gets the value of the otherCurrentAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherCurrentAssets() {
        return otherCurrentAssets;
    }

    /**
     * Sets the value of the otherCurrentAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherCurrentAssets(BigDecimal value) {
        this.otherCurrentAssets = value;
    }

    /**
     * Gets the value of the totalLiabilities property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    /**
     * Sets the value of the totalLiabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalLiabilities(BigDecimal value) {
        this.totalLiabilities = value;
    }

    /**
     * Gets the value of the capitalAndReserves property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCapitalAndReserves() {
        return capitalAndReserves;
    }

    /**
     * Sets the value of the capitalAndReserves property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCapitalAndReserves(BigDecimal value) {
        this.capitalAndReserves = value;
    }

    /**
     * Gets the value of the subscribedCapital property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubscribedCapital() {
        return subscribedCapital;
    }

    /**
     * Sets the value of the subscribedCapital property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubscribedCapital(BigDecimal value) {
        this.subscribedCapital = value;
    }

    /**
     * Gets the value of the reserves property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReserves() {
        return reserves;
    }

    /**
     * Sets the value of the reserves property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReserves(BigDecimal value) {
        this.reserves = value;
    }

    /**
     * Gets the value of the profitLossPrevYears property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProfitLossPrevYears() {
        return profitLossPrevYears;
    }

    /**
     * Sets the value of the profitLossPrevYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProfitLossPrevYears(BigDecimal value) {
        this.profitLossPrevYears = value;
    }

    /**
     * Gets the value of the profitLossFinancialYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProfitLossFinancialYear() {
        return profitLossFinancialYear;
    }

    /**
     * Sets the value of the profitLossFinancialYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProfitLossFinancialYear(BigDecimal value) {
        this.profitLossFinancialYear = value;
    }

    /**
     * Gets the value of the creditors property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCreditors() {
        return creditors;
    }

    /**
     * Sets the value of the creditors property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCreditors(BigDecimal value) {
        this.creditors = value;
    }

    /**
     * Gets the value of the longTermNonBankDebt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLongTermNonBankDebt() {
        return longTermNonBankDebt;
    }

    /**
     * Sets the value of the longTermNonBankDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLongTermNonBankDebt(BigDecimal value) {
        this.longTermNonBankDebt = value;
    }

    /**
     * Gets the value of the longTermBankDebt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLongTermBankDebt() {
        return longTermBankDebt;
    }

    /**
     * Sets the value of the longTermBankDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLongTermBankDebt(BigDecimal value) {
        this.longTermBankDebt = value;
    }

    /**
     * Gets the value of the shortTermNonBankDebt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShortTermNonBankDebt() {
        return shortTermNonBankDebt;
    }

    /**
     * Sets the value of the shortTermNonBankDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShortTermNonBankDebt(BigDecimal value) {
        this.shortTermNonBankDebt = value;
    }

    /**
     * Gets the value of the shortTermBankDebt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShortTermBankDebt() {
        return shortTermBankDebt;
    }

    /**
     * Sets the value of the shortTermBankDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShortTermBankDebt(BigDecimal value) {
        this.shortTermBankDebt = value;
    }

    /**
     * Gets the value of the turnover property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTurnover() {
        return turnover;
    }

    /**
     * Sets the value of the turnover property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTurnover(BigDecimal value) {
        this.turnover = value;
    }

    /**
     * Gets the value of the variationInStocks property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVariationInStocks() {
        return variationInStocks;
    }

    /**
     * Sets the value of the variationInStocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVariationInStocks(BigDecimal value) {
        this.variationInStocks = value;
    }

    /**
     * Gets the value of the otherOperatingIncome property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherOperatingIncome() {
        return otherOperatingIncome;
    }

    /**
     * Sets the value of the otherOperatingIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherOperatingIncome(BigDecimal value) {
        this.otherOperatingIncome = value;
    }

    /**
     * Gets the value of the operatingIncome property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOperatingIncome() {
        return operatingIncome;
    }

    /**
     * Sets the value of the operatingIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOperatingIncome(BigDecimal value) {
        this.operatingIncome = value;
    }

    /**
     * Gets the value of the costMaterialsConsumables property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCostMaterialsConsumables() {
        return costMaterialsConsumables;
    }

    /**
     * Sets the value of the costMaterialsConsumables property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCostMaterialsConsumables(BigDecimal value) {
        this.costMaterialsConsumables = value;
    }

    /**
     * Gets the value of the otherOperatingCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherOperatingCharges() {
        return otherOperatingCharges;
    }

    /**
     * Sets the value of the otherOperatingCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherOperatingCharges(BigDecimal value) {
        this.otherOperatingCharges = value;
    }

    /**
     * Gets the value of the remunerationAndCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRemunerationAndCharges() {
        return remunerationAndCharges;
    }

    /**
     * Sets the value of the remunerationAndCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRemunerationAndCharges(BigDecimal value) {
        this.remunerationAndCharges = value;
    }

    /**
     * Gets the value of the grossOperatingProfitOrLoss property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossOperatingProfitOrLoss() {
        return grossOperatingProfitOrLoss;
    }

    /**
     * Sets the value of the grossOperatingProfitOrLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossOperatingProfitOrLoss(BigDecimal value) {
        this.grossOperatingProfitOrLoss = value;
    }

    /**
     * Gets the value of the adjustNonFclAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAdjustNonFclAssets() {
        return adjustNonFclAssets;
    }

    /**
     * Sets the value of the adjustNonFclAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAdjustNonFclAssets(BigDecimal value) {
        this.adjustNonFclAssets = value;
    }

    /**
     * Gets the value of the netOperatingProfitOrLoss property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetOperatingProfitOrLoss() {
        return netOperatingProfitOrLoss;
    }

    /**
     * Sets the value of the netOperatingProfitOrLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetOperatingProfitOrLoss(BigDecimal value) {
        this.netOperatingProfitOrLoss = value;
    }

    /**
     * Gets the value of the adjustFclAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAdjustFclAssets() {
        return adjustFclAssets;
    }

    /**
     * Sets the value of the adjustFclAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAdjustFclAssets(BigDecimal value) {
        this.adjustFclAssets = value;
    }

    /**
     * Gets the value of the interestPaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInterestPaid() {
        return interestPaid;
    }

    /**
     * Sets the value of the interestPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInterestPaid(BigDecimal value) {
        this.interestPaid = value;
    }

    /**
     * Gets the value of the similarCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSimilarCharges() {
        return similarCharges;
    }

    /**
     * Sets the value of the similarCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSimilarCharges(BigDecimal value) {
        this.similarCharges = value;
    }

    /**
     * Gets the value of the profitOrLossOnOrdinaryActivities property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProfitOrLossOnOrdinaryActivities() {
        return profitOrLossOnOrdinaryActivities;
    }

    /**
     * Sets the value of the profitOrLossOnOrdinaryActivities property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProfitOrLossOnOrdinaryActivities(BigDecimal value) {
        this.profitOrLossOnOrdinaryActivities = value;
    }

    /**
     * Gets the value of the extraordinaryIncome property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExtraordinaryIncome() {
        return extraordinaryIncome;
    }

    /**
     * Sets the value of the extraordinaryIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExtraordinaryIncome(BigDecimal value) {
        this.extraordinaryIncome = value;
    }

    /**
     * Gets the value of the extraordinaryCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExtraordinaryCharges() {
        return extraordinaryCharges;
    }

    /**
     * Sets the value of the extraordinaryCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExtraordinaryCharges(BigDecimal value) {
        this.extraordinaryCharges = value;
    }

    /**
     * Gets the value of the taxesOnProfit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxesOnProfit() {
        return taxesOnProfit;
    }

    /**
     * Sets the value of the taxesOnProfit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxesOnProfit(BigDecimal value) {
        this.taxesOnProfit = value;
    }

    /**
     * Gets the value of the profitOrLossForFinancialYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProfitOrLossForFinancialYear() {
        return profitOrLossForFinancialYear;
    }

    /**
     * Sets the value of the profitOrLossForFinancialYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProfitOrLossForFinancialYear(BigDecimal value) {
        this.profitOrLossForFinancialYear = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FinancialDataAmountsType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FinancialDataAmountsType that = ((FinancialDataAmountsType) object);
        {
            BigDecimal lhsTotalAssets;
            lhsTotalAssets = this.getTotalAssets();
            BigDecimal rhsTotalAssets;
            rhsTotalAssets = that.getTotalAssets();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "totalAssets", lhsTotalAssets), LocatorUtils.property(thatLocator, "totalAssets", rhsTotalAssets), lhsTotalAssets, rhsTotalAssets)) {
                return false;
            }
        }
        {
            BigDecimal lhsSubscribedCapitalUnpaid;
            lhsSubscribedCapitalUnpaid = this.getSubscribedCapitalUnpaid();
            BigDecimal rhsSubscribedCapitalUnpaid;
            rhsSubscribedCapitalUnpaid = that.getSubscribedCapitalUnpaid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subscribedCapitalUnpaid", lhsSubscribedCapitalUnpaid), LocatorUtils.property(thatLocator, "subscribedCapitalUnpaid", rhsSubscribedCapitalUnpaid), lhsSubscribedCapitalUnpaid, rhsSubscribedCapitalUnpaid)) {
                return false;
            }
        }
        {
            BigDecimal lhsFixedAssets;
            lhsFixedAssets = this.getFixedAssets();
            BigDecimal rhsFixedAssets;
            rhsFixedAssets = that.getFixedAssets();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fixedAssets", lhsFixedAssets), LocatorUtils.property(thatLocator, "fixedAssets", rhsFixedAssets), lhsFixedAssets, rhsFixedAssets)) {
                return false;
            }
        }
        {
            BigDecimal lhsIntangibleFixedAssets;
            lhsIntangibleFixedAssets = this.getIntangibleFixedAssets();
            BigDecimal rhsIntangibleFixedAssets;
            rhsIntangibleFixedAssets = that.getIntangibleFixedAssets();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "intangibleFixedAssets", lhsIntangibleFixedAssets), LocatorUtils.property(thatLocator, "intangibleFixedAssets", rhsIntangibleFixedAssets), lhsIntangibleFixedAssets, rhsIntangibleFixedAssets)) {
                return false;
            }
        }
        {
            BigDecimal lhsTangibleFixedAssets;
            lhsTangibleFixedAssets = this.getTangibleFixedAssets();
            BigDecimal rhsTangibleFixedAssets;
            rhsTangibleFixedAssets = that.getTangibleFixedAssets();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tangibleFixedAssets", lhsTangibleFixedAssets), LocatorUtils.property(thatLocator, "tangibleFixedAssets", rhsTangibleFixedAssets), lhsTangibleFixedAssets, rhsTangibleFixedAssets)) {
                return false;
            }
        }
        {
            BigDecimal lhsFinancialAssets;
            lhsFinancialAssets = this.getFinancialAssets();
            BigDecimal rhsFinancialAssets;
            rhsFinancialAssets = that.getFinancialAssets();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "financialAssets", lhsFinancialAssets), LocatorUtils.property(thatLocator, "financialAssets", rhsFinancialAssets), lhsFinancialAssets, rhsFinancialAssets)) {
                return false;
            }
        }
        {
            BigDecimal lhsCurrentAsset;
            lhsCurrentAsset = this.getCurrentAsset();
            BigDecimal rhsCurrentAsset;
            rhsCurrentAsset = that.getCurrentAsset();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "currentAsset", lhsCurrentAsset), LocatorUtils.property(thatLocator, "currentAsset", rhsCurrentAsset), lhsCurrentAsset, rhsCurrentAsset)) {
                return false;
            }
        }
        {
            BigDecimal lhsStocks;
            lhsStocks = this.getStocks();
            BigDecimal rhsStocks;
            rhsStocks = that.getStocks();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "stocks", lhsStocks), LocatorUtils.property(thatLocator, "stocks", rhsStocks), lhsStocks, rhsStocks)) {
                return false;
            }
        }
        {
            BigDecimal lhsDebtorsDueInOneYear;
            lhsDebtorsDueInOneYear = this.getDebtorsDueInOneYear();
            BigDecimal rhsDebtorsDueInOneYear;
            rhsDebtorsDueInOneYear = that.getDebtorsDueInOneYear();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "debtorsDueInOneYear", lhsDebtorsDueInOneYear), LocatorUtils.property(thatLocator, "debtorsDueInOneYear", rhsDebtorsDueInOneYear), lhsDebtorsDueInOneYear, rhsDebtorsDueInOneYear)) {
                return false;
            }
        }
        {
            BigDecimal lhsDebtorsDueAfterOneYear;
            lhsDebtorsDueAfterOneYear = this.getDebtorsDueAfterOneYear();
            BigDecimal rhsDebtorsDueAfterOneYear;
            rhsDebtorsDueAfterOneYear = that.getDebtorsDueAfterOneYear();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "debtorsDueAfterOneYear", lhsDebtorsDueAfterOneYear), LocatorUtils.property(thatLocator, "debtorsDueAfterOneYear", rhsDebtorsDueAfterOneYear), lhsDebtorsDueAfterOneYear, rhsDebtorsDueAfterOneYear)) {
                return false;
            }
        }
        {
            BigDecimal lhsCashBankAndHand;
            lhsCashBankAndHand = this.getCashBankAndHand();
            BigDecimal rhsCashBankAndHand;
            rhsCashBankAndHand = that.getCashBankAndHand();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cashBankAndHand", lhsCashBankAndHand), LocatorUtils.property(thatLocator, "cashBankAndHand", rhsCashBankAndHand), lhsCashBankAndHand, rhsCashBankAndHand)) {
                return false;
            }
        }
        {
            BigDecimal lhsOtherCurrentAssets;
            lhsOtherCurrentAssets = this.getOtherCurrentAssets();
            BigDecimal rhsOtherCurrentAssets;
            rhsOtherCurrentAssets = that.getOtherCurrentAssets();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "otherCurrentAssets", lhsOtherCurrentAssets), LocatorUtils.property(thatLocator, "otherCurrentAssets", rhsOtherCurrentAssets), lhsOtherCurrentAssets, rhsOtherCurrentAssets)) {
                return false;
            }
        }
        {
            BigDecimal lhsTotalLiabilities;
            lhsTotalLiabilities = this.getTotalLiabilities();
            BigDecimal rhsTotalLiabilities;
            rhsTotalLiabilities = that.getTotalLiabilities();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "totalLiabilities", lhsTotalLiabilities), LocatorUtils.property(thatLocator, "totalLiabilities", rhsTotalLiabilities), lhsTotalLiabilities, rhsTotalLiabilities)) {
                return false;
            }
        }
        {
            BigDecimal lhsCapitalAndReserves;
            lhsCapitalAndReserves = this.getCapitalAndReserves();
            BigDecimal rhsCapitalAndReserves;
            rhsCapitalAndReserves = that.getCapitalAndReserves();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "capitalAndReserves", lhsCapitalAndReserves), LocatorUtils.property(thatLocator, "capitalAndReserves", rhsCapitalAndReserves), lhsCapitalAndReserves, rhsCapitalAndReserves)) {
                return false;
            }
        }
        {
            BigDecimal lhsSubscribedCapital;
            lhsSubscribedCapital = this.getSubscribedCapital();
            BigDecimal rhsSubscribedCapital;
            rhsSubscribedCapital = that.getSubscribedCapital();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subscribedCapital", lhsSubscribedCapital), LocatorUtils.property(thatLocator, "subscribedCapital", rhsSubscribedCapital), lhsSubscribedCapital, rhsSubscribedCapital)) {
                return false;
            }
        }
        {
            BigDecimal lhsReserves;
            lhsReserves = this.getReserves();
            BigDecimal rhsReserves;
            rhsReserves = that.getReserves();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reserves", lhsReserves), LocatorUtils.property(thatLocator, "reserves", rhsReserves), lhsReserves, rhsReserves)) {
                return false;
            }
        }
        {
            BigDecimal lhsProfitLossPrevYears;
            lhsProfitLossPrevYears = this.getProfitLossPrevYears();
            BigDecimal rhsProfitLossPrevYears;
            rhsProfitLossPrevYears = that.getProfitLossPrevYears();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "profitLossPrevYears", lhsProfitLossPrevYears), LocatorUtils.property(thatLocator, "profitLossPrevYears", rhsProfitLossPrevYears), lhsProfitLossPrevYears, rhsProfitLossPrevYears)) {
                return false;
            }
        }
        {
            BigDecimal lhsProfitLossFinancialYear;
            lhsProfitLossFinancialYear = this.getProfitLossFinancialYear();
            BigDecimal rhsProfitLossFinancialYear;
            rhsProfitLossFinancialYear = that.getProfitLossFinancialYear();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "profitLossFinancialYear", lhsProfitLossFinancialYear), LocatorUtils.property(thatLocator, "profitLossFinancialYear", rhsProfitLossFinancialYear), lhsProfitLossFinancialYear, rhsProfitLossFinancialYear)) {
                return false;
            }
        }
        {
            BigDecimal lhsCreditors;
            lhsCreditors = this.getCreditors();
            BigDecimal rhsCreditors;
            rhsCreditors = that.getCreditors();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creditors", lhsCreditors), LocatorUtils.property(thatLocator, "creditors", rhsCreditors), lhsCreditors, rhsCreditors)) {
                return false;
            }
        }
        {
            BigDecimal lhsLongTermNonBankDebt;
            lhsLongTermNonBankDebt = this.getLongTermNonBankDebt();
            BigDecimal rhsLongTermNonBankDebt;
            rhsLongTermNonBankDebt = that.getLongTermNonBankDebt();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "longTermNonBankDebt", lhsLongTermNonBankDebt), LocatorUtils.property(thatLocator, "longTermNonBankDebt", rhsLongTermNonBankDebt), lhsLongTermNonBankDebt, rhsLongTermNonBankDebt)) {
                return false;
            }
        }
        {
            BigDecimal lhsLongTermBankDebt;
            lhsLongTermBankDebt = this.getLongTermBankDebt();
            BigDecimal rhsLongTermBankDebt;
            rhsLongTermBankDebt = that.getLongTermBankDebt();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "longTermBankDebt", lhsLongTermBankDebt), LocatorUtils.property(thatLocator, "longTermBankDebt", rhsLongTermBankDebt), lhsLongTermBankDebt, rhsLongTermBankDebt)) {
                return false;
            }
        }
        {
            BigDecimal lhsShortTermNonBankDebt;
            lhsShortTermNonBankDebt = this.getShortTermNonBankDebt();
            BigDecimal rhsShortTermNonBankDebt;
            rhsShortTermNonBankDebt = that.getShortTermNonBankDebt();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "shortTermNonBankDebt", lhsShortTermNonBankDebt), LocatorUtils.property(thatLocator, "shortTermNonBankDebt", rhsShortTermNonBankDebt), lhsShortTermNonBankDebt, rhsShortTermNonBankDebt)) {
                return false;
            }
        }
        {
            BigDecimal lhsShortTermBankDebt;
            lhsShortTermBankDebt = this.getShortTermBankDebt();
            BigDecimal rhsShortTermBankDebt;
            rhsShortTermBankDebt = that.getShortTermBankDebt();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "shortTermBankDebt", lhsShortTermBankDebt), LocatorUtils.property(thatLocator, "shortTermBankDebt", rhsShortTermBankDebt), lhsShortTermBankDebt, rhsShortTermBankDebt)) {
                return false;
            }
        }
        {
            BigDecimal lhsTurnover;
            lhsTurnover = this.getTurnover();
            BigDecimal rhsTurnover;
            rhsTurnover = that.getTurnover();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "turnover", lhsTurnover), LocatorUtils.property(thatLocator, "turnover", rhsTurnover), lhsTurnover, rhsTurnover)) {
                return false;
            }
        }
        {
            BigDecimal lhsVariationInStocks;
            lhsVariationInStocks = this.getVariationInStocks();
            BigDecimal rhsVariationInStocks;
            rhsVariationInStocks = that.getVariationInStocks();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "variationInStocks", lhsVariationInStocks), LocatorUtils.property(thatLocator, "variationInStocks", rhsVariationInStocks), lhsVariationInStocks, rhsVariationInStocks)) {
                return false;
            }
        }
        {
            BigDecimal lhsOtherOperatingIncome;
            lhsOtherOperatingIncome = this.getOtherOperatingIncome();
            BigDecimal rhsOtherOperatingIncome;
            rhsOtherOperatingIncome = that.getOtherOperatingIncome();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "otherOperatingIncome", lhsOtherOperatingIncome), LocatorUtils.property(thatLocator, "otherOperatingIncome", rhsOtherOperatingIncome), lhsOtherOperatingIncome, rhsOtherOperatingIncome)) {
                return false;
            }
        }
        {
            BigDecimal lhsOperatingIncome;
            lhsOperatingIncome = this.getOperatingIncome();
            BigDecimal rhsOperatingIncome;
            rhsOperatingIncome = that.getOperatingIncome();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "operatingIncome", lhsOperatingIncome), LocatorUtils.property(thatLocator, "operatingIncome", rhsOperatingIncome), lhsOperatingIncome, rhsOperatingIncome)) {
                return false;
            }
        }
        {
            BigDecimal lhsCostMaterialsConsumables;
            lhsCostMaterialsConsumables = this.getCostMaterialsConsumables();
            BigDecimal rhsCostMaterialsConsumables;
            rhsCostMaterialsConsumables = that.getCostMaterialsConsumables();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "costMaterialsConsumables", lhsCostMaterialsConsumables), LocatorUtils.property(thatLocator, "costMaterialsConsumables", rhsCostMaterialsConsumables), lhsCostMaterialsConsumables, rhsCostMaterialsConsumables)) {
                return false;
            }
        }
        {
            BigDecimal lhsOtherOperatingCharges;
            lhsOtherOperatingCharges = this.getOtherOperatingCharges();
            BigDecimal rhsOtherOperatingCharges;
            rhsOtherOperatingCharges = that.getOtherOperatingCharges();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "otherOperatingCharges", lhsOtherOperatingCharges), LocatorUtils.property(thatLocator, "otherOperatingCharges", rhsOtherOperatingCharges), lhsOtherOperatingCharges, rhsOtherOperatingCharges)) {
                return false;
            }
        }
        {
            BigDecimal lhsRemunerationAndCharges;
            lhsRemunerationAndCharges = this.getRemunerationAndCharges();
            BigDecimal rhsRemunerationAndCharges;
            rhsRemunerationAndCharges = that.getRemunerationAndCharges();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "remunerationAndCharges", lhsRemunerationAndCharges), LocatorUtils.property(thatLocator, "remunerationAndCharges", rhsRemunerationAndCharges), lhsRemunerationAndCharges, rhsRemunerationAndCharges)) {
                return false;
            }
        }
        {
            BigDecimal lhsGrossOperatingProfitOrLoss;
            lhsGrossOperatingProfitOrLoss = this.getGrossOperatingProfitOrLoss();
            BigDecimal rhsGrossOperatingProfitOrLoss;
            rhsGrossOperatingProfitOrLoss = that.getGrossOperatingProfitOrLoss();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "grossOperatingProfitOrLoss", lhsGrossOperatingProfitOrLoss), LocatorUtils.property(thatLocator, "grossOperatingProfitOrLoss", rhsGrossOperatingProfitOrLoss), lhsGrossOperatingProfitOrLoss, rhsGrossOperatingProfitOrLoss)) {
                return false;
            }
        }
        {
            BigDecimal lhsAdjustNonFclAssets;
            lhsAdjustNonFclAssets = this.getAdjustNonFclAssets();
            BigDecimal rhsAdjustNonFclAssets;
            rhsAdjustNonFclAssets = that.getAdjustNonFclAssets();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "adjustNonFclAssets", lhsAdjustNonFclAssets), LocatorUtils.property(thatLocator, "adjustNonFclAssets", rhsAdjustNonFclAssets), lhsAdjustNonFclAssets, rhsAdjustNonFclAssets)) {
                return false;
            }
        }
        {
            BigDecimal lhsNetOperatingProfitOrLoss;
            lhsNetOperatingProfitOrLoss = this.getNetOperatingProfitOrLoss();
            BigDecimal rhsNetOperatingProfitOrLoss;
            rhsNetOperatingProfitOrLoss = that.getNetOperatingProfitOrLoss();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "netOperatingProfitOrLoss", lhsNetOperatingProfitOrLoss), LocatorUtils.property(thatLocator, "netOperatingProfitOrLoss", rhsNetOperatingProfitOrLoss), lhsNetOperatingProfitOrLoss, rhsNetOperatingProfitOrLoss)) {
                return false;
            }
        }
        {
            BigDecimal lhsAdjustFclAssets;
            lhsAdjustFclAssets = this.getAdjustFclAssets();
            BigDecimal rhsAdjustFclAssets;
            rhsAdjustFclAssets = that.getAdjustFclAssets();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "adjustFclAssets", lhsAdjustFclAssets), LocatorUtils.property(thatLocator, "adjustFclAssets", rhsAdjustFclAssets), lhsAdjustFclAssets, rhsAdjustFclAssets)) {
                return false;
            }
        }
        {
            BigDecimal lhsInterestPaid;
            lhsInterestPaid = this.getInterestPaid();
            BigDecimal rhsInterestPaid;
            rhsInterestPaid = that.getInterestPaid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "interestPaid", lhsInterestPaid), LocatorUtils.property(thatLocator, "interestPaid", rhsInterestPaid), lhsInterestPaid, rhsInterestPaid)) {
                return false;
            }
        }
        {
            BigDecimal lhsSimilarCharges;
            lhsSimilarCharges = this.getSimilarCharges();
            BigDecimal rhsSimilarCharges;
            rhsSimilarCharges = that.getSimilarCharges();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "similarCharges", lhsSimilarCharges), LocatorUtils.property(thatLocator, "similarCharges", rhsSimilarCharges), lhsSimilarCharges, rhsSimilarCharges)) {
                return false;
            }
        }
        {
            BigDecimal lhsProfitOrLossOnOrdinaryActivities;
            lhsProfitOrLossOnOrdinaryActivities = this.getProfitOrLossOnOrdinaryActivities();
            BigDecimal rhsProfitOrLossOnOrdinaryActivities;
            rhsProfitOrLossOnOrdinaryActivities = that.getProfitOrLossOnOrdinaryActivities();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "profitOrLossOnOrdinaryActivities", lhsProfitOrLossOnOrdinaryActivities), LocatorUtils.property(thatLocator, "profitOrLossOnOrdinaryActivities", rhsProfitOrLossOnOrdinaryActivities), lhsProfitOrLossOnOrdinaryActivities, rhsProfitOrLossOnOrdinaryActivities)) {
                return false;
            }
        }
        {
            BigDecimal lhsExtraordinaryIncome;
            lhsExtraordinaryIncome = this.getExtraordinaryIncome();
            BigDecimal rhsExtraordinaryIncome;
            rhsExtraordinaryIncome = that.getExtraordinaryIncome();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extraordinaryIncome", lhsExtraordinaryIncome), LocatorUtils.property(thatLocator, "extraordinaryIncome", rhsExtraordinaryIncome), lhsExtraordinaryIncome, rhsExtraordinaryIncome)) {
                return false;
            }
        }
        {
            BigDecimal lhsExtraordinaryCharges;
            lhsExtraordinaryCharges = this.getExtraordinaryCharges();
            BigDecimal rhsExtraordinaryCharges;
            rhsExtraordinaryCharges = that.getExtraordinaryCharges();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extraordinaryCharges", lhsExtraordinaryCharges), LocatorUtils.property(thatLocator, "extraordinaryCharges", rhsExtraordinaryCharges), lhsExtraordinaryCharges, rhsExtraordinaryCharges)) {
                return false;
            }
        }
        {
            BigDecimal lhsTaxesOnProfit;
            lhsTaxesOnProfit = this.getTaxesOnProfit();
            BigDecimal rhsTaxesOnProfit;
            rhsTaxesOnProfit = that.getTaxesOnProfit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "taxesOnProfit", lhsTaxesOnProfit), LocatorUtils.property(thatLocator, "taxesOnProfit", rhsTaxesOnProfit), lhsTaxesOnProfit, rhsTaxesOnProfit)) {
                return false;
            }
        }
        {
            BigDecimal lhsProfitOrLossForFinancialYear;
            lhsProfitOrLossForFinancialYear = this.getProfitOrLossForFinancialYear();
            BigDecimal rhsProfitOrLossForFinancialYear;
            rhsProfitOrLossForFinancialYear = that.getProfitOrLossForFinancialYear();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "profitOrLossForFinancialYear", lhsProfitOrLossForFinancialYear), LocatorUtils.property(thatLocator, "profitOrLossForFinancialYear", rhsProfitOrLossForFinancialYear), lhsProfitOrLossForFinancialYear, rhsProfitOrLossForFinancialYear)) {
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
            BigDecimal theTotalAssets;
            theTotalAssets = this.getTotalAssets();
            strategy.appendField(locator, this, "totalAssets", buffer, theTotalAssets);
        }
        {
            BigDecimal theSubscribedCapitalUnpaid;
            theSubscribedCapitalUnpaid = this.getSubscribedCapitalUnpaid();
            strategy.appendField(locator, this, "subscribedCapitalUnpaid", buffer, theSubscribedCapitalUnpaid);
        }
        {
            BigDecimal theFixedAssets;
            theFixedAssets = this.getFixedAssets();
            strategy.appendField(locator, this, "fixedAssets", buffer, theFixedAssets);
        }
        {
            BigDecimal theIntangibleFixedAssets;
            theIntangibleFixedAssets = this.getIntangibleFixedAssets();
            strategy.appendField(locator, this, "intangibleFixedAssets", buffer, theIntangibleFixedAssets);
        }
        {
            BigDecimal theTangibleFixedAssets;
            theTangibleFixedAssets = this.getTangibleFixedAssets();
            strategy.appendField(locator, this, "tangibleFixedAssets", buffer, theTangibleFixedAssets);
        }
        {
            BigDecimal theFinancialAssets;
            theFinancialAssets = this.getFinancialAssets();
            strategy.appendField(locator, this, "financialAssets", buffer, theFinancialAssets);
        }
        {
            BigDecimal theCurrentAsset;
            theCurrentAsset = this.getCurrentAsset();
            strategy.appendField(locator, this, "currentAsset", buffer, theCurrentAsset);
        }
        {
            BigDecimal theStocks;
            theStocks = this.getStocks();
            strategy.appendField(locator, this, "stocks", buffer, theStocks);
        }
        {
            BigDecimal theDebtorsDueInOneYear;
            theDebtorsDueInOneYear = this.getDebtorsDueInOneYear();
            strategy.appendField(locator, this, "debtorsDueInOneYear", buffer, theDebtorsDueInOneYear);
        }
        {
            BigDecimal theDebtorsDueAfterOneYear;
            theDebtorsDueAfterOneYear = this.getDebtorsDueAfterOneYear();
            strategy.appendField(locator, this, "debtorsDueAfterOneYear", buffer, theDebtorsDueAfterOneYear);
        }
        {
            BigDecimal theCashBankAndHand;
            theCashBankAndHand = this.getCashBankAndHand();
            strategy.appendField(locator, this, "cashBankAndHand", buffer, theCashBankAndHand);
        }
        {
            BigDecimal theOtherCurrentAssets;
            theOtherCurrentAssets = this.getOtherCurrentAssets();
            strategy.appendField(locator, this, "otherCurrentAssets", buffer, theOtherCurrentAssets);
        }
        {
            BigDecimal theTotalLiabilities;
            theTotalLiabilities = this.getTotalLiabilities();
            strategy.appendField(locator, this, "totalLiabilities", buffer, theTotalLiabilities);
        }
        {
            BigDecimal theCapitalAndReserves;
            theCapitalAndReserves = this.getCapitalAndReserves();
            strategy.appendField(locator, this, "capitalAndReserves", buffer, theCapitalAndReserves);
        }
        {
            BigDecimal theSubscribedCapital;
            theSubscribedCapital = this.getSubscribedCapital();
            strategy.appendField(locator, this, "subscribedCapital", buffer, theSubscribedCapital);
        }
        {
            BigDecimal theReserves;
            theReserves = this.getReserves();
            strategy.appendField(locator, this, "reserves", buffer, theReserves);
        }
        {
            BigDecimal theProfitLossPrevYears;
            theProfitLossPrevYears = this.getProfitLossPrevYears();
            strategy.appendField(locator, this, "profitLossPrevYears", buffer, theProfitLossPrevYears);
        }
        {
            BigDecimal theProfitLossFinancialYear;
            theProfitLossFinancialYear = this.getProfitLossFinancialYear();
            strategy.appendField(locator, this, "profitLossFinancialYear", buffer, theProfitLossFinancialYear);
        }
        {
            BigDecimal theCreditors;
            theCreditors = this.getCreditors();
            strategy.appendField(locator, this, "creditors", buffer, theCreditors);
        }
        {
            BigDecimal theLongTermNonBankDebt;
            theLongTermNonBankDebt = this.getLongTermNonBankDebt();
            strategy.appendField(locator, this, "longTermNonBankDebt", buffer, theLongTermNonBankDebt);
        }
        {
            BigDecimal theLongTermBankDebt;
            theLongTermBankDebt = this.getLongTermBankDebt();
            strategy.appendField(locator, this, "longTermBankDebt", buffer, theLongTermBankDebt);
        }
        {
            BigDecimal theShortTermNonBankDebt;
            theShortTermNonBankDebt = this.getShortTermNonBankDebt();
            strategy.appendField(locator, this, "shortTermNonBankDebt", buffer, theShortTermNonBankDebt);
        }
        {
            BigDecimal theShortTermBankDebt;
            theShortTermBankDebt = this.getShortTermBankDebt();
            strategy.appendField(locator, this, "shortTermBankDebt", buffer, theShortTermBankDebt);
        }
        {
            BigDecimal theTurnover;
            theTurnover = this.getTurnover();
            strategy.appendField(locator, this, "turnover", buffer, theTurnover);
        }
        {
            BigDecimal theVariationInStocks;
            theVariationInStocks = this.getVariationInStocks();
            strategy.appendField(locator, this, "variationInStocks", buffer, theVariationInStocks);
        }
        {
            BigDecimal theOtherOperatingIncome;
            theOtherOperatingIncome = this.getOtherOperatingIncome();
            strategy.appendField(locator, this, "otherOperatingIncome", buffer, theOtherOperatingIncome);
        }
        {
            BigDecimal theOperatingIncome;
            theOperatingIncome = this.getOperatingIncome();
            strategy.appendField(locator, this, "operatingIncome", buffer, theOperatingIncome);
        }
        {
            BigDecimal theCostMaterialsConsumables;
            theCostMaterialsConsumables = this.getCostMaterialsConsumables();
            strategy.appendField(locator, this, "costMaterialsConsumables", buffer, theCostMaterialsConsumables);
        }
        {
            BigDecimal theOtherOperatingCharges;
            theOtherOperatingCharges = this.getOtherOperatingCharges();
            strategy.appendField(locator, this, "otherOperatingCharges", buffer, theOtherOperatingCharges);
        }
        {
            BigDecimal theRemunerationAndCharges;
            theRemunerationAndCharges = this.getRemunerationAndCharges();
            strategy.appendField(locator, this, "remunerationAndCharges", buffer, theRemunerationAndCharges);
        }
        {
            BigDecimal theGrossOperatingProfitOrLoss;
            theGrossOperatingProfitOrLoss = this.getGrossOperatingProfitOrLoss();
            strategy.appendField(locator, this, "grossOperatingProfitOrLoss", buffer, theGrossOperatingProfitOrLoss);
        }
        {
            BigDecimal theAdjustNonFclAssets;
            theAdjustNonFclAssets = this.getAdjustNonFclAssets();
            strategy.appendField(locator, this, "adjustNonFclAssets", buffer, theAdjustNonFclAssets);
        }
        {
            BigDecimal theNetOperatingProfitOrLoss;
            theNetOperatingProfitOrLoss = this.getNetOperatingProfitOrLoss();
            strategy.appendField(locator, this, "netOperatingProfitOrLoss", buffer, theNetOperatingProfitOrLoss);
        }
        {
            BigDecimal theAdjustFclAssets;
            theAdjustFclAssets = this.getAdjustFclAssets();
            strategy.appendField(locator, this, "adjustFclAssets", buffer, theAdjustFclAssets);
        }
        {
            BigDecimal theInterestPaid;
            theInterestPaid = this.getInterestPaid();
            strategy.appendField(locator, this, "interestPaid", buffer, theInterestPaid);
        }
        {
            BigDecimal theSimilarCharges;
            theSimilarCharges = this.getSimilarCharges();
            strategy.appendField(locator, this, "similarCharges", buffer, theSimilarCharges);
        }
        {
            BigDecimal theProfitOrLossOnOrdinaryActivities;
            theProfitOrLossOnOrdinaryActivities = this.getProfitOrLossOnOrdinaryActivities();
            strategy.appendField(locator, this, "profitOrLossOnOrdinaryActivities", buffer, theProfitOrLossOnOrdinaryActivities);
        }
        {
            BigDecimal theExtraordinaryIncome;
            theExtraordinaryIncome = this.getExtraordinaryIncome();
            strategy.appendField(locator, this, "extraordinaryIncome", buffer, theExtraordinaryIncome);
        }
        {
            BigDecimal theExtraordinaryCharges;
            theExtraordinaryCharges = this.getExtraordinaryCharges();
            strategy.appendField(locator, this, "extraordinaryCharges", buffer, theExtraordinaryCharges);
        }
        {
            BigDecimal theTaxesOnProfit;
            theTaxesOnProfit = this.getTaxesOnProfit();
            strategy.appendField(locator, this, "taxesOnProfit", buffer, theTaxesOnProfit);
        }
        {
            BigDecimal theProfitOrLossForFinancialYear;
            theProfitOrLossForFinancialYear = this.getProfitOrLossForFinancialYear();
            strategy.appendField(locator, this, "profitOrLossForFinancialYear", buffer, theProfitOrLossForFinancialYear);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            BigDecimal theTotalAssets;
            theTotalAssets = this.getTotalAssets();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalAssets", theTotalAssets), currentHashCode, theTotalAssets);
        }
        {
            BigDecimal theSubscribedCapitalUnpaid;
            theSubscribedCapitalUnpaid = this.getSubscribedCapitalUnpaid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subscribedCapitalUnpaid", theSubscribedCapitalUnpaid), currentHashCode, theSubscribedCapitalUnpaid);
        }
        {
            BigDecimal theFixedAssets;
            theFixedAssets = this.getFixedAssets();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fixedAssets", theFixedAssets), currentHashCode, theFixedAssets);
        }
        {
            BigDecimal theIntangibleFixedAssets;
            theIntangibleFixedAssets = this.getIntangibleFixedAssets();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "intangibleFixedAssets", theIntangibleFixedAssets), currentHashCode, theIntangibleFixedAssets);
        }
        {
            BigDecimal theTangibleFixedAssets;
            theTangibleFixedAssets = this.getTangibleFixedAssets();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tangibleFixedAssets", theTangibleFixedAssets), currentHashCode, theTangibleFixedAssets);
        }
        {
            BigDecimal theFinancialAssets;
            theFinancialAssets = this.getFinancialAssets();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "financialAssets", theFinancialAssets), currentHashCode, theFinancialAssets);
        }
        {
            BigDecimal theCurrentAsset;
            theCurrentAsset = this.getCurrentAsset();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currentAsset", theCurrentAsset), currentHashCode, theCurrentAsset);
        }
        {
            BigDecimal theStocks;
            theStocks = this.getStocks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "stocks", theStocks), currentHashCode, theStocks);
        }
        {
            BigDecimal theDebtorsDueInOneYear;
            theDebtorsDueInOneYear = this.getDebtorsDueInOneYear();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "debtorsDueInOneYear", theDebtorsDueInOneYear), currentHashCode, theDebtorsDueInOneYear);
        }
        {
            BigDecimal theDebtorsDueAfterOneYear;
            theDebtorsDueAfterOneYear = this.getDebtorsDueAfterOneYear();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "debtorsDueAfterOneYear", theDebtorsDueAfterOneYear), currentHashCode, theDebtorsDueAfterOneYear);
        }
        {
            BigDecimal theCashBankAndHand;
            theCashBankAndHand = this.getCashBankAndHand();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cashBankAndHand", theCashBankAndHand), currentHashCode, theCashBankAndHand);
        }
        {
            BigDecimal theOtherCurrentAssets;
            theOtherCurrentAssets = this.getOtherCurrentAssets();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otherCurrentAssets", theOtherCurrentAssets), currentHashCode, theOtherCurrentAssets);
        }
        {
            BigDecimal theTotalLiabilities;
            theTotalLiabilities = this.getTotalLiabilities();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalLiabilities", theTotalLiabilities), currentHashCode, theTotalLiabilities);
        }
        {
            BigDecimal theCapitalAndReserves;
            theCapitalAndReserves = this.getCapitalAndReserves();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "capitalAndReserves", theCapitalAndReserves), currentHashCode, theCapitalAndReserves);
        }
        {
            BigDecimal theSubscribedCapital;
            theSubscribedCapital = this.getSubscribedCapital();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subscribedCapital", theSubscribedCapital), currentHashCode, theSubscribedCapital);
        }
        {
            BigDecimal theReserves;
            theReserves = this.getReserves();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reserves", theReserves), currentHashCode, theReserves);
        }
        {
            BigDecimal theProfitLossPrevYears;
            theProfitLossPrevYears = this.getProfitLossPrevYears();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "profitLossPrevYears", theProfitLossPrevYears), currentHashCode, theProfitLossPrevYears);
        }
        {
            BigDecimal theProfitLossFinancialYear;
            theProfitLossFinancialYear = this.getProfitLossFinancialYear();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "profitLossFinancialYear", theProfitLossFinancialYear), currentHashCode, theProfitLossFinancialYear);
        }
        {
            BigDecimal theCreditors;
            theCreditors = this.getCreditors();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creditors", theCreditors), currentHashCode, theCreditors);
        }
        {
            BigDecimal theLongTermNonBankDebt;
            theLongTermNonBankDebt = this.getLongTermNonBankDebt();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "longTermNonBankDebt", theLongTermNonBankDebt), currentHashCode, theLongTermNonBankDebt);
        }
        {
            BigDecimal theLongTermBankDebt;
            theLongTermBankDebt = this.getLongTermBankDebt();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "longTermBankDebt", theLongTermBankDebt), currentHashCode, theLongTermBankDebt);
        }
        {
            BigDecimal theShortTermNonBankDebt;
            theShortTermNonBankDebt = this.getShortTermNonBankDebt();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "shortTermNonBankDebt", theShortTermNonBankDebt), currentHashCode, theShortTermNonBankDebt);
        }
        {
            BigDecimal theShortTermBankDebt;
            theShortTermBankDebt = this.getShortTermBankDebt();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "shortTermBankDebt", theShortTermBankDebt), currentHashCode, theShortTermBankDebt);
        }
        {
            BigDecimal theTurnover;
            theTurnover = this.getTurnover();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "turnover", theTurnover), currentHashCode, theTurnover);
        }
        {
            BigDecimal theVariationInStocks;
            theVariationInStocks = this.getVariationInStocks();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "variationInStocks", theVariationInStocks), currentHashCode, theVariationInStocks);
        }
        {
            BigDecimal theOtherOperatingIncome;
            theOtherOperatingIncome = this.getOtherOperatingIncome();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otherOperatingIncome", theOtherOperatingIncome), currentHashCode, theOtherOperatingIncome);
        }
        {
            BigDecimal theOperatingIncome;
            theOperatingIncome = this.getOperatingIncome();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "operatingIncome", theOperatingIncome), currentHashCode, theOperatingIncome);
        }
        {
            BigDecimal theCostMaterialsConsumables;
            theCostMaterialsConsumables = this.getCostMaterialsConsumables();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "costMaterialsConsumables", theCostMaterialsConsumables), currentHashCode, theCostMaterialsConsumables);
        }
        {
            BigDecimal theOtherOperatingCharges;
            theOtherOperatingCharges = this.getOtherOperatingCharges();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "otherOperatingCharges", theOtherOperatingCharges), currentHashCode, theOtherOperatingCharges);
        }
        {
            BigDecimal theRemunerationAndCharges;
            theRemunerationAndCharges = this.getRemunerationAndCharges();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "remunerationAndCharges", theRemunerationAndCharges), currentHashCode, theRemunerationAndCharges);
        }
        {
            BigDecimal theGrossOperatingProfitOrLoss;
            theGrossOperatingProfitOrLoss = this.getGrossOperatingProfitOrLoss();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "grossOperatingProfitOrLoss", theGrossOperatingProfitOrLoss), currentHashCode, theGrossOperatingProfitOrLoss);
        }
        {
            BigDecimal theAdjustNonFclAssets;
            theAdjustNonFclAssets = this.getAdjustNonFclAssets();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "adjustNonFclAssets", theAdjustNonFclAssets), currentHashCode, theAdjustNonFclAssets);
        }
        {
            BigDecimal theNetOperatingProfitOrLoss;
            theNetOperatingProfitOrLoss = this.getNetOperatingProfitOrLoss();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "netOperatingProfitOrLoss", theNetOperatingProfitOrLoss), currentHashCode, theNetOperatingProfitOrLoss);
        }
        {
            BigDecimal theAdjustFclAssets;
            theAdjustFclAssets = this.getAdjustFclAssets();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "adjustFclAssets", theAdjustFclAssets), currentHashCode, theAdjustFclAssets);
        }
        {
            BigDecimal theInterestPaid;
            theInterestPaid = this.getInterestPaid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "interestPaid", theInterestPaid), currentHashCode, theInterestPaid);
        }
        {
            BigDecimal theSimilarCharges;
            theSimilarCharges = this.getSimilarCharges();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "similarCharges", theSimilarCharges), currentHashCode, theSimilarCharges);
        }
        {
            BigDecimal theProfitOrLossOnOrdinaryActivities;
            theProfitOrLossOnOrdinaryActivities = this.getProfitOrLossOnOrdinaryActivities();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "profitOrLossOnOrdinaryActivities", theProfitOrLossOnOrdinaryActivities), currentHashCode, theProfitOrLossOnOrdinaryActivities);
        }
        {
            BigDecimal theExtraordinaryIncome;
            theExtraordinaryIncome = this.getExtraordinaryIncome();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extraordinaryIncome", theExtraordinaryIncome), currentHashCode, theExtraordinaryIncome);
        }
        {
            BigDecimal theExtraordinaryCharges;
            theExtraordinaryCharges = this.getExtraordinaryCharges();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extraordinaryCharges", theExtraordinaryCharges), currentHashCode, theExtraordinaryCharges);
        }
        {
            BigDecimal theTaxesOnProfit;
            theTaxesOnProfit = this.getTaxesOnProfit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "taxesOnProfit", theTaxesOnProfit), currentHashCode, theTaxesOnProfit);
        }
        {
            BigDecimal theProfitOrLossForFinancialYear;
            theProfitOrLossForFinancialYear = this.getProfitOrLossForFinancialYear();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "profitOrLossForFinancialYear", theProfitOrLossForFinancialYear), currentHashCode, theProfitOrLossForFinancialYear);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
