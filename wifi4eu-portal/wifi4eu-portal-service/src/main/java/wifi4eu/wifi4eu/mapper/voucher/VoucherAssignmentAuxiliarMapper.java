package wifi4eu.wifi4eu.mapper.voucher;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentAuxiliarDTO;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignmentAuxiliar;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoucherAssignmentAuxiliarMapper {
    VoucherAssignmentAuxiliarDTO toDTO(VoucherAssignmentAuxiliar entity);

    VoucherAssignmentAuxiliar toEntity(VoucherAssignmentAuxiliarDTO vo);

    List<VoucherAssignmentAuxiliarDTO> toDTOList(List<VoucherAssignmentAuxiliar> list);

    List<VoucherAssignmentAuxiliar> toEntityList(List<VoucherAssignmentAuxiliarDTO> list);
}
