package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;

import java.util.List;

public interface VoucherAssignmentRepository extends CrudRepository<VoucherAssignment, Integer> {

    VoucherAssignment findByCallId(@Param("callId") Integer callId);

}
