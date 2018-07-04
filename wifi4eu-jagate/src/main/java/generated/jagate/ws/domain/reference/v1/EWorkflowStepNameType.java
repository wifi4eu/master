
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EWorkflowStepNameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EWorkflowStepNameType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="agate_ack"/>
 *     &lt;enumeration value="agate_invoice_ack"/>
 *     &lt;enumeration value="waiting_for_abac"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EWorkflowStepNameType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EWorkflowStepNameType {

    @XmlEnumValue("agate_ack")
    AGATE_ACK("agate_ack"),
    @XmlEnumValue("agate_invoice_ack")
    AGATE_INVOICE_ACK("agate_invoice_ack"),
    @XmlEnumValue("waiting_for_abac")
    WAITING_FOR_ABAC("waiting_for_abac");
    private final String value;

    EWorkflowStepNameType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EWorkflowStepNameType fromValue(String v) {
        for (EWorkflowStepNameType c: EWorkflowStepNameType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
