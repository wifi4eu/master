package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignmentAuxiliar;

import java.util.List;

public interface VoucherAssignmentRepository extends CrudRepository<VoucherAssignment, Integer> {

    @Query(value = "SELECT id, execution_date, status FROM voucher_assignments where call = ?1", nativeQuery = true)
    VoucherAssignment findByCallId(Integer callId);

}
