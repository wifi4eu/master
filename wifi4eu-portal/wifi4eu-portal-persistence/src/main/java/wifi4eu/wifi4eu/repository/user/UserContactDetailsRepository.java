package wifi4eu.wifi4eu.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.user.UserContactDetails;

import java.util.List;

public interface UserContactDetailsRepository extends CrudRepository<UserContactDetails, Integer> {

    @Query(value = "select u.id as id, u.name, u.surname, u.address, u.address_num, u.postal_code, u.city, u.country, u.ecas_email as email, ru" +
            ".main as main, u.type from users u inner join registration_users ru on ru._user = u.id" + " left join association_users ou on ou" +
            "" + ".id_user =" + " u.id where ru.registration = ?#{[0]} and (ou.id is null or ru.main=1) order by ru.main asc", nativeQuery = true)
    List<UserContactDetails> findUsersContactDetailsByRegistrationId(Integer registrationId);


    @Query(value = "select distinct u.id as id, u.name, u.surname, u.address, u.address_num, u.postal_code, u.city, u.country, u.ecas_email as " +
            "email, ru" + ".main as main, u.type from users u inner join registration_users ru on ru._user = u.id" + " left join " +
            "association_users" + " ou on ou" + ".id_user =" + " u.id where ou.id_association = ?#{[0]}", nativeQuery = true)
    List<UserContactDetails> findUsersContactDetailsByAssociationId(Integer associationId);
}
