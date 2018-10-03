package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.helper.Validator;

import java.util.List;

public class MunicipalityValidator {

    public static void validateArrayMunicipalitiesNotEmptyValues(List<MunicipalityDTO> municipalities) throws Exception{
        for (MunicipalityDTO municipalityDTO : municipalities) {
            validateNotEmptyValuesMunicipality(municipalityDTO);
        }
    }

    public static void validateNotEmptyValuesMunicipality(MunicipalityDTO municipalityDTO)throws Exception {
        //we validate that the municipality has no null values
        if (Validator.isNull(municipalityDTO.getAddressNum()) || Validator.isNull(municipalityDTO.getAddress()) || Validator.isNull(municipalityDTO
                .getPostalCode()) || Validator.isNull(municipalityDTO.getName()) || Validator.isNull(municipalityDTO.getCountry()) || Validator.isNull(municipalityDTO.getLauId()) ||
                Validator.isEmpty(municipalityDTO.getAddressNum()) || Validator.isEmpty(municipalityDTO.getAddress()) || Validator.isEmpty(municipalityDTO
                .getPostalCode()) || Validator.isEmpty(municipalityDTO.getName()) || Validator.isEmpty(municipalityDTO.getCountry())){
            throw new Exception("Incorrect municipality data");
        }
    }

    public static void validateLauMunicipality(MunicipalityDTO municipalityDTO, LauDTO lau, List<NutsDTO> nutsList) throws Exception {
        if (lau.getId() != municipalityDTO.getLauId()) {
            throw new Exception("Incorrect lau id");
        }
        Boolean nutsValidation = false;
        for (NutsDTO nuts : nutsList) {
            if (nuts.getLabel().equals(municipalityDTO.getCountry())) {
                nutsValidation = true;
                break;
            }
        }
        if (!nutsValidation) {
            throw new Exception("Incorrect country name");
        }
    }
}
