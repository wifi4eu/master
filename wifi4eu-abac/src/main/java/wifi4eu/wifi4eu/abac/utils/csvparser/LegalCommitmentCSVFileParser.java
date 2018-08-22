package wifi4eu.wifi4eu.abac.utils.csvparser;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import oracle.j2ee.ws.mdds.util.DateUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import wifi4eu.wifi4eu.abac.data.dto.LegalCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;
import wifi4eu.wifi4eu.abac.data.enums.BudgetaryCommitmentImportCSVColumn;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentImportCSVColumn;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

@Component
public class LegalCommitmentCSVFileParser extends AbstractCSVFileParser{

	@Override
	protected Boolean validateColumns(CSVParser csvParser) throws RuntimeException {
		throw new NotImplementedException();
	}

	@Override
	protected List<LegalCommitmentCSVRow> mapRowsToEntities(CSVParser csvParser) {
		throw new NotImplementedException();
	}

	public String exportBudgetaryCommitmentToCSV(List<LegalCommitment> legalCommitments) {

		try {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
			BufferedWriter writer = new BufferedWriter(streamWriter);

			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
					.withHeader(
							LegalCommitmentImportCSVColumn.MUNICIPALITY_PORTAL_ID.toString(),
							LegalCommitmentImportCSVColumn.GRANT_AGREEMENT_SIGNATURE_DATE.toString(),
							LegalCommitmentImportCSVColumn.GRANT_AGREEMENT_COUNTERSIGNATURE_DATE.toString()
					));

			for (LegalCommitment legalCommitment : legalCommitments) {
				csvPrinter.printRecord(
						legalCommitment.getLegalEntity().getMid(),
						DateTimeUtils.format(legalCommitment.getGrantAgreementSignatureDate(), PORTAL_CSV_DATE_FORMAT),
						DateTimeUtils.format(legalCommitment.getGrantAgreementCounterSignatureDate(), PORTAL_CSV_DATE_FORMAT)
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
