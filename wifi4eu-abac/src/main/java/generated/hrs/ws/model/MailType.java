
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MailType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MailType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INCOMING_DOCUMENT"/>
 *     &lt;enumeration value="OUTGOING_DOCUMENT"/>
 *     &lt;enumeration value="INTERNAL_DOCUMENT"/>
 *     &lt;enumeration value="INTER_INSTITUTIONAL_DOCUMENT"/>
 *     &lt;enumeration value="NOTE_TO_THE_FILE_DOCUMENT"/>
 *     &lt;enumeration value="EXTERNAL_DOCUMENT"/>
 *     &lt;enumeration value="OTHER_DOCUMENT"/>
 *     &lt;enumeration value="INTERNAL_MESSAGE"/>
 *     &lt;enumeration value="INTER_INSTITUTIONAL_MESSAGE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MailType")
@XmlEnum
public enum MailType {

    INCOMING_DOCUMENT,
    OUTGOING_DOCUMENT,
    INTERNAL_DOCUMENT,
    INTER_INSTITUTIONAL_DOCUMENT,
    NOTE_TO_THE_FILE_DOCUMENT,
    EXTERNAL_DOCUMENT,
    OTHER_DOCUMENT,
    INTERNAL_MESSAGE,
    INTER_INSTITUTIONAL_MESSAGE;

    public String value() {
        return name();
    }

    public static MailType fromValue(String v) {
        return valueOf(v);
    }

}
