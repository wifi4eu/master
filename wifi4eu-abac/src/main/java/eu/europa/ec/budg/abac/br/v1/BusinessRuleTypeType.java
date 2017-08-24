
package eu.europa.ec.budg.abac.br.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BusinessRuleTypeType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="BusinessRuleTypeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="T"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="W"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BusinessRuleTypeType")
@XmlEnum
public enum BusinessRuleTypeType {

    E,
    T,
    I,
    W,
    S;

    public String value() {
        return name();
    }

    public static BusinessRuleTypeType fromValue(String v) {
        return valueOf(v);
    }

}
