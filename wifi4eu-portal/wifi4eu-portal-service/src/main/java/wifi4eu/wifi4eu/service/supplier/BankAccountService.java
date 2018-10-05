package wifi4eu.wifi4eu.service.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDTO;
import wifi4eu.wifi4eu.mapper.supplier.BankAccountMapper;
import wifi4eu.wifi4eu.repository.supplier.BankAccountRepository;

import java.util.List;

@Service("BankAccountService")
public class BankAccountService {

    @Autowired
    BankAccountMapper bankAccountMapper;

    @Autowired
    BankAccountRepository bankAccountRepository;

    public List<BankAccountDTO> getBankAccountsBySupplierId(Integer supplierId) {
        return bankAccountMapper.toDTOList(bankAccountRepository.findBySupplierId(supplierId));
    }

    @Transactional
    public BankAccountDTO create(BankAccountDTO bankAccountDTO) {
        return bankAccountMapper.toDTO(bankAccountRepository.save(bankAccountMapper.toEntity(bankAccountDTO)));
    }

    @Transactional
    public BankAccountDTO deleteSupplier(int bankAccountId) {
        BankAccountDTO bankAccountDTO = bankAccountMapper.toDTO(bankAccountRepository.findOne(bankAccountId));
        if (bankAccountDTO != null) {
            bankAccountRepository.delete(bankAccountMapper.toEntity(bankAccountDTO));
            return bankAccountDTO;
        } else {
            return null;
        }
    }
}