package wifi4eu.wifi4eu.repository.voucher;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.voucher.VoucherSimulation;

public interface VoucherSimulationRepository extends CrudRepository<VoucherSimulation, Integer> {

    Iterable<VoucherSimulation> findAllByVoucherAssignment(@Param("idVoucherAssignment") int idVoucherAssignment);

}
