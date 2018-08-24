package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.data.entity.Role;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findByName(String name);
}
