package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.location.Nuts;
import wifi4eu.wifi4eu.entity.security.Role;

/**
 * Created by rgarcita on 08/02/2017.
 */
@Transactional
public interface LocationNutsRepository extends CrudRepository<Nuts, Long> {
    Iterable<Nuts> findByLevel(Long level);
}
