package wifi4eu.wifi4eu.abac.integration.hrs;

import com.sun.xml.ws.fault.ServerSOAPFaultException;
import generated.hrs.ws.DocumentService;
import generated.hrs.ws.FilingPlanService;
import generated.hrs.ws.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;

import javax.transaction.Transactional;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class HermesDocumentServiceClient {

    private static final String FILE_NAME_PATTERN = "Grant n° %s/Wifi4EU/Call %d identifying %d/%s/%s";
    private static final String DOCUMENT_NAME_PATTERN = "Grant n° Inea/Wifi4EU/Call %d identifying %d/%s/%s - %s";

    private static final Logger logger = LoggerFactory.getLogger(HermesDocumentServiceClient.class);

    private DocumentService documentService;

    private FilingPlanService filingService;

    private HrsHTTpClient HrsHTTpClient;

    @Value("${integration.hrs.service.file.headingId}")
    private String headingId;

    @Value("${integration.hrs.service.file.chefDeFile}")
    private String chefDeFile;

    @Value("${integration.hrs.service.file.readers}")
    private String readers;

    @Value("${integration.hrs.service.file.users}")
    private String users;

    @Value("${integration.hrs.service.file.editors}")
    private String editors;

    @Value("${integration.hrs.service.file.categoryKey}")
    private String categoryKey;


    public HermesDocumentServiceClient(DocumentService documentServicePort, FilingPlanService filingServicePort, HrsHTTpClient hrsHTTpClient) {
        this.documentService = documentServicePort;
        this.filingService = filingServicePort;
        this.HrsHTTpClient = hrsHTTpClient;
    }



    public Document uploadAttachment(Document document)throws Exception {
        String hrsAttachmentRef = HrsHTTpClient.uploadAttachment(document);
        document.setHermesAttachmentId(hrsAttachmentRef);

        return document;
    }


    public Document createDocument(Document document) throws Exception {

        if(document.getHermesDocumentId() != null){
            logger.info("A document is already created for DOC {} HermesDocumentId {}", document.getId(), document.getHermesDocumentId());
            return document;
        }

        DocumentCreationRequest request = new DocumentCreationRequest();

        LegalEntity legalEntity = document.getLegalEntity();
        String documentName = String.format(DOCUMENT_NAME_PATTERN, legalEntity.getCallNumber(), legalEntity.getMid(), legalEntity.getAbacLatinName(), legalEntity.getCountry().getName(), document.getType().getValue());

        request.setTitle(documentName);
        request.setDocumentDate(getGregorianDate(document.getDateCreated()));
        request.setSecurityClassification(SecurityClassification.NORMAL);
        request.setSenders(createIneaSender());

        ItemsToAdd items = new ItemsToAdd();
        UploadedItemToAdd uploadedItemToAdd = new UploadedItemToAdd();
        uploadedItemToAdd.setName(document.getFileName());
        uploadedItemToAdd.setContentId(document.getHermesAttachmentId());
        uploadedItemToAdd.setLanguage("EN");
        uploadedItemToAdd.setKind(ItemKindToAdd.MAIN);
        uploadedItemToAdd.setAttachmentType(AttachmentTypeToAdd.NATIVE_ELECTRONIC);
        uploadedItemToAdd.setExternalReference("HRS");
        items.getScannedItemOrUploadedItem().add(uploadedItemToAdd);

        request.setItems(items);

        CreateDocument createDocument = new CreateDocument();
        createDocument.setRequest(request);

        CreateDocumentResponse createDocumentResponse = documentService.createDocument(createDocument);

        String documentId = createDocumentResponse.getResult().getDocumentId();
        String saveNumber = createDocumentResponse.getResult().getSaveNumber();

        document.setHermesDocumentId(documentId);
        document.setHermesSaveNumber(saveNumber);

        return document;
    }


    public boolean fileDocument(Document document) throws Exception {
        FileDocument fileDocument = new FileDocument();
        fileDocument.setDocumentId(document.getHermesDocumentId());
        fileDocument.setFileId(document.getHermesFileId());

        try {
            FileDocumentResponse fileDocumentResponse = documentService.fileDocument(fileDocument);
        }catch (ServerSOAPFaultException e){
            logger.error("ERROR filing document {}", document.getId(), e);
            return false;
        }

        return true;
    }


    public Document createFile(Document document) throws Exception {

        CreateFileRequest createFileRequest = new CreateFileRequest();
        createFileRequest.setHeadingId(headingId);

        LegalEntity legalEntity = document.getLegalEntity();

        if(legalEntity.getHermesFileId() != null){
            logger.info("A file is already created for MID {} HermesFileId {}", legalEntity.getMid(), legalEntity.getHermesFileId());
            document.setHermesFileId(legalEntity.getHermesFileId());
            return document;
        }

        String fileName = String.format(
                FILE_NAME_PATTERN,
                legalEntity.getRegistrationNumber(),
                legalEntity.getCallNumber(),
                legalEntity.getMid(),
                legalEntity.getAbacLatinName(),
                legalEntity.getCountry().getName());

        createFileRequest.setEnglishName(fileName);
        createFileRequest.setChefDeFile(chefDeFile);

        CreateFileRequest.Readers readers = new CreateFileRequest.Readers();
        readers.getReader().addAll(Arrays.asList(this.readers.split(",")));
        createFileRequest.setReaders(readers);

        CreateFileRequest.Users users = new CreateFileRequest.Users();
        users.getUser().addAll(Arrays.asList(this.users.split(",")));
        createFileRequest.setUsers(users);


        CreateFileRequest.Editors editors = new CreateFileRequest.Editors();
        editors.getEditor().addAll(Arrays.asList(this.editors.split(",")));
        createFileRequest.setEditors(editors);

        createFileRequest.setActivate(true);
        createFileRequest.setCategoryKey(this.categoryKey);

        CreateFile createFile = new CreateFile();
        createFile.setRequest(createFileRequest);

        CreateFileResponse createFileResponse = filingService.createFile(createFile);

        document.setHermesFileId(createFileResponse.getFile().getFileId());
        legalEntity.setHermesFileId(createFileResponse.getFile().getFileId());


        return document;
    }

    public Document registerDocumentById(Document document) throws Exception {

        if(document.getRegistrationNumber() != null){
            logger.info("A document is already registered for DOC {} RegistrationNumber {}", document.getId(), document.getRegistrationNumber());
            return document;
        }

        RegisterDocumentById registerDocumentById = new RegisterDocumentById();
        registerDocumentById.setDocumentId(document.getHermesDocumentId());
        registerDocumentById.setFileId(document.getHermesFileId());

        RegisterDocumentByIdResponse registerDocumentByIdResponse = documentService.registerDocumentById(registerDocumentById);

        document.setRegistrationNumber(registerDocumentByIdResponse.getResult().getRegistrationNumber());
        document.setAresReference(registerDocumentByIdResponse.getResult().getRegistrationNumber());

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
