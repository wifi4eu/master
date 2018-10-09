package wifi4eu.wifi4eu.service.location;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.mapper.location.LauMapper;
import wifi4eu.wifi4eu.repository.location.LauRepository;

import java.util.List;

@Service("portalLauService")
public class LauService {
    @Autowired
    LauMapper lauMapper;

    @Autowired
    LauRepository lauRepository;

    public List<LauDTO> getAllLaus(){
        return lauMapper.toDTOList(lauRepository.findAll());
    }

    public LauDTO getLauById(int lauId) {
        return lauMapper.toDTO(lauRepository.findOne(lauId));
    }

    public LauDTO getLauByCountryCodeAndLau2(String countryCode, String lau2) {
        return lauMapper.toDTO(lauRepository.findByCountryCodeAndLau2(countryCode, lau2));
    }

    public List<LauDTO> getLausByCountryCode(String countryCode) {
        return lauMapper.toDTOList(Lists.newArrayList(lauRepository.findByCountryCode(countryCode)));
    }

    public List<LauDTO> getLausByNuts3(String nuts3) {
        return lauMapper.toDTOList(Lists.newArrayList(lauRepository.findByNuts3(nuts3)));
    }

    // on the performance test we identified the cache on this method has a low reuse. Not recomended to cache this service.
    public List<LauDTO> getLausByCountryCodeAndName1ContainingIgnoreCase(String countryCode, String name1) {
        return lauMapper.toDTOList(Lists.newArrayList(lauRepository.findByCountryCodeAndName1ContainingIgnoreCaseOrderByName1(countryCode, name1)));
    }

    public LauDTO updatePhysicalAddress(LauDTO lauDTO) {
        return lauMapper.toDTO(lauRepository.save(lauMapper.toEntity(lauDTO)));
    }

    public List<LauDTO> getLauByName1Country(String country, String name) {
        return lauMapper.toDTOList(lauRepository.findLauByName1Country(country, name));
    }

    public List<LauDTO> getLauByName1(String name) {
        return lauMapper.toDTOList(lauRepository.findLauByName1(name));
    }
}