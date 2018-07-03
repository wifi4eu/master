
package eu.europa.ec.budg.abac.search_criterion.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NumberCriterionOperatorType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="NumberCriterionOperatorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="EQUALS"/&gt;
 *     &lt;enumeration value="GREATER_THAN"/&gt;
 *     &lt;enumeration value="LESS_THAN"/&gt;
 *     &lt;enumeration value="GREATER_OR_EQUAL_THAN"/&gt;
 *     &lt;enumeration value="LESS_OR_EQUAL_THAN"/&gt;
 *     &lt;enumeration value="DIFFERENT"/&gt;
 *     &lt;enumeration value="BETWEEN"/&gt;
 *     &lt;enumeration value="IS_NULL"/&gt;
 *     &lt;enumeration value="NOT_NULL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NumberCriterionOperatorType")
@XmlEnum
public enum NumberCriterionOperatorType {

    EQUALS,
    GREATER_THAN,
    LESS_THAN,
    GREATER_OR_EQUAL_THAN,
    LESS_OR_EQUAL_THAN,
    DIFFERENT,
    BETWEEN,
    IS_NULL,
    NOT_NULL;

    public String value() {
        return name();
    }

    public static NumberCriterionOperatorType fromValue(String v) {
        return valueOf(v);
    }

}
