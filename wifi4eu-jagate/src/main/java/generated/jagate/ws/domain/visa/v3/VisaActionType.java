
package generated.jagate.ws.domain.visa.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VisaActionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VisaActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="SC"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="SR"/>
 *     &lt;enumeration value="TR"/>
 *     &lt;enumeration value="TA"/>
 *     &lt;enumeration value="PP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VisaActionType")
@XmlEnum
public enum VisaActionType {

    AC,
    SC,
    SP,
    SR,
    TR,
    TA,
    PP;

    public String value() {
        return name();
    }

    public static VisaActionType fromValue(String v) {
        return valueOf(v);
    }

}
