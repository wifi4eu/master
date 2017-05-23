package wifi4eu.wifi4eu.service.dgconn;

import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;
import wifi4eu.wifi4eu.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;

import java.util.List;

@Service
public class DgconnService {

    private final static Logger _log = Logger.getLogger(DgconnService.class);

    @Autowired
    BenPubSupMapper benPubSupMapper;

    @Autowired
    BenPubSupRepository benPubSupRepository;

    public List<BenPubSupDTO> distribute() {
        List<BenPubSupDTO> benPubSupDTOList = benPubSupMapper.toDTOList(Lists.newArrayList(benPubSupRepository.findAll()));
        for (int i = 0; i < benPubSupDTOList.size(); i++) {
            BenPubSupDTO benPubSupDTO = benPubSupDTOList.get(i);
            benPubSupDTO.setAwarded(true);
            benPubSupDTOList.set(i, benPubSupMapper.toDTO(benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO))));
        }
        return benPubSupDTOList;
    }
}
