package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentCSVColumn;
import wifi4eu.wifi4eu.abac.data.enums.LegalEntityDocumentCSVColumn;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentCSVFileParser extends AbstractCSVFileParser {

	@Override
	protected Boolean validateColumns(CSVParser csvParser) {
		return super.validateColumns(csvParser,
				LegalEntityDocumentCSVColumn.MUNICIPALITY_PORTAL_ID,
				LegalEntityDocumentCSVColumn.DOCUMENT_PORTAL_ID,
				LegalEntityDocumentCSVColumn.DOCUMENT_NAME,
				LegalEntityDocumentCSVColumn.DOCUMENT_FILENAME,
				LegalEntityDocumentCSVColumn.DOCUMENT_MIMETYPE,
				LegalEntityDocumentCSVColumn.DOCUMENT_DATE,
				LegalEntityDocumentCSVColumn.DOCUMENT_TYPE,
				LegalEntityDocumentCSVColumn.ARES_REFERENCE);
	}

	@Override
	protected List<LegalEntityDocumentCSVRow> mapRowsToEntities(CSVParser csvParser) {

		try {
			List<LegalEntityDocumentCSVRow> documents = new ArrayList<>();

			for (CSVRecord csvRecord : csvParser) {
				LegalEntityDocumentCSVRow documentCSVRow = new LegalEntityDocumentCSVRow();

				documentCSVRow.setMunicipalityPortalId(Long.parseLong(csvRecord.get(LegalEntityDocumentCSVColumn.MUNICIPALITY_PORTAL_ID)));
				documentCSVRow.setDocumentPortalId(Long.parseLong(csvRecord.get(LegalEntityDocumentCSVColumn.DOCUMENT_PORTAL_ID)));
				documentCSVRow.setDocumentName(csvRecord.get(LegalEntityDocumentCSVColumn.DOCUMENT_NAME));
				documentCSVRow.setDocumentFileName(csvRecord.get(LegalEntityDocumentCSVColumn.DOCUMENT_FILENAME));
				documentCSVRow.setDocumentMimeType(csvRecord.get(LegalEntityDocumentCSVColumn.DOCUMENT_MIMETYPE));
				documentCSVRow.setDocumentDate(DateTimeUtils.parseDate(csvRecord.get(LegalEntityDocumentCSVColumn.DOCUMENT_DATE), PORTAL_CSV_DATE_FORMAT));
				documentCSVRow.setDocumentType(DocumentType.valueOf(csvRecord.get(LegalEntityDocumentCSVColumn.DOCUMENT_TYPE)));
				documentCSVRow.setAresReference(csvRecord.get(LegalEntityDocumentCSVColumn.ARES_REFERENCE));
				documents.add(documentCSVRow);
			}
			return documents;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public String exportDocumentsToCSV(List<Document> documents) {

		try {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
			BufferedWriter writer = new BufferedWriter(streamWriter);

			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
					.withHeader(
							LegalEntityDocumentCSVColumn.MUNICIPALITY_PORTAL_ID.toString(),
							LegalEntityDocumentCSVColumn.DOCUMENT_NAME.toString(),
							LegalEntityDocumentCSVColumn.DOCUMENT_FILENAME.toString(),
							LegalEntityDocumentCSVColumn.DOCUMENT_MIMETYPE.toString(),
							LegalEntityDocumentCSVColumn.DOCUMENT_TYPE.toString(),
							LegalEntityDocumentCSVColumn.ARES_REFERENCE.toString(),
							LegalEntityDocumentCSVColumn.DATE_EXPORTED.toString(),
							LegalCommitmentCSVColumn.USER_EXPORTED.toString()
					));

			for (Document document : documents) {
				csvPrinter.printRecord(
						document.getLegalEntity().getMid(),
						document.getName(),
						document.getFileName(),
						document.getMimetype(),
						document.getType(),
						document.getAresReference(),
						DateTimeUtils.format(document.getDateExported(), PORTAL_CSV_DATETIME_FORMAT),
						document.getUserExported()
				);
			}

			csvPrinter.flush();
			return stream.toString();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
