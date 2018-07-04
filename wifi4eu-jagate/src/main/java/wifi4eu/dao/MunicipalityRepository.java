package wifi4eu.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import wifi4eu.model.Municipality;

public interface MunicipalityRepository extends CrudRepository<Municipality, Long> {
	
	public List<Municipality> findByJagateKeyIsNullOrderByName();
	public List<Municipality> findByOrderByName();
}
