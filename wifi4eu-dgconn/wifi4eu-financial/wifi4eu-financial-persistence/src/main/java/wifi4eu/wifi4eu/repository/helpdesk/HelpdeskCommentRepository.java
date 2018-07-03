package wifi4eu.wifi4eu.repository.helpdesk;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskComment;

import java.util.List;

public interface HelpdeskCommentRepository extends CrudRepository<HelpdeskComment, Long> {
    List<HelpdeskComment> findByIssueId(Long issueId);
}
