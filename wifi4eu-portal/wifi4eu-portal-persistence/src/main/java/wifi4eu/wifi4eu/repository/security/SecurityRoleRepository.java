package wifi4eu.wifi4eu.repository.security;

import wifi4eu.wifi4eu.entity.security.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SecurityRoleRepository extends CrudRepository<Role, Long> {
    Iterable<Role> findByRights_rightId(Long rightId);
}
