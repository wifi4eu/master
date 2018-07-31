package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;

import java.util.ArrayList;

public interface VoucherAssignmentRepository extends JpaRepository<VoucherAssignment, Integer> {

    @Query(value = "SELECT id, execution_date, status FROM voucher_assignments where call = ?1 AND status = 1", nativeQuery = true)
    VoucherAssignment findByCallId(Integer callId);

    VoucherAssignment findByCallIdAndStatusEquals(int callId, int status);

    @Query(value = "SELECT id, notified_date FROM voucher_assignments where notified_date IS NOT NULL", nativeQuery = true)
    ArrayList<VoucherAssignment.VoucherAssignmentGetIdAndNotificationDate> findByNotifiedDateNotNull();

}
