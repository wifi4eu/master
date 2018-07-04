
package generated.jagate.ws.domain.visa.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACCEPT"/>
 *     &lt;enumeration value="REFUSAL_FOR_CORRECTION"/>
 *     &lt;enumeration value="SUSPEND"/>
 *     &lt;enumeration value="REFUSAL"/>
 *     &lt;enumeration value="TECHNICAL_REJECTION"/>
 *     &lt;enumeration value="TECHNICAL_ACCEPTANCE"/>
 *     &lt;enumeration value="PASSED_FOR_PAYMENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActionType")
@XmlEnum
public enum ActionType {

    ACCEPT,
    REFUSAL_FOR_CORRECTION,
    SUSPEND,
    REFUSAL,
    TECHNICAL_REJECTION,
    TECHNICAL_ACCEPTANCE,
    PASSED_FOR_PAYMENT;

    public String value() {
        return name();
    }

    public static ActionType fromValue(String v) {
        return valueOf(v);
    }

}
