
package eu.europa.ec.budg.abac.legal_commitment.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PaymentTimeLimitType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaymentTimeLimitType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ApprovalReport" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SpecificTimeLimitForReportApproval" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}SpecificTimeLimitForReportApprovalType" minOccurs="0"/&gt;
 *                   &lt;element name="TimeLimitForReportApproval" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}TimeLimitForReportApprovalCodeType" minOccurs="0"/&gt;
 *                             &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PaymentTerms"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PaymentTypeCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}PaymentTypeCodeType" minOccurs="0"/&gt;
 *                   &lt;element name="ReasonPaymentTimeLimitNotApplicableCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}ReasonPaymentTimeLimitNotApplicableCodeType" minOccurs="0"/&gt;
 *                   &lt;element name="SpecificTimeLimitForPayment" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}SpecificTimeLimitForPaymentType" minOccurs="0"/&gt;
 *                   &lt;element name="TimeLimitForPayment" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}TimeLimitForPaymentCodeType" minOccurs="0"/&gt;
 *                             &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTimeLimitType", propOrder = {
    "approvalReport",
    "paymentTerms"
})
public class PaymentTimeLimitType {

    @XmlElement(name = "ApprovalReport")
    protected PaymentTimeLimitType.ApprovalReport approvalReport;
    @XmlElement(name = "PaymentTerms", required = true)
    protected PaymentTimeLimitType.PaymentTerms paymentTerms;

    /**
     * Obtiene el valor de la propiedad approvalReport.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTimeLimitType.ApprovalReport }
     *     
     */
    public PaymentTimeLimitType.ApprovalReport getApprovalReport() {
        return approvalReport;
    }

    /**
     * Define el valor de la propiedad approvalReport.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTimeLimitType.ApprovalReport }
     *     
     */
    public void setApprovalReport(PaymentTimeLimitType.ApprovalReport value) {
        this.approvalReport = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentTerms.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTimeLimitType.PaymentTerms }
     *     
     */
    public PaymentTimeLimitType.PaymentTerms getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * Define el valor de la propiedad paymentTerms.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTimeLimitType.PaymentTerms }
     *     
     */
    public void setPaymentTerms(PaymentTimeLimitType.PaymentTerms value) {
        this.paymentTerms = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="SpecificTimeLimitForReportApproval" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}SpecificTimeLimitForReportApprovalType" minOccurs="0"/&gt;
     *         &lt;element name="TimeLimitForReportApproval" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}TimeLimitForReportApprovalCodeType" minOccurs="0"/&gt;
     *                   &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "specificTimeLimitForReportApproval",
        "timeLimitForReportApproval"
    })
    public static class ApprovalReport {

        @XmlElement(name = "SpecificTimeLimitForReportApproval")
        protected BigInteger specificTimeLimitForReportApproval;
        @XmlElement(name = "TimeLimitForReportApproval")
        protected PaymentTimeLimitType.ApprovalReport.TimeLimitForReportApproval timeLimitForReportApproval;

        /**
         * Obtiene el valor de la propiedad specificTimeLimitForReportApproval.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSpecificTimeLimitForReportApproval() {
            return specificTimeLimitForReportApproval;
        }

        /**
         * Define el valor de la propiedad specificTimeLimitForReportApproval.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSpecificTimeLimitForReportApproval(BigInteger value) {
            this.specificTimeLimitForReportApproval = value;
        }

        /**
         * Obtiene el valor de la propiedad timeLimitForReportApproval.
         * 
         * @return
         *     possible object is
         *     {@link PaymentTimeLimitType.ApprovalReport.TimeLimitForReportApproval }
         *     
         */
        public PaymentTimeLimitType.ApprovalReport.TimeLimitForReportApproval getTimeLimitForReportApproval() {
            return timeLimitForReportApproval;
        }

        /**
         * Define el valor de la propiedad timeLimitForReportApproval.
         * 
         * @param value
         *     allowed object is
         *     {@link PaymentTimeLimitType.ApprovalReport.TimeLimitForReportApproval }
         *     
         */
        public void setTimeLimitForReportApproval(PaymentTimeLimitType.ApprovalReport.TimeLimitForReportApproval value) {
            this.timeLimitForReportApproval = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}TimeLimitForReportApprovalCodeType" minOccurs="0"/&gt;
         *         &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "code",
            "financialRegulationCode"
        })
        public static class TimeLimitForReportApproval {

            @XmlElement(name = "Code")
            protected String code;
            @XmlElement(name = "FinancialRegulationCode")
            protected String financialRegulationCode;

            /**
             * Obtiene el valor de la propiedad code.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Define el valor de la propiedad code.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            /**
             * Obtiene el valor de la propiedad financialRegulationCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFinancialRegulationCode() {
                return financialRegulationCode;
            }

            /**
             * Define el valor de la propiedad financialRegulationCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFinancialRegulationCode(String value) {
                this.financialRegulationCode = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PaymentTypeCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}PaymentTypeCodeType" minOccurs="0"/&gt;
     *         &lt;element name="ReasonPaymentTimeLimitNotApplicableCode" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}ReasonPaymentTimeLimitNotApplicableCodeType" minOccurs="0"/&gt;
     *         &lt;element name="SpecificTimeLimitForPayment" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}SpecificTimeLimitForPaymentType" minOccurs="0"/&gt;
     *         &lt;element name="TimeLimitForPayment" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}TimeLimitForPaymentCodeType" minOccurs="0"/&gt;
     *                   &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "paymentTypeCode",
        "reasonPaymentTimeLimitNotApplicableCode",
        "specificTimeLimitForPayment",
        "timeLimitForPayment"
    })
    public static class PaymentTerms {

        @XmlElement(name = "PaymentTypeCode")
        protected String paymentTypeCode;
        @XmlElement(name = "ReasonPaymentTimeLimitNotApplicableCode")
        protected String reasonPaymentTimeLimitNotApplicableCode;
        @XmlElement(name = "SpecificTimeLimitForPayment")
        protected BigInteger specificTimeLimitForPayment;
        @XmlElement(name = "TimeLimitForPayment")
        protected PaymentTimeLimitType.PaymentTerms.TimeLimitForPayment timeLimitForPayment;

        /**
         * Obtiene el valor de la propiedad paymentTypeCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentTypeCode() {
            return paymentTypeCode;
        }

        /**
         * Define el valor de la propiedad paymentTypeCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentTypeCode(String value) {
            this.paymentTypeCode = value;
        }

        /**
         * Obtiene el valor de la propiedad reasonPaymentTimeLimitNotApplicableCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReasonPaymentTimeLimitNotApplicableCode() {
            return reasonPaymentTimeLimitNotApplicableCode;
        }

        /**
         * Define el valor de la propiedad reasonPaymentTimeLimitNotApplicableCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReasonPaymentTimeLimitNotApplicableCode(String value) {
            this.reasonPaymentTimeLimitNotApplicableCode = value;
        }

        /**
         * Obtiene el valor de la propiedad specificTimeLimitForPayment.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSpecificTimeLimitForPayment() {
            return specificTimeLimitForPayment;
        }

        /**
         * Define el valor de la propiedad specificTimeLimitForPayment.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSpecificTimeLimitForPayment(BigInteger value) {
            this.specificTimeLimitForPayment = value;
        }

        /**
         * Obtiene el valor de la propiedad timeLimitForPayment.
         * 
         * @return
         *     possible object is
         *     {@link PaymentTimeLimitType.PaymentTerms.TimeLimitForPayment }
         *     
         */
        public PaymentTimeLimitType.PaymentTerms.TimeLimitForPayment getTimeLimitForPayment() {
            return timeLimitForPayment;
        }

        /**
         * Define el valor de la propiedad timeLimitForPayment.
         * 
         * @param value
         *     allowed object is
         *     {@link PaymentTimeLimitType.PaymentTerms.TimeLimitForPayment }
         *     
         */
        public void setTimeLimitForPayment(PaymentTimeLimitType.PaymentTerms.TimeLimitForPayment value) {
            this.timeLimitForPayment = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="Code" type="{http://www.ec.europa.eu/budg/abac/legal_commitment/v1}TimeLimitForPaymentCodeType" minOccurs="0"/&gt;
         *         &lt;element name="FinancialRegulationCode" type="{http://www.ec.europa.eu/budg/abac/financial_regulation/v1}FinancialRegulationCodeType" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "code",
            "financialRegulationCode"
        })
        public static class TimeLimitForPayment {

            @XmlElement(name = "Code")
            protected String code;
            @XmlElement(name = "FinancialRegulationCode")
            protected String financialRegulationCode;

            /**
             * Obtiene el valor de la propiedad code.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Define el valor de la propiedad code.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            /**
             * Obtiene el valor de la propiedad financialRegulationCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFinancialRegulationCode() {
                return financialRegulationCode;
            }

            /**
             * Define el valor de la propiedad financialRegulationCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFinancialRegulationCode(String value) {
                this.financialRegulationCode = value;
            }

        }

    }

}
