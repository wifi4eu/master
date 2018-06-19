package wifi4eu.wifi4eu.service.municipality;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityCacheDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.location.NutsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service("publicMunicipalityService")
public class MunicipalityService {
    @Autowired
    MunicipalityMapper municipalityMapper;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    NutsService nutsService;

    private final static Logger _log = LogManager.getLogger(MunicipalityService.class);

    @Cacheable(value = "publicGetMunicipalitiesCountGroupedByLauId")
    public List<Object> getMunicipalitiesCountGroupedByLauId() {
        return Lists.newArrayList(municipalityRepository.findMunicipalitiesCountGroupedByLauId());
    }

    @Cacheable(value = "publicGetMunicipalitiesRegisteredByCountry")
    public MunicipalityCacheDTO getMunicipalitiesByCountry(String countryCode){
        List<NutsDTO> regions = nutsService.getNutsByCountryCodeAndLevelOrderByLabelAsc(countryCode,3);
        List<String> municipalities = new ArrayList<>();
        Date today = new Date();
        MunicipalityCacheDTO municipalityCacheDTO = new MunicipalityCacheDTO();
        municipalityCacheDTO.setDateCached(today);
        for(NutsDTO nutsDTO: regions){
            municipalities.addAll(municipalityRepository.getMunicipalitiesRegisteredByRegion(nutsDTO.getCode()));
        }
        Collections.sort(municipalities);
        municipalityCacheDTO.setMunicipalities(municipalities);
        return municipalityCacheDTO;
    }

    @Cacheable(value = "publicGetMunicipalitiesRegisteredByRegion")
    public MunicipalityCacheDTO getMunicipalitiesRegisteredByRegion(String code) {
        Date today = new Date();
        MunicipalityCacheDTO municipalityCacheDTO = new MunicipalityCacheDTO();
        municipalityCacheDTO.setDateCached(today);
        municipalityCacheDTO.setMunicipalities(municipalityRepository.getMunicipalitiesRegisteredByRegion(code));
        return municipalityCacheDTO;
    }
}