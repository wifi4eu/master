package wifi4eu.wifi4eu.service.beneficiary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDisplayedListDTO;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;

import java.util.List;

@Service("beneficiary")
public class BeneficiaryDisplayedListService {

    @Autowired
    MunicipalityRepository municipalityRepository;

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryDisplayedListService.class);

    public List<BeneficiaryDisplayedListDTO> findBeneficiariesList(){
        return municipalityRepository.findBeneficiariesList();
    }

}
