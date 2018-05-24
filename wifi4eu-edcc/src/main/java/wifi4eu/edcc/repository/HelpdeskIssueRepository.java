package wifi4eu.edcc.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.edcc.persistence.entity.HelpdeskIssue;


import java.util.List;

public interface HelpdeskIssueRepository extends CrudRepository<HelpdeskIssue,Integer> {

    List<HelpdeskIssue> findAllByTicketFalse();
}