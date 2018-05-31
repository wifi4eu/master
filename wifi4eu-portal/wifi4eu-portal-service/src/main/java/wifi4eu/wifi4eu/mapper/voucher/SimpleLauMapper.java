package wifi4eu.wifi4eu.mapper.voucher;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.SimpleLauDTO;
import wifi4eu.wifi4eu.entity.voucher.SimpleLau;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SimpleLauMapper {
    SimpleLauDTO toDTO(SimpleLau entity);
    SimpleLau toEntity(SimpleLauDTO vo);
    List<SimpleLauDTO> toDTOList(List<SimpleLau> list);
    List<SimpleLau> toEntityList(List<SimpleLauDTO> list);
}