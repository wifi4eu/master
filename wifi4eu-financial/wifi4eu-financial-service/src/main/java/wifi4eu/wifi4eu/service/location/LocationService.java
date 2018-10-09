package wifi4eu.wifi4eu.service.location;

import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.mapper.location.LauMapper;
import wifi4eu.wifi4eu.common.mapper.location.NutsMapper;
import wifi4eu.wifi4eu.repository.location.LocationLauRepository;
import wifi4eu.wifi4eu.repository.location.LocationNutsRepository;

import java.util.List;

/**
 * Created by rgarcita on 08/02/2017.
 */
@Service
public class LocationService {

    private final static Logger _log = Logger.getLogger(LocationService.class);

    @Autowired
    LocationNutsRepository locationNutsRepository;

    @Autowired
    LocationLauRepository locationLauRepository;

    @Autowired
    NutsMapper nutsMapper;

    @Autowired
    LauMapper lauMapper;

    public List<NutsDTO> getNutsByLevel(long level) {
        if(_log.isDebugEnabled()) {
            _log.debug("Get NUTS with level: " + level);
        }
        return nutsMapper.toDTOList(Lists.newArrayList(locationNutsRepository.findByLevel(level)));
    }

    public List<NutsDTO> getAllNuts() {
        _log.debug("Get all NUTS");
        return nutsMapper.toDTOList(Lists.newArrayList(locationNutsRepository.findAll()));
    }

    public List<LauDTO> getLauByCountryCode(String countryCode){
        if(_log.isDebugEnabled()) {
            _log.debug("Get LAU from country: " + countryCode);
        }
        return lauMapper.toDTOList(Lists.newArrayList(locationLauRepository.findByCountryCode(countryCode)));
    }

    public List<LauDTO> getLauByNuts3(String nuts3){
        if(_log.isDebugEnabled()) {
            _log.debug("Get LAU from NUTS3: " + nuts3);
        }
        return lauMapper.toDTOList(Lists.newArrayList(locationLauRepository.findByNuts3(nuts3)));
    }

    public LauDTO getLauByLau2AndCountryCode(String lau2, String countryCode) {
        if (_log.isDebugEnabled()) {
            _log.debug("Get LAU from LAU2: " + lau2 + " and Country Code: " + countryCode);
        }
        return lauMapper.toDTO(locationLauRepository.findByLau2AndCountryCode(lau2, countryCode));
    }

    public NutsDTO getNutsByCode(String code) {
        if(_log.isDebugEnabled()) {
            _log.debug("Get NUTS with code: " + code);
        }
        return nutsMapper.toDTO(locationNutsRepository.findByCode(code));
    }

    public List<NutsDTO> getCountryRegions(String countryCode) {
        _log.debug("Get regions from " + countryCode);
        return nutsMapper.toDTOList(Lists.newArrayList(locationNutsRepository.findByLevelAndCountryCode(new Long(3), countryCode)));
    }
}
