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
            if (mayorDTO.getEmail() != null && mayorDTO.getName() != null && mayorDTO.getSurname() != null
                    && mayorDTO.getEmail().trim().isEmpty() || mayorDTO.getName().trim().isEmpty() || mayorDTO.getSurname().trim().isEmpty()) {
                throw new Exception("Some beneficiary field is empty!");
            }
        }
        for (MunicipalityDTO municipalityDTO : beneficiaryDTO.getMunicipalities()) {
            if (municipalityDTO.getAddress() != null && municipalityDTO.getAddressNum() != null && municipalityDTO.getName() != null && municipalityDTO.getCountry() != null && municipalityDTO.getPostalCode() != null
                    && municipalityDTO.getAddress().trim().isEmpty() || municipalityDTO.getAddressNum().trim().isEmpty() || municipalityDTO.getName().trim().isEmpty() || municipalityDTO.getCountry().trim().isEmpty() || municipalityDTO.getPostalCode().trim().isEmpty()) {
                throw new Exception("Some municipality field is empty!");
            }
        }

        if (user.getAddress() != null && user.getAddressNum() != null && user.getName() != null && user.getEmail() != null && user.getSurname() != null && user.getPostalCode() != null
                && user.getAddress().trim().isEmpty() || user.getAddressNum().trim().isEmpty() || user.getName().trim().isEmpty() || user.getEmail().trim().isEmpty() || user.getSurname().trim().isEmpty() || user.getPostalCode().trim().isEmpty()) {
            throw new Exception("Some user field is empty!");
        }
    }
}
