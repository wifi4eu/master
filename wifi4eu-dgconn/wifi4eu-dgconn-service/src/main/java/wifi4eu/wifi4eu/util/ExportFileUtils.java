package wifi4eu.wifi4eu.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import wifi4eu.wifi4eu.entity.exportImport.ExportFile;
import wifi4eu.wifi4eu.service.exportImport.ExportImportWifi4euAbacService;

@Service
public class ExportFileUtils {

	public static final String SEPARATOR = ",";
	public static final String QUOTE = "\"";

	private final Logger log = LoggerFactory.getLogger(ExportImportWifi4euAbacService.class);

	public final String[] csvDocumentHeaders = new String[] { "mun_id", "doc_portalId", "doc_name", "doc_fileName",
			"doc_mimeType", "doc_date", "doc_type" };

	public final String[] csvMunicipalitiesHeaders = new String[] { "mun_id", "mun_name", "mun_address",
			"mun_postalCode", "mun_city", "mun_countryCodeISO", "mun_languageCodeISO", "mun_registrationNumber" };

	public ByteArrayOutputStream generateZipFileStream(List<ExportFile> includedExportFiles) {
		if (includedExportFiles == null || includedExportFiles.size() == 0) {
			log.error("Invalid parameters - generateZipFile");
			return new ByteArrayOutputStream();
		}

		// -- Creating a zip
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (ZipOutputStream zos = new ZipOutputStream(baos)) {

			for (ExportFile exportFile : includedExportFiles) {
				ZipEntry entry = new ZipEntry(exportFile.getFilename());
				zos.putNextEntry(entry);
				zos.write(exportFile.getData());
				zos.closeEntry();
			}
		} catch (IOException ex) {
			log.error("Could not generate a zip file", ex);
		}

		return baos;
	}

	/**
	 * Generates the headers for the CSV file according to the String[] provided.
	 * 
	 * @return
	 */
	public String generateCSVHeaders(String[] headers) {
		StringBuilder headerData = new StringBuilder();

		boolean first = true;
		for (String header : headers) {
			if (first) {
				headerData.append(header);
				first = false;
			} else {
				headerData.append(SEPARATOR).append(header);
			}
		}

		return headerData.toString();
	}

	/**
	 * Generate a dummy pdf file to export. Dummy values just for test.
	 * 
	 * @return
	 */
	public ExportFile generateDummyPDFFile(String id, String name) throws DocumentException {
		// -- PDF i
		Document document = new Document();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, outputStream);
		document.open();
		document.addTitle(name);
		document.addSubject(name);
		document.add(new Paragraph(name));
		document.close();

		String filename = name + "-" + id + ".pdf";

		return new ExportFile(filename, outputStream.toByteArray());
	}

	/**
	 * Generate a dummy csv file with the municipalities to export. Dummy values
	 * just for test.
	 * 
	 * @return
	 */
	public String generateDummyCSVMunicipalities() {
		StringBuilder data = new StringBuilder();
		data.append(
				"mund_id,mun_name,mun_address,mun_postalCode,mun_city,mun_countryCodeISO,mun_languageCodeISO,mun_registrationNumber");
		data.append("\r\n");
		data.append("123,entity123,London Wall 34,EC2M 5QX,London,GB,eng,10123");
		data.append("\r\n");
		data.append("456,entity456,London Wall 40,EC2M 5QX,London,GB,eng,10133");
		data.append("\r\n");

		return data.toString();
	}

	/**
	 * Generate a dummy csv file with the documents to export. Dummy values just for
	 * test.
	 * 
	 * @return
	 */
	public String generateDummyCSVDocuments() {
		StringBuilder data = new StringBuilder();
		data.append("mun_id,doc_portalId,doc_name,doc_fileName,doc_mimeType,doc_date,doc_type");
		data.append("\r\n");
		data.append("123,321,Identification Form,document-321.pdf,application/pdf,")
				.append(Calendar.getInstance().getTime()).append(",MUNICIPALITY_ID_FORM");
		data.append("\r\n");
		data.append("456,654,Identification Form,document-654.pdf,application/pdf,")
				.append(Calendar.getInstance().getTime()).append(",MUNICIPALITY_ID_FORM");
		data.append("\r\n");

		return data.toString();
	}
}
