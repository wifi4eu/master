
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecurityClassification.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SecurityClassification">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NORMAL"/>
 *     &lt;enumeration value="LIMITED"/>
 *     &lt;enumeration value="EU_RESTRAINED"/>
 *     &lt;enumeration value="EURA_RESTRICTED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SecurityClassification")
@XmlEnum
public enum SecurityClassification {

    NORMAL,

    /**
     * In ARES UI, 'LIMITED' security classification is displayed/referred as 'Handling restriction',
     *                             which is just an alias for 'LIMITED' type security classification.
     * 
     */
    LIMITED,

    /**
     * In ARES UI, 'EU_RESTRAINED' security classification is displayed/referred as 'RESTREINT UE/EU RESTRICTED',
     *                             which is just an alias for 'EU_RESTRAINED' type security classification.
     * 
     */
    EU_RESTRAINED,
    EURA_RESTRICTED;

    public String value() {
        return name();
    }

    public static SecurityClassification fromValue(String v) {
        return valueOf(v);
    }

}
