package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.data.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findFirstByUserNameEquals(String userName);
}
