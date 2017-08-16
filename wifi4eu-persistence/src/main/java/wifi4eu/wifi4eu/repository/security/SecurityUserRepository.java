package wifi4eu.wifi4eu.repository.security;

import org.springframework.data.jpa.repository.Query;
import wifi4eu.wifi4eu.entity.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SecurityUserRepository extends CrudRepository<User, Long> {
    User findByUserId(Long userId);
    User findByEmail(String email);
    User findByUserTypeId(Long userTypeId);
}
