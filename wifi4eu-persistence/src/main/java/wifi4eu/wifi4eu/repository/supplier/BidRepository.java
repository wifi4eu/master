package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.Bid;

import java.util.List;

public interface BidRepository extends CrudRepository<Bid, Long> {
}
