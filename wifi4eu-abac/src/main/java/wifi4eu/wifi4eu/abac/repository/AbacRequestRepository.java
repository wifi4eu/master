package wifi4eu.wifi4eu.abac.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.entity.AbacRequest;
import wifi4eu.wifi4eu.abac.service.AbacWorkflowStatusEnum;

import java.util.List;
import java.util.Set;

public interface AbacRequestRepository extends CrudRepository<AbacRequest, Integer> {

	List<AbacRequest> findByLegalEntityWfStatusIn(Set<AbacWorkflowStatusEnum> statuses);

}
