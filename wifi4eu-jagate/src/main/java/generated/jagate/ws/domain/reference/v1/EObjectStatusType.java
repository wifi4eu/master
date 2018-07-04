
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EObjectStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EObjectStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Valid"/>
 *     &lt;enumeration value="Invalid"/>
 *     &lt;enumeration value="Blocked"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="Follow-up"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EObjectStatusType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EObjectStatusType {

    @XmlEnumValue("Valid")
    VALID("Valid"),
    @XmlEnumValue("Invalid")
    INVALID("Invalid"),
    @XmlEnumValue("Blocked")
    BLOCKED("Blocked"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Follow-up")
    FOLLOW_UP("Follow-up");
    private final String value;

    EObjectStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EObjectStatusType fromValue(String v) {
        for (EObjectStatusType c: EObjectStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
