package wifi4eu.wifi4eu.service.grantAgreement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.URL;
import java.util.List;

@Service
public class GrantAgreementService {


    @Autowired
    ApplicationService applicationService;

    @Autowired
    GrantAgreementRepository agreementRepository;

    public GrantAgreement createGrantAgreement(GrantAgreement inputGrantAgreement){
        return agreementRepository.save(inputGrantAgreement);
    }

    public GrantAgreement getGrantAgreementByApplicationId(Integer applicationId){
        return agreementRepository.findByApplicationId(applicationId);
    }

    public GrantAgreement getGrantAgreementById(Integer id){
        return agreementRepository.findOne(id);
    }

    public GrantAgreement initializeGrantAgreement(Integer applicationId){
        GrantAgreement grantAgreement = new GrantAgreement();
        grantAgreement.setApplicationId(applicationId);
        return createGrantAgreement(grantAgreement);
    }

    public ByteArrayOutputStream generateGrantAgreementPdf(Integer applicationId, GrantAgreement grantAgreement) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        PdfStamper stamper = null;
//        PdfReader pdfReader = null;
        try {

            ApplicationDTO applicationDTO = applicationService.getApplicationById(applicationId);

            //URL url = getClass().getResource("/grant_agreement_template.pdf");

            XWPFDocument document = new XWPFDocument(Data.class.getResourceAsStream("/grant_agreement_template.docx"));
            for (XWPFHeader h: document.getHeaderList()){
                XWPFHeader header = h;
            }
            for (XWPFParagraph p : document.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("needle")) {
                            //text = text.replace("needle", "haystack");
                            //r.setText(text, 0);
                        }
                    }
                }
            }



            return outputStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }  finally {
//            if(stamper != null){
//                stamper.close();
//
//            }
//            if(pdfReader != null){
//                pdfReader.close();
//            }
//            outputStream.close();
        }
//        byte[] base64 = Base64.encodeBase64(outputStream.toByteArray());

//        GrantAgreement grantAgreement = new GrantAgreement();
//        grantAgreement.setApplicationId(applicationId);
//        grantAgreement.setDocument_location(new String(base64));
//        createGrantAgreement(grantAgreement);

    }

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
