package wifi4eu.wifi4eu.abac.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wifi4eu.wifi4eu.abac.entity.LegalEntity;

/**
 * Parser to convert from CSV file to a LegalEntity (mocked)
 * 
 */
public final class ParserCSV2LegalEntityMock {

	private final Logger log = LoggerFactory.getLogger(ParserCSV2LegalEntityMock.class);

	private static final String CHAR_SEPARATOR = "\\|";

	/**
	 * Parse CSV file bytes into an Entity, the expected separator symbol is '|'.
	 * 
	 * Example of CSV input content:
	 * 
	 * <pre>
	 *  
	 * id|mid|languageCode|countryCode|region|officialAddress|officialAddressStrNo|postalCode|
	 * 1|123|eng|GB|London|London Wall|34|EC2M 5QX
	 * 2|234|spa|ES|Castellón|Plaza mayor|5|12540
	 * </pre>
	 * 
	 * @param inputCSV
	 *            content of the CSV file
	 * @param t
	 *            class of the entity
	 * @return list of entities
	 */
	public List<LegalEntity> parseCSV2Entity(byte[] inputCSV) {
		List<LegalEntity> result = new LinkedList<LegalEntity>();
		String[] columnNames = null;
		boolean isColumnNames = true;

		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new ByteArrayInputStream(inputCSV), StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					String[] attributes = line.split(CHAR_SEPARATOR);
					if (isColumnNames) {
						columnNames = attributes;
						isColumnNames = false;
					} else {
						LegalEntity newInstance = new LegalEntity();
						for (int i = 0; i < columnNames.length; i++) {
							if (attributes[i] != null) {
								switch (columnNames[i]) {
								case "id":
									log.info("id found, assigning to mid:" + attributes[i]);
									newInstance.setMid(new Long(attributes[i]));
									break;
								case "mun_OfficialName":
									log.info("mun_OfficialName found, assigning to officialName:" + attributes[i]);
									newInstance.setOfficialName(attributes[i]);
									break;
								case "mun_OfficialAddress":
									log.info(
											"mun_OfficialAddress found, assigning to officialAddress:" + attributes[i]);
									newInstance.setOfficialAddress(attributes[i]);
									break;
								case "reg_RegistartionNumber":
									log.info("reg_RegistartionNumber found, assigning to registrationNumber:"
											+ attributes[i]);
									newInstance.setRegistrationNumber(new Long(attributes[i]));
									break;
								default:
									log.info("Skipping column: " + columnNames[i]);
									break;
								}
							}
						}
						if (newInstance.getCountryCode() == null || newInstance.getCountryCode().isEmpty()) {
							newInstance.setCountryCode("ES");
						}
						if (newInstance.getPostalCode() == null || newInstance.getPostalCode().isEmpty()) {
							newInstance.setPostalCode("01010");
						}
						if (newInstance.getLanguageCode() == null || newInstance.getLanguageCode().isEmpty()) {
							newInstance.setLanguageCode("eng");
						}
						result.add(newInstance);
					}
				}
			}
		} catch (IOException ex) {
			log.error("Error parsing the CSV content (IO): " + ex.getMessage(), ex);
		}
		return result;
	}

}
