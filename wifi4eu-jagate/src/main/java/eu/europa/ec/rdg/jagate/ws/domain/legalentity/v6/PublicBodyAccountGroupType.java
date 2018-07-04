
package eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublicBodyAccountGroupType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PublicBodyAccountGroupType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MEMBER_STATES"/>
 *     &lt;enumeration value="THIRD_STATES"/>
 *     &lt;enumeration value="OTHER_PUBLIC_BODIES"/>
 *     &lt;enumeration value="REGIONS_PROVINCES_THIRD_STATES"/>
 *     &lt;enumeration value="REGIONS_PROVINCES_MEMBER_STATES"/>
 *     &lt;enumeration value="INTRA_COMMISSION"/>
 *     &lt;enumeration value="MEMBER_STATES"/>
 *     &lt;enumeration value="INSTITS_WITH_CMPTS_DE_LIAISON__ABAC"/>
 *     &lt;enumeration value="OTHER_EC-GLOBAL_CONS_WITH_CMPTS_DE_LIAISON"/>
 *     &lt;enumeration value="OTHER_EC-GLOBAL_CONS_W/OUT_CMPTS_DE_LIAISON_ABAC"/>
 *     &lt;enumeration value="OTHER_EC-PROPORTIONAL_CONSOLID"/>
 *     &lt;enumeration value="OTHER_EC-EQUITY_METHOD"/>
 *     &lt;enumeration value="NON_CONSOLIDATED_EC_ENTITIES"/>
 *     &lt;enumeration value="EFTA"/>
 *     &lt;enumeration value="INTERNATIONAL_ORGANISATIONS"/>
 *     &lt;enumeration value="OTHER_EC-GLOBAL_CONS_W/OUT_CMPTS_DE_LIAISON_2"/>
 *     &lt;enumeration value="INSTITS_WITH_CMPTS_DE_LIAISON"/>
 *     &lt;enumeration value="OTHER_EC-EQUITY_METHOD_ABAC"/>
 *     &lt;enumeration value="NON_CONSOLIDATED_EC_ENTITIES_2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PublicBodyAccountGroupType")
@XmlEnum
public enum PublicBodyAccountGroupType {

    MEMBER_STATES("MEMBER_STATES"),
    THIRD_STATES("THIRD_STATES"),
    OTHER_PUBLIC_BODIES("OTHER_PUBLIC_BODIES"),
    REGIONS_PROVINCES_THIRD_STATES("REGIONS_PROVINCES_THIRD_STATES"),
    REGIONS_PROVINCES_MEMBER_STATES("REGIONS_PROVINCES_MEMBER_STATES"),
    INTRA_COMMISSION("INTRA_COMMISSION"),
    @XmlEnumValue("INSTITS_WITH_CMPTS_DE_LIAISON__ABAC")
    INSTITS_WITH_CMPTS_DE_LIAISON_ABAC("INSTITS_WITH_CMPTS_DE_LIAISON__ABAC"),
    @XmlEnumValue("OTHER_EC-GLOBAL_CONS_WITH_CMPTS_DE_LIAISON")
    OTHER_EC_GLOBAL_CONS_WITH_CMPTS_DE_LIAISON("OTHER_EC-GLOBAL_CONS_WITH_CMPTS_DE_LIAISON"),
    @XmlEnumValue("OTHER_EC-GLOBAL_CONS_W/OUT_CMPTS_DE_LIAISON_ABAC")
    OTHER_EC_GLOBAL_CONS_W_OUT_CMPTS_DE_LIAISON_ABAC("OTHER_EC-GLOBAL_CONS_W/OUT_CMPTS_DE_LIAISON_ABAC"),
    @XmlEnumValue("OTHER_EC-PROPORTIONAL_CONSOLID")
    OTHER_EC_PROPORTIONAL_CONSOLID("OTHER_EC-PROPORTIONAL_CONSOLID"),
    @XmlEnumValue("OTHER_EC-EQUITY_METHOD")
    OTHER_EC_EQUITY_METHOD("OTHER_EC-EQUITY_METHOD"),
    NON_CONSOLIDATED_EC_ENTITIES("NON_CONSOLIDATED_EC_ENTITIES"),
    EFTA("EFTA"),
    INTERNATIONAL_ORGANISATIONS("INTERNATIONAL_ORGANISATIONS"),
    @XmlEnumValue("OTHER_EC-GLOBAL_CONS_W/OUT_CMPTS_DE_LIAISON_2")
    OTHER_EC_GLOBAL_CONS_W_OUT_CMPTS_DE_LIAISON_2("OTHER_EC-GLOBAL_CONS_W/OUT_CMPTS_DE_LIAISON_2"),
    INSTITS_WITH_CMPTS_DE_LIAISON("INSTITS_WITH_CMPTS_DE_LIAISON"),
    @XmlEnumValue("OTHER_EC-EQUITY_METHOD_ABAC")
    OTHER_EC_EQUITY_METHOD_ABAC("OTHER_EC-EQUITY_METHOD_ABAC"),
    NON_CONSOLIDATED_EC_ENTITIES_2("NON_CONSOLIDATED_EC_ENTITIES_2");
    private final String value;

    PublicBodyAccountGroupType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PublicBodyAccountGroupType fromValue(String v) {
        for (PublicBodyAccountGroupType c: PublicBodyAccountGroupType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
