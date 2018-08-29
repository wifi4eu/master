
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinkType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LinkType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RESPONSE"/>
 *     &lt;enumeration value="REQUEST"/>
 *     &lt;enumeration value="GENERAL"/>
 *     &lt;enumeration value="DUPLICATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LinkType")
@XmlEnum
public enum LinkType {

    RESPONSE,
    REQUEST,
    GENERAL,
    DUPLICATE;

    public String value() {
        return name();
    }

    public static LinkType fromValue(String v) {
        return valueOf(v);
    }

}
