
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EClientTransactionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EClientTransactionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Contract"/>
 *     &lt;enumeration value="Commitment"/>
 *     &lt;enumeration value="Invoice"/>
 *     &lt;enumeration value="Payment"/>
 *     &lt;enumeration value="Prefinancing document"/>
 *     &lt;enumeration value="Audit"/>
 *     &lt;enumeration value="Recovery order"/>
 *     &lt;enumeration value="Visa"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EClientTransactionType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EClientTransactionType {

    @XmlEnumValue("Contract")
    CONTRACT("Contract"),
    @XmlEnumValue("Commitment")
    COMMITMENT("Commitment"),
    @XmlEnumValue("Invoice")
    INVOICE("Invoice"),
    @XmlEnumValue("Payment")
    PAYMENT("Payment"),
    @XmlEnumValue("Prefinancing document")
    PREFINANCING_DOCUMENT("Prefinancing document"),
    @XmlEnumValue("Audit")
    AUDIT("Audit"),
    @XmlEnumValue("Recovery order")
    RECOVERY_ORDER("Recovery order"),
    @XmlEnumValue("Visa")
    VISA("Visa");
    private final String value;

    EClientTransactionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EClientTransactionType fromValue(String v) {
        for (EClientTransactionType c: EClientTransactionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
