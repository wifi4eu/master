
package generated.jagate.ws.domain.reference.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EActionCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EActionCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FIA"/>
 *     &lt;enumeration value="TA"/>
 *     &lt;enumeration value="SC"/>
 *     &lt;enumeration value="TR"/>
 *     &lt;enumeration value="RE"/>
 *     &lt;enumeration value="RC"/>
 *     &lt;enumeration value="RR"/>
 *     &lt;enumeration value="RP"/>
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="SR"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="PA"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="AF"/>
 *     &lt;enumeration value="AS"/>
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="AX"/>
 *     &lt;enumeration value="PO"/>
 *     &lt;enumeration value="HD"/>
 *     &lt;enumeration value="TP"/>
 *     &lt;enumeration value="AT"/>
 *     &lt;enumeration value="CN"/>
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="PP"/>
 *     &lt;enumeration value="SU"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="CS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EActionCodeType", namespace = "http://ec.europa.eu/rdg/jagate/ws/domain/reference/v1")
@XmlEnum
public enum EActionCodeType {


    /**
     * Financial Initiating Agent
     * 
     */
    FIA,

    /**
     * TECHNICAL ACCEPTANCE - TA
     * 
     */
    TA,

    /**
     * REFUS POUR CORRECTION - SC
     * 
     */
    SC,

    /**
     * TECHNICAL REJECTION - TR
     * 
     */
    TR,

    /**
     * REFUS FORMEL - RE
     * 
     */
    RE,

    /**
     * RECOURS A LA COMMISS. POUR DECISION - RC
     * 
     */
    RC,

    /**
     * REFUS DEFINITIF (CONFIRMATION) - RR
     * 
     */
    RR,

    /**
     * DECISION DE PASSER OUTRE - RP
     * 
     */
    RP,

    /**
     * ACCORD - AC
     * 
     */
    AC,

    /**
     * SUSPEND - SP
     * 
     */
    SP,

    /**
     * REFUS DEFINITIF - SR
     * 
     */
    SR,

    /**
     * ANNULATION - CC
     * 
     */
    CC,

    /**
     * PARAPH ACCEPT - PA
     * 
     */
    PA,

    /**
     * PARAPH REFUSAL - PR
     * 
     */
    PR,

    /**
     * VISA CF - AF
     * 
     */
    AF,

    /**
     * ACCORD CELLULE FIN. - AS
     * 
     */
    AS,

    /**
     * ACCORD XIX A - AA
     * 
     */
    AA,

    /**
     * ACCORD COMPTABLE - AX
     * 
     */
    AX,

    /**
     * PAS D'OBJECTION - PO
     * 
     */
    PO,

    /**
     * HELPDESK CORRECTION - HD
     * 
     */
    HD,

    /**
     * TECHNICAL ACCEPTANCE (PAYMENT) - TP
     * 
     */
    TP,

    /**
     * Accepted without verification L2 ex ante
     * 
     */
    AT,

    /**
     * COMPENSATION AGAINST R.O. - CN
     * 
     */
    CN,

    /**
     * FINAL APPROVAL
     * 
     */
    OK,

    /**
     * PASSED FOR PAYMENT
     * 
     */
    PP,

    /**
     * SUIVI (FOLLOW-UP) BY TPVT/LEVT
     * 
     */
    SU,

    /**
     * ACCEPT - CARRY-FORWARD
     * 
     */
    CA,

    /**
     * REFUSAL FOR CORRECTION - CARRY-FORWARD
     * 
     */
    CS;

    public String value() {
        return name();
    }

    public static EActionCodeType fromValue(String v) {
        return valueOf(v);
    }

}
