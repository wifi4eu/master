
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.search_criterion.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para OracleTextCriterionOperatorType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="OracleTextCriterionOperatorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SOUNDEX_AND"/&gt;
 *     &lt;enumeration value="FUZZY_AND"/&gt;
 *     &lt;enumeration value="SOUNDEX_OR"/&gt;
 *     &lt;enumeration value="FUZZY_OR"/&gt;
 *     &lt;enumeration value="DISTANCE_MAX"/&gt;
 *     &lt;enumeration value="EQUALS"/&gt;
 *     &lt;enumeration value="NOT_EQUALS"/&gt;
 *     &lt;enumeration value="STARTS"/&gt;
 *     &lt;enumeration value="ENDS"/&gt;
 *     &lt;enumeration value="CONTAINS"/&gt;
 *     &lt;enumeration value="LIKE"/&gt;
 *     &lt;enumeration value="NOT_LIKE"/&gt;
 *     &lt;enumeration value="BETWEEN"/&gt;
 *     &lt;enumeration value="IS_NULL"/&gt;
 *     &lt;enumeration value="NOT_NULL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OracleTextCriterionOperatorType")
@XmlEnum
public enum OracleTextCriterionOperatorType {

    SOUNDEX_AND,
    FUZZY_AND,
    SOUNDEX_OR,
    FUZZY_OR,
    DISTANCE_MAX,
    EQUALS,
    NOT_EQUALS,
    STARTS,
    ENDS,
    CONTAINS,
    LIKE,
    NOT_LIKE,
    BETWEEN,
    IS_NULL,
    NOT_NULL;

    public String value() {
        return name();
    }

    public static OracleTextCriterionOperatorType fromValue(String v) {
        return valueOf(v);
    }

}
