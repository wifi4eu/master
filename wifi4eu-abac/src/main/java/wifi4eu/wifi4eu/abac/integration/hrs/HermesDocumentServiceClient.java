package wifi4eu.wifi4eu.abac.integration.hrs;

import generated.hrs.ws.DocumentService;
import generated.hrs.ws.FilingPlanService;
import generated.hrs.ws.model.AttachmentTypeToAdd;
import generated.hrs.ws.model.CreateDocument;
import generated.hrs.ws.model.CreateDocumentResponse;
import generated.hrs.ws.model.CreateFile;
import generated.hrs.ws.model.CreateFileRequest;
import generated.hrs.ws.model.CreateFileResponse;
import generated.hrs.ws.model.CurrentEntityToAdd;
import generated.hrs.ws.model.DocumentCreationRequest;
import generated.hrs.ws.model.DocumentRegistrationRequest;
import generated.hrs.ws.model.FileDocument;
import generated.hrs.ws.model.FileDocumentResponse;
import generated.hrs.ws.model.ItemKindToAdd;
import generated.hrs.ws.model.RegisterDocument;
import generated.hrs.ws.model.RegisterDocumentResponse;
import generated.hrs.ws.model.SecurityClassification;
import generated.hrs.ws.model.SendersToAdd;
import generated.hrs.ws.model.UploadedItemToAdd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wifi4eu.wifi4eu.abac.data.entity.Document;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HermesDocumentServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(HermesDocumentServiceClient.class);

    private DocumentService documentService;

    private FilingPlanService filingService;

    private HrsHTTpClient HrsHTTpClient;

    public HermesDocumentServiceClient(DocumentService documentServicePort, FilingPlanService filingServicePort, HrsHTTpClient hrsHTTpClient) {
        this.documentService = documentServicePort;
        this.filingService = filingServicePort;
        this.HrsHTTpClient = hrsHTTpClient;
    }

    public Document saveDocumentInAres(Document document) throws Exception{
        createDocument(document);
        createFile(document);
        uploadAttachment(document);
        fileDocument(document);
        registerDocument(document);

        return document;
    }

    protected Document uploadAttachment(Document document)throws Exception {
        String hrsAttachmentRef = HrsHTTpClient.uploadAttachment(document);
        document.setHermesAttachmentId(hrsAttachmentRef);

        return document;
    }

    protected Document createDocument(Document document) throws Exception {

        DocumentCreationRequest request = new DocumentCreationRequest();
        request.setTitle(document.getName());
        request.setDocumentDate(getGregorianDate(document.getDateCreated()));
        request.setSecurityClassification(SecurityClassification.NORMAL);
        request.setSenders(createIneaSender());

        CreateDocument createDocument = new CreateDocument();
        createDocument.setRequest(request);

        CreateDocumentResponse createDocumentResponse = documentService.createDocument(createDocument);

        String documentId = createDocumentResponse.getResult().getDocumentId();
        String saveNumber = createDocumentResponse.getResult().getSaveNumber();

        document.setHermesDocumentId(documentId);
        document.setHermesSaveNumber(saveNumber);

        return document;
    }

    protected boolean fileDocument(Document document) throws Exception {
        FileDocument fileDocument = new FileDocument();
        fileDocument.setDocumentId(document.getHermesDocumentId());
        fileDocument.setFileId(document.getHermesFileId());

        FileDocumentResponse fileDocumentResponse = documentService.fileDocument(fileDocument);

        return fileDocumentResponse.getResult().isSuccess();
    }

    protected Document createFile(Document document) throws Exception {

        CreateFileRequest createFileRequest = new CreateFileRequest();
        createFileRequest.setHeadingId("0b0166e4850ba916");
        createFileRequest.setEnglishName(document.getName());
        createFileRequest.setChefDeFile("inea.c.c05");

        CreateFileRequest.Readers readers = new CreateFileRequest.Readers();
        readers.getReader().add("inea");
        readers.getReader().add("cnect");
        createFileRequest.setReaders(readers);

        CreateFileRequest.Users users = new CreateFileRequest.Users();
        users.getUser().add("je_eris");
        users.getUser().add("inea.c.c05");
        users.getUser().add("inea.r.r01");
        users.getUser().add("inea.r.r03");
        //users.getUser().add("inea.r.r04.43");
        createFileRequest.setUsers(users);


        CreateFileRequest.Editors editors = new CreateFileRequest.Editors();
        editors.getEditor().add("nc_inea_fc");
        editors.getEditor().add("je_wifieuinea");

        createFileRequest.setEditors(editors);

        createFileRequest.setActivate(true);
        createFileRequest.setCategoryKey("080166e4806c3e10");

        CreateFile createFile = new CreateFile();
        createFile.setRequest(createFileRequest);

        CreateFileResponse createFileResponse = filingService.createFile(createFile);

        document.setHermesFileId(createFileResponse.getFile().getFileId());

        return document;
    }

    protected Document registerDocument(Document document) throws Exception {


        DocumentRegistrationRequest registrationRequest = new DocumentRegistrationRequest();
        registrationRequest.setTitle(document.getName());
        registrationRequest.setDocumentDate(getGregorianDate(document.getPortalDate()));
        registrationRequest.setSentDate(getGregorianDate(new Date()));
        registrationRequest.setSecurityClassification(SecurityClassification.NORMAL);
        registrationRequest.setSenders(createIneaSender());


        DocumentRegistrationRequest.Items items = new DocumentRegistrationRequest.Items();
        UploadedItemToAdd uploadedItemToAdd = new UploadedItemToAdd();
        uploadedItemToAdd.setName(document.getFileName());
        uploadedItemToAdd.setContentId(document.getHermesAttachmentId());
        uploadedItemToAdd.setKind(ItemKindToAdd.MAIN);
        uploadedItemToAdd.setAttachmentType(AttachmentTypeToAdd.NATIVE_ELECTRONIC);
        uploadedItemToAdd.setExternalReference("HRS");
        items.getUploadedItem().add(uploadedItemToAdd);
        registrationRequest.setItems(items);

        RegisterDocument registerDocument = new RegisterDocument();
        registerDocument.setRequest(registrationRequest);

        RegisterDocumentResponse registerDocumentResponse = documentService.registerDocument(registerDocument);

        if(registerDocumentResponse.getDocument().getFilingResult().isSuccess()){
            document.setRegistrationNumber(registerDocumentResponse.getDocument().getRegistrationNumber());
        }

        return document;
    }

    private SendersToAdd createIneaSender() {
        SendersToAdd senders = new SendersToAdd();
        CurrentEntityToAdd sender = new CurrentEntityToAdd();
        sender.setCurrentInternalEntitySearchExpression("isOrganisation=true AND organisationName='inea'");
        senders.getSender().add(sender);
        return senders;
    }

    private XMLGregorianCalendar getGregorianDate(Date date)throws Exception {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar gregorianDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

        return gregorianDate;
    }
}
