package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;

import java.util.List;

public class MunicipalityValidator {

    public static void validateMunicipality(MunicipalityDTO municipalityDTO, LauDTO lau, List<NutsDTO> nutsList) throws Exception {
        if(lau.getId() != municipalityDTO.getLauId()){
            throw new Exception("Incorrect lau id");
        }
        Boolean nutsValidation = false;
        for(NutsDTO nuts : nutsList) {
            if(nuts.getLabel().equals(municipalityDTO.getCountry())){
                nutsValidation = true;
                break;
            }
        }
        if(!nutsValidation){
            throw new Exception("Incorrect country name");
        }

    }
}
