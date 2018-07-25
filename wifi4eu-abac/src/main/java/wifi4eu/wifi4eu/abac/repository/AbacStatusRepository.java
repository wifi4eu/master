package wifi4eu.wifi4eu.abac.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.entity.AbacLefStatus;

import java.util.List;
import java.util.Set;

public interface AbacStatusRepository extends CrudRepository<AbacLefStatus, String> {

	List<AbacLefStatus> findByLocObjForeignIdIn(Set<String> locObjForeignId);
}
