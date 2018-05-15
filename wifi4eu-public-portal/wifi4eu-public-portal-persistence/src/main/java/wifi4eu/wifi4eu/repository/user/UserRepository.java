package wifi4eu.wifi4eu.repository.user;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.user.User;

public interface UserRepository extends CrudRepository<User,Integer> {
}