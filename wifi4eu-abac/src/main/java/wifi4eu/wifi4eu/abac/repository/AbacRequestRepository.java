package wifi4eu.wifi4eu.abac.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.entity.AbacRequest;
import wifi4eu.wifi4eu.abac.service.AbacWorkflowStatusEnum;

import java.util.List;
import java.util.Set;

public interface AbacRequestRepository extends CrudRepository<AbacRequest, Integer> {

	@Query("select request.locObjForeignId from AbacRequest request where request.legalEntity.wfStatus in ?1")
	Set<String> findByLegalEntityWfStatusIn(Set<AbacWorkflowStatusEnum> statuses);

	AbacRequest findByLocObjForeignId(String locObjForeignId);

}
