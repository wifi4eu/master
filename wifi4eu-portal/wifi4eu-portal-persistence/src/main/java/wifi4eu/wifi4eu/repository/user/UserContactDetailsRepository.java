package wifi4eu.wifi4eu.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.user.UserContactDetails;

import java.util.List;

public interface UserContactDetailsRepository extends CrudRepository<UserContactDetails, Integer> {

    @Query(value = "select u.id as id, u.name, u.surname, u.address, u.address_num, u.postal_code, u.city, u.country, u.ecas_email as email, ru.main as main, u.type from users u inner join registration_users ru on ru._user = u.id where ru.registration = ?#{[0]} and ru.main=1", nativeQuery = true)
    List<UserContactDetails> findUsersContactDetailsByRegistrationId(Integer registrationId);


    @Query(value = "select u.id as id, u.name, u.surname, u.address, u.address_num, u.postal_code, u.city, u.country, u.ecas_email as email, ru" +
            ".main as main, u.type from users u inner join registration_users ru on ru._user = u.id where ru.registration in (select r2.id from " +
            "registrations r2 right join organizations o on r2.organisation_id = o.id where o.id = ?#{[0]}))", nativeQuery = true)
    List<UserContactDetails> findUsersContactDetailsByOrganisationId(Integer organizationId);
}
