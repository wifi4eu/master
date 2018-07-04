package wifi4eu.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import wifi4eu.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	public List<Country> findByOrderByName();
	public Country findByCodeIgnoreCase(String code);
}
