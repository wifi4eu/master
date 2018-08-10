package wifi4eu.wifi4eu.abac.integration.eris;

import eu.europa.ec.rdg.eris.document.v5.DocumentComponent;
import eu.europa.ec.rdg.eris.document.v5.IErisHttpClient;
import eu.europa.ec.research.fp.model.code_ref.v3.CodeRefType;
import eu.europa.ec.research.fp.model.header.v1.HeaderType;
import eu.europa.ec.research.fp.model.service_fault.v1.BusinessFaultInfoType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.CreateDocumentResponseWrapperType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.CreateFileResponseWrapperType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.DocumentMetaDataListType;
import eu.europa.ec.research.fp.services.document_management.interfaces.v5.UploadDocAttachmentType;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisClientException;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisClientParams;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisDocTypeEnum;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisServerException;
import wifi4eu.wifi4eu.abac.utils.ErisHelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLConnection;

@Service
public class ErisIntegrationService {

    private static final Logger logger = LoggerFactory.getLogger(ErisIntegrationService.class);

    private static final ErisDocTypeEnum[] CREATE_METADATA = {ErisDocTypeEnum.IDENTIFICATION_FORM};

    @Autowired
    private ErisHelper erisHelper;

    @Autowired
    private ErisWebserviceClient erisWebserviceClient;


    public String createFile(String mid) throws ErisClientException, ErisServerException {
        logger.debug("createFile was called");
        CreateFileResponseWrapperType responseWrapper = null;
        try {
            responseWrapper = erisWebserviceClient.createFile(new HeaderType(), erisHelper.buildCreateFileParams(mid));
        } catch (eu.europa.ec.research.fp.services.document_management.v5.DocumentFault e) {

            logger.error("Unable to createFile for MID: " + mid, e);
            throw new ErisClientException(e.getFaultInfo());
        } catch (RuntimeException e) {
            logger.error("Unable to createFile for MID: " + mid, e);
            throw new ErisServerException(e);
        }
        return responseWrapper.getFile().getFileId();
    }


    public Document addDocument(Document erisDocument, ErisClientParams params) throws ErisClientException, ErisServerException  {
        createDocument(erisDocument, params);
        uploadAttachment(erisDocument, params);
        try {
            fileDocument(erisDocument);
        } catch (ErisServerException e) {
            logger.error("Unable to file the document. ErisServerException with message: " + e.getMessage(), e);
        }

        return erisDocument;
    }

    /**
     * Creates a document in Hermes and externalises it if necessary
     * @throws ErisServerException
     * @throws ErisClientException
     */
    private void createDocument(Document erisDocument, ErisClientParams params) throws ErisClientException, ErisServerException {
        DocumentMetaDataListType metadata = erisHelper.buildMetadata(params, CREATE_METADATA);

        CodeRefType documentType = new CodeRefType();
        documentType.setId(erisDocument.getDocTypeCCM2Id());

        CreateDocumentResponseWrapperType response = null;
        try {
            response = erisWebserviceClient.createDocument(new HeaderType(), documentType, metadata, erisHelper.getSendersAndRecipients(erisDocument, params));
        } catch (eu.europa.ec.research.fp.services.document_management.v5.DocumentFault e) {
            logger.error("Unable to registerDocumentById for HermesREF: " + erisDocument.getHermesRef(), e);
            throw new ErisClientException(e.getFaultInfo());
        } catch (RuntimeException e) {
            logger.error("Unable to registerDocumentById for HermesREF: " + erisDocument.getHermesRef(), e);
            throw new ErisServerException(e);
        }
        String hermesRef = response.getDocument().getMasterID();
        erisDocument.setHermesRef(hermesRef);
        if (StringUtils.isEmpty(hermesRef)) {
            String errorMsg = "Couldn't find Hermes Reference Id for document: " + erisDocument.getFileName() + " and for DOCUMENT_MID: " + erisDocument.getLegalEntity().getMid() + ". Upload failed!";
            BusinessFaultInfoType faultInfo = new BusinessFaultInfoType();
            faultInfo.setDescription(errorMsg);
            throw new ErisServerException(faultInfo);
        }

        Serializable property = erisHelper.getMetadataProperty(params.getSaveNumCCM2Code(), response.getDocument());
        if(property != null) {
            erisDocument.setSaveNumber(property.toString());
        }
    }

    /**
     * Calls the {@link ErisHTTPClient} to upload the Binary content of the document
     * @throws ErisClientException, ErisServerException
     */
    private void uploadAttachment(Document erisDocument, ErisClientParams params) throws ErisClientException, ErisServerException {
        String attachmentContentType = erisDocument.getMimetype();
        if (StringUtils.isEmpty(attachmentContentType)) {
            try {
                attachmentContentType =  URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(erisDocument.getData()));
            } catch (IOException e) {
                String errorMsg = "Couldn't find content type for document: " + erisDocument.getFileName() + " and for DOCUMENT_MID: " + erisDocument.getLegalEntity().getMid() + ". Upload failed!";
                BusinessFaultInfoType faultInfo = new BusinessFaultInfoType();
                faultInfo.setDescription(errorMsg);
                throw new ErisServerException(faultInfo);
            }
        }
        try {
            UploadDocAttachmentType attachment = erisHelper.buildUploadDocAttachment(erisDocument, params);
            IErisHttpClient erisHTTPClient = new DocumentComponent().getHttpClient(erisHelper.getEndpoint(), erisHelper.getUsername(), erisHelper.getPassword(), erisHelper.isEcasAuthEnabled());
            String attachmentId = erisHTTPClient.uploadAttachment(attachment, new ByteArrayInputStream(erisDocument.getData()), attachmentContentType, FilenameUtils.getExtension(erisDocument.getFileName()));
            erisDocument.setHermesAttachmentId(attachmentId);
        } catch (eu.europa.ec.rdg.eris.document.common.ErisClientException e) {
            logger.error("Unable to uploadAttachment for HermesREF: " + erisDocument.getHermesRef(), e);
            throw e;
        }
    }


    public void fileDocument(Document erisDocument) throws ErisServerException {
        try {
            erisWebserviceClient.fileDocument(new HeaderType(), erisHelper.buildFileDocument(erisDocument));
        } catch (eu.europa.ec.research.fp.services.document_management.v5.DocumentFault e) {
            logger.error("File Document operation failed for HermesREF: " + erisDocument.getHermesRef(), e);
            throw new ErisServerException(e);
        }  catch (RuntimeException e) {
            logger.error("Unable to fileDocument for HermesREF: " + erisDocument.getHermesRef(), e);
            throw new ErisServerException(e);
        }
    }
}
