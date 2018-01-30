package wifi4eu.wifi4eu.repository.voucherManagement;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.voucherManagement.VoucherManagement;

import javax.transaction.Transactional;

public interface VoucherManagementRepository extends CrudRepository<VoucherManagement, Integer> {
    Iterable<VoucherManagement> findAllByVoucherCall(Integer callId);
}