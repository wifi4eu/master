package wifi4eu.wifi4eu.abac.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.utils.ZipFileWriter;
import wifi4eu.wifi4eu.abac.utils.csvparser.BudgetaryCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.DocumentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;

@Service
public class ExportDataService {

	@Autowired
	private LegalEntityCSVFileParser legalEntityCSVFileParser;

	@Autowired
	private LegalCommitmentCSVFileParser legalCommitmentCSVFileParser;

	@Autowired
	private BudgetaryCommitmentCSVFileParser budgetaryCommitmentCSVFileParser;

	@Autowired
	private DocumentCSVFileParser documentCSVFileParser;

	@Autowired
	private LegalEntityService legalEntityService;

	@Autowired
	private BudgetaryCommitmentService budgetaryCommitmentService;

	@Autowired
	private LegalCommitmentService legalCommitmentService;

	static final String LEGAL_ENTITY_INFORMATION_CSV_FILENAME = "airgap_exportBeneficiaryInformation.csv";
	static final String BUDGETARY_COMMITMENT_INFORMATION_CSV_FILENAME = "airgap_exportBudgetaryCommitmentInformation.csv";
	static final String LEGAL_COMMITMENT_INFORMATION_CSV_FILENAME = "airgap_exportLegalCommitmentInformation.csv";
	static final String LEGAL_COMMITMENT_INFORMATION_ZIP_FILENAME = "airgap_exportLegalCommitments.zip";
	static final String LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME = "airgap_exportBeneficiaryDocuments.csv";

	private final Logger log = LoggerFactory.getLogger(ExportDataService.class);

	public FileDTO exportLegalEntityFile() {
		log.info("exportLegalEntityFile");
		List<LegalEntity> legalEntities = legalEntityService.getLegalEntitiesProcessedInAbac();
		String csvFile = legalEntityCSVFileParser.exportLegalEntitiesToCSV(legalEntities);
		return new FileDTO(LEGAL_ENTITY_INFORMATION_CSV_FILENAME, csvFile.getBytes());
	}

	public FileDTO exportBudgetaryCommitments() {
		log.info("exportBudgetaryCommitmentyContent");
		List<BudgetaryCommitmentPosition> budgetaryCommitmentPositions = (List<BudgetaryCommitmentPosition>) budgetaryCommitmentService.findAllBudgetaryCommitmentPositions();
		String csvFile = budgetaryCommitmentCSVFileParser.exportBudgetaryCommitmentToCSV(budgetaryCommitmentPositions);
		return new FileDTO(BUDGETARY_COMMITMENT_INFORMATION_CSV_FILENAME, csvFile.getBytes());
	}

	public FileDTO exportLegalCommitments() throws IOException {
		ZipFileWriter zipFileWriter = new ZipFileWriter(LEGAL_COMMITMENT_INFORMATION_ZIP_FILENAME);

		List<LegalCommitment> legalCommitments = legalCommitmentService.getAllLegalCommitments();
		List<Document> documents = new ArrayList<>();

		for (LegalCommitment legalCommitment : legalCommitments) {

			Document counterSignedGrantAgreement = legalCommitment.getCounterSignedGrantAgreementDocument();
			if (counterSignedGrantAgreement != null) {
				FileDTO fileDTO = new FileDTO(counterSignedGrantAgreement.getFileName(), counterSignedGrantAgreement.getData());
				zipFileWriter.addFile(fileDTO);

				documents.add(counterSignedGrantAgreement);
			}
		}

		byte[] legalCommitmentsCSVbytes = legalCommitmentCSVFileParser.exportLegalCommitmentToCSV(legalCommitments).getBytes();
		FileDTO legalCommitmentsCSVFile = new FileDTO(LEGAL_COMMITMENT_INFORMATION_CSV_FILENAME, legalCommitmentsCSVbytes);
		zipFileWriter.addFile(legalCommitmentsCSVFile);

		byte[] documentsCSVbytes = documentCSVFileParser.exportDocumentsToCSV(documents).getBytes();
		FileDTO documentsCSVFile = new FileDTO(LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME, documentsCSVbytes);
		zipFileWriter.addFile(documentsCSVFile);

		return zipFileWriter.finishAndReturnZipfile();
	}
}