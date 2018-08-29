
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AsyncOperationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AsyncOperationStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RUNNING"/>
 *     &lt;enumeration value="EXECUTED"/>
 *     &lt;enumeration value="EXECUTED_WITH_ERRORS"/>
 *     &lt;enumeration value="CANCELED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AsyncOperationStatus")
@XmlEnum
public enum AsyncOperationStatus {

    RUNNING,
    EXECUTED,
    EXECUTED_WITH_ERRORS,
    CANCELED;

    public String value() {
        return name();
    }

    public static AsyncOperationStatus fromValue(String v) {
        return valueOf(v);
    }

}
