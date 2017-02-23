package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.voucher.Voucher;

import java.util.List;

/**
 * Created by rgarcita on 23/02/2017.
 */
public interface VoucherRepository extends CrudRepository<Voucher,Long> {
    List<Voucher> findByCallId(Long callId);
}
