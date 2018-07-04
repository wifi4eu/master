
package eu.europa.ec.research.fp.model.document.v5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.europa.ec.research.fp.model.document.v5 package. 
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

    private final static QName _DocumentMetaData_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "DocumentMetaData");
    private final static QName _AccessibilityClassification_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "AccessibilityClassification");
    private final static QName _OrganisationClassification_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "OrganisationClassification");
    private final static QName _DocumentAttachment_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "DocumentAttachment");
    private final static QName _AttachmentsOrder_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "AttachmentsOrder");
    private final static QName _AssignmentTask_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "AssignmentTask");
    private final static QName _AttachmentAttribute_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "AttachmentAttribute");
    private final static QName _ProjectClassification_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "ProjectClassification");
    private final static QName _DocumentClassification_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "DocumentClassification");
    private final static QName _Document_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "Document");
    private final static QName _DocumentCore_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "DocumentCore");
    private final static QName _AssignmentWorkflow_QNAME = new QName("http://ec.europa.eu/research/fp/model/document/V5", "AssignmentWorkflow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.europa.ec.research.fp.model.document.v5
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DocumentVersionType }
     * 
     */
    public DocumentVersionType createDocumentVersionType() {
        return new DocumentVersionType();
    }

    /**
     * Create an instance of {@link LocalFileType }
     * 
     */
    public LocalFileType createLocalFileType() {
        return new LocalFileType();
    }

    /**
     * Create an instance of {@link LocalFileType.MultiLingualNames }
     * 
     */
    public LocalFileType.MultiLingualNames createLocalFileTypeMultiLingualNames() {
        return new LocalFileType.MultiLingualNames();
    }

    /**
     * Create an instance of {@link DocumentType }
     * 
     */
    public DocumentType createDocumentType() {
        return new DocumentType();
    }

    /**
     * Create an instance of {@link AssignmentWorkflowType }
     * 
     */
    public AssignmentWorkflowType createAssignmentWorkflowType() {
        return new AssignmentWorkflowType();
    }

    /**
     * Create an instance of {@link OrganisationClassificationType }
     * 
     */
    public OrganisationClassificationType createOrganisationClassificationType() {
        return new OrganisationClassificationType();
    }

    /**
     * Create an instance of {@link AttachmentsOrderType }
     * 
     */
    public AttachmentsOrderType createAttachmentsOrderType() {
        return new AttachmentsOrderType();
    }

    /**
     * Create an instance of {@link DocumentAttachmentType }
     * 
     */
    public DocumentAttachmentType createDocumentAttachmentType() {
        return new DocumentAttachmentType();
    }

    /**
     * Create an instance of {@link DocumentMetaDataType }
     * 
     */
    public DocumentMetaDataType createDocumentMetaDataType() {
        return new DocumentMetaDataType();
    }

    /**
     * Create an instance of {@link AccessibilityClassificationType }
     * 
     */
    public AccessibilityClassificationType createAccessibilityClassificationType() {
        return new AccessibilityClassificationType();
    }

    /**
     * Create an instance of {@link AssignmentTaskType }
     * 
     */
    public AssignmentTaskType createAssignmentTaskType() {
        return new AssignmentTaskType();
    }

    /**
     * Create an instance of {@link AttachmentAttributeType }
     * 
     */
    public AttachmentAttributeType createAttachmentAttributeType() {
        return new AttachmentAttributeType();
    }

    /**
     * Create an instance of {@link DocumentCoreType }
     * 
     */
    public DocumentCoreType createDocumentCoreType() {
        return new DocumentCoreType();
    }

    /**
     * Create an instance of {@link ProjectClassificationType }
     * 
     */
    public ProjectClassificationType createProjectClassificationType() {
        return new ProjectClassificationType();
    }

    /**
     * Create an instance of {@link WorkflowUserType }
     * 
     */
    public WorkflowUserType createWorkflowUserType() {
        return new WorkflowUserType();
    }

    /**
     * Create an instance of {@link StringType }
     * 
     */
    public StringType createStringType() {
        return new StringType();
    }

    /**
     * Create an instance of {@link AssignmentWorkflowTaskType }
     * 
     */
    public AssignmentWorkflowTaskType createAssignmentWorkflowTaskType() {
        return new AssignmentWorkflowTaskType();
    }

    /**
     * Create an instance of {@link DocumentAttachmentRefType }
     * 
     */
    public DocumentAttachmentRefType createDocumentAttachmentRefType() {
        return new DocumentAttachmentRefType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link InternalOrganisationType }
     * 
     */
    public InternalOrganisationType createInternalOrganisationType() {
        return new InternalOrganisationType();
    }

    /**
     * Create an instance of {@link ExternaLEntityType }
     * 
     */
    public ExternaLEntityType createExternaLEntityType() {
        return new ExternaLEntityType();
    }

    /**
     * Create an instance of {@link RecipientType }
     * 
     */
    public RecipientType createRecipientType() {
        return new RecipientType();
    }

    /**
     * Create an instance of {@link EntityType }
     * 
     */
    public EntityType createEntityType() {
        return new EntityType();
    }

    /**
     * Create an instance of {@link DateTimeType }
     * 
     */
    public DateTimeType createDateTimeType() {
        return new DateTimeType();
    }

    /**
     * Create an instance of {@link LocalDocumentType }
     * 
     */
    public LocalDocumentType createLocalDocumentType() {
        return new LocalDocumentType();
    }

    /**
     * Create an instance of {@link DocumentStorageType }
     * 
     */
    public DocumentStorageType createDocumentStorageType() {
        return new DocumentStorageType();
    }

    /**
     * Create an instance of {@link DecimalType }
     * 
     */
    public DecimalType createDecimalType() {
        return new DecimalType();
    }

    /**
     * Create an instance of {@link ExternalPersonType }
     * 
     */
    public ExternalPersonType createExternalPersonType() {
        return new ExternalPersonType();
    }

    /**
     * Create an instance of {@link LinkedDocumentType }
     * 
     */
    public LinkedDocumentType createLinkedDocumentType() {
        return new LinkedDocumentType();
    }

    /**
     * Create an instance of {@link CategoryType }
     * 
     */
    public CategoryType createCategoryType() {
        return new CategoryType();
    }

    /**
     * Create an instance of {@link AssignmentTaskListType }
     * 
     */
    public AssignmentTaskListType createAssignmentTaskListType() {
        return new AssignmentTaskListType();
    }

    /**
     * Create an instance of {@link AssignmentWorkflowTaskListType }
     * 
     */
    public AssignmentWorkflowTaskListType createAssignmentWorkflowTaskListType() {
        return new AssignmentWorkflowTaskListType();
    }

    /**
     * Create an instance of {@link AttachmentIdType }
     * 
     */
    public AttachmentIdType createAttachmentIdType() {
        return new AttachmentIdType();
    }

    /**
     * Create an instance of {@link DocumentListType }
     * 
     */
    public DocumentListType createDocumentListType() {
        return new DocumentListType();
    }

    /**
     * Create an instance of {@link AttachmentType }
     * 
     */
    public AttachmentType createAttachmentType() {
        return new AttachmentType();
    }

    /**
     * Create an instance of {@link MetaDataValueType }
     * 
     */
    public MetaDataValueType createMetaDataValueType() {
        return new MetaDataValueType();
    }

    /**
     * Create an instance of {@link BooleanType }
     * 
     */
    public BooleanType createBooleanType() {
        return new BooleanType();
    }

    /**
     * Create an instance of {@link SenderType }
     * 
     */
    public SenderType createSenderType() {
        return new SenderType();
    }

    /**
     * Create an instance of {@link SendersRecipients }
     * 
     */
    public SendersRecipients createSendersRecipients() {
        return new SendersRecipients();
    }

    /**
     * Create an instance of {@link AttachmentAttributeListType }
     * 
     */
    public AttachmentAttributeListType createAttachmentAttributeListType() {
        return new AttachmentAttributeListType();
    }

    /**
     * Create an instance of {@link IntegerType }
     * 
     */
    public IntegerType createIntegerType() {
        return new IntegerType();
    }

    /**
     * Create an instance of {@link InternalEntityType }
     * 
     */
    public InternalEntityType createInternalEntityType() {
        return new InternalEntityType();
    }

    /**
     * Create an instance of {@link AttachmentNameType }
     * 
     */
    public AttachmentNameType createAttachmentNameType() {
        return new AttachmentNameType();
    }

    /**
     * Create an instance of {@link DocumentAccessLogEntryType }
     * 
     */
    public DocumentAccessLogEntryType createDocumentAccessLogEntryType() {
        return new DocumentAccessLogEntryType();
    }

    /**
     * Create an instance of {@link TagInfoType }
     * 
     */
    public TagInfoType createTagInfoType() {
        return new TagInfoType();
    }

    /**
     * Create an instance of {@link DocumentVersionType.StorageList }
     * 
     */
    public DocumentVersionType.StorageList createDocumentVersionTypeStorageList() {
        return new DocumentVersionType.StorageList();
    }

    /**
     * Create an instance of {@link LocalFileType.UserFileRoles }
     * 
     */
    public LocalFileType.UserFileRoles createLocalFileTypeUserFileRoles() {
        return new LocalFileType.UserFileRoles();
    }

    /**
     * Create an instance of {@link LocalFileType.Readers }
     * 
     */
    public LocalFileType.Readers createLocalFileTypeReaders() {
        return new LocalFileType.Readers();
    }

    /**
     * Create an instance of {@link LocalFileType.Users }
     * 
     */
    public LocalFileType.Users createLocalFileTypeUsers() {
        return new LocalFileType.Users();
    }

    /**
     * Create an instance of {@link LocalFileType.Editors }
     * 
     */
    public LocalFileType.Editors createLocalFileTypeEditors() {
        return new LocalFileType.Editors();
    }

    /**
     * Create an instance of {@link LocalFileType.MultiLingualNames.MultiLingualName }
     * 
     */
    public LocalFileType.MultiLingualNames.MultiLingualName createLocalFileTypeMultiLingualNamesMultiLingualName() {
        return new LocalFileType.MultiLingualNames.MultiLingualName();
    }

    /**
     * Create an instance of {@link DocumentType.VersionList }
     * 
     */
    public DocumentType.VersionList createDocumentTypeVersionList() {
        return new DocumentType.VersionList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentMetaDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "DocumentMetaData")
    public JAXBElement<DocumentMetaDataType> createDocumentMetaData(DocumentMetaDataType value) {
        return new JAXBElement<DocumentMetaDataType>(_DocumentMetaData_QNAME, DocumentMetaDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccessibilityClassificationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "AccessibilityClassification")
    public JAXBElement<AccessibilityClassificationType> createAccessibilityClassification(AccessibilityClassificationType value) {
        return new JAXBElement<AccessibilityClassificationType>(_AccessibilityClassification_QNAME, AccessibilityClassificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganisationClassificationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "OrganisationClassification")
    public JAXBElement<OrganisationClassificationType> createOrganisationClassification(OrganisationClassificationType value) {
        return new JAXBElement<OrganisationClassificationType>(_OrganisationClassification_QNAME, OrganisationClassificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentAttachmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "DocumentAttachment")
    public JAXBElement<DocumentAttachmentType> createDocumentAttachment(DocumentAttachmentType value) {
        return new JAXBElement<DocumentAttachmentType>(_DocumentAttachment_QNAME, DocumentAttachmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttachmentsOrderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "AttachmentsOrder")
    public JAXBElement<AttachmentsOrderType> createAttachmentsOrder(AttachmentsOrderType value) {
        return new JAXBElement<AttachmentsOrderType>(_AttachmentsOrder_QNAME, AttachmentsOrderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignmentTaskType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "AssignmentTask")
    public JAXBElement<AssignmentTaskType> createAssignmentTask(AssignmentTaskType value) {
        return new JAXBElement<AssignmentTaskType>(_AssignmentTask_QNAME, AssignmentTaskType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttachmentAttributeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "AttachmentAttribute")
    public JAXBElement<AttachmentAttributeType> createAttachmentAttribute(AttachmentAttributeType value) {
        return new JAXBElement<AttachmentAttributeType>(_AttachmentAttribute_QNAME, AttachmentAttributeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProjectClassificationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "ProjectClassification")
    public JAXBElement<ProjectClassificationType> createProjectClassification(ProjectClassificationType value) {
        return new JAXBElement<ProjectClassificationType>(_ProjectClassification_QNAME, ProjectClassificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentClassificationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "DocumentClassification")
    public JAXBElement<DocumentClassificationType> createDocumentClassification(DocumentClassificationType value) {
        return new JAXBElement<DocumentClassificationType>(_DocumentClassification_QNAME, DocumentClassificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "Document")
    public JAXBElement<DocumentType> createDocument(DocumentType value) {
        return new JAXBElement<DocumentType>(_Document_QNAME, DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentCoreType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "DocumentCore")
    public JAXBElement<DocumentCoreType> createDocumentCore(DocumentCoreType value) {
        return new JAXBElement<DocumentCoreType>(_DocumentCore_QNAME, DocumentCoreType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignmentWorkflowType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/research/fp/model/document/V5", name = "AssignmentWorkflow")
    public JAXBElement<AssignmentWorkflowType> createAssignmentWorkflow(AssignmentWorkflowType value) {
        return new JAXBElement<AssignmentWorkflowType>(_AssignmentWorkflow_QNAME, AssignmentWorkflowType.class, null, value);
    }

}
