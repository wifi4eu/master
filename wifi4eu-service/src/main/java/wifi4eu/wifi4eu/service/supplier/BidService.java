package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.BidDTO;
import wifi4eu.wifi4eu.mapper.supplier.BidMapper;
import wifi4eu.wifi4eu.repository.supplier.BidRepository;

import java.util.List;

@Service
public class BidService {

    Logger _log = LoggerFactory.getLogger(BidService.class);

    @Autowired
    BidRepository bidRepository;

    @Autowired
    BidMapper bidMapper;


    public List<BidDTO> getAllBids() {
        return bidMapper.toDTOList(Lists.newArrayList(bidRepository.findAll()));
    }

    public BidDTO getBid(Long bidId) {
        return bidMapper.toDTO(bidRepository.findOne(bidId));
    }

    public BidDTO createBid(BidDTO bidDTO) {
        return bidMapper.toDTO(bidRepository.save(bidMapper.toEntity(bidDTO)));
    }

}
