
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilePostARPAction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FilePostARPAction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ELIMINATION"/>
 *     &lt;enumeration value="TRANSFER_TO_THE_HISTORICAL_ARCHIVES"/>
 *     &lt;enumeration value="SAMPLING_AND_OR_SELECTION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FilePostARPAction")
@XmlEnum
public enum FilePostARPAction {

    ELIMINATION,
    TRANSFER_TO_THE_HISTORICAL_ARCHIVES,
    SAMPLING_AND_OR_SELECTION;

    public String value() {
        return name();
    }

    public static FilePostARPAction fromValue(String v) {
        return valueOf(v);
    }

}
