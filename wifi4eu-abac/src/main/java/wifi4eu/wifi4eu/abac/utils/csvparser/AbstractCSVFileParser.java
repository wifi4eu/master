package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import weblogic.xml.util.StringInputStream;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public abstract class AbstractCSVFileParser {

	public static final Charset CSV_FILES_ENCODING = StandardCharsets.UTF_16LE;
	public static final byte[] UTF_8_BOM = {(byte)0xEF, (byte)0xBB, (byte)0xBF};
	public static final char UTF_16_LE_BOM = '\uFEFF';
	
	protected static final String PORTAL_CSV_DATE_FORMAT = "yyyy-MM-dd";
	protected static final String PORTAL_CSV_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private final Logger log = LoggerFactory.getLogger(AbstractCSVFileParser.class);
	
	protected abstract void validateColumns(CSVParser csvParser) throws RuntimeException;
	protected abstract List<?> mapRowsToEntities(CSVParser csvParser);

	public List<?> parseFile(FileDTO fileDTO) throws RuntimeException{

		InputStream inputStream = new ByteArrayInputStream(fileDTO.getContent());
		BOMInputStream bomInput = new BOMInputStream(inputStream, ByteOrderMark.UTF_16LE);
		Reader reader = new InputStreamReader(bomInput, StandardCharsets.UTF_16LE);

		try (CSVParser csvParser = new org.apache.commons.csv.CSVParser(reader, CSVFormat.TDF
				.withFirstRecordAsHeader()
				.withIgnoreHeaderCase()
				.withTrim())) {

			validateColumns(csvParser);
			return mapRowsToEntities(csvParser);

		} catch (IOException exception) {
			log.error(exception.getMessage());
			throw new RuntimeException(exception);
		}
	}

	protected void validateColumns(CSVParser csvParser, Enum ...mandatoryColumns) throws RuntimeException {

		StringBuilder columnsNotFound = new StringBuilder();
		Boolean isValid = Boolean.TRUE;

		//convert all headers to lowercase so we don't have to care about the case used by the portal
		Map<String, String> lowerCaseHeaders = new TreeMap<>();
		csvParser.getHeaderMap().keySet().stream().forEach(key -> lowerCaseHeaders.put(key.toLowerCase(), key));

		for (Enum mandatoryColumn : mandatoryColumns) {

			Boolean isColumnFound = lowerCaseHeaders.containsKey(mandatoryColumn.toString().toLowerCase());

			if(!isColumnFound) {
				isValid = Boolean.FALSE;
				columnsNotFound.append(mandatoryColumn.toString()).append(", ");
			}

			isValid = isValid ? isColumnFound : isValid;
		}

		if (!isValid) {
			String error = String.format("Invalid file format. Missing columns %s", columnsNotFound);
			log.error(error);
			throw new RuntimeException(error);
		}
	}
	
	protected CSVPrinter createCSVPrinter(ByteArrayOutputStream stream, CSVFormat csvFormat) throws IOException{
		OutputStreamWriter writer = new OutputStreamWriter(stream, CSV_FILES_ENCODING);
		return new CSVPrinter(writer, csvFormat);
	}
	
	protected String createCSVFileContent(ByteArrayOutputStream stream) throws UnsupportedEncodingException {
		String BOMedString = UTF_16_LE_BOM + stream.toString(CSV_FILES_ENCODING.name());
		return BOMedString;
	}
}