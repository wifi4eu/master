package wifi4eu.wifi4eu.abac.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.LegalEntityImportCSVColumn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVFileParser {

	public List<LegalEntity> parseLegalEntityInformationFile(FileDTO fileDTO) {

		List<LegalEntity> legalEntities = new ArrayList<>();

		Reader reader = new StringReader(new String(fileDTO.getContent()));

		try (CSVParser csvParser = new org.apache.commons.csv.CSVParser(reader, CSVFormat.DEFAULT
				.withFirstRecordAsHeader()
				.withIgnoreHeaderCase()
				.withTrim())) {

			for (CSVRecord csvRecord : csvParser) {
				LegalEntity legalEntity = mapLegalEntity(csvRecord);
				legalEntities.add(legalEntity);
			}

		} catch (IOException exception) {
			exception.printStackTrace();
		}

		return legalEntities;
	}

	private LegalEntity mapLegalEntity(CSVRecord csvRecord) {
		LegalEntity legalEntity = new LegalEntity();

		legalEntity.setMid(Long.parseLong(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_PORTAL_ID)));
		legalEntity.setOfficialName(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_NAME));
		legalEntity.setOfficialAddress(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_ADDRESS));
		legalEntity.setPostalCode(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_POSTAL_CODE));
		legalEntity.setCity(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_CITY));
		legalEntity.setCountryCode(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_COUNTRY_CODE));
		legalEntity.setLanguageCode(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_LANGUAGE_CODE));
		legalEntity.setRegistrationNumber(Long.parseLong(csvRecord.get(LegalEntityImportCSVColumn.MUNICIPALITY_REGISTRATION_NUMBER)));

		return legalEntity;
	}

	public List<LegalEntity> parseLegalEntityDocumentsFile(FileDTO fileDTO) {
		return new ArrayList<LegalEntity>();
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