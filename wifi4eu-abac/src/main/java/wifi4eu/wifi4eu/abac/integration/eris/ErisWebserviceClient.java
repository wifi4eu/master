package wifi4eu.wifi4eu.abac.integration.eris;

import eu.europa.ec.research.fp.model.code_ref.v3.CodeRefType;
import eu.europa.ec.research.fp.model.document.v5.LinkTypeType;
import eu.europa.ec.research.fp.model.document.v5.SendersRecipients;
import eu.europa.ec.research.fp.model.document_ref.v3.DocumentRefType;
import eu.europa.ec.research.fp.model.header.v1.HeaderType;
import eu.europa.ec.research.fp.model.service_fault.v1.BusinessFaultInfoType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.BooleanMessageWrapperType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.CreateDocumentResponseWrapperType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.CreateFileResponseWrapperType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.CreateVirtualAttachmentsResponseWrapperType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.DocumentMetaDataListType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.FileDocumentType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.GetDocumentResponseWrapperType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.RegisterDocumentResponseWrapperType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.ServiceDocumentRefType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.VirtualAttachmentRefListType;
import eu.europa.ec.research.fp.services.document_management.v5.DocumentFault;
import eu.europa.ec.research.fp.services.document_management.v5.IDocumentManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wifi4eu.wifi4eu.abac.integration.eris.model.CreateAutomaticFileParams;

public class ErisWebserviceClient {

    private IDocumentManagementService port;

    private static final Logger logger = LoggerFactory.getLogger(ErisWebserviceClient.class);

    public ErisWebserviceClient(IDocumentManagementService port) {
        this.port = port;
    }

    public CreateFileResponseWrapperType createFile(HeaderType header, CreateAutomaticFileParams createFileParams) throws DocumentFault{
        try {
            return port.automaticFileCreation(header, createFileParams.getFilePlan(), createFileParams.getFileType(), createFileParams.getFileTitle(), createFileParams.getSpecificCode(), createFileParams.getChefDeFile());
        } catch (DocumentFault e) {
            handleException(e);
        }
        return null;
    }

    public CreateDocumentResponseWrapperType createDocument(HeaderType header, CodeRefType documentType, DocumentMetaDataListType metadata, SendersRecipients sendersRecipients)
            throws DocumentFault{
        try {
            return port.createDocument(header, documentType, metadata, sendersRecipients);
        } catch (DocumentFault e) {
            handleException(e);
        }
        return null;
    }

    public BooleanMessageWrapperType updateDocument(HeaderType header, String masterID, CodeRefType documentType, DocumentMetaDataListType metadata, SendersRecipients sendersRecipientsToAdd,
                                                    SendersRecipients sendersRecipientsToDelete) throws DocumentFault{
        try {
            return port.updateDocument(header, masterID, documentType, metadata, sendersRecipientsToAdd, sendersRecipientsToDelete);
        } catch (DocumentFault e) {
            handleException(e);
        }
        return null;
    }


    public BooleanMessageWrapperType fileDocument(HeaderType header, FileDocumentType documentRef) throws DocumentFault{
        try {
            return port.fileDocument(header, documentRef);
        } catch (DocumentFault e) {
            handleException(e);
        }
        return null;
    }

    public BooleanMessageWrapperType externalizeDocument(HeaderType header, ServiceDocumentRefType serviceDocumentRef, Integer partitionId) throws DocumentFault {
        try {
            return port.externalizeDocument(header, serviceDocumentRef, partitionId);
        } catch (DocumentFault e) {
            handleException(e);
        }
        return null;
    }

    public RegisterDocumentResponseWrapperType registerDocumentById(HeaderType header, DocumentRefType documentId) throws DocumentFault {
        try {
            return port.registerDocumentById(header, documentId);
        } catch (DocumentFault e) {
            handleException(e);
        }
        return null;
    }

    public CreateVirtualAttachmentsResponseWrapperType createVirtualAttachment(HeaderType header, DocumentRefType documentId, VirtualAttachmentRefListType virtualAttachmentRefs)
            throws DocumentFault {
        try {
            return port.createVirtualAttachments(header, documentId, virtualAttachmentRefs);
        } catch (DocumentFault e) {
            handleException(e);
        }
        return null;
    }

    public BooleanMessageWrapperType linkDocuments(HeaderType header, ServiceDocumentRefType sourceDocumentRef, ServiceDocumentRefType targetDocumentRef,
                                                   LinkTypeType linkType) throws DocumentFault {
        try {
            return port.linkDocuments(header, sourceDocumentRef, targetDocumentRef, linkType);
        } catch (DocumentFault e) {
            handleException(e);
        }
        return null;
    }

    public GetDocumentResponseWrapperType getDocument(HeaderType header, ServiceDocumentRefType documentRef, Boolean returnAttachmentAttributes) throws DocumentFault {

        try{
            return port.getDocument(header, documentRef, returnAttachmentAttributes);
        }catch(DocumentFault e) {
            handleException(e);
        }

        return null;
    }


    private void handleException(DocumentFault e) throws DocumentFault {
        BusinessFaultInfoType businessFaultInfoType = new BusinessFaultInfoType();
        businessFaultInfoType.setCode(e.getFaultInfo().getCode());
        businessFaultInfoType.setDescription(e.getFaultInfo().getDescription());
        throw new DocumentFault(e.getMessage(), businessFaultInfoType);
    }

}
