package wifi4eu.wifi4eu.repository.logEmails;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;

import java.util.List;

public interface LogEmailRepository extends JpaRepository<LogEmail, Integer> {
    Page<LogEmail> findAllByMunicipalityId(Integer municipalityId, Pageable pageable);
    List<LogEmail> findAllByMunicipalityIdAndActionEquals(Integer municipalityId, String action);
    LogEmail findTopByMunicipalityIdAndActionOrderBySentDateDesc(Integer municipalityId, String action);
    LogEmail findTopByMunicipalityIdAndActionAndToOrderBySentDateDesc(Integer municipalityId, String action, String to);
}
