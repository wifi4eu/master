
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ItemKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MAIN"/>
 *     &lt;enumeration value="COVER_LETTER"/>
 *     &lt;enumeration value="ANNEX"/>
 *     &lt;enumeration value="TRANSLATION"/>
 *     &lt;enumeration value="ACK_RECEIPT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ItemKind")
@XmlEnum
public enum ItemKind {

    MAIN,
    COVER_LETTER,
    ANNEX,
    TRANSLATION,
    ACK_RECEIPT;

    public String value() {
        return name();
    }

    public static ItemKind fromValue(String v) {
        return valueOf(v);
    }

}
