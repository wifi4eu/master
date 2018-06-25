package wifi4eu.wifi4eu.repository.helpdesk;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskIssue;

import java.util.List;

public interface HelpdeskIssueRepository extends CrudRepository<HelpdeskIssue,Integer> {

    List<HelpdeskIssue> findAllByTicketFalse();
}