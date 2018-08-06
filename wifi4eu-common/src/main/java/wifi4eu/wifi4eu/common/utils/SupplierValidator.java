package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;

public class SupplierValidator {

    public static void validateSupplier(SupplierDTO supplierDTO) throws Exception {
        if (supplierDTO.getStatus() != 0) {
            throw new Exception("Incorrect supplier status");
        }
        if (supplierDTO.getAccountNumber() != null && supplierDTO.getAddress() != null && supplierDTO.getBic() != null && supplierDTO.getContactEmail() != null && supplierDTO.getName() != null && supplierDTO.getVat() != null
                && supplierDTO.getAccountNumber().trim().isEmpty() || supplierDTO.getAddress().trim().isEmpty() || supplierDTO.getBic().trim().isEmpty() || supplierDTO.getContactEmail().trim().isEmpty() || supplierDTO.getName().trim().isEmpty() || supplierDTO.getVat().trim().isEmpty()) {
            throw new Exception("Some field is empty!");
        }
    }
}
