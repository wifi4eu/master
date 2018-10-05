package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.helper.Validator;

public class BeneficiaryValidator {

    public static void validateBeneficiary(BeneficiaryDTO beneficiaryDTO) throws Exception {
        if (beneficiaryDTO.getOrganisationId() > 0 && (Validator.isNull(beneficiaryDTO.getAssociationName()) || Validator.isEmpty(beneficiaryDTO
                .getAssociationName()))) {
            throw new Exception("Association name field is empty!");
        }

        MayorValidator.validateArrayMayors(beneficiaryDTO.getMayors());

        MunicipalityValidator.validateArrayMunicipalitiesNotEmptyValues(beneficiaryDTO.getMunicipalities());

        UserValidator.validateBeneficiarySubmit(beneficiaryDTO.getUser());
    }
}
