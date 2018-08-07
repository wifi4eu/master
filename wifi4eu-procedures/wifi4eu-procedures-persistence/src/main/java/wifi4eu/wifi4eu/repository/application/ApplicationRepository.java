package wifi4eu.wifi4eu.repository.application;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.Date;
import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    @Query(value = "SELECT distinct a.*, r.municipality FROM applications a JOIN registrations r ON a.registration = r.id WHERE r.municipality NOT IN (SELECT l.municipalityId FROM log_emails l WHERE l.action = 'createApplication' and sent_date > ?#{[2]} ) AND a.date < ?#{[1]} AND call_id = ?#{[0]} ORDER BY date ASC", nativeQuery = true)
    List<Application> findByCreateApplicationEmailNotSent(Integer callId, long currentTime, long startOfCall);
}