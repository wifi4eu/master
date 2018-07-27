package wifi4eu.wifi4eu.service.grantAgreement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class GrantAgreementService {

    public ByteArrayOutputStream downloadGrantAgreementPdf() {
        ByteArrayOutputStream outputStream = null;
        try {
            Document document = new Document();
            outputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            String docName = "Grant Agreement PDF";
            document.addTitle(docName);
            document.addSubject(docName);
            document.add(new Paragraph(docName));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

}
