package wifi4eu.wifi4eu.repository.municipality;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

public interface MunicipalityRepository extends CrudRepository<Municipality, Integer> {

    Long countMunicipalitiesById(Integer id);
}