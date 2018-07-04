
package generated.jagate.model.header.V1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import generated.jagate.model.coderef.V3.CodeRefType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for HeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageContext" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SecurityContext" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SystemId" type="{http://ec.europa.eu/research/fp/model/base/V1}SystemsType"/>
 *                   &lt;element name="EcasDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EcasUserId" type="{http://ec.europa.eu/research/fp/model/base/V1}ECUserIdType" minOccurs="0"/>
 *                   &lt;element name="OnBehalfOfSystemId" type="{http://ec.europa.eu/research/fp/model/base/V1}SystemsType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ResultSetContext" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StatelessPagination" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PageSize" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="PageNumberStartingFromZero" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Locale" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderType", propOrder = {
    "messageContext",
    "securityContext",
    "resultSetContext"
})
public class HeaderType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "MessageContext")
    protected HeaderType.MessageContext messageContext;
    @XmlElement(name = "SecurityContext")
    protected HeaderType.SecurityContext securityContext;
    @XmlElement(name = "ResultSetContext")
    protected HeaderType.ResultSetContext resultSetContext;

    /**
     * Gets the value of the messageContext property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderType.MessageContext }
     *     
     */
    public HeaderType.MessageContext getMessageContext() {
        return messageContext;
    }

    /**
     * Sets the value of the messageContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderType.MessageContext }
     *     
     */
    public void setMessageContext(HeaderType.MessageContext value) {
        this.messageContext = value;
    }

    /**
     * Gets the value of the securityContext property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderType.SecurityContext }
     *     
     */
    public HeaderType.SecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * Sets the value of the securityContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderType.SecurityContext }
     *     
     */
    public void setSecurityContext(HeaderType.SecurityContext value) {
        this.securityContext = value;
    }

    /**
     * Gets the value of the resultSetContext property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderType.ResultSetContext }
     *     
     */
    public HeaderType.ResultSetContext getResultSetContext() {
        return resultSetContext;
    }

    /**
     * Sets the value of the resultSetContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderType.ResultSetContext }
     *     
     */
    public void setResultSetContext(HeaderType.ResultSetContext value) {
        this.resultSetContext = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof HeaderType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final HeaderType that = ((HeaderType) object);
        {
            HeaderType.MessageContext lhsMessageContext;
            lhsMessageContext = this.getMessageContext();
            HeaderType.MessageContext rhsMessageContext;
            rhsMessageContext = that.getMessageContext();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "messageContext", lhsMessageContext), LocatorUtils.property(thatLocator, "messageContext", rhsMessageContext), lhsMessageContext, rhsMessageContext)) {
                return false;
            }
        }
        {
            HeaderType.SecurityContext lhsSecurityContext;
            lhsSecurityContext = this.getSecurityContext();
            HeaderType.SecurityContext rhsSecurityContext;
            rhsSecurityContext = that.getSecurityContext();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityContext", lhsSecurityContext), LocatorUtils.property(thatLocator, "securityContext", rhsSecurityContext), lhsSecurityContext, rhsSecurityContext)) {
                return false;
            }
        }
        {
            HeaderType.ResultSetContext lhsResultSetContext;
            lhsResultSetContext = this.getResultSetContext();
            HeaderType.ResultSetContext rhsResultSetContext;
            rhsResultSetContext = that.getResultSetContext();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resultSetContext", lhsResultSetContext), LocatorUtils.property(thatLocator, "resultSetContext", rhsResultSetContext), lhsResultSetContext, rhsResultSetContext)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            HeaderType.MessageContext theMessageContext;
            theMessageContext = this.getMessageContext();
            strategy.appendField(locator, this, "messageContext", buffer, theMessageContext);
        }
        {
            HeaderType.SecurityContext theSecurityContext;
            theSecurityContext = this.getSecurityContext();
            strategy.appendField(locator, this, "securityContext", buffer, theSecurityContext);
        }
        {
            HeaderType.ResultSetContext theResultSetContext;
            theResultSetContext = this.getResultSetContext();
            strategy.appendField(locator, this, "resultSetContext", buffer, theResultSetContext);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            HeaderType.MessageContext theMessageContext;
            theMessageContext = this.getMessageContext();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "messageContext", theMessageContext), currentHashCode, theMessageContext);
        }
        {
            HeaderType.SecurityContext theSecurityContext;
            theSecurityContext = this.getSecurityContext();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityContext", theSecurityContext), currentHashCode, theSecurityContext);
        }
        {
            HeaderType.ResultSetContext theResultSetContext;
            theResultSetContext = this.getResultSetContext();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultSetContext", theResultSetContext), currentHashCode, theResultSetContext);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "timestamp"
    })
    public static class MessageContext
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "Id", required = true)
        protected String id;
        @XmlElement(name = "Timestamp", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar timestamp;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the timestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTimestamp() {
            return timestamp;
        }

        /**
         * Sets the value of the timestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTimestamp(XMLGregorianCalendar value) {
            this.timestamp = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof HeaderType.MessageContext)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final HeaderType.MessageContext that = ((HeaderType.MessageContext) object);
            {
                String lhsId;
                lhsId = this.getId();
                String rhsId;
                rhsId = that.getId();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                    return false;
                }
            }
            {
                XMLGregorianCalendar lhsTimestamp;
                lhsTimestamp = this.getTimestamp();
                XMLGregorianCalendar rhsTimestamp;
                rhsTimestamp = that.getTimestamp();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "timestamp", lhsTimestamp), LocatorUtils.property(thatLocator, "timestamp", rhsTimestamp), lhsTimestamp, rhsTimestamp)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
            return equals(null, null, object, strategy);
        }

        public String toString() {
            final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
            final StringBuilder buffer = new StringBuilder();
            append(null, buffer, strategy);
            return buffer.toString();
        }

        public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
            strategy.appendStart(locator, this, buffer);
            appendFields(locator, buffer, strategy);
            strategy.appendEnd(locator, this, buffer);
            return buffer;
        }

        public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
            {
                String theId;
                theId = this.getId();
                strategy.appendField(locator, this, "id", buffer, theId);
            }
            {
                XMLGregorianCalendar theTimestamp;
                theTimestamp = this.getTimestamp();
                strategy.appendField(locator, this, "timestamp", buffer, theTimestamp);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theId;
                theId = this.getId();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
            }
            {
                XMLGregorianCalendar theTimestamp;
                theTimestamp = this.getTimestamp();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "timestamp", theTimestamp), currentHashCode, theTimestamp);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="StatelessPagination" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PageSize" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                   &lt;element name="PageNumberStartingFromZero" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Locale" type="{http://ec.europa.eu/research/fp/model/code-ref/V3}CodeRefType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "statelessPagination",
        "locale"
    })
    public static class ResultSetContext
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "StatelessPagination")
        protected HeaderType.ResultSetContext.StatelessPagination statelessPagination;
        @XmlElement(name = "Locale")
        protected CodeRefType locale;

        /**
         * Gets the value of the statelessPagination property.
         * 
         * @return
         *     possible object is
         *     {@link HeaderType.ResultSetContext.StatelessPagination }
         *     
         */
        public HeaderType.ResultSetContext.StatelessPagination getStatelessPagination() {
            return statelessPagination;
        }

        /**
         * Sets the value of the statelessPagination property.
         * 
         * @param value
         *     allowed object is
         *     {@link HeaderType.ResultSetContext.StatelessPagination }
         *     
         */
        public void setStatelessPagination(HeaderType.ResultSetContext.StatelessPagination value) {
            this.statelessPagination = value;
        }

        /**
         * Gets the value of the locale property.
         * 
         * @return
         *     possible object is
         *     {@link CodeRefType }
         *     
         */
        public CodeRefType getLocale() {
            return locale;
        }

        /**
         * Sets the value of the locale property.
         * 
         * @param value
         *     allowed object is
         *     {@link CodeRefType }
         *     
         */
        public void setLocale(CodeRefType value) {
            this.locale = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof HeaderType.ResultSetContext)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final HeaderType.ResultSetContext that = ((HeaderType.ResultSetContext) object);
            {
                HeaderType.ResultSetContext.StatelessPagination lhsStatelessPagination;
                lhsStatelessPagination = this.getStatelessPagination();
                HeaderType.ResultSetContext.StatelessPagination rhsStatelessPagination;
                rhsStatelessPagination = that.getStatelessPagination();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "statelessPagination", lhsStatelessPagination), LocatorUtils.property(thatLocator, "statelessPagination", rhsStatelessPagination), lhsStatelessPagination, rhsStatelessPagination)) {
                    return false;
                }
            }
            {
                CodeRefType lhsLocale;
                lhsLocale = this.getLocale();
                CodeRefType rhsLocale;
                rhsLocale = that.getLocale();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "locale", lhsLocale), LocatorUtils.property(thatLocator, "locale", rhsLocale), lhsLocale, rhsLocale)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
            return equals(null, null, object, strategy);
        }

        public String toString() {
            final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
            final StringBuilder buffer = new StringBuilder();
            append(null, buffer, strategy);
            return buffer.toString();
        }

        public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
            strategy.appendStart(locator, this, buffer);
            appendFields(locator, buffer, strategy);
            strategy.appendEnd(locator, this, buffer);
            return buffer;
        }

        public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
            {
                HeaderType.ResultSetContext.StatelessPagination theStatelessPagination;
                theStatelessPagination = this.getStatelessPagination();
                strategy.appendField(locator, this, "statelessPagination", buffer, theStatelessPagination);
            }
            {
                CodeRefType theLocale;
                theLocale = this.getLocale();
                strategy.appendField(locator, this, "locale", buffer, theLocale);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                HeaderType.ResultSetContext.StatelessPagination theStatelessPagination;
                theStatelessPagination = this.getStatelessPagination();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "statelessPagination", theStatelessPagination), currentHashCode, theStatelessPagination);
            }
            {
                CodeRefType theLocale;
                theLocale = this.getLocale();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "locale", theLocale), currentHashCode, theLocale);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="PageSize" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *         &lt;element name="PageNumberStartingFromZero" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "pageSize",
            "pageNumberStartingFromZero"
        })
        public static class StatelessPagination
            implements Equals, HashCode, ToString
        {

            @XmlElement(name = "PageSize", required = true)
            protected BigInteger pageSize;
            @XmlElement(name = "PageNumberStartingFromZero")
            protected BigInteger pageNumberStartingFromZero;

            /**
             * Gets the value of the pageSize property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getPageSize() {
                return pageSize;
            }

            /**
             * Sets the value of the pageSize property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setPageSize(BigInteger value) {
                this.pageSize = value;
            }

            /**
             * Gets the value of the pageNumberStartingFromZero property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getPageNumberStartingFromZero() {
                return pageNumberStartingFromZero;
            }

            /**
             * Sets the value of the pageNumberStartingFromZero property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setPageNumberStartingFromZero(BigInteger value) {
                this.pageNumberStartingFromZero = value;
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof HeaderType.ResultSetContext.StatelessPagination)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final HeaderType.ResultSetContext.StatelessPagination that = ((HeaderType.ResultSetContext.StatelessPagination) object);
                {
                    BigInteger lhsPageSize;
                    lhsPageSize = this.getPageSize();
                    BigInteger rhsPageSize;
                    rhsPageSize = that.getPageSize();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "pageSize", lhsPageSize), LocatorUtils.property(thatLocator, "pageSize", rhsPageSize), lhsPageSize, rhsPageSize)) {
                        return false;
                    }
                }
                {
                    BigInteger lhsPageNumberStartingFromZero;
                    lhsPageNumberStartingFromZero = this.getPageNumberStartingFromZero();
                    BigInteger rhsPageNumberStartingFromZero;
                    rhsPageNumberStartingFromZero = that.getPageNumberStartingFromZero();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "pageNumberStartingFromZero", lhsPageNumberStartingFromZero), LocatorUtils.property(thatLocator, "pageNumberStartingFromZero", rhsPageNumberStartingFromZero), lhsPageNumberStartingFromZero, rhsPageNumberStartingFromZero)) {
                        return false;
                    }
                }
                return true;
            }

            public boolean equals(Object object) {
                final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
                return equals(null, null, object, strategy);
            }

            public String toString() {
                final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
                final StringBuilder buffer = new StringBuilder();
                append(null, buffer, strategy);
                return buffer.toString();
            }

            public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
                strategy.appendStart(locator, this, buffer);
                appendFields(locator, buffer, strategy);
                strategy.appendEnd(locator, this, buffer);
                return buffer;
            }

            public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
                {
                    BigInteger thePageSize;
                    thePageSize = this.getPageSize();
                    strategy.appendField(locator, this, "pageSize", buffer, thePageSize);
                }
                {
                    BigInteger thePageNumberStartingFromZero;
                    thePageNumberStartingFromZero = this.getPageNumberStartingFromZero();
                    strategy.appendField(locator, this, "pageNumberStartingFromZero", buffer, thePageNumberStartingFromZero);
                }
                return buffer;
            }

            public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
                int currentHashCode = 1;
                {
                    BigInteger thePageSize;
                    thePageSize = this.getPageSize();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pageSize", thePageSize), currentHashCode, thePageSize);
                }
                {
                    BigInteger thePageNumberStartingFromZero;
                    thePageNumberStartingFromZero = this.getPageNumberStartingFromZero();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pageNumberStartingFromZero", thePageNumberStartingFromZero), currentHashCode, thePageNumberStartingFromZero);
                }
                return currentHashCode;
            }

            public int hashCode() {
                final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
                return this.hashCode(null, strategy);
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SystemId" type="{http://ec.europa.eu/research/fp/model/base/V1}SystemsType"/>
     *         &lt;element name="EcasDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="EcasUserId" type="{http://ec.europa.eu/research/fp/model/base/V1}ECUserIdType" minOccurs="0"/>
     *         &lt;element name="OnBehalfOfSystemId" type="{http://ec.europa.eu/research/fp/model/base/V1}SystemsType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "systemId",
        "ecasDomain",
        "ecasUserId",
        "onBehalfOfSystemId"
    })
    public static class SecurityContext
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "SystemId", required = true)
        protected String systemId;
        @XmlElement(name = "EcasDomain")
        protected String ecasDomain;
        @XmlElement(name = "EcasUserId")
        protected String ecasUserId;
        @XmlElement(name = "OnBehalfOfSystemId")
        protected String onBehalfOfSystemId;

        /**
         * Gets the value of the systemId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSystemId() {
            return systemId;
        }

        /**
         * Sets the value of the systemId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSystemId(String value) {
            this.systemId = value;
        }

        /**
         * Gets the value of the ecasDomain property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEcasDomain() {
            return ecasDomain;
        }

        /**
         * Sets the value of the ecasDomain property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEcasDomain(String value) {
            this.ecasDomain = value;
        }

        /**
         * Gets the value of the ecasUserId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEcasUserId() {
            return ecasUserId;
        }

        /**
         * Sets the value of the ecasUserId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEcasUserId(String value) {
            this.ecasUserId = value;
        }

        /**
         * Gets the value of the onBehalfOfSystemId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOnBehalfOfSystemId() {
            return onBehalfOfSystemId;
        }

        /**
         * Sets the value of the onBehalfOfSystemId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOnBehalfOfSystemId(String value) {
            this.onBehalfOfSystemId = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof HeaderType.SecurityContext)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final HeaderType.SecurityContext that = ((HeaderType.SecurityContext) object);
            {
                String lhsSystemId;
                lhsSystemId = this.getSystemId();
                String rhsSystemId;
                rhsSystemId = that.getSystemId();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "systemId", lhsSystemId), LocatorUtils.property(thatLocator, "systemId", rhsSystemId), lhsSystemId, rhsSystemId)) {
                    return false;
                }
            }
            {
                String lhsEcasDomain;
                lhsEcasDomain = this.getEcasDomain();
                String rhsEcasDomain;
                rhsEcasDomain = that.getEcasDomain();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "ecasDomain", lhsEcasDomain), LocatorUtils.property(thatLocator, "ecasDomain", rhsEcasDomain), lhsEcasDomain, rhsEcasDomain)) {
                    return false;
                }
            }
            {
                String lhsEcasUserId;
                lhsEcasUserId = this.getEcasUserId();
                String rhsEcasUserId;
                rhsEcasUserId = that.getEcasUserId();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "ecasUserId", lhsEcasUserId), LocatorUtils.property(thatLocator, "ecasUserId", rhsEcasUserId), lhsEcasUserId, rhsEcasUserId)) {
                    return false;
                }
            }
            {
                String lhsOnBehalfOfSystemId;
                lhsOnBehalfOfSystemId = this.getOnBehalfOfSystemId();
                String rhsOnBehalfOfSystemId;
                rhsOnBehalfOfSystemId = that.getOnBehalfOfSystemId();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "onBehalfOfSystemId", lhsOnBehalfOfSystemId), LocatorUtils.property(thatLocator, "onBehalfOfSystemId", rhsOnBehalfOfSystemId), lhsOnBehalfOfSystemId, rhsOnBehalfOfSystemId)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
            return equals(null, null, object, strategy);
        }

        public String toString() {
            final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
            final StringBuilder buffer = new StringBuilder();
            append(null, buffer, strategy);
            return buffer.toString();
        }

        public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
            strategy.appendStart(locator, this, buffer);
            appendFields(locator, buffer, strategy);
            strategy.appendEnd(locator, this, buffer);
            return buffer;
        }

        public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
            {
                String theSystemId;
                theSystemId = this.getSystemId();
                strategy.appendField(locator, this, "systemId", buffer, theSystemId);
            }
            {
                String theEcasDomain;
                theEcasDomain = this.getEcasDomain();
                strategy.appendField(locator, this, "ecasDomain", buffer, theEcasDomain);
            }
            {
                String theEcasUserId;
                theEcasUserId = this.getEcasUserId();
                strategy.appendField(locator, this, "ecasUserId", buffer, theEcasUserId);
            }
            {
                String theOnBehalfOfSystemId;
                theOnBehalfOfSystemId = this.getOnBehalfOfSystemId();
                strategy.appendField(locator, this, "onBehalfOfSystemId", buffer, theOnBehalfOfSystemId);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theSystemId;
                theSystemId = this.getSystemId();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "systemId", theSystemId), currentHashCode, theSystemId);
            }
            {
                String theEcasDomain;
                theEcasDomain = this.getEcasDomain();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ecasDomain", theEcasDomain), currentHashCode, theEcasDomain);
            }
            {
                String theEcasUserId;
                theEcasUserId = this.getEcasUserId();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ecasUserId", theEcasUserId), currentHashCode, theEcasUserId);
            }
            {
                String theOnBehalfOfSystemId;
                theOnBehalfOfSystemId = this.getOnBehalfOfSystemId();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onBehalfOfSystemId", theOnBehalfOfSystemId), currentHashCode, theOnBehalfOfSystemId);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
