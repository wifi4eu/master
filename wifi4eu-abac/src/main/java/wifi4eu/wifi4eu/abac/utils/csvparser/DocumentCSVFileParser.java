package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.LegalEntityDocumentImportCSVColumn;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentCSVFileParser extends AbstractCSVFileParser {

	private static final String PORTAL_CSV_DATE_FORMAT = "yyyy-MM-dd";

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
			documents.add(documentCSVRow);
		}
		return documents;
	}
}
