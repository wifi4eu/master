package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;

import java.util.List;

public interface RegistrationUsersRepository extends CrudRepository<RegistrationUsers, Integer> {

    RegistrationUsers findByUserIdAndRegistrationId(Integer userId, Integer registrationId);

    List<RegistrationUsers> findByContactEmail(String email);
}
