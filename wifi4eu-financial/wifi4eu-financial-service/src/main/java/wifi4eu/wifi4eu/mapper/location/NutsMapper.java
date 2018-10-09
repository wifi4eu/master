package wifi4eu.wifi4eu.common.mapper.location;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.dto.security.RightDTO;
import wifi4eu.wifi4eu.entity.location.Nuts;
import wifi4eu.wifi4eu.entity.security.Right;
import wifi4eu.wifi4eu.common.mapper.security.RoleMapper;

import java.util.List;

/**
 * Created by rgarcita on 08/02/2017.
 */


@Mapper(componentModel = "spring")
public interface NutsMapper {

    NutsDTO toDTO(Nuts entity);

    Nuts toEntity(NutsDTO vo);

    List<NutsDTO> toDTOList(List<Nuts> list);

    List<Nuts> toEntityList(List<NutsDTO> list);


}
