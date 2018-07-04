
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EContractTechnicalStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EContractTechnicalStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Successfully Verified"/>
 *     &lt;enumeration value="Not Applicable"/>
 *     &lt;enumeration value="New"/>
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Busy"/>
 *     &lt;enumeration value="Completely processed"/>
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="Confirmed"/>
 *     &lt;enumeration value="Partially processed"/>
 *     &lt;enumeration value="Submitted"/>
 *     &lt;enumeration value="Ready"/>
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Warning"/>
 *     &lt;enumeration value="To be confirmed"/>
 *     &lt;enumeration value="To be validated"/>
 *     &lt;enumeration value="UnSuccessfully Verified"/>
 *     &lt;enumeration value="Blocked"/>
 *     &lt;enumeration value="Not Validated"/>
 *     &lt;enumeration value="Not Confirmed"/>
 *     &lt;enumeration value="Pre-Draft"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EContractTechnicalStatusType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EContractTechnicalStatusType {

    @XmlEnumValue("Successfully Verified")
    SUCCESSFULLY_VERIFIED("Successfully Verified"),
    @XmlEnumValue("Not Applicable")
    NOT_APPLICABLE("Not Applicable"),
    @XmlEnumValue("New")
    NEW("New"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Busy")
    BUSY("Busy"),
    @XmlEnumValue("Completely processed")
    COMPLETELY_PROCESSED("Completely processed"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Confirmed")
    CONFIRMED("Confirmed"),
    @XmlEnumValue("Partially processed")
    PARTIALLY_PROCESSED("Partially processed"),
    @XmlEnumValue("Submitted")
    SUBMITTED("Submitted"),
    @XmlEnumValue("Ready")
    READY("Ready"),
    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Warning")
    WARNING("Warning"),
    @XmlEnumValue("To be confirmed")
    TO_BE_CONFIRMED("To be confirmed"),
    @XmlEnumValue("To be validated")
    TO_BE_VALIDATED("To be validated"),
    @XmlEnumValue("UnSuccessfully Verified")
    UN_SUCCESSFULLY_VERIFIED("UnSuccessfully Verified"),
    @XmlEnumValue("Blocked")
    BLOCKED("Blocked"),
    @XmlEnumValue("Not Validated")
    NOT_VALIDATED("Not Validated"),
    @XmlEnumValue("Not Confirmed")
    NOT_CONFIRMED("Not Confirmed"),
    @XmlEnumValue("Pre-Draft")
    PRE_DRAFT("Pre-Draft");
    private final String value;

    EContractTechnicalStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EContractTechnicalStatusType fromValue(String v) {
        for (EContractTechnicalStatusType c: EContractTechnicalStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
