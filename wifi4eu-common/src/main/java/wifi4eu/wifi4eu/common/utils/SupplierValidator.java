package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.helper.Validator;

public class SupplierValidator {

    public static void validateSupplier(SupplierDTO supplierDTO) throws Exception {
        if (supplierDTO.getStatus() != 0) {
            throw new Exception("Incorrect supplier status");
        }

        if ((Validator.isNull(supplierDTO.getAccountNumber()) || supplierDTO.getAccountNumber().trim().isEmpty()) || (Validator.isNull(supplierDTO.getAddress()) || supplierDTO.getAddress().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getBic()) || supplierDTO.getBic().trim().isEmpty()) || (Validator.isNull(supplierDTO.getBic()) || supplierDTO.getBic().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getContactEmail()) || supplierDTO.getContactEmail().trim().isEmpty()) || (Validator.isNull(supplierDTO.getName()) || supplierDTO.getName().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getVat()) || supplierDTO.getVat().trim().isEmpty())) {
            throw new Exception("Some field is empty!");
        }
    }
}
