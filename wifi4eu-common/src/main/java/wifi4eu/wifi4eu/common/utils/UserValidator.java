package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.helper.Validator;

public class UserValidator {

    public static void validateUser(UserDTO userDTO) throws Exception {
        if (userDTO == null) {
            throw new Exception("Empty user");
        }

        if ((Validator.isNull(userDTO.getName()) || userDTO.getName().trim() == null) || (Validator.isNull(userDTO.getSurname()) || userDTO.getSurname().trim() == null) || (Validator.isNull(userDTO.getEmail()) || userDTO.getEmail().trim() == null)) {
            throw new Exception("Some field is empty!");
        }
        if (userDTO.getName().length() > 255 || userDTO.getSurname().length() > 255 ||
                userDTO.getEmail().length() > 255) {
            throw new Exception("Too many characters in some field!");
        }
    }
}
