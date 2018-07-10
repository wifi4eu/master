package wifi4eu.wifi4eu.common.helper;

/**
 * Parser to convert from CSV file to JSON file
 * 
 */
public final class ParserCSV2JSON {

	private static final String CHAR_SEPARATOR = ",";
	private static final String EMPTY_VALUE = "";
	private static final String CHAR_NEW_LINE = "\r\n";

	// Private constructor so no instances are created
	private ParserCSV2JSON() {

	}

	/**
	 * Replace "," and """ for the comma symbol (,) and the quote symbol (")
	 * respectively.
	 * 
	 * @param originalValue
	 * @return
	 */
	private static String escapeSymbols(String originalValue) {
		if (originalValue != null && !originalValue.isEmpty()) {
			if (originalValue.startsWith("\"\"\"")) {
				// Skip the first 3 quotes and add a escaped one
				originalValue = "\"" + originalValue.substring(3,  originalValue.length());
				if (originalValue.endsWith("\"\"\"")) {
					// Skip the last 3 quotes and add a escaped one
					originalValue = originalValue.substring(0, originalValue.length() - 3) + "\"";
				}
			} else if (originalValue.startsWith("\"")) {
				// Skip the first quote
				originalValue = originalValue.substring(1,  originalValue.length());
				if (originalValue.endsWith("\"")) {
					// Skip the last quotes
					originalValue = originalValue.substring(0, originalValue.length() - 1);
				}
			}
			// Escape the (")
			originalValue = originalValue.replaceAll("\"", "\\\\\"");
			// Escape the (,)
			originalValue = originalValue.replaceAll("\"" + CHAR_SEPARATOR + "\"", CHAR_SEPARATOR);
		}
		return originalValue;
	}

	/**
	 * Check if the value starts with (") but doesn't ends with (")
	 * 
	 * @param originalValue
	 * @return
	 */
	private static boolean isStartingQuotedValue(String originalValue) {
		return (originalValue != null && !originalValue.isEmpty() && originalValue.startsWith("\"") && !originalValue.endsWith("\""));
	}
	
	private static boolean isEndingQuotedValue(String originalValue) {
		return (originalValue != null && !originalValue.isEmpty() && !originalValue.startsWith("\"") && originalValue.endsWith("\""));
	}

	/**
	 * Parse CSV content into JSON content
	 * 
	 * Example of CSV input content:
	 * 
	 * <pre>
	 * id,mun_OfficialName,mun_OfficialAddress,reg_RegistartionNumber
	 * 1,Barcelona,C\\Aragón,6
	 * 2,Barcelona,C\\Aragón,7
	 * 3,Madrid,C\\Bravo Murillo,8
	 * 4,Bruxelles,Rue Montoyer,9
	 * </pre>
	 * 
	 * Example of JSON output content (setting the mainNode to value
	 * "beneficiaryInformation"):
	 * 
	 * <pre>
	 * [{"beneficiaryInformation": [{"id":"1","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"6"},{"id":"2","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"7"},{"id":"3","mun_OfficialName":"Madrid","mun_OfficialAddress":"C\\Bravo Murillo","reg_RegistartionNumber":"8"},{"id":"4","mun_OfficialName":"Bruxelles","mun_OfficialAddress":"Rue Montoyer","reg_RegistartionNumber":"9"}]}]
	 * </pre>
	 * 
	 * Example of JSON output content (setting the mainNode to null or empty value):
	 * 
	 * <pre>
	 * [{"id":"1","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"6"},{"id":"2","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"7"},{"id":"3","mun_OfficialName":"Madrid","mun_OfficialAddress":"C\\Bravo Murillo","reg_RegistartionNumber":"8"},{"id":"4","mun_OfficialName":"Bruxelles","mun_OfficialAddress":"Rue Montoyer","reg_RegistartionNumber":"9"}]
	 * </pre>
	 * 
	 * Note: the comma symbol (,) and the quote symbol (") are expected to be
	 * escaped by """ and "," respectively.
	 * 
	 * 
	 * @param inputCSV
	 *            content of the CSV file
	 * @param mainNode
	 *            optional, if specified, it will create a json node with that name
	 *            and the json content as value
	 * @return
	 */
	public static String parseCSV2JSON(String inputCSV, String mainNode) {
		String[] lines = inputCSV.split(CHAR_NEW_LINE);
		StringBuilder result = new StringBuilder();
		result.append('[');
		String[] headers = new String[0];

		// CSV TO JSON
		for (int i = 0; i < lines.length; i++) {
			String[] values = lines[i].replaceAll(CHAR_NEW_LINE, EMPTY_VALUE).split(CHAR_SEPARATOR);

			// INDEX LIST
			if (i == 0) {
				headers = values;
			} else {
				result.append('{');
				String value = null;
				String jsonvalue = null;
				String addPreviousValue = null;
				
				// There is an exception when the input is like: 
				// 6,Frontignan,"Place de l'Hôtel de ville, 2",,6
				// It should be splitted as: 
				// [6] [Frontignan] [Place de l'Hôtel de ville, 2] [] [6]
				// So we split by (,) character and check if the first character is ("), 
				// then we concatenate the value to the next item
				// So we need to control the index of the values and the index of the headers
				for (int indexValues = 0, indexHeaders = 0; indexValues < values.length && indexHeaders < headers.length; indexValues++, indexHeaders++) {
					if (isStartingQuotedValue(values[indexValues])) {
						// Save the value for the next item
						addPreviousValue = values[indexValues];
						// The header shouldn't advance
						indexHeaders--;
					} else if (addPreviousValue != null && !addPreviousValue.isEmpty() && !isEndingQuotedValue(values[indexValues])) {
						// Save the value for the next item
						addPreviousValue = addPreviousValue + values[indexValues];
						// The header shouldn't advance
						indexHeaders--;
					} else {
						if (addPreviousValue != null) {
							// Add previous value if exists, and clean it
							value = escapeSymbols(addPreviousValue + CHAR_SEPARATOR + values[indexValues]);
							addPreviousValue = null;
						} else {
							value = escapeSymbols(values[indexValues]);
						}
						jsonvalue = "\"" + headers[indexHeaders] + "\":\"" + value + "\"";
						if (indexValues != values.length - 1) { 
							// If not last value of values...
							jsonvalue += CHAR_SEPARATOR;
						}
						result.append(jsonvalue);
					}
				}
				result.append('}');
				if (i != lines.length - 1) {
					result.append(CHAR_SEPARATOR);
				}
			}
		}
		result.append(']');

		if (mainNode != null && !mainNode.isEmpty()) {
			return "[{\"" + mainNode + "\": " + result.toString() + "}]";
		}

		return result.toString();
	}
}
