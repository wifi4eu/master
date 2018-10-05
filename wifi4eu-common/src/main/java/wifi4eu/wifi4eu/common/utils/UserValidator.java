package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.helper.Validator;

public class UserValidator {

    public static void validateUser(UserDTO userDTO) throws Exception {
        if (userDTO == null) {
            throw new Exception("Empty user");
        }
        if ((Validator.isNull(userDTO.getName()) || userDTO.getName().trim().isEmpty() || userDTO.getName().length() > 255) || (Validator.isNull
                (userDTO.getSurname()) || userDTO.getSurname().trim().isEmpty() || userDTO.getSurname().length() > 255)) {
            throw new Exception("Incorrect data in some field!");
        }
    }

    //supplier
    public static void validateUserContact(UserDTO userDTO) throws Exception {
        if (userDTO == null) {
            throw new Exception("Empty user");
        }
        if ((Validator.isNull(userDTO.getName()) || userDTO.getName().trim().isEmpty() || userDTO.getName().length() > 255) || (Validator.isNull
                (userDTO.getSurname()) || userDTO.getSurname().trim().isEmpty() || userDTO.getSurname().length() > 255) || (Validator.isNull
                (userDTO.getPhonePrefix()) || userDTO.getPhonePrefix().trim().isEmpty() || userDTO.getPhonePrefix().length() > 255) || (Validator
                .isNull(userDTO.getPhoneNumber()) || userDTO.getPhoneNumber().trim().isEmpty() || userDTO.getPhoneNumber().length() > 255)) {
            throw new Exception("Incorrect data in some field!");
        }
    }

    public static void validateBeneficiary(UserDTO userDTO) throws Exception {
        if (Validator.isNull(userDTO) || userDTO.getType() != wifi4eu.wifi4eu.common.Constant.ROLE_REPRESENTATIVE || Validator.isNull(userDTO
                .getName()) || Validator.isNull(userDTO.getSurname()) || Validator.isNull(userDTO.getAddress()) || Validator.isNull(userDTO
                .getAddressNum()) || Validator.isNull(userDTO.getCity()) || Validator.isNull(userDTO.getCountry()) || Validator.isNull(userDTO
                .getPostalCode()) || userDTO.getAddress().isEmpty() || userDTO.getAddressNum().isEmpty() || userDTO.getCity().isEmpty() || userDTO
                .getCountry().isEmpty() || userDTO.getPostalCode().isEmpty() || userDTO.getName().isEmpty() || userDTO.getSurname().isEmpty() ||
                userDTO.getName().length() > 255 || userDTO.getSurname().length() > 255 || userDTO.getAddress().length() > 255 || userDTO
                .getAddressNum().length() > 255 || userDTO.getCity().length() > 255 || userDTO.getCountry().length() > 255 || userDTO.getPostalCode
                ().length() > 255) {
            throw new Exception("Incorrect data in user fields!");
        }
    }

    public static void validateBeneficiarySubmit(UserDTO userDTO) throws Exception {
        validateBeneficiary(userDTO);
        if (Validator.isNull(userDTO.getEmail()) || userDTO.getEmail().length() > 255 || !userDTO.getEmail().matches(Constant.EMAIL_PATTERN)) {
            throw new Exception("Incorrect data in user fields!");
        }
    }

}
