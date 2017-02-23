package wifi4eu.wifi4eu.mapper.call;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.PublicationCallDTO;
import wifi4eu.wifi4eu.entity.call.PublicationCall;

import java.util.List;

/**
 * Created by rgarcita on 22/02/2017.
 */
@Mapper(componentModel = "spring")
public interface PublicationCallMapper {

    PublicationCallDTO toDTO(PublicationCall entity);

    PublicationCall toEntity(PublicationCallDTO vo);

    List<PublicationCallDTO> toDTOList(List<PublicationCall> list);

    List<PublicationCall> toEntityList(List<PublicationCallDTO> list);

}
