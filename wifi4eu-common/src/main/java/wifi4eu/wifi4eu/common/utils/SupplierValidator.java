package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;

public class SupplierValidator {

    public static void validateSupplier(SupplierDTO supplierDTO) throws Exception {
        if(supplierDTO.getStatus() != 0){
            throw new Exception("Incorrect supplier status");
        }
    }
}
