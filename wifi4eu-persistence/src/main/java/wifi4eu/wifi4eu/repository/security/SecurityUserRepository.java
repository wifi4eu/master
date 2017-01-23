package wifi4eu.wifi4eu.repository.security;

import wifi4eu.wifi4eu.entity.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SecurityUserRepository extends CrudRepository<User, Long> {
    User findByUserId(String userId);
}
