package wifi4eu.wifi4eu.abac.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.entity.AbacLefStatus;

public interface AbacStatusRepository extends CrudRepository<AbacLefStatus, String> {

	AbacLefStatus findByLocObjForeignId(String locObjForeignId);
}
