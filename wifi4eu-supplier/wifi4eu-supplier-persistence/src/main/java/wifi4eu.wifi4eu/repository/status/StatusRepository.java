package ec.europa.digit.euwifiops.euwifiops.repository.status;

import ec.europa.digit.euwifiops.euwifiops.entity.status.Status;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StatusRepository extends PagingAndSortingRepository<Status,Long> {
}
