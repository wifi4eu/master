
package generated.jagate.ws.domain.constants.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EWorkflowStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EWorkflowStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PEND3"/>
 *     &lt;enumeration value="PEND10"/>
 *     &lt;enumeration value="PEND30"/>
 *     &lt;enumeration value="FIN0"/>
 *     &lt;enumeration value="FIN2"/>
 *     &lt;enumeration value="CLO100"/>
 *     &lt;enumeration value="FIN100"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EWorkflowStatus", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/constants/v1")
@XmlEnum
public enum EWorkflowStatus {

    @XmlEnumValue("PEND3")
    PEND_3("PEND3"),
    @XmlEnumValue("PEND10")
    PEND_10("PEND10"),
    @XmlEnumValue("PEND30")
    PEND_30("PEND30"),
    @XmlEnumValue("FIN0")
    FIN_0("FIN0"),
    @XmlEnumValue("FIN2")
    FIN_2("FIN2"),
    @XmlEnumValue("CLO100")
    CLO_100("CLO100"),
    @XmlEnumValue("FIN100")
    FIN_100("FIN100");
    private final String value;

    EWorkflowStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EWorkflowStatus fromValue(String v) {
        for (EWorkflowStatus c: EWorkflowStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
