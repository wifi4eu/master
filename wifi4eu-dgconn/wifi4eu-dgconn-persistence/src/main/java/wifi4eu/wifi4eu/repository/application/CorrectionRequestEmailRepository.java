package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.CorrectionRequestEmail;

import java.util.List;

public interface CorrectionRequestEmailRepository extends CrudRepository<CorrectionRequestEmail,Integer> {
    List<CorrectionRequestEmail> findAllByCallIdOrderByDateDesc(Integer callId);
    List<CorrectionRequestEmail> findAllByCallId(Integer callId);

    long countByCallId(Integer callId);

}