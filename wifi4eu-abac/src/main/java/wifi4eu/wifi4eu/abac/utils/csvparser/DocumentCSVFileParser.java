package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.enums.BudgetaryCommitmentImportCSVColumn;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.LegalEntityDocumentImportCSVColumn;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentCSVFileParser extends AbstractCSVFileParser {

	@Override
	protected Boolean validateColumns(CSVParser csvParser) {
		return super.validateColumns(csvParser,
				LegalEntityDocumentImportCSVColumn.MUNICIPALITY_PORTAL_ID,
				LegalEntityDocumentImportCSVColumn.DOCUMENT_PORTAL_ID,
				LegalEntityDocumentImportCSVColumn.DOCUMENT_NAME,
				LegalEntityDocumentImportCSVColumn.DOCUMENT_FILENAME,
				LegalEntityDocumentImportCSVColumn.DOCUMENT_MIMETYPE,
				LegalEntityDocumentImportCSVColumn.DOCUMENT_DATE,
				LegalEntityDocumentImportCSVColumn.DOCUMENT_TYPE,
				LegalEntityDocumentImportCSVColumn.ARES_REFERENCE);
	}

	@Override
	protected List<LegalEntityDocumentCSVRow> mapRowsToEntities(CSVParser csvParser) {

		List<LegalEntityDocumentCSVRow> documents = new ArrayList<>();

		for (CSVRecord csvRecord : csvParser) {
			LegalEntityDocumentCSVRow documentCSVRow = new LegalEntityDocumentCSVRow();

			documentCSVRow.setMunicipalityPortalId(Long.parseLong(csvRecord.get(LegalEntityDocumentImportCSVColumn.MUNICIPALITY_PORTAL_ID)));
			documentCSVRow.setDocumentPortalId(Long.parseLong(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_PORTAL_ID)));
			documentCSVRow.setDocumentName(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_NAME));
			documentCSVRow.setDocumentFileName(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_FILENAME));
			documentCSVRow.setDocumentMimeType(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_MIMETYPE));
			documentCSVRow.setDocumentDate(DateTimeUtils.parseDate(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_DATE), PORTAL_CSV_DATE_FORMAT));
			documentCSVRow.setDocumentType(DocumentType.valueOf(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_TYPE)));
			documentCSVRow.setAresReference(csvRecord.get(LegalEntityDocumentImportCSVColumn.ARES_REFERENCE));
			documents.add(documentCSVRow);
		}
		return documents;
	}
}
