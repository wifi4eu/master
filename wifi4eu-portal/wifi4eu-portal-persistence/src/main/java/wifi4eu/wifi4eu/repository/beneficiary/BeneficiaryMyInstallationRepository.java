package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryMyInstallation;

import java.util.List;

public interface BeneficiaryMyInstallationRepository extends CrudRepository<BeneficiaryMyInstallation, Integer>, BeneficiaryMyInstallationRepositoryCustom {

    @Query(value = "SELECT count(*) FROM municipalities m INNER JOIN registrations r ON r.municipality = m.id INNER JOIN applications a ON " +
            "a.registration = r.id WHERE r._status = 2 AND a.supplier = ?1", nativeQuery = true)
    Long countBeneficiariesListMyInstallation(Integer supplierId);
}
