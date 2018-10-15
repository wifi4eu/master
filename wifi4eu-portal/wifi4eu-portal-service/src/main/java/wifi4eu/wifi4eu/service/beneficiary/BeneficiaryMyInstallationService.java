package wifi4eu.wifi4eu.service.beneficiary;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDTO;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryMyInstallationDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierMyInstallationDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.helper.StringPool;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryMyInstallation;
import wifi4eu.wifi4eu.mapper.beneficiary.BeneficiaryMyInstallationMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryMyInstallationRepository;
import wifi4eu.wifi4eu.service.supplier.BankAccountService;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiaryMyInstallationService {

    Logger _log = LogManager.getLogger(BeneficiaryMyInstallationService.class);

    @Autowired
    BeneficiaryMyInstallationMapper beneficiaryMyInstallationMapper;

    @Autowired
    BeneficiaryMyInstallationRepository beneficiaryMyInstallationRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    BankAccountService bankAccountService;

    @Transactional
    public ResponseDTO getMyInstallationData(Integer supplierId, String logInfo, Boolean firstTime, String fieldOrder, String orderDirection,
                                             Integer page, Integer rowsPerPage) {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(true);
        List<BeneficiaryMyInstallationDTO> dtoList = getBeneficiaryMyInstallationList(supplierId, fieldOrder, orderDirection, page, rowsPerPage);
        List<BankAccountDTO> bankAccountDTOList = null;
        if (firstTime) {
            bankAccountDTOList = bankAccountService.getBankAccountsBySupplierId(supplierId);
        }
        response.setData(new SupplierMyInstallationDTO(dtoList, bankAccountDTOList));
        response.setXTotalCount(beneficiaryMyInstallationRepository.countBeneficiariesListMyInstallation(supplierId));
        _log.info("ECAS Username: " + logInfo + " - Retrieved beneficiary list successfully");
        return response;
    }

    public ResponseDTO attributeBankAccountToBeneficiary(Integer bankAccountId, Integer applicationId) {
        Application application = applicationRepository.findOne(applicationId);
        application.setBankAccountId(bankAccountId);
        applicationRepository.save(application);
        return new ResponseDTO(true, "sucess", null);
    }

    public List<BeneficiaryMyInstallationDTO> getBeneficiaryMyInstallationList(Integer id, String fieldOrder, String orderDirection, Integer page,
                                                                               Integer rowsPerPage) {
        return beneficiaryMyInstallationMapper.toDTOList(beneficiaryMyInstallationRepository.searchBeneficiariesListMyInstallation(id, fieldOrder,
                orderDirection, page, rowsPerPage));
    }

}
