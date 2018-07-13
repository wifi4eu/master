package wifi4eu.wifi4eu.mapper.supplier;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.SupplierUserDTO;
import wifi4eu.wifi4eu.entity.supplier.SupplierUser;
import wifi4eu.wifi4eu.mapper.user.UserMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, SupplierMapper.class})
public interface SupplierUserMapper {

    SupplierUser toEntity(SupplierUserDTO vo);

    SupplierUserDTO toDTO(SupplierUser entity);

    List<SupplierUserDTO> toDTOList(List<SupplierUser> list);

    List<SupplierUser> toEntityList(List<SupplierUserDTO> list);

}
