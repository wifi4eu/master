package wifi4eu.wifi4eu.abac.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser to convert from CSV file to an Entity
 * 
 */
public final class ParserCSV2Entity<T> {

	private final Logger log = LoggerFactory.getLogger(ParserCSV2Entity.class);

	private static final String CHAR_SEPARATOR = "\\|";

	/**
	 * Parse CSV file bytes into an Entity, the expected separator symbol is '|'.
	 * 
	 * Example of CSV input content:
	 * 
	 * <pre>
	 * id|LANG|Name1|Name2|NAME|Region|Country|Code|Address|Nr|PostalCode
	 * 1|en|Buje|Buje|BUJE|Istarska županija|HRVATSKA|HR|Istarska |2|52460
	 * 2|es|Vila-real|Vila-real|VILA-REAL|Castellón / Castelló|ESPAÑA|ES|Plaza Mayor|1|12540
	 * </pre>
	 * 
	 * @param inputCSV
	 *            content of the CSV file
	 * @param t
	 *            class of the entity
	 * @return list of entities
	 */
	public List<T> parseCSV2Entity(byte[] inputCSV, Class<T> t) {
		List<T> result = new LinkedList<>();
		String[] columnNames = null;
		boolean isColumnNames = true;

		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new ByteArrayInputStream(inputCSV), StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] attributes = line.split(CHAR_SEPARATOR);
				if (isColumnNames) {
					columnNames = attributes;
					isColumnNames = false;
				} else {
					T newInstance = t.newInstance();
					Field[] fields = t.getDeclaredFields();
					for (Field field : fields) {
						for (int i = 0; i < columnNames.length; i++) {
							if (field.getName().equalsIgnoreCase(columnNames[i])) {
								field.setAccessible(true);
								Object value = getValue(field, attributes[i]);
								field.set(newInstance, value);
							}
						}
					}
					result.add(newInstance);
				}
			}
		} catch (InstantiationException ex) {
			log.error("Error parsing the CSV content (instantiation): " + ex.getMessage(), ex);
		} catch (IllegalAccessException ex) {
			log.error("Error parsing the CSV content (illegal access): " + ex.getMessage(), ex);
		} catch (IOException ex) {
			log.error("Error parsing the CSV content (IO): " + ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Adapts the value to the attribute class.
	 * 
	 * @param field
	 * @param value
	 * @return
	 */
	private Object getValue(Field field, String value) {
		if (field.getClass().isArray()) {
			log.warn("No support for arrays");
			return null;
		} else if (String.class.isAssignableFrom(field.getType())) {
			return value;
		} else if (Integer.class.isAssignableFrom(field.getType())) {
			return new Integer(value);
		} else {
			log.warn("Class not supported: " + field.getType());
			return null;
		}
	}
}