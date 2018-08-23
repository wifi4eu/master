package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import wifi4eu.wifi4eu.abac.data.dto.LegalCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentImportCSVColumn;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

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

	public String exportLegalCommitmentToCSV(List<LegalCommitment> legalCommitments) {

		try {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
			BufferedWriter writer = new BufferedWriter(streamWriter);

			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
					.withHeader(
							LegalCommitmentImportCSVColumn.MUNICIPALITY_PORTAL_ID.toString(),
							LegalCommitmentImportCSVColumn.GRANT_AGREEMENT_SIGNATURE_DATE.toString(),
							LegalCommitmentImportCSVColumn.GRANT_AGREEMENT_COUNTERSIGNATURE_DATE.toString(),
							LegalCommitmentImportCSVColumn.ABAC_STATUS.toString(),
							LegalCommitmentImportCSVColumn.ABAC_MESSAGE.toString(),
							LegalCommitmentImportCSVColumn.ABAC_KEY.toString()
					));

			for (LegalCommitment legalCommitment : legalCommitments) {
				csvPrinter.printRecord(
						legalCommitment.getLegalEntity().getMid(),
						DateTimeUtils.format(legalCommitment.getGrantAgreementSignatureDate(), PORTAL_CSV_DATE_FORMAT),
						DateTimeUtils.format(legalCommitment.getGrantAgreementCounterSignatureDate(), PORTAL_CSV_DATE_FORMAT),
						legalCommitment.getWfStatus(),
						legalCommitment.getAbacErrorMessage(),
						legalCommitment.getAbacKey()
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
