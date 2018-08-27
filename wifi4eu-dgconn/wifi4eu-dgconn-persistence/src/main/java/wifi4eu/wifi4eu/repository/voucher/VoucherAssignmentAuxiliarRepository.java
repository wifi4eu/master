package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignmentAuxiliar;

public interface VoucherAssignmentAuxiliarRepository extends CrudRepository<VoucherAssignmentAuxiliar, Integer> {

    @Query(value = "SELECT id, execution_date, status, notified_date FROM voucher_assignments where call = ?1 AND status =?2", nativeQuery = true)
    VoucherAssignmentAuxiliar findByCallIdAndStatusAux(Integer callId, Integer status);
}
