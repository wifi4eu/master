package wifi4eu.wifi4eu.repository.admin;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.admin.AdminActions;

public interface AdminActionsRepository extends CrudRepository<AdminActions, Integer> {

    AdminActions findOneByAction(String action);

}
