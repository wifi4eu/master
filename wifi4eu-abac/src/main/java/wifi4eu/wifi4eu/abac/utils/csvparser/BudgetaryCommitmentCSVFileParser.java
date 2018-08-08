package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.enums.BudgetaryCommitmentImportCSVColumn;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class BudgetaryCommitmentCSVFileParser extends AbstractCSVFileParser {

	@Override
	protected List<BudgetaryCommitmentCSVRow> mapRowsToEntities(CSVParser csvParser) {

		List<BudgetaryCommitmentCSVRow> budgetaryCommitmentCSVRows = new ArrayList<>();

		for (CSVRecord csvRecord : csvParser) {

			BudgetaryCommitmentCSVRow budgetaryCommitmentCSVRow = new BudgetaryCommitmentCSVRow();

			budgetaryCommitmentCSVRow.setMunicipalityPortalId(Long.parseLong(csvRecord.get(BudgetaryCommitmentImportCSVColumn.MUNICIPALITY_PORTAL_ID)));
			budgetaryCommitmentCSVRow.setAbacGlobalCommitmentLevel1PositionKey(csvRecord.get(BudgetaryCommitmentImportCSVColumn.ABAC_GLOBAL_COMMITMENT_LEVEL1_POSITION_KEY));
			budgetaryCommitmentCSVRow.setAbacCommitmentLevel2Position(Integer.parseInt(csvRecord.get(BudgetaryCommitmentImportCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION)));
			budgetaryCommitmentCSVRow.setAbacCommitmentLevel2PositionAmount(new BigDecimal(csvRecord.get(BudgetaryCommitmentImportCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION_AMOUNT)));

			budgetaryCommitmentCSVRows.add(budgetaryCommitmentCSVRow);
		}
		return budgetaryCommitmentCSVRows;
	}

	public String exportBudgetaryCommitmentToCSV(List<BudgetaryCommitment> budgetaryCommitments) {

		try {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
			BufferedWriter writer = new BufferedWriter(streamWriter);

			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
					.withHeader(
							BudgetaryCommitmentImportCSVColumn.MUNICIPALITY_PORTAL_ID.toString(),
							BudgetaryCommitmentImportCSVColumn.ABAC_GLOBAL_COMMITMENT_LEVEL1_POSITION_KEY.toString(),
							BudgetaryCommitmentImportCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION.toString(),
							BudgetaryCommitmentImportCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION_AMOUNT.toString()
					));

			// TODO Finish export
/*			for (LegalEntity budgetaryCommitment : budgetaryCommitments) {
				csvPrinter.printRecord(
						legalEntity.getMid(),
						legalEntity.getOfficialName(),
						legalEntity.getOfficialAddress(),
						legalEntity.getPostalCode(),
						legalEntity.getCity(),
						legalEntity.getCountryCode(),
						legalEntity.getLanguageCode(),
						legalEntity.getRegistrationNumber(),
						legalEntity.getAbacFelId(),
						legalEntity.getWfStatus()
				);
			}*/

			csvPrinter.flush();
			return stream.toString();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}