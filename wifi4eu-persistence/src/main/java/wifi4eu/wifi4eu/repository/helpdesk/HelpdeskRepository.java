package wifi4eu.wifi4eu.repository.helpdesk;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.helpdesk.Helpdesk;

import java.util.List;

public interface HelpdeskRepository extends CrudRepository<Helpdesk, Long> {
}
