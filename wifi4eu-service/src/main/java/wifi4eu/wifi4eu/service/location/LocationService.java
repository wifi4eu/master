package wifi4eu.wifi4eu.service.location;

import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.mapper.location.LauMapper;
import wifi4eu.wifi4eu.mapper.location.NutsMapper;
import wifi4eu.wifi4eu.repository.location.LocationLauRepository;
import wifi4eu.wifi4eu.repository.location.LocationNutsRepository;

import java.util.List;

/**
 * Created by rgarcita on 08/02/2017.
 */
@Service
public class LocationService {

    private final static Logger logger = Logger.getLogger(LocationService.class);

    @Autowired
    LocationNutsRepository locationNutsRepository;

    @Autowired
    LocationLauRepository locationLauRepository;

    @Autowired
    NutsMapper nutsMapper;

    @Autowired
    LauMapper lauMapper;

    public List<NutsDTO> getNutsByLevel(long level) {
        return nutsMapper.toDTOList(Lists.newArrayList(locationNutsRepository.findByLevel(level)));
    }

    public List<NutsDTO> getAllNuts() {
        return nutsMapper.toDTOList(Lists.newArrayList(locationNutsRepository.findAll()));
    }

    public List<LauDTO> getLauByCountryCode(String countryCode){
        return lauMapper.toDTOList(Lists.newArrayList(locationLauRepository.findByCountryCode(countryCode)));
    }

}
