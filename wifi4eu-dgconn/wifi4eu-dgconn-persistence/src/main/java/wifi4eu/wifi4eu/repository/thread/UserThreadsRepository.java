package wifi4eu.wifi4eu.repository.thread;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.thread.UserThreads;


public interface UserThreadsRepository extends CrudRepository<UserThreads, Integer> {
    UserThreads findByUserIdAndThreadId(Integer userId, Integer threadId);
}