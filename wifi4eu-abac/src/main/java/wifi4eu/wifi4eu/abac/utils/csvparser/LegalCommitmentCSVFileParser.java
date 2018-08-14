package wifi4eu.wifi4eu.abac.utils.csvparser;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.abac.data.dto.LegalCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentImportCSVColumn;

@Component
public class LegalCommitmentCSVFileParser extends AbstractCSVFileParser{

	@Override
	protected Boolean validateColumns(CSVParser csvParser) throws RuntimeException {
		return super.validateColumns(csvParser, LegalCommitmentImportCSVColumn.MUNICIPALITY_PORTAL_ID);
	}

	@Override
	protected List<LegalCommitmentCSVRow> mapRowsToEntities(CSVParser csvParser) {

		List<LegalCommitmentCSVRow> legalCommitmentRows = new ArrayList<>();

		for (CSVRecord csvRecord : csvParser) {
			LegalCommitmentCSVRow legalCommitmentCSVRow = new LegalCommitmentCSVRow();
			legalCommitmentCSVRow.setMunicipalityPortalId(Long.parseLong(csvRecord.get(LegalCommitmentImportCSVColumn.MUNICIPALITY_PORTAL_ID)));
			legalCommitmentRows.add(legalCommitmentCSVRow);
		}
		
		return legalCommitmentRows;
	}

}
