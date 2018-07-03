package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;

public class SupplierValidator {

    public static void validateSupplier(SupplierDTO supplierDTO) throws Exception {
        if (supplierDTO.getStatus() != 0) {
            throw new Exception("Incorrect supplier status");
        }
        if (supplierDTO.getAccountNumber() != null || supplierDTO.getAddress() != null || supplierDTO.getBic() != null
                || supplierDTO.getContactEmail() != null || supplierDTO.getContactPhoneNumber() != null ||
                supplierDTO.getContactPhonePrefix() != null || supplierDTO.getContactSurname() != null || supplierDTO.getName() != null || supplierDTO.getVat() != null) {
            if (supplierDTO.getAccountNumber().trim().compareTo("") == 0 || supplierDTO.getAddress().trim().compareTo("") == 0 || supplierDTO.getBic().trim().compareTo("") == 0
                    || supplierDTO.getContactEmail().trim().compareTo("") == 0 || supplierDTO.getContactPhoneNumber().trim().compareTo("") == 0 ||
                    supplierDTO.getContactPhonePrefix().trim().compareTo("") == 0 || supplierDTO.getContactSurname().trim().compareTo("") == 0 || supplierDTO.getName().trim().compareTo("") == 0 || supplierDTO.getVat().trim().compareTo("") == 0) {
                throw new Exception("Some field is empty!");
            }
        } else {
            throw new Exception("Some field is empty!");
        }
    }
}
