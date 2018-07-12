package wifi4eu.wifi4eu.mapper.supplier;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.SupplierUserDTO;
import wifi4eu.wifi4eu.entity.supplier.SupplierUser;
import wifi4eu.wifi4eu.mapper.user.UserMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, SupplierMapper.class})
public interface SupplierUserMapper {

    @Mappings({
            @Mapping(source = "userDTO.id", target = "user.id"),
            @Mapping(source = "supplierDTO.id", target = "supplier.id")
    })
    SupplierUser toEntity(SupplierUserDTO vo);

    @Mappings({
            @Mapping(source = "user.id", target = "userDTO.id"),
            @Mapping(source = "supplier.id", target = "supplierDTO.id")
    })
    SupplierUserDTO toDTO(SupplierUser entity);


    List<SupplierUserDTO> toDTOList(List<SupplierUser> list);

    List<SupplierUser> toEntityList(List<SupplierUserDTO> list);

}
