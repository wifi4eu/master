package wifi4eu.wifi4eu.common.helper;

/**
 * Parser to convert from CSV file to JSON file
 *  
 */
public final class ParserCSV2JSON {

	// Private constructor so no instances are created
	private ParserCSV2JSON() {
		
	}
	
	/**
	 * Parse CSV content into JSON content
	 * 
	 * Example of CSV input content:
	 * <p>
	 * id,mun_OfficialName,mun_OfficialAddress,reg_RegistartionNumber
	 * 1,Barcelona,C\\Aragón,6
	 * 2,Barcelona,C\\Aragón,7
	 * 3,Madrid,C\\Bravo Murillo,8
	 * 4,Bruxelles,Rue Montoyer,9
	 * </p>
	 * 
	 * Example of JSON output content (setting the mainNode to value "beneficiaryInformation"):
	 * <p>
	 * [{"beneficiaryInformation": [{"id":"1","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"6"},{"id":"2","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"7"},{"id":"3","mun_OfficialName":"Madrid","mun_OfficialAddress":"C\\Bravo Murillo","reg_RegistartionNumber":"8"},{"id":"4","mun_OfficialName":"Bruxelles","mun_OfficialAddress":"Rue Montoyer","reg_RegistartionNumber":"9"}]}]
	 * </p>
	 * 
	 * Example of JSON output content (setting the mainNode to null or empty value):
	 * <p>
	 * [{"id":"1","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"6"},{"id":"2","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"7"},{"id":"3","mun_OfficialName":"Madrid","mun_OfficialAddress":"C\\Bravo Murillo","reg_RegistartionNumber":"8"},{"id":"4","mun_OfficialName":"Bruxelles","mun_OfficialAddress":"Rue Montoyer","reg_RegistartionNumber":"9"}]
	 * </p>
	 * 
	 * @param inputCSV	content of the CSV file
	 * @param mainNode	optional, if specified, it will create a json node with that name and the json content as value
	 * @return
	 */
	public static String parseCSV2JSON(String inputCSV, String mainNode) {
		String charSeparator = ",";
		String charNewLine = "\r\n";

		String[] lines = inputCSV.split(charNewLine);
		StringBuilder result = new StringBuilder();
		result.append('[');
		String[] headers = new String[0];

		// CSV TO JSON
		for (int i = 0; i < lines.length; i++) {
			String[] values = lines[i].replaceAll("\"", "").replaceAll(charNewLine, "").split(charSeparator);

			// INDEX LIST
			if (i == 0) {
				headers = values;
			} else {
				result.append('{');
				for (int j = 0; j < values.length && j < headers.length; j++) {

					String jsonvalue = "\"" + headers[j] + "\":\"" + values[j] + "\"";
					if (j != values.length - 1) { // if not last value of values...
						jsonvalue += charSeparator;
					}
					result.append(jsonvalue);
				}
				result.append('}');
				if (i != lines.length - 1) {
					result.append(charSeparator);
				}
			}
		}
		result.append(']');
		
		if (mainNode != null && !mainNode.isEmpty()) {
			return "[{\""+mainNode+"\": "+result.toString()+"}]";
		}

		return result.toString();
	}
}
