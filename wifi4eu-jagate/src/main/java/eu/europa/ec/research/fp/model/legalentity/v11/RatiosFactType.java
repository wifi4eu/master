
package eu.europa.ec.research.fp.model.legalentity.v11;

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
 * <p>Java class for RatiosFactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RatiosFactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Year" type="{http://ec.europa.eu/research/fp/model/base/V1}YearType"/>
 *         &lt;element name="Quick" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}BalanceSheetMetricType" minOccurs="0"/>
 *         &lt;element name="GOProfit" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}BalanceSheetMetricType" minOccurs="0"/>
 *         &lt;element name="ProfitabilityGross" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}BalanceSheetMetricType" minOccurs="0"/>
 *         &lt;element name="ProfitabilityNet" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}BalanceSheetMetricType" minOccurs="0"/>
 *         &lt;element name="Solvency" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}BalanceSheetMetricType" minOccurs="0"/>
 *         &lt;element name="EquityFlag" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}BalanceSheetMetricType" minOccurs="0"/>
 *         &lt;element name="ConciseAnalysis" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}AnalyticalMetricType" minOccurs="0"/>
 *         &lt;element name="DepthAnalysis" type="{http://ec.europa.eu/research/fp/model/legalentity/V11}AnalyticalMetricType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RatiosFactType", propOrder = {
    "year",
    "quick",
    "goProfit",
    "profitabilityGross",
    "profitabilityNet",
    "solvency",
    "equityFlag",
    "conciseAnalysis",
    "depthAnalysis"
})
public class RatiosFactType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Year")
    protected int year;
    @XmlElement(name = "Quick")
    protected BalanceSheetMetricType quick;
    @XmlElement(name = "GOProfit")
    protected BalanceSheetMetricType goProfit;
    @XmlElement(name = "ProfitabilityGross")
    protected BalanceSheetMetricType profitabilityGross;
    @XmlElement(name = "ProfitabilityNet")
    protected BalanceSheetMetricType profitabilityNet;
    @XmlElement(name = "Solvency")
    protected BalanceSheetMetricType solvency;
    @XmlElement(name = "EquityFlag")
    protected BalanceSheetMetricType equityFlag;
    @XmlElement(name = "ConciseAnalysis")
    protected AnalyticalMetricType conciseAnalysis;
    @XmlElement(name = "DepthAnalysis")
    protected AnalyticalMetricType depthAnalysis;

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
     * Gets the value of the quick property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public BalanceSheetMetricType getQuick() {
        return quick;
    }

    /**
     * Sets the value of the quick property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public void setQuick(BalanceSheetMetricType value) {
        this.quick = value;
    }

    /**
     * Gets the value of the goProfit property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public BalanceSheetMetricType getGOProfit() {
        return goProfit;
    }

    /**
     * Sets the value of the goProfit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public void setGOProfit(BalanceSheetMetricType value) {
        this.goProfit = value;
    }

    /**
     * Gets the value of the profitabilityGross property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public BalanceSheetMetricType getProfitabilityGross() {
        return profitabilityGross;
    }

    /**
     * Sets the value of the profitabilityGross property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public void setProfitabilityGross(BalanceSheetMetricType value) {
        this.profitabilityGross = value;
    }

    /**
     * Gets the value of the profitabilityNet property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public BalanceSheetMetricType getProfitabilityNet() {
        return profitabilityNet;
    }

    /**
     * Sets the value of the profitabilityNet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public void setProfitabilityNet(BalanceSheetMetricType value) {
        this.profitabilityNet = value;
    }

    /**
     * Gets the value of the solvency property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public BalanceSheetMetricType getSolvency() {
        return solvency;
    }

    /**
     * Sets the value of the solvency property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public void setSolvency(BalanceSheetMetricType value) {
        this.solvency = value;
    }

    /**
     * Gets the value of the equityFlag property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public BalanceSheetMetricType getEquityFlag() {
        return equityFlag;
    }

    /**
     * Sets the value of the equityFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceSheetMetricType }
     *     
     */
    public void setEquityFlag(BalanceSheetMetricType value) {
        this.equityFlag = value;
    }

    /**
     * Gets the value of the conciseAnalysis property.
     * 
     * @return
     *     possible object is
     *     {@link AnalyticalMetricType }
     *     
     */
    public AnalyticalMetricType getConciseAnalysis() {
        return conciseAnalysis;
    }

    /**
     * Sets the value of the conciseAnalysis property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalyticalMetricType }
     *     
     */
    public void setConciseAnalysis(AnalyticalMetricType value) {
        this.conciseAnalysis = value;
    }

    /**
     * Gets the value of the depthAnalysis property.
     * 
     * @return
     *     possible object is
     *     {@link AnalyticalMetricType }
     *     
     */
    public AnalyticalMetricType getDepthAnalysis() {
        return depthAnalysis;
    }

    /**
     * Sets the value of the depthAnalysis property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalyticalMetricType }
     *     
     */
    public void setDepthAnalysis(AnalyticalMetricType value) {
        this.depthAnalysis = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RatiosFactType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RatiosFactType that = ((RatiosFactType) object);
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
            BalanceSheetMetricType lhsQuick;
            lhsQuick = this.getQuick();
            BalanceSheetMetricType rhsQuick;
            rhsQuick = that.getQuick();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "quick", lhsQuick), LocatorUtils.property(thatLocator, "quick", rhsQuick), lhsQuick, rhsQuick)) {
                return false;
            }
        }
        {
            BalanceSheetMetricType lhsGOProfit;
            lhsGOProfit = this.getGOProfit();
            BalanceSheetMetricType rhsGOProfit;
            rhsGOProfit = that.getGOProfit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "goProfit", lhsGOProfit), LocatorUtils.property(thatLocator, "goProfit", rhsGOProfit), lhsGOProfit, rhsGOProfit)) {
                return false;
            }
        }
        {
            BalanceSheetMetricType lhsProfitabilityGross;
            lhsProfitabilityGross = this.getProfitabilityGross();
            BalanceSheetMetricType rhsProfitabilityGross;
            rhsProfitabilityGross = that.getProfitabilityGross();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "profitabilityGross", lhsProfitabilityGross), LocatorUtils.property(thatLocator, "profitabilityGross", rhsProfitabilityGross), lhsProfitabilityGross, rhsProfitabilityGross)) {
                return false;
            }
        }
        {
            BalanceSheetMetricType lhsProfitabilityNet;
            lhsProfitabilityNet = this.getProfitabilityNet();
            BalanceSheetMetricType rhsProfitabilityNet;
            rhsProfitabilityNet = that.getProfitabilityNet();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "profitabilityNet", lhsProfitabilityNet), LocatorUtils.property(thatLocator, "profitabilityNet", rhsProfitabilityNet), lhsProfitabilityNet, rhsProfitabilityNet)) {
                return false;
            }
        }
        {
            BalanceSheetMetricType lhsSolvency;
            lhsSolvency = this.getSolvency();
            BalanceSheetMetricType rhsSolvency;
            rhsSolvency = that.getSolvency();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "solvency", lhsSolvency), LocatorUtils.property(thatLocator, "solvency", rhsSolvency), lhsSolvency, rhsSolvency)) {
                return false;
            }
        }
        {
            BalanceSheetMetricType lhsEquityFlag;
            lhsEquityFlag = this.getEquityFlag();
            BalanceSheetMetricType rhsEquityFlag;
            rhsEquityFlag = that.getEquityFlag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "equityFlag", lhsEquityFlag), LocatorUtils.property(thatLocator, "equityFlag", rhsEquityFlag), lhsEquityFlag, rhsEquityFlag)) {
                return false;
            }
        }
        {
            AnalyticalMetricType lhsConciseAnalysis;
            lhsConciseAnalysis = this.getConciseAnalysis();
            AnalyticalMetricType rhsConciseAnalysis;
            rhsConciseAnalysis = that.getConciseAnalysis();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "conciseAnalysis", lhsConciseAnalysis), LocatorUtils.property(thatLocator, "conciseAnalysis", rhsConciseAnalysis), lhsConciseAnalysis, rhsConciseAnalysis)) {
                return false;
            }
        }
        {
            AnalyticalMetricType lhsDepthAnalysis;
            lhsDepthAnalysis = this.getDepthAnalysis();
            AnalyticalMetricType rhsDepthAnalysis;
            rhsDepthAnalysis = that.getDepthAnalysis();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "depthAnalysis", lhsDepthAnalysis), LocatorUtils.property(thatLocator, "depthAnalysis", rhsDepthAnalysis), lhsDepthAnalysis, rhsDepthAnalysis)) {
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
            int theYear;
            theYear = (true?this.getYear(): 0);
            strategy.appendField(locator, this, "year", buffer, theYear);
        }
        {
            BalanceSheetMetricType theQuick;
            theQuick = this.getQuick();
            strategy.appendField(locator, this, "quick", buffer, theQuick);
        }
        {
            BalanceSheetMetricType theGOProfit;
            theGOProfit = this.getGOProfit();
            strategy.appendField(locator, this, "goProfit", buffer, theGOProfit);
        }
        {
            BalanceSheetMetricType theProfitabilityGross;
            theProfitabilityGross = this.getProfitabilityGross();
            strategy.appendField(locator, this, "profitabilityGross", buffer, theProfitabilityGross);
        }
        {
            BalanceSheetMetricType theProfitabilityNet;
            theProfitabilityNet = this.getProfitabilityNet();
            strategy.appendField(locator, this, "profitabilityNet", buffer, theProfitabilityNet);
        }
        {
            BalanceSheetMetricType theSolvency;
            theSolvency = this.getSolvency();
            strategy.appendField(locator, this, "solvency", buffer, theSolvency);
        }
        {
            BalanceSheetMetricType theEquityFlag;
            theEquityFlag = this.getEquityFlag();
            strategy.appendField(locator, this, "equityFlag", buffer, theEquityFlag);
        }
        {
            AnalyticalMetricType theConciseAnalysis;
            theConciseAnalysis = this.getConciseAnalysis();
            strategy.appendField(locator, this, "conciseAnalysis", buffer, theConciseAnalysis);
        }
        {
            AnalyticalMetricType theDepthAnalysis;
            theDepthAnalysis = this.getDepthAnalysis();
            strategy.appendField(locator, this, "depthAnalysis", buffer, theDepthAnalysis);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theYear;
            theYear = (true?this.getYear(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "year", theYear), currentHashCode, theYear);
        }
        {
            BalanceSheetMetricType theQuick;
            theQuick = this.getQuick();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "quick", theQuick), currentHashCode, theQuick);
        }
        {
            BalanceSheetMetricType theGOProfit;
            theGOProfit = this.getGOProfit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "goProfit", theGOProfit), currentHashCode, theGOProfit);
        }
        {
            BalanceSheetMetricType theProfitabilityGross;
            theProfitabilityGross = this.getProfitabilityGross();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "profitabilityGross", theProfitabilityGross), currentHashCode, theProfitabilityGross);
        }
        {
            BalanceSheetMetricType theProfitabilityNet;
            theProfitabilityNet = this.getProfitabilityNet();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "profitabilityNet", theProfitabilityNet), currentHashCode, theProfitabilityNet);
        }
        {
            BalanceSheetMetricType theSolvency;
            theSolvency = this.getSolvency();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "solvency", theSolvency), currentHashCode, theSolvency);
        }
        {
            BalanceSheetMetricType theEquityFlag;
            theEquityFlag = this.getEquityFlag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "equityFlag", theEquityFlag), currentHashCode, theEquityFlag);
        }
        {
            AnalyticalMetricType theConciseAnalysis;
            theConciseAnalysis = this.getConciseAnalysis();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conciseAnalysis", theConciseAnalysis), currentHashCode, theConciseAnalysis);
        }
        {
            AnalyticalMetricType theDepthAnalysis;
            theDepthAnalysis = this.getDepthAnalysis();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "depthAnalysis", theDepthAnalysis), currentHashCode, theDepthAnalysis);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
