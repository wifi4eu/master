package wifi4eu.wifi4eu.abac.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.repository.BudgetaryCommitmentRepository;

@Service
public class BudgetaryCommitmentService {

	private final Logger log = LoggerFactory.getLogger(BudgetaryCommitmentService.class);

	private BudgetaryCommitmentRepository budgetaryCommitmentyRepository;

	@Autowired
	public BudgetaryCommitmentService(BudgetaryCommitmentRepository budgetaryCommitmentyRepository) {
		this.budgetaryCommitmentyRepository = budgetaryCommitmentyRepository;
	}

	// @ Transactional
	public void importBudgetaryCommitmentyContent(String content) throws IOException {
		log.info("importBudgetaryCommitmentyContent");

		// TODO jlopezri pending implementation

		log.info("importBudgetaryCommitmentyContent - finished");
	}

	public String exportBudgetaryCommitmentyContent() {
		log.info("exportBudgetaryCommitmentyContent");

		// TODO jlopezri pending implementation
		String data = "test content";

		log.info("exportBudgetaryCommitmentyContent - finished");
		return data;
	}

}
