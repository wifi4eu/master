package wifi4eu.wifi4eu.abac.integration.hrs;

import com.sun.xml.ws.fault.ServerSOAPFaultException;
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
        String documentName = String.format("Grant n° Inea/Wifi4EU/Call %d identifying %d/%s/%s - %s", legalEntity.getCallNumber(), legalEntity.getMid(), legalEntity.getAbacLatinName(), legalEntity.getCountry().getName(), document.getType().getValue());

        request.setTitle(documentName);
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

        String fileName = String.format("Grant n° Inea/Wifi4EU/Call %d identifying %d/%s/%s", legalEntity.getCallNumber(), legalEntity.getMid(), legalEntity.getAbacLatinName(), legalEntity.getCountry().getName());

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


    public Document registerDocument(Document document) throws Exception {

        if(document.getRegistrationNumber() != null){
            logger.info("A document is already registered for DOC {} RegistrationNumber {}", document.getId(), document.getRegistrationNumber());
            return document;
        }

        LegalEntity legalEntity = document.getLegalEntity();
        String documentName = String.format("Grant n° Inea/Wifi4EU/Call %d identifying %d/%s/%s - %s", legalEntity.getCallNumber(), legalEntity.getMid(), legalEntity.getAbacLatinName(), legalEntity.getCountry().getName(), document.getType().getValue());

        DocumentRegistrationRequest registrationRequest = new DocumentRegistrationRequest();
        registrationRequest.setTitle(documentName);
        registrationRequest.setDocumentDate(getGregorianDate(document.getDateCreated()));
        registrationRequest.setSentDate(getGregorianDate(new Date()));
        registrationRequest.setSecurityClassification(SecurityClassification.NORMAL);
        registrationRequest.setSenders(createIneaSender());


        DocumentRegistrationRequest.Items items = new DocumentRegistrationRequest.Items();
        UploadedItemToAdd uploadedItemToAdd = new UploadedItemToAdd();
        uploadedItemToAdd.setName(document.getFileName());
        uploadedItemToAdd.setContentId(document.getHermesAttachmentId());
        uploadedItemToAdd.setLanguage("EN");
        uploadedItemToAdd.setKind(ItemKindToAdd.MAIN);
        uploadedItemToAdd.setAttachmentType(AttachmentTypeToAdd.NATIVE_ELECTRONIC);
        uploadedItemToAdd.setExternalReference("HRS");
        items.getUploadedItem().add(uploadedItemToAdd);
        registrationRequest.setItems(items);

        RegisterDocument registerDocument = new RegisterDocument();
        registerDocument.setRequest(registrationRequest);

        RegisterDocumentResponse registerDocumentResponse = documentService.registerDocument(registerDocument);

        document.setRegistrationNumber(registerDocumentResponse.getDocument().getRegistrationNumber());
        document.setAresReference(registerDocumentResponse.getDocument().getRegistrationNumber());

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
