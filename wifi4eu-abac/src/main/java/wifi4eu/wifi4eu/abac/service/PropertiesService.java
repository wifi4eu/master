package wifi4eu.wifi4eu.abac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.repository.PropertiesRepository;

@Service
public class PropertiesService {

    @Autowired
    private PropertiesRepository propertiesRepository;

    public String findPropertyByKey(String key){
        return propertiesRepository.findFirstByNameEquals(key);
    }
}
