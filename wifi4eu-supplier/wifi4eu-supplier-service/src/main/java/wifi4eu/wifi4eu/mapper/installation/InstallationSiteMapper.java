package wifi4eu.wifi4eu.mapper.installation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.InstallationSiteDTO;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstallationSiteMapper {

    /*
    @Mapping(source = "entity.municipality.id", target = "municipality.id")
    InstallationSiteDTO toDTO(InstallationSite entity);
    @Mapping(source = "vo.municipality.id", target = "municipality.id")
    InstallationSite toEntity(InstallationSiteDTO vo);
    List<InstallationSiteDTO> toDTOList(List<InstallationSite> list);
    List<InstallationSite> toEntityList(List<InstallationSiteDTO> list);
    */
}
