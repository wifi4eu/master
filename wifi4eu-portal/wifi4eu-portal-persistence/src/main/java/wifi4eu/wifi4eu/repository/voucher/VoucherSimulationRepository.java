package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;

public interface VoucherSimulationRepository extends CrudRepository<VoucherSimulation, Integer> {

    Iterable<VoucherSimulation> findAllByVoucherAssignment(@Param("idVoucherAssignment") int idVoucherAssignment);

    @Query("SELECT vs FROM VoucherSimulation vs JOIN vs.voucherAssignment a WHERE a.id =:idVoucherAssignment")
    Page<VoucherSimulation> findAllByVoucherAssignmentOrdered(@Param("idVoucherAssignment") int idVoucherAssignment, Pageable pageable);

    @Query("SELECT vs FROM VoucherSimulation vs JOIN vs.voucherAssignment a WHERE a.id =:idVoucherAssignment AND vs.country =:country")
    Page<VoucherSimulation> findAllByVoucherAssignmentInCountryOrdered(@Param("idVoucherAssignment") int idVoucherAssignment, @Param("country") String country, Pageable pageable);
}