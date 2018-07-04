package wifi4eu.wifi4eu.common.helper;


public final class ParserCSV2JSON {

	// Private constructor so no instances are created
	private ParserCSV2JSON() {
		
	}
	
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
