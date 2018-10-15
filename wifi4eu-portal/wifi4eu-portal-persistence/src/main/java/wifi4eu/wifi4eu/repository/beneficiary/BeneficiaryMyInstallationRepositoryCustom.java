package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryMyInstallation;

import java.util.List;

public interface BeneficiaryMyInstallationRepositoryCustom {

    List<BeneficiaryMyInstallation> searchBeneficiariesListMyInstallation(Integer supplierId, String fieldOrder, String order, Integer page, Integer
            rowsPerPage);
}
