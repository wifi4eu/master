package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;
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
	protected Boolean validateColumns(CSVParser csvParser) {

		return super.validateColumns(csvParser,
					BudgetaryCommitmentImportCSVColumn.MUNICIPALITY_PORTAL_ID,
					BudgetaryCommitmentImportCSVColumn.ABAC_GLOBAL_COMMITMENT_LEVEL1_POSITION_KEY,
					BudgetaryCommitmentImportCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION,
					BudgetaryCommitmentImportCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION_AMOUNT);
	}

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

	public String exportBudgetaryCommitmentToCSV(List<BudgetaryCommitmentPosition> budgetaryCommitments) {

		try {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
			BufferedWriter writer = new BufferedWriter(streamWriter);

			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
					.withHeader(
							BudgetaryCommitmentImportCSVColumn.MUNICIPALITY_PORTAL_ID.toString(),
							BudgetaryCommitmentImportCSVColumn.ABAC_GLOBAL_COMMITMENT_LEVEL1_POSITION_KEY.toString(),
							BudgetaryCommitmentImportCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION.toString(),
							BudgetaryCommitmentImportCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION_AMOUNT.toString(),
							BudgetaryCommitmentImportCSVColumn.ABAC_STATUS.toString(),
							BudgetaryCommitmentImportCSVColumn.ABAC_MESSAGE.toString()
					));

			for (BudgetaryCommitmentPosition budgetaryCommitmentPosition : budgetaryCommitments) {
				csvPrinter.printRecord(
						budgetaryCommitmentPosition.getBudgetaryCommitment().getLegalEntity().getMid(),
						budgetaryCommitmentPosition.getGlobalCommitmentLevel1PositionKey(),
						budgetaryCommitmentPosition.getCommitmentLevel2Position(),
						budgetaryCommitmentPosition.getCommitmentLevel2Amount(),
						budgetaryCommitmentPosition.getBudgetaryCommitment().getWfStatus(),
						budgetaryCommitmentPosition.getBudgetaryCommitment().getAbacErrorMessage()
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
