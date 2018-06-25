package wifi4eu.wifi4eu.mapper.voucher;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.SimpleRegistrationDTO;
import wifi4eu.wifi4eu.entity.voucher.SimpleRegistration;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SimpleRegistrationMapper {

    SimpleRegistration toEntity(SimpleRegistrationDTO simpleRegistrationDTO);
    SimpleRegistrationDTO toDTO(SimpleRegistration simpleRegistration);
    List<SimpleRegistration> toEntityList(List<SimpleRegistrationDTO> simpleRegistrationDTOS);
    List<SimpleRegistrationDTO> toDTOList(List<SimpleRegistration> simpleRegistrations);

}
