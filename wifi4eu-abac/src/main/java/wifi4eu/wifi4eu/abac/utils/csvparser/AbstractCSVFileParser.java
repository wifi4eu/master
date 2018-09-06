package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public abstract class AbstractCSVFileParser {

	protected static final String PORTAL_CSV_DATE_FORMAT = "yyyy-MM-dd";

	private final Logger log = LoggerFactory.getLogger(AbstractCSVFileParser.class);

	public List<?> parseFile(FileDTO fileDTO) throws RuntimeException {

		Reader reader = new StringReader(new String(fileDTO.getContent(), StandardCharsets.UTF_8));

		try (CSVParser csvParser = new org.apache.commons.csv.CSVParser(reader, CSVFormat.DEFAULT
				.withFirstRecordAsHeader()
				.withIgnoreHeaderCase()
				.withTrim())) {

			validateColumns(csvParser);
			return mapRowsToEntities(csvParser);

		} catch (IOException exception) {
			exception.printStackTrace();
			return null;
		}
	}

	protected abstract Boolean validateColumns(CSVParser csvParser) throws RuntimeException;

	protected Boolean validateColumns(CSVParser csvParser, Enum ...mandatoryColumns) throws RuntimeException {

		StringBuilder columnsNotFound = new StringBuilder();
		Boolean isValid = Boolean.TRUE;

		//convert all headers to lowercase so we don't have to care about the case used by the portal
		Map<String, String> lowerCaseHeaders = new TreeMap<>();
		csvParser.getHeaderMap().keySet().stream().forEach(key -> lowerCaseHeaders.put(key.toLowerCase(), key));

		for (Enum mandatoryColumn : mandatoryColumns) {

			Boolean isColumnFound = csvParser.getHeaderMap().containsKey(lowerCaseHeaders.get(mandatoryColumn.toString().toLowerCase()));

			if(!isColumnFound) {
				isValid = Boolean.FALSE;
				columnsNotFound.append(mandatoryColumn.toString()).append(", ");
			}

			isValid = isValid ? isColumnFound : isValid;
		}

		if (!isValid) {
			log.error("Invalid file format. Missing columns {}", columnsNotFound);
			throw new RuntimeException(String.format("Invalid file format. Missing columns %s", columnsNotFound));
		}

		return isValid;
	}

	protected abstract List<?> mapRowsToEntities(CSVParser csvParser);

}