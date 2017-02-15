package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.beneficiary.Representative;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Transactional
public interface RepresentativeRepository extends CrudRepository<Representative,Long>{
}
