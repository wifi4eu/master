package wifi4eu.wifi4eu.mapper.voucher;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;

import java.util.List;

@Mapper(componentModel = "spring", uses = {VoucherSimulationMapper.class})
public interface VoucherAssignmentMapper {

    @Mappings({
            @Mapping(source = "entity.call.id", target="call.id"),
            @Mapping(source = "entity.user.id", target = "user.id")
    })
    VoucherAssignmentDTO toDTO(VoucherAssignment entity);
    @Mappings({
            @Mapping(source = "vo.call.id", target="call.id"),
            @Mapping(source = "vo.user.id", target = "user.id")
    })
    VoucherAssignment toEntity(VoucherAssignmentDTO vo);

    List<VoucherAssignmentDTO> toDTOList(List<VoucherAssignment> list);
    List<VoucherAssignment> toEntityList(List<VoucherAssignmentDTO> list);
}