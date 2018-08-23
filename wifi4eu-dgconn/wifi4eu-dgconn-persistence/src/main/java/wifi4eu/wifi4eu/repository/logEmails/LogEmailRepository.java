package wifi4eu.wifi4eu.repository.logEmails;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;

import java.util.List;

public interface LogEmailRepository extends JpaRepository<LogEmail, Integer> {
    Page<LogEmail> findAllByMunicipalityId(Integer municipalityId, Pageable pageable);
    List<LogEmail> findAllByMunicipalityIdAndActionEquals(Integer municipalityId, String action);
    LogEmail findTopByMunicipalityIdAndActionOrderBySentDateDesc(Integer municipalityId, String action);
    LogEmail findTopByMunicipalityIdAndActionAndToOrderBySentDateDesc(Integer municipalityId, String action, String to);

    LogEmail findTopByActionOrderBySentDateDesc(String action);


    @Query(value = "select top 1 e.* from log_emails e " +
            "join registrations r on e.municipalityId=r.municipality " +
            "join applications a on a.registration = r.id " +
            "join legal_files_correction_reason lfc on r.id=lfc.registration " +
            "where action = ?2 and a.id=?1 and lfc.request_correction= 1 and sent_date > lfc.request_correction_date " +
            "and type not in ( select type from legal_files where upload_time > e.sent_date and registration= r.id )" +
            "order by sent_date desc", nativeQuery = true)
    LogEmail findLastEmailsSendCorrectionNotUploadedYet(Integer applicationId, String action);
}
