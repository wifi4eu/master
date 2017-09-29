package wifi4eu.wifi4eu.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.ThreadMessage;

public interface ThreadMessageRepository extends CrudRepository<ThreadMessage,Integer> {
}