
package generated.hrs.ws.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.hrs.ws.model package. 
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

    private final static QName _Header_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "header");
    private final static QName _HrsFault_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "hrsFault");
    private final static QName _SpecificMetadataString5_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "string5");
    private final static QName _SpecificMetadataString6_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "string6");
    private final static QName _SpecificMetadataString7_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "string7");
    private final static QName _SpecificMetadataString1_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "string1");
    private final static QName _SpecificMetadataDouble2_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "double2");
    private final static QName _SpecificMetadataString2_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "string2");
    private final static QName _SpecificMetadataDouble1_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "double1");
    private final static QName _SpecificMetadataString3_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "string3");
    private final static QName _SpecificMetadataString4_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "string4");
    private final static QName _SpecificMetadataDouble3_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "double3");
    private final static QName _SpecificMetadataBoolean1_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "boolean1");
    private final static QName _SpecificMetadataBoolean2_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "boolean2");
    private final static QName _SpecificMetadataBoolean3_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "boolean3");
    private final static QName _SpecificMetadataDate3_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "date3");
    private final static QName _SpecificMetadataDate2_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "date2");
    private final static QName _SpecificMetadataDate1_QNAME = new QName("http://ec.europa.eu/sg/hrs/types", "date1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.hrs.ws.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExternalizationDetails }
     * 
     */
    public ExternalizationDetails createExternalizationDetails() {
        return new ExternalizationDetails();
    }

    /**
     * Create an instance of {@link SignatoryWorkflow }
     * 
     */
    public SignatoryWorkflow createSignatoryWorkflow() {
        return new SignatoryWorkflow();
    }

    /**
     * Create an instance of {@link Heading }
     * 
     */
    public Heading createHeading() {
        return new Heading();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link Document.FiledIn }
     * 
     */
    public Document.FiledIn createDocumentFiledIn() {
        return new Document.FiledIn();
    }

    /**
     * Create an instance of {@link Document.Recipients }
     * 
     */
    public Document.Recipients createDocumentRecipients() {
        return new Document.Recipients();
    }

    /**
     * Create an instance of {@link Document.Senders }
     * 
     */
    public Document.Senders createDocumentSenders() {
        return new Document.Senders();
    }

    /**
     * Create an instance of {@link AssignmentWorkflow }
     * 
     */
    public AssignmentWorkflow createAssignmentWorkflow() {
        return new AssignmentWorkflow();
    }

    /**
     * Create an instance of {@link HrsFault }
     * 
     */
    public HrsFault createHrsFault() {
        return new HrsFault();
    }

    /**
     * Create an instance of {@link UpdateFileRequest }
     * 
     */
    public UpdateFileRequest createUpdateFileRequest() {
        return new UpdateFileRequest();
    }

    /**
     * Create an instance of {@link CreateFileRequest }
     * 
     */
    public CreateFileRequest createCreateFileRequest() {
        return new CreateFileRequest();
    }

    /**
     * Create an instance of {@link generated.hrs.ws.model.File }
     * 
     */
    public generated.hrs.ws.model.File createFile() {
        return new generated.hrs.ws.model.File();
    }

    /**
     * Create an instance of {@link SortOptions }
     * 
     */
    public SortOptions createSortOptions() {
        return new SortOptions();
    }

    /**
     * Create an instance of {@link DeleteFile }
     * 
     */
    public DeleteFile createDeleteFile() {
        return new DeleteFile();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link SearchFilesByExpression }
     * 
     */
    public SearchFilesByExpression createSearchFilesByExpression() {
        return new SearchFilesByExpression();
    }

    /**
     * Create an instance of {@link FilingPlanSearchByExpressionRequest }
     * 
     */
    public FilingPlanSearchByExpressionRequest createFilingPlanSearchByExpressionRequest() {
        return new FilingPlanSearchByExpressionRequest();
    }

    /**
     * Create an instance of {@link FileRetrievalOptions }
     * 
     */
    public FileRetrievalOptions createFileRetrievalOptions() {
        return new FileRetrievalOptions();
    }

    /**
     * Create an instance of {@link UpdateFileStatusAsync }
     * 
     */
    public UpdateFileStatusAsync createUpdateFileStatusAsync() {
        return new UpdateFileStatusAsync();
    }

    /**
     * Create an instance of {@link UpdateFileStatusAsyncRequest }
     * 
     */
    public UpdateFileStatusAsyncRequest createUpdateFileStatusAsyncRequest() {
        return new UpdateFileStatusAsyncRequest();
    }

    /**
     * Create an instance of {@link CreateFileResponse }
     * 
     */
    public CreateFileResponse createCreateFileResponse() {
        return new CreateFileResponse();
    }

    /**
     * Create an instance of {@link GetUpdateFileStatusAsyncResult }
     * 
     */
    public GetUpdateFileStatusAsyncResult createGetUpdateFileStatusAsyncResult() {
        return new GetUpdateFileStatusAsyncResult();
    }

    /**
     * Create an instance of {@link GetUpdateFileStatusAsyncResultRequest }
     * 
     */
    public GetUpdateFileStatusAsyncResultRequest createGetUpdateFileStatusAsyncResultRequest() {
        return new GetUpdateFileStatusAsyncResultRequest();
    }

    /**
     * Create an instance of {@link SearchHeadingsByExpressionResponse }
     * 
     */
    public SearchHeadingsByExpressionResponse createSearchHeadingsByExpressionResponse() {
        return new SearchHeadingsByExpressionResponse();
    }

    /**
     * Create an instance of {@link HeadingSearchResponse }
     * 
     */
    public HeadingSearchResponse createHeadingSearchResponse() {
        return new HeadingSearchResponse();
    }

    /**
     * Create an instance of {@link CreateFile }
     * 
     */
    public CreateFile createCreateFile() {
        return new CreateFile();
    }

    /**
     * Create an instance of {@link SearchFilesByExpressionResponse }
     * 
     */
    public SearchFilesByExpressionResponse createSearchFilesByExpressionResponse() {
        return new SearchFilesByExpressionResponse();
    }

    /**
     * Create an instance of {@link FileSearchResponse }
     * 
     */
    public FileSearchResponse createFileSearchResponse() {
        return new FileSearchResponse();
    }

    /**
     * Create an instance of {@link UpdateFileStatus }
     * 
     */
    public UpdateFileStatus createUpdateFileStatus() {
        return new UpdateFileStatus();
    }

    /**
     * Create an instance of {@link UpdateFileStatusRequest }
     * 
     */
    public UpdateFileStatusRequest createUpdateFileStatusRequest() {
        return new UpdateFileStatusRequest();
    }

    /**
     * Create an instance of {@link GetUserFavoriteFilesResponse }
     * 
     */
    public GetUserFavoriteFilesResponse createGetUserFavoriteFilesResponse() {
        return new GetUserFavoriteFilesResponse();
    }

    /**
     * Create an instance of {@link DeleteFileResponse }
     * 
     */
    public DeleteFileResponse createDeleteFileResponse() {
        return new DeleteFileResponse();
    }

    /**
     * Create an instance of {@link GetUpdateFileStatusAsyncResultResponse }
     * 
     */
    public GetUpdateFileStatusAsyncResultResponse createGetUpdateFileStatusAsyncResultResponse() {
        return new GetUpdateFileStatusAsyncResultResponse();
    }

    /**
     * Create an instance of {@link UpdateFileStatusAsyncResultResponse }
     * 
     */
    public UpdateFileStatusAsyncResultResponse createUpdateFileStatusAsyncResultResponse() {
        return new UpdateFileStatusAsyncResultResponse();
    }

    /**
     * Create an instance of {@link SearchHeadingsByExpression }
     * 
     */
    public SearchHeadingsByExpression createSearchHeadingsByExpression() {
        return new SearchHeadingsByExpression();
    }

    /**
     * Create an instance of {@link HeadingRetrievalOptions }
     * 
     */
    public HeadingRetrievalOptions createHeadingRetrievalOptions() {
        return new HeadingRetrievalOptions();
    }

    /**
     * Create an instance of {@link UpdateFile }
     * 
     */
    public UpdateFile createUpdateFile() {
        return new UpdateFile();
    }

    /**
     * Create an instance of {@link UpdateFileStatusResponse }
     * 
     */
    public UpdateFileStatusResponse createUpdateFileStatusResponse() {
        return new UpdateFileStatusResponse();
    }

    /**
     * Create an instance of {@link UpdateFileStatusAsyncResponse }
     * 
     */
    public UpdateFileStatusAsyncResponse createUpdateFileStatusAsyncResponse() {
        return new UpdateFileStatusAsyncResponse();
    }

    /**
     * Create an instance of {@link UpdateFileResponse }
     * 
     */
    public UpdateFileResponse createUpdateFileResponse() {
        return new UpdateFileResponse();
    }

    /**
     * Create an instance of {@link GetUserFavoriteFiles }
     * 
     */
    public GetUserFavoriteFiles createGetUserFavoriteFiles() {
        return new GetUserFavoriteFiles();
    }

    /**
     * Create an instance of {@link WorkflowUser }
     * 
     */
    public WorkflowUser createWorkflowUser() {
        return new WorkflowUser();
    }

    /**
     * Create an instance of {@link ExternalOrganization }
     * 
     */
    public ExternalOrganization createExternalOrganization() {
        return new ExternalOrganization();
    }

    /**
     * Create an instance of {@link InternalPerson }
     * 
     */
    public InternalPerson createInternalPerson() {
        return new InternalPerson();
    }

    /**
     * Create an instance of {@link Procedure }
     * 
     */
    public Procedure createProcedure() {
        return new Procedure();
    }

    /**
     * Create an instance of {@link SupportingItems }
     * 
     */
    public SupportingItems createSupportingItems() {
        return new SupportingItems();
    }

    /**
     * Create an instance of {@link InternalOrganization }
     * 
     */
    public InternalOrganization createInternalOrganization() {
        return new InternalOrganization();
    }

    /**
     * Create an instance of {@link SpecificMetadata }
     * 
     */
    public SpecificMetadata createSpecificMetadata() {
        return new SpecificMetadata();
    }

    /**
     * Create an instance of {@link FileTransparencyMetadata }
     * 
     */
    public FileTransparencyMetadata createFileTransparencyMetadata() {
        return new FileTransparencyMetadata();
    }

    /**
     * Create an instance of {@link DocumentRetrievalOptions }
     * 
     */
    public DocumentRetrievalOptions createDocumentRetrievalOptions() {
        return new DocumentRetrievalOptions();
    }

    /**
     * Create an instance of {@link AssignmentTask }
     * 
     */
    public AssignmentTask createAssignmentTask() {
        return new AssignmentTask();
    }

    /**
     * Create an instance of {@link Link }
     * 
     */
    public Link createLink() {
        return new Link();
    }

    /**
     * Create an instance of {@link WorkflowManagers }
     * 
     */
    public WorkflowManagers createWorkflowManagers() {
        return new WorkflowManagers();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link FilePhysicalItem }
     * 
     */
    public FilePhysicalItem createFilePhysicalItem() {
        return new FilePhysicalItem();
    }

    /**
     * Create an instance of {@link SignatoryTask }
     * 
     */
    public SignatoryTask createSignatoryTask() {
        return new SignatoryTask();
    }

    /**
     * Create an instance of {@link AccessibilityInfo }
     * 
     */
    public AccessibilityInfo createAccessibilityInfo() {
        return new AccessibilityInfo();
    }

    /**
     * Create an instance of {@link ExternalEntity }
     * 
     */
    public ExternalEntity createExternalEntity() {
        return new ExternalEntity();
    }

    /**
     * Create an instance of {@link AsyncOperationError }
     * 
     */
    public AsyncOperationError createAsyncOperationError() {
        return new AsyncOperationError();
    }

    /**
     * Create an instance of {@link SupportingItem }
     * 
     */
    public SupportingItem createSupportingItem() {
        return new SupportingItem();
    }

    /**
     * Create an instance of {@link ExternalSignature }
     * 
     */
    public ExternalSignature createExternalSignature() {
        return new ExternalSignature();
    }

    /**
     * Create an instance of {@link AssociatedLeadDepartments }
     * 
     */
    public AssociatedLeadDepartments createAssociatedLeadDepartments() {
        return new AssociatedLeadDepartments();
    }

    /**
     * Create an instance of {@link ExternalPerson }
     * 
     */
    public ExternalPerson createExternalPerson() {
        return new ExternalPerson();
    }

    /**
     * Create an instance of {@link FilePreservationMetadata }
     * 
     */
    public FilePreservationMetadata createFilePreservationMetadata() {
        return new FilePreservationMetadata();
    }

    /**
     * Create an instance of {@link SpecificMetadataItem }
     * 
     */
    public SpecificMetadataItem createSpecificMetadataItem() {
        return new SpecificMetadataItem();
    }

    /**
     * Create an instance of {@link InternalEntity }
     * 
     */
    public InternalEntity createInternalEntity() {
        return new InternalEntity();
    }

    /**
     * Create an instance of {@link OperationResponse }
     * 
     */
    public OperationResponse createOperationResponse() {
        return new OperationResponse();
    }

    /**
     * Create an instance of {@link ExternalizationDetails.ExternalizedItems }
     * 
     */
    public ExternalizationDetails.ExternalizedItems createExternalizationDetailsExternalizedItems() {
        return new ExternalizationDetails.ExternalizedItems();
    }

    /**
     * Create an instance of {@link ExternalizationDetails.ExternalizedSpecificMetadataItems }
     * 
     */
    public ExternalizationDetails.ExternalizedSpecificMetadataItems createExternalizationDetailsExternalizedSpecificMetadataItems() {
        return new ExternalizationDetails.ExternalizedSpecificMetadataItems();
    }

    /**
     * Create an instance of {@link SignatoryWorkflow.Tasks }
     * 
     */
    public SignatoryWorkflow.Tasks createSignatoryWorkflowTasks() {
        return new SignatoryWorkflow.Tasks();
    }

    /**
     * Create an instance of {@link Heading.ServiceOwners }
     * 
     */
    public Heading.ServiceOwners createHeadingServiceOwners() {
        return new Heading.ServiceOwners();
    }

    /**
     * Create an instance of {@link Heading.HeadingReaders }
     * 
     */
    public Heading.HeadingReaders createHeadingHeadingReaders() {
        return new Heading.HeadingReaders();
    }

    /**
     * Create an instance of {@link Heading.HeadingEditors }
     * 
     */
    public Heading.HeadingEditors createHeadingHeadingEditors() {
        return new Heading.HeadingEditors();
    }

    /**
     * Create an instance of {@link Heading.FileCreators }
     * 
     */
    public Heading.FileCreators createHeadingFileCreators() {
        return new Heading.FileCreators();
    }

    /**
     * Create an instance of {@link Heading.Categories }
     * 
     */
    public Heading.Categories createHeadingCategories() {
        return new Heading.Categories();
    }

    /**
     * Create an instance of {@link Item.CheckedOut }
     * 
     */
    public Item.CheckedOut createItemCheckedOut() {
        return new Item.CheckedOut();
    }

    /**
     * Create an instance of {@link Item.Translations }
     * 
     */
    public Item.Translations createItemTranslations() {
        return new Item.Translations();
    }

    /**
     * Create an instance of {@link Item.Versions }
     * 
     */
    public Item.Versions createItemVersions() {
        return new Item.Versions();
    }

    /**
     * Create an instance of {@link Document.PersonConcerned }
     * 
     */
    public Document.PersonConcerned createDocumentPersonConcerned() {
        return new Document.PersonConcerned();
    }

    /**
     * Create an instance of {@link Document.Items }
     * 
     */
    public Document.Items createDocumentItems() {
        return new Document.Items();
    }

    /**
     * Create an instance of {@link Document.Links }
     * 
     */
    public Document.Links createDocumentLinks() {
        return new Document.Links();
    }

    /**
     * Create an instance of {@link Document.SignedBy }
     * 
     */
    public Document.SignedBy createDocumentSignedBy() {
        return new Document.SignedBy();
    }

    /**
     * Create an instance of {@link Document.SpecificMetadataItems }
     * 
     */
    public Document.SpecificMetadataItems createDocumentSpecificMetadataItems() {
        return new Document.SpecificMetadataItems();
    }

    /**
     * Create an instance of {@link Document.ExternalSignatures }
     * 
     */
    public Document.ExternalSignatures createDocumentExternalSignatures() {
        return new Document.ExternalSignatures();
    }

    /**
     * Create an instance of {@link Document.FiledIn.File }
     * 
     */
    public Document.FiledIn.File createDocumentFiledInFile() {
        return new Document.FiledIn.File();
    }

    /**
     * Create an instance of {@link Document.Recipients.Recipient }
     * 
     */
    public Document.Recipients.Recipient createDocumentRecipientsRecipient() {
        return new Document.Recipients.Recipient();
    }

    /**
     * Create an instance of {@link Document.Senders.Sender }
     * 
     */
    public Document.Senders.Sender createDocumentSendersSender() {
        return new Document.Senders.Sender();
    }

    /**
     * Create an instance of {@link AssignmentWorkflow.Tasks }
     * 
     */
    public AssignmentWorkflow.Tasks createAssignmentWorkflowTasks() {
        return new AssignmentWorkflow.Tasks();
    }

    /**
     * Create an instance of {@link HrsFault.StackTrace }
     * 
     */
    public HrsFault.StackTrace createHrsFaultStackTrace() {
        return new HrsFault.StackTrace();
    }

    /**
     * Create an instance of {@link UpdateFileRequest.UpdateAssociatedLeadDepartments }
     * 
     */
    public UpdateFileRequest.UpdateAssociatedLeadDepartments createUpdateFileRequestUpdateAssociatedLeadDepartments() {
        return new UpdateFileRequest.UpdateAssociatedLeadDepartments();
    }

    /**
     * Create an instance of {@link UpdateFileRequest.UpdateReaders }
     * 
     */
    public UpdateFileRequest.UpdateReaders createUpdateFileRequestUpdateReaders() {
        return new UpdateFileRequest.UpdateReaders();
    }

    /**
     * Create an instance of {@link UpdateFileRequest.UpdateUsers }
     * 
     */
    public UpdateFileRequest.UpdateUsers createUpdateFileRequestUpdateUsers() {
        return new UpdateFileRequest.UpdateUsers();
    }

    /**
     * Create an instance of {@link UpdateFileRequest.UpdateEditors }
     * 
     */
    public UpdateFileRequest.UpdateEditors createUpdateFileRequestUpdateEditors() {
        return new UpdateFileRequest.UpdateEditors();
    }

    /**
     * Create an instance of {@link UpdateFileRequest.UpdateExceptionForOpeningToThePublic }
     * 
     */
    public UpdateFileRequest.UpdateExceptionForOpeningToThePublic createUpdateFileRequestUpdateExceptionForOpeningToThePublic() {
        return new UpdateFileRequest.UpdateExceptionForOpeningToThePublic();
    }

    /**
     * Create an instance of {@link CreateFileRequest.Readers }
     * 
     */
    public CreateFileRequest.Readers createCreateFileRequestReaders() {
        return new CreateFileRequest.Readers();
    }

    /**
     * Create an instance of {@link CreateFileRequest.Users }
     * 
     */
    public CreateFileRequest.Users createCreateFileRequestUsers() {
        return new CreateFileRequest.Users();
    }

    /**
     * Create an instance of {@link CreateFileRequest.Editors }
     * 
     */
    public CreateFileRequest.Editors createCreateFileRequestEditors() {
        return new CreateFileRequest.Editors();
    }

    /**
     * Create an instance of {@link generated.hrs.ws.model.File.UserFileRoles }
     * 
     */
    public generated.hrs.ws.model.File.UserFileRoles createFileUserFileRoles() {
        return new generated.hrs.ws.model.File.UserFileRoles();
    }

    /**
     * Create an instance of {@link generated.hrs.ws.model.File.Readers }
     * 
     */
    public generated.hrs.ws.model.File.Readers createFileReaders() {
        return new generated.hrs.ws.model.File.Readers();
    }

    /**
     * Create an instance of {@link generated.hrs.ws.model.File.Users }
     * 
     */
    public generated.hrs.ws.model.File.Users createFileUsers() {
        return new generated.hrs.ws.model.File.Users();
    }

    /**
     * Create an instance of {@link generated.hrs.ws.model.File.Editors }
     * 
     */
    public generated.hrs.ws.model.File.Editors createFileEditors() {
        return new generated.hrs.ws.model.File.Editors();
    }

    /**
     * Create an instance of {@link SortOptions.SortBy }
     * 
     */
    public SortOptions.SortBy createSortOptionsSortBy() {
        return new SortOptions.SortBy();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Header }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "header")
    public JAXBElement<Header> createHeader(Header value) {
        return new JAXBElement<Header>(_Header_QNAME, Header.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HrsFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "hrsFault")
    public JAXBElement<HrsFault> createHrsFault(HrsFault value) {
        return new JAXBElement<HrsFault>(_HrsFault_QNAME, HrsFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "string5", scope = SpecificMetadata.class)
    public JAXBElement<String> createSpecificMetadataString5(String value) {
        return new JAXBElement<String>(_SpecificMetadataString5_QNAME, String.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "string6", scope = SpecificMetadata.class)
    public JAXBElement<String> createSpecificMetadataString6(String value) {
        return new JAXBElement<String>(_SpecificMetadataString6_QNAME, String.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "string7", scope = SpecificMetadata.class)
    public JAXBElement<String> createSpecificMetadataString7(String value) {
        return new JAXBElement<String>(_SpecificMetadataString7_QNAME, String.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "string1", scope = SpecificMetadata.class)
    public JAXBElement<String> createSpecificMetadataString1(String value) {
        return new JAXBElement<String>(_SpecificMetadataString1_QNAME, String.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "double2", scope = SpecificMetadata.class)
    public JAXBElement<Double> createSpecificMetadataDouble2(Double value) {
        return new JAXBElement<Double>(_SpecificMetadataDouble2_QNAME, Double.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "string2", scope = SpecificMetadata.class)
    public JAXBElement<String> createSpecificMetadataString2(String value) {
        return new JAXBElement<String>(_SpecificMetadataString2_QNAME, String.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "double1", scope = SpecificMetadata.class)
    public JAXBElement<Double> createSpecificMetadataDouble1(Double value) {
        return new JAXBElement<Double>(_SpecificMetadataDouble1_QNAME, Double.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "string3", scope = SpecificMetadata.class)
    public JAXBElement<String> createSpecificMetadataString3(String value) {
        return new JAXBElement<String>(_SpecificMetadataString3_QNAME, String.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "string4", scope = SpecificMetadata.class)
    public JAXBElement<String> createSpecificMetadataString4(String value) {
        return new JAXBElement<String>(_SpecificMetadataString4_QNAME, String.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "double3", scope = SpecificMetadata.class)
    public JAXBElement<Double> createSpecificMetadataDouble3(Double value) {
        return new JAXBElement<Double>(_SpecificMetadataDouble3_QNAME, Double.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "boolean1", scope = SpecificMetadata.class)
    public JAXBElement<Boolean> createSpecificMetadataBoolean1(Boolean value) {
        return new JAXBElement<Boolean>(_SpecificMetadataBoolean1_QNAME, Boolean.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "boolean2", scope = SpecificMetadata.class)
    public JAXBElement<Boolean> createSpecificMetadataBoolean2(Boolean value) {
        return new JAXBElement<Boolean>(_SpecificMetadataBoolean2_QNAME, Boolean.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "boolean3", scope = SpecificMetadata.class)
    public JAXBElement<Boolean> createSpecificMetadataBoolean3(Boolean value) {
        return new JAXBElement<Boolean>(_SpecificMetadataBoolean3_QNAME, Boolean.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "date3", scope = SpecificMetadata.class)
    public JAXBElement<XMLGregorianCalendar> createSpecificMetadataDate3(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SpecificMetadataDate3_QNAME, XMLGregorianCalendar.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "date2", scope = SpecificMetadata.class)
    public JAXBElement<XMLGregorianCalendar> createSpecificMetadataDate2(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SpecificMetadataDate2_QNAME, XMLGregorianCalendar.class, SpecificMetadata.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ec.europa.eu/sg/hrs/types", name = "date1", scope = SpecificMetadata.class)
    public JAXBElement<XMLGregorianCalendar> createSpecificMetadataDate1(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_SpecificMetadataDate1_QNAME, XMLGregorianCalendar.class, SpecificMetadata.class, value);
    }

}
