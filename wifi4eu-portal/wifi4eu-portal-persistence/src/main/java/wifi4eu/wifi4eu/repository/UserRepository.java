package wifi4eu.wifi4eu.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.User;

public interface UserRepository extends CrudRepository<User,Integer> {
}