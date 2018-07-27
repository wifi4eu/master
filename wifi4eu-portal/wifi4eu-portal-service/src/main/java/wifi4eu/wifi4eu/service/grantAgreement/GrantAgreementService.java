package wifi4eu.wifi4eu.service.grantAgreement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.mapper.grantAgreement.GrantAgreementMapper;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;

import java.io.*;

@Service
public class GrantAgreementService {


    @Autowired
    ApplicationService applicationService;

    @Autowired
    GrantAgreementRepository agreementRepository;

    @Autowired
    GrantAgreementMapper grantAgreementMapper;

    public GrantAgreementDTO createGrantAgreement(GrantAgreementDTO inputGrantAgreement) {
        GrantAgreementDTO grantAgreementDTO = getGrantAgreementByApplicationId(inputGrantAgreement.getApplicationId());
        if (grantAgreementDTO != null) {
            grantAgreementDTO.setDocumentLanguage(inputGrantAgreement.getDocumentLanguage());
            return grantAgreementMapper.toDTO(agreementRepository.save(grantAgreementMapper.toEntity(grantAgreementDTO)));
        } else {
            return grantAgreementMapper.toDTO(agreementRepository.save(grantAgreementMapper.toEntity(inputGrantAgreement)));
        }
    }

    public GrantAgreementDTO getGrantAgreementByApplicationId(Integer applicationId) {
        return grantAgreementMapper.toDTO(agreementRepository.findByApplicationId(applicationId));
    }

    public GrantAgreementDTO getGrantAgreementById(Integer id) {
        return grantAgreementMapper.toDTO(agreementRepository.findOne(id));
    }

    public GrantAgreementDTO initializeGrantAgreement(Integer applicationId) {
        GrantAgreement grantAgreement = new GrantAgreement();
        grantAgreement.setApplicationId(applicationId);
        return createGrantAgreement(grantAgreementMapper.toDTO(grantAgreement));
    }

    public ByteArrayOutputStream generateGrantAgreementPdf(GrantAgreementDTO grantAgreement) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfStamper pdfStamper = null;
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader("C:\\grant_agreement_template_" + grantAgreement.getDocumentLanguage() + ".pdf");
            pdfStamper = new PdfStamper(pdfReader, outputStream);

            BaseFont baseFont = BaseFont.createFont(
                    BaseFont.TIMES_ROMAN,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);


            int pages = pdfReader.getNumberOfPages();

            for (int i = 1; i <= pages; i++) {
                if (i == 1) {
                    PdfContentByte pageContentByte = pdfStamper.getOverContent(i);

                    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, "Cp1252", BaseFont.EMBEDDED);
                    Font f = new Font(bf, 8);
                    ColumnText ct = new ColumnText(pageContentByte);
                    ct.setSimpleColumn(5, 0, pdfReader.getPageSize(i).getWidth() / 2, 400f);
                    ct.addElement(new Paragraph(grantAgreement.getDocumentLanguage(), f));
                    ct.go();
                }
            }

            return outputStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (pdfStamper != null) {
                pdfStamper.close();
            }
            if (pdfReader != null) {
                pdfReader.close();
            }
            outputStream.close();
        }
    }


    public ByteArrayOutputStream generateGrantAgreementPdfSigned(GrantAgreementDTO grantAgreement, String signString) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfStamper pdfStamper = null;
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader("C:\\grant_agreement_template_" + grantAgreement.getDocumentLanguage() + ".pdf");
            pdfStamper = new PdfStamper(pdfReader, outputStream);

            BaseFont baseFont = BaseFont.createFont(
                    BaseFont.TIMES_ROMAN,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);


            int pages = pdfReader.getNumberOfPages();

            for (int i = 1; i <= pages; i++) {
                //Contain the pdf data.
                if (i == pages) {
                    PdfContentByte pageContentByte =
                            pdfStamper.getOverContent(i);

                    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, "Cp1252", BaseFont.EMBEDDED);
                    Font f = new Font(bf, 8);
                    ColumnText ct = new ColumnText(pageContentByte);
                    ct.setSimpleColumn(74, 0, pdfReader.getPageSize(i).getWidth() / 2, 400f);
                    ct.addElement(new Paragraph(signString, f));
                    ct.go();
                }

                if (i == 1) {
                    PdfContentByte pageContentByte =
                            pdfStamper.getOverContent(i);

                    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, "Cp1252", BaseFont.EMBEDDED);
                    Font f = new Font(bf, 8);
                    ColumnText ct = new ColumnText(pageContentByte);
                    ct.setSimpleColumn(5, 0, pdfReader.getPageSize(i).getWidth() / 2, 400f);
                    ct.addElement(new Paragraph(grantAgreement.getDocumentLanguage(), f));
                    ct.go();
                }
            }

            return outputStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (pdfStamper != null) {
                pdfStamper.close();
            }
            if (pdfReader != null) {
                pdfReader.close();
            }
            outputStream.close();
        }

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
