package wifi4eu.wifi4eu.common.utils;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.helper.Validator;

import java.util.List;

public class MayorValidator {

    public static void validateMayor(MayorDTO mayor) throws Exception {
        //we validate that the municipality has no null values
        if (Validator.isNull(mayor.getName()) || Validator.isNull(mayor.getSurname()) || Validator.isNull(mayor.getEmail()) || Validator.isEmpty
                (mayor.getName()) || Validator.isEmpty(mayor.getSurname()) || Validator.isEmpty(mayor.getEmail()) || !mayor.getEmail().matches
                (Constant.EMAIL_PATTERN)) {
            throw new Exception("Incorrect mayor data");
        }
    }

    public static void validateArrayMayors(List<MayorDTO> mayors) throws Exception {
        for (MayorDTO mayor : mayors) {
            validateMayor(mayor);
        }
    }
}
