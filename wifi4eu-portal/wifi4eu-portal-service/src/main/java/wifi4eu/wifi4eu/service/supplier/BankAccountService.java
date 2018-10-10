package wifi4eu.wifi4eu.service.supplier;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDTO;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDocumentDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobConnector;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.supplier.BankAccount;
import wifi4eu.wifi4eu.mapper.supplier.BankAccountDocumentMapper;
import wifi4eu.wifi4eu.mapper.supplier.BankAccountMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
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
    ApplicationRepository applicationRepository;

    @Autowired
    BankAccountDocumentMapper bankAccountDocumentMapper;

    @Autowired
    BankAccountDocumentRepository bankAccountDocumentRepository;

    @Autowired
    AzureBlobConnector azureBlobConnector;

    public List<BankAccountDTO> getBankAccountsBySupplierId(Integer supplierId) {
        return bankAccountMapper.toDTOList(bankAccountRepository.findBySupplierId(supplierId));
    }

    @Transactional
    public BankAccountDTO save(BankAccountDTO bankAccountDTO) {
        return bankAccountMapper.toDTO(bankAccountRepository.save(bankAccountMapper.toEntity(bankAccountDTO)));
    }

    @Transactional
    public ResponseDTO deleteBankAccount(BankAccount bankAccount) throws Exception {
        // if it is attributed to a Beneficiary for payment the Wi-Fi Installation Company cannot delete it
        List<Application> applicationsWithBankAccount = applicationRepository.findByBankAccountIdAndSupplierId(bankAccount.getId(), bankAccount
                .getSupplierId());
        if (applicationsWithBankAccount.isEmpty()) {
            bankAccountRepository.delete(bankAccount);
            return new ResponseDTO(true, "success", null);
        } else {
            return new ResponseDTO(false, null, new ErrorDTO(20, "cannot delete bank account"));
        }
    }

    public BankAccount getBankAccountByIdAndSupplierId(Integer ibanId, Integer supplierId) {
        return bankAccountRepository.findByIdAndSupplierId(ibanId, supplierId);
    }

    public List<BankAccountDocumentDTO> getBankAccountDcoumentsBySupplierId(Integer supplierId) {
        return bankAccountDocumentMapper.toDTOList(bankAccountDocumentRepository.findBySupplierIdOrderByBankAccountId(supplierId));
    }

    @Transactional
    public BankAccountDocumentDTO save(BankAccountDocumentDTO bankAccountDocumentDTO, UserDTO userConnected, String ip) throws Exception {
        String bankAccountDocumentDTOToUpload = bankAccountDocumentDTO.getFileData();

        if (Validator.isNotNull(bankAccountDocumentDTOToUpload)) {
            String base64 = LegalFilesService.getBase64Data(bankAccountDocumentDTOToUpload);
            if (Validator.isNotNull(base64) && Validator.isNotEmpty(base64)) {
                byte[] byteArray = Base64.getMimeDecoder().decode(base64);
                String extension = LegalFilesService.getValidFileExtension(bankAccountDocumentDTOToUpload);
                if (byteArray.length > 1024000) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File size cannot bet greater than 1 MB");
                    throw new Exception("File size cannot bet greater than 1 MB.");
                } else if (extension == null) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File must have a valid extension");
                    throw new Exception("File must have a valid extension.");
                } else if (bankAccountDocumentDTO.getFileName().isEmpty()) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - File doesn't have a name");
                    throw new Exception("File must have a valid extension.");
                } else {
                    long uploadTimeUTC = System.currentTimeMillis();
                    MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
                    msdDigest.update(bankAccountDocumentDTO.getFileName().getBytes("UTF-8"), 0, bankAccountDocumentDTO.getFileName().length());
                    String codeName = DatatypeConverter.printHexBinary(msdDigest.digest());
                    String azureFileName = String.valueOf(bankAccountDocumentDTO.getSupplierId()) + "_" + codeName + "_" + uploadTimeUTC;

                    String uri = azureBlobConnector.uploadLegalFile(azureFileName, base64);
                    boolean docUploaded = !Validator.isEmpty(uri);
                    bankAccountDocumentDTO.setAzureUri(uri);

                    if (docUploaded) {

                        //legalFile.setFileData(LegalFilesService.getBase64Data(legalFileToUpload));
                        bankAccountDocumentDTO.setFileData("");
                        bankAccountDocumentDTO.setUploadTime(uploadTimeUTC);
                        bankAccountDocumentDTO.setFileMime(LegalFilesService.getMimeType(bankAccountDocumentDTOToUpload));
                        bankAccountDocumentDTO.setFileSize(byteArray.length);
                        bankAccountDocumentDTO.setUserId(userConnected.getId());

                        bankAccountDocumentDTO = bankAccountDocumentMapper.toDTO(bankAccountDocumentRepository.save(bankAccountDocumentMapper
                                .toEntity(bankAccountDocumentDTO)));

                        _log.log(Level.getLevel("BUSINESS"), "[ " + ip + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Updated " +
                                "Bank Account Document");

                        return bankAccountDocumentDTO;
                    }
                }
            } else {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Trying to upload a file its data is in incorrect format");
                throw new Exception("Data is in incorrect format");
            }
        } else {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Trying to upload a file that is empty");
            throw new Exception("File is empty");
        }

        return null;
    }

    public BankAccountDocumentDTO getBankAccountDocumentById(int id) {
        return bankAccountDocumentMapper.toDTO(bankAccountDocumentRepository.findOne(id));
    }

    public String downloadLegalFile(String url) {
        return azureBlobConnector.downloadLegalFile(url);
    }
}