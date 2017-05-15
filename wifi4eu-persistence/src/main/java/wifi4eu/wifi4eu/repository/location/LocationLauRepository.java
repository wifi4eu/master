package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.location.Lau;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Transactional
public interface LocationLauRepository extends CrudRepository<Lau, Long> {
    Iterable<Lau> findByCountryCode(String countryCode);
    Iterable<Lau> findByNuts3(String nuts3);
    Lau findByLau2(String lau2);
}
