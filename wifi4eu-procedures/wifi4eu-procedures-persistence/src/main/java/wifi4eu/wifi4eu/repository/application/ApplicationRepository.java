package wifi4eu.wifi4eu.repository.application;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    @Query(value = "SELECT distinct a.*, r.municipality FROM applications a JOIN registrations r ON a.registration = r.id WHERE a.sent_email != 1 AND a.date < ?#{[1]} AND call_id = ?#{[0]} ORDER BY date ASC", nativeQuery = true)
    List<Application> findByCreateApplicationEmailNotSent(Integer callId, long currentTime);

    @Query(value = "SELECT DISTINCT a.id, a.registration FROM applications a JOIN registrations r ON a.registration = r.id WHERE a.sent_email != 1 AND a.date < ?#{[1]} AND call_id = ?#{[0]}", nativeQuery = true)
    ArrayList<Application.ApplicationApplyEmail> findByCreateApplicationEmailNotSentCustom(Integer callId, long currentTime);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query(value = "UPDATE applications SET sent_email = ?1, sent_email_date = ?2 WHERE id = ?3", nativeQuery = true)
    void updateApplicationSetEmailSent(int sentEmail, Date sentEmailDate, int id);
}