package wifi4eu.wifi4eu.common.mapper.voucherManagement;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.VoucherManagementDTO;
import wifi4eu.wifi4eu.entity.voucherManagement.VoucherManagement;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoucherManagementMapper {
//    @Mapping(source = "entity.voucherCall.id", target = "call_id")
    VoucherManagementDTO toDTO(VoucherManagement entity);

//    @Mapping(source = "vo.call_id", target = "voucherCall.id")
    VoucherManagement toEntity(VoucherManagementDTO vo);

    List<VoucherManagementDTO> toDTOList(List<VoucherManagement> list);

    List<VoucherManagement> toEntityList(List<VoucherManagementDTO> list);
}