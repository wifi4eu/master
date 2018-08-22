package wifi4eu.wifi4eu.repository.logEmails;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;

public interface LogEmailRepository extends JpaRepository<LogEmail, Integer> {
    Page<LogEmail> findAllByMunicipalityId(Integer municipalityId, Pageable pageable);
}
