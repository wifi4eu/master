package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignmentAuxiliar;

public interface VoucherAssignmentAuxiliarRepository extends CrudRepository<VoucherAssignmentAuxiliar, Integer> {

    @Query(value = "SELECT id, execution_date, status FROM voucher_assignments where call = ?1", nativeQuery = true)
    VoucherAssignmentAuxiliar findByCallIdAux(Integer callId);
}
