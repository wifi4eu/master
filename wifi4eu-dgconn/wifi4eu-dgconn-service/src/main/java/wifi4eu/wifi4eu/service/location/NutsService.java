package wifi4eu.wifi4eu.service.location;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.mapper.location.NutsMapper;
import wifi4eu.wifi4eu.repository.location.NutsRepository;

import java.util.List;

@Service("portalNutsService")
public class NutsService {
    @Autowired
    NutsMapper nutsMapper;

    @Autowired
    NutsRepository nutsRepository;

    public List<NutsDTO> getAllNuts() {
        return nutsMapper.toDTOList(Lists.newArrayList(nutsRepository.findAll()));
    }

    @Cacheable(value = "portalGetNutsById")
    public NutsDTO getNutsById(int nutsId) {
        return nutsMapper.toDTO(nutsRepository.findOne(nutsId));
    }

    public NutsDTO getNutsByCode(String code) {
        return nutsMapper.toDTO(nutsRepository.findByCode(code));
    }

    @Cacheable(value = "portalGetNutsByLevel")
    public List<NutsDTO> getNutsByLevel(Integer level) {
        return nutsMapper.toDTOList(Lists.newArrayList(nutsRepository.findByLevel(level)));
    }

    public List<NutsDTO> getNutsByCountryCode(String countryCode) {
        return nutsMapper.toDTOList(Lists.newArrayList(nutsRepository.findByCountryCode(countryCode)));
    }

    @Cacheable(value = "portalGetNutsByCountryCodeAndLevelOrderByLabelAsc")
    public List<NutsDTO> getNutsByCountryCodeAndLevelOrderByLabelAsc(String countryCode, Integer level) {
        return nutsMapper.toDTOList(Lists.newArrayList(nutsRepository.getNutsByCountryCodeAndLevelOrderByLabelAsc(countryCode, level)));
    }

}
