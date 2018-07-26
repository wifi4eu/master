package wifi4eu.wifi4eu.service.grantAgreement;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;

import java.io.*;

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

    public ByteArrayOutputStream generateGrantAgreementPdf(Integer applicationId, GrantAgreement grantAgreement, String signString) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfStamper pdfStamper = null;
        PdfReader pdfReader = null;
        try {

            ApplicationDTO applicationDTO = applicationService.getApplicationById(applicationId);

            pdfReader = new PdfReader("C:\\grant_agreement_template.pdf");
            pdfStamper = new PdfStamper(pdfReader, outputStream);

            BaseFont baseFont = BaseFont.createFont(
                    BaseFont.TIMES_ROMAN,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);


            int pages = pdfReader.getNumberOfPages();

            for(int i=1; i<=pages; i++) {
                //Contain the pdf data.
                if(i == pages){
                    PdfContentByte pageContentByte =
                            pdfStamper.getOverContent(i);

                    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, "Cp1252", BaseFont.EMBEDDED);
                    Font f = new Font(bf, 8);
                    ColumnText ct = new ColumnText(pageContentByte);
                    ct.setSimpleColumn(74, 0, pdfReader.getPageSize(i).getWidth() / 2, 400f);
                    ct.addElement(new Paragraph (signString, f));
                    ct.go();
                }
            }

            return outputStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }  finally {
            if(pdfStamper != null){
                pdfStamper.close();
            }
            if(pdfReader != null){
                pdfReader.close();
            }
            outputStream.close();
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
