package wifi4eu.wifi4eu.service.location;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.mapper.location.NutsMapper;
import wifi4eu.wifi4eu.repository.location.NutsRepository;

import java.util.List;

@Service
public class NutsService {
    @Autowired
    NutsMapper nutsMapper;

    @Autowired
    NutsRepository nutsRepository;

    public List<NutsDTO> getNutsByLevel(Integer level) {
        return nutsMapper.toDTOList(Lists.newArrayList(nutsRepository.findByLevel(level)));
    }

    public List<NutsDTO> getNutsByCountryCode(String countryCode) {
        return nutsMapper.toDTOList(Lists.newArrayList(nutsRepository.findByCountryCode(countryCode)));
    }

    public List<NutsDTO> getNutsByCountryCodeAndLevelOrderByLabelAsc(String countryCode, Integer level) {
        return nutsMapper.toDTOList(Lists.newArrayList(nutsRepository.getNutsByCountryCodeAndLevelOrderByLabelAsc(countryCode, level)));
    }
}
