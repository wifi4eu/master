package wifi4eu.wifi4eu.abac.utils.csvparser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.LegalEntityImportCSVColumn;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

@Component
public class LegalEntityCSVFileParser extends AbstractCSVFileParser {

	@Override
	protected List<LegalEntityInformationCSVRow> mapRowsToEntities(CSVParser csvParser) {

		List<LegalEntityInformationCSVRow> legalEntityRows = new ArrayList<>();

		for (CSVRecord csvRecord : csvParser) {

			LegalEntityInformationCSVRow legalEntityInformationCSVRow = new LegalEntityInformationCSVRow();

			legalEntityInformationCSVRow.setMid(Long.parseLong(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_PORTAL_ID)));
			legalEntityInformationCSVRow.setOfficialName(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_NAME));
			legalEntityInformationCSVRow.setOfficialAddress(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_ADDRESS));
			legalEntityInformationCSVRow.setPostalCode(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_POSTAL_CODE));
			legalEntityInformationCSVRow.setCity(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_CITY));
			legalEntityInformationCSVRow.setCountryCode(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_COUNTRY_CODE));
			legalEntityInformationCSVRow.setLanguageCode(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_LANGUAGE_CODE));
			legalEntityInformationCSVRow.setRegistrationNumber(Long.parseLong(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_REGISTRATION_NUMBER)));

			legalEntityRows.add(legalEntityInformationCSVRow);
		}
		return legalEntityRows;
	}

	public String exportLegalEntitiesToCSV(List<LegalEntity> legalEntities) {

		try {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
			BufferedWriter writer = new BufferedWriter(streamWriter);

			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
					.withHeader(
							LegalEntityImportCSVColumn.MUNICIPALITY_PORTAL_ID.toString(),
							LegalEntityImportCSVColumn.MUNICIPALITY_NAME.toString(),
							LegalEntityImportCSVColumn.MUNICIPALITY_ADDRESS.toString(),
							LegalEntityImportCSVColumn.MUNICIPALITY_POSTAL_CODE.toString(),
							LegalEntityImportCSVColumn.MUNICIPALITY_CITY.toString(),
							LegalEntityImportCSVColumn.MUNICIPALITY_COUNTRY_CODE.toString(),
							LegalEntityImportCSVColumn.MUNICIPALITY_LANGUAGE_CODE.toString(),
							LegalEntityImportCSVColumn.MUNICIPALITY_REGISTRATION_NUMBER.toString(),
							LegalEntityImportCSVColumn.MUNICIPALITY_FEL_ID.toString(),
							LegalEntityImportCSVColumn.MUNICIPALITY_ABAC_STATUS.toString()
					));

			for (LegalEntity legalEntity : legalEntities) {
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
			}

			csvPrinter.flush();
			return stream.toString();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
