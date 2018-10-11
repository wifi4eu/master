package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.io.input.BOMInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.abac.data.Constants;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("rawtypes")
@Component
public abstract class AbstractCSVFileParser {

	private final Logger log = LoggerFactory.getLogger(AbstractCSVFileParser.class);
	
	protected abstract List<?> mapRowsToEntities(CSVParser csvParser);
	protected abstract void validateColumns(CSVParser csvParser) throws RuntimeException;

	public List<?> parseFile(FileDTO fileDTO) throws RuntimeException{

		InputStream inputStream = new ByteArrayInputStream(fileDTO.getContent());
		BOMInputStream bomInput = new BOMInputStream(inputStream, Constants.CSV_FILES_BOM);
		Reader reader = new InputStreamReader(bomInput, Constants.CSV_FILES_ENCODING);

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
}