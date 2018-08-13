package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.helper.Validator;

public class UserValidator {

    public static void validateUser(UserDTO userDTO) throws Exception {
        if (userDTO == null) {
            throw new Exception("Empty user");
        }
        if ((Validator.isNull(userDTO.getName()) || userDTO.getName().trim().isEmpty() || userDTO.getName().length() > 255)
                || (Validator.isNull(userDTO.getSurname()) || userDTO.getSurname().trim().isEmpty() || userDTO.getSurname().length() > 255)) {
            throw new Exception("Incorrect data in some field!");
        }
    }

    public static void validateUserContact(UserDTO userDTO) throws Exception {
        if (userDTO == null) {
            throw new Exception("Empty user");
        }
        if ((Validator.isNull(userDTO.getName()) || userDTO.getName().trim().isEmpty() || userDTO.getName().length() > 255)
                || (Validator.isNull(userDTO.getSurname()) || userDTO.getSurname().trim().isEmpty() || userDTO.getSurname().length() > 255)
                || (Validator.isNull(userDTO.getPhone_prefix()) || userDTO.getPhone_prefix().trim().isEmpty() || userDTO.getPhone_prefix().length() > 255)
                || (Validator.isNull(userDTO.getPhone_number()) || userDTO.getPhone_number().trim().isEmpty() || userDTO.getPhone_number().length() > 255)) {
            throw new Exception("Incorrect data in some field!");
        }
    }

}
