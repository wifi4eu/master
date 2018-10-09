package wifi4eu.wifi4eu.common.mapper.voucher;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.VoucherSimulationDTO;
import wifi4eu.wifi4eu.common.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.common.mapper.user.UserMapper;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;


import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ApplicationMapper.class})
public interface VoucherSimulationMapper {

    @Mappings({
            @Mapping(source = "entity.municipality.id", target = "municipality"),
            @Mapping(source = "entity.voucherAssignment.id", target = "voucherAssignment")
    })
    VoucherSimulationDTO toDTO(VoucherSimulation entity);
    @Mappings({
            @Mapping(source = "vo.municipality", target = "municipality.id"),
            @Mapping(source = "vo.voucherAssignment", target = "voucherAssignment.id")
    })
    VoucherSimulation toEntity(VoucherSimulationDTO vo);

    List<VoucherSimulationDTO> toDTOList(List<VoucherSimulation> list);
    List<VoucherSimulation> toEntityList(List<VoucherSimulationDTO> list);
}
