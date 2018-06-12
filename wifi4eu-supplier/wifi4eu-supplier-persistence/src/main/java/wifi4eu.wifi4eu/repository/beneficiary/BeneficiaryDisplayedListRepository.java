package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryDisplayedList;

import java.util.List;

public interface BeneficiaryDisplayedListRepository extends CrudRepository<BeneficiaryDisplayedList, Integer> {

    // @Query(value = "SELECT m.name, m.id, r.wifi_indicator as wifiIndicator FROM municipalities m INNER JOIN registrations r ON r.municipality = m.id INNER JOIN applications a ON a.registration = r.id INNER JOIN suppliers s ON a.supplier = s.id INNER JOIN users u ON u.id = s._user WHERE r._status = 2 AND s._user = ?1", nativeQuery = true)
    @Query(value = "SELECT m.name, m.id, r.is_submission as installationSiteSubmission, r.is_rejection as installationSiteRejection, r.is_confirmation as installationSiteConfirmation FROM municipalities m INNER JOIN registrations r ON r.municipality = m.id INNER JOIN applications a ON a.registration = r.id INNER JOIN suppliers s ON a.supplier = s.id INNER JOIN users u ON u.id = s._user WHERE r._status = 2 AND s._user = ?1 ORDER BY m.name", nativeQuery = true)
    List<BeneficiaryDisplayedList> findBeneficiariesList(Integer id);

    @Query(value = "SELECT m.name, m.id, r.is_submission as installationSiteSubmission, r.is_rejection as installationSiteRejection, r.is_confirmation as installationSiteConfirmation FROM municipalities m INNER JOIN registrations r ON r.municipality = m.id INNER JOIN applications a ON a.registration = r.id INNER JOIN suppliers s ON a.supplier = s.id INNER JOIN users u ON u.id = s._user WHERE r._status = 2 AND r.id = ?1", nativeQuery = true)
    BeneficiaryDisplayedList findBeneficiaryByRegistrationId(Integer id);
}