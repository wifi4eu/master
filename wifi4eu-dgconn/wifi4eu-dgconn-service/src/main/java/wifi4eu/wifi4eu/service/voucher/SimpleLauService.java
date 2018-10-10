package wifi4eu.wifi4eu.service.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.SimpleLauDTO;
import wifi4eu.wifi4eu.common.mapper.voucher.SimpleLauMapper;
import wifi4eu.wifi4eu.repository.voucher.SimpleLauRepository;

import java.util.List;

@Service
public class SimpleLauService {

    @Autowired
    private SimpleLauMapper simplelauMapper;

    @Autowired
    private SimpleLauRepository simplelauRepository;

    public List<SimpleLauDTO> getAllLausFromApplications(){
        return simplelauMapper.toDTOList(simplelauRepository.findAllLausFromApplications());
    }
}
