package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.location.Lau;

import java.util.List;

public interface LauRepository extends JpaRepository<Lau,Integer> {
    Lau findByCountryCodeAndLau2(String countryCode, String lau2);
    Iterable<Lau> findByCountryCode(String countryCode);
    Iterable<Lau> findByNuts3(String nuts3);
    Iterable<Lau> findByCountryCodeAndName1ContainingIgnoreCaseOrderByName1(String countryCode, String name1);
    Lau findByCountryCodeAndName1IgnoreCase(String countryCode, String name1);

    @Query(value = "SELECT * FROM laus l WHERE l.name1 LIKE ?2 AND l.country_code = (SELECT n.code FROM nuts n where n.label LIKE ?1 AND n.level = 0)", nativeQuery = true)
    List<Lau> findLauByName1Country(String country, String name1);

    @Query(value = "SELECT * FROM laus l WHERE l.name1 LIKE ?1", nativeQuery = true)
    List<Lau> findLauByName1(String name1);
}