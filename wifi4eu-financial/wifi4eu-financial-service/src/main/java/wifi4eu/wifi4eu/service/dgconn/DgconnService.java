package wifi4eu.wifi4eu.service.dgconn;

import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.common.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;

import java.util.List;

@Service
public class DgconnService {

    private final static Logger _log = Logger.getLogger(DgconnService.class);

    @Autowired
    BenPubSupMapper benPubSupMapper;

    @Autowired
    BenPubSupRepository benPubSupRepository;

    @Autowired
    LegalEntityMapper legalEntityMapper;

    @Autowired
    LegalEntityRepository legalEntityRepository;

    public List<BenPubSupDTO> distribute() {
        List<BenPubSupDTO> benPubSupDTOList = benPubSupMapper.toDTOList(Lists.newArrayList(benPubSupRepository.findAll()));
        for (int i = 0; i < benPubSupDTOList.size(); i++) {
            BenPubSupDTO benPubSupDTO = benPubSupDTOList.get(i);
            benPubSupDTO.setAwarded(true);
            benPubSupDTOList.set(i, benPubSupMapper.toDTO(benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO))));
        }
        return benPubSupDTOList;
    }

    public List<BenPubSupDTO> getAllRequests() {
        return benPubSupMapper.toDTOList(Lists.newArrayList(benPubSupRepository.findAll()));
    }

    public List<LegalEntityDTO> getAllLegalEntitiesByCountryCode(String countryCode) {
        return legalEntityMapper.toDTOList(Lists.newArrayList(legalEntityRepository.findByCountryCode(countryCode)));
    }
}
