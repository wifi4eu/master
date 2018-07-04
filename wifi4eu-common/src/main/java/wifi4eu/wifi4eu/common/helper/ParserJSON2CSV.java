package wifi4eu.wifi4eu.common.helper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public final class ParserJSON2CSV {

	// Private constructor so no instances are created
	private ParserJSON2CSV() {

	}

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
				values[i] = item.getAsJsonObject().get(headers[i]).getAsString();
			}

			addValues(result, values);
		}

		return result.toString();
	}
}
