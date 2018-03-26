package wifi4eu.wifi4eu.repository.municipality;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

public interface MunicipalityRepository extends PagingAndSortingRepository<Municipality, Integer> {
    Iterable<Municipality> findByLauId(Integer lauId);

    @Query(value = "SELECT COUNT(id),lau FROM municipalities GROUP BY lau", nativeQuery = true)
    Iterable<Object> findMunicipalitiesCountGroupedByLauId();

    Page<Object> findAllByAndGroup(Pageable pageable);

}