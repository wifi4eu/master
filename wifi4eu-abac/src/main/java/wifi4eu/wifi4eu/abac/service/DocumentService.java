package wifi4eu.wifi4eu.abac.service;

import eu.europa.ec.research.fp.services.document_management.v5.DocumentFault;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.DocumentTypeMetadataType;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.DocumentWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.repository.DocumentRepository;
import wifi4eu.wifi4eu.abac.data.repository.DocumentTypeMetadataRepository;
import wifi4eu.wifi4eu.abac.integration.eris.ErisIntegrationService;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisClientException;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisClientParams;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisDocTypeEnum;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisMetadataParam;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisMetadataParamType;
import wifi4eu.wifi4eu.abac.integration.eris.model.ErisServerException;
import wifi4eu.wifi4eu.abac.rest.LegalEntityController;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class DocumentService {

    private final Logger log = LoggerFactory.getLogger(DocumentService.class);

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
    private DocumentTypeMetadataRepository documentTypeMetadataRepository;

	@Autowired LegalEntityService legalEntityService;

    @Autowired
    ErisIntegrationService erisIntegrationService;

	public Document saveDocument(Document document) {
		return documentRepository.save(document);
	}

	public Document getDocumentByPortalId(Long portalId) {
		return documentRepository.findByPortalId(portalId);
	}

	public Document mapDocumentCSVToEntity(LegalEntityDocumentCSVRow documentCSVRow) {
		Document document = new Document();

		document.setPortalId(documentCSVRow.getDocumentPortalId());
		document.setName(documentCSVRow.getDocumentName());
		document.setFileName(documentCSVRow.getDocumentFileName());
		document.setMimetype(documentCSVRow.getDocumentMimeType());
		document.setPortalDate(documentCSVRow.getDocumentDate());
		document.setType(documentCSVRow.getDocumentType());

		LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(documentCSVRow.getMunicipalityPortalId());
		document.setLegalEntity(legalEntity);

		return document;
	}

	public Document addDocumentInAres(Document document) throws DocumentFault {
        ErisClientParams params = setErisClientParams(document);

        try {
            document = erisIntegrationService.addDocument(document, params);
        } catch (ErisClientException e) {
            e.printStackTrace();
        } catch (ErisServerException e) {
            e.printStackTrace();
        }

        return saveDocument(document);
    }

    private ErisClientParams setErisClientParams(Document erisDocument) throws DocumentFault {
        ErisClientParams erisClientParams = new ErisClientParams();

        Long docTypeCCM2Code = 31047688L;

        List<DocumentTypeMetadataType> docTypeMetadataList = documentTypeMetadataRepository.findDocumentTypeMetadataTypeByCcm2DocTypeId(docTypeCCM2Code);

        Map<String, DocumentTypeMetadataType> docTypeMetadataMap = new HashMap<String, DocumentTypeMetadataType>();

        if (!CollectionUtils.isEmpty(docTypeMetadataList)) {
            for (DocumentTypeMetadataType documentTypeMetadataType : docTypeMetadataList) {
                docTypeMetadataMap.put(documentTypeMetadataType.getCcm2MetadataKey(), documentTypeMetadataType);
            }
        }


        erisClientParams.setMetadataParam(ErisMetadataParamType.DOCDATE, buildMetadataParam(docTypeMetadataMap, ErisMetadataParamType.DOCDATE, new Timestamp(System.currentTimeMillis())));
        //erisClientParams.setMetadataParam(ErisMetadataParamType.LE_PIC, buildMetadataParam(docTypeMetadataMap, ErisMetadataParamType.LE_PIC, erisDocument.getPic()));
        //erisClientParams.setMetadataParam(ErisMetadataParamType.LE_NAME, buildMetadataParam(docTypeMetadataMap, ErisMetadataParamType.LE_NAME, erisDocument.getLegalName()));
        //erisClientParams.setMetadataParam(ErisMetadataParamType.SENDER_USER, buildMetadataParam(docTypeMetadataMap, ErisMetadataParamType.SENDER_USER, "alexand"));
        erisClientParams.setMetadataParam(ErisMetadataParamType.COMMENTS, buildMetadataParam(docTypeMetadataMap, ErisMetadataParamType.COMMENTS, ""));
        erisClientParams.setMetadataParam(ErisMetadataParamType.TITLE, buildMetadataParam(docTypeMetadataMap, ErisMetadataParamType.TITLE, FilenameUtils.getBaseName(erisDocument.getFileName())));

        DocumentTypeMetadataType saveNum = docTypeMetadataMap.get(ErisMetadataParamType.SAVENUM.name());
        if((saveNum == null) || (saveNum.getCcm2MetadataId() == null)) {
            log.error("Unable to build ErisMetadataParameter for key: " + ErisMetadataParamType.SAVENUM.name() + ". Missing ccm2Code");
            throw new IllegalArgumentException("Unable to create Eris metadata Parameter. Missing ccm2Code for: " + ErisMetadataParamType.SAVENUM.name());
        } else {
            erisClientParams.setSaveNumCCM2Code(saveNum.getCcm2MetadataId().toString());
        }
        erisClientParams.setMessageAttachment(false);
        erisClientParams.setExternalSender(false);
        addUserCredentials(erisClientParams);

        return erisClientParams;
    }

    private ErisMetadataParam buildMetadataParam(Map<String, DocumentTypeMetadataType> docTypeMetadataList, ErisMetadataParamType key, Serializable value) {
        if((key == null) || (value == null)) {
            log.error("Unable to build ErisMetadataParameter for key: " + key + " and value: " + value);
            throw new IllegalArgumentException("Unable to create Eris metadata Parameter. Missing key or value");
        }
        if(!docTypeMetadataList.containsKey(key.name())) {
            log.error("Unable to build ErisMetadataParameter for key: " + key + ". Missing ccm2Code");
            throw new IllegalArgumentException("Unable to create Eris metadata Parameter. Missing ccm2Code for: " + key);
        }
        DocumentTypeMetadataType documentMetaDataType = docTypeMetadataList.get(key.name());
        String abbreviation = documentMetaDataType.getCcm2MetadataAbbreviation();
        Long ccm2Code = documentMetaDataType.getCcm2MetadataId();
        ErisMetadataParam param = new ErisMetadataParam(ccm2Code.toString(), abbreviation, value);
        return param;
    }

    private ErisMetadataParam buildMetadataParam(ErisMetadataParamType key, Serializable value) {
        if((key == null) || (value == null)) {
            log.error("Unable to build ErisMetadataParameter for key: " + key + " and value: " + value);
            throw new IllegalArgumentException("Unable to create Eris metadata Parameter. Missing key or value");
        }

        DocumentTypeMetadataType documentMetaDataType = documentTypeMetadataRepository.findFirstByCcm2MetadataKey(key.name());

        if(documentMetaDataType == null){
            log.error("Unable to find DocumentTypeMetadataType for key: " + key);
            throw new IllegalArgumentException("Unable to create Eris metadata Parameter. Missing key!");
        }

        String abbreviation = documentMetaDataType.getCcm2MetadataAbbreviation();
        Long ccm2Code = documentMetaDataType.getCcm2MetadataId();
        ErisMetadataParam param = new ErisMetadataParam(ccm2Code.toString(), abbreviation, value);
        return param;
    }

    /**
     * The user first name and last name would be taken from the loggedInUser (set by the execution context) if there's no information
     * about this firstname/lastname it would be taken from the ECAS server using the username. This would be case for requests coming
     * from external resources in which only the username is propagated through the SOAP request.
     */
    private void addUserCredentials(ErisClientParams erisClientParams) throws DocumentFault {
        erisClientParams.setUsername("todo");
        erisClientParams.setFirstName("todo");
        erisClientParams.setLastName("todo");
    }

	public List<Document> getDocumentsByTypeAndStatus(DocumentType grantAgreement, DocumentWorkflowStatus waitingCountersignature) {
    	return documentRepository.findByTypeAndWfStatus(grantAgreement, waitingCountersignature);
	}

	public Document getDocumentsByLegalEntityIdAndType(Long legalEntityId, DocumentType documentType) {
    	return documentRepository.findByLegalEntityIdAndType(legalEntityId, documentType);
	}
}
