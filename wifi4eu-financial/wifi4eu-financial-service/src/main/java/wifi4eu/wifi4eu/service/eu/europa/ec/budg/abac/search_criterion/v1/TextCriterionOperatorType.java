
package wifi4eu.wifi4eu.service.eu.europa.ec.budg.abac.search_criterion.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TextCriterionOperatorType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TextCriterionOperatorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
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
@XmlType(name = "TextCriterionOperatorType")
@XmlEnum
public enum TextCriterionOperatorType {

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

    public static TextCriterionOperatorType fromValue(String v) {
        return valueOf(v);
    }

}
