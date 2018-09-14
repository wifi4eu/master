package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wifi4eu.wifi4eu.entity.application.ApplicationComment;

import java.util.List;

public interface ApplicationCommentRepository extends JpaRepository<ApplicationComment, Integer>{

    List<ApplicationComment> findAllByApplicationId(Integer applicationId);
    Page<ApplicationComment> findAllByApplicationId(Integer applicationId, Pageable pageable);

}
