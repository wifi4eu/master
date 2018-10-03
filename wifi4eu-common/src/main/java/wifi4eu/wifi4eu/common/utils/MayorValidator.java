package wifi4eu.wifi4eu.common.utils;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.helper.Validator;

import java.util.List;

public class MayorValidator {

    private static String emailPattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9]" +
            "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
            "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    public static void validateMayor(MayorDTO mayor) throws Exception {
        //we validate that the municipality has no null values
        if (Validator.isNull(mayor.getName()) || Validator.isNull(mayor.getSurname()) || Validator.isNull(mayor.getEmail()) || Validator.isEmpty
                (mayor.getName()) || Validator.isEmpty(mayor.getSurname()) || Validator.isEmpty(mayor.getEmail()) || !mayor.getEmail().matches
                (emailPattern)) {
            throw new Exception("Incorrect mayor data");
        }
    }
}
