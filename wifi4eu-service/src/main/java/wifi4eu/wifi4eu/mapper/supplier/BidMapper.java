package wifi4eu.wifi4eu.mapper.supplier;

import wifi4eu.wifi4eu.common.dto.model.BidDTO;
import wifi4eu.wifi4eu.entity.supplier.Bid;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BidMapper {
    BidDTO toDTO(Bid entity);

    Bid toEntity(BidDTO vo);

    List<BidDTO> toDTOList(List<Bid> list);

    List<Bid> toEntityList(List<BidDTO> list);
}