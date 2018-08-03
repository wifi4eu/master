package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
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
	protected List<Document> mapRowsToEntities(CSVParser csvParser) {

		List<Document> documents = new ArrayList<>();

		for (CSVRecord csvRecord : csvParser) {
			Document document = new Document();

			document.setPortalId(Long.parseLong(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_PORTAL_ID)));
			document.setName(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_NAME));
			document.setFilename(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_FILENAME));
			document.setMimetype(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_MIMETYPE));
			document.setPortalDate(DateTimeUtils.parseDate(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_DATE), PORTAL_CSV_DATE_FORMAT));
			//document.setType(new DocumentType(csvRecord.get(LegalEntityDocumentImportCSVColumn.DOCUMENT_TYPE)));
		}
		return documents;
	}
}
