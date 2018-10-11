package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.StringUtils;

import wifi4eu.wifi4eu.abac.data.Constants;
import wifi4eu.wifi4eu.abac.data.dto.DocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.DocumentCSVColumn;
import wifi4eu.wifi4eu.abac.utils.CSVStringCreator;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("rawtypes")
public abstract class DocumentCSVFileParser extends AbstractCSVFileParser {
	
	public static final Enum[] DOCUMENT_MANDATORY_FIELDS = {
		DocumentCSVColumn.DOCUMENT_PORTAL_ID,
		DocumentCSVColumn.DOCUMENT_NAME,
		DocumentCSVColumn.DOCUMENT_FILENAME,
		DocumentCSVColumn.DOCUMENT_MIMETYPE,
		DocumentCSVColumn.DOCUMENT_DATE,
		DocumentCSVColumn.DOCUMENT_TYPE,
		DocumentCSVColumn.ARES_REFERENCE
	};
	
	public static final String[] EXPORT_HEADERS = {
		DocumentCSVColumn.DOCUMENT_NAME.toString(),
		DocumentCSVColumn.DOCUMENT_FILENAME.toString(),
		DocumentCSVColumn.DOCUMENT_MIMETYPE.toString(),
		DocumentCSVColumn.DOCUMENT_TYPE.toString(),
		DocumentCSVColumn.ARES_REFERENCE.toString(),
		DocumentCSVColumn.DATE_EXPORTED.toString(),
		DocumentCSVColumn.USER_EXPORTED.toString()
	};

	public abstract Enum[] getMandatoryFields();
	public abstract String[] getAdditionalExportHeaders();
	public abstract Object[] getAdditionalExportValues(Document document);
	
	@Override
	protected void validateColumns(CSVParser csvParser) {
		super.validateColumns(csvParser, (Enum[])ArrayUtils.addAll(getMandatoryFields(), DOCUMENT_MANDATORY_FIELDS));
	}
	
	protected void mapCSVRowToDocument(DocumentCSVRow documentCSVRow, CSVRecord csvRecord) throws Exception, RuntimeException {
		documentCSVRow.setDocumentPortalId(StringUtils.isEmpty(
			csvRecord.get(DocumentCSVColumn.DOCUMENT_PORTAL_ID)) ?  null : Long.parseLong(csvRecord.get(DocumentCSVColumn.DOCUMENT_PORTAL_ID))
		);
		documentCSVRow.setDocumentName(csvRecord.get(DocumentCSVColumn.DOCUMENT_NAME));
		documentCSVRow.setDocumentFileName(csvRecord.get(DocumentCSVColumn.DOCUMENT_FILENAME));
		documentCSVRow.setDocumentMimeType(csvRecord.get(DocumentCSVColumn.DOCUMENT_MIMETYPE));
		documentCSVRow.setDocumentDate(StringUtils.isEmpty(
			csvRecord.get(DocumentCSVColumn.DOCUMENT_DATE)) ? null : DateTimeUtils.parseDate(csvRecord.get(DocumentCSVColumn.DOCUMENT_DATE), Constants.PORTAL_CSV_DATE_FORMAT)
		);
		documentCSVRow.setDocumentType(
			StringUtils.isEmpty(csvRecord.get(DocumentCSVColumn.DOCUMENT_TYPE)) ? null : DocumentType.valueOf(csvRecord.get(DocumentCSVColumn.DOCUMENT_TYPE))
		);
		documentCSVRow.setAresReference(csvRecord.get(DocumentCSVColumn.ARES_REFERENCE));
	}
	
	public String exportDocumentsToCSV(List<Document> documents) {

		try {
			String[] headers = (String[])ArrayUtils.addAll(getAdditionalExportHeaders(), EXPORT_HEADERS);
			CSVStringCreator csv = new CSVStringCreator(CSVFormat.TDF.withHeader(headers));
	
			for (Document document : documents) {
				Object[] values = {
					document.getName(),
					document.getFileName(),
					document.getMimetype(),
					document.getType(),
					document.getAresReference(),
					DateTimeUtils.format(document.getDateExported(), Constants.PORTAL_CSV_DATETIME_FORMAT),
					document.getUserExported()
				};
				csv.printRecord(ArrayUtils.addAll(getAdditionalExportValues(document), values));
			}
			return csv.closeAndGenerateString();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
