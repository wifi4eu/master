package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.location.Lau;

public interface LauRepository extends CrudRepository<Lau,Integer> {
    Lau findByCountryCodeAndLau2(String countryCode, String lau2);
    Iterable<Lau> findByCountryCode(String countryCode);
    Iterable<Lau> findByNuts3(String nuts3);
    Iterable<Lau> findByCountryCodeAndName1ContainingIgnoreCaseOrderByName1(String countryCode, String name1);
    Lau findByCountryCodeAndName1IgnoreCase(String countryCode, String name1);
}