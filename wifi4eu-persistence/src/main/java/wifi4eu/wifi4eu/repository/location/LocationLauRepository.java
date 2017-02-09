package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.location.Lau;
import wifi4eu.wifi4eu.entity.location.Nuts;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Transactional
public interface LocationLauRepository extends CrudRepository<Lau, Long> {
    Iterable<Lau> findByCountryCode(String countryCode);
}
