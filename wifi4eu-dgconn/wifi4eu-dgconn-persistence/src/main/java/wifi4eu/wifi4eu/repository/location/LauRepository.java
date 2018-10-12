package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import wifi4eu.wifi4eu.entity.location.Lau;

public interface LauRepository extends JpaRepository<Lau,Integer> {
    Lau findByCountryCodeAndLau2(String countryCode, String lau2);
    Iterable<Lau> findByCountryCode(String countryCode);
    Iterable<Lau> findByNuts3(String nuts3);
    Iterable<Lau> findByCountryCodeAndName1ContainingIgnoreCaseOrderByName1(String countryCode, String name1);
}