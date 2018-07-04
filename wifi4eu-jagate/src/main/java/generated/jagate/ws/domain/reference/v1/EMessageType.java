
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EMessageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EMessageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INFO"/>
 *     &lt;enumeration value="WARNING"/>
 *     &lt;enumeration value="ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EMessageType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EMessageType {

    INFO,
    WARNING,
    ERROR;

    public String value() {
        return name();
    }

    public static EMessageType fromValue(String v) {
        return valueOf(v);
    }

}
