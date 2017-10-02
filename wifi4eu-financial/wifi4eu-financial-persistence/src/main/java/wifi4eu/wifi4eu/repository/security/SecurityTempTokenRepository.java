package wifi4eu.wifi4eu.repository.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.security.TempToken;

/**
 * Created by rgarcita on 21/02/2017.
 */
@Transactional
public interface SecurityTempTokenRepository extends CrudRepository<TempToken,Long>{
    TempToken findByToken(String token);
    TempToken findByEmail(String email);
    TempToken findByUserId(Long userId);
}
