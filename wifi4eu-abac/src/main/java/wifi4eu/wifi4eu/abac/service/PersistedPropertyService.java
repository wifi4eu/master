package wifi4eu.wifi4eu.abac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.PersistedProperty;
import wifi4eu.wifi4eu.abac.data.repository.PersistedPropertyRepository;

import java.util.Optional;

@Service
public class PersistedPropertyService {

    @Autowired
    private PersistedPropertyRepository persistedPropertyRepository;

    public String findPropertyByKey(String key){
        Optional<PersistedProperty> property = Optional.ofNullable(persistedPropertyRepository.findFirstByNameEquals(key));
        return property.orElse(new PersistedProperty()).getValue();
    }
}
