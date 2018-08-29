
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemKindToAdd.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ItemKindToAdd">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MAIN"/>
 *     &lt;enumeration value="COVER_LETTER"/>
 *     &lt;enumeration value="ANNEX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ItemKindToAdd")
@XmlEnum
public enum ItemKindToAdd {

    MAIN,
    COVER_LETTER,
    ANNEX;

    public String value() {
        return name();
    }

    public static ItemKindToAdd fromValue(String v) {
        return valueOf(v);
    }

}
