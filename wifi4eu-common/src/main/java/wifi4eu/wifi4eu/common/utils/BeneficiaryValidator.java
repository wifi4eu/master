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
            if (beneficiaryDTO.getAssociationName() != null) {
                if (beneficiaryDTO.getAssociationName().trim().compareTo("") == 0) {
                    throw new Exception("Association name field is empty!");
                } else {
                    throw new Exception("Association name field is empty!");
                }
            }
        }
        for (MayorDTO mayorDTO : beneficiaryDTO.getMayors()) {
            if (mayorDTO.getEmail() != null || mayorDTO.getName() != null || mayorDTO.getSurname() != null) {
                if (mayorDTO.getEmail().trim().compareTo("") == 0 || mayorDTO.getName().trim().compareTo("") == 0 || mayorDTO.getSurname().trim().compareTo("") == 0) {
                    throw new Exception("Some beneficiary field is empty!");
                }
            } else {
                throw new Exception("Some beneficiary field is empty!");
            }
        }
        for (MunicipalityDTO municipalityDTO : beneficiaryDTO.getMunicipalities()) {
            if (municipalityDTO.getAddress() != null || municipalityDTO.getAddressNum() != null || municipalityDTO.getName() != null || municipalityDTO.getCountry() != null || municipalityDTO.getPostalCode() != null) {
                if (municipalityDTO.getAddress().trim().compareTo("") == 0 || municipalityDTO.getAddressNum().trim().compareTo("") == 0 || municipalityDTO.getName().trim().compareTo("") == 0
                        || municipalityDTO.getCountry().trim().compareTo("") == 0 || municipalityDTO.getPostalCode().trim().compareTo("") == 0) {
                    throw new Exception("Some municipality field is empty!");
                }
            } else {
                throw new Exception("Some municipality field is empty!");
            }
        }

        if (user.getAddress() != null || user.getAddressNum() != null || user.getName() != null ||
                user.getEmail() != null || user.getSurname() != null || user.getPostalCode() != null) {
            if (user.getAddress().trim().compareTo("") == 0 || user.getAddressNum().trim().compareTo("") == 0 || user.getName().trim().compareTo("") == 0 ||
                    user.getEmail().trim().compareTo("") == 0 || user.getSurname().trim().compareTo("") == 0 || user.getPostalCode().trim().compareTo("") == 0) {
                throw new Exception("Some user field is empty!");
            }
        } else {
            throw new Exception("Some user field is empty!");
        }

    }
}
