package wifi4eu.wifi4eu.repository.thread;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.thread.ThreadMessage;

public interface ThreadMessageRepository extends CrudRepository<ThreadMessage,Integer> {
}