package wifi4eu.wifi4eu.service.supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.supplier.BankAccount;
import wifi4eu.wifi4eu.mapper.supplier.BankAccountMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.supplier.BankAccountRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;

import java.util.List;

@Service("BankAccountService")
public class BankAccountService {

    @Autowired
    BankAccountMapper bankAccountMapper;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    private final Logger _log = LogManager.getLogger(BankAccountService.class);


    public List<BankAccountDTO> getBankAccountsBySupplierId(Integer supplierId) {
        return bankAccountMapper.toDTOList(bankAccountRepository.findBySupplierId(supplierId));
    }

    @Transactional
    public BankAccountDTO create(BankAccountDTO bankAccountDTO) {
        return bankAccountMapper.toDTO(bankAccountRepository.save(bankAccountMapper.toEntity(bankAccountDTO)));
    }

    @Transactional
    public ResponseDTO deleteBankAccount(BankAccount bankAccount) throws Exception {
        // if it is attributed to a Beneficiary for payment the Wi-Fi Installation Company cannot delete it
        List<Application> applicationsWithBankAccount = applicationRepository.findByBankAccountIdAndSupplierId(bankAccount.getId(), bankAccount.getSupplierId());
        if (applicationsWithBankAccount.isEmpty()) {
            bankAccountRepository.delete(bankAccount);
            return new ResponseDTO(true, "success", null);
        } else {
            return new ResponseDTO(false, null,  new ErrorDTO(20, "cannot delete bank account"));
        }
    }
}