package wifi4eu.wifi4eu.repository.grantAgreement;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;

public interface GrantAgreementRepository extends CrudRepository<GrantAgreement, Integer> {

    GrantAgreement findByApplicationId(Integer applicationId);

}
