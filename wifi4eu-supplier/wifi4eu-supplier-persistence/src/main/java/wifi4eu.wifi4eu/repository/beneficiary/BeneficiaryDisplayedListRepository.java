package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryDisplayedList;

import java.util.List;

public interface BeneficiaryDisplayedListRepository extends CrudRepository<BeneficiaryDisplayedList, Integer> {

    //TODO change the current query to retrieve the beneficiaries associated to supplier

    @Query(value = "SELECT m.name, m.id FROM municipalities m INNER JOIN registrations r ON r.municipality = m.id INNER JOIN users u ON u.id = r._user WHERE r._status = 2", nativeQuery = true)
    List<BeneficiaryDisplayedList> findBeneficiariesList();

}
