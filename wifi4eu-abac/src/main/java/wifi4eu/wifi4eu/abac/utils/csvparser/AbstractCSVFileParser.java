package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;

import java.io.*;
import java.util.List;

@Component
public abstract class AbstractCSVFileParser {

	public List<?> parseFile(FileDTO fileDTO) {

		Reader reader = new StringReader(new String(fileDTO.getContent()));

		try (CSVParser csvParser = new org.apache.commons.csv.CSVParser(reader, CSVFormat.DEFAULT
				.withFirstRecordAsHeader()
				.withIgnoreHeaderCase()
				.withTrim())) {

			return mapRowsToEntities(csvParser);

		} catch (IOException exception) {
			exception.printStackTrace();
			return null;
		}
	}

	protected abstract List<?> mapRowsToEntities(CSVParser csvParser);

}