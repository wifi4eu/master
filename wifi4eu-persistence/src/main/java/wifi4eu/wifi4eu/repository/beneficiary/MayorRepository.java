package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.beneficiary.Mayor;

/**
 * Created by rgarcita on 09/02/2017.
 */
public interface MayorRepository extends CrudRepository<Mayor,Long>{

    Mayor findByLegalEntityId(Long legalEntityId);
}
