package wifi4eu.wifi4eu.util;

import java.io.*;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.pdf.PdfWriter;
import fr.opensagres.xdocreport.itext.extension.IPdfWriterConfiguration;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.PositionInParagraph;
import org.apache.poi.xwpf.usermodel.TextSegement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ParametrizedDocConverter {

    public static ByteArrayOutputStream convert(byte[] byteData, Map<String, String> replacementsMap)
            throws FileNotFoundException, InvalidFormatException, IOException, Exception {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        XWPFDocument doc = new XWPFDocument(new ByteArrayInputStream(byteData));

        doc = replacePOI(doc, replacementsMap);

        outputStream = convertDocToPDF(doc, outputStream);
        doc.close();
        outputStream.close();
        return outputStream;
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

    private static ByteArrayOutputStream convertDocToPDF(XWPFDocument doc, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        try {
            PdfOptions options = PdfOptions.create();
            PdfConverter.getInstance().convert(doc, byteArrayOutputStream, options);
            return byteArrayOutputStream;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
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