
package generated.jagate.ws.domain.constants.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateCommitmentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UpdateCommitmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UPDATE_COMMITMENT"/>
 *     &lt;enumeration value="UPDATE_CONTRACTORS"/>
 *     &lt;enumeration value="UPDATE_COMMITMENT_AND_CONTRACTORS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UpdateCommitmentType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/constants/v1")
@XmlEnum
public enum UpdateCommitmentType {

    UPDATE_COMMITMENT,
    UPDATE_CONTRACTORS,
    UPDATE_COMMITMENT_AND_CONTRACTORS;

    public String value() {
        return name();
    }

    public static UpdateCommitmentType fromValue(String v) {
        return valueOf(v);
    }

}
