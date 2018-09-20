package wifi4eu.wifi4eu.util;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParametrizedDocConverter {
	private static final Logger _log = LogManager.getLogger(ParametrizedDocConverter.class);

	private ParametrizedDocConverter() {
		// Private constructor
	}
	
	/**
	 * Used to securely close streams
	 * 
	 * @param s
	 */
	private static void closeStream(Closeable s) {
	    try {
	        if (s!=null) {
	        	s.close();
	        }
	    } catch (IOException e) {
	    	// Ignore it
	    	_log.warn("Couldn't close stream", e.getMessage());
	    }
	}

	public static ByteArrayOutputStream convert(byte[] byteData, Map<String, String> replacementsMap) {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			outputStream = replaceWithPdfForm(byteData, outputStream, replacementsMap);
		} catch (IOException e1) {
			_log.error("IO error", e1);
		} finally {
			closeStream(outputStream);
		}

		return outputStream;
	}

	public static ByteArrayOutputStream replaceWithPdfForm(byte[] data, ByteArrayOutputStream outputStream,
			Map<String, String> replacementsMap) throws IOException {
		
		PdfStamper stamper = null;
		
		try {
			PdfReader reader = new PdfReader(data);
			stamper = new PdfStamper(reader, outputStream);
			AcroFields fields = stamper.getAcroFields();
			
			for (Map.Entry<String, String> replPair : replacementsMap.entrySet()) {
				String find = replPair.getKey();
				String repl = replPair.getValue();
				setFieldValue(fields, find, repl, reader);
			}
		} catch (DocumentException e1) {
			_log.error("Document error", e1);
		} catch (IOException e) {
			_log.error("IO error", e);
			throw e;
		} finally {
			if (stamper != null) {
				try {
					stamper.close();
				} catch (DocumentException e) {
			    	// Ignore it
			    	_log.warn("Couldn't close PdfStamper", e.getMessage());					
				}
			}
		}

		return outputStream;
	}
	
	private static void setFieldValue(AcroFields fields, String find, String repl, PdfReader reader) {
		try {
			if (find.equalsIgnoreCase("field1") || find.equalsIgnoreCase("field-action")) {
				BaseFont baseFontBold = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.EMBEDDED);
				fields.setFieldProperty(find, "textfont", baseFontBold, null);
			}
			else {
                InputStream inputStream =  ParametrizedDocConverter.class.getClassLoader().getResourceAsStream("times.ttf");
                byte[] bytes = IOUtils.toByteArray(inputStream);
                BaseFont fontTimesNewRoman = BaseFont.createFont("times.ttf", BaseFont.IDENTITY_H,BaseFont.EMBEDDED,true, bytes,null);
                fontTimesNewRoman.setSubset(true);
                fields.setFieldProperty(find, "textfont", fontTimesNewRoman, null);
                if(inputStream!=null) inputStream.close();
			}

			if (find.equalsIgnoreCase("header")) {
				fields.setFieldProperty(find, "textsize", new Float(9), null);
			} else {
				fields.setFieldProperty(find, "textsize", new Float(12), null);
			}
			
			fields.setField(find, repl);
		} catch (DocumentException e1) {
			_log.error("Field not found", e1);
		} catch (IOException e) {
			_log.error("IO error", e);
		}
	}
	
	private static XWPFDocument replacePOI(XWPFDocument doc, Map<String, String> replacementsMap) {
		// REPLACE ALL HEADERS
		for (XWPFHeader header : doc.getHeaderList()) {
			replaceAllBodyElements(header.getBodyElements(), replacementsMap);
		}
		// REPLACE BODY
		replaceAllBodyElements(doc.getBodyElements(), replacementsMap);
		return doc;
	}

	private static void replaceAllBodyElements(List<IBodyElement> bodyElements, Map<String, String> replacementsMap) {
		for (IBodyElement bodyElement : bodyElements) {
			if (bodyElement.getElementType().compareTo(BodyElementType.PARAGRAPH) == 0)
				replaceParagraph((XWPFParagraph) bodyElement, replacementsMap);
			if (bodyElement.getElementType().compareTo(BodyElementType.TABLE) == 0)
				replaceTable((XWPFTable) bodyElement, replacementsMap);
		}
	}

	private static void replaceTable(XWPFTable table, Map<String, String> replacementsMap) {
		for (XWPFTableRow row : table.getRows()) {
			for (XWPFTableCell cell : row.getTableCells()) {
				for (IBodyElement bodyElement : cell.getBodyElements()) {
					if (bodyElement.getElementType().compareTo(BodyElementType.PARAGRAPH) == 0) {
						replaceParagraph((XWPFParagraph) bodyElement, replacementsMap);
					}
					if (bodyElement.getElementType().compareTo(BodyElementType.TABLE) == 0) {
						replaceTable((XWPFTable) bodyElement, replacementsMap);
					}
				}
			}
		}
	}

	private static void replaceParagraph(XWPFParagraph paragraph, Map<String, String> replacementsMap) {

		List<XWPFRun> runs = paragraph.getRuns();
		for (Map.Entry<String, String> replPair : replacementsMap.entrySet()) {
			String find = replPair.getKey();
			String repl = replPair.getValue();
			TextSegement found = paragraph.searchText(find, new PositionInParagraph());
			if (found != null) {
				if (found.getBeginRun() == found.getEndRun()) {
					// whole search string is in one Run
					XWPFRun run = runs.get(found.getBeginRun());
					String runText = run.getText(run.getTextPosition());
					String replaced = runText.replace(find, repl);
					run.setText(replaced, 0);
				} else {
					// The search string spans over more than one Run
					// Put the Strings together
					StringBuilder b = new StringBuilder();
					for (int runPos = found.getBeginRun(); runPos <= found.getEndRun(); runPos++) {
						XWPFRun run = runs.get(runPos);
						b.append(run.getText(run.getTextPosition()));
					}
					String connectedRuns = b.toString();
					String replaced = connectedRuns.replace(find, repl);

					// The first Run receives the replaced String of all connected Runs
					XWPFRun partOne = runs.get(found.getBeginRun());
					partOne.setText(replaced, 0);
					// Removing the text in the other Runs.
					for (int runPos = found.getBeginRun() + 1; runPos <= found.getEndRun(); runPos++) {
						XWPFRun partNext = runs.get(runPos);
						partNext.setText("", 0);
					}
				}
			}
		}
	}

	private static ByteArrayOutputStream convertDocToPDF(XWPFDocument doc, ByteArrayOutputStream byteArrayOutputStream)
			throws IOException {
		try {
			PdfOptions options = PdfOptions.create();
			PdfConverter.getInstance().convert(doc, byteArrayOutputStream, options);
			return byteArrayOutputStream;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			byteArrayOutputStream.close();
		}
	}

	private static void saveWord(String filePath, XWPFDocument doc) throws FileNotFoundException, IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			doc.write(out);
		} finally {
			out.close();
		}
	}
}