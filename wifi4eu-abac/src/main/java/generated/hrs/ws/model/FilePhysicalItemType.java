
package generated.hrs.ws.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilePhysicalItemType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FilePhysicalItemType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ARCHIVE_BOX"/>
 *     &lt;enumeration value="BINDER_LARGE"/>
 *     &lt;enumeration value="BINDER_SMALL"/>
 *     &lt;enumeration value="FOLDER"/>
 *     &lt;enumeration value="ENVELOPE"/>
 *     &lt;enumeration value="PACKAGE"/>
 *     &lt;enumeration value="OTHER_UNIT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FilePhysicalItemType")
@XmlEnum
public enum FilePhysicalItemType {

    ARCHIVE_BOX,
    BINDER_LARGE,
    BINDER_SMALL,
    FOLDER,
    ENVELOPE,
    PACKAGE,
    OTHER_UNIT;

    public String value() {
        return name();
    }

    public static FilePhysicalItemType fromValue(String v) {
        return valueOf(v);
    }

}
