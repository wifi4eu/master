
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KindType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="KindType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MAIN"/>
 *     &lt;enumeration value="COVER_LETTER"/>
 *     &lt;enumeration value="ANNEX"/>
 *     &lt;enumeration value="TRANSLATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "KindType")
@XmlEnum
public enum KindType {

    MAIN,
    COVER_LETTER,
    ANNEX,
    TRANSLATION;

    public String value() {
        return name();
    }

    public static KindType fromValue(String v) {
        return valueOf(v);
    }

}
