package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;

public class BeneficiaryValidator {

    public static void validateBeneficiary(BeneficiaryDTO beneficiaryDTO) throws Exception {
        UserDTO user = beneficiaryDTO.getUser();

        if (beneficiaryDTO.isRepresentsMultipleMunicipalities()) {
            if (beneficiaryDTO.getAssociationName() != null
                    && beneficiaryDTO.getAssociationName().trim().isEmpty()) {
                throw new Exception("Association name field is empty!");
            }
        }
        for (MayorDTO mayorDTO : beneficiaryDTO.getMayors()) {
            MayorValidator.validateMayor(mayorDTO);
        }

        for (MunicipalityDTO municipalityDTO : beneficiaryDTO.getMunicipalities()) {
            MunicipalityValidator
        }

        if (user.getAddress() != null && user.getAddressNum() != null && user.getName() != null && user.getEmail() != null && user.getSurname() != null && user.getPostalCode() != null && user.getCity() != null && user.getCountry() != null
                && user.getAddress().trim().isEmpty() || user.getAddressNum().trim().isEmpty() || user.getName().trim().isEmpty() || user.getEmail().trim().isEmpty() || user.getSurname().trim().isEmpty() || user.getPostalCode().trim().isEmpty()
                && user.getCountry().trim().isEmpty() || user.getCity().trim().isEmpty()) {
            throw new Exception("Some user field is empty!");
        }
    }
}
