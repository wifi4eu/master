package ec.europa.digit.euwifiops.euwifiops.repository.status;

import ec.europa.digit.euwifiops.euwifiops.entity.status.BeneficiaryStatus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BeneficiaryStatusRepository extends PagingAndSortingRepository<BeneficiaryStatus,Long> {
}
