package wifi4eu.wifi4eu.repository.helpdesk;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskComment;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskIssue;

public interface HelpdeskCommentRepository extends CrudRepository<HelpdeskComment,Integer> {
    Iterable<HelpdeskComment> findByIssue(HelpdeskIssue issue);
}