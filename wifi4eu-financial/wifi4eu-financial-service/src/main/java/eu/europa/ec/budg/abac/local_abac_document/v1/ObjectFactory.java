
package eu.europa.ec.budg.abac.local_abac_document.v1;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.europa.ec.budg.abac.local_abac_document.v1 package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.europa.ec.budg.abac.local_abac_document.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResponsibleUsersType }
     * 
     */
    public ResponsibleUsersType createResponsibleUsersType() {
        return new ResponsibleUsersType();
    }

    /**
     * Create an instance of {@link LocalAbacDocumentType.AresDocuments }
     * 
     */
    public LocalAbacDocumentType.AresDocuments createLocalAbacDocumentTypeAresDocuments() {
        return new LocalAbacDocumentType.AresDocuments();
    }

    /**
     * Create an instance of {@link LocalAbacDocumentType.ResponsibleOrganisation }
     * 
     */
    public LocalAbacDocumentType.ResponsibleOrganisation createLocalAbacDocumentTypeResponsibleOrganisation() {
        return new LocalAbacDocumentType.ResponsibleOrganisation();
    }

    /**
     * Create an instance of {@link LocalAbacDocumentType.ScannedDocuments }
     * 
     */
    public LocalAbacDocumentType.ScannedDocuments createLocalAbacDocumentTypeScannedDocuments() {
        return new LocalAbacDocumentType.ScannedDocuments();
    }

}
