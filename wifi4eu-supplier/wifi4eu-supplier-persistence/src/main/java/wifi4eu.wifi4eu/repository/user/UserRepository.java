package wifi4eu.wifi4eu.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

    User findByEcasUsername(String ecasUsername);

    @Query(value = "select u.* from users u " +
            "inner join registration_users ru on ru._user = u.id where ru.main = 1 and ru._user = ?#{[0]}", nativeQuery = true)
    User findMainUserFromRegistration(Integer registrationId);
}