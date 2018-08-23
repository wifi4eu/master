package wifi4eu.wifi4eu.abac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.Properties;
import wifi4eu.wifi4eu.abac.data.repository.PropertiesRepository;

import java.util.Optional;

@Service
public class PropertiesService {

    @Autowired
    private PropertiesRepository propertiesRepository;

    public String findPropertyByKey(String key){
        Optional<Properties> property = Optional.ofNullable(propertiesRepository.findFirstByNameEquals(key));
        return property.orElse(new Properties()).getValue();
    }
}
