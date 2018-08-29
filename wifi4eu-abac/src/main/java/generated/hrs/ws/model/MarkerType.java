
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarkerType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MarkerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LIMITED_SERVICE"/>
 *     &lt;enumeration value="MEDICAL_MATTER"/>
 *     &lt;enumeration value="STAFF_MATTER"/>
 *     &lt;enumeration value="PERSONAL"/>
 *     &lt;enumeration value="PERSONAL_DATA"/>
 *     &lt;enumeration value="INVESTIGATIONS_AND_DISCIPLINARY_MATTER"/>
 *     &lt;enumeration value="OPINION_LEGAL_SERVICE"/>
 *     &lt;enumeration value="OLAF"/>
 *     &lt;enumeration value="OLAF_SPECIAL"/>
 *     &lt;enumeration value="COMMISSION_INTERNAL"/>
 *     &lt;enumeration value="LIMITED"/>
 *     &lt;enumeration value="EMBARGO_UNTIL"/>
 *     &lt;enumeration value="COMP_OPERATIONS"/>
 *     &lt;enumeration value="COMP_SPECIAL_HANDLING"/>
 *     &lt;enumeration value="COURT_PROCEDURAL_DOCUMENTS"/>
 *     &lt;enumeration value="SECURITY_MATTER"/>
 *     &lt;enumeration value="MEDIATION_SERVICE_MATTER"/>
 *     &lt;enumeration value="EU_SATELLITE_NAVIGATION_MATTERS"/>
 *     &lt;enumeration value="JOINT_PROCUREMENT"/>
 *     &lt;enumeration value="IAS_OPERATIONS"/>
 *     &lt;enumeration value="ECONOMY_AND_FINANCE"/>
 *     &lt;enumeration value="ETS_LIMITED"/>
 *     &lt;enumeration value="ETS_SENSITIVE"/>
 *     &lt;enumeration value="ETS_CRITICAL"/>
 *     &lt;enumeration value="PHARMA_INVESTIGATIONS"/>
 *     &lt;enumeration value="PHARMA_INVESTIGATIONS_SPECIAL_HANDLING"/>
 *     &lt;enumeration value="PERSONAL_DATA_DEADLINE"/>
 *     &lt;enumeration value="LIMITED_DEADLINE"/>
 *     &lt;enumeration value="COMP_OPERATIONS_DEADLINE"/>
 *     &lt;enumeration value="SECURITY_MATTER_DEADLINE"/>
 *     &lt;enumeration value="MEDIATION_SERVICE_MATTER_DEADLINE"/>
 *     &lt;enumeration value="EU_SATELLITE_NAVIGATION_MATTERS_DEADLINE"/>
 *     &lt;enumeration value="COMP_SPECIAL_HANDLING_DEADLINE"/>
 *     &lt;enumeration value="LIMITED_DG_DEADLINE"/>
 *     &lt;enumeration value="LIMITED_SERVICE_DEADLINE"/>
 *     &lt;enumeration value="MEDICAL_MATTER_DEADLINE"/>
 *     &lt;enumeration value="STAFF_MATTER_DEADLINE"/>
 *     &lt;enumeration value="PERSONAL_DEADLINE"/>
 *     &lt;enumeration value="INVESTIGATIONS_AND_DISCIPLINARY_MATTER_DEADLINE"/>
 *     &lt;enumeration value="OPINION_LEGAL_SERVICE_DEADLINE"/>
 *     &lt;enumeration value="OLAF_DEADLINE"/>
 *     &lt;enumeration value="OLAF_SPECIAL_DEADLINE"/>
 *     &lt;enumeration value="COMMISSION_INTERNAL_DEADLINE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MarkerType")
@XmlEnum
public enum MarkerType {

    LIMITED_SERVICE,
    MEDICAL_MATTER,
    STAFF_MATTER,
    PERSONAL,
    PERSONAL_DATA,
    INVESTIGATIONS_AND_DISCIPLINARY_MATTER,
    OPINION_LEGAL_SERVICE,
    OLAF,
    OLAF_SPECIAL,
    COMMISSION_INTERNAL,
    LIMITED,
    EMBARGO_UNTIL,
    COMP_OPERATIONS,
    COMP_SPECIAL_HANDLING,
    COURT_PROCEDURAL_DOCUMENTS,
    SECURITY_MATTER,
    MEDIATION_SERVICE_MATTER,
    EU_SATELLITE_NAVIGATION_MATTERS,
    JOINT_PROCUREMENT,
    IAS_OPERATIONS,
    ECONOMY_AND_FINANCE,
    ETS_LIMITED,
    ETS_SENSITIVE,
    ETS_CRITICAL,
    PHARMA_INVESTIGATIONS,
    PHARMA_INVESTIGATIONS_SPECIAL_HANDLING,
    PERSONAL_DATA_DEADLINE,
    LIMITED_DEADLINE,
    COMP_OPERATIONS_DEADLINE,
    SECURITY_MATTER_DEADLINE,
    MEDIATION_SERVICE_MATTER_DEADLINE,
    EU_SATELLITE_NAVIGATION_MATTERS_DEADLINE,
    COMP_SPECIAL_HANDLING_DEADLINE,
    LIMITED_DG_DEADLINE,
    LIMITED_SERVICE_DEADLINE,
    MEDICAL_MATTER_DEADLINE,
    STAFF_MATTER_DEADLINE,
    PERSONAL_DEADLINE,
    INVESTIGATIONS_AND_DISCIPLINARY_MATTER_DEADLINE,
    OPINION_LEGAL_SERVICE_DEADLINE,
    OLAF_DEADLINE,
    OLAF_SPECIAL_DEADLINE,
    COMMISSION_INTERNAL_DEADLINE;

    public String value() {
        return name();
    }

    public static MarkerType fromValue(String v) {
        return valueOf(v);
    }

}
