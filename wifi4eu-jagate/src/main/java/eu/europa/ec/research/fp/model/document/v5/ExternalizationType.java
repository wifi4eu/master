
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExternalizationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExternalizationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FULL"/>
 *     &lt;enumeration value="PARTIAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExternalizationType")
@XmlEnum
public enum ExternalizationType {

    FULL,
    PARTIAL;

    public String value() {
        return name();
    }

    public static ExternalizationType fromValue(String v) {
        return valueOf(v);
    }

}
