
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EContractStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EContractStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Ended"/>
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Terminated"/>
 *     &lt;enumeration value="Signed by Contractor(s)"/>
 *     &lt;enumeration value="In Force"/>
 *     &lt;enumeration value="Submitted"/>
 *     &lt;enumeration value="Si2 Committed"/>
 *     &lt;enumeration value="Amended"/>
 *     &lt;enumeration value="Sent to Contractor"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="Linked To Commitment"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Not Applicable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EContractStatusType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EContractStatusType {

    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Ended")
    ENDED("Ended"),
    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Terminated")
    TERMINATED("Terminated"),
    @XmlEnumValue("Signed by Contractor(s)")
    SIGNED_BY_CONTRACTOR_S("Signed by Contractor(s)"),
    @XmlEnumValue("In Force")
    IN_FORCE("In Force"),
    @XmlEnumValue("Submitted")
    SUBMITTED("Submitted"),
    @XmlEnumValue("Si2 Committed")
    SI_2_COMMITTED("Si2 Committed"),
    @XmlEnumValue("Amended")
    AMENDED("Amended"),
    @XmlEnumValue("Sent to Contractor")
    SENT_TO_CONTRACTOR("Sent to Contractor"),
    @XmlEnumValue("Suspended")
    SUSPENDED("Suspended"),
    @XmlEnumValue("Linked To Commitment")
    LINKED_TO_COMMITMENT("Linked To Commitment"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Not Applicable")
    NOT_APPLICABLE("Not Applicable");
    private final String value;

    EContractStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EContractStatusType fromValue(String v) {
        for (EContractStatusType c: EContractStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
