package wifi4eu.wifi4eu.common.helper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Parser to convert from JSON file to CSV file
 * 
 */
public final class ParserJSON2CSV {

	// Private constructor so no instances are created
	private ParserJSON2CSV() {

	}

	/**
	 * Prepare an skeleton of the file content with the headers
	 * 
	 * @param headers
	 * @return
	 */
	private static StringBuilder generateHeaders(String[] headers) {
		String separator = ",";
		StringBuilder msg = new StringBuilder();

		for (int i = 0; i < headers.length; i++) {
			if (i != 0) {
				msg.append(separator);
			}
			msg.append(headers[i]);
		}
		msg.append("\n");
		return msg;
	}

	/**
	 * Add a row of values, applying the same order of the headers to the values
	 * 
	 * @param msg
	 * @param values
	 */
	private static void addValues(StringBuilder msg, String[] values) {
		String separator = ",";

		for (int i = 0; i < values.length; i++) {
			if (i != 0) {
				msg.append(separator);
			}
			msg.append(values[i]);
		}
		msg.append("\n");
	}

	/**
	 * Parse JSON content into CSV content
	 * 
	 * Example of JSON input content (it will require setting the mainNode to value
	 * "beneficiaryInformation", and the headers {"id", "mun_OfficialName",
	 * "mun_OfficialAddress", "reg_RegistartionNumber"}):
	 * <p>
	 * [{"beneficiaryInformation":
	 * [{"id":"1","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"6"},{"id":"2","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"7"},{"id":"3","mun_OfficialName":"Madrid","mun_OfficialAddress":"C\\Bravo
	 * Murillo","reg_RegistartionNumber":"8"},{"id":"4","mun_OfficialName":"Bruxelles","mun_OfficialAddress":"Rue
	 * Montoyer","reg_RegistartionNumber":"9"}]}]
	 * </p>
	 * 
	 * Example of JSON input content (it will require setting the mainNode to null
	 * or empty value, and the headers {"id", "mun_OfficialName",
	 * "mun_OfficialAddress", "reg_RegistartionNumber"}):
	 * <p>
	 * [{"id":"1","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"6"},{"id":"2","mun_OfficialName":"Barcelona","mun_OfficialAddress":"C\\Aragón","reg_RegistartionNumber":"7"},{"id":"3","mun_OfficialName":"Madrid","mun_OfficialAddress":"C\\Bravo
	 * Murillo","reg_RegistartionNumber":"8"},{"id":"4","mun_OfficialName":"Bruxelles","mun_OfficialAddress":"Rue
	 * Montoyer","reg_RegistartionNumber":"9"}]
	 * </p>
	 * 
	 * Example of CSV output content:
	 * <p>
	 * id,mun_OfficialName,mun_OfficialAddress,reg_RegistartionNumber
	 * 1,Barcelona,C\\Aragón,6 2,Barcelona,C\\Aragón,7 3,Madrid,C\\Bravo Murillo,8
	 * 4,Bruxelles,Rue Montoyer,9
	 * </p>
	 * 
	 * 
	 * @param inputJSON
	 *            content of the JSON file
	 * @param mainNode
	 *            optional, if specified, it will read the json node with that name
	 *            and the json content as input value
	 * @param headers
	 *            required to indicate the headers of the CSV file
	 * @return
	 */
	public static String parseJSON2CSV(String inputJSON, String mainNode, String[] headers) {
		StringBuilder result = generateHeaders(headers);

		JsonArray array = ((JsonArray) new JsonParser().parse(inputJSON));

		if (mainNode != null && !mainNode.isEmpty()) {
			JsonObject object = array.get(0).getAsJsonObject();
			JsonElement element = object.get(mainNode);
			array = element.getAsJsonArray();
		}

		for (JsonElement item : array) {
			String[] values = new String[headers.length];

			for (int i = 0; i < headers.length; i++) {
				JsonElement element = item.getAsJsonObject().get(headers[i]);
				if (element != null && !element.isJsonNull()) {
					values[i] = element.getAsString();
				}
			}

			addValues(result, values);
		}

		return result.toString();
	}
}
