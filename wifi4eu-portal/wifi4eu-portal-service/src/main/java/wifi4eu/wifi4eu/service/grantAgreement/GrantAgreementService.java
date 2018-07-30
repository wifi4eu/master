package wifi4eu.wifi4eu.service.grantAgreement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.mapper.grantAgreement.GrantAgreementMapper;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.ParametrizedDocConverter;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Service
public class GrantAgreementService {


    @Autowired
    ApplicationService applicationService;

    @Autowired
    GrantAgreementRepository agreementRepository;

    @Autowired
    GrantAgreementMapper grantAgreementMapper;

    @Autowired
    UserService userService;

    @Autowired
    ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

    public GrantAgreementDTO saveGrantAgreementSignature(GrantAgreementDTO inputGrantAgreement){
        return grantAgreementMapper.toDTO(agreementRepository.save(grantAgreementMapper.toEntity(inputGrantAgreement)));
    }

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

    public GrantAgreementDTO initializeGrantAgreement(GrantAgreementDTO inputGrandAgreement) {
        return createGrantAgreement(inputGrandAgreement);
    }

    public ByteArrayOutputStream fillGrantAgreementDocument(GrantAgreementDTO grantAgreement, Map<String, String> mapProperties) throws Exception {
        Resource resource = new ClassPathResource("grant_agreement_template_" + grantAgreement.getDocumentLanguage() + ".docx");
        byte[] byteData = Files.readAllBytes(resource.getFile().toPath());

        return ParametrizedDocConverter.convert(byteData, mapProperties);
    }

    public ByteArrayOutputStream generateGrantAgreementDocument(GrantAgreementDTO grantAgreement) throws Exception {

        UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());

        ApplicationAuthorizedPersonDTO applicationAuthorizedPerson = applicationAuthorizedPersonService.findByApplicationAndAuthorisedPerson(grantAgreement.getApplicationId(), userDTO.getId());

        if(applicationAuthorizedPerson == null){
            throw new AccessDeniedException("This user doesn't have permissions to sign the grant agreement");
        }

        ApplicationDTO applicationDTO = applicationService.getApplicationById(grantAgreement.getApplicationId());


        String registrationID = String.valueOf(applicationDTO.getRegistrationId());
        String userId = String.valueOf(userDTO.getId());

        String formattedRegistrationID = ("000000" + registrationID).substring(registrationID.length());
        String formattedUserID = ("000000" + userId).substring(userId.length());

        Map<String,String> replacementsMap = new HashMap<String,String>();
        replacementsMap.put("[<call number>", String.valueOf(applicationDTO.getCallId()));
        replacementsMap.put("<year>]", "18");
        replacementsMap.put("[<unique identifying number>]", formattedRegistrationID.concat("-").concat(formattedUserID));
        replacementsMap.put("[function, forename and surname]", "Head of Department C, Andreas Boschen");
        replacementsMap.put("[full official name]", "Aartselaar");
        replacementsMap.put("[official address in full]", "Baron van Ertbornstraat, 1");
        replacementsMap.put("[insert name of the municipality]", "Aartselaar");
        replacementsMap.put("[insert number of the action in bold]", "Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        replacementsMap.put("[or in English]", "Lorem ipsum dolor sit amet");
        replacementsMap.put("[language]", grantAgreement.getDocumentLanguage());
        replacementsMap.put("[function/forename/surname]", "Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        replacementsMap.put("[e-signature]", "consectetur adipiscing elit");
        replacementsMap.put("[<M or A>", "M");
        replacementsMap.put("[xxxx]", "Lorem ipsum");
        return fillGrantAgreementDocument(grantAgreement, replacementsMap);
    }

    /*public ByteArrayOutputStream generateGrantAgreementPdf(GrantAgreementDTO grantAgreement) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfStamper pdfStamper = null;
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader(generateGrantAgreementDocument(grantAgreement).toByteArray());
            pdfStamper = new PdfStamper(pdfReader, outputStream);

            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, "Cp1252", BaseFont.EMBEDDED);

            int pages = pdfReader.getNumberOfPages();

            for (int i = 1; i <= pages; i++) {
                if (i == 1) {
                    PdfContentByte pageContentByte = pdfStamper.getOverContent(i);
                    Font f = new Font(bf, 8);
                    ColumnText ct = new ColumnText(pageContentByte);
                    ct.setSimpleColumn(5, 0, pdfReader.getPageSize(i).getWidth() / 2, 400f);
                    ct.addElement(new Paragraph(grantAgreement.getDocumentLanguage(), f));
                    ct.go();
                }
            }

            return outputStream;
        } catch (Exception e) {
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
    }*/


    public ByteArrayOutputStream generateGrantAgreementPdfSigned(GrantAgreementDTO grantAgreement, String signString) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfStamper pdfStamper = null;
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader(generateGrantAgreementDocument(grantAgreement).toByteArray());
            pdfStamper = new PdfStamper(pdfReader, outputStream);

            int pages = pdfReader.getNumberOfPages();

            for (int i = 1; i <= pages; i++) {
                //Contain the pdf data.
                if (i == 7) {
                    PdfContentByte pageContentByte =
                            pdfStamper.getOverContent(i);

                    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, "Cp1252", BaseFont.EMBEDDED);
                    Font f = new Font(bf, 8);
                    ColumnText ct = new ColumnText(pageContentByte);
                    ct.setSimpleColumn(74, 0, pdfReader.getPageSize(i).getWidth() / 2, 400f);
                    ct.addElement(new Paragraph(signString, f));
                    ct.go();
                }
            }

            return outputStream;
        } catch (Exception e) {
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
