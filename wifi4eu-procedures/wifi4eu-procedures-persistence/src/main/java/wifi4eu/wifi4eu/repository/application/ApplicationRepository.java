package wifi4eu.wifi4eu.repository.application;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    @Query(value = "SELECT distinct a.*, r.municipality FROM applications a JOIN registrations r ON a.registration = r.id WHERE a.sent_email != 1 AND a.date < ?#{[1]} AND call_id = ?#{[0]} ORDER BY date ASC", nativeQuery = true)
    List<Application> findByCreateApplicationEmailNotSent(Integer callId, long currentTime);
}