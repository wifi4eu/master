package wifi4eu.wifi4eu.service.grantAgreement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import org.apache.poi.util.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.common.azureblobstorage.AzureBlobStorage;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.mapper.grantAgreement.GrantAgreementMapper;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.ParametrizedDocConverter;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URL;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    AzureBlobStorage azureBlobStorage;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    LauService lauService;

    @Autowired
    ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

    final static HashMap<String, String> languagesMap = new HashMap<>();

    @PostConstruct
    public void initIt() throws Exception {
        languagesMap.put("bg", "български");
        languagesMap.put("cs", "čeština");
        languagesMap.put("da", "Dansk");
        languagesMap.put("de", "Deutsch");
        languagesMap.put("et", "eesti keel");
        languagesMap.put("el", "ελληνικά");
        languagesMap.put("en", "English");
        languagesMap.put("es","español");
        languagesMap.put("fr", "français");
        languagesMap.put("ga","Gaeilge");
        languagesMap.put("it", "italiano");
        languagesMap.put("lv", "latviešu valoda");
        languagesMap.put("lt",  "lietuvių kalba");
        languagesMap.put("hu", "magyar");
        languagesMap.put("mt", "Malti");
        languagesMap.put("nl",  "Nederlands");
        languagesMap.put("pl", "polski");
        languagesMap.put("pt", "português");
        languagesMap.put("ro","română");
        languagesMap.put("sk", "slovenčina");
        languagesMap.put("sl",  "slovenščina");
        languagesMap.put("fi", "suomi");
        languagesMap.put("sv", "svenska");
        languagesMap.put("hr",  "hrvatski");
        languagesMap.put("is", "íslenska");
        languagesMap.put("mk", "македонски");
        languagesMap.put("no", "norsk");
        languagesMap.put("tr",  "türkçe");
    }

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
        byte[] fileData = azureBlobStorage.getFileFromContainer("docs", "grant_agreement_template_" + grantAgreement.getDocumentLanguage() + ".docx");
        return ParametrizedDocConverter.convert(fileData, mapProperties);
    }

    public ByteArrayOutputStream generateGrantAgreementDocument(GrantAgreementDTO grantAgreement) throws Exception {

        UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());

        ApplicationAuthorizedPersonDTO applicationAuthorizedPerson = applicationAuthorizedPersonService.findByApplicationAndAuthorisedPerson(grantAgreement.getApplicationId(), userDTO.getId());

        if(applicationAuthorizedPerson == null){
            throw new AccessDeniedException("This user doesn't have permissions to sign the grant agreement");
        }

        ApplicationDTO applicationDTO = applicationService.getApplicationById(grantAgreement.getApplicationId());
        RegistrationDTO registrationDTO = registrationService.getRegistrationById(applicationDTO.getRegistrationId());
        MunicipalityDTO municipalityDTO = municipalityService.getMunicipalityById(registrationDTO.getMunicipalityId());
        LauDTO lauDTO = lauService.getLauById(municipalityDTO.getLauId());

        String registrationID = String.valueOf(applicationDTO.getRegistrationId());
        String userId = String.valueOf(userDTO.getId());

        String formattedRegistrationID = ("000000" + registrationID).substring(registrationID.length());
        String formattedUserID = ("000000" + userId).substring(userId.length());

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DateFormat df = new SimpleDateFormat("yyyy"); // Just the year, with 2 digits
        String year = df.format(cal.getTime());

        Map<String,String> replacementsMap = new HashMap<String,String>();
        replacementsMap.put("[<call number>", String.valueOf(applicationDTO.getCallId()));
        replacementsMap.put("<year>]", year);
        replacementsMap.put("[<unique identifying number>]", formattedRegistrationID.concat("-").concat(formattedUserID));
        replacementsMap.put("[function, forename and surname]", "Head of Department C, Andreas Boschen");
        replacementsMap.put("[function-2, forename and surname]", userDTO.getName().concat(" ").concat(userDTO.getSurname()));
        replacementsMap.put("[full official name]", lauDTO.getName1());
        replacementsMap.put("[official address in full]", municipalityDTO.getAddress().concat(", ").concat(municipalityDTO.getAddressNum()));
        replacementsMap.put("[insert name of the municipality]", lauDTO.getName2());
        replacementsMap.put("[insert number of the action in bold]", "INEA/CEF/WiFi4EU/" + String.valueOf(applicationDTO.getCallId()).concat(year) + "/" +  formattedRegistrationID.concat("-").concat(formattedUserID));
        if(grantAgreement.getDocumentLanguage().equalsIgnoreCase("en")){
            replacementsMap.put("[or in English]", "");
        }
        replacementsMap.put("[language]", languagesMap.get(grantAgreement.getDocumentLanguage()));
        replacementsMap.put("[function/forename/surname]", userDTO.getName().concat(" ").concat(userDTO.getSurname()));
        replacementsMap.put("INEA/CEF/ICT/", "INEA/CEF/WiFi4EU/");
        replacementsMap.put("[<M or A><year>]", String.valueOf(applicationDTO.getCallId()).concat(year));
        replacementsMap.put("[xxxx]", formattedRegistrationID.concat("-").concat(formattedUserID));
        replacementsMap.put("[e-signature]", "");
        return fillGrantAgreementDocument(grantAgreement, replacementsMap);
    }

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
