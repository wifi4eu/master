package wifi4eu.wifi4eu.repository.helpdesk;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskIssue;

public interface HelpdeskIssueRepository extends CrudRepository<HelpdeskIssue,Integer> {
}