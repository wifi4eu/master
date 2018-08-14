package wifi4eu.wifi4eu.abac.utils.csvparser;

import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.abac.data.dto.LegalCommitmentCSVRow;

@Component
public class LegalCommitmentCSVFileParser extends AbstractCSVFileParser{

	@Override
	protected Boolean validateColumns(CSVParser csvParser) throws RuntimeException {

		
		return null;
	}

	@Override
	protected List<LegalCommitmentCSVRow> mapRowsToEntities(CSVParser csvParser) {

		
		return null;
	}

}
