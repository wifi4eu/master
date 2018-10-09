package wifi4eu.wifi4eu.common.mapper.voucher;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.VoucherDTO;
import wifi4eu.wifi4eu.entity.voucher.Voucher;

import java.util.List;

/**
 * Created by rgarcita on 23/02/2017.
 */
@Mapper(componentModel = "spring")
public interface VoucherMapper {

    VoucherDTO toDTO(Voucher entity);

    Voucher toEntity(VoucherDTO vo);

    List<VoucherDTO> toDTOList(List<Voucher> list);

    List<Voucher> toEntityList(List<VoucherDTO> list);


}
