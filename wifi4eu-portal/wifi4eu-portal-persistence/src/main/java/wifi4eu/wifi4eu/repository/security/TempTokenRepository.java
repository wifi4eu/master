package wifi4eu.wifi4eu.repository.security;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.security.TempToken;

public interface TempTokenRepository extends CrudRepository<TempToken,Integer> {
    TempToken findByToken(String token);
    TempToken findByEmail(String email);
    TempToken findByUserId(Long userId);
}