package wifi4eu.wifi4eu.repository.security;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.security.Right;

public interface RightRepository extends CrudRepository<Right,Integer> {
    Iterable<Right> findByUserId(Integer userId);
    Iterable<Right> findByRightdescAndUserId(String rightDesc, Integer userId);

    @Modifying
    @Transactional
    long deleteByUserId(Integer userId);
}