package wifi4eu.wifi4eu.mapper.supplier;

import wifi4eu.wifi4eu.common.dto.model.InstallationDetailDTO;
import wifi4eu.wifi4eu.entity.supplier.InstallationDetail;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface InstallationDetailMapper {
    InstallationDetailDTO toDTO(InstallationDetail entity);

    InstallationDetail toEntity(InstallationDetailDTO vo);

    List<InstallationDetailDTO> toDTOList(List<InstallationDetail> list);

    List<InstallationDetail> toEntityList(List<InstallationDetailDTO> list);
}