package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.registration.ConditionsAgreement;

public interface ConditionsAgreementRepository extends JpaRepository<ConditionsAgreement, Integer> {

    ConditionsAgreement findFirstByRegistrationIdOrderByIdDesc(@Param("registrationId") Integer registrationId);

}
