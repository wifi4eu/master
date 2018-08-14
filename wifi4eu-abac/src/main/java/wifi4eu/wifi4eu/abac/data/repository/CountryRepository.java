package wifi4eu.wifi4eu.abac.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import wifi4eu.wifi4eu.abac.data.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {
	
	@Query(value = "SELECT c FROM Country c ORDER BY c.name")
	List<Country> findCountries();
	
	@Query(value = "SELECT c FROM Country c WHERE c.iso2Code = :code OR c.iso3Code = :code ")
	Country findByCode(@Param("code") String code);
}
