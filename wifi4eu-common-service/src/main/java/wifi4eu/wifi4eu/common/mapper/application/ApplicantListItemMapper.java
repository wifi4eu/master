package wifi4eu.wifi4eu.common.mapper.application;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ApplicantListItemDTO;
import wifi4eu.wifi4eu.entity.application.ApplicantListItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicantListItemMapper {
    ApplicantListItemDTO toDTO(ApplicantListItem entity);
    ApplicantListItem toEntity(ApplicantListItemDTO vo);
    List<ApplicantListItemDTO> toDTOList(List<ApplicantListItem> list);
    List<ApplicantListItem> toEntityList(List<ApplicantListItemDTO> list);
}