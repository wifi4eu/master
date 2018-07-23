package wifi4eu.wifi4eu.abac.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.service.AbacWorkflowStatusEnum;

import java.util.List;

public interface LegalEntityRepository extends CrudRepository<LegalEntity, Integer> {

	LegalEntity findByMid(Integer mid);

	LegalEntity findByOfficialName(String officialName);

	@Query(value = "SELECT le FROM LegalEntity le WHERE le.abacFelId is not null")
	List<LegalEntity> findLegalEntitiesProcessedInAbac();

	List<LegalEntity> findByWfStatusOrderByDateCreated(String status);
	List<LegalEntity> findByWfStatusOrderByDateCreated(String status, Pageable pageable);

}
