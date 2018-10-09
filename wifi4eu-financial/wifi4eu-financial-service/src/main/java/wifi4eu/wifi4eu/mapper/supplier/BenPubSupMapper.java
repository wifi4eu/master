package wifi4eu.wifi4eu.common.mapper.supplier;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;
import wifi4eu.wifi4eu.entity.supplier.BenPubSup;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BenPubSupMapper {
    BenPubSupDTO toDTO(BenPubSup entity);

    BenPubSup toEntity(BenPubSupDTO vo);

    List<BenPubSupDTO> toDTOList(List<BenPubSup> list);

    List<BenPubSup> toEntityList(List<BenPubSupDTO> list);
}