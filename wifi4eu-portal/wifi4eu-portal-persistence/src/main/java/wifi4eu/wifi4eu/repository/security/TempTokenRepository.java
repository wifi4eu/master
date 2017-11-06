package wifi4eu.wifi4eu.repository.security;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.security.TempToken;

public interface TempTokenRepository extends CrudRepository<TempToken,Integer> {
}