package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wifi4eu.wifi4eu.entity.application.ApplicationComment;

public interface ApplicationCommentRepository extends JpaRepository<ApplicationComment, Integer>{

    Page<ApplicationComment> findAllByApplicationId(Integer applicationId, Pageable pageable);

}
