package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;

import java.util.List;

public interface RegistrationUsersRepository extends CrudRepository<RegistrationUsers, Integer> {

    RegistrationUsers findByUserIdAndRegistrationId(Integer userId, Integer registrationId);

    List<RegistrationUsers> findByRegistrationId(Integer registration);

    @Query(value = "SELECT contact_email FROM registration_users where registration = (SELECT registration FROM applications where id = ?1) AND main = 1", nativeQuery = true)
    String findContactEmailFromApplicationId(int applicationId);

    @Query(value = "SELECT _user FROM registration_users where registration = (SELECT registration FROM applications where id = ?1) AND main = 1", nativeQuery = true)
    Integer findUserIdFromApplicationId(int applicationId);

    @Query(value = "SELECT _user FROM registration_users where registration = ?1 AND main = 1", nativeQuery = true)
    Integer findUserIdFromRegistrationId(int registrationId);
}
