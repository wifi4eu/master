package wifi4eu.wifi4eu.repository.thread;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.thread.Thread;

public interface ThreadRepository extends CrudRepository<Thread, Integer> {
    Thread findByTypeAndReason(Integer type, String reason);
}