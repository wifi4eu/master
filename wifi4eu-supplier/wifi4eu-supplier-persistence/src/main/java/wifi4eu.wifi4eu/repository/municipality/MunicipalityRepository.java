package wifi4eu.wifi4eu.repository.municipality;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDisplayedListDTO;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import java.util.List;

public interface MunicipalityRepository extends CrudRepository<Municipality, Integer> {
    Iterable<Municipality> findByLauId(Integer lauId);
    @Query(value = "SELECT COUNT(id),lau FROM municipalities GROUP BY lau", nativeQuery = true)
    Iterable<Object> findMunicipalitiesCountGroupedByLauId();


    //TODO change the current query to retrieve the beneficiaries associated to supplier

    @Query(value = "SELECT new wifi4eu.wifi4eu.common.dto.model.BeneficiaryDisplayedListDTO(m.name, m.id) FROM municipalities m INNER JOIN registrations r ON r.municipality = m.id INNER JOIN users u ON u.id = r._user WHERE r._status = 2", nativeQuery = true)
    List<BeneficiaryDisplayedListDTO> findBeneficiariesList();
}