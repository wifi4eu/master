
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssignmentTaskCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AssignmentTaskCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ASOC"/>
 *     &lt;enumeration value="AUT"/>
 *     &lt;enumeration value="CF"/>
 *     &lt;enumeration value="CF_CAB"/>
 *     &lt;enumeration value="CF_CBC"/>
 *     &lt;enumeration value="CF_CDP"/>
 *     &lt;enumeration value="CF_CIS"/>
 *     &lt;enumeration value="CF_DAD"/>
 *     &lt;enumeration value="CF_PET"/>
 *     &lt;enumeration value="CF_QP"/>
 *     &lt;enumeration value="CLASS"/>
 *     &lt;enumeration value="CONTR"/>
 *     &lt;enumeration value="EMET"/>
 *     &lt;enumeration value="INFO"/>
 *     &lt;enumeration value="RET"/>
 *     &lt;enumeration value="SIGNAT"/>
 *     &lt;enumeration value="VALID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AssignmentTaskCodeType")
@XmlEnum
public enum AssignmentTaskCodeType {

    ASOC,
    AUT,
    CF,
    CF_CAB,
    CF_CBC,
    CF_CDP,
    CF_CIS,
    CF_DAD,
    CF_PET,
    CF_QP,
    CLASS,
    CONTR,
    EMET,
    INFO,
    RET,
    SIGNAT,
    VALID;

    public String value() {
        return name();
    }

    public static AssignmentTaskCodeType fromValue(String v) {
        return valueOf(v);
    }

}
