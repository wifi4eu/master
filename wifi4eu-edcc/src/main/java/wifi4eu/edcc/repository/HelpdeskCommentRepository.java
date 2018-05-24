package wifi4eu.edcc.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.edcc.persistence.entity.HelpdeskComment;
import wifi4eu.edcc.persistence.entity.HelpdeskIssue;

public interface HelpdeskCommentRepository extends CrudRepository<HelpdeskComment,Integer> {
    Iterable<HelpdeskComment> findByIssue(HelpdeskIssue issue);
}