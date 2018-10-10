package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryMyInstallation;

import java.util.List;

public interface BeneficiaryMyInstallationRepository extends CrudRepository<BeneficiaryMyInstallation, Integer> {

    @Query(value = "SELECT a.id, m.name, m.name, m.country, a.select_supplier_date as selectSupplierDate, a.bank_account_id as bankAccountId FROM municipalities m " + "INNER JOIN " +
            "registrations r ON r.municipality = m.id " + "INNER JOIN applications a ON a.registration = r.id " + " WHERE r._status = 2 AND a.supplier = ?1 ORDER BY m.name",
            nativeQuery = true)
    List<BeneficiaryMyInstallation> findBeneficiariesListMyInstallation(Integer supplierId);

}
