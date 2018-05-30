package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    Iterable<Application> findBySupplierId(Integer supplierId);
    Application findByCallIdAndRegistrationId(Integer callId, Integer registrationId);
    Iterable<Application> findByRegistrationId(Integer registrationId);
    Iterable<Application> findByCallIdOrderByDateAsc(Integer callId);
    @Query(value = "SELECT * FROM applications app INNER JOIN registrations reg ON reg.id = app.registration INNER JOIN municipalities mun ON mun.id = reg.municipality WHERE app.call_id = ?#{[0]} AND mun.lau = ?#{[1]}", nativeQuery = true)
    List<Application> findByCallIdAndLauId(Integer callId, Integer lauId);

    @Query(value = "SELECT * FROM applications app INNER JOIN registrations reg ON reg.id = app.registration INNER JOIN municipalities mun ON mun.id = reg.municipality WHERE app.call_id = ?#{[0]} AND mun.lau = ?#{[1]} ORDER BY app.date ASC", nativeQuery = true)
    List<Application> findByCallIdAndLauIdOrderByDateAsc(Integer callId, Integer lauId);

}