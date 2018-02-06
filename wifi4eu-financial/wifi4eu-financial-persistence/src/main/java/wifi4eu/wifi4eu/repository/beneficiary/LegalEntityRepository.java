package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.beneficiary.LegalEntity;

/**
 * Created by rgarcita on 09/02/2017.
 */
public interface LegalEntityRepository extends CrudRepository<LegalEntity,Long>{
    Iterable<LegalEntity> findByCountryCode(String countryCode);
}
