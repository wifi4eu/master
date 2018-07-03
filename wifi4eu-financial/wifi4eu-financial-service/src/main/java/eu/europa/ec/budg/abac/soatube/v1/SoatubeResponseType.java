
package eu.europa.ec.budg.abac.soatube.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import eu.europa.ec.budg.abac.message.v1.MessageResponseType;


/**
 * <p>Clase Java para SoatubeResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SoatubeResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ec.europa.eu/budg/abac/message/v1}MessageResponseType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="ServicesList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Service" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *                             &lt;element name="SystemName" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                                   &lt;enumeration value="ABAC"/>
 *                                   &lt;enumeration value="SAP"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="RevisionNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="DatabaseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApplicationVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoatubeResponseType", propOrder = {
    "servicesList",
    "databaseName",
    "applicationVersion"
})
public class SoatubeResponseType
    extends MessageResponseType
{

    @XmlElement(name = "ServicesList")
    protected ServicesList servicesList;
    @XmlElement(name = "DatabaseName")
    protected String databaseName;
    @XmlElement(name = "ApplicationVersion")
    protected String applicationVersion;

    /**
     * Obtiene el valor de la propiedad servicesList.
     * 
     * @return
     *     possible object is
     *     {@link ServicesList }
     *     
     */
    public ServicesList getServicesList() {
        return servicesList;
    }

    /**
     * Define el valor de la propiedad servicesList.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicesList }
     *     
     */
    public void setServicesList(ServicesList value) {
        this.servicesList = value;
    }

    /**
     * Obtiene el valor de la propiedad databaseName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * Define el valor de la propiedad databaseName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabaseName(String value) {
        this.databaseName = value;
    }

    /**
     * Obtiene el valor de la propiedad applicationVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationVersion() {
        return applicationVersion;
    }

    /**
     * Define el valor de la propiedad applicationVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationVersion(String value) {
        this.applicationVersion = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Service" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}token"/>
     *                   &lt;element name="SystemName" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *                         &lt;enumeration value="ABAC"/>
     *                         &lt;enumeration value="SAP"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="RevisionNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "service"
    })
    public static class ServicesList {

        @XmlElement(name = "Service")
        protected List<Service> service;

        /**
         * Gets the value of the service property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the service property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getService().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Service }
         * 
         * 
         */
        public List<Service> getService() {
            if (service == null) {
                service = new ArrayList<Service>();
            }
            return this.service;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}token"/>
         *         &lt;element name="SystemName" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
         *               &lt;enumeration value="ABAC"/>
         *               &lt;enumeration value="SAP"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="RevisionNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "name",
            "systemName",
            "revisionNumber"
        })
        public static class Service {

            @XmlElement(name = "Name", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "token")
            protected String name;
            @XmlElement(name = "SystemName")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String systemName;
            @XmlElement(name = "RevisionNumber", required = true)
            protected String revisionNumber;

            /**
             * Obtiene el valor de la propiedad name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Define el valor de la propiedad name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Obtiene el valor de la propiedad systemName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSystemName() {
                return systemName;
            }

            /**
             * Define el valor de la propiedad systemName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSystemName(String value) {
                this.systemName = value;
            }

            /**
             * Obtiene el valor de la propiedad revisionNumber.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRevisionNumber() {
                return revisionNumber;
            }

            /**
             * Define el valor de la propiedad revisionNumber.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRevisionNumber(String value) {
                this.revisionNumber = value;
            }

        }

    }

}
