package wifi4eu.wifi4eu.repository.voucherManagement;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.voucherManagement.VoucherManagement;

import javax.transaction.Transactional;
import java.util.List;

public interface VoucherManagementRepository extends CrudRepository<VoucherManagement, Integer> {
    List<VoucherManagement> findAllByVoucherCallId(Integer callId);
}