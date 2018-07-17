package wifi4eu.wifi4eu.abac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import wifi4eu.wifi4eu.abac.entity.LegalEntity;

public interface LegalEntityRepository extends CrudRepository<LegalEntity, Integer> {

	LegalEntity findByName(String name);

	@Query(value = "SELECT le FROM LegalEntity le WHERE le.idAbac is not null")
	List<LegalEntity> findLegalEntitiesWithIdAbac();

}
