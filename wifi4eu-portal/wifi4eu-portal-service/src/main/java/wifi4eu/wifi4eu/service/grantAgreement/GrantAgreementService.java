package wifi4eu.wifi4eu.service.grantAgreement;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.itextpdf.text.pdf.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobConnector;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobStorage;
import wifi4eu.wifi4eu.mapper.grantAgreement.GrantAgreementMapper;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.ParametrizedDocConverter;

@Service
public class GrantAgreementService {
    Logger _log = LogManager.getLogger(GrantAgreementService.class);

    private final static String FILE_TEMPLATE_GRANT_AGREEMENT_PREFIX = "grant_agreement_0918_";

    private final static String FILE_TEMPLATE_GRANT_AGREEMENT_EXTENSION = ".pdf";

    @Autowired
    AzureBlobConnector azureBlobConnector;

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
    MunicipalityRepository municipalityRepository;

    @Autowired
    ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

    @Autowired
    RegistrationRepository registrationRepository;

    static final HashMap<String, String> languagesMap = new HashMap<>();

    @PostConstruct
    public void initIt() throws Exception {
        languagesMap.put("bg", "български");
        languagesMap.put("cs", "čeština");
        languagesMap.put("da", "Dansk");
        languagesMap.put("de", "Deutsch");
        languagesMap.put("et", "eesti keel");
        languagesMap.put("el", "ελληνικά");
        languagesMap.put("en", "English");
        languagesMap.put("es",  "español");
        languagesMap.put("fr", "français");
        languagesMap.put("ga",  "Gaeilge");
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
        	if (Validator.isNotNull(inputGrantAgreement.getId())) {
        	    if(inputGrantAgreement.getId() != 0){
                    _log.warn("Call to a create method with id set, the value has been removed ({})", inputGrantAgreement.getId());
                    inputGrantAgreement.setId(0);
                }
        	}        	
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

    private byte[] getGrantAgreementTemplate(String language) throws IOException {
    	StringBuilder fileName = new StringBuilder();
    	fileName.append(FILE_TEMPLATE_GRANT_AGREEMENT_PREFIX).append(language).append(FILE_TEMPLATE_GRANT_AGREEMENT_EXTENSION);

    	// Template files are stored in Azure: wifi4eustoredocuments - Storage Explorer
        return azureBlobStorage.getFileFromContainer("docs", fileName.toString());
    }

    public ByteArrayOutputStream fillGrantAgreementDocument(GrantAgreementDTO grantAgreement, Map<String, String> mapProperties) throws IOException {
    	// Get template in the correspondent language
        byte[] fileData = getGrantAgreementTemplate(grantAgreement.getDocumentLanguage().toLowerCase());
        // Replace placeholders in the template for the user's values
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
        String header = String.valueOf(applicationDTO.getCallId());
        header = header.concat(year);
        header = header.concat("/");
        header = header.concat(formattedRegistrationID.concat("-").concat(formattedUserID));

        String lauNationalName = lauDTO.getNationalName();
        String lauDisplayName = lauDTO.getDisplayName();
        String fullAddress = municipalityDTO.getAddress().concat(", ").concat(municipalityDTO.getAddressNum());

        replacementsMap.put("header", header);
        replacementsMap.put("field1", header);
        replacementsMap.put("field-forename-1", userDTO.getName().concat(" ").concat(userDTO.getSurname()));
        replacementsMap.put("field-name-commission", "Head of Department C, Andreas Boschen");
        replacementsMap.put("field-2", lauNationalName + "\n"+ fullAddress);
        replacementsMap.put("field-language", languagesMap.get(grantAgreement.getDocumentLanguage()));
        replacementsMap.put("field-beneficiary-name", userDTO.getName().concat(" ").concat(userDTO.getSurname()));
        replacementsMap.put("field-signature", "SIGNATURE HERE");
        replacementsMap.put("field-agency-name", "user of agency");
        replacementsMap.put("field-signature-agency", "SIGNATURE HERE");
        replacementsMap.put("field-action", header);
        replacementsMap.put("field-municipality", lauDisplayName);
        return fillGrantAgreementDocument(grantAgreement, replacementsMap);
    }

    public ByteArrayOutputStream generateGrantAgreementPdfSigned(GrantAgreementDTO grantAgreement, String signString) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfStamper pdfStamper = null;
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader(generateGrantAgreementDocument(grantAgreement).toByteArray());
            pdfStamper = new PdfStamper(pdfReader, outputStream);
            AcroFields fields = pdfStamper.getAcroFields();
            pdfStamper.setFormFlattening(true);

            final BaseFont font = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.EMBEDDED);
            fields.setField("field-signature", signString);
            fields.setFieldProperty("field-signature", "textfont", font, null);
            fields.setFieldProperty("field-signature", "textsize", new Float(9), null);

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

    public byte[] downloadGrantAgreementSigned(Integer applicationId, GrantAgreementDTO grantAgreementDTO) {
        byte[] fileBytes = null;
        try {
            fileBytes = azureBlobConnector.downloadGrantAgreementSigned(grantAgreementDTO.getDocumentLocation());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileBytes;
    }

    public boolean checkIsLefImportDone(int municipalityId){
        // TODO
        return municipalityRepository.countMunicipalityAbacFromMunicipalityId(registrationRepository.findMunicipalityByRegistrationId(municipalityId)) > 0;
    }

}
