package wifi4eu.wifi4eu.abac.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.repository.BudgetaryCommitmentPositionRepository;
import wifi4eu.wifi4eu.abac.data.repository.BudgetaryCommitmentRepository;
import wifi4eu.wifi4eu.abac.utils.csvparser.BudgetaryCommitmentCSVFileParser;

@Service
public class BudgetaryCommitmentService {

	private final Logger log = LoggerFactory.getLogger(BudgetaryCommitmentService.class);

	@Autowired
	private BudgetaryCommitmentRepository budgetaryCommitmentyRepository;

	@Autowired
	private BudgetaryCommitmentPositionRepository budgetaryCommitmentyPositionRepository;

	@Autowired
	private BudgetaryCommitmentCSVFileParser budgetaryCommitmentCSVFileParser;

	@Autowired
	private LegalEntityService legalEntityService;

	public String exportBudgetaryCommitments() {
		log.info("exportBudgetaryCommitmentyContent");
		List<BudgetaryCommitmentPosition> budgetaryCommitments = (List<BudgetaryCommitmentPosition>) budgetaryCommitmentyPositionRepository.findAll();
		String csvFile = budgetaryCommitmentCSVFileParser.exportBudgetaryCommitmentToCSV(budgetaryCommitments);
		return csvFile;
	}

	public BudgetaryCommitment save(BudgetaryCommitment budgetaryCommitment) {
		return budgetaryCommitmentyRepository.save(budgetaryCommitment);
	}

	public BudgetaryCommitmentPosition mapBudgetaryCommitmentCSVToEntity(BudgetaryCommitmentCSVRow budgetaryCommitmentCSVRow) {

		BudgetaryCommitmentPosition position = new BudgetaryCommitmentPosition();

		position.setGlobalCommitmentLevel1PositionKey(budgetaryCommitmentCSVRow.getAbacGlobalCommitmentLevel1PositionKey());
		position.setCommitmentLevel2Position(budgetaryCommitmentCSVRow.getAbacCommitmentLevel2Position());
		position.setCommitmentLevel2Amount(budgetaryCommitmentCSVRow.getAbacGlobalCommitmentPositionAmmount());

		BudgetaryCommitment budgetaryCommitment = new BudgetaryCommitment();

		LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(budgetaryCommitmentCSVRow.getMunicipalityPortalId());
		budgetaryCommitment.setLegalEntity(legalEntity);

		position.setBudgetaryCommitment(budgetaryCommitment);

		return position;
	}

	public BudgetaryCommitmentPosition getBCPosition(Long municipalityPortalId, Integer abacCommitmentLevel2Position) {
		return budgetaryCommitmentyPositionRepository.findByBudgetaryCommitmentLegalEntityMidAndCommitmentLevel2Position(municipalityPortalId, abacCommitmentLevel2Position);
	}

	public BudgetaryCommitmentPosition saveBCPosition(BudgetaryCommitmentPosition budgetaryCommitmentPosition) {
		return budgetaryCommitmentyPositionRepository.save(budgetaryCommitmentPosition);
	}

	public BudgetaryCommitment getByMunicipalityPortalId(Long municipalityPortalId) {
		return budgetaryCommitmentyRepository.findByLegalEntityMid(municipalityPortalId);
	}

	public Boolean isBatchProcessed(String batchRef){
		List<AbacWorkflowStatus> finishedStatuses = new ArrayList<>();
		finishedStatuses.add(AbacWorkflowStatus.ABAC_VALID);
		finishedStatuses.add(AbacWorkflowStatus.ABAC_REJECTED);
		finishedStatuses.add(AbacWorkflowStatus.ABAC_ERROR);
		finishedStatuses.add(AbacWorkflowStatus.ABAC_FINISH);

		Long pending = budgetaryCommitmentyRepository.countAllByWfStatusNotInAndBatchRefEquals(finishedStatuses, batchRef);

		return pending.equals(0L);
	}

	public List<BudgetaryCommitment> getAllByBatchRef(String batchRef){
		return budgetaryCommitmentyRepository.findAllByBatchRefEquals(batchRef);
	}
}
