package wifi4eu.wifi4eu.repository.grantAgreement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;

public interface GrantAgreementRepository extends CrudRepository<GrantAgreement, Integer>{

    Integer countByApplicationId(int applicationId);
    
    List<GrantAgreement> findByApplicationId(Integer applicationId);
}
