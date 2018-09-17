package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;

import java.util.ArrayList;
import java.util.List;

public interface VoucherSimulationRepository extends CrudRepository<VoucherSimulation, Integer> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM voucher_simulations WHERE voucher_assignment = ?1", nativeQuery = true)
	void deleteVoucherSimulationByVoucherAssignment(int idVoucherAssignment);

	@Query("SELECT vs FROM VoucherSimulation vs JOIN vs.voucherAssignment a WHERE a.id =:idVoucherAssignment AND vs.selectionStatus != 2")
	List<VoucherSimulation> findAllByVoucherAssignmentAndStatusOrderByEuRank(
			@Param("idVoucherAssignment") int idVoucherAssignment);

	@Query(value = "SELECT CAST(CASE WHEN count(*) = 0 THEN 1 ELSE 0 END AS BIT) FROM voucher_simulations vs INNER JOIN applications a ON a.id = vs.application INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id WHERE va.status = 1 AND va.call = ?1 and a._status != 2 AND vs.selection_status != 2", nativeQuery = true)
	Boolean checkApplicationAreValidForFreezeList(int callId);

	@Query("SELECT vs FROM VoucherSimulation vs JOIN vs.voucherAssignment a WHERE a.id =:idVoucherAssignment")
	List<VoucherSimulation> findAllByVoucherAssignmentOrderByEuRank(
			@Param("idVoucherAssignment") int idVoucherAssignment);

	@Query("SELECT vs FROM VoucherSimulation vs JOIN vs.voucherAssignment a INNER JOIN Municipality m ON m.id = vs.municipality WHERE LOWER(m.name) LIKE LOWER(CONCAT('%',:municipalityName,'%')) AND a.id =:idVoucherAssignment AND LOWER(vs.country) LIKE LOWER(CONCAT('%',:country,'%'))")
	Page<VoucherSimulation> findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByEuRank(
			@Param("idVoucherAssignment") int idVoucherAssignment, @Param("country") String country,
			@Param("municipalityName") String municipalityName, Pageable pageable);

	@Modifying
	@Transactional
	@Query(value = "UPDATE applications SET pre_selected_flag = ?1 WHERE id IN (SELECT application FROM voucher_simulations WHERE voucher_assignment = ?2)", nativeQuery = true)
	void updateApplicationsInVoucherSimulationByVoucherAssignment(int status, int idVoucherAssignment);

	@Query("SELECT vs FROM VoucherSimulation vs INNER JOIN vs.voucherAssignment va WHERE vs.application.id IN :applications AND va.call.id =:callId AND va.status =:status")
	VoucherSimulation findVoucherSimulationByApplicationId(@Param("applications") List<Integer> applicationID,
			@Param("callId") Integer callId, @Param("status") Integer status);

	/** Methods for sorting by municipalityName */

	@Query(value = "SELECT vs.* FROM voucher_simulations vs INNER JOIN municipalities m ON vs.municipality = m.id WHERE vs.voucher_assignment = ?#{[0]} AND LOWER(m.name) LIKE LOWER(CONCAT('%',?#{[1]},'%')) AND LOWER(vs.country) LIKE LOWER(CONCAT('%',?#{[2]},'%')) ORDER BY CASE WHEN ?#{[5]} = 'DESC' THEN m.name END DESC, CASE WHEN ?#{[5]} = 'ASC' THEN m.name END ASC OFFSET ?#{[3]} ROWS FETCH NEXT ?#{[4]} ROWS ONLY", nativeQuery = true)
	List<VoucherSimulation> findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByMunicipalityName(
			Integer voucherAssignmentId, String municipality, String country, Integer offset, Integer count,
			String orderDirection);

	@Query(value = "SELECT vs.id, vs.country, vs.country_rank, vs.eu_rank, vs.municipality, vs.num_applications, vs.rejected, vs.selection_status, vs.voucher_assignment, vs.application, (SELECT COUNT(rw.id) FROM registration_warnings rw WHERE rw.registration_id = app.registration) as issues FROM voucher_simulations vs INNER JOIN municipalities m ON vs.municipality = m.id LEFT JOIN applications app ON vs.application = app.id WHERE vs.voucher_assignment = ?#{[0]} AND LOWER(m.name) LIKE LOWER(CONCAT('%',?#{[1]},'%')) AND LOWER(vs.country) LIKE LOWER(CONCAT('%',?#{[2]},'%')) ORDER BY issues ASC OFFSET ?#{[3]} ROWS FETCH NEXT ?#{[4]} ROWS ONLY", nativeQuery = true)
	List<VoucherSimulation> findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByIssuesAsc(
			Integer voucherAssignmentId, String municipality, String country, Integer offset, Integer count,
			String orderDirection);

	@Query(value = "SELECT vs.id, vs.country, vs.country_rank, vs.eu_rank, vs.municipality, vs.num_applications, vs.rejected, vs.selection_status, vs.voucher_assignment, vs.application, (SELECT COUNT(rw.id) FROM registration_warnings rw WHERE rw.registration_id = app.registration) as issues FROM voucher_simulations vs INNER JOIN municipalities m ON vs.municipality = m.id LEFT JOIN applications app ON vs.application = app.id WHERE vs.voucher_assignment = ?#{[0]} AND LOWER(m.name) LIKE LOWER(CONCAT('%',?#{[1]},'%')) AND LOWER(vs.country) LIKE LOWER(CONCAT('%',?#{[2]},'%')) ORDER BY issues DESC OFFSET ?#{[3]} ROWS FETCH NEXT ?#{[4]} ROWS ONLY", nativeQuery = true)
	List<VoucherSimulation> findAllByVoucherAssignmentAndMunicipalityInCountryOrderedByIssuesDesc(
			Integer voucherAssignmentId, String municipality, String country, Integer offset, Integer count,
			String orderDirection);

	@Query(value = "SELECT count(*) FROM voucher_simulations vs INNER JOIN municipalities m ON vs.municipality = m.id WHERE vs.voucher_assignment = ?#{[0]} AND LOWER(m.name) LIKE LOWER(CONCAT('%',?#{[1]},'%')) AND LOWER(vs.country) LIKE LOWER(CONCAT('%',?#{[2]},'%'))", nativeQuery = true)
	Integer countAllByVoucherAssignmentAndMunicipalityInCountry(Integer voucherAssignmentId, String municipality,
			String country);

	@Query(value = "SELECT count(*) FROM voucher_simulations vs INNER JOIN applications a ON vs.application = a.id WHERE vs.voucher_assignment = ?1 AND (vs.num_applications > 1 OR a._status != 2) AND vs.selection_status != 2", nativeQuery = true)
	Integer checkIfSimulationIsValid(int voucherAssignmentId);

	@Query(value = "SELECT application FROM voucher_simulations WHERE voucher_assignment = ?1 AND selection_status = 3", nativeQuery = true)
	ArrayList<Integer> findApplicationIdsFromVoucherAssignmentAndSelectionStatus(int voucherAssignment);

	@Query(value = "SELECT count(vs) FROM VoucherSimulation vs INNER JOIN vs.voucherAssignment va WHERE vs.application.id =:applicationId AND va.call.id =:callId AND va.status =:status")
	Integer checkIfApplicationIsFreeze(@Param("applicationId") Integer applicationId, @Param("callId") Integer callId,
			@Param("status") Integer status);

    @Query(value = "SELECT count(va) FROM VoucherAssignment va WHERE va.call.id =:callId AND va.status =:status or va.status =:secondStatus")
    Integer checkIfSimulationExistByCallId(@Param("callId") Integer callId, @Param("status") Integer status, @Param("secondStatus") Integer secondStatus);
}