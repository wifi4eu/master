package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

@Component
public abstract class AbstractCSVFileParser {

	public List<?> parseFile(FileDTO fileDTO) throws RuntimeException {

		Reader reader = new StringReader(new String(fileDTO.getContent()));

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

		for (Enum mandatoryColumn : mandatoryColumns) {

			Boolean isColumnFound = csvParser.getHeaderMap().containsKey(mandatoryColumn.toString());

			if(!isColumnFound) {
				isValid = Boolean.FALSE;
				columnsNotFound.append(mandatoryColumn.toString()).append(", ");
			}

			isValid = isValid ? isColumnFound : isValid;
		}

		if (!isValid) throw new RuntimeException(String.format("Invalid file format. Missing columns %s", columnsNotFound));

		return isValid;
	}

	protected abstract List<?> mapRowsToEntities(CSVParser csvParser);

}