package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.location.Lau;

public interface LauRepository extends CrudRepository<Lau,Integer> {
    Lau findByCountryCodeAndLau2(String countryCode, String lau2);
    Iterable<Lau> findByCountryCode(String countryCode);
    Iterable<Lau> findByNuts3(String nuts3);
}