package wifi4eu.wifi4eu.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.user.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    Iterable<User> findByType(Integer type);
    User findByEmail(String email);
    User findByEcasUsername(String ecasUsername);
    User findByEcasEmail(String email);

//    @Query("SELECT r.user FROM Application a INNER JOIN Registration r ON a.registrationId = r.id WHERE a.id NOT IN (SELECT vs.application FROM VoucherSimulation vs WHERE vs.voucherAssignment.id =:voucherAssignmentId)")
//    List<User> getApplicationsNotSelectedInVoucherAssignment(@Param("callId") Integer callId, @Param("voucherAssignmentId") Integer voucherAssignmentId);
//
//    @Query("SELECT r.user FROM Application a INNER JOIN Registration r ON a.registrationId = r.id WHERE a.id IN (SELECT vs.application FROM VoucherSimulation vs WHERE vs.selectionStatus =:selectionStatus AND vs.voucherAssignment.id =:voucherAssignmentId)")
//    List<User> getApplicationsSelectedInVoucherAssignment(@Param("callId") Integer callId, @Param("voucherAssignmentId") Integer voucherAssignmentId, @Param("selectionStatus") Integer selectionStatus);

    @Query(value = "SELECT u.* FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN users u ON r._user = u.id WHERE a.id NOT IN (SELECT vs.application FROM voucher_simulations vs WHERE vs.voucher_assignment = ?2) AND a.call_id = ?1", nativeQuery = true)
    List<User> getApplicationsNotSelectedInVoucherAssignment(Integer callId, Integer voucherAssignmentId);

    @Query(value = "SELECT u.* FROM applications a INNER JOIN registrations r ON a.registration = r.id INNER JOIN users u ON r._user = u.id WHERE a.id IN (SELECT vs.application FROM voucher_simulations vs WHERE vs.voucher_assignment = ?1 AND vs.selection_status = ?2)", nativeQuery = true)
    List<User> getApplicationsSelectedInVoucherAssignment(Integer voucherAssignmentId, Integer selectionStatus);
}