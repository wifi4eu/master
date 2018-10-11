package wifi4eu.wifi4eu.abac.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import wifi4eu.wifi4eu.abac.data.Constants;

public class CSVStringCreator{

	private ByteArrayOutputStream stream;
	private CSVPrinter csvPrinter;
	
	public CSVStringCreator(CSVFormat csvFormat) throws IOException {
		this.stream = new ByteArrayOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(this.stream, Constants.CSV_FILES_ENCODING);
		this.csvPrinter = new CSVPrinter(writer, csvFormat);
	}
	
	public void printRecord(final Object... values) throws IOException {
		this.csvPrinter.printRecord(values);
	}
	
	public String closeAndGenerateString() throws IOException {
		csvPrinter.flush();
		csvPrinter.close();
		String result = new String(Constants.CSV_FILES_BOM.getBytes(), Constants.CSV_FILES_ENCODING) + stream.toString(Constants.CSV_FILES_ENCODING.name());
		return result;
	}
}
