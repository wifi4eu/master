package wifi4eu.wifi4eu.abac.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import wifi4eu.wifi4eu.abac.data.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {
	@Query(value = "SELECT c FROM Country c WHERE c.euMember = 'Y' ORDER BY c.name")
	List<Country> findCountries();
}
