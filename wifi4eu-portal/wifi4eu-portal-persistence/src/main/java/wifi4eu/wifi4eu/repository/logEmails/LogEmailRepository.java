package wifi4eu.wifi4eu.repository.logEmails;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;

public interface LogEmailRepository extends CrudRepository<LogEmail, Integer>{
    Iterable<LogEmail> findByMunicipalityId(Integer municipalityId);
    Iterable<LogEmail> findByFrom(String from);
    Iterable<LogEmail> findByTo(String to);
}
