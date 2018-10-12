package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;

import java.util.List;

public interface VoucherSimulationRepository extends CrudRepository<VoucherSimulation, Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM voucher_simulations WHERE voucher_assignment = ?1", nativeQuery = true)
    void deleteVoucherSimulationByVoucherAssignment(int idVoucherAssignment);

    @Query("SELECT vs FROM VoucherSimulation vs JOIN vs.voucherAssignment a WHERE a.id =:idVoucherAssignment AND vs.selectionStatus != 2")
    List<VoucherSimulation> findAllByVoucherAssignmentAndStatusOrderByEuRank(@Param("idVoucherAssignment") int idVoucherAssignment);

    @Query(value = "SELECT CAST(CASE WHEN count(*) = 0 THEN 1 ELSE 0 END AS BIT) FROM voucher_simulations vs INNER JOIN applications a ON a.id = vs.application INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id WHERE va.status = 1 AND va.call = ?1 and a._status != 2 AND vs.selection_status != 2", nativeQuery = true)
    Boolean checkApplicationAreValidForFreezeList(int callId);

    @Query("SELECT vs FROM VoucherSimulation vs JOIN vs.voucherAssignment a WHERE a.id =:idVoucherAssignment")
    List<VoucherSimulation> findAllByVoucherAssignmentOrderByEuRank(@Param("idVoucherAssignment") int idVoucherAssignment);

    @Query("SELECT vs FROM VoucherSimulation vs JOIN vs.voucherAssignment a INNER JOIN vs.municipality m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%',:municipalityName,'%')) AND a.id =:idVoucherAssignment AND LOWER(vs.country) LIKE LOWER(CONCAT('%',:country,'%'))")
    Page<VoucherSimulation> findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByEuRank(@Param("idVoucherAssignment") int idVoucherAssignment, @Param("country") String country, @Param("municipalityName") String municipalityName, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE applications SET pre_selected_flag = ?1 WHERE id IN (SELECT application FROM voucher_simulations WHERE voucher_assignment = ?2)", nativeQuery = true)
    void updateApplicationsInVoucherSimulationByVoucherAssignment(int status, int idVoucherAssignment);

    /** Methods for sorting by municipalityName */

    @Query(value = "SELECT vs.* FROM voucher_simulations vs INNER JOIN municipalities m ON vs.municipality = m.id WHERE vs.voucher_assignment = ?#{[0]} AND LOWER(m.name) LIKE LOWER(CONCAT('%',?#{[1]},'%')) AND LOWER(vs.country) LIKE LOWER(CONCAT('%',?#{[2]},'%')) ORDER BY CASE WHEN ?#{[5]} = 'DESC' THEN m.name END DESC, CASE WHEN ?#{[5]} = 'ASC' THEN m.name END ASC OFFSET ?#{[3]} ROWS FETCH NEXT ?#{[4]} ROWS ONLY", nativeQuery = true)
    List<VoucherSimulation> findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByMunicipalityName(Integer voucherAssignmentId, String municipality, String country, Integer offset, Integer count, String orderDirection);

    @Query(value = "SELECT count(*) FROM voucher_simulations vs INNER JOIN municipalities m ON vs.municipality = m.id WHERE vs.voucher_assignment = ?#{[0]} AND LOWER(m.name) LIKE LOWER(CONCAT('%',?#{[1]},'%')) AND LOWER(vs.country) LIKE LOWER(CONCAT('%',?#{[2]},'%'))", nativeQuery = true)
    Integer countAllByVoucherAssignmentAndMunicipalityInCountryOrderedByMunicipalityName(Integer voucherAssignmentId, String municipality, String country);

    @Query(value = "SELECT count(*) FROM voucher_simulations vs INNER JOIN applications a ON vs.application = a.id WHERE vs.voucher_assignment = ?1 AND (vs.num_applications > 1 OR a._status != 2)", nativeQuery = true)
    Integer checkIfSimulationIsValid(int voucherAssignmentId);
}