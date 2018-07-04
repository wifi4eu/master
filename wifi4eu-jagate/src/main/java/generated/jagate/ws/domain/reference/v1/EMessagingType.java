
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EMessagingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EMessagingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Queue"/>
 *     &lt;enumeration value="Topic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EMessagingType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EMessagingType {

    @XmlEnumValue("Queue")
    QUEUE("Queue"),
    @XmlEnumValue("Topic")
    TOPIC("Topic");
    private final String value;

    EMessagingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EMessagingType fromValue(String v) {
        for (EMessagingType c: EMessagingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
