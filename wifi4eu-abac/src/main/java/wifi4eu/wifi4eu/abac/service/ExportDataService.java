package wifi4eu.wifi4eu.abac.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.entity.*;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;
import wifi4eu.wifi4eu.abac.utils.ZipFileWriter;
import wifi4eu.wifi4eu.abac.utils.csvparser.BudgetaryCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.DocumentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;

import javax.transaction.Transactional;

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
	private ECASUserService ecasUserService;

	@Autowired
	private LegalCommitmentService legalCommitmentService;

	static final String LEGAL_ENTITY_INFORMATION_CSV_FILENAME = "airgap_exportBeneficiaryInformation.csv";
	static final String BUDGETARY_COMMITMENT_INFORMATION_CSV_FILENAME = "airgap_exportBudgetaryCommitmentInformation.csv";
	static final String LEGAL_COMMITMENT_INFORMATION_CSV_FILENAME = "airgap_exportLegalCommitmentInformation.csv";
	static final String LEGAL_COMMITMENT_INFORMATION_ZIP_FILENAME = "airgap_exportLegalCommitments.zip";
	static final String LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME = "airgap_exportBeneficiaryDocuments.csv";

	private final Logger log = LoggerFactory.getLogger(ExportDataService.class);

	@Transactional
	public FileDTO exportLegalEntities() {
		log.info("exportLegalEntities");
		List<LegalEntity> legalEntities = legalEntityService.getAllLegalEntitiesForExport();
		String csvFile = legalEntityCSVFileParser.exportLegalEntitiesToCSV(legalEntities);

		Date now = Calendar.getInstance().getTime();
		for (LegalEntity legalEntity : legalEntities) {
			legalEntity.setDateExported(now);
			legalEntity.setUserExported(ecasUserService.getCurrentUsername());
			legalEntityService.saveLegalEntity(legalEntity);
		}

		return new FileDTO(LEGAL_ENTITY_INFORMATION_CSV_FILENAME, csvFile.getBytes());
	}

	@Transactional
	public FileDTO exportBudgetaryCommitments() {
		log.info("exportBudgetaryCommitmentyContent");
		List<BudgetaryCommitmentPosition> budgetaryCommitmentPositions = (List<BudgetaryCommitmentPosition>) budgetaryCommitmentService.findAllBudgetaryCommitmentPositionsForExport();
		String csvFile = budgetaryCommitmentCSVFileParser.exportBudgetaryCommitmentToCSV(budgetaryCommitmentPositions);

		Date now = Calendar.getInstance().getTime();
		for (BudgetaryCommitmentPosition budgetaryCommitmentPosition : budgetaryCommitmentPositions) {
			budgetaryCommitmentPosition.getBudgetaryCommitment().setDateExported(now);
			budgetaryCommitmentPosition.getBudgetaryCommitment().setUserExported(ecasUserService.getCurrentUsername());
			budgetaryCommitmentService.save(budgetaryCommitmentPosition.getBudgetaryCommitment());
		}

		return new FileDTO(BUDGETARY_COMMITMENT_INFORMATION_CSV_FILENAME, csvFile.getBytes());
	}

	@Transactional
	public FileDTO exportLegalCommitments() throws IOException {
		ZipFileWriter zipFileWriter = new ZipFileWriter(LEGAL_COMMITMENT_INFORMATION_ZIP_FILENAME);

		List<LegalCommitment> legalCommitments = legalCommitmentService.getAllLegalCommitmentsForExport();
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

		Date now = Calendar.getInstance().getTime();
		for (LegalCommitment legalCommitment : legalCommitments) {
			legalCommitment.setDateExported(now);
			legalCommitment.setUserExported(ecasUserService.getCurrentUsername());

			if (legalCommitment.getCounterSignedGrantAgreementDocument() != null) {
				legalCommitment.getCounterSignedGrantAgreementDocument().setDateExported(now);
				legalCommitment.getCounterSignedGrantAgreementDocument().setUserExported(ecasUserService.getCurrentUsername());
			}

			legalCommitmentService.saveLegalCommitment(legalCommitment);

		}

		return zipFileWriter.finishAndReturnZipfile();
	}
}