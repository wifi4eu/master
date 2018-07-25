package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryDisplayedList;

import java.util.List;

public interface BeneficiaryDisplayedListRepository extends CrudRepository<BeneficiaryDisplayedList, Integer> {

    @Query(value = "SELECT m.name, m.id FROM municipalities m INNER JOIN registrations r ON r.municipality = m.id INNER JOIN registration_users ru ON ru.registration = r.id INNER JOIN users u ON u.id = ru._user WHERE r._status = 2", nativeQuery = true)
    List<BeneficiaryDisplayedList> findBeneficiariesList();

}