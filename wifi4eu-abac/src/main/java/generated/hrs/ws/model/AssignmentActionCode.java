
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssignmentActionCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AssignmentActionCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CF"/>
 *     &lt;enumeration value="ASOC"/>
 *     &lt;enumeration value="INFO"/>
 *     &lt;enumeration value="CLASS"/>
 *     &lt;enumeration value="CBC"/>
 *     &lt;enumeration value="CDP"/>
 *     &lt;enumeration value="DAD"/>
 *     &lt;enumeration value="QP"/>
 *     &lt;enumeration value="CIS"/>
 *     &lt;enumeration value="CAB"/>
 *     &lt;enumeration value="PET"/>
 *     &lt;enumeration value="CONTR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AssignmentActionCode")
@XmlEnum
public enum AssignmentActionCode {

    CF,
    ASOC,
    INFO,
    CLASS,
    CBC,
    CDP,
    DAD,
    QP,
    CIS,
    CAB,
    PET,
    CONTR;

    public String value() {
        return name();
    }

    public static AssignmentActionCode fromValue(String v) {
        return valueOf(v);
    }

}
