package wifi4eu.wifi4eu.repository.security;

import wifi4eu.wifi4eu.entity.security.Right;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SecurityRightRepository extends CrudRepository<Right, Long>{
}
