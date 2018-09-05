package wifi4eu.wifi4eu.abac.service;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;
import eu.cec.digit.ecas.client.jaas.SubjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.dto.LegalCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.DocumentWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.repository.LegalCommitmentRepository;
import wifi4eu.wifi4eu.abac.integration.essi.EssiService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class LegalCommitmentService {

	private final Logger log = LoggerFactory.getLogger(LegalCommitmentService.class);

	@Autowired
	private LegalCommitmentRepository legalCommitmentRepository;
	
	@Autowired
	private DocumentService documentService;

	@Autowired
	private EssiService essiService;

	@Autowired
	private LegalEntityService legalEntityService;

	@Autowired
	private PropertiesService propertiesService;

	@Autowired
	private UserService userService;

	@Transactional
	public void findAndCounterSignGrantAgreements() {

		List<LegalCommitment> legalCommitments = legalCommitmentRepository.findByWfStatus(LegalCommitmentWorkflowStatus.COUNTERSIGNATURE_REQUESTED);
		try {
			for (LegalCommitment legalCommitment : legalCommitments) {

				Document grantAgreement = legalCommitment.getGrantAgreementDocument();

				byte[] countersignedFile = essiService.signDocument(grantAgreement, userService.getUserByUsername(getCurrentUser().getUid()), userService.getUserByUsername(propertiesService.findPropertyByKey("GA_COUNTERSIGN_OFFICER_UID")));

				Document counterSignedGrantAgreement = new Document();
				counterSignedGrantAgreement.setName("countersigned_"+ grantAgreement.getName());
				counterSignedGrantAgreement.setFileName("countersigned_"+ grantAgreement.getFileName());
				counterSignedGrantAgreement.setMimetype(grantAgreement.getMimetype());
				counterSignedGrantAgreement.setType(DocumentType.COUNTERSIGNED_GRANT_AGREEMENT);
				counterSignedGrantAgreement.setWfStatus(DocumentWorkflowStatus.COUNTERSIGNED);
				counterSignedGrantAgreement.setData(countersignedFile);
				counterSignedGrantAgreement.setLegalEntity(grantAgreement.getLegalEntity());
				documentService.saveDocument(counterSignedGrantAgreement);

				legalCommitment.setGrantAgreementCounterSignatureDate(Calendar.getInstance().getTime());
				legalCommitment.setWfStatus(LegalCommitmentWorkflowStatus.COUNTERSIGNED);
				legalCommitment.setCounterSignedGrantAgreementDocument(counterSignedGrantAgreement);
				saveLegalCommitment(legalCommitment);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} catch (Error ex) {
			log.error(ex.getMessage());
		} catch (Throwable e) {
			log.error(e.getMessage());
		}
	}

	private DetailedUser getCurrentUser() {
		DetailedUser currentEcasUser = null;
		try {
			currentEcasUser = SubjectUtil.getCurrentEcasUser();
		} catch (SubjectNotFoundException e) {
			log.error("ERROR while trying to retrieve the current user", e);
		}
		return currentEcasUser;
	}

	public void createLegalCommitments(String batchRef) {
		List<Document> grantAgreements = documentService.getDocumentsByTypeAndStatus(DocumentType.GRANT_AGREEMENT, DocumentWorkflowStatus.IMPORTED);

		for (Document grantAgreement : grantAgreements) {
			if (grantAgreement.getLegalEntity().getLegalCommitment() == null) {
				createLegalCommitment(grantAgreement, batchRef);
			}
		}
	}

	private void createLegalCommitment(Document grantAgreement, String batchRef) {
		LegalCommitment legalCommitment = new LegalCommitment();
		legalCommitment.setLegalEntity(grantAgreement.getLegalEntity());
		legalCommitment.setGrantAgreementDocument(grantAgreement);
		legalCommitment.setGrantAgreementSignatureDate(grantAgreement.getPortalDate());
		legalCommitment.setWfStatus(LegalCommitmentWorkflowStatus.READY_TO_BE_COUNTERSIGNED);
		legalCommitment.setBatchRef(batchRef);
		legalCommitmentRepository.save(legalCommitment);
	}

	public LegalCommitment getLegalCommitmentByMunicipalityPortalId(Long municipalityPortalId) {
		return legalCommitmentRepository.findByLegalEntityMid(municipalityPortalId);
	}
	
	public LegalCommitment saveLegalCommitment(LegalCommitment legalCommitment) {
		return legalCommitmentRepository.save(legalCommitment);
	}
	
	public LegalCommitment mapLegalCommitmentCSVToEntity(LegalCommitmentCSVRow legalCommitmentCSVRow) {
		
		LegalCommitment legalCommitment = new LegalCommitment();
		
		LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(legalCommitmentCSVRow.getMunicipalityPortalId());
		legalCommitment.setLegalEntity(legalEntity);
		
		return legalCommitment;
	}

	public void requestCountersignature(List<Long> legalEntityIds) {

		for (Long legalEntityId : legalEntityIds) {

			LegalCommitment legalCommitment = legalCommitmentRepository.findByLegalEntityIdAndWfStatus(legalEntityId, LegalCommitmentWorkflowStatus.READY_TO_BE_COUNTERSIGNED);

			if (legalCommitment != null) {
				legalCommitment.setWfStatus(LegalCommitmentWorkflowStatus.COUNTERSIGNATURE_REQUESTED);
				legalCommitment.setGrantAgreementCounterSignatureUser(getCurrentUser().getUid());
				saveLegalCommitment(legalCommitment);
			}
		}

	}

	public List<LegalCommitment> getAllLegalCommitments() {
		return (List<LegalCommitment>) legalCommitmentRepository.findAll();
	}

	public Boolean isBatchProcessed(String batchRef){
		List<LegalCommitmentWorkflowStatus> finishedStatuses = new ArrayList<>();
		finishedStatuses.add(LegalCommitmentWorkflowStatus.ABAC_VALID);
		finishedStatuses.add(LegalCommitmentWorkflowStatus.ABAC_REJECTED);
		finishedStatuses.add(LegalCommitmentWorkflowStatus.ABAC_ERROR);

		Long pending = legalCommitmentRepository.countAllByWfStatusNotInAndBatchRefEquals(finishedStatuses, batchRef);

		return pending.equals(0L);
	}

	public List<LegalCommitment> getAllByBatchRef(String batchRef){
		return legalCommitmentRepository.findAllByBatchRefEquals(batchRef);
	}
}
