
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * A set of flags indicating how and where to access a document. Useful for the cases where user does not have access
 *                 or lost access to the document.
 * 
 * <p>Java class for AccessibilityInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccessibilityInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inHermes" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="trashed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="transferred" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="eliminated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccessibilityInfo", propOrder = {
    "accessible",
    "inHermes",
    "trashed",
    "transferred",
    "eliminated"
})
public class AccessibilityInfo
    implements Equals, HashCode, ToString
{

    protected boolean accessible;
    protected boolean inHermes;
    protected boolean trashed;
    protected boolean transferred;
    protected boolean eliminated;

    /**
     * Gets the value of the accessible property.
     * 
     */
    public boolean isAccessible() {
        return accessible;
    }

    /**
     * Sets the value of the accessible property.
     * 
     */
    public void setAccessible(boolean value) {
        this.accessible = value;
    }

    /**
     * Gets the value of the inHermes property.
     * 
     */
    public boolean isInHermes() {
        return inHermes;
    }

    /**
     * Sets the value of the inHermes property.
     * 
     */
    public void setInHermes(boolean value) {
        this.inHermes = value;
    }

    /**
     * Gets the value of the trashed property.
     * 
     */
    public boolean isTrashed() {
        return trashed;
    }

    /**
     * Sets the value of the trashed property.
     * 
     */
    public void setTrashed(boolean value) {
        this.trashed = value;
    }

    /**
     * Gets the value of the transferred property.
     * 
     */
    public boolean isTransferred() {
        return transferred;
    }

    /**
     * Sets the value of the transferred property.
     * 
     */
    public void setTransferred(boolean value) {
        this.transferred = value;
    }

    /**
     * Gets the value of the eliminated property.
     * 
     */
    public boolean isEliminated() {
        return eliminated;
    }

    /**
     * Sets the value of the eliminated property.
     * 
     */
    public void setEliminated(boolean value) {
        this.eliminated = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AccessibilityInfo)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AccessibilityInfo that = ((AccessibilityInfo) object);
        {
            boolean lhsAccessible;
            lhsAccessible = (true?this.isAccessible():false);
            boolean rhsAccessible;
            rhsAccessible = (true?that.isAccessible():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accessible", lhsAccessible), LocatorUtils.property(thatLocator, "accessible", rhsAccessible), lhsAccessible, rhsAccessible)) {
                return false;
            }
        }
        {
            boolean lhsInHermes;
            lhsInHermes = (true?this.isInHermes():false);
            boolean rhsInHermes;
            rhsInHermes = (true?that.isInHermes():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inHermes", lhsInHermes), LocatorUtils.property(thatLocator, "inHermes", rhsInHermes), lhsInHermes, rhsInHermes)) {
                return false;
            }
        }
        {
            boolean lhsTrashed;
            lhsTrashed = (true?this.isTrashed():false);
            boolean rhsTrashed;
            rhsTrashed = (true?that.isTrashed():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "trashed", lhsTrashed), LocatorUtils.property(thatLocator, "trashed", rhsTrashed), lhsTrashed, rhsTrashed)) {
                return false;
            }
        }
        {
            boolean lhsTransferred;
            lhsTransferred = (true?this.isTransferred():false);
            boolean rhsTransferred;
            rhsTransferred = (true?that.isTransferred():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transferred", lhsTransferred), LocatorUtils.property(thatLocator, "transferred", rhsTransferred), lhsTransferred, rhsTransferred)) {
                return false;
            }
        }
        {
            boolean lhsEliminated;
            lhsEliminated = (true?this.isEliminated():false);
            boolean rhsEliminated;
            rhsEliminated = (true?that.isEliminated():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "eliminated", lhsEliminated), LocatorUtils.property(thatLocator, "eliminated", rhsEliminated), lhsEliminated, rhsEliminated)) {
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
            boolean theAccessible;
            theAccessible = (true?this.isAccessible():false);
            strategy.appendField(locator, this, "accessible", buffer, theAccessible);
        }
        {
            boolean theInHermes;
            theInHermes = (true?this.isInHermes():false);
            strategy.appendField(locator, this, "inHermes", buffer, theInHermes);
        }
        {
            boolean theTrashed;
            theTrashed = (true?this.isTrashed():false);
            strategy.appendField(locator, this, "trashed", buffer, theTrashed);
        }
        {
            boolean theTransferred;
            theTransferred = (true?this.isTransferred():false);
            strategy.appendField(locator, this, "transferred", buffer, theTransferred);
        }
        {
            boolean theEliminated;
            theEliminated = (true?this.isEliminated():false);
            strategy.appendField(locator, this, "eliminated", buffer, theEliminated);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            boolean theAccessible;
            theAccessible = (true?this.isAccessible():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accessible", theAccessible), currentHashCode, theAccessible);
        }
        {
            boolean theInHermes;
            theInHermes = (true?this.isInHermes():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inHermes", theInHermes), currentHashCode, theInHermes);
        }
        {
            boolean theTrashed;
            theTrashed = (true?this.isTrashed():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "trashed", theTrashed), currentHashCode, theTrashed);
        }
        {
            boolean theTransferred;
            theTransferred = (true?this.isTransferred():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transferred", theTransferred), currentHashCode, theTransferred);
        }
        {
            boolean theEliminated;
            theEliminated = (true?this.isEliminated():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "eliminated", theEliminated), currentHashCode, theEliminated);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
