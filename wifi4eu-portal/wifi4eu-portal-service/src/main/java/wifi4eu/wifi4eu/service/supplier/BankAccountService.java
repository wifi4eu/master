package wifi4eu.wifi4eu.service.supplier;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDTO;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDocumentDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobConnector;
import wifi4eu.wifi4eu.mapper.supplier.BankAccountDocumentMapper;
import wifi4eu.wifi4eu.mapper.supplier.BankAccountMapper;
import wifi4eu.wifi4eu.repository.supplier.BankAccountDocumentRepository;
import wifi4eu.wifi4eu.repository.supplier.BankAccountRepository;
import wifi4eu.wifi4eu.service.registration.legal_files.LegalFilesService;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

@Service("BankAccountService")
public class BankAccountService {

    private final Logger _log = LogManager.getLogger(BankAccountService.class);

    @Autowired
    BankAccountMapper bankAccountMapper;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    BankAccountDocumentMapper bankAccountDocumentMapper;

    @Autowired
    BankAccountDocumentRepository bankAccountDocumentRepository;

    @Autowired
    AzureBlobConnector azureBlobConnector;

    @Autowired
    SupplierService supplierService;

    public List<BankAccountDTO> getBankAccountsBySupplierId(Integer supplierId) {
        return bankAccountMapper.toDTOList(bankAccountRepository.findBySupplierId(supplierId));
    }

    @Transactional
    public BankAccountDTO save(BankAccountDTO bankAccountDTO) {
        formatFields(bankAccountDTO);

        return bankAccountMapper.toDTO(bankAccountRepository.save(bankAccountMapper.toEntity(bankAccountDTO)));
    }

    @Transactional
    public BankAccountDTO deleteBankAccount(int bankAccountId) {
        BankAccountDTO bankAccountDTO = bankAccountMapper.toDTO(bankAccountRepository.findOne(bankAccountId));
        if (bankAccountDTO != null) {
            bankAccountRepository.delete(bankAccountMapper.toEntity(bankAccountDTO));
            return bankAccountDTO;
        } else {
            return null;
        }
    }

    public List<BankAccountDocumentDTO> getBankAccountDcoumentsBySupplierId(Integer supplierId) {
        return bankAccountDocumentMapper.toDTOList(bankAccountDocumentRepository.findBySupplierIdOrderByBankAccountId(supplierId));
    }

    @Transactional
    public BankAccountDocumentDTO save(BankAccountDocumentDTO bankAccountDocumentDTO, UserDTO userConnected, String ip) throws Exception {
        String bankAccountDocumentDTOToUpload = bankAccountDocumentDTO.getFileData();

        validateFile(bankAccountDocumentDTOToUpload, bankAccountDocumentDTO.getFileName(), userConnected.getEcasUsername());

        long uploadTimeUTC = System.currentTimeMillis();
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
        msdDigest.update(bankAccountDocumentDTO.getFileName().getBytes("UTF-8"), 0, bankAccountDocumentDTO.getFileName().length());
        String codeName = DatatypeConverter.printHexBinary(msdDigest.digest());
        String azureFileName = String.valueOf(bankAccountDocumentDTO.getSupplierId()) + "_" + codeName + "_" + uploadTimeUTC;

        String base64 = LegalFilesService.getBase64Data(bankAccountDocumentDTOToUpload);
        String uri = azureBlobConnector.uploadLegalFile(azureFileName, base64);
        boolean docUploaded = !Validator.isEmpty(uri);
        bankAccountDocumentDTO.setAzureUri(uri);

        if (docUploaded) {

            bankAccountDocumentDTO.setFileData("");
            bankAccountDocumentDTO.setUploadTime(uploadTimeUTC);
            bankAccountDocumentDTO.setFileMime(LegalFilesService.getMimeType(bankAccountDocumentDTOToUpload));
            bankAccountDocumentDTO.setFileSize(Base64.getMimeDecoder().decode(base64).length);
            bankAccountDocumentDTO.setUserId(userConnected.getId());

            bankAccountDocumentDTO = bankAccountDocumentMapper.toDTO(bankAccountDocumentRepository.save(bankAccountDocumentMapper.toEntity(bankAccountDocumentDTO)));

            _log.log(Level.getLevel("BUSINESS"), "[ " + ip + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Updated Bank Account Document");

            return bankAccountDocumentDTO;
        }

        return null;
    }

    private void validateFile(String fileData, String fileName, String userEcasUserName) throws Exception {
        if (Validator.isNotNull(fileData)) {
            String base64 = LegalFilesService.getBase64Data(fileData);
            if(Validator.isNotNull(base64) && Validator.isNotEmpty(base64)) {
            byte[] byteArray = Base64.getMimeDecoder().decode(base64);
            String extension = LegalFilesService.getValidFileExtension(fileData);
            if (byteArray.length > 1024000) {
                _log.error("ECAS Username: " + userEcasUserName + " - File size cannot bet greater than 1 MB");
                throw new Exception("File size cannot bet greater than 1 MB.");
            } else if (extension == null) {
                _log.error("ECAS Username: " + userEcasUserName + " - File must have a valid extension");
                throw new Exception("File must have a valid extension.");
            } else if (fileName.isEmpty()) {
                _log.error("ECAS Username: " + userEcasUserName + " - File doesn't have a name");
                throw new Exception("File must have a valid extension.");
            }
            } else {
            _log.error("ECAS Username: " + userEcasUserName + " - Trying to upload a file its data is in incorrect format");
            throw new Exception("Data is in incorrect format");
            }
        } else{
            _log.error("ECAS Username: " + userEcasUserName + " - Trying to upload a file that is empty");
            throw new Exception("File is empty");
        }
    }

    public BankAccountDocumentDTO getBankAccountDocumentById(int id){
        return bankAccountDocumentMapper.toDTO(bankAccountDocumentRepository.findOne(id));
    }

    public String downloadLegalFile(String url){
        return azureBlobConnector.downloadLegalFile(url);
    }

    public boolean hasUserPermissionForDocument(Integer supplierId, Integer userId, Integer documentId) {
        //Check if the user is the supplier or one of his contacts

        SupplierDTO supplierDTO = this.supplierService.getSupplierByUserId(userId);
        if (supplierDTO.getId() != supplierId) return false;

        //Check if the document is owned by the sipplier

        BankAccountDocumentDTO bankAccountDocumentDTO = getBankAccountDocumentById(documentId);
        return bankAccountDocumentDTO.getSupplierId() == supplierId;
    }

    private void formatFields(BankAccountDTO bankAccountDTO){
        bankAccountDTO.setAccountName(getStringTruncated(replaceNonAsciiCharacters(bankAccountDTO.getAccountName()), 70));

        bankAccountDTO.setBankName(getStringTruncated(replaceNonAsciiCharacters(bankAccountDTO.getBankName()),120));
        bankAccountDTO.setBankCity(getStringTruncated(replaceNonAsciiCharacters(bankAccountDTO.getBankCity()), 50));
        bankAccountDTO.setBankStreet(getStringTruncated(replaceNonAsciiCharacters(bankAccountDTO.getBankStreet()), 120));
        bankAccountDTO.setBankNumber(replaceNonAsciiCharacters(bankAccountDTO.getBankNumber()));

        bankAccountDTO.setAccountHolderCity(getStringTruncated(replaceNonAsciiCharacters(bankAccountDTO.getAccountHolderCity()),50));
        bankAccountDTO.setAccountHolderStreet(getStringTruncated(replaceNonAsciiCharacters(bankAccountDTO.getAccountHolderStreet()),60));
        bankAccountDTO.setAccountHolderNumber(replaceNonAsciiCharacters(bankAccountDTO.getAccountHolderNumber()));
    }

    private String replaceNonAsciiCharacters(String s){
        s = s.replaceAll("[óòöðôõøő]","o")
            .replaceAll("[ÒÓÖÔÕØŐ]","O")
            .replaceAll("[ñńňņ]","n")
            .replaceAll("[ÑŃŇŅ]","N")
            .replaceAll("[èéêëęėěē]","e")
            .replaceAll("[ÈÉÊËĘĖĚĒ]","E")
            .replaceAll("[áãâàäåæąăā]","a")
            .replaceAll("[Æ]","AE")
            .replaceAll("[ÀÁÂÃÅÄĄĂĀ]","A")
            .replaceAll("[ùúûüµųūůű]","u")
            .replaceAll("[ÙÚÛÜŲŪŮŰ]","U")
            .replaceAll("[ÝŸ]","Y")
            .replaceAll("[ÿý]","y")
            .replaceAll("[œ]","oe")
            .replaceAll("[çčćċ]","c")
            .replaceAll("[Œ]","OE")
            .replaceAll("[ÇČĆĊ]","C")
            .replaceAll("[ìíîïįī]","i")
            .replaceAll("[ÌÍÎÏĮĪ]","I")
            .replaceAll("[Þ]","Th")
            .replaceAll("[ĐĎ]","D")
            .replaceAll("[ďđ]","d")
            .replaceAll("[ß]","ss")
            .replaceAll("[ŠŚŞ]","S")
            .replaceAll("[šśş]","s")
            .replaceAll("[β]","b")
            .replaceAll("[łļľ]","l")
            .replaceAll("[ŁĽ]","D")
            .replaceAll("[ŁĽ]","D")
            .replaceAll("[ŽŻŹ]","Z")
            .replaceAll("[žżź]","z")
            .replaceAll("[ŢŤ]","T")
            .replaceAll("[ţť]","t")
            .replaceAll("[Ý]","Y")
            .replaceAll("[ý]","y")
            .replaceAll("[Ř]","R")
            .replaceAll("[řŕ]","r")
            .replaceAll("[Ħ]","H")
            .replaceAll("[ħ]","h")
            .replaceAll("[Ġ]","G")
            .replaceAll("[ġ]","g")
            .replaceAll("[þ]","th")
            .replaceAll("[ķ]","k")
            .replaceAll("[Ķ]","K")
            .replaceAll("[_]","-");

        return s;
    }

    private String getStringTruncated(String s, int maxLenght){
        if (s.length() <= maxLenght) return s;

        return s.substring(0,maxLenght);
    }
}