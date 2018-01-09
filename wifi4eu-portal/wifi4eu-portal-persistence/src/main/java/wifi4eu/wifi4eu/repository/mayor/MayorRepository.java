package wifi4eu.wifi4eu.repository.mayor;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.mayor.Mayor;

public interface MayorRepository extends CrudRepository<Mayor,Integer> {
    Mayor findByMunicipalityId(Integer municipalityId);
}