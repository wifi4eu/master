package wifi4eu.wifi4eu.repository.thread;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.thread.UserThreads;


public interface UserThreadsRepository extends CrudRepository<UserThreads, Integer> {
    Iterable<UserThreads> findByUserId(Integer userId);
    Iterable<UserThreads> findByThreadId(Integer threadId);
    UserThreads findByUserIdAndThreadId(Integer userId, Integer threadId);

    @Query(value = "SELECT ut.id, ut._user, ut.thread FROM threads t\n" +
            "INNER JOIN user_threads ut ON t.id = ut.thread\n" +
            "WHERE _user = ?#{[0]} AND title = ?#{[1]}", nativeQuery = true)
    UserThreads getUserThreadByUserAndRegistration(Integer userId, String municipalityName);
}