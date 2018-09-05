
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileExceptionForOpeningToThePublic.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FileExceptionForOpeningToThePublic">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CLASSIFIED"/>
 *     &lt;enumeration value="PERSONAL_DATA_PROTECTION"/>
 *     &lt;enumeration value="COMMERCIAL_INTERESTS"/>
 *     &lt;enumeration value="CLASSIFIED_FROM_THIRD_PARTY"/>
 *     &lt;enumeration value="EURATOM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FileExceptionForOpeningToThePublic")
@XmlEnum
public enum FileExceptionForOpeningToThePublic {

    CLASSIFIED,
    PERSONAL_DATA_PROTECTION,
    COMMERCIAL_INTERESTS,
    CLASSIFIED_FROM_THIRD_PARTY,
    EURATOM;

    public String value() {
        return name();
    }

    public static FileExceptionForOpeningToThePublic fromValue(String v) {
        return valueOf(v);
    }

}
