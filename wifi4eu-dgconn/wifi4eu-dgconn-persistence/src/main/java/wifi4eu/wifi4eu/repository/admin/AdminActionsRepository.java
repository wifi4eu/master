package wifi4eu.wifi4eu.repository.admin;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.admin.AdminActions;

import java.util.List;

public interface AdminActionsRepository extends CrudRepository<AdminActions, Integer> {

    AdminActions findOneByAction(String action);
    List<AdminActions> findAllByAction(String action);
    AdminActions findOneByActionAndUserId(String action, Integer userId);

}
