package wifi4eu.wifi4eu.abac.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.repository.BudgetaryCommitmentRepository;
import wifi4eu.wifi4eu.abac.utils.csvparser.BudgetaryCommitmentCSVFileParser;

@Service
public class BudgetaryCommitmentService {

	private final Logger log = LoggerFactory.getLogger(BudgetaryCommitmentService.class);

	@Autowired
	private BudgetaryCommitmentRepository budgetaryCommitmentyRepository;

	@Autowired
	private BudgetaryCommitmentCSVFileParser budgetaryCommitmentCSVFileParser;

	@Autowired
	private LegalEntityService legalEntityService;

	public String exportBudgetaryCommitments() {
		log.info("exportBudgetaryCommitmentyContent");
		List<BudgetaryCommitment> budgetaryCommitments = (List<BudgetaryCommitment>) budgetaryCommitmentyRepository.findAll();
		String csvFile = budgetaryCommitmentCSVFileParser.exportBudgetaryCommitmentToCSV(budgetaryCommitments);
		return csvFile;
	}

	public BudgetaryCommitment save(BudgetaryCommitment budgetaryCommitment) {
		return budgetaryCommitmentyRepository.save(budgetaryCommitment);
	}

	public BudgetaryCommitment mapBudgetaryCommitmentCSVToEntity(BudgetaryCommitmentCSVRow budgetaryCommitmentCSVRow) {

		BudgetaryCommitment budgetaryCommitment = new BudgetaryCommitment();

		budgetaryCommitment.setGlobalCommitmentLevel1PositionKey(budgetaryCommitmentCSVRow.getAbacGlobalCommitmentLevel1PositionKey());
		budgetaryCommitment.setCommitmentLevel2Position(budgetaryCommitmentCSVRow.getAbacCommitmentLevel2Position());
		budgetaryCommitment.setCommitmentLevel2Amount(budgetaryCommitmentCSVRow.getAbacGlobalCommitmentPositionAmmount());

		LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(budgetaryCommitmentCSVRow.getMunicipalityPortalId());
		budgetaryCommitment.setLegalEntity(legalEntity);

		return budgetaryCommitment;
	}
}
