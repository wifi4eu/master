package wifi4eu.wifi4eu.mapper.municipality;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.mapper.user.UserMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MunicipalityMapper {
    @Mappings({
            @Mapping(source = "entity.lau.id", target = "lauId"),
            @Mapping(ignore = true, target = "registrations")
    })
    MunicipalityDTO toDTO(Municipality entity);

    @Mapping(source = "vo.lauId", target = "lau.id")
    Municipality toEntity(MunicipalityDTO vo);

    @Mappings({
            @Mapping(source = "entity.municipality.id", target = "municipalityId")
    })
    RegistrationDTO toDTO(Registration entity);

    @Mappings({
            @Mapping(source = "vo.municipalityId", target = "municipality.id")
    })
    Registration toEntity(RegistrationDTO vo);

    List<MunicipalityDTO> toDTOList(List<Municipality> list);

    List<Municipality> toEntityList(List<MunicipalityDTO> list);

}