package wifi4eu.wifi4eu.abac.repository;

import org.springframework.data.repository.CrudRepository;

import wifi4eu.wifi4eu.abac.entity.LegalEntity;

public interface LegalEntityRepository extends CrudRepository<LegalEntity, Integer> {

	LegalEntity findByName(String name);

}
