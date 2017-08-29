
package abac.message.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MessageFaultType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MessageFaultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageFaultCode" type="{http://www.ec.europa.eu/budg/abac/message/v1}MessageFaultCodeType"/&gt;
 *         &lt;element name="MessageFaultReason" type="{http://www.ec.europa.eu/budg/abac/message/v1}MessageFaultReasonType"/&gt;
 *         &lt;element name="MessageFaultDetail" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ServerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="Program" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ProgramUnit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="ProgramLine" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="XsdValidationFailure" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *                             &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
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
 *         &lt;element name="MessageFaultSource" type="{http://www.ec.europa.eu/budg/abac/message/v1}MessageFaultSourceType" minOccurs="0"/&gt;
 *         &lt;element name="MessageUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageFaultType", propOrder = {
    "messageFaultCode",
    "messageFaultReason",
    "messageFaultDetail",
    "messageFaultSource",
    "messageUUID"
})
public class MessageFaultType {

    @XmlElement(name = "MessageFaultCode", required = true)
    protected String messageFaultCode;
    @XmlElement(name = "MessageFaultReason", required = true)
    protected String messageFaultReason;
    @XmlElement(name = "MessageFaultDetail")
    protected MessageFaultDetail messageFaultDetail;
    @XmlElement(name = "MessageFaultSource")
    protected String messageFaultSource;
    @XmlElement(name = "MessageUUID")
    protected String messageUUID;

    /**
     * Obtiene el valor de la propiedad messageFaultCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageFaultCode() {
        return messageFaultCode;
    }

    /**
     * Define el valor de la propiedad messageFaultCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageFaultCode(String value) {
        this.messageFaultCode = value;
    }

    /**
     * Obtiene el valor de la propiedad messageFaultReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageFaultReason() {
        return messageFaultReason;
    }

    /**
     * Define el valor de la propiedad messageFaultReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageFaultReason(String value) {
        this.messageFaultReason = value;
    }

    /**
     * Obtiene el valor de la propiedad messageFaultDetail.
     * 
     * @return
     *     possible object is
     *     {@link MessageFaultDetail }
     *     
     */
    public MessageFaultDetail getMessageFaultDetail() {
        return messageFaultDetail;
    }

    /**
     * Define el valor de la propiedad messageFaultDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageFaultDetail }
     *     
     */
    public void setMessageFaultDetail(MessageFaultDetail value) {
        this.messageFaultDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad messageFaultSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageFaultSource() {
        return messageFaultSource;
    }

    /**
     * Define el valor de la propiedad messageFaultSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageFaultSource(String value) {
        this.messageFaultSource = value;
    }

    /**
     * Obtiene el valor de la propiedad messageUUID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageUUID() {
        return messageUUID;
    }

    /**
     * Define el valor de la propiedad messageUUID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageUUID(String value) {
        this.messageUUID = value;
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
     *         &lt;element name="ServerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="Program" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ProgramUnit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="ProgramLine" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="XsdValidationFailure" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
     *                   &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
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
        "serverName",
        "program",
        "xsdValidationFailure"
    })
    public static class MessageFaultDetail {

        @XmlElement(name = "ServerName")
        protected String serverName;
        @XmlElement(name = "Program")
        protected List<Program> program;
        @XmlElement(name = "XsdValidationFailure")
        protected XsdValidationFailure xsdValidationFailure;

        /**
         * Obtiene el valor de la propiedad serverName.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServerName() {
            return serverName;
        }

        /**
         * Define el valor de la propiedad serverName.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServerName(String value) {
            this.serverName = value;
        }

        /**
         * Gets the value of the program property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the program property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProgram().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Program }
         * 
         * 
         */
        public List<Program> getProgram() {
            if (program == null) {
                program = new ArrayList<Program>();
            }
            return this.program;
        }

        /**
         * Obtiene el valor de la propiedad xsdValidationFailure.
         * 
         * @return
         *     possible object is
         *     {@link XsdValidationFailure }
         *     
         */
        public XsdValidationFailure getXsdValidationFailure() {
            return xsdValidationFailure;
        }

        /**
         * Define el valor de la propiedad xsdValidationFailure.
         * 
         * @param value
         *     allowed object is
         *     {@link XsdValidationFailure }
         *     
         */
        public void setXsdValidationFailure(XsdValidationFailure value) {
            this.xsdValidationFailure = value;
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
         *         &lt;element name="ProgramUnit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="ProgramLine" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
            "programUnit",
            "programLine"
        })
        public static class Program {

            @XmlElement(name = "ProgramUnit", required = true)
            protected String programUnit;
            @XmlElement(name = "ProgramLine")
            protected int programLine;

            /**
             * Obtiene el valor de la propiedad programUnit.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProgramUnit() {
                return programUnit;
            }

            /**
             * Define el valor de la propiedad programUnit.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProgramUnit(String value) {
                this.programUnit = value;
            }

            /**
             * Obtiene el valor de la propiedad programLine.
             * 
             */
            public int getProgramLine() {
                return programLine;
            }

            /**
             * Define el valor de la propiedad programLine.
             * 
             */
            public void setProgramLine(int value) {
                this.programLine = value;
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
         *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
         *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
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
            "messageAndLocation"
        })
        public static class XsdValidationFailure {

            @XmlElements({
                @XmlElement(name = "Message", type = String.class),
                @XmlElement(name = "Location")
            })
            protected List<Object> messageAndLocation;

            /**
             * Gets the value of the messageAndLocation property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the messageAndLocation property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getMessageAndLocation().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * {@link Object }
             * 
             * 
             */
            public List<Object> getMessageAndLocation() {
                if (messageAndLocation == null) {
                    messageAndLocation = new ArrayList<Object>();
                }
                return this.messageAndLocation;
            }

        }

    }

}
