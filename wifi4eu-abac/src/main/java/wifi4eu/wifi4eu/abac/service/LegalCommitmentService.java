package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.DocumentWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.repository.LegalCommitmentRepository;
import wifi4eu.wifi4eu.abac.integration.essi.EssiService;

import java.util.List;

@Service
public class LegalCommitmentService {

	private final Logger log = LoggerFactory.getLogger(LegalCommitmentService.class);

	@Autowired
	private LegalCommitmentRepository legalCommitmentyRepository;

	@Autowired
	private DocumentService documentService;

	@Autowired
	private EssiService essiService;

	public void findAndCounterSignGrantAgreements() {

		List<Document> grantAgreements = documentService.getDocumentsByTypeAndStatus(DocumentType.GRANT_AGREEMENT, DocumentWorkflowStatus.WAITING_COUNTERSIGNATURE);

		try {
			for (Document grantAgreement : grantAgreements) {
				byte[] countersignedFile = essiService.signDocument(grantAgreement);

				grantAgreement.setWfStatus(DocumentWorkflowStatus.COUNTERSIGNED);
				grantAgreement.setCountersignedData(countersignedFile);

				documentService.saveDocument(grantAgreement);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} catch (Error ex) {
			log.error(ex.getMessage());
		} catch (Throwable e) {
			log.error(e.getMessage());
		}
	}

}
