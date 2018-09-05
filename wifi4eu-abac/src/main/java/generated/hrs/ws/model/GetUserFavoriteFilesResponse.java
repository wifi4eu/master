
package generated.hrs.ws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="favorite" type="{http://ec.europa.eu/sg/hrs/types}File" maxOccurs="unbounded" minOccurs="0"/>
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
    "favorite"
})
@XmlRootElement(name = "getUserFavoriteFilesResponse")
public class GetUserFavoriteFilesResponse
    implements Equals, HashCode, ToString
{

    protected List<File> favorite;

    /**
     * Gets the value of the favorite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the favorite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFavorite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link File }
     * 
     * 
     */
    public List<File> getFavorite() {
        if (favorite == null) {
            favorite = new ArrayList<File>();
        }
        return this.favorite;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetUserFavoriteFilesResponse)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetUserFavoriteFilesResponse that = ((GetUserFavoriteFilesResponse) object);
        {
            List<File> lhsFavorite;
            lhsFavorite = (((this.favorite!= null)&&(!this.favorite.isEmpty()))?this.getFavorite():null);
            List<File> rhsFavorite;
            rhsFavorite = (((that.favorite!= null)&&(!that.favorite.isEmpty()))?that.getFavorite():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "favorite", lhsFavorite), LocatorUtils.property(thatLocator, "favorite", rhsFavorite), lhsFavorite, rhsFavorite)) {
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
            List<File> theFavorite;
            theFavorite = (((this.favorite!= null)&&(!this.favorite.isEmpty()))?this.getFavorite():null);
            strategy.appendField(locator, this, "favorite", buffer, theFavorite);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<File> theFavorite;
            theFavorite = (((this.favorite!= null)&&(!this.favorite.isEmpty()))?this.getFavorite():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "favorite", theFavorite), currentHashCode, theFavorite);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
