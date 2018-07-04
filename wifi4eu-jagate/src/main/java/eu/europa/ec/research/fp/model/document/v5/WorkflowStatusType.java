
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkflowStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WorkflowStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="BYPASSED"/>
 *     &lt;enumeration value="CLOSED"/>
 *     &lt;enumeration value="DECLINED"/>
 *     &lt;enumeration value="DELEGATED"/>
 *     &lt;enumeration value="DRAFT"/>
 *     &lt;enumeration value="LAUNCHED"/>
 *     &lt;enumeration value="MANUAL"/>
 *     &lt;enumeration value="RETURNED_TO_SENDER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WorkflowStatusType")
@XmlEnum
public enum WorkflowStatusType {

    ACTIVE,
    BYPASSED,
    CLOSED,
    DECLINED,
    DELEGATED,
    DRAFT,
    LAUNCHED,
    MANUAL,
    RETURNED_TO_SENDER;

    public String value() {
        return name();
    }

    public static WorkflowStatusType fromValue(String v) {
        return valueOf(v);
    }

}
