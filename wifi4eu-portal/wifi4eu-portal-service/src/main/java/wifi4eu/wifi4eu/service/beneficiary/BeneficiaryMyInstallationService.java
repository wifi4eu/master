package wifi4eu.wifi4eu.service.beneficiary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.BeneficiaryMyInstallationMapper;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryMyInstallationRepository;

@Service
public class BeneficiaryMyInstallationService {

    Logger _log = LogManager.getLogger(BeneficiaryMyInstallationService.class);

    @Autowired
    BeneficiaryMyInstallationMapper beneficiaryMyInstallationMapper;

    @Autowired
    BeneficiaryMyInstallationRepository beneficiaryMyInstallationRepository;

    @Transactional
    public ResponseDTO findBeneficiariesListMyInstallation(Integer id, String logInfo) {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(true);
        response.setData(beneficiaryMyInstallationMapper.toDTOList(beneficiaryMyInstallationRepository.findBeneficiariesListMyInstallation(id)));
        _log.info("ECAS Username: " + logInfo + " - Retrieved beneficiary list successfully");
        return response;
    }
}
