package wifi4eu.wifi4eu.repository.security;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.security.Right;

public interface RightRepository extends CrudRepository<Right, Integer> {
    Iterable<Right> findByRightdescAndUserId(String rightDesc, Integer userId);
}