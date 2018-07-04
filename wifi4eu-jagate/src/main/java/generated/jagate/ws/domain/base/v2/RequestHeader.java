
package generated.jagate.ws.domain.base.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
 * <p>Java class for RequestHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ec.europa.eu/rdg/jagate/ws/domain/base/v2}SecurityContext" minOccurs="0"/>
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
 *                             &lt;element name="PageSize" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="PageNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "RequestHeader", propOrder = {
    "securityContext",
    "resultSetContext"
})
public class RequestHeader
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "SecurityContext")
    protected SecurityContext securityContext;
    @XmlElement(name = "ResultSetContext")
    protected RequestHeader.ResultSetContext resultSetContext;

    /**
     * Gets the value of the securityContext property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityContext }
     *     
     */
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    /**
     * Sets the value of the securityContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityContext }
     *     
     */
    public void setSecurityContext(SecurityContext value) {
        this.securityContext = value;
    }

    /**
     * Gets the value of the resultSetContext property.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeader.ResultSetContext }
     *     
     */
    public RequestHeader.ResultSetContext getResultSetContext() {
        return resultSetContext;
    }

    /**
     * Sets the value of the resultSetContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeader.ResultSetContext }
     *     
     */
    public void setResultSetContext(RequestHeader.ResultSetContext value) {
        this.resultSetContext = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RequestHeader)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RequestHeader that = ((RequestHeader) object);
        {
            SecurityContext lhsSecurityContext;
            lhsSecurityContext = this.getSecurityContext();
            SecurityContext rhsSecurityContext;
            rhsSecurityContext = that.getSecurityContext();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "securityContext", lhsSecurityContext), LocatorUtils.property(thatLocator, "securityContext", rhsSecurityContext), lhsSecurityContext, rhsSecurityContext)) {
                return false;
            }
        }
        {
            RequestHeader.ResultSetContext lhsResultSetContext;
            lhsResultSetContext = this.getResultSetContext();
            RequestHeader.ResultSetContext rhsResultSetContext;
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
            SecurityContext theSecurityContext;
            theSecurityContext = this.getSecurityContext();
            strategy.appendField(locator, this, "securityContext", buffer, theSecurityContext);
        }
        {
            RequestHeader.ResultSetContext theResultSetContext;
            theResultSetContext = this.getResultSetContext();
            strategy.appendField(locator, this, "resultSetContext", buffer, theResultSetContext);
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            SecurityContext theSecurityContext;
            theSecurityContext = this.getSecurityContext();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "securityContext", theSecurityContext), currentHashCode, theSecurityContext);
        }
        {
            RequestHeader.ResultSetContext theResultSetContext;
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
     *         &lt;element name="StatelessPagination" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PageSize" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="PageNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
    @XmlType(name = "", propOrder = {
        "statelessPagination"
    })
    public static class ResultSetContext
        implements Equals, HashCode, ToString
    {

        @XmlElement(name = "StatelessPagination")
        protected RequestHeader.ResultSetContext.StatelessPagination statelessPagination;

        /**
         * Gets the value of the statelessPagination property.
         * 
         * @return
         *     possible object is
         *     {@link RequestHeader.ResultSetContext.StatelessPagination }
         *     
         */
        public RequestHeader.ResultSetContext.StatelessPagination getStatelessPagination() {
            return statelessPagination;
        }

        /**
         * Sets the value of the statelessPagination property.
         * 
         * @param value
         *     allowed object is
         *     {@link RequestHeader.ResultSetContext.StatelessPagination }
         *     
         */
        public void setStatelessPagination(RequestHeader.ResultSetContext.StatelessPagination value) {
            this.statelessPagination = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof RequestHeader.ResultSetContext)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final RequestHeader.ResultSetContext that = ((RequestHeader.ResultSetContext) object);
            {
                RequestHeader.ResultSetContext.StatelessPagination lhsStatelessPagination;
                lhsStatelessPagination = this.getStatelessPagination();
                RequestHeader.ResultSetContext.StatelessPagination rhsStatelessPagination;
                rhsStatelessPagination = that.getStatelessPagination();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "statelessPagination", lhsStatelessPagination), LocatorUtils.property(thatLocator, "statelessPagination", rhsStatelessPagination), lhsStatelessPagination, rhsStatelessPagination)) {
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
                RequestHeader.ResultSetContext.StatelessPagination theStatelessPagination;
                theStatelessPagination = this.getStatelessPagination();
                strategy.appendField(locator, this, "statelessPagination", buffer, theStatelessPagination);
            }
            return buffer;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                RequestHeader.ResultSetContext.StatelessPagination theStatelessPagination;
                theStatelessPagination = this.getStatelessPagination();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "statelessPagination", theStatelessPagination), currentHashCode, theStatelessPagination);
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
         *         &lt;element name="PageSize" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="PageNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
            "pageNumber"
        })
        public static class StatelessPagination
            implements Equals, HashCode, ToString
        {

            @XmlElement(name = "PageSize")
            protected BigInteger pageSize;
            @XmlElement(name = "PageNumber")
            protected BigInteger pageNumber;

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
             * Gets the value of the pageNumber property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getPageNumber() {
                return pageNumber;
            }

            /**
             * Sets the value of the pageNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setPageNumber(BigInteger value) {
                this.pageNumber = value;
            }

            public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
                if (!(object instanceof RequestHeader.ResultSetContext.StatelessPagination)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                final RequestHeader.ResultSetContext.StatelessPagination that = ((RequestHeader.ResultSetContext.StatelessPagination) object);
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
                    BigInteger lhsPageNumber;
                    lhsPageNumber = this.getPageNumber();
                    BigInteger rhsPageNumber;
                    rhsPageNumber = that.getPageNumber();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "pageNumber", lhsPageNumber), LocatorUtils.property(thatLocator, "pageNumber", rhsPageNumber), lhsPageNumber, rhsPageNumber)) {
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
                    BigInteger thePageNumber;
                    thePageNumber = this.getPageNumber();
                    strategy.appendField(locator, this, "pageNumber", buffer, thePageNumber);
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
                    BigInteger thePageNumber;
                    thePageNumber = this.getPageNumber();
                    currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pageNumber", thePageNumber), currentHashCode, thePageNumber);
                }
                return currentHashCode;
            }

            public int hashCode() {
                final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
                return this.hashCode(null, strategy);
            }

        }

    }

}
