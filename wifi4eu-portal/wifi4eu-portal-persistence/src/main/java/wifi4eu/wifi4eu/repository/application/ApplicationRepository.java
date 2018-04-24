package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    Iterable<Application> findBySupplierId(Integer supplierId);
    Application findByCallIdAndRegistrationId(Integer callId, Integer registrationId);
    Iterable<Application> findByRegistrationId(Integer registrationId);
    Iterable<Application> findByCallId(Integer callId);
    Iterable<Application> findByCallIdOrderByIdAsc(Integer callId);

    @Query("SELECT ap FROM Application ap JOIN ap.registration r WHERE r.status != 1 AND ap.call.id = :callId AND r.allFilesFlag = 1")
    List<Application> findApplicationsByRegistrationNotInvalidated(@Param("callId") int callId);

    @Query("SELECT ap FROM Application ap JOIN ap.registration r JOIN r.municipality m JOIN m.lau l WHERE l.countryCode =:countryCode AND ap.call.id = :callId")
    List<Application> findApplicationsByCountry(@Param("callId") int callId, @Param("countryCode") String countryCode);

    @Query("SELECT count(m) FROM Application a JOIN a.registration r JOIN r.municipality m WHERE m.lau.id =:lauId AND m.id =:municipalityId")
    Integer findApplicationsWithSameLau(@Param("lauId") int lauId, @Param("municipalityId") int municipalityId);
}