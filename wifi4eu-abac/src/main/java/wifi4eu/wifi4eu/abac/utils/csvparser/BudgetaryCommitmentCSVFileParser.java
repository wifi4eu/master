package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;
import wifi4eu.wifi4eu.abac.data.enums.BudgetaryCommitmentCSVColumn;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

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
	protected void validateColumns(CSVParser csvParser) {
		super.validateColumns(csvParser,
					BudgetaryCommitmentCSVColumn.MUNICIPALITY_PORTAL_ID,
					BudgetaryCommitmentCSVColumn.ABAC_GLOBAL_COMMITMENT_LEVEL1_POSITION_KEY,
					BudgetaryCommitmentCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION,
					BudgetaryCommitmentCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION_AMOUNT);
	}

	@Override
	protected List<BudgetaryCommitmentCSVRow> mapRowsToEntities(CSVParser csvParser) {

		List<BudgetaryCommitmentCSVRow> budgetaryCommitmentCSVRows = new ArrayList<>();

		for (CSVRecord csvRecord : csvParser) {

			BudgetaryCommitmentCSVRow budgetaryCommitmentCSVRow = new BudgetaryCommitmentCSVRow();

			budgetaryCommitmentCSVRow.setMunicipalityPortalId(Long.parseLong(csvRecord.get(BudgetaryCommitmentCSVColumn.MUNICIPALITY_PORTAL_ID)));
			budgetaryCommitmentCSVRow.setAbacGlobalCommitmentLevel1PositionKey(csvRecord.get(BudgetaryCommitmentCSVColumn.ABAC_GLOBAL_COMMITMENT_LEVEL1_POSITION_KEY));
			budgetaryCommitmentCSVRow.setAbacCommitmentLevel2Position(Integer.parseInt(csvRecord.get(BudgetaryCommitmentCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION)));
			budgetaryCommitmentCSVRow.setAbacCommitmentLevel2PositionAmount(new BigDecimal(csvRecord.get(BudgetaryCommitmentCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION_AMOUNT)));

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
							BudgetaryCommitmentCSVColumn.MUNICIPALITY_PORTAL_ID.toString(),
							BudgetaryCommitmentCSVColumn.ABAC_GLOBAL_COMMITMENT_LEVEL1_POSITION_KEY.toString(),
							BudgetaryCommitmentCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION.toString(),
							BudgetaryCommitmentCSVColumn.ABAC_COMMITMENT_LEVEL2_POSITION_AMOUNT.toString(),
							BudgetaryCommitmentCSVColumn.ABAC_STATUS.toString(),
							BudgetaryCommitmentCSVColumn.ABAC_MESSAGE.toString(),
							BudgetaryCommitmentCSVColumn.ABAC_COMMITMENT_LEVEL2_KEY.toString(),
							BudgetaryCommitmentCSVColumn.DATE_EXPORTED.toString(),
							BudgetaryCommitmentCSVColumn.USER_EXPORTED.toString()
					));

			for (BudgetaryCommitmentPosition budgetaryCommitmentPosition : budgetaryCommitments) {
				csvPrinter.printRecord(
						budgetaryCommitmentPosition.getBudgetaryCommitment().getLegalEntity().getMid(),
						budgetaryCommitmentPosition.getGlobalCommitmentLevel1PositionKey(),
						budgetaryCommitmentPosition.getCommitmentLevel2Position(),
						budgetaryCommitmentPosition.getCommitmentLevel2Amount(),
						budgetaryCommitmentPosition.getBudgetaryCommitment().getWfStatus(),
						budgetaryCommitmentPosition.getBudgetaryCommitment().getAbacErrorMessage(),
						budgetaryCommitmentPosition.getBudgetaryCommitment().getCommitmentLevel2Key(),
						DateTimeUtils.format(budgetaryCommitmentPosition.getBudgetaryCommitment().getDateExported(), PORTAL_CSV_DATETIME_FORMAT),
						budgetaryCommitmentPosition.getBudgetaryCommitment().getUserExported()
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
