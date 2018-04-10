package wifi4eu.wifi4eu.repository.status;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.status.BeneficiaryStatus;

@Transactional
public interface BeneficiaryStatusRepository extends PagingAndSortingRepository<BeneficiaryStatus,Long> {
}
