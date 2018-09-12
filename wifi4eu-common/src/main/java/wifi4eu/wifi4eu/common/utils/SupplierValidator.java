package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.helper.Validator;

public class SupplierValidator {

    public static void validateSupplierCreate(SupplierDTO supplierDTO) throws Exception {
        if (supplierDTO.getStatus() != 0) {
            throw new Exception("Incorrect supplier status");
        }

        if ((Validator.isNull(supplierDTO.getStreet()) || supplierDTO.getStreet().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getStreetNumber()) || supplierDTO.getStreetNumber().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getPostalCode()) || supplierDTO.getPostalCode().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getCity()) || supplierDTO.getCity().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getCountry()) || supplierDTO.getCountry().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getContactEmail()) || supplierDTO.getContactEmail().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getName()) || supplierDTO.getName().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getVat()) || supplierDTO.getVat().trim().isEmpty()) || (Validator.isNull(supplierDTO.getContactNumber()) || supplierDTO.getContactNumber().trim().isEmpty()) || (Validator.isNull(supplierDTO.getContactPrefix()) || supplierDTO.getContactPrefix().trim().isEmpty())) {
            throw new Exception("Some field is empty!");
        }
        if (supplierDTO.getStreet().length() > 255 || supplierDTO.getStreetNumber().length() > 255 || supplierDTO.getPostalCode().length() > 255 || supplierDTO.getCity().length() > 255 || supplierDTO.getCountry().length() > 255
                || supplierDTO.getContactEmail().length() > 255 || supplierDTO.getName().length() > 255 || supplierDTO.getVat().length() > 255) {
            throw new Exception("Too many characters in some field!");
        }
    }

    public static void validateSupplierUpdate(SupplierDTO supplierDTO) throws Exception {
        if (supplierDTO.getStatus() != 0) {
            throw new Exception("Incorrect supplier status");
        }

        if ((Validator.isNull(supplierDTO.getAddress()) || supplierDTO.getAddress().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getContactEmail()) || supplierDTO.getContactEmail().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getName()) || supplierDTO.getName().trim().isEmpty())
                || (Validator.isNull(supplierDTO.getVat()) || supplierDTO.getVat().trim().isEmpty())) {
            throw new Exception("Some field is empty!");
        }
        if (supplierDTO.getAddress().length() > 255 || supplierDTO.getContactEmail().length() > 255 || supplierDTO.getName().length() > 255 || supplierDTO.getVat().length() > 255) {
            throw new Exception("Too many characters in some field!");
        }
    }
}
