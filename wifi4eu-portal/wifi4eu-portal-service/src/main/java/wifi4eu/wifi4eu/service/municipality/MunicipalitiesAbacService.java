package wifi4eu.wifi4eu.service.municipality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.repository.municipality.MunicipalitiesAbacRepository;

@Service
public class MunicipalitiesAbacService {

    @Autowired
    MunicipalitiesAbacRepository municipalityRepository;

    public boolean isMunicipalityLefValidated(Integer municipalityId){
        String abacReference = municipalityRepository.getAbacReferenceByMunicipalityId(municipalityId);
        if(Validator.isNull(abacReference)){
            return false;
        }
        return !abacReference.isEmpty();
    }

}
