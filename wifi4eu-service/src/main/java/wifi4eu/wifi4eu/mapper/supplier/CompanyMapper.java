package wifi4eu.wifi4eu.mapper.supplier;

import wifi4eu.wifi4eu.common.dto.model.CompanyDTO;
import wifi4eu.wifi4eu.entity.supplier.Company;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO toDTO(Company entity);

    Company toEntity(CompanyDTO vo);

    List<CompanyDTO> toDTOList(List<Company> list);

    List<Company> toEntityList(List<CompanyDTO> list);
}