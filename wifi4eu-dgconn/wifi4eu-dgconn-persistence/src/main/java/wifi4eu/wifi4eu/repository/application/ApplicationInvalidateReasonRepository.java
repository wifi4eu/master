package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.application.ApplicationInvalidateReason;

import java.util.List;

public interface ApplicationInvalidateReasonRepository extends JpaRepository<ApplicationInvalidateReason, Integer>{

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM application_invalidate_reason WHERE application_id = ?1", nativeQuery = true)
    void deleteInvalidateReasonsByApplicationId(int applicationId);

    List<ApplicationInvalidateReason> findAllByApplicationIdOrderByReason(Integer applicationId);
}
