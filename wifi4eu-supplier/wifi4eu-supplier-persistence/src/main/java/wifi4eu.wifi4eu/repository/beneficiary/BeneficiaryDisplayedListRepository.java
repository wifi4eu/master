package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryDisplayedList;

import java.util.List;

public interface BeneficiaryDisplayedListRepository extends CrudRepository<BeneficiaryDisplayedList, Integer> {

    @Query(value = "SELECT m.name, m.id, r.wifi_indicator as wifiIndicator FROM municipalities m INNER JOIN registrations r ON r.municipality = m.id INNER JOIN users u ON u.id = r._user INNER JOIN suppliers s ON s._user = u.id INNER JOIN applications a ON a.supplier = s.id AND a.registration = r.id WHERE r._status = 2 AND s._user = ?1", nativeQuery = true)
    List<BeneficiaryDisplayedList> findBeneficiariesList(Integer id);

}