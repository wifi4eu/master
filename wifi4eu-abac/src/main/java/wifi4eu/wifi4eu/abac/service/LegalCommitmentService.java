package wifi4eu.wifi4eu.abac.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.repository.LegalCommitmentRepository;

@Service
public class LegalCommitmentService {

	private final Logger log = LoggerFactory.getLogger(LegalCommitmentService.class);

	private LegalCommitmentRepository legalCommitmentyRepository;

	@Autowired
	public LegalCommitmentService(LegalCommitmentRepository legalCommitmentyRepository) {
		this.legalCommitmentyRepository = legalCommitmentyRepository;
	}

	// @ Transactional
	public void importLegalCommitmentyContent(String content) throws IOException {
		log.info("importLegalCommitmentyContent");

		// TODO jlopezri pending implementation

		log.info("importLegalCommitmentyContent - finished");
	}

	public String exportLegalCommitmentyContent() {
		log.info("exportLegalCommitmentyContent");

		// TODO jlopezri pending implementation
		String data = "test content";

		log.info("exportLegalCommitmentyContent - finished");
		return data;
	}

}
